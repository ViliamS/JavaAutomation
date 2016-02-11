package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.openqa.selenium.WebDriver;

public class QuotePaydayLoanSection extends Borrower implements IQuotePaydayLoanSection{

    public QuotePaydayLoanSection(WebDriver webDriver){
        super( webDriver );
        //  isSubHeaderUnsecuredLoanPresent();
        //  isHeaderYesIWouldLikeGreatAndQuickLoanPresent();
        //  isSubTitleBasicInfoAboutYouShouldGiveUsPresent();

        isVisible(LOAN_PURPOSE_XPATH, true);
        isVisible(CONTINUE_TEAL_BUTTON_XPATH, true);
        isVisible(NET_MONTHLY_INCOME_INPUT, true);
        isVisible(MONTHLY_EXPENSES_INPUT, true);
        isVisible(NUMBER_OF_DEPENDENTS_INPUT, true);
        isVisible(AMOUNT_TO_BORROW_INPUT, true);
    }

//    @Override
//    public boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent() {
//        return isVisible(HEADER_TITLE_YES_I_LIKE_LOAN);
//    }

//    @Override
//    public boolean isSubHeaderUnsecuredLoanPresent() {
//        return isVisible(UNSECURED_LOAN_TITLE);
//    }

//    @Override
//    public boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent() {
//        return isVisible(BASIC_INFO_TITLE);
//    }

    @Override
    public IQuotePaydayLoanPage setLoanPurpose(String loanPurposeType) {
        isVisible(LOAN_PURPOSE_XPATH, true);
        clickElement(LOAN_PURPOSE_XPATH);
        isVisible(DROP_DOWN_LIST + "/a[text()='" + loanPurposeType + "']");
        clickElement(DROP_DOWN_LIST + "/a[text()='" + loanPurposeType + "']");
        return new QuotePaydayLoanPage(webDriver);
    }

    @Override
    public IQuotePaydayLoanPage setNetMonthlyIncome(String netMonthlyIncome) {
        type(NET_MONTHLY_INCOME_INPUT, netMonthlyIncome);
        return new QuotePaydayLoanPage(webDriver);
    }

    @Override
    public IQuotePaydayLoanPage setMonthlyExpenses(String monthlyExpenses) {
        type(MONTHLY_EXPENSES_INPUT, monthlyExpenses);
        return new QuotePaydayLoanPage(webDriver);
    }

    @Override
    public IQuotePaydayLoanPage setNumberOfDependents(String numberOfDependents) {
        type(NUMBER_OF_DEPENDENTS_INPUT, numberOfDependents);
        return new QuotePaydayLoanPage(webDriver);
    }

    @Override
    public IQuotePaydayLoanPage setAmountToBorrow(String amountToBorrow) {
        type(AMOUNT_TO_BORROW_INPUT, amountToBorrow);
        return new QuotePaydayLoanPage(webDriver);
    }

    @Override
    public IQuoteConfigurationPage clickContinue() {
        isVisible(CONTINUE_TEAL_BUTTON_XPATH, true);
        clickElementViaJavascript(CONTINUE_TEAL_BUTTON_XPATH);
        return new QuoteConfigurationPage( webDriver );
    }
}
