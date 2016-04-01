package com.r2development.leveris.selenium.apollo.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Keys;

public class AdministrationLoginPage extends Apollo implements IAdministrationLoginPage{

    private static final Log log = LogFactory.getLog(AdministrationLoginPage.class.getName());

    SharedDriver webDriver;

    @Inject
    public static IAdministrationLoginPage getLoginPageInstance(SharedDriver webDriver) {
        log.info("");
        return new AdministrationLoginPage(webDriver);
    }

    public AdministrationLoginPage(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
        webDriver.get(System.getProperty("administration.url"));
    }

    public IAdministrationLoginPage setUsername(String login){
        log.info("");
        isVisible(USERNAME_INPUT);
        type(USERNAME_INPUT, login);
        return this;
    }

    public IAdministrationLoginPage setPassword(String password){
        log.info("");
        isVisible(PASSWORD_INPUT);
        type(PASSWORD_INPUT, password, Keys.ENTER);
        return this;
    }

    public IAdministrationHomePage clickLogin(){
        log.info("");

//        isVisible(LOGIN_BUTTON);
//        clickElementLoop(LOGIN_BUTTON, IAdministrationHomePage.USERS_LINK);
        return new AdministrationHomePage(webDriver);
    }
}