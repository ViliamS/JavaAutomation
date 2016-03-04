package com.r2development.leveris.bdd.apollo.apistepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.utils.HttpUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.joda.time.DateTime;
import org.junit.Assert;

@Singleton
public class ApiSupportHttpClientStepDef {

    private static final Log log = LogFactory.getLog(ApiSupportHttpClientStepDef.class);

    private static HttpClient httpClient;
//    private static HttpContext localContext;
    private static HttpClientContext localContext;

    @Before
    public void setup() throws Exception {

        if ( StringUtils.isEmpty(System.getProperty("environment")))
            System.setProperty("environment", "dev2");

        if ( StringUtils.isEmpty(System.getProperty("domain.apollo")))
            System.setProperty("domain.apollo", "dv2apl.opoqodev.com");

        if ( StringUtils.isEmpty(System.getProperty("apollo.client")))
            System.setProperty("apollo.client", "https://dv2apl.opoqodev.com/client");

        if ( StringUtils.isEmpty(System.getProperty("apollo.payment")))
            System.setProperty("apollo.payment", "https://dv2apl.opoqodev.com/payment");

        if ( StringUtils.isEmpty(System.getProperty("apollo.context.client")))
            System.setProperty("apollo.context.client", "/client");

        if ( StringUtils.isEmpty(System.getProperty("apollo.context.payment")))
            System.setProperty("apollo.context.payment", "/payment");

        if ( StringUtils.isEmpty(System.getProperty("apollo.sso")))
            System.setProperty("apollo.sso", "https://dv2apl.opoqodev.com/sso/");

        if ( StringUtils.isEmpty(System.getProperty("timestamp")))
            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));

        httpClient = HttpUtils.createHttpClient();

        Assert.assertNotNull("Maven didn't load the System property Environment", System.getProperty("environment"));
        Assert.assertNotNull("Maven didn't load the System property Domain Apollo", System.getProperty("domain.apollo"));
        Assert.assertNotNull("Maven didn't load the System property Apollo.Client", System.getProperty("apollo.client"));
        Assert.assertNotNull("Maven didn't load the System property Apollo.Context.Client", System.getProperty("apollo.context.client"));
        Assert.assertNotNull("Maven didn't load the System property Apollo.Payment", System.getProperty("apollo.payment"));
        Assert.assertNotNull("Maven didn't load the System property Apollo.Context.Payment", System.getProperty("apollo.context.payment"));

        localContext = HttpUtils.initContext(System.getProperty("domain.apollo"), "/client");
    }

    @After
    public void teardown(Scenario scenario) throws Exception {

        try {
            if (scenario.isFailed() && StringUtils.equals(System.getProperty("activeScreenshot"), "true") ) {
                // TODO enhance cucumber to inject txt
            }
        } catch (Exception e) {
            log.fatal(e.getMessage());
            log.fatal(e.getCause());
        }
        finally {
//            HttpClientUtils.closeQuietly(httpClient);
            httpClient = null;
            localContext = null;
        }
    }

    public static HttpClient getInstanceHttpClient() {
        return httpClient;
    }

//    public static HttpContext getInstanceHttpClientContext() {
//        return localContext;
//    }
    public static HttpClientContext getInstanceHttpClientContext() {
        return localContext;
    }

//    public static HttpContext getNewInstanceHttpClientContext() {
//        return ( localContext = HttpUtils.initContext() );
//    }
    public static HttpClientContext getNewInstanceHttpClientContext() {
        return ( localContext = HttpUtils.initContext() );
    }

//    public static HttpContext getNewInstanceHttpClientContext(String domain, String context) {
//        return ( localContext = HttpUtils.initContext(domain, context) );
//    }
    public static HttpClientContext getNewInstanceHttpClientContext(String domain, String context) {
        return ( localContext = HttpUtils.initContext(domain, context) );
    }
}
