package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class YourResidenciesPage extends Borrower implements IYourResidenciesPage {

    private static final Log log = LogFactory.getLog(YourResidenciesPage.class.getName());

    private IYourResidenciesSection yourResidenciesSection;

    public YourResidenciesPage(SharedDriver webDriver) {
        super(webDriver);
        yourResidenciesSection = new YourResidenciesSection(webDriver);
    }

    @Override
    public IYourResidenciesPage clickCurrentResidency(){
        yourResidenciesSection.clickCurrentResidency();
        return this;
    }

    @Override
    public IYourResidenciesPage clickOtherPreviousResidency(){
        yourResidenciesSection.clickOtherPreviousResidency();
        return this;
    }

    @Override
    public IEmploymentIncomesPage clickNext(){
        return yourResidenciesSection.clickNext();
    }

}
