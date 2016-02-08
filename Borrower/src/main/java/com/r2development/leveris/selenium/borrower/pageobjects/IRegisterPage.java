package com.r2development.leveris.selenium.borrower.pageobjects;

import java.util.List;
import java.util.Map;

public interface IRegisterPage {
    String CLOSE_REGISTER_XPATH = "//a[contains(., 'X')]";
    String REGISTER_TITLE_XPATH = "//div[contains(@wicketpath,'TItle') and contains(.,'Create your secure login')]"; // TODO to check html code
    String FIRSTNAME_XPATH = "//label[contains(.,'First name')]/following-sibling::input[contains(@wicketpath, 'Name')]";
    String EMAIL_ADDRESS_XPATH = "//label[contains(.,'Email address')]/following-sibling::input[contains(@wicketpath, 'EmailAddress')]";
    String PHONE_NUMBER_XPATH = "//label[contains(.,'Phone number')]/following-sibling::input[contains(@wicketpath, 'PhoneNumber')]";
    String CREATE_PASSWORD_XPATH = "//label[contains(.,'Create a password')]/following-sibling::input[contains(@wicketpath, 'Password')]";
    String SHOW_PASSWORD_XPATH = "//label[contains(.,'Create a password')]/following-sibling::span[contains(@wicketpath, 'Password_showhide')]";
    String HIDE_PASSWORD_XPATH = "";
    String CONSTRAINT_PASSWORD_XPATH = "//div[contains(@wicketpath, 'PassDescription')]//span[contains(., 'Password')]";
    String ACCEPT_TERMS_XPATH = "//div[contains(@wicketpath, 'TermsOfBusiness') and @data-type='checkbox']/span[@class='vcheckbox control']";
    String ACCEPT_DATA_POLICY = "//div[contains(@wicketpath, 'DataProtectionPolicy') and @data-type='checkbox']/span[@class='vcheckbox control']";
    String REGISTER_BUTTON_XPATH = "//div[contains(@wicketpath, 'btnRegister')]";
    String ALREADY_REGISTER_XPATH = "//div[contains(@wicketpath, 'SignIn')]";

    String ERROR_BOX_ROOT_XPATH = "//div[contains(@id, 'feedbackBox') and contains(@class, 'feedback-form')]"; // .//li
    String ERROR_FORMS_XPATH = "//label[contains(@class, 'message-inline-error') and @role='alert']";
    String ERROR_FIRSTNAME_XPATH = "";
    String ERROR_EMAIL_ADDRESS_XPATH = "";
    String ERROR_PHONE_NUMBER_XPATH = "";
    String ERROR_PASSWORD_XPATH = "";

    String getRegisterTitle();
    String getFirstname();
    IRegisterPage setFirstname(String firstName);
    IRegisterPage setEmailAddress(String emailAddress);
    String getWeEmailAddress();
    String getEmailAddress();
    String getPhoneNumber();
    IRegisterPage setPhoneNumber(String phoneNumber);
    String getPassword();
    IRegisterPage setPassword(String password);
    IRegisterPage showPassword();
    IRegisterPage hidePassword();
    String getConstraintPassword();
    IRegisterPage checkAcceptTerms();
    IRegisterPage uncheckAcceptTerms();
    IRegisterPage checkDataPolicy();
    IRegisterPage uncheckDataPolicy();
    IVerifyEmailPage clickRegister();
    ILoginPage clickAlreadyRegister();

    boolean isLoaded();
    IWelcomePage closeRegister();

    boolean isErrorBox();
    List<String> getErrorBoxMessage();
    Map<String, String> getErrorForms();
    boolean isErrorFirstname();
    String getErrorFirstnameMessage();
    boolean isErrorEmailAddress();
    String getErrorEmailAddressMessage();
    boolean isErrorPhoneNumber();
    String getErrorPhoneNumberMessage();
    boolean isErrorPassword();
    String getErrorPasswordMessage();
}
