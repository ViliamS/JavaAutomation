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
        "html:target/Gui/AllCalQuote-Cucumber-NativeReports/AllCalQuote",
        "json:target/Gui/AllCalQuote-Cucumber-Json/AllCalQuote.json"
    },
    strict = true,
    features = "classpath:bdd/features/gui/calculation/quote/AllCalQuote.feature"
)
public class AllCalQuoteTest {

}
