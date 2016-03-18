package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetStartedMortgageSection extends Borrower implements IGetStartedMortgageSection {

    private static final Log log = LogFactory.getLog(GetStartedMortgageSection.class);

    @FindBy( xpath = GET_STARTED_BUTTON_XPATH )
    protected WebElement weGetStarted;

//    @Inject
    public GetStartedMortgageSection(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public void clickGetStarted() {
        loadingCheck();
        isVisible(GET_STARTED_BUTTON_XPATH, true, 1);
        weGetStarted.click();
        loadingCheck();
    }
}
