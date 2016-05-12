package com.r2development.leveris.tdd.borrower;

//import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PhantomJsTest {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    protected static DesiredCapabilities dCaps;

    @Before
    public void setUp() throws Exception {

        dCaps = new DesiredCapabilities();
        dCaps.setJavascriptEnabled(true);
        dCaps.setCapability("takesScreenshot", false);
//        dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,  "/usr/bin/phantomjs");

        driver = new PhantomJSDriver(dCaps);
//        driver = new PhantomJSDriver();
        baseUrl = "http://assertselenium.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        String urlAdobeDocument = "https://secure.na1.echosign.com/public/apiesign?pid=CBFCIBAA3AAABLblqZhByvgMB5YCZnhiW9vGosuFH3Ij0x0TcqC9xwvy47RcocATUWMw-3CvlUbA1hVpHVWs*";

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
        DesiredCapabilities dCaps;

        dCaps = new DesiredCapabilities();
        dCaps.setJavascriptEnabled(true);
        dCaps.setCapability("takesScreenshot", false);

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
        WebDriver webDriver = new PhantomJSDriver(dCaps);
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 60);

        webDriver.get(urlAdobeDocument);
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='popover-content'][text()='Start']"));
                    return true;
                });
        webDriver.findElement(By.xpath("//div[@class='popover-content'][text()='Start']")).click();
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//input[@name='echosign_email'][@value='test.automation+api20160511102017417@finfactory.com']"));
                    return true;
                });
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@role='button'][@aria-label='Click here to sign']"));
                    return true;
                });
        webDriver.findElement(By.xpath("//div[@role='button'][@aria-label='Click here to sign']")).click();
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//div[@class='modal-content']"));
                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//div[@class='signature-panel-inner']"));
                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//form//input[@class='form-control signature-name']"));
                    return true;
                });
        webDriver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//form//input[@class='form-control signature-name']")).sendKeys("Test Automation");
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//button[@class='btn btn-primary apply'][text()='Apply']"));
                    return true;
                });
        webDriver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//button[@class='btn btn-primary apply'][text()='Apply']")).click();
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='agreement-footer']//div[@class='terms-of-use container-fluid'][@style='min-height: 50px; height: auto; display: block; margin-bottom: 0px; overflow: visible;']//button[@class='btn btn-primary click-to-esign'][text()='Click to sign']"));
                    return true;
                });
        webDriver.findElement(By.xpath("//div[@class='agreement-footer']//div[@class='terms-of-use container-fluid'][@style='min-height: 50px; height: auto; display: block; margin-bottom: 0px; overflow: visible;']//button[@class='btn btn-primary click-to-esign'][text()='Click to sign']")).click();

        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='interstitial'][@style='display: block;']"));
                    return true;
                });
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='interstitial'][@style='display: none;']"));
                    return true;
                });
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//h1[@class='title'][contains(., 'You have successfully signed the agreement')]"));
                    return true;
                });
        webDriver.quit();

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
