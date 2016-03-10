package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.Then;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Singleton
public class ApiVerifyEmailPageStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiVerifyEmailPageStepDef.class);

    @Inject IUser user;

    @Then("^Borrower goes to Login page$")
    public void user_goes_to_Login_page() {
//        verifyEmailPage = new VerifyEmailPage(SupportWebDriverStepDef.getWebDriverInstance());
//        verifyEmailPage.isLoaded(user.getEmail());
//        welcomePage = verifyEmailPage.redirectToWelcomePage();
//        welcomePage.isLoaded();
//        loginPage = welcomePage.clickLogin();
    }
}
