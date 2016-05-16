package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmploymentIncomeSection extends Borrower implements IEmploymentIncomeSection {

    private static final Log log = LogFactory.getLog(EmploymentIncomeSection.class.getName());

    public EmploymentIncomeSection(SharedDriver_Borrower webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IEmploymentIncomeSection selectCategory(String category) {
        log.info("");
        loadingCheck();
        isPresent(EMPLOYMENT_INCOMES_CATEGORY_XPATH, 3);
        selectFromDropDown(EMPLOYMENT_INCOMES_CATEGORY_XPATH, category);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection clickCategory(String category) {
        log.info("");
        clickAdd(true);
        switch (category) {

            case "Paye":
                clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_PAYE_XPATH);
                break;

            case "Self Employed":
                clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_SELF_EMPLOYED_XPATH);
                break;

            case "Unemployed/Homemaker":
                clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_UNEMPLOYED_XPATH);
                break;

            case "Other":
                clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_OTHER_XPATH);
                break;

            default:
                log.error("Huston, we have a problem on Employment&Income category");
        }
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectPaye_Occupation(String occupation) {
        log.info("");
        isPresent(EMPLOYMENT_INCOME_PAYE_FORM_OCCUPATION_XPATH, 3);
        selectFromDropDown(EMPLOYMENT_INCOME_PAYE_FORM_OCCUPATION_XPATH, occupation);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typePaye_EmploymentName(String employmentName) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYER_NAME_XPATH, true);
        type(EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYER_NAME_XPATH, employmentName);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectPaye_EmploymentType(String employmentType) {
        log.info("");
        isPresent(EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYMENT_TYPE_XPATH, 3);
        selectFromDropDown(EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYMENT_TYPE_XPATH, employmentType);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typePaye_StartDate(String startDate) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_START_DATE_XPATH, true);
        type(EMPLOYMENT_INCOME_PAYE_FORM_START_DATE_XPATH, startDate);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typePaye_EndDate(String endDate) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_END_DATE_XPATH, true);
        type(EMPLOYMENT_INCOME_PAYE_FORM_END_DATE_XPATH, endDate);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkPaye_Currently(String currently) {
        log.info("");
        loadingCheck();
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_CURRENTLY_XPATH, true);
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_CURRENTLY_XPATH, true);
        if ( currently.equals("checks") ) {
            clickElementViaJavascript(EMPLOYMENT_INCOME_PAYE_FORM_CURRENTLY_XPATH);
            loadingCheck();
        }
        return this;
    }

    @Override
    public IEmploymentIncomeSection typePaye_NetIncomeMonthly(String netIncomeMonthly) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_NET_INCOME_MONTHLY_XPATH, true);
        type(EMPLOYMENT_INCOME_PAYE_FORM_NET_INCOME_MONTHLY_XPATH, netIncomeMonthly);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectSelfEmployment_Occupation(String occupation) {
        log.info("");
        isPresent(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_OCCUPATION_XPATH, 3);
        selectFromDropDown(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_OCCUPATION_XPATH, occupation);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_StartDate(String startDate) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_START_DATE_XPATH, true);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_START_DATE_XPATH, startDate);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_EndDate(String endDate) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_END_DATE_XPATH, true);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_END_DATE_XPATH, endDate);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkSelfEmployment_Currently(String currently) {
        log.info("");
        loadingCheck();
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_CURRENTLY_XPATH, true);
        if ( currently.equals("checks") ) {
            clickElementViaJavascript(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_CURRENTLY_XPATH);
            loadingCheck();
        }
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_NetIncomeMonthly(String netIncomeMonthly) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_NET_INCOME_MONTHLY_XPATH, true);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_NET_INCOME_MONTHLY_XPATH, netIncomeMonthly);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_BusinessName(String businessName) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NAME_XPATH, true);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NAME_XPATH, businessName);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_AddressLine1(String addressLine1) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_1_XPATH, true);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_1_XPATH, addressLine1);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_AddressLine2(String addressLine2) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_2_XPATH, true);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_2_XPATH, addressLine2);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_TownCity(String townCity) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_TOWN_CITY_XPATH, true);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_TOWN_CITY_XPATH, townCity);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectSelfEmployment_CountyState(String countyState) {
        log.info("");
        isPresent(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTY_STATE_SELECT_XPATH, 3);
        setCounty(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTY_STATE_SELECT_XPATH, countyState);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectSelfEmployment_Country(String country) {
        log.info("");
        isPresent(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTRY_XPATH, 3);
        setCountry(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTRY_XPATH, country);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_BusinessNature(String businessNature) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NATURE_XPATH, true);
        sendKeysElement(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NATURE_XPATH, businessNature, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeOther_StartDate(String startDate) {
        log.info("");
        isPresent(EMPLOYMENT_INCOME_OTHER_FORM_START_DATE_XPATH, 3);
        sendKeysElement(EMPLOYMENT_INCOME_OTHER_FORM_START_DATE_XPATH, startDate, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeOther_EndDate(String endDate) {
        log.info("");
        isPresent(EMPLOYMENT_INCOME_OTHER_FORM_END_DATE_XPATH, 3);
        sendKeysElement(EMPLOYMENT_INCOME_OTHER_FORM_END_DATE_XPATH, endDate, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkOther_Currently(String currently) {
        log.info("");
        loadingCheck();
        isVisible(EMPLOYMENT_INCOME_OTHER_FORM_CURRENTLY_XPATH, true);
        if ( currently.equals("checks") ) {
            clickElementViaJavascript(EMPLOYMENT_INCOME_OTHER_FORM_CURRENTLY_XPATH);
            loadingCheck();
        }
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeUnemployment_StartDate(String startDate) {
        log.info("");
        isPresent(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_START_DATE_XPATH, 3);
        sendKeysElement(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_START_DATE_XPATH, startDate, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeUnemployment_EndDate(String endDate) {
        log.info("");
        isPresent(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_END_DATE_XPATH, 3);
        sendKeysElement(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_END_DATE_XPATH, endDate, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkUnemployment_Currently(String currently) {
        log.info("");
        loadingCheck();
        isPresent(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_CURRENTLY_XPATH, 3);
        if ( currently.equals("checks") ) {
            clickElementViaJavascript(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_CURRENTLY_XPATH);
            loadingCheck();
        }
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeOther_NetIncomeMonthly(String netIncomeMonthly) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_MONTHLY_XPATH, true);
        sendKeysElement(EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_MONTHLY_XPATH, netIncomeMonthly, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeOther_AdditionalIncomeSource(String additionalIncomeSource) {
        log.info("");
        isVisible(EMPLOYMENT_INCOME_OTHER_FORM_NET_ADDITIONAL_INCOME_SOURCE_XPATH, true);
        sendKeysElement(EMPLOYMENT_INCOME_OTHER_FORM_NET_ADDITIONAL_INCOME_SOURCE_XPATH, additionalIncomeSource, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeOther_EarningTime(String earningTIme) {
        log.info("");
// Not present in form
//        isVisible(EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_TIME_EARNING_XPATH);
//        sendKeysElement(EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_TIME_EARNING_XPATH, earningTIme, 10);
//        loadingCheck();
        return this;
    }

    private Map<String, String> formExceptionDetails(){
        log.info("");
        Map<String, String> formExceptionDetails = new LinkedHashMap<>();
        formExceptionDetails.put(
                "FormName",
                "\n Employment and income saving problem as save button is still present \n" +
                        " Extracting exception text from the form \n"
        );
        formExceptionDetails.put(
                "GetExceptionResult1",
                "\n --------------------------------------------------------------\n" +
                        " | Not being able to save the form @!wtf!@                         | \n" +
                        " | it is due to : '"
        );
        formExceptionDetails.put(
                "GetExceptionResult2",
                "' is displayed on page | \n" +
                        " -------------------------------------------------------------- \n"
        );
        formExceptionDetails.put(
                "FormAction",
                "Failed clickSaveAndClose"
        );
        return formExceptionDetails;
    }

    @Override
    public IEmploymentIncomeSection clickSaveAndClose() {
        log.info("");
        loadingCheck();
        isVisible(SAVE_AND_CLOSE_XPATH, true);
        isNotVisible(EMPLOYMENT_INCOMES_FEEDBACK_DIALOG_XPATH + ERROR, false, 0);
        clickElementViaJavascript(SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        formSubmitPostSync(SAVE_AND_CLOSE_XPATH, formExceptionDetails());
        return this;
    }

    @Override
    public IEmploymentIncomeSection clickCancel() {
        log.info("");
        loadingCheck();
        isVisible(CANCEL_XPATH, true);
        clickElementViaJavascript(CANCEL_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection clickAdd() {
        log.info("");
        loadingCheck();
        isVisible(ADD_XPATH, true);
        clickElementViaJavascript(ADD_XPATH, EMPLOYMENT_INCOMES_DIALOG_XPATH);
        loadingCheck();
        return this;
    }

    private IEmploymentIncomeSection clickAdd(boolean justToBeSure) {
        log.info("");
        loadingCheck();
        if(isVisible(ADD_XPATH, 1)){
            isVisible(ADD_XPATH, true);
            clickElementViaJavascript(ADD_XPATH, EMPLOYMENT_INCOMES_DIALOG_XPATH);
        }
        return this;
    }

    @Override
    public IYourAccountsPage clickDone() {
        log.info("");
        loadingCheck();
        isVisible(DONE_XPATH, true);
        clickElement(DONE_XPATH, IYourAccountsSection.YOUR_ACCOUNTS_CURRENT_ACCOUNT_XPATH);
        loadingCheck();
        return new YourAccountsPage(webDriver);
    }

    @Override
    public IEmploymentIncomeSection clickDelete(int index) {
        // TODO to implement
        return null;
    }

    @Override
    public IEmploymentIncomeSection clickDelete(String detailCategory) {
        // TODO to implement
        return null;
    }

    @Override
    public IEmploymentIncomeSection clickEdit(int index) {
        // TODO to implement
        return null;
    }

    @Override
    public IEmploymentIncomeSection clickEdit(String detailCategory) {
        // TODO to implement
        return null;
    }
}
