package com.r2development.leveris.selenium.borrower.pageobjects;

/**
 * todo Page Object Specific Implementation
 */
public interface IQuoteConfigurationPage {

    IQuoteConfigurationPage setAmountToBorrowInput(String amountToBorrow);

//    String getAmountToBorrow();

    IQuoteConfigurationPage setMonthlyRepaymentInput(String monthlyRepayment);

//    String getMonthlyRepayment();
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

