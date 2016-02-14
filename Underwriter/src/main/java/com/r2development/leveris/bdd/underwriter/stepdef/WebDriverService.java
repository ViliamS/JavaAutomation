package com.r2development.leveris.bdd.underwriter.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Singleton
public class WebDriverService {

    private static final Log log = LogFactory.getLog(WebDriverService.class);

    private WebDriver webDriver;

    @Inject
    WebDriverService(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

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
