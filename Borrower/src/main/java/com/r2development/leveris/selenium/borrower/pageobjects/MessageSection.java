package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageSection extends Borrower implements IMessageSection {

    private static final Log log = LogFactory.getLog(MessageSection.class.getName());

    @FindBy( xpath = MESSAGE_SECTION_XPATH )
    protected WebElement weMessageSection;

    @FindBy( xpath = GET_ONE_NOW_XPATH )
    protected WebElement weGetOneNow;

//    @Inject
    MessageSection(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public void clickGetOneNow() {
        loadingCheck();
        isVisible(GET_ONE_NOW_XPATH, true, 1);
        clickElement(GET_ONE_NOW_XPATH);
        loadingCheck();
//        weGetOneNow.click();
    }

    @Override
    public String getMessage() {
        loadingCheck();
        isVisible(MESSAGE_CONTAINER_XPATH);
        return getText(MESSAGE_TEXT_XPATH); // potential bug !
    }
}
