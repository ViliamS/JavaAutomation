package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IQuotePaydayLoanPage {

    boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent();

    boolean isSubHeaderUnsecuredLoanPresent();

    boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent();

    IQuotePaydayLoanSection setLoanPurpose(String loanPurposeType);

    IQuotePaydayLoanSection setNetMonthlyIncome(String netMonthlyIncome);

    IQuotePaydayLoanSection setMonthlyExpenses(String monthlyExpenses);

    IQuotePaydayLoanSection setNumberOfDependents(String numberOfDependents);

    IQuotePaydayLoanSection setAmountToBorrow(String amountToBorrow);

    IQuoteConfigurationPage clickContinue();
}
