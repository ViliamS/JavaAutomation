package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IBuildQuoteSection2 {
    String BUILD_QUOTE2_BACK_XPATH = "//a[contains(., 'Back')]";
    String BUILD_QUOTE2_STEP2_XPATH = "//div[contains(@wicketpath, 'Step') and contains(@class, 'sc-label') and contains(., 'Step 2 of 3')]";
    String BUILD_QUOTE2_TITLE_XPATH = "//div[contains(@wicketpath, 'Title') and contains(., 'Based on your figures, you could buy a home up to the value of:')]";
    String BUILD_QUOTE2_HOUSE_LOC_XPATH = "//div[contains(@wicketpath, 'Affordability') and contains(@wicketpath, 'HouseLoc')]";
    String BUILD_QUOTE2_EDIT_XPATH = "//a[contains(., 'EDIT')]";
    String BUILD_QUOTE2_CONFIGURE_LOAN_XPATH = "//a[contains(., 'Configure your loan')]";

    String BUILD_QUOTE2_AFFORDABILITY_AMOUNT_XPATH = "//div[contains(@data-path,'pnlAffordability lblBasedOn')]//b[position()=1]";
    String BUILD_QUOTE2_AFFORDABILITY_MONTHLY_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlAffordability_c_w_pnlValues_c_w_lblMonthlyValue_l']//span";
    String BUILD_QUOTE2_AFFORDABILITY_FUNDS_XPATH = "//div[contains(@data-path,'pnlAffordability lblBasedOn')]//b[position()=2]"; //label[contains(., 'Your funds')]/following-sibling::input";

    String BUILD_QUOTE_NOT_ELIGIBLE_XPATH = "//div[contains(@data-path, 'lblNotEligible') and contains(., 'Sorry, you`re not eligible to borrow at this time')]";

    void clickEdit();
    void clickConfigureLoan();
    boolean isLoaded();
    String getAffordabilityAmount();
    String getAffordabilityMonthly();
    String getAffordabilityFunds();
    boolean isEligible();
}
