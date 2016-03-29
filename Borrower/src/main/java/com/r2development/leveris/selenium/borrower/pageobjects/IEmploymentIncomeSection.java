package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IEmploymentIncomeSection {
//    String EMPLOYMENT_INCOMES_TITLE_XPATH = "//h2[contains(@wicketpath, 'title') and contains(., '${replace}$') and contains(., 'Employment') and contains(., 'Income')]";
    String EMPLOYMENT_INCOMES_TITLE_XPATH = "//h2[contains(@wicketpath, 'title') and contains(., '${replace}$') and contains(., 'Employment')]"; // after deployment 20160128 we were already using this xpath before.
//    String EMPLOYMENT_INCOMES_TITLE_XPATH = "//div[contains(@wicketpath, 'pnlNoEmplyments_c_w_lblNoEmpTitle_l') and contains(., '${replace}$') and contains(., 'Employment')]"; before deployment 20160128
    String EMPLOYMENT_INCOMES_DESCRIPTION_XPATH = "";

    String EMPLOYMENT_INCOMES_CATEGORY_XPATH = "//label[contains(., 'Category')]";
    String EMPLOYMENT_INCOMES_LINK_CATEGORY_XPATH = "//div[contains(@data-path, 'lnkAdd${replace}$')]/a";

    String EMPLOYMENT_INCOMES_FEEDBACK_DIALOG_XPATH = "//div[contains(., 'main_c_form_dialogWrapper_dialog_feedbackBox')]";
    String ERROR = "//div[text()='There are error items.']";

    String EMPLOYMENT_INCOMES_DIALOG_XPATH = "//div[@wicketpath='main_c_form_dialogWrapper_dialog']";

    String EMPLOYMENT_INCOMES_ADD_PAYE_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_pnlPaye_c_w_lnkAddPaye_dialog']";
    String EMPLOYMENT_INCOMES_ADD_SELF_EMPLOYED_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_pnlSelfEmployed_c_w_lnkAddSelfEmployed_dialog']";
    String EMPLOYMENT_INCOMES_ADD_UNEMPLOYED_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_pnlUnemployed_c_w_lnkAddUnemployment_dialog']";
    String EMPLOYMENT_INCOMES_ADD_OTHER_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_pnlOther_c_w_lnkAddHomemaker_dialog']";

    String EMPLOYMENT_INCOMES_DIALOG_ADD_PAYE_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_pnlPaye_c_w_lnkAddPaye_submit']";
    String EMPLOYMENT_INCOMES_DIALOG_ADD_SELF_EMPLOYED_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_pnlSelfEmployed_c_w_lnkAddSelfEmployed_submit']";
    String EMPLOYMENT_INCOMES_DIALOG_ADD_UNEMPLOYED_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_pnlUnemployed_c_w_lnkAddUnemployment_submit']";
    String EMPLOYMENT_INCOMES_DIALOG_ADD_OTHER_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_pnlOther_c_w_lnkAddHomemaker_submit']";

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

    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_OCCUPATION_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_cmbSelfOccupation_v']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NAME_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtBusinessName_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_1_XPATH = "//label[contains(., 'Address line 1')]/following-sibling::input[contains(@id, 'pnlAddress')]";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_2_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtAddressLine2_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_TOWN_CITY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtCity_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTY_STATE_XPATH =     "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_pnlCounty_c_w_pnlIrelandCounty_c_w_cmbIrelandCounty_v']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTY_STATE_SELECT_XPATH =   "//select[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_pnlCounty_c_w_pnlIrelandCounty_c_w_cmbIrelandCounty_combobox']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTRY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_cmbCountry_v']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NATURE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtNatureOfBusiness_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_START_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtDateBussEstablished_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_END_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_txtBusinessEndDate_tb']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_CURRENTLY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlSelfEmployed_c_w_chkBusinessCurrently_checkbox']";
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_NET_INCOME_MONTHLY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlNetIcomeSelf_c_w_crbNetIcomeSelf_tb']";

    String EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_OCCUPATION_XPATH = INPUT_OCCUPATION_XPATH;
    String EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_EMPLOYER_NAME_XPATH = INPUT_EMPLOYMENT_NAME_XPATH;
    String EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_EMPLOYMENT_TYPE_XPATH = INPUT_EMPLOYMENT_TYPE_XPATH;
    String EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_START_DATE_XPATH = INPUT_START_DATE_XPATH;
    String EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_END_DATE_XPATH = INPUT_END_DATE_XPATH;
    String EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_CURRENTLY_XPATH = INPUT_CURRENTLY_XPATH;
    String EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_NET_INCOME_MONTHLY_XPATH = INPUT_NET_INCOME_MONTHLY_XPATH;

    String EMPLOYMENT_INCOME_UNEMPLOYED_FORM_START_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlUnemployed_c_w_txtUnemployedStartDate_tb']";
    String EMPLOYMENT_INCOME_UNEMPLOYED_FORM_END_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlUnemployed_c_w_txtUnemployedEndDate_tb']";
    String EMPLOYMENT_INCOME_UNEMPLOYED_FORM_CURRENTLY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlUnemployed_c_w_chkUnemployedCurrently_checkbox']";

    String EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_MONTHLY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlNetIcomeOther_c_w_crbNetIcomeOther_tb']";
    String EMPLOYMENT_INCOME_OTHER_FORM_NET_ADDITIONAL_INCOME_SOURCE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlOther_c_w_txtSourceAdditionalIncome_tb']";
    String EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_TIME_EARNING_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlNetIcomeOther_c_w_txtOtherNetIncomeTime_tb']";

    String SAVE_AND_CLOSE_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_btnEmploymentAdd_submit']";
    String CANCEL_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_btnCancel_cancel']";
    String ADD_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_btnAddEmp_dialog']";
    String DONE_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_btnImDone_submit']";
    String EDIT_INDEX_INDEX_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_${replace_index}$_item_pnlItems_c_w_btnEdit_dialog'][contains(@class, 'ui-state-hover')]"; //(int index);
    String EDIT_DETAIL_CATEGORY_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_\\d+_item_pnlItems_c_w_lblIncomeName_l'][contains(., '${replace_detail_category}']"; //(String detailCategory);
    String DELETE_INDEX_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_${replace_index}$_item_pnlItems_c_w_btnDelete_dialog'][contains(@class, 'ui9state-hover')]"; //(int index);
    String DELETE_DETAIL_CATEGORY_XPATH = ""; //(String detailCategory);

    String getTitle();
    boolean isTitle(String firstName);

    String getDescriptionEmploymentIncome();

    IEmploymentIncomeSection selectCategory(String category);
    IEmploymentIncomeSection clickCategory(String category);

    IEmploymentIncomeSection selectPaye_Occupation(String occupation);
    IEmploymentIncomeSection typePaye_EmploymentName(String employmentName);
    IEmploymentIncomeSection selectPaye_EmploymentType(String employmentType);
    IEmploymentIncomeSection typePaye_StartDate(String startDate);
    IEmploymentIncomeSection typePaye_EndDate(String endDate);
    IEmploymentIncomeSection checkPaye_Currently(String currently);
    IEmploymentIncomeSection typePaye_NetIncomeMonthly(String netIncomeMonthly);

    IEmploymentIncomeSection selectSelfEmployment_Occupation(String occupation);
    IEmploymentIncomeSection typeSelfEmployment_StartDate(String startDate);
    IEmploymentIncomeSection typeSelfEmployment_EndDate(String endDate);
    IEmploymentIncomeSection checkSelfEmployment_Currently(String currently);
    IEmploymentIncomeSection typeSelfEmployment_NetIncomeMonthly(String netIncomeMonthly);
    IEmploymentIncomeSection typeSelfEmployment_BusinessName(String businessName);
    IEmploymentIncomeSection typeSelfEmployment_AddressLine1(String addressLine1);
    IEmploymentIncomeSection typeSelfEmployment_AddressLine2(String addressLine2);
    IEmploymentIncomeSection typeSelfEmployment_TownCity(String townCity);
    IEmploymentIncomeSection selectSelfEmployment_CountyState(String countyState);
    IEmploymentIncomeSection selectSelfEmployment_Country(String country);
    IEmploymentIncomeSection typeSelfEmployment_BusinessNature(String businessNature);

    IEmploymentIncomeSection selectCivilServant_Occupation(String occupation);
    IEmploymentIncomeSection typeCivilServant_EmploymentName(String employmentName);
    IEmploymentIncomeSection selectCivilServant_EmploymentType(String employmentType);
    IEmploymentIncomeSection typeCivilServant_StartDate(String startDate);
    IEmploymentIncomeSection typeCivilServant_EndDate(String endDate);
    IEmploymentIncomeSection checkCivilServant_Currently(String currently);
    IEmploymentIncomeSection typeCivilServant_NetIncomeMonthly(String netIncomeMonthly);

    IEmploymentIncomeSection typeUnemployment_StartDate(String startDate);
    IEmploymentIncomeSection typeUnemployment_EndDate(String endDate);
    IEmploymentIncomeSection checkUnemployment_Currently(String currently);

    IEmploymentIncomeSection typeOther_NetIncomeMonthly(String netIncomeMonthly);
    IEmploymentIncomeSection typeOther_AdditionalIncomeSource(String additionalIncomeSource);
    IEmploymentIncomeSection typeOther_EarningTime(String earningTIme);

    IEmploymentIncomeSection clickSaveAndClose();
    IEmploymentIncomeSection clickCancel();
    IEmploymentIncomeSection clickAdd();
    IYourAccountsPage clickDone();
    IEmploymentIncomeSection clickDelete(int index);
    IEmploymentIncomeSection clickDelete(String detailCategory);
    IEmploymentIncomeSection clickEdit(int index);
    IEmploymentIncomeSection clickEdit(String detailCategory);
}