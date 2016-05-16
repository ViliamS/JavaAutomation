package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.Underwriter;
import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver_Underwriter;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolSection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class SetScoreOverrideDialog extends Underwriter implements ISetScoreOverrideDialog {

    private static final Log log = LogFactory.getLog(SetScoreOverrideDialog.class.getName());

    private WebDriver webDriver;

    public SetScoreOverrideDialog(SharedDriver_Underwriter webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public ISetScoreOverrideDialog setValue(String value){
        log.info("");
        loadingCheck();
        isVisible(VALUE_INPUT, true);
        loadingCheck();
        type(VALUE_INPUT, value);
        loadingCheck();
        return this;
    }

    @Override
    public ISetScoreOverrideDialog setNote(String value){
        log.info("");
        loadingCheck();
        isVisible(NOTE_INPUT, true);
        loadingCheck();
        type(NOTE_INPUT, value);
        loadingCheck();
        return this;
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

    @Override
    public IRiskToolSection clickCancel(){
        log.info("");
        isVisible(CANCEL_BUTTON, true);
        clickElement(CANCEL_BUTTON);
        return new RiskToolSection((SharedDriver_Underwriter) webDriver);
    }

    @Override
    public IRiskToolSection clickDeleteAll(){
        log.info("");
        loadingCheck();
        isVisible(DELETE_ALL_BUTTON, true);
        loadingCheck();
        clickElement(DELETE_ALL_BUTTON);
        loadingCheck();
        return new RiskToolSection((SharedDriver_Underwriter) webDriver);
    }
    @Override
    public IRiskToolSection clickDeleteScore(){
        log.info("");
        loadingCheck();
        isVisible(DELETE_SCORE, true);
        loadingCheck();
        clickElement(DELETE_SCORE);
        loadingCheck();
        return new RiskToolSection((SharedDriver_Underwriter) webDriver);
    }

}
