package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IQuoteQuickLoanPage {

    boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent();

    boolean isSubHeaderUnsecuredLoanPresent();

    boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent();

    IQuoteQuickLoanSection setLoanPurpose(String loanPurposeType);

    IQuoteQuickLoanSection setNetMonthlyIncome(String netMonthlyIncome);

    IQuoteQuickLoanSection setMonthlyExpenses(String monthlyExpenses);

    IQuoteQuickLoanSection setNumberOfDependents(String numberOfDependents);

    IQuoteQuickLoanSection setAmountToBorrow(String amountToBorrow);

    IQuoteConfigurationPage clickContinue();
}