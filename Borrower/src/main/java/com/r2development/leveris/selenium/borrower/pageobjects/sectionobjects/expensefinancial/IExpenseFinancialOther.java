package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.expensefinancial;

public interface IExpenseFinancialOther {

    String FINANCIAL_OTHER_REPAYMENT_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlRepaymentAmount_c_w_crbRepaymentAmount_tb']";
    String FINANCIAL_OTHER_VALUE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlOtherValue_c_w_crbValue_tb']";
    String FINANCIAL_OTHER_DESCRIPTION_XPATH = "//textarea[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlOtherValue_c_w_txaDescription_textarea']";

    IExpenseFinancialOther typeOtherRepaymentAmount(String repaymentAmount);
    IExpenseFinancialOther typeOtherValue(String value);
    IExpenseFinancialOther typeOtherDescription(String description);
}