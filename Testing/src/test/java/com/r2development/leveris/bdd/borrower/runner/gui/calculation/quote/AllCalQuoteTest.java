package com.r2development.leveris.bdd.borrower.runner.gui.calculation.quote;

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
        "html:target/borrower/gui/AllCalQuote-Cucumber-NativeReports/AllCalQuote",
        "json:target/borrower/gui/AllCalQuote-Cucumber-Json/AllCalQuote.json"
    },
    strict = false,
    features = "classpath:bdd/features/borrower/gui/calculation/quote/AllCalQuote.feature"
)
public class AllCalQuoteTest {

}
