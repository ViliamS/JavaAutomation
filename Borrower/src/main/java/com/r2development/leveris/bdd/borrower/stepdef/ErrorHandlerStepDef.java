package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import cucumber.api.java.en.Then;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class ErrorHandlerStepDef {

    WebDriver webDriver;

    private Map<String, String> errorHandler;

    @Inject
    ErrorHandlerStepDef(SharedDriver_Borrower webDriver) {
        errorHandler = new LinkedHashMap<>();
        this.webDriver = webDriver;
    }

    @Then("^(Borrower) sees these errors messages$")
    public void borrower_sees_these_error_messages(String userType, Map<String, String> values) {

        errorHandler = getErrorHandler();

        Assert.assertEquals(
                true,
                CollectionUtils.isSubCollection(
                        errorHandler.keySet(),
                        values.keySet()
                )
                &&
                CollectionUtils.isSubCollection(
                        errorHandler.values(),
                        values.values()
                )
        );
    }

    @Then("^(Borrower) don't see these errors message$")
    public void borrower_do_not_sees_these_error_messages(String userType, Map<String, String> values) {
        Assert.assertEquals(
                true,
                CollectionUtils.isSubCollection(values.keySet(), errorHandler.keySet())
                ||
                CollectionUtils.isSubCollection(values.values(), errorHandler.values())
        );
    }

    private Map<String, String> getErrorHandler() {

        Map<String, String>  toReturn = new LinkedHashMap<>();

        List<WebElement> webElementsList = webDriver.findElements(By.xpath("//label[contains(@class, 'message-inline-error')]/ancestor::div[@data-path][contains(@data-path, 'txt') or contains(@data-path, 'rgr') or contains(@data-path, 'cmb')]"));
        for ( WebElement currentWebElement :  webElementsList) {
            String key;
            try {
                key = currentWebElement.findElement(By.xpath("./label[@wicketpath]")).getText();
            }
            catch (NoSuchElementException nsee) {
                continue;
            }
            String message = currentWebElement.findElement(By.xpath("./label[@role='alert']")).getText();
            toReturn.put(key, message);
        }

        return toReturn;
    }

}
