package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteLandingPage extends Borrower implements IQuoteLandingPage, IQuoteLandingSection {

    private static final Log log = LogFactory.getLog(QuoteLandingPage.class.getName());

    IQuoteLandingSection quoteLandingSection;

    public QuoteLandingPage( WebDriver webDriver ) {
        super( webDriver );

        if (System.getProperty(DEFAULT_ENVIRONMENT_VARIABLE) == null)
            System.setProperty(DEFAULT_ENVIRONMENT_VARIABLE, DEFAULT_ENVIRONMENT);

        get(System.getProperty("borrower"));
        PageFactory.initElements( webDriver, this );
        quoteLandingSection = new QuoteLandingSection( webDriver );
    }

    @Override
    public IQuoteLandingPage goToBorrowerQuoteLandingPage(){
        get(System.getProperty("borrower"));
        return this;
    }

    @Override
    public IQuoteQuickLoanPage clickContinuePaydayLoanTealButton(){
        return quoteLandingSection.clickContinuePaydayLoanTealButton();
    }

    @Override
    public IQuoteQuickLoanPage clickContinueUnsecuredLoanRedButton(){
        return quoteLandingSection.clickContinueUnsecuredLoanRedButton();
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

    @Override
    public boolean isFromAmountPerMonthEqualToValue( String fromAmountPerMonth ) {
        return quoteLandingSection.isFromAmountPerMonthEqualToValue( fromAmountPerMonth );
    }
}
