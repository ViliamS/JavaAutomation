package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

@Singleton
public class ApiYourFinancialCommitmentsStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourFinancialCommitmentsStepDef.class);

    public ApiYourFinancialCommitmentsStepDef() {
    }

    @When("^user selects (Personal Loan|Credit Card|Maintenance Payment|Other|Car Loan|Student Loan) as financial commitment type$")
    public void user_selects_as_financial_commitment_type(String type) {
//        yourFinancialCommitmentsPage.selectFinancialCommitmentType(type);
    }

    @When("^user has(n't)? financial commitments$")
    public void user_has_financial_commitments(String hasCommitments) throws IOException {
        if (hasCommitments == null) {
            // TODO to implement
//            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
//                yourFinancialCommitmentsPage.clickCoupleYes();
//            else
//                yourFinancialCommitmentsPage.clickSingleYes();
        }
        else {
//            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
//                yourFinancialCommitmentsPage.clickCoupleNo();
//            else
//                yourFinancialCommitmentsPage.clickSingleNo();
//            yourFinancialCommitmentsPage.clickNext();

            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkHaveNoCommitments:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "1");
                            put("root:c:w:pnlNoEmplyments:c:w:lnkHaveNoCommitments:submit", "1");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );

            String noCommitmentsResponse = requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoCommitments:c:w:btnNextSection:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "1");
                            put("root:c:w:pnlNoCommitments:c:w:btnNextSection:submit", "1");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(noCommitmentsResponse);
        }
    }

    @And("^this commitment is applied to (borrower|coapplicant|both)$")
    public void this_commitment_is_applied_to(String toWhom) {
        switch (toWhom) {
            case "borrower":
//                yourFinancialCommitmentsPage.checkFinancialCommitmentAppliesToBorrower(user.getFirstName());
                break;
            case "coapplicant":
//                yourFinancialCommitmentsPage.checkFinancialCommitmentAppliesToCoapplicant(user.getFirstNameCoApplicant());
                break;
            case "both":
//                yourFinancialCommitmentsPage.checkFinancialCommitmentAppliesToBorrower(user.getFirstName());
//                yourFinancialCommitmentsPage.checkFinancialCommitmentAppliesToCoapplicant(user.getFirstNameCoApplicant());
                break;
            default:
        }
    }

    @And("^user clicks Financial Commitment \"CANCEL\"$")
    public void user_clicks_financial_commitment_cancel() {
//        yourFinancialCommitmentsPage.clickCancel();
    }

    @And("^user clicks Financial Commitment \"NEXT\"$")
    public void user_clicks_financial_commitment_next() {
//        yourFinancialCommitmentsPage.clickNext();
    }

    @And("^user clicks \"ADD THIS LIABILITY\"$")
    public void user_clicks_add_this_liability() {
//        yourFinancialCommitmentsPage.clickAddThisLiability();
    }

    @And("^user clicks \"ADD LIABILITY\"$")
    public void user_clicks_add_liability() {
//        yourFinancialCommitmentsPage.clickAddLiability();
    }

    @And("^user clicks \"EDIT THIS LIABILITY\"$")
    public void user_clicks_edit_this_liability() {
//        yourFinancialCommitmentsPage.clickEditThisLiability();
    }

    @And("^user types Personal Loan balance: (.*)$")
    public void user_types_personal_loan_balance(String balance) {
//        yourFinancialCommitmentsPage.typePersonalLoanBalance(balance);
    }

    @And("^user types Personal Loan institution: (.*)$")
    public void user_types_personal_loan_institution(String institution) {
//        yourFinancialCommitmentsPage.typePersonalLoanInstitution(institution);
    }

    @And("^user selects (Weekly|Fortnightly|Monthly|Yearly) as Personal Loan repayment frequency$")
    public void user_selects_as_personal_loan_repayment_frequency(String repaymentFrequency) {
//        yourFinancialCommitmentsPage.selectPersonalLoanRepaymentFrequency(repaymentFrequency);
    }

    @And("^user types Personal Loan purpose: (.*)$")
    public void user_types_personal_loan_purpose(String purpose) {
//        yourFinancialCommitmentsPage.typePersonalLoanPurpose(purpose);
    }

    @And("^user types Personal Loan final repayment date: (.*)$")
    public void user_types_personal_loan_final_repayment_date(String finalRepaymentDate) {
//        yourFinancialCommitmentsPage.typePersonalLoanFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^user types Personal Loan repayment amount: (.*)$")
    public void user_types_personal_loan_repayment_amount(String repaymentAmount) {
//        yourFinancialCommitmentsPage.typePersonalLoanRepaymentAmount(repaymentAmount);
    }

    @And("^user types Credit Card repayment amount: (.*)$")
    public void user_types_credit_card_repayment_amount(String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeCreditCardRepaymentAmount(repaymentAmount);
    }

    @And("^user types Credit Card provider: (.*)$")
    public void user_types_credit_card_provider(String provider) {
//        yourFinancialCommitmentsPage.typeCreditCardProvider(provider);
    }

    @And("^user selects (VISA|Mastercard|American Express|Store Card|Other) as Credit Card type$")
    public void user_selects_as_credit_card_type(String type) {
//        yourFinancialCommitmentsPage.selectCreditCardType(type);
    }

    @And("^user types Credit Card limit: (.*)$")
    public void user_types_credit_card_limit(String limit) {
//        yourFinancialCommitmentsPage.typeCreditCardLimit(limit);
    }

    @And("^user types Credit Card balance: (.*)$")
    public void user_types_credit_card_balance(String balance) {
//        yourFinancialCommitmentsPage.typeCreditCardBalance(balance);
    }

    @And("^user types Maintenance Monthly payment: (.*)$")
    public void user_types_maintenance_monthly_payment(String payment) {
//        yourFinancialCommitmentsPage.typeMaintenanceMonthlyPayment(payment);
    }

    @And("^user types Other Commitment repayment amount: (.*)$")
    public void user_types_other_repayment_amount(String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeOtherRepaymentAmount(repaymentAmount);
    }

    @And("^user types Other Commitment value: (.*)$")
    public void user_types_other_value(String value) {
//        yourFinancialCommitmentsPage.typeOtherValue(value);
    }

    @And("^user types Other Commitment description: (.*)$")
    public void user_types_other_description(String description) {
//        yourFinancialCommitmentsPage.typeOtherDescription(description);
    }

    @And("^user types Car Loan balance: (.*)$")
    public void user_types_car_loan_balance(String balance) {
//        yourFinancialCommitmentsPage.typeCarLoanBalance(balance);
    }

    @And("^user types Car Loan institution: (.*)")
    public void user_types_car_loan_institution(String institution) {
//        yourFinancialCommitmentsPage.typeCarLoanInstitution(institution);
    }

    @And("^user selects (Weekly|Fortnightly|Monthly|Yearly) as Car Loan repayment frequency$")
    public void user_selects_as_car_loan_repayment_frequency(String repaymentFrequency) {
//        yourFinancialCommitmentsPage.selectCarLoanRepaymentFrequency(repaymentFrequency);
    }

    @And("^user types Car Loan final repayment date: (.*)")
    public void user_types_car_loan_final_repayment_date(String finalRepaymentDate) {
//        yourFinancialCommitmentsPage.typeCarLoanFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^user types Car Loan repayment amount: (.*)")
    public void user_types_car_loan_repayment_amount(String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeCarLoanRepaymentAmount(repaymentAmount);
    }

    @And("^user types Student Loan balance: (.*)")
    public void user_types_student_loan_balance(String balance) {
//        yourFinancialCommitmentsPage.typeStudentLoanBalance(balance);
    }

    @And("^user types Student Loan institution: (.*)")
    public void user_types_student_loan_institution(String institution) {
//        yourFinancialCommitmentsPage.typeStudentLoanInstitution(institution);
    }

    @And("^user selects (Weekly|Fortnightly|Monthly|Yearly) as Student Loan repayment frequency$")
    public void user_selects_as_student_loan_repayment_frequency(String repaymentFrequency) {
//        yourFinancialCommitmentsPage.selectStudentLoanRepaymentFrequency(repaymentFrequency);
    }

    @And("^user types Student Loan final repayment date: (.*)")
    public void user_types_student_loan_final_repayment_date(String finalRepaymentDate) {
//        yourFinancialCommitmentsPage.typeStudentLoanFinalRepaymentDate(finalRepaymentDate);
    }

    @And("^user types Student Loan repayment amount: (.*)$")
    public void user_types_student_loan_repayment_amount(String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeStudentLoanRepaymentAmount(repaymentAmount);
    }
}
