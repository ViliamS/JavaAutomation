package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteQuickLoanSection extends Borrower implements IQuoteQuickLoanSection {

//    @Inject
    public QuoteQuickLoanSection(SharedDriver webDriver){
        super( webDriver );
    }

    @Override
    public boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent() {
        //isVisible(HEADER_TITLE_YES_I_LIKE_LOAN_XPATH);
        return true;
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent() {
        //isVisible(UNSECURED_LOAN_TITLE_XPATH);
        return true;
    }

    @Override
    public boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent() {
        //isVisible(BASIC_INFO_TITLE_XPATH);
        return true;
    }

    @Override
    public IQuoteQuickLoanSection setLoanPurpose(String loanPurposeType) {
        loadingCheck();
        isVisible(LOAN_PURPOSE_XPATH, true);
        clickElement(LOAN_PURPOSE_XPATH);
        isVisible(DROP_DOWN_LIST + "/a[text()='" + loanPurposeType + "']");
        clickElement(DROP_DOWN_LIST + "/a[text()='" + loanPurposeType + "']");
        return this;
    }

    @Override
    public IQuoteQuickLoanSection setNetMonthlyIncome(String netMonthlyIncome) {
        type(NET_MONTHLY_INCOME_INPUT, netMonthlyIncome);
        return this;
    }

    @Override
    public IQuoteQuickLoanSection setMonthlyExpenses(String monthlyExpenses) {
        type(MONTHLY_EXPENSES_INPUT, monthlyExpenses);
        return this;
    }

    @Override
    public IQuoteQuickLoanSection setNumberOfDependents(String numberOfDependents) {
        type(NUMBER_OF_DEPENDENTS_INPUT, numberOfDependents);
        return this;
    }

    @Override
    public IQuoteQuickLoanSection setAmountToBorrow(String amountToBorrow) {
        type(AMOUNT_TO_BORROW_INPUT, amountToBorrow);
        return this;
    }

    @Override
    public IQuoteConfigurationPage clickContinue() {
        isVisible(CONTINUE_TEAL_BUTTON_XPATH, true);
        clickElementViaJavascript(CONTINUE_TEAL_BUTTON_XPATH);
        loadingCheck();
        return new QuoteConfigurationPage(webDriver);
    }

}
