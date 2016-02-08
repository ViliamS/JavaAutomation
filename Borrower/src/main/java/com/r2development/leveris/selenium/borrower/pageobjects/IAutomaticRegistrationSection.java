package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IAutomaticRegistrationSection {

    String TITLE_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_lblTitle_l']";
    String INPUT_APPLICANT_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_txtId_tb']";
    String CHECKBOX_QUOTE_COMPLETE_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_chkQuote']//a";
    String CHECKBOX_INVITE_COAPPLICANT_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_chkCoapp']//a";
    String INPUT_COAPPLICANT_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_pnlQuote_c_w_txtCoapp_tb']";
    String LINK_CREATE_NEW_USER_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_btn-register']/a";

    void typeApplicantId(String applicantId);
    void checkQuoteComplete();
    void uncheckQuoteComplete();
    boolean isCheckedQuoteComplete();

    void checkInviteCoapplicant();
    void uncheckInviteCoapplicant();
    boolean isCheckedInviteCoapplicant();
    boolean isEnableInviteCoapplicant();

    void typeCoapplicantId(String coapplicantId);

    // TODO ... to check in which page we move to.
    void clickCreateNewUser();

}
