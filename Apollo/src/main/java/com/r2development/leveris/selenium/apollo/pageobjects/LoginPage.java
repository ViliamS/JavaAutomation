package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Apollo implements ILoginPage {

    private static final Log log = LogFactory.getLog(LoginPage.class.getName());

    @FindBy(xpath = USERNAME_XPATH)
    private WebElement weUsername;
    //private String username;

    @FindBy(xpath = PASSWORD_XPATH)
    private WebElement wePassword;
    //private String password;

    @FindBy(xpath = SUBMIT_XPATH)
    private WebElement weSubmit;

    public static ILoginPage getLoginPageInstance(SharedDriver webDriver) {
        ILoginPage loginPage = new LoginPage(webDriver);
        PageFactory.initElements(webDriver, loginPage);
        return loginPage;
    }

    public LoginPage(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        webDriver.get(System.getProperty("apollo.client"));
    }

    /*
    public LoginPage LoginPage(SharedDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APOLLO_ENVIRONMENT.get(ENVIRONMENT_RUN.name()).get(APPLICATION_RUN));
        return this;
    }
    */

    public String getUsername() {
        return this.weUsername.getText();
    }

    @Override
    public ILoginPage setUsername(String username) {
        isVisible(USERNAME_XPATH);
        this.weUsername.clear();
        this.weUsername.sendKeys(username);
        return this;
    }

    public String getPassword() {
        return this.wePassword.getText();
    }

    @Override
    public ILoginPage setPassword(String password) {
        isVisible(PASSWORD_XPATH);
        this.wePassword.clear();
        this.wePassword.sendKeys(password);
        return this;
    }

    @Override
    public ISearchPage clickSubmit() {
        isVisible(SUBMIT_XPATH);
        weSubmit.click();
        return SearchPage.getSearchSectionInstance(webDriver);
    }
}

