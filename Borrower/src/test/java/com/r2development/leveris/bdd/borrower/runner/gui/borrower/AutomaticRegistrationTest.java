package com.r2development.leveris.bdd.borrower.runner.gui.borrower;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = { "classpath:com.r2development.abakus.bdd.borrower.stepdef" },
    monochrome = true,
    format = {
        "pretty",
        "html:target/AutomaticRegistration-Cucumber-NativeReports/AutomaticRegistration",
        "json:target/AutomaticRegistration-Cucumber-Json/AutomaticRegistration-Cucumber.json"
    },
    strict = true,
    features = "classpath:bdd/features/AutomaticRegistration.feature"
)
public class AutomaticRegistrationTest {

}
