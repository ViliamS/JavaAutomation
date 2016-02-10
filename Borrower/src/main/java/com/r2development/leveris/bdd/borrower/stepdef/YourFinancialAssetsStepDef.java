package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.selenium.borrower.pageobjects.IFormsMenu;
import com.r2development.leveris.selenium.borrower.pageobjects.YourFinancialAssetsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;

@Singleton
public class YourFinancialAssetsStepDef extends BorrowerStepDef implements CLV312Workaround {

    private static final Log log = LogFactory.getLog(YourFinancialAssetsStepDef.class);

    public YourFinancialAssetsStepDef() {
        yourFinancialAssetsPage = new YourFinancialAssetsPage(WebDriverService.getWebDriverInstance());
    }

    @When("^user has(n't)? financial assets$")
    public void user_has_financial_assets(String hasFinancialAsset) throws InterruptedException {
        workaroundCLV312(null);

        if (hasFinancialAsset == null) {
            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
                yourFinancialAssetsPage.clickCoupleYes();
            else
                yourFinancialAssetsPage.clickSingleYes();
        }
        else {
            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
                yourFinancialAssetsPage.clickCoupleNo();
            else
                yourFinancialAssetsPage.clickSingleNo();
            yourFinancialAssetsPage.clickNext();
        }
    }

    @Override
    public void workaroundCLV312(String borrowerOrCoapplicant) {
        borrowerHomePage.clickInfoUpload();
        boolean toGoOn = false;
        while ( !toGoOn ) {
            try {
                if ( StringUtils.isEmpty(user.getFirstNameCoApplicant()))
                    borrowerPersonalDetailsPage.clickFinancialAssets();
                else
                    ((IFormsMenu)borrowerPersonalDetailsPage).clickFinancialAssets("double");
                yourFinancialAssetsPage.getTitle();
                toGoOn = true;
            } catch (TimeoutException te) {
                log.debug("Issues of getting Financial Assets page.");
            }
        }
    }

    @And("^user selects (Investment Product Funds / Bonds|Shares|Share Options|Land/Site|Life Policy|Other) as Financial Asset Type$")
    public void user_selects_as_financial_asset_type(String assetType) {
        yourFinancialAssetsPage.selectAssetType(assetType);
    }

    @And("^this financial assets is applied to (borrower|coapplicant|both)$")
    public void this_financial_assets_is_applied_to(String toWhom) {
        switch (toWhom) {
            case "borrower":
                yourFinancialAssetsPage.checkFinancialAssetAppliedToBorrower(user.getFirstName());
                break;
            case "coapplicant":
                yourFinancialAssetsPage.checkFinancialAssetAppliedToCoapplicant(user.getFirstNameCoApplicant());
                break;
            case "both":
                yourFinancialAssetsPage.checkFinancialAssetAppliedToBorrower(user.getFirstName());
                yourFinancialAssetsPage.checkFinancialAssetAppliedToCoapplicant(user.getFirstNameCoApplicant());
                break;
            default:
        }
    }

    @And("^user types Funds/Bonds investment value: (.*)$")
    public void user_types_funds_bonds_investment_value(String investmentValue) {
        yourFinancialAssetsPage.typeFundsBondsInvestment(investmentValue);
    }

    @And("^user types Funds/Bonds institution: (.*)$")
    public void user_types_funds_bonds_institution(String institution) {
        yourFinancialAssetsPage.typeFundsBondsInstitution(institution);
    }

    @And("^user types Funds/Bonds maturity date: (.*)$")
    public void user_types_funds_bonds_maturity_date(String maturityDate) {
        yourFinancialAssetsPage.typeFundsBondsMaturityDate(maturityDate);
    }

    @And("^user clicks \"ADD THIS ASSET\"$")
    public void user_clicks_add_this_asset() {
        yourFinancialAssetsPage.clickAddThisAsset();
    }

    @And("^user clicks \"ADD ASSET\"$")
    public void user_clicks_add_asset() {
        yourFinancialAssetsPage.clickAddAsset();
    }

    @And("^user types Shares company: (.*)$")
    public void user_types_shares_company(String company) {
        yourFinancialAssetsPage.typeSharesCompany(company);
    }

    @And("^user types Shares value: (.*)$")
    public void user_types_shares_value(String value) {
        yourFinancialAssetsPage.typeSharesValue(value);
    }

    @And("^user types Share Option Company: (.*)$")
    public void user_types_share_option_company(String company) {
        yourFinancialAssetsPage.typeShareOptionCompany(company);
    }

    @And("^user types Share Option exercise date: (.*)$")
    public void user_types_share_option_exercise_date(String exerciseDate) {
        yourFinancialAssetsPage.typeShareOptionExerciseDate(exerciseDate);
    }

    @And("^user types Share Option value: (.*)$")
    public void user_types_share_option_value(String value) {
        yourFinancialAssetsPage.typeShareOptionValue(value);
    }

    @And("user types Land/Site nature: (.*)$")
    public void user_type_land_site_nature(String nature) {
        yourFinancialAssetsPage.typeLandSiteNature(nature);
    }

    @And("user types Land/Site location: (.*)$")
    public void user_type_land_site_location(String location) {
        yourFinancialAssetsPage.typeLandSiteLocation(location);
    }

    @And("user types Land/Site size: (.*)$")
    public void user_type_land_site_size(String size) {
        yourFinancialAssetsPage.typeLandSiteSize(size);
    }

    @And("user selects Land/Site units: (Sq. Kilometers|Acres|Hectares)$")
    public void user_selects_land_site_units(String units) {
        yourFinancialAssetsPage.selectLandSiteUnits(units);
    }

    @And("user types Land/Site estimation: (.*)$")
    public void user_type_land_site_estimation(String estimation) {
        yourFinancialAssetsPage.typeLandSiteEstimate(estimation);
    }

    @And("user types Life Policy company: (.*)$")
    public void user_types_life_policy_company(String company) {
        yourFinancialAssetsPage.typeLifePolicyCompany(company);
    }

    @And("user types Life Policy value: (.*)$")
    public void user_types_life_policy_value(String value) {
        yourFinancialAssetsPage.typeLifePolicyValue(value);
    }

    @And("^user types Other financial asset nature: (.*)$")
    public void user_types_other_financial_asset_nature(String nature) {
        yourFinancialAssetsPage.typeOtherNature(nature);
    }

    @And("^user types Other financial asset value: (.*)$")
    public void user_types_other_financial_asset_value(String value) {
        yourFinancialAssetsPage.typeOtherValue(value);
    }

    @And("^user clicks Financial assets \"Next\"$")
    public void user_clicks_financial_assets_next() {
        yourFinancialAssetsPage.clickNext();
    }

    @And("^user verifies financial assets data$")
    public void user_verifies_financial_assets_data() {
        yourFinancialAssetsPage.validateFinancialAssets();
    }

}
