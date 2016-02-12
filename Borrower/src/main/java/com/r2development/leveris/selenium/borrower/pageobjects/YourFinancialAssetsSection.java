package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class YourFinancialAssetsSection extends Borrower implements IYourFinancialAssetsSection {

    private static final Log log = LogFactory.getLog(YourFinancialAssetsSection.class);

    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_TITLE_XPATH )
    protected WebElement weYourFinancialAssetsTitle;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_DESCRIPTION_XPATH )
    protected WebElement weYourFinancialAssetDescription;

    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_SINGLE_NO_XPATH )
    protected WebElement weYourFinancialAssetsSingleNo;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_SINGLE_YES_XPATH )
    protected WebElement weYourFinancialAssetsSingleYes;

    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_COUPLE_NO_XPATH )
    protected WebElement weYourFinancialAssetsCoupleNo;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_COUPLE_YES_XPATH )
    protected WebElement weYourFinancialAssetsCoupleYes;

    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_APPLIES_TO_BORROWER_XPATH )
    protected WebElement weYourFinancialAssetsAppliesToBorrower;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_APPLIES_TO_COAPPLICANT_XPATH )
    protected WebElement weYourFinancialAssetsAppliesToCoapplicant;

    // Investment Product Funds / Bonds, Shares, Share Options, Land/Site, Life Policy, Other
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_WHICH_ASSETS_XPATH )
    protected WebElement weYourFinancialAssetsWhichAssets;

    // Investment Product Funds / Bonds
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_FUNDS_BONDS_INVESTMENTS_XPATH )
    protected WebElement weYourFinancialAssetsFundsBondsInvestments;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_FUNDS_BONDS_INSTITUTION_XPATH )
    protected WebElement weYourFinancialAssetsFundsBondsInstitution;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_FUNDS_BONDS_MATURITY_XPATH )
    protected WebElement weYourFinancialAssetsFundsBondsMaturity;

    // Shares
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_SHARES_COMPANY_XPATH )
    protected WebElement weYourFinancialAssetsSharesCompany;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_SHARES_VALUE_XPATH )
    protected WebElement weYourFinancialAssetsSharesValue;

    // Share Options
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_SHARE_OPTION_COMPANY_XPATH )
    protected WebElement weYourFinancialAssetsShareOptionCompany;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_SHARE_OPTION_EXERCISE_DATE_XPATH )
    protected WebElement weYourFinancialAssetsShareOptionExerciseDate;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_SHARE_OPTION_VALUE_XPATH )
    protected WebElement weYourFinancialAssetsShareOptionValue;

    // Land/Site
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_LAND_SITE_NATURE_XPATH )
    protected WebElement weYourFinancialAssetsLandSiteNature;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_LAND_SITE_LOCATION_XPATH )
    protected WebElement weYourFinancialAssetsLandSiteLocation;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_LAND_SITE_SIZE_XPATH )
    protected WebElement weYourFinancialAssetsLandSiteSize;
    // Sq. Kilometers, Acres, Hectares
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_LAND_SITE_UNITS_XPATH )
    protected WebElement weYourFinancialAssetsLandSiteUnits;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_LAND_SITE_ESTIMATE_XPATH )
    protected WebElement weYourFinancialAssetsLandSiteEstimate;

    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_CANCEL_XPATH )
    protected WebElement weYourFinancialAssetsCancel;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_ADD_THIS_ASSETS_XPATH )
    protected WebElement weYourFinancialAssetsAddThisAssets;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_ADD_ASSET_XPATH )
    protected WebElement weYourFinancialAssetsAddAsset;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_NEXT_XPATH )
    protected WebElement weYourFinancialAssetsNext;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_EDIT_THIS_ASSET_XPATH )
    protected WebElement weYourFinancialAssetsEditThisAsset;

    // Life Policy
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_LIFE_POLICY_COMPANY_XPATH )
    protected WebElement weYourFinancialAssetsLifePolicyCompany;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_LIFE_POLICY_VALUE_XPATH )
    protected WebElement weYourFinancialAssetsLifePolicyValue;

    // Other
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_OTHERS_NATURE_XPATH )
    protected WebElement weYourFinancialAssetsOthersNature;
    @FindBy ( xpath = YOUR_FINANCIAL_ASSETS_OTHERS_VALUE_XPATH )
    protected WebElement weYourFinancialAssetsOthersValue;

    @FindBy ( xpath = YOUR_FINANCIAL_ASSET_TOTAL_XPATH )
    protected WebElement weYourFinancialAssetsTotal;

    @Inject
    YourFinancialAssetsSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        return getWebElement(YOUR_FINANCIAL_ASSETS_TITLE_XPATH).getText();
