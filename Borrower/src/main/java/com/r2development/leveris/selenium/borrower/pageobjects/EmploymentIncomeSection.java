package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
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







//    @Override
//    public IEmploymentIncomeSection selectEIP_Occupation(String occupation) {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_OCCUPATION_XPATH, true);
//        selectFromDropDown(EMPLOYMENT_INCOMES_PAYE_OCCUPATION_XPATH, occupation);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIP_EmployerName(String employerName) {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_EMPLOYER_NAME_XPATH, true);
//        weEIP_EmployerName.clear();
//        weEIP_EmployerName.sendKeys(employerName);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection selectEIP_EmploymentType(String employmentType) {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_EMPLOYMENT_TYPE_XPATH, true);
//        selectFromDropDown(EMPLOYMENT_INCOMES_PAYE_EMPLOYMENT_TYPE_XPATH, employmentType);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIP_StartDate(String startDate) {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_STARTDATE_XPATH, true);
//        weEIP_StartDate.clear();
//        weEIP_StartDate.sendKeys(startDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIP_MandatoryEndDate(String mandatoryEndDate) {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_MANDATORY_ENDDATE_XPATH, true);
//        weEIP_MandatoryEndDate.clear();
//        weEIP_MandatoryEndDate.sendKeys(mandatoryEndDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIP_EndDate(String endDate) {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_ENDDATE_XPATH, true);
//        weEIP_EndDate.clear();
//        weEIP_EndDate.sendKeys(endDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection checkEIP_Currently() {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_CURRENTLY_XPATH, true);
//        weEIP_Currently.click();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection uncheckEIP_Currently() {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_CURRENTLY_XPATH, true);
//        weEIP_Currently.click();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIP_NetMonthlyIncome(String netMonthlyIncome) {
//        isVisible(EMPLOYMENT_INCOME_NET_MONTHLY_INCOME_XPATH, true);
//        weEIP_NetMonthlyIncome.clear();
//        weEIP_NetMonthlyIncome.sendKeys(netMonthlyIncome);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIP_GrossSalary(String grossSalary) {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_GROSS_SALARY_XPATH, true);
//        weEIP_GrossSalary.clear();
//        weEIP_GrossSalary.sendKeys(grossSalary);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIP_RegularOvertime(String regularOvertime) {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_REGULAR_OVERTIME_XPATH, true);
//        weEIP_RegularOvertime.clear();
//        weEIP_RegularOvertime.sendKeys(regularOvertime);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIP_RegularGuaranteedBonus(String regularGuaranteedBonus) {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_REGULAR_GUARANTEED_BONUS_XPATH, true);
//        weEIP_RegularGuaranteedBonus.clear();
//        weEIP_RegularGuaranteedBonus.sendKeys(regularGuaranteedBonus);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIP_GuaranteedCommission(String guaranteedCommission) {
//        isVisible(EMPLOYMENT_INCOMES_PAYE_GUARANTEED_COMMISSION_XPATH, true);
//        weEIP_GuaranteedCommission.clear();
//        weEIP_GuaranteedCommission.sendKeys(guaranteedCommission);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection selectEISE_Occupation(String occupation) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_OCCUPATION_XPATH, true);
//        selectFromDropDown(EMPLOYMENT_INCOMES_SELFEMPLOYED_OCCUPATION_XPATH, occupation);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEISE_BusinessName(String businessName) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_BUSINESS_NAME_XPATH, true);
//        weEISE_BusinessName.clear();
//        weEISE_BusinessName.sendKeys(businessName);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEISE_AddressLine1(String addressLine1) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_ADDRESS_LINE1_XPATH, true);
//        weEISE_AddressLine1.clear();
//        weEISE_AddressLine1.sendKeys(addressLine1);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEISE_AddressLine2(String addressLine2) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_ADDRESS_LINE2_XPATH, true);
//        weEISE_AddressLine2.clear();
//        weEISE_AddressLine2.sendKeys(addressLine2);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEISE_TownCity(String townCity) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_TOWNCITY_XPATH, true);
//        moveTo(EMPLOYMENT_INCOMES_SELFEMPLOYED_TOWNCITY_XPATH);
//        weEISE_TownCity.clear();
//        weEISE_TownCity.sendKeys(townCity);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection selectEISE_CountyState(String countyState) {
//        scroll(-500, 0);
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTYSTATE_XPATH, true);
//        moveTo2(EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTYSTATE_XPATH);
//        selectFromDropDown(EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTYSTATE_XPATH, countyState);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection selectEISE_Country(String country) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTRY_XPATH, true);
//        selectFromDropDown(EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTRY_XPATH, country);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEISE_BusinessNature(String businessNature) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_BUSINESS_NATURE_XPATH, true);
//        weEISE_BusinessNature.clear();
//        weEISE_BusinessNature.sendKeys(businessNature);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEISE_StartDate(String startDate) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_STARTDATE_XPATH, true);
//        weEISE_StartDate.clear();
//        weEISE_StartDate.sendKeys(startDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEISE_EndDate(String endDate) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_ENDDATE_XPATH, true);
//        weEISE_EndDate.clear();
//        weEISE_EndDate.sendKeys(endDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection checkEISE_Currently() {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_CURRENTLY_XPATH, true); // verification if it is checked
//        weEISE_Currently.click();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection uncheckEISE_Currently() {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_CURRENTLY_XPATH, true);
//        weEISE_Currently.click();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEISE_NetProfitLastYear(String netProfitLastYear) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_NETPROFIT_LASTYEAR_XPATH, true);
//        weEISE_NetProfitLastYear.clear();
//        weEISE_NetProfitLastYear.sendKeys(netProfitLastYear);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEISE_NetProfitPreviousYear(String netProfitPreviousYear) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_NETPROFIT_PREVIOUSYEAR_XPATH, true);
//        weEISE_NetProfitPreviousYear.clear();
//        weEISE_NetProfitPreviousYear.sendKeys(netProfitPreviousYear);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEISE_AccountantName(String accountantName) {
//        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_ACCOUNTANT_NAME_XPATH, true);
//        weEISE_AccountantName.clear();
//        weEISE_AccountantName.sendKeys(accountantName);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection selectEICS_Occupation(String occupation) {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_OCCUPATION_XPATH, true);
//        selectFromDropDown(EMPLOYMENT_INCOMES_CIVIL_SERVANT_OCCUPATION_XPATH, occupation);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEICS_EmployerName(String employerName) {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_EMPLOYER_NAME_XPATH, true);
//        weEICS_EmployerName.clear();
//        weEICS_EmployerName.sendKeys(employerName);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection selectEICS_EmploymentType(String employmentType) {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_EMPLOYMENT_TYPE_XPATH, true);
//        selectFromDropDown(EMPLOYMENT_INCOMES_CIVIL_SERVANT_EMPLOYMENT_TYPE_XPATH, employmentType);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEICS_StartDate(String startDate) {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_STARTDATE_XPATH, true);
//        weEICS_StartDate.clear();
//        weEICS_StartDate.sendKeys(startDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEICS_MandatoryEndDate(String mandatoryEndDate) {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_MANDATORY_ENDDATE_XPATH, true);
//        weEICS_MandatoryEndDate.clear();
//        weEICS_MandatoryEndDate.sendKeys(mandatoryEndDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEICS_EndDate(String endDate) {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_ENDDATE_XPATH, true);
//        weEICS_EndDate.clear();
//        weEICS_EndDate.sendKeys(endDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection checkEICS_Currently() {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_CURRENTLY_XPATH, true);
//        weEICS_Currently.click();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection uncheckEICS_Currently() {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_CURRENTLY_XPATH, true);
//        weEICS_Currently.click();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEICS_GrossSalary(String grossSalary) {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_GROSS_SALARY_XPATH, true);
//        weEICS_GrossSalary.clear();
//        weEICS_GrossSalary.sendKeys(grossSalary);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEICS_RegularOvertime(String regularOvertime) {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_REGULAR_OVERTIME_XPATH, true);
//        weEICS_RegularOvertime.clear();
//        weEICS_RegularOvertime.sendKeys(regularOvertime);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEICS_RegularGuaranteedBonus(String regularGuaranteedBonus) {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_REGULAR_GUARANTEED_BONUS_XPATH, true);
//        weEICS_RegularGuaranteedBonus.clear();
//        weEICS_RegularGuaranteedBonus.sendKeys(regularGuaranteedBonus);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEICS_GuaranteedCommission(String guaranteedCommission) {
//        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_GUARANTEED_COMMISSION_XPATH, true);
//        weEICS_GuaranteedCommission.clear();
//        weEICS_GuaranteedCommission.sendKeys(guaranteedCommission);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIUH_StartDate(String startDate) {
//        isVisible(EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_STARTDATE_XPATH, true);
//        weEIUH_StartDate.clear();
//        weEIUH_StartDate.sendKeys(startDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIUH_EndDate(String endDate) {
//        isVisible(EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_ENDDATE_XPATH, true);
//        weEIUH_EndDate.clear();
//        weEIUH_EndDate.sendKeys(endDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection checkEIUH_Currently() {
//        isVisible(EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_CURRENTLY, true);
//        weEIUH_Currently.click();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection uncheckEIUH_Currently() {
//        isVisible(EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_CURRENTLY, true);
//        weEIUH_Currently.click();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIO_SourceIncome(String sourceIncome) {
//        isVisible(EMPLOYMENT_INCOMES_OTHERS_SOURCE_INCOME_XPATH, true);
//        weEIO_SourceIncome.clear();
//        weEIO_SourceIncome.sendKeys(sourceIncome);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIO_GrossIncomes(String grossIncomes) {
//        isVisible(EMPLOYMENT_INCOMES_OTHERS_GROSS_INCOMES_XPATH, true);
//        weEIO_GrossIncomes.clear();
//        weEIO_GrossIncomes.sendKeys(grossIncomes);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection typeEIO_TimeEarningIncome(String timeEarningIncome) {
//        isVisible(EMPLOYMENT_INCOMES_OTHERS_TIME_EARNING_INCOME_XPATH, true);
//        weEIO_TimeEarningIncome.clear();
//        weEIO_TimeEarningIncome.sendKeys(timeEarningIncome);
//        return this;
//    }
//
//    @Override
//    public boolean isExistReportIncomes() {
//        return isInvisible(REPORT_INCOMES_XPATH);
////        return isVisible(REPORT_INCOMES_XPATH);
//    }
//
//    @Override
//    public Map<Integer, ReportEmploymentIncome> getReportsEmploymentIncome() {
//        return null;
//    }
//
//    @Override
//    public Map<Integer, ReportEmploymentIncome> delReportEmploymentIncome(int i) {
//        return null;
//    }
//
//    @Override
//    public IEmploymentIncomeSection clickEmploymentIncomeCancel() {
//        isVisible(EMPLOYMENT_INCOMES_CANCEL_XPATH, true);
//        weEmploymentIncomesCancel.click();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection clickEmploymentIncomeAddThisEmployment() {
//        isVisible(EMPLOYMENT_INCOMES_ADD_THIS_EMPLOYMENT_XPATH, true, 5);
////        weEmploymentIncomesAddThisEmployment.click();
//        clickElement(EMPLOYMENT_INCOMES_ADD_THIS_EMPLOYMENT_XPATH);
//        isNotVisible("//div[@wicketpath='main_c_form_dialogWrapper']", true, 15);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomeSection clickEmploymentIncomeAddEmployment() {
////        isVisible(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH, true, 5);
//        try {
////            weEmploymentIncomesAddEmployment.click();
//            clickElement(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
//            isVisible("//div[@wicketpath='main_c_form_dialogWrapper']", true, 5);
//        } catch ( WebDriverException e) {
////            clickElement(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
//            if (!isVisible("//div[@wicketpath='main_c_form_dialogWrapper']", false, 5))
//                clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
//        }
////        clickElement(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
////        clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
////        if (!isVisible("//div[@wicketpath='main_c_form_dialogWrapper']", false, 5)) {
////            clickElement(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
////        }
//        return this;
//    }
//
//    @Override
//    public IYourAccountsPage clickEmploymentIncomeDone() {
//        isVisible(EMPLOYMENT_INCOMES_DONE_XPATH, true);
////        clickElement(EMPLOYMENT_INCOMES_DONE_XPATH);
//        clickElementViaJavascript(EMPLOYMENT_INCOMES_DONE_XPATH);
////        weEmploymentIncomesDone.click();
//        if(isVisible(INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
//        return new YourAccountsPage(webDriver);
//    }
}
