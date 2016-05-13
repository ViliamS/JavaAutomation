package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class SessionListPage extends SideMenu implements ISessionListPage {

    private static final Log log = LogFactory.getLog(SessionListPage.class.getName());

    private WebDriver webDriver;

    public SessionListPage(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }
}