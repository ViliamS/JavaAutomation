package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NotificationMessagePage extends Borrower implements INotificationMessagePage {

    private static final Log log = LogFactory.getLog(NotificationMessagePage.class);

//    @Inject
    public NotificationMessagePage(SharedDriver_Borrower webDriver) {
        super(webDriver);
    }
}