package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.selenium.borrower.pageobjects.IBorrowerHomePage;
import com.r2development.leveris.selenium.borrower.pageobjects.INotificationMessagePage;
import com.r2development.leveris.selenium.borrower.pageobjects.IWelcomePage;

public interface IHeaderSection {
    String LOGO_LINK_XPATH = "//a[contains(@wicketpath, 'logo')]";
    String NOTIFICATION_MESSAGE_LINK_XPATH = "//a[@class='link' and @href='form/mi/notifications' and @title='Messages' and contains(., 'Messages')]";
    String YOUR_ACCOUNT_LINK_XPATH = "//a[@class='link' and @href='form/mi/account' and @title='Your Account' and contains(., 'Your Account')]";
    String SIGNOUT_LINK_XPATH = "//a[@class='link' and @href='form/mi/signout' and @title='Sign Out' and contains(., 'Sign out')]";
    String CLOSE_CHAT_XPATH = "//div[contains(@wicketpath, 'menu_support')]//a[contains(., 'X')]";

    IBorrowerHomePage clickLogo();
    INotificationMessagePage clickNotificationMessages();
    IBorrowerHomePage clickYourAccount();
    void moveToYourAccount();
    IWelcomePage clickSignOut() throws Exception;
    void closeChat();
    boolean isLoaded();
}
