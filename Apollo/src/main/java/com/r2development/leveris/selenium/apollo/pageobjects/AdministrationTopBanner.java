package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver_Apollo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class AdministrationTopBanner extends Apollo implements IAdministrationTopBanner {

    private static final Log log = LogFactory.getLog(AdministrationTopBanner.class.getName());

    private WebDriver webDriver;

    public AdministrationTopBanner(SharedDriver_Apollo webDriver){
        super( webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IAdministrationUsersPage clickBannerLinkUsers(){
        log.info("");
        isVisible(IAdministrationTopBanner.USERS_LINK);
        clickElementLoop(IAdministrationTopBanner.USERS_LINK, IAdministrationUsersPage.SEARCH_INPUT);
        return new AdministrationUsersPage((SharedDriver_Apollo) webDriver);
    }

    @Override
    public IAdministrationTopBanner clickAdminFirstNameLastNameLink(){
        log.info("");
        isVisible(ADMIN_FIRSTNAME_LASTNAME_LINK, true);
        clickElement(ADMIN_FIRSTNAME_LASTNAME_LINK);
        isVisible(ADMIN_FN_LN_DROPDOWN_OPEN);
        return this;
    }

    @Override
    public IAdministrationLoginPage logouts(){
        log.info("");
        clickAdminFirstNameLastNameLink();
        isVisible(ADMIN_FN_LN_DROPDOWN_OPEN, true);
        isVisible(LOGOUT_LINK);
        clickElement(LOGOUT_LINK);
        return new AdministrationLoginPage((SharedDriver_Apollo) webDriver);
    }

    public void clickBannerLinkRoles(){
        log.info("");

    }

    public void clickBannerLinkFundManager(){
        log.info("");

    }

}