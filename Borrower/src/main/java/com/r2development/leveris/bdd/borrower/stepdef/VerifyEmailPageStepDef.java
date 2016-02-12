package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.ILoginPage;
import com.r2development.leveris.selenium.borrower.pageobjects.IVerifyEmailPage;
import com.r2development.leveris.selenium.borrower.pageobjects.IWelcomePage;
import com.r2development.leveris.selenium.borrower.pageobjects.VerifyEmailPage;
import cucumber.api.java.en.Then;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

@Singleton
public class VerifyEmailPageStepDef /*extends BorrowerStepDef*/ {

    private static final Log log = LogFactory.getLog(VerifyEmailPageStepDef.class);
    private WebDriver webdriver;

    IVerifyEmailPage verifyEmailPage;
    IWelcomePage welcomePage;
    ILoginPage loginPage;

    @Inject
    IUser user;

    @Inject
    VerifyEmailPageStepDef(WebDriver webDriver) {
//        super(webDriver);
        this.webdriver = webDriver;

    }

    @Then("^user goes to Login page$")
    public void user_goes_to_Login_page() {
//        verifyEmailPage = new VerifyEmailPage(WebDriverService.getWebDriverInstance());
        verifyEmailPage = new VerifyEmailPage(webdriver);
        verifyEmailPage.isLoaded(user.getEmail());
        welcomePage = verifyEmailPage.redirectToWelcomePage();
        welcomePage.isLoaded();
        loginPage = welcomePage.clickLogin();
    }
}
