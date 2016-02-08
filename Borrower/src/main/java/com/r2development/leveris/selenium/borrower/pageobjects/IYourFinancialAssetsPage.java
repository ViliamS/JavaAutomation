package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourFinancialAssetsPage {
    IYourFinancialAssetsPage typeFundsBondsInvestment(String fundBondInvestment);
    IYourFinancialAssetsPage typeFundsBondsInstitution(String fundBondInstitution);
    IYourFinancialAssetsPage typeFundsBondsMaturityDate(String fundBondMaturityDate);

    IYourFinancialAssetsPage typeSharesCompany(String sharesCompany);
    IYourFinancialAssetsPage typeSharesValue(String sharesValue);

    IYourFinancialAssetsPage typeShareOptionCompany(String company);
    IYourFinancialAssetsPage typeShareOptionExerciseDate(String exerciseDate);
    IYourFinancialAssetsPage typeShareOptionValue(String value);

    IYourFinancialAssetsPage typeLandSiteNature(String nature);
    IYourFinancialAssetsPage typeLandSiteLocation(String location);
    IYourFinancialAssetsPage typeLandSiteSize(String size);
    IYourFinancialAssetsPage selectLandSiteUnits(String unit);
    IYourFinancialAssetsPage typeLandSiteEstimate(String estimation);

    IYourFinancialAssetsPage typeLifePolicyCompany(String company);
    IYourFinancialAssetsPage typeLifePolicyValue(String value);

    IYourFinancialAssetsPage typeOtherNature(String nature);
    IYourFinancialAssetsPage typeOtherValue(String value);

    IYourFinancialAssetsPage clickCancel();
    IYourFinancialAssetsPage clickAddThisAsset();
    IYourFinancialAssetsPage clickAddAsset();
    IYourFinancialAssetsPage clickNext();
    IYourFinancialAssetsPage clickEditThisAsset();

    String getTitle();
    String getDescription();

    IYourFinancialAssetsPage clickSingleYes();
    IYourFinancialAssetsPage clickSingleNo();
    IYourFinancialAssetsPage clickCoupleYes();
    IYourFinancialAssetsPage clickCoupleNo();

    IYourFinancialAssetsPage selectAssetType(String assetType);
    IYourFinancialAssetsPage checkFinancialAssetAppliedToBorrower(String borrower);
    IYourFinancialAssetsPage checkFinancialAssetAppliedToCoapplicant(String coapplicant);

    IYourFinancialAssetsPage validateFinancialAssets();
}
