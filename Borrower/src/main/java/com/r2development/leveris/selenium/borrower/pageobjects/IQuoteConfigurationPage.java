package com.r2development.leveris.selenium.borrower.pageobjects;

/**
 * todo Page Object Specific Implementation
 */
public interface IQuoteConfigurationPage {

    IQuoteConfigurationSection setLoanAmountInput(String amountToBorrow);

//    String getLoanAmount();

    IQuoteConfigurationSection setMonthlyInstallmentInput(String monthlyRepayment);

//    String getMonthlyInstalmentAmount();
//
//    boolean isHeaderGreatAndQuickLoanPresent();
//
//    boolean isTitleUnsecuredLoanCalculatorPresent();
//
//    boolean isTitleConfigureYourLoanPresent();
//
//    boolean isTitleNumberOfRepaymentsPresent();

//    String getNumberOfRepayments();

//    boolean isTitleLastRepaymentAmountPresent();
//
////    String getLastRepaymentAmount();
//
//    boolean isTitleAprPresent();
//
////    String getApr();
//
//    boolean isTitleTotalCostOfLoanPresent();
//
////    String getTotalCostOfLoan();

    IRegisterPage clickApplyOnline();

    IQuoteConfigurationPage clickChangeProduct();

//    boolean isChangeProductPresent();

}

