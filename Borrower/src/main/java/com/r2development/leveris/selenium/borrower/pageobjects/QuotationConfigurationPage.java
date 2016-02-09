package com.r2development.leveris.selenium.borrower.pageobjects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * todo Page Object Specific Implementation
 */
public class QuotationConfigurationPage extends TopBannerMenu implements IQuotationConfigurationSubSection{

    IQuotationConfigurationSubSection quotationConfigurationSubSection;
    ITopBannerMenu topBannerMenu;

    private static final Log log = LogFactory.getLog(QuotationConfigurationPage.class.getName());

    public QuotationConfigurationPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        topBannerMenu = new TopBannerMenu( webDriver );
        quotationConfigurationSubSection = new QuotationConfigurationSubSection( webDriver );
    }

    @Override
    public QuotationConfigurationSubSection clickApplyOnline(){
        return quotationConfigurationSubSection.clickApplyOnline();
    }

    @Override
    public QuotationConfigurationSubSection clickChangeProduct(){
        return quotationConfigurationSubSection.clickChangeProduct();
    }

    @Override
    public QuotationConfigurationSubSection setAmountToBorrowInput(String amountToBorrow) {
        return quotationConfigurationSubSection.setAmountToBorrowInput( amountToBorrow );
    }

    @Override
    public String getAmountToBorrow (){
        return quotationConfigurationSubSection.getAmountToBorrow();
    }

    @Override
    public QuotationConfigurationSubSection setMonthlyRepaymentInput(String monthlyRepayment){
        return quotationConfigurationSubSection.setMonthlyRepaymentInput( monthlyRepayment );
    }

    @Override
    public String getMonthlyRepayment(){
        return quotationConfigurationSubSection.getMonthlyRepayment();
    }

    @Override
    public boolean isHeaderGreatAndQuickLoanPresent(){
        return quotationConfigurationSubSection.isHeaderGreatAndQuickLoanPresent();
    }

    @Override
    public boolean isTitleUnsecuredLoanCalculatorPresent(){
        return quotationConfigurationSubSection.isTitleUnsecuredLoanCalculatorPresent();
    }

    @Override
    public boolean isTitleConfigureYourLoanPresent(){
        return quotationConfigurationSubSection.isTitleConfigureYourLoanPresent();
    }

    @Override
    public boolean isTitleNumberOfRepaymentsPresent(){
        return quotationConfigurationSubSection.isTitleNumberOfRepaymentsPresent();
    }

    @Override
    public String getNumberOfRepayments(){
        return quotationConfigurationSubSection.getNumberOfRepayments();
    }

    @Override
    public boolean isTitleLastRepaymentAmountPresent(){
        return quotationConfigurationSubSection.isTitleLastRepaymentAmountPresent();
    }

    @Override
    public String getLastRepaymentAmount(){
        return quotationConfigurationSubSection.getLastRepaymentAmount();
    }

    @Override
    public boolean isTitleAprPresent(){
        return quotationConfigurationSubSection.isTitleAprPresent();
    }

    @Override
    public String getApr(){
        return quotationConfigurationSubSection.getApr();
    }

    @Override
    public boolean isTitleTotalCostOfLoanPresent(){
        return quotationConfigurationSubSection.isTitleTotalCostOfLoanPresent();
    }

    @Override
    public String getTotalCostOfLoan(){
        return quotationConfigurationSubSection.getTotalCostOfLoan();
    }

    @Override
    public boolean isChangeProductPresent(){
        return quotationConfigurationSubSection.isChangeProductPresent();
    }
}
