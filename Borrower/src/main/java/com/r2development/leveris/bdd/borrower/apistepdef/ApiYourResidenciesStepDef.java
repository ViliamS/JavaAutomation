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

    @Given("^(Borrower) types (Current residency|Other/previous residency) start date : (.*)")
    public void borrower_user_types_his_start_date(String userType, String formType, String startDate) {

    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) end date : (.*)")
    public void borrower_user_types_his_end_date(String userType, String formType, String end) {

    }

    @Given("^(Borrower) selects (Current residency|Other/previous residency) residential status: (.*)")
    public void borrower_user_types_his_residential_status(String userType, String formType, String end) {
//        <select class="content control combobox valid" name="root:c:w:pnlMortgageApplicationResidency:c:w:cmbResidentialStatus:combobox" id="combobox3ca" wicketpath="main_c_form_dialogWrapper_dialog_form_root_c_w_pnlMortgageApplicationResidency_c_w_cmbResidentialStatus_combobox" aria-readonly="false" aria-labelledby="label3c9" data-default="" data-readonly="false" data-enabled="true" aria-required="true" data-height="40" tabindex="3506" data-whisper="true" data-forcevalue="true" style="display:none;" data-button="true">
//        <option selected="selected" value="">Choose One</option>
//        <option value="OWN">Owner</option>
//        <option value="LWP">Living with parents</option>
//        <option value="TEN">Tenant</option>
//        <option value="CTE">Council tenant</option>
//        <option value="JOW">Joint owner</option>
//        <option value="OTH">Other</option>
//        </select>
    }

    @Given("^(Borrower) clicks (Current residency|Other/previous residency) \"cancel\"$")
    public void borrower_user_clicks_cancel(String userType, String residencyType) {

    }

    @Given("^(Borrower) clicks (Current residency|Other/previous residency) \"save and close\"")
    public void borrower_user_clicks_save_and_close(String userType, String formType) {

//        root:c:w:pnlMortgageApplicationResidency:c:w:pnlAddressField:data:
//        root:c:w:pnlMortgageApplicationResidency:c:w:txtAddressLine2:tb:
//        root:c:w:pnlMortgageApplicationResidency:c:w:txtTownCity:tb:Galway
//        root:c:w:pnlMortgageApplicationResidency:c:w:txtPostcode:tb:
//        root:c:w:pnlMortgageApplicationResidency:c:w:cmbCountry:combobox:IE
//        root:c:w:pnlMortgageApplicationResidency:c:w:txtStartDate:tb:28/02/2016
//        root:c:w:pnlMortgageApplicationResidency:c:w:txtEndDate:tb:
//        root:c:w:pnlMortgageApplicationResidency:c:w:cmbResidentialStatus:combobox:LWP
//        root:c:w:txtHiddenPreviousAddrLine1Holder:tb:
//        stepToken:1
//        root:c:w:btnNext:submit:1

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