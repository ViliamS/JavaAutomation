package com.r2development.leveris.bdd.borrower.stepdef;

import com.r2development.leveris.bdd.borrower.model.LandingPageData;
import com.r2development.leveris.selenium.borrower.pageobjects.QuickLoanPage;
import com.r2development.leveris.selenium.borrower.pageobjects.QuotationConfigurationPage;
import com.r2development.leveris.selenium.borrower.pageobjects.QuoteLandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Map;

/**
 * todo LandingPageStepDef Specific Implementation
 */
public class LandingPageStepDef {

    QuoteLandingPage landingPage = new QuoteLandingPage(WebDriverService.getWebDriverInstance());
    QuickLoanPage quickLoanPage = new QuickLoanPage(WebDriverService.getWebDriverInstance());
    QuotationConfigurationPage quoteConfigurationPage = new QuotationConfigurationPage(WebDriverService.getWebDriverInstance());
    LandingPageData landingPageData;

    @Given("^Open Lever\\.is Quote Landing page$")
    public void openLeverIsQuoteLandingPage() {
        landingPage.goToBorrowerQuoteLandingPage();
    }

    @Given("^User clicks on red continue button$")
    public void userClickOnRedContinueButton() {
        landingPage.clickContinueRedButton();
    }

    @Given("^User selects a (.*) from drop down field Loan purpose$")
    public void userSelectsAVALUEFromDropDownFieldLoanPurpose(String loanPurpose) {
        quickLoanPage.loanPurposeSendKeys( loanPurpose );
    }

    @Given("^User types a (.*) into Net monthly income field$")
    public void usertypesAVALUEIntoNetMonthlyIncomeField(String netMonthlyIncome) {
        quickLoanPage.netMonthlyIncomeSendKeys( netMonthlyIncome );
    }

    @Given("^User types a (.*) into Monthly expenses filed$")
    public void usertypesAVALUEIntoMonthlyExpensesFiled(String monthlyExpenses) {
        quickLoanPage.monthlyExpensesSendKeys( monthlyExpenses );
    }

    @Given("^User types a (.*) into Number of dependents field$")
    public void usertypesAVALUEIntoNumberOfDependentsField(String numberOfDependents) {
        quickLoanPage.numberOfDependentsSendKeys( numberOfDependents );
    }

    @Given("^User types a (.*) into Amount to borrow field$")
    public void usertypesAVALUEIntoAmountToBorrowField(String amountToBorrow) {
        quickLoanPage.amountToBorrowSendKeys( amountToBorrow );
    }

    @Then("^User clicks on Continue button$")
    public void userClickOnContinueButton() {
        quickLoanPage.clickContinue();
    }

    @Given("^User types a (.*) into Monthly repayment filed$")
    public void userTypesAVALUEIntoMonthlyRepaymentFiled(String monthlyRepayment) {
        quoteConfigurationPage.setMonthlyRepaymentInput( monthlyRepayment );
    }

    @Then("^Check that (.*) is in Amount to borrow field$")
    public void checkThatVALUEIsInAmountToBorrowField(String expectedAmountToBorrow) {
        String actualAmountToBorrow = quoteConfigurationPage.getAmountToBorrow();
        System.out.println("Amount to borrow Expected : '" + expectedAmountToBorrow + "'\n" +
                "                 Actual   : '" + actualAmountToBorrow + "'");
        Assert.assertTrue("Amount to borrow doesn't match expected value", actualAmountToBorrow.equalsIgnoreCase( expectedAmountToBorrow ) );
    }

    @Then("^Check that (.*) is in Monthly repayment field$")
    public void checkThatVALUEIsInMonthlyRepaymentField(String expectedMonthlyRepaymentField) {
        String actualMonthlyRepayment = quoteConfigurationPage.getMonthlyRepayment();
        System.out.println("Monthly repayment Expected : '" + expectedMonthlyRepaymentField + "'\n" +
                "                  Actual   : '" + actualMonthlyRepayment + "'");
        Assert.assertTrue("Monthly repayment doesn't match expected value", actualMonthlyRepayment.equalsIgnoreCase( expectedMonthlyRepaymentField ) );
    }

    @When("^User walk-through the Quotation process filling all mandatory data \\(format1\\)$")
    public void userWalkThroughTheQuotationProcessFillingAllMandatoryData(Map<String, String> rawQuotationData) {

        landingPageData = new LandingPageData( rawQuotationData );
        openLeverIsQuoteLandingPage();
        checkUpToValue( landingPageData.getUpToAmount() );
        checkFromAmountPerMonth( landingPageData.getFromAmountPerMonth() );
        checkThatPaydayVALUEIsDisplayed( landingPageData.getPayDayLoanAmount() );

        userClickOnRedContinueButton();

        userSelectsAVALUEFromDropDownFieldLoanPurpose( landingPageData.getLoanPurpose() );
        usertypesAVALUEIntoNetMonthlyIncomeField( landingPageData.getNetMonthlyIncome() );
        usertypesAVALUEIntoMonthlyExpensesFiled( landingPageData.getMonthlyExpenses() );
        usertypesAVALUEIntoNumberOfDependentsField( landingPageData.getNumberOfDependents() );
        usertypesAVALUEIntoAmountToBorrowField( landingPageData.getAmountToBorrow() );

        userClickOnContinueButton();

        usertypesAVALUEIntoAmountToBorrowField( landingPageData.getAmountToBorrow() );
        userTypesAVALUEIntoMonthlyRepaymentFiled( landingPageData.getMonthlyRepayment() );
        checkThatVALUEIsInMonthlyRepaymentField( landingPageData.getMonthlyRepayment() );
        checkThatVALUEIsInAmountToBorrowField( landingPageData.getMonthlyRepayment() );

        userClicksOnApplyOnline();
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
    public void checkThatPaydayVALUEIsDisplayed(String expectedPaydayLoanAmount) {
        String actualPaydayLoanAmount = getPaydayLoanAmount();
        System.out.println("Payday loan amount Expected : '" + expectedPaydayLoanAmount + "'\n" +
                "                   Actual   : '" + actualPaydayLoanAmount + "'");
        Assert.assertTrue("from $ per month doesn't match expected value", actualPaydayLoanAmount.equalsIgnoreCase( expectedPaydayLoanAmount ) );
    }

    @Then("^User clicks on Apply Online$")
    public void userClicksOnApplyOnline() {
        quoteConfigurationPage.clickApplyOnline();
    }
}


