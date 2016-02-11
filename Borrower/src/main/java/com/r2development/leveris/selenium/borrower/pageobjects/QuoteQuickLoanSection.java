package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.openqa.selenium.WebDriver;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteQuickLoanSection extends Borrower implements IQuoteQuickLoanSection {

    public QuoteQuickLoanSection(WebDriver webDriver){
        super( webDriver );
//        isSubHeaderUnsecuredLoanPresent();
      //  isHeaderYesIWouldLikeGreatAndQuickLoanPresent();
      //  isSubTitleBasicInfoAboutYouShouldGiveUsPresent();

        isVisible("//input[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoanQuotation_c_w_cmbLoanPurpose_v']", true);
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
    public IQuoteQuickLoanPage setLoanPurpose(String loanPurposeType) {
        isVisible("//input[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoanQuotation_c_w_cmbLoanPurpose_v']", true);
        clickElement("//input[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoanQuotation_c_w_cmbLoanPurpose_v']");
        isVisible("//ul[contains(@style,'display: block')][not(contains(@style,'display: none'))]/li[@class='ui-menu-item']/a[text()='" + loanPurposeType + "']");
        clickElement("//ul[contains(@style,'display: block')][not(contains(@style,'display: none'))]/li[@class='ui-menu-item']/a[text()='" + loanPurposeType + "']");
        return new QuoteQuickLoanPage(webDriver);
    }

    @Override
    public IQuoteQuickLoanPage setNetMonthlyIncome(String netMonthlyIncome) {
        type(NET_MONTHLY_INCOME_INPUT, netMonthlyIncome);
        return new QuoteQuickLoanPage(webDriver);
    }

    @Override
    public IQuoteQuickLoanPage setMonthlyExpenses(String monthlyExpenses) {
        type(MONTHLY_EXPENSES_INPUT, monthlyExpenses);
        return new QuoteQuickLoanPage(webDriver);
    }

    @Override
    public IQuoteQuickLoanPage setNumberOfDependents(String numberOfDependents) {
        type(NUMBER_OF_DEPENDENTS_INPUT, numberOfDependents);
        return new QuoteQuickLoanPage(webDriver);
    }

    @Override
    public IQuoteQuickLoanPage setAmountToBorrow(String amountToBorrow) {
        type(AMOUNT_TO_BORROW_INPUT, amountToBorrow);
        return new QuoteQuickLoanPage(webDriver);
    }

    @Override
    public IQuoteConfigurationPage clickContinue() {
        isVisible(CONTINUE_TEAL_BUTTON_XPATH, true);
        clickElementViaJavascript(CONTINUE_TEAL_BUTTON_XPATH);
        return new QuoteConfigurationPage( webDriver );
    }

}
