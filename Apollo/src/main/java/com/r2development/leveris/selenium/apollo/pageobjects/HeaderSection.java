package com.r2development.leveris.selenium.apollo.pageobjects;


import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver_Apollo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

class HeaderSection extends Apollo implements IHeaderSection {

    private static final Log log = LogFactory.getLog(ContactSection.class);

    private SharedDriver_Apollo webDriver;

    @FindBy( xpath =  VERSION_XPATH )
    private WebElement weVersion;

    @FindBy( xpath = CLIENT_OVERVIEW_MENU_XPATH)
    private WebElement weClientOverviewMenu;

    @FindBy( xpath = LOG_OUT_PATH )
    private WebElement weLogOut;

    public static IHeaderSection getHeaderSectionInstance(SharedDriver_Apollo webDriver) {
        IHeaderSection headerSection = new HeaderSection(webDriver);
        PageFactory.initElements(webDriver, headerSection);
        return headerSection;
    }

    HeaderSection(SharedDriver_Apollo webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public String getVersion() {
        isVisible(VERSION_XPATH);
        return weVersion.getAttribute("title").intern();
    }

    @Override
    public Map<String, String> clickClientOverviewMenu() {
        return new HashMap<>();
    }

    @Override
    public void clickClientOverviewItemMenu() {
        // TODO to implement
    }

    @Override
    public void clickPaymentItemMenu() {
        // TODO to implement
    }

    @Override
    public LoginPage clickLogOutButton() {
        isInvisible(LOG_OUT_PATH);
        weLogOut.click();
        return new LoginPage(webDriver);
    }

//    @Override
//    public IHeaderSection waitForHeaderSectionToLoad() {
//        isVisible(VERSION_XPATH);
//        isVisible(CLIENT_OVERVIEW_MENU_XPATH);
//        isVisible(LOG_OUT_PATH);
//        return this;
//    }
}

