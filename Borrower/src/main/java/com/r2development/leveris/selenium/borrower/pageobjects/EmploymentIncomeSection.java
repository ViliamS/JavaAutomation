package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class EmploymentIncomeSection extends Borrower implements IEmploymentIncomeSection {

    private static final Log log = LogFactory.getLog(EmploymentIncomeSection.class);

    @FindBy ( xpath = EMPLOYMENT_INCOMES_TITLE_XPATH )
    protected WebElement weEI_Title;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_DESCRIPTION_XPATH )
    protected WebElement weEI_Description;

    @FindBy ( xpath = EMPLOYMENT_INCOMES_CATEGORY_XPATH )
    protected WebElement weEI_Category;

    // case PAYE
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_CONTAINER_XPATH )
    protected WebElement weEIP_Container;

    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_OCCUPATION_XPATH )
    protected WebElement weEIP_Occupation;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_EMPLOYER_NAME_XPATH )
    protected WebElement weEIP_EmployerName;
    // Contract, Permanent, Temporary
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_EMPLOYMENT_TYPE_XPATH )
    protected WebElement weEIP_EmploymentType;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_STARTDATE_XPATH )
    protected WebElement weEIP_StartDate;
    // case PAY Contract
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_MANDATORY_ENDDATE_XPATH )
    protected WebElement weEIP_MandatoryEndDate;
    // case PAY Permanent, Temporary
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_ENDDATE_XPATH )
    protected WebElement weEIP_EndDate;
    // case not valid for PAY Contract only for Permanent, Temporary
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_CURRENTLY_XPATH )
    protected WebElement weEIP_Currently;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_GROSS_SALARY_XPATH )
    protected WebElement weEIP_GrossSalary;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_REGULAR_OVERTIME_XPATH )
    protected WebElement weEIP_RegularOvertime;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_REGULAR_GUARANTEED_BONUS_XPATH )
    protected WebElement weEIP_RegularGuaranteedBonus;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_PAYE_GUARANTEED_COMMISSION_XPATH )
    protected WebElement weEIP_GuaranteedCommission;

    // case SELF_EMPLOYED
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_CONTAINER_XPATH )
    protected WebElement weEISE_Container;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_OCCUPATION_XPATH )
    protected WebElement weEISE_Occupation; // select
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_BUSINESS_NAME_XPATH )
    protected WebElement weEISE_BusinessName;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_ADDRESS_LINE1_XPATH )
    protected WebElement weEISE_AddressLine1;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_ADDRESS_LINE2_XPATH )
    protected WebElement weEISE_AddressLine2;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_TOWNCITY_XPATH )
    protected WebElement weEISE_TownCity;
    // if country is Ireland
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTYSTATE_XPATH )
    protected WebElement weEISE_CountyState; // select
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTRY_XPATH )
    protected WebElement weEISE_Country; // select
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_BUSINESS_NATURE_XPATH )
    protected WebElement weEISE_BusinessNature;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_STARTDATE_XPATH )
    protected WebElement weEISE_StartDate;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_ENDDATE_XPATH )
    protected WebElement weEISE_EndDate;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_CURRENTLY_XPATH )
    protected WebElement weEISE_Currently;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_NETPROFIT_LASTYEAR_XPATH )
    protected WebElement weEISE_NetProfitLastYear;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_NETPROFIT_PREVIOUSYEAR_XPATH )
    protected WebElement weEISE_NetProfitPreviousYear;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_SELFEMPLOYED_ACCOUNTANT_NAME_XPATH )
    protected WebElement weEISE_AccountantName;

    // case CIVIL_SERVANT
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_CONTAINER_XPATH )
    protected WebElement weEICS_Container;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_OCCUPATION_XPATH )
    protected WebElement weEICS_Occupation;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_EMPLOYER_NAME_XPATH )
    protected WebElement weEICS_EmployerName;
    // Contract, Permanent, Temporary
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_EMPLOYMENT_TYPE_XPATH )
    protected WebElement weEICS_EmploymentType;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_STARTDATE_XPATH )
    protected WebElement weEICS_StartDate;
    // case PAY Contract
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_MANDATORY_ENDDATE_XPATH )
    protected WebElement weEICS_MandatoryEndDate;
    // case PAY Permanent, Temporary
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_ENDDATE_XPATH )
    protected WebElement weEICS_EndDate;
    // case not valid for PAY Contract only for Permanent, Temporary
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_CURRENTLY_XPATH )
    protected WebElement weEICS_Currently;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_GROSS_SALARY_XPATH )
    protected WebElement weEICS_GrossSalary;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_REGULAR_OVERTIME_XPATH )
    protected WebElement weEICS_RegularOvertime;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_REGULAR_GUARANTEED_BONUS_XPATH )
    protected WebElement weEICS_RegularGuaranteedBonus;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CIVIL_SERVANT_GUARANTEED_COMMISSION_XPATH )
    protected WebElement weEICS_GuaranteedCommission;

    // case UNEMPLOYED_HOMEMAKER
    @FindBy ( xpath = EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_CONTAINER_XPATH )
    protected WebElement weEIUH_Container;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_STARTDATE_XPATH )
    protected WebElement weEIUH_StartDate;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_ENDDATE_XPATH )
    protected WebElement weEIUH_EndDate;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_CURRENTLY )
    protected WebElement weEIUH_Currently;

    // case OTHER
    @FindBy ( xpath = EMPLOYMENT_INCOMES_OTHERS_CONTAINER_XPATH )
    protected WebElement weEIO_Container;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_OTHERS_SOURCE_INCOME_XPATH )
    protected WebElement weEIO_SourceIncome;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_OTHERS_GROSS_INCOMES_XPATH )
    protected WebElement weEIO_GrossIncomes;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_OTHERS_TIME_EARNING_INCOME_XPATH )
    protected WebElement weEIO_TimeEarningIncome;

    @FindBy( xpath = REPORT_INCOMES_XPATH )
    protected WebElement weReportIncomes;