//        return weYourFinancialAssetsTitle.getText();
    }

    @Override
    public String getDescription() {
        return weYourFinancialAssetDescription.getText();
    }

    @Override
    public IYourFinancialAssetsSection typeFundsBondsInvestment(String fundBondInvestment) {
        isVisible(YOUR_FINANCIAL_ASSETS_FUNDS_BONDS_INVESTMENTS_XPATH, true);
        weYourFinancialAssetsFundsBondsInvestments.clear();
        weYourFinancialAssetsFundsBondsInvestments.sendKeys(fundBondInvestment);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeFundsBondsInstitution(String fundBondInstitution) {
        isVisible(YOUR_FINANCIAL_ASSETS_FUNDS_BONDS_INSTITUTION_XPATH, true);
        weYourFinancialAssetsFundsBondsInstitution.clear();
        weYourFinancialAssetsFundsBondsInstitution.sendKeys(fundBondInstitution);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeFundsBondsMaturityDate(String fundBondMaturityDate) {
        isVisible(YOUR_FINANCIAL_ASSETS_FUNDS_BONDS_MATURITY_XPATH, true);
        weYourFinancialAssetsFundsBondsMaturity.clear();
        weYourFinancialAssetsFundsBondsMaturity.sendKeys(fundBondMaturityDate);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeSharesCompany(String sharesCompany) {
        isVisible(YOUR_FINANCIAL_ASSETS_SHARES_COMPANY_XPATH, true);
        weYourFinancialAssetsSharesCompany.clear();
        weYourFinancialAssetsSharesCompany.sendKeys(sharesCompany);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeSharesValue(String sharesValue) {
        isVisible(YOUR_FINANCIAL_ASSETS_SHARES_VALUE_XPATH, true);
        weYourFinancialAssetsSharesValue.clear();
        weYourFinancialAssetsSharesValue.sendKeys(sharesValue);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeShareOptionCompany(String company) {
        isVisible(YOUR_FINANCIAL_ASSETS_SHARE_OPTION_COMPANY_XPATH, true);
        weYourFinancialAssetsShareOptionCompany.clear();
        weYourFinancialAssetsShareOptionCompany.sendKeys(company);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeShareOptionExerciseDate(String exerciseDate) {
        isVisible(YOUR_FINANCIAL_ASSETS_SHARE_OPTION_EXERCISE_DATE_XPATH, true);
        weYourFinancialAssetsShareOptionExerciseDate.clear();
        weYourFinancialAssetsShareOptionExerciseDate.sendKeys(exerciseDate);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeShareOptionValue(String value) {
        isVisible(YOUR_FINANCIAL_ASSETS_SHARE_OPTION_VALUE_XPATH, true);
        weYourFinancialAssetsShareOptionValue.clear();
        weYourFinancialAssetsShareOptionValue.sendKeys(value);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeLandSiteNature(String nature) {
        isVisible(YOUR_FINANCIAL_ASSETS_LAND_SITE_NATURE_XPATH, true);
        weYourFinancialAssetsLandSiteNature.clear();
        weYourFinancialAssetsLandSiteNature.sendKeys(nature);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeLandSiteLocation(String location) {
        isVisible(YOUR_FINANCIAL_ASSETS_LAND_SITE_LOCATION_XPATH, true);
        weYourFinancialAssetsLandSiteLocation.clear();
        weYourFinancialAssetsLandSiteLocation.sendKeys(location);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeLandSiteSize(String size) {
        isVisible(YOUR_FINANCIAL_ASSETS_LAND_SITE_SIZE_XPATH, true);
        weYourFinancialAssetsLandSiteSize.clear();
        weYourFinancialAssetsLandSiteSize.sendKeys(size);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection selectLandSiteUnits(String unit) {
        isVisible(YOUR_FINANCIAL_ASSETS_LAND_SITE_UNITS_XPATH, true);
        selectFromDropDown(YOUR_FINANCIAL_ASSETS_LAND_SITE_UNITS_XPATH, unit);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeLandSiteEstimate(String estimation) {
        isVisible(YOUR_FINANCIAL_ASSETS_LAND_SITE_ESTIMATE_XPATH, true);
        weYourFinancialAssetsLandSiteEstimate.clear();
        weYourFinancialAssetsLandSiteEstimate.sendKeys(estimation);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeLifePolicyCompany(String company) {
        isVisible(YOUR_FINANCIAL_ASSETS_LIFE_POLICY_COMPANY_XPATH, true);
        weYourFinancialAssetsLifePolicyCompany.clear();
        weYourFinancialAssetsLifePolicyCompany.sendKeys(company);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeLifePolicyValue(String value) {
        isVisible(YOUR_FINANCIAL_ASSETS_LIFE_POLICY_VALUE_XPATH, true);
        weYourFinancialAssetsLifePolicyValue.clear();
        weYourFinancialAssetsLifePolicyValue.sendKeys(value);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeOtherNature(String nature) {
        isVisible(YOUR_FINANCIAL_ASSETS_OTHERS_NATURE_XPATH, true);
        weYourFinancialAssetsOthersNature.clear();
        weYourFinancialAssetsOthersNature.sendKeys(nature);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection typeOtherValue(String value) {
        isVisible(YOUR_FINANCIAL_ASSETS_OTHERS_VALUE_XPATH, true);
        weYourFinancialAssetsOthersValue.clear();
        weYourFinancialAssetsOthersValue.sendKeys(value);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection clickCancel() {
        isVisible(YOUR_FINANCIAL_ASSETS_CANCEL_XPATH, true);
        weYourFinancialAssetsCancel.click();
        return this;
    }

    @Override
    public IYourFinancialAssetsSection clickAddThisAsset() {
        isVisible(YOUR_FINANCIAL_ASSETS_ADD_THIS_ASSETS_XPATH, true);
        weYourFinancialAssetsAddThisAssets.click();
        return this;
    }

    @Override
    public IYourFinancialAssetsSection clickAddAsset() {
        isVisible(YOUR_FINANCIAL_ASSETS_ADD_ASSET_XPATH, true);
        weYourFinancialAssetsAddAsset.click();
        return this;
    }

    @Override
    public IYourFinancialAssetsSection clickNext() {
        isVisible(YOUR_FINANCIAL_ASSETS_NEXT_XPATH, true);
//        weYourFinancialAssetsNext.click();
        clickElement(YOUR_FINANCIAL_ASSETS_NEXT_XPATH);
//        if(isVisible(INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection clickEditThisAsset() {
        isVisible(YOUR_FINANCIAL_ASSETS_EDIT_THIS_ASSET_XPATH, true);
        weYourFinancialAssetsEditThisAsset.click();
        return this;
    }

    @Override
    public IYourFinancialAssetsSection clickSingleYes() {
        isVisible(YOUR_FINANCIAL_ASSETS_SINGLE_YES_XPATH, true);
        weYourFinancialAssetsSingleYes.click();
        return this;
    }

    @Override
    public IYourFinancialAssetsSection clickSingleNo() {
//        isVisible(YOUR_FINANCIAL_ASSETS_SINGLE_NO_XPATH, true);
//        weYourFinancialAssetsSingleNo.click();
        clickElement(YOUR_FINANCIAL_ASSETS_SINGLE_NO_XPATH);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection clickCoupleYes() {
        isVisible(YOUR_FINANCIAL_ASSETS_COUPLE_YES_XPATH, true);
//        weYourFinancialAssetsCoupleYes.click();
//        getWebElement(YOUR_FINANCIAL_ASSETS_COUPLE_YES_XPATH, 30).click();
        clickElement(YOUR_FINANCIAL_ASSETS_COUPLE_YES_XPATH);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection clickCoupleNo() {
        isVisible(YOUR_FINANCIAL_ASSETS_COUPLE_NO_XPATH, true);
        weYourFinancialAssetsCoupleNo.click();
        return this;
    }

    @Override
    public IYourFinancialAssetsSection selectAssetType(String assetType) {
        isVisible(YOUR_FINANCIAL_ASSETS_WHICH_ASSETS_XPATH, true);
        selectFromDropDown(YOUR_FINANCIAL_ASSETS_WHICH_ASSETS_XPATH, assetType);
        return this;
    }

    @Override
    public IYourFinancialAssetsSection checkFinancialAssetAppliedToBorrower(String borrower) {
        isVisible(YOUR_FINANCIAL_ASSETS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower), true);
//        getWebElement(YOUR_FINANCIAL_ASSETS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower), 30).click();
        clickElement(YOUR_FINANCIAL_ASSETS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower));
        return this;
    }

    @Override
    public IYourFinancialAssetsSection checkFinancialAssetAppliedToCoapplicant(String coapplicant) {
        isVisible(YOUR_FINANCIAL_ASSETS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant), true);
//        getWebElement(YOUR_FINANCIAL_ASSETS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant), 30).click();
        clickElement(YOUR_FINANCIAL_ASSETS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant));
        return this;
    }

    @Override
    public IYourFinancialAssetsSection validateFinancialAssets() {
        areVisible(YOUR_FINANCIAL_ASSET_REPORTS_XPATH, true, 15);
        List<WebElement> weAsset = getWebElements(YOUR_FINANCIAL_ASSET_REPORTS_XPATH);

        Float computeResult = 0.00f;
        for ( WebElement weCurrent : weAsset) {
            String currentAmount = weCurrent.findElement(By.xpath(".//div[contains(@id, 'Value') and not(contains(@id, 'Title'))]")).getText();
            currentAmount = currentAmount.replace("€", "").replace(",", "").trim();
            computeResult +=  Float.parseFloat(currentAmount);
        }

        assertThat("Amount should be equal", computeResult, Is.is(Float.parseFloat(weYourFinancialAssetsTotal.getText().replace("€", "").replace(",", "").trim())));

        return this;
    }
}
