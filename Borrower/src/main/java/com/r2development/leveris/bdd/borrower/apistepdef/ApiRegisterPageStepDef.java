package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.RegistrationData;
import com.r2development.leveris.di.IABorrowerHttpContext;
import com.r2development.leveris.di.IBorrowerHttpResponse;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.di.User;
import com.r2development.leveris.utils.HttpUtils;
import com.r2development.leveris.utils.mdg.MdgCallBack;
import com.r2development.leveris.utils.mdg.MdgCallBackImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Singleton
public class ApiRegisterPageStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiRegisterPageStepDef.class);

//    private HttpClient httpClient;
//    private HttpContext localContext;
//    private IUser user;
//    private Map<String, String> registerParameters;

    @Inject
    IABorrowerHttpContext localContext;
    @Inject
    IBorrowerHttpResponse httpResponse;
    @Inject
    IUser user;

//    @Inject
//    ApiRegisterPageStepDef( HttpClient httpClient, HttpContext localContext, IUser user) {
//        this.httpClient = httpClient;
//        this.localContext = localContext;
//        this.user = user;
//        registerParameters = new LinkedHashMap<>();
//    }

//    public ApiRegisterPageStepDef() {
//        super();
//    }

//    @Inject
    public ApiRegisterPageStepDef(/*IUser user*/) {
//        this.httpClient = httpClient;
//        this.localContext = localContext;
//        this.user = user;
//        registerParameters = new LinkedHashMap<>();
    }

    @Given("Borrower goes to Registration page$")
    public void user_goes_to_registration_page() throws IOException {

        httpClient = HttpUtils.createHttpClient();
        localContext.setHttpContext(HttpUtils.initContext(System.getProperty("domain.borrower"), System.getProperty("/borrower.ctx")));

        String homeResponse = requestHttpGet(
                httpClient,
                System.getProperty("borrower.url") + "/home",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(homeResponse);

        String linkRegister = Jsoup.parse(homeResponse).select("a[id~=link]").select("a[wicketpath=initialMenuWrapper_initialMenu_root_item_2_link]").attr("onclick");
        Pattern pLinkRegister = Pattern.compile("wicketAjaxGet\\('(;jsessionid=.*\\?wicket:interface=.*)',");
        Matcher mLinkRegister = pLinkRegister.matcher(linkRegister);
        String linkRegisterWicketInterface = StringUtils.EMPTY;
        while ( mLinkRegister.find() )
            linkRegisterWicketInterface = mLinkRegister.group(1);

        String lnkRegistrationResponse = requestHttpGet(
            httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:initialMenuWrapper:initialMenu:root:item:2:link::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2" + linkRegisterWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(lnkRegistrationResponse);

//        requestHttpPost(
//                httpClient,
////                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:lnkRegister:cancel::IBehaviorListener:0:",
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:lnkRegister:cancel::IBehaviorListener:0:",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                        put("Content-Type", "application/x-www-form-urlencoded");
//                    }
//                },
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("stepToken", "1");
//                    }
//                },
//                localContext,
//                CONSUME_QUIETLY
//        );

    }

    @Given("^this registration data, Borrower processes the registration \\(format1\\)$")
    public void this_registration_data_user_processes_the_registration(List<RegistrationData> registrationDataList, String... test) throws IOException {
        assertEquals("System is expecting only one RegistrationData occurrence", registrationDataList.size(), 1);
        fill_in_registration(registrationDataList.get(0));
    }

    @Given("^this registration data, Borrower processes the registration \\(format2\\)$")
//    public void this_registration_data_user_processes_the_registration(Map<String, String> registrationDataMap) throws IOException {
    public void this_registration_data_user_processes_the_registration(List<String> registrationDataMap) throws IOException {
        fill_in_registration(new RegistrationData(registrationDataMap));
    }

    private void fill_in_registration(RegistrationData registrationData) throws IOException {
        user_types_his_first_name(registrationData.getFirstName());
        user_types_his_email(registrationData.getEmail());
        if(registrationData.getPhoneNumber().equals("toGenerate"))
            system_generate_borrower_phone_number_in_Register_page();
        else
            user_types_his_phone_number(registrationData.getPhoneNumber());
        user_types_his_password(registrationData.getPassword());
        user_accepts_the_terms_of_business((registrationData.isTermsBusiness() ? "accepts" : "unaccepts"));
        user_accepts_the_data_protection_policy((registrationData.isProtectionBusiness() ? "accepts" : "unaccepts"));
        user_registers();
    }

    @Given("^Borrower types his first name (.*) in Register page$")
    public void user_types_his_first_name(String firstName) {
//        registerPage.setFirstname(firstName);
//        String uniqueAutomationFirstname = new DateTime().now().toString("yyyyMMddHHmmssSSS");
        if ( user == null)
            user = new User(null, null, null, null);
        user.setFirstName(firstName/* + uniqueAutomationFirstname*/);
        registerParameters.put("root:c:w:pnlMain:c:w:txtName:tb", firstName /*+ new DateTime().now().toString("yyyyMMddHHmmssSSS")*/);
    }

    @Given("^Borrower types his email (.*) in Register page$")
    public void user_types_his_email(String email) {
        String[] emailArray = email.split("@");
//        DateTime now = DateTime.now();
//        emailArray[0] = emailArray[0] + now.toString("yyyyMMddHHmmssSSS");

        // TODO to handle when it's running junit ... and not maven

//        if (StringUtils.isEmpty(System.getProperty("timestamp")))
//            System.getProperty(DateTime.now().toString("yyyyMMddHHmmssSSS"));

        emailArray[0] = emailArray[0] + System.getProperty("timestamp");
        user.setEmail(String.join("@", emailArray));
        registerParameters.put("root:c:w:pnlMain:c:w:txtEmailAddress:tb", String.join("@", emailArray));
        log.info(user.getEmail());
    }

    @Given("^Borrower types his phone number (.*) in Register page$")
    public void user_types_his_phone_number(String phoneNumber) {
//        DateTime now = DateTime.now();
//        user.setPhoneNumber("+420" + System.getProperty("timestamp"));

        /*
        String phoneNumberEpoch = String.valueOf(System.currentTimeMillis()/1000);
        user.setPhoneNumber("+420" + phoneNumberEpoch);
//        registerParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", "+420" + System.getProperty("timestamp"));
        registerParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", "+420" + phoneNumberEpoch);
        */

        user.setPhoneNumber("+420778098091");
        registerParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", "+420778098091");
        log.info(user.getPhoneNumber());
    }

    @Given("^system generates Borrower's phone number in Register page$")
    public void system_generate_borrower_phone_number_in_Register_page() {
//        DateTime now = DateTime.now();
//        String trickyPhoneNumber = now.toString("yyyyMMddHHmmss");
//        user.setPhoneNumber(trickyPhoneNumber);
        String phoneNumberEpoch = String.valueOf(System.currentTimeMillis()/1000);
//        user.setPhoneNumber("+420" + System.getProperty("timestamp"));
        user.setPhoneNumber("+420" + phoneNumberEpoch);
//        registerParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", trickyPhoneNumber);
//        registerParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", "+420" + System.getProperty("timestamp"));
        registerParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", "+420" + phoneNumberEpoch);
        log.info(user.getPhoneNumber());
    }

    @Given("^Borrower types his password (.*) in Register page$")
    public void user_types_his_password(String pwd) {
        user.setPwd(pwd);
        registerParameters.put("root:c:w:pnlMain:c:w:pwdPassword:tb", pwd);
    }

    @Given("^Borrower wants to (show|hide) his password in Registration page$")
    public void user_wants_to_his_password(String showOrHide) {
    }

    @Given("^Borrower (accepts|unaccepts) the terms of business$")
    public void user_accepts_the_terms_of_business(String acceptOrNot) {
        if ( acceptOrNot.equals("accepts") )
            registerParameters.put("root:c:w:pnlMain:c:w:chkTermsOfBusiness:checkbox", "on");
    }

    @Given("^Borrower (accepts|unaccepts) the data protection policy$")
    public void user_accepts_the_data_protection_policy(String acceptOrNot) {
        if ( acceptOrNot.equals("accepts") )
            registerParameters.put("root:c:w:pnlMain:c:w:chkDataProtectionPolicy:checkbox", "on");
    }

    @When("^Borrower registers$")
    public void user_registers() throws IOException {

//        requestHttpPost(
//                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:"
//        );

        registerParameters.putAll(
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1"); // Extract StepToken !!!
                        put("root:c:w:pnlMain:c:w:btnRegister:submit", "1");
                    }
                }
        );

        String btnRegister=Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=main]").select("component[encoding~=wicket]").text()).select("a[wicketpath=main_c_form_form_root_c_w_pnlMain_c_w_btnRegister_submit]").attr("onclick");
        Pattern pBtnRegister = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnRegister= pBtnRegister.matcher(btnRegister);
        String btnRegisterWicketInterface = StringUtils.EMPTY;
        while ( mBtnRegister.find() )
            btnRegisterWicketInterface = mBtnRegister.group(1);

        String registerResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnRegister:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnRegisterWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                registerParameters,
                localContext.getHttpContext(),
                false
        );
        httpResponse.setHttpResponse(registerResponse);
    }

    @When("^Borrower creates an account$")
    public void user_creates_an_account() throws IOException {

        if ( System.getProperty("excel.filename") != null ) {
            /*
            Map<Integer, Map<String, String>> borrowersRegistrationContainer = null;
            assertThat("File should exist", ExcelUtils.checkExcelExists(), Is.is(true));

            try {
                borrowersRegistrationContainer = ACMExcel.loadRegistrationDataToMap(ExcelUtils.getAbsolutePath());
            } catch (IOException e) {
                log.error("ACMExcel error on loading Registration Data to Map.");
            } catch (Exception e) {
                e.printStackTrace();
            }


            assertNotNull(borrowersRegistrationContainer);
            assertEquals("Excel is not the good one to run our current automation framework.", borrowersRegistrationContainer.size(), 1);
            assertNotNull(borrowersRegistrationContainer.get(0));

            Map<String, String> borrowerRegistrationData = borrowersRegistrationContainer.get(0);

            // REMINDER data comes from ACMEExcel
            user_types_his_first_name(borrowerRegistrationData.get("First Name"));
            user_types_his_email(borrowerRegistrationData.get("Email Address"));
            user_types_his_phone_number(borrowerRegistrationData.get("Phone Number"));
            user_types_his_password(borrowerRegistrationData.get("Password"));
            user_accepts_the_terms_of_business(borrowerRegistrationData.get("AcceptBusiness"));
            user_accepts_the_data_protection_policy(borrowerRegistrationData.get("AcceptPolicy"));
            */
        }
        else {
            user_types_his_first_name("Tony");
            user_types_his_email("test.automation.api@test.finfactory.com");
            user_types_his_phone_number("+420123456789");
            user_types_his_password("Password1122+");
            user_accepts_the_terms_of_business("accepts");
            user_accepts_the_data_protection_policy("accepts");
        }
        user_registers();
    }

    public String email(MdgCallBack mdgCallback) throws IOException {
        return mdgCallback.methodToEmailCallBack();
    }

    public String sms(MdgCallBack mdgCallBack) throws IOException {
        return mdgCallBack.methodToSmsCallBack();
    }

    @Then("^Borrower activates his account")
    public void borrower_activates_his_account() throws IOException, InterruptedException {

        MdgCallBack mdgCallBack = new MdgCallBackImpl(user.getEmail(), user.getPhoneNumber());
        log.info("ExternalId: " + this.email(mdgCallBack));

        HttpClient httpClient = createHttpClient();
        CookieStore cookieStore = new BasicCookieStore();
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setCookieStore(cookieStore);

        String queryEmailResponse = requestHttpPost(
                httpClient,
//                "https://dv2mdg.opoqodev.com/queryemail",
                System.getProperty("mdg.url") + "/queryemail",
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Accept", "application/json");
                    }
                },
                "{\"to\": \"" + user.getEmail() + "\"}",
                localContext,
                false
        );

        JsonParser jsonParserQueryEmailResponse = new JsonParser();
        JsonObject jsonObjectQueryEmailResponse = (JsonObject) jsonParserQueryEmailResponse.parse(queryEmailResponse.substring(1, queryEmailResponse.length()-1));

        String emailId = jsonObjectQueryEmailResponse.get("_id").getAsString();
        assertNotNull("emailId should n't be null", emailId);
        System.out.println("emailId: " + emailId);


        String queryEmailDetailResponse = requestHttpPost(
                httpClient,
//                "https://dv2mdg.opoqodev.com/queryemail/detail",
                System.getProperty("mdg.url") + "/queryemail/detail",
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Accept", "application/json");
                    }
                },
                "{\"ids\":[\"" + emailId + "\"]}",
                localContext,
                false
        );


        JsonParser jsonParserQueryEmailDetailsResponse = new JsonParser();
        JsonObject jsonObjectQueryEmailDetailsResponse = (JsonObject) jsonParserQueryEmailDetailsResponse.parse(queryEmailDetailResponse.substring(1, queryEmailDetailResponse.length()-1));
