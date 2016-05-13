package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends SideMenu implements IProfilePage {

    private static final Log log = LogFactory.getLog(ProfilePage.class.getName());

    private WebDriver webDriver;

    public ProfilePage(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public boolean isProfilePageTitlePresent() {
        return isVisible(PROFILE_AND_SETTINGS_TITLE, 5);
    }

    @Override
    public ILoginPage clickLogout() {
        isVisible(LOGOUT_LINK_TITLE, 0);
        clickElement(LOGOUT_LINK, ILoginPage.LOGIN_BUTTON);
        return new LoginPage(webDriver);
    }

}