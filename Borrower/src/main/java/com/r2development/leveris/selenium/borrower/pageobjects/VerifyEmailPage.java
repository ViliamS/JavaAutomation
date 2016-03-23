package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyEmailPage extends Borrower implements IVerifyEmailPage {

    private static final Log log = LogFactory.getLog(VerifyEmailPage.class.getName());

    @FindBy( xpath = VERIFY_EMAIL_TITLE_XPATH)
    protected WebElement weTitle;

    @FindBy( xpath = VERIFY_EMAIL_DESCRIPTION_XPATH )
    protected WebElement weDescription;

    @FindBy( xpath = VERIFY_EMAIL_RESEND_XPATH )
    protected WebElement weResend;

    @FindBy( xpath = VERIFY_EMAIL_INPUT_XPATH)
    protected WebElement weInputEmail;

    @FindBy( xpath = VERIFY_EMAIL_RESEND2_XPATH)
    protected WebElement weResend2;

    public VerifyEmailPage(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isLoaded(String emailAddress) {
        loadingCheck();
        isVisible(VERIFY_EMAIL_TITLE_XPATH, true);
        isVisible(VERIFY_EMAIL_DESCRIPTION_XPATH.replace("${replace}$", emailAddress), true);
        isVisible(VERIFY_EMAIL_NO_EMAIL_XPATH, true);
        isVisible(VERIFY_EMAIL_RESEND_XPATH, true);
        return true;
    }

    @Override
    public IVerifyEmailPage clickReSent() {
        loadingCheck();
        isVisible(VERIFY_EMAIL_RESEND_XPATH, 1);
        clickElement(VERIFY_EMAIL_RESEND_XPATH);
        loadingCheck();
        return new VerifyEmailPage(webDriver);
    }

    @Override
    public IVerifyEmailPage clickReSent2() {
        loadingCheck();
        isVisible(VERIFY_EMAIL_INPUT_XPATH, 1);
        isVisible(VERIFY_EMAIL_RESEND2_XPATH, 1);
        clickElement(VERIFY_EMAIL_RESEND2_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IVerifyEmailPage setEmail(String email) {
        loadingCheck();
        isVisible(VERIFY_EMAIL_INPUT_XPATH, 1);
        type(VERIFY_EMAIL_INPUT_XPATH, email);
        loadingCheck();
        return this;
    }

    @Override
    public IWelcomePage redirectToWelcomePage() {
        return new WelcomePage(webDriver).goToWelcomePage();
    }
}