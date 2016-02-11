package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.LandingPageData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Map;

/**
 * todo LandingPageStepDef Specific Implementation
 */
@Singleton
public class LandingPageStepDef extends BorrowerStepDef {

//    @Before
//    public void setup() throws Exception {
//
//        if (StringUtils.isEmpty(System.getProperty("environment")))
//            System.setProperty("environment", "dev2");
//
//        if (StringUtils.isEmpty(System.getProperty("domain")))
//            System.setProperty("domain", "FUCKdv2app.opoqodev.com/stable-borrower");
//
//        if (StringUtils.isEmpty(System.getProperty("borrower")))
//            System.setProperty("borrower", "FUCKhttp://dv2app.opoqodev.com/stable-borrower");
//
//        if (StringUtils.isEmpty(System.getProperty("timestamp")))
//            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));
//    }
    LandingPageData loanData;

    @Given("^Open Leveris Quote Landing page$")
    public void open_leveris_quote_landing_page() {
        landingPage.goToBorrowerQuoteLandingPage();
    }

    @Given("^User clicks on continue to get (Payday Loan|Unsecured Loan)$")
    public void user_click_on_continue_button(String loanType) {

        switch (loanType) {

            case "Payday Loan":

                paydayLoanPage = landingPage.clickContinuePaydayLoanTealButton();

                break;

            case "Unsecured Loan":

                quickLoanPage = landingPage.clickContinueUnsecuredLoanRedButton();

                break;
        }
    }

/*    @Given("^User clicks on red continue button$")
    public void user_click_on_red_continue_button() {
        quickLoanPage = landingPage.clickContinueUnsecuredLoanRedButton();
    }

    @Given("^User clicks on teal continue button$")
    public void user_click_on_teal_continue_button() {
        paydayLoanPage = landingPage.clickContinuePaydayLoanTealButton();
    }*/


    @And("^User fills whole form (Payday Loan|Unsecured Loan)$")
    public void user_fills_form (String loanType, Map<String, String> rawData){

        LandingPageData landingPageData = new LandingPageData( rawData );
        this.loanData = landingPageData;

        user_selects_loan_purpose( loanType, landingPageData.getLoanPurpose() );
        user_types_value_into_net_monthly_income_field( loanType, landingPageData.getNetMonthlyIncome() );
        user_types_value_into_monthly_expenses_field( loanType, landingPageData.getMonthlyExpenses() );
        user_types_value_into_number_of_dependents_field( loanType, landingPageData.getNumberOfDependents() );
        user_types_value_into_amount_to_borrow_field( loanType, landingPageData.getLoanAmount() );

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

                paydayLoanPage.setLoanPurpose(loanPurpose);

                break;

            case "Unsecured Loan":

                quickLoanPage.setLoanPurpose( loanPurpose );

                break;
        }
    }


    @Given("^(Payday Loan|Unsecured Loan) User types into Net monthly income field a (.*)$")
    public void user_types_value_into_net_monthly_income_field(String switchCase, String netMonthlyIncome) {

        switch (switchCase) {
            case "Payday Loan":

                paydayLoanPage.setNetMonthlyIncome( netMonthlyIncome );

                break;

            case "Unsecured Loan":

                quickLoanPage.setNetMonthlyIncome( netMonthlyIncome );

                break;
        }
    }

/*    @Given("^User types into Net monthly income field a (.*)$")
    public void user_types_value_into_net_monthly_income_field(String netMonthlyIncome) {
        quickLoanPage.setNetMonthlyIncome( netMonthlyIncome );
    }*/

    @Given("^(Payday Loan|Usecured Loan) User types into Monthly expenses field a (.*)$")
    public void user_types_value_into_monthly_expenses_field(String switchCase, String monthlyExpenses) {

        switch (switchCase) {
            case "Payday Loan":

                paydayLoanPage.setMonthlyExpenses( monthlyExpenses );

                break;

            case "Unsecured Loan":

                quickLoanPage.setMonthlyExpenses( monthlyExpenses );

                break;
        }
    }

