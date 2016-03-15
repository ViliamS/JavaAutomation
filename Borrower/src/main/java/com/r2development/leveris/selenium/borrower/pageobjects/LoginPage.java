package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LoginPage extends Borrower implements ILoginPage {

    private static final Log log = LogFactory.getLog(LoginPage.class.getName());

    @FindBy( xpath = CLOSE_LOGIN_XPATH)
    protected WebElement weCloseLogin;

    @FindBy( xpath = LOGIN_TITLE_XPATH)
    protected WebElement weTitle;

    @FindBy( xpath = EMAIL_ADDRESS_XPATH)
    protected WebElement weEmailAddress;

    @FindBy( xpath = PASSWORD_XPATH)
    protected WebElement wePassword;

    @FindBy( xpath = SHOW_PASSWORD_XPATH)
    protected WebElement weShowHidePassword;

    @FindBy( xpath = FORGOT_PASSWORD_XPATH)
    protected WebElement weForgotPassword;

    @FindBy( xpath = LOGIN_BUTTON_XPATH)
    protected WebElement weLoginButton;

//    @Inject
    public LoginPage(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public IWelcomePage closeLogin() {
        isVisible(CLOSE_LOGIN_XPATH, true);
        weCloseLogin.click();
        loadingCheck();
        return new WelcomePage(webDriver);
    }

    @Override
    public ILoginPage setEmailAddress(String emailAddress) {
        loadingCheck();
        isVisible(EMAIL_ADDRESS_XPATH, true);
        weEmailAddress.clear();
        weEmailAddress.sendKeys(emailAddress);
        return this;
    }

    @Override
    public String getEmailAddress() {
        return null;
    }

    @Override
    public ILoginPage setPassword(String password) {
        isVisible(PASSWORD_XPATH, true);
        wePassword.clear();
        wePassword.sendKeys(password);
        return this;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public INewPasswordPage clickForgotPassword() {
        return null;
    }

    @Override
    public ILoginPage clickShowPassword() {
        return null;
    }

    @Override
    public ILoginPage clickHidePassword() {
        return null;
    }

    private Map<String, String> formExceptionDetails(){
        Map<String, String> formExceptionDetails = new LinkedHashMap<>();
        formExceptionDetails.put(
                "FormName",
                "\n Login button is still present! \n" +
                        " Extracting exception text from dialog \n"
        );
        formExceptionDetails.put(
                "GetExceptionResult1",
                "\n -------------------------------\n" +
                        " | Not being able to login @!!@ | \n" +
                        " | due to : "
        );
        formExceptionDetails.put(
                "GetExceptionResult2",
                " | \n ------------------------------- \n"
        );
        formExceptionDetails.put(
                "FormAction",
                "Failed clickLogin"
        );
        return formExceptionDetails;
    }

    @Override
    public IBorrowerHomePage clickLogin() {
        isVisible(LOGIN_BUTTON_XPATH, true);
        clickElement(LOGIN_BUTTON_XPATH);
        loadingCheck();
        // TODO tocheck
        formSubmitPostSync(LOGIN_BUTTON_XPATH, EXCEPTION_DIALOG, formExceptionDetails());

//        try{
//        isNotVisible(LOGIN_BUTTON_XPATH, true, 5);
//        } catch(Exception x){
//            log.info("\n Login button is still present! \n Extracting exception text from dialog \n");
//            if(isVisible(EXCEPTION_DIALOG)){
//                log.info("\n -------------------------------\n | Not being able to login @!!@ | \n | due to : " + getExceptionText() + " | \n ------------------------------- \n");
//                Assert.assertTrue("Failed to Login", false);
//            }
//        }
        return new BorrowerHomePage(webDriver);
    }

    @Override
    public boolean isLoaded() {
        loadingCheck();
        isVisible(LOGIN_TITLE_XPATH, true);
        isVisible(EMAIL_ADDRESS_XPATH, true);
        isVisible(PASSWORD_XPATH, true);
        isVisible(SHOW_PASSWORD_XPATH, true);
        isVisible(FORGOT_PASSWORD_XPATH, true);
        isVisible(LOGIN_BUTTON_XPATH, true);
        return true;
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
    public boolean isErrorEmailAddress() {
        return false;
    }

    @Override
    public String getErrorEmailAddressMessage() {
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
