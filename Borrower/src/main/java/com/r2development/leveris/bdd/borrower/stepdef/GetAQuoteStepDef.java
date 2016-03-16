package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.QuoteData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.qa.utils.ACMExcel;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import com.r2development.leveris.utils.ExcelUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.openqa.selenium.TimeoutException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Singleton
public class GetAQuoteStepDef /*extends BorrowerStepDef*/ {

    private static final Log log = LogFactory.getLog(GetAQuoteStepDef.class);

    private boolean toSkip = false;
    private final SharedDriver webDriver;

    @Inject
    IUser user;
    IBorrowerHomePage borrowerHomePage;
    IWelcomePage welcomePage;
    IBuildQuotationPage buildQuotationPage;

    @Inject
    GetAQuoteStepDef(SharedDriver webDriver) {
//        formsMenu = new FormsMenu(WebDriverService.getWebDriverInstance());
//        super(webDriver);
        this.webDriver = webDriver;
        borrowerHomePage = new BorrowerHomePage(webDriver);
    }

    @Given("^Borrower clicks \"Quote\" task$")
    public void borrower_clicks_start_task() {
        borrowerHomePage.clickStartTaskButton();
    }

    @Given("^Borrower processes \"Get a Quote\" \\(format1\\)$")
    public void user_processes_get_quote(List<QuoteData> quoteDataList, String... test) {
        assertEquals("System is expecting only one QuoteData occurrence", quoteDataList.size(), 1);
        user_wants_to_get_a_quote_now();
        fill_in_quote_step1(quoteDataList.get(0));
        user_processes_2step3_to_get_a_quote();
        user_processes_3step3_to_get_a_quote();
    }

    @Given("^Borrower processes \"Get a Quote\" \\(format2\\)$")
//    public void user_processes_get_quote(Map<String, String> quoteDataMap) {
    public void user_processes_get_quote(List<String> quoteDataMap) {
        user_wants_to_get_a_quote_now();
        fill_in_quote_step1(new QuoteData(quoteDataMap));
        user_processes_2step3_to_get_a_quote();
        user_processes_3step3_to_get_a_quote();
    }

//    @Given("^Borrower processes \"Get a Quote\" \\(format2 with failure\\)$")
//    public void user_processes_get_quote_with_error_click(Map<String, String> quoteDataMap) {
//        user_wants_to_get_a_quote_now();
//        fill_in_quote_step1_failure(new QuoteData(quoteDataMap));
//        user_processes_2step3_to_get_a_quote();
//        user_processes_3step3_to_get_a_quote();
//    }

    private void fill_in_quote_step1(QuoteData quoteData) {
//        user_selects_number_of_borrowers(quoteData.getBorrowerNumber());
        user_clicks_number_of_borrowers(quoteData.getBorrowerNumber());
//        user_selects_mortgage_type(quoteData.getMortgageType());
        user_clicks_mortgage_type(quoteData.getMortgageType());
        user_types_his_age(quoteData.getBorrowerAge());
        if ( quoteData.getPartnerAge() != null )
            user_types_partner_age(quoteData.getPartnerAge());
        user_selects_his_marital_status(quoteData.getBorrowerMaritalStatus());
        user_types_his_total_of_dependants(quoteData.getBorrowerTotalDependants());
        user_selects_his_income_type(quoteData.getBorrowerIncomeType());
        user_types_his_income_amount(quoteData.getBorrowerIncomeAmount());
        if ( quoteData.getPartnerIncomeType() != null ) {
            user_selects_partner_income_type(quoteData.getPartnerIncomeType());
        }
        if ( quoteData.getPartnerIncomeAmount() != null )
            user_types_partner_income_amount(quoteData.getPartnerIncomeAmount());
        user_types_monthly_credit_commitments(quoteData.getMonthlyCreditCommitments());
        user_clicks_get_my_quote();
    }

//    private void fill_in_quote_step1_failure(QuoteData quoteData) {
//        user_selects_number_of_borrowers(quoteData.getBorrowerNumber());
//        user_selects_mortgage_type(quoteData.getMortgageType());
//        user_types_his_age(quoteData.getBorrowerAge());
//        if ( quoteData.getPartnerAge() != null )
//            user_types_partner_age(quoteData.getPartnerAge());
//        user_selects_his_marital_status(quoteData.getBorrowerMaritalStatus());
//        user_types_his_total_of_dependants(quoteData.getBorrowerTotalDependants());
//        user_selects_his_income_type(quoteData.getBorrowerIncomeType());
//        user_types_his_income_amount(quoteData.getBorrowerIncomeAmount());
//        if ( quoteData.getPartnerIncomeType() != null ) {
//            user_selects_partner_income_type(quoteData.getPartnerIncomeType());
//        }
//        if ( quoteData.getPartnerIncomeAmount() != null )
//            user_types_partner_income_amount(quoteData.getPartnerIncomeAmount());
//        user_types_monthly_credit_commitments(quoteData.getMonthlyCreditCommitments());
//        user_clicks_get_my_quote_failure();
//    }

