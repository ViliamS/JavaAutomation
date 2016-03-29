package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.expensefinancial;

public interface IExpenseFinancialCreditCard {

    String FINANCIAL_CREDITC_REPAYMENT_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlRepaymentAmount_c_w_crbRepaymentAmount_tb']";
    String FINANCIAL_CREDITC_PROVIDER_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlCreditCard_c_w_txtCardProvider_tb']";
    String FINANCIAL_CREDITC_CARD_TYPE_LABEL_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlCreditCard_c_w_cmbCardType_label']";
    String FINANCIAL_CREDITC_CARD_TYPE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlCreditCard_c_w_cmbCardType_combobox']";
    String FINANCIAL_CREDITC_CARD_LIMIT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlCreditCard_c_w_crbCardLimit_tb']";
    String FINANCIAL_CREDITC_CARD_BALANCE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlCreditCard_c_w_crbCardBalance_tb']";

    IExpenseFinancialCreditCard typeCreditcRepaymentAmount(String repaymentAmount);
    IExpenseFinancialCreditCard typeCreditcProvider(String provider);
    IExpenseFinancialCreditCard selectCreditcType(String type);
    IExpenseFinancialCreditCard typeCreditcLimit(String limit);
    IExpenseFinancialCreditCard typeCreditcBalance(String balance);
}