package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.EmploymentIncomeData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Singleton
public class EmploymentAndIncomeStepDef /*extends BorrowerStepDef*/ /*implements CLV312Workaround*/ {

    private static final Log log = LogFactory.getLog(EmploymentAndIncomeStepDef.class);

    private final WebDriver webDriver;
    @Inject
    IUser user;
    IBorrowerHomePage borrowerHomePage;
    IPersonalDetailsPage borrowerPersonalDetailsPage;
//    IEmploymentIncomesPage coapplicantEmploymentIncomesPage;
    IEmploymentIncomesPage borrowerEmploymentIncomesPage;
    IYourAccountsPage yourAccountsPage;

    @Inject
    EmploymentAndIncomeStepDef(SharedDriver webDriver/*, IUser user*/) {
        this.webDriver = webDriver;
//        this.user = user;
//        super(webDriver);
        borrowerEmploymentIncomesPage = new EmploymentIncomesPage(webDriver);
//        coapplicantEmploymentIncomesPage = new EmploymentIncomesPage(WebDriverService.getWebDriverInstance());
    }

    @Given("(Borrower) fills in Employment and Income type (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other)$")
//    public void user_fills_in_employment_income(String borrowerOrCoapplicant, Map<String, String> employmentIncomeDataMap) throws InterruptedException {
    public void user_fills_in_employment_income(String borrowerOrCoapplicant, String employmentCategory, List<String> employmentIncomeDataMap) throws InterruptedException {
//        workaroundCLV312(borrowerOrCoapplicant);
        EmploymentIncomeData employmentIncomeData = new EmploymentIncomeData(employmentIncomeDataMap);

        assertEquals(
                "We should have the same employment and income category in step def calling and in the table",
                employmentCategory,
                employmentIncomeData.get("categoryIncome")
        );

        switch (employmentIncomeData.get("categoryIncome")) {

            case "Paye":

                borrower_coapplicant_user_clicks_an_employment_and_income_category(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"));
                borrower_coapplicant_user_selects_category_occupation(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("occupation"));
                borrower_coapplicant_user_types_category_employer_name(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("employerName"));
                borrower_coapplicant_user_selects_category_employer_type(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("employmentType"));
                borrower_coapplicant_user_types_category_start_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("startDate"));
                borrower_coapplicant_user_checks_unchecks_category_currently(borrowerOrCoapplicant, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), employmentIncomeData.get("categoryIncome"));

                if ( !employmentIncomeData.isCurrentEmployment() )
                    borrower_coapplicant_user_types_category_end_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("endDate"));
                borrower_coapplicant_user_types_category_net_monthly_income(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("netMonthlyIncome"));
                break;

