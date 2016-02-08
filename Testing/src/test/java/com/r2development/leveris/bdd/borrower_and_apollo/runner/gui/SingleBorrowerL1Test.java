package com.r2development.leveris.bdd.borrower_and_apollo.runner.gui;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = { "classpath:com.r2development.leveris.bdd.borrower.stepdef", "classpath:com.r2development.leveris.bdd.apollo.stepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Borrower_And_Apollo/SingleBorrowerL1/Cucumber-NativeReports/",
                "json:target/Borrower_And_Apollo/SingleBorrowerL1/Cucumber-Json/SingleBorrowerL1.json"
        },
        strict = false,
        features = "src/test/resources/bdd/features/borrower_and_apollo/gui/SingleBorrowerL1.feature"
)
public class SingleBorrowerL1Test {

}