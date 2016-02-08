package com.r2development.leveris.selenium.borrower.pageobjects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class YourFinancialAssetsPage extends HeaderAndBottomAndFormsMenuSection implements IYourFinancialAssetsPage {

    private static final Log log = LogFactory.getLog(YourFinancialAssetsPage.class);

    protected IYourFinancialAssetsSection yourFinancialAssetsSection;
    
    public YourFinancialAssetsPage(WebDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        yourFinancialAssetsSection = new YourFinancialAssetsSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public IYourFinancialAssetsPage typeFundsBondsInvestment(String fundBondInvestment) {
        yourFinancialAssetsSection.typeFundsBondsInvestment(fundBondInvestment);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeFundsBondsInstitution(String fundBondInstitution) {
        yourFinancialAssetsSection.typeFundsBondsInstitution(fundBondInstitution);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeFundsBondsMaturityDate(String fundBondMaturityDate) {
        yourFinancialAssetsSection.typeFundsBondsMaturityDate(fundBondMaturityDate);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeSharesCompany(String sharesCompany) {
        yourFinancialAssetsSection.typeSharesCompany(sharesCompany);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeSharesValue(String sharesValue) {
        yourFinancialAssetsSection.typeSharesValue(sharesValue);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeShareOptionCompany(String company) {
        yourFinancialAssetsSection.typeShareOptionCompany(company);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeShareOptionExerciseDate(String exerciseDate) {
        yourFinancialAssetsSection.typeShareOptionExerciseDate(exerciseDate);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeShareOptionValue(String value) {
        yourFinancialAssetsSection.typeShareOptionValue(value);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeLandSiteNature(String nature) {
        yourFinancialAssetsSection.typeLandSiteNature(nature);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeLandSiteLocation(String location) {
        yourFinancialAssetsSection.typeLandSiteLocation(location);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeLandSiteSize(String size) {
        yourFinancialAssetsSection.typeLandSiteSize(size);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage selectLandSiteUnits(String unit) {
        yourFinancialAssetsSection.selectLandSiteUnits(unit);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeLandSiteEstimate(String estimation) {
        yourFinancialAssetsSection.typeLandSiteEstimate(estimation);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeLifePolicyCompany(String company) {
        yourFinancialAssetsSection.typeLifePolicyCompany(company);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeLifePolicyValue(String value) {
        yourFinancialAssetsSection.typeLifePolicyValue(value);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeOtherNature(String nature) {
        yourFinancialAssetsSection.typeOtherNature(nature);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage typeOtherValue(String value) {
        yourFinancialAssetsSection.typeOtherValue(value);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage clickCancel() {
        yourFinancialAssetsSection.clickCancel();
        return this;
    }

    @Override
    public IYourFinancialAssetsPage clickAddThisAsset() {
        yourFinancialAssetsSection.clickAddThisAsset();
        return this;
    }

    @Override
    public IYourFinancialAssetsPage clickAddAsset() {
        yourFinancialAssetsSection.clickAddAsset();
        return this;
    }

    @Override
    public IYourFinancialAssetsPage clickNext() {
        yourFinancialAssetsSection.clickNext();
        return this;
    }

    @Override
    public IYourFinancialAssetsPage clickEditThisAsset() {
        yourFinancialAssetsSection.clickEditThisAsset();
        return this;
    }

    @Override
    public String getTitle() {
        return yourFinancialAssetsSection.getTitle();
    }

    @Override
    public String getDescription() {
        return yourFinancialAssetsSection.getDescription();
    }

    @Override
    public IYourFinancialAssetsPage clickSingleYes() {
        yourFinancialAssetsSection.clickSingleYes();
        return this;
    }

    @Override
    public IYourFinancialAssetsPage clickSingleNo() {
        yourFinancialAssetsSection.clickSingleNo();
        return this;
    }

    @Override
    public IYourFinancialAssetsPage clickCoupleYes() {
        yourFinancialAssetsSection.clickCoupleYes();
        return this;
    }

    @Override
    public IYourFinancialAssetsPage clickCoupleNo() {
        yourFinancialAssetsSection.clickCoupleNo();
        return this;
    }

    @Override
    public IYourFinancialAssetsPage selectAssetType(String assetType) {
        yourFinancialAssetsSection.selectAssetType(assetType);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage checkFinancialAssetAppliedToBorrower(String borrower) {
        yourFinancialAssetsSection.checkFinancialAssetAppliedToBorrower(borrower);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage checkFinancialAssetAppliedToCoapplicant(String coapplicant) {
        yourFinancialAssetsSection.checkFinancialAssetAppliedToCoapplicant(coapplicant);
        return this;
    }

    @Override
    public IYourFinancialAssetsPage validateFinancialAssets() {
        yourFinancialAssetsSection.validateFinancialAssets();
        return this;
    }
}
