package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.WebDriverService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class QuotePaydayLoanPage extends Borrower implements IQuotePaydayLoanPage {

    public IQuotePaydayLoanSection quotePaydayLoanSection;

    private static final Log log = LogFactory.getLog( QuoteQuickLoanPage.class.getName() );

    public QuotePaydayLoanPage() {
        super(WebDriverService.getWebDriverInstance());
        quotePaydayLoanSection = new QuotePaydayLoanSection(webDriver);
    }

    public QuotePaydayLoanPage(WebDriver webDriver ) {
        super( webDriver );
        quotePaydayLoanSection = new QuotePaydayLoanSection(webDriver);
    }

    @Override
    public boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent(){
        return quotePaydayLoanSection.isHeaderYesIWouldLikeGreatAndQuickLoanPresent();
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent(){
        return quotePaydayLoanSection.isSubHeaderUnsecuredLoanPresent();
    }

    @Override
    public boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent(){
        return quotePaydayLoanSection.isSubTitleBasicInfoAboutYouShouldGiveUsPresent();
    }

    @Override
    public IQuotePaydayLoanSection setLoanPurpose(String loanPurposeType){
        log.info("selecting loan");
        quotePaydayLoanSection.setLoanPurpose( loanPurposeType );
        return new QuotePaydayLoanSection(webDriver);
    }

    @Override
    public IQuotePaydayLoanSection setNetMonthlyIncome(String netMonthlyIncome){
        quotePaydayLoanSection.setNetMonthlyIncome( netMonthlyIncome );
        return new QuotePaydayLoanSection(webDriver);
    }

    @Override
    public IQuotePaydayLoanSection setMonthlyExpenses(String monthlyExpenses){
        quotePaydayLoanSection.setMonthlyExpenses( monthlyExpenses );
        return new QuotePaydayLoanSection(webDriver);
    }

    @Override
    public IQuotePaydayLoanSection setNumberOfDependents(String numberOfDependents){
        quotePaydayLoanSection.setNumberOfDependents( numberOfDependents );
        return new QuotePaydayLoanSection(webDriver);
    }

    @Override
    public IQuotePaydayLoanSection setAmountToBorrow(String amountToBorrow) {
        quotePaydayLoanSection.setAmountToBorrow( amountToBorrow );
        return new QuotePaydayLoanSection(webDriver);
    }

    @Override
    public IQuoteConfigurationPage clickContinue(){
        return quotePaydayLoanSection.clickContinue();
    }

}
