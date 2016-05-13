package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.Underwriter;
import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolSection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class SetFICODialog extends Underwriter implements ISetFICODialog {

    private static final Log log = LogFactory.getLog(SetFICODialog.class.getName());

    private WebDriver webDriver;

    public SetFICODialog(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public ISetFICODialog setFICO(String value){
        log.info("");
        loadingCheck();
        isVisible(FICO_INPUT, true);
        loadingCheck();
        type(FICO_INPUT, value);
        loadingCheck();
        return this;
    }

    @Override
    public ISetFICODialog setTicketID(String value){
        log.info("");
        loadingCheck();
        isVisible(TICKET_ID_INPUT, true);
        loadingCheck();
        type(TICKET_ID_INPUT, value);
        loadingCheck();
        return this;
    }

    @Override
    public ISetFICODialog setComment(String value){
        log.info("");
        loadingCheck();
        isVisible(COMMENT_INPUT, true);
        loadingCheck();
        type(COMMENT_INPUT, value);
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
        return new RiskToolSection((SharedDriver) webDriver);
    }

    @Override
    public IRiskToolSection clickCancel(){
        log.info("");
        loadingCheck();
        isVisible(CANCEL_BUTTON, true);
        loadingCheck();
        clickElement(CANCEL_BUTTON);
        loadingCheck();
        return new RiskToolSection((SharedDriver) webDriver);
    }
}