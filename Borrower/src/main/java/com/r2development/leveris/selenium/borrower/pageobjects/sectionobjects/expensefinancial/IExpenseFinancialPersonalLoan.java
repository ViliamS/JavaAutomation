package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.expensefinancial;

/**
 * Created by anthonymottot on 18/03/2016.
 */
public interface IExpenseFinancialPersonalLoan {

    //    Personal Loan Details
    String FINANCIAL_PERSONAL_OUTSTANDING_BALANCE_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlOutstandingAmount_c_w_crbOutstandingLoanAmount_tb']";
    String FINANCIAL_PERSONAL_FINANCIAL_INSTITUTION_XPATH = "/input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPersonalLoan_c_w_txtFinancialInstitution_tb']";
    String FINANCIAL_PERSONAL_LOAN_PURPOSE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPersonalLoan_c_w_txtLoanPurpose_tb']";
    String FINANCIAL_PERSONAL_FINAL_REPAYMENT_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPersonalLoan_c_w_txtFinalRepaymentDate_tb']";
    String FINANCIAL_PERSONAL_PAYMENT_FREQUENCY_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_label']";
    String FINANCIAL_PERSONAL_PAYMENT_FREQUENCY_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_v']";
    String FINANCIAL_PERSONAL_REPAYMENT_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlRepaymentAmount_c_w_crbRepaymentAmount_tb']";

    IExpenseFinancialPersonalLoan typePersonalOutstandingBalanceAmount(String outstandingBalanceAmount);
    IExpenseFinancialPersonalLoan typePersonalFinancialInstitution(String financialInstitution);
    IExpenseFinancialPersonalLoan typePersonalLoanPurpose(String loanPurpose);
    IExpenseFinancialPersonalLoan typePersonalFinalRepaymentDate(String finalRepaymentDate);
    IExpenseFinancialPersonalLoan selectPersonalPaymentFrequency(String paymentFrequency);
    IExpenseFinancialPersonalLoan typePersonalRepaymentAmount(String repaymentAmount);

}
