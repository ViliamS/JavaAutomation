package com.r2development.leveris.bdd.borrower.runner.gui;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = { "classpath:com.r2development.leveris.bdd.borrower.stepdef" },
    monochrome = true,
    format = {
        "pretty",
        "html:target/Borrower-LowLevel-Cucumber-NativeReports/Borrower-LowLevel",
        "json:target/Borrower-LowLevel-Cucumber-Json/Borrower-LowLevel-Cucumber.json"
    },
    strict = true,
    features = "classpath:bdd/features/borrowerLowLevel.feature"
)
public class BorrowerLowLevelTest {

}