            case "Self Employed":
                borrower_coapplicant_user_clicks_an_employment_and_income_category(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"));
                borrower_coapplicant_user_selects_category_occupation(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("occupation"));
                borrower_coapplicant_user_types_category_business_name(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("businessName"));
                borrower_coapplicant_user_types_category_address_line1(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("addressLine1"));

                if ( !StringUtils.isEmpty(employmentIncomeData.get("addressLine2")))
                    borrower_coapplicant_user_types_category_address_line2(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("addressLine2"));

                borrower_coapplicant_user_types_category_town_city(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("townCity"));

                if ( !StringUtils.isEmpty(employmentIncomeData.get("country")) ) {
                    borrower_coapplicant_user_selects_category_country(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("country"));

                    if ( !StringUtils.isEmpty(employmentIncomeData.get("country")) && employmentIncomeData.get("country").equals("Ireland") )
                        borrower_coapplicant_user_types_category_county_state(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("countyState"));
                }

                borrower_coapplicant_user_types_category_nature_business(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("businessNature"));
                borrower_coapplicant_user_types_category_start_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("startDate"));
                borrower_coapplicant_user_checks_unchecks_category_currently(borrowerOrCoapplicant, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), employmentIncomeData.get("categoryIncome"));

                if ( !employmentIncomeData.isCurrentEmployment() )
                    borrower_coapplicant_user_types_category_end_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("endDate"));

                borrower_coapplicant_user_types_category_net_monthly_income(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("netMonthlyIncome"));
                break;

            case "Civil Servant":
                borrower_coapplicant_user_clicks_an_employment_and_income_category(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"));
                borrower_coapplicant_user_selects_category_occupation(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("occupation"));
                borrower_coapplicant_user_types_category_employer_name(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("employerName"));
                borrower_coapplicant_user_selects_category_employer_type(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("employmentType"));
                borrower_coapplicant_user_types_category_start_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("startDate"));
                borrower_coapplicant_user_checks_unchecks_category_currently(borrowerOrCoapplicant, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), employmentIncomeData.get("categoryIncome"));

                if ( !employmentIncomeData.isCurrentEmployment() )
                    borrower_coapplicant_user_types_category_end_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("endDate"));
                borrower_coapplicant_user_types_category_net_monthly_income(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("netMonthlyIncome"));
                break;

            case "Unemployed/Homemaker":
                borrower_coapplicant_user_clicks_an_employment_and_income_category(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"));
                borrower_coapplicant_user_types_category_start_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("startDate"));
                borrower_coapplicant_user_checks_unchecks_category_currently(borrowerOrCoapplicant, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), employmentIncomeData.get("categoryIncome"));

                if ( !employmentIncomeData.isCurrentEmployment() )
                    borrower_coapplicant_user_types_category_end_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("endDate"));
                break;

            case "Other":
                borrower_coapplicant_user_clicks_an_employment_and_income_category(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"));
                borrower_coapplicant_user_types_category_source_additional_income(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("additionalIncomeSource"));
                borrower_coapplicant_user_types_category_net_monthly_income(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("netMonthlyIncome"));
                borrower_coapplicant_user_types_category_time_earning_income(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("timeEarningIncome"));
                break;

            default:
                log.error("Huston, we have a problem on selecting Employment&Income category");
        }
        borrower_coapplicant_user_clicks_add_this_employment(borrowerOrCoapplicant);
    }

    @Given("^(Borrower) user sees his name in the Employment & Income title$")
    public void borrower_coapplicant_user_sees_his_name_in_the_title(String borrowerOrCoapplicant) {

//        workaroundCLV312(borrowerOrCoapplicant);

        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrowerEmploymentIncomesPage.isTitle(user.getFirstName());
                break;
        }
    }

    @Deprecated
    @Given("^(Borrower) user selects the employment & income category : (Paye|Self Employed|Civil Servant|Unemployed|Homemaker)$")
    public void borrower_coapplicant_user_selects_an_employment_and_income_category(String borrowerOrCoapplicant, String category) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrowerEmploymentIncomesPage.selectCategory(category);
                break;
//            case "coapplicant":
//                coapplicantEmploymentIncomesPage.selectCategory(category);
//                break;
        }
    }

    @Given("^(Borrower) user clicks the employment & income category : (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other)$")
    public void borrower_coapplicant_user_clicks_an_employment_and_income_category(String borrowerOrCoapplicant, String category) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrowerEmploymentIncomesPage.clickCategory(category);
                break;
//            case "coapplicant":
//                coapplicantEmploymentIncomesPage.clickCategory(category);
//                break;
        }
    }

    @Given("^(Borrower) user selects the (Paye|Self Employed|Civil Servant) occupation : (.*)$")
    public void borrower_coapplicant_user_selects_category_occupation(String borrowerOrCoapplicant, String category, String occupation) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_selects_category_occupation(borrowerEmploymentIncomesPage, category, occupation);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_selects_category_occupation(coapplicantEmploymentIncomesPage, category, occupation);
