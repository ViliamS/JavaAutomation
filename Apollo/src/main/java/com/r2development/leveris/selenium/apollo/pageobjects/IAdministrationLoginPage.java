package com.r2development.leveris.selenium.apollo.pageobjects;

import static com.r2development.leveris.utils.XPathBuilder.*;

public interface IAdministrationLoginPage {

    String USERNAME_INPUT = equalsTo(input, name, "username");//"//input[@name='username']";
    String PASSWORD_INPUT = equalsTo(input, name, "password") ;//"//input[@name='password']";
    String LOGIN_BUTTON = equalsTo(button, type, "submit") + equalsTo(singleSlash, span, text, "Login");//"//button[@type='submit']/span[text()='Login']";

    IAdministrationLoginPage setUsername(String username);
    IAdministrationLoginPage setPassword(String password);
    IAdministrationHomePage clickLogin();
}
