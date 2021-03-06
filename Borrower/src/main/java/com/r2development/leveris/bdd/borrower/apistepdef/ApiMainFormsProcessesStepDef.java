package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IABorrowerHttpContext;
import com.r2development.leveris.di.IBorrowerHttpResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;

@Singleton
public class ApiMainFormsProcessesStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiMainFormsProcessesStepDef.class);

//    private HttpClient httpClient;
    @Inject
    IABorrowerHttpContext localContext;
    @Inject
    private IBorrowerHttpResponse httpResponse;

//    @Inject
//    public ApiMainFormsProcessesStepDef(HttpClient httpClient, HttpContext localContext) {
//        this.httpClient = httpClient;
//        this.localContext = localContext;
//    }

    @Inject
    public ApiMainFormsProcessesStepDef(IBorrowerHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    // "proxy page"
    @And("^Borrower processes \"Forms\"$")
    public void user_processes_Forms() throws IOException {

        String onclickBtnAppFormsHidden = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=main]").select("component[encoding~=wicket]").text()).select("a[id~=cancel]").select("a[wicketpath~=main_c_form_form_root_c_w_btnAppFormsHidden_cancel").attr("onclick");
        Pattern pOnclickBtnAppFormsHidden = Pattern.compile("\\?(wicket:interface=.*&stepToken=.)&");
        Matcher mOnclickBtnAppFormsHidden = pOnclickBtnAppFormsHidden.matcher(onclickBtnAppFormsHidden);

        String btnAppFormsHiddenWicketInterface = null;
        while(mOnclickBtnAppFormsHidden.find()) {
            btnAppFormsHiddenWicketInterface = mOnclickBtnAppFormsHidden.group(1);
        }


        String formResponse = requestHttpGet(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnAppFormsHidden:cancel::IBehaviorListener:0:&stepToken=1",
                System.getProperty("borrower.url") + "/form.2?" + btnAppFormsHiddenWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(formResponse);
    }

    @When("^Borrower clicks \"Dashboard\"$")
    public void user_clicks_Dashboard() {
    }

    @When("^Borrower clicks \"Borrower Personal Details\"$")
    public void user_clicks_Borrower_Personal_Details() {
//        if ( StringUtils.isNotEmpty(user.getFirstNameCoApplicant()) ) {
//        }
//        else {
//        }
    }

    @When("^Borrower clicks \"Borrower Employment Income\"$")
    public void clickBorrowerEmploymentIncome() throws InterruptedException {
//        if ( StringUtils.isNotEmpty(user.getFirstNameCoApplicant()) ) {
//        }
//        else {
//        }
    }

    @When("^Borrower clicks \"Coapplicant Personal Details\"$")
    public void clickCoapplicantPersonalDetails() {
    }

    @When("^Borrower clicks \"Coapplicant Employment Income\"$")
    public void clickCoapplicantEmploymentIncome() {
    }

    @When("^Borrower clicks \"Account\"$")
    public void clickAccount() {
    }

    @When("^Borrower clicks \"Dependants\"$")
    public void clickDependants() {
    }

    @When("^Borrower clicks \"Financial Assets\"$")
    public void clickFinancialAssets() {
    }

    @When("^Borrower clicks \"Properties\"$")
    public void clickProperties() {
    }

    @When("^Borrower clicks \"Financial Commitments\"$")
    public void clickFinancialCommitments() {
    }

    @When("^Borrower clicks \"Funding\"$")
    public void clickFunding() {
    }

    @When("^Borrower clicks \"Document Upload\"$")
    public void clickDocumentUpload() {
    }

    @When("^Borrower clicks \"Home\"$")
    public void clickHome() {
    }

}
