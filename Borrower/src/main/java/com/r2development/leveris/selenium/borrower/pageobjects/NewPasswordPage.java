package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class NewPasswordPage extends Borrower implements INewPasswordPage {

    private static final Log log = LogFactory.getLog(NewPasswordPage.class);

    public NewPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }
}
