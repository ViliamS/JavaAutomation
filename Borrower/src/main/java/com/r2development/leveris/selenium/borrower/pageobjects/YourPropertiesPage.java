package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class YourPropertiesPage extends HeaderAndBottomAndFormsMenuSection implements IYourPropertiesPage {

    private static final Log log = LogFactory.getLog(YourPropertiesPage.class);

    protected IYourPropertiesSection yourPropertiesSection;

    @Inject
    public YourPropertiesPage(WebDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        yourPropertiesSection = new YourPropertiesSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public String getYourPropertiesTitle() {
        return yourPropertiesSection.getYourPropertiesTitle();
    }

    @Override
    public String getYourPropertiesDescription() {
        return yourPropertiesSection.getYourPropertiesDescription();
    }

    @Override
    public IYourPropertiesPage clickSingleNo() {
        yourPropertiesSection.clickSingleNo();
        return this;
    }

    @Override
    public IYourPropertiesPage clickSingleYes() {
        yourPropertiesSection.clickSingleYes();
        return this;
    }

    @Override
    public IYourPropertiesPage clickCoupleNo() {
        yourPropertiesSection.clickCoupleNo();
        return this;
    }

    @Override
    public IYourPropertiesPage clickCoupleYes() {
        yourPropertiesSection.clickCoupleYes();
        return this;
    }

    @Override
    public IYourPropertiesPage clickPastSingleNo() {
        yourPropertiesSection.clickPastSingleNo();
        return this;
    }

    @Override
    public IYourPropertiesPage clickPastSingleYes() {
        yourPropertiesSection.clickPastSingleYes();
        return this;
    }

    @Override
    public IYourPropertiesPage clickPastCoupleNo() {
        yourPropertiesSection.clickPastCoupleNo();
        return this;
    }

    @Override
    public IYourPropertiesPage clickPastCoupleYes() {
        yourPropertiesSection.clickPastCoupleYes();
        return this;
    }

    @Override
    public IYourPropertiesPage checkThisPropertyAppliesToBorrower(String borrower) {
        yourPropertiesSection.checkThisPropertyAppliesToBorrower(borrower);
		return this;
    }

    @Override
    public IYourPropertiesPage checkThisPropertyAppliedToCoapplicant(String coapplicant) {
        yourPropertiesSection.checkThisPropertyAppliedToCoapplicant(coapplicant);
		return this;
    }

    @Override
    public IYourPropertiesPage checkOtherPartyInterest() {
        yourPropertiesSection.checkOtherPartyInterest();
		return this;
    }

    @Override
    public IYourPropertiesPage selectPropertiesCategory(String propertyCategory) {
        yourPropertiesSection.selectPropertiesCategory(propertyCategory);
		return this;
    }

    @Override
    public IYourPropertiesPage clickPDH_SameAsHomeAddress() {
        yourPropertiesSection.clickPDH_SameAsHomeAddress();
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_AddressLine1(String addressLine1) {
        yourPropertiesSection.typePDH_AddressLine1(addressLine1);
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_AddressLine2(String addressLine2) {
        yourPropertiesSection.typePDH_AddressLine2(addressLine2);
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_TownCity(String townCity) {
        yourPropertiesSection.typePDH_TownCity(townCity);
		return this;
    }

    @Override
    public IYourPropertiesPage selectPDH_County(String county) {
        yourPropertiesSection.selectPDH_County(county);
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_Postcode(String postcode) {
        yourPropertiesSection.typePDH_Postcode(postcode);
		return this;
    }

    @Override
    public IYourPropertiesPage selectPDH_Country(String country) {
        yourPropertiesSection.selectPDH_Country(country);
		return this;
    }

    @Override
    public IYourPropertiesPage selectPDH_PropertyType(String propertyType) {
        yourPropertiesSection.selectPDH_PropertyType(propertyType);
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_NumberBedrooms(String numberBedrooms) {
        yourPropertiesSection.typePDH_NumberBedrooms(numberBedrooms);
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_AcquiredYear(String acquiredYear) {
        yourPropertiesSection.typePDH_AcquiredYear(acquiredYear);
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_OriginalPurchasePrice(String originalPurchasePrice) {
        yourPropertiesSection.typePDH_OriginalPurchasePrice(originalPurchasePrice);
		return this;
    }

    @Override
    public IYourPropertiesPage clickPDH_SellPlanYes() {
        yourPropertiesSection.clickPDH_SellPlanYes();
		return this;
    }

    @Override
    public IYourPropertiesPage clickPDH_SellPlanNo() {
        yourPropertiesSection.clickPDH_SellPlanNo();
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_EstimationPrice(String estimationPrice) {
        yourPropertiesSection.typePDH_EstimationPrice(estimationPrice);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_MonthlyRent(String monthlyRent) {
        yourPropertiesSection.typeINV_MonthlyRent(monthlyRent);
		return this;
    }

    @Override
    public IYourPropertiesPage selectINV_RentType(String rentType) {
        yourPropertiesSection.selectINV_RentType(rentType);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_AddressLine1(String addressLine1) {
        yourPropertiesSection.typeINV_AddressLine1(addressLine1);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_AddressLine2(String addressLine2) {
        yourPropertiesSection.typeINV_AddressLine2(addressLine2);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_TownCity(String townCity) {
        yourPropertiesSection.typeINV_TownCity(townCity);
		return this;
    }

    @Override
    public IYourPropertiesPage selectINV_County(String county) {
        yourPropertiesSection.selectINV_County(county);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_Postcode(String postcode) {
        yourPropertiesSection.typeINV_Postcode(postcode);
		return this;
    }

    @Override
    public IYourPropertiesPage selectINV_Country(String country) {
        yourPropertiesSection.selectINV_Country(country);
		return this;
    }

    @Override
    public IYourPropertiesPage selectINV_PropertyType(String propertyType) {
        yourPropertiesSection.selectINV_PropertyType(propertyType);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_NumberBedrooms(String numberBedrooms) {
        yourPropertiesSection.typeINV_NumberBedrooms(numberBedrooms);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_AcquiredYear(String acquiredYear) {
        yourPropertiesSection.typeINV_AcquiredYear(acquiredYear);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_OriginalPurchasePrice(String originalPurchasePrice) {
        yourPropertiesSection.typeINV_OriginalPurchasePrice(originalPurchasePrice);
		return this;
    }

    @Override
    public IYourPropertiesPage clickINV_SellPlanYes() {
        yourPropertiesSection.clickINV_SellPlanYes();
		return this;
    }

    @Override
    public IYourPropertiesPage clickINV_SellPlanNo() {
        yourPropertiesSection.clickINV_SellPlanNo();
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_EstimationPrice(String estimationPrice) {
        yourPropertiesSection.typeINV_EstimationPrice(estimationPrice);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_MonthlyRent(String monthlyRent) {
        yourPropertiesSection.typeHH_MonthlyRent(monthlyRent);
		return this;
    }

    @Override
    public IYourPropertiesPage selectHH_RentType(String rentType) {
        yourPropertiesSection.selectHH_RentType(rentType);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_AddressLine1(String addressLine1) {
        yourPropertiesSection.typeHH_AddressLine1(addressLine1);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_AddressLine2(String addressLine2) {
        yourPropertiesSection.typeHH_AddressLine2(addressLine2);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_TownCity(String townCity) {
        yourPropertiesSection.typeHH_TownCity(townCity);
		return this;
    }

    @Override
    public IYourPropertiesPage selectHH_County(String county) {
        yourPropertiesSection.selectHH_County(county);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_Postcode(String postcode) {
        yourPropertiesSection.typeHH_Postcode(postcode);
		return this;
    }

    @Override
    public IYourPropertiesPage selectHH_Country(String country) {
        yourPropertiesSection.selectHH_Country(country);
		return this;
    }

    @Override
    public IYourPropertiesPage selectHH_PropertyType(String propertyType) {
        yourPropertiesSection.selectHH_PropertyType(propertyType);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_NumberBedrooms(String numberBedrooms) {
        yourPropertiesSection.typeHH_NumberBedrooms(numberBedrooms);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_AcquiredYear(String acquiredYear) {
        yourPropertiesSection.typeHH_AcquiredYear(acquiredYear);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_OriginalPurchasePrice(String originalPurchasePrice) {
        yourPropertiesSection.typeHH_OriginalPurchasePrice(originalPurchasePrice);
		return this;
    }

    @Override
    public IYourPropertiesPage clickHH_SellPlanYes() {
        yourPropertiesSection.clickHH_SellPlanYes();
		return this;
    }

    @Override
    public IYourPropertiesPage clickHH_SellPlanNo() {
        yourPropertiesSection.clickHH_SellPlanNo();
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_EstimationPrice(String estimationPrice) {
        yourPropertiesSection.typeHH_EstimationPrice(estimationPrice);
		return this;
    }

    @Override
    public IYourPropertiesPage selectPDH_MortgageQuestion(String mortgageQuestion) {
        yourPropertiesSection.selectPDH_MortgageQuestion(mortgageQuestion);
		return this;
    }

    @Override
    public IYourPropertiesPage selectINV_MortgageQuestion(String mortgageQuestion) {
        yourPropertiesSection.selectINV_MortgageQuestion(mortgageQuestion);
        return this;
    }

    @Override
    public IYourPropertiesPage selectHH_MortgageQuestion(String mortgageQuestion) {
        yourPropertiesSection.selectHH_MortgageQuestion(mortgageQuestion);
        return this;
    }

    @Override
    public IYourPropertiesPage typePDH_MortgageProvider(String mortgageType) {
        yourPropertiesSection.typePDH_MortgageProvider(mortgageType);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_MortgageProvider(String mortgageType) {
        yourPropertiesSection.typeINV_MortgageProvider(mortgageType);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_MortgageProvider(String mortgageType) {
        yourPropertiesSection.typeHH_MortgageProvider(mortgageType);
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_MortgageAccountNumber(String accountNumber, String index) {
        yourPropertiesSection.typePDH_MortgageAccountNumber(accountNumber, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_MortgageAccountNumber(String accountNumber, String index) {
        yourPropertiesSection.typeINV_MortgageAccountNumber(accountNumber, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_MortgageAccountNumber(String accountNumber, String index) {
        yourPropertiesSection.typeHH_MortgageAccountNumber(accountNumber, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_MortgageAccountBalance(String accountBalance, String index) {
        yourPropertiesSection.typePDH_MortgageAccountBalance(accountBalance, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_MortgageAccountBalance(String accountBalance, String index) {
        yourPropertiesSection.typeINV_MortgageAccountBalance(accountBalance, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_MortgageAccountBalance(String accountBalance, String index) {
        yourPropertiesSection.typeHH_MortgageAccountBalance(accountBalance, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index) {
        yourPropertiesSection.typePDH_MortgageAccountMonthlyPayment(accountMonthlyPayment, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index) {
        yourPropertiesSection.typeINV_MortgageAccountMonthlyPayment(accountMonthlyPayment, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index) {
        yourPropertiesSection.typeHH_MortgageAccountMonthlyPayment(accountMonthlyPayment, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_MortgageAccountInterestRate(String accountInterestRate, String index) {
        yourPropertiesSection.typePDH_MortgageAccountInterestRate(accountInterestRate, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_MortgageAccountInterestRate(String accountInterestRate, String index) {
        yourPropertiesSection.typeINV_MortgageAccountInterestRate(accountInterestRate, index);
		return this;
    }

    @Override
    public IYourPropertiesPage typeHH_MortgageAccountInterestRate(String accountInterestRate, String index) {
        yourPropertiesSection.typeHH_MortgageAccountInterestRate(accountInterestRate, index);
		return this;
    }

    @Override
    public IYourPropertiesPage checkPDH_MortgageAccountOnlyInterest(String index) {
        yourPropertiesSection.checkPDH_MortgageAccountOnlyInterest(index);
		return this;
    }

    @Override
    public IYourPropertiesPage checkINV_MortgageAccountOnlyInterest(String index) {
        yourPropertiesSection.checkINV_MortgageAccountOnlyInterest(index);
		return this;
    }

    @Override
    public IYourPropertiesPage checkHH_MortgageAccountOnlyInterest(String index) {
        yourPropertiesSection.checkHH_MortgageAccountOnlyInterest(index);
		return this;
    }

    @Override
    public IYourPropertiesPage selectPDH_MortgageAccountRateType(String accountRateType, String index) {
        yourPropertiesSection.selectPDH_MortgageAccountRateType(accountRateType, index);
		return this;
    }

    @Override
    public IYourPropertiesPage selectINV_MortgageAccountRateType(String accountRateType, String index) {
        yourPropertiesSection.selectINV_MortgageAccountRateType(accountRateType, index);
		return this;
    }

    @Override
    public IYourPropertiesPage selectHH_MortgageAccountRateType(String accountRateType, String index) {
        yourPropertiesSection.selectHH_MortgageAccountRateType(accountRateType, index);
		return this;
    }

    @Override
    public IYourPropertiesPage checkPDH_MortgageAccount24MonthYes(String index) {
        yourPropertiesSection.checkPDH_MortgageAccount24MonthYes(index);
		return this;
    }

    @Override
    public IYourPropertiesPage checkINV_MortgageAccount24MonthYes(String index) {
        yourPropertiesSection.checkINV_MortgageAccount24MonthYes(index);
		return this;
    }

    @Override
    public IYourPropertiesPage checkHH_MortgageAccount24MonthYes(String index) {
        yourPropertiesSection.checkHH_MortgageAccount24MonthYes(index);
		return this;
    }

    @Override
    public IYourPropertiesPage checkPDH_MortgageAccount24MonthNo(String index) {
        yourPropertiesSection.checkPDH_MortgageAccount24MonthNo(index);
		return this;
    }

    @Override
    public IYourPropertiesPage checkINV_MortgageAccount24MonthNo(String index) {
        yourPropertiesSection.checkINV_MortgageAccount24MonthNo(index);
		return this;
    }

    @Override
    public IYourPropertiesPage checkHH_MortgageAccount24MonthNo(String index) {
        yourPropertiesSection.checkHH_MortgageAccount24MonthNo(index);
		return this;
    }

    @Override
    public IYourPropertiesPage clickAddAnotherMortgageAccount() {
        yourPropertiesSection.clickAddAnotherMortgageAccount();
		return this;
    }

    @Override
    public IYourPropertiesPage typePDH_MortgageRepaidProvider(String mortgageRepaidProvider) {
        yourPropertiesSection.typePDH_MortgageRepaidProvider(mortgageRepaidProvider);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_MortgageRepaidProvider(String mortgageRepaidProvider) {
        yourPropertiesSection.typeINV_MortgageRepaidProvider(mortgageRepaidProvider);
        return this;
    }

    @Override
    public IYourPropertiesPage typeHH_MortgageRepaidProvider(String mortgageRepaidProvider) {
        yourPropertiesSection.typeHH_MortgageRepaidProvider(mortgageRepaidProvider);
        return this;
    }

    @Override
    public IYourPropertiesPage typePDH_MortgageRepaidYear(String mortgageRepaidYear) {
        yourPropertiesSection.typePDH_MortgageRepaidYear(mortgageRepaidYear);
		return this;
    }

    @Override
    public IYourPropertiesPage typeINV_MortgageRepaidYear(String mortgageRepaidYear) {
        yourPropertiesSection.typeINV_MortgageRepaidYear(mortgageRepaidYear);
        return this;
    }

    @Override
    public IYourPropertiesPage typeHH_MortgageRepaidYear(String mortgageRepaidYear) {
        yourPropertiesSection.typeHH_MortgageRepaidYear(mortgageRepaidYear);
        return this;
    }

    @Override
    public IYourPropertiesPage clickCancel() {
        yourPropertiesSection.clickCancel();
		return this;
    }

    @Override
    public IYourPropertiesPage clickAddThisProperty() {
        yourPropertiesSection.clickAddThisProperty();
		return this;
    }

    @Override
    public IYourPropertiesPage clickAddProperty() {
        yourPropertiesSection.clickAddProperty();
		return this;
    }

    @Override
    public IYourPropertiesPage clickNext() {
        yourPropertiesSection.clickNext();
		return this;
    }

    @Override
    public IYourPropertiesPage clickNextSection() {
        yourPropertiesSection.clickNextSection();
        return this;
    }

    @Override
    public IYourPropertiesPage clickEditThisProperty() {
        yourPropertiesSection.clickEditThisProperty();
		return this;
    }
}
