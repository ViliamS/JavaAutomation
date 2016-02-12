package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class YourFundingPage extends HeaderAndBottomAndFormsMenuSection implements IYourFundingPage {

    private static final Log log = LogFactory.getLog(YourFundingPage.class);

    protected  IYourFundingSection yourFundingSection;

    @Inject
    public YourFundingPage(WebDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        yourFundingSection = new YourFundingSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public String getTitle() {
        return yourFundingSection.getTitle();
    }

    @Override
    public String getDescription() {
        return yourFundingSection.getDescription();
    }

    @Override
    public YourFundingPage selectFundsSource(String fundsSource) {
        yourFundingSection.selectFundsSource(fundsSource);
        return this;
    }

//    @Override
//    public YourFundingPage clickSingleYes() {
//        yourFundingSection.clickSingleYes();
//        return this;
//    }
//
//    @Override
//    public YourFundingPage clickSingleNo() {
//        yourFundingSection.clickSingleNo();
//        return this;
//    }
//
//    @Override
//    public YourFundingPage clickCoupleYes() {
//        yourFundingSection.clickCoupleYes();
//        return this;
//    }
//
//    @Override
//    public YourFundingPage clickCoupleNo() {
//        yourFundingSection.clickCoupleNo();
//        return this;
//    }

    @Override
    public YourFundingPage checkFundingAppliesToBorrower(String borrower) {
        yourFundingSection.checkFundingAppliesToBorrower(borrower);
        return this;
    }

    @Override
    public YourFundingPage checkFundingAppliedToCoapplicant(String coapplicant) {
        yourFundingSection.checkFundingAppliedToCoapplicant(coapplicant);
        return this;
    }

    @Override
    public YourFundingPage typeGiftDescription(String description) {
        yourFundingSection.typeGiftDescription(description);
        return this;
    }

    @Override
    public YourFundingPage typeGiftAmount(String amount) {
        yourFundingSection.typeGiftAmount(amount);
        return this;
    }

    @Override
    public YourFundingPage typeInheritanceDescription(String description) {
        yourFundingSection.typeInheritanceDescription(description);
        return this;
    }

    @Override
    public YourFundingPage typeInheritanceAmount(String amount) {
        yourFundingSection.typeInheritanceAmount(amount);
        return this;
    }

    @Override
    public YourFundingPage typeOtherDescription(String description) {
        yourFundingSection.typeOtherDescription(description);
        return this;
    }

    @Override
    public YourFundingPage typeOtherAmount(String amount) {
        yourFundingSection.typeOtherAmount(amount);
        return this;
    }

    @Override
    public YourFundingPage clickCancel() {
        yourFundingSection.clickCancel();
        return this;
    }

    @Override
    public YourFundingPage clickNext() {
        yourFundingSection.clickNext();
        return this;
    }

    @Override
    public YourFundingPage clickAddFundsSource() {
        yourFundingSection.clickAddFundsSource();
        return this;
    }

    @Override
    public YourFundingPage clickAddThisFundsSource() {
        yourFundingSection.clickAddThisFundsSource();
        return this;
    }
}
