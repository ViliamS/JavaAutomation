package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.selenium.borrower.pageobjects.IFormsMenu;
import com.r2development.leveris.selenium.borrower.pageobjects.YourDependentsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;

@Singleton
public class YourDependentsStepDef extends BorrowerStepDef implements CLV312Workaround {

    private static final Log log = LogFactory.getLog(YourDependentsStepDef.class);

    public YourDependentsStepDef() {
        yourDependentsPage = new YourDependentsPage(WebDriverService.getWebDriverInstance());
    }

    @When("^user has(n't)? dependents$")
    public void user_has_dependencies(String hasDependents) throws InterruptedException {
        workaroundCLV312(null);

        if (hasDependents == null) {
            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
                yourDependentsPage.clickCoupleYes();
            else
                yourDependentsPage.clickSingleYes();
        }
        else {
            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
                yourDependentsPage.clickCoupleNo();
            else
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
                if ( StringUtils.isEmpty(user.getFirstNameCoApplicant()) )
                    borrowerPersonalDetailsPage.clickDependents();
                else
                    ((IFormsMenu)borrowerPersonalDetailsPage).clickDependents("double");
                yourDependentsPage.getTitle();
                toGoOn = true;
            } catch ( TimeoutException te ) {
                log.debug("Issues of getting Dependents page");
            }
        }
    }

    @And("^this dependent is applied to (borrower|coapplicant|both)$")
    public void this_dependent_is_applied_to(String toWhom) {
        switch (toWhom) {
            case "borrower":
                yourDependentsPage.checkAccountAppliesToBorrower(user.getFirstName());
                break;
            case "coapplicant":
                yourDependentsPage.checkAccountAppliesToCoapplicant(user.getFirstNameCoApplicant());
                break;
            case "both":
                yourDependentsPage.checkAccountAppliesToBorrower(user.getFirstName());
                yourDependentsPage.checkAccountAppliesToCoapplicant(user.getFirstNameCoApplicant());
                break;
            default:
        }
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
