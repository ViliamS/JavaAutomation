package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourFundingSection extends Borrower implements IYourFundingSection {

    private static final Log log = LogFactory.getLog(YourFundingSection.class);

    @FindBy( xpath = YOUR_FUNDING_TITLE_XPATH )
    protected  WebElement weYourFundingTitle;
    @FindBy ( xpath = YOUR_FUNDING_DESCRIPTION_XPATH )
    protected WebElement weYourFundingDescription;

    @FindBy ( xpath = YOUR_FUNDING_SINGLE_NO_XPATH )
    protected WebElement weYourFundingSingleNo;
    @FindBy ( xpath = YOUR_FUNDING_SINGLE_YES_XPATH )
    protected WebElement weYourFundingSingleYes;

    @FindBy ( xpath = YOUR_FUNDING_COUPLE_NO_XPATH )
    protected WebElement weYourFundingCoupleNo;
    @FindBy ( xpath = YOUR_FUNDING_COUPLE_YES_XPATH )
    protected WebElement weYourFundingCoupleYes;

    @FindBy ( xpath = YOUR_FUNDING_APPLIES_TO_BORROWER_XPATH )
    protected WebElement weYourFundingAppliesToBorrower;
    @FindBy ( xpath = YOUR_FUNDING_APPLIES_TO_COAPPLICANT_XPATH )
    protected WebElement weYourFundingAppliesToCoapplicant;

    @FindBy ( xpath = YOUR_FUNDING_LBL_WHATIS_XPATH )
    protected WebElement weYourFundingLblWhatIs;
    // Gift, Inheritance, Other
    @FindBy ( xpath = YOUR_FUNDING_CBX_WHATIS_XPATH )
    protected WebElement weYourFundingCbxWhatIs;

    @FindBy ( xpath = YOUR_FUNDING_LBL_SUBTOTAL_XPATH )
    protected WebElement weYourFundingLblSubtotal;
    @FindBy ( xpath = YOUR_FUNDING_SUBTOTAL_XPATH )
    protected WebElement weYourFundingSubtotal;

    // Gift
    @FindBy ( xpath = YOUR_FUNDING_GIFT_DESCRIPTION_XPATH )
    protected WebElement weYourFundingGiftDescription;
    @FindBy ( xpath = YOUR_FUNDING_GIFT_AMOUNT_XPATH )
    protected WebElement weYourFundingGiftAmount;

    // Inheritance
    @FindBy ( xpath = YOUR_FUNDING_INHERITANCE_DESCRIPTION_XPATH )
    protected WebElement weYourFundingInheritanceDescription;
    @FindBy ( xpath = YOUR_FUNDING_INHERITANCE_AMOUNT_XPATH )
    protected WebElement weYourFundingInheritanceAmount;

    // OTHER
    @FindBy ( xpath = YOUR_FUNDING_OTHER_DESCRIPTION_XPATH )
    protected WebElement weYourFundingOtherDescription;
    @FindBy ( xpath = YOUR_FUNDING_OTHER_AMOUNT_XPATH )
    protected WebElement weYourFundingOtherAmount;

    @FindBy ( xpath = YOUR_FUNDING_ADD_THIS_FUNDS_SOURCE_XPATH )
    protected WebElement weYourFundingAddThisFundsSource;
    @FindBy ( xpath = YOUR_FUNDING_ADD_FUNDS_SOURCE_XPATH )
    protected WebElement weYourFundingAddFundsSource;
    @FindBy ( xpath = YOUR_FUNDING_NEXT_XPATH )
    protected WebElement weYourFundingNext;
    @FindBy ( xpath = YOUR_FUNDING_CANCEL_XPATH )
    protected WebElement weYourFundingCancel;

    YourFundingSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        return getWebElement(YOUR_FUNDING_TITLE_XPATH).getText();
//        return weYourFundingTitle.getText();
    }

    @Override
    public String getDescription() {
        return weYourFundingDescription.getText();
    }

//    @Override
//    public IYourFundingSection clickSingleYes() {
//        isVisible(YOUR_FUNDING_SINGLE_YES_XPATH, true);
//        weYourFundingSingleYes.click();
//        return this;
//    }
//
//    @Override
//    public IYourFundingSection clickSingleNo() {
//        isVisible(YOUR_FUNDING_SINGLE_NO_XPATH, true);
//        weYourFundingSingleNo.click();
//        return this;
//    }
//
//    @Override
//    public IYourFundingSection clickCoupleYes() {
//        isVisible(YOUR_FUNDING_COUPLE_YES_XPATH, true);
//        weYourFundingCoupleYes.click();
//        return this;
//    }
//
//    @Override
//    public IYourFundingSection clickCoupleNo() {
//        isVisible(YOUR_FUNDING_COUPLE_NO_XPATH, true);
//        weYourFundingCoupleNo.click();
//        return this;
//    }

    @Override
    public IYourFundingSection selectFundsSource(String fundsSource) {
        isVisible(YOUR_FUNDING_CBX_WHATIS_XPATH, true);
        selectFromDropDown(YOUR_FUNDING_CBX_WHATIS_XPATH, fundsSource);
        return this;
    }

    @Override
    public IYourFundingSection checkFundingAppliesToBorrower(String borrower) {
        isVisible(YOUR_FUNDING_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower), true);
