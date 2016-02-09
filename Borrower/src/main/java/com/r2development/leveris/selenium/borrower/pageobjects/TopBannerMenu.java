package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * todo Page Object Specific Implementation
 */
public class TopBannerMenu extends Borrower implements ITopBannerMenu {

    private static final Log log = LogFactory.getLog(TopBannerMenu.class.getName());

    @FindBy(xpath = TOP_BANNER_SIGN_IN_XPATH)
    protected WebElement weSignIn;

    @FindBy(xpath = TOP_BANNER_REGISTER_XPATH)
    protected WebElement weRegister;

    @FindBy(xpath = TOP_BANNER_CHAT_NOW_XPATH)
    protected WebElement weChatNow;

    public TopBannerMenu(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        checkPage();
    }

    public TopBannerMenu checkPage(){
        weSignIn.isDisplayed();
        weRegister.isDisplayed();
        weChatNow.isDisplayed();
        return this;
    }

    @Override
    public TopBannerMenu signIn(){
        weSignIn.click();
        return this;
    }

    @Override
    public TopBannerMenu register(){
        weRegister.click();
        return this;
    }

    @Override
    public TopBannerMenu chatNow(){
        weChatNow.click();
        return this;
    }
}
