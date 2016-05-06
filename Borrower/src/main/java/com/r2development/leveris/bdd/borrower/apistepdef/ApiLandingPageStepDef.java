package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.LandingPageData;
import com.r2development.leveris.di.BorrowerHttpResponse;
import com.r2development.leveris.di.IABorrowerHttpContext;
import com.r2development.leveris.di.IBorrowerHttpResponse;
import com.r2development.leveris.utils.HttpUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;

@Singleton
public class ApiLandingPageStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiLandingPageStepDef.class.getName());

    @Inject
    IBorrowerHttpResponse httpResponse;
    @Inject
    IABorrowerHttpContext localContext;
//    @Inject
//    IAutHttpLocalContext httpLocalContext;

//    IQuoteLandingPage quoteLandingPage;
//    IQuotePaydayLoanPage quotePaydayLoanPage;
//    IQuoteQuickLoanPage quoteQuickLoanPage;
//    IQuoteConfigurationPage quoteConfigurationPage;
//    IRegisterPage registerPage;
    LandingPageData loanData;
//    Map<String, String> paydayParameters = new LinkedHashMap<String, String>();

//    private HttpClient httpClient;
//    private HttpContext localContext;

//    @Inject
//    public ApiLandingPageStepDef(HttpClient httpClient, HttpContext localContext) {
//        this.httpClient = httpClient;
//        this.localContext = provideNewLocalContext();
//
//    }

    @Given("^Open Leveris Automatic Registration Page")
    public void open_leveris_automatic_registration_page() throws IOException {

//        httpClient = HttpUtils.createHttpClient();
//        localContext = HttpUtils.initContext(System.getProperty("domain.borrower"), "/stable-borrower");
//        localContext = this.newHttpClientContext(System.getProperty("domain.borrower"), "/stable-borrower");
        httpClient = HttpUtils.createHttpClient();
        localContext.setHttpContext(HttpUtils.initContext(System.getProperty("domain.borrower"), "/stable-borrower"));

        String automaticRegistrationResponse = requestHttpGet(
                httpClient,
//                "http://dv2app.opoqodev.com/stable-borrower/home?useCase=automaticregistration",
                System.getProperty("borrower") + "/home?useCase=automaticregistration",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext.getHttpContext(),
                false
        );

        if ( httpResponse == null )
            httpResponse = new BorrowerHttpResponse(null);
        httpResponse.setHttpResponse(automaticRegistrationResponse);
    }

    @Given("^Open Leveris Quote Landing page$")
    public void open_leveris_quote_landing_page() throws IOException {
//        quoteLandingPage.goToBorrowerQuoteLandingPage();

        requestHttpGet(
                httpClient,
//                "http://dv2app.opoqodev.com/stable-borrower/",
                System.getProperty("borrower"),
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext.getHttpContext(),
                false
        );

    }

    @Given("^Borrower clicks on continue to get (Payday Loan|Unsecured Loan)$")
    public void user_click_on_continue_button(String loanType) throws IOException {

        Document doc = Jsoup.parse(httpResponse.getHttpResponse());

        switch (loanType) {
            case "Payday Loan":
//                quotePaydayLoanPage = quoteLandingPage.clickContinuePaydayLoanTealButton();

//                Document doc = Jsoup.parse(httpResponse.getHttpResponse());


                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower") + "/form.1?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoan:c:w:pnlUnsecuredLoan1:c:w:btnContinue1:submit::IBehaviorListener:0:",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("stepToken", "1");
                            }
                        },
                        localContext.getHttpContext(),
                        false
                );
                break;
            case "Unsecured Loan":
