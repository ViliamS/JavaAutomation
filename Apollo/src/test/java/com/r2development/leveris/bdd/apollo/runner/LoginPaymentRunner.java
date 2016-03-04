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
            "html:target/Login/NativeReports/LoginPayment/",
            "json:target/Login/Cucumber-Json/Cucumber-LoginPayment.json"
    },
    strict = false,
    features = "classpath:bdd/features/ApolloLoginPayment.feature"
)
public class LoginPaymentRunner {

    private static final Log log = LogFactory.getLog(LoginPaymentRunner.class);

    LoginPaymentRunner() {
        log.info("Running LoginPaymentRunner");
    }
}
