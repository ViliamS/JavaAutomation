package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.EmploymentIncomeData;
import com.r2development.leveris.selenium.borrower.pageobjects.EmploymentIncomesPage;
import com.r2development.leveris.selenium.borrower.pageobjects.IEmploymentIncomesPage;
import com.r2development.leveris.selenium.borrower.pageobjects.IFormsMenu;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;
import org.openqa.selenium.TimeoutException;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

@Singleton
public class EmploymentAndIncomeStepDef extends BorrowerStepDef implements CLV312Workaround {

    private static final Log log = LogFactory.getLog(EmploymentAndIncomeStepDef.class);

    EmploymentAndIncomeStepDef() {
        borrowerEmploymentIncomesPage = new EmploymentIncomesPage(WebDriverService.getWebDriverInstance());
        coapplicantEmploymentIncomesPage = new EmploymentIncomesPage(WebDriverService.getWebDriverInstance());
    }

    @Given("(borrower|coapplicant) fills in \"Employment Income\"$")
    public void user_fills_in_employment_income(String borrowerOrCoapplicant, Map<String, String> employmentIncomeDataMap) throws InterruptedException {
        workaroundCLV312(borrowerOrCoapplicant);
        EmploymentIncomeData employmentIncomeData = new EmploymentIncomeData(employmentIncomeDataMap);
//        borrower_coapplicant_user_clicks_an_employment_and_income_category(borrowerOrCoapplicant, employmentIncomeData.getCategoryIncome());
        borrower_coapplicant_user_clicks_an_employment_and_income_category(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"));
//        borrower_coapplicant_user_selects_category_occupation(borrowerOrCoapplicant, employmentIncomeData.getCategoryIncome(), employmentIncomeData.getOccupation());
        borrower_coapplicant_user_selects_category_occupation(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("occupation"));
//        borrower_coapplicant_user_types_category_employer_name(borrowerOrCoapplicant, employmentIncomeData.getCategoryIncome(), employmentIncomeData.getEmployerName());
        borrower_coapplicant_user_types_category_employer_name(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("employerName"));
//        borrower_coapplicant_user_selects_category_employer_type(borrowerOrCoapplicant, employmentIncomeData.getCategoryIncome(), employmentIncomeData.getEmploymentType());
        borrower_coapplicant_user_selects_category_employer_type(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("employmentType"));
//        borrower_coapplicant_user_types_category_start_date(borrowerOrCoapplicant, employmentIncomeData.getCategoryIncome(), employmentIncomeData.getStartDate());
        borrower_coapplicant_user_types_category_start_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("startDate"));
//        borrower_coapplicant_user_checks_unchecks_category_currently(borrowerOrCoapplicant, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), employmentIncomeData.getCategoryIncome());
        borrower_coapplicant_user_checks_unchecks_category_currently(borrowerOrCoapplicant, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), employmentIncomeData.get("categoryIncome"));
//        borrower_coapplicant_user_types_category_salary(borrowerOrCoapplicant, employmentIncomeData.getCategoryIncome(), employmentIncomeData.getGrossSalary());
        borrower_coapplicant_user_types_category_salary(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("grossSalary"));
        borrower_coapplicant_user_clicks_add_this_employment(borrowerOrCoapplicant);
    }

    @Override
    public void workaroundCLV312(String borrowerOrCoapplicant) {

        if ( borrowerOrCoapplicant.equals("borrower")) {
            borrowerHomePage.clickInfoUpload();
            boolean toGoOn = false;
            while (!toGoOn) {
                try {
                    if (borrowerOrCoapplicant.equals("coapplicant") && StringUtils.isNotEmpty(user.getFirstNameCoApplicant())) {
                        ((IFormsMenu) borrowerPersonalDetailsPage).clickCoapplicantEmploymentIncome(user.getFirstNameCoApplicant());
                        //                    borrowerPersonalDetailsPage.clickBorrowerEmploymentIncome(user.getFirstNameCoApplicant());
//                        coapplicantEmploymentIncomesPage.isTitle(user.getFirstNameCoApplicant());
                        coapplicantEmploymentIncomesPage.isTitle("Automation");
                    } else if (borrowerOrCoapplicant.equals("borrower")) {
                        if (StringUtils.isEmpty(user.getFirstNameCoApplicant()))
                            borrowerPersonalDetailsPage.clickBorrowerEmploymentIncome();
                        else
                            borrowerPersonalDetailsPage.clickBorrowerEmploymentIncome(user.getFirstName());
//                        borrowerEmploymentIncomesPage.isTitle(user.getFirstName());
                        borrowerEmploymentIncomesPage.isTitle("Automation");
                    }
                    toGoOn = true;
                } catch (TimeoutException te) {
                    log.debug("Issues of getting Financial Assets page.");
                }
            }
        }
    }

    @Given("^(borrower|coapplicant) user sees his name in the Employment & Income title$")
    public void borrower_coapplicant_user_sees_his_name_in_the_title(String borrowerOrCoapplicant) {

        workaroundCLV312(borrowerOrCoapplicant);

        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrowerEmploymentIncomesPage.isTitle(user.getFirstName());
                break;
            case "coapplicant":
                coapplicantEmploymentIncomesPage.isTitle(user.getFirstNameCoApplicant());
                break;
            default:
                assertThat("....", false, Is.is(true));
        }
    }

    @Deprecated
    @Given("^(borrower|coapplicant) user selects the employment & income category : (Paye|Self Employed|Civil Servant|Unemployed|Homemaker)$")
    public void borrower_coapplicant_user_selects_an_employment_and_income_category(String borrowerOrCoapplicant, String category) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrowerEmploymentIncomesPage.selectCategory(category);
                break;
            case "coapplicant":
                coapplicantEmploymentIncomesPage.selectCategory(category);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user clicks the employment & income category : (Paye|SelfEmployed|CivilServant|Unemployed/Homemaker|Other)$")
    public void borrower_coapplicant_user_clicks_an_employment_and_income_category(String borrowerOrCoapplicant, String category) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrowerEmploymentIncomesPage.clickCategory(category);
                break;
            case "coapplicant":
                coapplicantEmploymentIncomesPage.clickCategory(category);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user selects the (Paye|Self Employed|Civil Servant) occupation : (.*)$")
    public void borrower_coapplicant_user_selects_category_occupation(String borrowerOrCoapplicant, String category, String occupation) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_selects_category_occupation(borrowerEmploymentIncomesPage, category, occupation);
                break;
            case "coapplicant":
                borrower_coapplicant_user_selects_category_occupation(coapplicantEmploymentIncomesPage, category, occupation);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_selects_category_occupation(IEmploymentIncomesPage employmentIncomesPage, String category, String occupation) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.selectEIP_Occupation(occupation);
                break;
            case "Self Employed":
                employmentIncomesPage.selectEISE_Occupation(occupation);
                break;
            case "Civil Servant":
                employmentIncomesPage.selectEICS_Occupation(occupation);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Civil Servant) employer's name : (.*)$")
    public void borrower_coapplicant_user_types_category_employer_name(String borrowerOrCoapplicant, String category, String employerName) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_employer_name(borrowerEmploymentIncomesPage, category, employerName);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_employer_name(coapplicantEmploymentIncomesPage, category, employerName);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_employer_name(IEmploymentIncomesPage employmentIncomesPage, String category, String employerName) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.typeEIP_EmployerName(employerName);
                break;
            case "Civil Servant":
                employmentIncomesPage.typeEICS_EmployerName(employerName);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user selects the (Paye|Civil Servant) employment type : (Contract|Permanent|Temporary)$")
    public void borrower_coapplicant_user_selects_category_employer_type(String borrowerOrCoapplicant, String category, String employmentType) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_selects_category_employer_type(borrowerEmploymentIncomesPage, category, employmentType);
                break;
            case "coapplicant":
                borrower_coapplicant_user_selects_category_employer_type(coapplicantEmploymentIncomesPage, category, employmentType);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_selects_category_employer_type(IEmploymentIncomesPage employmentIncomesPage, String category, String employmentType) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.selectEIP_EmploymentType(employmentType);
                break;
            case "Civil Servant":
                employmentIncomesPage.selectEICS_EmploymentType(employmentType);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) start date : (.*)$")
    public void borrower_coapplicant_user_types_category_start_date(String borrowerOrCoapplicant, String category, String startDate) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_start_date(borrowerEmploymentIncomesPage, category, startDate);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_start_date(coapplicantEmploymentIncomesPage, category, startDate);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_start_date(IEmploymentIncomesPage employmentIncomesPage, String category, String startDate) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.typeEIP_StartDate(startDate);
                break;
            case "Self Employed":
                employmentIncomesPage.typeEISE_StartDate(startDate);
                break;
            case "Civil Servant":
                employmentIncomesPage.typeEICS_StartDate(startDate);
                break;
            case "Unemployed/Homemaker":
                employmentIncomesPage.typeEIUH_StartDate(startDate);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) end date : (.*)$")
    public void borrower_coapplicant_user_types_category_end_date(String borrowerOrCoapplicant, String category, String endDate) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_end_date(borrowerEmploymentIncomesPage, category, endDate);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_end_date(coapplicantEmploymentIncomesPage, category, endDate);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_end_date(IEmploymentIncomesPage employmentIncomesPage, String category, String endDate) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.typeEIP_EndDate(endDate);
                break;
            case "Self Employed":
                employmentIncomesPage.typeEISE_EndDate(endDate);
                break;
            case "Civil Servant":
                employmentIncomesPage.typeEICS_EndDate(endDate);
                break;
            case "Unemployed/Homemaker":
                employmentIncomesPage.typeEIUH_EndDate(endDate);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user (checks|unchecks) the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) currently$")
    public void borrower_coapplicant_user_checks_unchecks_category_currently(String borrowerOrCoapplicant, String action, String category) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_checks_unchecks_category_currently(borrowerEmploymentIncomesPage, action, category);
                break;
            case "coapplicant":
                borrower_coapplicant_user_checks_unchecks_category_currently(coapplicantEmploymentIncomesPage, action, category);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_checks_unchecks_category_currently(IEmploymentIncomesPage employmentIncomesPage, String action, String category) {
        switch (category) {
            case "Paye":
                if (action.equals("checks"))
                    employmentIncomesPage.checkEIP_Currently();
                else if (action.equals("unchecks"))
                    employmentIncomesPage.uncheckEIP_Currently();
                break;
            case "Self Employed":
                if (action.equals("checks"))
                    employmentIncomesPage.checkEISE_Currently();
                else if (action.equals("unchecks"))
                    employmentIncomesPage.uncheckEISE_Currently();
                break;
            case "Civil Servant":
                if (action.equals("checks"))
                    employmentIncomesPage.checkEICS_Currently();
                else if (action.equals("unchecks"))
                    employmentIncomesPage.uncheckEICS_Currently();
                break;
            case "Unemployed/Homemaker":
                if (action.equals("checks"))
                    employmentIncomesPage.checkEIUH_Currently();
                else if (action.equals("unchecks"))
                    employmentIncomesPage.uncheckEIUH_Currently();
                break;
            default:
                assertThat("No Valid employment category.", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Civil Servant) gross salary : (.*)$")
    public void borrower_coapplicant_user_types_category_salary(String borrowerOrCoapplicant, String category, String grossSalary) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_salary(borrowerEmploymentIncomesPage, category, grossSalary);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_salary(coapplicantEmploymentIncomesPage, category, grossSalary);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_salary(IEmploymentIncomesPage employmentIncomesPage, String category, String grossSalary) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.typeEIP_GrossSalary(grossSalary);
                break;
            case "Civil Servant":
                employmentIncomesPage.typeEICS_GrossSalary(grossSalary);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Civil Servant) regular overtime : (.*)$")
    public void borrower_coapplicant_user_types_category_regular_overtime(String borrowerOrCoapplicant, String category, String regularOvertime) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_regular_overtime(borrowerEmploymentIncomesPage, category, regularOvertime);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_regular_overtime(coapplicantEmploymentIncomesPage, category, regularOvertime);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_regular_overtime(IEmploymentIncomesPage employmentIncomesPage, String category, String regularOvertime) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.typeEIP_RegularOvertime(regularOvertime);
                break;
            case "Civil Servant":
                employmentIncomesPage.typeEICS_RegularOvertime(regularOvertime);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Civil Servant) regular guaranteed bonus : (.*)$")
    public void borrower_coapplicant_user_types_category_regular_guaranteed_bonus(String borrowerOrCoapplicant, String category, String regularGuaranteedBonus) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_regular_guaranteed_bonus(borrowerEmploymentIncomesPage, category, regularGuaranteedBonus);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_regular_guaranteed_bonus(coapplicantEmploymentIncomesPage, category, regularGuaranteedBonus);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_regular_guaranteed_bonus(IEmploymentIncomesPage employmentIncomesPage, String category, String regularGuaranteedBonus) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.typeEIP_RegularGuaranteedBonus(regularGuaranteedBonus);
                break;
            case "Civil Servant":
                employmentIncomesPage.typeEICS_RegularGuaranteedBonus(regularGuaranteedBonus);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Civil Servant) guaranteed commission : (.*)$")
    public void borrower_coapplicant_user_types_category_guaranteed_commission(String borrowerOrCoapplicant, String category, String guaranteedCommission) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_guaranteed_commission(borrowerEmploymentIncomesPage, category, guaranteedCommission);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_guaranteed_commission(coapplicantEmploymentIncomesPage, category, guaranteedCommission);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_guaranteed_commission(IEmploymentIncomesPage employmentIncomesPage, String category, String guaranteedCommission) {
        switch (category) {
            case "Paye":
                employmentIncomesPage.typeEIP_GuaranteedCommission(guaranteedCommission);
                break;
            case "Civil Servant":
                employmentIncomesPage.typeEICS_GuaranteedCommission(guaranteedCommission);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) business name : (.*)$")
    public void borrower_coapplicant_user_types_category_business_name(String borrowerOrCoapplicant, String category, String businessName) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_business_name(borrowerEmploymentIncomesPage, category, businessName);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_business_name(coapplicantEmploymentIncomesPage, category, businessName);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_business_name(IEmploymentIncomesPage employmentIncomesPage, String category, String businessName) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeEISE_BusinessName(businessName);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) address line 1 : (.*)$")
    public void borrower_coapplicant_user_types_category_address_line1(String borrowerOrCoapplicant, String category, String addressLine1) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_address_line1(borrowerEmploymentIncomesPage, category, addressLine1);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_address_line1(coapplicantEmploymentIncomesPage, category, addressLine1);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_address_line1(IEmploymentIncomesPage employmentIncomesPage, String category, String addressLine1) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeEISE_AddressLine1(addressLine1);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) address line 2 : (.*)$")
    public void borrower_coapplicant_user_types_category_address_line2(String borrowerOrCoapplicant, String category, String addressLine2) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_address_line2(borrowerEmploymentIncomesPage, category, addressLine2);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_address_line2(coapplicantEmploymentIncomesPage, category, addressLine2);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_address_line2(IEmploymentIncomesPage employmentIncomesPage, String category, String addressLine2) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeEISE_AddressLine2(addressLine2);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) town/city : (.*)$")
    public void borrower_coapplicant_user_types_category_town_city(String borrowerOrCoapplicant, String category, String townCity) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_town_city(borrowerEmploymentIncomesPage, category, townCity);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_town_city(coapplicantEmploymentIncomesPage, category, townCity);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_town_city(IEmploymentIncomesPage employmentIncomesPage, String category, String townCity) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeEISE_TownCity(townCity);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) county/state : (.*)$")
    public void borrower_coapplicant_user_types_category_county_state(String borrowerOrCoapplicant, String category, String countyState) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_county_state(borrowerEmploymentIncomesPage, category, countyState);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_county_state(coapplicantEmploymentIncomesPage, category, countyState);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_county_state(IEmploymentIncomesPage employmentIncomesPage, String category, String countyState) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.selectEISE_CountyState(countyState);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user selects the (Self Employed) country : (.*)$")
    public void borrower_coapplicant_user_selects_category_country(String borrowerOrCoapplicant, String category, String country) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_selects_category_country(borrowerEmploymentIncomesPage, category, country);
                break;
            case "coapplicant":
                borrower_coapplicant_user_selects_category_country(coapplicantEmploymentIncomesPage, category, country);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_selects_category_country(IEmploymentIncomesPage employmentIncomesPage, String category, String country) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.selectEISE_Country(country);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) nature of business : (.*)$")
    public void borrower_coapplicant_user_types_category_nature_business(String borrowerOrCoapplicant, String category, String natureBusiness) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_nature_business(borrowerEmploymentIncomesPage, category, natureBusiness);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_nature_business(coapplicantEmploymentIncomesPage, category, natureBusiness);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_nature_business(IEmploymentIncomesPage employmentIncomesPage, String category, String natureBusiness) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeEISE_BusinessNature(natureBusiness);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) net profit last year : (.*)$")
    public void borrower_coapplicant_user_types_category_net_profit_last_year(String borrowerOrCoapplicant, String category, String netProfitLastYear) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_net_profit_last_year(borrowerEmploymentIncomesPage, category, netProfitLastYear);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_net_profit_last_year(coapplicantEmploymentIncomesPage, category, netProfitLastYear);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_net_profit_last_year(IEmploymentIncomesPage employmentIncomesPage, String category, String netProfitLastYear) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeEISE_NetProfitLastYear(netProfitLastYear);
                break;
            default:
                assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) net profit previous year : (.*)$")
    public void borrower_coapplicant_user_types_category_net_profit_previous_year(String borrowerOrCoapplicant, String category, String netProfitPreviousYear) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_net_profit_previous_year(borrowerEmploymentIncomesPage, category, netProfitPreviousYear);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_net_profit_previous_year(coapplicantEmploymentIncomesPage, category, netProfitPreviousYear);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_net_profit_previous_year(IEmploymentIncomesPage employmentIncomesPage, String category, String netProfitPreviousYear) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeEISE_NetProfitPreviousYear(netProfitPreviousYear);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) accountant name / practice : (.*)$")
    public void borrower_coapplicant_user_types_category_accountant_name_practice(String borrowerOrCoapplicant, String category, String accountantNamePractice) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_accountant_name_practice(borrowerEmploymentIncomesPage, category, accountantNamePractice);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_accountant_name_practice(coapplicantEmploymentIncomesPage, category, accountantNamePractice);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_accountant_name_practice(IEmploymentIncomesPage employmentIncomesPage, String category, String accountantNamePractice) {
        switch (category) {
            case "Self Employed":
                employmentIncomesPage.typeEISE_AccountantName(accountantNamePractice);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Other) source of additional income : (.*)$")
    public void borrower_coapplicant_user_types_category_source_additional_income(String borrowerOrCoapplicant, String category, String sourceAdditionalIncome) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_source_additional_income(borrowerEmploymentIncomesPage, category, sourceAdditionalIncome);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_source_additional_income(coapplicantEmploymentIncomesPage, category, sourceAdditionalIncome);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_source_additional_income(IEmploymentIncomesPage employmentIncomesPage, String category, String sourceAdditionalIncome) {
        switch (category) {
            case "Other":
                employmentIncomesPage.typeEIO_SourceIncome(sourceAdditionalIncome);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Other) gross income : (.*)$")
    public void borrower_coapplicant_user_types_category_gross_income(String borrowerOrCoapplicant, String category, String grossIncome) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_gross_income(borrowerEmploymentIncomesPage, category, grossIncome);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_gross_income(coapplicantEmploymentIncomesPage, category, grossIncome);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_gross_income(IEmploymentIncomesPage employmentIncomesPage, String category, String grossIncome) {
        switch (category) {
            case "Other":
                employmentIncomesPage.typeEIO_GrossIncomes(grossIncome);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Other) time earning this income : (.*)$")
    public void borrower_coapplicant_user_types_category_time_earning_income(String borrowerOrCoapplicant, String category, String timeEarningIncome) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_time_earning_income(borrowerEmploymentIncomesPage, category, timeEarningIncome);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_time_earning_income(coapplicantEmploymentIncomesPage, category, timeEarningIncome);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    private void borrower_coapplicant_user_types_category_time_earning_income(IEmploymentIncomesPage employmentIncomesPage, String category, String timeEarningIncome) {
        switch (category) {
            case "Other":
                employmentIncomesPage.typeEIO_TimeEarningIncome(timeEarningIncome);
                break;
            default:
               assertThat("...", false, Is.is(true));
        }
    }

    @When("^(borrower|coapplicant) user clicks \"Add This Employment\"$")
    public void borrower_coapplicant_user_clicks_add_this_employment(String borrowerOrCoapplicant) {
        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerEmploymentIncomesPage.clickEmploymentIncomeAddThisEmployment();
                break;
            case "coapplicant":
                coapplicantEmploymentIncomesPage.clickEmploymentIncomeAddThisEmployment();
                break;
            default:
        }

    }

    @When("^(borrower|coapplicant) user clicks \"ADD EMPLOYMENT\"$")
    public void borrower_coapplicant_user_clicks_add_employment(String borrowerOrCoapplicant) {
//        workaroundCLV312(borrowerOrCoapplicant);
        switch(borrowerOrCoapplicant) {
            case "borrower":
                borrowerEmploymentIncomesPage.clickEmploymentIncomeAddEmployment();
                break;
            case "coapplicant":
                coapplicantEmploymentIncomesPage.clickEmploymentIncomeAddEmployment();
                break;
            default:
        }

    }

    @Then("^(borrower|coapplicant) user clicks \"Done\"$")
    public void borrower_coapplicant_user_clicks_done(String borrowerOrCoapplicant) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrowerEmploymentIncomesPage.clickEmploymentIncomeDone();
                break;
            case "coapplicant":
                coapplicantEmploymentIncomesPage.clickEmploymentIncomeDone();
                break;
            default:
        }
    }
}