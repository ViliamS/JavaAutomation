package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeGetQuoteSection extends Borrower implements IWelcomeGetQuoteSection {

    private static final Log log = LogFactory.getLog(WelcomeGetQuoteSection.class);

    @FindBy( xpath = MOTTO_XPATH )
    protected WebElement weMotto;

    @FindBy( xpath = GET_QUOTE_NOW_BUTTON_XPATH )
    protected WebElement weGetQuoteNow;

    @FindBy( xpath = CLOSE_XPATH )
    protected WebElement weClose;

//    @Inject
    public WelcomeGetQuoteSection(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public void clickGetQuoteNow() {
        try {
            isVisible(GET_QUOTE_NOW_BUTTON_XPATH, true, 5);
            weGetQuoteNow.click();
        }
        catch(Exception e) {
//            isVisible(GET_QUOTE_NOW_BUTTON_XPATH, true);
//            getWebElement(GET_QUOTE_NOW_BUTTON_XPATH).click();
            clickElement(GET_QUOTE_NOW_BUTTON_XPATH);
        }
    }

    @Override
    public boolean isLoaded() {
//        isVisible(MOTTO_XPATH, true);
        isVisible(GET_QUOTE_NOW_BUTTON_XPATH, true);
        return true;
    }

    @Override
    public IWelcomePage closeWelcomeQuote() {
        isVisible(CLOSE_XPATH, true);
        weClose.click();
        return new WelcomePage(webDriver);
    }
}
