package com.r2development.leveris.bdd.borrower.runner.api.borrower;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = { "classpath:com.r2development.abakus.bdd.borrower.apistepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Api/ApiDoubleBorrowerL1-NativeReports/",
                "json:target/Api/ApiDoubleBorrowerL1-Json/ApiDoubleBorrowerL1.json"
        },
        strict = false,
        features = "classpath:bdd/features/api/borrower/ApiDoubleBorrowerL1.feature"
)
public class ApiDoubleBorrowerL1Test {

}
