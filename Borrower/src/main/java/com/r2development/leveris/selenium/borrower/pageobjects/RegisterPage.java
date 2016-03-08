package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class RegisterPage extends Borrower implements IRegisterPage {

    private static final Log log = LogFactory.getLog(RegisterPage.class.getName());

    @FindBy(xpath = CLOSE_REGISTER_XPATH)
    protected WebElement weCloseRegister;

    @FindBy(xpath = REGISTER_TITLE_XPATH)
    protected WebElement weRegisterTitle;

    @FindBy(xpath = FIRSTNAME_XPATH)
    protected WebElement weFirstname;

    @FindBy(xpath = EMAIL_ADDRESS_XPATH)
    protected WebElement weEmailAddress;
    private String emailAddress;

    @FindBy(xpath = PHONE_NUMBER_XPATH)
    protected WebElement wePhoneNumber;

    @FindBy(xpath = CREATE_PASSWORD_XPATH)
    protected WebElement weCreatePassword;

    @FindBy(xpath = SHOW_PASSWORD_XPATH)
    protected WebElement weShowPassword;

    @FindBy(xpath = CONSTRAINT_PASSWORD_XPATH)
    protected WebElement weConstraintPassword;

    @FindBy(xpath = ACCEPT_TERMS_XPATH)
    protected WebElement weAcceptTerms;

    @FindBy(xpath = ACCEPT_DATA_POLICY)
    protected WebElement weAcceptDataPolicy;

    @FindBy(xpath = REGISTER_BUTTON_XPATH)
    protected WebElement weRegisterButton;

    @FindBy(xpath = ALREADY_REGISTER_XPATH)
    protected WebElement weAlreadyRegisterLink;

//    @Inject
    public RegisterPage(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getRegisterTitle() {
        isVisible(REGISTER_TITLE_XPATH, true);
        return weRegisterTitle.getText();
    }

    @Override
    public String getFirstname() {
        isVisible(FIRSTNAME_XPATH, true);
        return weFirstname.getText();
    }

    @Override
    public IRegisterPage setFirstname(String firstName) {
        loadingCheck();
        isVisible(FIRSTNAME_XPATH, true);
        weFirstname.clear();
        weFirstname.sendKeys(firstName);
        return this;
    }

    @Override
    public String getWeEmailAddress() {
        isVisible(EMAIL_ADDRESS_XPATH, true);
        return weEmailAddress.getText();
    }

    @Override
    public String getEmailAddress() {
        return this.emailAddress;
    }

    @Override
    public IRegisterPage setEmailAddress(String emailAddress) {
        isVisible(EMAIL_ADDRESS_XPATH, true);
        weEmailAddress.clear();
        weEmailAddress.sendKeys(emailAddress);
        this.emailAddress = emailAddress;
        return this;
    }

    @Override
    public String getPhoneNumber() {
        return null;
    }

    @Override
    public IRegisterPage setPhoneNumber(String phoneNumber) {
        loadingCheck();
        isVisible(PHONE_NUMBER_XPATH, true);
        wePhoneNumber.clear();
        wePhoneNumber.sendKeys(phoneNumber);
        return this;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public IRegisterPage setPassword(String password) {
        isVisible(CREATE_PASSWORD_XPATH, true);
        weCreatePassword.clear();
        weCreatePassword.sendKeys(password);
        return this;
    }

    @Override
    public IRegisterPage showPassword() {
        return null;
    }

    @Override
    public IRegisterPage hidePassword() {
        return null;
    }

    @Override
    public String getConstraintPassword() {
        return null;
    }

    @Override
    public IRegisterPage checkAcceptTerms() {
        isVisible(ACCEPT_TERMS_XPATH, true);
        clickElement(ACCEPT_TERMS_XPATH);
//        weAcceptTerms.click();
        return this;
    }

    @Override
    public IRegisterPage uncheckAcceptTerms() {
        return null;
    }

    @Override
    public IRegisterPage checkDataPolicy() {
        isVisible(ACCEPT_DATA_POLICY, true);
        clickElement(ACCEPT_DATA_POLICY);
//        weAcceptDataPolicy.click();
        return this;
    }

    @Override
    public IRegisterPage uncheckDataPolicy() {
        return null;
    }

    @Override
    public IVerifyEmailPage clickRegister() {
        loadingCheck();
        isVisible(REGISTER_BUTTON_XPATH, true);
        clickElement(REGISTER_BUTTON_XPATH);
        loadingCheck();
//        weRegisterButton.click();
        isInvisible(ERROR_BOX_ROOT_XPATH, true);
        isInvisible(ERROR_FORMS_XPATH, true);
        return new VerifyEmailPage(webDriver);
    }

    @Override
    public ILoginPage clickAlreadyRegister() {
        return null;
    }

    @Override
    public boolean isLoaded() {
        loadingCheck();
        isVisible(CLOSE_REGISTER_XPATH, true);
        isVisible(REGISTER_TITLE_XPATH, true);
        isVisible(FIRSTNAME_XPATH, true);
        isVisible(EMAIL_ADDRESS_XPATH, true);
        isVisible(PHONE_NUMBER_XPATH, true);
        isVisible(CREATE_PASSWORD_XPATH, true);
        isVisible(SHOW_PASSWORD_XPATH, true);
        isVisible(CONSTRAINT_PASSWORD_XPATH, true);
        isVisible(ACCEPT_TERMS_XPATH, true);
        isVisible(ACCEPT_DATA_POLICY, true);
        isVisible(REGISTER_BUTTON_XPATH, true);
        isVisible(ALREADY_REGISTER_XPATH, true);
        isVisible(REGISTER_BUTTON_XPATH, true);
        return true;
    }

    @Override
    public IWelcomePage closeRegister() {
        isVisible(CLOSE_REGISTER_XPATH, true);
        weCloseRegister.click();
        return new WelcomePage(webDriver);
    }

    @Override
    public boolean isErrorBox() {
        return false;
    }

    @Override
    public List<String> getErrorBoxMessage() {
        return null;
    }

    @Override
    public Map<String, String> getErrorForms() {
        return null;
    }

    @Override
    public boolean isErrorFirstname() {
        return false;
    }

    @Override
    public String getErrorFirstnameMessage() {
        return null;
    }

    @Override
    public boolean isErrorEmailAddress() {
        return false;
    }

    @Override
    public String getErrorEmailAddressMessage() {
        return null;
    }

    @Override
    public boolean isErrorPhoneNumber() {
        return false;
    }

    @Override
    public String getErrorPhoneNumberMessage() {
        return null;
    }

    @Override
    public boolean isErrorPassword() {
        return false;
    }

    @Override
    public String getErrorPasswordMessage() {
        return null;
    }
}
