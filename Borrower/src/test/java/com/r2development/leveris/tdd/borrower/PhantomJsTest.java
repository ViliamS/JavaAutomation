package com.r2development.leveris.tdd.borrower;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

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
    public void getTestRailLinkOfAssertSelenium() {

        driver.get("https://www.loftkeys.com/testrail/");
//Getting all the links present in the page by a HTML tag.
        List<WebElement> links = driver.findElements(By.tagName("a"));

//Printing the size, will print the no of links present in the page.
        System.out.println("Total Links present is "+links.size());

//Printing the links in the page, we get through the href attribute.
        for (WebElement link : links) {

            System.out.println("Links are listed " + link.getAttribute("href"));
        }
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
