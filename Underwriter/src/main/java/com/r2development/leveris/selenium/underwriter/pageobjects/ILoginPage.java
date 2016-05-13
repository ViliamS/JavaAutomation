package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;

import static com.r2development.leveris.utils.XpathBuilder.XPath.getXPath;
import static com.r2development.leveris.utils.XpathBuilder.XPath.getXPath_DirectSpanEqualsText;

public interface ILoginPage {

    String USERNAME_INPUT = getXPath(ELEMENTS.INPUT, ACTIONS.EQUALS, ATTRIBUTES.NAME, "username");
    String PASSWORD_INPUT = getXPath(ELEMENTS.INPUT, ACTIONS.EQUALS, ATTRIBUTES.NAME, "password");
    String LOGIN_BUTTON = getXPath(ELEMENTS.BUTTON, ACTIONS.EQUALS, ATTRIBUTES.TYPE, "submit") + getXPath_DirectSpanEqualsText("Login");

    ILoginPage setUsername(String username);

    ILoginPage setPassword(String password);

    ISideMenu clickLogin();

    ILoginPage goToUnderwriterLoginPage();

    boolean isUsernameInputPresent();
}