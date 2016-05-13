package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;
import com.r2development.leveris.utils.XpathBuilder.XPath;
import com.r2development.leveris.utils.XpathBuilder.XPathValues;
import com.r2development.leveris.utils.XpathBuilder.version2.XPTableActionsAttributesValues;

import java.util.LinkedList;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IYourAccountsAccountScrapingWindow {

    String BANK_OF_AMERICA_LINK =       getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.ARIA_LABEL, "Popular Site Bank of America");
    String CLOSE_BUTTON =               getXPath(ELEMENTS.I, ACTIONS.EQUALS, ATTRIBUTES.DATA_YTRACK, "APPLICATION_CLOSE_ICON_LANDING");

    String LOGIN_INPUT =                getXPath(ELEMENTS.INPUT, ACTIONS.EQUALS, ATTRIBUTES.NAME, "LOGIN");
    String LOGIN_PASSWORD =             getXPath(ELEMENTS.INPUT, ACTIONS.EQUALS, ATTRIBUTES.NAME, "PASSWORD");
    String LOGIN_PASSWORD_RE_ENTER =    getXPath(ELEMENTS.INPUT, ACTIONS.EQUALS, ATTRIBUTES.NAME, "Re-enter_PASSWORD");
    String NEXT_BUTTON =                getXPath(ELEMENTS.INPUT, ACTIONS.EQUALS, ATTRIBUTES.ID, "next");

    String I_AGREE_CHECKBOX =           getXPath_DivEqualsDataPath("pnlBasicInfo chkConditions") + getXPath(PREFIX.DOUBLE_SLASH, ELEMENTS.A);
    String START_SCRAPING_BUTTON =      getXPath_DivEqualsDataPath("pnlBasicInfo pnlYodleeIframe") + getXPath(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlYodleeIframe") +
                                        getXPath_HasADescendantSpanEqualsText("Start Scraping") + getXPath(ELEMENTS.A, ACTIONS.AND_CONTAINS, ATTRIBUTES.CLASS, new XPathValues(new LinkedList<String>() {{
                                                                                                                                                                                                    add("start");
                                                                                                                                                                                                    add("apply");
                                                                                                                                                                                                    add("content");
                                                                                                                                                                                                    add("control");
                                                                                                                                                                                                    add("submit");
                                                                                                                                                                                                }}));

    String SCRAPING_IN_PROGRESS =       getXPath_DivEqualsDataPath("pnlBasicInfo pnlYodleeProcess") + XPath.getXPath(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.DATA_PATH, "pnlBasicInfo pnlYodleeProcess med-") + XPTableActionsAttributesValues.getXPathFromTable(ACTIONS.AND_CONTAINS, ATTRIBUTES.CLASS, new XPathValues("widget-enabled", "scraping-download", "widget-media"));


    IYourAccountsAccountScrapingWindow clickOnBankOfAmericaLink();

    IYourAccountsSection closeAccountScraping() throws InterruptedException;

    IYourAccountsAccountScrapingWindow setLogin(String login);

    IYourAccountsAccountScrapingWindow setPassword(String password);

    IYourAccountsAccountScrapingWindow setPasswordReEnter(String password);

    IYourAccountsAccountScrapingWindow clickNext();

    IYourAccountsSection clickCloseButton();

}