    @When("^Borrower clicks on Get a quote or Get Started$")
    public void user_clicks_to_get_a_quote_or_get_started() throws Exception {
//        borrowerHomePage = new BorrowerHomePage(WebDriverService.getWebDriverInstance());
        borrowerHomePage = new BorrowerHomePage(webDriver);
        borrowerHomePage.clickGetQuoteOrGetStarted();
    }

    @When("^Borrower creates a quote")
    public void user_create_a_quote() {
//        welcomePage = new WelcomePage(WebDriverService.getWebDriverInstance());
        welcomePage = new WelcomePage(webDriver);
//        buildQuotationPage = welcomePage.clickQuote();
//        buildQuotationPage.clickGetQuoteNow();
    }

    @When("^Borrower clicks on \"Get a quote now\"$")
    public void user_clicks_on_get_a_quote_now() {
//        buildQuotationPage = welcomePage.clickQuote();
//        buildQuotationPage.clickGetQuoteNow();
    }

    @And("^Borrower wants to get a quote now$")
    public void user_wants_to_get_a_quote_now() {
        
        
        
        try {
            borrowerHomePage.closePopup();
        } catch ( TimeoutException te) {
            log.info("Popup is not displayed as it's not mandatory within the workflow...");
        }

        // Do we still need this ?
//        try {
//
//            borrowerHomePage.clickGetQuoteOrGetStarted();
//        } catch (Exception e) {
//            log.error("Problem of clicking Get Quote link or Get Started link.");
//        }

        borrowerHomePage.clickGetOneNow();
//        buildQuotationPage = new BuildQuotationPage(WebDriverService.getWebDriverInstance());
        buildQuotationPage = new BuildQuotationPage(webDriver);
        buildQuotationPage.clickGetQuoteNow();
    }

    @Then("^Borrower processes \"Get a Quote\"$")
    public void user_processes_get_quote() {
        user_wants_to_get_a_quote_now();
        user_processes_1step3_to_get_a_quote();
        user_processes_2step3_to_get_a_quote();
        user_processes_3step3_to_get_a_quote();
    }

    @And("^Borrower processes 1st step of 3 to get a quote$")
    public void user_processes_1step3_to_get_a_quote() {

        // TODO extract data from excel
        Map<String, String> quotationData = null;
        if ( StringUtils.isNotEmpty(System.getProperty("excel_filename")) ) {
            MatcherAssert.assertThat("File should exist", ExcelUtils.checkExcelExists(), Is.is(true));

            try {
//                quotationData = ACMExcel.loadDataToMap(QUOTATION.getSheetname(), ExcelUtils.getAbsolutePath());
                quotationData = ACMExcel.loadDataToMap(ExcelSheetVerificator.QUOTATION_sheetName.getSheetName(), ExcelUtils.getAbsolutePath());
            } catch (IOException e) {
                log.error("ACMExcel's problem of loading Data to Map ...");
            } catch (Exception e) {
                e.printStackTrace();
            }


            assertNotNull(quotationData);
            assertEquals("Excel is not the good one to run our current automation framework.", quotationData.size(), 11);

            user_selects_number_of_borrowers(quotationData.get("Number of Borrowers"));
            user_selects_mortgage_type(quotationData.get("Mortgage Type"));
            user_types_his_age(quotationData.get("First Borrower Age"));
            user_types_partner_age(quotationData.get("Second Borrower Age"));
            user_selects_his_marital_status(quotationData.get("Borrowers Marital Status"));
            user_types_his_total_of_dependants(quotationData.get("Number of Dependants"));
            user_selects_his_income_type(quotationData.get("Income Type First Borrower"));
            user_types_his_income_amount(quotationData.get("Income Amount First Borrower"));
            user_selects_partner_income_type(quotationData.get("Income Type Second Borrower"));
            user_types_partner_income_amount(quotationData.get("Income Amount Second Borrower"));
            user_types_monthly_credit_commitments(quotationData.get("Other Financial Commitments"));

        }
        else {
            user_selects_number_of_borrowers("two borrowers");
            user_selects_mortgage_type("first-time buyer(s)");
            user_types_his_age("22");
            user_types_partner_age("20");
            user_selects_his_marital_status("single");
            user_types_his_total_of_dependants("1");
            user_selects_his_income_type("an employee");
            user_types_his_income_amount("300000");
            user_selects_partner_income_type("an employee");
            user_types_partner_income_amount("300000");
            user_types_monthly_credit_commitments("2000");
        }

        user_clicks_get_my_quote();
    }

