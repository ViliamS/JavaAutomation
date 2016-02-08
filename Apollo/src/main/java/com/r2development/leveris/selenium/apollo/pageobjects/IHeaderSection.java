package com.r2development.leveris.selenium.apollo.pageobjects;

import java.util.Map;

public interface IHeaderSection {
    String VERSION_XPATH = "//a[@href='#/search']/img[@src='assets/logo.png' and @alt='Abakus']";
    String CLIENT_OVERVIEW_MENU_XPATH = "//button[contains(@class, 'btn-link') and @type='button']";
    String LOG_OUT_PATH = "//a[contains(., 'Log Out')]";

    //    IHeaderSection waitForHeaderSectionToLoad();
    ILoginPage clickLogOutButton();
    String getVersion();
    Map<String, String> clickClientOverviewMenu();
    void clickClientOverviewItemMenu();
    void clickPaymentItemMenu();
}
