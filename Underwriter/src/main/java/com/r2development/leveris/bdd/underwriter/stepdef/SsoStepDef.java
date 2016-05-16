package com.r2development.leveris.bdd.underwriter.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

@Singleton
public class SsoStepDef {

    private static final Log log = LogFactory.getLog(SsoStepDef.class.getName());

    private String ssoTicket;
    @Inject
    IUser user;
    private WebDriver webdriver;

    @Inject
    SsoStepDef( SharedDriver_Borrower webDriver) {
        this.webdriver = webDriver;
    }

    @Given("^user processes SSO (Underwriter) Auth Step$")
    public void user_processes_SSO_Auth(String application) throws IOException {

        webdriver.get("https://dv2apl.opoqodev.com/sso/login?application=UNDERWRITER&host=http%3A%2F%2Fdv2app.opoqodev.com%2Fstable-underwriter%2Fhome%3FuseCase%3Dauthenticate");

    }

    @When("^user processes final SSO (Underwriter) Auth Step$")
    public void user_processes_final_sso_auth_step(String application) throws IOException {

    }

    @Then("^user logs out from (Underwriter)$")
    public void user_logs_out(String application) throws IOException {

    }
}
