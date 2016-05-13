package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.Underwriter;
import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolSection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class SetAMLDialog extends Underwriter implements ISetAMLDialog{

    private static final Log log = LogFactory.getLog(SetAMLDialog.class.getName());

    private WebDriver webDriver;

    public SetAMLDialog(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public ISetAMLDialog setAMLcombobox(String value){
        log.info("");
        loadingCheck();
        isVisible(AML_COMBOBOX, true);
        setComboboxInput(AML_COMBOBOX, value);
        loadingCheck();
        return this;
    }
    @Override
    public ISetAMLDialog setTicketId(String value){
        log.info("");
        loadingCheck();
        isVisible(TICKET_ID_INPUT, true);
        type(TICKET_ID_INPUT, value);
        loadingCheck();
        return this;
    }
    @Override
    public ISetAMLDialog setComment(String value){
        log.info("");
        loadingCheck();
        isVisible(COMMENT_INPUT, true);
        type(COMMENT_INPUT, value);
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