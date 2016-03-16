package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.PersonalDetailsData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.IBorrowerHomePage;
import com.r2development.leveris.selenium.borrower.pageobjects.IPersonalDetailsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.PersonalDetailsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

@Singleton
public class PersonalDetailsStepDef /*extends BorrowerStepDef*/ /*implements CLV312Workaround*/ {

    private static final Log log = LogFactory.getLog(PersonalDetailsStepDef.class);

    private final WebDriver webDriver;

    @Inject
    IUser user;
    IBorrowerHomePage borrowerHomePage;
    IPersonalDetailsPage borrowerPersonalDetailsPage;

    @Inject
    PersonalDetailsStepDef(SharedDriver webDriver/*, IUser user*/) {
        this.webDriver = webDriver;
//        this.user = user;
        borrowerPersonalDetailsPage = new PersonalDetailsPage(webDriver);
    }

    @When("^(Borrower) fills in (Personal Details)$")
//    public void user_fills_in_borrower_personal_details(String borrowerOrCoapplicant, String formType,  Map<String, String> personalDetailsDataMap) {
    public void user_fills_in_borrower_personal_details(String borrowerOrCoapplicant, String formType, List<String> personalDetailsDataMap) {
//        workaroundCLV312(borrowerOrCoapplicant);
        PersonalDetailsData personalDetailsData = new PersonalDetailsData(personalDetailsDataMap);

        Assert.assertEquals(
                "'Borrower fills in Personal Details' have Failed on the check of Feature file table declaration. \n " +
                    "formType = '" + formType + "' equals to the personalDetailsData.getFormType() : '" + personalDetailsData.getFormType() + "'",
                formType,
                personalDetailsData.getFormType()
        );

        borrower_coapplicant_user_sees_his_name_in_the_title(borrowerOrCoapplicant);
        borrower_coapplicant_user_types_his_firstname(borrowerOrCoapplicant, personalDetailsData.getFirstName());
        borrower_coapplicant_user_types_his_lastname(borrowerOrCoapplicant, personalDetailsData.getLastName());
        borrower_coapplicant_user_checks_his_gender(borrowerOrCoapplicant, personalDetailsData.getGender());
        borrower_coapplicant_user_types_his_date_of_birth(borrowerOrCoapplicant, personalDetailsData.getDateOfBirth());
        borrower_coapplicant_user_selects_his_marital_status(borrowerOrCoapplicant, personalDetailsData.get("maritalStatus"));
        borrower_coapplicant_user_selects_his_nationality(borrowerOrCoapplicant, personalDetailsData.get("nationality"));
        borrower_coapplicant_user_types_his_residency_address_line_1(borrowerOrCoapplicant, personalDetailsData.getAddressLine1());
        borrower_coapplicant_user_types_his_residency_towncity(borrowerOrCoapplicant, personalDetailsData.getTownCity());
        borrower_coapplicant_user_selects_his_residency_country(borrowerOrCoapplicant, personalDetailsData.get("country"));
        borrower_coapplicant_user_selects_his_residency_countystate(borrowerOrCoapplicant, personalDetailsData.getCountyState());
//        borrower_coapplicant_user_selects_his_residency_accommodation(borrowerOrCoapplicant, personalDetailsData.getAccommodation());
//        borrower_coapplicant_user_checks_if_he_is_living_since_3_years(borrowerOrCoapplicant, (personalDetailsData.isLivingSince3years() ? "is" : "is not" ));
    }

