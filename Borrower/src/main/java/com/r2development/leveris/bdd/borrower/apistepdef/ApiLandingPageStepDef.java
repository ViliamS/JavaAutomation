package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.LandingPageData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

/**
 * todo LandingPageStepDef Specific Implementation
 */
@Singleton
public class ApiLandingPageStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiLandingPageStepDef.class.getName());

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

    @Given("^Open Leveris Quote Landing page$")
    public void open_leveris_quote_landing_page() throws IOException {
//        quoteLandingPage.goToBorrowerQuoteLandingPage();

        requestHttpGet(
                httpClient,
                "http://dv2app.opoqodev.com/stable-borrower/",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                false
        );

    }

    @Given("^User clicks on continue to get (Payday Loan|Unsecured Loan)$")
    public void user_click_on_continue_button(String loanType) throws IOException {
        switch (loanType) {
            case "Payday Loan":
//                quotePaydayLoanPage = quoteLandingPage.clickContinuePaydayLoanTealButton();

                requestHttpPost(
                        httpClient,
                        "http://dv2app.opoqodev.com/stable-borrower/form.1?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoan:c:w:pnlUnsecuredLoan1:c:w:btnContinue1:submit::IBehaviorListener:0:",
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
                        localContext,
                        false
                );

                break;
            case "Unsecured Loan":
//                quoteQuickLoanPage = quoteLandingPage.clickContinueUnsecuredLoanRedButton();
                break;
        }
    }

    @And("^User fills in (Payday Loan|Unsecured Loan) form$")
//    public void user_fills_form (String loanType, Map<String, String> rawData){
    public void user_fills_in_form ( String loanType, List<String> rawData) {
        log.info(rawData);
        this.loanData = new LandingPageData( rawData );

        user_selects_loan_purpose( loanType, loanData.getLoanPurpose() );
        user_types_value_into_net_monthly_income_field( loanType, loanData.getNetMonthlyIncome() );
        user_types_value_into_monthly_expenses_field( loanType, loanData.getMonthlyExpenses() );
        user_types_value_into_number_of_dependents_field( loanType, loanData.getNumberOfDependents() );
        user_types_value_into_amount_to_borrow_field( loanType, loanData.getLoanAmount() );
    }

    @Given("^(Payday Loan) User selects Loan purpose (PAYDAY)$")
    public void user_selects_pay_loan_purpose(String loanType, String loanPurpose) {
        loan_purpose( loanType ,loanPurpose );
    }

    @Given("^(Unsecured Loan) User selects Loan purpose (PERSONAL|CAR|HOLIDAY|STUDENT|HOMEIMPROVEMENT)$")
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
//                quoteQuickLoanPage.setLoanPurpose( loanPurpose );
                break;
        }
    }

    @Given("^(Payday Loan|Unsecured Loan) User types into Net monthly income field a (.*)$")
    public void user_types_value_into_net_monthly_income_field(String switchCase, String netMonthlyIncome) {
        switch (switchCase) {
            case "Payday Loan":
//                quotePaydayLoanPage.setNetMonthlyIncome( netMonthlyIncome );
                paydayParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbNetMonthlyIncome:tb", netMonthlyIncome);
                break;
            case "Unsecured Loan":
//                quoteQuickLoanPage.setNetMonthlyIncome( netMonthlyIncome );
                break;
        }
    }

    @Given("^(Payday Loan|Usecured Loan) User types into Monthly expenses field a (.*)$")
    public void user_types_value_into_monthly_expenses_field(String switchCase, String monthlyExpenses) {
        switch (switchCase) {
            case "Payday Loan":
//                quotePaydayLoanPage.setMonthlyExpenses( monthlyExpenses );
                paydayParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbMonthlyExpenses:tb", monthlyExpenses);
                break;
            case "Unsecured Loan":
//                quoteQuickLoanPage.setMonthlyExpenses( monthlyExpenses );
                break;
        }
    }

    @Given("^(Payday Loan|Usecured Loan) User types into Number of dependents field a (.*)$")
    public void user_types_value_into_number_of_dependents_field(String switchCase, String numberOfDependents) {
        switch (switchCase) {
            case "Payday Loan":
//                quotePaydayLoanPage.setNumberOfDependents( numberOfDependents );
                paydayParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:txtNumberOfDependents:tb", numberOfDependents);
                break;
            case "Unsecured Loan":
//                quoteQuickLoanPage.setNumberOfDependents( numberOfDependents );
                break;
        }
    }

    @Given("^(Payday Loan|Usecured Loan) User types into Amount to borrow field a (.*)$")
    public void user_types_value_into_amount_to_borrow_field(String switchCase, String amountToBorrow) {
        switch (switchCase) {
            case "Payday Loan":
//                quotePaydayLoanPage.setAmountToBorrow( amountToBorrow );
                paydayParameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:pnlAmountToBorrowPayday:c:w:crbcrbAmountToBorrowPayday:tb", amountToBorrow);
                break;
            case "Unsecured Loan":
//                quoteQuickLoanPage.setAmountToBorrow( amountToBorrow );
                break;
        }
    }

    @Then("^(Payday Loan|Unsecured Loan) User clicks on Continue button$")
    public void user_clicks_on_continue_button(String switchCase) throws IOException {
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
                        "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit::IBehaviorListener:0:",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        paydayParameters,
                        localContext,
                        false
                );
                break;
            case "Unsecured Loan":
//                quoteConfigurationPage = quoteQuickLoanPage.clickContinue();
                break;
        }
    }

    @Given("^User types into Monthly installment field a (.*)$")
    public void user_types_value_into_monthly_repayment_field(String monthlyRepayment) {
//        quoteConfigurationPage.setMonthlyInstallmentInput( monthlyRepayment );
    }

    @Given("^User types into Loan amount field a (.*)$")
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

    @When("^User walk-through (Payday Loan|Unsecured Loan) Quotation process$")
    public void userWalkThroughTheQuotationProcessFillingAllMandatoryData(String loanType, List<String> rawQuotationData) throws IOException {

        this.loanData = new LandingPageData( rawQuotationData );
        user_click_on_continue_button(loanType);

        user_selects_loan_purpose(loanType, loanData.getLoanPurpose() );
        user_types_value_into_net_monthly_income_field( loanType, loanData.getNetMonthlyIncome() );
        user_types_value_into_monthly_expenses_field( loanType, loanData.getMonthlyExpenses() );
        user_types_value_into_number_of_dependents_field( loanType, loanData.getNumberOfDependents() );
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

    @Then("^User clicks on Apply Online$")
    public void user_clicks_on_apply_online() throws IOException {
        Map<String, String> applyParameters = new LinkedHashMap<>();
        applyParameters.put("root:c:w:pnlMain:c:w:pnlMortgageCalc:data", "{\"loanValue\":1000,\"repaymentValue\":1016.6666666666725,\"changedParam\":\"\"}");
        applyParameters.put("stepToken","3");
        applyParameters.put("root:c:w:btnApplyOnline:submit","1");

        String applyResponse = requestHttpPost(
                httpClient,
                "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnApplyOnline:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                applyParameters,
                localContext,
                false
        );
    }

    @Then("^User is forwarded to the Registration Page$")
    public void gets_to_registration_page(){
//        registerPage.isLoaded();
    }

}


