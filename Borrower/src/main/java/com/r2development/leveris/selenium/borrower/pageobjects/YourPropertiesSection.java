package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourPropertiesSection extends Borrower implements IYourPropertiesSection {

    private static final Log log = LogFactory.getLog(YourPropertiesSection.class);

    @FindBy( xpath = YOUR_PROPERTIES_TITLE_XPATH )
    protected  WebElement weTitle;
    @FindBy( xpath = YOUR_PROPERTIES_DESCRIPTION_XPATH )
    protected WebElement weDescription;

    @FindBy( xpath = YOUR_PROPERTIES_SINGLE_NO_XPATH )
    protected WebElement weSingleNo;
    @FindBy( xpath = YOUR_PROPERTIES_COUPLE_NO_XPATH )
    protected WebElement weCoupleNo;
    @FindBy( xpath = YOUR_PROPERTIES_SINGLE_YES_XPATH )
    protected WebElement weSingleYes;
    @FindBy( xpath = YOUR_PROPERTIES_COUPLE_YES_XPATH )
    protected WebElement weCoupleYes;

    @FindBy( xpath = YOUR_PROPERTIES_PAST_SINGLE_NO_XPATH )
    protected WebElement wePastSingleNo;
    @FindBy( xpath = YOUR_PROPERTIES_PAST_COUPLE_NO_XPATH )
    protected WebElement wePastCoupleNo;
    @FindBy( xpath = YOUR_PROPERTIES_PAST_SINGLE_YES_XPATH )
    protected WebElement wePastSingleYes;
    @FindBy( xpath = YOUR_PROPERTIES_PAST_COUPLE_YES_XPATH )
    protected WebElement wePastCoupleYes;

    @FindBy( xpath = YOUR_PROPERTIES_APPLIES_TO_BORROWER_XPATH )
    protected WebElement weAppliesToBorrower;
    @FindBy( xpath = YOUR_PROPERTIES_APPLIES_TO_COAPPLICANT_XPATH )
    protected WebElement weAppliesToCoapplicant;

    @FindBy( xpath = YOUR_PROPERTIES_OTHER_PARTY_INTEREST_XPATH )
    protected WebElement weOtherPartyInterest;

    @FindBy( xpath = YOUR_PROPERTIES_SELECTED_CATEGORY_XPATH )
    protected WebElement weSelectedCategory;

    // Principal Dwelling House
    @FindBy( xpath = YOUR_PROPERTIES_PDH_SAME_AS_HOME_ADDRESS_XPATH )
    protected WebElement wePDH_SameAsHomeAddress;

    @FindBy( xpath = YOUR_PROPERTIES_PDH_ADDRESS_LINE1_XPATH )
    protected WebElement wePDH_AddressLine1;
    @FindBy( xpath = YOUR_PROPERTIES_PDH_ADDRESS_LINE2_XPATH )
    protected WebElement wePDH_AddressLine2;
    @FindBy( xpath = YOUR_PROPERTIES_PDH_TOWNCITY_XPATH )
    protected WebElement wePDH_TownCity;
    @FindBy( xpath = YOUR_PROPERTIES_PDH_COUNTY_XPATH )       //select
    protected WebElement wePDH_County;
    @FindBy( xpath = YOUR_PROPERTIES_PDH_POSTCODE_XPATH ) //or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:txtPostCode:tb']
    protected WebElement wePDH_Postcode;
    @FindBy( xpath = YOUR_PROPERTIES_PDH_COUNTRY_XPATH ) // or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:cmbCountry:v']      //select
    protected WebElement wePDH_Country;
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    @FindBy( xpath = YOUR_PROPERTIES_PDH_PROPERTY_TYPE_XPATH )        // select
    protected WebElement wePDH_PropertyType;
    @FindBy( xpath = YOUR_PROPERTIES_PDH_NUMBER_BEDROOMS_XPATH ) // or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:txtNumberOfBedrooms:tb']
    protected WebElement wePDH_NumberBedrooms;
    @FindBy( xpath = YOUR_PROPERTIES_PDH_ACQUIRED_YEAR_XPATH )
    protected WebElement wePDH_AcquiredYear;
    @FindBy( xpath = YOUR_PROPERTIES_PDH_ORIGINAL_PURCHASE_PRICE_XPATH ) // or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:crbOrigPurchasePrice:tb']
    protected WebElement wePDH_OriginalPurchasePrice;
    // plan to sel it before you get your home loan
    @FindBy( xpath = YOUR_PROPERTIES_PDH_SELL_PLAN_YES_XPATH )
    protected WebElement wePDH_SellPlanYes;
    @FindBy( xpath = YOUR_PROPERTIES_PDH_SELL_PLAN_NO_XPATH )
    protected WebElement wePDH_SellPlanNo;
    @FindBy( xpath = YOUR_PROPERTIES_PDH_ESTIMATION_PRICE_XPATH ) // or
    protected WebElement wePDH_EstimationPrice;


    //// Yes; No, Mortgage Repaid; No, Never Had a Mortgage
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_QUESTION_XPATH ) // or //input[@name='root:c:w:pnlAddNew:c:w:cmbIsPropertyMortgaged:v'] // Select
    protected WebElement weMortgageQuestion;
    //// yes
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_PROVIDER_XPATH )
    protected WebElement weMortgageProvider;
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_ACCOUNT_NUMBER_XPATH )
    protected WebElement weMortgageAccountNumber;
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_ACCOUNT_BALANCE_XPATH )
    protected WebElement weMortgageAccountBalance;
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_ACCOUNT_MONTHLY_PAYMENT_XPATH )
    protected WebElement weMortgageAccountMonthlyPayment;
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_ACCOUNT_INTEREST_RATE_XPATH )
    protected WebElement weMortgageAccountInterestRate;
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_ACCOUNT_ONLY_INTEREST_XPATH )
    protected WebElement weMortgageAccountOnlyInterest;
    //// Fixed, Variable
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_ACCOUNT_RATE_TYPE )
    protected WebElement weMortgageAccountRateType;
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_YES )
    protected WebElement weMortgageAccount24MonthYes;
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_NO )
    protected WebElement weMortgageAccount24MonthNo;
    @FindBy( xpath = YOUR_PROPERTIES_ADD_ANOTHER_MORTGAGE_ACCOUNT_XPATH )
    protected WebElement weAddAnotherMortgageAccount;
    //// No, Mortgage Repaid
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_REPAID_PROVIDER_XPATH )
    protected WebElement weMortgageRepaidProvider;
    @FindBy( xpath = YOUR_PROPERTIES_MORTGAGE_REPAID_YEAR_XPATH )
    protected WebElement weMortgageRepaidYear;

    // Investment
    @FindBy( xpath = YOUR_PROPERTIES_INV_MONTHLY_RENT_XPATH )
    protected WebElement weINV_MonthlyRent;
    //// Seasonal, Guaranteed
    @FindBy( xpath = YOUR_PROPERTIES_INV_RENT_TYPE_XPATH ) // select
    protected WebElement weINV_RentType;
    @FindBy( xpath = YOUR_PROPERTIES_INV_ADDRESS_LINE1_XPATH )
    protected WebElement weINV_AddressLine1;
    @FindBy( xpath = YOUR_PROPERTIES_INV_ADDRESS_LINE2_XPATH )
    protected WebElement weINV_AddressLine2;
    @FindBy( xpath = YOUR_PROPERTIES_INV_TOWNCITY_XPATH )
    protected WebElement weINV_TownCity;
    @FindBy( xpath = YOUR_PROPERTIES_INV_COUNTY_XPATH )
    protected WebElement weINV_County;
    @FindBy( xpath = YOUR_PROPERTIES_INV_POSTCODE_XPATH )
    protected WebElement weINV_Postcode;
    @FindBy( xpath = YOUR_PROPERTIES_INV_COUNTRY_XPATH )
    protected WebElement weINV_Country;
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    @FindBy( xpath = YOUR_PROPERTIES_INV_PROPERTY_TYPE_XPATH )
    protected WebElement weINV_PropertyType;
    @FindBy( xpath = YOUR_PROPERTIES_INV_NUMBER_BEDROOMS_XPATH )
    protected WebElement weINV_NumberBedrooms;
    @FindBy( xpath = YOUR_PROPERTIES_INV_ACQUIRED_YEAR_XPATH )
    protected WebElement weINV_AcquiredYear;
    @FindBy( xpath = YOUR_PROPERTIES_INV_ORIGINAL_PURCHASE_PRICE_XPATH )
    protected WebElement weINV_OriginalPurchasePrice;
    // plan to sel it before you get your home loan
    @FindBy( xpath = YOUR_PROPERTIES_INV_SELL_PLAN_YES_XPATH )
    protected WebElement weINV_SellPlanYes;
    @FindBy( xpath = YOUR_PROPERTIES_INV_SELL_PLAN_NO_XPATH )
    protected WebElement weINV_SellPlanNo;
    @FindBy( xpath = YOUR_PROPERTIES_INV_ESTIMATION_PRICE_XPATH )
    protected WebElement weINV_EstimationPrice;


    // Holiday Home
    @FindBy( xpath = YOUR_PROPERTIES_HH_MONTHLY_RENT_XPATH )
    protected WebElement weHH_MonthlyRent;
    //// Seasonal, Guaranteed
    @FindBy( xpath = YOUR_PROPERTIES_HH_RENT_TYPE_XPATH )
    protected WebElement weHH_RentType;
    @FindBy( xpath = YOUR_PROPERTIES_HH_ADDRESS_LINE1_XPATH )
    protected WebElement weHH_AddressLine1;
    @FindBy( xpath = YOUR_PROPERTIES_HH_ADDRESS_LINE2_XPATH )
    protected WebElement weHH_AddressLine2;
    @FindBy( xpath = YOUR_PROPERTIES_HH_TOWNCITY_XPATH )
    protected WebElement weHH_TownCity;
    @FindBy( xpath = YOUR_PROPERTIES_HH_COUNTY_XPATH )
    protected WebElement weHH_County;
    @FindBy( xpath = YOUR_PROPERTIES_HH_POSTCODE_XPATH )
    protected WebElement weHH_Postcode;
    @FindBy( xpath = YOUR_PROPERTIES_HH_COUNTRY_XPATH )
    protected WebElement weHH_Country;
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    @FindBy( xpath = YOUR_PROPERTIES_HH_PROPERTY_TYPE_XPATH )
    protected WebElement weHH_PropertyType;
    @FindBy( xpath = YOUR_PROPERTIES_HH_NUMBER_BEDROOMS_XPATH )
    protected WebElement weHH_NumberBedrooms;
    @FindBy( xpath = YOUR_PROPERTIES_HH_ACQUIRED_YEAR_XPATH )
    protected WebElement weHH_AcquiredYear;
    @FindBy( xpath = YOUR_PROPERTIES_HH_ORIGINAL_PURCHASE_PRICE_XPATH )
    protected WebElement weHH_OriginalPurchasePrice;
    // plan to sel it before you get your home loan
    @FindBy( xpath = YOUR_PROPERTIES_HH_SELL_PLAN_YES_XPATH )
    protected WebElement weHH_SellPlanYes;
    @FindBy( xpath = YOUR_PROPERTIES_HH_SELL_PLAN_NO_XPATH )
    protected WebElement weHH_SellPlanNo;
    @FindBy( xpath = YOUR_PROPERTIES_HH_ESTIMATION_PRICE_XPATH )
    protected WebElement weHH_EstimationPrice;



    @FindBy( xpath = YOUR_PROPERTIES_CANCEL_XPATH )
    protected WebElement weCancel;
    @FindBy( xpath = YOUR_PROPERTIES_ADD_THIS_PROPERTY_XPATH )
    protected WebElement weAddThisProperty;
    @FindBy( xpath = YOUR_PROPERTIES_ADD_PROPERTY_XPATH )
    protected WebElement weAddProperty;
    @FindBy( xpath = YOUR_PROPERTIES_NEXT_XPATH )
    protected WebElement weNext;
    @FindBy( xpath = YOUR_PROPERTIES_EDIT_THIS_PROPERTY_XPATH )
    protected WebElement weEditThisProperty;


    YourPropertiesSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    @Override
    public String getYourPropertiesTitle() {
        return getWebElement(YOUR_PROPERTIES_TITLE_XPATH, 10).getText();
//        return weTitle.getText();
    }

    @Override
    public String getYourPropertiesDescription() {
        return weDescription.getText();
    }

    @Override
    public IYourPropertiesSection clickSingleNo() {
        isVisible(YOUR_PROPERTIES_SINGLE_NO_XPATH, true);
        weSingleNo.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickSingleYes() {
        isVisible(YOUR_PROPERTIES_SINGLE_YES_XPATH, true);
        weSingleYes.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickCoupleNo() {
        isVisible(YOUR_PROPERTIES_COUPLE_NO_XPATH, true);
        weCoupleNo.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickCoupleYes() {
        isVisible(YOUR_PROPERTIES_COUPLE_YES_XPATH, true);
        weCoupleYes.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickPastSingleNo() {
        isVisible(YOUR_PROPERTIES_PAST_SINGLE_NO_XPATH, true);
        wePastSingleNo.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickPastSingleYes() {
        isVisible(YOUR_PROPERTIES_PAST_SINGLE_YES_XPATH, true);
        wePastSingleYes.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickPastCoupleNo() {
        isVisible(YOUR_PROPERTIES_PAST_COUPLE_NO_XPATH, true);
        wePastCoupleNo.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickPastCoupleYes() {
        isVisible(YOUR_PROPERTIES_PAST_COUPLE_YES_XPATH, true);
        wePastCoupleYes.click();
        return this;
    }

    @Override
    public IYourPropertiesSection checkThisPropertyAppliesToBorrower(String borrower) {
        isVisible(YOUR_PROPERTIES_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower), true);
        getWebElement(YOUR_PROPERTIES_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower)).click();
        return this;
    }

    @Override
    public IYourPropertiesSection checkThisPropertyAppliedToCoapplicant(String coapplicant) {
        isVisible(YOUR_PROPERTIES_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant), true);
        getWebElement(YOUR_PROPERTIES_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant)).click();
        return this;
    }

    @Override
    public IYourPropertiesSection checkOtherPartyInterest() {
        isVisible(YOUR_PROPERTIES_OTHER_PARTY_INTEREST_XPATH, true);
        weOtherPartyInterest.click();
        return this;
    }

    @Override
    public IYourPropertiesSection selectPropertiesCategory(String propertyCategory) {
        isVisible(YOUR_PROPERTIES_SELECTED_CATEGORY_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_SELECTED_CATEGORY_XPATH, propertyCategory);
        return this;
    }

    @Override
    public IYourPropertiesSection clickPDH_SameAsHomeAddress() {
        isVisible(YOUR_PROPERTIES_PDH_SAME_AS_HOME_ADDRESS_XPATH, true);
        wePDH_SameAsHomeAddress.click();
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_AddressLine1(String addressLine1) {
        isVisible(YOUR_PROPERTIES_PDH_ADDRESS_LINE1_XPATH, true);
        wePDH_AddressLine1.clear();
        wePDH_AddressLine1.sendKeys(addressLine1);
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_AddressLine2(String addressLine2) {
        isVisible(YOUR_PROPERTIES_PDH_ADDRESS_LINE2_XPATH, true);
        wePDH_AddressLine2.clear();
        wePDH_AddressLine2.sendKeys(addressLine2);
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_TownCity(String townCity) {
        isVisible(YOUR_PROPERTIES_PDH_TOWNCITY_XPATH, true);
        wePDH_TownCity.clear();
        wePDH_TownCity.sendKeys(townCity);
        return this;
    }

    @Override
    public IYourPropertiesSection selectPDH_County(String county) {
        isVisible(YOUR_PROPERTIES_PDH_COUNTY_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_PDH_COUNTY_XPATH, county);
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_Postcode(String postcode) {
        isVisible(YOUR_PROPERTIES_PDH_POSTCODE_XPATH, true);
        wePDH_Postcode.clear();
        wePDH_Postcode.sendKeys(postcode);
        return this;
    }

    @Override
    public IYourPropertiesSection selectPDH_Country(String country) {
        isVisible(YOUR_PROPERTIES_PDH_COUNTRY_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_PDH_COUNTRY_XPATH, country);
        return this;
    }

    @Override
    public IYourPropertiesSection selectPDH_PropertyType(String propertyType) {
        isVisible(YOUR_PROPERTIES_PDH_PROPERTY_TYPE_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_PDH_PROPERTY_TYPE_XPATH, propertyType);
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_NumberBedrooms(String numberBedrooms) {
        isVisible(YOUR_PROPERTIES_PDH_NUMBER_BEDROOMS_XPATH, true);
        wePDH_NumberBedrooms.clear();
        wePDH_NumberBedrooms.sendKeys(numberBedrooms);
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_AcquiredYear(String acquiredYear) {
        isVisible(YOUR_PROPERTIES_PDH_ACQUIRED_YEAR_XPATH, true);
        wePDH_AcquiredYear.clear();
        wePDH_AcquiredYear.sendKeys(acquiredYear);
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_OriginalPurchasePrice(String originalPurchasePrice) {
        isVisible(YOUR_PROPERTIES_PDH_ORIGINAL_PURCHASE_PRICE_XPATH, true);
        wePDH_OriginalPurchasePrice.clear();
        wePDH_OriginalPurchasePrice.sendKeys(originalPurchasePrice);
        return this;
    }

    @Override
    public IYourPropertiesSection clickPDH_SellPlanYes() {
        isVisible(YOUR_PROPERTIES_PDH_SELL_PLAN_YES_XPATH, true);
        wePDH_SellPlanYes.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickPDH_SellPlanNo() {
        isVisible(YOUR_PROPERTIES_PDH_SELL_PLAN_YES_XPATH, true);
        wePDH_SellPlanNo.click();
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_EstimationPrice(String estimationPrice) {
        isVisible(YOUR_PROPERTIES_PDH_ESTIMATION_PRICE_XPATH, true);
        wePDH_EstimationPrice.clear();
        wePDH_EstimationPrice.sendKeys(estimationPrice);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_MonthlyRent(String monthlyRent) {
        isVisible(YOUR_PROPERTIES_INV_MONTHLY_RENT_XPATH, true);
        weINV_MonthlyRent.clear();
        weINV_MonthlyRent.sendKeys(monthlyRent);
        return this;
    }

    @Override
    public IYourPropertiesSection selectINV_RentType(String rentType) {
        isVisible(YOUR_PROPERTIES_INV_RENT_TYPE_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_INV_RENT_TYPE_XPATH, rentType);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_AddressLine1(String addressLine1) {
        isVisible(YOUR_PROPERTIES_INV_ADDRESS_LINE1_XPATH, true);
        weINV_AddressLine1.clear();
        weINV_AddressLine1.sendKeys(addressLine1);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_AddressLine2(String addressLine2) {
        isVisible(YOUR_PROPERTIES_INV_ADDRESS_LINE2_XPATH, true);
        weINV_AddressLine2.clear();
        weINV_AddressLine2.sendKeys(addressLine2);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_TownCity(String townCity) {
        isVisible(YOUR_PROPERTIES_INV_TOWNCITY_XPATH, true);
        weINV_TownCity.clear();
        weINV_TownCity.sendKeys(townCity);
        return this;
    }

    @Override
    public IYourPropertiesSection selectINV_County(String county) {
        isVisible(YOUR_PROPERTIES_INV_COUNTY_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_INV_COUNTY_XPATH, county);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_Postcode(String postcode) {
        isVisible(YOUR_PROPERTIES_INV_POSTCODE_XPATH, true);
        weINV_Postcode.clear();
        weINV_Postcode.sendKeys(postcode);
        return this;
    }

    @Override
    public IYourPropertiesSection selectINV_Country(String country) {
        isVisible(YOUR_PROPERTIES_INV_COUNTRY_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_INV_COUNTRY_XPATH, country);
        return this;
    }

    @Override
    public IYourPropertiesSection selectINV_PropertyType(String propertyType) {
        isVisible(YOUR_PROPERTIES_INV_PROPERTY_TYPE_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_INV_PROPERTY_TYPE_XPATH, propertyType);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_NumberBedrooms(String numberBedrooms) {
        isVisible(YOUR_PROPERTIES_INV_NUMBER_BEDROOMS_XPATH, true);
        weINV_NumberBedrooms.clear();
        weINV_NumberBedrooms.sendKeys(numberBedrooms);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_AcquiredYear(String acquiredYear) {
        isVisible(YOUR_PROPERTIES_INV_ACQUIRED_YEAR_XPATH, true);
        weINV_AcquiredYear.clear();
        weINV_AcquiredYear.sendKeys(acquiredYear);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_OriginalPurchasePrice(String originalPurchasePrice) {
        isVisible(YOUR_PROPERTIES_INV_ORIGINAL_PURCHASE_PRICE_XPATH, true);
        weINV_OriginalPurchasePrice.clear();
        weINV_OriginalPurchasePrice.sendKeys(originalPurchasePrice);
        return this;
    }

    @Override
    public IYourPropertiesSection clickINV_SellPlanYes() {
        isVisible(YOUR_PROPERTIES_INV_SELL_PLAN_YES_XPATH, true);
        weINV_SellPlanYes.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickINV_SellPlanNo() {
        isVisible(YOUR_PROPERTIES_INV_SELL_PLAN_NO_XPATH, true);
        weINV_SellPlanNo.click();
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_EstimationPrice(String estimationPrice) {
        isVisible(YOUR_PROPERTIES_INV_ESTIMATION_PRICE_XPATH, true);
        weINV_EstimationPrice.clear();
        weINV_EstimationPrice.sendKeys(estimationPrice);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_MonthlyRent(String monthlyRent) {
        isVisible(YOUR_PROPERTIES_HH_MONTHLY_RENT_XPATH, true);
        weHH_MonthlyRent.clear();
        weHH_MonthlyRent.sendKeys(monthlyRent);
        return this;
    }

    @Override
    public IYourPropertiesSection selectHH_RentType(String rentType) {
        isVisible(YOUR_PROPERTIES_HH_RENT_TYPE_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_HH_RENT_TYPE_XPATH, rentType);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_AddressLine1(String addressLine1) {
        isVisible(YOUR_PROPERTIES_HH_ADDRESS_LINE1_XPATH, true);
        weHH_AddressLine1.clear();
        weHH_AddressLine1.sendKeys(addressLine1);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_AddressLine2(String addressLine2) {
        isVisible(YOUR_PROPERTIES_HH_ADDRESS_LINE2_XPATH, true);
        weHH_AddressLine2.clear();
        weHH_AddressLine2.sendKeys(addressLine2);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_TownCity(String townCity) {
        isVisible(YOUR_PROPERTIES_HH_TOWNCITY_XPATH, true);
        weHH_TownCity.clear();
        weHH_TownCity.sendKeys(townCity);
        return this;
    }

    @Override
    public IYourPropertiesSection selectHH_County(String county) {
        isVisible(YOUR_PROPERTIES_HH_COUNTY_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_HH_COUNTY_XPATH, county);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_Postcode(String postcode) {
        isVisible(YOUR_PROPERTIES_HH_POSTCODE_XPATH, true);
        weHH_Postcode.clear();
        weHH_Postcode.sendKeys(postcode);
        return this;
    }

    @Override
    public IYourPropertiesSection selectHH_Country(String country) {
        isVisible(YOUR_PROPERTIES_HH_COUNTRY_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_HH_COUNTRY_XPATH, country);
        return this;
    }

    @Override
    public IYourPropertiesSection selectHH_PropertyType(String propertyType) {
        isVisible(YOUR_PROPERTIES_HH_PROPERTY_TYPE_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_HH_PROPERTY_TYPE_XPATH, propertyType);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_NumberBedrooms(String numberBedrooms) {
        isVisible(YOUR_PROPERTIES_HH_NUMBER_BEDROOMS_XPATH, true);
        weHH_NumberBedrooms.clear();
        weHH_NumberBedrooms.sendKeys(numberBedrooms);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_AcquiredYear(String acquiredYear) {
        isVisible(YOUR_PROPERTIES_HH_ACQUIRED_YEAR_XPATH, true);
        weHH_AcquiredYear.clear();
        weHH_AcquiredYear.sendKeys(acquiredYear);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_OriginalPurchasePrice(String originalPurchasePrice) {
        isVisible(YOUR_PROPERTIES_HH_ORIGINAL_PURCHASE_PRICE_XPATH, true);
        weHH_OriginalPurchasePrice.clear();
        weHH_OriginalPurchasePrice.sendKeys(originalPurchasePrice);
        return this;
    }

    @Override
    public IYourPropertiesSection clickHH_SellPlanYes() {
        isVisible(YOUR_PROPERTIES_HH_SELL_PLAN_YES_XPATH, true);
        weHH_SellPlanYes.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickHH_SellPlanNo() {
        isVisible(YOUR_PROPERTIES_HH_SELL_PLAN_NO_XPATH, true);
        weHH_SellPlanNo.click();
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_EstimationPrice(String estimationPrice) {
        isVisible(YOUR_PROPERTIES_HH_ESTIMATION_PRICE_XPATH, true);
        weHH_EstimationPrice.click();
        weHH_EstimationPrice.sendKeys(estimationPrice);
        return this;
    }

    @Override
    public IYourPropertiesSection clickAddAnotherMortgageAccount() {
        isVisible(YOUR_PROPERTIES_ADD_ANOTHER_MORTGAGE_ACCOUNT_XPATH, true);
        weAddAnotherMortgageAccount.click();
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_MortgageRepaidProvider(String mortgageRepaidProvider) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_REPAID_PROVIDER_XPATH, true);
        weMortgageRepaidProvider.clear();
        weMortgageRepaidProvider.sendKeys(mortgageRepaidProvider);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_MortgageRepaidProvider(String mortgageRepaidProvider) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_REPAID_PROVIDER_XPATH, true);
        weMortgageRepaidProvider.clear();
        weMortgageRepaidProvider.sendKeys(mortgageRepaidProvider);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_MortgageRepaidProvider(String mortgageRepaidProvider) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_REPAID_PROVIDER_XPATH, true);
        weMortgageRepaidProvider.clear();
        weMortgageRepaidProvider.sendKeys(mortgageRepaidProvider);
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_MortgageRepaidYear(String mortgageRepaidYear) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_REPAID_YEAR_XPATH, true);
        weMortgageRepaidYear.clear();
        weMortgageRepaidYear.sendKeys(mortgageRepaidYear);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_MortgageRepaidYear(String mortgageRepaidYear) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_REPAID_YEAR_XPATH, true);
        weMortgageRepaidYear.clear();
        weMortgageRepaidYear.sendKeys(mortgageRepaidYear);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_MortgageRepaidYear(String mortgageRepaidYear) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_REPAID_YEAR_XPATH, true);
        weMortgageRepaidYear.clear();
        weMortgageRepaidYear.sendKeys(mortgageRepaidYear);
        return this;
    }

    @Override
    public IYourPropertiesSection clickCancel() {
        isVisible(YOUR_PROPERTIES_CANCEL_XPATH, true);
        weCancel.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickAddThisProperty() {
        isVisible(YOUR_PROPERTIES_ADD_THIS_PROPERTY_XPATH, true);
        weAddThisProperty.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickAddProperty() {
        isVisible(YOUR_PROPERTIES_ADD_PROPERTY_XPATH, true);
        weAddProperty.click();
        return this;
    }

    @Override
    public IYourPropertiesSection clickNext() {
        isVisible(YOUR_PROPERTIES_NEXT_XPATH, true);
        clickElement(YOUR_PROPERTIES_NEXT_XPATH);
//        weNext.click();
//        if(isVisible(INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }

    @Override
    public IYourPropertiesSection clickNextSection() {
        isVisible(YOUR_PROPERTIES_NEXT_SECTION_XPATH, true);
        clickElement(YOUR_PROPERTIES_NEXT_SECTION_XPATH);
        return this;
    }

    @Override
    public IYourPropertiesSection clickEditThisProperty() {
        isVisible(YOUR_PROPERTIES_EDIT_THIS_PROPERTY_XPATH, true);
        weEditThisProperty.click();
        return this;
    }


    @Override
    public IYourPropertiesSection selectPDH_MortgageQuestion(String mortgageQuestion) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_QUESTION_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_MORTGAGE_QUESTION_XPATH, mortgageQuestion);
        return this;
    }

    @Override
    public IYourPropertiesSection selectINV_MortgageQuestion(String mortgageQuestion) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_QUESTION_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_MORTGAGE_QUESTION_XPATH, mortgageQuestion);
        return this;
    }

    @Override
    public IYourPropertiesSection selectHH_MortgageQuestion(String mortgageQuestion) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_QUESTION_XPATH, true);
        selectFromDropDown(YOUR_PROPERTIES_MORTGAGE_QUESTION_XPATH, mortgageQuestion);
        return this;
    }

    @Override
    public IYourPropertiesSection typePDH_MortgageProvider(String mortgageType) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_PROVIDER_XPATH, true);
        weMortgageProvider.clear();
        weMortgageProvider.sendKeys(mortgageType);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_MortgageProvider(String mortgageType) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_PROVIDER_XPATH, true);
        weMortgageProvider.click();
        weMortgageProvider.sendKeys(mortgageType);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_MortgageProvider(String mortgageType) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_PROVIDER_XPATH, true);
        weMortgageProvider.click();
        weMortgageProvider.sendKeys(mortgageType);
        return this;
    }

    private void type_mortgageAccountNumber(String accountNumber, String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_NUMBER_XPATH.replace("${replaceIndex}$", index), true);
        WebElement currentWE = getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_NUMBER_XPATH.replace("${replaceIndex}$", index));
        currentWE.clear();
        currentWE.sendKeys(accountNumber);
    }

    @Override
    public IYourPropertiesSection typePDH_MortgageAccountNumber(String accountNumber, String index) {
        type_mortgageAccountNumber(accountNumber, index);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_MortgageAccountNumber(String accountNumber, String index) {
        type_mortgageAccountNumber(accountNumber, index);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_MortgageAccountNumber(String accountNumber, String index) {
        type_mortgageAccountNumber(accountNumber, index);
        return this;
    }

    private void type_MortgageAccountBalance(String accountBalance, String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_BALANCE_XPATH.replace("${replaceIndex}$", index), true);
        WebElement currentWE = getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_BALANCE_XPATH.replace("${replaceIndex}$", index));
        currentWE.clear();
        currentWE.sendKeys(accountBalance);
    }

    @Override
    public IYourPropertiesSection typePDH_MortgageAccountBalance(String accountBalance, String index) {
        type_MortgageAccountBalance(accountBalance, index);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_MortgageAccountBalance(String accountBalance, String index) {
        type_MortgageAccountBalance(accountBalance, index);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_MortgageAccountBalance(String accountBalance, String index) {
        type_MortgageAccountBalance(accountBalance, index);
        return this;
    }

    public void type_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_MONTHLY_PAYMENT_XPATH.replace("${replaceIndex}$", index), true);
        WebElement currentWE = getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_MONTHLY_PAYMENT_XPATH.replace("${replaceIndex}$", index));
        currentWE.clear();
        currentWE.sendKeys(accountMonthlyPayment);
    }

    @Override
    public IYourPropertiesSection typePDH_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index) {
        type_MortgageAccountMonthlyPayment(accountMonthlyPayment, index);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index) {
        type_MortgageAccountMonthlyPayment(accountMonthlyPayment, index);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index) {
        type_MortgageAccountMonthlyPayment(accountMonthlyPayment, index);
        return this;
    }

    public void type_MortgageAccountInterestRate(String accountInterestRate, String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_INTEREST_RATE_XPATH.replace("${replaceIndex}$", index), true);
        WebElement currentWE = getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_INTEREST_RATE_XPATH.replace("${replaceIndex}$", index));
        currentWE.clear();
        currentWE.sendKeys(accountInterestRate);
    }

    @Override
    public IYourPropertiesSection typePDH_MortgageAccountInterestRate(String accountInterestRate, String index) {
        type_MortgageAccountInterestRate(accountInterestRate, index);
        return this;
    }

    @Override
    public IYourPropertiesSection typeINV_MortgageAccountInterestRate(String accountInterestRate, String index) {
        type_MortgageAccountInterestRate(accountInterestRate, index);
        return this;
    }

    @Override
    public IYourPropertiesSection typeHH_MortgageAccountInterestRate(String accountInterestRate, String index) {
        type_MortgageAccountInterestRate(accountInterestRate, index);
        return this;
    }

    @Override
    public IYourPropertiesSection checkPDH_MortgageAccountOnlyInterest(String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_ONLY_INTEREST_XPATH.replace("${replaceIndex}$", index), true);
        getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_ONLY_INTEREST_XPATH.replace("${replaceIndex}$", index)).click();
        return this;
    }

    @Override
    public IYourPropertiesSection checkINV_MortgageAccountOnlyInterest(String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_ONLY_INTEREST_XPATH.replace("${replaceIndex}$", index), true);
        getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_ONLY_INTEREST_XPATH.replace("${replaceIndex}$", index)).click();
        return this;
    }

    @Override
    public IYourPropertiesSection checkHH_MortgageAccountOnlyInterest(String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_ONLY_INTEREST_XPATH.replace("${replaceIndex}$", index), true);
        getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_ONLY_INTEREST_XPATH.replace("${replaceIndex}$", index)).click();
        return this;
    }

    @Override
    public IYourPropertiesSection selectPDH_MortgageAccountRateType(String accountRateType, String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_RATE_TYPE.replace("${replaceIndex}$", index), true);
        selectFromDropDown(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_RATE_TYPE.replace("${replaceIndex}$", index), accountRateType);
        return this;
    }

    @Override
    public IYourPropertiesSection selectINV_MortgageAccountRateType(String accountRateType, String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_RATE_TYPE.replace("${replaceIndex}$", index), true);
        selectFromDropDown(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_RATE_TYPE.replace("${replaceIndex}$", index), accountRateType);
        return this;
    }

    @Override
    public IYourPropertiesSection selectHH_MortgageAccountRateType(String accountRateType, String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_RATE_TYPE.replace("${replaceIndex}$", index), true);
        selectFromDropDown(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_RATE_TYPE.replace("${replaceIndex}$", index), accountRateType);
        return this;
    }

    @Override
    public IYourPropertiesSection checkPDH_MortgageAccount24MonthYes(String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_YES.replace("${replaceIndex}$", index), true);
        getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_YES.replace("${replaceIndex}$", index)).click();
        return this;
    }

    @Override
    public IYourPropertiesSection checkINV_MortgageAccount24MonthYes(String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_YES.replace("${replaceIndex}$", index), true);
        getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_YES.replace("${replaceIndex}$", index)).click();
        return this;
    }

    @Override
    public IYourPropertiesSection checkHH_MortgageAccount24MonthYes(String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_YES.replace("${replaceIndex}$", index), true);
        getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_YES.replace("${replaceIndex}$", index)).click();
        return this;
    }

    @Override
    public IYourPropertiesSection checkPDH_MortgageAccount24MonthNo(String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_NO.replace("${replaceIndex}$", index), true);
        getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_NO.replace("${replaceIndex}$", index)).click();
        return this;
    }

    @Override
    public IYourPropertiesSection checkINV_MortgageAccount24MonthNo(String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_NO.replace("${replaceIndex}$", index), true);
        getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_NO.replace("${replaceIndex}$", index)).click();
        return this;
    }

    @Override
    public IYourPropertiesSection checkHH_MortgageAccount24MonthNo(String index) {
        isVisible(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_NO.replace("${replaceIndex}$", index), true);
        getWebElement(YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_NO.replace("${replaceIndex}$", index)).click();
        return this;
    }
}
