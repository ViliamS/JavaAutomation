package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.r2development.leveris.bdd.borrower.model.ResidencyData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.IYourResidenciesPage;
import com.r2development.leveris.selenium.borrower.pageobjects.IYourResidenciesSection;
import com.r2development.leveris.selenium.borrower.pageobjects.YourResidenciesPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

import java.util.List;

public class YourResidenciesStepDef {

    private static final Log log = LogFactory.getLog(YourResidenciesStepDef.class.getName());

    @Inject
    IUser user;

    private IYourResidenciesPage yourResidencies;
    private IYourResidenciesSection yourResidenciesSection;


    @Inject
    YourResidenciesStepDef(SharedDriver webDriver) {
        this.yourResidencies = new YourResidenciesPage(webDriver);
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

        borrower_user_clicks_add_residency(userType);

        switch (formType) {

            case "Current residency":
                borrower_clicks_on_currentOrPreviousResidency(formType);
                borrower_user_types_his_address_line_1(userType, formType, residencyData.getAddressLine1());
                if ( !StringUtils.isEmpty(residencyData.getAddressLine2()) )
                    borrower_user_types_his_address_line_2(userType, formType, residencyData.getAddressLine2());
                borrower_user_types_his_towncity(userType, formType, residencyData.getTownCity());
                if ( !StringUtils.isEmpty(residencyData.getCountry()) && (residencyData.getCountry().equals("United Kingdom") || residencyData.getCountry().equals("Ireland")) )
                    borrower_user_selects_his_countystate(userType, formType, residencyData.getCountyState());
                if ( !StringUtils.isEmpty(residencyData.getPostcodeZip()))
                    borrower_user_types_his_postcode_zip(userType, formType, residencyData.getPostcodeZip());
                borrower_user_selects_his_country(userType, formType, residencyData.getCountry());
                borrower_user_types_his_start_date(userType, formType, residencyData.getStartDate());
                borrower_user_types_his_residential_status(userType, formType, residencyData.getResidentialStatus());
                break;

            case "Other/previous residency":
                borrower_clicks_on_currentOrPreviousResidency(formType);
                borrower_user_types_his_address_line_1(userType, formType, residencyData.getAddressLine1());
                if ( !StringUtils.isEmpty(residencyData.getAddressLine2()) )
                    borrower_user_types_his_address_line_2(userType, formType, residencyData.getAddressLine2());
                borrower_user_types_his_towncity(userType, formType, residencyData.getTownCity());
                if ( !StringUtils.isEmpty(residencyData.getCountry()) && (residencyData.getCountry().equals("United Kingdom") || residencyData.getCountry().equals("Ireland")) )
                    borrower_user_selects_his_countystate(userType, formType, residencyData.getCountyState());
                if ( !StringUtils.isEmpty(residencyData.getPostcodeZip()))
                    borrower_user_types_his_postcode_zip(userType, formType, residencyData.getPostcodeZip());
                borrower_user_selects_his_country(userType, formType, residencyData.getCountry());
                borrower_user_types_his_start_date(userType, formType, residencyData.getStartDate());
                borrower_user_types_his_end_date(userType, formType, residencyData.getEndDate());
                break;
        }

        borrower_user_clicks_save_and_close(userType, formType);

    }

    @And("^(Borrower) clicks \"Add Residency\"")
    public void borrower_user_clicks_add_residency(String userType) {
        yourResidenciesSection = yourResidencies.clickAdd();
    }

    @And("^Borrower clicks on (Current residency|Other/previous residency)$")
    public void borrower_clicks_on_currentOrPreviousResidency(String formType){
        switch (formType) {
            case "Current residency":
                yourResidenciesSection = yourResidencies.clickCurrentResidency();
                break;
            case "Other/previous residency":
                yourResidenciesSection = yourResidencies.clickOtherPreviousResidency();
                break;
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) address line 1 : (.*)$")
    public void borrower_user_types_his_address_line_1(String userType, String formType, String residencyAddressLine1) {
        switch(userType) {
            case "Borrower":
                yourResidenciesSection.setAddressLine1(residencyAddressLine1);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) address line 2 : (.*)$")
    public void borrower_user_types_his_address_line_2(String userType, String formType, String residencyAddressLine2) {
        switch(userType) {
            case "Borrower":
                yourResidenciesSection.setAddressLine2(residencyAddressLine2);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) town/city : (.*)$")
    public void borrower_user_types_his_towncity(String userType, String formType, String residencyTownCity) {
        switch(userType) {
            case "Borrower":
                yourResidenciesSection.setTownCity(residencyTownCity);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects (Current residency|Other/previous residency) county/state : (.*)$")
    public void borrower_user_selects_his_countystate(String userType, String formType, String residencyCountyState) {
        switch(userType) {
            case "Borrower":
                yourResidenciesSection.setCountyState(residencyCountyState);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) postcode/zip : (.*)$")
    public void borrower_user_types_his_postcode_zip(String userType, String formType, String residencyPostcodeZip) {
        switch(userType) {
            case "Borrower":
                yourResidenciesSection.setPostCodeZip(residencyPostcodeZip);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects (Current residency|Other/previous residency) country : (.*)")
    public void borrower_user_selects_his_country(String userType, String formType, String residencyCountry) {
        switch(userType) {
            case "Borrower":
                yourResidenciesSection.setCountry(residencyCountry);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) start date : (.*)")
    public void borrower_user_types_his_start_date(String userType, String formType, String startDate) {
        yourResidenciesSection.setStartDate(startDate);
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) end date : (.*)")
    public void borrower_user_types_his_end_date(String userType, String formType, String end) {
        yourResidenciesSection.setEndDate(end);
    }

    @Given("^(Borrower) selects (Current residency|Other/previous residency) residential status: (.*)")
    public void borrower_user_types_his_residential_status(String userType, String formType, String end) {
        yourResidenciesSection.setResidentalStatus(end);
    }

    @Given("^(Borrower) clicks (Current residency|Other/previous residency) \"cancel\"$")
    public void borrower_user_clicks_cancel(String userType, String formType) {
        yourResidenciesSection.clickCancel();
    }

    @Given("^(Borrower) clicks (Current residency|Other/previous residency) \"save and close\"")
    public void borrower_user_clicks_save_and_close(String userType, String formType) {
        yourResidenciesSection.clickSaveAndClose();
    }

    @And("^(Borrower) clicks (Residency) \"Done\"$")
    public void borrower_user_clicks_done(String userType, String formType) {
        yourResidencies.clickDone();
    }

    @When("^(Borrower) clicks (Current residency|Other/previous residency) \"Edit\" item \\d+$")
    public void borrower_user_clicks_edit(String userType, String formType, int item) {
    }

    @When("^(Borrower) clicks (Current residency|Other/previous residency) \"Delete\" item \\d+$")
    public void borrower_user_clicks_delete(String userType, String formType, int item) {
    }
}