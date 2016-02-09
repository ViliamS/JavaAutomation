package com.r2development.leveris.selenium.borrower.pageobjects;

public interface ITopBannerMenu {

    String      TOP_BANNER_SIGN_IN_XPATH = "",
                TOP_BANNER_REGISTER_XPATH = "",
                TOP_BANNER_CHAT_NOW_XPATH = "";

    TopBannerMenu signIn();

    TopBannerMenu register();

    TopBannerMenu chatNow();

}
