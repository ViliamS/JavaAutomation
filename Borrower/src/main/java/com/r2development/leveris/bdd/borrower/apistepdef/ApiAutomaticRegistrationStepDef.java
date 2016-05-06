package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.AutomaticRegistrationData;
import com.r2development.leveris.di.IABorrowerHttpContext;
import com.r2development.leveris.di.IBorrowerHttpResponse;
import com.r2development.leveris.di.IUser;
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
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

@Singleton
public class ApiAutomaticRegistrationStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiAutomaticRegistrationStepDef.class.getName());

    @Inject
    IUser user;
    @Inject
    IABorrowerHttpContext localContext;
    @Inject
    IBorrowerHttpResponse httpResponse;

    @Given("^Borrower goes to Automatic Registration page$")
    public void user_goes_to_automatic_registration_page() {
        // TODO to implement
    }

    @Given("^Borrower types his applicant : (.*)$")
    public void user_types_his_applicant(String applicantId) {
        String datetimestamp = DateTime.now().toString("yyyyMMddHHmmssSSS");
        automationRegistrationParameters.put("root:c:w:pnlMain:c:w:txtId:tb", applicantId.split("@")[0] + datetimestamp + "@finfactory.com");
//        automationRegistrationParameters.put("root:c:w:pnlMain:c:w:txtId:tb", "test.automation.b_api_" + datetimestamp + "@finfactory.com");
//        automationRegistrationParameters.put("root:c:w:pnlMain:c:w:txtId:tb", "anthony.mottot+" + datetimestamp + "@finfactory.com");
//        automationRegistrationParameters.put("root:c:w:pnlMain:c:w:txtId:tb", "anthony.mottot" + 12345 + "@finfactory.com");
//        user.setEmail("anthony.mottot+" + datetimestamp + "@finfactory.com");
//        user.setEmail("anthony.mottot+" + 12345 + "@finfactory.com");
        user.setEmail(applicantId.split("@")[0] + datetimestamp + "@finfactory.com");
        log.info("===============>");
        log.info("Email Login ===>  " + applicantId.split("@")[0] + datetimestamp + "@finfactory.com");
        System.out.println("automatic registration parameters: " + applicantId.split("@")[0] + datetimestamp + "@finfactory.com");
        log.info("===============>");
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

    @Deprecated @Given("^Borrower types coapplicant's email: (.*)$")
    public void user_types_coapplicant_email(String coapplicantId) {
//        DateTime now = DateTime.now();
//        automationRegistrationParameters.put("root:c:w:pnlMain:c:w:pnlQuote:c:w:txtCoapp:tb", "anthony.mottot.coapplicant.test0001" + now.toString("yyyyMMddHHmmssSSS") + "@abakus.com");
        automationRegistrationParameters.put("root:c:w:pnlMain:c:w:pnlQuote:c:w:txtCoapp:tb", "anthony.mottot.coapplicant.test0001" + System.getProperty("timestamp") + "@abakus.com");
    }

    @When("^Borrower clicks \"Create new user\"$")
    public void user_clicks_create_new_user() throws IOException {

        Pattern pLinkWithSession = Pattern.compile(";(jsessionid=.*?wicket:interface=.*)&amp;");
        Matcher mLinkWithSession = pLinkWithSession.matcher(httpResponse.getHttpResponse());

        String linkWithSession = null;
        while (mLinkWithSession.find()) {
            linkWithSession = mLinkWithSession.group(0);
        }

        requestHttpPost(
            httpClient,
            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:1",
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
            localContext.getHttpContext(),
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

        String automaticRegistrationResponse = requestHttpPost(
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
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(automaticRegistrationResponse);

        System.out.println("automatic registration parameters: " + automationRegistrationParameters);
    }

    @Given("^Borrower logs in via Automatic Registration$")
    public void user_logs_in_via_automatic_registration() throws IOException {

        String loginResponse = requestHttpPost(
                httpClient,
//                "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnLogin:submit::IBehaviorListener:0:",
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnLogin:submit::IBehaviorListener:0:",
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
                localContext.getHttpContext(),
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
//        user_types_his_applicant("said.bouabdallah12345@finfactory.com");
        user.setPwd("Password1122+");

//        if ( automaticRegistrationData.get("quoteComplete") != null && automaticRegistrationData.get("quoteComplete").equals("yes"))
//            user_unchecks_or_checks_for_quote_complete("checks");
//        if ( automaticRegistrationData.get("inviteCoapplicant") != null && automaticRegistrationData.get("inviteCoapplicant").equals("yes")) {
//            user_unchecks_or_checks_for_invite_coapplicant("checks");
//            Assert.assertNotNull("coapplicant id is mandatory to invite a coapplicant", automaticRegistrationData.get("coapplicantId" ));
//            user_types_coapplicant_email(automaticRegistrationData.get("coapplicantId"));
//        }
        user_clicks_create_new_user();
        user_logs_in_via_automatic_registration();
    }
}
