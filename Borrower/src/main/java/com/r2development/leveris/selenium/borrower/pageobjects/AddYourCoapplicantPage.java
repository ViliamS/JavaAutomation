package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;


public class AddYourCoapplicantPage extends HeaderAndBottomAndFormsMenuSection implements IAddYourCoapplicantPage, IHeaderSection , IBottomSection {

    private static final Log log = LogFactory.getLog(AddYourCoapplicantPage.class);

    protected IHeaderSection headerSection;
    protected IAddYourCoapplicantSection addYourCoapplicantSection;
    protected IBottomSection bottomSection;

    @Inject
    public AddYourCoapplicantPage(WebDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        addYourCoapplicantSection = new AddYourCoapplicantSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public IAddYourCoapplicantPage fillInAddYourCoapplicantPage(String firstName, String email) {
        this.setFirstName(firstName);
        this.setEmail(email);
        return this;
    }

    @Override
    public IAddYourCoapplicantPage setFirstName(String firstName) {
        addYourCoapplicantSection.setFirstName(firstName);
        return this;
    }

    @Override
    public IAddYourCoapplicantPage setEmail(String email) {
        addYourCoapplicantSection.setEmail(email);
        return this;
    }

    @Override
    public IAddYourCoapplicantPage clickInviteNow() {
        addYourCoapplicantSection.clickInviteNow();
        return this;
    }

    @Override
    public IBorrowerHomePage clickBackToDashboard() {
        return addYourCoapplicantSection.clickBackToDashboard();
    }
}
