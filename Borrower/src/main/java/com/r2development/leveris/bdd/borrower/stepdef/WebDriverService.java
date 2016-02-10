package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.BROWSER_TYPE;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Random;


@Singleton
public class WebDriverService {

    private static final Log log = LogFactory.getLog(WebDriverService.class);

//    private static HarProxyServer proxyServer;
//    private static LegacyProxyServer legacyProxyServer;
//    private static BrowserMobProxy browserMobProxy;
//    private static int proxyServerPort;
    private static String userdata;
    private static WebDriver webDriver;
//    private static Injector injector;

    @Before
    public void setup() throws Exception {
        Thread.sleep((new Random()).nextInt(597) + 534);

//        Proxy seleniumProxy = null;
        DesiredCapabilities capabilities = null;
        if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//            proxyServer = new HarProxyServer();
//            proxyServer.startProxyServer();
//            proxyServer.setCapture();
//
//            seleniumProxy = proxyServer.getSeleniumProxy();
            capabilities = new DesiredCapabilities();
//            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        }

//        if ( StringUtils.isEmpty(System.getProperty("environment")))
//            System.setProperty("environment", "st1");
//
//        if ( StringUtils.isEmpty(System.getProperty("domain")))
//            System.setProperty("domain", "st1app.loftkeys.com");
//
//        if ( StringUtils.isEmpty(System.getProperty("borrower")))
//            System.setProperty("borrower", "https://st1app.loftkeys.com/borrower");
//
        if ( System.getProperty("browser") == null)
            System.setProperty("browser", "chrome");
//
//        if ( StringUtils.isEmpty(System.getProperty("timestamp")))
//            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));

        switch (BROWSER_TYPE.getBrowser(System.getProperty("browser"))) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("ui-prioritize-in-gpu-process");
                userdata = "--user-data-dir=./target/" + System.getProperty("timestamp");
                options.addArguments(userdata);
//                options.addArguments("--start-maximized");
//                options.addArguments("--window-position=200,50");
//                options.addArguments("--window-size=1440,900");
//                options.addArguments("--proxy-server=localhost:8080");

                if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
                    //noinspection ConstantConditions
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    webDriver = new ChromeDriver(capabilities);
//                    proxyServer.newHar(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
                } else {
                    webDriver = new ChromeDriver(options);
                }

                break;
            case PHANTHOMJS:
                break;
            case FIREFOX:
                if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
                    webDriver = new FirefoxDriver(capabilities);
//                    proxyServer.newHar(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
                } else {
                    webDriver = new FirefoxDriver();
                }
                break;
            case IE:
                break;
            default:
        }
    }

    public static WebDriver getWebDriverInstance() {
        return webDriver;
    }

//    public static HarProxyServer getProxyInstance() {
//        return proxyServer;
//    }

    public static String getUserdata() {
        return userdata;
    }

//    public static Injector getInjector() {
//        return injector;
//    }

    @After
    public void teardown(Scenario scenario) throws Exception {

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

            if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
                // TODO to implement
//                proxyServer.stopProxyServer();
            }

//            if (StringUtils.equals(System.getProperty("automation.mode"), "prod")) {
//            if (AUTOMATION_MODE.compareTo(AUTOMATION_MODE.PROD)==0) {
            if ( webDriver != null ) {
                webDriver.manage().deleteAllCookies();
                webDriver.quit();
            }
//            }
//            injector = null;
        }
    }
}
