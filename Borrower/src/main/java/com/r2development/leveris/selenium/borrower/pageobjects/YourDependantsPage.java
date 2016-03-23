package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class YourDependantsPage extends HeaderAndBottomAndFormsMenuSection implements IYourDependantsPage {

    private static final Log log = LogFactory.getLog(YourDependantsPage.class);

    protected IYourDependantsSection yourDependantsSection;

//    @Inject
    public YourDependantsPage(SharedDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        yourDependantsSection = new YourDependantsSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public String getTitle() {
        return yourDependantsSection.getTitle();
    }

    @Override
    public String getDescription() {
        return yourDependantsSection.getDescription();
    }

    @Override
    public IYourDependantsPage clickDone() {
        yourDependantsSection.clickDone();
        return this;
    }

    @Override
    public IYourDependantsPage clickNone() {
        yourDependantsSection.clickNone();
        return this;
    }

    @Override
    public IYourDependantsPage clickNext() {
        yourDependantsSection.clickNext();
        return this;
    }

    @Override
    public IYourDependantsPage clickWaitWeHaveDependants() {
        return this;
    }

    @Override
    public IYourDependantsPage typeDateOfBirth(String dateOfBirth) {
        yourDependantsSection.typeDateOfBirth(dateOfBirth);
        return this;
    }

    @Override
    public IYourDependantsPage clickAddThisDependant() {
        yourDependantsSection.clickAddThisDependant();
        return this;
    }

    @Override
    public IYourDependantsPage clickSaveAndClose() {
        yourDependantsSection.clickSaveAndClose();
        return this;
    }

    @Override
    public IYourDependantsPage clickCancel() {
        yourDependantsSection.clickCancel();
        return this;
    }

    @Override
    public IYourDependantsPage clickAddDependant() {
            yourDependantsSection.clickAddDependant();
//            log.info("\n ---------------------------------------------------------------------- \n" +
//                     " | Exception raised due to failed clicking to get to add dependant page | \n" +
//                     " ----------------------------------------------------------------------- \n");
        return this;
    }

    @Override
    public String getDependantAge(int index) {
        return null;
    }

    @Override
    public IYourDependantsPage editDependant(int index) {
        return null;
    }

    @Override
    public IYourDependantsPage deleteDependant(int index) {
        yourDependantsSection.deleteDependant(index);
        return this;
    }
}