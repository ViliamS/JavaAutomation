package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BottomSection extends Borrower implements IBottomSection {

    private static final Log log = LogFactory.getLog(BottomSection.class);

    @FindBy( xpath = CONTACT_US_LINK_XPATH )
    protected WebElement weContactUs;

    @FindBy( xpath = HELP_CENTER_LINK_XPATH )
    protected WebElement weHelpCenter;

    @FindBy( xpath = WHAT_ELSE_LINK_XPATH )
    protected WebElement weWhatElse;

    @FindBy( xpath = LEGALS_TERMS_LINK_XPATH )
    protected WebElement weLegalsTerms;

    @FindBy( xpath = GOV_AND_INC_REGULARITY_XPATH )
    protected WebElement weGovAndIncRegularity;

//    @Inject
    public BottomSection(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public void clickContactUs() {

    }

    @Override
    public void clickHelpCenter() {

    }

    @Override
    public void clickWhatElse() {

    }

    @Override
    public void clickLegalTerm() {

    }

    @Override
    public boolean isLoaded() {
        return true;
    }
}
