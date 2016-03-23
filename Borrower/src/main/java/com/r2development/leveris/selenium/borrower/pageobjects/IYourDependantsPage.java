package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourDependantsPage {

    String getTitle();
    String getDescription();

    IYourDependantsPage clickNone();
    IYourDependantsPage clickNext();
    IYourDependantsPage clickWaitWeHaveDependants();

    IYourDependantsPage typeDateOfBirth(String dateOfBirth);

    IYourDependantsPage clickAddThisDependant();
    IYourDependantsPage clickSaveAndClose();
    IYourDependantsPage clickAddDependant();
    IYourDependantsPage clickCancel();
    IYourDependantsPage clickDone();

    String getDependantAge(int index);
    IYourDependantsPage editDependant(int index);
    IYourDependantsPage deleteDependant(int index);
}