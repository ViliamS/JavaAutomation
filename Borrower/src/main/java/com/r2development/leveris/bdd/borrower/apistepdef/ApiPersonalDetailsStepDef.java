package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.PersonalDetailsData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

@Singleton
public class ApiPersonalDetailsStepDef extends ApiAbakusBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiPersonalDetailsStepDef.class);

    ApiPersonalDetailsStepDef() {
    }

    @When("^(borrower|coapplicant) fills in \"Personal Details\"$")
    public void user_fills_in_borrower_personal_details(String borrowerOrCoapplicant, Map<String, String> personalDetailsDataMap) throws IOException {

        if ( borrowerOrCoapplicant.equals("coapplicant") ) {
            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:left:c:form:form:root:c:w:pnlBorrower2:c:w:rptBorrower2UncommonForms:c:rows:1:item:pnlBorrower2UncommonForms:c:w:btnBorrower2UncommonForms:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    null,
                    localContext,
                    CONSUME_QUIETLY
            );
        }

        PersonalDetailsData personalDetailsData = new PersonalDetailsData(personalDetailsDataMap);
//        borrower_coapplicant_user_sees_his_name_in_the_title(borrowerOrCoapplicant);
        borrower_coapplicant_user_types_his_firstname(borrowerOrCoapplicant, personalDetailsData.getFirstName());
        borrower_coapplicant_user_types_his_lastname(borrowerOrCoapplicant, personalDetailsData.getLastName());
        borrower_coapplicant_user_checks_his_gender(borrowerOrCoapplicant, personalDetailsData.getGender());
        borrower_coapplicant_user_types_his_date_of_birth(borrowerOrCoapplicant, personalDetailsData.getDateOfBirth());
        borrower_coapplicant_user_selects_his_marital_status(borrowerOrCoapplicant, personalDetailsData.get("maritalStatus"));
        borrower_coapplicant_user_selects_his_nationality(borrowerOrCoapplicant, personalDetailsData.get("nationality"));
        borrower_coapplicant_user_types_his_residency_address_line_1(borrowerOrCoapplicant, personalDetailsData.getAddressLine1());
        borrower_coapplicant_user_types_his_residency_towncity(borrowerOrCoapplicant, personalDetailsData.getTownCity());
        borrower_coapplicant_user_selects_his_residency_countystate(borrowerOrCoapplicant, personalDetailsData.getCountyState());
        borrower_coapplicant_user_selects_his_residency_country(borrowerOrCoapplicant, personalDetailsData.get("country"));
        borrower_coapplicant_user_selects_his_residency_accommodation(borrowerOrCoapplicant, personalDetailsData.getAccommodation());
        borrower_coapplicant_user_checks_if_he_is_living_since_3_years(borrowerOrCoapplicant, (personalDetailsData.isLivingSince3years() ? "yes" : "no"));
        borrower_coapplicant_user_checks_if_requiring_visa(borrowerOrCoapplicant, personalDetailsData.get("requiredVisa"));
    }

    @When("^user fills in \"Borrower's personal details\"$")
    public void user_fills_in_borrower_personal_details() {
//        borrowerPersonalDetailsPage
//                .setFirstname(user.getFirstName())
//                .setLastname("Mottot")
//                .checkGender("Male")
//                .setDateOfBirth("20/10/1978")
//                .selectMaritalStatus("single")
//                .selectNationality("French")
//                .setResidentYears("3")
////                .checkRequiredVisa(false)
//                .setResidencyAddressLine1("Prague, Czech Republic")
//                .setResidencyAddressLine2("Hlavní město Praha")
//                .setResidencyTownCity("Prague")
//                .setResidencyPostcodeZip("14000")
////                .selectResidencyCountyState()
//                .selectResidencyCountry("Czech Republic")
//                .selectResidencyAccommodation("Rented on contract")
//                .setResidencyRent("200")
//                .checkLivedLast3Years(false)
//                .setPreviousResidencyAddressLine1("Dijon, France")
//                .setPreviousResidencyAddressLine2("Burgundy")
//                .setPreviousResidencyTownCity("Dijon")
//                .setPreviousResidencyPostcodeZip("21000")
////                .selectPreviousResidencyCountry("France")
//                .setPreviousResidencyCountry("France")
//                .clickSave();
    }

    @When("^user fills in \"Coapplicant's personal details\"$")
    public void user_fills_in_coapplicant_personal_details() {
//        coapplicantPersonalDetailsPage
//                .setFirstname(user.getFirstNameCoApplicant())
//                .setLastname("Mottot")
//                .checkGender("Male")
//                .setDateOfBirth("20/10/1978")
//                .selectMaritalStatus("single")
//                .selectNationality("French")
//                .setResidentYears("3")
//                .setResidencyAddressLine1("Prague, Czech Republic")
//                .setResidencyAddressLine2("Hlavní město Praha")
//                .setResidencyTownCity("Prague")
//                .setResidencyPostcodeZip("14000")
////                .selectResidencyCountyState()
//                .selectResidencyCountry("Czech Republic")
//                .selectResidencyAccommodation("Rented on contract")
//                .setResidencyRent("200")
//                .checkLivedLast3Years(false)
//                .setPreviousResidencyAddressLine1("Dijon, France")
//                .setPreviousResidencyAddressLine2("Burgundy")
//                .setPreviousResidencyTownCity("Dijon")
//                .setPreviousResidencyPostcodeZip("21000")
////                .selectPreviousResidencyCountry("France")
//                .setPreviousResidencyCountry("France")
//                .clickSave();
    }

    private void fillInPersonalDetails(String whichBorrower) {
//
//        IPersonalDetailsPage currentPersonalDetailsPage = null;
//        switch (whichBorrower) {
//            case "Borrower" :
//
//                currentPersonalDetailsPage = borrowerPersonalDetailsPage;
//                break;
//            case "Coapplicant" :
//                currentPersonalDetailsPage = coapplicantPersonalDetailsPage;
//                break;
//        }
//
//        currentPersonalDetailsPage
//                .setFirstname(user.getFirstNameCoApplicant())
//                .setLastname("Mottot")
//                .checkGender("Male")
//                .setDateOfBirth("20/10/1978")
//                .selectMaritalStatus("single")
//                .selectNationality("French")
//                .setResidentYears("3")
//                .setResidencyAddressLine1("Prague, Czech Republic")
//                .setResidencyAddressLine2("Hlavní město Praha")
//                .setResidencyTownCity("Prague")
//                .setResidencyPostcodeZip("14000")
////                .selectResidencyCountyState()
//                .selectResidencyCountry("Czech Republic")
//                .selectResidencyAccommodation("Rented on contract")
//                .setResidencyRent("200")
//                .checkLivedLast3Years(false)
//                .setPreviousResidencyAddressLine1("Dijon, France")
//                .setPreviousResidencyAddressLine2("Burgundy")
//                .setPreviousResidencyTownCity("Dijon")
//                .setPreviousResidencyPostcodeZip("21000")
////                .selectPreviousResidencyCountry("France")
//                .setPreviousResidencyCountry("France")
//                .clickSave();
    }

    @Given("^(borrower|coapplicant) user sees his name in the Personal Details title$")
    public void borrower_coapplicant_user_sees_his_name_in_the_title(String borrowerOrCoapplicant) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his firstname : (.*)$")
    public void borrower_coapplicant_user_types_his_firstname(String borrowerOrCoapplicant, String firstName) {
//        DateTime now = DateTime.now();
        switch(borrowerOrCoapplicant) {
            case "borrower":
//                if (firstName.isEmpty()) {
//                    borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setFirstname(user.getFirstName());
//                    user.setFirstName(firstName);
//                }
//                else {
//                    borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setFirstname(firstName);
//
//                }
//                borrowerPersonalDetailsParameters.put("root:c:w:txtFirstName:tb", firstName + now.toString("yyyyDDmmHH"));
                borrowerPersonalDetailsParameters.put("root:c:w:txtFirstName:tb", firstName + System.getProperty("timestamp"));
//                user.setFirstName(firstName + now.toString("yyyyDDmmHH"));
                user.setFirstName(firstName + System.getProperty("timestamp"));
                break;
//            case "coapplicant":
//                if ( firstName.isEmpty()) {
//                    coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setFirstname(user.getFirstName());
//                }
//                else {
//                    coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setFirstname(firstName);
//                }
//                coapplicantPersonalDetailsParameters.put("root:c:w:txtFirstName:tb", firstName + now.toString("yyyyDDmmHH"));
//                coapplicantPersonalDetailsParameters.put("root:c:w:txtFirstName:tb", firstName + System.getProperty("timestamp"));
//                user.setFirstNameCoApplicant(firstName + now.toString("yyyyDDmmHH"));
//                user.setFirstNameCoApplicant(firstName + System.getProperty("timestamp"));
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his lastname : (.*)$")
    public void borrower_coapplicant_user_types_his_lastname(String borrowerOrCoapplicant, String lastname) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
//                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setLastname(lastname);
                borrowerPersonalDetailsParameters.put("root:c:w:txtLastName:tb", lastname);
                break;
            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setLastname(lastname);
                coapplicantPersonalDetailsParameters.put("root:c:w:txtLastName:tb", lastname);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user checks his gender : (Male|Female)$")
    public void borrower_coapplicant_user_checks_his_gender(String borrowerOrCoapplicant, String gender) throws IOException {
        String parameterValue = ( gender.equals("Male") ? "radMale" : "radFemale" );

        switch( gender ) {
            case "Male":

                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put(
                                    "data",
                                    "{" +
                                        "\"widgets\":" +
                                        "[" +
                                            "{" +
                                                "\"widget\": \"pnlMaidenName\"," +
                                                "\"data\": {" +
                                                    "\"enable\": false" +
                                                "}" +
                                            "}" +
                                        "]" +
                                    "}"
                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY
                );
                break;
            case "Female":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new gender type ?");
        }

        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerPersonalDetailsParameters.put("root:c:w:rgrGender:rg", parameterValue);
                break;
            case "coapplicant":
                coapplicantPersonalDetailsParameters.put("root:c:w:rgrGender:rg", parameterValue);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his date of birth : (\\d\\d/\\d\\d/\\d\\d\\d\\d)$") // Date
    public void borrower_coapplicant_user_types_his_date_of_birth(String borrowerOrCoapplicant, String dateOfBirth) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerPersonalDetailsParameters.put("root:c:w:txtDateOfBirth:tb", dateOfBirth);
                break;
            case "coapplicant":
                coapplicantPersonalDetailsParameters.put("root:c:w:txtDateOfBirth:tb", dateOfBirth);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user selects his marital status : (single|separated|married/civil partner\\(s\\)|divorced/dissolved civil partnership|widowed)$")
    public void borrower_coapplicant_user_selects_his_marital_status(String borrowerOrCoapplicant, String maritalStatus) {

        String parameterValue = StringUtils.EMPTY;

        switch ( (maritalStatus == null ? "" : maritalStatus )) {
            case "single":
                parameterValue = "SIN";
                break;
            case "separated":
                break;
            case "married/civil partner(s)":
                break;
            case "divorced/dissolved civil partnership":
                break;
            case "widowed":
                break;
            case StringUtils.EMPTY:
                parameterValue = "SIN";
            default:
                log.info("Huston, we have a problem ! Do we have a new marital status ?");
        }

        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrowerPersonalDetailsParameters.put("root:c:w:cmbMaritalStatus:combobox", parameterValue);
                break;
            case "coapplicant":
                coapplicantPersonalDetailsParameters.put("root:c:w:cmbMaritalStatus:combobox", parameterValue);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user selects his nationality : (.*)$")
    public void borrower_coapplicant_user_selects_his_nationality(String borrowerOrCoapplicant, String nationality) {
        String parameterValue = (StringUtils.isEmpty(nationality) ? "IE" : nationality );
        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerPersonalDetailsParameters.put("root:c:w:cmbNationality:combobox", parameterValue);
                break;
            case "coapplicant":
                coapplicantPersonalDetailsParameters.put("root:c:w:cmbNationality:combobox", parameterValue);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types the number of resident years : ([\\d]+)$")
    public void borrower_coapplicant_user_types_the_number_resident_years(String borrowerOrCoapplicant, String residentYear) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user checks if he (is not|is) requiring a visa$")
    public void borrower_coapplicant_user_checks_if_requiring_visa(String borrowerOrCoapplicant, String sRequiringVisa) throws IOException {
//        boolean bRequiredVisa = ( StringUtils.isEmpty(sRequiringVisa) ? false : ( sRequiringVisa.equals("is") ? true : false));
        boolean bRequiredVisa = (!StringUtils.isEmpty(sRequiringVisa) && sRequiringVisa.equals("is"));
        switch(borrowerOrCoapplicant) {
            case "borrower":
                if ( !bRequiredVisa ) {
                    requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put(
                                        "data",
                                        "{" +
                                            "\"widgets\": [" +
                                                "{" +
                                                    "\"widget\": \"pnlVisa\"," +
                                                    "\"data\": {" +
                                                        "\"visible\": false" +
                                                    "}," +
                                                    "\"delta\": -50," +
                                                    "\"visibleEvent\": \"hide\"" +
                                                "}," +
                                                "{" +
                                                    "\"widget\": \"pnlVisa\"," +
                                                    "\"data\": {" +
                                                        "\"enable\": false" +
                                                    "}" +
                                                "}" +
                                            "]" +
                                        "}"
                                    );
                                }
                            },
                            localContext,
                            CONSUME_QUIETLY
                    );
                }
                break;
            case "coapplicant":
                if ( !bRequiredVisa ) {
                    requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put(
                                        "data",
                                        "{" +
                                            "\"widgets\": [" +
                                                "{" +
                                                    "\"widget\": \"pnlVisa\"," +
                                                    "\"data\": {" +
                                                        "\"visible\": false" +
                                                    "}," +
                                                    "\"delta\": -50," +
                                                    "\"visibleEvent\": \"hide\"" +
                                                "}," +
                                                "{" +
                                                    "\"widget\": \"pnlVisa\"," +
                                                    "\"data\": {" +
                                                        "\"enable\": false" +
                                                    "}" +
                                                "}," +
                                                "{" +
                                                    "\"widget\": \"pnlMaidenName\"," +
                                                    "\"data\": {" +
                                                        "\"enable\": false" +
                                                    "}" +
                                                "}," +
                                                "{" +
                                                    "\"widget\": \"pnlRent\"," +
                                                    "\"data\": {" +
                                                        "\"visible\": false" +
                                                    "}," +
                                                    "\"delta\": -80," +
                                                    "\"visibleEvent\": \"hide\"" +
                                                "}," +
                                                "{" +
                                                    "\"widget\": \"pnlRent\"," +
                                                    "\"data\": {" +
                                                        "\"enable\": false" +
                                                    "}" +
                                                "}" +
                                            "]" +
                                        "}"
                                    );
                                }
                            },
                            localContext,
                            CONSUME_QUIETLY
                    );
                }
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his residency address in line 1 : (.*)$")
    public void borrower_coapplicant_user_types_his_residency_address_line_1(String borrowerOrCoapplicant, String residencyAddressLine1) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his residency address in line 2 : (.*)$")
    public void borrower_coapplicant_user_types_his_residency_address_line_2(String borrowerOrCoapplicant, String residencyAddressLine2) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerPersonalDetailsParameters.put("root:c:w:txtAddressLine2:tb", residencyAddressLine2);
                break;
            case "coapplicant":
                coapplicantPersonalDetailsParameters.put("root:c:w:txtAddressLine2:tb", residencyAddressLine2);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his residency town/city : (.*)$")
    public void borrower_coapplicant_user_types_his_residency_towncity(String borrowerOrCoapplicant, String residencyTownCity) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerPersonalDetailsParameters.put("root:c:w:txtTownCity:tb", residencyTownCity);
                break;
            case "coapplicant":
                coapplicantPersonalDetailsParameters.put("root:c:w:txtTownCity:tb", residencyTownCity);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user selects his residency county/state : (.*)$")
    public void borrower_coapplicant_user_selects_his_residency_countystate(String borrowerOrCoapplicant, String residencyCountyState) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerPersonalDetailsParameters.put("root:c:w:cmbCountyState:combobox", "G");
                break;
            case "coapplicant":
                coapplicantPersonalDetailsParameters.put("root:c:w:cmbCountyState:combobox", "G");
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his postcode/zip : (.*)$")
    public void borrower_coapplicant_user_types_his_postcode_zip(String borrowerOrCoapplicant, String residencyPostcodeZip) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerPersonalDetailsParameters.put("root:c:w:cmbCountyState:combobox", residencyPostcodeZip);
                break;
            case "coapplicant":
                coapplicantPersonalDetailsParameters.put("root:c:w:cmbCountyState:combobox", residencyPostcodeZip);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user selects his residency country : (.*)")
    public void borrower_coapplicant_user_selects_his_residency_country(String borrowerOrCoapplicant, String residencyCountry) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerPersonalDetailsParameters.put("root:c:w:cmbCountry:combobox", "IE");
//                borrowerPersonalDetailsParameters.put("root:c:w:cmbCountry:combobox", residencyCountry);
                break;
            case "coapplicant":
                coapplicantPersonalDetailsParameters.put("root:c:w:cmbCountry:combobox", "IE");
//                coapplicantPersonalDetailsParameters.put("root:c:w:cmbCountry:combobox", residencyCountry);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user selects his residency accommodation : (Rented on contract|Rented from family/friends|Property owner|Others)$")
    public void borrower_coapplicant_user_selects_his_residency_accommodation(String borrowerOrCoapplicant, String residencyAccommodation) throws IOException {

        switch (residencyAccommodation) {
            case "Rented on contract" :
                break;
            case "Rented from family/friends" :
                break;
            case "Property owner":
                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put(
                                    "data",
                                    "{" +
                                        "\"widgets\": [" +
                                            "{" +
                                                "\"widget\": \"pnlRent\"," +
                                                "\"data\": {" +
                                                    "\"visible\": false" +
                                                "}," +
                                                "\"delta\": -80," +
                                                "\"visibleEvent\": \"hide\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlRent\"," +
                                                "\"data\": {" +
                                                    "\"enable\": false" +
                                                "}" +
                                            "}" +
                                        "]" +
                                    "}"
                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY
                );
                break;
            case "Others":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new accommodation type");
        }

        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerPersonalDetailsParameters.put("root:c:w:cmbAccomodation:combobox", "PO");
                break;
            case "coapplicant":
                coapplicantPersonalDetailsParameters.put("root:c:w:cmbAccomodation:combobox", "PO");
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his residency rent : (.*)$")
    public void borrower_coapplicant_user_types_his_residency_rent(String borrowerOrCoapplicant, String residencyRent) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user checks if he (is not|is) living since 3 years$")
    public void borrower_coapplicant_user_checks_if_he_is_living_since_3_years(String borrowerOrCoapplicant, String sLivedLast3Years) throws IOException {
        boolean bLivedLast3Years = sLivedLast3Years.equals("yes");
        switch(borrowerOrCoapplicant) {
            case "borrower":
                if ( bLivedLast3Years )
                    borrowerPersonalDetailsParameters.put("root:c:w:rgrLast3Years:rg", "radYes");
                else
                    borrowerPersonalDetailsParameters.put("root:c:w:rgrLast3Years:rg", "radNo");
                break;
            case "coapplicant":
                if ( bLivedLast3Years )
                    coapplicantPersonalDetailsParameters.put("root:c:w:rgrLast3Years:rg", "radYes");
                else
                    coapplicantPersonalDetailsParameters.put("root:c:w:rgrLast3Years:rg", "radNo");
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }

        if ( bLivedLast3Years ) {
            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put(
                                    "data",
                                    "{\"widgets\":[{\"widget\":\"pnlPreviousResidency\",\"data\":{\"enable\":false}},{\"widget\":\"pnlPreviousResidency\",\"data\":{\"visible\":false},\"delta\":-400,\"visibleEvent\":\"hide\"}]}"
                            );
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
        }
    }

    @Given("^(borrower|coapplicant) user types his previous residency address in line 1 : (.*)$")
    public void borrower_coapplicant_user_types_his_previous_residency_address_line1(String borrowerOrCoapplicant, String previousResidencyAddressLine1) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his previous residency address in line 2 : (.*)$")
    public void borrower_coapplicant_user_types_his_previous_residency_address_line2(String borrowerOrCoapplicant, String previousResidencyAddressLine2) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his previous residency town/city : (.*)$")
    public void borrower_coapplicant_user_types_his_previous_residency_towncity(String borrowerOrCoapplicant, String previousResidencyTownCity) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user selects his previous residency county/state : (.*)$")
    public void borrower_coapplicant_user_selects_his_previous_residency_countystate(String borrowerOrCoapplicant, String residencyCountyState) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his previous residency postcode/zip : (.*)$")
    public void borrower_coapplicant_user_types_his_previous_residency_postcodezip(String borrowerOrCoapplicant, String previousResidencyPostcodeZip) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user selects his previous residency country : (.*)$")
    public void borrower_coapplicant_user_selects_his_previous_residency_country(String borrowerOrCoapplicant, String previousResidencyCountry) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user types his previous residency country : (.*)$")
    public void borrower_coapplicant_user_types_his_previous_residency_country(String borrowerOrCoapplicant, String previousResidencyCountry) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                break;
            case "coapplicant":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(borrower|coapplicant) user saves his personal details data$")
    public void borrower_coapplicant_user_saves(String borrowerOrCoapplicant) throws IOException{

        Map<String, String> finalPersonalDetailsParameters = new HashMap<>();

        switch(borrowerOrCoapplicant) {
            case "borrower":
//                finalPersonalDetailsParameters = borrowerPersonalDetailsParameters;
                finalPersonalDetailsParameters.putAll(borrowerPersonalDetailsParameters);
                break;
            case "coapplicant":
//                finalPersonalDetailsParameters = coapplicantPersonalDetailsParameters;
                finalPersonalDetailsParameters.putAll(coapplicantPersonalDetailsParameters);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }

//        finalParameters.put("root:c:w:pnlAddressField:data", "{\"countryCode\":\"IE\",\"route\":\"Woodquay\",\"streetNumber\":\"18-19\",\"postalCode\":\"\",\"region\":\"Galway\",\"houseNumber\":\"\",\"inputText\":\"18-19 Woodquay\",\"county\":\"Galway\"}");
        finalPersonalDetailsParameters.put("root:c:w:pnlAddressField:data", "{\"inputText\":\"18-19 Woodquay\"}");
        finalPersonalDetailsParameters.put("stepToken", "1");
        finalPersonalDetailsParameters.put("root:c:w:btnNext:submit", "1");

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnNext:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                finalPersonalDetailsParameters,
                localContext,
                CONSUME_QUIETLY
        );
    }

}
