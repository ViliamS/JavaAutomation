package com.r2development.leveris;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver_Underwriter;
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

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Underwriter {

    protected final Log log = LogFactory.getLog(Underwriter.class);

    private static final int DEFAULT_TIMEOUT = 30;

    protected WebDriver webDriver;

    protected Underwriter(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected final String

            LIST_OF_RESULTS = getXPath(ELEMENTS.UL, ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: block") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.LI, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "ui-menu-item") + getXPath_DirectSibling(ELEMENTS.A),

            ANY_LOADING_OVERLAY = getXPath(ELEMENTS.DIV, ACTIONS.OR_CONTAINS, ATTRIBUTES.CLASS, new XPathValues("busy-indicator-big", "busyIndicator", "dblclick-fix-layer")) + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "block") + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "none"),
            NONE_LOADING_OVERLAY = getXPath(ELEMENTS.DIV, ACTIONS.OR_CONTAINS, ATTRIBUTES.CLASS, new XPathValues("busy-indicator-big", "busyIndicator", "dblclick-fix-layer")) + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "none") + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "block"),

            HIDDEN =    getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "none") + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "block"),
            VISIBLE =   getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "block") + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "none"),

            BUSY_INDICATOR_BLOCK = getXPath_DivEqualsId("busyIndicatorBig") + VISIBLE,
            BUSY_INDICATOR_NONE = getXPath_DivEqualsId("busyIndicatorBig") + HIDDEN,

            BUSY_INDICATOR_BLOCK2 = getXPath_DivEqualsWicket("busyIndicator") + VISIBLE,
            BUSY_INDICATOR_NONE2 = getXPath_DivEqualsWicket("busyIndicator") + HIDDEN,

            BUSY_INDICATOR_BLOCK3 = getXPath_DivEqualsClass("dblclick-fix-layer") + VISIBLE,
            BUSY_INDICATOR_NONE3 = getXPath_DivEqualsClass("dblclick-fix-layer") + HIDDEN,

            BUSY_INDICATOR_BLOCK4 = getXPath_DivEqualsClass("busyIndicator working") + VISIBLE,
            BUSY_INDICATOR_NONE4 = getXPath_DivEqualsClass("busyIndicator working") + HIDDEN;

    protected void loadingCheck() {
        log.info("");
        if (!System.getProperty("modeRun").equalsIgnoreCase(SharedDriver_Underwriter.PHANTOMJS)) {
            for (int i = 0; i < 3; i++) {
                if ((i > 1) && (isLoadingBlock()))
                    notLoading(i);
                if (isLoading())
                    notLoading(i);
                if ((i > 2) && (isLoadingBlock()))
                    notLoading(i);
            }
            try {
                isPresent(ANY_LOADING_OVERLAY, 0);
                isPresent(BUSY_INDICATOR_NONE, 0);
                isPresent(BUSY_INDICATOR_NONE2, 0);
                isPresent(BUSY_INDICATOR_NONE3, 0);
                isPresent(BUSY_INDICATOR_NONE4, 0);
            } catch (Exception x){
                log.info("loadingCheck() throws Exception ---> '" + x + "'");
            }
        }
    }

    private boolean isLoadingBlock() {
        return (isVisibleLoadingCheck(BUSY_INDICATOR_BLOCK, 0)) || (isVisibleLoadingCheck(BUSY_INDICATOR_BLOCK2, 0)) || (isVisibleLoadingCheck(BUSY_INDICATOR_BLOCK3, 0)) || (isVisibleLoadingCheck(BUSY_INDICATOR_BLOCK4, 0));
    }

    private boolean isLoading() {
        return isVisibleLoadingCheck(ANY_LOADING_OVERLAY, 0);
    }

    private void notLoading(int i) {

        if(isVisibleLoadingCheck(ANY_LOADING_OVERLAY, 0) && !isVisibleLoadingCheck(NONE_LOADING_OVERLAY, 0))

        isVisibleLoadingCheck(BUSY_INDICATOR_NONE, (i == 0 ? i : i - 1));
        isVisibleLoadingCheck(BUSY_INDICATOR_NONE2, (i == 0 ? i : i - 1));
        isVisibleLoadingCheck(BUSY_INDICATOR_NONE3, (i == 0 ? i : i - 1));
        isVisibleLoadingCheck(BUSY_INDICATOR_NONE4, (i == 0 ? i : i - 1));
    }

    private boolean isVisibleLoadingCheck(String xpath, int timeout_in_seconds) {
        try {
            waitForVisibilityLoadingCheck(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            return false;
        }
        return true;
    }

    private void waitForVisibilityLoadingCheck(String xpath, int timeout_in_seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(presenceOfElementLocated(By.xpath(xpath)));
    }

    //todo it is not tested yet just a blindly coded draft
    protected boolean clickToAppearDisappear(String xpathToClick, String xpathToAppear, String xpathToDisappear) {
        log.info("clickToAppearDisappear(String xpathToClick = '" + xpathToClick + "', String xpathToAppear = '" + xpathToAppear + "', String xpathToDisappear = '" + xpathToDisappear + "')");
        loadingCheck();
        moveTo(xpathToClick);
        isVisible(xpathToClick, true, 0);
        clickElement(xpathToClick, xpathToAppear);
        if (isPresent(xpathToAppear, 0) && isNotVisible(xpathToDisappear, 0)) {
            log.info("clickToAppearDisappear() have PASSED vybordelne!");
            return true;
        } else if (!isPresent(xpathToAppear, 0) && xpathToAppear!=null) {
            log.info("\n !!!! FAILED !!!! \n clickToAppearDisappear() Failed due to ---> xpath : '" + xpathToAppear + "' <--- \n Element didn't Appeared");
            return false;
        } else if (!isNotVisible(xpathToDisappear, 0) && xpathToDisappear != null) {
            log.info("\n !!!! FAILED !!!! \n clickToAppearDisappear() Failed due to ---> xpath : '" + xpathToDisappear + "' <--- \n" +
                    " Element is still visible!");
            return false;
        }
        return false;
    }

    private WebElement findBy(By locator) {
        log.info(("\n findBy(By locator) \n locator ---> " + locator.toString() + " <---\n"));
        return webDriver.findElement(locator);
    }

    protected WebElement findBy(String xpath) {
        log.info(("\n findBy(String xpath)\n xpath ---> " + xpath + " <---\n"));
        return webDriver.findElement(By.xpath(xpath));
    }

    protected WebElement getWebElement(By locator) {
        log.info(("\n getWebElement(By locator) \n locator ---> " + locator.toString() + " <---\n"));
        return findBy(locator);
    }

    protected WebElement getWebElement(String xpath) {
        log.info(("\n getWebElement(String xpath)\n xpath ---> " + xpath + " <---\n"));
        return findBy(xpath);
    }

    protected List<WebElement> getWebElements(WebElement webElement, By locator) {
        log.info(("\n getWebElements(WebElement webElement, By locator) \n webElement ---> '" + webElement.toString() + "' <--- \n locator ---> " + locator.toString() + " <---\n"));
        return webElement.findElements(locator);
    }

    protected boolean areVisible(@SuppressWarnings("SameParameterValue") String xpath, @SuppressWarnings("SameParameterValue") boolean throwException, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
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
        waitForVisibilities(xpath, timeout_in_seconds);
        return true;
    }

    private void waitForVisibilities(String xpath, int timeout_in_seconds) {
        log.info("\n waitForInvisibility ---> xpath: " + xpath + " with time-out: '" + timeout_in_seconds + "'\n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
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

    protected List<WebElement> getWebElements(WebElement webElement, String xpath) {
        log.info(("\n getWebElements(WebElement webElement, String xpath) \n webElement ---> '" + webElement.toString() + "' <--- \n xpath ---> " + xpath + " <---\n"));
        return webElement.findElements(By.xpath(xpath));
    }

    protected String getAttribute(WebElement webElement, String attribute){
        log.info("getAttribute(WebElement webElement, String attribute ---> '" + attribute + "')");
        return webElement.getAttribute(attribute);
    }

    protected String getText(String xpath) {
        log.info("\n getText(String xpath) \n xpath ---> '" + xpath + "' <--- \n");
        moveTo(xpath);
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath(xpath)).getText();
                    return true;
                });
        log.info("\n getText ---> xpath: " + xpath + "\n");
        return getWebElement(xpath).getText();
    }

    protected String getText(WebElement webElement) {
        log.info(("\n getText(WebElement webElement) \n webElement ---> '" + webElement.toString() + "' <--- \n returned text ---> '" + webElement.getText() + "'"));
        return webElement.getText();
    }

    protected String getText(WebElement webElement, String xpath) {
        log.info(("\n getText(WebElement webElement, String xpath) \n webElement ---> '" + webElement.toString() + "' <--- \n xpath ---> " + xpath + " <---\n"));
        return webElement.findElement(By.xpath(xpath)).getText();
    }

    protected String getClassText(WebElement webElement, @SuppressWarnings("SameParameterValue") String xpath) {
        log.info(("\n getClassText(WebElement webElement, String xpath) \n webElement ---> '" + webElement.toString() + "' <--- \n xpath ---> " + xpath + " <---\n"));
        return webElement.findElement(By.xpath(xpath)).getAttribute("class");
    }

    protected void clickElementLoop(String xpath, String expectedClickableXpath){
        log.info("\n clickElementLoop(String xpath, String expectedClickableXpath) \n xpath ---> '" + xpath+ "' <--- ' \n expectedClickableXpath --->" + expectedClickableXpath + "' <--- \n");
        clickElement(xpath, expectedClickableXpath, 30);
        try {
            isVisible(expectedClickableXpath, 5);
        } catch ( Exception e ) {
            boolean toGoOn = false;
            while ( !toGoOn ) {
                try {
                    moveTo(xpath);
                    clickElement(xpath, expectedClickableXpath, 15);
                    isVisible(expectedClickableXpath, 5);
                    toGoOn = true;
                } catch ( TimeoutException e2) {
                    log.debug("Problem of clicking on Your Account Done or getting the Dependant title.");
                }
            }
        }
    }

    protected void clickElement(String xpath) {
        log.info(("\n clickElement(String xpath)\n xpath ---> " + xpath + " <---\n"));
        new WebDriverWait(webDriver, 10)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
                .until((WebDriver driver) -> {
                    try {
                        moveTo(xpath);
                        driver.findElement(By.xpath(xpath)).click();
                    } catch (WebDriverException wde) {
                        log.debug("\n clickElement ---> xpath: " + xpath + " can't be found now \n");
                    }
                    return true;
                });
        log.info("click on element with xpath: " + xpath);
    }

    protected void clickElement(String xpath, boolean ignoreStateElementReferenceException, boolean ignoreWebDriverException) {
        log.info("\n clickElement(String xpath, boolean ignoreStateElementReferenceException, boolean ignoreWebDriverException) \n xpath ---> '" + xpath + "'\n ignoreStateElementReferenceException ---> '" + ignoreStateElementReferenceException + "' <--- \n ignoreWebDriverException ---> '" + ignoreWebDriverException + "' <--- \n");

        FluentWait<WebDriver> wdw = new WebDriverWait(webDriver, 10);

        wdw.ignoring(StaleElementReferenceException.class);
        if ( ignoreWebDriverException ) wdw.ignoring(WebDriverException.class);
        if ( ignoreStateElementReferenceException ) wdw.ignoring(TimeoutException.class);

        wdw.until((WebDriver driver) -> {
            try {
                moveTo(xpath);
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

    protected void clickElement(String xpath, @SuppressWarnings("SameParameterValue") String expectedXpath, int timeOut) {
        log.info("\n clickElement(String xpath, String expectedXpath, int timeOut) \n xpath ---> '" + xpath + "'\n and expect presence of xpath ---> '" + expectedXpath + "' <--- \n");
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
                .until((WebDriver driver) -> {
                    try {
                        moveTo(xpath);
                        driver.findElement(By.xpath(xpath)).click();
                        driver.findElement(By.xpath(expectedXpath));
//                        isVisible(expectedXpath, true);
                    } catch (WebDriverException wde) {
                        log.debug("\n element ---> xpath: " + xpath + " couldn't been found \n");
                    }
                    return true;
                });
        new WebDriverWait(webDriver, timeOut).until(presenceOfElementLocated(By.xpath(expectedXpath)));
    }

    private void clickElement(By by) {
        log.info("\n clickElement(By by) \n by ---> '" + by.toString() + "' <--- \n");
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    try {
                        moveTo(by);
                        driver.findElement(by).click();
                    } catch (WebDriverException wde) {
                        log.debug("\n clickElement ---> By: " + by.toString() + " couldn't been found \n");
                    }
                    return true;
                });
    }

    protected void clickElement(By by, @SuppressWarnings("SameParameterValue") String expectedXpath) {
        log.info(("\n clickElement ---> xpath: " + by.toString() + " \n and expected xpath ---> '" + expectedXpath + "' <---"));
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    try {
                        moveTo(by);
                        driver.findElement(by).click();
                        isVisible(expectedXpath, true);
                    } catch (WebDriverException wde) {
                        log.debug("\n By by, String expectedXpath \n ---> By: " + by.toString() + " couldn't been found \n or expectedXpath ---> '" + expectedXpath + "' <--- couldn't been found \n");
                    }
                    return true;
                });
    }

    protected void clickElementViaJavascript(String xpath, boolean toGoOn) {
        log.info(("\n clickElementViaJavascript(String xpath, boolean toGoOn) \n ---> xpath ---> '" + xpath + "' <---\n"));
        try {
            isVisible(xpath, true, 0);
            moveTo(xpath);
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click();", findBy(xpath));
        } catch ( NoSuchElementException | TimeoutException ignored) {
            log.info("Huston ! we have a problem !!!");
        }
    }

    protected void clickElementViaJavascript(String xpath) {
        boolean toGoOn = false;
        while(!toGoOn) {
            try {
                isVisible(xpath, true, 0);
                moveTo(xpath);
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", findBy(xpath));
                log.info(("\n clickElementViaJavascript(String xpath) \n ---> xpath ---> " + xpath + " <---\n"));
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
                isVisible(xpath, true, 0);
                moveTo(xpath);
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", findBy(xpath));
                log.info(("\n clickElementViaJavascript ---> xpath: " + xpath + " \n and ---> expectedXpath: " + expectedXpath) + "\n");
                isVisible(expectedXpath, true, 0);
                toGoOn = true;
            } catch ( NoSuchElementException | TimeoutException ignored) {
                log.info("Huston ! we have a problem !!!");
            }
        }
    }

    private void waitForPresence(String locator) {
        log.debug("\n waitForVisibility(By locator) \n locator ---> '" + locator + "' <--- \n");
        waitForPresence(By.xpath(locator));
    }

    private void waitForPresence(String locator, int timeOut) {
        log.debug("\n waitForVisibility(By locator) \n locator ---> '" + locator + "' <--- \n");
        waitForPresence(By.xpath(locator), timeOut);
    }

    private void waitForPresence(By locator) {
        log.debug("\n waitForPresence(By locator) \n locator ---> '" + locator.toString() + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(presenceOfElementLocated(locator));
    }

    private void waitForPresence(By locator, int timeOut) {
        log.debug("\n waitForPresence(By locator) \n locator ---> '" + locator.toString() + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
        wait.until(presenceOfElementLocated(locator));
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
        log.debug("\n waitForVisibility(By locator) \n locator ---> '" + locator.toString() + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(presenceOfElementLocated(locator));
    }

    private void waitForVisibility(By locator, int timeout_in_seconds) {
        log.debug("\n waitForVisibility(By locator, int timeout_in_seconds) \n locator ---> '" + locator.toString() + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(presenceOfElementLocated(locator));
    }

    private void waitForVisibility(String xpath) {
        log.debug("\n waitForVisibility(String xpath) \n xpath ---> '" + xpath + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(presenceOfElementLocated(By.xpath(xpath)));
    }

    private void waitForVisibility(String xpath, int timeout_in_seconds) {
        log.debug("\n waitForVisibility(String xpath, int timeout_in_seconds) \n xpath ---> '" + xpath + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(presenceOfElementLocated(By.xpath(xpath)));
    }

    private void waitForInvisibility(By locator) {
        log.debug("\n waitForInvisibility(By locator) \n locator ---> '" + locator.toString() + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.not(presenceOfElementLocated(locator)));
    }

    private void waitForInvisibility(By locator, int timeout_in_seconds) {
        log.debug("\n waitForInvisibility(String xpath, int timeout_in_seconds) \n locator ---> '" + locator.toString() + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.not(presenceOfElementLocated(locator)));
//        log.info("visible: " + locator.toString());
    }

    private void waitForInvisibility(String xpath) {
        log.debug("\n waitForInvisibility(String xpath) \n xpath ---> '" + xpath + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.not(presenceOfElementLocated(By.xpath(xpath))));
    }

    private void waitForInvisibility(String xpath, int timeout_in_seconds) {
        log.debug("\n waitForInvisibility(String xpath, int timeout_in_seconds) \n xpath ---> '" + xpath + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.not(presenceOfElementLocated(By.xpath(xpath))));
    }

    protected boolean isInvisible(String xpath) {
        log.debug("\n isInvisible(String xpath) \n xpath ---> '" + xpath + "' <--- \n");
        boolean toReturn = true;
        try {
            waitForInvisibility(xpath);
        } catch (TimeoutException te) {
            toReturn = false;
        }
        return toReturn;
    }

    protected boolean isInvisible(String xpath, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
        log.debug("\n isInvisible(String xpath, int timeout_in_seconds) \n xpath ---> '" + xpath + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        boolean toReturn = true;
        try {
            waitForInvisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            toReturn = false;
        }
        return toReturn;
    }

    protected boolean isInvisible(By locator) {
        log.debug("\n isInvisible(By locator) \n By.locator ---> '" + locator.toString() + "' <--- \n");
        boolean toReturn = true;
        try {
            waitForInvisibility(locator);
        } catch (TimeoutException te) {
            toReturn = false;
        }
        return toReturn;
    }

    protected boolean isInvisible(By locator, int timeout_in_seconds) {
        log.debug("\n isInvisible(By locator, int timeout_in_seconds) \n By.locator ---> '" + locator.toString() + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        boolean toReturn = true;
        try {
            waitForInvisibility(locator, timeout_in_seconds);
        } catch (TimeoutException te) {
            toReturn = false;
        }
        return toReturn;
    }

    protected boolean isVisible(String xpath) {
        log.debug("\n isVisible(String xpath) \n xpath ---> '" + xpath + "' <--- \n");
        boolean toReturn = true;
        try {
            waitForVisibility(xpath);
        } catch (TimeoutException te) {
            toReturn = false;
        }
        return toReturn;
    }

    protected boolean isVisible(String xpath, boolean throwException) {
        log.debug("\n isVisible(String xpath, boolean throwException) \n xpath ---> '" + xpath + "' <--- \n throwException ---> '" + throwException + "' <--- \n");
        if (!throwException)
            return isVisible(xpath);
        waitForVisibility(xpath, 60);
        return true;
    }

    protected boolean isVisible(String xpath, boolean throwException, int timeout_in_seconds) {
        log.debug("\n isVisible(String xpath, boolean throwException, int timeout_in_seconds) \n xpath ---> '" + xpath + "' <--- \n throwException ---> '" + throwException + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        if (!throwException)
            return isVisible(xpath, timeout_in_seconds);
        waitForVisibility(xpath, timeout_in_seconds);
        return true;
    }

    protected boolean isVisible(String xpath, int timeout_in_seconds) {
        log.debug("\n isVisible(String xpath, int timeout_in_seconds) \n xpath ---> '" + xpath + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        try {
            waitForVisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            return false;
        }
        return true;
    }

    protected boolean isNotVisible(String xpath, @SuppressWarnings("SameParameterValue") boolean throwException, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
        log.debug("\n isNotVisible(String xpath, boolean throwException, int timeout_in_seconds) \n xpath ---> '" + xpath + "' <--- \n throwException ---> '" + throwException + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        if (!throwException)
            return isNotVisible(xpath, timeout_in_seconds);
        waitForInvisibility(xpath, timeout_in_seconds);
        return true;
    }

    protected boolean isNotVisible(String xpath, int timeout_in_seconds) {
        log.debug("\n isNotVisible(String xpath, int timeout_in_seconds) \n xpath ---> '" + xpath + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        try {
            waitForInvisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            return false;
        }
        return true;
    }

    protected void type(String xpath, String valueToType) {
        log.info("\n type: " + valueToType + " to ---> xpath: " + xpath + "\n");
        By currentBy = By.xpath(xpath);
        waitForVisibility(currentBy);
        moveTo(currentBy);
        webDriver.findElement(currentBy).clear();
        webDriver.findElement(currentBy).sendKeys(valueToType);
//        webDriver.findElement(currentBy).sendKeys(Keys.ENTER);
        log.info("type on element with xpath: " + xpath + " \n and type a value: '" + valueToType + "'");
    }

    @Deprecated
    protected void scroll(int vertical, @SuppressWarnings("SameParameterValue") int horizontal) {
        //noinspection RedundantCast
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("scroll(" + vertical + "," + horizontal + ")");
    }

    private String moveToDropDownButton(String xpath, Integer horizontal, Integer vertical) {
        loadingCheck();
        moveTo(By.xpath(xpath));
        scroll(horizontal, vertical);
        String currentBy = xpath + "/following-sibling::button";
        waitForVisibility(currentBy);
        moveTo(currentBy);
        return currentBy;
    }

    private void clickOnDropDownToShowList(String xpath) {
        loadingCheck();
        clickElement(xpath);
        loadingCheck();
    }

    private void clickOnDropDownToShowList(String xpath, boolean recall) {
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
        final String DROP_DOWN_LIST = "//ul[contains(@style, 'display: block')]/li/a";
        String dropDownLocator = DROP_DOWN_LIST + "[.='" + valueToSelect + "']";
        waitForVisibility(dropDownLocator, DEFAULT_TIMEOUT);
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
        waitForVisibility(currentBy);
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

    protected void setComboboxInput(String xpath, String value){
        log.info("\n setComboboxInput: " + value + " to ---> xpath: " + xpath + "\n");
        By currentBy = By.xpath(xpath);
        waitForVisibility(currentBy);
        moveTo(currentBy);
        webDriver.findElement(currentBy).click();
        String valueXpath = "[text()='" + value + "']";
        String listUnderXPath = "//ul[contains(@style,'display: block')]/li[@class='ui-menu-item']/a" + valueXpath;
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
        if ( !StringUtils.isEmpty(sendKeyType) ) {
            log.info("sendKeys " + sendKeyType + "");
            keyStroke(currentBy, sendKeyType);
        }
    }

    private void keyStroke(String xpath, Keys sendKeyType){
        keyStroke(By.xpath(xpath), sendKeyType);
    }

    private void keyStroke(By currentBy, Keys sendKeyType){
        log.info("\n -------------------------------------- \n | keyStroke | \n byLocator ---> " + currentBy.toString() + " <--- | \n -------------------------------------- \n");
        webDriver.findElement(currentBy).sendKeys(sendKeyType);
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


}

