package com.r2development.leveris.selenium.borrower.pageobjects;

        import java.util.Map;

public interface IEmploymentIncomeSection {
//    String EMPLOYMENT_INCOMES_TITLE_XPATH = "//h2[contains(@wicketpath, 'title') and contains(., '${replace}$') and contains(., 'Employment') and contains(., 'Income')]";
    String EMPLOYMENT_INCOMES_TITLE_XPATH = "//h2[contains(@wicketpath, 'title') and contains(., '${replace}$') and contains(., 'Employment')]"; // after deployment 20160128 we were already using this xpath before.
//    String EMPLOYMENT_INCOMES_TITLE_XPATH = "//div[contains(@wicketpath, 'pnlNoEmplyments_c_w_lblNoEmpTitle_l') and contains(., '${replace}$') and contains(., 'Employment')]"; before deployment 20160128
    String EMPLOYMENT_INCOMES_DESCRIPTION_XPATH = "";

    String EMPLOYMENT_INCOMES_CATEGORY_XPATH = "//label[contains(., 'Category')]";

    String EMPLOYMENT_INCOMES_LINK_CATEGORY_XPATH = "//div[contains(@data-path, 'lnkAdd${replace}$')]/a";


    // String EMPLOYMENT_INCOME_PANELS_XPATH = //div[contains(@id, 'pnlInnerPanel') and contains(@wicketpath, 'pnlInnerPanel') and contains(@class, 'panel')]
    // String EMPLOYMENT_INCOME_PANEL_INCOME_NAME_XPATH = //div[contains(@id, 'IncomeName')]//span
    // String EMPLOYMENT_INCOME_PANEL_EDIT_INCOME_XPATH = //div[contains(@id, 'EmploymentEditLink')]//a
    // String EMPLOYMENT_INCOME_PANEL_EDIT_GROSS_INCOME_XPATH = //div[contains(@id, 'EditGrossIncome')]//span
    // String EMPLOYMENT_INCOME_PANEL_ACTUALITY_XPATH = //div[contains(@id, 'DateOrCurrent')]//span
    // String EMPLOYMENT_INCOME_PANEL_EMPL_GROSS_INCOME_XPATH = //div[contains(@id, 'EmplGrossIncome')]//span
    // String EMPLOYMENT_INCOME_PANEL_REMOVE_PANEL_XPATH = //div[contains(@id, 'RemoveEmployment')]//a

    // case PAYE
    String EMPLOYMENT_INCOMES_PAYE_CONTAINER_XPATH = "//div[contains(@wicketpath, 'pnlEmployed') and contains(@class, 'widget-enabled')]";
    String EMPLOYMENT_INCOMES_PAYE_OCCUPATION_XPATH = "//label[contains(., 'Occupation')]/following-sibling::input[contains(@wicketpath, 'pnlEmployed')]"; //select
//    String EMPLOYMENT_INCOMES_PAYE_EMPLOYER_NAME_XPATH = "//label[contains(., 'Employer') and contains(., 's name')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_PAYE_EMPLOYER_NAME_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmployerName:tb']";
    // Contract, Permanent, Temporary
//    String EMPLOYMENT_INCOMES_PAYE_EMPLOYMENT_TYPE_XPATH = "//label[contains(., 'Employment type')]"; // select
    String EMPLOYMENT_INCOMES_PAYE_EMPLOYMENT_TYPE_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlEmployed:c:w:cmbEmplType:v']"; // select
//    String EMPLOYMENT_INCOMES_PAYE_STARTDATE_XPATH = "//label[contains(., 'Start date')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_PAYE_STARTDATE_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplStartDate:tb']";
    // case PAY Contract
//    String EMPLOYMENT_INCOMES_PAYE_MANDATORY_ENDDATE_XPATH = "//label[contains(., 'End date')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_PAYE_MANDATORY_ENDDATE_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplEndDate:tb']";
    // case PAY Permanent, Temporary
//    String EMPLOYMENT_INCOMES_PAYE_ENDDATE_XPATH = "//label[contains(., 'End date')]/following-sibling::input[contains(@wicketpath, 'pnlEmployed')]";
    String EMPLOYMENT_INCOMES_PAYE_ENDDATE_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplEndDate:tb']";
    // case not valid for PAY Contract only for Permanent, Temporary
//    String EMPLOYMENT_INCOMES_PAYE_CURRENTLY_XPATH = "//label[contains(@wicketpath, 'pnlEmployed') and contains(., 'Currently')]/following-sibling::span/a";
    String EMPLOYMENT_INCOMES_PAYE_CURRENTLY_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlEmployed_c_w_pnlEmplCurrently_c_w_chkEmplCurrently_label']/following-sibling::span/a";
//    String EMPLOYMENT_INCOMES_PAYE_GROSS_SALARY_XPATH = "//label[contains(., 'Gross salary')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_PAYE_GROSS_SALARY_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossSalary:tb']";
//    String EMPLOYMENT_INCOMES_PAYE_REGULAR_OVERTIME_XPATH = "//label[contains(., 'Regular overtime')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_PAYE_REGULAR_OVERTIME_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossOvertime:tb']";
//    String EMPLOYMENT_INCOMES_PAYE_REGULAR_GUARANTEED_BONUS_XPATH = "//label[contains(., 'Regular guaranteed bonus')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_PAYE_REGULAR_GUARANTEED_BONUS_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossBonus:tb']";
    String EMPLOYMENT_INCOMES_PAYE_GUARANTEED_COMMISSION_XPATH = "//label[contains(., 'Guaranteed commission')]/following-sibling::input";

