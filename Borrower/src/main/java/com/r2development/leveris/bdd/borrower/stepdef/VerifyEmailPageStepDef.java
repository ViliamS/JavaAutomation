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

@Singleton
public class VerifyEmailPageStepDef /*extends BorrowerStepDef*/ {

    private static final Log log = LogFactory.getLog(VerifyEmailPageStepDef.class.getName());
    private SharedDriver webDriver;

    IVerifyEmailPage verifyEmailPage;
    IWelcomePage welcomePage;
    ILoginPage loginPage;

    @Inject
    IUser user;

    @Inject
    VerifyEmailPageStepDef(SharedDriver webDriver) {
//        super(webDriver);
        this.webDriver = webDriver;

    }

    @Then("^Borrower goes to Login page$")
    public void user_goes_to_Login_page() {
//        verifyEmailPage = new VerifyEmailPage(WebDriverService.getWebDriverInstance());
        verifyEmailPage = new VerifyEmailPage(webDriver);
        verifyEmailPage.isLoaded(user.getEmail());
        welcomePage = verifyEmailPage.redirectToWelcomePage();
        welcomePage.isLoaded();
        loginPage = welcomePage.clickLogin();
    }
}
