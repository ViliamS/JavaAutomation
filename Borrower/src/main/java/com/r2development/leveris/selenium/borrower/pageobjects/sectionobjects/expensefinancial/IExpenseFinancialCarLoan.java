package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.expensefinancial;

public interface IExpenseFinancialCarLoan {

    String FINANCIAL_CAR_OUTSTANDING_BALANCE_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlOutstandingAmount_c_w_crbOutstandingLoanAmount_tb']";
    String FINANCIAL_CAR_FINANCIAL_INSTITUTION_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPersonalLoan_c_w_txtFinancialInstitution_tb']";
    String FINANCIAL_CAR_FINAL_REPAYMENT_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPersonalLoan_c_w_txtFinalRepaymentDate_tb']";
    String FINANCIAL_CAR_PAYMENT_FREQUENCY_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_label']";
    String FINANCIAL_CAR_PAYMENT_FREQUENCY_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_v']";
    String FINANCIAL_CAR_REPAYMENT_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlRepaymentAmount_c_w_crbRepaymentAmount_tb']";

    IExpenseFinancialCarLoan typeCarOutstandingBalanceAmount(String outstandingBalanceAmount);
    IExpenseFinancialCarLoan typeCarFinancialInstitution(String financialInstitution);
    IExpenseFinancialCarLoan typeCarFinalRepaymentDate(String finalRepaymentDate);
    IExpenseFinancialCarLoan selectCarPaymentFrequency(String paymentFrequency);
    IExpenseFinancialCarLoan typeCarRepaymentAmount(String repaymentAmount);
}