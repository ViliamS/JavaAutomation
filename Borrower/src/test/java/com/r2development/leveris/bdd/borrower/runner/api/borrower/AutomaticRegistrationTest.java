package com.r2development.leveris.bdd.borrower.runner.api.borrower;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(
@Cucumber.Options(
    glue = { "classpath:com.r2development.leveris.bdd.borrower.apistepdef" },
    monochrome = true,
    format = {
        "pretty",
        "html:target/ApiAutomaticRegistration-Cucumber-NativeReports/AutomaticRegistration",
        "json:target/ApiAutomaticRegistration-Cucumber-Json/AutomaticRegistration-Cucumber.json"
    },
    strict = true,
    features = "classpath:bdd/features/AutomaticRegistration.feature"
)
public class AutomaticRegistrationTest {

}
