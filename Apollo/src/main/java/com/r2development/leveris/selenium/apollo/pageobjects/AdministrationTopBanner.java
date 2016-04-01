package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class AdministrationTopBanner extends Apollo implements IAdministrationTopBanner {

    private static final Log log = LogFactory.getLog(AdministrationTopBanner.class.getName());

    private WebDriver webDriver;

    protected IAdministrationHomePage administrationHomePage;
    protected IAdministrationUsersPage administrationUsersPage;


    public AdministrationTopBanner(SharedDriver webDriver){
        super( webDriver);
        this.webDriver = webDriver;
        administrationHomePage = new AdministrationHomePage(webDriver);
    }

    public IAdministrationUsersPage clickBannerLinkUsers(){
        isVisible(IAdministrationTopBanner.USERS_LINK);
        clickElementLoop(IAdministrationTopBanner.USERS_LINK, IAdministrationUsersPage.SEARCH_INPUT);
        return administrationUsersPage = new AdministrationUsersPage((SharedDriver) webDriver);
    }

    public void clickBannerLinkRoles(){}

    public void clickBannerLinkFundManager(){}

}