//                break;
        }
    }

    private void borrower_coapplicant_user_selects_category_occupation(IEmploymentIncomesPage employmentIncomesPage, String category, String occupation) {
        switch (category) {
            case "Paye":
//                employmentIncomesPage.selectEIP_Occupation(occupation);
                employmentIncomesPage.selectPaye_Occupation(occupation);
                break;
            case "Self Employed":
//                employmentIncomesPage.selectEISE_Occupation(occupation);
                employmentIncomesPage.selectSelfEmployment_Occupation(occupation);
                break;
            case "Civil Servant":
//                employmentIncomesPage.selectEICS_Occupation(occupation);
                employmentIncomesPage.selectCivilServant_Occupation(occupation);
                break;
        }
    }

    @Given("^(borrower) user types the (Paye|Civil Servant) employer's name : (.*)$")
    public void borrower_coapplicant_user_types_category_employer_name(String borrowerOrCoapplicant, String category, String employerName) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_employer_name(borrowerEmploymentIncomesPage, category, employerName);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_employer_name(coapplicantEmploymentIncomesPage, category, employerName);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_employer_name(IEmploymentIncomesPage employmentIncomesPage, String category, String employerName) {
        switch (category) {
            case "Paye":
//                employmentIncomesPage.typeEIP_EmployerName(employerName);
                employmentIncomesPage.typePaye_EmploymentName(employerName);
                break;
            case "Civil Servant":
//                employmentIncomesPage.typeEICS_EmployerName(employerName);
                employmentIncomesPage.typeCivilServant_EmploymentName(employerName);
                break;
        }
    }

    @Given("^(Borrower) user selects the (Paye|Civil Servant) employment type : (Contract|Permanent|Temporary)$")
    public void borrower_coapplicant_user_selects_category_employer_type(String borrowerOrCoapplicant, String category, String employmentType) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_selects_category_employer_type(borrowerEmploymentIncomesPage, category, employmentType);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_selects_category_employer_type(coapplicantEmploymentIncomesPage, category, employmentType);
//                break;
        }
    }

    private void borrower_coapplicant_user_selects_category_employer_type(IEmploymentIncomesPage employmentIncomesPage, String category, String employmentType) {
        switch (category) {
            case "Paye":
//                employmentIncomesPage.selectEIP_EmploymentType(employmentType);
                employmentIncomesPage.selectPaye_EmploymentType(employmentType);
                break;
            case "Civil Servant":
//                employmentIncomesPage.selectEICS_EmploymentType(employmentType);
                employmentIncomesPage.selectCivilServant_EmploymentType(employmentType);
                break;
        }
    }

    @Given("^(Borrower) user types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) start date : (.*)$")
    public void borrower_coapplicant_user_types_category_start_date(String borrowerOrCoapplicant, String category, String startDate) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_types_category_start_date(borrowerEmploymentIncomesPage, category, startDate);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_start_date(coapplicantEmploymentIncomesPage, category, startDate);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_start_date(IEmploymentIncomesPage employmentIncomesPage, String category, String startDate) {
        switch (category) {
            case "Paye":
//                employmentIncomesPage.typeEIP_StartDate(startDate);
                employmentIncomesPage.typePaye_StartDate(startDate);
                break;
            case "Self Employed":
//                employmentIncomesPage.typeEISE_StartDate(startDate);
                employmentIncomesPage.typeSelfEmployment_StartDate(startDate);
                break;
            case "Civil Servant":
//                employmentIncomesPage.typeEICS_StartDate(startDate);
                employmentIncomesPage.typeCivilServant_StartDate(startDate);
                break;
            case "Unemployed/Homemaker":
//                employmentIncomesPage.typeEIUH_StartDate(startDate);
                employmentIncomesPage.typeUnemployment_StartDate(startDate);
                break;
        }
    }

    @Given("^(Borrower) user types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) end date : (.*)$")
    public void borrower_coapplicant_user_types_category_end_date(String borrowerOrCoapplicant, String category, String endDate) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_types_category_end_date(borrowerEmploymentIncomesPage, category, endDate);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_end_date(coapplicantEmploymentIncomesPage, category, endDate);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_end_date(IEmploymentIncomesPage employmentIncomesPage, String category, String endDate) {
        switch (category) {
            case "Paye":
//                employmentIncomesPage.typeEIP_EndDate(endDate);
                employmentIncomesPage.typePaye_EndDate(endDate);
                break;
            case "Self Employed":
//                employmentIncomesPage.typeEISE_EndDate(endDate);
                employmentIncomesPage.typeSelfEmployment_EndDate(endDate);
                break;
            case "Civil Servant":
//                employmentIncomesPage.typeEICS_EndDate(endDate);
                employmentIncomesPage.typeCivilServant_EndDate(endDate);
                break;
            case "Unemployed/Homemaker":
//                employmentIncomesPage.typeEIUH_EndDate(endDate);
                employmentIncomesPage.typeUnemployment_EndDate(endDate);
                break;
        }
    }

    @Given("^(Borrower) user (checks|unchecks) the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) currently$")
    public void borrower_coapplicant_user_checks_unchecks_category_currently(String borrowerOrCoapplicant, String action, String category) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_checks_unchecks_category_currently(borrowerEmploymentIncomesPage, action, category);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_checks_unchecks_category_currently(coapplicantEmploymentIncomesPage, action, category);
