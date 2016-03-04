package com.r2development.leveris.bdd.apollo.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//@Cucumber.Options(
    glue = { "classpath:com.r2development.leveris.bdd.apollo.apistepdef" },
    monochrome = true,
    format = { "pretty",
            "html:target/Login/NativeReports/LoginClient/",
            "json:target/Login/CucumberJson/LoginClient.json"
    },
    strict = false,
    features = "classpath:bdd/features/ApolloLoginClient.feature"
)
public class LoginClientRunner {

    private static final Log log = LogFactory.getLog(LoginClientRunner.class);

    LoginClientRunner() {
        log.info("Running LoginClientRunner");
    }
}
