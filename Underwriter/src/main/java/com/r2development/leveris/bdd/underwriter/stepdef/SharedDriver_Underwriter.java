package com.r2development.leveris.bdd.underwriter.stepdef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

/**
 * <p>
 * Example of a WebDriver implementation that has delegates all methods to a static instance (REAL_DRIVER) that is only
 * created once for the duration of the JVM. The REAL_DRIVER is automatically closed when the JVM exits. This makes
 * scenarios a lot faster since opening and closing a browser for each scenario is pretty slow.
 * To prevent browser state from leaking between scenarios, cookies are automatically deleted before every scenario.
 * </p>
 * <p>
 * A new instance of SharedDriver_Borrower is created for each Scenario and passed to yor Stepdef classes via Dependency Injection
 * </p>
 * <p>
 * As a bonus, screenshots are embedded into the report for each scenario. (This only works
 * if you're also using the HTML formatter).
 * </p>
 * <p>
 * A new instance of the SharedDriver_Borrower is created for each Scenario and then passed to the Step Definition classes'
 * constructor. They all receive a reference to the same instance. However, the REAL_DRIVER is the same instance throughout
 * the life of the JVM.
 * </p>
 */
//@Singleton
public class SharedDriver_Underwriter extends EventFiringWebDriver {

    private static final Log log = LogFactory.getLog(SharedDriver_Underwriter.class.getName());

    public static final String IEXPLORER = "iexplorer";
    public static final String PHANTOMJS = "phantomjs";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String OPERA = "opera";
    public static final String EDGE = "edge";
    public static final String MARIONETTE = "marionette";

    public static final String GUI = "gui";
    public static final String API = "api";

    public static DesiredCapabilities dCaps = new DesiredCapabilities();
    private StringBuffer verificationErrors = new StringBuffer();

    private static final WebDriver REAL_DRIVER = SharedDriver_Underwriter.execute(getProperty("browser"));
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            REAL_DRIVER.close();
        }
    };

    /** Part for detecting running OS */
    private static String OS = System.getProperty("os.name").toLowerCase();

    private static boolean isWindows() {
        return (OS.contains("win"));
    }

    private static boolean isMac() {
        return (OS.contains("mac"));
    }

    private static boolean isUnix() {
        return (OS.contains("nux"));
    }


    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver_Underwriter() {
        super(REAL_DRIVER);
    }

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }

