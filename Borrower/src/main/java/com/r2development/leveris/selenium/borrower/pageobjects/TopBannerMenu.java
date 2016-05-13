package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

/**
 * todo Page Object Specific Implementation
 */
public class TopBannerMenu extends Borrower implements ITopBannerMenu {

    private static final Log log = LogFactory.getLog(TopBannerMenu.class.getName());

    WebDriver webDriver;

    //    @Inject
    public TopBannerMenu(SharedDriver webDriver) {
        super(webDriver);
        isVisible(TOP_BANNER_SIGN_IN_XPATH, true);
        isVisible(TOP_BANNER_REGISTER_XPATH, true);
        isVisible(TOP_BANNER_CHAT_NOW_XPATH, true);

    }

    @Override
    public ITopBannerMenu clickSignIn() {
        clickElement(TOP_BANNER_SIGN_IN_XPATH);
        return this;
    }

    @Override
    public ITopBannerMenu clickRegister() {
        clickElement(TOP_BANNER_REGISTER_XPATH);
        return this;
    }

    @Override
    public ITopBannerMenu clickChatNow() {
        clickElement(TOP_BANNER_CHAT_NOW_XPATH);
        return this;
    }
}