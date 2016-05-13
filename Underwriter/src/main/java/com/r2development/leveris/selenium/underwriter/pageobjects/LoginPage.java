package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.Underwriter;
import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Underwriter implements ILoginPage {

    private static final Log log = LogFactory.getLog(LoginPage.class.getName());

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public ILoginPage goToUnderwriterLoginPage() {
        log.info("");
        webDriver.get(System.getProperty("underwriter.url"));
        return this;
    }

    @Override
    public boolean isUsernameInputPresent() {
        log.info("");
        return isVisible(USERNAME_INPUT, 15);
    }

    @Override
    public ILoginPage setUsername(String login) {
        log.info("");
        isVisible(USERNAME_INPUT);
        type(USERNAME_INPUT, login);
        return this;
    }

    @Override
    public ILoginPage setPassword(String password) {
        log.info("");
        isVisible(PASSWORD_INPUT);
        type(PASSWORD_INPUT, password);
        return this;
    }

    @Override
    public ISideMenu clickLogin() {
        log.info("");
        isVisible(LOGIN_BUTTON);
        clickElementLoop(LOGIN_BUTTON, IApplicationListPage.TITLE_APPLICATION_LIST);
        return new SideMenu((SharedDriver) webDriver);
    }
}