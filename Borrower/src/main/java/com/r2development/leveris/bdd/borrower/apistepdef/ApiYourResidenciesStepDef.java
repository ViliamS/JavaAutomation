package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.r2development.leveris.bdd.borrower.model.ResidencyData;
import com.r2development.leveris.di.IHttpResponse;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

import java.util.List;

public class ApiYourResidenciesStepDef {

    private static final Log log = LogFactory.getLog(ApiYourResidenciesStepDef.class.getName());

    @Inject
    IUser user;
    @Inject
    IHttpResponse httpResponse;

    private boolean isThereResidencyList = false;

    @Inject
    ApiYourResidenciesStepDef(IHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @And("^(Borrower) clicks on Residency link$")
    public void borrower_clicks_on_link(String userType){

    }

    @And("^(Borrower) fills in (Current residency|Other/previous residency)$")
    public void borrower_fills_in_currentOrPrevious_residency(String userType, String formType, List<String> yourResidenciesFormData){

        ResidencyData residencyData = new ResidencyData(yourResidenciesFormData);

        Assert.assertEquals(
                "'Borrower fills in '" + formType + "' have Failed due to data table formType declaration. \n " +
                        "formType = '" + formType + "' MUST equals to the residencyData.getFormType() : '" + residencyData.getFormType() + "'",
                formType,
                residencyData.getFormType()
        );

        borrower_user_clicks_add_residency(formType);

        switch (formType) {
            case "Current residency":
                borrower_user_types_his_address_line_1(formType, residencyData.getAddressLine1());
                if ( !StringUtils.isEmpty(residencyData.getAddressLine2()) )
                    borrower_user_types_his_address_line_2(formType, residencyData.getAddressLine2());
                borrower_user_types_his_towncity(formType, residencyData.getTownCity());
                if ( !StringUtils.isEmpty(residencyData.getCountry()) && (residencyData.getCountry().equals("United Kingdom") || residencyData.getCountry().equals("Ireland")) )
                    borrower_user_selects_his_countystate(formType, residencyData.getCountyState());
                if ( !StringUtils.isEmpty(residencyData.getPostcodeZip()))
                    borrower_user_types_his_postcode_zip(formType, residencyData.getPostcodeZip());
                borrower_user_selects_his_country(formType, residencyData.getCountry());
                break;
            case "Other/previous residency":
                borrower_user_types_his_address_line_1(formType, residencyData.getAddressLine1());
                if ( !StringUtils.isEmpty(residencyData.getAddressLine2()) )
                    borrower_user_types_his_address_line_2(formType, residencyData.getAddressLine2());
                borrower_user_types_his_towncity(formType, residencyData.getTownCity());
                if ( !StringUtils.isEmpty(residencyData.getCountry()) && (residencyData.getCountry().equals("United Kingdom") || residencyData.getCountry().equals("Ireland")) )
                    borrower_user_selects_his_countystate(formType, residencyData.getCountyState());
                if ( !StringUtils.isEmpty(residencyData.getPostcodeZip()))
                    borrower_user_types_his_postcode_zip(formType, residencyData.getPostcodeZip());
                borrower_user_selects_his_country(formType, residencyData.getCountry());
                break;
        }

        borrower_user_clicks_save_and_close(userType, formType);

    }

    @And("^(Borrower) clicks \"Add Residency\"")
    public void borrower_user_clicks_add_residency(String userType) {

    }

    @And("^Borrower clicks on (Current residency|Other/previous residency)$")
    public void borrower_clicks_on_currentOrPreviousResidency(String formType){
        switch (formType) {
            case "Current residency":
                break;
            case "Other/previous residency":
                break;
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) address line 1 : (.*)$")
    public void borrower_user_types_his_address_line_1(String userType, String residencyAddressLine1) {
        switch(userType) {
            case "Borrower":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) address line 2 : (.*)$")
    public void borrower_user_types_his_address_line_2(String userType, String residencyAddressLine2) {
        switch(userType) {
            case "Borrower":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) town/city : (.*)$")
    public void borrower_user_types_his_towncity(String userType, String residencyTownCity) {
        switch(userType) {
            case "Borrower":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects (Current residency|Other/previous residency) county/state : (.*)$")
    public void borrower_user_selects_his_countystate(String userType, String residencyCountyState) {
        switch(userType) {
            case "Borrower":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) postcode/zip : (.*)$")
    public void borrower_user_types_his_postcode_zip(String userType, String residencyPostcodeZip) {
        switch(userType) {
            case "Borrower":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects (Current residency|Other/previous residency) country : (.*)")
    public void borrower_user_selects_his_country(String userType, String residencyCountry) {
        switch(userType) {
            case "Borrower":
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) clicks (Current residency|Other/previous residency) \"cancel\"$")
    public void borrower_user_clicks_cancel(String userType, String residencyType) {

    }

    @Given("^(Borrower) clicks (Current residency|Other/previous residency) \"save and close\"")
    public void borrower_user_clicks_save_and_close(String userType, String formType) {

    }

    @And("^(Borrower) clicks (Residency) \"Done\"$")
    public void borrower_user_clicks_done(String userType, String formType) {

    }

    @When("^(Borrower) clicks (Current residency|Other/previous residency) \"Edit\" item \\d+$")
    public void borrower_user_clicks_edit(String userType, String formType, int item) {

    }

    @When("^(Borrower) clicks (Current residency|Other/previous residency) \"Delete\" item \\d+$")
    public void borrower_user_clicks_delete(String userType, String formType, int item) {

    }
}