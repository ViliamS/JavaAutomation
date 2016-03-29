package com.r2development.leveris.bdd.apollo.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Deprecated @Singleton
public class WebDriverService {

    private WebDriver webDriver;

    @Inject
    WebDriverService(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @After
    public void teardown(Scenario scenario){
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        }
        finally {

//            if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//            TODO to implement
//                proxyServer.stopProxyServer();
//            }

//            if ( AUTOMATION_MODE.getAutomationMode(System.getProperty("automation.mode")).compareTo(AUTOMATION_MODE.PROD) == 0 ) {
//            if (AUTOMATION_MODE.compareTo(AUTOMATION_MODE.PROD)==0) {
                if ( webDriver!= null )
                    webDriver.quit();
//            }
        }
    }
}
