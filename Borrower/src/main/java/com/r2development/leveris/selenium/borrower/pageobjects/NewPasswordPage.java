package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NewPasswordPage extends Borrower implements INewPasswordPage {

    private static final Log log = LogFactory.getLog(NewPasswordPage.class);

//    @Inject
    public NewPasswordPage(SharedDriver webDriver) {
        super(webDriver);
    }
}