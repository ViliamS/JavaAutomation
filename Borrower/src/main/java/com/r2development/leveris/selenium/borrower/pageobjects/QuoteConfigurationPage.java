package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteConfigurationPage extends Borrower implements IQuoteConfigurationSection, IQuoteConfigurationPage {

    IQuoteConfigurationSection quotationConfigurationSection;

    private static final Log log = LogFactory.getLog(QuoteConfigurationPage.class.getName());

    public QuoteConfigurationPage(WebDriver webDriver) {
        super(webDriver);
        quotationConfigurationSection = new QuoteConfigurationSection(webDriver);
    }

    @Override
    public IRegisterPage clickApplyOnline() {
        return quotationConfigurationSection.clickApplyOnline();
    }

    @Override
    public IQuoteConfigurationPage clickChangeProduct() {
        return quotationConfigurationSection.clickChangeProduct();
    }

    @Override
    public IQuoteConfigurationPage setLoanAmountInput(String amountToBorrow) {
        return quotationConfigurationSection.setLoanAmountInput(amountToBorrow);
    }

//    @Override
//    public String getLoanAmount (){
//        return quotationConfigurationSection.getLoanAmount();
//    }

    @Override
    public IQuoteConfigurationPage setMonthlyInstalmentInput(String monthlyRepayment) {
        return quotationConfigurationSection.setMonthlyInstalmentInput(monthlyRepayment);
    }
}
//    @Override
//    public String getMonthlyInstalmentAmount(){
//        return quotationConfigurationSection.getMonthlyInstalmentAmount();
//    }

//    @Override
//    public boolean isHeaderGreatAndQuickLoanPresent(){
//        return quotationConfigurationSection.isHeaderGreatAndQuickLoanPresent();
//    }
//
//    @Override
//    public boolean isTitleUnsecuredLoanCalculatorPresent(){
//        return quotationConfigurationSection.isTitleUnsecuredLoanCalculatorPresent();
//    }
//
//    @Override
//    public boolean isTitleConfigureYourLoanPresent(){
//        return quotationConfigurationSection.isTitleConfigureYourLoanPresent();
//    }
//
//    @Override
//    public boolean isTitleNumberOfRepaymentsPresent(){
//        return quotationConfigurationSection.isTitleNumberOfRepaymentsPresent();
//    }

//    @Override
//    public String getNumberOfRepayments(){
//        return quotationConfigurationSection.getNumberOfRepayments();
//    }

//    @Override
//    public boolean isTitleLastRepaymentAmountPresent(){
//        return quotationConfigurationSection.isTitleLastRepaymentAmountPresent();
//    }

//    @Override
//    public String getLastRepaymentAmount(){
//        return quotationConfigurationSection.getLastRepaymentAmount();
//    }

//    @Override
//    public boolean isTitleAprPresent(){
//        return quotationConfigurationSection.isTitleAprPresent();
//    }

//    @Override
//    public String getApr(){
//        return quotationConfigurationSection.getApr();
//    }
//
//    @Override
//    public boolean isTitleTotalCostOfLoanPresent(){
//        return quotationConfigurationSection.isTitleTotalCostOfLoanPresent();
//    }
//
////    @Override
////    public String getTotalCostOfLoan(){
////        return quotationConfigurationSection.getTotalCostOfLoan();
////    }
//
//    @Override
//    public boolean isChangeProductPresent(){
//        return quotationConfigurationSection.isChangeProductPresent();
//    }
//}