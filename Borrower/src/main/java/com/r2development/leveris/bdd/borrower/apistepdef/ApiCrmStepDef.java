package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.common.base.Predicate;
import com.google.inject.Singleton;
import cucumber.api.java.en.Given;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Singleton
public class ApiCrmStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiCrmStepDef.class);

    @Given("^user goes to CRM$")
    public void user_goes_tp_CRM() {

        WebDriver firefoxWebDriver = new FirefoxDriver();

        WebDriverWait firefoxWebDriverWait = new WebDriverWait(firefoxWebDriver, 60);
        firefoxWebDriver.get("https://st1crm.loftkeys.com/index.php?module=acm_sms&action=index&parentTab=All");

        firefoxWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@label='Username']")));
        firefoxWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@label='Password']")));
        firefoxWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(., 'Login')]")));
        firefoxWebDriver.findElement(By.xpath("//input[@label='Username']")).sendKeys("Andrej.Gondor");
        firefoxWebDriver.findElement(By.xpath("//input[@label='Password']")).sendKeys("Password1122");
        firefoxWebDriver.findElement(By.xpath("//button[contains(., 'Login')]")).click();

        // todo wait for
        firefoxWebDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='index.php?module=Home&action=index']")));
        firefoxWebDriver.findElement(By.xpath("//a[@href='index.php?module=Home&action=index']")).click();

        firefoxWebDriverWait.until(
                (Predicate<WebDriver>) (WebDriver) -> firefoxWebDriver.getWindowHandles().size() == 2
        );
        firefoxWebDriver.get("https://st1crm.loftkeys.com/index.php?module=acm_sms&action=index&parentTab=All");

        firefoxWebDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='advanced_search_link' or @id='basic_search_link']")));
        firefoxWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone_advanced' or @id='phone_basic']")));
        firefoxWebDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search_form_submit_advanced' or @id='search_form_submit']")));

        firefoxWebDriver.findElement(By.xpath("//input[@id='phone_advanced' or @id='phone_basic']")).clear();
        firefoxWebDriver.findElement(By.xpath("//input[@id='phone_advanced' or @id='phone_basic']")).sendKeys(user.getPhoneNumber());
        firefoxWebDriver.findElement(By.xpath("//input[@id='search_form_submit_advanced' or @id='search_form_submit']")).click();

        firefoxWebDriverWait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//tr[contains(., '" + user.getPhoneNumber() + "') and @class ]//a[contains(., 'Please enter code')]"))
        );

        List<WebElement> allWebElementPotentialCodes = firefoxWebDriver.findElements(By.xpath("//table//tr[contains(., '" + user.getPhoneNumber() + "') and @class ]//a[contains(., 'Please enter code')]"));
        List<String> allPotentialCodes = new LinkedList<>();

        for ( WebElement currentWebElementPotentialCode : allWebElementPotentialCodes) {
            Pattern p = Pattern.compile("^Please enter code (.*) in your browser window within 30 minutes of getting this message. Thanks!$");
            Matcher m = p.matcher(currentWebElementPotentialCode.getText());

            String potentialCode = null;
            while (m.find()) {
                potentialCode = m.group(1);
            }
            allPotentialCodes.add(potentialCode);
            log.info("Potential Code: " + potentialCode);
        }

        WebDriver chromeWebDriver = ApiSupportWebDriverStepDef.getWebDriverInstance();
        WebDriverWait chromeWebDriverWait = new WebDriverWait(chromeWebDriver, 60);
        chromeWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_txtVerificationCode_tb']")));
        chromeWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_btnConfirmRegistration_submit']")));

        boolean find = false;
        for ( String currentPotentialCode : allPotentialCodes ) {
            try {
                chromeWebDriver.findElement(By.xpath("//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_txtVerificationCode_tb']")).clear();
                chromeWebDriver.findElement(By.xpath("//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_txtVerificationCode_tb']")).sendKeys(currentPotentialCode);
                chromeWebDriver.findElement(By.xpath("//a[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_btnConfirmRegistration_submit']"));
                find = true;
            } catch (WebDriverException wde) {
                log.debug("Issue of finding element to extract Potential Codes");
            }
            if (find)
                break;
        }

        chromeWebDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_btnConfirmRegistration_submit']"))).click();

        List<String> firefoxWindowsHandle = new ArrayList<>(firefoxWebDriver.getWindowHandles());
        for ( String currentFirefoxWindowsHandle : firefoxWindowsHandle) {
            firefoxWebDriver.switchTo().window(currentFirefoxWindowsHandle).close();
        }
        firefoxWebDriver.quit();
    }

}
