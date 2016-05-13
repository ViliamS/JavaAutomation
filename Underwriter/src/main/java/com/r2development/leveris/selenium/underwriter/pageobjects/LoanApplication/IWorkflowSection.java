package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.utils.XpathBuilder.Enums.*;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IWorkflowSection {

    String WORKFLOW_TAB = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_0");
    String WORKFLOW_PANEL_TITLE = WORKFLOW_TAB + getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Workflow") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_0_header");
    String WORKFLOW_PANEL_HIDE = WORKFLOW_TAB + getXPath(ELEMENTS.A, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "collapse");
    String WORKFLOW_PANEL_HIDDEN = WORKFLOW_PANEL_HIDE + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: none");
    String WORKFLOW_PANEL_NOT_HIDDEN = WORKFLOW_PANEL_HIDE + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "display: none");
    String REFRESH_BUTTON = WORKFLOW_TAB + getXPath_DivEqualsDataPath("btnRefresh") + getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "btnRefresh_cancel") + getXPath_HasADescendantSpanEqualsText("Refresh");
    String PANEL_STAGE1 = WORKFLOW_TAB + getXPath_DivEqualsDataPath("pnlStage1") + getXPath_HasADescendantSpanEqualsText("Stage 1: Data Validation");
    String OPEN_FORM_VIEWER_STAGE1 = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 lnkOpenFormViewer") + getXPath(ELEMENTS.A) + getXPath_HasADescendantSpanEqualsText("Open Form Viewer");
    String OPEN_DOCUMENT_VIEWER_STAGE1 = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 lnkOpenDocViewer") + getXPath(ELEMENTS.A) + getXPath_HasADescendantSpanEqualsText("Open Document Viewer");
    String DOCUMENT_VALIDATION_SHOW = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 pnlDocumentValidations lnkDocumentValidationsShow") + getXPath(ELEMENTS.A) + getXPath_HasADescendantSpanEqualsText("Show");
    String TASKS_SHOW_LINK = PANEL_STAGE1 + getXPath_DivEqualsDataPath("lnkTasksShow") + getXPath(ELEMENTS.A) + getXPath_HasADescendantSpanEqualsText("Show");
    String AUDIT_HISTORY_HIDE = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 lnkHideAuditHistory") + getXPath(ELEMENTS.A) + getXPath_HasADescendantSpanEqualsText("Hide");
    String AUDIT_HISTORY_TABLE_HEAD = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 pnlAuditHistory tblAuditHistory") + getXPath_DivEqualsClass("table-head");
    String AUDIT_HISTORY_TABLE_BODY = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 pnlAuditHistory tblAuditHistory") + getXPath_DivEqualsClass("table-body");
    String CHECKBOX_CHECKED = getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "checked");
    String I_HAVE_REVIEWED_CHECKBOX1 = getXPath_DivEqualsDataPath("pnlStage1 chkCheck1") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "vcheckbox control") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.ID, "checkbox");
    String I_HAVE_EXTRACTED_CHECKBOX2 = getXPath_DivEqualsDataPath("pnlStage1 chkCheck2") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "vcheckbox control") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.ID, "checkbox");
    String I_HAVE_PERFORMED_CHECKBOX3 = getXPath_DivEqualsDataPath("pnlStage1 chkCheck3") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "vcheckbox control") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.ID, "checkbox");
    String I_HAVE_EXTRACTED_CHECKBOX2_TITLE = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 lblCheck2") + getXPath_SpanEqualsText("I have extracted data from all the documents and the types and accepted and rejected documents where appropriate");
    String I_HAVE_REVIEWED_CHECKBOX1_TITLE = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 lblCheck1") + getXPath_SpanEqualsText("I have reviewed the application form and the data is consistent and makes sense");
    String I_HAVE_PERFORMED_CHECKBOX3_TITLE = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 lblCheck3") + getXPath_SpanEqualsText("I have performed KYC");
    String COMPLETE_VALIDATION_BUTTON_DISABLED = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 btnCompleteScript") + getXPath(ELEMENTS.EM) + getXPath_HasADescendantSpanEqualsText("Complete Validation");
    String COMPLETE_VALIDATION_BUTTON_ENABLED = getXPath_DivEqualsDataPath("pnlStage1 btnCompleteScript") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlStage1_c_w_btnCompleteScript_script") + getXPath_HasADescendantSpanEqualsText("Complete Validation");
    String PUSH_QUESTIONS_BUTTON = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 btnPushQueries") + getXPath_HasADescendantSpanEqualsText("Push Questions");
    String REJECT_APPLICATION_BUTTON = PANEL_STAGE1 + getXPath_DivEqualsDataPath("pnlStage1 btnReject") + getXPath(ELEMENTS.A) + getXPath_HasADescendantSpanEqualsText("Reject Application");

    /** Stage 2 Credit review */
    String WORKFLOW_STAGE2_CREDIT_REVIEW = WORKFLOW_TAB + getXPath_DivEqualsDataPath("pnlStage2") + getXPath_DirectAButtonContainsWicketpath("pnlStage2_label") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Stage 2: Credit Review");

    String WORKFLOW_STAGE2_TASKS_SHOWHIDE_LINK = WORKFLOW_TAB + getXPath_DivEqualsDataPath("lnkTasksShow") + getXPath_DirectAButtonContainsWicketpath("lnkTasksShow_cancel");
    String WORKFLOW_STAGE2_TASKS_SHOW_LINK = WORKFLOW_STAGE2_TASKS_SHOWHIDE_LINK + getXPath_HasADescendantSpanEqualsText("Show");
    String WORKFLOW_STAGE2_TASKS_HIDE_LINK = WORKFLOW_STAGE2_TASKS_SHOWHIDE_LINK + getXPath_HasADescendantSpanEqualsText("Hide");

    String WORKFLOW_STAGE2_AUDIT_HISTORY_SHOWHIDE_LINK = WORKFLOW_TAB + getXPath_DivEqualsDataPath("pnlStage2 lnkHideAuditHistory") + getXPath_DirectAButtonContainsWicketpath("lnkHideAuditHistory_script");
    String WORKFLOW_STAGE2_AUDIT_HISTORY_SHOW_LINK = WORKFLOW_STAGE2_AUDIT_HISTORY_SHOWHIDE_LINK + getXPath_HasADescendantSpanEqualsText("Show");
    String WORKFLOW_STAGE2_AUDIT_HISTORY_HIDE_LINK = WORKFLOW_STAGE2_AUDIT_HISTORY_SHOWHIDE_LINK + getXPath_HasADescendantSpanEqualsText("Hide");

    String WORKFLOW_STAGE2_OFFER_CREDIT_BUTTON = WORKFLOW_TAB + getXPath_DivEqualsDataPath("pnlStage2 btnOfferCredit") + getXPath_DirectAButtonContainsWicketpath("btnOfferCredit_submit") + getXPath_HasADescendantSpanEqualsText("Offer Credit");
    String WORKFLOW_STAGE2_PUSH_QUESTIONS_BUTTON = WORKFLOW_TAB + getXPath_DivEqualsDataPath("pnlStage2 btnPushQueries") + getXPath_DirectAButtonContainsWicketpath("btnPushQueries_submit") + getXPath_HasADescendantSpanEqualsText("Push Questions");
    String WORKFLOW_STAGE2_CREDIT_DECLINE_BUTTON = WORKFLOW_TAB + getXPath_DivEqualsDataPath("pnlStage2 btnReject") + getXPath_DirectAButtonContainsWicketpath("btnReject_dialog") + getXPath_HasADescendantSpanEqualsText("Credit Decline");
    String WORKFLOW_STAGE2_VIEW_MODIFY_LOAN_OFFER_BUTTON = WORKFLOW_TAB + getXPath_DivEqualsDataPath("pnlStage2 btnViewModify") + getXPath_DirectAButtonContainsWicketpath("btnViewModify_script") + getXPath_HasADescendantSpanEqualsText("View/Modify Loan Offer");

    IWorkflowSection workflowSectionHideUnhide(ACTION action);

    IWorkflowSection clickRefresh();

    IWorkflowSection clickOpenFormViewer();

    IWorkflowSection clickOpenDocumentViewer();

    IWorkflowSection clickDocumentValidationShow();

    IWorkflowSection clickTasksShow();

    IWorkflowSection clickAuditHistoryHide();

    IWorkflowSection checkBox1(String action);

    IWorkflowSection checkBox2(String action);

    IWorkflowSection checkBox3(String action);

    boolean isCheckBox2TextPresent();

    boolean isCheckBox1TextPresent();

    boolean isCheckBox3TextPresent();

    IWorkflowSection clickRejectApplication();

    IWorkflowSection clickPushQuestions();

    IWorkflowSection clickCompleteValidation();

    /** Stage 2 Credit review */

    IWorkflowSection tasksShowOrHide(ACTION showOrHide);

    IWorkflowSection auditHistoryShowOrHide(ACTION showOrHide);

    IWorkflowSection clickOfferCredit();

    IWorkflowSection clickPushQuestionsStage2();

    IWorkflowSection clickCreditDecline();

    IWorkflowSection clickViewModifyLoanOffer();

}