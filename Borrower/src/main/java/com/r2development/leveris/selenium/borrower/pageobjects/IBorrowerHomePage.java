package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IBorrowerHomePage {
    boolean isLoaded();
    void closePopup();
    void clickGetQuoteOrGetStarted() throws Exception;

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

    IBorrowerHomePage clickReviewAndSubmit();
    IBorrowerHomePage clickSubmitYourApplication();
    IBorrowerHomePage checkDistanceMarketing();
    IBorrowerHomePage checkStatutory();
    IBorrowerHomePage checkDeclaration();
    IBorrowerHomePage clickFinalSubmitApplication();
}