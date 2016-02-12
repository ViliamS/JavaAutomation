package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteQuickLoanPage extends Borrower implements IQuoteQuickLoanPage {

    public IQuoteQuickLoanSection quickLoanSection;

    private static final Log log = LogFactory.getLog( QuoteQuickLoanPage.class.getName() );

    @Inject
    public QuoteQuickLoanPage(WebDriver webDriver ) {
        super( webDriver );
        quickLoanSection = new QuoteQuickLoanSection(webDriver);
    }

    @Override
    public boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent(){
        return quickLoanSection.isHeaderYesIWouldLikeGreatAndQuickLoanPresent();
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent(){
        return quickLoanSection.isSubHeaderUnsecuredLoanPresent();
    }

    @Override
    public boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent(){
        return quickLoanSection.isSubTitleBasicInfoAboutYouShouldGiveUsPresent();
    }

    @Override
    public IQuoteQuickLoanPage setLoanPurpose(String loanPurposeType){
        log.info("selecting loan");
        quickLoanSection.setLoanPurpose( loanPurposeType );
        return this;
    }

    @Override
    public IQuoteQuickLoanPage setNetMonthlyIncome(String netMonthlyIncome){
        quickLoanSection.setNetMonthlyIncome( netMonthlyIncome );
        return this;
    }

    @Override
    public IQuoteQuickLoanPage setMonthlyExpenses(String monthlyExpenses){
        quickLoanSection.setMonthlyExpenses( monthlyExpenses );
        return this;
    }

    @Override
    public IQuoteQuickLoanPage setNumberOfDependents(String numberOfDependents){
        quickLoanSection.setNumberOfDependents( numberOfDependents );
        return this;
    }

    @Override
    public IQuoteQuickLoanPage setAmountToBorrow(String amountToBorrow) {
        quickLoanSection.setAmountToBorrow( amountToBorrow );
        return this;
    }

    @Override
    public IQuoteConfigurationPage clickContinue(){
        return quickLoanSection.clickContinue();
    }
}
