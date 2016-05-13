package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class FinanceToolSection extends LoanApplicationPage implements IFinanceToolSection{

    private static final Log log = LogFactory.getLog(FinanceToolSection.class.getName());

    private WebDriver webDriver;

    public FinanceToolSection(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IFinanceToolSection financeToolSectionHideUnhide(ACTION action) {
        log.info("");
        switch (action) {
            case HIDE:
                return hideFinanceToolSection();
            case UNHIDE:
                return unhideFinanceToolSection();
            default:
                return this;
        }
    }

    IFinanceToolSection unhideFinanceToolSection() {
        log.info("");
        loadingCheck();
        if(isPresent(FINANCE_TOOL_PANEL_HIDDEN, 1)) {
            clickElement(FINANCE_TOOL_TAB, FINANCE_TOOL_PANEL_NOT_HIDDEN);
            loadingCheck();
        } else {
            log.info("Finance tool Section was already opened");
        }
        return this;
    }

    IFinanceToolSection hideFinanceToolSection() {
        log.info("");
        loadingCheck();
        if(isVisible(FINANCE_TOOL_PANEL_NOT_HIDDEN, 1)) {
            clickElement(FINANCE_TOOL_PANEL_NOT_HIDDEN, FINANCE_TOOL_PANEL_HIDDEN);
            loadingCheck();
        } else {
            log.info("Finance tool Section is already hidden");
        }
        return this;
    }

}
