package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.FinancialData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

@Singleton
public class YourFinancialCommitmentsStepDef /*extends BorrowerStepDef*/ /*implements CLV312Workaround*/ {

    private static final Log log = LogFactory.getLog(YourFinancialCommitmentsStepDef.class.getName());

    private SharedDriver webDriver;
    @Inject
    private IUser user;

    private IBorrowerHomePage borrowerHomePage;
    private IPersonalDetailsPage borrowerPersonalDetailsPage;
    private IYourFinancialCommitmentsPage yourFinancialCommitmentsPage;
    private IFormsMenu formsMenu;

    @Inject
    public YourFinancialCommitmentsStepDef(SharedDriver webDriver) {
        yourFinancialCommitmentsPage = new YourFinancialCommitmentsPage(webDriver);
    }

    @Given("^(Borrower) fills in (Personal Loan|Credit Card|Maintenance Payment|Other|Car Loan|Student Loan|Rent|Utilities|Childcare|Mortgage)$")
    public void user_fills_in_financial(String userType, String formType, List<String> financialListData) {
        FinancialData financialData = new FinancialData(financialListData);

        Assert.assertEquals("Form Type from table under step definition do not match the financial commitment in the step definition", formType, financialData.getFormType());

        user_clicks_financial_loan_type(userType, financialData.getFormType());

        switch (financialData.getFormType()) {
            case "Personal Loan":
                yourFinancialCommitmentsPage.typePersonalOutstandingBalanceAmount(financialData.getOutstandingAmount());
                yourFinancialCommitmentsPage.typePersonalFinancialInstitution(financialData.getFinancialInstitution());
                yourFinancialCommitmentsPage.typePersonalLoanPurpose(financialData.getPurposeOfTheLoan());
                yourFinancialCommitmentsPage.typePersonalFinalRepaymentDate(financialData.getFinalRepaymentDate());
                yourFinancialCommitmentsPage.selectPersonalPaymentFrequency(financialData.getPaymentFrequency());
                yourFinancialCommitmentsPage.typePersonalRepaymentAmount(financialData.getRepaymentAmount());
                break;
            case "Credit Card":
                yourFinancialCommitmentsPage.typeCreditcRepaymentAmount(financialData.getRepaymentAmount());
                yourFinancialCommitmentsPage.typeCreditcProvider(financialData.getCardProvider());
                yourFinancialCommitmentsPage.selectCreditcType(financialData.getCardType());
                yourFinancialCommitmentsPage.typeCreditcLimit(financialData.getCardLimit());
                yourFinancialCommitmentsPage.typeCreditcBalance(financialData.getCardBalance());
                break;
            case "Maintenance Payment":
                yourFinancialCommitmentsPage.typeMaintenancepPayment(financialData.getMonthlyMaintenancePayment());
                break;
            case "Other":
                yourFinancialCommitmentsPage.typeOtherRepaymentAmount(financialData.getRepaymentAmount());
                yourFinancialCommitmentsPage.typeOtherValue(financialData.getValue());
                yourFinancialCommitmentsPage.typeOtherDescription(financialData.getDescription());
                break;
            case "Car Loan":
                yourFinancialCommitmentsPage.typeCarOutstandingBalanceAmount(financialData.getOutstandingAmount());
                yourFinancialCommitmentsPage.typeCarFinancialInstitution(financialData.getFinancialInstitution());
                yourFinancialCommitmentsPage.typeCarFinalRepaymentDate(financialData.getFinalRepaymentDate());
                yourFinancialCommitmentsPage.selectCarPaymentFrequency(financialData.getPaymentFrequency());
                yourFinancialCommitmentsPage.typeCarRepaymentAmount(financialData.getRepaymentAmount());
                break;
            case "Student Loan":
                yourFinancialCommitmentsPage.typeStudentOutstandingBalanceAmount(financialData.getOutstandingAmount());
                yourFinancialCommitmentsPage.typeStudentFinancialInstitution(financialData.getFinancialInstitution());
                yourFinancialCommitmentsPage.typeStudentFinalRepaymentDate(financialData.getFinalRepaymentDate());
                yourFinancialCommitmentsPage.selectStudentPaymentFrequency(financialData.getPaymentFrequency());
                yourFinancialCommitmentsPage.typeStudentRepaymentAmount(financialData.getRepaymentAmount());
                break;
            case "Rent":
                //optional
                yourFinancialCommitmentsPage.selectRentPaymentFrequency(financialData.getPaymentFrequency());
                yourFinancialCommitmentsPage.typeRentRepaymentAmount(financialData.getRepaymentAmount());
                //optional
                yourFinancialCommitmentsPage.typeRentNote(financialData.getNote());
                break;
            case "Utilities":
                //optional
                yourFinancialCommitmentsPage.selectUtilitiesPaymentFrequency(financialData.getPaymentFrequency());
                yourFinancialCommitmentsPage.typeUtilitiesRepaymentAmount(financialData.getRepaymentAmount());
                //optional
                yourFinancialCommitmentsPage.typeUtilitiesNote(financialData.getNote());
                break;
            case "Childcare":
                //optional
                yourFinancialCommitmentsPage.selectChildCarePaymentFrequency(financialData.getPaymentFrequency());
                yourFinancialCommitmentsPage.typeChildCareRepaymentAmount(financialData.getRepaymentAmount());
                //optional
                yourFinancialCommitmentsPage.typeChildCareNote(financialData.getNote());
                break;
            case "Mortgage":
                yourFinancialCommitmentsPage.typeMortgageOutstandingBalanceAmount(financialData.getOutstandingAmount());
                yourFinancialCommitmentsPage.typeMortgageFinancialInstitution(financialData.getFinancialInstitution());
                //optional
                yourFinancialCommitmentsPage.typeMortgageFinalRepaymentDate(financialData.getFinalRepaymentDate());
                yourFinancialCommitmentsPage.typeMortgageRepaymentAmount(financialData.getRepaymentAmount());
                break;
            default:
        }
        yourFinancialCommitmentsPage.clickSaveAndClose();
    }

