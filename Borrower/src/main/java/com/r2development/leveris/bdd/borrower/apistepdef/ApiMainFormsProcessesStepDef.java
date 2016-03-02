package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;

@Singleton
public class ApiMainFormsProcessesStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiMainFormsProcessesStepDef.class);

//    private HttpClient httpClient;
//    private HttpContext localContext;

//    @Inject
//    public ApiMainFormsProcessesStepDef(HttpClient httpClient, HttpContext localContext) {
//        this.httpClient = httpClient;
//        this.localContext = localContext;
//    }

    // "proxy page"
    @And("^user processes \"Forms\"$")
    public void user_processes_Forms() throws IOException {

//        requestHttpGet(
//                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnAppFormsHidden:cancel::IBehaviorListener:0:&stepToken=1",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/xml");
//                    }
//                },
//                localContext,
//                CONSUME_QUIETLY
//        );

        log.info("Going to Forms page");

        Document loginResponse = Jsoup.parse(httpResponse.getHttpResponse());
        Document loginResponse2 = Jsoup.parse(loginResponse.select("component[id~=main]").select("component[encoding~=wicket]").first().textNodes().get(0).text());

        String formResponse = requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnAppFormsHidden:cancel::IBehaviorListener:0:&stepToken=1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(formResponse);
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
