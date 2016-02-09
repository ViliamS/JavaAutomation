package com.r2development.leveris.selenium.borrower.pageobjects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteLandingPage extends TopBannerMenu implements IQuoteLandingPage, IQuoteLandingSubSection {

    protected IQuoteLandingSubSection quoteLandingSection;
    protected ITopBannerMenu topBannerMenu;

    private static final Log log = LogFactory.getLog(QuoteLandingPage.class.getName());

    public QuoteLandingPage(WebDriver webDriver) {
        super(webDriver);

        if ( System.getProperty("borrower") == null )
            System.setProperty("borrower", "https://st1app.loftkeys.com/borrower");

        get(System.getProperty("borrower"));

        quoteLandingSection = new QuoteLandingSubSection(webDriver);
        topBannerMenu = new TopBannerMenu(webDriver);
    }

    @Override
    public QuoteLandingPage goToBorrowerQuoteLandingPage(){
        get(System.getProperty("borrower"));
        return this;
    }

    @Override
    public QuickLoanPage clickContinueTealButton(){
        return quoteLandingSection.clickContinueTealButton();
    }

    @Override
    public QuickLoanPage clickContinueRedButton(){
        return quoteLandingSection.clickContinueRedButton();
    }

    @Override
    public boolean isHeaderGreatAndQuickLoanPresent(){
        return quoteLandingSection.isHeaderGreatAndQuickLoanPresent();
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent(){
        return quoteLandingSection.isSubHeaderUnsecuredLoanPresent();
    }

    @Override
    public boolean isLoanUpToLoanAmountPresent() {
        return quoteLandingSection.isLoanUpToLoanAmountPresent();
    }

    @Override
    public String getValueLoanUpTo(){
        return quoteLandingSection.getValueLoanUpTo();
    }

    @Override
    public boolean isHeaderPayDayLoanPresent(){
        return quoteLandingSection.isHeaderPayDayLoanPresent();
    }

    @Override
    public String getPayDayLoanAmount(){
        return quoteLandingSection.getPayDayLoanAmount();
    }

    @Override
    public boolean isHeaderMortgagePresent() {
        return quoteLandingSection.isHeaderMortgagePresent();
    }

    @Override
    public boolean isHeaderDebitConsolidationPresent() {
        return quoteLandingSection.isHeaderDebitConsolidationPresent();
    }

    @Override
    public boolean isTitleFromAmountPerMonthPresent() {
        return quoteLandingSection.isTitleFromAmountPerMonthPresent();
    }

    @Override
    public String getFromAmountPerMonthValue() {
        return quoteLandingSection.getFromAmountPerMonthValue();
    }
}
