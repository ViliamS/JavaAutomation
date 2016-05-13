package com.r2development.leveris.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = { "classpath:com.r2development.leveris.di", "classpath:com.r2development.leveris.bdd.borrower.stepdef", "classpath:com.r2development.leveris.bdd.apollo.stepdef", "classpath:com.r2development.leveris.bdd.underwriter.stepdef", "classpath:com.r2development.leveris.bdd.investor.stepdef" },
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
public class RunnerGuiTest {
}
