package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.AutomaticRegistrationData;
import com.r2development.leveris.selenium.borrower.pageobjects.AutomaticRegistrationPage;
import com.r2development.leveris.selenium.borrower.pageobjects.IAutomaticRegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

@Singleton
public class AutomaticRegistrationStepDef /*extends BorrowerStepDef*/ {

    private static final Log log = LogFactory.getLog(AutomaticRegistrationStepDef.class.getName());

    IAutomaticRegistrationPage automaticRegistrationPage;
    private final WebDriver webDriver;

    @Inject
    AutomaticRegistrationStepDef(SharedDriver webDriver) {
//        super(webDriver);
        automaticRegistrationPage = new AutomaticRegistrationPage(webDriver);
        this.webDriver = webDriver;
    }

    @Given("^Borrower processes the automatic registration$")
    public void user_goes_to_automatic_registration_page(List<String> userNameList) {
        //todo when change back to map just uncomment
        //automaticRegistrationPage.clickCreateNewUser(userNameMap.get(ApplicantId));
        automaticRegistrationPage.clickCreateNewUser(userNameList.get(1));
    }

    @Given("^Borrower types his applicant : (.*)$")
    public void user_types_his_applicant(String applicantId) {
        automaticRegistrationPage.typeCoapplicantId(applicantId);
    }

    @Given("^Borrower (unchecks|checks) \"Quote Complete\"$")
    public void user_unchecks_or_checks_for_quote_complete(String checks_or_unchecks) {
        switch (checks_or_unchecks) {
            case "unchecks":
                automaticRegistrationPage.uncheckQuoteComplete();
                break;
            case "checks":
                automaticRegistrationPage.isCheckedQuoteComplete();
                break;
            default:
                log.error("House we have problem AutomaticRegistration Quote Complete");
                break;
        }
    }

    @Given("^Borrower (unchecks|checks) \"Invite Coapplicant\"$")
    public void user_unchecks_or_checks_for_invite_coapplicant(String checks_or_unchecks) {
        switch (checks_or_unchecks) {
            case "unchecks":
                automaticRegistrationPage.uncheckInviteCoapplicant();
                break;
            case "checks":
                automaticRegistrationPage.checkInviteCoapplicant();
                break;
            default:
                log.error("House we have problem AutomaticRegistration Invite Coapplicant");
                break;
        }
    }

    @Given("^Borrower types coapplicant's email: (.*)$")
    public void user_types_coapplicant_email(String coapplicantId) {
        automaticRegistrationPage.typeCoapplicantId(coapplicantId);
    }

    @When("^Borrower clicks \"Create new user\"$")
    public void user_clicks_create_new_user(List<String> userData) {
        //automaticRegistrationPage.clickCreateNewUser();
    }

    @Given("^this automatic registration data, user processes the automatic registration$")
    public void this_registration_data_user_processes_the_registration(Map<String, String> automationRegistrationDataMap) {
        fill_in_automatic_registration(new AutomaticRegistrationData(automationRegistrationDataMap));
    }

    private void fill_in_automatic_registration(AutomaticRegistrationData automaticRegistrationData) {
//        user_types_coapplicant_email(automaticRegistrationData.get("applicantId"));
//        if ( automaticRegistrationData.get("quoteComplete") != null && automaticRegistrationData.get("quoteComplete").equals("yes"))
//            user_unchecks_or_checks_for_quote_complete("checks");
//        if ( automaticRegistrationData.get("inviteCoapplicant") != null && automaticRegistrationData.get("inviteCoapplicant").equals("yes")) {
//            user_unchecks_or_checks_for_invite_coapplicant("checks");
//            Assert.assertNotNull("coapplicant id is mandatory to invite a coapplicant", automaticRegistrationData.get("coapplicantId" ));
//            user_types_coapplicant_email(automaticRegistrationData.get("coapplicantId"));
//        }
        //user_clicks_create_new_user();
    }
}
