package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HttpContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Singleton
public class ApiWebDriverService {

    private static final Log log = LogFactory.getLog(ApiWebDriverService.class);

    private WebDriver webDriver;
    private HttpClient httpClient;
    private HttpContext localContext;

//    @Inject
//    ApiWebDriverService(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }

//    @Inject
//    ApiWebDriverService(HttpClient httpClient, HttpContext localContext) {
//        this.httpClient = httpClient;
//        this.localContext = localContext;
//    }

    @After
    public void teardown(Scenario scenario) {

        try {
            if (scenario.isFailed() && StringUtils.equals(System.getProperty("active.screenshot"), "true")) {
                final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        } catch (Exception e) {
            log.fatal(e.getMessage());
            log.fatal(e.getCause());
        }
        finally {

//            if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//            TODO to implement
//                proxyServer.stopProxyServer();
//            }

//            if (StringUtils.equals(System.getProperty("automation.mode"), "prod")) {
//            if (AUTOMATION_MODE.compareTo(AUTOMATION_MODE.PROD)==0) {
            if ( webDriver != null ) {
                webDriver.quit();
            }
        }
    }
}
