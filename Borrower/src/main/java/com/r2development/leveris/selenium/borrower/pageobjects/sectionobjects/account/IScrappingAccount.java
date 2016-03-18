package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.account;

/**
 * Created by anthonymottot on 17/03/2016.
 */
public interface IScrappingAccount {

    String YOUR_ACCOUNTS_SCRAPING_CLOSE_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnl-608_c_w_btnClose_cancel']";

    void closeScraping();
}
