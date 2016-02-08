package com.r2development.leveris.bdd.borrower.runner.api.borrower;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = { "classpath:com.r2development.leveris.bdd.borrower.apistepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/borrower/api/ApiDoubleBorrowerL1-Cucumber-NativeReports/ApiDoubleBorrowerL1-SingleApp-FirstTimeBuyer",
                "json:target/borrower/api/ApiDoubleBorrowerL1-Cucumber-Json/ApiDoubleBorrowerL1-SingleApp-FirstTimeBuyer.json"
        },
        strict = false,
        features = "classpath:bdd/features/borrower/api/borrower/ApiDoubleBorrowerL1.feature"
)
public class ApiDoubleBorrowerL1Test {

}
