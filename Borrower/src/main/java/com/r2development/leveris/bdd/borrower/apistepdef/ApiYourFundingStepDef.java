package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IHttpResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

@Singleton
public class ApiYourFundingStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourFundingStepDef.class);

    @Inject
    IHttpResponse httpResponse;

    @Inject
    public ApiYourFundingStepDef(IHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @When("^user clicks \"ADD SOURCE OF FUNDS\"$")
    public void user_clicks_add_source_of_funds() {
//        yourFundingPage.clickAddFundsSource();
    }

    @When("^user clicks \"ADD THIS SOURCE OF FUNDS\"$")
    public void user_clicks_add_this_source_of_funds() {
//        yourFundingPage.clickAddThisFundsSource();
    }

    @When("^user clicks Funding \"NEXT\"$")
    public void user_clicks_funding_next() throws IOException {

        String currentResponse = requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnImDone:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                        put("root:c:w:pnlEmpList:c:w:rptAccounts:c:rows:6:item:txtMaxFundsAccounts:tb", "20,000");
                        put("root:c:w:pnlEmpList:c:w:rptAccounts:c:rows:8:item:crbHowMuch:tb", "20,000.00");
                        put("root:c:w:pnlEmpList:c:w:btnImDone:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        httpResponse.setHttpResponse(currentResponse);
    }

    @And("^user selects (Gift|Inheritance|Other) as source of funds$")
    public void user_selects_source_funds(String sourceFunds) {
//        yourFundingPage.selectFundsSource(sourceFunds);
    }

    @And("^this funding is applied to (borrower|coapplicant|both)$")
    public void this_funding_is_applied_to(String toWhom) {
        switch (toWhom) {
            case "borrower":
//                yourFundingPage.checkFundingAppliesToBorrower(user.getFirstName());
                break;
            case "coapplicant":
//                yourFundingPage.checkFundingAppliedToCoapplicant(user.getFirstNameCoApplicant());
                break;
            case "both":
//                yourFundingPage.checkFundingAppliesToBorrower(user.getFirstName());
//                yourFundingPage.checkFundingAppliedToCoapplicant(user.getFirstNameCoApplicant());
                break;
            default:
        }
    }

    @And("^user types Gift description: (.*)$")
    public void user_types_gift_description(String description) {
//        yourFundingPage.typeGiftDescription(description);
    }

    @And("^user types Gift amount: (.*)$")
    public void user_types_gift_amount(String amount) {
//        yourFundingPage.typeGiftAmount(amount);
    }

    @And("^user types Inheritance description: (.*)$")
    public void user_types_inheritance_description(String description) {
//        yourFundingPage.typeInheritanceDescription(description);
    }

    @And("^user types Inheritance amount: (.*)$")
    public void user_types_inheritance_amount(String amount) {
//        yourFundingPage.typeInheritanceAmount(amount);
    }

    @And("^user types Other Funding description: (.*)$")
    public void user_types_other_description(String description) {
//        yourFundingPage.typeOtherDescription(description);
    }

    @And("^user types Other Funding amount: (.*)$")
    public void user_types_other_amount(String amount) {
//        yourFundingPage.typeOtherAmount(amount);
    }

    @And("^user verifies funding data$")
    public void user_verifies_funding_data() {
    }
}
