package com.r2development.leveris.selenium.apollo.pageobjects;

public interface ILoginPage {

    String USERNAME_XPATH = "//input[@id='username']";
    String PASSWORD_XPATH = "//input[@id='pwd']";

    // TODO to set apollo properties
    String USERNAME_ACTIVE = "harry.potter@abakus.com";
    String PASSWORD_ACTIVE = "heslo";
    String SUBMIT_XPATH = "//button[contains(@class,'btn-primary') and text()='Submit']";

    ISearchPage clickSubmit();
    ILoginPage setUsername(@SuppressWarnings("SameParameterValue") String username);
    ILoginPage setPassword(@SuppressWarnings("SameParameterValue") String password);
}
