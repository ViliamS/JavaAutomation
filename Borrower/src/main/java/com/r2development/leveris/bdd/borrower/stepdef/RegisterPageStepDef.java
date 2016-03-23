package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.RegistrationData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.qa.utils.ACMExcel;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import com.r2development.leveris.utils.ExcelUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Singleton
public class RegisterPageStepDef /*extends BorrowerStepDef*/ {

    private static final Log log = LogFactory.getLog(RegisterPageStepDef.class.getName());

    private SharedDriver webDriver;
    private IWelcomePage welcomePage;
    private IRegisterPage registerPage;
    private IVerifyEmailPage verifyEmailPage;
    private ILoginPage loginPage;

    @Inject
    IUser user;

    @Inject
    RegisterPageStepDef(SharedDriver webDriver) {
//        super(webDriver);
        this.webDriver = webDriver;
        registerPage = new RegisterPage(webDriver);
    }

    @Given("Borrower goes to Registration page$")
    public void user_goes_to_registration_page() {

//        welcomePage = new WelcomePage(WebDriverService.getWebDriverInstance());
        welcomePage = new WelcomePage(webDriver, true);
        registerPage = welcomePage.clickRegister();
    }

    @Given("^this registration data, Borrower processes the registration \\(format1\\)$")
    public void this_registration_data_user_processes_the_registration(List<RegistrationData> registrationDataList, String... test) {
        assertEquals("System is expecting only one RegistrationData occurrence", registrationDataList.size(), 1);
        fill_in_registration(registrationDataList.get(0));
    }

    @Given("^this registration data, Borrower processes the registration \\(format2\\)$")
//    public void this_registration_data_Borrower_processes_the_registration(Map<String, String> registrationDataMap) {
    public void this_registration_data_user_processes_the_registration(List<String> registrationDataMap) {
        fill_in_registration(new RegistrationData(registrationDataMap));
    }

    private void fill_in_registration(RegistrationData registrationData) {
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
        registerPage.setFirstname(firstName);
        user.setFirstName(firstName);
    }

    @Given("^Borrower types his email (.*) in Register page$")
    public void user_types_his_email(String email) {
        String[] emailArray = email.split("@");
//        DateTime now = DateTime.now();
//        emailArray[0] = emailArray[0] + now.toString("yyyyMMddHHmmssSSS");
        emailArray[0] = emailArray[0] + "_" + System.getProperty("modeRun") + "_" + System.getProperty("timestamp");



        registerPage.setEmailAddress(String.join("@", emailArray));
        user.setEmail(String.join("@", emailArray));
        log.info(user.getEmail());
    }

    @Given("^Borrower types his phone number (.*) in Register page$")
    public void user_types_his_phone_number(String phoneNumber) {
//        DateTime now = DateTime.now();
//        registerPage.setPhoneNumber("+420" + System.getProperty("timestamp"));
        registerPage.setPhoneNumber("+420123456789");
//        user.setPhoneNumber("+420" + System.getProperty("timestamp"));
        user.setPhoneNumber("+420123456789");
        log.info(user.getPhoneNumber());
    }

    @Given("^system generates Borrower's phone number in Register page$")
    public void system_generate_borrower_phone_number_in_Register_page() {
//        DateTime now = DateTime.now();
//        String trickyPhoneNumber = now.toString("yyyyMMddHHmmss");
//        registerPage.setPhoneNumber(trickyPhoneNumber);
        registerPage.setPhoneNumber(System.getProperty("timestamp"));
//        user.setPhoneNumber(trickyPhoneNumber);
        user.setPhoneNumber(System.getProperty("timestamp"));
        log.info(user.getPhoneNumber());
    }

    @Given("^Borrower types his password (.*) in Register page$")
    public void user_types_his_password(String pwd) {
        registerPage.setPassword(pwd);
        user.setPwd(pwd);
    }

    @Given("^Borrower (show|hide)s his password in Registration page$")
    public void user_wants_to_his_password(String showOrHide) {
        registerPage = ( showOrHide.equals("show") ? registerPage.showPassword() : registerPage.hidePassword() );
    }

    @Given("^Borrower (accepts|unaccepts) the terms of business$")
    public void user_accepts_the_terms_of_business(String acceptOrNot) {
        registerPage = ( acceptOrNot.equals("accepts") ? registerPage.checkAcceptTerms() : registerPage.uncheckAcceptTerms() );
    }

    @Given("^Borrower (accepts|unaccepts) the data protection policy$")
    public void user_accepts_the_data_protection_policy(String acceptOrNot) {
        registerPage = ( acceptOrNot.equals("accepts") ? registerPage.checkDataPolicy() : registerPage.uncheckDataPolicy() );
    }

    @When("^Borrower registers$")
    public void user_registers() {
        verifyEmailPage = registerPage.clickRegister();
        verifyEmailPage.isLoaded(user.getEmail());
    }

    @When("^Borrower creates an account$")
    public void user_creates_an_account() {

//        if ( IBorrower.EXCEL_FILENAME != null ) {
        // TODO .... handle this System Property
        if ( System.getProperty("excelFilename") != null ) {
            // TODO to validate
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
        }
        else {
            user_types_his_first_name("AutomationTest");
            user_types_his_email("test.automation.@test.finfactory.com");
            user_types_his_phone_number("123456789");
        }
        user_types_his_password("Password1122+");
        user_accepts_the_terms_of_business("accepts");
        user_accepts_the_data_protection_policy("accepts");
        user_registers();
    }

    @When("^Borrower is already signed$")
    public void user_already_signed() {
        loginPage = registerPage.clickAlreadyRegister();
    }

    @When("^Borrower closes the Register page$")
    public void user_closes_the_register_page() {
        welcomePage = registerPage.closeRegister();
    }

    @Then("^Verify Email Page is loaded$")
    public void verify_email_page_is_loaded() {
        verifyEmailPage.isLoaded(registerPage.getEmailAddress());
    }

    @When("^Borrower wants us resent email$")
    public void user_wants_us_resent_email() {
        verifyEmailPage.clickReSent();
    }

    @Then("^Borrower types his email (.*) in the Verify Email Page$")
    public void user_types_his_email_in_the_verify_email_page(String email) {
        verifyEmailPage.setEmail(registerPage.getEmailAddress());
//        verifyEmailPage.setEmail(user.getEmail());
    }

    @Then("^Borrower clicks re-sent$")
    public void user_resends() {
        verifyEmailPage.clickReSent2();
    }
}
