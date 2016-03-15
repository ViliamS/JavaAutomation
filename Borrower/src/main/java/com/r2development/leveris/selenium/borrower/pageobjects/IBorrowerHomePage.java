package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IBorrowerHomePage {
    boolean isLoaded();
    void closePopup();
    void clickGetQuoteOrGetStarted() throws Exception;

    String GET_A_QUOTE_START_TASK_BUTTON_XPATH = "//a[@wicketpath='main_c_form_embeddedFormWrapper_embeddedForm_1_form_root_c_w_pnlQuote_c_w_btnAction_script']";

    IBorrowerHomePage clickLogo();
    INotificationMessagePage clickNotificationMessages();
    IBorrowerHomePage clickYourAccount();
    void moveToYourAccount();
    IWelcomePage clickSignOut() throws Exception;
    void closeChat();

    void clickGetOneNow(); // GetNowQuote
    String getMessage();

    void clickGetApproval();
    void clickFindDreamHome();
    void clickConfigureLoan();
    void clickFinalLoanSetup();

    String getGetApprovalTitle();
    String getGetApprovalText();
    void clickWhatDocs();
    IBuildQuotationPage clickGetAQuote();
    IPersonalDetailsPage clickInfoUpload();
    void closeWhatDocs();

    void clickContactUs();
    void clickHelpCenter();
    void clickWhatElse();
    void clickLegalTerm();

    void clickStartTaskButton();

    IBorrowerHomePage clickReviewAndSubmit();
    IBorrowerHomePage clickSubmitYourApplication();
    IBorrowerHomePage checkDistanceMarketing();
    IBorrowerHomePage checkStatutory();
    IBorrowerHomePage checkDeclaration();
    IBorrowerHomePage clickFinalSubmitApplication();
}