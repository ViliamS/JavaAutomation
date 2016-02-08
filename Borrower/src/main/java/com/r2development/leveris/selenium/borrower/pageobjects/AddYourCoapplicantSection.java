package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddYourCoapplicantSection extends Borrower implements IAddYourCoapplicantSection {

    private static final Log log = LogFactory.getLog(AddYourCoapplicantSection.class);

    @FindBy( xpath = TITLE_XPATH )
    protected WebElement weTitle;

    @FindBy ( xpath = DESCRIPTION_XPATH )
    protected WebElement weDescription;

    @FindBy ( xpath = FIRSTNAME_XPATH )
    protected WebElement weFirstName;

    @FindBy ( xpath = EMAIL_XPATH )
    protected WebElement weEmail;

    @FindBy ( xpath = INVITE_NOW_XPATH )
    protected WebElement weInviteNow;

    @FindBy ( xpath = BACK_TO_DASHBOARD_XPATH )
    protected WebElement weBackToDashboard;

    public AddYourCoapplicantSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public IAddYourCoapplicantSection setFirstName(String firstName) {
        isVisible(FIRSTNAME_XPATH);
        weFirstName.clear();
        weFirstName.sendKeys(firstName);
        return this;
    }

    @Override
    public IAddYourCoapplicantSection setEmail(String email) {
        isVisible(EMAIL_XPATH);
        weEmail.clear();
        weEmail.sendKeys(email);
        return this;
    }

    @Override
    public IAddYourCoapplicantSection clickInviteNow() {
        isVisible(INVITE_NOW_XPATH);
        weInviteNow.click();
        return this;
    }

    @Override
    public IBorrowerHomePage clickBackToDashboard() {
        isVisible(BACK_TO_DASHBOARD_XPATH);
        weBackToDashboard.click();
        return new BorrowerHomePage(webDriver);
    }
}
