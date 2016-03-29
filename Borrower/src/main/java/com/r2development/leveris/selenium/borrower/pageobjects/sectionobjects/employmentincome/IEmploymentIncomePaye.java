package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.employmentincome;

public interface IEmploymentIncomePaye {

    String INPUT_OCCUPATION_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlEmployed_c_w_cmbJobTitle_v']";
    String INPUT_EMPLOYMENT_NAME_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlEmployed_c_w_txtEmployerName_tb']";
    String INPUT_EMPLOYMENT_TYPE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlEmployed_c_w_cmbEmplType_v']";
    String INPUT_START_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlEmployed_c_w_txtEmplStartDate_tb']";
    String INPUT_END_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlEmployed_c_w_txtEmplEndDate_tb']";
    String INPUT_CURRENTLY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlEmployed_c_w_pnlEmplCurrently_c_w_chkEmplCurrently_checkbox']";
    String INPUT_NET_INCOME_MONTHLY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlEmployed_c_w_pnlNetIncomeEmpl_c_w_crbEmplNetIcome_tb']";

    String EMPLOYMENT_INCOME_PAYE_FORM_OCCUPATION_XPATH = INPUT_OCCUPATION_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYER_NAME_XPATH = INPUT_EMPLOYMENT_NAME_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYMENT_TYPE_XPATH = INPUT_EMPLOYMENT_TYPE_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_START_DATE_XPATH = INPUT_START_DATE_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_END_DATE_XPATH = INPUT_END_DATE_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_CURRENTLY_XPATH = INPUT_CURRENTLY_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_NET_INCOME_MONTHLY_XPATH = INPUT_NET_INCOME_MONTHLY_XPATH;

    IEmploymentIncomePaye selectPaye_Occupation(String occupation);
    IEmploymentIncomePaye typePaye_EmploymentName(String employmentName);
    IEmploymentIncomePaye selectPaye_EmploymentType(String employmentType);
    IEmploymentIncomePaye typePaye_StartDate(String startDate);
    IEmploymentIncomePaye typePaye_EndDate(String endDate);
    IEmploymentIncomePaye checkPaye_Currently(String currently);
    IEmploymentIncomePaye typePaye_NetIncomeMonthly(String netIncomeMonthly);
}