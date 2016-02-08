package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IWelcomePage {
    String QUOTE_XPATH = "//a[contains(., 'Quote')]";
    String LOGIN_XPATH = "//a[contains(., 'Login')]";
    String SIGN_IN_XPATH = "//a[contains(., 'Sign in')]";
    String REGISTER_XPATH = "//a[contains(., 'Register')]";

    String getVersion();
    IBuildQuotationPage clickQuote();
    ILoginPage clickLogin();
    IRegisterPage clickRegister();
    ILoginPage clickSignIn();

    IWelcomePage goToWelcomePage();
    boolean isLoaded();
}