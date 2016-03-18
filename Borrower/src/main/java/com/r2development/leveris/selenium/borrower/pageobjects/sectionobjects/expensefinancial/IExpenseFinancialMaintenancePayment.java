package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.expensefinancial;

/**
 * Created by anthonymottot on 18/03/2016.
 */
public interface IExpenseFinancialMaintenancePayment {

    //    maintenance payment
    String FINANCIAL_MAINTENANCEP_PAYMENT_XPATH = "/inputa[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlMaintenance_c_w_crbMaintenancePayment_tb']";

    //    maintenance payment
    IExpenseFinancialMaintenancePayment typeMaintenancepPayment(String payment);

}
