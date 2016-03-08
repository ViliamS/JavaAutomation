package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class YourDependentsPage extends HeaderAndBottomAndFormsMenuSection implements IYourDependentsPage {

    private static final Log log = LogFactory.getLog(YourDependentsPage.class);

    protected IYourDependentsSection yourDependentsSection;

//    @Inject
    public YourDependentsPage(SharedDriver webDriver) {
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
    public IYourDependentsPage clickDone() {
        yourDependentsSection.clickDone();
        return this;
    }

    @Override
    public IYourDependentsPage clickNone() {
        yourDependentsSection.clickNone();
        return this;
    }

    @Override
    public IYourDependentsPage clickNext() {
        yourDependentsSection.clickNext();
        return this;
    }

    @Override
    public IYourDependentsPage clickWaitWeHaveDependents() {
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
    public IYourDependentsPage clickSaveAndClose() {
        yourDependentsSection.clickSaveAndClose();
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
    public String getDependentAge(int index) {
        return null;
    }

    @Override
    public IYourDependentsPage editDependent(int index) {
        return null;
    }

    @Override
    public IYourDependentsPage deleteDependent(int index) {
        yourDependentsSection.deleteDependent(index);
        return this;
    }


}
