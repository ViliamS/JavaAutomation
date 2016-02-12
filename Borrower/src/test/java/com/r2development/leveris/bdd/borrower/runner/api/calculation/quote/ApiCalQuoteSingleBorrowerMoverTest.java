package com.r2development.leveris.bdd.borrower.runner.api.calculation.quote;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(
@Cucumber.Options(
    glue = { "classpath:com.r2development.leveris.bdd.borrower.apistepdef" },
    monochrome = true,
    format = {
        "pretty",
        "html:target/Api/ApiCalQuote-Cucumber-NativeReports/ApiCalQuote-SingleApp-Mover",
        "json:target/Api/ApiCalQuote-Cucumber-Json/ApiCalQuote-SingleApp-Mover.json"
    },
    strict = false,
    features = "classpath:bdd/features/api/calculation/quote/ApiCalQuote-SingleApp-Mover.feature"
)
public class ApiCalQuoteSingleBorrowerMoverTest {

}
