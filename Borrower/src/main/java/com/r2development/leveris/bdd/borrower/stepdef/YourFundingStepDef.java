package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.selenium.borrower.pageobjects.IFormsMenu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

@Singleton
public class YourFundingStepDef extends BorrowerStepDef implements CLV312Workaround {

    private static final Log log = LogFactory.getLog(YourFundingStepDef.class);

    @Inject
    YourFundingStepDef(WebDriver webDriver) {
//        yourFundingPage = new YourFundingPage(WebDriverService.getWebDriverInstance());
        super(webDriver);
    }

    @When("^user clicks \"ADD SOURCE OF FUNDS\"$")
    public void user_clicks_add_source_of_funds() {
        yourFundingPage.clickAddFundsSource();
    }

    @When("^user clicks \"ADD THIS SOURCE OF FUNDS\"$")
    public void user_clicks_add_this_source_of_funds() {
        yourFundingPage.clickAddThisFundsSource();
    }

    @When("^user clicks Funding \"NEXT\"$")
    public void user_clicks_funding_next() throws InterruptedException {
        workaroundCLV312(null);
        yourFundingPage.clickNext(); // TODO .... to create a new method .... IM_DONE ....
    }

    @Override
    public void workaroundCLV312(String borrowerOrCoapplicant) {
        borrowerHomePage.clickInfoUpload();

        boolean toGoOn = false;
        while ( !toGoOn ) {
            try {
                if (StringUtils.isEmpty(user.getFirstNameCoApplicant()))
                    borrowerPersonalDetailsPage.clickFunding();
                else
                    ((IFormsMenu)borrowerPersonalDetailsPage).clickFunding("double");
                yourFundingPage.getTitle();
                toGoOn = true;
            } catch (TimeoutException te) {
                log.debug("Issues of getting Funding page.");
            }
        }
    }

    @And("^user selects (Gift|Inheritance|Other) as source of funds$")
    public void user_selects_source_funds(String sourceFunds) {
        yourFundingPage.selectFundsSource(sourceFunds);
    }

    @And("^this funding is applied to (borrower|coapplicant|both)$")
    public void this_funding_is_applied_to(String toWhom) {
        switch (toWhom) {
            case "borrower":
                yourFundingPage.checkFundingAppliesToBorrower(user.getFirstName());
                break;
            case "coapplicant":
                yourFundingPage.checkFundingAppliedToCoapplicant(user.getFirstNameCoApplicant());
                break;
            case "both":
                yourFundingPage.checkFundingAppliesToBorrower(user.getFirstName());
                yourFundingPage.checkFundingAppliedToCoapplicant(user.getFirstNameCoApplicant());
                break;
            default:
        }
    }

    @And("^user types Gift description: (.*)$")
    public void user_types_gift_description(String description) {
        yourFundingPage.typeGiftDescription(description);
    }

    @And("^user types Gift amount: (.*)$")
    public void user_types_gift_amount(String amount) {
        yourFundingPage.typeGiftAmount(amount);
    }

    @And("^user types Inheritance description: (.*)$")
    public void user_types_inheritance_description(String description) {
        yourFundingPage.typeInheritanceDescription(description);
    }

    @And("^user types Inheritance amount: (.*)$")
    public void user_types_inheritance_amount(String amount) {
        yourFundingPage.typeInheritanceAmount(amount);
    }

    @And("^user types Other Funding description: (.*)$")
    public void user_types_other_description(String description) {
        yourFundingPage.typeOtherDescription(description);
    }

    @And("^user types Other Funding amount: (.*)$")
    public void user_types_other_amount(String amount) {
        yourFundingPage.typeOtherAmount(amount);
    }

    @And("^user verifies funding data$")
    public void user_verifies_funding_data() {
    }
}
