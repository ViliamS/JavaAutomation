package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.DependantData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.IYourDependantsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.YourDependantsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.util.Map;

@Singleton
public class YourDependantsStepDef {

    private static final Log log = LogFactory.getLog(YourDependantsStepDef.class);

    private WebDriver webDriver;
    @Inject
    private IUser user;

    private IYourDependantsPage yourDependantsPage;

    @Inject
    public YourDependantsStepDef(SharedDriver webDriver/*, IUser user*/) {
        yourDependantsPage = new YourDependantsPage(webDriver);
    }

    @Given("^Borrower fills in \"Dependant form\"$")
    public void user_fills_in_account(Map<String, String> accountDataMap) {
        DependantData dependantData = new DependantData(accountDataMap);

        if (!StringUtils.isEmpty(dependantData.get("date Of Birth")))
            user_types_dependant_date_of_birth(dependantData.get("date Of Birth"));
        user_clicks_save_and_close();
    }

    @When("^Borrower has(n't)? dependants$")
    public void user_has_dependants(String hasDependants) throws InterruptedException {
//        workaroundCLV312(null);

        if (hasDependants == null) {
//            yourDependantsPage.clickSingleYes();
            yourDependantsPage.clickAddDependant();
        }
        else {
            yourDependantsPage.clickNone();
//            yourDependantsPage.clickSingleNo();
            yourDependantsPage.clickNext();

        }
    }

    @And("^Borrower types the Dependant date of birth: (.*)$")
    public void user_types_dependant_date_of_birth(String dateOfBirth) {
        yourDependantsPage.typeDateOfBirth(dateOfBirth);
    }

    @And("^Borrower clicks \"ADD THIS DEPENDANT\"$")
    public void user_clicks_add_this_dependant() {
        yourDependantsPage.clickAddThisDependant();
    }

    @And("^Borrower clicks \"Save and Close\"$")
    public void user_clicks_save_and_close() {
        yourDependantsPage.clickSaveAndClose();
    }

    @And("^Borrower clicks \"ADD DEPENDANT\"$")
    public void user_clicks_add_dependant() {
        yourDependantsPage.clickAddDependant();
    }

    @And("^Borrower clicks Dependants \"NEXT\"$")
    public void user_clicks_dependants_next() {
        yourDependantsPage.clickNext();
    }

    @And("^Borrower clicks Dependants \"Done\"$")
    public void user_clicks_dependants_done() { yourDependantsPage.clickDone(); }
}
