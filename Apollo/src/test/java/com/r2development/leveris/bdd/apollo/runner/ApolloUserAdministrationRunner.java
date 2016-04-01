package com.r2development.leveris.bdd.apollo.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//@Cucumber.Options(
        glue = { "classpath:com.r2development.leveris.bdd.borrower.apistepdef", "com.r2development.leveris.bdd.apollo.apistepdef", "com.r2development.leveris.bdd.underwriter.apistepdef", "com.r2development.leveris.bdd.investor.apistepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Login/NativeReports/",
                "json:target/Login/CucumberJson/login.json"
        },
        strict = false,
        features = "classpath:bdd/features/",
        tags = "@ApolloUserAdministration"
)
public class ApolloUserAdministrationRunner {

}