//    public void deleteAllCookies() {
//        manage().deleteAllCookies();
//    }

    public static WebDriver execute(String browser) {

        setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
////        Proxy seleniumProxy = null;
//        DesiredCapabilities capabilities = null;
//        if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//            proxyServer = new HarProxyServer();
////            proxyServer.startProxyServer();
////            proxyServer.setCapture();
////
////            seleniumProxy = proxyServer.getSeleniumProxy();
//            capabilities = new DesiredCapabilities();
////            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
////            capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
//        }
        WebDriver toReturn;
        if ( StringUtils.isEmpty(browser) )
            browser = CHROME;

        switch (browser) {

            case IEXPLORER:
//                InternetExplorerDriverManager.getInstance().setup();
                toReturn = new InternetExplorerDriver();
                break;

            case CHROME:

                /**
                 * https://github.com/bonigarcia/webdrivermanager
                 */
//                ChromeDriverManager.getInstance().setup();
//
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("ui-prioritize-in-gpu-process");
//                String userdata = "user-data-dir=/target/" + System.getProperty("timestamp") + RandomStringUtils.random(5, true, true);
//                options.addArguments(userdata);
//                options.addArguments("--start-maximized");
//                options.addArguments("--window-position=200,50");
//                options.addArguments("--window-size=1440,900");
//                options.addArguments("--proxy-server=localhost:8080");
//
//                if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//                    //noinspection ConstantConditions
////                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//                    webDriver = new ChromeDriver(capabilities);
////                    proxyServer.newHar(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//                } else {
//                    if ( webDriver != null)
//                        webDriver = null;
//
//                    webDriver = new ChromeDriver(options);
////                    webDriver = new ChromeDriver();
//                    if ( webDriver.toString().contains("(null)") )
//                        webDriver = new ChromeDriver(options);
//
////                    injector.createChildInjector("BorrowerDependenciesModule");
////                    injector.injectMembers(webDriver);
//                }
//                toReturn = new ChromeDriver();

                toReturn = new ChromeDriver();

                break;
            case OPERA:
//                OperaDriverManager.getInstance().setup();
                toReturn = new OperaDriver();

                break;
            case PHANTOMJS:
                dCaps = new DesiredCapabilities();
                dCaps.setJavascriptEnabled(true);
                dCaps.setCapability("takesScreenshot", false);

                dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[]{
                        "--web-security=false",
                        "--ssl-protocol=any",
                        "--ignore-ssl-errors=true",
                        "--webdriver-loglevel=DEBUG"
                });

//                DesiredCapabilities caps = new DesiredCapabilities();
//                caps.setJavascriptEnabled(true);                //< not really needed: JS enabled by default
//                caps.setBrowserName("chrome");
//


//                caps.setCapability("takesScreenshot", true);    //< yeah, GhostDriver haz screenshotz!
                dCaps.setCapability(
                        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                        "/usr/bin/phantomjs"
                );
                dCaps.setCapability("webStorageEnabled", true);
                dCaps.setCapability("applicationCacheEnabled", true);
                dCaps.setCapability("browserConnectionEnabled", true);
                dCaps.setCapability("acceptSslCerts", true);
                dCaps.setCapability("webStorageEnabled", true);
                dCaps.setCapability("takesScreenshot", true);
                dCaps.setCapability("browserName", "chrome");
//                dCaps.setCapability();
//                dCaps.setCapability();
//                dCaps.setCapability();



                Capabilities capabilities = dCaps;

                // Launch driver (will take care and ownership of the phantomjs process)
                toReturn = new PhantomJSDriver(capabilities);
//
//                dCaps = new DesiredCapabilities();
//                dCaps.setJavascriptEnabled(true);
//                dCaps.setCapability("takesScreenshot", false);
//                dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[]{
//                        "--web-security=false",
//                        "--ssl-protocol=any",
//                        "--ignore-ssl-errors=true",
//                        "--webdriver-loglevel=DEBUG"
//                });
//
//                PhantomJsDriverManager.getInstance().setup();
//                toReturn = new PhantomJSDriver(dCaps);
                toReturn.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                toReturn.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                toReturn.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
                toReturn.manage().window().setSize(new Dimension(1440, 900));
                toReturn.manage().window().maximize();
                break;

            case MARIONETTE:
//                MarionetteDriverManager.getInstance().setup();
                toReturn = new MarionetteDriver();
                break;

            case EDGE:
//                EdgeDriverManager.getInstance().setup();
                toReturn = new EdgeDriver();
                break;

            default:
                toReturn = new ChromeDriver();
        }
        return toReturn;
    }

    @Before
    public void setup() throws IOException {
        log.info("setup()");
        Properties prop = new Properties();

        if (StringUtils.isEmpty(System.getProperty("timestamp")))
            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));

        if (!StringUtils.isEmpty(System.getProperty("environment"))) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(System.getProperty("environment") + ".properties");
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + System.getProperty("environment") + ".properties' not found in the classpath");
            }

            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.setProperty(key, value);
            }
        }

        /** This part is able to distinguish between mac and windows os and properly setup path to chrome / phantomjs / firefox etc.. libraries */
        /** When not running through Jenkins here is possible to setup [override] the placement of you system exe files */
        if (isMac()) {
            log.info("isMac ---> '" + isMac() + "'");

            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            System.setProperty("webdriver.phantomjs.driver", "/usr/bin/phantomjs");

            dCaps.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("webdriver.chrome.driver"));
            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("webdriver.phantomjs.driver"));

        } else if (isWindows()) {
            log.info("isWindows ---> '" + isWindows() + "'");

            System.setProperty("webdriver.chrome.driver", "C:/Path/To/chromedriver");
            System.setProperty("webdriver.phantomjs.driver", "C:/Path/To/phantomhjs");

            dCaps.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("webdriver.chrome.driver"));
            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("webdriver.phantomjs.driver"));
        }
        log.info("\n SET THE CHROME DRIVER EXE PROPERTY ---> \""+ System.getProperty("webdriver.chrome.driver") +"\" \n");
        log.info("\n SET THE PHANTOMJS DRIVER EXE PROPERTY ---> \""+ System.getProperty("webdriver.phantomjs.driver") +"\" \n");

    }

    @After
    public void embedScreenshot(Scenario scenario) {

        String verificationErrorString = verificationErrors.toString();
        if(!StringUtils.isEmpty(verificationErrorString))
            err.println(verificationErrorString);

        try {
            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            err.println(somePlatformsDontSupportScreenshots.getMessage());
        }

        if ( getProperty("Proxy") != null && BooleanUtils.toBoolean(getProperty("Proxy"))) {
//                proxyServer.stopProxyServer();
        }
    }
}