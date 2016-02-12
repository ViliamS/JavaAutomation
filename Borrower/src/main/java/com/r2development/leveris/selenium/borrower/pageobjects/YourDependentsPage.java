package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class YourDependentsPage extends HeaderAndBottomAndFormsMenuSection implements IYourDependentsPage {

    private static final Log log = LogFactory.getLog(YourDependentsPage.class);

    protected IYourDependentsSection yourDependentsSection;

    @Inject
    public YourDependentsPage(WebDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        yourDependentsSection = new YourDependentsSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public String getTitle() {
        return yourDependentsSection.getTitle();
    }

    @Override
    public String getDescription() {
        return yourDependentsSection.getDescription();
    }

    @Override
    public IYourDependentsPage clickSingleYes() {
        yourDependentsSection.clickSingleYes();
        return this;
    }

    @Override
    public IYourDependentsPage clickSingleNo() {
        yourDependentsSection.clickSingleNo();
        return this;
    }

    @Override
    public IYourDependentsPage clickCoupleYes() {
        yourDependentsSection.clickCoupleYes();
        return this;
    }

    @Override
    public IYourDependentsPage clickCoupleNo() {
        yourDependentsSection.clickCoupleNo();
        return this;
    }

    @Override
    public IYourDependentsPage checkAccountAppliesToBorrower(String borrower) {
        yourDependentsSection.checkAccountAppliesToBorrower(borrower);
        return this;
    }

    @Override
    public IYourDependentsPage checkAccountAppliesToCoapplicant(String coapplicant) {
        yourDependentsSection.checkAccountAppliesToCoapplicant(coapplicant);
        return this;
    }

    @Override
    public IYourDependentsPage typeDateOfBirth(String dateOfBirth) {
        yourDependentsSection.typeDateOfBirth(dateOfBirth);
        return this;
    }

    @Override
    public IYourDependentsPage clickAddThisDependent() {
        yourDependentsSection.clickAddThisDependent();
        return this;
    }

    @Override
    public IYourDependentsPage clickCancel() {
        yourDependentsSection.clickCancel();
        return this;
    }

    @Override
    public IYourDependentsPage clickAddDependent() {
        yourDependentsSection.clickAddDependent();
        return this;
    }

    @Override
    public IYourDependentsPage clickNext() {
        yourDependentsSection.clickNext();
        return this;
    }

    @Override
    public IYourDependentsPage clickEditThisDependent(int index) {
        yourDependentsSection.clickEditThisDependent(index);
        return this;
    }

    @Override
    public String getDependentAge(int index) {
        return null;
    }

    @Override
    public String getBorrowerName(int index) {
        return null;
    }

    @Override
    public IYourDependentsPage deleteDependent(int index) {
        yourDependentsSection.deleteDependent(index);
        return this;
    }

    @Override
    public IYourDependentsPage clickDependentPanel(int index) {
        yourDependentsSection.clickDependentPanel(index);
        return this;
    }
}