    @When("^Borrower has(n't)? financial commitments$")
    public void user_has_financial_commitments(String hasCommitments) throws InterruptedException {

        if (hasCommitments == null) {
//            yourFinancialCommitmentsPage.clickSingleYes();
        }
        else {
//            yourFinancialCommitmentsPage.clickSingleNo();
            yourFinancialCommitmentsPage.clickNone();
            yourFinancialCommitmentsPage.clickNext();
        }
    }

    @Given("^(Borrower) selects (Personal Loan|Credit Card|Maintenance Payment|Other|Car Loan|Student Loan|Rent|Utilities|Childcare|Mortgage) as his financial commitment$")
    public void user_clicks_financial_loan_type(String usertType, String financialTypeLoan) {
        yourFinancialCommitmentsPage.clickFinancialType(financialTypeLoan);
    }

    @When("^(Borrower) clicks Financial I have none$")
    public void user_clicks_i_have_none(String usertType) {
        yourFinancialCommitmentsPage.clickNone();
    }

    @When("^(Borrower) clicks Financial Cancel")
    public void user_clicks_financial_cancel(String usertType) {
        yourFinancialCommitmentsPage.clickCancel();
    }

    @When("^(Borrower) clicks Financial Save and Close")
    public void user_clicks_financial_save_and_close(String usertType) {
        yourFinancialCommitmentsPage.clickSaveAndClose();
    }

    @When("^(Borrower) clicks Financial Edit")
    public void user_clicks_financial_edit(String usertType) {
        yourFinancialCommitmentsPage.clickEdit();
    }

    @When("^(Borrower) clicks financial Delete$")
    public void user_clicks_financial_delete(String usertType) {
        yourFinancialCommitmentsPage.clickDelete();
    }

    @When("^(Borrower) clicks financial Done$")
    public void user_clicks_financial_done(String usertType) {
        yourFinancialCommitmentsPage.clickDone();
    }

    @When("^(Borrower) clicks financial Add$")
    public void user_clicks_financial_add(String usertType) {
        yourFinancialCommitmentsPage.clickAdd();
    }

    @And("^(Borrower) clicks financial \"NEXT\"$")
    public void user_clicks_financial_next(String usertType) {
        yourFinancialCommitmentsPage.clickNext();
    }

    @When("^(Borrower) clicks financial Wait I have...$")
    public void user_clicks_financial_wait_i_have(String usertType) {
        yourFinancialCommitmentsPage.clickWaitIHave();
    }

    @And("^(Borrower) types Personal OustandingBalalnceAmount : (.*)$")
    public void user_types_personal_oustanding_balance_amount(String usertType, String outstandingBalanceAmount) {
        yourFinancialCommitmentsPage.typePersonalOutstandingBalanceAmount(outstandingBalanceAmount);
    }

    @And("^(Borrower) types Personal Financial Institution : (.*)$")
    public void user_types_personal_financial_institution(String usertType, String financialInstitution) {
        yourFinancialCommitmentsPage.typePersonalFinancialInstitution(financialInstitution);
    }

