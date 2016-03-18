package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

public interface IGetStartedMortgageSection {
//    "//div[contains(@wicketpath. 'Title') and contains(., \"Let's get you a great mortgage, Tonda\")]"
    String GET_MORTGAGE_TITLE_XPATH = "//div[contains(@wicketpath. 'Title') and contains(., 'Let's get you a great mortgage, ${firstName}$')]";
    String CIRCLE_GET_APPROVAL_XPATH = "//div[contains(@wicketpath, 'circle-1') and contains(@class, 'black-circle') and contains(., '1')]";
    String CIRCLE_FIND_YOUR_HOME_XPATH = "//div[contains(@wicketpath, 'circle-2') and contains(@class, 'black-circle') and contains(., '2')]";
    String CIRCLE_CONFIGURE_YOUR_LOAN_XPATH = "//div[contains(@wicketpath, 'circle-3') and contains(@class, 'black-circle') and contains(., '3')]";
    String CIRCLE_FINAL_LOAN_SETUP_XPATH = "//div[contains(@wicketpath, 'circle-4') and contains(@class, 'black-circle') and contains(., '4')]";
    String TEXT_GET_APPROVAL_XPATH = "//div[contains(@wicketpath, 'text1') and contains(@data-path, 'text1') and contains(., 'Get approval')]";
    String TEXT_FIND_YOUR_HOME_XPATH = "//div[contains(@wicketpath, 'text2') and contains(@data-path, 'text2') and contains(., 'Find your home')]";
    String TEXT_CONFIGURE_YOUR_LOAN_XPATH = "//div[contains(@wicketpath, 'text3') and contains(@data-path, 'text3') and contains(., 'Configure your loan')]";
    String TEXT_FINAL_LOAN_SETUP_XPATH = "//div[contains(@wicketpath, 'text4') and contains(@data-path, 'text4') and contains(., 'Final loan setup')]";

    String GET_STARTED_BUTTON_XPATH = "//a[contains(@wicketpath, 'GetStarted') and contains(., 'Get started')]";

    void clickGetStarted();
}
