package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.r2development.leveris.bdd.borrower.model.ResidencyData;
import com.r2development.leveris.di.IABorrowerHttpContext;
import com.r2development.leveris.di.IBorrowerHttpResponse;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.utils.enums.COUNTRY;
import com.r2development.leveris.utils.enums.COUNTY_ENGLAND;
import com.r2development.leveris.utils.enums.COUNTY_IRELAND;
import com.r2development.leveris.utils.enums.RESIDENTIAL_STATUS;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

//@Singleton
public class ApiYourResidenciesStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourResidenciesStepDef.class.getName());

    @Inject
    IABorrowerHttpContext localContext;
    @Inject
    IUser user;
    @Inject
    IBorrowerHttpResponse httpResponse;

    private boolean isThereResidencyList = false;
    private String btnHiddenSubmitWicketInterface = StringUtils.EMPTY;
    private String btnHiddenRefreshWicketInterface = StringUtils.EMPTY;

    @Inject
    ApiYourResidenciesStepDef(IBorrowerHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @And("^(Borrower) clicks on Residency link$")
    public void borrower_clicks_on_link(String userType){

    }

    @And("^(Borrower) fills in (Current residency|Other/previous residency)$")
    public void borrower_fills_in_currentOrPrevious_residency(String userType, String formType, List<String> yourResidenciesFormData) throws IOException {

        ResidencyData residencyData = new ResidencyData(yourResidenciesFormData);

        Assert.assertEquals(
                "'Borrower fills in '" + formType + "' have Failed due to data table formType declaration. \n " +
                        "formType = '" + formType + "' MUST equals to the residencyData.getFormType() : '" + residencyData.getFormType() + "'",
                formType,
                residencyData.getFormType()
        );

        borrower_clicks_on_currentOrPreviousResidency(userType, residencyData.getFormType());

        switch (residencyData.getFormType()) {
            case "Current residency":
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
                borrower_user_selects_residential_status(userType, formType, residencyData.getResidentialStatus());
                break;
            case "Other/previous residency":
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
                break;
        }

        borrower_clicks_residency_save_and_close(userType, formType);

    }

    @And("^(Borrower) clicks \"Add Residency\"")
    public void borrower_user_clicks_add_residency(String userType) {
    }

    @And("^(Borrower) clicks on (Current residency|Other/previous residency)$")
    public void borrower_clicks_on_currentOrPreviousResidency(String userType, String residencyType) throws IOException {

        Document residencyListDoc = Jsoup.parse(httpResponse.getHttpResponse());

        Document residencyListDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        String currentComponentId = StringUtils.EMPTY;
        for (String aComponentId : componentId) {
            try {
                residencyListDoc2 = Jsoup.parse(residencyListDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);
                currentComponentId = aComponentId;
                if ( !aComponentId.equals("main") )
                    isThereResidencyList = true;
                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

        if ( currentComponentId.equals("main") ) {
            if ( !isThereResidencyList ) {
                String onclickBtnHiddenSubmit = residencyListDoc2.select("a[id~=submit]").select("a[wicketpath~=btnHiddenSubmit]").attr("onclick");
                Pattern pBtnHiddenSubmit = Pattern.compile("\\?(wicket:interface=.*)&");
                Matcher mBtnHiddenSubmit = pBtnHiddenSubmit.matcher(onclickBtnHiddenSubmit);
                while (mBtnHiddenSubmit.find()) {
                    btnHiddenSubmitWicketInterface = mBtnHiddenSubmit.group(1);
                }
            }
            else {
                String onclickBtnHiddenRefresh = residencyListDoc2.select("a[id~=submit]").select("a[wicketpath~=btnHiddenRefresh]").attr("onclick");
                Pattern pBtnHiddenRefresh = Pattern.compile("\\?(wicket:interface=.*)&");
                Matcher mBtnHiddenRefresh = pBtnHiddenRefresh.matcher(onclickBtnHiddenRefresh);
                while(mBtnHiddenRefresh.find()) {
                    btnHiddenRefreshWicketInterface = mBtnHiddenRefresh.group(1);
                }
            }
        }

        String fixCategory = StringUtils.EMPTY;
        switch (residencyType) {
            case "Current residency":
                fixCategory = "lnkCurrentResidency";
                break;
            case "Other/previous residency":
                fixCategory = "lnkOtherResidency";
                break;
        }
        final String finalFixCategory = fixCategory;

        Elements divResidencyTypeAddElements = residencyListDoc2.select("div[data-path~=pnlNoEmplyments").select("div[data-path~=" + finalFixCategory + "]");

        Elements divEmploymentTypeAddElements2;
//        Map<String, String> wicketInterfaceMap = new LinkedHashMap<>();
        String linkAdd = null;
//        String currentKey = "linkAdd";
        if ( divResidencyTypeAddElements.size() != 0 ) {
            for (Element current : divResidencyTypeAddElements) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_").select("a[wicketpath~=" + finalFixCategory + "_dialog]").attr("onclick");
                Pattern pWicketInterface = Pattern.compile("\\?wicket:interface=(.*)&");
                Matcher mWicketInterface = pWicketInterface.matcher(currentOnClick);
                String currentWicketInterface = null;
                while (mWicketInterface.find()) {
                    currentWicketInterface = mWicketInterface.group(1);
                }
//                wicketInterfaceMap.put(currentKey, currentWicketInterface);
                linkAdd = currentWicketInterface;
            }
        }
        else /*if ( divEmploymentTypeAddElements.size() == 0 )*/ {
            isThereResidencyList = true;
            divEmploymentTypeAddElements2 = residencyListDoc2.select("div[data-path~=pnlResidencyList btnAdd]");
            for (Element current : divEmploymentTypeAddElements2) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath=main_c_form_form_root_c_w_pnlResidencyList_c_w_btnAdd_dialog]").attr("onclick");
                Pattern pWicketInterface = Pattern.compile("\\?wicket:interface=(.*)&");
                Matcher mWicketInterface = pWicketInterface.matcher(currentOnClick);
                String currentWicketInterface = null;
                while (mWicketInterface.find()) {
                    currentWicketInterface = mWicketInterface.group(1);
                }
//                wicketInterfaceMap.put(currentKey, currentWicketInterface);
                linkAdd = currentWicketInterface;
            }
        }
        final String finalLinkAdd = linkAdd;

        String stepToken = residencyListDoc2.select("input[name=stepToken").attr("value");
        Map<String, String> linkAddParameters = new LinkedHashMap<>();
        linkAddParameters.put("stepToken", stepToken);


        String employmentLinkAddResponse = requestHttpPost(
                httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoLiability:c:w:lnkAddPaye:dialog::IBehaviorListener:0:",
//                        System.getProperty("borrower") + "/form.2?wicket:interface=" + wicketInterfaceMap.get("lnkAdd" + finalFixCategory),
                System.getProperty("borrower") + "/form.2?wicket:interface=" + finalLinkAdd,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                linkAddParameters,
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(employmentLinkAddResponse);

        switch ( residencyType ) {
            case "Current residency":

                if ( isThereResidencyList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkAddCurrentResidency:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoEmplyments:c:w:lnkAddCurrentResidency:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);

                }

                /*
                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("data",
                                        "{\"widgets\":[" +
                                                "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlPersonalLoan\",\"data\":{\"visible\":true},\"delta\":160,\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlPaymentFreq\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlCreditCard\",\"data\":{\"enable\":false}},{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"enable\":true}}," +
                                                "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"enable\":true}}," +
                                                "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"enable\":true}}," +
                                                "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"enable\":true}}," +
                                                "{\"widget\":\"pnlAddNew pnlRepaymentAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlMaintenance\",\"data\":{\"enable\":false}}," +
                                                "{\"widget\":\"pnlAddNew pnlNote txaNote\",\"data\":{\"enable\":false}}" +
                                                "{\"widget\":\"pnlAddNew pnlOtherValue crbValue\",\"data\":{\"enable\":false}}" +
                                                "]}");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
                */
                break;
            case "Other/previous residency":

                if ( isThereResidencyList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkAddOtherResidency:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoLiability:c:w:lnkAddCreditCard:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);

                }

                /*
                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("data",
                                        "{\"widgets\":[" +
                                                "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlPersonalLoan\",\"data\":{\"enable\":false}}," +
                                                "{\"widget\":\"pnlAddNew pnlPaymentFreq cmbRepaymentFrequency\",\"data\":{\"enable\":false}}," +
                                                "{\"widget\":\"pnlAddNew pnlCreditCard\",\"data\":{\"visible\":true},\"delta\":240,\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":false},\"delta\":-80,\"visibleEvent\":\"hide\"}," +
                                                "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"enable\":false}}," +
                                                "{\"widget\":\"pnlAddNew pnlRepaymentAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                                "{\"widget\":\"pnlAddNew pnlMaintenance\",\"data\":{\"enable\":false}}," +
                                                "{\"widget\":\"pnlAddNew pnlNote txaNote\",\"data\":{\"enable\":false}}" +
                                                "{\"widget\":\"pnlAddNew pnlOtherValue crbValue\",\"data\":{\"enable\":false}}" +
                                                "]}");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY

                );
                */
                break;
            default:
                log.info("Huston, we have problem ! Do we have a new financial type ?");
        }

    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) address line 1 : (.*)$")
    public void borrower_user_types_his_address_line_1(String userType, String formType, String residencyAddressLine1) {
        switch(userType) {
            case "Borrower":
                residencyParameters.put("root:c:w:pnlMortgageApplicationResidency:c:w:pnlAddressField:data", "{\"countryCode\":\"CZ\",\"route\":\"\",\"streetNumber\":\"\",\"postalCode\":\"110 00\",\"region\":\"Prague\",\"houseNumber\":\"\",\"inputText\":\"Staré Město, Prague, Czech Republic\",\"county\":\"Hlavní město Praha\"}");
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) address line 2 : (.*)$")
    public void borrower_user_types_his_address_line_2(String userType, String formType, String residencyAddressLine2) {
        switch(userType) {
            case "Borrower":
                residencyParameters.put("root:c:w:pnlMortgageApplicationResidency:c:w:txtAddressLine2:tb", residencyAddressLine2);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) town/city : (.*)$")
    public void borrower_user_types_his_towncity(String userType, String formType, String residencyTownCity) {
        switch(userType) {
            case "Borrower":
                residencyParameters.put("root:c:w:pnlMortgageApplicationResidency:c:w:txtTownCity:tb", residencyTownCity);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects (Current residency|Other/previous residency) county/state : (.*)$")
    public void borrower_user_selects_his_countystate(String userType, String formType, String residencyCountyState) {
        switch(userType) {
            case "Borrower":
                if (COUNTY_IRELAND.getShortValueByLongValue(residencyCountyState) != null)
                    residencyParameters.put("root:c:w:pnlMortgageApplicationResidency:c:w:pnlCounty:c:w:pnlEnglandCounty:c:w:cmbCountyState2:combobox", residencyCountyState);
                else if (COUNTY_ENGLAND.getShortValueByLongValue(residencyCountyState) != null)
                    residencyParameters.put("root:c:w:pnlMortgageApplicationResidency:c:w:pnlCounty:c:w:pnlIrelandCounty:c:w:cmbCountyState:combobox", residencyCountyState);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) postcode/zip : (.*)$")
    public void borrower_user_types_his_postcode_zip(String userType, String formType, String residencyPostcodeZip) {
        switch(userType) {
            case "Borrower":
                residencyParameters.put("root:c:w:pnlMortgageApplicationResidency:c:w:txtPostcode:tb", residencyPostcodeZip);
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) selects (Current residency|Other/previous residency) country : (.*)")
    public void borrower_user_selects_his_country(String userType, String formType, String residencyCountry) {

        /*
        <select class="content control combobox valid" name="root:c:w:pnlMortgageApplicationResidency:c:w:cmbCountry:combobox" id="combobox7a3" wicketpath="main_c_form_dialogWrapper_dialog_form_root_c_w_pnlMortgageApplicationResidency_c_w_cmbCountry_combobox" aria-readonly="false" aria-labelledby="label7a2" data-default="CZ" data-readonly="false" data-enabled="true" aria-required="true" data-height="40" tabindex="3506" data-whisper="true" data-forcevalue="true" style="display:none;" data-button="true">
        <option value="AF">Afghanistan</option>
        <option value="AX">Åland Islands</option>
        <option value="AL">Albania</option>
        <option value="DZ">Algeria</option>
        <option value="AS">American Samoa</option>
        <option value="AD">Andorra</option>
        <option value="AO">Angola</option>
        <option value="AI">Anguilla</option>
        <option value="AQ">Antarctica</option>
        <option value="AG">Antigua and Barbuda</option>
        <option value="AR">Argentina</option>
        <option value="AM">Armenia</option>
        <option value="AW">Aruba</option>
        <option value="AU">Australia</option>
        <option value="AT">Austria</option>
        <option value="AZ">Azerbaijan</option>
        <option value="BS">Bahamas</option>
        <option value="BH">Bahrain</option>
        <option value="BD">Bangladesh</option>
        <option value="BB">Barbados</option>
        <option value="BY">Belarus</option>
        <option value="BE">Belgium</option>
        <option value="BZ">Belize</option>
        <option value="BJ">Benin</option>
        <option value="BM">Bermuda</option>
        <option value="BT">Bhutan</option>
        <option value="BO">Bolivia</option>
        <option value="BA">Bosnia and Herzegovina</option>
        <option value="BW">Botswana</option>
        <option value="BV">Bouvet Island</option>
        <option value="BR">Brazil</option>
        <option value="IO">British Indian Ocean Territory</option>
        <option value="VG">British Virgin Islands</option>
        <option value="BN">Brunei</option>
        <option value="BG">Bulgaria</option>
        <option value="BF">Burkina Faso</option>
        <option value="MM">Burma (Republic of the Union of Myanmar)</option>
        <option value="BI">Burundi</option>
        <option value="KH">Cambodia</option>
        <option value="CM">Cameroon</option>
        <option value="CA">Canada</option>
        <option value="CV">Cape Verde</option>
        <option value="BQ">Caribbean Netherlands</option>
        <option value="KY">Cayman Islands</option>
        <option value="CF">Central African Republic</option>
        <option value="TD">Chad</option>
        <option value="CL">Chile</option>
        <option value="CN">China</option>
        <option value="CX">Christmas Island</option>
        <option value="CC">Cocos (Keeling) Islands</option>
        <option value="CO">Colombia</option>
        <option value="KM">Comoros</option>
        <option value="CG">Congo (Republic of)</option>
        <option value="CK">Cook Islands</option>
        <option value="CR">Costa Rica</option>
        <option value="CI">Côte d’Ivoire (Ivory Coast)</option>
        <option value="HR">Croatia</option>
        <option value="CU">Cuba</option>
        <option value="CW">Curaçao</option>
        <option value="CY">Cyprus</option>
        <option selected="selected" value="CZ">Czech Republic</option>
        <option value="CD">Democratic Republic of the Congo</option>
        <option value="DK">Denmark</option>
        <option value="DJ">Djibouti</option>
        <option value="DM">Dominica</option>
        <option value="DO">Dominican Republic</option>
        <option value="EC">Ecuador</option>
        <option value="EG">Egypt</option>
        <option value="SV">El Salvador</option>
        <option value="GQ">Equatorial Guinea</option>
        <option value="ER">Eritrea</option>
        <option value="EE">Estonia</option>
        <option value="ET">Ethiopia</option>
        <option value="FK">Falkland Islands</option>
        <option value="FO">Faroe Islands</option>
        <option value="FJ">Fiji</option>
        <option value="FI">Finland</option>
        <option value="FR">France</option>
        <option value="GF">French Guiana</option>
        <option value="PF">French Polynesia</option>
        <option value="TF">French Southern Territories</option>
        <option value="GA">Gabon</option>
        <option value="GM">Gambia</option>
        <option value="GE">Georgia</option>
        <option value="DE">Germany</option>
        <option value="GH">Ghana</option>
        <option value="GI">Gibraltar</option>
        <option value="GR">Greece</option>
        <option value="GL">Greenland</option>
        <option value="GD">Grenada</option>
        <option value="GP">Guadeloupe</option>
        <option value="GU">Guam</option>
        <option value="GT">Guatemala</option>
        <option value="GG">Guernsey</option>
        <option value="GN">Guinea</option>
        <option value="GW">Guinea-Bissau</option>
        <option value="GY">Guyana</option>
        <option value="HT">Haiti</option>
        <option value="HM">Heard and McDonald Islands</option>
        <option value="HN">Honduras</option>
        <option value="HK">Hong Kong</option>
        <option value="HU">Hungary</option>
        <option value="IS">Iceland</option>
        <option value="IN">India</option>
        <option value="ID">Indonesia</option>
        <option value="IR">Iran</option>
        <option value="IQ">Iraq</option>
        <option value="IE">Ireland</option>
        <option value="IM">Isle of Man</option>
        <option value="IL">Israel</option>
        <option value="IT">Italy</option>
        <option value="JM">Jamaica</option>
        <option value="JP">Japan</option>
        <option value="JE">Jersey</option>
        <option value="JO">Jordan</option>
        <option value="KZ">Kazakhstan</option>
        <option value="KE">Kenya</option>
        <option value="KI">Kiribati</option>
        <option value="KW">Kuwait</option>
        <option value="KG">Kyrgyzstan</option>
        <option value="LA">Laos</option>
        <option value="LV">Latvia</option>
        <option value="LB">Lebanon</option>
        <option value="LS">Lesotho</option>
        <option value="LR">Liberia</option>
        <option value="LY">Libya</option>
        <option value="LI">Liechtenstein</option>
        <option value="LT">Lithuania</option>
        <option value="LU">Luxembourg</option>
        <option value="MO">Macau</option>
        <option value="MK">Macedonia</option>
        <option value="MG">Madagascar</option>
        <option value="MW">Malawi</option>
        <option value="MY">Malaysia</option>
        <option value="MV">Maldives</option>
        <option value="ML">Mali</option>
        <option value="MT">Malta</option>
        <option value="MH">Marshall Islands</option>
        <option value="MQ">Martinique</option>
        <option value="MR">Mauritania</option>
        <option value="MU">Mauritius</option>
        <option value="YT">Mayotte</option>
        <option value="MX">Mexico</option>
        <option value="FM">Micronesia</option>
        <option value="MD">Moldova</option>
        <option value="MC">Monaco</option>
        <option value="MN">Mongolia</option>
        <option value="ME">Montenegro</option>
        <option value="MS">Montserrat</option>
        <option value="MA">Morocco</option>
        <option value="MZ">Mozambique</option>
        <option value="NA">Namibia</option>
        <option value="NR">Nauru</option>
        <option value="NP">Nepal</option>
        <option value="NL">Netherlands</option>
        <option value="NC">New Caledonia</option>
        <option value="NZ">New Zealand</option>
        <option value="NI">Nicaragua</option>
        <option value="NE">Niger</option>
        <option value="NG">Nigeria</option>
        <option value="NU">Niue</option>
        <option value="NF">Norfolk Island</option>
        <option value="KP">North Korea</option>
        <option value="MP">Northern Mariana Islands</option>
        <option value="NO">Norway</option>
        <option value="OM">Oman</option>
        <option value="PK">Pakistan</option>
        <option value="PW">Palau</option>
        <option value="PS">Palestine</option>
        <option value="PA">Panama</option>
        <option value="PG">Papua New Guinea</option>
        <option value="PY">Paraguay</option>
        <option value="PE">Peru</option>
        <option value="PH">Philippines</option>
        <option value="PN">Pitcairn</option>
        <option value="PL">Poland</option>
        <option value="PT">Portugal</option>
        <option value="PR">Puerto Rico</option>
        <option value="QA">Qatar</option>
        <option value="RE">Réunion</option>
        <option value="RO">Romania</option>
        <option value="RU">Russian Federation</option>
        <option value="RW">Rwanda</option>
        <option value="BL">Saint Barthélemy</option>
        <option value="SH">Saint Helena</option>
        <option value="KN">Saint Kitts and Nevis</option>
        <option value="LC">Saint Lucia</option>
        <option value="MF">Saint Martin (France)</option>
        <option value="SX">Saint Martin (Netherlands)</option>
        <option value="VC">Saint Vincent and Grenadines</option>
        <option value="WS">Samoa</option>
        <option value="SM">San Marino</option>
        <option value="ST">São Tome and Príncipe</option>
        <option value="SA">Saudi Arabia</option>
        <option value="SN">Senegal</option>
        <option value="RS">Serbia</option>
        <option value="SC">Seychelles</option>
        <option value="SL">Sierra Leone</option>
        <option value="SG">Singapore</option>
        <option value="SK">Slovakia</option>
        <option value="SI">Slovenia</option>
        <option value="SB">Solomon Islands</option>
        <option value="SO">Somalia</option>
        <option value="ZA">South Africa</option>
        <option value="GS">South Georgia and the South Sandwich Islands</option>
        <option value="KR">South Korea</option>
        <option value="SS">South Sudan</option>
        <option value="ES">Spain</option>
        <option value="LK">Sri Lanka</option>
        <option value="PM">St. Pierre and Miquelon</option>
        <option value="SD">Sudan</option>
        <option value="SR">Suriname</option>
        <option value="SJ">Svalbard and Jan Mayen Islands</option>
        <option value="SZ">Swaziland</option>
        <option value="SE">Sweden</option>
        <option value="CH">Switzerland</option>
        <option value="SY">Syria</option>
        <option value="TW">Taiwan</option>
        <option value="TJ">Tajikistan</option>
        <option value="TZ">Tanzania</option>
        <option value="TH">Thailand</option>
        <option value="TL">Timor-Leste</option>
        <option value="TG">Togo</option>
        <option value="TK">Tokelau</option>
        <option value="TO">Tonga</option>
        <option value="TT">Trinidad and Tobago</option>
        <option value="TN">Tunisia</option>
        <option value="TR">Turkey</option>
        <option value="TM">Turkmenistan</option>
        <option value="TC">Turks and Caicos Islands</option>
        <option value="TV">Tuvalu</option>
        <option value="UG">Uganda</option>
        <option value="UA">Ukraine</option>
        <option value="AE">United Arab Emirates</option>
        <option value="GB">United Kingdom</option>
        <option value="UM">United States Minor Outlying Islands</option>
        <option value="US">United States of America</option>
        <option value="VI">United States Virgin Islands</option>
        <option value="UY">Uruguay</option>
        <option value="UZ">Uzbekistan</option>
        <option value="VU">Vanuatu</option>
        <option value="VA">Vatican</option>
        <option value="VE">Venezuela</option>
        <option value="VN">Vietnam</option>
        <option value="WF">Wallis and Futuna Islands</option>
        <option value="EH">Western Saharan</option>
        <option value="YE">Yemen</option>
        <option value="ZM">Zambia</option>
        <option value="ZW">Zimbabwe</option>
        </select>
        */

        switch(userType) {
            case "Borrower":
                residencyParameters.put("root:c:w:pnlMortgageApplicationResidency:c:w:cmbCountry:combobox", COUNTRY.getShortValueByLongValue(residencyCountry));
                break;
            default:
                log.info("Huston, we have a problem !, Do we have a new user type ?");
        }
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) start date : (.*)")
    public void borrower_user_types_his_start_date(String userType, String formType, String startDate) {
        residencyParameters.put("root:c:w:pnlMortgageApplicationResidency:c:w:txtStartDate:tb", startDate);
    }

    @Given("^(Borrower) types (Current residency|Other/previous residency) end date : (.*)")
    public void borrower_user_types_his_end_date(String userType, String formType, String endDate) {
        residencyParameters.put("root:c:w:pnlMortgageApplicationResidency:c:w:txtEndDate:tb", endDate);
    }

    @Given("^(Borrower) selects (Current residency|Other/previous residency) residential status: (.*)")
    public void borrower_user_selects_residential_status(String userType, String formType, String residentialStatus) {
//        <select class="content control combobox valid" name="root:c:w:pnlMortgageApplicationResidency:c:w:cmbResidentialStatus:combobox" id="combobox3ca" wicketpath="main_c_form_dialogWrapper_dialog_form_root_c_w_pnlMortgageApplicationResidency_c_w_cmbResidentialStatus_combobox" aria-readonly="false" aria-labelledby="label3c9" data-default="" data-readonly="false" data-enabled="true" aria-required="true" data-height="40" tabindex="3506" data-whisper="true" data-forcevalue="true" style="display:none;" data-button="true">
//        <option selected="selected" value="">Choose One</option>
//        <option value="OWN">Owner</option>
//        <option value="LWP">Living with parents</option>
//        <option value="TEN">Tenant</option>
//        <option value="CTE">Council tenant</option>
//        <option value="JOW">Joint owner</option>
//        <option value="OTH">Other</option>
//        </select>

        residencyParameters.put("root:c:w:pnlMortgageApplicationResidency:c:w:cmbResidentialStatus:combobox", RESIDENTIAL_STATUS.getShortValueByLongValue(residentialStatus));
    }

    @Given("^(Borrower) clicks (Current residency|Other/previous residency) \"cancel\"$")
    public void borrower_user_clicks_cancel(String userType, String formType) {
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

    @Given("^(Borrower) clicks Residency \"Save and Close\"")
    public void borrower_clicks_residency_save_and_close(String userType, String formType) throws IOException {

        Map<String, String> finalResidencyParameters = new LinkedHashMap<>();

        switch ( userType ) {
            case "Borrower":
                finalResidencyParameters.putAll(residencyParameters);
                break;
            default:
                log.debug("Huston we have a problem when finalizing EmploymentIncomeParameters");
        }

        Document currentFormDoc = Jsoup.parse(httpResponse.getHttpResponse());
        Document currentFormDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for (String aComponentId : componentId) {
            try {
                currentFormDoc2 = Jsoup.parse(currentFormDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);
                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

        String stepToken = currentFormDoc2.select("input[name=stepToken]").attr("value");
        String btnNext = currentFormDoc2.select("a[id~=submit]").select("a[wicketpath~=btnNext_submit]").attr("onclick");

        Pattern pBtnNext = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnNext = pBtnNext.matcher(btnNext);

        String btnNextWicketInterface = null;
        while( mBtnNext.find() ) {
            btnNextWicketInterface = mBtnNext.group(1);
        }

//        finalFinancialParameters.put("root:c:w:pnlDetail:c:w:txtHiddenId:tb", "");
        finalResidencyParameters.put("stepToken", stepToken);
        finalResidencyParameters.put("root:c:w:btnNext:submit", "1");

        requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlDetail:c:w:btnEmploymentAdd:submit::IBehaviorListener:0:",
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:btnNext:submit::IBehaviorListener:0:",
                System.getProperty("borrower") + "/form.2?" + btnNextWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                finalResidencyParameters,
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
//        httpResponse.setHttpResponse(employmentAddResponse);

        Document currentClose = Jsoup.parse(currentFormDoc.select("component[id~=close]").select("component[encoding~=wicket]").text());
        Pattern pClose = Pattern.compile("\\?(wicket:interface=.*:)'");
        Matcher mClose = null;
        String linkClose = StringUtils.EMPTY;
//        String fixCategory = StringUtils.EMPTY;
        switch ( formType ) {
            case "Current residency":
//                finalResidencyParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "PL");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkCurrentResidency:close::IBehaviorListener:0:";
//                currentClose.select("a[id~=close]").select("main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkCurrentResidency_close").attr("onclick");
                mClose = pClose.matcher(currentClose.select("a[id~=close]").select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkCurrentResidency_close]").attr("onclick"));
                while ( mClose.find() ) {
                    linkClose = mClose.group(1);
                }
                break;
            case "Other/previous residency":
//                finalResidencyParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "CRD");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkOtherResidency:close::IBehaviorListener:0:";
//                currentClose.select("a[id~=close]").select("main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkOtherResidency_close").attr("onclick");
                mClose = pClose.matcher(currentClose.select("a[id~=close]").select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkOtherResidency_close]").attr("onclick"));
                while ( mClose.find() ) {
                    linkClose = mClose.group(1);
                }
                break;
            default:
                log.error("Huston, we have an issue on Fix Residency Type");
        }

        if ( isThereResidencyList ) {
            linkClose = ":1:main:c:form:form:root:c:w:pnlResidencyList:c:w:btnAdd:close::IBehaviorListener:0:";
            // TODO to extract this link
        }

        requestHttpPost(
                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=" + linkClose,
                System.getProperty("borrower") + "/form.2?" + linkClose,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {},
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        if ( !isThereResidencyList ) {

//            String onclickBtnHiddenSubmit = currentFormDoc2.select("a[id~=submit]").select("a[data-path~=btnHiddenSubmit]").attr("onclick");
//            Pattern pBtnHiddenSubmit = Pattern.compile("\\?(wicket:interface=.*)&");
//            Matcher mBtnHiddenSubmit = pBtnHiddenSubmit.matcher(onclickBtnHiddenSubmit);
//            String btnHiddenSubmitWicketInterface = null;
//            while(mBtnHiddenSubmit.find()){
//                btnHiddenSubmitWicketInterface = mBtnHiddenSubmit.group(1);
//            }

            String addEmplCompleted = requestHttpPost(
                    httpClient,
//                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:",
                    System.getProperty("borrower") + "/form.2?" + btnHiddenSubmitWicketInterface,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", stepToken);
                            put("root:c:w:btnHiddenSubmit:submit", "1");
                        }
                    },
                    localContext.getHttpContext(),
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(addEmplCompleted);
        }
        else {

//            String onclickBtnHiddenRefresh = currentFormDoc2.select("a[id~=submit]").select("a[data-path~=btnHiddenRefresh]").attr("onclick");
//            Pattern pBtnHiddenRefresh = Pattern.compile("\\?(wicket:interface=.*)&");
//            Matcher mBtnHiddenRefresh = pBtnHiddenRefresh.matcher(onclickBtnHiddenRefresh);
//            String btnHiddenRefreshWicketInterface = null;
//            while(mBtnHiddenRefresh.find()){
//                btnHiddenRefreshWicketInterface = mBtnHiddenRefresh.group(1);
//            }

            String addEmplCompleted = requestHttpPost(
                    httpClient,
//                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenRefresh:submit::IBehaviorListener:0:",
                    System.getProperty("borrower") + "/form.2?" + btnHiddenRefreshWicketInterface,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", stepToken);
                            put("root:c:w:btnHiddenSubmit:submit", "1");
                        }
                    },
                    localContext.getHttpContext(),
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(addEmplCompleted);
        }

    }

    @And("^(Borrower) clicks (Residency) \"Done\"$")
    public void borrower_user_clicks_done(String userType, String formType) throws IOException {
        Document currentFormDoc = Jsoup.parse(httpResponse.getHttpResponse());
        Document currentFormDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for (String aComponentId : componentId) {
            try {
                currentFormDoc2 = Jsoup.parse(currentFormDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);
                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

        String stepToken = currentFormDoc2.select("input[name=stepToken]").attr("value");
        String btnImDone = currentFormDoc2.select("a[id~=submit]").select("a[wicketpath=main_c_form_form_root_c_w_pnlResidencyList_c_w_btnImDone_submit]").attr("onclick");
        Pattern pBtnImDone = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnImDone = pBtnImDone.matcher(btnImDone);
        String imDoneWicketInterface =StringUtils.EMPTY;
        while(mBtnImDone.find()) {
            imDoneWicketInterface = mBtnImDone.group(1);
        }

        String yourAccountPageResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlResidencyList:c:w:btnImDone:submit::IBehaviorListener:0:",
                System.getProperty("borrower") + "/form.2?" + imDoneWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", stepToken); // TODO extract stepToken should be 3
                        put("root:c:w:pnlResidencyList:c:w:btnImDone:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(yourAccountPageResponse);
    }

    @When("^(Borrower) clicks (Current residency|Other/previous residency) \"Edit\" item \\d+$")
    public void borrower_user_clicks_edit(String userType, String formType, int item) {

    }

    @When("^(Borrower) clicks (Current residency|Other/previous residency) \"Delete\" item \\d+$")
    public void borrower_user_clicks_delete(String userType, String formType, int item) {

    }
}