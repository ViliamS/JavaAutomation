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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * <p>
 * Example of a WebDriver implementation that has delegates all methods to a static instance (REAL_DRIVER) that is only
 * created once for the duration of the JVM. The REAL_DRIVER is automatically closed when the JVM exits. This makes
 * scenarios a lot faster since opening and closing a browser for each scenario is pretty slow.
 * To prevent browser state from leaking between scenarios, cookies are automatically deleted before every scenario.
 * </p>
 * <p>
 * A new instance of SharedDriver is created for each Scenario and passed to yor Stepdef classes via Dependency Injection
 * </p>
 * <p>
 * As a bonus, screenshots are embedded into the report for each scenario. (This only works
 * if you're also using the HTML formatter).
 * </p>
 * <p>
 * A new instance of the SharedDriver is created for each Scenario and then passed to the Step Definition classes'
 * constructor. They all receive a reference to the same instance. However, the REAL_DRIVER is the same instance throughout
 * the life of the JVM.
 * </p>
 */
//@Singleton
public class SharedDriver extends EventFiringWebDriver {

    public static final String PHANTOMJS = "phantomjs",
            chrome = "chrome",
            firefox = "firefox",
            gui = "gui",
            api = "api";

    private static final Log log = LogFactory.getLog(SharedDriver.class.getName());

    public static DesiredCapabilities dCaps = new DesiredCapabilities();
    private StringBuffer verificationErrors = new StringBuffer();

    //    private static WebDriver REAL_DRIVER = new ChromeDriver();
    private static final WebDriver REAL_DRIVER = execute(System.getProperty("browser"));
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            REAL_DRIVER.close();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver() {
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
    public static void setup() {

        if ( StringUtils.isEmpty(System.getProperty("environment")))
            System.setProperty("environment", "dev2");
        if ( StringUtils.isEmpty(System.getProperty("domain.underwriter")))
            System.setProperty("domain.underwriter", "dv2app.opoqodev.com");
        if ( StringUtils.isEmpty(System.getProperty("borrower")))
            System.setProperty("underwriter", "http://dv2app.opoqodev.com/stable-underwriter");
        if ( System.getProperty("browser") == null)
            System.setProperty("browser", chrome);
        if ( StringUtils.isEmpty(System.getProperty("timestamp")))
            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));
        if ( StringUtils.isEmpty(System.getProperty("modeRun")) )
            System.setProperty("modeRun", gui);

//        WebDriver webDriver = null;
        if ( !StringUtils.isEmpty(System.getProperty("modeRun")) && System.getProperty("modeRun").equals(gui)) {
//            switch (System.getProperty("browser")) {
//                case "chrome":
//                    webDriver = new ChromeDriver();
//                    break;
//                case "firefox":
//                    webDriver = new FirefoxDriver();
//                    break;
//            }
//            deleteAllCookies();
        }
        if ( System.getProperty("modeRun").equalsIgnoreCase(PHANTOMJS) && System.getProperty("browser").equalsIgnoreCase(PHANTOMJS) ){

            String[] cli_args = new String[]{ "--ignore-ssl-errors=true", "--remote-debugger-port=9000" };
            dCaps = DesiredCapabilities.phantomjs();
            dCaps.setCapability( PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args );
            dCaps.setJavascriptEnabled(true);
            dCaps.setCapability("takesScreenshot", false);

        }
        if ( System.getProperty("modeRun").equals(api) ) {
//            httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
//            CookieStore cookieStore = new BasicCookieStore();
//            HttpClientContext localContextBody = HttpClientContext.create();
//            BasicClientCookie cookieScUnload = new BasicClientCookie("sc-unload", "obu");
//            cookieScUnload.setDomain(System.getProperty("domain"));
//            cookieScUnload.setPath("/stable-borrower");
//            cookieStore.addCookie(cookieScUnload);
//            localContextBody.setCookieStore(cookieStore);
//            localContext = localContextBody;
//            httpResponse = new HttpResponse(StringUtils.EMPTY);
        }

//        return webDriver;
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