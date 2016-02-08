package com.r2development.leveris.selenium.apollo.pageobjects;

import java.util.Map;

public interface IRecordPage {
    ILoginPage clickLogOutButton();
    String getVersion();
    Map<String, String> clickClientOverviewMenu();
    void clickClientOverviewItemMenu();
    void clickPaymentItemMenu();

    boolean checkContactData();
    boolean checkUpdatedContactData();
    IEditContactPage editContactData();
}
