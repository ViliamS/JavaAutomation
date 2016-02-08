package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IAddYourCoapplicantSection {
    String TITLE_XPATH = "//h2[contains(., 'ADD YOUR CO-APPLICANT')]";
    String DESCRIPTION_XPATH = "//div[contains(@wicketpath, 'SummaryText')]/span";
    String FIRSTNAME_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_txtFirstName_tb']"; //label[contains(., 'First name')]/following-sibling::input";
    String EMAIL_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_txtEmail_tb']"; //label[contains(., 'Email address')]/following-sibling::input";
    String INVITE_NOW_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_btnInvite_submit']"; //a[contains(., 'INVITE NOW')]";
    String BACK_TO_DASHBOARD_XPATH = "//a[text()='Back to Dashboard']";

    IAddYourCoapplicantSection setFirstName(String firstName);
    IAddYourCoapplicantSection setEmail(String email);
    IAddYourCoapplicantSection clickInviteNow();
    IBorrowerHomePage clickBackToDashboard();
}
