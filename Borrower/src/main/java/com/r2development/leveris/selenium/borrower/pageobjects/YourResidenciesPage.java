package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class YourResidenciesPage extends HeaderAndBottomAndFormsMenuSection implements IYourResidenciesPage {

    private static final Log log = LogFactory.getLog(YourResidenciesSection.class.getName());

    WebDriver webDriver;

    private IYourResidenciesSection yourResidenciesSection;

    public YourResidenciesPage(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.yourResidenciesSection = new YourResidenciesSection(webDriver);
    }

    @Override
    public IYourResidenciesSection clickAdd() {
        log.info("");
        loadingCheck();
        if (isVisible(ADD_BUTTON, 5)) {
            isVisible(ADD_BUTTON, true);
            clickElement(ADD_BUTTON);
        }
        loadingCheck();
        return yourResidenciesSection;
    }

    @Override
    public IEmploymentIncomesPage clickDone() {
        log.info("");
        isVisible(DONE_BUTTON, true);
        clickElement(DONE_BUTTON, IEmploymentIncomeSection.EMPLOYMENT_INCOMES_ADD_PAYE_XPATH);
        return new EmploymentIncomesPage((SharedDriver) webDriver);
    }

    @Override
    public IYourResidenciesSection clickOtherPreviousResidency() {
        log.info("");
        isVisible(OTHER_PREVIOUS_RESIDENCY, true);
        clickElement(OTHER_PREVIOUS_RESIDENCY);
        loadingCheck();
        return yourResidenciesSection;
    }

    @Override
    public IYourResidenciesSection clickCurrentResidency() {
        log.info("");
        isVisible(CURRENT_RESIDENCY, true);
        clickElement(CURRENT_RESIDENCY);
        loadingCheck();
        return yourResidenciesSection;
    }

}
