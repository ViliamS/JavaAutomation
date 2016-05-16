package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver_Apollo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class AdministrationHomePage extends AdministrationTopBanner implements IAdministrationHomePage {

    private static final Log log = LogFactory.getLog(AdministrationHomePage.class.getName());

    WebDriver webDriver;

    public AdministrationHomePage(SharedDriver_Apollo webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    public IAdministrationUsersPage clickUsersLink(){
        isVisible(IAdministrationHomePage.USERS_LINK, true);
        clickElementLoop(IAdministrationHomePage.USERS_LINK, IAdministrationUsersPage.SEARCH_INPUT);
        return new AdministrationUsersPage((SharedDriver_Apollo) webDriver);
    }
}