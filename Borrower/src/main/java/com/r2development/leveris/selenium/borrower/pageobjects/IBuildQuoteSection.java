package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IBuildQuoteSection {
    String BUILD_QUOTE_STEP_XPATH = "//div[contains(@wicketpath, 'Step') and contains(@class, 'sc-label')]/span";
    String BUILD_QUOTE_STEP1_XPATH = "//div[contains(@wicketpath, 'Step') and contains(@class, 'sc-label') and contains(., 'Step 1 of 3')]";
    String BUILD_QUOTE_TITLE_XPATH = "//div[contains(@wicketpath, 'Title') and contains(@class, 'sc-label') and contains(., 'Build your quotation')]";

    String BUILD_QUOTE_NUMBER_BORROWER_XPATH = "//input[contains(@wicketpath, 'NumberOfBorrowers')]";
    String BUILD_QUOTE_NUMBER_BORROWER_SINGLE_OR_JOINT_LINK_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlNumberOfBorrowers_c_w_rgrNumberOfBorrowers_rg_rb_radNumberOfBorrowers${replace}']//a";
    String BUILD_QUOTE_NUMBER_BORROWER_SINGLE_LINK_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlNumberOfBorrowers_c_w_rgrNumberOfBorrowers_rg_rb_radNumberOfBorrowersSingle']//a";
    String BUILD_QUOTE_NUMBER_BORROWER_JOINT_LINK_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlNumberOfBorrowers_c_w_rgrNumberOfBorrowers_rg_rb_radNumberOfBorrowersJoint']//a";
    String BUILD_QUOTE_MORTGAGE_TYPE_XPATH = "//input[contains(@wicketpath, 'MortgageType')]";
    String BUILD_QUOTE_MORTGAGE_TYPE_FIRST_TIME_BUYER_OR_MOVER_LINK_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlMortgageType_c_w_rgrMortgageType_rg_rb_radMortgage${replace}']//a";
    String BUILD_QUOTE_MORTGAGE_TYPE_FIRST_TIME_BUYER_LINK_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlMortgageType_c_w_rgrMortgageType_rg_rb_radMortgageTypeFirstTime']//a";
    String BUILD_QUOTE_MORTGAGE_TYPE_MOVER_LINK_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlMortgageType_c_w_rgrMortgageType_rg_rb_radMortgageTypeMovers']//a";
//    String BUILD_QUOTE_AGE_XPATH = "//input[contains(@wicketpath, 'txtAge') and not(contains(@wicketpath, 'txtAge2'))]";
    String BUILD_QUOTE_AGE_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlAge_c_w_txtAge_tb']";
//    String BUILD_QUOTE_PARTNER_AGE_XPATH = "//input[contains(@wicketpath, 'txtAge2') and not(@disabled)]";
    String BUILD_QUOTE_PARTNER_AGE_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlAge_c_w_pnlAge2_c_w_txtAge2_tb']";

    String BUILD_QUOTE_MARITAL_STATUS_XPATH = "//input[contains(@wicketpath, 'MaritalStatus')]";
    String BUILD_QUOTE_MARITAL_STATUS_SINGLE_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlMaritalStatus_c_w_rgrMaritalStatus_rg_rb_radMaritalStatusSingle']//a";
    String BUILD_QUOTE_MARITAL_STATUS_SEPARATED_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlMaritalStatus_c_w_rgrMaritalStatus_rg_rb_radMaritalStatusSeparated']//a";
    String BUILD_QUOTE_MARITAL_STATUS_MARRIED_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlMaritalStatus_c_w_rgrMaritalStatus_rg_rb_radMaritalStatusMarried']//a";
    String BUILD_QUOTE_MARITAL_STATUS_DIVORCED_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlMaritalStatus_c_w_rgrMaritalStatus_rg_rb_radMaritalStatusDivorced']//a";
    String BUILD_QUOTE_MARITAL_STATUS_WIDOWED_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlMaritalStatus_c_w_rgrMaritalStatus_rg_rb_radMaritalStatusWidowed']//a";

//    String BUILD_QUOTE_TOTAL_DEPENDANTS_XPATH = "//input[contains(@wicketpath, 'TotalDependents')]";
    String BUILD_QUOTE_TOTAL_DEPENDANTS_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlTotalDependents_c_w_txtTotalDependents_tb']";

    String BUILD_QUOTE_INCOME_TYPE_XPATH = "//input[contains(@wicketpath, 'Income1') and contains(@wicketpath, 'IncomeType') and not(contains(@wicketpath, 'IncomeType1origValue'))]";
    String BUILD_QUOTE_INCOME_TYPE_PANEL_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlEmploymentAndIncome1_c_w_pnlIncome1_c_w_rgrIncomeTypeB1_rg']";
    String BUILD_QUOTE_INCOME_TYPE_EMPLOYEE_XPATH = BUILD_QUOTE_INCOME_TYPE_PANEL_XPATH + "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlEmploymentAndIncome1_c_w_pnlIncome1_c_w_rgrIncomeTypeB1_rg_rb_radIncomeTypePaye']//a";
    String BUILD_QUOTE_INCOME_TYPE_SELF_EMPLOYEE_XPATH = BUILD_QUOTE_INCOME_TYPE_PANEL_XPATH + "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlEmploymentAndIncome1_c_w_pnlIncome1_c_w_rgrIncomeTypeB1_rg_rb_radIncomeTypeSelfEmployed']//a";
    String BUILD_QUOTE_INCOME_TYPE_CIVIL_SERVANT_XPATH = BUILD_QUOTE_INCOME_TYPE_PANEL_XPATH + "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlEmploymentAndIncome1_c_w_pnlIncome1_c_w_rgrIncomeTypeB1_rg_rb_radIncomeTypeCivilServant']//a";

    String BUILD_QUOTE_PARTNER_INCOME_TYPE_XPATH = "//input[contains(@wicketpath, 'Income2') and contains(@wicketpath, 'IncomeType') and not(contains(@wicketpath, 'IncomeType2origValue')) and not(@disabled)]";
    String BUILD_QUOTE_PARTNER_INCOME_TYPE_PANEL_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlEmploymentAndIncome2_c_w_pnlIncome2_c_w_rgrIncomeTypeB2_rg']";
    String BUILD_QUOTE_PARTNER_INCOME_TYPE_EMPLOYEE_XPATH = BUILD_QUOTE_PARTNER_INCOME_TYPE_PANEL_XPATH + "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlEmploymentAndIncome2_c_w_pnlIncome2_c_w_rgrIncomeTypeB2_rg_rb_radIncomeTypePaye']//a";
    String BUILD_QUOTE_PARTNER_INCOME_TYPE_SELF_EMPLOYEE_XPATH = BUILD_QUOTE_PARTNER_INCOME_TYPE_PANEL_XPATH + "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlEmploymentAndIncome2_c_w_pnlIncome2_c_w_rgrIncomeTypeB2_rg_rb_radIncomeTypeSelfEmployed']//a";
    String BUILD_QUOTE_PARTNER_INCOME_TYPE_CIVIL_SERVANT_XPATH = BUILD_QUOTE_PARTNER_INCOME_TYPE_PANEL_XPATH + "//div[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlEmploymentAndIncome2_c_w_pnlIncome2_c_w_rgrIncomeTypeB2_rg_rb_radIncomeTypeCivilServant']//a";

    String BUILD_QUOTE_INCOME_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlEmploymentAndIncome1_c_w_pnlIncomeAmountB1_c_w_crbIncomeAmount_tb']";
    String BUILD_QUOTE_PARTNER_INCOME_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlEmploymentAndIncome2_c_w_pnlIncomeAmountB2_c_w_crbIncomeAmount_tb']";
    String BUILD_QUOTE_MONTHLY_CREDIT_COMMITMENT_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_pnlBuildYourQuotation_c_w_pnlMonthlyCreditCommitments_c_w_crbMonthlyCreditCommitments_tb']";
    String BUILD_QUOTE_GET_MY_QUOTE_XPATH = "//a[contains(., 'Get quote')]";
    String BUILD_QUOTE_GET_MY_QUOTE_FAILURE_XPATH = "//a[contains(., 'GET MY QUOTE')]";

    IBuildQuoteSection selectNumberOfBorrower(String nbBorrowers);
    IBuildQuoteSection clickNumberOfBorrower(String nbBorrowers);
    IBuildQuoteSection selectMortgageType(String mortgageType);
    IBuildQuoteSection clickMortgageType(String mortgageType);
    IBuildQuoteSection typeAge(String age);
    IBuildQuoteSection typePartnerAge(String age);
    IBuildQuoteSection selectMaritalStatus(String maritalStatus);
    IBuildQuoteSection typeTotalDependants(String totalDependants);
    IBuildQuoteSection selectIncomeType(String incomeType);
    IBuildQuoteSection selectPartnerIncomeType(String incomeType);
    IBuildQuoteSection typeIncomeAmount(String incomeAmount);
    IBuildQuoteSection typePartnerIncomeAmount(String incomeAmount);
    IBuildQuoteSection typeMonthlyCreditCommitments(String monthCreditCommitment);
    IBuildQuoteSection2 clickGetQuote();
//    IBuildQuoteSection2 clickGetQuoteFailure();
    boolean isLoaded();
}
