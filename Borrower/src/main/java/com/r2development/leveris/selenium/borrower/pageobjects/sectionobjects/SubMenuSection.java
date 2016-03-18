package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubMenuSection extends Borrower implements ISubMenuSection {

    private static final Log log = LogFactory.getLog(SubMenuSection.class);

    @FindBy ( xpath = SUB_MENU_GET_APPROVAL_XPATH )
    protected WebElement weGetApproval;

    @FindBy ( xpath = SUB_MENU_FIND_YOUR_DREAM_HONE_XPATH )
    protected WebElement weFindDreamHome;

    @FindBy ( xpath = SUB_MENU_CONFIGURE_YOUR_LOAN_XPATH )
    protected WebElement weConfigureLoan;

    @FindBy ( xpath = SUB_MENU_FINAL_LOAN_SETUP_XPATH )
    protected WebElement weFinalLoanSetup;

//    @Inject
    public SubMenuSection(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public void clickGetApproval() {
        isVisible(SUB_MENU_GET_APPROVAL_XPATH, true);
        weGetApproval.click();
    }

    @Override
    public void clickFindDreamHome() {
        isVisible(SUB_MENU_FIND_YOUR_DREAM_HONE_XPATH, true);
        weFindDreamHome.click();
    }

    @Override
    public void clickConfigureLoan() {
        isVisible(SUB_MENU_CONFIGURE_YOUR_LOAN_XPATH, true);
        weConfigureLoan.click();
    }

    @Override
    public void clickFinalLoanSetup() {
        isVisible(SUB_MENU_FINAL_LOAN_SETUP_XPATH, true);
        weFinalLoanSetup.click();
    }
}
