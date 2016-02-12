package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.WebDriverService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class QuotePaydayLoanPage extends Borrower implements IQuotePaydayLoanPage {

    public IQuotePaydayLoanSection quotePaydayLoanSection;

    private static final Log log = LogFactory.getLog( QuoteQuickLoanPage.class.getName() );

//    public QuotePaydayLoanPage() {
//        super(WebDriverService.getWebDriverInstance());
//        quotePaydayLoanSection = new QuotePaydayLoanSection(webDriver);
//    }

    @Inject
    public QuotePaydayLoanPage(WebDriver webDriver ) {
        super( webDriver );
        quotePaydayLoanSection = new QuotePaydayLoanSection(webDriver);
    }

    @Override
    public boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent() {
        return false;
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent() {
        return false;
    }

    @Override
    public boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent() {
        return false;
    }

    @Override
    public IQuotePaydayLoanPage setLoanPurpose(String loanPurposeType){
        log.info("selecting loan");
        quotePaydayLoanSection.setLoanPurpose( loanPurposeType );
        return this;
    }

    @Override
    public IQuotePaydayLoanPage setNetMonthlyIncome(String netMonthlyIncome){
        quotePaydayLoanSection.setNetMonthlyIncome( netMonthlyIncome );
        return this;
    }

    @Override
    public IQuotePaydayLoanPage setMonthlyExpenses(String monthlyExpenses){
        quotePaydayLoanSection.setMonthlyExpenses( monthlyExpenses );
        return this;
    }

    @Override
    public IQuotePaydayLoanPage setNumberOfDependents(String numberOfDependents){
        quotePaydayLoanSection.setNumberOfDependents( numberOfDependents );
        return this;
    }

    @Override
    public IQuotePaydayLoanPage setAmountToBorrow(String amountToBorrow) {
        quotePaydayLoanSection.setAmountToBorrow( amountToBorrow );
        return this;
    }

    @Override
    public IQuoteConfigurationPage clickContinue(){
        return quotePaydayLoanSection.clickContinue();
    }

}
