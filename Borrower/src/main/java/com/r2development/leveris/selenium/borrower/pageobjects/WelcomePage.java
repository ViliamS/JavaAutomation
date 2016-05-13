package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends Borrower implements IWelcomePage {

    private static final Log log = LogFactory.getLog(WelcomePage.class.getName());

    @FindBy(xpath = QUOTE_XPATH)
    protected WebElement weQuote;

    @FindBy(xpath = LOGIN_XPATH)
    protected WebElement weLogin;

    @FindBy(xpath = REGISTER_XPATH)
    protected WebElement weRegister;

    //    @Inject
    public WelcomePage(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public IWelcomePage goToWelcomePage() {
        get(System.getProperty("borrower"));
        return this;
    }

    public WelcomePage(SharedDriver webDriver, boolean toSetUrl) {
        super(webDriver);
        if (toSetUrl)
            get(System.getProperty("borrower"));
    }

    @Override
    public boolean isLoaded() {
        loadingCheck();
        isVisible(QUOTE_XPATH, true);
        isVisible(LOGIN_XPATH, true);
        isVisible(REGISTER_XPATH, true);
        return true;
    }

    @Override
    public String getVersion() {
//        return getText(ABAKUS_VERSION_XPATH);
        return null;
    }

    @Override
    public IBuildQuotationPage clickQuote() {
        isVisible(QUOTE_XPATH, true);
        clickElement(QUOTE_XPATH);
//        weQuote.click();
        return new BuildQuotationPage(webDriver);
    }

    @Override
    public ILoginPage clickLogin() {
        isVisible(LOGIN_XPATH, true);
//        weLogin.click();
        clickElement(LOGIN_XPATH);
        loadingCheck();
        return new LoginPage(webDriver);
    }

    @Override
    public ILoginPage clickSignIn() {
        isVisible(SIGN_IN_XPATH, true);
        clickElement(SIGN_IN_XPATH);
        loadingCheck();
        return new LoginPage(webDriver);
    }

    @Override
    public IRegisterPage clickRegister() {
        isVisible(REGISTER_XPATH, true);
        clickElement(REGISTER_XPATH);
        loadingCheck();
//        weRegister.click();
        return new RegisterPage(webDriver);
    }
}