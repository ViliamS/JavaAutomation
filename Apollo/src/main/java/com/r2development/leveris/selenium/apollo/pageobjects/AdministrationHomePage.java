package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class AdministrationHomePage extends AdministrationTopBanner implements IAdministrationHomePage {

    private static final Log log = LogFactory.getLog(AdministrationHomePage.class.getName());

    SharedDriver webDriver;

    public AdministrationHomePage(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    public IAdministrationUsersPage clickUsersLink(){
        isVisible(IAdministrationHomePage.USERS_LINK, true);
        clickElement(IAdministrationHomePage.USERS_LINK);
        return new AdministrationUsersPage(webDriver);
    }
}