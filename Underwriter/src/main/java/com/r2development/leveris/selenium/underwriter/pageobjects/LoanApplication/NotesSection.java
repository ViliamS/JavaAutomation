package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver_Underwriter;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class NotesSection extends LoanApplicationPage implements INotesSection{

    private static final Log log = LogFactory.getLog(NotesSection.class.getName());

    private WebDriver webDriver;

    public NotesSection(SharedDriver_Underwriter webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public INotesSection notesSectionHideUnhide(ACTION action) {
        log.info("");
        switch (action) {
            case HIDE:
                return hideNotesSection();
            case UNHIDE:
                return unhideNotesSection();
            default:
                return this;
        }
    }

    INotesSection unhideNotesSection() {
        log.info("");
        loadingCheck();
        if(isPresent(NOTES_PANEL_HIDDEN, 1)) {
            clickElement(NOTES_PANEL_TITLE, NOTES_PANEL_NOT_HIDDEN);
            loadingCheck();
        } else {
            log.info("Notes section was already opened");
        }
        return this;
    }

    INotesSection hideNotesSection() {
        log.info("");
        loadingCheck();
        if(isVisible(NOTES_PANEL_NOT_HIDDEN, 1)) {
            clickElement(NOTES_PANEL_NOT_HIDDEN, NOTES_PANEL_HIDDEN);
            loadingCheck();
        } else {
            log.info("Notes section is already hidden");
        }
        return this;
    }
}