    @And("^Borrower processes 2nd step of 3 to get a quote$")
    public void user_processes_2step3_to_get_a_quote() {
        user_clicks_configure_loan();
    }

    @And("^Borrower processes 3rd step of 3 to get a quote$")
    public void user_processes_3step3_to_get_a_quote() {
        user_clicks_apply_now();
    }

    @And("^Borrower selects (a single borrower|two borrowers) as number of borrowers")
    public void user_selects_number_of_borrowers(String nbBorrowers) {
        buildQuotationPage.selectNumberOfBorrower(nbBorrowers);
    }

    @And("^Borrower clicks (a single borrower|two borrowers) as number of borrowers$")
//    @And("^Borrower clicks \"(Single|Joint) Borrower\" as number of borrowers$")
    public void user_clicks_number_of_borrowers(String nbBorrowers) {
        buildQuotationPage.clickNumberOfBorrower(nbBorrowers);
    }

    @And("^Borrower selects (first-time buyer\\(s\\)|mover\\(s\\)) as mortgage type$")
    public void user_selects_mortgage_type(String mortgageType) {
        buildQuotationPage.selectMortgageType(mortgageType);
    }

    @And("^Borrower clicks (first-time buyer\\(s\\)|mover\\(s\\)) as mortgage type$")
//    @And("^Borrower clicks (first time buyer|mover) as mortgage type$")
    public void user_clicks_mortgage_type(String mortgageType) {
        buildQuotationPage.clickMortgageType(mortgageType);
    }

    @And("^Borrower types (.*) as age$")
    public void user_types_his_age(String age) {
        buildQuotationPage.typeAge(age);
    }

    @And("^Borrower types (.*) as partner\'s age")
    public void user_types_partner_age(String age) {
        buildQuotationPage.typePartnerAge(age);
    }

    @And("^Borrower selects (single|separated|married/civil partner\\(s\\)|divorced/dissolved civil partnership|widowed) as marital status$")
    public void user_selects_his_marital_status(String maritalStatus) {
        buildQuotationPage.selectMaritalStatus(maritalStatus);
    }

    @And("^Borrower types (.*) as total of dependants$")
    public void user_types_his_total_of_dependants(String totalDependants) {
        if ( StringUtils.isEmpty(totalDependants) )
            totalDependants = "0";
        buildQuotationPage.typeTotalDependants(totalDependants);
    }

    @And("^Borrower selects (an employee|a civil servant|self employed|not in paid work just now) as income type$")
    public void user_selects_his_income_type(String incomeType) {
        buildQuotationPage.selectIncomeType(incomeType);
    }

    @And("^Borrower types (.*) as income amount$")
    public void user_types_his_income_amount(String incomeAmount) {
        buildQuotationPage.typeIncomeAmount(incomeAmount);
    }

    @And("^Borrower selects (\\s*|an employee|a civil servant|self employed|not in paid work just now) as partner\'s income type$")
    public void user_selects_partner_income_type(String incomeType){
        buildQuotationPage.selectPartnerIncomeType(incomeType);
    }

    @And("^Borrower types (.*) as partner\'s income amount$")
    public void user_types_partner_income_amount(String incomeAmount) {
        buildQuotationPage.typePartnerIncomeAmount(incomeAmount);
    }

    @And("^Borrower types (.*) as monthly credit commitments$")
    public void user_types_monthly_credit_commitments(String monthlyCreditCommitments) {
        buildQuotationPage.typeMonthlyCreditCommitments(monthlyCreditCommitments);
    }

