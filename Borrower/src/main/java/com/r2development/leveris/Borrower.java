package com.r2development.leveris;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class Borrower /*implements IBorrower*/ {

    private static final Log log = LogFactory.getLog(Borrower.class.getName());

//    @Inject
    protected SharedDriver /*final*/ webDriver;

//    @Inject
    protected Borrower(SharedDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final int DEFAULT_TIMEOUT = 30;

//    protected final String INDICATOR_BIG_OFF = "//div[@id='busyIndicatorBig' and @class='busy-indicator-big' and @style='display: none']";
//    protected final String INDICATOR_BIG_ON = "//div[@id='busyIndicatorBig' and @class='busy-indicator-big' and @style='display: block']";

    protected final String INDICATOR_SMALL_OFF = "//div[@wicketpath='wicketpath' and @id='busyIndicator1a0' and @style='display: none']";
    protected final String INDICATOR_SMALL_ON = "//div[@wicketpath='wicketpath' and @id='busyIndicator1a0' and @style='display: block']";

    protected final Integer[] scrollDown = {50, 0};

    protected final String EXCEPTION_THERE_ARE_ERROR_ITEMS_XPATH = "//div[@wicketpath='main_c_form_dialogWrapper_dialog_feedbackBox1']/div[@class='errorbox']/ul/li/div";

    private String getExceptionText(){
        isVisible(EXCEPTION_THERE_ARE_ERROR_ITEMS_XPATH, 5);
        return getText(EXCEPTION_THERE_ARE_ERROR_ITEMS_XPATH);
    }

    protected void formSubmitPostSync(String xpathWaitToDisappear, String xpathOfExceptionDialog, Map<String, String> exceptionTexts) {
        log.info("formSPSEE ----> ");
        try {
            isNotVisible(xpathWaitToDisappear, true, 5);
            log.info("formSPSEE ---> \n" +
                    "Passed isNotVisible('" + xpathWaitToDisappear  + "')");
        } catch (Exception x) {
            log.info("formSPSEE ---> \n" +
                    "Failed isNotVisible('" + xpathWaitToDisappear  + "')");
            log.info(exceptionTexts.get("FormName"));
            if (isVisible(xpathWaitToDisappear, 1) && isVisible(xpathOfExceptionDialog, 1)) {
                log.info(exceptionTexts.get("GetExceptionResult1") + getExceptionText() + exceptionTexts.get("GetExceptionResult2"));
                Assert.assertTrue(exceptionTexts.get("FormAction"), false);
            }
        }
    }

    protected void formSubmitPostSync(String xpathWaitToDisappear, Map<String, String> exceptionTextDisplayedIfFieldStillPresent) {
        formSubmitPostSync(xpathWaitToDisappear, EXCEPTION_THERE_ARE_ERROR_ITEMS_XPATH, exceptionTextDisplayedIfFieldStillPresent);
    }

    protected final String
            ANY_LOADING_OVERLAY = "//div[contains(@id,'busyIndicator') or contains(@class,'dblclick-fix-layer') or contains(@id,'initialMenuWrapper')][contains(@style,'display:block') or contains(@style,'display: block')]",
            BUSY_INDICATOR_BLOCK = "//div[@id='busyIndicatorBig'][contains(@style,'display:block')][not(contains(@style,'display:none'))]",
            BUSY_INDICATOR_BLOCK2 = "//div[@wicketpath='busyIndicator'][contains(@style,'display: block')][not(contains(@style,'display: none'))]",
            BUSY_INDICATOR_BLOCK3 = "//div[@class='dblclick-fix-layer'][contains(@style,'display: block')][not(contains(@style,'display: none'))]",
            BUSY_INDICATOR_NONE = "//div[@id='busyIndicatorBig'][contains(@style,'display:none')][not(contains(@style,'display:block'))]",
            BUSY_INDICATOR_NONE2 = "//div[@wicketpath='busyIndicator'][contains(@style,'display: none')][not(contains(@style,'display: block'))]",
            BUSY_INDICATOR_NONE3 = "//div[@class='dblclick-fix-layer'][contains(@style,'display: none')][not(contains(@style,'display: block'))]";

    protected void loadingCheck(){
        for(int i = 0; i < 3; i++){
            if((i > 1) && (isLoadingBlock()))
                notLoading(i);
            if(isLoading())
                notLoading(i);
            if((i > 2) && (isLoadingBlock()))
                notLoading(i);
        }
    }

    private boolean isLoadingBlock(){
        return (isVisibleLoadingCheck(BUSY_INDICATOR_BLOCK, 0)) || (isVisibleLoadingCheck(BUSY_INDICATOR_BLOCK2, 0)) || (isVisibleLoadingCheck(BUSY_INDICATOR_BLOCK3, 0));
    }

    private boolean isLoading(){
        return isVisibleLoadingCheck(ANY_LOADING_OVERLAY, 0);
    }

    private void notLoading(int i){
        isVisibleLoadingCheck(BUSY_INDICATOR_NONE, (i==0 ? i: i-1));
        isVisibleLoadingCheck(BUSY_INDICATOR_NONE2, (i==0 ? i: i-1));
        isVisibleLoadingCheck(BUSY_INDICATOR_NONE3, (i==0 ? i: i-1));
    }

//    protected final String CALENDAR_XPATH_DONE =  "//div[@id='ui-datepicker-div' and contains(@style, 'display: block')]//button[contains(., 'Done')]";

//    private List<WebElement> findAllBy(String xpath) {
//        return webDriver.findElements(By.xpath(xpath));
//    }
    private List<WebElement> findAllBy(By locator) {
        return webDriver.findElements(locator);
    }

    private WebElement findBy(By locator) {
        return webDriver.findElement(locator);
    }

    private WebElement findBy(String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }

    protected WebElement getWebElement(By locator) {
        return findBy(locator);
    }

    protected WebElement getWebElement(String xpath) {
        log.info("\n getWebElement ---> xpath: " + xpath + "\n");
        waitForVisibility(xpath);
        return findBy(xpath);
    }

    protected WebElement getWebElement(String xpath, @SuppressWarnings("SameParameterValue") int timeout) {
        log.info("\n getWebElement ---> xpath: " + xpath + " with time-out: " + timeout + "\n");
        waitForVisibility(xpath, timeout);
        return findBy(xpath);
    }

    protected boolean getWebElementWithText(String xpath, @SuppressWarnings("SameParameterValue") String text, int timeout) {
        log.info("\n getWebElementWithText ---> xpath: " + xpath + " containing text: " + text + " with time-out: " + timeout + "\n");
        waitForVisibilityWithText(xpath, text, timeout);
        return true;
    }

    protected void sendKeysElement(@SuppressWarnings("SameParameterValue") String xpath, String text, @SuppressWarnings("SameParameterValue") int timeout) {
        new WebDriverWait(webDriver, timeout)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(By.xpath(xpath)).clear();
                        driver.findElement(By.xpath(xpath)).sendKeys(text);
                    } catch (WebDriverException wde) {
                        log.debug("\n sendKeysElement ---> xpath: " + xpath + " can't be found now \n");
                    }
                    return true;
                });
        log.info("\n sendKeysElement ---> xpath: " + xpath + " typing: '" + text + "'\n");
    }

    protected List<WebElement> getWebElements(String xpath) {
        log.info("Extracting all Element matching the xpath: " + xpath);
        return findAllBy(By.xpath(xpath));
    }

    protected void clickElement(String xpath) {
        new WebDriverWait(webDriver, 10)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(By.xpath(xpath)).click();
                    } catch (WebDriverException wde) {
                        log.debug("\n clickElement ---> xpath: " + xpath + " can't be found now \n");
                    }
                    return true;
                });
        log.info("click on element with xpath: " + xpath);
    }

    protected void clickElement(String xpath, boolean ignoreStateElementReferenceException, boolean ignoreWebDriverException) {

        FluentWait<WebDriver> wdw = new WebDriverWait(webDriver, 10);

        wdw.ignoring(StaleElementReferenceException.class);
        if ( ignoreWebDriverException ) wdw.ignoring(WebDriverException.class);
        if ( ignoreStateElementReferenceException ) wdw.ignoring(TimeoutException.class);

        wdw.until((WebDriver driver) -> {
            try {
                driver.findElement(By.xpath(xpath)).click();
            } catch (WebDriverException wde) {
                log.debug("\n clickElement ---> xpath: " + xpath + " can't be found now \n");
            }
            return true;
        });
        log.info("\n clickElement ---> xpath: " + xpath + "\n");
    }

    protected void clickElement(String xpath, @SuppressWarnings("SameParameterValue") String expectedClickableXpath) {
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(By.xpath(xpath)).click();
                        loadingCheck();
                    } catch (WebDriverException wde) {
                        log.debug("\n clickElement ---> xpath: " + xpath + " couldn't been found \n");
                    }
                    return true;
                });
        new WebDriverWait(webDriver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath(expectedClickableXpath)));
        log.info("\n clickElement ---> xpath: " + xpath + "and expect clickable xpath: " + expectedClickableXpath + "\n");
    }

    private void clickElement(By by) {
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(by).click();
                    } catch (WebDriverException wde) {
                        log.debug("\n clickElement ---> By: " + by.toString() + " couldn't been found \n");
                    }
                    return true;
                });
        log.info("\n clickElement ---> by: " + by.toString() + "\n");
    }

    protected void clickElement(By by, @SuppressWarnings("SameParameterValue") String expectedXpath) {
        log.info(("\n clickElement ---> xpath: " + by.toString() + " \n and ---> expected: " + expectedXpath));
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(by).click();
                        isVisible(expectedXpath, true);
                    } catch (WebDriverException wde) {
                        log.debug("\n clickElement ---> By: " + by.toString() + " couldn't been found or expectedXpath: " + expectedXpath + " couldn't been found \n");
                    }
                    return true;
                });
        log.info("click on element with by: " + by.toString());
    }

    protected void clickElementViaJavascript(String xpath, boolean toGoOn) {

        try {
            loadingCheck();
            isVisible(xpath, true, 0);
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click();", findBy(xpath));
//            if ( xpath.equals(IEmploymentIncomeSection.EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH))
//                isVisible("//div[@wicketpath='main_c_form_dialogWrapper']", true, 5);
            log.info(("\n clickElementViaJavascript ---> xpath: " + xpath + "\n"));
            loadingCheck();
        } catch ( NoSuchElementException | TimeoutException ignored) {
            log.info("Huston ! we have a problem !!!");
        }

    }

    protected void clickElementViaJavascript(String xpath) {

        boolean toGoOn = false;
        while(!toGoOn) {
            try {
                loadingCheck();
                isVisible(xpath, true, 0);
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", findBy(xpath));
                log.info(("\n clickElementViaJavascript ---> xpath: " + xpath + "\n"));
                loadingCheck();
                toGoOn = true;
            } catch ( NoSuchElementException | TimeoutException ignored) {
                log.info("Huston ! we have a problem !!!");
            }
        }

    }

    protected void clickElementViaJavascript(String xpath, String expectedXpath) {

        boolean toGoOn = false;
        while(!toGoOn) {
            try {
                loadingCheck();
                isVisible(xpath, true, 0);
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", findBy(xpath));
                log.info(("\n clickElementViaJavascript ---> xpath: " + xpath + " \n and ---> expectedXpath: " + expectedXpath) + "\n");
                loadingCheck();
                isVisible(expectedXpath, true, 0);
                toGoOn = true;
            } catch ( NoSuchElementException | TimeoutException ignored) {
                log.info("Huston ! we have a problem !!!");
            }
        }

    }

    protected String getText(String xpath) {
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath(xpath)).getText();
                    return true;
                });
        log.info("\n getText ---> xpath: " + xpath + "\n");
        return getWebElement(xpath).getText();
    }

