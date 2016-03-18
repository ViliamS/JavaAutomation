package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

public interface ISubMenuSection {
    String SUB_MENU_SECTION_XPATH = "//div[@class='portlet-submenu']";
    String SUB_MENU_SECTION_LINKS_XPATH = SUB_MENU_SECTION_XPATH + "/a";
    String SUB_MENU_GET_APPROVAL_XPATH = SUB_MENU_SECTION_XPATH + "/a[contains(., 'Get approval')]";
    String SUB_MENU_FIND_YOUR_DREAM_HONE_XPATH = SUB_MENU_SECTION_XPATH + "/a[contains(., 'Find your dream home')]";
    String SUB_MENU_CONFIGURE_YOUR_LOAN_XPATH = SUB_MENU_SECTION_XPATH + "/a[contains(., 'Configure your loan')]";
    String SUB_MENU_FINAL_LOAN_SETUP_XPATH = SUB_MENU_SECTION_XPATH + "/a[contains(., 'Final loan setup')]";

    void clickGetApproval();
    void clickFindDreamHome();
    void clickConfigureLoan();
    void clickFinalLoanSetup();
}
