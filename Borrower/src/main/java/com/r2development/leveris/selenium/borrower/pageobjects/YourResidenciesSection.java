package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class YourResidenciesSection extends Borrower implements IYourResidenciesSection {

    private static final Log log = LogFactory.getLog(YourResidenciesSection.class.getName());

    private IFormsMenu formsMenu;

    public YourResidenciesSection(SharedDriver webDriver) {
        super(webDriver);
        formsMenu = new FormsMenu(webDriver);
    }

    public IYourResidenciesSection clickCurrentResidency(){
        log.info("IYourResidenciesSection.clickCurrentResidency()");
        loadingCheck();
        isVisible(CURRENT_RESIDENCY_XPATH, 10);
        clickElementLoop(CURRENT_RESIDENCY_XPATH, RESIDENCY_ADDRESS_LINE_1_XPATH);
        loadingCheck();
        return this;
    }

    public IYourResidenciesSection clickOtherPreviousResidency(){
        log.info("IYourResidenciesSection.clickOtherPreviousResidency()");
        loadingCheck();
        isVisible(OTHER_PREVIOUS_RESIDENCY_XPATH, 10);
        clickElementLoop(OTHER_PREVIOUS_RESIDENCY_XPATH, RESIDENCY_ADDRESS_LINE_1_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomesPage clickNext(){
        log.info("IYourResidenciesSection.clickNext()");
        loadingCheck();
        formsMenu.clickBorrowerEmploymentIncome();
        loadingCheck();
        return new EmploymentIncomesPage(webDriver);
    }
}