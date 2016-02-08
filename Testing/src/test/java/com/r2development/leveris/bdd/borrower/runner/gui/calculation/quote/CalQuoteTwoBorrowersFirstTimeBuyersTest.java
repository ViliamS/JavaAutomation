package com.r2development.leveris.bdd.borrower.runner.gui.calculation.quote;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = { "classpath:com.r2development.abakus.bdd.borrower.stepdef" },
    monochrome = true,
    format = {
        "pretty",
        "html:target/borrower/gui/CalQuote-Cucumber-NativeReports/CalQuote-JointApp-FirstTimeBuyer",
        "json:target/borrower/gui/CalQuote-Cucumber-Json/CalQuote-JointApp-FirstTimeBuyer.json"
    },
    strict = false,
    features = "classpath:bdd/features/borrower/gui/calculation/quote/CalQuote-JointApp-FirstTimeBuyer.feature"
)
public class CalQuoteTwoBorrowersFirstTimeBuyersTest {

}
