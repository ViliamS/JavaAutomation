package com.r2development.leveris.bdd.borrower.stepdef;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Set;

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
public class SharedDriver_Borrower extends EventFiringWebDriver {

    private static final Log log = LogFactory.getLog(SharedDriver_Borrower.class.getName());

    public static final String IEXPLORER = "iexplorer";
    public static final String PHANTOMJS = "phantomjs";
    public static final String CHROME = "chrome";
    public static final String OPERA = "opera";
    public static final String FIREFOX = "firefox";
    public static final String EDGE = "edge";
    public static final String MARIONETTE = "marionette";

    public static final String GUI = "gui";
    public static final String API = "api";

    public static DesiredCapabilities dCaps = new DesiredCapabilities();
    private StringBuffer verificationErrors = new StringBuffer();
    private static final WebDriver REAL_DRIVER = SharedDriver_Borrower.execute(System.getProperty("browser"));

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            REAL_DRIVER.close();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver_Borrower() {
        super(REAL_DRIVER);
    }

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

    /**
     * Return a set of window handles which can be used to iterate over all open windows of this
     * WebDriver instance by passing them to webDriver.switchTo().window(windowName)
     *
     * @return A set of window handles which can be used to iterate over all open windows.
     * Provides a Set of String names of currently opened windowsNames
     */
    public LinkedList<String> getWindowHandlesInList() {
        log.info("getWindowHandles() \n" +
                "returning Set<String> \n" +
                "size of the Set is---> '" + super.getWindowHandles().size() + "'\n");
        LinkedList<String> handlesList = new LinkedList<>();
        int i = 0;
        for (String oneHandle : super.getWindowHandles()) {
            i++;
            log.info("Handle number '" + i + "' has name ---> '" + oneHandle + "'");
            handlesList.add(oneHandle);
        }
        return handlesList;
    }

    public Set<String> getWindowHandles() {
        log.info("getWindowHandles() \n" +
                "returning Set<String> \n" +
                "size of the Set is---> '" + super.getWindowHandles().size() + "'\n");
        return super.getWindowHandles();
    }

    public String getWindowHandle() {
        log.info("getWindowHandle() \n" +
                "returns ---> '" + super.getWindowHandle() + "'\n");
        return super.getWindowHandle();
    }

    @Override
    public void close() {
        super.close();
    }

    public static WebDriver execute(String browser) {
        WebDriver toReturn;
        if (StringUtils.isEmpty(browser))
            browser = CHROME;

        log.info("WebDriver execute(String browser ---> '" + browser + "')");

        switch (browser) {

            case IEXPLORER:
                toReturn = new InternetExplorerDriver();
                toReturn.manage().window().setSize(new Dimension(1440, 900));
                toReturn.manage().window().maximize();
                return toReturn;

            case CHROME:
                toReturn = new ChromeDriver();
                toReturn.manage().window().setSize(new Dimension(1440, 900));
                toReturn.manage().window().maximize();
                return toReturn;

            case FIREFOX:
                toReturn = new FirefoxDriver();
                toReturn.manage().window().setSize(new Dimension(1440, 900));
                toReturn.manage().window().maximize();
                return toReturn;

            case PHANTOMJS:

                dCaps.setJavascriptEnabled(true);
                dCaps.setCapability("takesScreenshot", false);
                dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[]
                        {
                        "--web-security=false",
                        "--ssl-protocol=any",
                        "--ignore-ssl-errors=true",
                        "--webdriver-loglevel=DEBUG"
                        }
                );
                Capabilities capabilities = dCaps;

                toReturn = new PhantomJSDriver(capabilities);
                toReturn.manage().window().setSize(new Dimension(1440, 900));
                toReturn.manage().window().maximize();
                return toReturn;

            case MARIONETTE:
                toReturn =  new MarionetteDriver();
                toReturn.manage().window().setSize(new Dimension(1440, 900));
                toReturn.manage().window().maximize();
                return toReturn;

            case EDGE:
                toReturn =  new EdgeDriver();
                toReturn.manage().window().setSize(new Dimension(1440, 900));
                toReturn.manage().window().maximize();
                return new EdgeDriver();


            default:
                toReturn =  new ChromeDriver();
                toReturn.manage().window().setSize(new Dimension(1440, 900));
                toReturn.manage().window().maximize();
                return new ChromeDriver();
        }
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
        if (!StringUtils.isEmpty(verificationErrorString))
            System.err.println(verificationErrorString);

        try {
            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }

        if (System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//                proxyServer.stopProxyServer();
        }
    }
}