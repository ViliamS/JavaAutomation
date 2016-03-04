package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.EmploymentIncomeData;
import com.r2development.leveris.di.IHttpResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

@Singleton
public class ApiEmploymentAndIncomeStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiEmploymentAndIncomeStepDef.class);

    @Inject
    IHttpResponse httpResponse;

    @Inject
    public ApiEmploymentAndIncomeStepDef(IHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @Given("(borrower) fills in \"Employment Income\"$")
//    public void user_fills_in_employment_income(String borrowerOrCoapplicant, Map<String, String> employmentIncomeDataMap) throws IOException {
    public void user_fills_in_employment_income(String borrowerOrCoapplicant, List<String> employmentIncomeDataMap) throws IOException {

//        if ( borrowerOrCoapplicant.equals("coapplicant") ) {
//            requestHttpPost(
//                    httpClient,
//                    "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:left:c:form:form:root:c:w:pnlBorrower2:c:w:rptBorrower2UncommonForms:c:rows:2:item:pnlBorrower2UncommonForms:c:w:btnBorrower2UncommonForms:submit::IBehaviorListener:0:",
//                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:left:c:form:form:root:c:w:pnlBorrower2:c:w:rptBorrower2UncommonForms:c:rows:2:item:pnlBorrower2UncommonForms:c:w:btnBorrower2UncommonForms:submit::IBehaviorListener:0:",
//                    new LinkedHashMap<String, String>() {
//                        {
//                            put("Accept", "text/xml");
//                            put("Content-Type", "application/x-www-form-urlencoded");
//                        }
//                    },
//                    null,
//                    localContext,
//                    CONSUME_QUIETLY
//            );
//        }

        EmploymentIncomeData employmentIncomeData = new EmploymentIncomeData(employmentIncomeDataMap);

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
                if ( !StringUtils.isEmpty(employmentIncomeData.get("country")) && employmentIncomeData.get("country").equals("Ireland") )
                    borrower_coapplicant_user_types_category_county_state(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("countyState"));
                if ( !StringUtils.isEmpty(employmentIncomeData.get("country")) )
                    borrower_coapplicant_user_selects_category_country(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("country"));
                borrower_coapplicant_user_types_category_nature_business(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("businessNature"));
                borrower_coapplicant_user_types_category_start_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("startDate"));
                borrower_coapplicant_user_checks_unchecks_category_currently(borrowerOrCoapplicant, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), employmentIncomeData.get("categoryIncome"));
                if ( !employmentIncomeData.isCurrentEmployment() )
                    borrower_coapplicant_user_types_category_end_date(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("endDate"));
                borrower_coapplicant_user_types_category_net_monthly_income(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"), employmentIncomeData.get("netMonthlyIncome"));
                borrowerEmploymentIncomeParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:pnlAddressField1:data", "{\"countryCode\":\"CZ\",\"route\":\"\",\"streetNumber\":\"\",\"postalCode\":\"110 00\",\"region\":\"Prague\",\"houseNumber\":\"\",\"inputText\":\"Staré Město, Prague, Czech Republic\",\"county\":\"Hlavní město Praha\"}");
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

        borrower_coapplicant_user_clicks_add_this_employment(borrowerOrCoapplicant, employmentIncomeData.get("categoryIncome"));
    }

    public void workaroundCLV312(String borrowerOrCoapplicant) {
    }

    @Given("^(borrower) user sees his name in the Employment & Income title$")
    public void borrower_coapplicant_user_sees_his_name_in_the_title(String borrowerOrCoapplicant) {
    }

    @Given("^(borrower) user clicks the employment & income category : (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other)$")
    public void borrower_coapplicant_user_clicks_an_employment_and_income_category(String borrowerOrCoapplicant, String category) throws IOException {

        if ( !httpResponse.getHttpResponse().contains("ajax") ) {

        }

        Document empListDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textNodeEmpList = null;
        try {
            textNodeEmpList = empListDoc.select("component[id~=main]").select("component[encoding~=wicket]").first().textNodes().get(0);
//            textNodeEmpList = empListDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
        } catch ( NullPointerException npe ) {
            textNodeEmpList = empListDoc.select("component[id~=dialog]").select("component[encoding~=wicket]").first().textNodes().get(0);
        }
        Document empListDoc2 = Jsoup.parse(textNodeEmpList.text());

        Elements divEmploymentTypeAddElements = empListDoc2.select("div[data-path~=pnlNoEmplyments lnkAdd]");
//        Elements wicketInterfaceEmploymentTypeAddElements = empListDoc2.select("div[data-path~=pnlNoEmplyments lnkAdd] a[wicketpath~=root_c_w_pnlNoEmplyments_c_w_lnkAdd]").select("a[id~=dialog]");
        Map<String, String> wicketInterfaceMap = new LinkedHashMap<>();
        for ( Element current : divEmploymentTypeAddElements ) {
            String currentKey = current.attr("data-path").split(" ")[1];
//            String currentOnClick = current.select("a[wicketpath~=root_c_w_pnlNoEmplyments_c_w_lnkAdd]").select("a[id~=dialog]").attr("onclick");
            String currentOnClick = current.select("a[wicketpath~=root_c_w_pnlNoEmplyments_c_w_lnkAdd]").attr("onclick");

            Pattern pWicketInterface = Pattern.compile("\\?wicket:interface=(.*)&");
            Matcher mWicketInterface = pWicketInterface.matcher(currentOnClick);
            String currentWicketInterface = null;
            while (mWicketInterface.find()) {
                currentWicketInterface = mWicketInterface.group(1);
            }

            wicketInterfaceMap.put(currentKey, currentWicketInterface);
        }

        String fixCategory = StringUtils.EMPTY;
        switch ( category ) {
            case "Paye":
                fixCategory = category;
                break;
            case "Self Employed":
                fixCategory = "SelfEmployed";
                break;
            case "SelfEmployed":
                fixCategory = category;
                break;
            case "Civil Servant":
                fixCategory = "CivilServant";
                break;
            case "CivilServant":
                fixCategory = category;
                break;
            case "Unemployed/Homemaker":
                fixCategory = "Unemployment";
                break;
            case "Other":
                fixCategory = "Homemaker";
                break;
            default:
                log.error("Huston, we have an issue on Fix Category Type");
        }
        final String finalFixCategory = fixCategory;

        switch ( fixCategory ) {
            case "Paye":
                String linkAddPayeResponse = requestHttpPost(
                        httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAddPaye:dialog::IBehaviorListener:0:",
                        System.getProperty("borrower") + "/form.2?wicket:interface=" + wicketInterfaceMap.get("lnkAdd" + finalFixCategory),
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
                httpResponse.setHttpResponse(linkAddPayeResponse);

//                requestHttpPost(
//                        httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
//                        new LinkedHashMap<String, String>() {
//                            {
//                                put("Accept", "text/xml");
//                                put("Content-Type", "application/x-www-form-urlencoded");
//                            }
//                        },
//                        new LinkedHashMap<String, String>() {
//                            {
//                                put(
//                                    "data",
//                                    "" //"{\"widgets\":[{\"widget\":\"pnlDetail pnlSelfEmployed cmbCounty\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed cmbCounty\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed txtEmployerName\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed cmbEmplType\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed txtEmplStartDate\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossSalary\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossBonus\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossOvertime\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed\",\"data\":{\"visible\":true},\"delta\":520,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlNetIncomeEmpl\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\",\"data\":{\"visible\":false},\"delta\":-160,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlUnemployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed txtBusinessEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlUnemployed txtUnemployedEndDate\",\"data\":{\"enable\":true}}]}"
//                                );
//                            }
//                        },
//                        localContext,
//                        CONSUME_QUIETLY
//
//                );
//

                break;
            case "SelfEmployed":
                String linkAddSelfEmployedResponse = requestHttpPost(
                        httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAddEmp:dialog::IBehaviorListener:0:",
                        System.getProperty("borrower") + "/form.2?wicket:interface=" + wicketInterfaceMap.get("lnkAdd" + finalFixCategory),
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
                httpResponse.setHttpResponse(linkAddSelfEmployedResponse);

//                requestHttpPost(
//                        httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
//                        new LinkedHashMap<String, String>() {
//                            {
//                                put("Accept", "text/xml");
//                                put("Content-Type", "application/x-www-form-urlencoded");
//                            }
//                        },
//                        new LinkedHashMap<String, String>() {
//                            {
//                                put(
//                                        "data",
//                                        "{\"widgets\":[{\"widget\":\"pnlDetail pnlSelfEmployed cmbCounty\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed cmbCounty\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossSalary\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossOvertime\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossBonus\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbCommision\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\",\"data\":{}},{\"widget\":\"pnlDetail pnlSelfEmployed\",\"data\":{\"visible\":true},\"delta\":850,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{},\"delta\":-160,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit txtAccountantNamePractice\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitLastyear\",\"data\":{}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitPreviousYear\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit txtAccountantNamePractice\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitLastyear\",\"data\":{}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitPreviousYear\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlOtherIncome crbGrossIncome\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlOtherIncome txtOtherIncomeTime\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"enable\":false},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlUnemployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlEmployed txtEmplEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlUnemployed txtUnemployedEndDate\",\"data\":{\"enable\":true}}]}"
//                                );
//                            }
//                        },
//                        localContext,
//                        CONSUME_QUIETLY
//
//                );

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
                                put(
                                        "data",
                                        "{\"widgets\":[" +
                                                "{\"widget\":\"pnlDetail pnlEmployed\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossSalary\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit txtAccountantNamePractice\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitLastyear\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitPreviousYear\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlOther txtSourceAdditionalIncome\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlOtherIncome crbGrossIncome\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlOtherIncome txtOtherIncomeTime\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlNetIcomeOther crbNetIcomeOther\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlNetIcomeOther txtOtherNetIncomeTime\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"wicket\":\"pnlDetail pnlUnemployed txtUnemployedStartDate\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlSelfEmployed\", \"data\":{\"enable\":true}, \"visibleEvent\":\"show\"}" +
                                                "{\"widget\":\"pnlDetail pnlSefEmployed pnlProfit\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlNetIncomeSelf\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlOther\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlOtherIncome\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlNetIncomeOther\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlUnemployed\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                            "]}"
//                                        "{\"widgets\":[{\"widget\":\"pnlDetail pnlEmployed txtEmplEndDate\",\"data\":{\"enable\":false}}]}"
                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY

                );
                break;
            case "CivilServant":
                String linkAddCivilServantResponse = requestHttpPost(
                        httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAddEmp:dialog::IBehaviorListener:0:",
                        System.getProperty("borrower") + "/form.2?wicket:interface=" + wicketInterfaceMap.get("lnkAdd" + finalFixCategory),
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("stepToken", "1");
                                put("root:c:w:pnlNoEmplyments:c:w:lnkAddCivilServant:submit", "1");
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY
                );
                httpResponse.setHttpResponse(linkAddCivilServantResponse);

                break;
            case "Unemployment":
                String linkAddUmployedResponse = requestHttpPost(
                        httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAddEmp:dialog::IBehaviorListener:0:",
                        System.getProperty("borrower") + "/form.2?wicket:interface=" + wicketInterfaceMap.get("lnkAdd" + finalFixCategory),
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("stepToken", "1");
                                put("root:c:w:pnlNoEmplyments:c:w:lnkAddUnemployment:submit", "1");
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY
                );
                httpResponse.setHttpResponse(linkAddUmployedResponse);

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
                                put(
                                        "data",
                                        "{\"widgets\":[" +
                                                "{\"widget\":\"pnlDetail pnlEmployed\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossSalary\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit txtAccountantNamePractice\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitLastyear\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitPreviousYear\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlOther txtSourceAdditionalIncome\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlOtherIncome crbGrossIncome\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlOtherIncome txtOtherIncomeTime\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlNetIcomeOther crbNetIcomeOther\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlNetIcomeOther txtOtherNetIncomeTime\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"wicket\":\"pnlDetail pnlUnemployed txtUnemployedStartDate\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlSelfEmployed\", \"data\":{\"enable\":true}, \"visibleEvent\":\"show\"}" +
                                                "{\"widget\":\"pnlDetail pnlSefEmployed pnlProfit\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlNetIncomeSelf\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlOther\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlOtherIncome\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlNetIncomeOther\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "{\"widget\":\"pnlDetail pnlUnemployed\", \"data\":{\"enable\":false}, \"visibleEvent\":\"hide\"}" +
                                                "]}"
//                                        "{\"widgets\":[{\"widget\":\"pnlDetail pnlEmployed txtEmplEndDate\",\"data\":{\"enable\":false}}]}"
                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY

                );
                break;
            case "Homemaker":
                String linkAddOtherResponse = requestHttpPost(
                        httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAddEmp:dialog::IBehaviorListener:0:",
                        System.getProperty("borrower") + "/form.2?wicket:interface=" + wicketInterfaceMap.get("lnkAdd" + finalFixCategory),
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("stepToken", "1");
                                put("root:c:w:pnlNoEmplyments:c:w:lnkAddUnemployment:submit", "1");
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY
                );
                httpResponse.setHttpResponse(linkAddOtherResponse);

//                requestHttpPost(
//                        httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
//                        new LinkedHashMap<String, String>() {
//                            {
//                                put("Accept", "text/xml");
//                                put("Content-Type", "application/x-www-form-urlencoded");
//                            }
//                        },
//                        new LinkedHashMap<String, String>() {
//                            {
//                                put(
//                                        "data",
//                                        "{\"widgets\":[{\"widget\":\"pnlDetail pnlSelfEmployed cmbCounty\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed cmbCounty\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossSalary\",\"data\":{}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossOvertime\",\"data\":{}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossBonus\",\"data\":{}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbCommision\",\"data\":{}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\",\"data\":{}},{\"widget\":\"pnlDetail pnlSelfEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{},\"delta\":-160,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit txtAccountantNamePractice\",\"data\":{}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitLastyear\",\"data\":{}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitPreviousYear\",\"data\":{}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{}},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlOtherIncome crbGrossIncome\",\"data\":{}},{\"widget\":\"pnlDetail pnlOtherIncome txtOtherIncomeTime\",\"data\":{}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{}},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlUnemployed\",\"data\":{\"visible\":true},\"delta\":140,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed txtEmplEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed txtBusinessEndDate\",\"data\":{\"enable\":true}}"
//                                );
//                            }
//                        },
//                        localContext,
//                        CONSUME_QUIETLY
//
//                );
                break;
            default:
                log.info("Huston, we have problem ! Do we have a new category type ?");
        }
    }

    @Given("^(borrower) user selects the (Paye|Self Employed|Civil Servant) occupation : (.*)$")
    public void borrower_coapplicant_user_selects_category_occupation(String borrowerOrCoapplicant, String category, String occupation) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_selects_category_occupation(borrowerEmploymentIncomeParameters, category, occupation);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_selects_category_occupation(coapplicantEmploymentIncomesPage, category, occupation);
//                break;
        }
    }

    private void borrower_coapplicant_user_selects_category_occupation(Map<String, String> employmentIncomesParameters, String category, String occupation) {
        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:cmbJobTitle:combobox", occupation.toUpperCase());
                break;
            case "Self Employed":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:cmbSelfOccupation:combobox", occupation.toUpperCase());
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:cmbJobTitle:combobox", occupation.toUpperCase());
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Self Employed")), not(equalTo("Civil Servant")) ));
        }
    }

    @Given("^(borrower) user types the (Paye|Civil Servant) employer's name : (.*)$")
    public void borrower_coapplicant_user_types_category_employer_name(String borrowerOrCoapplicant, String category, String employerName) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_employer_name(borrowerEmploymentIncomeParameters, category, employerName);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_employer_name(coapplicantEmploymentIncomesPage, category, employerName);
