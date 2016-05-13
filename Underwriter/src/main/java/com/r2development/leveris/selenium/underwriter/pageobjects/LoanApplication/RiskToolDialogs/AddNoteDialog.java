package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.Underwriter;
import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolSection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class AddNoteDialog extends Underwriter implements IAddNoteDialog {

    private static final Log log = LogFactory.getLog(AddNoteDialog.class.getName());

    private WebDriver webDriver;

    public AddNoteDialog(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IAddNoteDialog setNote(String value){
        log.info("");
        loadingCheck();
        isVisible(NOTE_INPUT, true);
        loadingCheck();
        type(NOTE_INPUT, value);
        loadingCheck();
        return this;
    }

    @Override
    public IRiskToolSection clickCancel(){
        log.info("");
        loadingCheck();
        isVisible(CANCEL_BUTTON, true);
        clickElement(CANCEL_BUTTON);
        loadingCheck();
        return new RiskToolSection((SharedDriver) webDriver);
    }

    @Override
    public IRiskToolSection clickSave(){
        log.info("");
        loadingCheck();
        isVisible(SAVE_BUTTON, true);
        clickElement(SAVE_BUTTON);
        loadingCheck();
        return new RiskToolSection((SharedDriver) webDriver);
    }
}