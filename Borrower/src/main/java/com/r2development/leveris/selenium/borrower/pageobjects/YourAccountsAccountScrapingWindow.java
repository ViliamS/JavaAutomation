package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Set;


public class YourAccountsAccountScrapingWindow extends Borrower implements IYourAccountsAccountScrapingWindow {

    private static final Log log = LogFactory.getLog(YourAccountsAccountScrapingWindow.class.getName());

    public YourAccountsAccountScrapingWindow(SharedDriver_Borrower webDriver) {
        super(webDriver);
    }

    @Override
    public IYourAccountsSection closeAccountScraping() throws InterruptedException {
        log.info("");
        Thread.sleep(10000); // Wait for page to load
        String keepWindow = webDriver.getWindowHandle();
        Set<String> toClose = webDriver.getWindowHandles();
        for(String entryToClose : toClose) {
            if (!entryToClose.equals(keepWindow)) {
                log.info("\n SwitchingTo window ---> '" + entryToClose + "'\n");
                webDriver.switchTo().window(entryToClose);
                log.info("\n Closing window ---> '" + entryToClose + "'\n");
                webDriver.close();
            }
        }
        log.info("\n SwitchingTo window ---> '" + keepWindow + "'\n");
        webDriver.switchTo().window(keepWindow);

        while (isVisible(SCRAPING_IN_PROGRESS)) {
            Thread.sleep(500);
        }

        return new YourAccountsSection(webDriver);
    }

    @Override
    public IYourAccountsAccountScrapingWindow clickOnBankOfAmericaLink() {
        log.info("clickOnBankOfAmericaLink()");
        isVisible(BANK_OF_AMERICA_LINK, true, 5);
        clickElement(BANK_OF_AMERICA_LINK, LOGIN_INPUT);
        return this;
    }

    @Override
    public IYourAccountsAccountScrapingWindow setLogin(String login) {
        log.info("setLogin(String login)\n" +
                "login ---> '" + login + "'");
        isVisible(LOGIN_INPUT, true);
        type(LOGIN_INPUT, login);
        return this;
    }

    @Override
    public IYourAccountsAccountScrapingWindow setPassword(String password) {
        log.info("setPassword(String password)\n" +
                "password ---> '" + password + "'");
        isVisible(LOGIN_PASSWORD, true);
        type(LOGIN_PASSWORD, password);
        return this;
    }

    @Override
    public IYourAccountsAccountScrapingWindow setPasswordReEnter(String password) {
        log.info("setPasswordReEnter(String password)\n" +
                "password ---> '" + password + "'");
        isVisible(LOGIN_PASSWORD_RE_ENTER, true);
        type(LOGIN_PASSWORD_RE_ENTER, password);
        return this;
    }

    @Override
    public IYourAccountsAccountScrapingWindow clickNext() {
        log.info("clickNext()");
        isVisible(NEXT_BUTTON, true);
        clickElement(NEXT_BUTTON);
        return this;
    }

    @Override
    public IYourAccountsSection clickCloseButton() {
        log.info("clickCloseButton()");
        isVisible(CLOSE_BUTTON, true);
        clickElement(CLOSE_BUTTON);
        return new YourAccountsSection(webDriver);
    }

}
