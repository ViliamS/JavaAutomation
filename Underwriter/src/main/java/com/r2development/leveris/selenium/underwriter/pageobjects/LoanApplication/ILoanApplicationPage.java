package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs.*;
import com.r2development.leveris.utils.Enums.LOANAPPSECTIONS;
import com.r2development.leveris.utils.Enums.UNDERWRITINGSTATUS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;

public interface ILoanApplicationPage {

    ILoanApplicationPage sectionHideUnhide(LOANAPPSECTIONS section, ACTION action);

    IFinanceToolSection financeToolSectionHideUnhide(ACTION action);

    IWorkflowSection workflowSectionHideUnhide(ACTION action);

    ILoanOfferToolSection loanOfferToolSectionHideUnhide(ACTION action);

    IFormToolsSection formToolSectionHideUnhide(ACTION action);

    IDocumentsSection documentsSectionHideUnhide(ACTION action);

    IDocuments2Section documents2SectionHideUnhide(ACTION action);

    INotesSection notesSectionHideUnhide(ACTION action);

    IUpdateHistorySection updateHistorySectionHideUnhide(ACTION action);

    IWorkflowSection clickRefresh();

    IWorkflowSection clickOpenFormViewer();

    IWorkflowSection clickOpenDocumentViewer();

    IWorkflowSection clickDocumentValidationShow();

    IWorkflowSection clickTasksShow();

    IWorkflowSection clickAuditHistoryHide();

    IWorkflowSection checkBox1(String action);

    boolean isCheckBox1TextPresent();

    IWorkflowSection checkBox2(String action);

    boolean isCheckBox2TextPresent();

    IWorkflowSection checkBox3(String action);

    boolean isCheckBox3TextPresent();

    IWorkflowSection clickRejectApplication();

    IWorkflowSection clickPushQuestions();

    IWorkflowSection clickCompleteValidation();

    /** Documents Section */

    int getNumberOfUploadedDocuments();

    IDocumentsDetail openDocument(String indexNumber);

    IDocumentsDetail openDocument(int i);

    boolean isDocumentInExpectedStatus(UNDERWRITINGSTATUS underwritingstatus, int documentRowIndex);

    /** Risk Tool Section */

    IRiskToolSection setStatusDropDown(String value);

    IRiskToolSection riskToolSectionHideUnhide(ACTION action);

    IRiskToolSection setManuallyUpdateCheckbox(ACTION checkUncheck);

    IRiskToolSection clickSaveKYC();

    ISetFICODialog clickSetFICO();

    ISetAMLDialog clickSetAML();

    ISetFraudDialog clickSetFraud();

    IRepeatCustomerDialog clickSetRepCustomer();

    ISetScoreOverrideDialog clickSetScoreOverride();

    IAddNoteDialog clickSetNote();

    /** Loan Offer Tool Section */

    ILoanOfferToolSection selectLoanOfferVersionLatest();

    boolean isScoreWarningDisplayed();

    ILoanOfferToolSection selectLoanOfferVersion(String version);

    ILoanOfferToolSection clickEditReview();

    ILoanOfferToolSection clickReset();

    ILoanOfferToolSection clickSaveOffer();

    INewLoanOfferConditionDialog clickAddCondition();

    ILoanOfferToolSection addComment(String comment);

    IRiskToolSection clickSignReview();

    /** Workflow Stage 2 Credit review */

    IWorkflowSection tasksShowOrHide(ACTION showOrHide);

    IWorkflowSection auditHistoryShowOrHide(ACTION showOrHide);

    IWorkflowSection clickOfferCredit();

    IWorkflowSection clickPushQuestionsStage2();

    IWorkflowSection clickCreditDecline();

    IWorkflowSection clickViewModifyLoanOffer();

}