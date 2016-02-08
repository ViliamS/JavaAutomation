package com.r2development.leveris.bdd.underwriter.apistepdef;

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
    private static HttpClientContext localContext;

    @Before
    public void setup() throws Exception {

        if ( StringUtils.isEmpty(System.getProperty("environment")))
            System.setProperty("environment", "st1");

        if ( StringUtils.isEmpty(System.getProperty("domain")))
            System.setProperty("domain", "st1app.loftkeys.com");

        if ( StringUtils.isEmpty(System.getProperty("underwriter")))
            System.setProperty("underwriter", "https://st1app.loftkeys.com/underwriter");

        if ( StringUtils.isEmpty(System.getProperty("timestamp")))
            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));

        httpClient = HttpUtils.createHttpClient();

        Assert.assertNotNull("Maven didn't load the System property Environment", System.getProperty("environment"));
        Assert.assertNotNull("Maven didn't load the System property Domain", System.getProperty("domain"));
        Assert.assertNotNull("Maven didn't load the System property Borrower", System.getProperty("underwriter"));

        localContext = HttpUtils.initContext(System.getProperty("domain"), "/underwriter");
//        localContext = getNewInstanceHttpClientContext();
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

    public static HttpClientContext getInstanceHttpClientContext() {
        return localContext;
    }

    public static HttpClientContext getNewInstanceHttpClientContext() {
        return ( localContext = HttpUtils.initContext() );
    }

    public static HttpClientContext getNewInstanceHttpClientContext(String domain, String context) {
        return ( localContext = HttpUtils.initContext(domain, context) );
    }

}