    // case SELF_EMPLOYED
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_CONTAINER_XPATH = "//div[contains(@wicketpath, 'pnlSelfEmployed') and contains(@class, 'widget-enabled')]";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_OCCUPATION_XPATH = "//label[contains(., 'Occupation')]/following-sibling::input[contains(@wicketpath, 'pnlSelfEmployed')]"; // select
//    String EMPLOYMENT_INCOMES_SELFEMPLOYED_BUSINESS_NAME_XPATH = "//label[contains(., 'Business name')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_BUSINESS_NAME_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:txtBusinessName:tb']";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_ADDRESS_LINE1_XPATH = "//label[contains(., 'Address line 1')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_ADDRESS_LINE2_XPATH = "//label[contains(., 'Address line 2')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_TOWNCITY_XPATH = "//label[contains(., 'Town/City')]/following-sibling::input";
    // if country is Ireland
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTYSTATE_XPATH = "//label[contains(., 'County/State')]"; // select
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTRY_XPATH = "//label[contains(., 'Country')]"; // select
//    String EMPLOYMENT_INCOMES_SELFEMPLOYED_BUSINESS_NATURE_XPATH = "//label[contains(., 'Nature of business')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_BUSINESS_NATURE_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:txtNatureOfBusiness:tb']";
//    String EMPLOYMENT_INCOMES_SELFEMPLOYED_STARTDATE_XPATH = "//label[contains(., 'Start date')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_STARTDATE_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:txtDateBussEstablished:tb']";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_ENDDATE_XPATH = "//label[contains(., 'End date')]/following-sibling::input[contains(@wicketpath, 'pnlSelfEmployed')]";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_CURRENTLY_XPATH = "//label[contains(@wicketpath, 'pnlSelfEmployed') and contains(., 'Currently') ]/following-sibling::span/a";
//    String EMPLOYMENT_INCOMES_SELFEMPLOYED_NETPROFIT_LASTYEAR_XPATH = "//label[contains(., 'Net profit last year')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_NETPROFIT_LASTYEAR_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:crbNetProfitLastyear:tb']";
//    String EMPLOYMENT_INCOMES_SELFEMPLOYED_NETPROFIT_PREVIOUSYEAR_XPATH = "//label[contains(., 'Net profit previous year')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_NETPROFIT_PREVIOUSYEAR_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:crbNetProfitPreviousYear:tb']";
//    String EMPLOYMENT_INCOMES_SELFEMPLOYED_ACCOUNTANT_NAME_XPATH = "//label[contains(., 'Accountant name / practice')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_SELFEMPLOYED_ACCOUNTANT_NAME_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:txtAccountantNamePractice:tb']";

