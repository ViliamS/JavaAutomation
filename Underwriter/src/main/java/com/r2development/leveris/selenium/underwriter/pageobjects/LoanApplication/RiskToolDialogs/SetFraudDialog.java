package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.Underwriter;
import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver_Underwriter;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolSection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class SetFraudDialog extends Underwriter implements ISetFraudDialog {

    private static final Log log = LogFactory.getLog(SetFraudDialog.class.getName());

    private WebDriver webDriver;

    public SetFraudDialog(SharedDriver_Underwriter webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public ISetFraudDialog setFraud(String value){
        log.info("");
        loadingCheck();
        isVisible(FRAUD_COMBOBOX_INPUT, true);
        loadingCheck();
        setComboboxInput(FRAUD_COMBOBOX_INPUT, value);
        loadingCheck();
        return this;
    }

    @Override
    public ISetFraudDialog setTickedId(String value){
        log.info("");
        loadingCheck();
        isVisible(TICKET_ID_INPUT, true);
        loadingCheck();
        type(TICKET_ID_INPUT, value);
        loadingCheck();
        return this;
    }

    @Override
    public ISetFraudDialog setComment(String value){
        log.info("");
        loadingCheck();
        isVisible(COMMENT_INPUT, true);
        loadingCheck();
        type(COMMENT_INPUT, value);
        loadingCheck();
        return this;
    }

    @Override
    public IRiskToolSection clickCancel(){
        log.info("");
        loadingCheck();
        isVisible(CANCEL_BUTTON, true);
        loadingCheck();
        clickElement(CANCEL_BUTTON);
        loadingCheck();
        return new RiskToolSection((SharedDriver_Underwriter) webDriver);
    }

    @Override
    public IRiskToolSection clickSave(){
        log.info("");
        loadingCheck();
        isVisible(SAVE_BUTTON, true);
        loadingCheck();
        clickElement(SAVE_BUTTON);
        loadingCheck();
        return new RiskToolSection((SharedDriver_Underwriter) webDriver);
    }
}