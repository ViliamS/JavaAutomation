package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

public interface IBottomSection {
    String CONTACT_US_LINK_XPATH = "//a[@href='form/mi/contact' and @title='Contact Us' and contains(., 'Contact Us')]";
    String HELP_CENTER_LINK_XPATH = "//a[@href='form/mi/help' and @title='Help Center' and contains(., 'Help Center')]";
    String WHAT_ELSE_LINK_XPATH = "//a[@href='form/mi/else' and @title='What Else?' and contains(., 'What Else?')]";
    String LEGALS_TERMS_LINK_XPATH = "//a[@href='form/mi/legal' and @title='Legals/Terms?' and contains(., 'Legals/Terms?')]";
    String GOV_AND_INC_REGULARITY_XPATH = "//span[@class='text' and contains(., 'Bank of Ireland')]";

    void clickContactUs();
    void clickHelpCenter();
    void clickWhatElse();
    void clickLegalTerm();
    boolean isLoaded();
}