//                break;
        }
    }

    private void borrower_coapplicant_user_checks_unchecks_category_currently(IEmploymentIncomesPage employmentIncomesPage, String action, String category) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.checkPaye_Currently(action);
                break;
            case "Self Employed":
                employmentIncomesPage.checkSelfEmployment_Currently(action);
                break;
            case "Civil Servant":
                employmentIncomesPage.checkCivilServant_Currently(action);
                break;
            case "Unemployed/Homemaker":
                employmentIncomesPage.checkUnemployment_Currently(action);
                break;
        }
    }

    @Given("^(borrower) user types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other) net monthly income : (.*)$")
    public void borrower_coapplicant_user_types_category_net_monthly_income(String borrowerOrCoapplicant, String category, String netMonthlyIncome) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_net_monthly_income(borrowerEmploymentIncomesPage, category, netMonthlyIncome);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_net_monthly_income(coapplicantEmploymentIncomesPage, category, netMonthlyIncome);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_net_monthly_income(IEmploymentIncomesPage employmentIncomesPage, String category, String netMonthlyIncome) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.typePaye_NetIncomeMonthly(netMonthlyIncome);
                break;
            case "Self Employed":
                employmentIncomesPage.typeSelfEmployment_NetIncomeMonthly(netMonthlyIncome);
                break;
            case "Civil Servant":
                employmentIncomesPage.typeCivilServant_NetIncomeMonthly(netMonthlyIncome);
                break;
            case "Other":
                employmentIncomesPage.typeOther_NetIncomeMonthly(netMonthlyIncome);
                break;
        }
    }

//    @Given("^(Borrower) user types the (Paye|Civil Servant) gross salary : (.*)$")
//    public void borrower_coapplicant_user_types_category_salary(String borrowerOrCoapplicant, String category, String grossSalary) {
//        switch (borrowerOrCoapplicant) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_salary(borrowerEmploymentIncomesPage, category, grossSalary);
//                break;
////            case "coapplicant":
////                borrower_coapplicant_user_types_category_salary(coapplicantEmploymentIncomesPage, category, grossSalary);
////                break;
//        }
//    }

//    private void borrower_coapplicant_user_types_category_salary(IEmploymentIncomesPage employmentIncomesPage, String category, String grossSalary) {
//        switch (category) {
//            case "Paye":
//                employmentIncomesPage.typeEIP_GrossSalary(grossSalary);
//                break;
//            case "Civil Servant":
//                employmentIncomesPage.typeEICS_GrossSalary(grossSalary);
//                break;
//        }
//    }

//    @Given("^(Borrower) user types the (Paye|Civil Servant) regular overtime : (.*)$")
//    public void borrower_coapplicant_user_types_category_regular_overtime(String borrowerOrCoapplicant, String category, String regularOvertime) {
//        switch (borrowerOrCoapplicant) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_regular_overtime(borrowerEmploymentIncomesPage, category, regularOvertime);
//                break;
////            case "coapplicant":
////                borrower_coapplicant_user_types_category_regular_overtime(coapplicantEmploymentIncomesPage, category, regularOvertime);
////                break;
//        }
//    }

//    private void borrower_coapplicant_user_types_category_regular_overtime(IEmploymentIncomesPage employmentIncomesPage, String category, String regularOvertime) {
//        switch (category) {
//            case "Paye":
//                employmentIncomesPage.typeEIP_RegularOvertime(regularOvertime);
//                break;
//            case "Civil Servant":
//                employmentIncomesPage.typeEICS_RegularOvertime(regularOvertime);
//                break;
//        }
//    }

//    @Given("^(Borrower) user types the (Paye|Civil Servant) regular guaranteed bonus : (.*)$")
//    public void borrower_coapplicant_user_types_category_regular_guaranteed_bonus(String borrowerOrCoapplicant, String category, String regularGuaranteedBonus) {
//        switch (borrowerOrCoapplicant) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_regular_guaranteed_bonus(borrowerEmploymentIncomesPage, category, regularGuaranteedBonus);
//                break;
////            case "coapplicant":
////                borrower_coapplicant_user_types_category_regular_guaranteed_bonus(coapplicantEmploymentIncomesPage, category, regularGuaranteedBonus);
////                break;
//        }
//    }

