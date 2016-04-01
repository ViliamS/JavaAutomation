package com.r2development.leveris;

import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Apollo {

    private final Log log = LogFactory.getLog(Apollo.class);

    private static final int DEFAULT_TIMEOUT = 30;

    protected SharedDriver /*final*/ webDriver;

    protected Apollo(SharedDriver webDriver) {
        this.webDriver = webDriver;
    }

    private WebElement findBy(By locator) {
        log.info(("\n findBy(By locator) \n locator ---> " + locator.toString() + " <---\n"));
        return webDriver.findElement(locator);
    }

    private WebElement findBy(String xpath) {
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

    protected void get(String url) {
        log.info("\n **************************************************************************************************** \n" +
                " *                                                                                                    * \n" +
                " *                                                                                                    * \n" +
                " Opening a Web Page URL: " + url + "\n" +
                " *                                                                                                    * \n" +
                " *                                                                                                    * " +
                "\n *************************************************************************************************** \n");
        webDriver.get(url);
    }

    protected List<WebElement> getWebElements(WebElement webElement, String xpath) {
        log.info(("\n getWebElements(WebElement webElement, String xpath) \n webElement ---> '" + webElement.toString() + "' <--- \n xpath ---> " + xpath + " <---\n"));
        return webElement.findElements(By.xpath(xpath));
    }

    protected String getText(WebElement webElement) {
        log.info(("\n getText(WebElement webElement) \n webElement ---> '" + webElement.toString() + "' <--- \n"));
        return webElement.findElement(By.xpath(".")).getText();
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
        log.info("\n clickElement(String xpath, String expectedClickableXpath, int timeOut) \n xpath ---> '" + xpath + "'\n and expect clickable xpath ---> '" + expectedClickableXpath + "' <--- \n");
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
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
        log.info("\n clickElement(By by) \n by ---> '" + by.toString() + "' <--- \n");
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
        log.info(("\n clickElement ---> xpath: " + by.toString() + " \n and expected xpath ---> '" + expectedXpath + "' <---"));
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    try {
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

    private void waitForVisibility(By locator) {
        log.debug("\n waitForVisibility(By locator) \n locator ---> '" + locator.toString() + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForVisibility(By locator, int timeout_in_seconds) {
        log.debug("\n waitForVisibility(By locator, int timeout_in_seconds) \n locator ---> '" + locator.toString() + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForVisibility(String xpath) {
        log.debug("\n waitForVisibility(String xpath) \n xpath ---> '" + xpath + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForVisibility(String xpath, int timeout_in_seconds) {
        log.debug("\n waitForVisibility(String xpath, int timeout_in_seconds) \n xpath ---> '" + xpath + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForInvisibility(By locator) {
        log.debug("\n waitForInvisibility(By locator) \n locator ---> '" + locator.toString() + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    private void waitForInvisibility(By locator, int timeout_in_seconds) {
        log.debug("\n waitForInvisibility(String xpath, int timeout_in_seconds) \n locator ---> '" + locator.toString() + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//        log.info("visible: " + locator.toString());
    }

    private void waitForInvisibility(String xpath) {
        log.debug("\n waitForInvisibility(String xpath) \n xpath ---> '" + xpath + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForInvisibility(String xpath, int timeout_in_seconds) {
        log.debug("\n waitForInvisibility(String xpath, int timeout_in_seconds) \n xpath ---> '" + xpath + "' <--- \n timeout ---> '" + timeout_in_seconds + "' <--- \n");
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
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
}

