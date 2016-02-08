package com.r2development.leveris.bdd.borrower.runner.api.calculation.quote;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = { "classpath:com.r2development.leveris.bdd.borrower.apistepdef" },
    monochrome = true,
    format = {
        "pretty",
        "html:target/Api/ApiAllCalQuote-Cucumber-NativeReports/ApiAllCalQuote",
        "json:target/Api/ApiAllCalQuote-Cucumber-Json/ApiAllCalQuote.json"
    },
    strict = true,
    features = "classpath:bdd/features/api/calculation/quote/ApiAllCalQuote.feature"
)
public class ApiAllCalQuoteTest {

}
