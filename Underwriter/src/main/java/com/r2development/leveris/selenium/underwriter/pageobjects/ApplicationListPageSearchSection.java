package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.ILoanApplicationPage;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IWorkflowSection;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.LoanApplicationPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

/**
 * I think is not needed to have the search results in own section because there are just few methods related only for selection of Result.... so it is not effective this is result of my Analysis
 */
public class ApplicationListPageSearchSection extends ApplicationListPage implements IApplicationListPageSearchSection {

    private static final Log log = LogFactory.getLog(ApplicationListPageSearchSection.class.getName());

    private WebDriver webDriver;

    public ApplicationListPageSearchSection(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public ILoanApplicationPage openLoanApplicationContainingName(String loanApplicationName){
        log.info("");
        loadingCheck();
        String FINAL_XPATH_APPLICATION_START_BUTTON_XPATH = PREFIX_ANY_SINGLE_APPLICATION_RESULT + "//span[contains(text(),'" + loanApplicationName + "')]/../../.." + LOAN_APPLICATION_BUTTON;
        log.info(FINAL_XPATH_APPLICATION_START_BUTTON_XPATH);
        isVisible(FINAL_XPATH_APPLICATION_START_BUTTON_XPATH);
        clickElement(FINAL_XPATH_APPLICATION_START_BUTTON_XPATH, IWorkflowSection.WORKFLOW_PANEL_TITLE);
        loadingCheck();
        return new LoanApplicationPage((SharedDriver) webDriver);
    }

    @Override
    public ILoanApplicationPage openLoanApplication(String loanApplicationName){
        log.info("");
        loadingCheck();
        String FINAL_XPATH_APPLICATION_START_BUTTON_XPATH = PREFIX_ANY_SINGLE_APPLICATION_RESULT + "//span[text()='" + loanApplicationName + "']/../../.." + LOAN_APPLICATION_BUTTON;
        isVisible(FINAL_XPATH_APPLICATION_START_BUTTON_XPATH);
        clickElement(FINAL_XPATH_APPLICATION_START_BUTTON_XPATH, IWorkflowSection.WORKFLOW_PANEL_TITLE);
        loadingCheck();
        return new LoanApplicationPage((SharedDriver) webDriver);
    }

    @Override
    public ILoanApplicationPage startLoanApplication(String loanApplicationName) {
        log.info("");
        String FINAL_XPATH_APPLICATION_START_BUTTON_XPATH = PREFIX_ANY_SINGLE_APPLICATION_RESULT + "//span[text()='" + loanApplicationName + "']/../../.." + START_BUTTON;
        isVisible(FINAL_XPATH_APPLICATION_START_BUTTON_XPATH);
        clickElement(FINAL_XPATH_APPLICATION_START_BUTTON_XPATH, IWorkflowSection.WORKFLOW_PANEL_TITLE);
        loadingCheck();
        return new LoanApplicationPage((SharedDriver) webDriver);
    }

    @Override
    public ILoanApplicationPage continueLoanApplication(String loanApplicationName){
        log.info("");
        loadingCheck();
        String FINAL_XPATH_APPLICATION_CONTINUE_BUTTON_XPATH = PREFIX_ANY_SINGLE_APPLICATION_RESULT + "//span[text()='" + loanApplicationName + "']/../../.." + CONTINUE_BUTTON;
        isVisible(FINAL_XPATH_APPLICATION_CONTINUE_BUTTON_XPATH);
        clickElement(FINAL_XPATH_APPLICATION_CONTINUE_BUTTON_XPATH, IWorkflowSection.WORKFLOW_PANEL_TITLE);
        loadingCheck();
        return new LoanApplicationPage((SharedDriver) webDriver);
    }

}
