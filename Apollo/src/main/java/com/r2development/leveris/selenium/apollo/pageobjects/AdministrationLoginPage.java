package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class AdministrationLoginPage extends Apollo implements IAdministrationLoginPage{

    private static final Log log = LogFactory.getLog(AdministrationLoginPage.class.getName());

    WebDriver webDriver;

    public AdministrationLoginPage(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IAdministrationLoginPage goToApolloAdministrationLoginPage(){
        webDriver.get(System.getProperty("administration.url"));
        return this;
    }

    @Override
    public boolean isUsernameInputPresent(){
        log.info("");
        return isVisible(USERNAME_INPUT, 15);
    }

    @Override
    public IAdministrationLoginPage setUsername(String login){
        log.info("");
        isVisible(USERNAME_INPUT);
        type(USERNAME_INPUT, login);
        return this;
    }

    @Override
    public IAdministrationLoginPage setPassword(String password){
        log.info("");
        isVisible(PASSWORD_INPUT);
        type(PASSWORD_INPUT, password/*, Keys.ENTER*/);
        return this;
    }

    @Override
    public IAdministrationTopBanner clickLogin(){
        log.info("");
        isVisible(LOGIN_BUTTON);
        clickElementLoop(LOGIN_BUTTON, IAdministrationHomePage.USERS_LINK);
        return new AdministrationTopBanner((SharedDriver) webDriver);
    }
}