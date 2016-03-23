package com.r2development.leveris.bdd.borrower.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = { "classpath:com.r2development.leveris.bdd.borrower.apistepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Runner-Cucumber-NativeReports/Runner",
                "json:target/Runner-Cucumber-Json/Runner.json"
        },
        strict = true,
        features = "classpath:bdd/features/api/borrower/",
        tags = "Payday"
)
public class RunnerTest {
}