    @And("^Borrower clicks \"GET MY QUOTE\"$")
    public void user_clicks_get_my_quote() {
        buildQuotationPage.clickGetQuote();
    }

//    @And("^Borrower clicks \"GET MY QUOTE\" with failure$")
//    public void user_clicks_get_my_quote_failure() {
//        buildQuotationPage.clickGetQuoteFailure();
//    }

    @And("^Borrower is(\\s*|n't) eligible to borrow at this time$")
    public void user_is_eligible_to_borrow_at_this_time(String isEligible) {
        if ( StringUtils.isEmpty(isEligible) ) {
            assertThat("we are expected that user is eligible.", buildQuotationPage.isEligible(), Is.is(true) );
            toSkip = false;
        }
        else {
            assertThat("we are expected that user is not eligible.", buildQuotationPage.isEligible(), Is.is(false) );
            toSkip = true; // skip is a keyword :p also toSkip ?
        }
    }

    @And("^Borrower clicks \"CONFIGURE LOAN\"$")
    public void user_clicks_configure_loan() {
        buildQuotationPage.clickConfigureLoan();
    }

    @And("^Borrower clicks \"APPLY NOW\"$")
    public void user_clicks_apply_now() {
        buildQuotationPage.clickApplyNow();
    }

    @And("^Borrower clicks \"E-MAIL QUOTE\"$")
    public void user_clicks_email_quote() {
        buildQuotationPage.clickEmailQuote();
    }

    @And("^Borrower clicks \"EDIT YOUR DETAILS\"$")
    public void user_clicks_edit_details() {
        buildQuotationPage.clickEditDetails();
    }

    @Then("^Borrower could buy a home up to the value of (.*) euros$")
    public void user_could_build_a_home_up_to_value(String maxLoanAmount) {
        if ( !toSkip ) {
            int roundedMaxLoanAmount = Math.round(Float.parseFloat(buildQuotationPage.getAffordabilityAmount().replaceAll(",", "").replace("€", "").trim()));
            assertThat("Expected max loan amount is incorrect",
                    String.valueOf(roundedMaxLoanAmount),
                    Is.is(maxLoanAmount)
            );
        }
    }

    @Then("^Borrower should pay monthly (.*) euros$")
    public void user_should_pay_monthly(String monthlyPayment) {
        if ( !toSkip ) {
            int roundedMonthlyPayment = Math.round(Float.parseFloat(buildQuotationPage.getAffordabilityMonthly().replaceAll(",", "").replace("€", "")));
            assertThat("Expected monthly payment is incorrect",
                    String.valueOf(roundedMonthlyPayment),
                    Is.is(monthlyPayment)
            );
        }
    }

    @Then("^Borrower should get a minimum deposit value of (.*) euros$")
    public void user_should_get_minimum_deposit_of(String minimumDeposit) {
        if ( !toSkip ) {
            int roundedMinimumDeposit = Math.round(Float.parseFloat(buildQuotationPage.getAffordabilityFunds().replaceAll("\\(", "").replaceAll("\\)", "").replace("€", "").replace(",", "").concat(".00")));
            assertThat("Expected minimum  deposit is incorrect",
                   String.valueOf(roundedMinimumDeposit),
                   Is.is(minimumDeposit)
            );
        }
    }

    @And("^Borrower clicks \"Review and Submit\"$")
    public void user_clicks_review_and_submit() {
        borrowerHomePage = new BorrowerHomePage(webDriver);
        borrowerHomePage.clickReviewAndSubmit();
    }

    @And("^Borrower clicks \"Submit your application\"$")
    public void user_clicks_submit_your_application() {
        borrowerHomePage.clickSubmitYourApplication();
    }

    @And("^Borrower checks \"Distance Marketing\"$")
    public void user_checks_DistanceMarketing() {
        borrowerHomePage.checkDistanceMarketing();
    }

    @And("^Borrower checks \"Statutory\"$")
    public void user_checks_Statutory() {
        borrowerHomePage.checkStatutory();
    }

    @And("^Borrower checks \"Declaration\"$")
    public void user_checks_Declaration() {
        borrowerHomePage.checkDeclaration();
    }

    @And("^Borrower checks \"Fraud Credit check\"$")
    public void user_checks_fraud_credit_check() {
        borrowerHomePage.checkCreditFraud();
    }

    @And("^finally, Borrower clicks \"Submit Application\"$")
    public void user_clicks_submit_application_final() {
        borrowerHomePage.clickFinalSubmitApplication();
    }

}
