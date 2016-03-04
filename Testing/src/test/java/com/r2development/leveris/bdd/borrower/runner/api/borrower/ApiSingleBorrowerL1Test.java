package com.r2development.leveris.bdd.borrower.runner.api.borrower;

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
                "html:target/borrower/api/ApiSingleBorrowerL1-Cucumber-NativeReports/ApiSingleBorrowerL1-SingleApp-FirstTimeBuyer",
                "json:target/borrower/api/ApiSingleBorrowerL1-Cucumber-Json/ApiSingleBorrowerL1-SingleApp-FirstTimeBuyer.json"
        },
        strict = true,
        features = "classpath:bdd/features/borrower/api/borrower/ApiSingleBorrowerL1.feature"
)
public class ApiSingleBorrowerL1Test {

}