//    private void borrower_coapplicant_user_types_category_regular_guaranteed_bonus(IEmploymentIncomesPage employmentIncomesPage, String category, String regularGuaranteedBonus) {
//        switch (category) {
//            case "Paye":
//                employmentIncomesPage.typeEIP_RegularGuaranteedBonus(regularGuaranteedBonus);
//                break;
//            case "Civil Servant":
//                employmentIncomesPage.typeEICS_RegularGuaranteedBonus(regularGuaranteedBonus);
//                break;
//        }
//    }

//    @Given("^(Borrower) user types the (Paye|Civil Servant) guaranteed commission : (.*)$")
//    public void borrower_coapplicant_user_types_category_guaranteed_commission(String borrowerOrCoapplicant, String category, String guaranteedCommission) {
//        switch (borrowerOrCoapplicant) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_guaranteed_commission(borrowerEmploymentIncomesPage, category, guaranteedCommission);
//                break;
////            case "coapplicant":
////                borrower_coapplicant_user_types_category_guaranteed_commission(coapplicantEmploymentIncomesPage, category, guaranteedCommission);
////                break;
//        }
//    }

//    private void borrower_coapplicant_user_types_category_guaranteed_commission(IEmploymentIncomesPage employmentIncomesPage, String category, String guaranteedCommission) {
//        switch (category) {
//            case "Paye":
//                employmentIncomesPage.typeEIP_GuaranteedCommission(guaranteedCommission);
//                break;
//            case "Civil Servant":
//                employmentIncomesPage.typeEICS_GuaranteedCommission(guaranteedCommission);
//                break;
//        }
//    }

    @Given("^(Borrower) user types the (Self Employed) business name : (.*)$")
    public void borrower_coapplicant_user_types_category_business_name(String borrowerOrCoapplicant, String category, String businessName) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_types_category_business_name(borrowerEmploymentIncomesPage, category, businessName);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_business_name(coapplicantEmploymentIncomesPage, category, businessName);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_business_name(IEmploymentIncomesPage employmentIncomesPage, String category, String businessName) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeSelfEmployment_BusinessName(businessName);
                break;
        }
    }

    @Given("^(Borrower) user types the (Self Employed) address line 1 : (.*)$")
    public void borrower_coapplicant_user_types_category_address_line1(String borrowerOrCoapplicant, String category, String addressLine1) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_types_category_address_line1(borrowerEmploymentIncomesPage, category, addressLine1);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_address_line1(coapplicantEmploymentIncomesPage, category, addressLine1);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_address_line1(IEmploymentIncomesPage employmentIncomesPage, String category, String addressLine1) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeSelfEmployment_AddressLine1(addressLine1);
                break;
        }
    }

    @Given("^(Borrower) user types the (Self Employed) address line 2 : (.*)$")
    public void borrower_coapplicant_user_types_category_address_line2(String borrowerOrCoapplicant, String category, String addressLine2) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_types_category_address_line2(borrowerEmploymentIncomesPage, category, addressLine2);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_address_line2(coapplicantEmploymentIncomesPage, category, addressLine2);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_address_line2(IEmploymentIncomesPage employmentIncomesPage, String category, String addressLine2) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeSelfEmployment_AddressLine2(addressLine2);
                break;
        }
    }

    @Given("^(Borrower) user types the (Self Employed) town/city : (.*)$")
    public void borrower_coapplicant_user_types_category_town_city(String borrowerOrCoapplicant, String category, String townCity) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_types_category_town_city(borrowerEmploymentIncomesPage, category, townCity);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_town_city(coapplicantEmploymentIncomesPage, category, townCity);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_town_city(IEmploymentIncomesPage employmentIncomesPage, String category, String townCity) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeSelfEmployment_TownCity(townCity);
                break;
        }
    }

    @Given("^(Borrower) user types the (Self Employed) county/state : (.*)$")
    public void borrower_coapplicant_user_types_category_county_state(String borrowerOrCoapplicant, String category, String countyState) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_types_category_county_state(borrowerEmploymentIncomesPage, category, countyState);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_county_state(coapplicantEmploymentIncomesPage, category, countyState);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_county_state(IEmploymentIncomesPage employmentIncomesPage, String category, String countyState) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.selectSelfEmployment_CountyState(countyState);
                break;
        }
    }

    @Given("^(Borrower) user selects the (Self Employed) country : (.*)$")
    public void borrower_coapplicant_user_selects_category_country(String borrowerOrCoapplicant, String category, String country) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_selects_category_country(borrowerEmploymentIncomesPage, category, country);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_selects_category_country(coapplicantEmploymentIncomesPage, category, country);
