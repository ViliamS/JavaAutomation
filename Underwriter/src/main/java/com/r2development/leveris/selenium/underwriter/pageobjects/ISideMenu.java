package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.getXPath;

public interface ISideMenu {

    String LOGO = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "menuWrapper") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "logo-item");
    String APPLICATION = getXPath(ELEMENTS.A, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Application");
    String PROFILE = getXPath(ELEMENTS.A, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Profile");
    String NOTIFICATIONS = getXPath(ELEMENTS.A, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Notifications");
    String MESSAGES = getXPath(ELEMENTS.A, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Messages");

    IProfilePage clickProfile();

    IApplicationListPage clickApplication();

    void clickNotifications();

    void clickMessages();
}