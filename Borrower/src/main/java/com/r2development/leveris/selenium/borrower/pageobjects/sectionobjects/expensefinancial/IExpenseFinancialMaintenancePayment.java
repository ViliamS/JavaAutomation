package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.expensefinancial;

public interface IExpenseFinancialMaintenancePayment {

    String FINANCIAL_MAINTENANCEP_PAYMENT_XPATH = "/inputa[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlMaintenance_c_w_crbMaintenancePayment_tb']";

    IExpenseFinancialMaintenancePayment typeMaintenancepPayment(String payment);
}