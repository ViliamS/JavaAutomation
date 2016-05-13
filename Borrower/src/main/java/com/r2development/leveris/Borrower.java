package com.r2development.leveris;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.utils.XpathBuilder.Enums.*;
import com.r2development.leveris.utils.XpathBuilder.XPathValues;
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

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public class Borrower {

    private static final Log log = LogFactory.getLog(Borrower.class.getName());

    protected SharedDriver /*final*/ webDriver;

    protected Borrower(SharedDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final int DEFAULT_TIMEOUT = 30;

    protected final String INDICATOR_SMALL_OFF = "//div[@wicketpath='wicketpath' and @id='busyIndicator1a0' and @style='display: none']";
    protected final String INDICATOR_SMALL_ON = "//div[@wicketpath='wicketpath' and @id='busyIndicator1a0' and @style='display: block']";
    protected final Integer scrollHorizontal = 50;
    protected final Integer scrollVertical = 0;
    protected final String EXCEPTION_THERE_ARE_ERROR_ITEMS_XPATH = "//div[@wicketpath='main_c_form_dialogWrapper_dialog_feedbackBox1']/div[@class='errorbox']/ul/li/div";
    protected final String

            LIST_OF_RESULTS = getXPath(ELEMENTS.UL, ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: block") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.LI, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "ui-menu-item") + getXPath_DirectSibling(ELEMENTS.A),

            HIDDEN = getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "none") + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "block"),
            VISIBLE = getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "block") + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "none"),

            LOADING_OVERLAY = getXPath(ELEMENTS.DIV, ACTIONS.OR_CONTAINS, ATTRIBUTES.CLASS, new XPathValues("busy-indicator-big", "busyIndicator", "dblclick-fix-layer")),

            ANY_LOADING_OVERLAY = LOADING_OVERLAY + VISIBLE,
            NONE_LOADING_OVERLAY = LOADING_OVERLAY + HIDDEN;

    protected void loadingCheck() {
//        log.info("loadingCheck");
            for (int i = 0; i < 5; i++) {
//                log.info("******* loadingCheck( i ---> '" + i + "' <---- *******");
                if ((i > 1) && (isLoadingBlock()))
                    notLoading(i);
                if (isLoading())
                    notLoading(i);
                if ((i > 2) && (isLoadingBlock()))
                    notLoading(i);
            }
    }

    private boolean isLoadingBlock() {
        return (isVisibleLoadingCheck(ANY_LOADING_OVERLAY, 0));
    }

    private boolean isLoading() {
        return isVisibleLoadingCheck(ANY_LOADING_OVERLAY, 0);
    }

    private void notLoading(int i) {
        if(isVisibleLoadingCheck(ANY_LOADING_OVERLAY, 0)) {
            isVisibleLoadingCheck(NONE_LOADING_OVERLAY, (i == 0 ? i : i - 1));
        }
    }

    private boolean isVisibleLoadingCheck(String xpath, int timeout_in_seconds) {
        try {
            waitForVisibilityLoadingCheck(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
//            log.info("\n \n isVisibleLoadingCheck ---> TimeoutException \n \n ");
            return false;
        }
        return true;
    }

    private void waitForVisibilityLoadingCheck(String xpath, int timeout_in_seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    protected void waitForClickable(String xpath) {
        log.info("\n waitForClickable(String xpath ---> '"+ xpath +"')");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    protected void waitForClickable(String xpath, int timeOut) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    /** Means element is become invisible but present in code */
    protected boolean clickToDissapear(String xpathToClick, String xpathToDissapear){
        return clickToAppearDisappear(xpathToClick, null, xpathToDissapear);
    }

    /** Means that element is Visible on Page */
    protected boolean clickToAppear(String xpathToClick, String xpathToAppear){
        return clickToAppearDisappear(xpathToClick, xpathToAppear, null);
    }

    //todo it is not tested yet just a blindly coded draft
    protected boolean clickToAppearDisappear(String xpathToClick, String xpathToAppear, String xpathToDisappear) {
        log.info("\n clickToAppearDisappear(String xpathToClick = '" + xpathToClick + "', String xpathToAppear = '" + xpathToAppear + "', String xpathToDisappear = '" + xpathToDisappear + "')");
        isVisible(xpathToClick, true, 5);
        clickElement(xpathToClick);
        if (isPresent(xpathToAppear, 5) && isNotVisible(xpathToDisappear, 5)) {
            log.info("clickToAppearDisappear() have PASSED vybordelne!");
            return true;
        } else if (!isPresent(xpathToAppear, 5) && xpathToAppear!=null) {
            log.info("\n !!!! FAILED !!!! \n clickToAppearDisappear() Failed due to ---> xpath : '" + xpathToAppear + "' <--- \n Element didn't Appeared");
            return false;
        } else if (!isNotVisible(xpathToDisappear, 5) && xpathToDisappear != null) {
            log.info("\n !!!! FAILED !!!! \n clickToAppearDisappear() Failed due to ---> xpath : '" + xpathToDisappear + "' <--- \n" +
                    " Element is still visible!");
            return false;
        }
        return false;
    }

    /**
     * Java Time Since the Epoch
     */
    protected long fromEpoch() {
        return (System.currentTimeMillis() / 1000);
    }

    protected String userNameTimeStamping(String userName, boolean isGui) {
        if (isGui) {
            return userNameTimeStamping(userName, "gui");
        } else {
            return userNameTimeStamping(userName, "api");
        }
    }

    protected String userNameTimeStamping(String userName, String testType) {
        String[] userNameArray = userName.split("@");
        String timestamp = System.getProperty("timestamp");
//        timestamp = timestamp.substring(timestamp.length() - 5, timestamp.length()); //yyyyMMddHHmmssSSS
        userName = userNameArray[0] + "." + testType + timestamp + "@" + userNameArray[1];
        return userName;
    }


    private String userNameTimeStamping(String userName) {
        return userNameTimeStamping(userName, "gui");
    }

    private String getExceptionText() {
        isVisible(EXCEPTION_THERE_ARE_ERROR_ITEMS_XPATH, 5);
        return getText(EXCEPTION_THERE_ARE_ERROR_ITEMS_XPATH);
    }

    protected void formSubmitPostSync(String xpathWaitToDisappear, String xpathOfExceptionDialog, Map<String, String> exceptionTexts) {
        log.info("formSubmitPostSync(String xpathWaitToDisappear, String xpathOfExceptionDialog, Map<String, String> exceptionTexts) ----> ");
        try {
            isNotVisible(xpathWaitToDisappear, true, 0);
            log.info("formSubmitPostSync ---> \n" +
                    "Passed isNotVisible('" + xpathWaitToDisappear + "')");
        } catch (Exception x) {
            log.info("formSubmitPostSync ---> \n" +
                    "Failed isNotVisible('" + xpathWaitToDisappear + "')");
        }
    }

    protected void formSubmitPostSync(String xpathWaitToDisappear, Map<String, String> exceptionTextDisplayedIfFieldStillPresent) {
        formSubmitPostSync(xpathWaitToDisappear, EXCEPTION_THERE_ARE_ERROR_ITEMS_XPATH, exceptionTextDisplayedIfFieldStillPresent);
    }

    private List<WebElement> findAllBy(By locator) {
        log.info("");
        return webDriver.findElements(locator);
    }

    private WebElement findBy(By locator) {
        log.info("");
        return webDriver.findElement(locator);
    }

    private WebElement findBy(String xpath) {
        log.info("");
        return webDriver.findElement(By.xpath(xpath));
    }

    protected WebElement getWebElement(By locator) {
        log.info("");
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
        log.info("\n sendKeysElement ---> xpath: " + xpath + " \n typing: '" + text + "'\n");
        new WebDriverWait(webDriver, timeout)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(By.xpath(xpath)).clear();
                        driver.findElement(By.xpath(xpath)).sendKeys(text);
                    } catch (WebDriverException wde) {
                        log.debug("\n sendKeysElement ---> xpath: " + xpath + " can't be found now \n");
                    }
                    return true;
                });
    }

    protected List<WebElement> getWebElements(String xpath) {
        log.info("Extracting all Element matching the xpath: " + xpath);
        return findAllBy(By.xpath(xpath));
    }

    protected void clickElementLoop(String xpath, String expectedClickableXpath) {
        log.info("\nclickElementLoop(\n xpath ---> '" + xpath + "', ' \n expectedClickableXpath --->" + expectedClickableXpath + "')");
        clickElement(xpath, expectedClickableXpath, 30);
        loadingCheck();
        try {
            isVisible(expectedClickableXpath, 1);
        } catch (Exception e) {
            boolean toGoOn = false;
            while (!toGoOn) {
                try {
                    clickElement(xpath, expectedClickableXpath, 15);
                    isVisible(expectedClickableXpath, 5);
                    toGoOn = true;
                } catch (TimeoutException e2) {
                    log.debug("Problem of clicking on Your Account Done or getting the Dependant title.");
                }
            }
        }
    }

    protected void clickElement(String xpath) {
        log.info("\nclickElementLoop(\n xpath ---> '" + xpath + "')");
        if (!System.getProperty("modeRun").equalsIgnoreCase(SharedDriver.PHANTOMJS)) {
            new WebDriverWait(webDriver, 10)
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver driver) -> {
                        try {
                            driver.findElement(By.xpath(xpath)).click();
                        } catch (WebDriverException wde) {
                            log.debug("\n clickElement ---> xpath: " + xpath + " can't be found now \n");
                        }
                        return true;
                    });
        } else {
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("document.querySelector('[id^=\"submit\"]').click()");
        }
    }

    protected void clickElement(String xpath, boolean ignoreStateElementReferenceException, boolean ignoreWebDriverException) {
        log.info("\n clickElement ---> xpath: " + xpath + "\n");
        FluentWait<WebDriver> wdw = new WebDriverWait(webDriver, 10);
        wdw.ignoring(StaleElementReferenceException.class);
        if (ignoreWebDriverException) wdw.ignoring(WebDriverException.class);
        if (ignoreStateElementReferenceException) wdw.ignoring(TimeoutException.class);
        wdw.until((WebDriver driver) -> {
            try {
                driver.findElement(By.xpath(xpath)).click();
            } catch (WebDriverException wde) {
                log.debug("\n clickElement ---> xpath: " + xpath + " can't be found now \n");
            }
            return true;
        });
    }

    protected void clickElement(String xpath, @SuppressWarnings("SameParameterValue") String expectedClickableXpath) {
        clickElement(xpath, expectedClickableXpath, 60);
    }

    protected void clickElement(String xpath, @SuppressWarnings("SameParameterValue") String expectedClickableXpath, int timeOut) {
        log.info("\n clickElement ---> xpath: " + xpath + "and expect clickable xpath: " + expectedClickableXpath + "\n");
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(By.xpath(xpath)).click();
                        isVisible(expectedClickableXpath, true);
                    } catch (WebDriverException wde) {
                        log.debug("\n clickElement ---> xpath: " + xpath + " couldn't been found \n");
                    }
                    return true;
                });
        new WebDriverWait(webDriver, timeOut).until(ExpectedConditions.elementToBeClickable(By.xpath(expectedClickableXpath)));
    }

    private void clickElement(By by) {
        log.info("\n clickElement ---> by: " + by.toString() + "\n");
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(by).click();
                    } catch (WebDriverException wde) {
                        log.debug("\n clickElement ---> By: " + by.toString() + " couldn't been found \n");
                    }
                    return true;
                });
    }

    protected void clickElement(By by, @SuppressWarnings("SameParameterValue") String expectedXpath) {
        log.info(("\n clickElement ---> xpath: " + by.toString() + " \n and ---> expected: " + expectedXpath));
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(by).click();
                        isVisible(expectedXpath, true);
                    } catch (WebDriverException wde) {
                        log.debug("\n clickElement ---> By: " + by.toString() + " couldn't been found or expectedXpath: " + expectedXpath + " couldn't been found \n");
                    }
                    return true;
                });
    }

    protected void clickElementViaJavascript(String xpath, boolean toGoOn) {
        log.info(("\n clickElementViaJavascript ---> xpath: " + xpath + "\n"));
        try {
            isVisible(xpath, true, 0);
            //noinspection RedundantCast
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click();", findBy(xpath));
        } catch (NoSuchElementException | TimeoutException ignored) {
            log.info("Huston ! we have a problem !!!");
        }
    }

    protected void clickElementViaJavascript(String xpath) {
        log.info(("\n clickElementViaJavascript ---> xpath: " + xpath + "\n"));
        boolean toGoOn = false;
        while (!toGoOn) {
            try {
                isVisible(xpath, true, 0);
                //noinspection RedundantCast
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", findBy(xpath));
                toGoOn = true;
            } catch (NoSuchElementException | TimeoutException ignored) {
                log.info("Huston ! we have a problem !!!");
            }
        }
    }

    protected void clickElementViaJavascript(String xpath, String expectedXpath) {
        log.info(("\n clickElementViaJavascript ---> xpath: " + xpath + " \n and ---> expectedXpath: " + expectedXpath) + "\n");
        boolean toGoOn = false;
        while (!toGoOn) {
            try {
                isVisible(xpath, true, 0);
                //noinspection RedundantCast
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", findBy(xpath));
                isVisible(expectedXpath, true, 0);
                toGoOn = true;
            } catch (NoSuchElementException | TimeoutException ignored) {
                log.info("Huston ! we have a problem !!!");
            }
        }
    }

    protected String getText(String xpath) {
        log.info("\n getText ---> xpath: " + xpath + "\n");
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath(xpath)).getText();
                    return true;
                });
        return getWebElement(xpath).getText();
    }

    protected String getAttributeText(WebElement webElement, String attributeName) {
        log.info("Extracting attribute value of " + attributeName + " from the webElement " + webElement.toString());
        return (webElement.getAttribute(attributeName) != null ? webElement.getAttribute(attributeName) : null);
    }

    private void waitForPresence(String xPath) {
        log.debug("\n waitForVisibility(By locator) \n locator ---> '" + xPath + "' <--- \n");
        waitForPresence(By.xpath(xPath));
    }

    private void waitForPresence(String xPath, int timeOut) {
        log.debug("\n waitForVisibility(By locator) \n locator ---> '" + xPath + "' <--- \n");
        waitForPresence(By.xpath(xPath), timeOut);
    }

    private void waitForPresence(By locator) {
        log.debug("\n waitForPresence(By locator) \n locator ---> '" + locator.toString() + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private void waitForPresence(By locator, int timeOut) {
        log.debug("\n waitForPresence(By locator) \n locator ---> '" + locator.toString() + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected boolean isPresent(String xpath, int timeOut) {
        log.debug("\n isPresent(String xpath) \n xpath ---> '" + xpath + "' <--- \n");
        boolean toReturn = true;
        try {
            waitForPresence(xpath, timeOut);
        } catch (TimeoutException te) {
            toReturn = false;
        }
        return toReturn;
    }

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

    private void waitForVisibility(String xpath, int timeout_in_seconds) {
        log.info("\n waitForVisibility ---> xpath: '" + xpath + "' <--- " + " with time-out: '" + timeout_in_seconds + "'\n");
        loadingCheck();
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
        log.info("");
        boolean toReturn = true;
        try {
            waitForInvisibility(xpath);
        } catch (TimeoutException te) {
            toReturn = false;
        }
        return toReturn;
    }

    protected boolean isInvisible(String xpath, boolean throwException) {
        log.info("");
        if (!throwException)
            return isInvisible(xpath);
        waitForInvisibility(xpath);
        return true;
    }

    protected boolean isInvisible(String xpath, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
        log.info("");
        try {
            waitForInvisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            return false;
        }
        return true;
    }

    protected boolean isVisible(String xpath) {
        log.info("");
        boolean toReturn = true;
        try {
            waitForVisibility(xpath);
        } catch (TimeoutException te) {
            toReturn = false;
        }
        return toReturn;
    }

    protected boolean isVisible(String xpath, boolean throwException) {
        log.info("");
        if (!throwException)
            return isVisible(xpath);
        waitForVisibility(xpath, 60);
        return true;
    }

    protected boolean isVisible(String xpath, boolean throwException, int timeout_in_seconds) {
        log.info("");
        if (!throwException)
            return isVisible(xpath, timeout_in_seconds);
        waitForVisibility(xpath, timeout_in_seconds);
        return true;
    }

//    private boolean isVisibleLoadingCheck(String xpath, int timeout_in_seconds) {
//        try {
//            waitForVisibilityLoadingCheck(xpath, timeout_in_seconds);
//        } catch (TimeoutException te) {
//            return false;
//        }
//        return true;
//    }

    protected boolean isVisible(String xpath, int timeout_in_seconds) {
        log.info("");
        try {
            waitForVisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            return false;
        }
        return true;
    }

    protected boolean isNotVisible(String xpath, @SuppressWarnings("SameParameterValue") boolean throwException, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
        log.info("");
        if (!throwException)
            return isNotVisible(xpath, timeout_in_seconds);
        waitForInvisibility(xpath, timeout_in_seconds);
        return true;
    }

    protected boolean isNotVisible(String xpath, int timeout_in_seconds) {
        log.info("");
        try {
            waitForInvisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            return false;
        }
        return true;
    }

    protected boolean areVisible(@SuppressWarnings("SameParameterValue") String xpath, @SuppressWarnings("SameParameterValue") boolean throwException, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
        log.info("");
        boolean toReturn = true;

        if (throwException)
            return areVisible(xpath, timeout_in_seconds);

        try {
            waitForVisibilities(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            toReturn = false;
        }
        return toReturn;
    }

    private boolean areVisible(String xpath, int timeout_in_seconds) {
        log.info("");
        waitForVisibilities(xpath, timeout_in_seconds);
        return true;
    }

    protected void get(String url) {
        log.info("\n **************************************************************************************************** \n" +
                " *                                                                                                    * \n" +
                " *                                                                                                    * \n" +
                " Opening a Web Page URL: " + url + "\n" +
                " *                                                                                                    * \n" +
                " *                                                                                                    * " +
                "\n *************************************************************************************************** \n");
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }

    private String moveToDropDownButton(String xpath, Integer horizontal, Integer vertical) {
        log.info("");
        moveTo(By.xpath(xpath));
        scroll(horizontal, vertical);
        String currentBy = xpath + "/following-sibling::button";
        waitForVisibility(currentBy);
        moveTo(currentBy);
        return currentBy;
    }

    private void clickOnDropDownToShowList(String xpath) {
        log.info("");
        loadingCheck();
        clickElement(xpath);
        loadingCheck();
    }

    private void clickOnDropDownToShowList(String xpath, boolean recall) {
        log.info("");
        if (recall) {
            for (int i = 0; i < 5; i++) {
                if (!isVisible(xpath))
                    clickOnDropDownToShowList(xpath);
                isVisible(xpath, 2);
            }
        } else
            clickOnDropDownToShowList(xpath);
    }

    private void selectFromDisplayedDropDownList(String valueToSelect) {
        log.info("");
        String dropDownLocator = LIST_OF_RESULTS + "[.='" + valueToSelect + "']";
        waitForPresence(dropDownLocator, DEFAULT_TIMEOUT);
        if (!isVisible(dropDownLocator))
            clickOnDropDownToShowList(dropDownLocator, true);
        moveTo(dropDownLocator);
        clickElement(dropDownLocator);
        loadingCheck();
    }

    protected void selectFromDropDown(String xpath, String valueToSelect, Integer horizontal, Integer vertical) {
        log.info("\n selectFromDropDown: " + valueToSelect + " on ---> xpath: " + xpath + "\n");
        clickOnDropDownToShowList(moveToDropDownButton(xpath, horizontal, vertical));
        scroll(horizontal, vertical);
        selectFromDisplayedDropDownList(valueToSelect);
        loadingCheck();
    }

    protected void selectFromDropDown(String xpath, String valueToSelect) {
        log.info("\n selectFromDropDown: " + valueToSelect + " on ---> xpath: " + xpath + "\n");
        loadingCheck();
        moveTo(By.xpath(xpath));
        By currentBy = By.xpath(xpath + "/following-sibling::button");
        waitForPresence(currentBy);
        moveTo(currentBy);
        clickElement(currentBy);
        loadingCheck();
        final String DROP_DOWN_LIST = "//ul[contains(@style, 'display: block')]/li/a";
        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[.='" + valueToSelect + "']");
        waitForVisibility(dropDownLocator, DEFAULT_TIMEOUT);
        moveTo(dropDownLocator);
        clickElement(dropDownLocator);
        loadingCheck();
    }

    protected void selectFromDropDownIncludingBold(String xpath, String valueToSelect) {
        log.info("\n selectFromDropDownIncludingBold: " + valueToSelect + " on ---> xpath: " + xpath + "\n");
        By currentBy = By.xpath(xpath + "/following-sibling::button");
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

    protected void setCountry(String xpath, String valueToSelect){
        log.info("\n setCountry(String xpath ---> '"+ xpath +"', String valueToSelect ---> '"+ valueToSelect +"')");
        loadingCheck();
        moveTo(xpath);
        type(xpath, valueToSelect);
        selectFromDisplayedDropDownList(valueToSelect);
        loadingCheck();
    }

    /**
     <option selected="selected" value="">Choose One</option>
     <option value="UTIL">Utility Bill (Gas/Electricity/Phone/Television Provider)</option>
     <option value="CRTTFA">Tax Free Allowance Certificate</option>
     <option value="RCBS">Revenue Commissioners Balancing Statement</option>
     <option value="INSDOC">Insurance Document (house, motor, life)</option>
     */
    protected void setCounty(String xpath, String valueToSelect){
        log.info("\n setCounty(String xpath ---> '"+xpath+"', String valueToSelect ---> '"+valueToSelect+"')");
        loadingCheck();
        moveTo(xpath);
        webDriver.findElement(By.xpath(xpath)).click();
        selectFromDisplayedDropDownList(valueToSelect);
    }

    protected void type(String xpath, String valueToType) {
        log.info("\n type: " + valueToType + " to ---> xpath: " + xpath + "\n");
        By currentBy = By.xpath(xpath);
        waitForVisibility(currentBy);
        moveTo(currentBy);
        webDriver.findElement(currentBy).clear();
        webDriver.findElement(currentBy).sendKeys(valueToType);
        log.info("type on element with xpath: " + xpath + " \n and type a value: '" + valueToType + "'");
    }

    protected void setComboboxInput(String xpath, String value){
        log.info("\n setComboboxInput: " + value + " to ---> xpath: " + xpath + "\n");
        By currentBy = By.xpath(xpath);
        waitForVisibility(currentBy);
        moveTo(currentBy);
        webDriver.findElement(currentBy).click();
        String valueXpath = "[text()='" + value + "']";
        String listUnderXPath = LIST_OF_RESULTS + valueXpath;
        currentBy = By.xpath(listUnderXPath);
        webDriver.findElement(currentBy).click();
    }

    /** Selects a last value from ComboBox */
    protected void selectsLastComboBoxValue(String xpath){
        log.info("\n selectsLastComboBoxValue(String xpath ---> '"+ xpath +"')");
        By currentBy = By.xpath(xpath);
        waitForVisibility(currentBy);
        moveTo(currentBy);
        webDriver.findElement(currentBy).click();
        loadingCheck();
        List<WebElement> listOfWebElements = webDriver.findElements(By.xpath(LIST_OF_RESULTS));
        log.info("There is '" + listOfWebElements.size() + "' entries possible to select");
        listOfWebElements.get(listOfWebElements.size() - 1).click();
        loadingCheck();
    }


    protected void type(String xpath, String valueToType, boolean sendKeyEnter) {
        log.info("");
        if (sendKeyEnter)
            type(xpath, valueToType, Keys.ENTER);
        else
            type(xpath, valueToType);
    }

    protected void typeEndWithTab(String xpath, String valueToType, boolean sendKeyTab) {
        log.info("");
        if (sendKeyTab)
            type(xpath, valueToType, "TAB");
        else
            type(xpath, valueToType);
    }

    protected void type(String xpath, String valueToType, String sendKeyType) {
        log.info("\n type: " + valueToType + " to ---> xpath: " + xpath + "' \n and hitting a key = '" + sendKeyType + "'\n");
        if (!StringUtils.isEmpty(sendKeyType))
            type(xpath, valueToType, Keys.valueOf(sendKeyType));
        else
            type(xpath, valueToType);
    }

    protected void type(String xpath, String valueToType, Keys sendKeyType) {
        log.info("\n type: " + valueToType + " to ---> xpath: " + xpath + "' \n and hitting a key = '" + sendKeyType.toString() + "'\n");
        By currentBy = By.xpath(xpath);
        waitForVisibility(currentBy);
        moveTo(currentBy);
        webDriver.findElements(currentBy).clear();
        webDriver.findElement(currentBy).sendKeys(valueToType);
        if (!StringUtils.isEmpty(sendKeyType)) {
            log.info("sendKeys " + sendKeyType + "");
            keyStroke(currentBy, sendKeyType);
        }
    }

    private void keyStroke(String xpath, Keys sendKeyType) {
        log.info("");
        keyStroke(By.xpath(xpath), sendKeyType);
    }

    private void keyStroke(By currentBy, Keys sendKeyType) {
        log.info("\n -------------------------------------- \n | keyStroke | \n byLocator ---> " + currentBy.toString() + " <--- | \n -------------------------------------- \n");
        webDriver.findElement(currentBy).sendKeys(sendKeyType);
    }

    @Deprecated
    protected void scroll(int vertical, @SuppressWarnings("SameParameterValue") int horizontal) {
        log.info("");
        //noinspection RedundantCast
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("scroll(" + vertical + "," + horizontal + ")");
    }

    /**
     * Method is simulating hovering of an cursor over an element
     *
     * @param by - By object providing an target locator to set focus on
     */
    private void moveTo(By by) {
        log.info("\n -------------------------------------- \n | moveTo | \n byLocator ---> " + by.toString() + " <--- | \n -------------------------------------- \n");
        new Actions(webDriver).moveToElement(webDriver.findElement(by)).perform();
    }

    protected void moveTo(String xpath) {
        log.info("\n -------------------------------------- \n | moveTo | \n xpath ---> " + xpath + " <--- | \n -------------------------------------- \n");
        new Actions(webDriver).moveToElement(webDriver.findElement(By.xpath(xpath))).perform();
    }

    protected void moveTo2(@SuppressWarnings("SameParameterValue") String xpath) {
        log.info("");
        //noinspection RedundantCast
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.xpath(xpath)));
    }

    protected void checkBox(String xpathToClickOn, String xpathToGetStatus, String action){
        log.info("\n checkBox(String xpathToClickOn ---> '"+ xpathToClickOn +"', String xpathToGetStatus ---> '"+ xpathToGetStatus +"', String action ---> '"+ action +"')\n");


        if (!action.equalsIgnoreCase(ACTION.CHECK.get()) && !action.equalsIgnoreCase(ACTION.UNCHECK.get()))
            Assert.assertTrue("Not supported action was called ---> '" + action + "' supported are only following : '" + ACTION.CHECK.get() + "' or '" + ACTION.UNCHECK.get() + "'\n please correct it", false);

        String xpathChecked =   xpathToGetStatus + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "checked");
        String xpathUnchecked = xpathToGetStatus + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.CLASS, "checked");
        String preCondition =   action.equalsIgnoreCase(ACTION.CHECK.get()) ? xpathChecked : xpathUnchecked;
        String postCondition =  action.equalsIgnoreCase(ACTION.CHECK.get()) ? xpathChecked : xpathUnchecked;

        log.info("checkbox ---> '" + preCondition + "'");
        isPresent(preCondition, 15);
        moveTo(xpathToClickOn);
        clickElement(xpathToClickOn, postCondition);
        log.info("checkbox " + action + " ---> " + postCondition);
        isPresent(postCondition, 15);
    }

    /**
     * Driven by action it clicks to check or to uncheck the checkbox. That behavior is driven by [contains(@class,'checked')] or [not(contains(@class,'checked'))] for given Xpath
     *
     * @param xpath  - XPath selector pointing on element with expected behavioural changes after checking|unchecking.
     * @param action - String ---> only two possible values are handled {{ACTION.CHECK.get() or ACTION.UNCHECK.get()}}
     */
    protected void checkBox(String xpath, String action) {
        log.info("\n checkBox(String xpath ---> '"+ xpath +"', String action ---> '"+ action +"')");

        String xpathChecked = xpath + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "checked");
        String xpathUnchecked = xpath + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.CLASS, "checked");

        if (action.equalsIgnoreCase(ACTION.CHECK.get())) {
            log.info("checking checkbox");
            isVisible(xpathUnchecked);
            clickElement(xpathUnchecked, xpathChecked);
            log.info("checkbox checked");
            isVisible(xpathChecked);

        } else if (action.equalsIgnoreCase(ACTION.UNCHECK.get())) {
            log.info("un-checking checkbox");
            isVisible(xpathChecked);
            clickElement(xpathChecked, xpathUnchecked);
            isVisible(xpathUnchecked);
            log.info("checkbox un-checked");

        } else {
            Assert.assertTrue("Not supported action was called ---> '" + action + "' supported are only following : '" + ACTION.CHECK.get() + "' or '" + ACTION.UNCHECK.get() + "'\n please correct it", false);
        }
    }

    /**
     * boolean action --> true = ACTION.CHECK | false = ACTION.UNCHECK
     *
     * @param xpath
     * @param action
     */
    protected void checkBox(String xpath, boolean action) {
        log.info("\n checkBox(String xpath, boolean action)\n " +
                "xpath ---> '" + xpath + "' \n" +
                "action ---> '" + action + "'\n");
        if (action) {
            checkBox(xpath, ACTION.CHECK.get());
        } else {
            checkBox(xpath, ACTION.UNCHECK.get());
        }
    }

    protected void checkAlert() {
        log.info("");
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 0);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
    }
}