//    @FindBys( ) // to google it how to use it
//    @FindBys( FindBys[] = REPORT_INCOMES_XPATH )
//    WebElement[] weReportIncomes;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_CANCEL_XPATH )
    protected WebElement weEmploymentIncomesCancel;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH )
    protected WebElement weEmploymentIncomesAddEmployment;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_ADD_THIS_EMPLOYMENT_XPATH )
    protected WebElement weEmploymentIncomesAddThisEmployment;
    @FindBy ( xpath = EMPLOYMENT_INCOMES_DONE_XPATH )
    protected WebElement weEmploymentIncomesDone;

    @Inject
    public EmploymentIncomeSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        isVisible(EMPLOYMENT_INCOMES_TITLE_XPATH, true, 5);
        return getWebElement(EMPLOYMENT_INCOMES_TITLE_XPATH).getText();
//        return weEI_Title.getText();
    }

    @Override
    public boolean isTitle(String firstName) {
        isVisible(EMPLOYMENT_INCOMES_TITLE_XPATH.replace("${replace}$", firstName), true, 10);
        return true;
    }

    @Override
    public String getDescriptionEmploymentIncome() {
        return weEI_Description.getText();
    }

    @Override @Deprecated
    public IEmploymentIncomeSection selectCategory(String category) {
        isVisible(EMPLOYMENT_INCOMES_CATEGORY_XPATH, true);
        selectFromDropDown(EMPLOYMENT_INCOMES_CATEGORY_XPATH, category);
        return this;
    }

    @Override
    public IEmploymentIncomeSection clickCategory(String category) {
//        data-path="pnlNoEmplyments lnkAddPaye" => "//div[contains(@data-path, 'lnkAddPaye')]/a"
//        data-path="pnlNoEmplyments lnkAddCivilServant" => "//div[contains(@data-path, 'lnkAddCivilServant')]/a"
//        data-path="pnlNoEmplyments lnkAddSelfEmployed"=> "//div[contains(@data-path, 'lnkAddSelfEmployed')]/a"
//        data-path="pnlNoEmplyments lnkAddUnemployment"=> "//div[contains(@data-path, 'lnkAddUnemployment')]/a"
//        data-path="pnlNoEmplyments lnkAddHomemaker"=> "//div[contains(@data-path, 'lnkAddHomemaker')]/a"

//        Paye => a[wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddPaye_submit']
//        SelfEmployed => a[wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddSelfEmployed_submit']
//        CivilServant => a[wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddCivilServant_submit']
//        Unemployed/Homemaker -> a[wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddUnemployment_submit']
//        Other => a[wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddHomemaker_submit']

        isVisible("//div[@wicketpath='main_c_form_dialogWrapper']", false, 10);

        if ( category.equals("CivilServant")) {
//            clickElement("//a[contains(@wicketpath, 'lnkAddCivilServant')]");
            clickElementViaJavascript("//a[contains(@wicketpath, 'lnkAddCivilServant')]");
        }
        else {
            if (category.equals("Unemployed/Homemaker"))
                category = "Unemployment";
            else if (category.equals("Other"))
                category = "Homemaker";

            clickElementViaJavascript(EMPLOYMENT_INCOMES_LINK_CATEGORY_XPATH.replace("${replace}$", category));
        }

//        isVisible(EMPLOYMENT_INCOMES_LINK_CATEGORY_XPATH.replace("${replace}$", category), true, 5);
//        clickElement(EMPLOYMENT_INCOMES_LINK_CATEGORY_XPATH.replace("${replace}$", category));

        return this;
    }

    @Override
    public IEmploymentIncomeSection selectEIP_Occupation(String occupation) {
        isVisible(EMPLOYMENT_INCOMES_PAYE_OCCUPATION_XPATH, true);
        selectFromDropDown(EMPLOYMENT_INCOMES_PAYE_OCCUPATION_XPATH, occupation);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIP_EmployerName(String employerName) {
        isVisible(EMPLOYMENT_INCOMES_PAYE_EMPLOYER_NAME_XPATH, true);
        weEIP_EmployerName.clear();
        weEIP_EmployerName.sendKeys(employerName);
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectEIP_EmploymentType(String employmentType) {
        isVisible(EMPLOYMENT_INCOMES_PAYE_EMPLOYMENT_TYPE_XPATH, true);
        selectFromDropDown(EMPLOYMENT_INCOMES_PAYE_EMPLOYMENT_TYPE_XPATH, employmentType);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIP_StartDate(String startDate) {
        isVisible(EMPLOYMENT_INCOMES_PAYE_STARTDATE_XPATH, true);
        weEIP_StartDate.clear();
        weEIP_StartDate.sendKeys(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIP_MandatoryEndDate(String mandatoryEndDate) {
        isVisible(EMPLOYMENT_INCOMES_PAYE_MANDATORY_ENDDATE_XPATH, true);
        weEIP_MandatoryEndDate.clear();
        weEIP_MandatoryEndDate.sendKeys(mandatoryEndDate);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIP_EndDate(String endDate) {
        isVisible(EMPLOYMENT_INCOMES_PAYE_ENDDATE_XPATH, true);
        weEIP_EndDate.clear();
        weEIP_EndDate.sendKeys(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkEIP_Currently() {
        isVisible(EMPLOYMENT_INCOMES_PAYE_CURRENTLY_XPATH, true);
        weEIP_Currently.click();
        return this;
    }

    @Override
    public IEmploymentIncomeSection uncheckEIP_Currently() {
        isVisible(EMPLOYMENT_INCOMES_PAYE_CURRENTLY_XPATH, true);
        weEIP_Currently.click();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIP_GrossSalary(String grossSalary) {
        isVisible(EMPLOYMENT_INCOMES_PAYE_GROSS_SALARY_XPATH, true);
        weEIP_GrossSalary.clear();
        weEIP_GrossSalary.sendKeys(grossSalary);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIP_RegularOvertime(String regularOvertime) {
        isVisible(EMPLOYMENT_INCOMES_PAYE_REGULAR_OVERTIME_XPATH, true);
        weEIP_RegularOvertime.clear();
        weEIP_RegularOvertime.sendKeys(regularOvertime);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIP_RegularGuaranteedBonus(String regularGuaranteedBonus) {
        isVisible(EMPLOYMENT_INCOMES_PAYE_REGULAR_GUARANTEED_BONUS_XPATH, true);
        weEIP_RegularGuaranteedBonus.clear();
        weEIP_RegularGuaranteedBonus.sendKeys(regularGuaranteedBonus);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIP_GuaranteedCommission(String guaranteedCommission) {
        isVisible(EMPLOYMENT_INCOMES_PAYE_GUARANTEED_COMMISSION_XPATH, true);
        weEIP_GuaranteedCommission.clear();
        weEIP_GuaranteedCommission.sendKeys(guaranteedCommission);
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectEISE_Occupation(String occupation) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_OCCUPATION_XPATH, true);
        selectFromDropDown(EMPLOYMENT_INCOMES_SELFEMPLOYED_OCCUPATION_XPATH, occupation);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEISE_BusinessName(String businessName) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_BUSINESS_NAME_XPATH, true);
        weEISE_BusinessName.clear();
        weEISE_BusinessName.sendKeys(businessName);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEISE_AddressLine1(String addressLine1) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_ADDRESS_LINE1_XPATH, true);
        weEISE_AddressLine1.clear();
        weEISE_AddressLine1.sendKeys(addressLine1);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEISE_AddressLine2(String addressLine2) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_ADDRESS_LINE2_XPATH, true);
        weEISE_AddressLine2.clear();
        weEISE_AddressLine2.sendKeys(addressLine2);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEISE_TownCity(String townCity) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_TOWNCITY_XPATH, true);
        moveTo(EMPLOYMENT_INCOMES_SELFEMPLOYED_TOWNCITY_XPATH);
        weEISE_TownCity.clear();
        weEISE_TownCity.sendKeys(townCity);
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectEISE_CountyState(String countyState) {
        scroll(-500, 0);
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTYSTATE_XPATH, true);
        moveTo2(EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTYSTATE_XPATH);
        selectFromDropDown(EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTYSTATE_XPATH, countyState);
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectEISE_Country(String country) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTRY_XPATH, true);
        selectFromDropDown(EMPLOYMENT_INCOMES_SELFEMPLOYED_COUNTRY_XPATH, country);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEISE_BusinessNature(String businessNature) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_BUSINESS_NATURE_XPATH, true);
        weEISE_BusinessNature.clear();
        weEISE_BusinessNature.sendKeys(businessNature);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEISE_StartDate(String startDate) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_STARTDATE_XPATH, true);
        weEISE_StartDate.clear();
        weEISE_StartDate.sendKeys(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEISE_EndDate(String endDate) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_ENDDATE_XPATH, true);
        weEISE_EndDate.clear();
        weEISE_EndDate.sendKeys(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkEISE_Currently() {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_CURRENTLY_XPATH, true); // verification if it is checked
        weEISE_Currently.click();
        return this;
    }

    @Override
    public IEmploymentIncomeSection uncheckEISE_Currently() {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_CURRENTLY_XPATH, true);
        weEISE_Currently.click();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEISE_NetProfitLastYear(String netProfitLastYear) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_NETPROFIT_LASTYEAR_XPATH, true);
        weEISE_NetProfitLastYear.clear();
        weEISE_NetProfitLastYear.sendKeys(netProfitLastYear);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEISE_NetProfitPreviousYear(String netProfitPreviousYear) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_NETPROFIT_PREVIOUSYEAR_XPATH, true);
        weEISE_NetProfitPreviousYear.clear();
        weEISE_NetProfitPreviousYear.sendKeys(netProfitPreviousYear);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEISE_AccountantName(String accountantName) {
        isVisible(EMPLOYMENT_INCOMES_SELFEMPLOYED_ACCOUNTANT_NAME_XPATH, true);
        weEISE_AccountantName.clear();
        weEISE_AccountantName.sendKeys(accountantName);
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectEICS_Occupation(String occupation) {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_OCCUPATION_XPATH, true);
        selectFromDropDown(EMPLOYMENT_INCOMES_CIVIL_SERVANT_OCCUPATION_XPATH, occupation);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEICS_EmployerName(String employerName) {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_EMPLOYER_NAME_XPATH, true);
        weEICS_EmployerName.clear();
        weEICS_EmployerName.sendKeys(employerName);
        return this;
    }

    @Override
    public IEmploymentIncomeSection selectEICS_EmploymentType(String employmentType) {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_EMPLOYMENT_TYPE_XPATH, true);
        selectFromDropDown(EMPLOYMENT_INCOMES_CIVIL_SERVANT_EMPLOYMENT_TYPE_XPATH, employmentType);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEICS_StartDate(String startDate) {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_STARTDATE_XPATH, true);
        weEICS_StartDate.clear();
        weEICS_StartDate.sendKeys(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEICS_MandatoryEndDate(String mandatoryEndDate) {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_MANDATORY_ENDDATE_XPATH, true);
        weEICS_MandatoryEndDate.clear();
        weEICS_MandatoryEndDate.sendKeys(mandatoryEndDate);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEICS_EndDate(String endDate) {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_ENDDATE_XPATH, true);
        weEICS_EndDate.clear();
        weEICS_EndDate.sendKeys(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkEICS_Currently() {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_CURRENTLY_XPATH, true);
        weEICS_Currently.click();
        return this;
    }

    @Override
    public IEmploymentIncomeSection uncheckEICS_Currently() {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_CURRENTLY_XPATH, true);
        weEICS_Currently.click();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEICS_GrossSalary(String grossSalary) {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_GROSS_SALARY_XPATH, true);
        weEICS_GrossSalary.clear();
        weEICS_GrossSalary.sendKeys(grossSalary);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEICS_RegularOvertime(String regularOvertime) {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_REGULAR_OVERTIME_XPATH, true);
        weEICS_RegularOvertime.clear();
        weEICS_RegularOvertime.sendKeys(regularOvertime);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEICS_RegularGuaranteedBonus(String regularGuaranteedBonus) {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_REGULAR_GUARANTEED_BONUS_XPATH, true);
        weEICS_RegularGuaranteedBonus.clear();
        weEICS_RegularGuaranteedBonus.sendKeys(regularGuaranteedBonus);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEICS_GuaranteedCommission(String guaranteedCommission) {
        isVisible(EMPLOYMENT_INCOMES_CIVIL_SERVANT_GUARANTEED_COMMISSION_XPATH, true);
        weEICS_GuaranteedCommission.clear();
        weEICS_GuaranteedCommission.sendKeys(guaranteedCommission);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIUH_StartDate(String startDate) {
        isVisible(EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_STARTDATE_XPATH, true);
        weEIUH_StartDate.clear();
        weEIUH_StartDate.sendKeys(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIUH_EndDate(String endDate) {
        isVisible(EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_ENDDATE_XPATH, true);
        weEIUH_EndDate.clear();
        weEIUH_EndDate.sendKeys(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomeSection checkEIUH_Currently() {
        isVisible(EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_CURRENTLY, true);
        weEIUH_Currently.click();
        return this;
    }

    @Override
    public IEmploymentIncomeSection uncheckEIUH_Currently() {
        isVisible(EMPLOYMENT_INCOMES_UNEMPLOYED_HOMEMAKER_CURRENTLY, true);
        weEIUH_Currently.click();
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIO_SourceIncome(String sourceIncome) {
        isVisible(EMPLOYMENT_INCOMES_OTHERS_SOURCE_INCOME_XPATH, true);
        weEIO_SourceIncome.clear();
        weEIO_SourceIncome.sendKeys(sourceIncome);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIO_GrossIncomes(String grossIncomes) {
        isVisible(EMPLOYMENT_INCOMES_OTHERS_GROSS_INCOMES_XPATH, true);
        weEIO_GrossIncomes.clear();
        weEIO_GrossIncomes.sendKeys(grossIncomes);
        return this;
    }

    @Override
    public IEmploymentIncomeSection typeEIO_TimeEarningIncome(String timeEarningIncome) {
        isVisible(EMPLOYMENT_INCOMES_OTHERS_TIME_EARNING_INCOME_XPATH, true);
        weEIO_TimeEarningIncome.clear();
        weEIO_TimeEarningIncome.sendKeys(timeEarningIncome);
        return this;
    }

    @Override
    public boolean isExistReportIncomes() {
        return isInvisible(REPORT_INCOMES_XPATH);
//        return isVisible(REPORT_INCOMES_XPATH);
    }

    @Override
    public Map<Integer, ReportEmploymentIncome> getReportsEmploymentIncome() {
        return null;
    }

    @Override
    public Map<Integer, ReportEmploymentIncome> delReportEmploymentIncome(int i) {
        return null;
    }

    @Override
    public IEmploymentIncomeSection clickEmploymentIncomeCancel() {
        isVisible(EMPLOYMENT_INCOMES_CANCEL_XPATH, true);
        weEmploymentIncomesCancel.click();
        return this;
    }

    @Override
    public IEmploymentIncomeSection clickEmploymentIncomeAddThisEmployment() {
        isVisible(EMPLOYMENT_INCOMES_ADD_THIS_EMPLOYMENT_XPATH, true, 5);
//        weEmploymentIncomesAddThisEmployment.click();
        clickElement(EMPLOYMENT_INCOMES_ADD_THIS_EMPLOYMENT_XPATH);
        isNotVisible("//div[@wicketpath='main_c_form_dialogWrapper']", true, 15);
        return this;
    }

    @Override
    public IEmploymentIncomeSection clickEmploymentIncomeAddEmployment() {
//        isVisible(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH, true, 5);
        try {
//            weEmploymentIncomesAddEmployment.click();
            clickElement(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
            isVisible("//div[@wicketpath='main_c_form_dialogWrapper']", true, 5);
        } catch ( WebDriverException e) {
//            clickElement(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
            if (!isVisible("//div[@wicketpath='main_c_form_dialogWrapper']", false, 5))
                clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
        }
//        clickElement(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
//        clickElementViaJavascript(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
//        if (!isVisible("//div[@wicketpath='main_c_form_dialogWrapper']", false, 5)) {
//            clickElement(EMPLOYMENT_INCOMES_ADD_EMPLOYMENT_XPATH);
//        }
        return this;
    }

    @Override
    public IEmploymentIncomeSection clickEmploymentIncomeDone() {
        isVisible(EMPLOYMENT_INCOMES_DONE_XPATH, true);
//        clickElement(EMPLOYMENT_INCOMES_DONE_XPATH);
        clickElementViaJavascript(EMPLOYMENT_INCOMES_DONE_XPATH);
//        weEmploymentIncomesDone.click();
        if(isVisible(INDICATOR_SMALL_ON, false, 5))
            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }
}
