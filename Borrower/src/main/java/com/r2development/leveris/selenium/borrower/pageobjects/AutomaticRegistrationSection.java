package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomaticRegistrationSection extends Borrower implements IAutomaticRegistrationSection {

    private static final Log log = LogFactory.getLog(AutomaticRegistrationSection.class);

    @FindBy( xpath = TITLE_XPATH )
    protected WebElement weTitle;

    @FindBy( xpath = INPUT_APPLICANT_XPATH )
    protected WebElement weApplicant;

    @FindBy( xpath = CHECKBOX_QUOTE_COMPLETE_XPATH )
    protected  WebElement weQuoteComplete;

    @FindBy( xpath = CHECKBOX_INVITE_COAPPLICANT_XPATH )
    protected WebElement weInviteCoapplicant;

    @FindBy( xpath = INPUT_COAPPLICANT_XPATH )
    protected WebElement weCoApplicant;

    @FindBy( xpath = LINK_CREATE_NEW_USER_XPATH )
    protected WebElement CreateNewUser;

    @Inject
    public AutomaticRegistrationSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    @Override
    public void typeApplicantId(String applicantId) {
        isVisible(TITLE_XPATH, 5);
        type(TITLE_XPATH, applicantId);
    }

    @Override
    public void checkQuoteComplete() {
        isVisible(CHECKBOX_QUOTE_COMPLETE_XPATH, 5);
        clickElement(CHECKBOX_QUOTE_COMPLETE_XPATH);
    }

    @Override
    public void uncheckQuoteComplete() {
        if ( weQuoteComplete.isSelected() )
            weQuoteComplete.click();
    }

    @Override
    public boolean isCheckedQuoteComplete() {
        return weQuoteComplete.isSelected();
    }

    @Override
    public void checkInviteCoapplicant() {
        isVisible(CHECKBOX_INVITE_COAPPLICANT_XPATH, 5);
        clickElement(CHECKBOX_INVITE_COAPPLICANT_XPATH);
    }

    @Override
    public void uncheckInviteCoapplicant() {
        if ( weInviteCoapplicant.isSelected() )
            weQuoteComplete.isSelected();
    }

    @Override
    public boolean isCheckedInviteCoapplicant() {
        return weInviteCoapplicant.isSelected();
    }

    @Override
    public boolean isEnableInviteCoapplicant() {
        return weInviteCoapplicant.isEnabled();
    }

    @Override
    public void typeCoapplicantId(String coapplicantId) {
        isVisible(INPUT_COAPPLICANT_XPATH, 5);
        type(INPUT_COAPPLICANT_XPATH, coapplicantId);
    }

    @Override
    public void clickCreateNewUser() {
        isVisible(LINK_CREATE_NEW_USER_XPATH, 5);
        clickElement(LINK_CREATE_NEW_USER_XPATH);
    }
}
