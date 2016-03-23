package com.r2development.leveris.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//@Cucumber.Options(
        glue = { "classpath:com.r2development.leveris.bdd.borrower.apistepdef", "classpath:com.r2development.leveris.bdd.apollo.apistepdef", "classpath:com.r2development.leveris.bdd.underwriter.apistepdef", "classpath:com.r2development.leveris.bdd.investor.apistepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Login/NativeReports/",
                "json:target/Login/CucumberJson/login.json"
        },
        strict = true,
        features = "classpath:bdd/features/",
        tags = "@login"
)
public class LoginTest {

}
