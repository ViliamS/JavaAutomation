package com.r2development.leveris.tdd.borrower;

/**
 * Created by anthonymottot on 16/03/2016.
 */
public class HarTest {
//
//    private static HarProxyServer proxyServer;
//    private static LegacyProxyServer legacyProxyServer;
//    private static BrowserMobProxy browserMobProxy;
//    private static int proxyServerPort;
//    private static String userdata;
//
//    public final static void main(String... arg) throws Exception {
//        Proxy seleniumProxy = null;
//        DesiredCapabilities capabilities = null;
////        if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//            proxyServer = new HarProxyServer();
//            proxyServer.startProxyServer();
//            proxyServer.setCapture();
//
//            seleniumProxy = proxyServer.getSeleniumProxy();
//            capabilities = new DesiredCapabilities();
//            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
////        }
//
////        switch (BROWSER_TYPE.getBrowser(System.getProperty("browser"))) {
////            case CHROME:
//
//                ChromeOptions options = new ChromeOptions();
////                options.addArguments("ui-prioritize-in-gpu-process");
////                userdata = "user-data-dir=/target/" + System.getProperty("timestamp") + RandomStringUtils.random(5, true, true);
////                options.addArguments(userdata);
//                options.addArguments("--start-maximized");
//                options.addArguments("--window-position=200,50");
//                options.addArguments("--window-size=1440,900");
//                options.addArguments("--proxy-server=localhost:8080");
//
////                if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//                    //noinspection ConstantConditions
//                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//                    WebDriver webDriver = new ChromeDriver(capabilities);
//                    WebDriverWait wait = new WebDriverWait(webDriver, 60);
////                    proxyServer.newHar(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//                    proxyServer.newHar("TestHar-" + DateTime.now().toString("yyyyMMddHHmmssSSS"));
////                } else {
////                    webDriver = new ChromeDriver(options);
////                    webDriver = new ChromeDriver();
////                }
//
////                break;
////            case PHANTHOMJS:
////                break;
////            case FIREFOX:
////                if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
////                    webDriver = new FirefoxDriver(capabilities);
////                    proxyServer.newHar(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
////                } else {
////                    webDriver = new FirefoxDriver();
////                }
////                break;
////            case IE:
////                break;
////            default:
////        }
//
//        webDriver.get("http://google.fr");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));
//        webDriver.findElement(By.xpath("//input[@name='q']")).sendKeys("beachklub.cz" + Keys.ENTER);
//        Thread.sleep(500);
//        webDriver.quit();
//        proxyServer.stopProxyServer();
//        Har har = proxyServer.getHar();
//        har.writeTo(new File("/Users/anthonymottot/Automation/R&D/TheHar.har"));
//        System.out.println("done...");
//    }

}
