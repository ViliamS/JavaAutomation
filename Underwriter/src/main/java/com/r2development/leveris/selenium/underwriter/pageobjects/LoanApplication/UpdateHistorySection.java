package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class UpdateHistorySection extends LoanApplicationPage implements IUpdateHistorySection {

    private static final Log log = LogFactory.getLog(UpdateHistorySection.class.getName());

    private WebDriver webDriver;

    public UpdateHistorySection(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IUpdateHistorySection updateHistorySectionHideUnhide(ACTION action) {
        log.info("");
        switch (action) {
            case HIDE:
                return hideUpdateHistorySection();
            case UNHIDE:
                return unhideUpdateHistorySection();
            default:
                return this;
        }
    }

    IUpdateHistorySection unhideUpdateHistorySection() {
        log.info("");
        loadingCheck();
        if(isPresent(UPDATE_HISTORY_PANEL_HIDDEN, 1)) {
            clickElement(UPDATE_HISTORY_PANEL_TITLE, UPDATE_HISTORY_PANEL_NOT_HIDDEN);
            loadingCheck();
        } else {
            log.info("Update History section was already opened");
        }
        return this;
    }

    IUpdateHistorySection hideUpdateHistorySection() {
        log.info("");
        loadingCheck();
        if(isVisible(UPDATE_HISTORY_PANEL_NOT_HIDDEN, 1)) {
            clickElement(UPDATE_HISTORY_PANEL_NOT_HIDDEN, UPDATE_HISTORY_PANEL_HIDDEN);
            loadingCheck();
        } else {
            log.info("Updates History section is already hidden");
        }
        return this;
    }

}
