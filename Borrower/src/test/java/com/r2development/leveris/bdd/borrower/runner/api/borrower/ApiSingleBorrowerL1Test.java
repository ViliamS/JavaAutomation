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
                "html:target/Api/ApiSingleBorrowerL1-NativeReports/",
                "json:target/Api/ApiSingleBorrowerL1-Json/ApiSingleBorrowerL1.json"
        },
        strict = false,
        features = "classpath:bdd/features/api/borrower/ApiSingleBorrowerL1.feature"
)
public class ApiSingleBorrowerL1Test {

}
