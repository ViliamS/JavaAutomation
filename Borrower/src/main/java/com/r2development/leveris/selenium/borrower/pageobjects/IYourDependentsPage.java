package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourDependentsPage {

    String getTitle();
    String getDescription();

    IYourDependentsPage clickSingleYes();
    IYourDependentsPage clickSingleNo();
    IYourDependentsPage clickCoupleYes();
    IYourDependentsPage clickCoupleNo();

    IYourDependentsPage checkAccountAppliesToBorrower(String borrower);
    IYourDependentsPage checkAccountAppliesToCoapplicant(String coapplicant);

    IYourDependentsPage typeDateOfBirth(String dateOfBirth);

    IYourDependentsPage clickAddThisDependent();
    IYourDependentsPage clickCancel();
    IYourDependentsPage clickAddDependent();
    IYourDependentsPage clickNext();
    IYourDependentsPage clickEditThisDependent(int index);

    String getDependentAge(int index);
    String getBorrowerName(int index) ;
    IYourDependentsPage deleteDependent(int index);
    IYourDependentsPage clickDependentPanel(int index);

}
