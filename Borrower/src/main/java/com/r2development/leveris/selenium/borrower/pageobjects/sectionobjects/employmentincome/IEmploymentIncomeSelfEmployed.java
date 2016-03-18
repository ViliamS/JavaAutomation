package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.employmentincome;

/**
 * Created by anthonymottot on 17/03/2016.
 */
public interface IEmploymentIncomeSelfEmployed {

    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_OCCUPATION_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_cmbSelfOccupation_v']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NAME_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtBusinessName_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_1_XPATH = "//label[contains(., 'Address line 1')]/following-sibling::input[contains(@id, 'pnlAddress')]";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_2_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtAddressLine2_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_TOWN_CITY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtCity_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTY_STATE_XPATH =     "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_pnlCounty_c_w_pnlIrelandCounty_c_w_cmbIrelandCounty_v']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTY_STATE_SELECT_XPATH =   "//select[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_pnlCounty_c_w_pnlIrelandCounty_c_w_cmbIrelandCounty_combobox']";
    //String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTY_STATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_cmbCounty_v']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTRY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_cmbCountry_v']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NATURE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtNatureOfBusiness_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_START_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtDateBussEstablished_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_END_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtBusinessEndDate_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_CURRENTLY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_chkBusinessCurrently_checkbox']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_NET_INCOME_MONTHLY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlNetIcomeSelf_c_w_crbNetIcomeSelf_tb']";

    IEmploymentIncomeSelfEmployed selectSelfEmployment_Occupation(String occupation);
    IEmploymentIncomeSelfEmployed typeSelfEmployment_StartDate(String startDate);
    IEmploymentIncomeSelfEmployed typeSelfEmployment_EndDate(String endDate);
    IEmploymentIncomeSelfEmployed checkSelfEmployment_Currently(String currently);
    IEmploymentIncomeSelfEmployed typeSelfEmployment_NetIncomeMonthly(String netIncomeMonthly);
    IEmploymentIncomeSelfEmployed typeSelfEmployment_BusinessName(String businessName);
    IEmploymentIncomeSelfEmployed typeSelfEmployment_AddressLine1(String addressLine1);
    IEmploymentIncomeSelfEmployed typeSelfEmployment_AddressLine2(String addressLine2);
    IEmploymentIncomeSelfEmployed typeSelfEmployment_TownCity(String townCity);
    IEmploymentIncomeSelfEmployed selectSelfEmployment_CountyState(String countyState);
    IEmploymentIncomeSelfEmployed selectSelfEmployment_Country(String country);
    IEmploymentIncomeSelfEmployed typeSelfEmployment_BusinessNature(String businessNature);

}
