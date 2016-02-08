package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.EmploymentIncomeData;
import com.r2development.leveris.selenium.borrower.pageobjects.IEmploymentIncomesPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

@Singleton
public class ApiEmploymentAndIncomeStepDef extends ApiAbakusBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiEmploymentAndIncomeStepDef.class);

    ApiEmploymentAndIncomeStepDef() {
    }

    @Given("(borrower|coapplicant) fills in \"Employment Income\"$")
    public void user_fills_in_employment_income(String borrowerOrCoapplicant, Map<String, String> employmentIncomeDataMap) throws IOException {

        if ( borrowerOrCoapplicant.equals("coapplicant") ) {
            requestHttpPost(
                    httpClient,
//                    "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:left:c:form:form:root:c:w:pnlBorrower2:c:w:rptBorrower2UncommonForms:c:rows:2:item:pnlBorrower2UncommonForms:c:w:btnBorrower2UncommonForms:submit::IBehaviorListener:0:",
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:left:c:form:form:root:c:w:pnlBorrower2:c:w:rptBorrower2UncommonForms:c:rows:2:item:pnlBorrower2UncommonForms:c:w:btnBorrower2UncommonForms:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    null,
                    localContext,
                    CONSUME_QUIETLY
            );
        }

        EmploymentIncomeData employmentIncomeData = new EmploymentIncomeData(employmentIncomeDataMap);
        borrower_coapplicant_user_clicks_an_employment_and_income_category(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"));
        borrower_coapplicant_user_selects_category_occupation(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("occupation"));
        borrower_coapplicant_user_types_category_employer_name(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("employerName"));
        borrower_coapplicant_user_selects_category_employer_type(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("employmentType"));
        borrower_coapplicant_user_types_category_start_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("startDate"));
        borrower_coapplicant_user_checks_unchecks_category_currently(borrowerOrCoapplicant, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), employmentIncomeData.get("categoryIncome"));
        borrower_coapplicant_user_types_category_salary(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("grossSalary"));
        borrower_coapplicant_user_types_category_regular_overtime(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), "");
        borrower_coapplicant_user_types_category_regular_guaranteed_bonus(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), "");
        borrower_coapplicant_user_types_category_guaranteed_commission(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), "");
        borrower_coapplicant_user_clicks_add_this_employment(borrowerOrCoapplicant);
    }

    @Given("^(borrower|coapplicant) user sees his name in the Employment & Income title$")
    public void borrower_coapplicant_user_sees_his_name_in_the_title(String borrowerOrCoapplicant) {
    }

    @Deprecated
    @Given("^(borrower|coapplicant) user selects the employment & income category : (Paye|Self Employed|Civil Servant|Unemployed|Homemaker)$")
    public void borrower_coapplicant_user_selects_an_employment_and_income_category(String borrowerOrCoapplicant, String category) {
    }

    @Given("^(borrower|coapplicant) user clicks the employment & income category : (Paye|SelfEmployed|CivilServant|Unemployed|Homemaker)$")
    public void borrower_coapplicant_user_clicks_an_employment_and_income_category(String borrowerOrCoapplicant, String category) throws IOException {

        switch ( category ) {
            case "Paye":
                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAddPaye:dialog::IBehaviorListener:0:",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        null,
                        localContext,
                        CONSUME_QUIETLY
                );
                break;
            case "SelfEmployed":
                break;
            case "CivilServant":
                break;
            case "Unemployed":
                break;
            case "Homemaker":
                break;
            default:
                log.info("Huston, we have problem ! Do we have a new category type ?");
        }
    }

    @Given("^(borrower|coapplicant) user selects the (Paye|Self Employed|Civil Servant) occupation : (.*)$")
    public void borrower_coapplicant_user_selects_category_occupation(String borrowerOrCoapplicant, String category, String occupation) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_selects_category_occupation(borrowerEmploymentIncomeParameters, category, occupation);
                break;
            case "coapplicant":
                borrower_coapplicant_user_selects_category_occupation(coapplicantEmploymentIncomeParameters, category, occupation);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
        }
    }

    private void borrower_coapplicant_user_selects_category_occupation(Map<String, String> employmentIncomesParameters, String category, String occupation) {
        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:cmbJobTitle:combobox", occupation);
                break;
            case "Self Employed":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:cmbJobTitle:combobox", occupation);
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:cmbJobTitle:combobox", occupation);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Self Employed")), not(equalTo("Civil Servant")) ));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Civil Servant) employer's name : (.*)$")
    public void borrower_coapplicant_user_types_category_employer_name(String borrowerOrCoapplicant, String category, String employerName) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_employer_name(borrowerEmploymentIncomeParameters, category, employerName);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_employer_name(coapplicantEmploymentIncomeParameters, category, employerName);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));

        }
    }

    private void borrower_coapplicant_user_types_category_employer_name(Map<String, String> employmentIncomesParameters, String category, String employerName) {
        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmployerName:tb", employerName);
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmployerName:tb", employerName);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Self Employed")), not(equalTo("Civil Servant")) ));
        }
    }

    @Given("^(borrower|coapplicant) user selects the (Paye|Civil Servant) employment type : (Contract|Permanent|Temporary)$")
    public void borrower_coapplicant_user_selects_category_employer_type(String borrowerOrCoapplicant, String category, String employmentType) throws IOException {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_selects_category_employer_type(borrowerEmploymentIncomeParameters, category, employmentType);
                break;
            case "coapplicant":
                borrower_coapplicant_user_selects_category_employer_type(coapplicantEmploymentIncomeParameters, category, employmentType);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
        }
    }

    private void borrower_coapplicant_user_selects_category_employer_type(Map<String, String> employmentIncomesParameters, String category, String employmentType) throws IOException {

        String finalEmploymentType = StringUtils.EMPTY;
        switch ( employmentType ) {
            case "Contract":
                finalEmploymentType = "CON";
                break;
            case "Permanent":
                finalEmploymentType = "PER";
                requestHttpPost(
                        httpClient,
//                        "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put(
                                    "data",
                                    "{" +
                                        "\"widgets\": [" +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlSelfEmployed cmbCounty\"," +
                                                "\"data\": {" +
                                                    "\"visible\": true" +
                                                "}," +
                                                "\"visibleEvent\": \"show\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlSelfEmployed cmbCounty\"," +
                                                "\"data\": {" +
                                                    "\"visible\": true" +
                                                "}," +
                                                "\"visibleEvent\": \"show\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlEmployed txtEmployerName\"," +
                                                "\"data\": {" +
                                                    "\"visible\": true" +
                                                "}," +
                                                "\"visibleEvent\": \"show\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlEmployed cmbEmplType\"," +
                                                "\"data\": {" +
                                                    "\"visible\": true" +
                                                "}," +
                                                "\"visibleEvent\": \"show\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlEmployed txtEmplStartDate\"," +
                                                "\"data\": {" +
                                                    "\"visible\": true" +
                                                "}," +
                                                "\"visibleEvent\": \"show\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\"," +
                                                "\"data\": {" +
                                                    "\"visible\": true" +
                                                "}," +
                                                "\"visibleEvent\": \"show\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlEmployed crbEmplGrossSalary\"," +
                                                "\"data\": {" +
                                                    "\"visible\": true" +
                                                "}," +
                                                "\"visibleEvent\": \"show\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlEmployed crbEmplGrossBonus\"," +
                                                "\"data\": {" +
                                                    "\"visible\": true" +
                                                "}," +
                                                "\"visibleEvent\": \"show\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlEmployed crbEmplGrossOvertime\"," +
                                                "\"data\": {" +
                                                    "\"visible\": true" +
                                                "}," +
                                                "\"visibleEvent\": \"show\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlEmployed\"," +
                                                "\"data\": {" +
                                                    "\"visible\": true" +
                                                "}," +
                                                "\"delta\": 530," +
                                                "\"visibleEvent\": \"show\"" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlSelfEmployed\"," +
                                                "\"data\": {" +
                                                    "\"enable\": false" +
                                                "}" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlOther\"," +
                                                "\"data\": {" +
                                                    "\"enable\": false" +
                                                "}" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlUnemployed\"," +
                                                "\"data\": {" +
                                                    "\"enable\": false" +
                                                "}" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlSelfEmployed txtBusinessEndDate\"," +
                                                "\"data\": {" +
                                                    "\"enable\": true" +
                                                "}" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlUnemployed txtUnemployedEndDate\"," +
                                                "\"data\": {" +
                                                    "\"enable\": true" +
                                                "}" +
                                            "}," +
                                            "{" +
                                                "\"widget\": \"pnlDetail pnlEmployed txtEmplEndDate\"," +
                                                "\"data\": {" +
                                                    "\"enable\": false" +
                                                "}" +
                                            "}" +
                                        "]" +
                                    "}"
                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY
                );

                break;
            case "Temporary":
                finalEmploymentType = "TEM";
                break;
            default:
        }

        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:cmbEmplType:combobox", finalEmploymentType);
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:cmbEmplType:combobox", finalEmploymentType);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) start date : (.*)$")
    public void borrower_coapplicant_user_types_category_start_date(String borrowerOrCoapplicant, String category, String startDate) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_start_date(borrowerEmploymentIncomeParameters, category, startDate);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_start_date(coapplicantEmploymentIncomeParameters, category, startDate);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
        }
    }

    private void borrower_coapplicant_user_types_category_start_date(Map<String, String> employmentIncomesParameters, String category, String startDate) {
        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplStartDate:tb", startDate);
                break;
            case "Self Employed":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplStartDate:tb", startDate);
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplStartDate:tb", startDate);
                break;
            case "Unemployed/Homemaker":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplStartDate:tb", startDate);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Self Employed")), not(equalTo("Civil Servant")), not(equalTo("Unemployed/Homemaker")) ));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) end date : (.*)$")
    public void borrower_coapplicant_user_types_category_end_date(String borrowerOrCoapplicant, String category, String endDate) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_end_date(borrowerEmploymentIncomeParameters, category, endDate);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_end_date(coapplicantEmploymentIncomeParameters, category, endDate);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
        }
    }

    private void borrower_coapplicant_user_types_category_end_date(Map<String, String> employmentIncomesParameters, String category, String endDate) {
        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplEndDate:tb", endDate);
                break;
            case "Self Employed":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplEndDate:tb", endDate);
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplEndDate:tb", endDate);
                break;
            case "Unemployed/Homemaker":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:txtEmplEndDate:tb", endDate);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Self Employed")), not(equalTo("Civil Servant")), not(equalTo("Unemployed/Homemaker")) ));
        }
    }

    @Given("^(borrower|coapplicant) user (checks|unchecks) the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) currently$")
    public void borrower_coapplicant_user_checks_unchecks_category_currently(String borrowerOrCoapplicant, String action, String category) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_checks_unchecks_category_currently(borrowerEmploymentIncomeParameters, action, category);
                break;
            case "coapplicant":
                borrower_coapplicant_user_checks_unchecks_category_currently(coapplicantEmploymentIncomeParameters, action, category);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
        }
    }

    private void borrower_coapplicant_user_checks_unchecks_category_currently(Map<String, String> employmentIncomesParameters, String action, String category) {
        switch (category) {
            case "Paye":
                if (action.equals("checks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "on");
//                else if (action.equals("unchecks"))
//                    employmentIncomesPage.uncheckEIP_Currently();
                break;
            case "Self Employed":
                if (action.equals("checks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "on");
//                else if (action.equals("unchecks"))
//                    employmentIncomesPage.uncheckEISE_Currently();
                break;
            case "Civil Servant":
                if (action.equals("checks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "on");
//                else if (action.equals("unchecks"))
//                    employmentIncomesPage.uncheckEICS_Currently();
                break;
            case "Unemployed/Homemaker":
                if (action.equals("checks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "on");
//                else if (action.equals("unchecks"))
//                    employmentIncomesPage.uncheckEIUH_Currently();
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Self Employed")), not(equalTo("Civil Servant")), not(equalTo("Unemployed/Homemaker")) ));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Civil Servant) gross salary : (.*)$")
    public void borrower_coapplicant_user_types_category_salary(String borrowerOrCoapplicant, String category, String grossSalary) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_salary(borrowerEmploymentIncomeParameters, category, grossSalary);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_salary(coapplicantEmploymentIncomeParameters, category, grossSalary);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
        }
    }

    private void borrower_coapplicant_user_types_category_salary(Map<String, String> employmentIncomesParameters, String category, String grossSalary) {
        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossSalary:tb", grossSalary);
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossSalary:tb", grossSalary);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Civil Servant) regular overtime : (.*)$")
    public void borrower_coapplicant_user_types_category_regular_overtime(String borrowerOrCoapplicant, String category, String regularOvertime) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_regular_overtime(borrowerEmploymentIncomeParameters, category, regularOvertime);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_regular_overtime(coapplicantEmploymentIncomeParameters, category, regularOvertime);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
        }
    }

    private void borrower_coapplicant_user_types_category_regular_overtime(Map<String, String> employmentIncomesParameters, String category, String regularOvertime) {
        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossOvertime:tb", regularOvertime);
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossOvertime:tb", regularOvertime);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Civil Servant) regular guaranteed bonus : (.*)$")
    public void borrower_coapplicant_user_types_category_regular_guaranteed_bonus(String borrowerOrCoapplicant, String category, String regularGuaranteedBonus) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_regular_guaranteed_bonus(borrowerEmploymentIncomeParameters, category, regularGuaranteedBonus);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_regular_guaranteed_bonus(coapplicantEmploymentIncomeParameters, category, regularGuaranteedBonus);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
        }
    }

    private void borrower_coapplicant_user_types_category_regular_guaranteed_bonus(Map<String, String> employmentIncomesParameters, String category, String regularGuaranteedBonus) {
        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossBonus:tb", regularGuaranteedBonus);
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossBonus:tb", regularGuaranteedBonus);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Paye|Civil Servant) guaranteed commission : (.*)$")
    public void borrower_coapplicant_user_types_category_guaranteed_commission(String borrowerOrCoapplicant, String category, String guaranteedCommission) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_guaranteed_commission(borrowerEmploymentIncomeParameters, category, guaranteedCommission);
                break;
            case "coapplicant":
                borrower_coapplicant_user_types_category_guaranteed_commission(coapplicantEmploymentIncomeParameters, category, guaranteedCommission);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
        }
    }

    private void borrower_coapplicant_user_types_category_guaranteed_commission(Map<String, String> employmentIncomesParameters, String category, String guaranteedCommission) {
        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbCommision:tb", guaranteedCommission);
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbCommision:tb", guaranteedCommission);
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
        }
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) business name : (.*)$")
    public void borrower_coapplicant_user_types_category_business_name(String borrowerOrCoapplicant, String category, String businessName) {
    }

    private void borrower_coapplicant_user_types_category_business_name(IEmploymentIncomesPage employmentIncomesPage, String category, String businessName) {
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) address line 1 : (.*)$")
    public void borrower_coapplicant_user_types_category_address_line1(String borrowerOrCoapplicant, String category, String addressLine1) {
    }

    private void borrower_coapplicant_user_types_category_address_line1(IEmploymentIncomesPage employmentIncomesPage, String category, String addressLine1) {
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) address line 2 : (.*)$")
    public void borrower_coapplicant_user_types_category_address_line2(String borrowerOrCoapplicant, String category, String addressLine2) {
    }

    private void borrower_coapplicant_user_types_category_address_line2(IEmploymentIncomesPage employmentIncomesPage, String category, String addressLine2) {
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) town/city : (.*)$")
    public void borrower_coapplicant_user_types_category_town_city(String borrowerOrCoapplicant, String category, String townCity) {
    }

    private void borrower_coapplicant_user_types_category_town_city(IEmploymentIncomesPage employmentIncomesPage, String category, String townCity) {
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) county/state : (.*)$")
    public void borrower_coapplicant_user_types_category_county_state(String borrowerOrCoapplicant, String category, String countyState) {
    }

    private void borrower_coapplicant_user_types_category_county_state(IEmploymentIncomesPage employmentIncomesPage, String category, String countyState) {
    }

    @Given("^(borrower|coapplicant) user selects the (Self Employed) country : (.*)$")
    public void borrower_coapplicant_user_selects_category_country(String borrowerOrCoapplicant, String category, String country) {
    }

    private void borrower_coapplicant_user_selects_category_country(IEmploymentIncomesPage employmentIncomesPage, String category, String country) {
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) nature of business : (.*)$")
    public void borrower_coapplicant_user_types_category_nature_business(String borrowerOrCoapplicant, String category, String natureBusiness) {
    }

    private void borrower_coapplicant_user_types_category_nature_business(IEmploymentIncomesPage employmentIncomesPage, String category, String natureBusiness) {
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) net profit last year : (.*)$")
    public void borrower_coapplicant_user_types_category_net_profit_last_year(String borrowerOrCoapplicant, String category, String netProfitLastYear) {
    }

    private void borrower_coapplicant_user_types_category_net_profit_last_year(IEmploymentIncomesPage employmentIncomesPage, String category, String netProfitLastYear) {
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) net profit previous year : (.*)$")
    public void borrower_coapplicant_user_types_category_net_profit_previous_year(String borrowerOrCoapplicant, String category, String netProfitPreviousYear) {
    }

    private void borrower_coapplicant_user_types_category_net_profit_previous_year(IEmploymentIncomesPage employmentIncomesPage, String category, String netProfitPreviousYear) {
    }

    @Given("^(borrower|coapplicant) user types the (Self Employed) accountant name / practice : (.*)$")
    public void borrower_coapplicant_user_types_category_accountant_name_practice(String borrowerOrCoapplicant, String category, String accountantNamePractice) {
    }

    private void borrower_coapplicant_user_types_category_accountant_name_practice(IEmploymentIncomesPage employmentIncomesPage, String category, String accountantNamePractice) {
    }

    @Given("^(borrower|coapplicant) user types the (Other) source of additional income : (.*)$")
    public void borrower_coapplicant_user_types_category_source_additional_income(String borrowerOrCoapplicant, String category, String sourceAdditionalIncome) {
    }

    private void borrower_coapplicant_user_types_category_source_additional_income(IEmploymentIncomesPage employmentIncomesPage, String category, String sourceAdditionalIncome) {
    }

    @Given("^(borrower|coapplicant) user types the (Other) gross income : (.*)$")
    public void borrower_coapplicant_user_types_category_gross_income(String borrowerOrCoapplicant, String category, String grossIncome) {
    }

    private void borrower_coapplicant_user_types_category_gross_income(IEmploymentIncomesPage employmentIncomesPage, String category, String grossIncome) {
    }

    @Given("^(borrower|coapplicant) user types the (Other) time earning this income : (.*)$")
    public void borrower_coapplicant_user_types_category_time_earning_income(String borrowerOrCoapplicant, String category, String timeEarningIncome) {
    }

    private void borrower_coapplicant_user_types_category_time_earning_income(IEmploymentIncomesPage employmentIncomesPage, String category, String timeEarningIncome) {
    }

    @When("^(borrower|coapplicant) user clicks \"Add This Employment\"$")
    public void borrower_coapplicant_user_clicks_add_this_employment(String borrowerOrCoapplicant) throws IOException {

        Map<String, String> finalEmploymentIncomeParameters = new LinkedHashMap<>();

        switch ( borrowerOrCoapplicant ) {
            case "borrower":
                finalEmploymentIncomeParameters.putAll(borrowerEmploymentIncomeParameters);
                break;
            case "coapplicant":
                finalEmploymentIncomeParameters.putAll(coapplicantEmploymentIncomeParameters);
                break;
            default:
                log.debug("Huston we have a problem when finalizing EmploymentIncomeParameters");
        }

        finalEmploymentIncomeParameters.put("root:c:w:pnlDetail:c:w:txtHiddenId:tb", "");
        finalEmploymentIncomeParameters.put("stepToken", "1");
        finalEmploymentIncomeParameters.put("root:c:w:pnlDetail:c:w:btnEmploymentAdd:submit", "1");

        requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlDetail:c:w:btnEmploymentAdd:submit::IBehaviorListener:0:",
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlDetail:c:w:btnEmploymentAdd:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                finalEmploymentIncomeParameters,
                localContext,
                CONSUME_QUIETLY
        );

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAddPaye:close::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                null,
                localContext,
                CONSUME_QUIETLY
        );

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                        put("root:c:w:btnHiddenSubmit:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    @When("^(borrower|coapplicant) user clicks \"ADD EMPLOYMENT\"$")
    public void borrower_coapplicant_user_clicks_add_employment(String borrowerOrCoapplicant) {
    }

    @Then("^(borrower|coapplicant) user clicks \"Done\"$")
    public void borrower_coapplicant_user_clicks_done(String borrowerOrCoapplicant) throws IOException {

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnImDone:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "2");
                        put("root:c:w:pnlEmpList:c:w:btnImDone:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }
}