//                break;
        }
    }

    private void borrower_coapplicant_user_selects_category_country(IEmploymentIncomesPage employmentIncomesPage, String category, String country) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.selectSelfEmployment_Country(country);
                break;
        }
    }

    @Given("^(Borrower) user types the (Self Employed) nature of business : (.*)$")
    public void borrower_coapplicant_user_types_category_nature_business(String borrowerOrCoapplicant, String category, String natureBusiness) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_types_category_nature_business(borrowerEmploymentIncomesPage, category, natureBusiness);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_nature_business(coapplicantEmploymentIncomesPage, category, natureBusiness);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_nature_business(IEmploymentIncomesPage employmentIncomesPage, String category, String natureBusiness) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeSelfEmployment_BusinessNature(natureBusiness);
                break;
        }
    }

//    @Given("^(Borrower) user types the (Self Employed) net profit last year : (.*)$")
//    public void borrower_coapplicant_user_types_category_net_profit_last_year(String borrowerOrCoapplicant, String category, String netProfitLastYear) {
//        switch (borrowerOrCoapplicant) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_net_profit_last_year(borrowerEmploymentIncomesPage, category, netProfitLastYear);
//                break;
////            case "coapplicant":
////                borrower_coapplicant_user_types_category_net_profit_last_year(coapplicantEmploymentIncomesPage, category, netProfitLastYear);
////                break;
//        }
//    }
//
//    private void borrower_coapplicant_user_types_category_net_profit_last_year(IEmploymentIncomesPage employmentIncomesPage, String category, String netProfitLastYear) {
//        switch (category) {
//            case "Self Employed":
//                employmentIncomesPage.typeEISE_NetProfitLastYear(netProfitLastYear);
//                break;
//        }
//    }

//    @Given("^(Borrower) user types the (Self Employed) net profit previous year : (.*)$")
//    public void borrower_coapplicant_user_types_category_net_profit_previous_year(String borrowerOrCoapplicant, String category, String netProfitPreviousYear) {
//        switch (borrowerOrCoapplicant) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_net_profit_previous_year(borrowerEmploymentIncomesPage, category, netProfitPreviousYear);
//                break;
////            case "coapplicant":
////                borrower_coapplicant_user_types_category_net_profit_previous_year(coapplicantEmploymentIncomesPage, category, netProfitPreviousYear);
////                break;
//        }
//    }
//
//    private void borrower_coapplicant_user_types_category_net_profit_previous_year(IEmploymentIncomesPage employmentIncomesPage, String category, String netProfitPreviousYear) {
//        switch (category) {
//            case "Self Employed":
//                employmentIncomesPage.typeEISE_NetProfitPreviousYear(netProfitPreviousYear);
//                break;
//        }
//    }

