package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs.*;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class RiskToolSection extends LoanApplicationPage implements IRiskToolSection{

    private static final Log log = LogFactory.getLog(RiskToolSection.class.getName());

    private WebDriver webDriver;

    public RiskToolSection(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IRiskToolSection riskToolSectionHideUnhide(ACTION action) {
        log.info("");
        switch (action) {
            case HIDE:
                return hideRiskToolSection();
            case UNHIDE:
                return unhideRiskToolSection();
            default:
                return this;
        }
    }

    IRiskToolSection unhideRiskToolSection() {
        log.info("");
        loadingCheck();
        if(isPresent(RISK_TOOL_PANEL_HIDDEN, 1)) {
            clickElement(RISK_TOOL_PANEL_TITLE, RISK_TOOL_PANEL_NOT_HIDDEN);
            loadingCheck();
        } else {
            log.info("Risk Tool section was already opened");
        }
        return this;
    }

    IRiskToolSection hideRiskToolSection() {
        log.info("");
        loadingCheck();
        if(isVisible(RISK_TOOL_PANEL_NOT_HIDDEN, 1)) {
            clickElement(RISK_TOOL_PANEL_NOT_HIDDEN, RISK_TOOL_PANEL_HIDDEN);
            loadingCheck();
        } else {
            log.info("Risk Tool section is already hidden");
        }
        return this;
    }

    @Override
    public IRiskToolSection setManuallyUpdateCheckbox(ACTION checkUncheck){
        log.info("");
        loadingCheck();
        isVisible(KYC_CHECK_MANUALLY_UPDATE_CHECKBOX, true);
        checkBox(KYC_CHECK_MANUALLY_UPDATE_CHECKBOX, checkUncheck.get());
        loadingCheck();
        return this;
    }

    @Override
    public IRiskToolSection clickSaveKYC(){
        log.info("");
        loadingCheck();
        isVisible(KYC_SAVE_BUTTON, true);
        loadingCheck();
        clickElement(KYC_SAVE_BUTTON);
        loadingCheck();
        return this;
    }

    @Override
    public ISetFICODialog clickSetFICO(){
        log.info("");
        loadingCheck();
        isVisible(SET_FICO_BUTTON, true);
        loadingCheck();
        clickToAppearDisappear(SET_FICO_BUTTON, ISetFICODialog.FICO_INPUT, "");
        loadingCheck();
        return new SetFICODialog((SharedDriver) webDriver);
    }

    @Override
    public ISetAMLDialog clickSetAML(){
        log.info("");
        loadingCheck();
        isVisible(SET_AML_BUTTON, true);
        loadingCheck();
        clickToAppearDisappear(SET_AML_BUTTON, ISetAMLDialog.SET_AML_DIALOG, "");
        loadingCheck();
        return new SetAMLDialog((SharedDriver) webDriver);
    }

    @Override
    public ISetFraudDialog clickSetFraud(){
        log.info("");
        loadingCheck();
        isVisible(SET_FRAUD_BUTTON, true);
        loadingCheck();
        clickToAppearDisappear(SET_FRAUD_BUTTON, ISetFraudDialog.FRAUD_COMBOBOX_INPUT, "");
        loadingCheck();
        return new SetFraudDialog((SharedDriver) webDriver);
    }

    @Override
    public IRepeatCustomerDialog clickSetRepCustomer(){
        log.info("");
        loadingCheck();
        isVisible(SET_REP_CUSTOMER_BUTTON, true);
        loadingCheck();
        clickToAppearDisappear(SET_REP_CUSTOMER_BUTTON, IRepeatCustomerDialog.REEPEAT_CUSTOMER_DIALOG, "");
        loadingCheck();
        return new RepeatCustomerDialog((SharedDriver) webDriver);
    }

    @Override
    public ISetScoreOverrideDialog clickSetScoreOverride(){
        log.info("");
        loadingCheck();
        isVisible(SET_SCORE_OVERRIDE_BUTTON, true);
        loadingCheck();
        clickToAppearDisappear(SET_SCORE_OVERRIDE_BUTTON, ISetScoreOverrideDialog.SET_SCORE_OVERRIDE_TITLE, "");
        loadingCheck();
        return new SetScoreOverrideDialog((SharedDriver) webDriver);
    }

    @Override
    public IAddNoteDialog clickSetNote(){
        log.info("");
        loadingCheck();
        isVisible(SET_NOTE_BUTTON, true);
        loadingCheck();
        clickToAppearDisappear(SET_NOTE_BUTTON, IAddNoteDialog.NOTE_INPUT, "");
        loadingCheck();
        return new AddNoteDialog((SharedDriver) webDriver);
    }

    @Override
    public IRiskToolSection setStatusDropDown(String value){
        log.info("");
        loadingCheck();
        isVisible(KYC_TABLE_FIRST_ROW_STATUS_COMBOBOX, true);
        loadingCheck();
        setComboboxInput(KYC_TABLE_FIRST_ROW_STATUS_COMBOBOX, value);
        loadingCheck();
        return this;
    }
}