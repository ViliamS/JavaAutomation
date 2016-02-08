package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourPropertiesPage {
    String getYourPropertiesTitle();
    String getYourPropertiesDescription();

    IYourPropertiesPage clickSingleNo();
    IYourPropertiesPage clickSingleYes();
    IYourPropertiesPage clickCoupleNo();
    IYourPropertiesPage clickCoupleYes();

    IYourPropertiesPage clickPastSingleNo();
    IYourPropertiesPage clickPastSingleYes();
    IYourPropertiesPage clickPastCoupleNo();
    IYourPropertiesPage clickPastCoupleYes();

    IYourPropertiesPage checkThisPropertyAppliesToBorrower(String borrower);
    IYourPropertiesPage checkThisPropertyAppliedToCoapplicant(String coapplicant);

    IYourPropertiesPage checkOtherPartyInterest();

    // Principal Dwelling House, Investment, Holiday Home
    IYourPropertiesPage selectPropertiesCategory(String propertyCategory);

    // Principal Dwelling House
    IYourPropertiesPage clickPDH_SameAsHomeAddress();
    IYourPropertiesPage typePDH_AddressLine1(String addressLine1);
    IYourPropertiesPage typePDH_AddressLine2(String addressLine2);
    IYourPropertiesPage typePDH_TownCity(String townCity);
    IYourPropertiesPage selectPDH_County(String county);
    IYourPropertiesPage typePDH_Postcode(String postcode);
    IYourPropertiesPage selectPDH_Country(String country);
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    IYourPropertiesPage selectPDH_PropertyType(String propertyType);
    IYourPropertiesPage typePDH_NumberBedrooms(String numberBedrooms);
    IYourPropertiesPage typePDH_AcquiredYear(String acquiredYear);
    IYourPropertiesPage typePDH_OriginalPurchasePrice(String originalPurchasePrice);
    // plan to sel it before you get your home loan
    IYourPropertiesPage clickPDH_SellPlanYes(); //div[contains(@id, 'radSoldBeforeYes')]//label[contains(., 'YES')]/following-sibling::span/a
    IYourPropertiesPage clickPDH_SellPlanNo(); //div[contains(@id, 'radSoldBeforeNo')]//label[contains(., 'NO')]/following-sibling::span/a
    IYourPropertiesPage typePDH_EstimationPrice(String estimationPrice); //label[contains(., 'Estimated value/sale agreed price*')]/following-sibling::input

    // Investment
    IYourPropertiesPage typeINV_MonthlyRent(String monthlyRent);
    //// Seasonal, Guaranteed
    IYourPropertiesPage selectINV_RentType(String rentType);
    IYourPropertiesPage typeINV_AddressLine1(String addressLine1);
    IYourPropertiesPage typeINV_AddressLine2(String addressLine2);
    IYourPropertiesPage typeINV_TownCity(String townCity);
    IYourPropertiesPage selectINV_County(String county);
    IYourPropertiesPage typeINV_Postcode(String postcode);
    IYourPropertiesPage selectINV_Country(String country);
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    IYourPropertiesPage selectINV_PropertyType(String propertyType);
    IYourPropertiesPage typeINV_NumberBedrooms(String numberBedrooms);
    IYourPropertiesPage typeINV_AcquiredYear(String acquiredYear);
    IYourPropertiesPage typeINV_OriginalPurchasePrice(String originalPurchasePrice);
    // plan to sel it before you get your home loan
    IYourPropertiesPage clickINV_SellPlanYes();
    IYourPropertiesPage clickINV_SellPlanNo();
    IYourPropertiesPage typeINV_EstimationPrice(String estimationPrice);

    // Holiday Home
    IYourPropertiesPage typeHH_MonthlyRent(String monthlyRent);
    //// Seasonal, Guaranteed
    IYourPropertiesPage selectHH_RentType(String rentType);
    IYourPropertiesPage typeHH_AddressLine1(String addressLine1);
    IYourPropertiesPage typeHH_AddressLine2(String addressLine2);
    IYourPropertiesPage typeHH_TownCity(String townCity);
    IYourPropertiesPage selectHH_County(String county);
    IYourPropertiesPage typeHH_Postcode(String postcode);
    IYourPropertiesPage selectHH_Country(String country);
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    IYourPropertiesPage selectHH_PropertyType(String propertyType);
    IYourPropertiesPage typeHH_NumberBedrooms(String numberBedrooms);
    IYourPropertiesPage typeHH_AcquiredYear(String acquiredYear);
    IYourPropertiesPage typeHH_OriginalPurchasePrice(String originalPurchasePrice);
    // plan to sel it before you get your home loan
    IYourPropertiesPage clickHH_SellPlanYes();
    IYourPropertiesPage clickHH_SellPlanNo();
    IYourPropertiesPage typeHH_EstimationPrice(String estimationPrice);


    //// Yes; No, Mortgage Repaid; No, Never Had a Mortgage
    IYourPropertiesPage selectPDH_MortgageQuestion(String mortgageQuestion);
    IYourPropertiesPage selectINV_MortgageQuestion(String mortgageQuestion);
    IYourPropertiesPage selectHH_MortgageQuestion(String mortgageQuestion);
    //// yes
    IYourPropertiesPage typePDH_MortgageProvider(String mortgageType);
    IYourPropertiesPage typeINV_MortgageProvider(String mortgageType);
    IYourPropertiesPage typeHH_MortgageProvider(String mortgageType);
    IYourPropertiesPage typePDH_MortgageAccountNumber(String accountNumber, String index);
    IYourPropertiesPage typeINV_MortgageAccountNumber(String accountNumber, String index);
    IYourPropertiesPage typeHH_MortgageAccountNumber(String accountNumber, String index);
    IYourPropertiesPage typePDH_MortgageAccountBalance(String accountBalance, String index);
    IYourPropertiesPage typeINV_MortgageAccountBalance(String accountBalance, String index);
    IYourPropertiesPage typeHH_MortgageAccountBalance(String accountBalance, String index);
    IYourPropertiesPage typePDH_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index);
    IYourPropertiesPage typeINV_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index);
    IYourPropertiesPage typeHH_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index);
    IYourPropertiesPage typePDH_MortgageAccountInterestRate(String accountInterestRate, String index);
    IYourPropertiesPage typeINV_MortgageAccountInterestRate(String accountInterestRate, String index);
    IYourPropertiesPage typeHH_MortgageAccountInterestRate(String accountInterestRate, String index);
    IYourPropertiesPage checkPDH_MortgageAccountOnlyInterest(String index);
    IYourPropertiesPage checkINV_MortgageAccountOnlyInterest(String index);
    IYourPropertiesPage checkHH_MortgageAccountOnlyInterest(String index);
    //// Fixed, Variable
    IYourPropertiesPage selectPDH_MortgageAccountRateType(String accountRateType, String index);
    IYourPropertiesPage selectINV_MortgageAccountRateType(String accountRateType, String index);
    IYourPropertiesPage selectHH_MortgageAccountRateType(String accountRateType, String index);
    IYourPropertiesPage checkPDH_MortgageAccount24MonthYes(String index);
    IYourPropertiesPage checkINV_MortgageAccount24MonthYes(String index);
    IYourPropertiesPage checkHH_MortgageAccount24MonthYes(String index);
    IYourPropertiesPage checkPDH_MortgageAccount24MonthNo(String index);
    IYourPropertiesPage checkINV_MortgageAccount24MonthNo(String index);
    IYourPropertiesPage checkHH_MortgageAccount24MonthNo(String index);
    IYourPropertiesPage clickAddAnotherMortgageAccount();
    IYourPropertiesPage typePDH_MortgageRepaidProvider(String mortgageRepaidProvider);
    IYourPropertiesPage typeINV_MortgageRepaidProvider(String mortgageRepaidProvider);
    IYourPropertiesPage typeHH_MortgageRepaidProvider(String mortgageRepaidProvider);
    IYourPropertiesPage typePDH_MortgageRepaidYear(String mortgageRepaidYear);
    IYourPropertiesPage typeINV_MortgageRepaidYear(String mortgageRepaidYear);
    IYourPropertiesPage typeHH_MortgageRepaidYear(String mortgageRepaidYear);



    IYourPropertiesPage clickCancel();
    IYourPropertiesPage clickAddThisProperty();
    IYourPropertiesPage clickAddProperty();
    IYourPropertiesPage clickNext();
    IYourPropertiesPage clickNextSection();
    IYourPropertiesPage clickEditThisProperty();
}
