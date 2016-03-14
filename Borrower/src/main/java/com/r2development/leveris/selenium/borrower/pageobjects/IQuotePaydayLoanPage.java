package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IQuotePaydayLoanPage {

    boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent();
    boolean isSubHeaderUnsecuredLoanPresent();
    boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent();
    IQuotePaydayLoanPage setLoanPurpose(String loanPurposeType);
    IQuotePaydayLoanPage setNetMonthlyIncome(String netMonthlyIncome);
    IQuotePaydayLoanPage setMonthlyExpenses(String monthlyExpenses);
    IQuotePaydayLoanPage setNumberOfDependants(String numberOfDependents);
    IQuotePaydayLoanPage setAmountToBorrow(String amountToBorrow);
    IQuoteConfigurationPage clickContinue();

}
