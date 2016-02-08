package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourFundingSection {
//    String YOUR_FUNDING_TITLE_XPATH = "//h2[contains(.,'YOUR FUNDING')]";
    String YOUR_FUNDING_TITLE_XPATH = "//div[contains(@data-path, 'pnlEmpList lblEmpListTitle') and contains(., 'Your fundings')]";
    String YOUR_FUNDING_DESCRIPTION_XPATH = "//div[contains(@wicketpath, 'lblYourFundig')]//span";

    String YOUR_FUNDING_SINGLE_NO_XPATH = "//label[contains(., 'NO I DON')]/following-sibling::span/a";
    String YOUR_FUNDING_SINGLE_YES_XPATH = "//label[contains(., 'YES I DO')]/following-sibling::span/a";

    String YOUR_FUNDING_COUPLE_NO_XPATH = "//label[contains(., 'NO WE DON')]/following-sibling::span/a";
    String YOUR_FUNDING_COUPLE_YES_XPATH = "//label[contains(., 'YES WE DO')]/following-sibling::span/a";

    String YOUR_FUNDING_APPLIES_TO_BORROWER_XPATH = "//label[contains(., '${replaceBorrower}$')]/following-sibling::span/a";
    String YOUR_FUNDING_APPLIES_TO_COAPPLICANT_XPATH = "//label[contains(., '${replaceCoapplicant}$')]/following-sibling::span/a";

    String YOUR_FUNDING_LBL_WHATIS_XPATH = "//div[contains(@wicketpath, 'lblWhatIs') and contains(., 'What is the source of funds?')]//span";
    // Gift, Inheritance, Other
    String YOUR_FUNDING_CBX_WHATIS_XPATH = "//label[contains(@wicketpath, 'cmbSourceOfFunds_label')]/following-sibling::input";

//    String YOUR_FUNDING_PANELS_XPATH = "//div[contains(@id, 'pnlFunding')]";
//    String YOUR_FUNDING_TYPE_XPATH = "//div[contains(@wicketpath, 'lblType')]/span"; // id = Type
//    String YOUR_FUNDING_LINK_XPATH = "//div[contains(@wicketpath, 'lblType')]/span"; // id = Other
//    String YOUR_FUNDING_DELETE_XPATH = "//div[contains(@wicketpath, 'lblType')]/span"; // id = Other
//    String YOUR_FUNDING_LABEL2_XPATH = "//div[contains(@wicketpath, 'lblFunding2')]/span":  // id =
//    String YOUR_FUNDING_OWNER_XPATH = "//div[contains(@wicketpath, 'lblName')]/span";
//    String YOUR_FUNDING_AMOUNT_XPATH = "//div[contains(@wicketpath, 'lblFundingAmount')]/span";
//    String YOUR_FUNDING_EDITAMOUNT_XPATH = "//input[contains(@wicketpath, 'crbFunding2')]";

    String YOUR_FUNDING_LBL_SUBTOTAL_XPATH = "//div[@data-path='lblSubtotal']";
    String YOUR_FUNDING_SUBTOTAL_XPATH = "//div[@data-path='lblSubtotalAmount']//span";

    // Gift
    String YOUR_FUNDING_GIFT_DESCRIPTION_XPATH = "//label[contains(., 'Description')]/following-sibling::input";
    String YOUR_FUNDING_GIFT_AMOUNT_XPATH = "//label[contains(., 'Amount')]/following-sibling::input";

    // Inheritance
    String YOUR_FUNDING_INHERITANCE_DESCRIPTION_XPATH = YOUR_FUNDING_GIFT_DESCRIPTION_XPATH;
    String YOUR_FUNDING_INHERITANCE_AMOUNT_XPATH = YOUR_FUNDING_GIFT_AMOUNT_XPATH;

    // OTHER
    String YOUR_FUNDING_OTHER_DESCRIPTION_XPATH = YOUR_FUNDING_GIFT_DESCRIPTION_XPATH;
    String YOUR_FUNDING_OTHER_AMOUNT_XPATH = YOUR_FUNDING_GIFT_AMOUNT_XPATH;

    String YOUR_FUNDING_ADD_THIS_FUNDS_SOURCE_XPATH = "//a[contains(., 'ADD THIS SOURCE OF FUNDS')]";
    String YOUR_FUNDING_ADD_FUNDS_SOURCE_XPATH = "//a[contains(., 'ADD SOURCE OF FUNDS')]";
//    String YOUR_FUNDING_NEXT_XPATH = "//a[contains(., 'Next')]";
    String YOUR_FUNDING_NEXT_XPATH = "//a[contains(., 'I') and contains(., 'm done')]";
    String YOUR_FUNDING_CANCEL_XPATH = "//a[contains(., 'CANCEL')]";

//    IYourFundingSection clickSingleYes();
//    IYourFundingSection clickSingleNo();
//    IYourFundingSection clickCoupleYes();
//    IYourFundingSection clickCoupleNo();

    IYourFundingSection selectFundsSource(String fundsSource);
//    IYourFundingSection typeFundsSourceDescription(String fundsSource, String fundsSourceDescription);
//    IYourFundingSection typeFundsSourceAmount(String fundsSource, String fundsSourceAmount);
//    void typePanelFundsSourceAmount(String indexFundsSource, String fundsSourceAmount);
//    String getPanelFundsSourceInputAmount(String indexFundsSource);
//    String getPanelFundsSourceType(String indexFundsSource);
//    String getPanelFundsSourceOwner(String indexFundsSource);
//    String getPanelFundsSourceLabelAmount(String indexFundsSource);

    IYourFundingSection typeGiftDescription(String description);
    IYourFundingSection typeGiftAmount(String amount);

    IYourFundingSection typeInheritanceDescription(String description);
    IYourFundingSection typeInheritanceAmount(String amount);

    IYourFundingSection typeOtherDescription(String description);
    IYourFundingSection typeOtherAmount(String amount);

    IYourFundingSection clickCancel();
    IYourFundingSection clickNext();
    IYourFundingSection clickAddFundsSource();
    IYourFundingSection clickAddThisFundsSource();

    String getTitle();
    String getDescription();

    IYourFundingSection checkFundingAppliesToBorrower(String borrower);
    IYourFundingSection checkFundingAppliedToCoapplicant(String coapplicant);

}
