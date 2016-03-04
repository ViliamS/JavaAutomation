package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AutomaticRegistrationPage extends Borrower implements IHeaderSection, IAutomaticRegistrationPage {

    private static final Log log = LogFactory.getLog(AutomaticRegistrationPage.class);

    protected  IHeaderSection headerSection;
    protected IAutomaticRegistrationSection automaticRegistrationSection;

//    @Inject
    public AutomaticRegistrationPage(SharedDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        automaticRegistrationSection = new AutomaticRegistrationSection(webDriver);
    }

    @Override
    public void typeApplicantId(String applicantId) {
        automaticRegistrationSection.typeApplicantId(applicantId);
    }

    @Override
    public void checkQuoteComplete() {
        automaticRegistrationSection.checkQuoteComplete();
    }

    @Override
    public void uncheckQuoteComplete() {
        automaticRegistrationSection.uncheckQuoteComplete();
    }

    @Override
    public boolean isCheckedQuoteComplete() {
        return automaticRegistrationSection.isCheckedQuoteComplete();
    }

    @Override
    public void checkInviteCoapplicant() {
        automaticRegistrationSection.checkInviteCoapplicant();
    }

    @Override
    public void uncheckInviteCoapplicant() {
        automaticRegistrationSection.uncheckInviteCoapplicant();
    }

    @Override
    public boolean isCheckedInviteCoapplicant() {
        return automaticRegistrationSection.isCheckedInviteCoapplicant();
    }

    @Override
    public boolean isEnableInviteCoapplicant() {
        return automaticRegistrationSection.isEnableInviteCoapplicant();
    }

    @Override
    public void typeCoapplicantId(String coapplicantId) {
        automaticRegistrationSection.typeCoapplicantId(coapplicantId);
    }

    @Override
    // TODO to check which page we move to
    public void clickCreateNewUser() {
        automaticRegistrationSection.clickCreateNewUser();
    }

    @Override
    public IBorrowerHomePage clickLogo() {
        return null;
    }

    @Override
    public INotificationMessagePage clickNotificationMessages() {
        return null;
    }

    @Override
    public IBorrowerHomePage clickYourAccount() {
        return null;
    }

    @Override
    public void moveToYourAccount() {

    }

    @Override
    public IWelcomePage clickSignOut() throws Exception {
        return null;
    }

    @Override
    public void closeChat() {

    }

    @Override
    public boolean isLoaded() {
        return false;
    }
}
