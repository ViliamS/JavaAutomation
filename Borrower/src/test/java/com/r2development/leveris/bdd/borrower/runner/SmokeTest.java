package com.r2development.leveris.bdd.borrower.runner;

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
                "html:target/SmokeTest-Cucumber-NativeReports/SmokeTest",
                "json:target/SmokeTest-Cucumber-Json/SmokeTest.json"
        },
        strict = false,
        features = "classpath:bdd/features/api/borrower/ApiSingleBorrowerL1.feature"
//        tags = ""
)
public class SmokeTest {

}
