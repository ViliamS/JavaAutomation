package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IBuildQuotationPage {
    boolean isWelcomeQuoteLoaded();
    IWelcomePage closeWelcomeQuote();
    void clickGetQuoteNow();
    boolean isLoaded();

    IBuildQuotationPage selectNumberOfBorrower(String nbBorrowers);
    IBuildQuotationPage clickNumberOfBorrower(String nbBorrowers);
    IBuildQuotationPage selectMortgageType(String mortgageType);
    IBuildQuotationPage clickMortgageType(String mortgageType);
    IBuildQuotationPage typeAge(String age);
    IBuildQuotationPage typePartnerAge(String age);
    IBuildQuotationPage selectMaritalStatus(String maritalStatus);
    IBuildQuotationPage typeTotalDependants(String totalDependants);
    IBuildQuotationPage selectIncomeType(String incomeType);
    IBuildQuotationPage selectPartnerIncomeType(String incomeType);
    IBuildQuotationPage typeIncomeAmount(String incomeAmount);
    IBuildQuotationPage typePartnerIncomeAmount(String incomeAmount);
    IBuildQuotationPage typeMonthlyCreditCommitments(String monthCreditCommitment);
    IBuildQuotationPage clickGetQuote();
//    IBuildQuotationPage clickGetQuoteFailure();

    void clickEdit();
    void clickConfigureLoan();

    void clickApplyNow();
    void clickEmailQuote();
    void clickEditDetails();
    String getCurrentStep();

    String getAffordabilityAmount();
    String getAffordabilityMonthly();
    String getAffordabilityFunds();
    boolean isEligible();
}
