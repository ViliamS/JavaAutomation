package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

public interface IBuildQuoteSection3 {

    String BUILD_QUOTE3_STEP3_XPATH = "//div[contains(@wicketpath, 'form_root') and contains(@class, 'sc-label') and contains(., 'Step 3 of 3')]";
    String BUILD_QUOTE3_EDIT_DETAILS_XPATH = "//a[contains(@class, 'details') and contains(., 'EDIT YOUR DETAILS')]";
    String BUILD_QUOTE3_EMAIL_QUOTE_XPATH = "//a[contains(., 'E-MAIL QUOTE')]";
    String BUILD_QUOTE3_APPLY_NOW_XPATH = "//a[contains(@class, 'apply') and contains(., 'Apply now')]";

    String getCurrentStep();
    void clickApplyNow();
    void clickEmailQuote();
    void clickEditDetails();
    boolean isLoaded();
}
