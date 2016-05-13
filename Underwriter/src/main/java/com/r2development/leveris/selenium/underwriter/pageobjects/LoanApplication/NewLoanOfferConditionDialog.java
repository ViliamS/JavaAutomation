package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.Underwriter;
import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class NewLoanOfferConditionDialog extends Underwriter implements INewLoanOfferConditionDialog{

    private static final Log log = LogFactory.getLog(NewLoanOfferConditionDialog.class.getName());

    private WebDriver webDriver;

    public NewLoanOfferConditionDialog(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public ILoanOfferToolSection clickCloseX(){
        log.info("");
        loadingCheck();
        isVisible(NEW_LOAN_OFFER_DIALOG_CLOSE_BUTTON_X, true);
        clickElement(NEW_LOAN_OFFER_DIALOG_CLOSE_BUTTON_X, ILoanOfferToolSection.LOAN_OFFER_TOOL_ADD_CONDITION_BUTTON);
        loadingCheck();
        return new LoanOfferToolSection((SharedDriver) webDriver);
    }

    @Override
    public INewLoanOfferConditionDialog addComment(String comment){
        log.info("");
        loadingCheck();
        isVisible(NEW_LOAN_OFFER_DIALOG_ADD_COMMENT_TEXTAREA, true);
        type(NEW_LOAN_OFFER_DIALOG_ADD_COMMENT_TEXTAREA, comment);
        loadingCheck();
        return this;
    }

    @Override
    public ILoanOfferToolSection clickSave(){
        log.info("");
        loadingCheck();
        isVisible(NEW_LOAN_OFFER_DIALOG_SAVE_BUTTON, true);
        clickElement(NEW_LOAN_OFFER_DIALOG_SAVE_BUTTON, ILoanOfferToolSection.LOAN_OFFER_TOOL_ADD_CONDITION_BUTTON);
        loadingCheck();
        return new LoanOfferToolSection((SharedDriver) webDriver);
    }


}
