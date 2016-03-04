package com.r2development.leveris;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
        log.info("wait for visibility of the xpath: " + xpath);
        waitForVisibility(xpath);
        return findBy(xpath);
    }

    protected WebElement getWebElement(String xpath, @SuppressWarnings("SameParameterValue") int timeout) {
        log.info("wait for visibility of the xpath: " + xpath);
        waitForVisibility(xpath, timeout);
        return findBy(xpath);
    }

    protected boolean getWebElementWithText(String xpath, @SuppressWarnings("SameParameterValue") String text, int timeout) {
        log.info("wait for visibility of the xpath: " + xpath + " having this text: " + text);
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
                        log.debug("Element with xpath: " + xpath + " can't be found now.");
                    }
                    return true;
                });
        log.info("click on element with xpath: " + xpath);
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
                        log.debug("Element with xpath: " + xpath + " can't be found now.");
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
                log.debug("Element with xpath: " + xpath + " can't be found now.");
            }
            return true;
        });
        log.info("click on element with xpath: " + xpath);
    }

    protected void clickElement(String xpath, @SuppressWarnings("SameParameterValue") String expectedClickableXpath) {
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(By.xpath(xpath)).click();
                    } catch (WebDriverException wde) {
                        log.debug("Element with xpath: " + xpath + " can't be found now.");
                    }
                    return true;
                });
        new WebDriverWait(webDriver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath(expectedClickableXpath)));
        log.info("click on element with xpath: " + xpath + "and expect clickable xpath: " + expectedClickableXpath);
    }

    private void clickElement(By by) {
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(by).click();
                    } catch (WebDriverException wde) {
                        log.debug("Element with By: " + by.toString() + " can't be found now.");
                    }
                    return true;
                });
        log.info("click on element with by: " + by.toString());
    }

    protected void clickElement(By by, @SuppressWarnings("SameParameterValue") String expected) {
        new WebDriverWait(webDriver, DEFAULT_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
//                .ignoring(WebDriverException.class)
                .until((WebDriver driver) -> {
                    try {
                        driver.findElement(by).click();
                        isVisible(expected, true);
                    } catch (WebDriverException wde) {
                        log.debug("Element with By: " + by.toString() + " can't be found now.");
                    }
                    return true;
                });
        log.info("click on element with by: " + by.toString());
    }

    protected void clickElementViaJavascript(String xpath, boolean toGoOn) {

        try {
            isVisible(xpath, true, 5);
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click();", findBy(xpath));
//            if ( xpath.equals(IEmploymentIncomeSection.EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH))
//                isVisible("//div[@wicketpath='main_c_form_dialogWrapper']", true, 5);
            log.info(("click via javascript injection with xpath: " + xpath));
        } catch ( NoSuchElementException | TimeoutException ignored) {
            log.info("Huston ! we have a problem !!!");
        }

    }

    protected void clickElementViaJavascript(String xpath) {

        boolean toGoOn = false;
        while(!toGoOn) {
            try {
                isVisible(xpath, true, 5);
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", findBy(xpath));
                log.info(("click via javascript injection with xpath: " + xpath));
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
                isVisible(xpath, true, 10);
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", findBy(xpath));
                log.info(("click via javascript injection with xpath: " + xpath));
                isVisible(expectedXpath, true, 2);
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
        log.info("Extract text on this xpath: " + xpath);
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
        log.info("waitForVisibility based on this locator: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForVisibility(By locator, int timeout_in_seconds) {
        log.info("waitForVisibility based on this locator: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForVisibility(String xpath) {
        log.info("waitForVisibility based on this xpath: " + xpath);
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForVisibility(String xpath, int timeout_in_seconds) {
        log.info("waitForVisibility based on this xpath: " + xpath);
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForVisibilityWithText(String xpath, String text, int timeout_in_seconds) {
        log.info("waitForVisibility based on this xpath: " + xpath + " and on this text: " + text);
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
    }

    private void waitForInvisibility(By locator) {
        log.info("waitForVisibility based on this locator: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    private void waitForInvisibility(By locator, int timeout_in_seconds) {
        log.info("waitForVisibility based on this locator: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    private void waitForInvisibility(String xpath) {
        log.info("waitForVisibility based on this xpath: " + xpath);
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForInvisibility(String xpath, int timeout_in_seconds) {
        log.info("waitForVisibility based on this xpath: " + xpath);
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    private void waitForVisibilities(String xpath, int timeout_in_seconds) {
        log.info("waitForVisibility based on this xpath: " + xpath);
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

    protected void selectFromDropDown(String xpath, String valueToSelect) {
        log.info("Selecting this value: " + valueToSelect + ", on this xpath: " + xpath);
        moveTo(By.xpath(xpath));
        By currentBy = By.xpath(xpath + "/following-sibling::button");
        waitForVisibility(currentBy);
        moveTo(currentBy);
        clickElement(currentBy);

        final String DROP_DOWN_LIST = "//ul[contains(@style, 'display: block')]/li/a";
//        final String DROP_DOWN_LIST = "//ul[@role='listbox'][not(contains(@style,'display: none'))]/li[@class='ui-menu-item']/a";
        // or //ul[contains(@style, 'display: block')]/li/a
//        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[text()='" + valueToSelect + "']");
//        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[contains(.,'" + valueToSelect + "')]");
        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[.='" + valueToSelect + "']");
        waitForVisibility(dropDownLocator, DEFAULT_TIMEOUT);
        moveTo(dropDownLocator);
        clickElement(dropDownLocator);
    }

    protected void selectFromDropDownIncludingBold(String xpath, String valueToSelect) {
        log.info("Selecting this value: " + valueToSelect + ", on this xpath: " + xpath);
        By currentBy = By.xpath(xpath + "/following-sibling::button");
        waitForVisibility(currentBy);
        moveTo(currentBy);
        clickElement(currentBy);

        final String DROP_DOWN_LIST = "//ul[contains(@style, 'display: block')]/li/a/b";
//        final String DROP_DOWN_LIST = "//ul[@role='listbox'][not(contains(@style,'display: none'))]/li[@class='ui-menu-item']/a";
        // or //ul[contains(@style, 'display: block')]/li/a
        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[text()='" + valueToSelect + "']");
//        By dropDownLocator = By.xpath(DROP_DOWN_LIST + "[contains(.,'" + valueToSelect + "')]");
//        waitForVisibility(dropDownLocator, DEFAULT_TIMEOUT);
        moveTo(dropDownLocator);
        clickElement(dropDownLocator);
    }

    protected void type(String xpath, String valueToType) {
        log.info("Typing this value: " + valueToType + ", on this xpath: " + xpath);
        By currentBy = By.xpath(xpath);
        waitForVisibility(currentBy);
        moveTo(currentBy);
//        webDriver.findElement(currentBy).clear();
        webDriver.findElement(currentBy).sendKeys(valueToType);
//        webDriver.findElement(currentBy).sendKeys(Keys.ENTER);
        log.info("type on xpath: " + xpath + " with value: " + valueToType);
    }

    protected void type(String xpath, String valueToType, boolean sendKeyEnter) {
        log.info("Typing this value: " + valueToType + ", on this xpath: " + xpath);
        By currentBy = By.xpath(xpath);
        waitForVisibility(currentBy);
        moveTo(currentBy);
//        webDriver.findElement(currentBy).clear();
        webDriver.findElement(currentBy).sendKeys(valueToType);
        if ( sendKeyEnter )
            webDriver.findElement(currentBy).sendKeys(Keys.ENTER);
        log.info("type on xpath: " + xpath + " with value: " + valueToType);
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
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
    }
}
