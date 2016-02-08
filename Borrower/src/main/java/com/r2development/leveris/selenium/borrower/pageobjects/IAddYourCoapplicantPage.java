package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IAddYourCoapplicantPage {

    IAddYourCoapplicantPage fillInAddYourCoapplicantPage(String firstName, String email);
    IAddYourCoapplicantPage setFirstName(String firstName);
    IAddYourCoapplicantPage setEmail(String email);
    IAddYourCoapplicantPage clickInviteNow();
    IBorrowerHomePage clickBackToDashboard();
}
