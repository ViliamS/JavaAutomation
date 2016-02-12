package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuildQuoteSection2 extends Borrower implements IBuildQuoteSection2 {

    private static final Log log = LogFactory.getLog(BuildQuoteSection2.class);

    @FindBy( xpath = BUILD_QUOTE2_BACK_XPATH )
    protected WebElement weBack;

    @FindBy( xpath = BUILD_QUOTE2_STEP2_XPATH )
    protected WebElement weStep;

    @FindBy( xpath = BUILD_QUOTE2_EDIT_XPATH )
    protected WebElement weEdit;

    @FindBy( xpath = BUILD_QUOTE2_HOUSE_LOC_XPATH )
    protected WebElement weHouseLoc;

    @FindBy( xpath = BUILD_QUOTE2_CONFIGURE_LOAN_XPATH )
    protected WebElement weConfigureLoan;


    @FindBy( xpath = BUILD_QUOTE2_AFFORDABILITY_AMOUNT_XPATH )
    protected WebElement weAffordabilityAmount;

    @FindBy( xpath = BUILD_QUOTE2_AFFORDABILITY_MONTHLY_XPATH )
    protected WebElement weAffordabilityMonthly;

    @FindBy( xpath = BUILD_QUOTE2_AFFORDABILITY_FUNDS_XPATH )
    protected WebElement weAffordabilityFunds;

    @FindBy( xpath = BUILD_QUOTE_NOT_ELIGIBLE_XPATH )
    protected WebElement weQuoteNotEligible;

    @Inject
    public BuildQuoteSection2(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public void clickEdit() {
    }

    @Override
    public void clickConfigureLoan() {
        try {
            isVisible(BUILD_QUOTE2_CONFIGURE_LOAN_XPATH, true);
            weConfigureLoan.click();
        } catch ( WebDriverException wde) {
            clickElement(BUILD_QUOTE2_CONFIGURE_LOAN_XPATH);
        }
    }

    @Override
    public boolean isLoaded() {
        return true;
    }

    @Override
    public String getAffordabilityAmount() {
        try {
            isVisible(BUILD_QUOTE2_AFFORDABILITY_AMOUNT_XPATH, true);
            return weAffordabilityAmount.getText();
        }
        catch(Exception ioe) {
            isVisible(BUILD_QUOTE2_AFFORDABILITY_AMOUNT_XPATH, true, 15);
        }
        return weAffordabilityAmount.getText();
    }

    @Override
    public String getAffordabilityMonthly() {
        isVisible(BUILD_QUOTE2_AFFORDABILITY_MONTHLY_XPATH, true);
        return weAffordabilityMonthly.getText();
    }

    @Override
    public String getAffordabilityFunds() {
        isVisible(BUILD_QUOTE2_AFFORDABILITY_FUNDS_XPATH, true);
        return weAffordabilityFunds.getText();
    }

    @Override
    public boolean isEligible() {
        return !isVisible(BUILD_QUOTE_NOT_ELIGIBLE_XPATH, false, 5);
    }
}