/*    @Given("^User types into Monthly expenses field a (.*)$")
    public void user_types_value_into_monthly_expenses_field(String monthlyExpenses) {
        quickLoanPage.setMonthlyExpenses( monthlyExpenses );
    }*/

    @Given("^(Payday Loan|Usecured Loan) User types into Number of dependents field a (.*)$")
    public void user_types_value_into_number_of_dependents_field(String switchCase, String numberOfDependents) {

        switch (switchCase) {
            case "Payday Loan":

                paydayLoanPage.setNumberOfDependents( numberOfDependents );

                break;

            case "Unsecured Loan":

                quickLoanPage.setNumberOfDependents( numberOfDependents );

                break;
        }
    }

    /*@Given("^User types into Number of dependents field a (.*)$")
    public void user_types_value_into_number_of_dependents_field(String numberOfDependents) {
        quickLoanPage.setNumberOfDependents( numberOfDependents );
    }*/

    @Given("^(Payday Loan|Usecured Loan) User types into Amount to borrow field a (.*)$")
    public void user_types_value_into_amount_to_borrow_field(String switchCase, String amountToBorrow) {

        switch (switchCase) {
            case "Payday Loan":

                paydayLoanPage.setAmountToBorrow( amountToBorrow );

                break;

            case "Unsecured Loan":

                quickLoanPage.setAmountToBorrow( amountToBorrow );

                break;
        }
    }

/*    @Given("^User types into Amount to borrow field a (.*)$")
    public void user_types_value_into_amount_to_borrow_field(String amountToBorrow) {
        quickLoanPage.setAmountToBorrow( amountToBorrow );
    }*/

    @Then("^(Payday Loan|Unsecured Loan) User clicks on Continue button$")
    public void user_clicks_on_continue_button(String switchCase) {

        switch (switchCase) {
            case "Payday Loan":

                quoteConfigurationPage = paydayLoanPage.clickContinue();

                break;

            case "Unsecured Loan":

                quoteConfigurationPage = quickLoanPage.clickContinue();

                break;
        }
    }

/*    @Then("^User clicks on Continue button$")
    public void user_click_on_continue_button() {
        quoteConfigurationPage = quickLoanPage.clickContinue();
    }*/

    @Given("^User types into Monthly instalment field a (.*)$")
    public void user_types_value_into_monthly_repayment_field(String monthlyRepayment) {
        quoteConfigurationPage.setMonthlyInstallmentInput( monthlyRepayment );
    }

    @Given("^User types into Loan amount field a (.*)$")
    public void user_types_value_into_loan_amount_field( String amountToBorrow ) {
        quoteConfigurationPage.setLoanAmountInput( amountToBorrow );
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
    public void userWalkThroughTheQuotationProcessFillingAllMandatoryData(String loanType, Map<String, String> rawQuotationData) {

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
        return landingPage.getValueLoanUpTo();
    }

    public String getFromAmountPerMonth(){
        return landingPage.getFromAmountPerMonthValue();
    }

    public String getPaydayLoanAmount() { return landingPage.getPayDayLoanAmount(); }

    @When("^Check that Payday (.*) is displayed$")
    public void check_that_payday_value_is_displayed(String expectedPaydayLoanAmount) {
        String actualPaydayLoanAmount = getPaydayLoanAmount();
        System.out.println("Payday loan amount Expected : '" + expectedPaydayLoanAmount + "'\n" +
                "                   Actual   : '" + actualPaydayLoanAmount + "'");
        Assert.assertTrue("from $ per month doesn't match expected value", actualPaydayLoanAmount.equalsIgnoreCase( expectedPaydayLoanAmount ) );
    }

    @Then("^User clicks on Apply Online$")
    public void user_clicks_on_apply_online() {

        iRegisterPage = quoteConfigurationPage.clickApplyOnline();
    }

    @Then("^User is forwarded to the Registration Page$")
    public void gets_to_registration_page(){
        iRegisterPage.isLoaded();
    }

}


