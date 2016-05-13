package com.r2development.leveris.selenium.borrower.pageobjects;

import java.util.List;
import java.util.Map;

public interface ILoginPage {
    String CLOSE_LOGIN_XPATH = "//a[contains(., 'X')]";
    String LOGIN_TITLE_XPATH = "//div[contains(@wicketpath, 'Title') and contains(@class, 'sc-label') and contains(., 'Login')]";
    String EMAIL_ADDRESS_XPATH = "//input[@name='USERNAME']";
    String PASSWORD_XPATH = "//input[@name='PWD']";
    String SHOW_PASSWORD_XPATH = "//label[contains(.,'Password')]/following-sibling::span[contains(@wicketpath, 'Password_showhide')]";
    String HIDE_PASSWORD_XPATH = "";
    String FORGOT_PASSWORD_XPATH = "//a[contains(., 'Forgot your password?')]";
    String LOGIN_BUTTON_XPATH = "//button[@type='submit']/span[text()='Log in']";
    String EXCEPTION_DIALOG = "//div[contains(@class,'alert-danger')]/span";

    String ERROR_EMAIL_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_txtName_tb']/following-sibling:label";

    String ERROR_BOX_ROOT_XPATH = "//div[contains(@id, 'feedbackBox') and contains(@class, 'feedback-form')]";
    String ERROR_FORMS_XPATH = "//label[contains(@class, 'message-inline-error') and @role='alert']";
    String ERROR_EMAIL_ADDRESS_XPATH = "";
    String ERROR_PASSWORD_XPATH = "";

    IWelcomePage closeLogin();

    ILoginPage setEmailAddress(String emailAddress);

    String getEmailAddress();

    ILoginPage setPassword(String password);

    String getPassword();

    INewPasswordPage clickForgotPassword();

    IBorrowerHomePage clickLogin();

    ILoginPage clickShowPassword();

    ILoginPage clickHidePassword();

    boolean isLoaded();

    boolean isErrorBox();

    List<String> getErrorBoxMessage();

    Map<String, String> getErrorForms();

    boolean isErrorEmailAddress();

    String getErrorEmailAddressMessage();

    boolean isErrorPassword();

    String getErrorPasswordMessage();
}
