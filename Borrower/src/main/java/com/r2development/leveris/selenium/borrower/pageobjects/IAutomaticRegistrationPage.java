package com.r2development.leveris.selenium.borrower.pageobjects;

import java.io.FileNotFoundException;

public interface IAutomaticRegistrationPage {

    void typeApplicantId(String applicantId);
    void checkQuoteComplete();
    void uncheckQuoteComplete();
    boolean isCheckedQuoteComplete();

    void checkInviteCoapplicant();
    void uncheckInviteCoapplicant();
    boolean isCheckedInviteCoapplicant();
    boolean isEnableInviteCoapplicant();

    void typeCoapplicantId(String coapplicantId);

    // TODO ... to check in which page we move to.
    IAutomaticRegistrationPage clickCreateNewUser(String userName);
    IAutomaticRegistrationPage goToAutomaticRegistrationPage() throws FileNotFoundException;

}
