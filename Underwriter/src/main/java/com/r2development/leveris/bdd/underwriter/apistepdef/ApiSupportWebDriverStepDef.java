package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;


@Singleton
public class ApiSupportWebDriverStepDef {
//
//    private static final Log log = LogFactory.getLog(com.r2development.abakus.bdd.borrower.stepdef.SupportWebDriverStepDef.class);
//
////    private static HarProxyServer proxyServer;
////    private static LegacyProxyServer legacyProxyServer;
////    private static BrowserMobProxy browserMobProxy;
////    private static int proxyServerPort;
////    private static CookieStore cookieStore;
////    private static CloseableHttpClient client;
//    private static String userdata;
    private static WebDriver webDriver;
////    private static Injector injector;
//
//    @Before
//    public void setup() throws Exception {
//        Thread.sleep((new Random()).nextInt(597) + 534);
//
//        Proxy seleniumProxy = null;
//        DesiredCapabilities capabilities = null;
//        if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
////            proxyServer = new HarProxyServer();
////            proxyServer.startProxyServer();
////            proxyServer.setCapture();
////
////            seleniumProxy = proxyServer.getSeleniumProxy();
//            capabilities = new DesiredCapabilities();
////            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
//        }
//
////        https://git-scm.com/book/be/v2/Embedding-Git-in-your-Applications-JGit
//        System.setProperty("oracle.net.tns_admin", "/Users/anthonymottot/oraSupp/tns_admin/");
//
////        injector = Guice.createInjector(new AbstractModule() {
////            @Override
////            protected void configure() {
////                bind(IUser.class).to(User.class);
////            }
////        });
//
////        injector = Guice.createInjector(new DependenciesModule());
//
//        switch ( BROWSER_TYPE ) {
//            case CHROME:
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("ui-prioritize-in-gpu-process");
//                userdata = "--user-data-dir=./target/" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
//                options.addArguments(userdata);
////                options.addArguments("--start-maximized");
//                options.addArguments("--window-position=200,50");
//                options.addArguments("--window-size=1440,900");
////                options.addArguments("--proxy-server=localhost:8080");
//
//                if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//                    webDriver = new ChromeDriver(capabilities);
////                    proxyServer.newHar(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//                } else {
//                    webDriver = new ChromeDriver(options);
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
//
    public static WebDriver getWebDriverInstance() {
        return webDriver;
    }
//
////    public static HarProxyServer getProxyInstance() {
////        return proxyServer;
////    }
//
//    public static String getUserdata() {
//        return userdata;
//    }
//
////    public static Injector getInjector() {
////        return injector;
////    }
//
//    @After
//    public void teardown(Scenario scenario) throws Exception {
//
//        try {
//            if (scenario.isFailed() && ACTIVE_SCREENSHOT ) {
//                final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
//                scenario.embed(screenshot, "image/png");
//
////                Embedding text/plain code is not a provided feature
////                final String domcode = "i'm testing the embedding text/plain code";
////                scenario.embed(domcode.getBytes(), "text/plain");
////                File srcFile = ((TakesScreenshot) webDriverService.getWebDriver()).getScreenshotAs(OutputType.FILE);
////                FileUtils.copyFile(srcFile, new File(./target/scenario.getName() + ".txt"));
//            }
//        } catch (Exception e) {
//            log.fatal(e.getMessage());
//            log.fatal(e.getCause());
//        }
//        finally {
//
//            if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
////                proxyServer.stopProxyServer();
//            }
//
//            if (AUTOMATION_MODE.compareTo(AUTOMATION_MODE.PROD)==0) {
//                if ( webDriver != null ) {
//                    webDriver.quit();
//                }
//            }
//
////            injector = null;
//        }
//    }
}
