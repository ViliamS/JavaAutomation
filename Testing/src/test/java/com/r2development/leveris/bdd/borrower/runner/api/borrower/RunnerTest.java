package com.r2development.leveris.bdd.borrower.runner.api.borrower;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = { "classpath:com.r2development.leveris.di", "classpath:com.r2development.leveris.bdd.borrower.apistepdef", "classpath:com.r2development.leveris.bdd.apollo.apistepdef", "classpath:com.r2development.leveris.bdd.underwriter.apistepdef", "classpath:com.r2development.leveris.bdd.investor.apistepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Runner-Cucumber-NativeReports/Runner",
                "json:target/Runner-Cucumber-Json/Runner.json"
        },
        strict = true,
        features = "classpath:bdd/features",
        tags = "@Payday"
)
public class RunnerTest {
}
