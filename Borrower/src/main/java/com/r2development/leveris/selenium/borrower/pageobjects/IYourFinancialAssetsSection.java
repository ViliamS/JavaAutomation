package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourFinancialAssetsSection {
    String YOUR_FINANCIAL_ASSETS_TITLE_XPATH = "//h2[contains(., 'Your assets')]";
//    String YOUR_FINANCIAL_ASSETS_TITLE_XPATH = "//div[contains(@data-path, 'pnlNoEmplyments lblNoAssetTitle') and contains(., 'Your assets')]";

    String YOUR_FINANCIAL_ASSETS_DESCRIPTION_XPATH = "//div[contains(@wicketpath, 'lblHeaderText')]/span";

//    String YOUR_FINANCIAL_ASSETS_SINGLE_NO_XPATH = "//label[contains(., 'NO I DON')]/following-sibling::span/a";
    String YOUR_FINANCIAL_ASSETS_SINGLE_NO_XPATH = "//a[contains(., 'I have no assets')]";
    String YOUR_FINANCIAL_ASSETS_SINGLE_YES_XPATH = "//label[contains(., 'YES I DO')]/following-sibling::span/a";

    String YOUR_FINANCIAL_ASSETS_COUPLE_NO_XPATH = "//a[contains(., 'We have no assets')]"; //"//label[contains(., 'We have no assets')]/following-sibling::span/a";
    String YOUR_FINANCIAL_ASSETS_COUPLE_YES_XPATH = "//label[contains(., 'YES WE DO')]/following-sibling::span/a";

    String YOUR_FINANCIAL_ASSETS_APPLIES_TO_BORROWER_XPATH = "//label[contains(., '${replaceBorrower}$')]/following-sibling::span/a";
    String YOUR_FINANCIAL_ASSETS_APPLIES_TO_COAPPLICANT_XPATH = "//label[contains(., '${replaceCoapplicant}$')]/following-sibling::span/a";

    // Investment Product Funds / Bonds, Shares, Share Options, Land/Site, Life Policy, Other
    //String YOUR_FINANCIAL_ASSETS_WHICH_ASSETS_XPATH ="//label[contains(., 'What is type of asset?')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_WHICH_ASSETS_XPATH ="//input[@wicketpath='main_c_form_form_root_c_w_pnlAddForm_c_w_cmbAssetType_v']";


    // Investment Product Funds / Bonds
    String YOUR_FINANCIAL_ASSETS_FUNDS_BONDS_INVESTMENTS_XPATH = "//label[contains(., 'Current value of investments funds / bonds')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_FUNDS_BONDS_INSTITUTION_XPATH = "//label[contains(., 'Funds / bonds institution')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_FUNDS_BONDS_MATURITY_XPATH = "//label[contains(., 'Maturity date')]/following-sibling::input";

    // Shares
    String YOUR_FINANCIAL_ASSETS_SHARES_COMPANY_XPATH = "//label[contains(., 'Company in which shares held')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_SHARES_VALUE_XPATH = "//label[contains(., 'Current value of shares')]/following-sibling::input";

    // Share Options
    String YOUR_FINANCIAL_ASSETS_SHARE_OPTION_COMPANY_XPATH = "//label[contains(., 'Company in which share options held')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_SHARE_OPTION_EXERCISE_DATE_XPATH = "//label[contains(., 'Share options exercise date')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_SHARE_OPTION_VALUE_XPATH = "//label[contains(., 'Current value of share options')]/following-sibling::input";

    // Land/Site
    String YOUR_FINANCIAL_ASSETS_LAND_SITE_NATURE_XPATH = "//label[contains(., 'Nature of the land / site')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_LAND_SITE_LOCATION_XPATH = "//label[contains(., 'Land / site location')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_LAND_SITE_SIZE_XPATH = "//label[contains(., 'Land / site size')]/following-sibling::input";
    // Sq. Kilometers, Acres, Hectares
    String YOUR_FINANCIAL_ASSETS_LAND_SITE_UNITS_XPATH = "//label[contains(., 'Units')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_LAND_SITE_ESTIMATE_XPATH = "//label[contains(., 'Estimated land / site value')]/following-sibling::input";

    String YOUR_FINANCIAL_ASSETS_CANCEL_XPATH = "//a[contains(., 'CANCEL')]";
    String YOUR_FINANCIAL_ASSETS_ADD_THIS_ASSETS_XPATH = "//a[contains(., 'ADD THIS ASSET')]";
    String YOUR_FINANCIAL_ASSETS_ADD_ASSET_XPATH = "//a[contains(., 'ADD ASSET')]";
    String YOUR_FINANCIAL_ASSETS_NEXT_XPATH = "//a[contains(., 'Next section')]";
    String YOUR_FINANCIAL_ASSETS_EDIT_THIS_ASSET_XPATH = "//a[contains(., 'EDIT THIS ASSET')]";

    // Life Policy
    String YOUR_FINANCIAL_ASSETS_LIFE_POLICY_COMPANY_XPATH = "//label[contains(., 'Life policy company')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_LIFE_POLICY_VALUE_XPATH = "//label[contains(., 'Current encashment value')]/following-sibling::input";

    // Other
    String YOUR_FINANCIAL_ASSETS_OTHERS_NATURE_XPATH = "//label[contains(., 'Nature of other financial asset')]/following-sibling::input";
//    String YOUR_FINANCIAL_ASSETS_OTHERS_VALUE_XPATH = "//label[contains(., 'Current value')]/following-sibling::input";
    String YOUR_FINANCIAL_ASSETS_OTHERS_VALUE_XPATH = "//input[@name='root:c:w:pnlAddForm:c:w:pnlOtherAsset:c:w:crbOtherAssetValue:tb']";

    String YOUR_FINANCIAL_ASSET_REPORTS_XPATH = "//div[contains(@id, 'AssetList')]";
    String YOUR_FINANCIAL_ASSET_TOTAL_XPATH = "//div[contains(@id, 'SubtotalValue')]//span";

    IYourFinancialAssetsSection typeFundsBondsInvestment(String fundBondInvestment);
    IYourFinancialAssetsSection typeFundsBondsInstitution(String fundBondInstitution);
    IYourFinancialAssetsSection typeFundsBondsMaturityDate(String fundBondMaturityDate);

    IYourFinancialAssetsSection typeSharesCompany(String sharesCompany);
    IYourFinancialAssetsSection typeSharesValue(String sharesValue);

    IYourFinancialAssetsSection typeShareOptionCompany(String company);
    IYourFinancialAssetsSection typeShareOptionExerciseDate(String exerciseDate);
    IYourFinancialAssetsSection typeShareOptionValue(String value);

    IYourFinancialAssetsSection typeLandSiteNature(String nature);
    IYourFinancialAssetsSection typeLandSiteLocation(String location);
    IYourFinancialAssetsSection typeLandSiteSize(String size);
    IYourFinancialAssetsSection selectLandSiteUnits(String unit);
    IYourFinancialAssetsSection typeLandSiteEstimate(String estimation);

    IYourFinancialAssetsSection typeLifePolicyCompany(String company);
    IYourFinancialAssetsSection typeLifePolicyValue(String value);

    IYourFinancialAssetsSection typeOtherNature(String nature);
    IYourFinancialAssetsSection typeOtherValue(String value);

    IYourFinancialAssetsSection clickCancel();
    IYourFinancialAssetsSection clickAddThisAsset();
    IYourFinancialAssetsSection clickAddAsset();
    IYourFinancialAssetsSection clickNext();
    IYourFinancialAssetsSection clickEditThisAsset();

    String getTitle();
    String getDescription();

    IYourFinancialAssetsSection clickSingleYes();
    IYourFinancialAssetsSection clickSingleNo();
    IYourFinancialAssetsSection clickCoupleYes();
    IYourFinancialAssetsSection clickCoupleNo();

    IYourFinancialAssetsSection selectAssetType(String assetType);
    IYourFinancialAssetsSection checkFinancialAssetAppliedToBorrower(String borrower);
    IYourFinancialAssetsSection checkFinancialAssetAppliedToCoapplicant(String coapplicant);

    IYourFinancialAssetsSection validateFinancialAssets();
}
