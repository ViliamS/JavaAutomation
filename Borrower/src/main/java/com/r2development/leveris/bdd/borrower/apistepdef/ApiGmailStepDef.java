package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import cucumber.api.java.en.Given;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Singleton
public class ApiGmailStepDef extends ApiAbakusBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiGmailStepDef.class);

    @Given("^user goes to gmail$")
    public void user_goes_to_gmail() {
        WebDriver webDriver = ApiSupportWebDriverStepDef.getWebDriverInstance();
        webDriver.get("http://www.gmail.com");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='gmail-sign-in']")));
        webDriver.findElement(By.xpath("//a[@id='gmail-sign-in']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='next']")));
        webDriver.findElement(By.xpath("//input[@id='Email']")).sendKeys("anthony.mottot@abakus.com");
        webDriver.findElement(By.xpath("//input[@id='next']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='email-display' and contains(., 'anthony.mottot@abakus.com')]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Passwd']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='signIn']")));
        webDriver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("anthonymagm3!");
        webDriver.findElement(By.xpath("//input[@id='signIn']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sbq']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nvp_site_mail']")));
        webDriver.findElement(By.xpath("//input[@name='nvp_site_mail']")).sendKeys("from:no-reply@abakus.com Verify your email now to register with Abakus" + Keys.ENTER);

        new WebDriverWait(webDriver, 180)
                .until((WebDriver driver) -> {
                    boolean toReturn = false;
                    try {
                        driver.findElement(By.xpath("//a[contains(., '" +  user.getEmail() + "')]")).click();
                        toReturn = true;
                    } catch (WebDriverException wde) {
                        driver.findElement(By.xpath("//a[@accesskey='i' and contains(., 'Inbox')]")).click();
                    }
                    return toReturn;
                });

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'" + user.getEmail() + "')]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., '" + user.getEmail() + "')]/parent::div/following-sibling::font//a[contains(., 'Verify my email address')]")));
        WebElement webElement = webDriver.findElement(By.xpath("//a[contains(., '" + user.getEmail() + "')]/parent::div/following-sibling::font//a[contains(., 'Verify my email address')]"));
        String url = webElement.getAttribute("href");
        log.info("Activation Account Url: " + url);

        webDriver.get(url);
    }
}
