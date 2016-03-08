package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourDependentsPage {

    String getTitle();
    String getDescription();

    IYourDependentsPage clickNone();
    IYourDependentsPage clickNext();
    IYourDependentsPage clickWaitWeHaveDependents();

    IYourDependentsPage typeDateOfBirth(String dateOfBirth);

    IYourDependentsPage clickAddThisDependent();
    IYourDependentsPage clickSaveAndClose();
    IYourDependentsPage clickAddDependent();
    IYourDependentsPage clickCancel();
    IYourDependentsPage clickDone();

    String getDependentAge(int index);
    IYourDependentsPage editDependent(int index);
    IYourDependentsPage deleteDependent(int index);

}
