package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;
import com.r2development.leveris.utils.XpathBuilder.XPath;

public interface IAdministrationLoginPage {

    String USERNAME_INPUT = XPath.getXPath(ELEMENTS.INPUT, ACTIONS.EQUALS, ATTRIBUTES.NAME, "username");//equalsTo(input, name, "username");//"//input[@name='username']";
    String PASSWORD_INPUT = XPath.getXPath(ELEMENTS.INPUT, ACTIONS.EQUALS, ATTRIBUTES.NAME, "password");//equalsTo(input, name, "password") ;//"//input[@name='password']";
    String LOGIN_BUTTON =   XPath.getXPath(ELEMENTS.BUTTON, ACTIONS.EQUALS, ATTRIBUTES.TYPE, "submit") + XPath.getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Login") + "/../../button";//equalsTo(button, type, "submit") + equalsTo(singleSlash, span, text, "Login") + "/../../button";//"//button[@type='submit']/span[text()='Login']";

    IAdministrationLoginPage setUsername(String username);
    IAdministrationLoginPage setPassword(String password);
    IAdministrationTopBanner clickLogin();
    IAdministrationLoginPage goToApolloAdministrationLoginPage();

    boolean isUsernameInputPresent();
}