//        JsonObject jsonObjectQueryEmailResponse = (JsonObject) jsonParserQueryEmailResponse.parse(queryEmailResponse);

        String oid = jsonObjectQueryEmailDetailsResponse.get("body").getAsJsonObject().get("$oid").getAsString();
        String TheExternalId = jsonObjectQueryEmailDetailsResponse.get("externalId").getAsString();
        assertNotNull("emailId should n't be null", oid);
        System.out.println("emailId: " + oid);
        System.out.println("externalId: " + TheExternalId);


        String queryDataQueryResponse = requestHttpGet(
                httpClient,
//                "https://dv2mdg.opoqodev.com/email/body/" + oid,
                System.getProperty("mdg.url") + "/email/body/" + oid,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "application/html");
                    }
                },
                localContext,
                false
        );

        Document email = Jsoup.parse(queryDataQueryResponse);
        String urlVerifyRegistration = email.select("a[href~=useCase=verifyregistration]").attr("href");

        System.out.println(urlVerifyRegistration);

        String borrowerUIResponse = requestHttpGet(
                httpClient,
                urlVerifyRegistration,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "application/html");
                    }
                },
                this.localContext.getHttpContext(),
                false
        );
        httpResponse.setHttpResponse(borrowerUIResponse);

        String smsCode = this.sms(mdgCallBack);
        log.info("Sms Code: " + smsCode);

        /*
        String querySmsResponse = requestHttpPost(
                httpClient,
                "https://dv2mdg.opoqodev.com/querysms",
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Accept", "application/json");
                    }
                },
                "{\"to\": \"+420778098091\"}", // TODO, input parameters generated by Automation Framework with Epoch value
                localContext,
                false
        );

        JsonParser jsonParserQuerySmsResponse = new JsonParser();
        JsonObject jsonObjectQuerySmsResponse = (JsonObject) jsonParserQuerySmsResponse.parse("{\"listSms\":" + querySmsResponse + "}");
//        JsonObject jsonObjectQueryEmailResponse = (JsonObject) jsonParserQueryEmailResponse.parse(queryEmailResponse);

        JsonArray smsId = jsonObjectQuerySmsResponse.get("listSms").getAsJsonArray();
        assertNotNull("smsId should n't be null", smsId);
        System.out.println("smsId: " + smsId);

        String activationCode = null;

        if ( smsId.size() == 1) {
            JsonObject jsonSmsId = smsId.get(0).getAsJsonObject();
            String theSmsId = jsonSmsId.get("_id").getAsString();

            String querySmsDetailResponse = requestHttpPost(
                    httpClient,
                    "https://dv2mdg.opoqodev.com/querysms/detail",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Content-Type", "application/json");
                            put("Accept", "application/json");
                        }
                    },
                    "{\"ids\":[\"" + theSmsId + "\"]}",
                    localContext,
                    false
            );

            JsonParser jsonParserQuerySmsDetailResponse = new JsonParser();
            JsonObject jsonObjectQuerySmsDetailResponse = (JsonObject) jsonParserQuerySmsDetailResponse.parse(querySmsDetailResponse.substring(1, querySmsDetailResponse.length()-1));

            String externalId = jsonObjectQuerySmsDetailResponse.get("externalId").getAsString();

            Assert.assertEquals(true, externalId.equals(TheExternalId));

            String bodySms = jsonObjectQuerySmsDetailResponse.get("response").getAsJsonObject().get("body").getAsString();
//                String toSmsId = jsonObjectQuerySmsDetailResponse.get("_id").getAsString();

            assertNotNull("bodySms should n't be null", bodySms);
//                assertNotNull("bodySms should n't be null", toSmsId);
//                System.out.println("sms body: " + new String(Base64.getDecoder().decode(bodySms.getBytes())));
            System.out.println("to: " + bodySms);

            Pattern pBodySms = Pattern.compile("Please enter code (\\d+) in your browser window within 5 minutes of getting this message");
            Matcher mBodySms = pBodySms.matcher(bodySms);

            activationCode = null;
            while (mBodySms.find()) {
                activationCode = mBodySms.group(2);
            }

            System.out.println("activationCode: " + activationCode);
        }
        else {
            Thread.sleep(30000);
            for ( JsonElement currentSmsId : smsId) {
                JsonObject jsonSmsId = currentSmsId.getAsJsonObject();
                String theSmsId = jsonSmsId.get("_id").getAsString();

                String querySmsDetailResponse = requestHttpPost(
                        httpClient,
                        "https://dv2mdg.opoqodev.com/querysms/detail",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Content-Type", "application/json");
                                put("Accept", "application/json");
                            }
                        },
                        "{\"ids\":[\"" + theSmsId + "\"]}",
                        localContext,
                        false
                );

                JsonParser jsonParserQuerySmsDetailResponse = new JsonParser();
                JsonObject jsonObjectQuerySmsDetailResponse = (JsonObject) jsonParserQuerySmsDetailResponse.parse(querySmsDetailResponse.substring(1, querySmsDetailResponse.length()-1));

                String externalId = jsonObjectQuerySmsDetailResponse.get("externalId").getAsString();

                if ( !externalId.equals(TheExternalId))
                    continue;

                String bodySms = jsonObjectQuerySmsDetailResponse.get("response").getAsJsonObject().get("body").getAsString();
//                String toSmsId = jsonObjectQuerySmsDetailResponse.get("_id").getAsString();

                assertNotNull("bodySms should n't be null", bodySms);
//                assertNotNull("bodySms should n't be null", toSmsId);
//                System.out.println("sms body: " + new String(Base64.getDecoder().decode(bodySms.getBytes())));
                System.out.println("to: " + bodySms);

                Pattern pBodySms = Pattern.compile("Please enter code (\\d+) in your browser window within 5 minutes of getting this message");
                Matcher mBodySms = pBodySms.matcher(bodySms);

                activationCode = null;
                while (mBodySms.find()) {
                    activationCode = mBodySms.group(1);
                }

                System.out.println("activationCode: " + activationCode);
                break;

            }
        }
        */

        Document jsoup = Jsoup.parse(httpResponse.getHttpResponse());
        String stepToken = jsoup.select("input[name=stepToken]").attr("value");
        String onclick = jsoup.select("div[id~=btnConfirmRegistration] a").attr("onclick");

        Pattern pLinkWithSession = Pattern.compile("\\?(wicket:interface=.*btnConfirmRegistration.*)&");
        Matcher mLinkWithSession = pLinkWithSession.matcher(onclick);
        String linkWithSession = null;
        while (mLinkWithSession.find()) {
            linkWithSession = mLinkWithSession.group(1);
        }
        final String finalLink = linkWithSession;
        System.out.println("link: " + finalLink);

        final String finalActivationCode = smsCode;
        String smsCodeActivationResponse = requestHttpPost(
                httpClient,
                System.getProperty("borrower.url") + "/form.2?" + finalLink,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:3:main:c:form:form:root:c:w:pnlMain:c:w:btnConfirmRegistration:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "application/json");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlMain:c:w:pnlForVerify:c:w:txtVerificationCode:tb", finalActivationCode);
                        put("stepToken", stepToken);
                        put("root:c:w:pnlMain:c:w:btnConfirmRegistration:submit", "1");
                    }
                },
                this.localContext.getHttpContext(),
                false
        );
        httpResponse.setHttpResponse(smsCodeActivationResponse);

    }

    @When("^Borrower is already signed$")
    public void user_already_signed() {
//        loginPage = registerPage.clickAlreadyRegister();
    }

    @When("^Borrower closes the Register page$")
    public void user_closes_the_register_page() {
//        welcomePage = registerPage.closeRegister();
    }

    @Then("^Verify Email Page is loaded$")
    public void verify_email_page_is_loaded() {
//        verifyEmailPage.isLoaded(registerPage.getEmailAddress());
    }

    @When("^Borrower wants us resent email$")
    public void user_wants_us_resent_email() {
//        verifyEmailPage.clickReSent();
    }

    @Then("^Borrower types his email (.*) in the Verify Email Page$")
    public void user_types_his_email_in_the_verify_email_page(String email) {
//        verifyEmailPage.setEmail(registerPage.getEmailAddress());
//        verifyEmailPage.setEmail(user.getEmail());
    }

    @Then("^Borrower clicks re-send$")
    public void user_resends() {
//        verifyEmailPage.clickReSent2();
    }

}
