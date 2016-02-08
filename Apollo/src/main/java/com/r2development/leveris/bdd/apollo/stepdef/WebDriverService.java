package com.r2development.leveris.bdd.apollo.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.AUTOMATION_MODE;
import com.r2development.leveris.BROWSER_TYPE;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Singleton
public class WebDriverService implements IWebDriverService {

    @Inject
    private WebDriver webDriver;

    @Override @Before
    public void setup() {
//        switch ( BROWSER_TYPE ) {
        switch (BROWSER_TYPE.getBrowser(System.getProperty("browser")) ) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("ui-prioritize-in-gpu-process");
                options.addArguments("--start-maximized");
                webDriver = new ChromeDriver(options);
                webDriver.manage().window().maximize();
                webDriver.switchTo().window(webDriver.getWindowHandle());
                break;
            case PHANTHOMJS:
                break;
            case FIREFOX:
                break;
            case IE:
                break;
            default:
        }
    }

    @Override
    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    @Override @After
    public void teardown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
//                File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(srcFile, new File(./target/scenario.getName() + ".png"));
//                log.info("Log Info: " + scenario.getName());
//                log.info("Log Info2: " + scenario.getId());
            }
        }
        finally {
            if ( AUTOMATION_MODE.getAutomationMode(System.getProperty("automation.mode")).compareTo(AUTOMATION_MODE.PROD) == 0 ) {
//            if (AUTOMATION_MODE.compareTo(AUTOMATION_MODE.PROD)==0) {
                if ( webDriver!= null )
                    webDriver.quit();
            }
        }
    }
}
