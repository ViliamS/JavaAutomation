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
        "html:target/Gui/CalQuote-Cucumber-NativeReports/CalQuote-SingleApp-FirstTimeBuyer",
        "json:target/Gui/CalQuote-Cucumber-Json/CalQuote-SingleApp-FirstTimeBuyer.json"
    },
    strict = false,
    features = "classpath:bdd/features/api/calculation/quote/ApiCalQuote-SingleApp-FirstTimeBuyer.feature"
)
public class CalQuoteSingleBorrowerFirstTimeBuyerTest {

}
