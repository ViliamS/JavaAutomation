package com.r2development.leveris.bdd.borrower.runner.api.calculation.quote;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//@Cucumber.Options(
    glue = { "classpath:com.r2development.leveris.bdd.borrower.apistepdef" },
    monochrome = true,
    format = {
        "pretty",
        "html:target/Borrower/Api/ApiCalQuote-Cucumber-NativeReports/ApiCalQuote-JointApp-Mover",
        "json:target/Borrower/Api/ApiCalQuote-Cucumber-Json/ApiCalQuote-JointApp-Mover.json"
    },
    strict = false,
    features = "classpath:bdd/features/borrower/api/calculation/quote/ApiCalQuote-SingleApp-Mover.feature"
)
public class ApiCalQuoteTwoBorrowersMoversTest {

}
