package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.r2development.leveris.bdd.borrower.model.LandingPageData;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * todo LandingPageStepDef Specific Implementation
 */
public class LandingPageStepDef /*extends BorrowerStepDef*/ {

    IQuoteLandingPage quoteLandingPage;
    IQuotePaydayLoanPage quotePaydayLoanPage;
    IQuoteQuickLoanPage quoteQuickLoanPage;
    IQuoteConfigurationPage quoteConfigurationPage;
    IRegisterPage registerPage;
    LandingPageData loanData;

//    public LandingPageStepDef() {
//        quoteLandingPage = new QuoteLandingPage(WebDriverService.getWebDriverInstance());
//    }

    private WebDriver webDriver;

    @Inject
    public LandingPageStepDef(WebDriver webDriver) {
//        super(webDriver);
//        this.webDriver = webDriver;
        quoteLandingPage = new QuoteLandingPage(webDriver);
    }

//    @Given("^I am running Chrome WebDriver$")
//    public void I_am_running_Chrome_WebDriver() {
//        webDriver.navigate().to("http://www.google.fr");
//    }

    @Given("^Open Leveris Quote Landing page$")
    public void open_leveris_quote_landing_page() {
//        webDriver.navigate().to("http.google.fr");
        quoteLandingPage.goToBorrowerQuoteLandingPage();
    }

    @Given("^User clicks on continue to get (Payday Loan|Unsecured Loan)$")
    public void user_click_on_continue_button(String loanType) {

        switch (loanType) {

            case "Payday Loan":

                quotePaydayLoanPage = quoteLandingPage.clickContinuePaydayLoanTealButton();

                break;

            case "Unsecured Loan":

                quoteQuickLoanPage = quoteLandingPage.clickContinueUnsecuredLoanRedButton();

                break;
        }
    }

/*    @Given("^User clicks on red continue button$")
    public void user_click_on_red_continue_button() {
        quoteQuickLoanPage = quoteLandingPage.clickContinueUnsecuredLoanRedButton();
    }

    @Given("^User clicks on teal continue button$")
    public void user_click_on_teal_continue_button() {
        quotePaydayLoanPage = quoteLandingPage.clickContinuePaydayLoanTealButton();
    }*/


    @And("^User fills whole form (Payday Loan|Unsecured Loan)$")
//    public void user_fills_form (String loanType, Map<String, String> rawData){
    public void user_fills_form ( String loanType, List<String> rawData) {

        System.out.println(rawData);
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

                quotePaydayLoanPage.setLoanPurpose(loanPurpose);

                break;

            case "Unsecured Loan":

                quoteQuickLoanPage.setLoanPurpose( loanPurpose );

                break;
        }
    }


    @Given("^(Payday Loan|Unsecured Loan) User types into Net monthly income field a (.*)$")
    public void user_types_value_into_net_monthly_income_field(String switchCase, String netMonthlyIncome) {

        switch (switchCase) {
            case "Payday Loan":

                quotePaydayLoanPage.setNetMonthlyIncome( netMonthlyIncome );

                break;

            case "Unsecured Loan":

                quoteQuickLoanPage.setNetMonthlyIncome( netMonthlyIncome );

                break;
        }
    }

/*    @Given("^User types into Net monthly income field a (.*)$")
    public void user_types_value_into_net_monthly_income_field(String netMonthlyIncome) {
        quoteQuickLoanPage.setNetMonthlyIncome( netMonthlyIncome );
    }*/

    @Given("^(Payday Loan|Usecured Loan) User types into Monthly expenses field a (.*)$")
    public void user_types_value_into_monthly_expenses_field(String switchCase, String monthlyExpenses) {

        switch (switchCase) {
            case "Payday Loan":

                quotePaydayLoanPage.setMonthlyExpenses( monthlyExpenses );

                break;

            case "Unsecured Loan":

                quoteQuickLoanPage.setMonthlyExpenses( monthlyExpenses );

                break;
        }
    }

/*    @Given("^User types into Monthly expenses field a (.*)$")
    public void user_types_value_into_monthly_expenses_field(String monthlyExpenses) {
        quoteQuickLoanPage.setMonthlyExpenses( monthlyExpenses );
    }*/

    @Given("^(Payday Loan|Usecured Loan) User types into Number of dependents field a (.*)$")
    public void user_types_value_into_number_of_dependents_field(String switchCase, String numberOfDependents) {

        switch (switchCase) {
            case "Payday Loan":

                quotePaydayLoanPage.setNumberOfDependents( numberOfDependents );

                break;

            case "Unsecured Loan":

                quoteQuickLoanPage.setNumberOfDependents( numberOfDependents );

                break;
        }
    }

    /*@Given("^User types into Number of dependents field a (.*)$")
    public void user_types_value_into_number_of_dependents_field(String numberOfDependents) {
        quoteQuickLoanPage.setNumberOfDependents( numberOfDependents );
    }*/

    @Given("^(Payday Loan|Usecured Loan) User types into Amount to borrow field a (.*)$")
    public void user_types_value_into_amount_to_borrow_field(String switchCase, String amountToBorrow) {

        switch (switchCase) {
            case "Payday Loan":

                quotePaydayLoanPage.setAmountToBorrow( amountToBorrow );

                break;

            case "Unsecured Loan":

                quoteQuickLoanPage.setAmountToBorrow( amountToBorrow );

                break;
        }
    }

/*    @Given("^User types into Amount to borrow field a (.*)$")
    public void user_types_value_into_amount_to_borrow_field(String amountToBorrow) {
        quoteQuickLoanPage.setAmountToBorrow( amountToBorrow );
    }*/

    @Then("^(Payday Loan|Unsecured Loan) User clicks on Continue button$")
    public void user_clicks_on_continue_button(String switchCase) {

        switch (switchCase) {
            case "Payday Loan":

                quoteConfigurationPage = quotePaydayLoanPage.clickContinue();

                break;

            case "Unsecured Loan":

                quoteConfigurationPage = quoteQuickLoanPage.clickContinue();

                break;
        }
    }

/*    @Then("^User clicks on Continue button$")
    public void user_click_on_continue_button() {
        quoteConfigurationPage = quoteQuickLoanPage.clickContinue();
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
    public void userWalkThroughTheQuotationProcessFillingAllMandatoryData(String loanType, List<String> rawQuotationData) {

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
        return quoteLandingPage.getValueLoanUpTo();
    }

    public String getFromAmountPerMonth(){
        return quoteLandingPage.getFromAmountPerMonthValue();
    }

    public String getPaydayLoanAmount() { return quoteLandingPage.getPayDayLoanAmount(); }

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

    @Then("^User is forwarded to the Registration Page$")
    public void gets_to_registration_page(){
        registerPage.isLoaded();
    }

}