    // case CIVIL_SERVANT
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_CONTAINER_XPATH = EMPLOYMENT_INCOMES_PAYE_CONTAINER_XPATH;
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_OCCUPATION_XPATH = EMPLOYMENT_INCOMES_PAYE_OCCUPATION_XPATH;
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_EMPLOYER_NAME_XPATH = EMPLOYMENT_INCOMES_PAYE_EMPLOYER_NAME_XPATH;
    // Contract, Permanent, Temporary
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_EMPLOYMENT_TYPE_XPATH = EMPLOYMENT_INCOMES_PAYE_EMPLOYMENT_TYPE_XPATH;
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_STARTDATE_XPATH = EMPLOYMENT_INCOMES_PAYE_STARTDATE_XPATH;
    // case PAY Contract
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_MANDATORY_ENDDATE_XPATH = EMPLOYMENT_INCOMES_PAYE_MANDATORY_ENDDATE_XPATH;
    // case PAY Permanent, Temporary
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_ENDDATE_XPATH = EMPLOYMENT_INCOMES_PAYE_ENDDATE_XPATH;
    // case not valid for PAY Contract only for Permanent, Temporary
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_CURRENTLY_XPATH = EMPLOYMENT_INCOMES_PAYE_CURRENTLY_XPATH;
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_GROSS_SALARY_XPATH = EMPLOYMENT_INCOMES_PAYE_GROSS_SALARY_XPATH;
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_REGULAR_OVERTIME_XPATH = EMPLOYMENT_INCOMES_PAYE_REGULAR_OVERTIME_XPATH;
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_REGULAR_GUARANTEED_BONUS_XPATH = EMPLOYMENT_INCOMES_PAYE_REGULAR_GUARANTEED_BONUS_XPATH;
    String EMPLOYMENT_INCOMES_CIVIL_SERVANT_GUARANTEED_COMMISSION_XPATH = EMPLOYMENT_INCOMES_PAYE_GUARANTEED_COMMISSION_XPATH;

    // case UNEMPLOYED_HOMEMAKER
    String EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_CONTAINER_XPATH = "//div[contains(@wicketpath, 'pnlUnemployed') and contains(@class, 'widget-enabled')]";
    String EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_STARTDATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlUnemployed_c_w_txtUnemployedStartDate_tb']"; //label[contains(., 'Start date')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_ENDDATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlUnemployed_c_w_txtUnemployedEndDate_tb']"; //label[contains(., 'End date')]/following-sibling::input[contains(@wicketpath, 'pnlUnemployed')]";
    String EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_CURRENTLY = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlUnemployed_c_w_chkUnemployedCurrently_label']/following-sibling::span/a"; //label[contains(@wicketpath, 'pnlUnemployed') and contains(., 'Currently')]/following-sibling::span/a";

    // case OTHER
    String EMPLOYMENT_INCOMES_OTHERS_CONTAINER_XPATH = "//div[contains(@wicketpath, 'pnlOther') and contains(@class, 'widget-enabled')]";
