package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmploymentIncomeSection extends Borrower implements IEmploymentIncomeSection {

    private static final Log log = LogFactory.getLog(EmploymentIncomeSection.class.getName());

    @FindBy ( xpath = EMPLOYMENT_INCOMES_DESCRIPTION_XPATH )
    protected WebElement weEI_Description;

//    @Inject
    public EmploymentIncomeSection(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        loadingCheck();
        isVisible(EMPLOYMENT_INCOMES_TITLE_XPATH, true, 1);
        return getWebElement(EMPLOYMENT_INCOMES_TITLE_XPATH).getText();
//        return weEI_Title.getText();
    }

    @Override
    public boolean isTitle(String firstName) {
        loadingCheck();
        isVisible(EMPLOYMENT_INCOMES_TITLE_XPATH.replace("${replace}$", firstName), true, 10);
        return true;
    }

    @Override
    public String getDescriptionEmploymentIncome() {
        return weEI_Description.getText();
    }

    @Override @Deprecated
    public IEmploymentIncomeSection selectCategory(String category) {
        loadingCheck();
        isVisible(EMPLOYMENT_INCOMES_CATEGORY_XPATH, true);
        selectFromDropDown(EMPLOYMENT_INCOMES_CATEGORY_XPATH, category);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection clickCategory(String category) {
        loadingCheck();
        //TODO : The overlay window should be detected instead of these
        if(!isVisible(EMPLOYMENT_INCOMES_DIALOG_ADD_PAYE_XPATH, 0) && !isVisible(EMPLOYMENT_INCOMES_ADD_PAYE_XPATH, 0) ){
            if(isVisible(ADD_XPATH, 0)){
                clickElement(ADD_XPATH);
                loadingCheck();
            }
        }
        switch (category) {

            case "Paye":
                if ( isVisible(EMPLOYMENT_INCOMES_ADD_PAYE_XPATH, 0) )
                    clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_PAYE_XPATH);
                else
                    clickElementViaJavascript(EMPLOYMENT_INCOMES_DIALOG_ADD_PAYE_XPATH);
                loadingCheck();
                break;

            case "Self Employed":
                if ( isVisible(EMPLOYMENT_INCOMES_ADD_SELF_EMPLOYED_XPATH, 0) )
                    clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_SELF_EMPLOYED_XPATH);
                else
                    clickElementViaJavascript(EMPLOYMENT_INCOMES_DIALOG_ADD_SELF_EMPLOYED_XPATH);
                loadingCheck();
                break;

//            case "Civil Servant":
//                if ( isVisible(EMPLOYMENT_INCOMES_ADD_CIVIL_SERVANT_XPATH, 0) )
//                    clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_CIVIL_SERVANT_XPATH);
//                else
//                    clickElementViaJavascript(EMPLOYMENT_INCOMES_DIALOG_ADD_CIVIL_SERVANT_XPATH);
//                loadingCheck();
//                break;

            case "Unemployed/Homemaker":
                if ( isVisible(EMPLOYMENT_INCOMES_ADD_UNEMPLOYED_XPATH, 0) )
                    clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_UNEMPLOYED_XPATH);
                else
                    clickElementViaJavascript(EMPLOYMENT_INCOMES_DIALOG_ADD_UNEMPLOYED_XPATH);
                loadingCheck();
                break;

            case "Other":
                if ( isVisible(EMPLOYMENT_INCOMES_ADD_OTHER_XPATH, 0) )
                    clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_OTHER_XPATH);
                else
                    clickElementViaJavascript(EMPLOYMENT_INCOMES_DIALOG_ADD_OTHER_XPATH);
                loadingCheck();
                break;

            default:
                log.error("Huston, we have a problem on Employment&Income category");
        }
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectPaye_Occupation(String occupation) {
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_OCCUPATION_XPATH);
        selectFromDropDown(EMPLOYMENT_INCOME_PAYE_FORM_OCCUPATION_XPATH, occupation);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typePaye_EmploymentName(String employmentName) {
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYER_NAME_XPATH);
        type(EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYER_NAME_XPATH, employmentName);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectPaye_EmploymentType(String employmentType) {
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYMENT_TYPE_XPATH);
        selectFromDropDown(EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYMENT_TYPE_XPATH, employmentType);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typePaye_StartDate(String startDate) {
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_START_DATE_XPATH);
        type(EMPLOYMENT_INCOME_PAYE_FORM_START_DATE_XPATH, startDate);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typePaye_EndDate(String endDate) {
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_END_DATE_XPATH);
        type(EMPLOYMENT_INCOME_PAYE_FORM_END_DATE_XPATH, endDate);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkPaye_Currently(String currently) {
        loadingCheck();
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_CURRENTLY_XPATH, 0);
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_CURRENTLY_XPATH+"/following-sibling::span/a", 0);
        if ( currently.equals("checks") ) {
            clickElementViaJavascript(EMPLOYMENT_INCOME_PAYE_FORM_CURRENTLY_XPATH + "/following-sibling::span/a");
            loadingCheck();
        }
        return this;
    }

    @Override
    public IEmploymentIncomeSection typePaye_NetIncomeMonthly(String netIncomeMonthly) {
        isVisible(EMPLOYMENT_INCOME_PAYE_FORM_NET_INCOME_MONTHLY_XPATH, 0);
        type(EMPLOYMENT_INCOME_PAYE_FORM_NET_INCOME_MONTHLY_XPATH, netIncomeMonthly);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectSelfEmployment_Occupation(String occupation) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_OCCUPATION_XPATH, 0);
        selectFromDropDown(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_OCCUPATION_XPATH, occupation);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_StartDate(String startDate) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_START_DATE_XPATH, 0);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_START_DATE_XPATH, startDate);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_EndDate(String endDate) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_END_DATE_XPATH, 0);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_END_DATE_XPATH, endDate);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkSelfEmployment_Currently(String currently) {
        loadingCheck();
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_CURRENTLY_XPATH, 0);
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_CURRENTLY_XPATH+"/following-sibling::span/a", 0);
        clickElementViaJavascript(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_CURRENTLY_XPATH+"/following-sibling::span/a");
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_NetIncomeMonthly(String netIncomeMonthly) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_NET_INCOME_MONTHLY_XPATH, 0);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_NET_INCOME_MONTHLY_XPATH, netIncomeMonthly);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_BusinessName(String businessName) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NAME_XPATH, 0);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NAME_XPATH, businessName);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_AddressLine1(String addressLine1) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_1_XPATH, 0);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_1_XPATH, addressLine1);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_AddressLine2(String addressLine2) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_2_XPATH, 0);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_2_XPATH, addressLine2);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_TownCity(String townCity) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_TOWN_CITY_XPATH, 0);
        type(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_TOWN_CITY_XPATH, townCity);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectSelfEmployment_CountyState(String countyState) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTY_STATE_SELECT_XPATH, 0);
        selectFromDropDown(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTY_STATE_SELECT_XPATH, countyState);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectSelfEmployment_Country(String country) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTRY_XPATH, 0);
        typeEndWithTab(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTRY_XPATH, country, true);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeSelfEmployment_BusinessNature(String businessNature) {
        isVisible(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NATURE_XPATH);
        sendKeysElement(EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NATURE_XPATH, businessNature, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectCivilServant_Occupation(String occupation) {
        isVisible(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_OCCUPATION_XPATH);
        selectFromDropDown(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_OCCUPATION_XPATH, occupation);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeCivilServant_EmploymentName(String employmentName) {
        isVisible(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_EMPLOYER_NAME_XPATH);
        sendKeysElement(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_EMPLOYER_NAME_XPATH, employmentName, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectCivilServant_EmploymentType(String employmentType) {
        isVisible(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_EMPLOYMENT_TYPE_XPATH, 0);
        selectFromDropDown(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_EMPLOYMENT_TYPE_XPATH, employmentType);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeCivilServant_StartDate(String startDate) {
        isVisible(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_START_DATE_XPATH, 0);
        sendKeysElement(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_START_DATE_XPATH, startDate, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeCivilServant_EndDate(String endDate) {
        isVisible(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_END_DATE_XPATH, 0);
        sendKeysElement(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_END_DATE_XPATH, endDate, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkCivilServant_Currently(String currently) {
        loadingCheck();
        isVisible(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_CURRENTLY_XPATH, 0);
        isVisible(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_CURRENTLY_XPATH+"/following-sibling::span/a", 0);
        if ( currently.equals("checks") ) {
            clickElementViaJavascript(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_CURRENTLY_XPATH + "/following-sibling::span/a");
            loadingCheck();
        }
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeCivilServant_NetIncomeMonthly(String netIncomeMonthly) {
        isVisible(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_NET_INCOME_MONTHLY_XPATH, 0);
        sendKeysElement(EMPLOYMENT_INCOME_CIVIL_SERVANT_FORM_NET_INCOME_MONTHLY_XPATH, netIncomeMonthly, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeUnemployment_StartDate(String startDate) {
        isVisible(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_START_DATE_XPATH);
        sendKeysElement(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_START_DATE_XPATH, startDate, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeUnemployment_EndDate(String endDate) {
        isVisible(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_END_DATE_XPATH);
        sendKeysElement(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_END_DATE_XPATH, endDate, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkUnemployment_Currently(String currently) {
        loadingCheck();
        isVisible(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_CURRENTLY_XPATH, 0);
        isVisible(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_CURRENTLY_XPATH+"/following-sibling::span/a", 0);
        if ( currently.equals("checks") ) {
            clickElementViaJavascript(EMPLOYMENT_INCOME_UNEMPLOYED_FORM_CURRENTLY_XPATH + "/following-sibling::span/a");
            loadingCheck();
        }
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeOther_NetIncomeMonthly(String netIncomeMonthly) {
        isVisible(EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_MONTHLY_XPATH);
        sendKeysElement(EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_MONTHLY_XPATH, netIncomeMonthly, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeOther_AdditionalIncomeSource(String additionalIncomeSource) {
        isVisible(EMPLOYMENT_INCOME_OTHER_FORM_NET_ADDITIONAL_INCOME_SOURCE_XPATH);
        sendKeysElement(EMPLOYMENT_INCOME_OTHER_FORM_NET_ADDITIONAL_INCOME_SOURCE_XPATH, additionalIncomeSource, 10);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeOther_EarningTime(String earningTIme) {
        isVisible(EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_TIME_EARNING_XPATH);
        sendKeysElement(EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_TIME_EARNING_XPATH, earningTIme, 10);
        loadingCheck();
        return this;
    }

    private Map<String, String> formExceptionDetails(){
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
        loadingCheck();
        isVisible(CANCEL_XPATH, true, 0);
        clickElementViaJavascript(CANCEL_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IEmploymentIncomeSection clickAdd() {
        loadingCheck();
        if(isVisible(ADD_XPATH, 0) && !isVisible(EMPLOYMENT_INCOMES_DIALOG_XPATH, 0))
            clickElementViaJavascript(ADD_XPATH, EMPLOYMENT_INCOMES_DIALOG_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsPage clickDone() {
        loadingCheck();
        isVisible(DONE_XPATH, 0);
        clickElementViaJavascript(DONE_XPATH);
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
