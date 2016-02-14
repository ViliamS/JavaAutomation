package com.r2development.leveris.bdd.apollo.runner;

import cucumber.api.junit.Cucumber;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(
@Cucumber.Options(
    glue = { "classpath:com.r2development.leveris.bdd.apollo.stepdef" },
    monochrome = true,
    format = { "pretty",
            "html:target/Cucumber-NativeReports/",
            "json:target/Cucumber-Json/cucumber.json"
    },
    strict = false,
    features = "classpath:bdd/features/DemoApollo.feature"
)
public class ApolloRunner {

    private static final Log log = LogFactory.getLog(ApolloRunner.class);

    ApolloRunner() {
        log.info("Running ApolloRunner");
    }
}
