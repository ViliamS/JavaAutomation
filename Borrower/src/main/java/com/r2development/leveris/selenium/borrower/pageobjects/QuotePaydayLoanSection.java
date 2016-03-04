package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;

public class QuotePaydayLoanSection extends Borrower implements IQuotePaydayLoanSection{

//    @Inject
    public QuotePaydayLoanSection(SharedDriver webDriver){
        super( webDriver );
    }

    @Override
    public boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent() {
        return true;//isVisible(HEADER_TITLE_YES_I_LIKE_LOAN);
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent() {
        return true;//isVisible(UNSECURED_LOAN_TITLE);
    }

    @Override
    public boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent() {
        return true;//isVisible(BASIC_INFO_TITLE);
    }

    @Override
    public IQuotePaydayLoanSection setLoanPurpose(String loanPurposeType) {
        isVisible(LOAN_PURPOSE_XPATH, true);
        clickElement(LOAN_PURPOSE_XPATH);
        isVisible(DROP_DOWN_LIST + "/a[text()='" + loanPurposeType + "']");
        clickElement(DROP_DOWN_LIST + "/a[text()='" + loanPurposeType + "']");
        return this;
    }

    @Override
    public IQuotePaydayLoanSection setNetMonthlyIncome(String netMonthlyIncome) {
        type(NET_MONTHLY_INCOME_INPUT, netMonthlyIncome);
        return this;
    }

    @Override
    public IQuotePaydayLoanSection setMonthlyExpenses(String monthlyExpenses) {
        type(MONTHLY_EXPENSES_INPUT, monthlyExpenses);
        return this;
    }

    @Override
    public IQuotePaydayLoanSection setNumberOfDependents(String numberOfDependents) {
        type(NUMBER_OF_DEPENDENTS_INPUT, numberOfDependents);
        return this;
    }

    @Override
    public IQuotePaydayLoanSection setAmountToBorrow(String amountToBorrow) {
        type(AMOUNT_TO_BORROW_INPUT, amountToBorrow, false);
        return this;
    }

    @Override
    public IQuoteConfigurationPage clickContinue() {
        isVisible(CONTINUE_TEAL_BUTTON_XPATH, true);
        clickElementViaJavascript(CONTINUE_TEAL_BUTTON_XPATH);
        return new QuoteConfigurationPage(webDriver);
    }
}
