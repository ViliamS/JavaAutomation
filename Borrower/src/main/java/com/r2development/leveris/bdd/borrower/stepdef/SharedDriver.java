package com.r2development.leveris.bdd.borrower.stepdef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

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

    private static final Log log = LogFactory.getLog(SharedDriver.class.getName());

    public static final String PHANTOMJS = "phantomjs";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String GUI = "gui";
    public static final String API = "api";

    public static DesiredCapabilities dCaps = new DesiredCapabilities();
    private StringBuffer verificationErrors = new StringBuffer();

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
            case CHROME:

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

                toReturn = new ChromeDriver();
                break;
            case FIREFOX:
                toReturn = new FirefoxDriver();
                break;
            case PHANTOMJS:
                toReturn = new PhantomJSDriver(dCaps);
                toReturn.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                toReturn.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                toReturn.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
                toReturn.manage().window().setSize(new Dimension(1024, 768));
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
        if ( StringUtils.isEmpty(System.getProperty("domain.borrower")))
            System.setProperty("domain.borrower", "dv2app.opoqodev.com");
        if ( StringUtils.isEmpty(System.getProperty("borrower")))
            System.setProperty("borrower", "http://dv2app.opoqodev.com/stable-borrower");
        if ( StringUtils.isEmpty(System.getProperty("autoregistration")) )
            System.setProperty("autoregistration", "http://dv2app.opoqodev.com/stable-borrower/home?useCase=automaticregistration");
        if ( System.getProperty("browser") == null)
            System.setProperty("browser", CHROME);
        if ( StringUtils.isEmpty(System.getProperty("timestamp")))
            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));
        if ( StringUtils.isEmpty(System.getProperty("modeRun")) )
            System.setProperty("modeRun", GUI);

        if ( !StringUtils.isEmpty(System.getProperty("modeRun")) && System.getProperty("modeRun").equals(GUI)) {

        }
        else if ( System.getProperty("modeRun").equalsIgnoreCase(PHANTOMJS) && System.getProperty("browser").equals(PHANTOMJS) ) {
//            String [] cli_args = new String[] { "--web-security=false", "--ignore-ssl-errors=true", "--remote-debugger-port=9000" };
//            String [] cli_args = new String[] { "--web-security=false", "--ignore-ssl-errors=true" };
//            dCaps = DesiredCapabilities.phantomjs();
//            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args);
//            dCaps.setJavascriptEnabled(true);
//            dCaps.setCapability("takesScreenshot", false);

//            dCaps = DesiredCapabilities.phantomjs();
//            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "userAgent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36");
//            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "loadImages", true);
//            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "javascriptEnabled", true);
//            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "resourceTimeout", 60000);
//            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--webdriver-loglevel=ERROR"});//NONE,ERROR

            dCaps = new DesiredCapabilities();
            dCaps.setJavascriptEnabled(true);
            dCaps.setCapability("takesScreenshot", false);

            // Change "User-Agent" via page-object capabilities
//            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "userAgent", "My User Agent - Chrome");

            // Disable "web-security", enable all possible "ssl-protocols" and "ignore-ssl-errors" for PhantomJSDriver
            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
                    "--web-security=false",
                    "--ssl-protocol=any",
                    "--ignore-ssl-errors=true",
                    "--webdriver-loglevel=DEBUG"
            });




        }
        else if ( System.getProperty("modeRun").equals(API) ) {
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

        if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//                proxyServer.stopProxyServer();
        }
    }

}