//                quoteQuickLoanPage = quoteLandingPage.clickContinueUnsecuredLoanRedButton();

                Pattern pUnsecuredLoanBtnContinue0 = Pattern.compile("\\<a.*wicketpath.*pnlUnsecuredLoan.*pnlUnsecuredLoan0.*btnContinue0.*\\?wicket:interface=(.*)&.*Continue\\<\\/a\\>");
                Matcher mUnsecuredLoanBtnContinue0 = pUnsecuredLoanBtnContinue0.matcher(doc.select("component[id~=main]").select("component[encoding~=wicket").text());

                String unsecuredLoanBtnContinue0WicketInterface = null;
                while (mUnsecuredLoanBtnContinue0.find()) {
                    unsecuredLoanBtnContinue0WicketInterface = mUnsecuredLoanBtnContinue0.group(1);
                }
                String finalUnsecuredLoanBtnContinue0WicketInterface = unsecuredLoanBtnContinue0WicketInterface;

                String unsecuredLoanResponse = requestHttpPost(
                        httpClient,
//                        "http://dv2app.opoqodev.com/stable-borrower/form.1?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoan:c:w:pnlUnsecuredLoan0:c:w:btnContinue0:submit::IBehaviorListener:0:",
                        System.getProperty("borrower") + "/form.2?wicket:interface=" + finalUnsecuredLoanBtnContinue0WicketInterface,
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("stepToken", "1");
                                put("root:c:w:pnlUnsecuredLoan:c:w:pnlUnsecuredLoan0:c:w:btnContinue0:submit", "1");
                            }
                        },
                        localContext.getHttpContext(),
                        false
                );
                httpResponse.setHttpResponse(unsecuredLoanResponse);

                break;
        }
    }

    @And("^Borrower clicks \"Quote\" task$")
    public void borrower_clicks_quote_task() throws IOException {

        Document doc = Jsoup.parse(httpResponse.getHttpResponse());

//        Document componentDoc = Jsoup.parse(jsoup.select("component[id~=" + aComponentId + "]").first().text());
//        Document componentDoc = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=main]").select("component[encoding~=wicket").text());

        Elements elts = doc.select("evaluate[encoding~=wicket]");
        Element theElement = null;
        for ( Element currentElt : elts) {
            if ( !currentElt.text().contains("pnlQuote btnAction"))
                continue;

            theElement = currentElt;
            break;
        }

        Pattern pHomeDashboard = Pattern.compile("'pnlQuote btnAction.*\\{\"workItemId\"\\:\"(.*)\"\\}");
//        Matcher mHomeDashboard = pHomeDashboard.matcher(componentDoc.text());
        Matcher mHomeDashboard = pHomeDashboard.matcher(theElement.text());

        String workItemId = null;
        while (mHomeDashboard.find()) {
            workItemId = mHomeDashboard.group(1);
        }
        String finalWorkItemId = workItemId;

        Pattern pBtnTasksHidden = Pattern.compile("btnTasksHidden_submit.*\\?wicket:interface=(.*)&.*Tasks\\sHidden");
        Matcher mBtnTasksHidden = pBtnTasksHidden.matcher(doc.select("component[id~=main]").select("component[encoding~=wicket").text());

        String btnTasksHiddenWicketInterface = null;
        while (mBtnTasksHidden.find()) {
            btnTasksHiddenWicketInterface = mBtnTasksHidden.group(1);
        }
        String finalTasksHiddenWicketInterface = btnTasksHiddenWicketInterface;

        String tasksHiddenWicketInterfaceResponse = requestHttpPost(
            httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=" + finalTasksHiddenWicketInterface, //:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
            new LinkedHashMap<String, String>() {
                {
                    put("Accept", "text/xml");
                    put("Content-Type", "application/x-www-form-urlencoded");
                }
            },
            new LinkedHashMap<String, String>() {
                {
                    put("stepToken", "1");
                    put("root:c:w:txtWorkItemViewTaskId:tb", finalWorkItemId);
                    put("root:c:w:btnTasksHidden:submit", "1");
                }
            },
            localContext.getHttpContext(),
            CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(tasksHiddenWicketInterfaceResponse);

//        wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:
//        root:c:w:btnTasksHidden:submit
    }

    @And("^Borrower fills in (Payday Loan|Unsecured Loan) form$")
//    public void user_fills_form (String loanType, Map<String, String> rawData){
    public void user_fills_in_form ( String loanType, Map<String, String> rawData) {
        log.info(rawData);
        this.loanData = new LandingPageData( rawData );

        user_selects_loan_purpose( loanType, loanData.getLoanPurpose() );
        user_types_value_into_net_monthly_income_field( loanType, loanData.getNetMonthlyIncome() );
        user_types_value_into_monthly_expenses_field( loanType, loanData.getMonthlyExpenses() );
        user_types_value_into_number_of_dependants_field( loanType, loanData.getNumberOfDependants() );
        user_types_value_into_amount_to_borrow_field( loanType, loanData.getLoanAmount() );
//        user_clicks_on_continue_button(loanType);
    }

    @Given("^(Payday Loan) Borrower selects Loan purpose (PAYDAY)$")
    public void user_selects_pay_loan_purpose(String loanType, String loanPurpose) {
        loan_purpose( loanType ,loanPurpose );
    }

    @Given("^(Unsecured Loan) Borrower selects Loan purpose (PERSONAL|CAR|HOLIDAY|STUDENT|HOMEIMPROVEMENT)$")
    public void user_selects_loan_purpose(String loanType, String loanPurpose) {
        loan_purpose( loanType, loanPurpose );
    }

    private void loan_purpose(String loanType, String loanPurpose){
        switch (loanType) {
            case "Payday Loan":
//                quotePaydayLoanPage.setLoanPurpose(loanPurpose);
                paydayParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:cmbLoanPurpose:combobox", "PAYDAY");
                break;
            case "Unsecured Loan":

                /*
                <select class="content control combobox valid" name="root:c:w:pnlUnsecuredLoanQuotation:c:w:cmbLoanPurpose:combobox" id="combobox77" wicketpath="main_c_form_form_root_c_w_pnlUnsecuredLoanQuotation_c_w_cmbLoanPurpose_combobox" aria-readonly="false" aria-labelledby="label76" data-default="" data-readonly="false" data-enabled="true" aria-required="true" data-height="40" tabindex="1002" data-whisper="false" data-forcevalue="false" style="display:none;" data-button="true">
                <option selected="selected" value="">Choose One</option>
                <option value="PERSONAL">Personal purposes</option>
                <option value="CAR">Car purchase</option>
                <option value="HOLIDAY">Holiday purchase</option>
                <option value="STUDENT">Student purchase</option>
                <option value="HOMEIMPROVEMENT">Home improvement</option>
                </select>
                */

                unsecuredParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:cmbLoanPurpose:combobox", "PERSONAL");
                break;
        }
    }

    @Given("^(Payday Loan|Unsecured Loan) Borrower types into Net monthly income field a (.*)$")
    public void user_types_value_into_net_monthly_income_field(String switchCase, String netMonthlyIncome) {
        switch (switchCase) {
            case "Payday Loan":
//                quotePaydayLoanPage.setNetMonthlyIncome( netMonthlyIncome );
                paydayParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbNetMonthlyIncome:tb", netMonthlyIncome);
                break;
            case "Unsecured Loan":
//                quoteQuickLoanPage.setNetMonthlyIncome( netMonthlyIncome );
                unsecuredParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbNetMonthlyIncome:tb", netMonthlyIncome);
                break;
        }
    }

    @Given("^(Payday Loan|Usecured Loan) Borrower types into Monthly expenses field a (.*)$")
    public void user_types_value_into_monthly_expenses_field(String switchCase, String monthlyExpenses) {
        switch (switchCase) {
            case "Payday Loan":
//                quotePaydayLoanPage.setMonthlyExpenses( monthlyExpenses );
                paydayParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbMonthlyExpenses:tb", monthlyExpenses);
                break;
            case "Unsecured Loan":
//                quoteQuickLoanPage.setMonthlyExpenses( monthlyExpenses );
                unsecuredParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbMonthlyExpenses:tb", monthlyExpenses);
                break;
        }
    }

    @Given("^(Payday Loan|Usecured Loan) Borrower types into Number of dependants field a (.*)$")
    public void user_types_value_into_number_of_dependants_field(String switchCase, String numberOfDependants) {
        switch (switchCase) {
            case "Payday Loan":
//                quotePaydayLoanPage.setNumberOfDependants( numberOfDependants );
                paydayParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:txtNumberOfDependents:tb", numberOfDependants);
                break;
            case "Unsecured Loan":
//                quoteQuickLoanPage.setNumberOfDependants( numberOfDependants );
                unsecuredParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:txtNumberOfDependents:tb", numberOfDependants);
                break;
        }
    }

    @Given("^(Payday Loan|Usecured Loan) Borrower types into Amount to borrow field a (.*)$")
    public void user_types_value_into_amount_to_borrow_field(String switchCase, String amountToBorrow) {
        switch (switchCase) {
            case "Payday Loan":
//                quotePaydayLoanPage.setAmountToBorrow( amountToBorrow );
                paydayParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:pnlAmountToBorrowPayday:c:w:crbAmountToBorrowPayday:tb", amountToBorrow);
                break;
            case "Unsecured Loan":
//                quoteQuickLoanPage.setAmountToBorrow( amountToBorrow );
                unsecuredParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:pnlAmountToBorrowUnsecured:c:w:crbAmountToBorrowUnsecured:tb", amountToBorrow);
                break;
        }
    }

    @Then("^(Payday Loan|Unsecured Loan) Borrower clicks on Continue button$")
    public void user_clicks_on_continue_button(String switchCase) throws IOException {

        Document doc = Jsoup.parse(httpResponse.getHttpResponse());

        switch (switchCase) {
            case "Payday Loan":

//                String hidePnlUnsecuredLoanQuotationResponse = requestHttpPost(
//                    httpClient,
//                    "http://dv2app.opoqodev.com/stable-borrower/form.2??wicket:interface=:0:main:c:form::IFormChangeListener:2:1",
//                        new LinkedHashMap<String, String>() {
//                            {
//                                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                                put("Content-Type", "application/x-www-form-urlencoded");
//                            }
//                        },
//                        new LinkedHashMap<String, String>() {
//                            {
//                                put(
//                                    "data",
//                                    ""
//                                );
//                            }
//                        },
//                        localContext,
//                        false
//                );

//                quoteConfigurationPage = quotePaydayLoanPage.clickContinue();
                paydayParameters.put("stepToken", "2");
                paydayParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit", "1");

                String form1Response = requestHttpPost(
                        httpClient,
                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit::IBehaviorListener:0:",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        paydayParameters,
                        localContext.getHttpContext(),
                        false
                );
                httpResponse.setHttpResponse(form1Response);
                break;
            case "Unsecured Loan":

                Pattern pUnsecuredLoanQuotationBtnContinue = Pattern.compile("\\<a.*wicketpath.*pnlUnsecuredLoanQuotation.*btnContinue.*\\?wicket:interface=(.*)&.*Continue\\<\\/a\\>");
                Matcher mUnsecuredLoanQuotationBtnContinue = pUnsecuredLoanQuotationBtnContinue.matcher(doc.select("component[id~=form]").select("component[encoding~=wicket").text());

                String unsecuredLoanQuotationBtnContinueWicketInterface = null;
                while (mUnsecuredLoanQuotationBtnContinue.find()) {
                    unsecuredLoanQuotationBtnContinueWicketInterface = mUnsecuredLoanQuotationBtnContinue.group(1);
                }
                String finalUnsecuredLoanQuotationBtnContinueWicketInterfaceWicketInterface = unsecuredLoanQuotationBtnContinueWicketInterface;

                unsecuredParameters.put("stepToken", "2");
                unsecuredParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit", "1");

                String form2Response = requestHttpPost(
                        httpClient,
//                        "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit::IBehaviorListener:0:",
                        System.getProperty("borrower") + "/form.2?wicket:interface=" + finalUnsecuredLoanQuotationBtnContinueWicketInterfaceWicketInterface, //:1:main:c:form:form:root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit::IBehaviorListener:0:",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        unsecuredParameters,
                        localContext.getHttpContext(),
                        false
                );
                httpResponse.setHttpResponse(form2Response);
                break;
        }
    }

    @Given("^Borrower types into Monthly installment field a (.*)$")
    public void user_types_value_into_monthly_repayment_field(String monthlyRepayment) {
//        quoteConfigurationPage.setMonthlyInstallmentInput( monthlyRepayment );
    }

    @Given("^Borrower types into Loan amount field a (.*)$")
    public void user_types_value_into_loan_amount_field( String amountToBorrow ) {
//        quoteConfigurationPage.setLoanAmountInput( amountToBorrow );
    }

    private void check_that_value_is_in_in_amount_to_borrow_field(String expectedAmountToBorrow) {
//        String actualAmountToBorrow = quoteConfigurationPage.getLoanAmount();
//        System.out.println("Amount to borrow Expected : '" + expectedAmountToBorrow + "'\n" +
//                "                 Actual   : '" + actualAmountToBorrow + "'");
//        Assert.assertTrue("Amount to borrow doesn't match expected value", actualAmountToBorrow.equalsIgnoreCase( expectedAmountToBorrow ) );
    }

    private void check_that_value_is_in_monthly_repayment_field(String expectedMonthlyRepaymentField) {
//        String actualMonthlyRepayment = quoteConfigurationPage.getMonthlyInstalmentAmount();
//        System.out.println("Monthly repayment Expected : '" + expectedMonthlyRepaymentField + "'\n" +
//                "                  Actual   : '" + actualMonthlyRepayment + "'");
//        Assert.assertTrue("Monthly repayment doesn't match expected value", actualMonthlyRepayment.equalsIgnoreCase( expectedMonthlyRepaymentField ) );
    }

    @When("^Borrower walk-through (Payday Loan|Unsecured Loan) Quotation process$")
    public void userWalkThroughTheQuotationProcessFillingAllMandatoryData(String loanType, List<String> rawQuotationData) throws IOException {

        this.loanData = new LandingPageData( rawQuotationData );
        user_click_on_continue_button(loanType);

        user_selects_loan_purpose(loanType, loanData.getLoanPurpose() );
        user_types_value_into_net_monthly_income_field( loanType, loanData.getNetMonthlyIncome() );
        user_types_value_into_monthly_expenses_field( loanType, loanData.getMonthlyExpenses() );
        user_types_value_into_number_of_dependants_field( loanType, loanData.getNumberOfDependants() );
        user_types_value_into_amount_to_borrow_field( loanType, loanData.getLoanAmount() );

        user_clicks_on_continue_button( loanType );

//        user_types_value_into_loan_amount_field( loanData.getLoanAmount() );
//        user_types_value_into_loan_amount_field( loanData.getMonthlyInstalmentAmount() );

        user_clicks_on_apply_online();
    }

    @When("^Check that Up to (.*) is displayed$")
    public void checkUpToValue(String expectedFromPerMonth){
        String actualFromPerMonth = getUpTo();
        System.out.println("Up to $Value Expected : '" + expectedFromPerMonth + "'\n" +
                "Up to $Value Actual   : '" + actualFromPerMonth + "'");
        Assert.assertTrue("Up to $Value doesn't match expected value", actualFromPerMonth.equalsIgnoreCase( expectedFromPerMonth ) );
    }

    @When("^Check that from (.*) per month is displayed$")
    public void checkFromAmountPerMonth(String expectedFromPerMonth){
        String actualFromPerMonth = getFromAmountPerMonth();
        System.out.println("from $ per month Expected : '" + expectedFromPerMonth + "'\n" +
                "                 Actual   : '" + actualFromPerMonth + "'");
        Assert.assertTrue("from $ per month doesn't match expected value", actualFromPerMonth.equalsIgnoreCase( expectedFromPerMonth ) );
    }

    public String getUpTo(){
//        return quoteLandingPage.getValueLoanUpTo();
        return null;
    }

    public String getFromAmountPerMonth(){
//        return quoteLandingPage.getFromAmountPerMonthValue();
        return StringUtils.EMPTY;
    }

    public String getPaydayLoanAmount() {
//        return quoteLandingPage.getPayDayLoanAmount();
        return StringUtils.EMPTY;
    }

    @When("^Check that Payday (.*) is displayed$")
    public void check_that_payday_value_is_displayed(String expectedPaydayLoanAmount) {
        String actualPaydayLoanAmount = getPaydayLoanAmount();
        System.out.println("Payday loan amount Expected : '" + expectedPaydayLoanAmount + "'\n" +
                "                   Actual   : '" + actualPaydayLoanAmount + "'");
        Assert.assertTrue("from $ per month doesn't match expected value", actualPaydayLoanAmount.equalsIgnoreCase( expectedPaydayLoanAmount ) );
    }

    @Then("^Borrower clicks on Apply Online$")
    public void user_clicks_on_apply_online() throws IOException {

        String onclickBtnApplyOnline = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=main_c_form_form_root_c_w_btnApplyOnline_submit").attr("onclick");
        Pattern pOnclickBtnApplyOnline = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mOnclickBtnApplyOnline = pOnclickBtnApplyOnline.matcher(onclickBtnApplyOnline);

        String btnApplyOnlineWicketInterface = null;
        while(mOnclickBtnApplyOnline.find()) {
            btnApplyOnlineWicketInterface = mOnclickBtnApplyOnline.group(1);
        }

        Map<String, String> applyParameters = new LinkedHashMap<>();
//        applyParameters.put("root:c:w:pnlMain:c:w:pnlMortgageCalc:data", "{\"loanValue\":1000,\"repaymentValue\":1016.6666666666725,\"changedParam\":\"\"}");
        applyParameters.put("root:c:w:pnlMain:c:w:pnlMortgageCalc:data", "{\"loanValue\":1000,\"repaymentValue\":174.03381021345666,\"changedParam\":\"\"}");
        applyParameters.put("stepToken","3");
        applyParameters.put("root:c:w:btnApplyOnline:submit","1");

        String applyResponse = requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?" + btnApplyOnlineWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                applyParameters,
                localContext.getHttpContext(),
                false
        );
        httpResponse.setHttpResponse(applyResponse);
    }

    @Then("^Borrower is forwarded to the Registration Page$")
    public void gets_to_registration_page(){
//        registerPage.isLoaded();
    }

}


