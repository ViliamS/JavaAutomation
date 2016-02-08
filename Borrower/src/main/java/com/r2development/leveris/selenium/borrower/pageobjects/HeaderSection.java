package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderSection extends Borrower implements IHeaderSection {

    private static final Log log = LogFactory.getLog(HeaderSection.class);

    @FindBy( xpath = LOGO_LINK_XPATH )
    protected WebElement webLogo;

    @FindBy( xpath = NOTIFICATION_MESSAGE_LINK_XPATH )
    protected WebElement webNotificationMessage;

    @FindBy( xpath = YOUR_ACCOUNT_LINK_XPATH )
    protected WebElement weYourAccount;

    @FindBy( xpath = SIGNOUT_LINK_XPATH )
    protected WebElement weSignOut;

    @FindBy( xpath = CLOSE_CHAT_XPATH )
    protected WebElement weCloseChat;

    public HeaderSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public IBorrowerHomePage clickLogo() {
        isVisible(LOGO_LINK_XPATH, true);
        webLogo.click();
        return new BorrowerHomePage(webDriver);
    }

    @Override
    public INotificationMessagePage clickNotificationMessages() {
        isVisible(NOTIFICATION_MESSAGE_LINK_XPATH, true);
        webNotificationMessage.click();
        return new NotificationMessagePage(webDriver);
    }

    @Override
    public IBorrowerHomePage clickYourAccount() {
        isVisible(YOUR_ACCOUNT_LINK_XPATH, true);
        moveTo(YOUR_ACCOUNT_LINK_XPATH);
        weYourAccount.click();
        return new BorrowerHomePage(webDriver);
    }

    @Override
    public void moveToYourAccount()
    {
        isVisible(YOUR_ACCOUNT_LINK_XPATH, true);
        moveTo(YOUR_ACCOUNT_LINK_XPATH);
    }

    @Override
    public IWelcomePage clickSignOut() throws Exception{
        isVisible(SIGNOUT_LINK_XPATH, true);
        weSignOut.click();
        return new WelcomePage(webDriver);
    }

    @Override
    public void closeChat() {
        // BUG
    }

    @Override
    public boolean isLoaded() {
//        isVisible(LOGO_LINK_XPATH, true);
        isVisible(NOTIFICATION_MESSAGE_LINK_XPATH, true);
        isVisible(YOUR_ACCOUNT_LINK_XPATH, true);
//        isVisible(SIGNOUT_LINK_XPATH, true);
//        isVisible(CLOSE_CHAT_XPATH, true);
        return true;
    }
}
