package com.r2development.leveris.bdd.borrower.runner.api.calculation.quote;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = { "classpath:com.r2development.abakus.bdd.borrower.apistepdef" },
    monochrome = true,
    format = {
        "pretty",
        "html:target/Borrower/Api/ApiAllCalQuote-Cucumber-NativeReports/ApiAllCalQuote",
        "json:target/Borrower/Api/ApiAllCalQuote-Cucumber-Json/ApiAllCalQuote.json"
    },
    strict = false,
    features = "classpath:bdd/features/borrower/api/calculation/quote/ApiAllCalQuote.feature"
)
public class ApiAllCalQuoteTest {

}
