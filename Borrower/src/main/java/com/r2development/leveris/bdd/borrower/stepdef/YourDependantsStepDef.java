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

import java.util.List;

@Singleton
public class YourDependantsStepDef /*extends BorrowerStepDef*/ /*implements CLV312Workaround*/ {

    private static final Log log = LogFactory.getLog(YourDependantsStepDef.class.getName());

    private WebDriver webDriver;
    @Inject
    private IUser user;

    private IYourDependantsPage yourDependantsPage;

    @Inject
    public YourDependantsStepDef(SharedDriver webDriver/*, IUser user*/) {
        yourDependantsPage = new YourDependantsPage(webDriver);
    }

    @Given("^(Borrower) fills in \"Dependant form\"$")
    public void user_fills_in_account(String userType, List<String> accountDataMap) throws InterruptedException {
        DependantData dependantData = new DependantData(accountDataMap);

        if (!StringUtils.isEmpty(dependantData.getDateOfBirth())){
            user_clicks_add_dependant(userType);
            user_types_dependant_date_of_birth(userType, dependantData.getDateOfBirth());
        }
        user_clicks_save_and_close(userType);
    }

    @When("^(Borrower) has(n't)? dependants$")
    public void user_has_dependants(String userType, String hasDependants) throws InterruptedException {
        if (hasDependants == null)
            user_clicks_add_dependant(userType);
        else {
            borrower_clicks_i_have_none_dependant(userType);
            user_clicks_dependants_next(userType);
        }
    }

    @And("^(Borrower) types the Dependant date of birth: (.*)$")
    public void user_types_dependant_date_of_birth(String userType, String dateOfBirth) {
        yourDependantsPage.typeDateOfBirth(dateOfBirth);
    }

    @And("^(Borrower) clicks \"ADD THIS DEPENDANT\"$")
    public void user_clicks_add_this_dependant(String userType) {
        yourDependantsPage.clickAddThisDependant();
    }

    @And("^(Borrower) clicks \"Save and Close\"$")
    public void user_clicks_save_and_close(String userType) {
        yourDependantsPage.clickSaveAndClose();
    }

    @And("^(Borrower) clicks \"ADD DEPENDANT\"$")
    public void user_clicks_add_dependant(String userType) {
        yourDependantsPage.clickAddDependant();


    }

    @And("^(Borrower) clicks Dependants \"NEXT\"$")
    public void user_clicks_dependants_next(String userType) {
        yourDependantsPage.clickNext();
    }

    @And("^(Borrower) clicks \"I HAVE NONE\" Dependant$")
    public void borrower_clicks_i_have_none_dependant(String userType){
        yourDependantsPage.clickNone();
    }

    @And("^(Borrower) clicks Dependants \"Done\"$")
    public void user_clicks_dependants_done(String userType) {
        yourDependantsPage.clickDone();
    }
}
