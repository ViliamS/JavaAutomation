package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.employmentincome;

public interface IEmploymentIncomeUnemployed {

    String EMPLOYMENT_INCOME_UNEMPLOYED_FORM_START_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlUnemployed_c_w_txtUnemployedStartDate_tb']";
    String EMPLOYMENT_INCOME_UNEMPLOYED_FORM_END_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlUnemployed_c_w_txtUnemployedEndDate_tb']";
    String EMPLOYMENT_INCOME_UNEMPLOYED_FORM_CURRENTLY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlUnemployed_c_w_chkUnemployedCurrently_checkbox']";

    IEmploymentIncomeUnemployed typeUnemployment_StartDate(String startDate);
    IEmploymentIncomeUnemployed typeUnemployment_EndDate(String endDate);
    IEmploymentIncomeUnemployed checkUnemployment_Currently(String currently);
}