//    String EMPLOYMENT_INCOMES_OTHERS_SOURCE_INCOME_XPATH = "//label[contains(., 'Source of additional income')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_OTHERS_SOURCE_INCOME_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlOther:c:w:txtSourceAdditionalIncome:tb']";
//    String EMPLOYMENT_INCOMES_OTHERS_GROSS_INCOMES_XPATH = "//label[contains(., 'Gross income')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_OTHERS_GROSS_INCOMES_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlOther:c:w:crbGrossIncome:tb']";
//    String EMPLOYMENT_INCOMES_OTHERS_TIME_EARNING_INCOME_XPATH = "//label[contains(., 'Time earning this income')]/following-sibling::input";
    String EMPLOYMENT_INCOMES_OTHERS_TIME_EARNING_INCOME_XPATH = "//input[@name='root:c:w:pnlDetail:c:w:pnlOther:c:w:txtOtherIncomeTime:tb']";

    String REPORT_INCOMES_XPATH = "//div[contains(@id, 'rptIncomes')]";
    String DELETE_REPORT_INCOMES = ""; // to investigate using hover ?

    String EMPLOYMENT_INCOMES_CANCEL_XPATH = "//a[contains(., 'CANCEL')]";
    String EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH = "//a[contains(., 'Add')]";
    String EMPLOYMENT_INCOMES_ADD_THIS_EMPLOYMENT_XPATH = "//a[contains(., 'Save and Close')]"; // TODO to check if when we will have many incomes
    String EMPLOYMENT_INCOMES_DONE_XPATH = "//a[contains(., 'I') and contains(., 'm done')]";


    String getTitle();
    boolean isTitle(String firstName);

    String getDescriptionEmploymentIncome();

    IEmploymentIncomeSection selectCategory(String category);
    IEmploymentIncomeSection clickCategory(String category);

    // case PAYE
    IEmploymentIncomeSection selectEIP_Occupation(String occupation);
    IEmploymentIncomeSection typeEIP_EmployerName(String employerName);
    // Contract, Permanent, Temporary
    IEmploymentIncomeSection selectEIP_EmploymentType(String employmentType);
    IEmploymentIncomeSection typeEIP_StartDate(String startDate);
    // case PAY Contract
    IEmploymentIncomeSection typeEIP_MandatoryEndDate(String mandatoryEndDate);
    // case PAY Permanent, Temporary
    IEmploymentIncomeSection typeEIP_EndDate(String endDate);
    // case not valid for PAY Contract only for Permanent, Temporary
    IEmploymentIncomeSection checkEIP_Currently();
    IEmploymentIncomeSection uncheckEIP_Currently();
    IEmploymentIncomeSection typeEIP_GrossSalary(String grossSalary);
    IEmploymentIncomeSection typeEIP_RegularOvertime(String regularOvertime);
    IEmploymentIncomeSection typeEIP_RegularGuaranteedBonus(String regularGuaranteedBonus);
    IEmploymentIncomeSection typeEIP_GuaranteedCommission(String guaranteedCommission);

    // case SELF_EMPLOYED
    IEmploymentIncomeSection selectEISE_Occupation(String occupation);
    IEmploymentIncomeSection typeEISE_BusinessName(String businessName);
    IEmploymentIncomeSection typeEISE_AddressLine1(String addressLine1);
    IEmploymentIncomeSection typeEISE_AddressLine2(String addressLine2);
    IEmploymentIncomeSection typeEISE_TownCity(String townCity);
    // if country is Ireland
    IEmploymentIncomeSection selectEISE_CountyState(String countyState);
    IEmploymentIncomeSection selectEISE_Country(String country);
    IEmploymentIncomeSection typeEISE_BusinessNature(String businessNature);
    IEmploymentIncomeSection typeEISE_StartDate(String startDate);
    IEmploymentIncomeSection typeEISE_EndDate(String endDate);
    IEmploymentIncomeSection checkEISE_Currently();
    IEmploymentIncomeSection uncheckEISE_Currently();
    IEmploymentIncomeSection typeEISE_NetProfitLastYear(String netProfitLastYear);
    IEmploymentIncomeSection typeEISE_NetProfitPreviousYear(String netProfitPreviousYear);
    IEmploymentIncomeSection typeEISE_AccountantName(String accountantName);

    // case CIVIL_SERVANT
    IEmploymentIncomeSection selectEICS_Occupation(String occupation);
    IEmploymentIncomeSection typeEICS_EmployerName(String employerName);
    // Contract, Permanent, Temporary
    IEmploymentIncomeSection selectEICS_EmploymentType(String employmentType);
    IEmploymentIncomeSection typeEICS_StartDate(String startDate);
    // case PAY Contract
    IEmploymentIncomeSection typeEICS_MandatoryEndDate(String mandatoryEndDate);
    // case PAY Permanent, Temporary
    IEmploymentIncomeSection typeEICS_EndDate(String endDate);
    // case not valid for PAY Contract only for Permanent, Temporary
    IEmploymentIncomeSection checkEICS_Currently();
    IEmploymentIncomeSection uncheckEICS_Currently();
    IEmploymentIncomeSection typeEICS_GrossSalary(String grossSalary);
    IEmploymentIncomeSection typeEICS_RegularOvertime(String regularOvertime);
    IEmploymentIncomeSection typeEICS_RegularGuaranteedBonus(String regularGuaranteedBonus);
    IEmploymentIncomeSection typeEICS_GuaranteedCommission(String guaranteedCommission);

    // case UNEMPLOYED_HOMEMAKER
    IEmploymentIncomeSection typeEIUH_StartDate(String startDate);
    IEmploymentIncomeSection typeEIUH_EndDate(String endDate);
    IEmploymentIncomeSection checkEIUH_Currently();
    IEmploymentIncomeSection uncheckEIUH_Currently();

    // case OTHER
    IEmploymentIncomeSection typeEIO_SourceIncome(String sourceIncome);
    IEmploymentIncomeSection typeEIO_GrossIncomes(String grossIncomes);
    IEmploymentIncomeSection typeEIO_TimeEarningIncome(String timeEarningIncome);

    boolean isExistReportIncomes();
    Map<Integer, ReportEmploymentIncome> getReportsEmploymentIncome(); // model or di ?
    Map<Integer, ReportEmploymentIncome> delReportEmploymentIncome(int i); // to think about it !

    IEmploymentIncomeSection clickEmploymentIncomeCancel();
    IEmploymentIncomeSection clickEmploymentIncomeAddEmployment();
    IEmploymentIncomeSection clickEmploymentIncomeAddThisEmployment();
    IEmploymentIncomeSection clickEmploymentIncomeDone();
}