//    @Given("^(Borrower) user types the (Self Employed) accountant name / practice : (.*)$")
//    public void borrower_coapplicant_user_types_category_accountant_name_practice(String borrowerOrCoapplicant, String category, String accountantNamePractice) {
//        switch (borrowerOrCoapplicant) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_accountant_name_practice(borrowerEmploymentIncomesPage, category, accountantNamePractice);
//                break;
////            case "coapplicant":
////                borrower_coapplicant_user_types_category_accountant_name_practice(coapplicantEmploymentIncomesPage, category, accountantNamePractice);
////                break;
//        }
//    }
//
//    private void borrower_coapplicant_user_types_category_accountant_name_practice(IEmploymentIncomesPage employmentIncomesPage, String category, String accountantNamePractice) {
//        switch (category) {
//            case "Self Employed":
//                employmentIncomesPage.typeEISE_AccountantName(accountantNamePractice);
//                break;
//        }
//    }

    @Given("^(Borrower) user types the (Other) source of additional income : (.*)$")
    public void borrower_coapplicant_user_types_category_source_additional_income(String borrowerOrCoapplicant, String category, String additionalIncomeSource) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_types_category_source_additional_income(borrowerEmploymentIncomesPage, category, additionalIncomeSource);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_source_additional_income(coapplicantEmploymentIncomesPage, category, additionalIncomeSource);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_source_additional_income(IEmploymentIncomesPage employmentIncomesPage, String category, String additionalIncomeSource) {
        switch (category) {
            case "Other":
                employmentIncomesPage.typeOther_AdditionalIncomeSource(additionalIncomeSource);
                break;
        }
    }

//    @Given("^(Borrower|coapplicant) user types the (Other) gross income : (.*)$")
//    public void borrower_coapplicant_user_types_category_gross_income(String borrowerOrCoapplicant, String category, String grossIncome) {
//        switch (borrowerOrCoapplicant) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_gross_income(borrowerEmploymentIncomesPage, category, grossIncome);
//                break;
////            case "coapplicant":
////                borrower_coapplicant_user_types_category_gross_income(coapplicantEmploymentIncomesPage, category, grossIncome);
////                break;
//        }
//    }
//
//    private void borrower_coapplicant_user_types_category_gross_income(IEmploymentIncomesPage employmentIncomesPage, String category, String grossIncome) {
//        switch (category) {
//            case "Other":
//                employmentIncomesPage.typeEIO_GrossIncomes(grossIncome);
//                break;
//        }
//    }

    @Given("^(Borrower) user types the (Other) time earning this income : (.*)$")
    public void borrower_coapplicant_user_types_category_time_earning_income(String borrowerOrCoapplicant, String category, String timeEarningIncome) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
                borrower_coapplicant_user_types_category_time_earning_income(borrowerEmploymentIncomesPage, category, timeEarningIncome);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_time_earning_income(coapplicantEmploymentIncomesPage, category, timeEarningIncome);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_time_earning_income(IEmploymentIncomesPage employmentIncomesPage, String category, String timeEarningIncome) {
        switch (category) {
            case "Other":
                employmentIncomesPage.typeOther_EarningTime(timeEarningIncome);
                break;
        }
    }

    @When("^(Borrower) user clicks \"Add This Employment\"$")
    public void borrower_coapplicant_user_clicks_add_this_employment(String borrowerOrCoapplicant) {
        switch(borrowerOrCoapplicant) {
            case "Borrower":
//                borrowerEmploymentIncomesPage.clickEmploymentIncomeAddThisEmployment();
                borrowerEmploymentIncomesPage.clickSaveAndClose();
                break;
//            case "coapplicant":
//                coapplicantEmploymentIncomesPage.clickEmploymentIncomeAddThisEmployment();
//                break;
        }

    }

    @When("^(Borrower|coapplicant) user clicks \"ADD EMPLOYMENT\"$")
    public void borrower_coapplicant_user_clicks_add_employment(String borrowerOrCoapplicant) {
//        workaroundCLV312(borrowerOrCoapplicant);
        switch(borrowerOrCoapplicant) {
            case "Borrower":
//                borrowerEmploymentIncomesPage.clickEmploymentIncomeAddEmployment();
                borrowerEmploymentIncomesPage.clickAdd();
                break;
//            case "coapplicant":
//                coapplicantEmploymentIncomesPage.clickEmploymentIncomeAddEmployment();
//                break;
        }

    }

    @Then("^(Borrower) user clicks \"Done\"$")
    public void borrower_coapplicant_user_clicks_done(String borrowerOrCoapplicant) {
        switch (borrowerOrCoapplicant) {
            case "Borrower":
//                yourAccountsPage = borrowerEmploymentIncomesPage.clickEmploymentIncomeDone();
                yourAccountsPage = borrowerEmploymentIncomesPage.clickDone();
                yourAccountsPage.getTitle();
                break;
//            case "coapplicant":
//                coapplicantEmploymentIncomesPage.clickEmploymentIncomeDone();
//                break;
        }
    }
}