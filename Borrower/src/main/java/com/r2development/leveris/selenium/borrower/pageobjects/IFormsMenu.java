package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IFormsMenu {

    String DASHBOARD_LINK_XPATH = "//a[contains(., 'Dashboard')]";
    String HOME_LINK_XPATH = "//a[@wicketpath='left_c_form_form_root_c_w_hbxMenu_c_i_w_lnkDashboard_cancel']";
    String CURRENT_CATEGORY_XPATH = "//div[contains(@wicketpath, 'Forms') and contains(., '> Forms')]";

    String DETAILS_ICON_XPATH = "//div[contains(@class, 'detail-icon')]";
    String FORMDONE_ICON_XPATH = "//div[contains(@class, 'formdone-icon')]";

    String FORM_TITLE_XPATH = "//div[contains(@class, 'sc-label') and contains(., 'Your forms to fill')]";
    String BORROWER_PERSONAL_DETAILS_XPATH = "//div[contains(@id, 'pnlBorrower1UncommonForms') and contains(., '${replace}$') and contains(., 'personal details')]";
    String BORROWER_PERSONAL_DETAILS_SINGLE_XPATH = "//div[contains(@id, 'pnlBorrower1UncommonForms') and contains(., 'Personal details')]";
    String BORROWER_PERSONAL_DETAILS_COUPLE_XPATH = "//div[contains(@id, 'pnlBorrower1UncommonForms') and contains(., 'personal details')]";
    String BORROWER_EMPLOYMENT_INCOME_XPATH = "//div[contains(@id, 'pnlBorrower1UncommonForms') and contains(., '${replace}$') and contains(., 'employment and income')]";
    String BORROWER_EMPLOYMENT_INCOME_SINGLE_XPATH = "//div[contains(@id, 'pnlBorrower1UncommonForms') and contains(., 'Employment and income')]";
    String BORROWER_EMPLOYMENT_INCOME_COUPLE_XPATH = "//div[contains(@id, 'pnlBorrower1UncommonForms') and contains(., 'employment and income')]";

    String COAPPLICANT_PERSONAL_DETAILS_XPATH = "//div[contains(@id, 'pnlBorrower2UncommonForms') and contains(., 'AutomationCoapplicant') and contains(., 'personal details')]";
//    String COAPPLICANT_PERSONAL_DETAILS_XPATH = "//div[contains(@id, 'pnlBorrower2UncommonForms') and contains(., '${replace}$') and contains(., 'personal details')]";
    String COAPPLICANT_EMPLOYMENT_INCOME_XPATH = "//div[contains(@id, 'pnlBorrower2UncommonForms')and contains(., 'AutomationCoapplicant') and contains(., 'employment and income')]";
//    String COAPPLICANT_EMPLOYMENT_INCOME_XPATH = "//div[contains(@id, 'pnlBorrower2UncommonForms')and contains(., '${replace}$') and contains(., 'employment and income')]";

    String FORMS_ROOT_XPATH = "//div[contains(@id, 'pnlCommonForm')]";
//    String ACCOUNT_XPATH = "//div[contains(@data-path, 'pnlCommonForms') and not(contains(@wicketpath, 'lblCommonForms')) and contains(., 'Accounts')]"; //data-path pnlBorrower1 rptBorrower1CommonForms 0 pnlBorrower1CommonForms
    String ACCOUNT_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_1_item_pnlBorrower1CommonForms']";
    String ACCOUNT_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_1_item_pnlBorrower1CommonForms' and contains(@class, 'formdone-icon')]";
    String ACCOUNT_COMMON_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_1_item_pnlCommonForms']";
    String ACCOUNT_COMMON_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_1_item_pnlCommonForms' and contains(@class, 'formdone-icon')]";
//    String DEPENDENTS_XPATH = "//div[contains(@data-path, 'pnlCommonForms') and not(contains(@wicketpath, 'lblCommonForms')) and contains(., 'Dependents')]"; //data-path pnlBorrower1 rptBorrower1CommonForms 1 pnlBorrower1CommonForms
    String DEPENDENTS_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_2_item_pnlBorrower1CommonForms']";
    String DEPENDENTS_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_2_item_pnlBorrower1CommonForms' and contains(@class, 'formdone-icon')]";
    String DEPENDENTS_COMMON_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_2_item_pnlCommonForms']";
    String DEPENDENTS_COMMON_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_2_item_pnlCommonForms' and contains(@class, 'formdone-icon')]";
//    String FINANCIAL_ASSETS_XPATH = "//div[contains(@data-path, 'pnlCommonForms') and not(contains(@wicketpath, 'lblCommonForms')) and contains(., 'Financial assets')]"; //data-path pnlBorrower1 rptBorrower1CommonForms 2 pnlBorrower1CommonForms
    String FINANCIAL_ASSETS_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_3_item_pnlBorrower1CommonForms']";
    String FINANCIAL_ASSETS_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_3_item_pnlBorrower1CommonForms' and contains(@class, 'formdone-icon')]";
    String FINANCIAL_ASSETS_COMMON_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_3_item_pnlCommonForms']";
    String FINANCIAL_ASSETS_COMMON_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_3_item_pnlCommonForms' and contains(@class, 'formdone-icon')]";
//    String PROPERTIES_XPATH = "//div[contains(@data-path, 'pnlCommonForms') and not(contains(@wicketpath, 'lblCommonForms')) and contains(., 'Properties')]"; //data-path pnlBorrower1 rptBorrower1CommonForms 3 pnlBorrower1CommonForms
    String PROPERTIES_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_4_item_pnlBorrower1CommonForms']";
    String PROPERTIES_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_4_item_pnlBorrower1CommonForms' and contains(@class, 'formdone-icon')]";
    String PROPERTIES_COMMON_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_4_item_pnlCommonForms']";
    String PROPERTIES_COMMON_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_4_item_pnlCommonForms' and contains(@class, 'formdone-icon')]";
//    String FINANCIAL_COMMITMENTS_XPATH = "//div[contains(@data-path, 'pnlCommonForms') and not(contains(@wicketpath, 'lblCommonForms')) and contains(., 'Financial commitments')]"; //data-path pnlBorrower1 rptBorrower1CommonForms 4 pnlBorrower1CommonForms
    String FINANCIAL_COMMITMENTS_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_5_item_pnlBorrower1CommonForms']";
    String FINANCIAL_COMMITMENTS_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_5_item_pnlBorrower1CommonForms' and contains(@class, 'formdone-icon')]";
    String FINANCIAL_COMMITMENTS_COMMON_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_5_item_pnlCommonForms']";
    String FINANCIAL_COMMITMENTS_COMMON_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_5_item_pnlCommonForms' and contains(@class, 'formdone-icon')]";
//    String FUNDING_XPATH = "//div[contains(@data-path, 'pnlCommonForms') and not(contains(@wicketpath, 'lblCommonForms')) and contains(., 'Funding')]"; //data-path pnlBorrower1 rptBorrower1CommonForms 5 pnlBorrower1CommonForms
    String FUNDING_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_6_item_pnlBorrower1CommonForms']";
    String FUNDING_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlBorrower1_c_w_rptBorrower1CommonForms_c_rows_6_item_pnlBorrower1CommonForms' and contains(@class, 'formdone-icon')]";
    String FUNDING_COMMON_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_6_item_pnlCommonForms']";
    String FUNDING_COMMON_DONE_XPATH = "//div[@wicketpath='left_c_form_form_root_c_w_pnlCommon_c_w_rptCommonForms_c_rows_6_item_pnlCommonForms' and contains(@class, 'formdone-icon')]";
//    String DOCUMENT_UPLOAD_XPATH = "//div[contains(@id, 'pnlDocument') and contains(., 'Document upload')]";
    String DOCUMENT_UPLOAD_XPATH = "//div[contains(@id, 'pnlDocument') and contains(., 'Document upload')]";

    IBorrowerHomePage clickDashboard();
    IBorrowerHomePage clickHome();

    IFormsMenu clickBorrowerPersonalDetails(String borrowerFirstName);
    IFormsMenu clickBorrowerPersonalDetails();
    IFormsMenu clickSingleBorrowerPersonalDetails();
    IFormsMenu clickCoupleBorrowerPersonalDetails();
    boolean isBorrowerPersonalDetailsValid(String borrowerFirstName);
    boolean isBorrowerPersonalDetailsValid();
    IFormsMenu clickBorrowerEmploymentIncome(String borrowerFirstName);
    IFormsMenu clickBorrowerEmploymentIncome();
    IFormsMenu clickCoapplicantPersonalDetails(String coapplicantFirstName);
    boolean isCoapplicantPersonalDetailsValid(String coapplicantFirstName);
    IFormsMenu clickCoapplicantEmploymentIncome(String coapplicantFirstName);

    IFormsMenu clickAccount();
    IFormsMenu clickAccount(String singleOrDouble);
    boolean isAccountFormDone(String singleOrDouble);
    IFormsMenu clickDependents();
    IFormsMenu clickDependents(String singleOrDouble);
    boolean isDependentFormDone(String singleOrDouble);
    IFormsMenu clickFinancialAssets();
    IFormsMenu clickFinancialAssets(String singleOrDouble);
    boolean isFinancialAssetsFormDone(String singleOrDouble);
    IFormsMenu clickProperties();
    IFormsMenu clickProperties(String singleOrDouble);
    boolean isPropertiesDone(String singleOrDouble);
    IFormsMenu clickFinancialCommitments();
    IFormsMenu clickFinancialCommitments(String singleOrDouble);
    boolean isFinancialCommitmentsFormDone(String singleOrDouble);
    IFormsMenu clickFunding();
    IFormsMenu clickFunding(String singleOrDouble);
    boolean isFundingFormDone(String singleOrDouble);

    IFormsMenu clickDocumentUpload();

    boolean isLoaded();

}
