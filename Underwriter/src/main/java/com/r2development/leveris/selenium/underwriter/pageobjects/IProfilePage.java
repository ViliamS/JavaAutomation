package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;
import com.r2development.leveris.utils.XpathBuilder.XPath;

import static com.r2development.leveris.utils.XpathBuilder.XPath.getXPath;

public interface IProfilePage {

    String PROFILE_AND_SETTINGS_TITLE = getXPath(ELEMENTS.H2, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "widget-form-title") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.TEXT, "PROFILE & SETTINGS");
    String LOGOUT_LINK = XPath.getXPath_DivEqualsDataPath("pnlMain lnkLogout") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "lnkLogout_cancel");
    String LOGOUT_LINK_TITLE = LOGOUT_LINK + getXPath(ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Logout");

    boolean isProfilePageTitlePresent();

    ILoginPage clickLogout();
}