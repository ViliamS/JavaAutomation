package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourFundingPage {
    String getTitle();
    String getDescription();

//    IYourFundingPage clickSingleYes();
//    IYourFundingPage clickSingleNo();
//    IYourFundingPage clickCoupleYes();
//    IYourFundingPage clickCoupleNo();

    YourFundingPage selectFundsSource(String fundsSource);

    YourFundingPage checkFundingAppliesToBorrower(String borrower);
    YourFundingPage checkFundingAppliedToCoapplicant(String coapplicant);

    YourFundingPage typeGiftDescription(String description);
    YourFundingPage typeGiftAmount(String amount);

    YourFundingPage typeInheritanceDescription(String description);
    YourFundingPage typeInheritanceAmount(String amount);

    YourFundingPage typeOtherDescription(String description);
    YourFundingPage typeOtherAmount(String amount);

    YourFundingPage clickCancel();
    YourFundingPage clickNext();
    YourFundingPage clickAddFundsSource();
    YourFundingPage clickAddThisFundsSource();

}
