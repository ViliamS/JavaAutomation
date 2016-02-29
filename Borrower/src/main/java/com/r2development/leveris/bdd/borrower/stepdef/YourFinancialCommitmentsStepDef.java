package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.FinancialData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.IBorrowerHomePage;
import com.r2development.leveris.selenium.borrower.pageobjects.IPersonalDetailsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.IYourFinancialCommitmentsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.YourFinancialCommitmentsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.util.List;

@Singleton
public class YourFinancialCommitmentsStepDef /*extends BorrowerStepDef*/ /*implements CLV312Workaround*/ {

    private static final Log log = LogFactory.getLog(YourFinancialCommitmentsStepDef.class);

    private WebDriver webDriver;
    private IUser user;

    private IBorrowerHomePage borrowerHomePage;
    private IPersonalDetailsPage borrowerPersonalDetailsPage;
    private IYourFinancialCommitmentsPage yourFinancialCommitmentsPage;

    @Inject
    public YourFinancialCommitmentsStepDef(WebDriver webDriver) {
        yourFinancialCommitmentsPage = new YourFinancialCommitmentsPage(webDriver);
    }

    @Given("^user fills in \"Financial forn\"$")
    public void user_fills_in_financial(List<String> financialListData) {
        FinancialData financialData = new FinancialData(financialListData);

        user_clicks_financial_loan_type(financialData.get("financialType"));
        switch (financialData.get("financialType")) {
            case "Personal":
                yourFinancialCommitmentsPage.typePersonalOutstandingBalanceAmount(financialData.get("outstandingBalanceAmount"));
                yourFinancialCommitmentsPage.typePersonalFinancialInstitution(financialData.get("financialInstitution"));
                yourFinancialCommitmentsPage.typePersonalLoanPurpose(financialData.get("loanPurpose"));
                yourFinancialCommitmentsPage.typePersonalFinalRepaymentDate(financialData.get("finalRepaymentDate"));
                yourFinancialCommitmentsPage.selectPersonalPaymentFrequency(financialData.get("paymentFrequency"));
                yourFinancialCommitmentsPage.typePersonalRepaymentAmount(financialData.get("repaymentAmount"));
                break;
            case "Credit Card":
                yourFinancialCommitmentsPage.typeCreditcRepaymentAmount(financialData.get("repaymentAmount"));
                yourFinancialCommitmentsPage.typeCreditcProvider(financialData.get("provider"));
                yourFinancialCommitmentsPage.selectCreditcType(financialData.get("type"));
                yourFinancialCommitmentsPage.typeCreditcLimit(financialData.get("limit"));
                yourFinancialCommitmentsPage.typeCreditcBalance(financialData.get("balance"));
                break;
            case "Maintenance Payment":
                yourFinancialCommitmentsPage.typeMaintenancepPayment(financialData.get("payment"));
                break;
            case "Other":
                yourFinancialCommitmentsPage.typeOtherRepaymentAmount(financialData.get("repaymentAmount"));
                yourFinancialCommitmentsPage.typeOtherValue(financialData.get("value"));
                yourFinancialCommitmentsPage.typeOtherDescription(financialData.get("description"));
                break;
            case "Car":
                yourFinancialCommitmentsPage.typeCarOutstandingBalanceAmount(financialData.get("outstandingBalanceAmount"));
                yourFinancialCommitmentsPage.typeCarFinancialInstitution(financialData.get("financialInstitution"));
                yourFinancialCommitmentsPage.typeCarFinalRepaymentDate(financialData.get("finalRepaymentDate"));
                yourFinancialCommitmentsPage.selectCarPaymentFrequency(financialData.get("paymentFrequency"));
                yourFinancialCommitmentsPage.typeCarRepaymentAmount(financialData.get("repaymentAmount"));
                break;
            case "Student":
                yourFinancialCommitmentsPage.typeStudentOutstandingBalanceAmount(financialData.get("outstandingBalanceAmount"));
                yourFinancialCommitmentsPage.typeStudentFinancialInstitution(financialData.get("financialInstitution"));
                yourFinancialCommitmentsPage.typeStudentFinalRepaymentDate(financialData.get("finalRepaymentDate"));
                yourFinancialCommitmentsPage.selectStudentPaymentFrequency(financialData.get("paymentFrequency"));
                yourFinancialCommitmentsPage.typeStudentRepaymentAmount(financialData.get("repaymentAmount"));
                break;
            case "Rent":
                //optional
                yourFinancialCommitmentsPage.selectRentPaymentFrequency(financialData.get("repaymentFrequency"));
                yourFinancialCommitmentsPage.typeRentRepaymentAmount(financialData.get("repaymentAmount"));
                //optional
                yourFinancialCommitmentsPage.typeRentNote(financialData.get("note"));
                break;
            case "Utilities":
                //optional
                yourFinancialCommitmentsPage.selectUtilitiesPaymentFrequency(financialData.get("paymentFrequency"));
                yourFinancialCommitmentsPage.typeUtilitiesRepaymentAmount(financialData.get("repaymentAmount"));
                //optional
                yourFinancialCommitmentsPage.typeUtilitiesNote(financialData.get("note"));
                break;
            case "Child Care":
                //optional
                yourFinancialCommitmentsPage.selectChildCarePaymentFrequency(financialData.get("paymentFrequency"));
                yourFinancialCommitmentsPage.typeChildCareRepaymentAmount(financialData.get("repaymentAmount"));
                //optional
                yourFinancialCommitmentsPage.typeChildCareNote(financialData.get("note"));
                break;
            case "Mortgage":
                yourFinancialCommitmentsPage.typeMortgageOutstandingBalanceAmount(financialData.get("outstandingBalanceAmount"));
                yourFinancialCommitmentsPage.typeMortgageFinancialInstitution(financialData.get("financialInstitution"));
                //optional
                yourFinancialCommitmentsPage.typeMortgageFinalRepaymentDate(financialData.get("finalRepaymentDate"));
                yourFinancialCommitmentsPage.typeMortgageRepaymentAmount(financialData.get("repaymentAmount"));
                break;
            default:

        }
    }

