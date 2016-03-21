package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.r2development.leveris.bdd.borrower.model.PersonalDetailsData;
import com.r2development.leveris.bdd.borrower.model.ResidencyData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class YourResidenciesStepDef {

    private static final Log log = LogFactory.getLog(YourResidenciesStepDef.class);

    private final WebDriver webDriver;

    @Inject
    IUser user;
    IBorrowerHomePage borrowerHomePage;
    IPersonalDetailsPage borrowerPersonalDetailsPage;
    IYourResidenciesPage yourResidenciesPage;

    @Inject
    YourResidenciesStepDef(SharedDriver webDriver/*, IUser user*/) {
        this.webDriver = webDriver;
//        this.user = user;
        borrowerPersonalDetailsPage = new PersonalDetailsPage(webDriver);
        yourResidenciesPage = new YourResidenciesPage(webDriver);
    }


    @And("^Borrower fills in (Current residency|Other / previous residency)$")
    public void borrower_fills_in_currentOrPrevious_residency(String formType, List<String> yourResidenciesFormData){

        ResidencyData residencyData = new ResidencyData(yourResidenciesFormData);
        Assert.assertEquals(
                "'Borrower fills in '" + formType + "' have Failed due to data table formType declaration. \n " +
                        "formType = '" + formType + "' MUST equals to the residencyData.getFormType() : '" + residencyData.getFormType() + "'",
                formType,
                residencyData.getFormType()
        );
        //borrower_clicks_on_currentOrPreviousResidency(formType); due to bug adding new residency
        yourResidenciesPage.clickNext();

    }


    @And("^Borrower clicks on (Current residency|Other / previous residency)$")
    public void borrower_clicks_on_currentOrPreviousResidency(String formType){
        switch (formType) {
            case "Current residency":
                yourResidenciesPage = yourResidenciesPage.clickCurrentResidency();
                break;

            case "Other / previous residency":
                yourResidenciesPage = yourResidenciesPage.clickOtherPreviousResidency();
                break;
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

}
