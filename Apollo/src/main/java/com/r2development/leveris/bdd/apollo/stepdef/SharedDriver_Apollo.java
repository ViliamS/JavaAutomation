package com.r2development.leveris.bdd.apollo.stepdef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * <p>
 * Example of a WebDriver implementation that has delegates all methods to a static instance (REAL_DRIVER) that is only
 * created once for the duration of the JVM. The REAL_DRIVER is automatically closed when the JVM exits. This makes
 * scenarios a lot faster since opening and closing a browser for each scenario is pretty slow.
 * To prevent browser state from leaking between scenarios, cookies are automatically deleted before every scenario.
 * </p>
 * <p>
 * A new instance of SharedDriver_Apollo is created for each Scenario and passed to yor Stepdef classes via Dependency Injection
 * </p>
 * <p>
 * As a bonus, screenshots are embedded into the report for each scenario. (This only works
 * if you're also using the HTML formatter).
 * </p>
 * <p>
 * A new instance of the SharedDriver_Apollo is created for each Scenario and then passed to the Step Definition classes'
 * constructor. They all receive a reference to the same instance. However, the REAL_DRIVER is the same instance throughout
 * the life of the JVM.
 * </p>
 */
//@Singleton
public class SharedDriver_Apollo extends EventFiringWebDriver {

    public static final String PHANTOMJS = "phantomjs",
            chrome = "chrome",
            firefox = "firefox",
            gui = "gui",
            api = "api";

    private static final Log log = LogFactory.getLog(SharedDriver_Apollo.class.getName());

    public static DesiredCapabilities dCaps = new DesiredCapabilities();
    private StringBuffer verificationErrors = new StringBuffer();

//        private static WebDriver REAL_DRIVER = new ChromeDriver();
    private static final WebDriver REAL_DRIVER = execute(System.getProperty("browser"));
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

    public SharedDriver_Apollo() {
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
        WebDriver toReturn = null;
        if ( StringUtils.isEmpty(browser) )
            browser = chrome;

        switch (browser) {
            case chrome:
                toReturn = new ChromeDriver();
                break;
            case firefox:
                toReturn = new FirefoxDriver();
                break;
            case PHANTOMJS:
                toReturn = new PhantomJSDriver(dCaps);
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
            System.err.println(verificationErrorString);

        try {
            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }

}
