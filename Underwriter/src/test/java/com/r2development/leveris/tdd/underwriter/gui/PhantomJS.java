package com.r2development.leveris.tdd.underwriter.gui;
import com.r2development.leveris.selenium.underwriter.pageobjects.ILoginPage;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PhantomJS {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public PhantomJS() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities dCaps = new DesiredCapabilities();
        dCaps.setJavascriptEnabled(true);
        dCaps.setJavascriptEnabled(true);
        dCaps.setCapability("takesScreenshot", false);
        dCaps.setCapability("handlesAlerts", true);
        dCaps.setCapability("databaseEnabled", true);
        dCaps.setCapability("locationContextEnabled", true);
        dCaps.setCapability("applicationCacheEnabled", true);
        dCaps.setCapability("browserConnectionEnabled", true);
        dCaps.setCapability("webStorageEnabled", true);
        dCaps.setCapability("acceptSslCerts", true);
        dCaps.setCapability("nativeEvents", false);

        dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/bin/phantomjs");
        dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--web-security=no", "--ignore-ssl-errors=yes"});
        dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX,"Y");
        dCaps.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:16.0) Gecko/20121026 Firefox/16.0");
        dCaps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            driver = new PhantomJSDriver(dCaps);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

//        dCaps = new DesiredCapabilities();
//        dCaps.setJavascriptEnabled(true);
//        dCaps.setCapability("takesScreenshot", false);
//        dCaps.setCapability("navigationLocked", false);
////        dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,  "/usr/bin/phantomjs");
//        driver = new PhantomJSDriver(dCaps);
////        driver = new PhantomJSDriver();
//        baseUrl = "http://assertselenium.com/";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        return null;

    }
    @Test
    public void getLinksOfAssertSelenium() throws Exception {
        driver.get(baseUrl + "/");
//Getting all the links present in the page by a HTML tag.
        List<WebElement> links = driver.findElements(By.tagName("a"));
//Printing the size, will print the no of links present in the page.
        System.out.println("Total Links present is "+links.size());
//Printing the links in the page, we get through the href attribute.
        for (WebElement link : links) {
            System.out.println("Links are listed " + link.getAttribute("href"));
        }
    }
    @Test
    public void getGoogleLinksOfAssertSelenium() throws Exception {
        driver.get("http://www.google.com");
//Getting all the links present in the page by a HTML tag.
        List<WebElement> links = driver.findElements(By.tagName("a"));
//Printing the size, will print the no of links present in the page.
        System.out.println("Total Links present is "+links.size());
//Printing the links in the page, we get through the href attribute.
        for (WebElement link : links) {
            System.out.println("Links are listed " + link.getAttribute("href"));
        }
        System.out.println("====================");
        System.out.println(driver.getPageSource());
    }
    @Test
    public void adobe() {
        String urlAdobeDocument = "https://dv2apl.opoqodev.com/sso/login?application=UNDERWRITER&host=http%3A%2F%2Fdv2app.opoqodev.com%2Fstable-underwriter%2Fhome%3FuseCase%3Dauthenticate";
//        HttpClient httpAdobeClient = HttpUtils.createHttpClient();
//        CookieStore cookieStore = new BasicCookieStore();
//        HttpClientContext localAdobeContext = HttpClientContext.create();
//
////        BasicClientCookie cookieScUnload = new BasicClientCookie("sc-unload", "obu");
////        cookieScUnload.setDomain(domain);
////        cookieScUnload.setPath(application);
////        cookieStore.addCookie(cookieScUnload);
//        BasicClientCookie cookieTest = new BasicClientCookie("cookietest", "1");
//        cookieTest.setDomain("na1.echosign.com");
//        cookieTest.setPath("/");
//        cookieStore.addCookie(cookieTest);
//        localAdobeContext.setCookieStore(cookieStore);
//
//        requestHttpGet(
//                httpAdobeClient,
//                urlAdobeDocument,
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                        put("Host", "secure.na1.echosign.com");
//                        put("Referer", "http://dv2app.opoqodev.com/stable-borrower/form.2");
//                        put("Upgrade-Insecure-Requests", "1");
//                    }
//                },
//                localAdobeContext,
//                CONSUME_QUIETLY
//        );
        StringBuffer verificationErrors = new StringBuffer();



////        if ( System.getProperty("webdriver.phantomjs.driver") == null) {
////        dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,  "/usr/bin/phantomjs");
////            System.getProperty("webdriver.phantomjs.driver", "/usr/...")
////        }
////        else { System.getProperty("webdriver.phantomjs.driver").contains("JENKINS") ) {
//        if ( System.getProperty("webdriver.phantomjs.driver") != null && System.getProperty("webdriver.phantomjs.driver").equals("JENKINS") ) {
////        dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,  "/usr/bin/phantomjs");
////            System.setProperty("webdriver.phantomjs.driver", System.getProperty("JENKINS_HOME"));
//            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,  System.getProperty("JENKINS_HOME"));
//        }
//        PhantomJsDriverManager.getInstance().setup("2.1.1");
//        WebDriver webDriver = new PhantomJSDriver(dCaps);
//        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 60);
//
//





        ILoginPage loginPage = new LoginPage(driver);

        driver.get(urlAdobeDocument);

        long start = System.currentTimeMillis();
           ((JavascriptExecutor) driver).executeAsyncScript(
                       "window.setTimeout(arguments[arguments.length - 1], 5000);");
           System.out.println(
                      "Elapsed time: " + (System.currentTimeMillis() - start));

        WebDriverWait wait = new WebDriverWait(driver, 1);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div")));


        System.out.println("\n\n"+driver.getPageSource()+"\n\n");

        wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div")));

        System.out.println("\n\n"+driver.getPageSource()+"\n\n");

//        loginPage
//                .setUsername("testautomation@finfactory.com");
//
//        System.out.println("\n\n"+driver.getPageSource()+"\n\n");
//
//        loginPage
//                .setPassword("1234567Aa");
//
//        System.out.println("\n\n"+driver.getPageSource()+"\n\n");
//
//        loginPage
//                .clickLogin();
//
//        webDriverWait
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver driver) -> {
//                    driver.findElement(By.xpath("//div[@class='popover-content'][text()='Start']"));
//                    return true;
//                });
//
//        webDriver.findElement(By.xpath("//div[@class='popover-content'][text()='Start']")).click();
//        webDriverWait
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver driver) -> {
//                    driver.findElement(By.xpath("//input[@name='echosign_email'][@value='test.automation+api20160511102017417@finfactory.com']"));
//                    return true;
//                });
//        webDriverWait
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver driver) -> {
//                    driver.findElement(By.xpath("//div[@role='button'][@aria-label='Click here to sign']"));
//                    return true;
//                });
//        webDriver.findElement(By.xpath("//div[@role='button'][@aria-label='Click here to sign']")).click();
//        webDriverWait
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver driver) -> {
//                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//div[@class='modal-content']"));
//                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//div[@class='signature-panel-inner']"));
//                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//form//input[@class='form-control signature-name']"));
//                    return true;
//                });
//        webDriver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//form//input[@class='form-control signature-name']")).sendKeys("Test Automation");
//        webDriverWait
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver driver) -> {
//                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//button[@class='btn btn-primary apply'][text()='Apply']"));
//                    return true;
//                });
//        webDriver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//button[@class='btn btn-primary apply'][text()='Apply']")).click();
//        webDriverWait
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver driver) -> {
//                    driver.findElement(By.xpath("//div[@class='agreement-footer']//div[@class='terms-of-use container-fluid'][@style='min-height: 50px; height: auto; display: block; margin-bottom: 0px; overflow: visible;']//button[@class='btn btn-primary click-to-esign'][text()='Click to sign']"));
//                    return true;
//                });
//        webDriver.findElement(By.xpath("//div[@class='agreement-footer']//div[@class='terms-of-use container-fluid'][@style='min-height: 50px; height: auto; display: block; margin-bottom: 0px; overflow: visible;']//button[@class='btn btn-primary click-to-esign'][text()='Click to sign']")).click();
//        webDriverWait
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver driver) -> {
//                    driver.findElement(By.xpath("//div[@class='interstitial'][@style='display: block;']"));
//                    return true;
//                });
//        webDriverWait
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver driver) -> {
//                    driver.findElement(By.xpath("//div[@class='interstitial'][@style='display: none;']"));
//                    return true;
//                });
//        webDriverWait
//                .ignoring(StaleElementReferenceException.class)
//                .until((WebDriver driver) -> {
//                    driver.findElement(By.xpath("//h1[@class='title'][contains(., 'You have successfully signed the agreement')]"));
//                    return true;
//                });
        driver.quit();
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.assertFalse(verificationErrorString, true);
        }
    }
}