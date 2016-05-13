package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BorrowerHomePage extends HeaderAndBottomAndFormsMenuSection implements IBorrowerHomePage, IMessageSection, ISubMenuSection {

    private static final Log log = LogFactory.getLog(BorrowerHomePage.class);

    protected IMessageSection messageSection;
    protected ISubMenuSection subMenuSection;
    protected IGetApprovalSection getApprovalSection;
    protected IGetStartedMortgageSection getStartedMortgageSection;
    protected IBuildQuotationPage buildQuotationPage;

//    @Inject
    public BorrowerHomePage(SharedDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        messageSection = new MessageSection(webDriver);
        subMenuSection = new SubMenuSection(webDriver);
        getApprovalSection = new GetApprovalSection(webDriver);
        getStartedMortgageSection = new GetStartedMortgageSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public boolean isLoaded() {
//        headerSection.isLoaded();
//        messageSection.isLoaded();
//        subMenuSection.isLoaded();
        loadingCheck();
        getApprovalSection.isLoaded();
        return true;
    }

    @Override
    public void closePopup() {
        getApprovalSection.closePopup();
    }

    @Override
    public void clickGetQuoteOrGetStarted() throws Exception {
        loadingCheck();
        if ( isVisible(IGetStartedMortgageSection.GET_STARTED_BUTTON_XPATH, false, 1)  ) {
            log.info("We need to handle the page StartedMortgageSection");
            getStartedMortgageSection.clickGetStarted();
        } else {
            log.error("Houston, do we have a new page to check ?!");
//            throw new Exception("Houston, do we have a new page to check ?!");
        }
        getApprovalSection.clickGetAQuote();
    }

    @Override
    public boolean startTaskButtonIsPresent(){
        loadingCheck();
        return isVisible(GET_A_QUOTE_START_TASK_BUTTON_XPATH, true);
    }

    @Override
    public void clickStartTaskButton(){
        loadingCheck();
        isVisible(GET_A_QUOTE_START_TASK_BUTTON_XPATH, true);
        clickElement(GET_A_QUOTE_START_TASK_BUTTON_XPATH);
        loadingCheck();
        isNotVisible(GET_A_QUOTE_START_TASK_BUTTON_XPATH, true, 20);
    }

    @Override
    public void clickGetOneNow() {
        messageSection.clickGetOneNow();
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public void clickGetApproval() {

    }

    @Override
    public void clickFindDreamHome() {

    }

    @Override
    public void clickConfigureLoan() {

    }

    @Override
    public void clickFinalLoanSetup() {

    }

    @Override
    public String getGetApprovalTitle() {
        return null;
    }

    @Override
    public String getGetApprovalText() {
        return null;
    }

    @Override
    public void clickWhatDocs() {

    }

    @Override
    public IBuildQuotationPage clickGetAQuote() {
        return getApprovalSection.clickGetAQuote();
    }

    @Override
    public IPersonalDetailsPage clickInfoUpload() {
        return getApprovalSection.clickInfoUpload();
    }

    @Override
    public void closeWhatDocs() {
    }

    @Override
    public IBorrowerHomePage clickReviewAndSubmit() {
        getApprovalSection.clickReviewAndSubmit();
        return this;
    }

    @Override
    public IBorrowerHomePage clickSubmitYourApplication() {
        getApprovalSection.clickSubmitYourApplication();
        return this;
    }

    @Override
    public IBorrowerHomePage checkDistanceMarketing() {
        getApprovalSection.checkDistanceMarketing();
        return this;
    }

    @Override
    public IBorrowerHomePage checkStatutory() {
        getApprovalSection.checkStatutory();
        return this;
    }

    @Override
    public IBorrowerHomePage checkDeclaration() {
        getApprovalSection.checkDeclaration();
        return this;
    }

    @Override
    public IBorrowerHomePage checkCreditFraud() {
        getApprovalSection.checkCreditFraud();
        return this;
    }

    @Override
    public IBorrowerHomePage clickFinalSubmitApplication() {
        getApprovalSection.clickFinalSubmitApplication();
        return this;
    }
}
