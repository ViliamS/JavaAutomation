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
        "html:target/borrower/api/ApiCalQuote-Cucumber-NativeReports/ApiCalQuote-JointApp-FirstTimeBuyer",
        "json:target/borrower/api/ApiCalQuote-Cucumber-Json/ApiCalQuote-JointApp-FirstTimeBuyer.json"
    },
    strict = false,
    features = "classpath:bdd/features/borrower/api/calculation/quote/ApiCalQuote-JointApp-FirstTimeBuyer.feature"
)
public class ApiCalQuoteTwoBorrowersFirstTimeBuyersTest {

}
