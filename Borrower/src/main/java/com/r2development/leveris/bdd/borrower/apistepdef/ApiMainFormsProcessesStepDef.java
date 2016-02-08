package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

@Singleton
public class ApiMainFormsProcessesStepDef extends ApiAbakusBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiMainFormsProcessesStepDef.class);

    public ApiMainFormsProcessesStepDef() {
    }

    // "proxy page"
    @And("^user processes \"Forms\"$")
    public void user_processes_Forms() throws IOException {

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnAppFormsHidden:cancel::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    @When("^user clicks \"Dashboard\"$")
    public void user_clicks_Dashboard() {
    }

    @When("^user clicks \"Borrower Personal Details\"$")
    public void user_clicks_Borrower_Personal_Details() {
//        if ( StringUtils.isNotEmpty(user.getFirstNameCoApplicant()) ) {
//        }
//        else {
//        }
    }

    @When("^user clicks \"Borrower Employment Income\"$")
    public void clickBorrowerEmploymentIncome() throws InterruptedException {
//        if ( StringUtils.isNotEmpty(user.getFirstNameCoApplicant()) ) {
//        }
//        else {
//        }
    }

    @When("^user clicks \"Coapplicant Personal Details\"$")
    public void clickCoapplicantPersonalDetails() {
    }

    @When("^user clicks \"Coapplicant Employment Income\"$")
    public void clickCoapplicantEmploymentIncome() {
    }

    @When("^user clicks \"Account\"$")
    public void clickAccount() {
    }

    @When("^user clicks \"Dependents\"$")
    public void clickDependents() {
    }

    @When("^user clicks \"Financial Assets\"$")
    public void clickFinancialAssets() {
    }

    @When("^user clicks \"Properties\"$")
    public void clickProperties() {
    }

    @When("^user clicks \"Financial Commitments\"$")
    public void clickFinancialCommitments() {
    }

    @When("^user clicks \"Funding\"$")
    public void clickFunding() {
    }

    @When("^user clicks \"Document Upload\"$")
    public void clickDocumentUpload() {
    }

    @When("^user clicks \"Home\"$")
    public void clickHome() {
    }

}
