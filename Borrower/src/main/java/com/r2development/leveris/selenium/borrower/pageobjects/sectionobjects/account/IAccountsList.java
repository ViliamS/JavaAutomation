package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.account;

import com.r2development.leveris.selenium.borrower.pageobjects.IYourDependantsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;

/**
 * Created by anthonymottot on 18/03/2016.
 */
public interface IAccountsList {

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkCurrent_dialog']";
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkSavings_dialog']";
    String YOUR_ACCOUNTS_ACCOUNT_SCRAPING_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkAuto_dialog']";

    String getTitle();
    String getDescription();

    IForm selectAccountType(String accountType);
    IForm clickCurrentAccount();
    IForm clickSavingsAccount();
    IForm clickAccountScraping();

    IYourDependantsPage clickDone();

}
