package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver_Apollo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class AdministrationUserDetailPage extends AdministrationTopBanner implements IAdministrationUserDetailPage{

    private static final Log log = LogFactory.getLog(AdministrationUserDetailPage.class.getName());

    WebDriver webDriver;

    public AdministrationUserDetailPage(SharedDriver_Apollo webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IAdministrationUserDetailPage clickSendActivationEmail(){
        log.info("");
        isVisible(SEND_ACTIVATION_EMIAL_BUTTON, true);
        clickElement(SEND_ACTIVATION_EMIAL_BUTTON);
        return this;
    }

    @Override
    public IAdministrationAssignRolesPage clickManageRoles(){
        log.info("");
        isVisible(MANAGE_ROLES_BUTTON, true);
        clickElement(MANAGE_ROLES_BUTTON);
        return new AdministrationAssignRolesPage((SharedDriver_Apollo) webDriver);
    }

    @Override
    public IAdministrationUsersPage clickBack(){
        log.info("");
        isVisible(BACK_BUTTON, true);
        clickElement(BACK_BUTTON);
        return new AdministrationUsersPage((SharedDriver_Apollo) webDriver);
    }

    @Override
    public IAdministrationUserDetailPageEditDetails clickEditDetails(){
        log.info("");
        isVisible(EDIT_DETAILS_BUTTON, true);
        clickElement(EDIT_DETAILS_BUTTON);
        return new AdministrationUserDetailPageEditDetails((SharedDriver_Apollo) webDriver);
    }

    @Override
    public String getDateOfBirth(){
        log.info("");
        isVisible(USER_DETAILS_DATA, true);
        return getText(USER_DATA_DATE_OF_BIRTH);

    }

    @Override
    public String getEmail(){
        log.info("");
        isVisible(USER_DETAILS_DATA, true);
        return getText(USER_DATA_EMAIL).replace(", email: ", "");
    }

    @Override
    public String getAlert(){
        log.info("");
        isVisible(GET_ALERT_TEXT, true);
        return getText(GET_ALERT_TEXT);
    }

}
