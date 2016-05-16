package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver_Underwriter;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class LoanOfferToolSection extends LoanApplicationPage implements ILoanOfferToolSection {

    private static final Log log = LogFactory.getLog(LoanOfferToolSection.class.getName());

    private WebDriver webDriver;

    public LoanOfferToolSection(SharedDriver_Underwriter webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public ILoanOfferToolSection loanOfferToolSectionHideUnhide(ACTION action) {
        log.info("");
        switch (action) {
            case HIDE:
                return hideLoanOfferToolSection();
            case UNHIDE:
                return unhideLoanOfferToolSection();
            default:
                return this;
        }
    }

    ILoanOfferToolSection unhideLoanOfferToolSection() {
        log.info("");
        loadingCheck();
        if (isPresent(LOAN_OFFER_TOOL_PANEL_HIDDEN, 1)) {
            clickElement(LOAN_OFFER_TOOL_PANEL_TITLE, LOAN_OFFER_TOOL_PANEL_NOT_HIDDEN);
            loadingCheck();
        } else {
            log.info("Loan Offer Tool section was already opened");
        }
        return this;
    }

    ILoanOfferToolSection hideLoanOfferToolSection() {
        log.info("");
        loadingCheck();
        if (isVisible(LOAN_OFFER_TOOL_PANEL_NOT_HIDDEN, 1)) {
            clickElement(LOAN_OFFER_TOOL_PANEL_NOT_HIDDEN, LOAN_OFFER_TOOL_PANEL_HIDDEN);
            loadingCheck();
        } else {
            log.info("Loan Offer Tool section is already hidden");
        }
        return this;
    }

    @Override
    public boolean isScoreWarningDisplayed(){
        log.info("");
        loadingCheck();
        return isVisible(LOAN_OFFER_TOOL_WARNING_SCORE_NOT_FULLY_SET_UP_YET, 3);
    }

    @Override
    public ILoanOfferToolSection selectLoanOfferVersionLatest(){
        log.info("");
        loadingCheck();
        isVisible(LOAN_OFFER_TOOL_VERSION_SELECT, true);
        selectsLastComboBoxValue(LOAN_OFFER_TOOL_VERSION_SELECT);
        return this;
    }

    @Override
    public ILoanOfferToolSection selectLoanOfferVersion(String version){
        log.info("");
        loadingCheck();
        isVisible(LOAN_OFFER_TOOL_VERSION_SELECT, true);
        setComboboxInput(LOAN_OFFER_TOOL_VERSION_SELECT, version);
        loadingCheck();
        return this;
    }

    @Override
    public ILoanOfferToolSection clickEditReview(){
        log.info("");
        loadingCheck();
        isVisible(LOAN_OFFER_TOOL_EDIT_REVIEW_BUTTON, true);
        clickElement(LOAN_OFFER_TOOL_EDIT_REVIEW_BUTTON);
        loadingCheck();
        return this;
    }

    @Override
    public ILoanOfferToolSection clickReset(){
        log.info("");
        loadingCheck();
        isVisible(LOAN_OFFER_TOOL_RESET_BUTTON, true);
        clickElement(LOAN_OFFER_TOOL_RESET_BUTTON);
        loadingCheck();
        return this;
    }

    @Override
    public ILoanOfferToolSection clickSaveOffer(){
        log.info("");
        loadingCheck();
        isVisible(LOAN_OFFER_TOOL_SAVE_OFFER_BUTTON, true);
        clickElement(LOAN_OFFER_TOOL_SAVE_OFFER_BUTTON);
        loadingCheck();
        return this;
    }

    @Override
    public INewLoanOfferConditionDialog clickAddCondition(){
        log.info("");
        loadingCheck();
        isVisible(LOAN_OFFER_TOOL_ADD_CONDITION_BUTTON, true);
        clickElement(LOAN_OFFER_TOOL_ADD_CONDITION_BUTTON, INewLoanOfferConditionDialog.NEW_LOAN_OFFER_DIALOG_ADD_COMMENT_TEXTAREA);
        loadingCheck();
        return new NewLoanOfferConditionDialog((SharedDriver_Underwriter) webDriver);
    }

    @Override
    public ILoanOfferToolSection addComment(String comment){
        log.info("");
        loadingCheck();
        isVisible(LOAN_OFFER_TOOL_ADD_COMMENTS_HERE, true);
        type(LOAN_OFFER_TOOL_ADD_COMMENTS_HERE, comment);
        loadingCheck();
        return this;
    }

    @Override
    public IRiskToolSection clickSignReview(){
        log.info("");
        loadingCheck();
        isVisible(LOAN_OFFER_TOOL_SIGN_REVIEW_BUTTON, true);
        clickElement(LOAN_OFFER_TOOL_SIGN_REVIEW_BUTTON, IRiskToolSection.KYC_CHECK_TITLE);
        loadingCheck();
        return this;
    }
}