//        weYourFundingAppliesToBorrower.click();
        getWebElement(YOUR_FUNDING_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower)).click();
        return this;
    }

    @Override
    public IYourFundingSection checkFundingAppliedToCoapplicant(String coapplicant) {
        isVisible(YOUR_FUNDING_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant), true);
//        weYourFundingAppliesToCoapplicant.click();
        getWebElement(YOUR_FUNDING_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant)).click();
        return this;
    }

    @Override
    public IYourFundingSection typeGiftDescription(String description) {
        isVisible(YOUR_FUNDING_GIFT_DESCRIPTION_XPATH, true);
        weYourFundingGiftDescription.clear();
        weYourFundingGiftDescription.sendKeys(description);
        return this;
    }

    @Override
    public IYourFundingSection typeGiftAmount(String amount) {
        isVisible(YOUR_FUNDING_GIFT_AMOUNT_XPATH, true);
        weYourFundingGiftAmount.clear();
        weYourFundingGiftAmount.sendKeys(amount);
        return this;
    }

    @Override
    public IYourFundingSection typeInheritanceDescription(String description) {
        isVisible(YOUR_FUNDING_INHERITANCE_DESCRIPTION_XPATH, true);
        weYourFundingInheritanceDescription.clear();
        weYourFundingInheritanceDescription.sendKeys(description);
        return this;
    }

    @Override
    public IYourFundingSection typeInheritanceAmount(String amount) {
        isVisible(YOUR_FUNDING_INHERITANCE_AMOUNT_XPATH, true);
        weYourFundingInheritanceAmount.clear();
        weYourFundingInheritanceAmount.sendKeys(amount);
        return this;
    }

    @Override
    public IYourFundingSection typeOtherDescription(String description) {
        isVisible(YOUR_FUNDING_OTHER_DESCRIPTION_XPATH, true);
        weYourFundingOtherDescription.clear();
        weYourFundingOtherDescription.sendKeys(description);
        return this;
    }

    @Override
    public IYourFundingSection typeOtherAmount(String amount) {
        isVisible(YOUR_FUNDING_OTHER_AMOUNT_XPATH, true);
        weYourFundingOtherAmount.clear();
        weYourFundingOtherAmount.sendKeys(amount);
        return this;
    }

    //    @Override
//    public IYourFundingSection typeFundsSourceDescription(String fundsSource, String fundsSourceDescription) {
//        isVisible(YOUR_FUNDING_GIFT_DESCRIPTION_XPATH, true);
//        weYourFundingGiftDescription.clear();
//        weYourFundingGiftDescription.sendKeys(fundsSourceDescription);
//        return this;
//    }
//
//    @Override
//    public IYourFundingSection typeFundsSourceAmount(String fundsSource, String fundsSourceAmount) {
//        isVisible(YOUR_FUNDING_GIFT_AMOUNT_XPATH, true);
//        weYourFundingGiftAmount.clear();
//        weYourFundingGiftAmount.sendKeys(fundsSourceAmount);
//        return null;
//    }
//
//    @Override
//    public void typePanelFundsSourceAmount(String indexFundsSource, String fundsSourceAmount) {
//
//    }
//
//    @Override
//    public String getPanelFundsSourceInputAmount(String indexFundsSource) {
//        return null;
//    }
//
//    @Override
//    public String getPanelFundsSourceType(String indexFundsSource) {
//        return null;
//    }
//
//    @Override
//    public String getPanelFundsSourceOwner(String indexFundsSource) {
//        return null;
//    }
//
//    @Override
//    public String getPanelFundsSourceLabelAmount(String indexFundsSource) {
//        return null;
//    }

    @Override
    public IYourFundingSection clickNext() {
        isVisible(YOUR_FUNDING_NEXT_XPATH, true);
//        weYourFundingNext.click();
        clickElement(YOUR_FUNDING_NEXT_XPATH);
//        if(isVisible(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }

    @Override
    public IYourFundingSection clickAddFundsSource() {
        isVisible(YOUR_FUNDING_ADD_FUNDS_SOURCE_XPATH, true);
        weYourFundingAddFundsSource.click();
        return this;
    }

    @Override
    public IYourFundingSection clickAddThisFundsSource() {
        isVisible(YOUR_FUNDING_ADD_THIS_FUNDS_SOURCE_XPATH, true);
        weYourFundingAddThisFundsSource.click();
        return this;
    }

    @Override
    public IYourFundingSection clickCancel() {
        isVisible(YOUR_FUNDING_CANCEL_XPATH, true);
        weYourFundingCancel.click();
        return this;
    }
}
