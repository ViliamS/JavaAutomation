package com.r2development.leveris.bdd.apollo.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.apollo.apistepdef.OpoqoApolloStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.IOException;

@Singleton
public class SsoStepDef {

    private static final Log log = LogFactory.getLog(SsoStepDef.class.getName());

    @Given("^user processes SSO (Payment|Client) Auth Step$")
    public void user_processes_SSO_Auth(String application) throws IOException {
    }

    @When("^user processes final SSO (Payment|Client) Auth Step$")
    public void user_processes_final_sso_auth_step(String application) throws IOException {
    }

    @Then("^user logs out from (Client|Payment)$")
    public void user_logs_out(String application) throws IOException {
    }
}