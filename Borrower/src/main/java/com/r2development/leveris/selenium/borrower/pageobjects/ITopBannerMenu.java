package com.r2development.leveris.selenium.borrower.pageobjects;

public interface ITopBannerMenu {

    String
            DIV = "//div",
            A = "//a",
            SPAN = "/span",
            MENU_WRAPER_WICKET = "[contains(@wicketpath,'initialMenuWrapper')]",
            SIGN_IN_WICKET = "[contains(@wicketpath,'Menu_root_item_1')]",
            REGISTER_WICKET = "[contains(@wicketpath,'Menu_root_item_2')]",
            CHAT_NOW_WICKET = "[contains(@wicketpath,'Menu_root_item_3')]",
            LINK_TEXT_WICKET = "[contains(@wicketpath,'linkText')]",

            TEXT_SIGN_IN = "[text()='Sign in']",
            TEXT_REGISTER = "[text()='Register']",
            TEXT_CHAT_NOW = "[text()='Chat Now']",

            TOP_BANNER_SIGN_IN_XPATH = DIV + MENU_WRAPER_WICKET + A + SIGN_IN_WICKET + SPAN + LINK_TEXT_WICKET + TEXT_SIGN_IN,
            TOP_BANNER_REGISTER_XPATH = DIV + MENU_WRAPER_WICKET + A + REGISTER_WICKET + SPAN + LINK_TEXT_WICKET + TEXT_REGISTER,
            TOP_BANNER_CHAT_NOW_XPATH = DIV + MENU_WRAPER_WICKET + A + CHAT_NOW_WICKET + SPAN + LINK_TEXT_WICKET + TEXT_CHAT_NOW;

    ITopBannerMenu clickSignIn();
    ITopBannerMenu clickRegister();
    ITopBannerMenu clickChatNow();
}