package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.ILoanApplicationPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class ApplicationListPage extends SideMenu implements IApplicationListPage, IApplicationListPageSearchSection {

    private static final Log log = LogFactory.getLog(ApplicationListPage.class.getName());

    private WebDriver webDriver;

    protected IApplicationListPageSearchSection applicationListPageSearchSection;

    public ApplicationListPage(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public ILoanApplicationPage openLoanApplicationContainingName(String loanApplicationName){
        log.info("");
        loadingCheck();
        return new ApplicationListPageSearchSection((SharedDriver) webDriver).openLoanApplicationContainingName(loanApplicationName);
    }

    @Override
    public ILoanApplicationPage openLoanApplication(String loanApplicationName){
        log.info("");
        loadingCheck();
        return new ApplicationListPageSearchSection((SharedDriver) webDriver).openLoanApplication(loanApplicationName);
    }

    @Override
    public ILoanApplicationPage startLoanApplication(String loanApplicationName){
        log.info("");
        loadingCheck();
        return new ApplicationListPageSearchSection((SharedDriver) webDriver).startLoanApplication(loanApplicationName);
    }

    @Override
    public ILoanApplicationPage continueLoanApplication(String loanApplicationName){
        log.info("");
        loadingCheck();
        return new ApplicationListPageSearchSection((SharedDriver) webDriver).continueLoanApplication(loanApplicationName);
    }

    @Override
    public boolean isTitleApplicationListPresent() {
        log.info("");
        loadingCheck();
        return isVisible(TITLE_APPLICATION_LIST);
    }

    @Override
    public IApplicationListPage setAssignedFilter(String filter) {
        log.info("");
        loadingCheck();
        isVisible(ASSIGNED_FILTER, true);
        setComboboxInput(ASSIGNED_FILTER_BUTTON, filter);
        loadingCheck();
        return this;
    }

    @Override
    public IApplicationListPage setCaseFilter(String filter) {
        log.info("");
        loadingCheck();
        isVisible(CASE_FILTER);
        setComboboxInput(CASE_FILTER_BUTTON, filter);
        loadingCheck();
        return this;
    }

    @Override
    public IApplicationListPage setStatusFilter(String filter) {
        log.info("");
        loadingCheck();
        isVisible(STATUS_FILTER);
        setComboboxInput(STATUS_FILTER_BUTTON, filter);
        loadingCheck();
        return this;
    }

    @Override
    public IApplicationListPage showAdvancedOptions() {
        log.info("");
        loadingCheck();
        if (isShowAdvancedOptionsDisplayed())
            clickElement(ADVANCED_OPTIONS);
        loadingCheck();
        return this;
    }

    @Override
    public boolean isShowAdvancedOptionsDisplayed() {
        log.info("");
        loadingCheck();
        return isVisible(SHOW_ADVANCED_OPTIONS, 1);
    }

    @Override
    public IApplicationListPage setSearchTextAdvancedFilter(String filter) {
        log.info("");
        loadingCheck();
        isVisible(ADVANCED_SEARCH_TEXT_FILTER);
        type(ADVANCED_SEARCH_TEXT_FILTER, filter);
        loadingCheck();
        return this;
    }

    @Override
    public IApplicationListPage setApplicationIdAdvancedFilter(String filter) {
        log.info("");
        loadingCheck();
        isVisible(ADVANCED_APPLICATION_ID_FILTER);
        type(ADVANCED_APPLICATION_ID_FILTER, filter);
        loadingCheck();
        return this;
    }

    @Override
    public boolean isHideAdvancedOptionsDisplayed() {
        log.info("");
        loadingCheck();
        return isVisible(HIDE_ADVANCED_OPTIONS, 1);
    }

    @Override
    public IApplicationListPage hideAdvancedOptions() {
        log.info("");
        loadingCheck();
        if (isHideAdvancedOptionsDisplayed()) {
            clickElement(ADVANCED_OPTIONS);
            loadingCheck();
        }
        return this;
    }

    @Override
    public IApplicationProcessesList clickProcessList() {
        log.info("");
        loadingCheck();
        isVisible(PROCESS_LIST_LINK);
        clickElement(PROCESS_LIST_LINK);
        loadingCheck();
        return new ApplicationProcessesList((SharedDriver) webDriver);
    }

    @Override
    public ISessionListPage clickSessionList() {
        log.info("");
        loadingCheck();
        isVisible(SESSION_LIST_LINK);
        clickElement(SESSION_LIST_LINK);
        loadingCheck();
        return new SessionListPage((SharedDriver) webDriver);
    }

    @Override
    public IApplicationListPage sortByStageSubmissionDate() {
        log.info("");
        loadingCheck();
        clickElement(SORT_BY_STAGE_SUBMISSION_DATE);
        loadingCheck();
        return this;
    }

    @Override
    public IApplicationListPage sortByCreationDate() {
        log.info("");
        loadingCheck();
        clickElement(SORT_BY_CREATION_DATE);
        loadingCheck();
        return this;
    }

    @Override
    public IApplicationListPage sortByAscendant() {
        log.info("");
        loadingCheck();
        clickElement(SORT_BY_ASCENDANT);
        loadingCheck();
        return this;
    }

    @Override
    public IApplicationListPage sortByDescendant() {
        log.info("");
        loadingCheck();
        clickElement(SORT_BY_DESCENDANT);
        loadingCheck();
        return this;
    }

    @Override
    public IApplicationListPage search() {
        log.info("");
        loadingCheck();
        isVisible(SEARCH_BUTTON);
        clickElement(SEARCH_BUTTON);
        loadingCheck();
        return this;
    }
}