    @When("^user has(n't)? financial commitments$")
    public void user_has_financial_commitments(String hasCommitments) throws InterruptedException {
//        workaroundCLV312(null);

        if (hasCommitments == null) {
//            yourFinancialCommitmentsPage.clickSingleYes();
        }
        else {
//            yourFinancialCommitmentsPage.clickSingleNo();
            yourFinancialCommitmentsPage.clickNone();
            yourFinancialCommitmentsPage.clickNext();
        }
    }

    @Given("^user clicks Financial (Personal|Credit Card|Maintenance Payment|Other|Car|Studen|Rent|Utilities|ChildCare|Mortgage) Loan$")
    public void user_clicks_financial_loan_type(String financialTypeLoan) {
        yourFinancialCommitmentsPage.clickFinancialType(financialTypeLoan);
    }

    @When("^user clicks Financial I have none$")
    public void user_clicks_i_have_none() {
        yourFinancialCommitmentsPage.clickNone();
    }

    @When("^user clicks Financial Cancel")
    public void user_clicks_financial_cancel() {
        yourFinancialCommitmentsPage.clickCancel();
    }

    @When("^user clicks Financial Save and Close")
    public void user_clicks_financial_save_and_close() {
        yourFinancialCommitmentsPage.clickSaveAndClose();
    }

    @When("^user clicks Financial Edit")
    public void user_clicks_financial_edit() {
        yourFinancialCommitmentsPage.clickEdit();
    }

    @When("^user clicks financial Delete$")
    public void user_clicks_financial_delete() {
        yourFinancialCommitmentsPage.clickDelete();
    }

    @When("^user clicks financial Done$")
    public void user_clicks_financial_done() {
        yourFinancialCommitmentsPage.clickDone();
    }

    @When("^user clicks financial Add$")
    public void user_clicks_financail_add() {
        yourFinancialCommitmentsPage.clickAdd();
    }

    @And("^user clicks financial \"NEXT\"$")
    public void user_clicks_financial_next() {
        yourFinancialCommitmentsPage.clickNext();
    }

