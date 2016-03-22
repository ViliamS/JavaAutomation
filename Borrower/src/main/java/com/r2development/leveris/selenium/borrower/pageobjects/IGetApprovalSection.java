package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IGetApprovalSection {
    String GET_APPROVAL_SECTION_XPATH = "//div[@wicketpath='main_c_form' and contains(@class, 'center')]";

    String GET_APPROVAL_TITLE_XPATH = "//div[contains(@wicketpath, 'GetApprovalTitle') and contains(@data-path, 'GetApprovalTitle') and contains(., 'Get approval')]";
    String GET_APPROVAL_TEXT_XPATH = "//div[contains(@wicketpath, 'GetApprovalText') and contains(@data-path, 'GetApprovalText')]//span";
    String GET_APPROVAL_DOCS_LINK_XPATH = "//a[contains(., 'What docs do i need')]";

    String POPUP_CLOSE_XPATH = "//a[@href='#' and  @role='button' and contains(., 'close')]";
    String GET_APPROVAL_GET_A_QUOTE_XPATH = "//div[contains(@wicketpath, 'Quote') and @data-path='pnlQuote' and contains(., 'Get a quote')]";
//    String GET_APPROVAL_INVITE_COAPPLICANT_START_TASK_XPATH = "//a[@wicketpath='main_c_form_embeddedFormWrapper_embeddedForm_2_form_root_c_w_pnlCoapplicant_c_w_btnAction_submit']";
    String GET_APPROVAL_INVITE_COAPPLICANT_START_TASK_XPATH = "//div[contains(@data-path,'pnlCoapplicant btnAction')]/a[contains(., 'Start Task')]";
    String GET_APPROVAL_INVITE_COAPPLICANT_XPATH = "//div[contains(@wicketpath, 'Coapplicant') and @data-path='pnlCoapplicant' and contains(., 'Invite a co-applicant')]";
    String GET_APPROVAL_INFO_UPLOAD_XPATH = "//a[@wicketpath='main_c_form_embeddedFormWrapper_embeddedForm_2_form_root_c_w_pnlForms_c_w_btnAction_script']"; //div[contains(@wicketpath, 'Forms') and @data-path='pnlForms' and contains(., 'Some other info and uploads we need')]";

    String WHAT_DOCS_CONTAINER_XPATH = "//div[@role='dialog']";
    String WHAT_DOCS_XPATH = "//h3[contains(., 'What documentation do I need?')]";
    String WHAT_DOCS_DESCRIPTION_XPATH = WHAT_DOCS_XPATH + "//div[contains(@class, 'sc-label') and contains(., 'documentation')]";
    String WHAT_DOCS_PROOF_ID_XPATH = WHAT_DOCS_XPATH + "//div[contains(@class, 'sc-label') and contains(., 'Proof of ID')]";
    String WHAT_DOCS_PROOF_ADDRESS_XPATH = WHAT_DOCS_XPATH + "//div[contains(@class, 'sc-label') and contains(., 'Proof of Adress')]"; // TODO address in the html code
    String WHAT_DOCS_PROOF_INCOME_XPATH = WHAT_DOCS_XPATH + "//div[contains(@class, 'sc-label') and contains(., 'Proof of income')]";
    String WHAT_DOCS_SALARY_CERT_XPATH = WHAT_DOCS_XPATH + "//div[contains(@class, 'sc-label') and contains(., 'Salary cert')]";
    String WHAT_DOCS_PROOF_FUNDING_XPATH = WHAT_DOCS_XPATH + "//div[contains(@class, 'sc-label') and contains(., 'Proof of funding')]";
    String WHAT_DOCS_GIFT_FUNDING_XPATH = WHAT_DOCS_XPATH + "//div[contains(@class, 'sc-label') and contains(., 'Gift funding')]";
    String WHAT_DOCS_RESIDENT_XPATH = WHAT_DOCS_XPATH + "//div[contains(@class, 'sc-label') and contains(., 'Non resident?')]";
    String WHAT_DOCS_CLOSE_XPATH = "//a[@role='button' and contains(., 'close')]";

    String INVITE_COAPPLICANT_XPATH = "//a[contains(., 'Invite')]";
    String GO_SOLO_XPATH = "//a[contains(., 'Go solo')]";


    String READY_TO_REVIEW_AND_SUBMIT_TITLE_XPATH = "//div[@id='lbl_ReadyToSubmitTitleaa' and contains(., 'Ready to Submit')]"; // TODO to check html code
    String READY_TO_REVIEW_AND_SUBMIT_BUTTON_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnl-YouAreReadyToSubmit_c_w_btn-ReviewAndSubmit_submit']";


//    String GET_APPROVAL_SUBMIT_YOUR_APPLICATION_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_btnSubmitApplication_submit']";
    String GET_APPROVAL_SUBMIT_YOUR_APPLICATION_XPATH = "//a[contains(., 'Submit your application')]";
    String GET_APPROVAL_CHECK_DISTANCE_MARKETING_XPATH = "//label[@wicketpath='main_c_form_form_root_c_w_pnlBeforeSubmit_c_w_chkDistanceMarketing_label']/following-sibling::span/a";
    String GET_APPROVAL_CHECK_STATUTORY_XPATH = "//label[@wicketpath='main_c_form_form_root_c_w_pnlBeforeSubmit_c_w_chkStatutory_label']/following-sibling::span/a";
    String GET_APPROVAL_CHECK_DECLARATION_XPATH = "//label[@wicketpath='main_c_form_form_root_c_w_pnlBeforeSubmit_c_w_chkDeclarations_label']/following-sibling::span/a";
    String GET_APPROVAL_CHECK_FRAUD_CREDIT_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_pnlBeforeSubmit_c_w_chkCraAml_checkbox']/following-sibling::span/a";

    String GET_APPROVAL_FINAL_SUBMIT_APPLICATION_ENABLED_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlSubmitButton_c_w_btnSubmitApplication'][contains(@class,'widget-enabled')]"; //[not(contains(@class,'widget-disabled'))][contains(@class,'widget-enabled')]/em[not(contains(@class,'disabled'))]";
    String GET_APPROVAL_FINAL_SUBMIT_APPLICATION_DISABLED_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlSubmitButton_c_w_btnSubmitApplication'][contains(@class,'widget-disabled')]";//[not(contains(@class,'widget-enabled'))]/em[contains(@class,'ui-button-disabled') and contains(@class,'ui-state-disabled')]";



    String GET_APPROVAL_CONFIRMATION_XPATH  = "//div[@wicketpath='main_c_form_form_root_c_w_pnl-YourAppHasBeenSubmitted_c_w_lbl-YourAppHasBeenSubmittedTitle']";

    String getGetApprovalTitle();
    String getGetApprovalText();
    void clickWhatDocs();
    void closePopup();
    IBuildQuotationPage clickGetAQuote();
    IPersonalDetailsPage clickInfoUpload();
    void closeWhatDocs();

    IGetApprovalSection clickReviewAndSubmit();
    IGetApprovalSection clickSubmitYourApplication();
    IGetApprovalSection checkDistanceMarketing();
    IGetApprovalSection checkStatutory();
    IGetApprovalSection checkDeclaration();
    IGetApprovalSection checkCreditFraud();
    IGetApprovalSection clickFinalSubmitApplication();

    boolean isLoaded();
}
