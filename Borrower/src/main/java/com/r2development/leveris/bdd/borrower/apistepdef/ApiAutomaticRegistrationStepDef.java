package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.AutomaticRegistrationData;
import com.r2development.leveris.di.HttpResponse;
import com.r2development.leveris.di.IHttpResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

@Singleton
public class ApiAutomaticRegistrationStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiAutomaticRegistrationStepDef.class.getName());

    @Inject
    IHttpResponse httpResponse;

    @Given("^Borrower goes to Automatic Registration page$")
    public void user_goes_to_automatic_registration_page() {
        // TODO to implement
    }

    @Given("^Borrower types his applicant : (.*)$")
    public void user_types_his_applicant(String applicantId) {
        automationRegistrationParameters.put("root:c:w:pnlMain:c:w:txtId:tb", "test.automation.b_api_" + DateTime.now().toString("yyyyMMddHHmmssSSS") + "@finfactory.com");
    }

    @Given("^Borrower (unchecks|checks) \"Quote Complete\"$")
    public void user_unchecks_or_checks_for_quote_complete(String checks_or_unchecks) {
        switch (checks_or_unchecks) {
            case "unchecks":
                automationRegistrationParameters.put("root:c:w:pnlMain:c:w:chkQuote:checkbox", "off");
                break;
            case "checks":
                automationRegistrationParameters.put("root:c:w:pnlMain:c:w:chkQuote:checkbox", "on");
                break;
            default:
                log.error("House we have problem AutomaticRegistration Quote Complete");
                break;
        }
    }

    @Given("^Borrower (unchecks|checks) \"Invite Coapplicant\"$")
    public void user_unchecks_or_checks_for_invite_coapplicant(String checks_or_unchecks) {
        switch (checks_or_unchecks) {
            case "unchecks":
                automationRegistrationParameters.put("root:c:w:pnlMain:c:w:chkCoapp:checkbox", "off");
                break;
            case "checks":
                automationRegistrationParameters.put("root:c:w:pnlMain:c:w:chkCoapp:checkbox", "on");
                break;
            default:
                log.error("House we have problem AutomaticRegistration Invite Coapplicant");
                break;
        }
    }

    @Given("^Borrower types coapplicant's email: (.*)$")
    public void user_types_coapplicant_email(String coapplicantId) {
//        DateTime now = DateTime.now();
//        automationRegistrationParameters.put("root:c:w:pnlMain:c:w:pnlQuote:c:w:txtCoapp:tb", "anthony.mottot.coapplicant.test0001" + now.toString("yyyyMMddHHmmssSSS") + "@abakus.com");
        automationRegistrationParameters.put("root:c:w:pnlMain:c:w:pnlQuote:c:w:txtCoapp:tb", "anthony.mottot.coapplicant.test0001" + System.getProperty("timestamp") + "@abakus.com");
    }

    @When("^Borrower clicks \"Create new user\"$")
    public void user_clicks_create_new_user() throws IOException {

        String automaticRegistrationResponse = requestHttpGet(
            httpClient,
            "http://dv2app.opoqodev.com/stable-borrower/home?useCase=automaticregistration",
            new LinkedHashMap<String, String>() {
                {
                    put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                }
            },
            localContext,
            false
        );

        if ( httpResponse == null )
            httpResponse = new HttpResponse(null);
        httpResponse.setHttpResponse(automaticRegistrationResponse);

        Pattern pLinkWithSession = Pattern.compile(";(jsessionid=.*?wicket:interface=.*)&amp;");
        Matcher mLinkWithSession = pLinkWithSession.matcher(automaticRegistrationResponse);

        String linkWithSession = null;
        while (mLinkWithSession.find()) {
            linkWithSession = mLinkWithSession.group(0);
        }

        requestHttpPost(
            httpClient,
            "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:1",
            new LinkedHashMap<String, String>() {
                {
                    put("Accept", "text/xml");
                    put("Content-Type", "application/x-www-form-urlencoded");
                }
            },
            new LinkedHashMap<String, String>() {
                {
                    put("data", "{\"widgets\":[{\"widget\":\"pnlMain pnlInvite\",\"data\":{\"enable\":false}}]}");
                }
            },
            localContext,
            false
        );

        automationRegistrationParameters.putAll(
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                        put("root:c:w:pnlMain:c:w:btn-register:submit", "1");
                    }
                });

//        localContext = ApiSupportHttpClientStepDef.getInstanceHttpClientContext();

        requestHttpPost(
                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:3:main:c:form:form:root:c:w:pnlMain:c:w:btn-register:submit::IBehaviorListener:0:",
                System.getProperty("borrower") + "/form.2" + linkWithSession, //?wicket:interface=:3:main:c:form:form:root:c:w:pnlMain:c:w:btn-register:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                automationRegistrationParameters,
                localContext,
                CONSUME_QUIETLY
        );
    }

    @Given("^Borrower logs in via Automatic Registration$")
    public void user_logs_in_via_automatic_registration() throws IOException {

        String loginResponse = requestHttpPost(
                httpClient,
                "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnLogin:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "2");
                        put("root:c:w:pnlMain:c:w:btnLogin:submit", "1");
                    }
                },
                localContext,
                false
        );
        httpResponse.setHttpResponse(loginResponse);
    }

    @Given("^Borrower processes the automatic registration$")
    public void this_registration_data_user_processes_the_registration(Map<String, String> automationRegistrationDataMap) throws IOException {
        fill_in_automatic_registration(new AutomaticRegistrationData(automationRegistrationDataMap));
    }

    private void fill_in_automatic_registration(AutomaticRegistrationData automaticRegistrationData) throws IOException {
//        user_types_coapplicant_email(automaticRegistrationData.get("applicantId"));
        user_types_his_applicant(automaticRegistrationData.get("applicantId"));
//        if ( automaticRegistrationData.get("quoteComplete") != null && automaticRegistrationData.get("quoteComplete").equals("yes"))
//            user_unchecks_or_checks_for_quote_complete("checks");
//        if ( automaticRegistrationData.get("inviteCoapplicant") != null && automaticRegistrationData.get("inviteCoapplicant").equals("yes")) {
//            user_unchecks_or_checks_for_invite_coapplicant("checks");
//            Assert.assertNotNull("coapplicant id is mandatory to invite a coapplicant", automaticRegistrationData.get("coapplicantId" ));
//            user_types_coapplicant_email(automaticRegistrationData.get("coapplicantId"));
//        }
        user_clicks_create_new_user();
//        user_logs_in_via_automatic_registration();
    }
}
