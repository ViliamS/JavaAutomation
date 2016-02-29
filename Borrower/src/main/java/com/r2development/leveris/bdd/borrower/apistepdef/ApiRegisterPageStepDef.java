package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.RegistrationData;
import com.r2development.leveris.qa.utils.ACMExcel;
import com.r2development.leveris.utils.ExcelUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.r2development.leveris.utils.HttpUtils.*;
import static org.junit.Assert.*;

@Singleton
public class ApiRegisterPageStepDef extends ApiAbakusBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiRegisterPageStepDef.class);

//    private HttpClient httpClient;
//    private HttpContext localContext;
//    private IUser user;
//    private Map<String, String> registerParameters;

//    @Inject
//    ApiRegisterPageStepDef( HttpClient httpClient, HttpContext localContext, IUser user) {
//        this.httpClient = httpClient;
//        this.localContext = localContext;
//        this.user = user;
//        registerParameters = new LinkedHashMap<>();
//    }

    @Given("user goes to Registration page$")
    public void user_goes_to_registration_page() throws IOException {

        requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/home",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        requestHttpGet(
            httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:initialMenuWrapper:initialMenu:root:item:2:link::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

//        requestHttpPost(
//                httpClient,
////                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:lnkRegister:cancel::IBehaviorListener:0:",
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:lnkRegister:cancel::IBehaviorListener:0:",
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

    @Given("^this registration data, user processes the registration \\(format1\\)$")
    public void this_registration_data_user_processes_the_registration(List<RegistrationData> registrationDataList, String... test) throws IOException {
        assertEquals("System is expecting only one RegistrationData occurrence", registrationDataList.size(), 1);
        fill_in_registration(registrationDataList.get(0));
    }

    @Given("^this registration data, user processes the registration \\(format2\\)$")
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

    @Given("^user types his first name (.*) in Register page$")
    public void user_types_his_first_name(String firstName) {
//        registerPage.setFirstname(firstName);
//        String uniqueAutomationFirstname = new DateTime().now().toString("yyyyMMddHHmmssSSS");
        user.setFirstName(firstName/* + uniqueAutomationFirstname*/);
        registerParameters.put("root:c:w:pnlMain:c:w:txtName:tb", firstName /*+ new DateTime().now().toString("yyyyMMddHHmmssSSS")*/);
    }

    @Given("^user types his email (.*) in Register page$")
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

    @Given("^user types his phone number (.*) in Register page$")
    public void user_types_his_phone_number(String phoneNumber) {
//        DateTime now = DateTime.now();
        user.setPhoneNumber(phoneNumber);
        registerParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", phoneNumber);
        log.info(user.getPhoneNumber());
    }

    @Given("^system generates Borrower's phone number in Register page$")
    public void system_generate_borrower_phone_number_in_Register_page() {
//        DateTime now = DateTime.now();
//        String trickyPhoneNumber = now.toString("yyyyMMddHHmmss");
//        user.setPhoneNumber(trickyPhoneNumber);
        user.setPhoneNumber(System.getProperty("timestamp"));
//        registerParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", trickyPhoneNumber);
        registerParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", System.getProperty("timestamp"));
        log.info(user.getPhoneNumber());
    }

    @Given("^user types his password (.*) in Register page$")
    public void user_types_his_password(String pwd) {
        user.setPwd(pwd);
        registerParameters.put("root:c:w:pnlMain:c:w:txtPassword:tb", pwd);
    }

    @Given("^user wants to (show|hide) his password in Registration page$")
    public void user_wants_to_his_password(String showOrHide) {
    }

    @Given("^user (accepts|unaccepts) the terms of business$")
    public void user_accepts_the_terms_of_business(String acceptOrNot) {
        if ( acceptOrNot.equals("accepts") )
            registerParameters.put("root:c:w:pnlMain:c:w:chkTermsOfBusiness:checkbox", "on");
    }

    @Given("^user (accepts|unaccepts) the data protection policy$")
    public void user_accepts_the_data_protection_policy(String acceptOrNot) {
        if ( acceptOrNot.equals("accepts") )
            registerParameters.put("root:c:w:pnlMain:c:w:chkDataProtectionPolicy:checkbox", "on");
    }

    @When("^user registers$")
    public void user_registers() throws IOException {

        registerParameters.putAll(
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "4");
                        put("root:c:w:pnlMain:c:w:btnRegister:submit", "1");
                    }
                }
        );

        String registrationResponse = requestHttpPost(
                httpClient,
                "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnRegister:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                registerParameters,
                localContext,
                false
        );
    }

    @When("^user creates an account$")
    public void user_creates_an_account() throws IOException {

        if ( System.getProperty("excel.filename") != null ) {
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
        }
        else {
            user_types_his_first_name("Tony");
            user_types_his_email("anthony.mottot.test0001@abakus.com");
            user_types_his_phone_number("123456789");
            user_types_his_password("Password1122");
            user_accepts_the_terms_of_business("accepts");
            user_accepts_the_data_protection_policy("accepts");
        }
        user_registers();
    }

    @When("^user is already signed$")
    public void user_already_signed() {
//        loginPage = registerPage.clickAlreadyRegister();
    }

    @When("^user closes the Register page$")
    public void user_closes_the_register_page() {
//        welcomePage = registerPage.closeRegister();
    }

    @Then("^Verify Email Page is loaded$")
    public void verify_email_page_is_loaded() {
//        verifyEmailPage.isLoaded(registerPage.getEmailAddress());
    }

    @When("^user wants us resent email$")
    public void user_wants_us_resent_email() {
//        verifyEmailPage.clickReSent();
    }

    @Then("^user types his email (.*) in the Verify Email Page$")
    public void user_types_his_email_in_the_verify_email_page(String email) {
//        verifyEmailPage.setEmail(registerPage.getEmailAddress());
//        verifyEmailPage.setEmail(user.getEmail());
    }

    @Then("^user resends$")
    public void user_resends() {
//        verifyEmailPage.clickReSent2();
    }

}
