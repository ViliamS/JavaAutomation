package com.r2development.leveris.bdd.borrower_and_underwriter.runner.api;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//@Cucumber.Options(
        glue = { "classpath:com.r2development.leveris.bdd.borrower.apistepdef", "classpath:com.r2development.leveris.bdd.underwriter.apistepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Borrower_And_Underwriter/Api/SingleBorrowerUnderwriterL1-NativeReports/",
                "json:target/Borrower_And_Underwriter/Api/SingleBorrowerUnderwriterL1-Json/SingleBorrowerUnderwriterL1.json"
        },
        strict = false,
        features = "src/test/resources/bdd/features/borrower_and_underwriter/api/ApiSingleBorrowerL1.feature"
)
public class SingleBorrowerUnderwriterL1Test {

}