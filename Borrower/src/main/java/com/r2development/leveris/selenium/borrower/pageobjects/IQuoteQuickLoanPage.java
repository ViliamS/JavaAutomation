package com.r2development.leveris.selenium.borrower.pageobjects;

/**
 * todo Page Object Specific Implementation
 */
public interface IQuoteQuickLoanPage {

    boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent();
    boolean isSubHeaderUnsecuredLoanPresent();
    boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent();
    IQuoteQuickLoanPage setLoanPurpose(String loanPurposeType);
    IQuoteQuickLoanPage setNetMonthlyIncome(String netMonthlyIncome);
    IQuoteQuickLoanPage setMonthlyExpenses(String monthlyExpenses);
    IQuoteQuickLoanPage setNumberOfDependents(String numberOfDependents);
    IQuoteQuickLoanPage setAmountToBorrow(String amountToBorrow);
    IQuoteConfigurationPage clickContinue();

}