    @Given("^(Borrower) sees his name in the Personal Details title$")
    public void borrower_coapplicant_user_sees_his_name_in_the_title(String borrowerOrCoapplicant) {
//        workaroundCLV312(borrowerOrCoapplicant);
        switch (borrowerOrCoapplicant) {
            case "Borrower":
//                assertThat("user\'s firstname should be in the title !", borrowerPersonalDetailsPage.isTitle(user.getFirstName()), is(true));
                borrowerPersonalDetailsPage.isTitle(user.getFirstName());
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his firstname : (.*)$")
    public void borrower_coapplicant_user_types_his_firstname(String borrowerOrCoapplicant, String firstName) {
//        DateTime now = DateTime.now();
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                if (firstName.isEmpty()) {
//                    borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setFirstname(user.getFirstName() + now.toString("yyyyDDmmHH"));
                    borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setFirstname(user.getFirstName() + System.getProperty("timestamp"));
                    user.setFirstName(firstName);
                }
                else {
//                    borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setFirstname(firstName + now.toString("yyyyDDmmHH"));
                    borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setFirstname(firstName + System.getProperty("timestamp"));
                }
//                user.setFirstName(firstName + now.toString("yyyyDDmmHH"));
                user.setFirstName(firstName + System.getProperty("timestamp"));
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his lastname : (.*)$")
    public void borrower_coapplicant_user_types_his_lastname(String borrowerOrCoapplicant, String lastname) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setLastname(lastname);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setLastname(lastname);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

//    boolean isGenderLabel();
//    IPersonalDetailsPage checkGenderMale();
//    IPersonalDetailsPage checkGenderFemale();

    @Given("^(Borrower) checks his gender : (Male|Female)$")
    public void borrower_coapplicant_user_checks_his_gender(String borrowerOrCoapplicant, String gender) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.checkGender(gender);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.checkGender(gender);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his date of birth : (\\d\\d/\\d\\d/\\d\\d\\d\\d)$")
    public void borrower_coapplicant_user_types_his_date_of_birth(String borrowerOrCoapplicant, String dateOfBirth) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setDateOfBirth(dateOfBirth);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setDateOfBirth(dateOfBirth);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects his marital status : (single|separated|married/civil partner\\(s\\)|divorced/dissolved civil partnership|widowed)$")
    public void borrower_coapplicant_user_selects_his_marital_status(String borrowerOrCoapplicant, String maritalStatus) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.selectMaritalStatus(maritalStatus);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.selectMaritalStatus(maritalStatus);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects his nationality : (.*)$")
    public void borrower_coapplicant_user_selects_his_nationality(String borrowerOrCoapplicant, String nationality) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.selectNationality(nationality);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = borrowerPersonalDetailsPage.selectNationality(nationality);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types the number of resident years : ([\\d]+)$")
    public void borrower_coapplicant_user_types_the_number_resident_years(String borrowerOrCoapplicant, String residentYear) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setResidentYears(residentYear);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setResidentYears(residentYear);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

//    boolean isRequiredVisa();
//    IPersonalDetailsPage checkRequiredVisaYes();
//    IPersonalDetailsPage checkRequiredVisaNo();

    @Given("^(Borrower) checks if he (is not|is) requiring a visa$")
    public void borrower_coapplicant_user_check_if_requiring_visa(String borrowerOrCoapplicant, String sRequiringVisa) {
        boolean bRequiredVisa = sRequiringVisa.equals("is");
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.checkRequiredVisa(bRequiredVisa);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.checkRequiredVisa(bRequiredVisa);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his residency address in line 1 : (.*)$")
    public void borrower_coapplicant_user_types_his_residency_address_line_1(String borrowerOrCoapplicant, String residencyAddressLine1) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setResidencyAddressLine1(residencyAddressLine1);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setResidencyAddressLine1(residencyAddressLine1);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his residency address in line 2 : (.*)$")
    public void borrower_coapplicant_user_types_his_residency_address_line_2(String borrowerOrCoapplicant, String residencyAddressLine2) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setResidencyAddressLine2(residencyAddressLine2);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setResidencyAddressLine2(residencyAddressLine2);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his residency town/city : (.*)$")
    public void borrower_coapplicant_user_types_his_residency_towncity(String borrowerOrCoapplicant, String residencyTownCity) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setResidencyTownCity(residencyTownCity);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setResidencyTownCity(residencyTownCity);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects his residency county/state : (.*)$")
    public void borrower_coapplicant_user_selects_his_residency_countystate(String borrowerOrCoapplicant, String residencyCountyState) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.selectResidencyCountyState(residencyCountyState);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.selectResidencyCountyState(residencyCountyState);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his postcode/zip : (.*)$")
    public void borrower_coapplicant_user_types_his_postcode_zip(String borrowerOrCoapplicant, String residencyPostcodeZip) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setResidencyPostcodeZip(residencyPostcodeZip);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setResidencyPostcodeZip(residencyPostcodeZip);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects his residency country : (.*)")
    public void borrower_coapplicant_user_selects_his_residency_country(String borrowerOrCoapplicant, String residencyCountry) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.selectResidencyCountry(residencyCountry);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.selectResidencyCountry(residencyCountry);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects his residency accommodation : (Rented on contract|Rented from family/friends|Property owner|Others)$")
    public void borrower_coapplicant_user_selects_his_residency_accommodation(String borrowerOrCoapplicant, String residencyAccommodation) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.selectResidencyAccommodation(residencyAccommodation);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.selectResidencyAccommodation(residencyAccommodation);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his residency rent : (.*)$")
    public void borrower_coapplicant_user_types_his_residency_rent(String borrowerOrCoapplicant, String residencyRent) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage.setResidencyRent(residencyRent);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage.setResidencyRent(residencyRent);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

//    boolean isLivedLast3Years();
//    IPersonalDetailsPage checkLivedLast3YearsYes();
//    IPersonalDetailsPage checkLivedLast3YearsNo();

    @Given("^(Borrower) checks if he (is not|is) living since 3 years$")
    public void borrower_coapplicant_user_checks_if_he_is_living_since_3_years(String borrowerOrCoapplicant, String sLivedLast3Years) {
        boolean bLivedLast3Years = sLivedLast3Years.equals("is");
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.checkLivedLast3Years(bLivedLast3Years);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.checkLivedLast3Years(bLivedLast3Years);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his previous residency address in line 1 : (.*)$")
    public void borrower_coapplicant_user_types_his_previous_residency_address_line1(String borrowerOrCoapplicant, String previousResidencyAddressLine1) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setPreviousResidencyAddressLine1(previousResidencyAddressLine1);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setPreviousResidencyAddressLine1(previousResidencyAddressLine1);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his previous residency address in line 2 : (.*)$")
    public void borrower_coapplicant_user_types_his_previous_residency_address_line2(String borrowerOrCoapplicant, String previousResidencyAddressLine2) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setPreviousResidencyAddressLine2(previousResidencyAddressLine2);
                break;
//            case "coapplicant":
//                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setPreviousResidencyAddressLine2(previousResidencyAddressLine2);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his previous residency town/city : (.*)$")
    public void borrower_coapplicant_user_types_his_previous_residency_towncity(String borrowerOrCoapplicant, String previousResidencyTownCity) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setPreviousResidencyTownCity(previousResidencyTownCity);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setPreviousResidencyTownCity(previousResidencyTownCity);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects his previous residency county/state : (.*)$")
    public void borrower_coapplicant_user_selects_his_previous_residency_countystate(String borrowerOrCoapplicant, String residencyCountyState) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.selectResidencyCountyState(residencyCountyState);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.selectResidencyCountyState(residencyCountyState);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his previous residency postcode/zip : (.*)$")
    public void borrower_coapplicant_user_types_his_previous_residency_postcodezip(String borrowerOrCoapplicant, String previousResidencyPostcodeZip) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.setPreviousResidencyPostcodeZip(previousResidencyPostcodeZip);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.setPreviousResidencyPostcodeZip(previousResidencyPostcodeZip);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects his previous residency country : (.*)$")
    public void borrower_coapplicant_user_selects_his_previous_residency_country(String borrowerOrCoapplicant, String previousResidencyCountry) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage.selectPreviousResidencyCountry(previousResidencyCountry);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage.selectPreviousResidencyCountry(previousResidencyCountry);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types his previous residency country : (.*)$")
    public void borrower_coapplicant_user_types_his_previous_residency_country(String borrowerOrCoapplicant, String previousResidencyCountry) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage.setPreviousResidencyCountry(previousResidencyCountry);
                break;
//            case "coapplicant":
//                coapplicantPersonalDetailsPage.setPreviousResidencyCountry(previousResidencyCountry);
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) saves his personal details data$")
    public void borrower_coapplicant_user_saves(String borrowerOrCoapplicant) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
                borrowerPersonalDetailsPage = borrowerPersonalDetailsPage.clickSave();
//                formsPage = new FormsPage(ApiSupportWebDriverStepDef.getWebDriverInstance());
//                formsPage.isLoaded();
//                formsPage.isBorrowerPersonalDetailsValid(user.getFirstName());
//                if ( StringUtils.isNotEmpty(user.getEmailCoApplicant()) )
//                    borrowerPersonalDetailsPage.isBorrowerPersonalDetailsValid(user.getFirstName());
                break;
//            case "coapplicant":
//
//                // TODO create CLV bug ... if it fixed the issues
//                borrower_coapplicant_user_types_his_lastname(borrowerOrCoapplicant, personalDetailsData.getLastName());
//                borrower_coapplicant_user_checks_his_gender(borrowerOrCoapplicant, personalDetailsData.getGender());
//
//                coapplicantPersonalDetailsPage = coapplicantPersonalDetailsPage.clickSave();
////                formsPage = new FormsPage(ApiSupportWebDriverStepDef.getWebDriverInstance());
////                formsPage.isLoaded();
////                formsPage.isCoapplicantPersonalDetailsValid(user.getFirstNameCoApplicant());
//                coapplicantPersonalDetailsPage.isCoapplicantPersonalDetailsValid(user.getFirstNameCoApplicant());
//                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

}
