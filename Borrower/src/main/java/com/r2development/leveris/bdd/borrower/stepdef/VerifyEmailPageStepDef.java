package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.VerifyEmailPage;
import cucumber.api.java.en.Then;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Singleton
public class VerifyEmailPageStepDef extends BorrowerStepDef {

    private static final Log log = LogFactory.getLog(VerifyEmailPageStepDef.class);

    @Inject IUser user;

    @Then("^user goes to Login page$")
    public void user_goes_to_Login_page() {
        verifyEmailPage = new VerifyEmailPage(WebDriverService.getWebDriverInstance());
        verifyEmailPage.isLoaded(user.getEmail());
        welcomePage = verifyEmailPage.redirectToWelcomePage();
        welcomePage.isLoaded();
        loginPage = welcomePage.clickLogin();
    }
}
