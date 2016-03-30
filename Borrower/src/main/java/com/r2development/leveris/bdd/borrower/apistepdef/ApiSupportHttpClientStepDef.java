package com.r2development.leveris.bdd.borrower.apistepdef;

import com.r2development.leveris.utils.HttpUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HttpContext;
import org.joda.time.DateTime;
import org.junit.Assert;

//@Singleton
public class ApiSupportHttpClientStepDef {

    private static final Log log = LogFactory.getLog(ApiSupportHttpClientStepDef.class);

    private static HttpClient httpClient;
    private static HttpContext localContext;

    @Before
    public void setup() throws Exception {

        if ( StringUtils.isEmpty(System.getProperty("environment")))
            System.setProperty("environment", "dev2");

        if ( StringUtils.isEmpty(System.getProperty("domain.borrower")))
            System.setProperty("domain.borrower", "dv2app.opoqodev.com");

        if ( StringUtils.isEmpty(System.getProperty("borrower")))
            System.setProperty("borrower", "http://dv2app.opoqodev.com/stable-borrower");

        if ( StringUtils.isEmpty(System.getProperty("timestamp")))
            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));


        Assert.assertNotNull("Maven didn't load the System property Environment", System.getProperty("environment"));
        Assert.assertNotNull("Maven didn't load the System property Domain", System.getProperty("domain.borrower"));
        Assert.assertNotNull("Maven didn't load the System property Borrower", System.getProperty("borrower"));

        httpClient = HttpUtils.createHttpClient();
        localContext = HttpUtils.initContext(System.getProperty("domain.borrower"), "/stable-borrower");
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
            httpClient = null;
            localContext = null;
        }
    }

    public static HttpClient getInstanceHttpClient() {
        return httpClient;
    }

    public static HttpContext getInstanceHttpClientContext() {
        return localContext;
    }

    public static HttpContext getNewInstanceHttpClientContext() {
        return ( localContext = HttpUtils.initContext() );
    }

    public static HttpContext getNewInstanceHttpClientContext(String domain, String context) {
        return ( localContext = HttpUtils.initContext(domain, context) );
    }
}
