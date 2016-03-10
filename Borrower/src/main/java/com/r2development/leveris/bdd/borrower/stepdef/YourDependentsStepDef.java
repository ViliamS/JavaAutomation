package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.DependentData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.IYourDependentsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.YourDependentsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.util.Map;

@Singleton
public class YourDependentsStepDef {

    private static final Log log = LogFactory.getLog(YourDependentsStepDef.class);

    private WebDriver webDriver;
    @Inject
    private IUser user;

    private IYourDependentsPage yourDependentsPage;

    @Inject
    public YourDependentsStepDef(SharedDriver webDriver/*, IUser user*/) {
        yourDependentsPage = new YourDependentsPage(webDriver);
    }

    @Given("^Borrower fills in \"Dependent form\"$")
    public void user_fills_in_account(Map<String, String> accountDataMap) {
        DependentData dependentData = new DependentData(accountDataMap);

        if (!StringUtils.isEmpty(dependentData.get("date Of Birth")))
            user_types_dependent_date_of_birth(dependentData.get("date Of Birth"));
        user_clicks_save_and_close();
    }

    @When("^Borrower has(n't)? dependents$")
    public void user_has_dependents(String hasDependents) throws InterruptedException {
//        workaroundCLV312(null);

        if (hasDependents == null) {
//            yourDependentsPage.clickSingleYes();
            yourDependentsPage.clickAddDependent();
        }
        else {
            yourDependentsPage.clickNone();
//            yourDependentsPage.clickSingleNo();
            yourDependentsPage.clickNext();

        }
    }

    @And("^Borrower types the Dependent date of birth: (.*)$")
    public void user_types_dependent_date_of_birth(String dateOfBirth) {
        yourDependentsPage.typeDateOfBirth(dateOfBirth);
    }

    @And("^Borrower clicks \"ADD THIS DEPENDENT\"$")
    public void user_clicks_add_this_dependant() {
        yourDependentsPage.clickAddThisDependent();
    }

    @And("^Borrower clicks \"Save and Close\"$")
    public void user_clicks_save_and_close() {
        yourDependentsPage.clickSaveAndClose();
    }

    @And("^Borrower clicks \"ADD DEPENDENT\"$")
    public void user_clicks_add_dependent() {
        yourDependentsPage.clickAddDependent();
    }

    @And("^Borrower clicks Dependents \"NEXT\"$")
    public void user_clicks_dependents_next() {
        yourDependentsPage.clickNext();
    }

    @And("^Borrower clicks Dependents \"Done\"$")
    public void user_clicks_dependents_done() { yourDependentsPage.clickDone(); }
}
