package com.r2development.leveris.di;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import org.apache.commons.lang3.StringUtils;

public class ApolloDependenciesModule extends AbstractModule {

    private IUser user;

    @Inject
    ApolloDependenciesModule(IUser user) {
        this.user = user;
    }

//    private static HarProxyServer proxyServer;
//    private static LegacyProxyServer legacyProxyServer;
//    private static BrowserMobProxy browserMobProxy;
//    private static int proxyServerPort;
//    private static String userdata;

//    public void setup() throws Exception {
//        Proxy seleniumProxy = null;
//        DesiredCapabilities capabilities = null;
//        if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//            proxyServer = new HarProxyServer();
//            proxyServer.startProxyServer();
//            proxyServer.setCapture();
//
//            seleniumProxy = proxyServer.getSeleniumProxy();
//            capabilities = new DesiredCapabilities();
//            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
//        }
//
//        switch (BROWSER_TYPE.getBrowser(System.getProperty("browser"))) {
//            case CHROME:
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("ui-prioritize-in-gpu-process");
//                userdata = "user-data-dir=/target/" + System.getProperty("timestamp") + RandomStringUtils.random(5, true, true);
//                options.addArguments(userdata);
//                options.addArguments("--start-maximized");
//                options.addArguments("--window-position=200,50");
//                options.addArguments("--window-size=1440,900");
//                options.addArguments("--proxy-server=localhost:8080");
//
//                if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//                    //noinspection ConstantConditions
//                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//                    webDriver = new ChromeDriver(capabilities);
//                    proxyServer.newHar(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//                } else {
//                    webDriver = new ChromeDriver(options);
//                    webDriver = new ChromeDriver();
//                }
//
//                break;
//            case PHANTHOMJS:
//                break;
//            case FIREFOX:
//                if ( System.getProperty("Proxy") != null && BooleanUtils.toBoolean(System.getProperty("Proxy"))) {
//                    webDriver = new FirefoxDriver(capabilities);
//                    proxyServer.newHar(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//                } else {
//                    webDriver = new FirefoxDriver();
//                }
//                break;
//            case IE:
//                break;
//            default:
//        }
//    }

    @Override
    protected void configure() {

        if ( !StringUtils.isEmpty(System.getProperty("modeRun")) && System.getProperty("modeRun").equals("gui")) {
            switch (System.getProperty("browser")) {
                case "chrome":
                    break;
                case "firefox":
                    break;
            }
        }
//        bind(User.class).toInstance(user);
        if ( user == null)
            user = new User("", "", "", "", "", "");
        bind(IUser.class).toInstance(user);
    }
}