    @When("^user clicks financial Wait I have...$")
    public void user_clicks_financial_wait_i_have() {
        yourFinancialCommitmentsPage.clickWaitIHave();
    }

    @And("^user types Personal OustandingBalalnceAmount : (.*)$")
    public void user_types_personal_oustanding_balance_amount(String outstandingBalanceAmount) {
        yourFinancialCommitmentsPage.typePersonalOutstandingBalanceAmount(outstandingBalanceAmount);
    }

    @And("^user types Personal Financial Institution : (.*)$")
    public void user_types_personal_financial_institution(String financialInstitution) {
        yourFinancialCommitmentsPage.typePersonalFinancialInstitution(financialInstitution);
    }

    @And("^user types Personal Loan Purpose : (.*)$")
    public void user_types_personal_loan_purpose(String loanPurpose) {
        yourFinancialCommitmentsPage.typePersonalLoanPurpose(loanPurpose);
    }

    @And("^user types Personal final repayment date : (.*)$")
    public void user_types_personal_final_repayment_date(String finalRepaymentDate) {
        yourFinancialCommitmentsPage.typePersonalFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^user selects Personal payment frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selcts_personal_payment_frequency(String paymentFrequency) {
        yourFinancialCommitmentsPage.selectPersonalPaymentFrequency(paymentFrequency);
    }

    @And("^user types Personal repayment amount : (.*)$")
    public void user_types_personal_repayment_amount(String repaymentAmount) {
        yourFinancialCommitmentsPage.typePersonalRepaymentAmount(repaymentAmount);
    }


    //    credit card

    @And("^user types Credit Card repayment amount : (.*)$")
    public void user_types_credit_card_repayment_amount(String repaymentAmount) {
        yourFinancialCommitmentsPage.typeCreditcRepaymentAmount(repaymentAmount);
    }

    @And("^user types Credit Card provider : (.*)$")
    public void user_types_credit_card_provider(String provider) {
        yourFinancialCommitmentsPage.typeCreditcProvider(provider);
    }

    @And("^user selects Credit Card type : (VISA|Mastercard|American Express|Store Card|Other)$")
    public void user_selects_credit_card_type(String type) {
        yourFinancialCommitmentsPage.selectCreditcType(type);
    }

    @And("^user types Credit Card limit : (.*)$")
    public void user_types_credit_care_limit(String limit) {
        yourFinancialCommitmentsPage.typeCreditcLimit(limit);
    }

    @And("^user types Credit Card balance : (.*)$")
    public void user_types_credit_card_balance(String balance) {
        yourFinancialCommitmentsPage.typeCreditcBalance(balance);
    }


//    maintenance payment

    @And("^user types Maintenance payment : (.*)$")
    public void user_types_maintenance_payment(String payment) {
        yourFinancialCommitmentsPage.typeMaintenancepPayment(payment);
    }


//    other

    @And("^user types Other repayment amount : (.*)$")
    public void user_types_other_repayment_amount(String repaymentAmount) {
        yourFinancialCommitmentsPage.typeOtherRepaymentAmount(repaymentAmount);
    }

    @And("^user types Other value : (.*)$")
    public void user_types_other_value(String value) {
        yourFinancialCommitmentsPage.typeOtherValue(value);
    }

    @And("^user types Other description : (.*)$")
    public void user_types_other_description(String description) {
        yourFinancialCommitmentsPage.typeOtherDescription(description);
    }


//    car loan

    @And("^user types Car outstanding balance amount : (.*)$")
    public void user_types_car_outstanding_balance_amount(String outstandingBalanceAmount) {
        yourFinancialCommitmentsPage.typeCarOutstandingBalanceAmount(outstandingBalanceAmount);
    }

    @And("^user types Car financial institution : (.*)$")
    public void user_types_car_financial_institution(String financialInstitution) {
        yourFinancialCommitmentsPage.typeCarFinancialInstitution(financialInstitution);
    }

    @And("^user types Car final Repayment Date : (.*)$")
    public void user_types_car_final_repayment_date(String finalRepaymentDate) {
        yourFinancialCommitmentsPage.typeCarFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^user selects Car Payment Frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selects_car_payment_frequency(String paymentFrequency) {
        yourFinancialCommitmentsPage.selectCarPaymentFrequency(paymentFrequency);
    }

    @And("^user types Card repayment amount : (.*)$")
    public void user_types_card_repayment_amount(String repaymentAmount) {
        yourFinancialCommitmentsPage.typeCarRepaymentAmount(repaymentAmount);
    }


//    student loan

    @And("^user types Student outstanding balance amount : (.*)$")
    public void user_types_student_outstanding_balance_amount(String outstandingBalanceAmount) {
        yourFinancialCommitmentsPage.typeStudentOutstandingBalanceAmount(outstandingBalanceAmount);
    }

    @And("^user types Student financial institution : (.*)$")
    public void user_types_student_financial_institution(String financialInstitution) {
        yourFinancialCommitmentsPage.typeStudentFinancialInstitution(financialInstitution);
    }

    @And("^user types Student final repayment date : (.*)$")
    public void user_types_student_final_repayment_date(String finalRepaymentDate) {
        yourFinancialCommitmentsPage.typeStudentFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^user selects Student payment frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selects_studeent_payment_frequency(String paymentFrequency) {
        yourFinancialCommitmentsPage.selectStudentPaymentFrequency(paymentFrequency);
    }

    @And("^user types Student repayment amount : (.*)$")
    public void user_types_student_repayment_amount(String repaymentAmount) {
        yourFinancialCommitmentsPage.typeStudentRepaymentAmount(repaymentAmount);
    }


//    rent

    @And("^user selects Rent Payment Frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selects_rent_payment_frequency(String repaymentFrequency) {
        //optional
        yourFinancialCommitmentsPage.selectRentPaymentFrequency(repaymentFrequency);
    }

    @And("^user types Rent Repayment Amount : (.*)$")
    public void user_types_rent_repayment_amount(String repaymentAmount) {
        yourFinancialCommitmentsPage.typeRentRepaymentAmount(repaymentAmount);
    }

    @And("^user types Rent note : (.*)$")
    public void user_types_rent_note(String note) {
        //optional
        yourFinancialCommitmentsPage.typeRentNote(note);
    }


//    utilities

    @And("^user types Utilities payment frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_types_utilities_payment_frequency(String paymentFrequency) {
        //optional
        yourFinancialCommitmentsPage.selectUtilitiesPaymentFrequency(paymentFrequency);
    }

    @And("^user types Utilities Repayment Amount : (.*)$")
    public void user_types_utilities_repayment_amount(String repaymentAmount) {
        yourFinancialCommitmentsPage.typeUtilitiesRepaymentAmount(repaymentAmount);
    }

    @And("^user types Utilities note : (.*)$")
    public void user_types_utilities_note(String note) {
        //optional
        yourFinancialCommitmentsPage.typeUtilitiesNote(note);
    }


//    childcare

    @And("^user selects Child Care Payment Frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_types_child_care_payment_frequency(String paymentFrequency) {
        //optional
        yourFinancialCommitmentsPage.selectChildCarePaymentFrequency(paymentFrequency);
    }

    @And("^user types Child Care Repayment Amount : (.*)$")
    public void user_types_child_care_repayment_amount(String repaymentAmount) {
        yourFinancialCommitmentsPage.typeChildCareRepaymentAmount(repaymentAmount);
    }

    @And("^user types Child Care note: (.*)$")
    public void user_types_child_care_note(String note) {
        //optional
        yourFinancialCommitmentsPage.typeChildCareNote(note);
    }


//    mortgage

    @And("^user types Mortgage Outstanding Balance Amount : (.*)$")
    public void user_types_mortgage_outstanding_balance_amount(String outstandingBalanceAmount) {
        yourFinancialCommitmentsPage.typeMortgageOutstandingBalanceAmount(outstandingBalanceAmount);
    }

    @And("^user types Mortgage Financial Institution : (.*)$")
    public void user_types_mortgage_financial_institution(String financialInstitution) {
        yourFinancialCommitmentsPage.typeMortgageFinancialInstitution(financialInstitution);
    }

    @And("^user types Mortgage Final Repayment Date : (.*)$")
    public void user_types_mortgage_final_repayment_date(String finalRepaymentDate) {
        //optional
        yourFinancialCommitmentsPage.typeMortgageFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^user types Mortgage Repayment Amount: (.*)$")
    public void user_types_mortgage_repayment_amount(String repaymentAmount) {
        yourFinancialCommitmentsPage.typeMortgageRepaymentAmount(repaymentAmount);
    }


//    @When("^user selects (Personal Loan|Credit Card|Maintenance Payment|Other|Car Loan|Student Loan) as financial commitment type$")
//    public void user_selects_as_financial_commitment_type(String type) {
//        yourFinancialCommitmentsPage.selectFinancialCommitmentType(type);
//    }

//    @Override
//    public void workaroundCLV312(String borrowerOrCoapplicant) {
//        borrowerHomePage.clickInfoUpload();
//
//        boolean toGoOn = false;
//        while ( !toGoOn ) {
//            try {
//                ((IFormsMenu)borrowerPersonalDetailsPage).clickFinancialCommitments("double");
//                yourFinancialCommitmentsPage.getTitle();
//                toGoOn = true;
//            } catch (TimeoutException te) {
//                log.debug("Issues of getting Financial Commitments page.");
//            }
//        }
//    }

//    @And("^this commitment is applied to (borrower)$")
//    public void this_commitment_is_applied_to(String toWhom) {
//        yourFinancialCommitmentsPage.checkFinancialCommitmentAppliesToBorrower(user.getFirstName());
//    }

//    @And("^user clicks Financial Commitment \"CANCEL\"$")
//    public void user_clicks_financial_commitment_cancel() {
//        yourFinancialCommitmentsPage.clickCancel();
//    }

//    @And("^user clicks \"ADD THIS LIABILITY\"$")
//    public void user_clicks_add_this_liability() {
//        yourFinancialCommitmentsPage.clickAddThisLiability();
//    }

//    @And("^user clicks \"ADD LIABILITY\"$")
//    public void user_clicks_add_liability() {
//        yourFinancialCommitmentsPage.clickAddLiability();
//    }

//    @And("^user clicks \"EDIT THIS LIABILITY\"$")
//    public void user_clicks_edit_this_liability() {
//        yourFinancialCommitmentsPage.clickEditThisLiability();
//    }

//    @And("^user types Personal Loan balance: (.*)$")
//    public void user_types_personal_loan_balance(String balance) {
//        yourFinancialCommitmentsPage.typePersonalLoanBalance(balance);
//    }

//    @And("^user types Personal Loan institution: (.*)$")
//    public void user_types_personal_loan_institution(String institution) {
//        yourFinancialCommitmentsPage.typePersonalLoanInstitution(institution);
//    }

//    @And("^user selects (Weekly|Fortnightly|Monthly|Yearly) as Personal Loan repayment frequency$")
//    public void user_selects_as_personal_loan_repayment_frequency(String repaymentFrequency) {
//        yourFinancialCommitmentsPage.selectPersonalLoanRepaymentFrequency(repaymentFrequency);
//    }

//    @And("^user types Personal Loan purpose: (.*)$")
//    public void user_types_personal_loan_purpose(String purpose) {
//        yourFinancialCommitmentsPage.typePersonalLoanPurpose(purpose);
//    }

//    @And("^user types Personal Loan final repayment date: (.*)$")
//    public void user_types_personal_loan_final_repayment_date(String finalRepaymentDate) {
//        yourFinancialCommitmentsPage.typePersonalLoanFinalRepaymentDate(finalRepaymentDate);
//    }

//    @And("^user types Personal Loan repayment amount: (.*)$")
//    public void user_types_personal_loan_repayment_amount(String repaymentAmount) {
//        yourFinancialCommitmentsPage.typePersonalLoanRepaymentAmount(repaymentAmount);
//    }

//    @And("^user types Credit Card repayment amount: (.*)$")
//    public void user_types_credit_card_repayment_amount(String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeCreditCardRepaymentAmount(repaymentAmount);
//    }

//    @And("^user types Credit Card provider: (.*)$")
//    public void user_types_credit_card_provider(String provider) {
//        yourFinancialCommitmentsPage.typeCreditCardProvider(provider);
//    }

//    @And("^user selects (VISA|Mastercard|American Express|Store Card|Other) as Credit Card type$")
//    public void user_selects_as_credit_card_type(String type) {
//        yourFinancialCommitmentsPage.selectCreditCardType(type);
//    }

//    @And("^user types Credit Card limit: (.*)$")
//    public void user_types_credit_card_limit(String limit) {
//        yourFinancialCommitmentsPage.typeCreditCardLimit(limit);
//    }

//    @And("^user types Credit Card balance: (.*)$")
//    public void user_types_credit_card_balance(String balance) {
//        yourFinancialCommitmentsPage.typeCreditCardBalance(balance);
//    }

//    @And("^user types Maintenance Monthly payment: (.*)$")
//    public void user_types_maintenance_monthly_payment(String payment) {
//        yourFinancialCommitmentsPage.typeMaintenanceMonthlyPayment(payment);
//    }

//    @And("^user types Other Commitment repayment amount: (.*)$")
//    public void user_types_other_repayment_amount(String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeOtherRepaymentAmount(repaymentAmount);
//    }

//    @And("^user types Other Commitment value: (.*)$")
//    public void user_types_other_value(String value) {
//        yourFinancialCommitmentsPage.typeOtherValue(value);
//    }

//    @And("^user types Other Commitment description: (.*)$")
//    public void user_types_other_description(String description) {
//        yourFinancialCommitmentsPage.typeOtherDescription(description);
//    }

//    @And("^user types Car Loan balance: (.*)$")
//    public void user_types_car_loan_balance(String balance) {
//        yourFinancialCommitmentsPage.typeCarLoanBalance(balance);
//    }

//    @And("^user types Car Loan institution: (.*)")
//    public void user_types_car_loan_institution(String institution) {
//        yourFinancialCommitmentsPage.typeCarLoanInstitution(institution);
//    }

//    @And("^user selects (Weekly|Fortnightly|Monthly|Yearly) as Car Loan repayment frequency$")
//    public void user_selects_as_car_loan_repayment_frequency(String repaymentFrequency) {
//        yourFinancialCommitmentsPage.selectCarLoanRepaymentFrequency(repaymentFrequency);
//    }

//    @And("^user types Car Loan final repayment date: (.*)")
//    public void user_types_car_loan_final_repayment_date(String finalRepaymentDate) {
//        yourFinancialCommitmentsPage.typeCarLoanFinalRepaymentDate(finalRepaymentDate);
//    }

//    @And("^user types Car Loan repayment amount: (.*)")
//    public void user_types_car_loan_repayment_amount(String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeCarLoanRepaymentAmount(repaymentAmount);
//    }

//    @And("^user types Student Loan balance: (.*)")
//    public void user_types_student_loan_balance(String balance) {
//        yourFinancialCommitmentsPage.typeStudentLoanBalance(balance);
//    }

//    @And("^user types Student Loan institution: (.*)")
//    public void user_types_student_loan_institution(String institution) {
//        yourFinancialCommitmentsPage.typeStudentLoanInstitution(institution);
//    }

//    @And("^user selects (Weekly|Fortnightly|Monthly|Yearly) as Student Loan repayment frequency$")
//    public void user_selects_as_student_loan_repayment_frequency(String repaymentFrequency) {
//        yourFinancialCommitmentsPage.selectStudentLoanRepaymentFrequency(repaymentFrequency);
//    }

//    @And("^user types Student Loan final repayment date: (.*)")
//    public void user_types_student_loan_final_repayment_date(String finalRepaymentDate) {
//        yourFinancialCommitmentsPage.typeStudentLoanFinalRepaymentDate(finalRepaymentDate);
//    }

//    @And("^user types Student Loan repayment amount: (.*)$")
//    public void user_types_student_loan_repayment_amount(String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeStudentLoanRepaymentAmount(repaymentAmount);
//    }
}
