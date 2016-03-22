package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.selenium.borrower.pageobjects.IWelcomePage;

public interface IWelcomeGetQuoteSection {
    String CLOSE_XPATH = "//a[contains(., 'X')]";
//    No mortgage will ever be perfect, but we're very very close.
    String MOTTO_XPATH = "//div[contains(@wicketpath, 'Welcome') and contains(@class, 'sc-label')]//";
    String GET_QUOTE_NOW_BUTTON_XPATH = "//a[contains(., 'Get a quote now')]";
    //a[contains(., 'LET') and contains(., 'S GO')]"
    //a[contains(., 'Get one now')]"

//    void clickGetOneNow();
//    void clickLetsGo()
    void clickGetQuoteNow();
    boolean isLoaded();
    IWelcomePage closeWelcomeQuote();
}
