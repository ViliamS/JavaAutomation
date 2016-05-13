package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.di.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomaticRegistrationSection extends Borrower implements IAutomaticRegistrationSection {

    private static final Log log = LogFactory.getLog(AutomaticRegistrationSection.class);

    @Inject
    IUser user;

    @FindBy( xpath = OPOQO_APPLICANT_READ_ONLY_INPUT_XPATH )
    protected WebElement readOnlyApplicantInput;

    @FindBy( xpath = OPOQO_PASSWORD_READ_ONLY_INPUT_XPATH )
    protected WebElement readOnlyPasswordInput;

    @FindBy( xpath = TITLE_XPATH )
    protected WebElement weTitle;

    @FindBy( xpath = INPUT_APPLICANT_XPATH )
    protected WebElement weApplicant;

    @FindBy( xpath = CHECKBOX_QUOTE_COMPLETE_XPATH )
    protected WebElement weQuoteComplete;

    @FindBy( xpath = CHECKBOX_INVITE_COAPPLICANT_XPATH )
    protected WebElement weInviteCoapplicant;

    @FindBy( xpath = INPUT_COAPPLICANT_XPATH )
    protected WebElement weCoApplicant;

    @FindBy( xpath = LINK_CREATE_NEW_USER_XPATH )
    protected WebElement CreateNewUser;

//    @Inject
    public AutomaticRegistrationSection(SharedDriver webDriver) {
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
    public IAutomaticRegistrationSection clickCreateNewUserAndLogin(String userName) {
        loadingCheck();

        isVisible(OPOQO_APPLICANTS_ID_INPUT_XPATH, true);
        isVisible(LINK_CREATE_NEW_USER_XPATH, true);

        if(!StringUtils.isEmpty(userName))
            type(OPOQO_APPLICANTS_ID_INPUT_XPATH, userNameTimeStamping(userName, "gui")); //typing with timestamp

        clickElement(LINK_CREATE_NEW_USER_XPATH);
        loadingCheck();

        isVisible(OPOQO_APPLICANT_READ_ONLY_INPUT_XPATH, true);
        isVisible(OPOQO_PASSWORD_READ_ONLY_INPUT_XPATH, true);
        isVisible(OPOQO_LOGIN_BUTTON_XPATH, true);

        String applicant = getAttributeText(readOnlyApplicantInput, "value");
        if(!StringUtils.isEmpty(applicant)) {
          //todo Anthony cucumber guice module not executed
            user = new User();
            user.setEmail(applicant);
        }
        String password = getAttributeText(readOnlyPasswordInput, "value");
        if(!StringUtils.isEmpty(password))
            user.setPwd(password);
        clickElement(OPOQO_LOGIN_BUTTON_XPATH);
        loadingCheck();
        return this;
    }
}