//                break;
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

    @Given("^(borrower) user selects the (Paye|Civil Servant) employment type : (Contract|Permanent|Temporary)$")
    public void borrower_coapplicant_user_selects_category_employer_type(String borrowerOrCoapplicant, String category, String employmentType) throws IOException {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_selects_category_employer_type(borrowerEmploymentIncomeParameters, category, employmentType);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_selects_category_employer_type(coapplicantEmploymentIncomesPage, category, employmentType);
//                break;
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
                                        "{\"widgets\":[{\"widget\":\"pnlDetail pnlSelfEmployed cmbCounty\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed cmbCounty\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed txtEmployerName\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed cmbEmplType\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed txtEmplStartDate\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossSalary\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossBonus\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossOvertime\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed\",\"data\":{\"visible\":true},\"delta\":520,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlNetIncomeEmpl\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\",\"data\":{\"visible\":false},\"delta\":-160,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlUnemployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed txtBusinessEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlUnemployed txtUnemployedEndDate\",\"data\":{\"enable\":true}}]}"
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

    @Given("^(borrower) user types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) start date : (.*)$")
    public void borrower_coapplicant_user_types_category_start_date(String borrowerOrCoapplicant, String category, String startDate) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_start_date(borrowerEmploymentIncomeParameters, category, startDate);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_start_date(coapplicantEmploymentIncomeParameters, category, startDate);
//                break;
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
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:txtDateBussEstablished:tb", startDate);
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

    @Given("^(borrower) user types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) end date : (.*)$")
    public void borrower_coapplicant_user_types_category_end_date(String borrowerOrCoapplicant, String category, String endDate) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_end_date(borrowerEmploymentIncomeParameters, category, endDate);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_end_date(coapplicantEmploymentIncomeParameters, category, endDate);
//                break;
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
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:txtBusinessEndDate:tb", endDate);
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

    @Given("^(borrower) user (checks|unchecks) the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) currently$")
    public void borrower_coapplicant_user_checks_unchecks_category_currently(String borrowerOrCoapplicant, String action, String category) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_checks_unchecks_category_currently(borrowerEmploymentIncomeParameters, action, category);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_checks_unchecks_category_currently(coapplicantEmploymentIncomeParameters, action, category);
//                break;
            default:
                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
        }
    }

    private void borrower_coapplicant_user_checks_unchecks_category_currently(Map<String, String> employmentIncomesParameters, String action, String category) {
        switch (category) {
            case "Paye":
                if (action.equals("checks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "on");
                else if (action.equals("unchecks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "off");
                break;
            case "Self Employed":
                if (action.equals("checks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "on");
                else if (action.equals("unchecks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "off");
                break;
            case "Civil Servant":
                if (action.equals("checks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "on");
                else if (action.equals("unchecks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "off");
                break;
            case "Unemployed/Homemaker":
                if (action.equals("checks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "on");
                else if (action.equals("unchecks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlEmplCurrently:c:w:chkEmplCurrently:checkbox", "off");
                break;
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Self Employed")), not(equalTo("Civil Servant")), not(equalTo("Unemployed/Homemaker")) ));
        }
    }

    @Given("^(borrower) user types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other) net monthly income : (.*)$")
    public void borrower_coapplicant_user_types_category_net_monthly_income(String borrowerOrCoapplicant, String category, String netMonthlyIncome) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_net_monthly_income(borrowerEmploymentIncomeParameters, category, netMonthlyIncome);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_net_monthly_income(borrowerEmploymentIncomeParameters, category, netMonthlyIncome);
//                break;
            default:
                assertThat("We handle only borrower", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")) ));
        }
    }

    private void borrower_coapplicant_user_types_net_monthly_income(Map<String, String> employmentIncomesParameters, String category, String netMonthlyIncome) {
        switch (category) {
            case "Paye":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlNetIncomeEmpl:c:w:crbEmplNetIcome:tb", netMonthlyIncome);
                break;
            case "Self Employed":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlNetIcomeSelf:c:w:crbNetIcomeSelf:tb", netMonthlyIncome);
                break;
            case "Civil Servant":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlNetIncomeEmpl:c:w:crbEmplNetIcome:tb", netMonthlyIncome);
                break;
            case "Other":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlNetIncomeEmpl:c:w:crbEmplNetIcome:tb", netMonthlyIncome);
                break;
            default:
                assertThat("We handle only borrower", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
        }
    }

//    @Given("^(borrower) user types the (Paye|Civil Servant) net monthly salary : (.*)$")
//    public void borrower_coapplicant_user_types_net_monthly_salary(String borrowerOrCoapplicant, String category, String grossSalary) {
//        switch (borrowerOrCoapplicant) {
//            case "borrower":
//                borrower_coapplicant_user_types_net_monthly_salary(borrowerEmploymentIncomeParameters, category, grossSalary);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_net_monthly_salary(coapplicantEmploymentIncomeParameters, category, grossSalary);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
//        }
//    }

//    private void borrower_coapplicant_user_types_net_monthly_salary(Map<String, String> employmentIncomesParameters, String category, String grossSalary) {
//        switch (category) {
//            case "Paye":
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlNetIncomeEmpl:c:w:crbEmplNetIcome:tb", grossSalary);
//                break;
//            case "Civil Servant":
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:pnlNetIncomeEmpl:c:w:crbEmplNetIcome:tb", grossSalary);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
//        }
//    }
//
//    @Given("^(borrower) user types the (Paye|Civil Servant) gross salary : (.*)$")
//    public void borrower_coapplicant_user_types_category_salary(String borrowerOrCoapplicant, String category, String grossSalary) {
//        switch (borrowerOrCoapplicant) {
//            case "borrower":
//                borrower_coapplicant_user_types_category_salary(borrowerEmploymentIncomeParameters, category, grossSalary);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_salary(coapplicantEmploymentIncomeParameters, category, grossSalary);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
//        }
//    }

//    private void borrower_coapplicant_user_types_category_salary(Map<String, String> employmentIncomesParameters, String category, String grossSalary) {
//        switch (category) {
//            case "Paye":
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossSalary:tb", grossSalary);
//                break;
//            case "Civil Servant":
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossSalary:tb", grossSalary);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
//        }
//    }

//    @Given("^(borrower) user types the (Paye|Civil Servant) regular overtime : (.*)$")
//    public void borrower_coapplicant_user_types_category_regular_overtime(String borrowerOrCoapplicant, String category, String regularOvertime) {
//        switch (borrowerOrCoapplicant) {
//            case "borrower":
//                borrower_coapplicant_user_types_category_regular_overtime(borrowerEmploymentIncomeParameters, category, regularOvertime);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_regular_overtime(coapplicantEmploymentIncomeParameters, category, regularOvertime);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
//        }
//    }

//    private void borrower_coapplicant_user_types_category_regular_overtime(Map<String, String> employmentIncomesParameters, String category, String regularOvertime) {
//        switch (category) {
//            case "Paye":
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossOvertime:tb", regularOvertime);
//                break;
//            case "Civil Servant":
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossOvertime:tb", regularOvertime);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
//        }
//    }

//    @Given("^(borrower) user types the (Paye|Civil Servant) regular guaranteed bonus : (.*)$")
//    public void borrower_coapplicant_user_types_category_regular_guaranteed_bonus(String borrowerOrCoapplicant, String category, String regularGuaranteedBonus) {
//        switch (borrowerOrCoapplicant) {
//            case "borrower":
//                borrower_coapplicant_user_types_category_regular_guaranteed_bonus(borrowerEmploymentIncomeParameters, category, regularGuaranteedBonus);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_regular_guaranteed_bonus(coapplicantEmploymentIncomeParameters, category, regularGuaranteedBonus);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
//        }
//    }

//    private void borrower_coapplicant_user_types_category_regular_guaranteed_bonus(Map<String, String> employmentIncomesParameters, String category, String regularGuaranteedBonus) {
//        switch (category) {
//            case "Paye":
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossBonus:tb", regularGuaranteedBonus);
//                break;
//            case "Civil Servant":
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbEmplGrossBonus:tb", regularGuaranteedBonus);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
//        }
//    }

//    @Given("^(borrower) user types the (Paye|Civil Servant) guaranteed commission : (.*)$")
//    public void borrower_coapplicant_user_types_category_guaranteed_commission(String borrowerOrCoapplicant, String category, String guaranteedCommission) {
//        switch (borrowerOrCoapplicant) {
//            case "borrower":
//                borrower_coapplicant_user_types_category_guaranteed_commission(borrowerEmploymentIncomeParameters, category, guaranteedCommission);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_guaranteed_commission(coapplicantEmploymentIncomeParameters, category, guaranteedCommission);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", borrowerOrCoapplicant, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
//        }
//    }

//    private void borrower_coapplicant_user_types_category_guaranteed_commission(Map<String, String> employmentIncomesParameters, String category, String guaranteedCommission) {
//        switch (category) {
//            case "Paye":
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbCommision:tb", guaranteedCommission);
//                break;
//            case "Civil Servant":
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlEmployed:c:w:crbCommision:tb", guaranteedCommission);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
//        }
//    }

    @Given("^(borrower) user types the (Self Employed) business name : (.*)$")
    public void borrower_coapplicant_user_types_category_business_name(String borrowerOrCoapplicant, String category, String businessName) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_business_name(borrowerEmploymentIncomeParameters, category, businessName);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_business_name(coapplicantEmploymentIncomesPage, category, businessName);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_business_name(Map<String, String> employmentIncomesParameters, String category, String businessName) {
        switch (category) {
            case "Self Employed":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:txtBusinessName:tb", businessName);
                break;
        }
    }

    @Given("^(borrower) user types the (Self Employed) address line 1 : (.*)$")
    public void borrower_coapplicant_user_types_category_address_line1(String borrowerOrCoapplicant, String category, String addressLine1) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_address_line1(borrowerEmploymentIncomeParameters, category, addressLine1);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_address_line1(coapplicantEmploymentIncomesPage, category, addressLine1);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_address_line1(Map<String, String> employmentIncomesParameters, String category, String addressLine1) {
        switch (category) {
            case "Self Employed":
//                employmentIncomesPage.typeSelfEmployment_AddressLine1(addressLine1);
                break;
        }
    }

    @Given("^(borrower) user types the (Self Employed) address line 2 : (.*)$")
    public void borrower_coapplicant_user_types_category_address_line2(String borrowerOrCoapplicant, String category, String addressLine2) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_address_line2(borrowerEmploymentIncomeParameters, category, addressLine2);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_address_line2(coapplicantEmploymentIncomesPage, category, addressLine2);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_address_line2(Map<String, String> employmentIncomesParameters, String category, String addressLine2) {
        switch (category) {
            case "Self Employed":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:txtAddressLine2:tb", addressLine2);
                break;
        }
    }

    @Given("^(borrower) user types the (Self Employed) town/city : (.*)$")
    public void borrower_coapplicant_user_types_category_town_city(String borrowerOrCoapplicant, String category, String townCity) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_town_city(borrowerEmploymentIncomeParameters, category, townCity);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_town_city(coapplicantEmploymentIncomesPage, category, townCity);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_town_city(Map<String, String> employmentIncomesParameters, String category, String townCity) {
        switch (category) {
            case "Self Employed":
//                employmentIncomesPage.typeSelfEmployment_TownCity(townCity);
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:txtCity:tb", townCity);
                break;
        }
    }

    @Given("^(borrower) user types the (Self Employed) county/state : (.*)$")
    public void borrower_coapplicant_user_types_category_county_state(String borrowerOrCoapplicant, String category, String countyState) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_county_state(borrowerEmploymentIncomeParameters, category, countyState);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_county_state(coapplicantEmploymentIncomesPage, category, countyState);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_county_state(Map<String, String> employmentIncomesParameters, String category, String countyState) {
        // TODO get all counties !!!
        switch (category) {
            case "Self Employed":
//                employmentIncomesPage.selectSelfEmployment_CountyState(countyState);
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:cmbCounty:combobox", "G");
                break;
        }
    }

    @Given("^(borrower) user selects the (Self Employed) country : (.*)$")
    public void borrower_coapplicant_user_selects_category_country(String borrowerOrCoapplicant, String category, String country) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_selects_category_country(borrowerEmploymentIncomeParameters, category, country);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_selects_category_country(coapplicantEmploymentIncomesPage, category, country);
//                break;
        }
    }

    private void borrower_coapplicant_user_selects_category_country(Map<String, String> employmentIncomesParameters, String category, String country) {
        switch (category) {
            case "Self Employed":
//                employmentIncomesPage.selectSelfEmployment_Country(country);
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:cmbCountry:combobox", "IE");
                break;
        }
    }

    @Given("^(borrower) user types the (Self Employed) nature of business : (.*)$")
    public void borrower_coapplicant_user_types_category_nature_business(String borrowerOrCoapplicant, String category, String natureBusiness) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_nature_business(borrowerEmploymentIncomeParameters, category, natureBusiness);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_nature_business(coapplicantEmploymentIncomesPage, category, natureBusiness);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_nature_business(Map<String, String> employmentIncomesParameters, String category, String natureBusiness) {
        switch (category) {
            case "Self Employed":
//                employmentIncomesPage.typeSelfEmployment_BusinessNature(natureBusiness);
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:txtNatureOfBusiness:tb", natureBusiness);
                break;
        }
    }

//    private void borrower_coapplicant_user_types_category_net_profit_last_year(IEmploymentIncomesPage employmentIncomesPage, String category, String netProfitLastYear) {
//    }

//    @Given("^(borrower|coapplicant) user types the (Self Employed) net profit previous year : (.*)$")
//    public void borrower_coapplicant_user_types_category_net_profit_previous_year(String borrowerOrCoapplicant, String category, String netProfitPreviousYear) {
//    }

//    private void borrower_coapplicant_user_types_category_net_profit_previous_year(IEmploymentIncomesPage employmentIncomesPage, String category, String netProfitPreviousYear) {
//    }

//    @Given("^(borrower|coapplicant) user types the (Self Employed) accountant name / practice : (.*)$")
//    public void borrower_coapplicant_user_types_category_accountant_name_practice(String borrowerOrCoapplicant, String category, String accountantNamePractice) {
//    }

//    private void borrower_coapplicant_user_types_category_accountant_name_practice(IEmploymentIncomesPage employmentIncomesPage, String category, String accountantNamePractice) {
//    }

    @Given("^(borrower) user types the (Other) source of additional income : (.*)$")
    public void borrower_coapplicant_user_types_category_source_additional_income(String borrowerOrCoapplicant, String category, String additionalIncomeSource) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_source_additional_income(borrowerEmploymentIncomeParameters, category, additionalIncomeSource);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_source_additional_income(coapplicantEmploymentIncomesPage, category, additionalIncomeSource);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_source_additional_income(Map<String, String> employmentIncomesParameters, String category, String additionalIncomeSource) {
        switch (category) {
            case "Other":
//                employmentIncomesPage.typeOther_EarningTime(timeEarningIncome);
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlOther:c:w:txtSourceAdditionalIncome:tb", additionalIncomeSource);
                break;
        }
    }
//    @Given("^(borrower|coapplicant) user types the (Other) gross income : (.*)$")
//    public void borrower_coapplicant_user_types_category_gross_income(String borrowerOrCoapplicant, String category, String grossIncome) {
//    }
//
//    private void borrower_coapplicant_user_types_category_gross_income(IEmploymentIncomesPage employmentIncomesPage, String category, String grossIncome) {
//    }

    @Given("^(borrower) user types the (Other) time earning this income : (.*)$")
    public void borrower_coapplicant_user_types_category_time_earning_income(String borrowerOrCoapplicant, String category, String timeEarningIncome) {
        switch (borrowerOrCoapplicant) {
            case "borrower":
                borrower_coapplicant_user_types_category_time_earning_income(borrowerEmploymentIncomeParameters, category, timeEarningIncome);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_time_earning_income(coapplicantEmploymentIncomesPage, category, timeEarningIncome);
//                break;
        }
    }

    private void borrower_coapplicant_user_types_category_time_earning_income(Map<String, String> employmentIncomesParameters, String category, String timeEarningIncome) {
        switch (category) {
            case "Other":
//                employmentIncomesPage.typeOther_EarningTime(timeEarningIncome);
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlNetIcomeOther:c:w:txtOtherNetIncomeTime:tb", timeEarningIncome);
                break;
        }
    }

    @When("^(borrower) user clicks \"Add This Employment\"$")
    public void borrower_coapplicant_user_clicks_add_this_employment(String borrowerOrCoapplicant, String category) throws IOException {

        Map<String, String> finalEmploymentIncomeParameters = new LinkedHashMap<>();

        switch ( borrowerOrCoapplicant ) {
            case "borrower":
                finalEmploymentIncomeParameters.putAll(borrowerEmploymentIncomeParameters);
                break;
//            case "coapplicant":
//                finalEmploymentIncomeParameters.putAll(coapplicantEmploymentIncomeParameters);
//                break;
            default:
                log.debug("Huston we have a problem when finalizing EmploymentIncomeParameters");
        }

        Document currentFormDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textNodesCurrentFormDoc = null;
        try {
            textNodesCurrentFormDoc = currentFormDoc.select("component[id~=main]").select("component[encoding~=wicket]").first().textNodes().get(0);
        } catch ( NullPointerException npe) {
            textNodesCurrentFormDoc = currentFormDoc.select("component[id~=dialog]").select("component[encoding~=wicket]").first().textNodes().get(0);
        }
        Document currentFormDoc2 = Jsoup.parse(textNodesCurrentFormDoc.text());

        String stepToken = currentFormDoc2.select("input[name=stepToken]").attr("value");

        finalEmploymentIncomeParameters.put("root:c:w:pnlDetail:c:w:txtHiddenId:tb", "");
        finalEmploymentIncomeParameters.put("stepToken", stepToken);
        finalEmploymentIncomeParameters.put("root:c:w:pnlDetail:c:w:btnEmploymentAdd:submit", "1");

        String employmentAddReponse = requestHttpPost(
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

        /*
        TextNode textNodesCurrentFormToClose = currentFormDoc.select("component[id~=close]").select("component[encoding~=wicket]").first().textNodes().get(0);
        Document currentFormToClose = Jsoup.parse(textNodesCurrentFormToClose.text());
        String wicketInterfaceOnClick = currentFormToClose.select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkAdd.*_close]").attr("onclick");
        Pattern pWicketInterface = Pattern.compile("\\?wicket:interface=(.*):',");
        Matcher mWicketInterface = pWicketInterface.matcher(wicketInterfaceOnClick);
        String wicketInterface = null;
        while (mWicketInterface.find()) {
            wicketInterface = mWicketInterface.group(1);
        }
        final String finalWicketInterface = wicketInterface;

                String fixCategory = StringUtils.EMPTY;
        switch ( category ) {
            case "Paye":
                fixCategory = category;
                break;
            case "Self Employed":
                fixCategory = "SelfEmployed";
                break;
            case "SelfEmployed":
                fixCategory = category;
                break;
            case "Civil Servant":
                fixCategory = "CivilServant";
                break;
            case "CivilServant":
                fixCategory = category;
                break;
            case "Unemployed/Homemaker":
                fixCategory = "Unemployment";
                break;
            case "Other":
                fixCategory = "Homemaker";
                break;
            default:
                log.error("Huston, we have an issue on Fix Category Type");
        }
        final String finalFixCategory = fixCategory;

        */

        // (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other)
        String finalCategory = StringUtils.EMPTY;
        switch (category) {
            case "Paye":
                finalCategory = "Paye";
                break;
            case "Self Employed":
                finalCategory = "SelfEmployed";
                break;
            case "Civil Servant":
                finalCategory = "CivilServant";
                break;
            case "Unemployed/Homemaker":
                finalCategory = "Unemployment";
                break;
            case "Other":
                finalCategory = "Homemaker";
                break;
        }

        if ( category.equals("Paye")) {
            requestHttpPost(
                    httpClient,
                    //                System.getProperty("borrower") + "/form.2?wicket:interface=" + finalWicketInterface + ":",
                    //                System.getProperty("borrower") + "/form.2?wicket:interface=" + :1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAddEmp:close::IBehaviorListener:0:-1",
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAdd" + finalCategory + ":close::IBehaviorListener:0:-1",
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
        else {
            // TODO to extract form btnAddEmp ...
            requestHttpGet(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAddEmp:close::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
        }

        if ( category.equals("Paye")) {
            String addEmplCompleted = requestHttpPost(
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
                            put("stepToken", stepToken);
                            put("root:c:w:btnHiddenSubmit:submit", "1");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(addEmplCompleted);
        }
        else {
            /*
            String addEmplCompleted = requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:-1",
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
                    localContext,
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(addEmplCompleted);
            */
        }
    }

    @When("^(borrower) user clicks \"ADD EMPLOYMENT\"$")
    public void borrower_coapplicant_user_clicks_add_employment(String borrowerOrCoapplicant) throws IOException {

        Document precedentResponseDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textNodePrecedentResponse = null;
        try {
            textNodePrecedentResponse = precedentResponseDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
        } catch ( NullPointerException npe ) {
            textNodePrecedentResponse = precedentResponseDoc.select("component[id~=dialog]").select("component[encoding~=wicket]").first().textNodes().get(0);
        }
        Document precedentResponseDoc2 = Jsoup.parse(textNodePrecedentResponse.text());

        String stepTokenValue = precedentResponseDoc2.select("input[name=stepToken]").attr("value");

        switch(borrowerOrCoapplicant) {
            case "borrower":
                String addEmpResponse = requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAddEmp:dialog::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", stepTokenValue);
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
                );
                httpResponse.setHttpResponse(addEmpResponse);
                break;
        }

    }

    @Then("^(borrower) user clicks \"Done\"$")
    public void borrower_coapplicant_user_clicks_done(String borrowerOrCoapplicant) throws IOException {

        String yourAccountPageResponse = requestHttpPost(
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
                        put("stepToken", "1");
                        put("root:c:w:pnlEmpList:c:w:btnImDone:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(yourAccountPageResponse);
    }
}