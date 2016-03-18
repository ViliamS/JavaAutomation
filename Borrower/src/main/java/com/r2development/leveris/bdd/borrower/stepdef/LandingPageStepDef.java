package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.LandingPageData;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.List;

/**
 * todo LandingPageStepDef Specific Implementation
 */
@Singleton
public class LandingPageStepDef /*extends BorrowerStepDef*/ {

    IQuoteLandingPage quoteLandingPage;
    IQuotePaydayLoanPage quotePaydayLoanPage;
    IQuoteQuickLoanPage quoteQuickLoanPage;
    IQuoteConfigurationPage quoteConfigurationPage;
    IRegisterPage registerPage;
    LandingPageData loanData;
    IAutomaticRegistrationPage automaticRegistrationPage;

//    public LandingPageStepDef() {
//        quoteLandingPage = new QuoteLandingPage(WebDriverService.getWebDriverInstance());
//    }

//    private WebDriver webDriver;

    @Inject
    public LandingPageStepDef(SharedDriver webDriver) {
//        super(webDriver);
//        this.webDriver = webDriver;
        quoteLandingPage = new QuoteLandingPage(webDriver);
        automaticRegistrationPage = new AutomaticRegistrationPage(webDriver);
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

    @Given("^Open Leveris Automatic Registration Page$")
    public void open_leveris_automatic_registration_page(){
        automaticRegistrationPage.goToAutomaticRegistrationPage();
    }

    @When("^Use Automatic registration page to create a new Borrower and login$")
    public void use_automatic_registration_page_to_create_new_user(List<String> userData){
        // Todo : uncomment when moving back to Map         automaticRegistrationPage.clickCreateNewUser(userData.get(ApplicantId));
        automaticRegistrationPage.clickCreateNewUser(userData.get(1));
    }

    @Given("^Borrower clicks on continue to get (Payday Loan|Unsecured Loan)$")
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

/*    @Given("^Borrower clicks on red continue button$")
    public void user_click_on_red_continue_button() {
        quoteQuickLoanPage = quoteLandingPage.clickContinueUnsecuredLoanRedButton();
    }

    @Given("^Borrower clicks on teal continue button$")
    public void user_click_on_teal_continue_button() {
        quotePaydayLoanPage = quoteLandingPage.clickContinuePaydayLoanTealButton();
    }*/


    @And("^Borrower fills in (Payday Loan|Unsecured Loan) form$")
//    public void user_fills_form (String loanType, Map<String, String> rawData){
    public void user_fills_in_form ( String formType, List<String> rawData) {

        this.loanData = new LandingPageData( rawData );

        Assert.assertTrue(formType + " doesn't equals to " + loanData.getFormType(), formType.equalsIgnoreCase(loanData.getFormType()));

        if ( !StringUtils.isEmpty(loanData.getLoanPurpose()) )
            user_selects_loan_purpose( formType, loanData.getLoanPurpose() );
        user_types_value_into_net_monthly_income_field( formType, loanData.getNetMonthlyIncome() );
        user_types_value_into_monthly_expenses_field( formType, loanData.getMonthlyExpenses() );
        user_types_value_into_number_of_dependants_field( formType, loanData.getNumberOfDependants() );
        user_types_value_into_amount_to_borrow_field( formType, loanData.getLoanAmount() );

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
                quotePaydayLoanPage.setLoanPurpose(loanPurpose);
                break;
            case "Unsecured Loan":
                quoteQuickLoanPage.setLoanPurpose( loanPurpose );
                break;
        }
    }


    @Given("^(Payday Loan|Unsecured Loan) Borrower types into Net monthly income field a (.*)$")
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

/*    @Given("^Borrower types into Net monthly income field a (.*)$")
    public void user_types_value_into_net_monthly_income_field(String netMonthlyIncome) {
        quoteQuickLoanPage.setNetMonthlyIncome( netMonthlyIncome );
    }*/

    @Given("^(Payday Loan|Usecured Loan) Borrower types into Monthly expenses field a (.*)$")
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

/*    @Given("^Borrower types into Monthly expenses field a (.*)$")
    public void user_types_value_into_monthly_expenses_field(String monthlyExpenses) {
        quoteQuickLoanPage.setMonthlyExpenses( monthlyExpenses );
    }*/

    @Given("^(Payday Loan|Usecured Loan) Borrower types into Number of dependants field a (.*)$")
    public void user_types_value_into_number_of_dependants_field(String switchCase, String numberOfDependants) {
        switch (switchCase) {
            case "Payday Loan":
                quotePaydayLoanPage.setNumberOfDependants( numberOfDependants );
                break;
            case "Unsecured Loan":
                quoteQuickLoanPage.setNumberOfDependants( numberOfDependants );
                break;
        }
    }

    /*@Given("^Borrower types into Number of dependants field a (.*)$")
    public void user_types_value_into_number_of_dependants_field(String numberOfDependants) {
        quoteQuickLoanPage.setNumberOfDependants( numberOfDependants );
    }*/

    @Given("^(Payday Loan|Usecured Loan) Borrower types into Amount to borrow field a (.*)$")
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

/*    @Given("^Borrower types into Amount to borrow field a (.*)$")
    public void user_types_value_into_amount_to_borrow_field(String amountToBorrow) {
        quoteQuickLoanPage.setAmountToBorrow( amountToBorrow );
    }*/

    @Then("^(Payday Loan|Unsecured Loan) Borrower clicks on Continue button$")
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

/*    @Then("^Borrower clicks on Continue button$")
    public void user_click_on_continue_button() {
        quoteConfigurationPage = quoteQuickLoanPage.clickContinue();
    }*/

    @Given("^Borrower types into Monthly instalment field a (.*)$")
    public void user_types_value_into_monthly_repayment_field(String monthlyRepayment) {
        quoteConfigurationPage.setMonthlyInstallmentInput( monthlyRepayment );
    }

    @Given("^Borrower types into Loan amount field a (.*)$")
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

    @When("^Borrower walk-through (Payday Loan|Unsecured Loan) Quotation process$")
    public void userWalkThroughTheQuotationProcessFillingAllMandatoryData(String loanType, List<String> rawQuotationData) {

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
        System.out.println("Up to $Value Expected : '" + expectedFromPerMonth + " Up to $Value Actual   : '" + actualFromPerMonth + "'");
        Assert.assertTrue("Up to $Value doesn't match expected value", actualFromPerMonth.equalsIgnoreCase( expectedFromPerMonth ) );
    }

    @When("^Check that from (.*) per month is displayed$")
    public void checkFromAmountPerMonth(String expectedFromPerMonth){
        String actualFromPerMonth = getFromAmountPerMonth();
        System.out.println("from $ per month Expected : '" + expectedFromPerMonth + ", Actual   : '" + actualFromPerMonth + "'");
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
        System.out.println("Payday loan amount Expected : '" + expectedPaydayLoanAmount + ", Actual   : '" + actualPaydayLoanAmount + "'");
        Assert.assertTrue("from $ per month doesn't match expected value", actualPaydayLoanAmount.equalsIgnoreCase( expectedPaydayLoanAmount ) );
    }

    @Then("^Borrower clicks on Apply Online$")
    public void user_clicks_on_apply_online() {
        registerPage = quoteConfigurationPage.clickApplyOnline();
    }

    @Then("^Borrower is on the Registration Page$")
    public void gets_to_registration_page(){
        registerPage.isLoaded();
    }

}


