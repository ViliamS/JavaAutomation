package com.r2development.leveris.bdd.apollo.stepdef;

import com.google.inject.ImplementedBy;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

@ImplementedBy(WebDriverService.class)
public interface IWebDriverService {

    void setup();
    void teardown(Scenario scenario);
    WebDriver getWebDriver();
}