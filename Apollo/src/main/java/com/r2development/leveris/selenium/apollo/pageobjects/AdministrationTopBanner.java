package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class AdministrationTopBanner extends Apollo implements IAdministrationTopBanner {

    private static final Log log = LogFactory.getLog(AdministrationTopBanner.class.getName());

    SharedDriver webDriver;

    AdministrationTopBanner(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    public IAdministrationUsersPage clickBannerLinkUsers(){
        isVisible(ROLES_LINK);
        clickElement(ROLES_LINK);
        return new AdministrationUsersPage(webDriver);
    }

    public void clickBannerLinkRoles(){}

    public void clickBannerLinkFundManager(){}

}