    @And("^(Borrower) types Personal Loan Purpose : (.*)$")
    public void user_types_personal_loan_purpose(String usertType, String loanPurpose) {
        yourFinancialCommitmentsPage.typePersonalLoanPurpose(loanPurpose);
    }

    @And("^(Borrower) types Personal final repayment date : (.*)$")
    public void user_types_personal_final_repayment_date(String usertType, String finalRepaymentDate) {
        yourFinancialCommitmentsPage.typePersonalFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^(Borrower) selects Personal payment frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selcts_personal_payment_frequency(String usertType, String paymentFrequency) {
        yourFinancialCommitmentsPage.selectPersonalPaymentFrequency(paymentFrequency);
    }

    @And("^(Borrower) types Personal repayment amount : (.*)$")
    public void user_types_personal_repayment_amount(String usertType, String repaymentAmount) {
        yourFinancialCommitmentsPage.typePersonalRepaymentAmount(repaymentAmount);
    }

    @And("^(Borrower) types Credit Card repayment amount : (.*)$")
    public void user_types_credit_card_repayment_amount(String usertType, String repaymentAmount) {
        yourFinancialCommitmentsPage.typeCreditcRepaymentAmount(repaymentAmount);
    }

    @And("^(Borrower) types Credit Card provider : (.*)$")
    public void user_types_credit_card_provider(String usertType, String provider) {
        yourFinancialCommitmentsPage.typeCreditcProvider(provider);
    }

    @And("^(Borrower) selects Credit Card type : (VISA|Mastercard|American Express|Store Card|Other)$")
    public void user_selects_credit_card_type(String usertType, String type) {
        yourFinancialCommitmentsPage.selectCreditcType(type);
    }

    @And("^(Borrower) types Credit Card limit : (.*)$")
    public void user_types_credit_care_limit(String usertType, String limit) {
        yourFinancialCommitmentsPage.typeCreditcLimit(limit);
    }

    @And("^(Borrower) types Credit Card balance : (.*)$")
    public void user_types_credit_card_balance(String usertType, String balance) {
        yourFinancialCommitmentsPage.typeCreditcBalance(balance);
    }

    @And("^(Borrower) types Maintenance payment : (.*)$")
    public void user_types_maintenance_payment(String usertType, String payment) {
        yourFinancialCommitmentsPage.typeMaintenancepPayment(payment);
    }

    @And("^(Borrower) types Other repayment amount : (.*)$")
    public void user_types_other_repayment_amount(String usertType, String repaymentAmount) {
        yourFinancialCommitmentsPage.typeOtherRepaymentAmount(repaymentAmount);
    }

    @And("^(Borrower) types Other value : (.*)$")
    public void user_types_other_value(String usertType, String value) {
        yourFinancialCommitmentsPage.typeOtherValue(value);
    }

    @And("^(Borrower) types Other description : (.*)$")
    public void user_types_other_description(String usertType, String description) {
        yourFinancialCommitmentsPage.typeOtherDescription(description);
    }

    @And("^(Borrower) types Car outstanding balance amount : (.*)$")
    public void user_types_car_outstanding_balance_amount(String usertType, String outstandingBalanceAmount) {
        yourFinancialCommitmentsPage.typeCarOutstandingBalanceAmount(outstandingBalanceAmount);
    }

    @And("^(Borrower) types Car financial institution : (.*)$")
    public void user_types_car_financial_institution(String usertType, String financialInstitution) {
        yourFinancialCommitmentsPage.typeCarFinancialInstitution(financialInstitution);
    }

    @And("^(Borrower) types Car final Repayment Date : (.*)$")
    public void user_types_car_final_repayment_date(String usertType, String finalRepaymentDate) {
        yourFinancialCommitmentsPage.typeCarFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^(Borrower) selects Car Payment Frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selects_car_payment_frequency(String usertType, String paymentFrequency) {
        yourFinancialCommitmentsPage.selectCarPaymentFrequency(paymentFrequency);
    }

    @And("^(Borrower) types Card repayment amount : (.*)$")
    public void user_types_card_repayment_amount(String usertType, String repaymentAmount) {
        yourFinancialCommitmentsPage.typeCarRepaymentAmount(repaymentAmount);
    }

    @And("^(Borrower) types Student outstanding balance amount : (.*)$")
    public void user_types_student_outstanding_balance_amount(String usertType, String outstandingBalanceAmount) {
        yourFinancialCommitmentsPage.typeStudentOutstandingBalanceAmount(outstandingBalanceAmount);
    }

    @And("^(Borrower) types Student financial institution : (.*)$")
    public void user_types_student_financial_institution(String usertType, String financialInstitution) {
        yourFinancialCommitmentsPage.typeStudentFinancialInstitution(financialInstitution);
    }

    @And("^(Borrower) types Student final repayment date : (.*)$")
    public void user_types_student_final_repayment_date(String usertType, String finalRepaymentDate) {
        yourFinancialCommitmentsPage.typeStudentFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^(Borrower) selects Student payment frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selects_studeent_payment_frequency(String usertType, String paymentFrequency) {
        yourFinancialCommitmentsPage.selectStudentPaymentFrequency(paymentFrequency);
    }

    @And("^(Borrower) types Student repayment amount : (.*)$")
    public void user_types_student_repayment_amount(String usertType, String repaymentAmount) {
        yourFinancialCommitmentsPage.typeStudentRepaymentAmount(repaymentAmount);
    }

//    rent
    @And("^(Borrower) selects Rent Payment Frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selects_rent_payment_frequency(String usertType, String repaymentFrequency) {
        //optional
        yourFinancialCommitmentsPage.selectRentPaymentFrequency(repaymentFrequency);
    }

    @And("^(Borrower) types Rent Repayment Amount : (.*)$")
    public void user_types_rent_repayment_amount(String usertType, String repaymentAmount) {
        yourFinancialCommitmentsPage.typeRentRepaymentAmount(repaymentAmount);
    }

    @And("^(Borrower) types Rent note : (.*)$")
    public void user_types_rent_note(String usertType, String note) {
        //optional
        yourFinancialCommitmentsPage.typeRentNote(note);
    }

//    utilities
    @And("^(Borrower) types Utilities payment frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_types_utilities_payment_frequency(String usertType, String paymentFrequency) {
        //optional
        yourFinancialCommitmentsPage.selectUtilitiesPaymentFrequency(paymentFrequency);
    }

    @And("^(Borrower) types Utilities Repayment Amount : (.*)$")
    public void user_types_utilities_repayment_amount(String usertType, String repaymentAmount) {
        yourFinancialCommitmentsPage.typeUtilitiesRepaymentAmount(repaymentAmount);
    }

    @And("^(Borrower) types Utilities note : (.*)$")
    public void user_types_utilities_note(String usertType, String note) {
        //optional
        yourFinancialCommitmentsPage.typeUtilitiesNote(note);
    }

//    childcare
    @And("^(Borrower) selects Child Care Payment Frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_types_child_care_payment_frequency(String usertType, String paymentFrequency) {
        //optional
        yourFinancialCommitmentsPage.selectChildCarePaymentFrequency(paymentFrequency);
    }

    @And("^(Borrower) types Child Care Repayment Amount : (.*)$")
    public void user_types_child_care_repayment_amount(String usertType, String repaymentAmount) {
        yourFinancialCommitmentsPage.typeChildCareRepaymentAmount(repaymentAmount);
    }

    @And("^(Borrower) types Child Care note: (.*)$")
    public void user_types_child_care_note(String usertType, String note) {
        //optional
        yourFinancialCommitmentsPage.typeChildCareNote(note);
    }

//    mortgage
    @And("^(Borrower) types Mortgage Outstanding Balance Amount : (.*)$")
    public void user_types_mortgage_outstanding_balance_amount(String usertType, String outstandingBalanceAmount) {
        yourFinancialCommitmentsPage.typeMortgageOutstandingBalanceAmount(outstandingBalanceAmount);
    }

    @And("^(Borrower) types Mortgage Financial Institution : (.*)$")
    public void user_types_mortgage_financial_institution(String usertType, String financialInstitution) {
        yourFinancialCommitmentsPage.typeMortgageFinancialInstitution(financialInstitution);
    }

    @And("^(Borrower) types Mortgage Final Repayment Date : (.*)$")
    public void user_types_mortgage_final_repayment_date(String usertType, String finalRepaymentDate) {
        //optional
        yourFinancialCommitmentsPage.typeMortgageFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^(Borrower) types Mortgage Repayment Amount: (.*)$")
    public void user_types_mortgage_repayment_amount(String usertType, String repaymentAmount) {
        yourFinancialCommitmentsPage.typeMortgageRepaymentAmount(repaymentAmount);
    }

    @And("^Borrower clicks on Financial commitments link$")
    public void borrower_clicks_on_financial_commitments_link(){
        formsMenu = new FormsMenu(webDriver);
        formsMenu.clickFinancialCommitments();
    }

}
