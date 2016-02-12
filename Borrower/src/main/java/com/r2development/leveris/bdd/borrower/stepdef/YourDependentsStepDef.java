package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.selenium.borrower.pageobjects.IFormsMenu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

@Singleton
public class YourDependentsStepDef extends BorrowerStepDef implements CLV312Workaround {

    private static final Log log = LogFactory.getLog(YourDependentsStepDef.class);

    @Inject
    public YourDependentsStepDef(WebDriver webDriver) {
//        yourDependentsPage = new YourDependentsPage(WebDriverService.getWebDriverInstance());
        super(webDriver);
    }

    @When("^user has(n't)? dependents$")
    public void user_has_dependencies(String hasDependents) throws InterruptedException {
        workaroundCLV312(null);

        if (hasDependents == null) {
            yourDependentsPage.clickSingleYes();
        }
        else {
            yourDependentsPage.clickSingleNo();
            yourDependentsPage.clickNext();
        }
    }

    @Override
    public void workaroundCLV312(String borrowerOrCoapplicant) {
        borrowerHomePage.clickInfoUpload();

        boolean toGoOn = false;
        while ( !toGoOn ) {
            try {
                ((IFormsMenu)borrowerPersonalDetailsPage).clickDependents("double");
                yourDependentsPage.getTitle();
                toGoOn = true;
            } catch ( TimeoutException te ) {
                log.debug("Issues of getting Dependents page");
            }
        }
    }

    @And("^this dependent is applied to (borrower)$")
    public void this_dependent_is_applied_to(String toWhom) {
        yourDependentsPage.checkAccountAppliesToBorrower(user.getFirstName());
    }

    @And("^user types the Dependent date of birth: (.*)$")
    public void user_types_Dependent_date_of_birth(String dateOfBirth) {
        yourDependentsPage.typeDateOfBirth(dateOfBirth);
    }

    @And("^user clicks \"ADD THIS DEPENDENT\"$")
    public void user_clicks_add_this_dependent() {
        yourDependentsPage.clickAddThisDependent();
    }

    @And("^user clicks \"ADD DEPENDENT\"$")
    public void user_clicks_add_dependent() {
        yourDependentsPage.clickAddDependent();
    }

    @And("^user clicks Dependents \"NEXT\"$")
    public void user_clicks_dependents_next() {
        yourDependentsPage.clickNext();
    }
}
