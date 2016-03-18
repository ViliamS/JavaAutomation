package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuildQuoteSection3 extends Borrower implements IBuildQuoteSection3 {

    private static final Log log = LogFactory.getLog(BuildQuoteSection3.class);

    @FindBy( xpath = BUILD_QUOTE3_STEP3_XPATH )
    protected WebElement weStep;

    @FindBy( xpath = BUILD_QUOTE3_EDIT_DETAILS_XPATH )
    protected WebElement weEditDetails;

    @FindBy( xpath = IBuildQuoteSection3.BUILD_QUOTE3_EMAIL_QUOTE_XPATH )
    protected WebElement weEmailQuote;

    @FindBy( xpath = IBuildQuoteSection3.BUILD_QUOTE3_APPLY_NOW_XPATH )
    protected WebElement weApplyNow;

//    @Inject
    public BuildQuoteSection3(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getCurrentStep() {
        isVisible(BUILD_QUOTE3_STEP3_XPATH, true);
        return weStep.getText();
    }

    @Override
    public void clickApplyNow() {
//        isVisible(BUILD_QUOTE3_APPLY_NOW_XPATH, true);
//        getWebElement(BUILD_QUOTE3_APPLY_NOW_XPATH).click();
//        clickElement(BUILD_QUOTE3_APPLY_NOW_XPATH);
//        weApplyNow.click();
        clickElementViaJavascript(BUILD_QUOTE3_APPLY_NOW_XPATH);
    }

    @Override
    public void clickEmailQuote() {
        isVisible(BUILD_QUOTE3_EMAIL_QUOTE_XPATH, true);
        weEditDetails.click();
    }

    @Override
    public void clickEditDetails() {
        isVisible(BUILD_QUOTE3_EDIT_DETAILS_XPATH, true);
        weEditDetails.click();
    }

    @Override
    public boolean isLoaded() {
        return true;
    }
}
