package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


@Singleton
public class WebDriverService {

    private static final Log log = LogFactory.getLog(WebDriverService.class);

//    private static HarProxyServer proxyServer;
//    private static LegacyProxyServer legacyProxyServer;
//    private static BrowserMobProxy browserMobProxy;
//    private static int proxyServerPort;
    private static String userdata;
    private WebDriver webDriver;

    @Inject
    WebDriverService(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

////    @Before
//    public void setup() throws Exception {
////        Proxy seleniumProxy = null;
//        DesiredCapabilities capabilities = null;
//        if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
////            proxyServer = new HarProxyServer();
////            proxyServer.startProxyServer();
////            proxyServer.setCapture();
////
////            seleniumProxy = proxyServer.getSeleniumProxy();
//            capabilities = new DesiredCapabilities();
////            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
////            capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
//        }
//
//        switch (BROWSER_TYPE.getBrowser(System.getProperty("browser"))) {
//            case CHROME:
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("ui-prioritize-in-gpu-process");
//                userdata = "user-data-dir=/target/" + System.getProperty("timestamp") + RandomStringUtils.random(5, true, true);
////                options.addArguments(userdata);
////                options.addArguments("--start-maximized");
////                options.addArguments("--window-position=200,50");
////                options.addArguments("--window-size=1440,900");
////                options.addArguments("--proxy-server=localhost:8080");
//
//                if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//                    //noinspection ConstantConditions
////                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//                    webDriver = new ChromeDriver(capabilities);
////                    proxyServer.newHar(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//                } else {
//                    webDriver = new ChromeDriver(options);
////                    webDriver = new ChromeDriver();
//                }
//
//                break;
//            case PHANTHOMJS:
//                break;
//            case FIREFOX:
//                if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//                    webDriver = new FirefoxDriver(capabilities);
////                    proxyServer.newHar(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//                } else {
//                    webDriver = new FirefoxDriver();
//                }
//                break;
//            case IE:
//                break;
//            default:
//        }
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
//                webDriver.manage().deleteAllCookies();
                webDriver.quit();
            }
        }
    }
}
