package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver_Underwriter;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class WorkflowSection extends LoanApplicationPage implements IWorkflowSection {

    private static final Log log = LogFactory.getLog(WorkflowSection.class.getName());

    private WebDriver webDriver;

    public WorkflowSection(SharedDriver_Underwriter webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IWorkflowSection workflowSectionHideUnhide(ACTION action) {
        log.info("");
        switch (action) {
            case HIDE:
                return hideWorkflowSection();
            case UNHIDE:
                return unhideWorkflowSection();
        }
        return this;
    }

    IWorkflowSection unhideWorkflowSection() {
        log.info("");
        loadingCheck();
        if(isPresent(WORKFLOW_PANEL_HIDDEN, 2)) {
            clickElement(WORKFLOW_PANEL_TITLE, WORKFLOW_PANEL_NOT_HIDDEN);
            loadingCheck();
        } else {
            log.info("Workflow Panel was already opened");
        }
        return this;
    }

    IWorkflowSection hideWorkflowSection() {
        log.info("");
        loadingCheck();
        if(isVisible(WORKFLOW_PANEL_NOT_HIDDEN, 2)) {
            clickElement(WORKFLOW_PANEL_NOT_HIDDEN, WORKFLOW_PANEL_HIDDEN);
            loadingCheck();
        } else {
            log.info("Workflow Panel was already hidden");
        }
        return this;
    }

    @Override
    public IWorkflowSection clickRefresh() {
        log.info("");
        loadingCheck();
        isVisible(REFRESH_BUTTON);
        clickElement(REFRESH_BUTTON);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection clickOpenFormViewer() {
        log.info("");
        loadingCheck();
        isVisible(OPEN_FORM_VIEWER_STAGE1);
        clickElement(OPEN_FORM_VIEWER_STAGE1);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection clickOpenDocumentViewer() {
        log.info("");
        loadingCheck();
        isVisible(OPEN_DOCUMENT_VIEWER_STAGE1);
        clickElement(OPEN_DOCUMENT_VIEWER_STAGE1);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection clickDocumentValidationShow() {
        log.info("");
        loadingCheck();
        isVisible(DOCUMENT_VALIDATION_SHOW);
        clickElement(DOCUMENT_VALIDATION_SHOW);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection clickTasksShow() {
        log.info("");
        loadingCheck();
        isVisible(TASKS_SHOW_LINK);
        clickElement(TASKS_SHOW_LINK);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection clickAuditHistoryHide() {
        log.info("");
        loadingCheck();
        isVisible(AUDIT_HISTORY_HIDE);
        clickElement(AUDIT_HISTORY_HIDE);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection checkBox1(String action) {
        log.info("");
        loadingCheck();
        isPresent(I_HAVE_REVIEWED_CHECKBOX1, 2);
        checkBox(I_HAVE_REVIEWED_CHECKBOX1, action);
        loadingCheck();
        return this;
    }

    @Override
    public boolean isCheckBox1TextPresent() {
        log.info("");
        loadingCheck();
        return isVisible(I_HAVE_REVIEWED_CHECKBOX1_TITLE);
    }

    @Override
    public IWorkflowSection checkBox2(String action) {
        log.info("");
        loadingCheck();
        isPresent(I_HAVE_EXTRACTED_CHECKBOX2, 2);
        checkBox(I_HAVE_EXTRACTED_CHECKBOX2, action);
        loadingCheck();
        return this;
    }

    @Override
    public boolean isCheckBox2TextPresent() {
        log.info("");
        loadingCheck();
        return isVisible(I_HAVE_EXTRACTED_CHECKBOX2_TITLE);
    }

    @Override
    public IWorkflowSection checkBox3(String action) {
        log.info("");
        loadingCheck();
        isPresent(I_HAVE_PERFORMED_CHECKBOX3, 2);
        checkBox(I_HAVE_PERFORMED_CHECKBOX3, action);
        loadingCheck();
        return this;
    }

    @Override
    public boolean isCheckBox3TextPresent() {
        log.info("");
        loadingCheck();
        return isVisible(I_HAVE_PERFORMED_CHECKBOX3_TITLE);
    }

    @Override
    public IWorkflowSection clickRejectApplication() {
        log.info("");
        loadingCheck();
        isVisible(REJECT_APPLICATION_BUTTON);
        clickElement(REJECT_APPLICATION_BUTTON);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection clickPushQuestions() {
        log.info("");
        loadingCheck();
        isVisible(PUSH_QUESTIONS_BUTTON);
        clickElement(PUSH_QUESTIONS_BUTTON);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection clickCompleteValidation() {
        log.info("");
        loadingCheck();
        isVisible(COMPLETE_VALIDATION_BUTTON_ENABLED);
        clickElement(COMPLETE_VALIDATION_BUTTON_ENABLED);
        loadingCheck();
        return this;
    }

    /** Stage 2 Credit review */

    @Override
    public IWorkflowSection tasksShowOrHide(ACTION showOrHide){
        log.info("");
        loadingCheck();
        if (ACTION.SHOW.equals(showOrHide) || ACTION.HIDE.equals(showOrHide)){
            isVisible(WORKFLOW_STAGE2_TASKS_SHOWHIDE_LINK, true);
            switch (showOrHide){
                case SHOW:
                    clickElement(WORKFLOW_STAGE2_TASKS_SHOW_LINK, WORKFLOW_STAGE2_TASKS_HIDE_LINK);
                    break;

                case HIDE:
                    clickElement(WORKFLOW_STAGE2_TASKS_HIDE_LINK, WORKFLOW_STAGE2_TASKS_SHOW_LINK);
                    break;
            }
            loadingCheck();
        } else {
            Assert.assertEquals("\n ACTION ---> '" + showOrHide.get() + "' is not valid to be used please use [ ACTION.HIDE or ACTION.SHOW ]", showOrHide, ACTION.SHOW);
            Assert.assertEquals("\n ACTION ---> '" + showOrHide.get() + "' is not valid to be used please use [ ACTION.HIDE or ACTION.SHOW ]", showOrHide, ACTION.HIDE);
        }
        return this;
    }

    @Override
    public IWorkflowSection auditHistoryShowOrHide(ACTION showOrHide){
        log.info("");
        loadingCheck();
        if (ACTION.SHOW.equals(showOrHide) || ACTION.HIDE.equals(showOrHide)){
            isVisible(WORKFLOW_STAGE2_AUDIT_HISTORY_SHOWHIDE_LINK, true);
            switch (showOrHide){
                case SHOW:
                    clickElement(WORKFLOW_STAGE2_AUDIT_HISTORY_SHOW_LINK, WORKFLOW_STAGE2_AUDIT_HISTORY_HIDE_LINK);
                    break;

                case HIDE:
                    clickElement(WORKFLOW_STAGE2_AUDIT_HISTORY_HIDE_LINK, WORKFLOW_STAGE2_AUDIT_HISTORY_SHOW_LINK);
                    break;
            }
            loadingCheck();
        } else {
            Assert.assertEquals("\n ACTION ---> '" + showOrHide.get() + "' is not valid to be used please use [ ACTION.HIDE or ACTION.SHOW ]", showOrHide, ACTION.SHOW);
            Assert.assertEquals("\n ACTION ---> '" + showOrHide.get() + "' is not valid to be used please use [ ACTION.HIDE or ACTION.SHOW ]", showOrHide, ACTION.HIDE);
        }
        return this;
    }

    @Override
    public IWorkflowSection clickOfferCredit(){
        log.info("");
        loadingCheck();
        isVisible(WORKFLOW_STAGE2_OFFER_CREDIT_BUTTON, true);
        clickElement(WORKFLOW_STAGE2_OFFER_CREDIT_BUTTON);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection clickPushQuestionsStage2(){
        log.info("");
        loadingCheck();
        isVisible(WORKFLOW_STAGE2_PUSH_QUESTIONS_BUTTON, true);
        clickElement(WORKFLOW_STAGE2_PUSH_QUESTIONS_BUTTON);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection clickCreditDecline(){
        log.info("");
        loadingCheck();
        isVisible(WORKFLOW_STAGE2_CREDIT_DECLINE_BUTTON, true);
        clickElement(WORKFLOW_STAGE2_CREDIT_DECLINE_BUTTON);
        loadingCheck();
        return this;
    }

    @Override
    public IWorkflowSection clickViewModifyLoanOffer(){
        log.info("");
        loadingCheck();
        isVisible(WORKFLOW_STAGE2_VIEW_MODIFY_LOAN_OFFER_BUTTON, true);
        clickElement(WORKFLOW_STAGE2_VIEW_MODIFY_LOAN_OFFER_BUTTON);
        loadingCheck();
        return this;
    }

}
