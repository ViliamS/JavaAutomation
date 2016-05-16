package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver_Underwriter;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class FormToolsSection extends LoanApplicationPage implements IFormToolsSection{

    private static final Log log = LogFactory.getLog(FormToolsSection.class.getName());

    private WebDriver webDriver;

    public FormToolsSection(SharedDriver_Underwriter webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IFormToolsSection formToolSectionHideUnhide(ACTION action) {
        log.info("");
        switch (action) {
            case HIDE:
                return hideFormToolSection();
            case UNHIDE:
                return unhideFormToolSection();
            default:
                return this;
        }
    }

    IFormToolsSection unhideFormToolSection() {
        log.info("");
        loadingCheck();
        if(isPresent(FORM_TOOLS_PANEL_HIDDEN, 1)) {
            clickElement(FORM_TOOLS_PANEL_TITLE, FORM_TOOLS_PANEL_NOT_HIDDEN);
            loadingCheck();
        } else {
            log.info("Form Tools section was already opened");
        }
        return this;
    }

    IFormToolsSection hideFormToolSection() {
        log.info("");
        loadingCheck();
        if(isVisible(FORM_TOOLS_PANEL_NOT_HIDDEN, 1)) {
            clickElement(FORM_TOOLS_PANEL_NOT_HIDDEN, FORM_TOOLS_PANEL_HIDDEN);
            loadingCheck();
        } else {
            log.info("Form Tools section is already hidden");
        }
        return this;
    }

}