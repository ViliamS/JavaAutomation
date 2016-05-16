package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver_Underwriter;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class Documents2Section extends LoanApplicationPage implements IDocuments2Section{

    private static final Log log = LogFactory.getLog(Documents2Section.class.getName());

    private WebDriver webDriver;

    public Documents2Section(SharedDriver_Underwriter webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IDocuments2Section documents2SectionHideUnhide(ACTION action) {
        log.info("");
        switch (action) {
            case HIDE:
                return hideDocuments2Section();
            case UNHIDE:
                return unhideDocuments2Section();
            default:
                return this;
        }
    }

    IDocuments2Section unhideDocuments2Section() {
        log.info("");
        loadingCheck();
        if(isPresent(DOCUMENTS2_PANEL_HIDDEN, 1)) {
            clickElement(DOCUMENTS2_PANEL_TITLE, DOCUMENTS2_PANEL_NOT_HIDDEN);
            loadingCheck();
        } else {
            log.info("Documents 2 section was already opened");
        }
        return this;
    }

    IDocuments2Section hideDocuments2Section() {
        log.info("");
        loadingCheck();
        if(isVisible(DOCUMENTS2_PANEL_NOT_HIDDEN, 1)) {
            clickElement(DOCUMENTS2_PANEL_NOT_HIDDEN, DOCUMENTS2_PANEL_HIDDEN);
            loadingCheck();
        } else {
            log.info("Documents 2 section is already hidden");
        }
        return this;
    }

}
