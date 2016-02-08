package com.r2development.leveris;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Apollo {

    private final Log log = LogFactory.getLog(Apollo.class);

    protected WebDriver webDriver;
    private static final int DEFAULT_TIMEOUT = 30;

    public Apollo(WebDriver webDriver) {
        this.webDriver = webDriver;
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
        return findBy(xpath);
    }

    protected List<WebElement> getWebElements(WebElement webElement, By locator) {
        return webElement.findElements(locator);
    }

    protected List<WebElement> getWebElements(WebElement webElement, String xpath) {
        return webElement.findElements(By.xpath(xpath));
    }

    protected String getText(WebElement webElement) {
        return webElement.findElement(By.xpath(".")).getText();
    }

    protected String getText(WebElement webElement, String xpath) {
        return webElement.findElement(By.xpath(xpath)).getText();
    }

    protected String getClassText(WebElement webElement, @SuppressWarnings("SameParameterValue") String xpath) {
        return webElement.findElement(By.xpath(xpath)).getAttribute("class");
    }

//    protected boolean getAttribute(WebElement webElement, String attributeName) {
//        return (webElement.getAttribute(attributeName) != null);
//    }

    private void waitForVisibility(By locator) {
//        log.info("waitForVisibility: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        log.info("visible: " + locator.toString());
    }

    private void waitForVisibility(By locator, int timeout_in_seconds) {
//        log.info("waitForVisibility: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        log.info("visible: " + locator.toString());
    }

    private void waitForVisibility(String xpath) {
//        log.info("waitForVisibility: " + xpath);
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//        log.info("visible: " + xpath);
    }

    private void waitForVisibility(String xpath, int timeout_in_seconds) {
//        log.info("waitForInvisibility: " + xpath);
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//        log.info("visible: " + xpath);
    }

    private void waitForInvisibility(By locator) {
//        log.info("waitForInvisibility: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//        log.info("visible: " + locator.toString());
    }

    private void waitForInvisibility(By locator, int timeout_in_seconds) {
//        log.info("waitForInvisibility: " + locator.toString());
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//        log.info("visible: " + locator.toString());
    }

    private void waitForInvisibility(String xpath) {
//        log.info("waitForInvisibility: " + xpath);
        WebDriverWait wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
//        log.info("visible: " + xpath);
    }

    private void waitForInvisibility(String xpath, int timeout_in_seconds) {
//        log.info("waitForInvisibility: " + xpath);
        WebDriverWait wait = new WebDriverWait(webDriver, timeout_in_seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
//        log.info("visible: " + xpath);
    }

    protected boolean isInvisible(String xpath) {
        boolean toReturn = true;
        try {
            waitForInvisibility(xpath);
        } catch (TimeoutException te) {
            toReturn = false;
        }
//        } finally {
//        }
        return toReturn;
    }

    protected boolean isInvisible(String xpath, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
        boolean toReturn = true;
        try {
            waitForInvisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            toReturn = false;
        }
//        finally {
//        }
        return toReturn;
    }

    protected boolean isInvisible(By locator) {
        boolean toReturn = true;
        try {
            waitForInvisibility(locator);
        } catch (TimeoutException te) {
            toReturn = false;
        }
//        finally {
//        }
        return toReturn;
    }

    protected boolean isInvisible(By locator, int timeout_in_seconds) {
        boolean toReturn = true;
        try {
            waitForInvisibility(locator, timeout_in_seconds);
        } catch (TimeoutException te) {
            toReturn = false;
        }
//        finally {
//        }
        return toReturn;
    }

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

    protected boolean isVisible(String xpath, @SuppressWarnings("SameParameterValue") boolean throwException) {
//        boolean toReturn = true;

        if (!throwException)
            return isVisible(xpath);

        waitForVisibility(xpath);
        return true;
    }

    protected boolean isVisible(String xpath, @SuppressWarnings("SameParameterValue") int timeout_in_seconds) {
        boolean toReturn = true;
        try {
            waitForVisibility(xpath, timeout_in_seconds);
        } catch (TimeoutException te) {
            toReturn = false;
        }
//        finally {
//        }
        return toReturn;
    }

    protected boolean isVisible(By locator) {
        boolean toReturn = true;
        try {
            waitForVisibility(locator);
        } catch (TimeoutException te) {
            toReturn = false;
        }
//        finally {
//        }
        return toReturn;
    }

    protected boolean isVisible(By locator, int timeout_in_seconds) {
        boolean toReturn = true;
        try {
            waitForVisibility(locator, timeout_in_seconds);
        } catch (TimeoutException te) {
            toReturn = false;
        }
//        finally {
//        }
        return toReturn;
    }
}

