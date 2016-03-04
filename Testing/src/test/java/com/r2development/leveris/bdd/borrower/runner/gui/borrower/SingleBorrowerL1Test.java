package com.r2development.leveris.bdd.borrower.runner.gui.borrower;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//@Cucumber.Options(
        glue = { "classpath:com.r2development.leveris.bdd.borrower.stepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/borrower/gui/SingleBorrowerL1-Cucumber-NativeReports/SingleBorrowerL1",
                "json:target/borrower/gui/SingleBorrowerL1-Cucumber-Json/SingleBorrowerL1.json"
        },
        strict = false,
        features = "classpath:bdd/features/borrower/gui/borrower/SingleBorrowerL1.feature"
)
public class SingleBorrowerL1Test {
}
