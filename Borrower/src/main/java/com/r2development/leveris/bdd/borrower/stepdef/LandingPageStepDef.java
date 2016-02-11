package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.LandingPageData;
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


    @Given("^Open Lever\\.is Quote Landing page$")
    public void open_leveris_quote_landing_page() {
        landingPage.goToBorrowerQuoteLandingPage();
    }

    @Given("^User clicks on red continue button$")
    public void user_click_on_red_continue_button() {
        quickLoanPage = landingPage.clickContinueUnsecuredLoanRedButton();
    }

    @Given("^User clicks on teal continue button$")
    public void user_click_on_teal_continue_button() {
        landingPage.clickContinuePaydayLoanTealButton();
    }

    @Given("^User selects Loan purpose (PERSONAL|PAYDAY)$")
    public void user_selects_value_from_drop_down_field_loan_purpose(String loanPurpose) {
        quickLoanPage.setLoanPurpose( loanPurpose );
    }

    @Given("^User types into Net monthly income field a (.*)$")
    public void user_types_value_into_net_monthly_income_field(String netMonthlyIncome) {
        quickLoanPage.setNetMonthlyIncome( netMonthlyIncome );
    }

    @Given("^User types into Monthly expenses field a (.*)$")
    public void user_types_value_into_monthly_expenses_field(String monthlyExpenses) {
        quickLoanPage.setMonthlyExpenses( monthlyExpenses );
    }

    @Given("^User types into Number of dependents field a (.*)$")
    public void user_types_value_into_number_of_dependents_field(String numberOfDependents) {
        quickLoanPage.setNumberOfDependents( numberOfDependents );
    }

    @Given("^User types into Amount to borrow field a (.*)$")
    public void user_types_value_into_amount_to_borrow_field(String amountToBorrow) {
        quickLoanPage.setAmountToBorrow( amountToBorrow );
    }

    @Then("^User clicks on Continue button$")
    public void user_click_on_continue_button() {
        quoteConfigurationPage = quickLoanPage.clickContinue();
    }

    @Given("^User types into Monthly instalment field a (.*)$")
    public void user_types_value_into_monthly_repayment_field(String monthlyRepayment) {
        quoteConfigurationPage.setMonthlyInstalmentInput( monthlyRepayment );
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

    @When("^User walk-through the Quotation process filling all mandatory data \\(format1\\)$")
    public void userWalkThroughTheQuotationProcessFillingAllMandatoryData(Map<String, String> rawQuotationData) {

        LandingPageData landingPageData = new LandingPageData( rawQuotationData );
        open_leveris_quote_landing_page();

        //getting and checking the page is more less self-test of page xpaths
        /*checkUpToValue( landingPageData.getUpToAmount() );
        checkFromAmountPerMonth( landingPageData.getFromAmountPerMonth() );
        check_that_payday_value_is_displayed( landingPageData.getPayDayLoanAmount() );*/

        user_click_on_red_continue_button();

        user_selects_value_from_drop_down_field_loan_purpose( landingPageData.getLoanPurpose() );
        user_types_value_into_net_monthly_income_field( landingPageData.getNetMonthlyIncome() );
        user_types_value_into_monthly_expenses_field( landingPageData.getMonthlyExpenses() );
        user_types_value_into_number_of_dependents_field( landingPageData.getNumberOfDependents() );
        user_types_value_into_amount_to_borrow_field( landingPageData.getLoanAmount() );

        user_click_on_continue_button();

        user_types_value_into_loan_amount_field( landingPageData.getLoanAmount() );
        user_types_value_into_loan_amount_field( landingPageData.getMonthlyInstalmentAmount() );

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
        registerPage = quoteConfigurationPage.clickApplyOnline();
    }
}


