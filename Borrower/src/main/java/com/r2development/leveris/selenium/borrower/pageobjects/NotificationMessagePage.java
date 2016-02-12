package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class NotificationMessagePage extends Borrower implements INotificationMessagePage {

    private static final Log log = LogFactory.getLog(NotificationMessagePage.class);

    @Inject
    public NotificationMessagePage(WebDriver webDriver) {
        super(webDriver);
    }
}
