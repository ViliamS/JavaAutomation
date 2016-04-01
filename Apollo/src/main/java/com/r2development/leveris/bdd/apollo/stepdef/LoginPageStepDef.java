package com.r2development.leveris.bdd.apollo.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.apollo.apistepdef.OpoqoApolloStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.List;

@Singleton
public class LoginPageStepDef {

    private static final Log log = LogFactory.getLog(LoginPageStepDef.class);

    @Given("^Apollo User types his email login (.*) in Login page$")
    public void user_types_his_login(String email) {
    }

    @Given("^Apollo User types his pwd (.*) in Login page$")
    public void user_types_his_pwd(String pwd) {
    }

    @When("^Apollo user logs in$")
    public void user_logs_in() throws IOException {
    }

    @When("^Apollo user logs in with these credentials$")
    public void user_logs_in_with_these_credentials(List<String> credentials) throws IOException {
    }

    @When("^Apollo user forgets his password$")
    public void user_forgets_his_password() {
    }

    @When("^Apollo user closes the login page")
    public void user_closes_the_login_page() {
    }

    @When("^Apollo user wants to (show|hide) his password in Login page$")
    public void user_wants_to_his_password(String showOrHide) {
    }
}