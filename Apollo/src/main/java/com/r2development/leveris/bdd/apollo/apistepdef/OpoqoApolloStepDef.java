package com.r2development.leveris.bdd.apollo.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IHttpResponse;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;

import java.util.LinkedHashMap;
import java.util.Map;

@Singleton
public class OpoqoApolloStepDef{

    private static final Log log = LogFactory.getLog(OpoqoApolloStepDef.class);

    public OpoqoApolloStepDef() {

        httpClient = SupportHttpClientStepDef.getInstanceHttpClient();
        localContext = SupportHttpClientStepDef.getInstanceHttpClientContext();

        registerParameters = new LinkedHashMap<>();
        quoteParameters = new LinkedHashMap<>();

        borrowerPersonalDetailsParameters = new LinkedHashMap<>();
        coapplicantPersonalDetailsParameters = new LinkedHashMap<>();

        borrowerEmploymentIncomeParameters = new LinkedHashMap<>();
        coapplicantEmploymentIncomeParameters = new LinkedHashMap<>();

        accountParameters = new LinkedHashMap<>();
        paydayParameters = new LinkedHashMap<>();

        automationRegistrationParameters = new LinkedHashMap<>();
//        registerParameters = new LinkedHashMap<>();
        loginParameters = new LinkedHashMap<>();
//        quoteParameters = new LinkedHashMap<>();

//        borrowerPersonalDetailsParameters = new LinkedHashMap<>();
//        coapplicantPersonalDetailsParameters = new LinkedHashMap<>();

//        borrowerEmploymentIncomeParameters = new LinkedHashMap<>();
//        coapplicantEmploymentIncomeParameters = new LinkedHashMap<>();

//        accountParameters = new LinkedHashMap<>();
//        paydayParameters = new LinkedHashMap<>();
    }

    protected HttpClient httpClient;
    //    protected HttpClientContext localContext;
    protected HttpContext localContext;

    protected Map<String, String> registerParameters;
    protected Map<String, String> automationRegistrationParameters;
    protected Map<String, String> loginParameters;
    protected Map<String, String> quoteParameters;

    protected Map<String, String> borrowerPersonalDetailsParameters;
    protected Map<String, String> coapplicantPersonalDetailsParameters;

    protected Map<String, String> borrowerEmploymentIncomeParameters;
    protected Map<String, String> coapplicantEmploymentIncomeParameters;

    protected Map<String, String> accountParameters;
    protected Map<String, String> paydayParameters;

    public HttpContext newHttpClientContext() {
        return ( localContext = SupportHttpClientStepDef.getNewInstanceHttpClientContext() );
    }

    public HttpContext newHttpClientContext(String domain, @SuppressWarnings("SameParameterValue") String context) {
        return ( localContext = SupportHttpClientStepDef.getNewInstanceHttpClientContext(domain, context));
    }

    @When("^Go to Apollo Administration Login page$")
    public void go_to_user_administration(){
    }

    @And("^Set username (Admin) with password (changemenow!) and click login$")
    public void set_username_with_password_and_click_login(String username, String password){
    }

    @And("^Admin clicks on the (Users|Roles|Fund Manager|Administration) banner menu link$")
    public void admin_clicks_on_the_banner_menu_link(String clickOn){
    }

    @And("^Admin set User Search criteria: (.*) and triggers Search$")
    public void admin_set_user_search_criteria (String searchCriteria) {
    }

    @Then("^Admin checks if User: \"(.*)\" is present$")
    public void admin_checks_if_user_is_present (String userName) {
    }


}
