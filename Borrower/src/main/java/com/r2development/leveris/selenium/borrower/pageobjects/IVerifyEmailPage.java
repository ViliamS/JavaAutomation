package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IVerifyEmailPage {

    String VERIFY_EMAIL_TITLE_XPATH = "//div[contains(@wicketpath, 'TItle') and contains(@class, 'sc-label') and contains(., 'Verify your email')]"; // TODO to check html code
    String VERIFY_EMAIL_DESCRIPTION_XPATH = "//div[contains(@wicketpath, 'Description') and contains(@class, 'sc-label') and contains(., '${replace}$')]";
    String VERIFY_EMAIL_NO_EMAIL_XPATH = "//div[contains(@wicketpath, 'DidndReceiveEmail') and contains(@class, 'sc-label') and contains(., 'Didn') and contains(., 't get the email')]"; // TODO to check html code
    String VERIFY_EMAIL_RESEND_XPATH = "//a[contains(@class, 'sc-button') and contains(@wicketpath, 'Resend_submit') and contains(., 'Click to resend')]";
    String VERIFY_EMAIL_INPUT_XPATH = "//label[contains(@wicketpath, 'EmailAddress')]/following-sibling::input";
    String VERIFY_EMAIL_RESEND2_XPATH = "//a[contains(@class, 'sc-button') and contains(@wicketpath, 'Resend_submit') and contains(., 'Resend')]";

    boolean isLoaded(String emailAddress);
    IVerifyEmailPage clickReSent();
    IVerifyEmailPage clickReSent2();
    IVerifyEmailPage setEmail(String email);
    IWelcomePage redirectToWelcomePage() ;
}
