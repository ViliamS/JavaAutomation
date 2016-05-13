package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.selenium.underwriter.pageobjects.ISideMenu;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs.*;
import com.r2development.leveris.selenium.underwriter.pageobjects.SideMenu;
import com.r2development.leveris.utils.Enums.DOCUMENTTYPE;
import com.r2development.leveris.utils.Enums.LOANAPPSECTIONS;
import com.r2development.leveris.utils.Enums.UNDERWRITINGSTATUS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class LoanApplicationPage extends SideMenu implements ILoanApplicationPage, ISideMenu, IWorkflowSection, ILoanOfferToolSection, IFormToolsSection, IDocumentsSection, IDocumentsDetail, IDocumentsDetailEditSection, IDocuments2Section, IRiskToolSection, IUpdateHistorySection {

    private static final Log log = LogFactory.getLog(LoanApplicationPage.class.getName());

    private WebDriver webDriver;

    protected IWorkflowSection workflowSection;
    protected IFinanceToolSection financeToolSection;
    protected ILoanOfferToolSection loanOfferToolSection;
    protected IFormToolsSection formToolsSection;
    protected IDocumentsSection documentsSection;
    protected IDocuments2Section documents2Section;
    protected INotesSection notesSection;
    protected IRiskToolSection riskToolSection;
    protected IUpdateHistorySection updateHistorySection;
    protected IDocumentsDetail documentsDetail;
    protected IDocumentsDetailEditSection documentsDetailEditSection;

    public LoanApplicationPage(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
//        loanApplicationPage = new LoanApplicationPage(webDriver);
    }

    @Override
    public ILoanApplicationPage sectionHideUnhide(LOANAPPSECTIONS section, ACTION action){
        log.info("");
        loanApplicationPage = new LoanApplicationPage((SharedDriver) webDriver);
        switch (section){
            case WORKFLOW:
                loanApplicationPage.workflowSectionHideUnhide(action);
                break;

            case FINANCE_TOOL:
                loanApplicationPage.financeToolSectionHideUnhide(action);
                break;

            case LOAN_OFFER_TOOL:
                loanApplicationPage.loanOfferToolSectionHideUnhide(action);
                break;

            case FORM_TOOLS:
                loanApplicationPage.formToolSectionHideUnhide(action);
                break;

            case DOCUMENTS:
                loanApplicationPage.documentsSectionHideUnhide(action);
                break;

            case DOCUMENTS2:
                loanApplicationPage.documents2SectionHideUnhide(action);
                break;

            case NOTES:
                loanApplicationPage.notesSectionHideUnhide(action);
                break;

            case RISK_TOOL:
                loanApplicationPage.riskToolSectionHideUnhide(action);
                break;

            case UPDATE_HISTORY:
                loanApplicationPage.updateHistorySectionHideUnhide(action);
                break;
        }
        return this;
    }

    /**
     #################################
     #      Finance Tool Section     #
     #################################
     */

    @Override
    public IFinanceToolSection financeToolSectionHideUnhide(ACTION action){
        log.info("");
        return financeToolSection.financeToolSectionHideUnhide(action);
    }

    /**
     #################################
     #    Loan Offer Tool Section    #
     #################################
     */

    @Override
    public ILoanOfferToolSection selectLoanOfferVersionLatest(){
        log.info("");
        return loanOfferToolSection.selectLoanOfferVersionLatest();
    }

    @Override
    public boolean isScoreWarningDisplayed(){
        log.info("");
        return loanOfferToolSection.isScoreWarningDisplayed();
    }

    @Override
    public ILoanOfferToolSection loanOfferToolSectionHideUnhide(ACTION action){
        log.info("");
        return loanOfferToolSection = new LoanOfferToolSection((SharedDriver) webDriver).loanOfferToolSectionHideUnhide(action);
    }

    @Override
    public ILoanOfferToolSection selectLoanOfferVersion(String version){
        log.info("");
        return loanOfferToolSection.selectLoanOfferVersion(version);
    }

    @Override
    public ILoanOfferToolSection clickEditReview(){
        log.info("");
        return loanOfferToolSection.clickEditReview();
    }

    @Override
    public ILoanOfferToolSection clickReset(){
        log.info("");
        return loanOfferToolSection.clickReset();
    }

    @Override
    public ILoanOfferToolSection clickSaveOffer(){
        log.info("");
        return loanOfferToolSection.clickSaveOffer();
    }

    @Override
    public INewLoanOfferConditionDialog clickAddCondition(){
        log.info("");
        return loanOfferToolSection.clickAddCondition();
    }

    @Override
    public ILoanOfferToolSection addComment(String comment){
        log.info("");
        return loanOfferToolSection.addComment(comment);
    }

    @Override
    public IRiskToolSection clickSignReview(){
        log.info("");
        return loanOfferToolSection.clickSignReview();
    }

    /**
     #################################
     #       Form Tool Section       #
     #################################
     */

    @Override
    public IFormToolsSection formToolSectionHideUnhide(ACTION action){
        log.info("");
        return formToolsSection.formToolSectionHideUnhide(action);
    }

    /**
     #################################
     #       Documents Section       #
     #################################
     */

    @Override
    public IDocumentsSection clickDelete(){
        log.info("");
        return documentsDetail.clickDelete();
    }

    @Override
    public IDocumentsSection clickCloseX(){
        log.info("");
        return documentsDetail.clickCloseX();
    }

    @Override
    public IDocumentsDetailEditSection clickEdit(){
        log.info("");
        return documentsDetail.clickEdit();
    }

    @Override
    public String getDocumentTypeText(){
        log.info("");
        return documentsDetailEditSection.getDocumentTypeText();
    }

    @Override
    public DOCUMENTTYPE getDocumentType(){
        log.info("");
        return documentsDetailEditSection.getDocumentType();
    }

    @Override
    public String getDocumentSubType(){
        log.info("");
        return documentsDetailEditSection.getDocumentSubType();
    }

    @Override
    public IDocumentsDetailEditSection setDocumentType(String value){
        log.info("");
        return documentsDetailEditSection.setDocumentType(value);
    }

    @Override
    public IDocumentsDetailEditSection setDocumentSubType(String value){
        log.info("");
        return documentsDetailEditSection.setDocumentSubType(value);
    }

    @Override
    public IDocumentsDetailEditSection setExpiryDate(String date){
        log.info("");
        return documentsDetailEditSection.setExpiryDate(date);
    }

    @Override
    public IDocumentsDetailEditSection setTag(String tag){
        log.info("");
        return documentsDetailEditSection.setTag(tag);
    }

    @Override
    public IDocumentsDetailEditSection setUnderwritingStatus(String status){
        log.info("");
        return documentsDetailEditSection.setUnderwritingStatus(status);
    }

    @Override
    public IDocumentsDetail clickSave(){
        log.info("");
        return documentsDetailEditSection.clickSave();
    }

    @Override
    public IDocumentsDetailEditSection clickCancel(){
        log.info("");
        return documentsDetailEditSection.clickCancel();
    }

    @Override
    public IDocumentsSection documentsSectionHideUnhide(ACTION action){
        log.info("");
        return documentsSection = new DocumentsSection((SharedDriver) webDriver).documentsSectionHideUnhide(action);
    }

    @Override
    public int getNumberOfUploadedDocuments(){
        log.info("");
        return documentsSection.getNumberOfUploadedDocuments();
    }

    @Override
    public IDocumentsDetail openDocument(int indexNumber){
        log.info("");
        return documentsSection.openDocument(indexNumber);
    }

    @Override
    public IDocumentsDetail openDocument(String indexNumber){
        log.info("");
        return documentsSection.openDocument(indexNumber);
    }

    @Override
    public boolean isDocumentInExpectedStatus(UNDERWRITINGSTATUS underwritingstatus, int documentRowIndex){
        log.info("");
        return documentsSection.isDocumentInExpectedStatus(underwritingstatus, documentRowIndex);
    }
    /**
     #################################
     #      Documents2 Section       #
     #################################
     */

    @Override
    public IDocuments2Section documents2SectionHideUnhide(ACTION action){
        log.info("");
        return documents2Section = new Documents2Section((SharedDriver) webDriver).documents2SectionHideUnhide(action);
    }

    /**
     #################################
     #         Notes Section         #
     #################################
     */

    @Override
    public INotesSection notesSectionHideUnhide(ACTION action){
        log.info("");
        return notesSection = new NotesSection((SharedDriver) webDriver).notesSectionHideUnhide(action);
    }

    /**
     #################################
     #       Risk Tool Section       #
     #################################
     */

    @Override
    public IRiskToolSection setStatusDropDown(String value){
        log.info("");
        return riskToolSection.setStatusDropDown(value);
    }

    @Override
    public IRiskToolSection riskToolSectionHideUnhide(ACTION action){
        log.info("");
        return riskToolSection = new RiskToolSection((SharedDriver) webDriver).riskToolSectionHideUnhide(action);
    }

    @Override
    public IRiskToolSection setManuallyUpdateCheckbox(ACTION checkUncheck){
        log.info("");
        return riskToolSection.setManuallyUpdateCheckbox(checkUncheck);
    }

    @Override
    public IRiskToolSection clickSaveKYC(){
        log.info("");
        return riskToolSection.clickSaveKYC();
    }

    @Override
    public ISetFICODialog clickSetFICO(){
        log.info("");
        return riskToolSection.clickSetFICO();
    }

    @Override
    public ISetAMLDialog clickSetAML(){
        log.info("");
        return riskToolSection.clickSetAML();
    }

    @Override
    public ISetFraudDialog clickSetFraud(){
        log.info("");
        return riskToolSection.clickSetFraud();
    }

    @Override
    public IRepeatCustomerDialog clickSetRepCustomer(){
        log.info("");
        return riskToolSection.clickSetRepCustomer();
    }

    @Override
    public ISetScoreOverrideDialog clickSetScoreOverride(){
        log.info("");
        return riskToolSection.clickSetScoreOverride();
    }

    @Override
    public IAddNoteDialog clickSetNote(){
        log.info("");
        return riskToolSection.clickSetNote();
    }

    /**
     #################################
     #     Update History Section    #
     #################################
     */

    @Override
    public IUpdateHistorySection updateHistorySectionHideUnhide(ACTION action){
        log.info("");
        return updateHistorySection.updateHistorySectionHideUnhide(action);
    }

    /**
     * #################################
     * #        Workflow Section       #
     * #################################
     */

    @Override
    public IWorkflowSection workflowSectionHideUnhide(ACTION action){
        log.info("");
        return workflowSection = new WorkflowSection((SharedDriver) webDriver).workflowSectionHideUnhide(action);
    }

    @Override
    public IWorkflowSection clickRefresh() {
        log.info("");
        return workflowSection.clickRefresh();
    }

    @Override
    public IWorkflowSection clickOpenFormViewer() {
        log.info("");
        return workflowSection.clickOpenFormViewer();
    }

    @Override
    public IWorkflowSection clickOpenDocumentViewer() {
        log.info("");
        return workflowSection.clickOpenDocumentViewer();
    }

    @Override
    public IWorkflowSection clickDocumentValidationShow() {
        log.info("");
        return workflowSection.clickDocumentValidationShow();
    }

    @Override
    public IWorkflowSection clickTasksShow() {
        log.info("");
        return workflowSection.clickTasksShow();
    }

    @Override
    public IWorkflowSection clickAuditHistoryHide() {
        log.info("");
        return workflowSection.clickAuditHistoryHide();
    }

    @Override
    public IWorkflowSection checkBox1(String action) {
        log.info("");
        return workflowSection.checkBox1(action);
    }

    @Override
    public boolean isCheckBox1TextPresent() {
        log.info("");
        return workflowSection.isCheckBox1TextPresent();
    }

    @Override
    public IWorkflowSection checkBox2(String action) {
        log.info("");
        return workflowSection.checkBox2(action);
    }

    @Override
    public boolean isCheckBox2TextPresent() {
        log.info("");
        return workflowSection.isCheckBox2TextPresent();
    }

    @Override
    public IWorkflowSection checkBox3(String action) {
        log.info("");
        return workflowSection.checkBox3(action);
    }

    @Override
    public boolean isCheckBox3TextPresent() {
        log.info("");
        return workflowSection.isCheckBox3TextPresent();
    }

    @Override
    public IWorkflowSection clickRejectApplication() {
        log.info("");
        return workflowSection.clickRejectApplication();
    }

    @Override
    public IWorkflowSection clickPushQuestions() {
        log.info("");
        return workflowSection.clickPushQuestions();
    }

    @Override
    public IWorkflowSection clickCompleteValidation() {
        log.info("");
        return workflowSection.clickCompleteValidation();
    }

    /** Workflow Stage 2 Credit review */

    @Override
    public IWorkflowSection tasksShowOrHide(ACTION showOrHide){
        log.info("");
        return workflowSection.tasksShowOrHide(showOrHide);
    }

    @Override
    public IWorkflowSection auditHistoryShowOrHide(ACTION showOrHide){
        log.info("");
        return workflowSection.auditHistoryShowOrHide(showOrHide);
    }

    @Override
    public IWorkflowSection clickOfferCredit(){
        log.info("");
        return workflowSection.clickOfferCredit();
    }

    @Override
    public IWorkflowSection clickPushQuestionsStage2(){
        log.info("");
        return workflowSection.clickPushQuestionsStage2();
    }

    @Override
    public IWorkflowSection clickCreditDecline(){
        log.info("");
        return workflowSection.clickCreditDecline();
    }

    @Override
    public IWorkflowSection clickViewModifyLoanOffer(){
        log.info("");
        return workflowSection.clickViewModifyLoanOffer();
    }
}