//    protected String getText(WebElement webElement) {
//        return webElement.findElement(By.xpath(".")).getText();
//    }

//    protected String getText(WebElement webElement, String xpath) {
//        return webElement.findElement(By.xpath(xpath)).getText();
//    }

//    protected String getClassText(WebElement webElement, String xpath) {
//        return webElement.findElement(By.xpath(xpath)).getAttribute("class");
//    }

//    protected boolean getAttribute(WebElement webElement, String attributeName) {
//        log.info("Extracting attribute " + attributeName + " from the webElement " + webElement.toString());
//        return ( webElement.getAttribute(attributeName) != null ? true : false );
//    }

//    protected String getAttributeText(WebElement webElement, String attributeName) {
//        log.info("Extracting attribute value of " + attributeName + " from the webElement " + webElement.toString());
//        return ( webElement.getAttribute(attributeName) != null ? webElement.getAttribute(attributeName) : null);
//    }

    private void waitForVisibility(By locator) {
        log.info("\n waitForVisibility ---> locator: " + locator.toString() + "\n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForVisibility(By locator, int timeout_in_seconds) {
        log.info("\n waitForVisibility ---> locator: " + locator.toString() + " with time-out: '" + timeout_in_seconds + "'\n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForVisibility(String xpath) {
        log.info("\n waitForVisibility ---> xpath: '" + xpath + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForVisibilityLoadingCheck(String xpath, int timeout_in_seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForVisibility(String xpath, int timeout_in_seconds) {
        log.info("\n waitForVisibility ---> xpath: '" + xpath + "' <--- " + " with time-out: '" + timeout_in_seconds + "'\n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForVisibilityWithText(String xpath, String text, int timeout_in_seconds) {
        log.info("\n waitForVisibilityWithText ---> xpath: '" + xpath + "' <--- and on this text: " + text + " with time-out: '" + timeout_in_seconds + "'\n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
    }

    private void waitForInvisibility(By locator) {
        log.info("\n waitForInvisibility ---> locator: " + locator.toString() + "\n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    private void waitForInvisibility(By locator, int timeout_in_seconds) {
        log.info("\n waitForInvisibility ---> locator: " + locator.toString() + " with time-out: '" + timeout_in_seconds + "'\n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    private void waitForInvisibility(String xpath) {
        log.info("\n waitForInvisibility ---> xpath: " + xpath + " <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForInvisibility(String xpath, int timeout_in_seconds) {
        log.info("\n waitForInvisibility ---> xpath: " + xpath + " with time-out: '" + timeout_in_seconds + "'\n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForVisibilities(String xpath, int timeout_in_seconds) {
        log.info("\n waitForInvisibility ---> xpath: " + xpath + " with time-out: '" + timeout_in_seconds + "'\n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    protected boolean isInvisible(String xpath) {
        boolean toReturn = true;
        try {
            waitForInvisibility(xpath);
        } catch (TimeoutException te) {
            toReturn = false;
        }
//        finally {
//        }
        return toReturn;
    }

    protected boolean isInvisible(String xpath, boolean throwException) {
//        boolean toReturn = true;

        if (!throwException)
            return isInvisible(xpath);

        waitForInvisibility(xpath);
        return true;
    }

    protected boolean isInvisible(String xpath, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
//        boolean toReturn = true;
        try {
            waitForInvisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            return false;
        }
//        finally {
//        }
        return true;
    }

//    protected boolean isInvisible(By locator) {
//        boolean toReturn = true;
//        try {
//            waitForInvisibility(locator);
//        } catch (TimeoutException te) {
//            toReturn = false;
//        } finally {
//            return toReturn;
//        }
//    }

//    protected boolean isInvisible(By locator, int timeout_in_seconds) {
//        boolean toReturn = true;
//        try {
//            waitForInvisibility(locator, timeout_in_seconds);
//        } catch (TimeoutException te) {
//            toReturn = false;
//        } finally {
//            return toReturn;
//        }
//    }

    protected boolean isVisible(String xpath) {
        boolean toReturn = true;
        try {
            waitForVisibility(xpath);
        } catch (TimeoutException te) {
            toReturn = false;
        }
//        finally {
//        }
        return toReturn;
    }

    protected boolean isVisible(String xpath, boolean throwException) {
//        boolean toReturn = true;

        if (!throwException)
            return isVisible(xpath);

        waitForVisibility(xpath, 60);
        return true;
    }

    protected boolean isVisible(String xpath, boolean throwException, int timeout_in_seconds) {
//        boolean toReturn = false;

        if (!throwException)
            return isVisible(xpath, timeout_in_seconds);

        waitForVisibility(xpath, timeout_in_seconds);
        return true;
    }

    private boolean isVisibleLoadingCheck(String xpath, int timeout_in_seconds) {
//        boolean toReturn = true;
        try {
            waitForVisibilityLoadingCheck(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
//            toReturn = false;
            return false;
        }
//        } finally {
//        }
//        return toReturn;
        return true;
    }

    protected boolean isVisible(String xpath, int timeout_in_seconds) {
//        boolean toReturn = true;
        try {
            waitForVisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
//            toReturn = false;
            return false;
        }
//        } finally {
//        }
//        return toReturn;
        return true;
    }

    protected boolean isNotVisible(String xpath, @SuppressWarnings("SameParameterValue") boolean throwException, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
//        boolean toReturn = false;

        if (!throwException)
            return isNotVisible(xpath, timeout_in_seconds);

        waitForInvisibility(xpath, timeout_in_seconds);
        return true;
    }

    protected boolean isNotVisible(String xpath, int timeout_in_seconds) {
//        boolean toReturn = true;
        try {
            waitForInvisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
//            toReturn = false;
            return false;
        }

//      return toReturn;
        return true;
    }

    protected boolean areVisible(@SuppressWarnings("SameParameterValue") String xpath, @SuppressWarnings("SameParameterValue") boolean throwException, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
        boolean toReturn = true;

        if (throwException)
            return areVisible(xpath, timeout_in_seconds);

        try {
            waitForVisibilities(xpath, timeout_in_seconds);
        } catch(TimeoutException te) {
            toReturn = false;
        }
//        finally {
//        }
        return toReturn;
    }

    private boolean areVisible(String xpath, int timeout_in_seconds) {
//        boolean toReturn = true;
        waitForVisibilities(xpath, timeout_in_seconds);
        return true;
    }

//    protected boolean isVisible(By locator) {
//        boolean toReturn = true;
//        try {
//            waitForVisibility(locator);
//        } catch (TimeoutException te) {
//            toReturn = false;
//        } finally {
//            return toReturn;
//        }
//    }

//    protected boolean isVisible(By locator, int timeout_in_seconds) {
//        boolean toReturn = true;
//        try {
//            waitForVisibility(locator, timeout_in_seconds);
//        } catch (TimeoutException te) {
//            toReturn = false;
//        } finally {
//            return toReturn;
//        }
//    }

    protected void get(String url) {
        webDriver.get(url);
    }

    private void horizontalVerticalScroll(Integer[] horizontalAndVertical){
        if(horizontalAndVertical.length == 2)
            scroll(horizontalAndVertical[0], horizontalAndVertical[1]);
        else if (horizontalAndVertical.length == 1)
            scroll(horizontalAndVertical[0], 0);
    }

    private String moveToDropDownButton(String xpath, Integer[] horizontalAndVertical){
        loadingCheck();
        moveTo(By.xpath(xpath));
        horizontalVerticalScroll(horizontalAndVertical);
        String currentBy = xpath + "/following-sibling::button";
        waitForVisibility(currentBy);
        moveTo(currentBy);
        return currentBy;
    }

    private void clickOnDropDownToShowList(String xpath){
        loadingCheck();
        clickElement(xpath);
        loadingCheck();
    }

    private void clickOnDropDownToShowList(String xpath, boolean recall){
        if(recall){
            for(int i = 0; i < 5; i++) {
                if (!isVisible(xpath))
                    clickOnDropDownToShowList(xpath);
                isVisible(xpath, 2);
            }
        } else
            clickOnDropDownToShowList(xpath);
    }

    private void selectFromDisplayedDropDownList(String valueToSelect){
        final String DROP_DOWN_LIST = "//ul[contains(@style, 'display: block')]/li/a";
        String dropDownLocator = DROP_DOWN_LIST + "[.='" + valueToSelect + "']";
        waitForVisibility( dropDownLocator, DEFAULT_TIMEOUT );

        if(!isVisible(dropDownLocator))
            clickOnDropDownToShowList(dropDownLocator, true);

        moveTo( dropDownLocator );
        clickElement( dropDownLocator );
        loadingCheck();

    }

    protected void selectFromDropDown(String xpath, String valueToSelect, Integer[] horizontalVerticalScroll){
        log.info("\n selectFromDropDown: " + valueToSelect + " on ---> xpath: " + xpath + "\n");
        //By currentBy = moveToDropDownButton(xpath);
        //clickOnDropDownToShowList(currentBy)
         /**
          * that two rows above are redundant if compared to row below....
          * but row below is harder to read so keeping two rows above commented as hint
          */
        clickOnDropDownToShowList( moveToDropDownButton( xpath, horizontalVerticalScroll ) );
        horizontalVerticalScroll( horizontalVerticalScroll );
        selectFromDisplayedDropDownList( valueToSelect );
        loadingCheck();
    }

    protected void selectFromDropDown(String xpath, String valueToSelect) {
        log.info("\n selectFromDropDown: " + valueToSelect + " on ---> xpath: " + xpath + "\n");
        loadingCheck();
        moveTo(By.xpath(xpath));
        By currentBy = By.xpath(xpath + "/following-sibling::button");
        waitForVisibility(currentBy);
        moveTo(currentBy);
        clickElement(currentBy);
        loadingCheck();
        final String DROP_DOWN_LIST = "//ul[contains(@style, 'display: block')]/li/a";
//        final String DROP_DOWN_LIST = "//ul[@role='listbox'][not(contains(@style,'display: none'))]/li[@class='ui-menu-item']/a";
        // or //ul[contains(@style, 'display: block')]/li/a
//        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[text()='" + valueToSelect + "']");
//        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[contains(.,'" + valueToSelect + "')]");
        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[.='" + valueToSelect + "']");
        waitForVisibility(dropDownLocator, DEFAULT_TIMEOUT);
        moveTo(dropDownLocator);
        clickElement(dropDownLocator);
        loadingCheck();
    }

    protected void selectFromDropDownIncludingBold(String xpath, String valueToSelect) {
        log.info("\n selectFromDropDownIncludingBold: " + valueToSelect + " on ---> xpath: " + xpath + "\n");
        By currentBy = By.xpath(xpath + "/following-sibling::button");
        loadingCheck();
        waitForVisibility(currentBy);
        moveTo(currentBy);
        clickElement(currentBy);
        loadingCheck();
        final String DROP_DOWN_LIST = "//ul[contains(@style, 'display: block')]/li/a/b";
//        final String DROP_DOWN_LIST = "//ul[@role='listbox'][not(contains(@style,'display: none'))]/li[@class='ui-menu-item']/a";
        // or //ul[contains(@style, 'display: block')]/li/a
        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[text()='" + valueToSelect + "']");
//        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[contains(.,'" + valueToSelect + "')]");
//        waitForVisibility(dropDownLocator, DEFAULT_TIMEOUT);
        moveTo(dropDownLocator);
        clickElement(dropDownLocator);
        loadingCheck();
    }

    protected void type(String xpath, String valueToType) {
        log.info("\n type: " + valueToType + " to ---> xpath: " + xpath + "\n");
        By currentBy = By.xpath(xpath);
        waitForVisibility(currentBy);
        moveTo(currentBy);
//        webDriver.findElement(currentBy).clear();
        webDriver.findElement(currentBy).sendKeys(valueToType);
//        webDriver.findElement(currentBy).sendKeys(Keys.ENTER);
        log.info("type on element with xpath: " + xpath + " \n and type a value: '" + valueToType + "'");
    }

    protected void type(String xpath, String valueToType, boolean sendKeyEnter) {
        if(sendKeyEnter)
        // type(xpath, valueToType, "ENTER");
        type(xpath, valueToType, Keys.ENTER);
        else
        type(xpath, valueToType);
    }

    protected void typeEndWithTab(String xpath, String valueToType, boolean sendKeyTab) {
        if(sendKeyTab)
            type(xpath, valueToType, "TAB");
        else
            type(xpath, valueToType);
    }

    protected void type(String xpath, String valueToType, String sendKeyType) {
        log.info("\n type: " + valueToType + " to ---> xpath: " + xpath + "' \n and hitting a key = '" + sendKeyType + "'\n");

        if ( !StringUtils.isEmpty(sendKeyType) )
            type(xpath, valueToType, Keys.valueOf(sendKeyType));
        else
            type(xpath, valueToType);
    }

    protected void type(String xpath, String valueToType, Keys sendKeyType){
        log.info("\n type: " + valueToType + " to ---> xpath: " + xpath + "' \n and hitting a key = '" + sendKeyType.toString() + "'\n");
        By currentBy = By.xpath(xpath);
        waitForVisibility(currentBy);
        moveTo(currentBy);
        webDriver.findElement(currentBy).sendKeys(valueToType);
        /*        if ( sendKeyType.equalsIgnoreCase("ENTER") ) {
            log.info("sendKeys Enter");
            webDriver.findElement(currentBy).sendKeys(Keys.ENTER);
        }

        if ( sendKeyType.equalsIgnoreCase("TAB") ){
            log.info("sendKeys TAB");
            webDriver.findElement(currentBy).sendKeys(Keys.TAB);
        }*/
        if ( !StringUtils.isEmpty(sendKeyType) ) {
            log.info("sendKeys " + sendKeyType + "");
            sendKeysKeyType(currentBy, sendKeyType);
        }
    }

    private void sendKeysKeyType(String xpath, Keys sendKeyType){
        sendKeysKeyType(By.xpath(xpath), sendKeyType);
    }

    private void sendKeysKeyType(By currentBy, Keys sendKeyType){
        log.info("\n -------------------------------------- \n | sendKeysKeyType | \n byLocator ---> " + currentBy.toString() + " <--- | \n -------------------------------------- \n");
        webDriver.findElement(currentBy).sendKeys(sendKeyType);
    }

    protected void scroll(int vertical, @SuppressWarnings("SameParameterValue") int horizontal) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("scroll(" + vertical + "," + horizontal + ")");
    }

    /**
     * Method is simulating hovering of an cursor over an element
     *
     * @param by - By object providing an target locator to set focus on
     */
    private void moveTo(By by) {
        new Actions(webDriver).moveToElement(webDriver.findElement(by)).perform();
    }

    protected void moveTo(String xpath) {
        new Actions(webDriver).moveToElement(webDriver.findElement(By.xpath(xpath))).perform();
    }

    protected void moveTo2(@SuppressWarnings("SameParameterValue") String xpath) {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.xpath(xpath)));
    }

//    public void click(String xpath) {
//        webDriver.findElement(By.xpath(xpath)).click();
//        log.info("click on xpath: " + xpath);
//
//    }

//    private void click(By by) {
//        webDriver.findElement(by).click();
//    }

    protected void checkAlert() {
        loadingCheck();
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 0);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
        loadingCheck();
    }
}
