package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by viliamstrobich on 29.03.16.
 */
public class AdministrationLoginPage extends Apollo implements IAdministrationLoginPage{

    private static final Log log = LogFactory.getLog(AdministrationLoginPage.class.getName());

    SharedDriver webDriver;

    public static IAdministrationLoginPage getLoginPageInstance(SharedDriver webDriver) {
        log.info("");
        IAdministrationLoginPage administrationLoginPage = new AdministrationLoginPage(webDriver);
        PageFactory.initElements(webDriver, administrationLoginPage);
        return administrationLoginPage;
    }

    public AdministrationLoginPage(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
        webDriver.get(System.getProperty("apollo.client"));
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
        type(PASSWORD_INPUT, password);
        return this;
    }

    public IAdministrationHomePage clickLogin(){
        log.info("");
        isVisible(LOGIN_BUTTON);
        clickElement(LOGIN_BUTTON);
        return new AdministrationHomePage(webDriver);
    }
}