package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.ILoanApplicationPage;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IApplicationListPageSearchSection {

    /**
     * todo : How works Targeting of Specific Loan Application ?
     * //div[@data-path='pnlApplicationList rptApplication']//div[contains(@id,'pnlApplication')][contains(@wicketpath,'item_pnlApplication')]//span[text()='BORROWER_LOAN_APPLICATION_NAME']/../../../div[contains(@data-path,'pnlApplicationList rptApplication') and contains(@data-path,'pnlApplication btnStart')]/a[contains(@wicketpath,'btnStart_submit')][//span[text()='Start']]
     * In line above is final selector, but that have to be folded in Page Object layer as only there we know the Borrower Loan Application Name...
     * String FINAL_XPATH_APPLICATION_START_BUTTON_XPATH = PREFIX_ANY_SINGLE_APPLICATION_RESULT + "//span[text()='" + loanApplicationName + "']/../../.." + START_BUTTON;
     * and this xpath we use for clicking on specific START_BUTTON.
     */

    String ALL_APPLICATIONS_RESULT_LIST = getXPath_DivEqualsDataPath("pnlApplicationList rptApplication");
    String PREFIX_ANY_SINGLE_APPLICATION_RESULT = ALL_APPLICATIONS_RESULT_LIST + getXPath(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.ID, "pnlApplication") + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "item_pnlApplication");
    String LOAN_APPLICATION_BUTTON = getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.DATA_PATH, "pnlApplicationList rptApplication") + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.DATA_PATH, "pnlApplication btnStart") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "btnStart_submit");
    String START_BUTTON = LOAN_APPLICATION_BUTTON + getXPath_HasADescendantSpanEqualsText("Start");
    String CONTINUE_BUTTON = LOAN_APPLICATION_BUTTON + getXPath_HasADescendantSpanEqualsText("Continue");

    /**
     * This method is not taking care about displayed text of the button so it is possible to use either for Start button clicking or continue for opening an Loan Application
     */
    ILoanApplicationPage openLoanApplicationContainingName(String loanApplicationName);

    ILoanApplicationPage openLoanApplication(String loanApplicationName);

    ILoanApplicationPage startLoanApplication(String loanApplicationName);

    ILoanApplicationPage continueLoanApplication(String loanApplicationName);

}