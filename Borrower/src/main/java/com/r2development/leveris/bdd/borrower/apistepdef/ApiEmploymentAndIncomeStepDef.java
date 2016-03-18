package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.EmploymentIncomeData;
import com.r2development.leveris.di.IHttpResponse;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
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
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@Singleton
public class ApiEmploymentAndIncomeStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiEmploymentAndIncomeStepDef.class);

    @Inject
    IUser user;
    @Inject
    IHttpResponse httpResponse;

    @Inject
    public ApiEmploymentAndIncomeStepDef(IHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @Given("(Borrower) fills in Employment and Income type (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other)$")
    public void user_fills_in_employment_income(String userType, String formType, List<String> employmentIncomeDataMap) throws IOException {

        EmploymentIncomeData employmentIncomeData = new EmploymentIncomeData(employmentIncomeDataMap);

        assertEquals(
                "We should have the same employment and income category in step def calling and in the table",
                formType,
                employmentIncomeData.get("formType")
        );

        borrower_coapplicant_user_clicks_an_employment_and_income_category(userType, formType);

        switch (formType) {

            case "Paye":
//                borrower_coapplicant_user_clicks_an_employment_and_income_category(userType, formType);
                borrower_coapplicant_user_selects_category_occupation(userType, formType, employmentIncomeData.get("occupation"));
                borrower_coapplicant_user_types_category_employer_name(userType, formType, employmentIncomeData.get("employerName"));
                borrower_coapplicant_user_selects_category_employer_type(userType, formType, employmentIncomeData.get("employmentType"));
                borrower_coapplicant_user_types_category_start_date(userType, formType, employmentIncomeData.get("startDate"));
                borrower_coapplicant_user_checks_unchecks_category_currently(userType, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), formType);

                if ( !employmentIncomeData.isCurrentEmployment() )
                    borrower_coapplicant_user_types_category_end_date(userType, formType, employmentIncomeData.get("endDate"));
                borrower_coapplicant_user_types_category_net_monthly_income(userType, formType, employmentIncomeData.get("netMonthlyIncome"));
                break;

            case "Self Employed":
//                borrower_coapplicant_user_clicks_an_employment_and_income_category(userType, formType);
                borrower_coapplicant_user_selects_category_occupation(userType, formType, employmentIncomeData.get("occupation"));
                borrower_coapplicant_user_types_category_business_name(userType, formType, employmentIncomeData.get("businessName"));
                borrower_coapplicant_user_types_category_address_line1(userType, formType, employmentIncomeData.get("addressLine1"));

                if ( !StringUtils.isEmpty(employmentIncomeData.get("addressLine2")))
                    borrower_coapplicant_user_types_category_address_line2(userType, formType, employmentIncomeData.get("addressLine2"));

                borrower_coapplicant_user_types_category_town_city(userType, formType, employmentIncomeData.get("townCity"));

                if ( !StringUtils.isEmpty(employmentIncomeData.get("country")) ) {
                    borrower_coapplicant_user_selects_category_country(userType, formType, employmentIncomeData.get("country"));

                    if ( !StringUtils.isEmpty(employmentIncomeData.get("country")) && employmentIncomeData.get("country").equals("Ireland") )
                        borrower_coapplicant_user_types_category_county_state(userType, formType, employmentIncomeData.get("countyState"));
                }

                borrower_coapplicant_user_types_category_nature_business(userType, formType, employmentIncomeData.get("businessNature"));
                borrower_coapplicant_user_types_category_start_date(userType, formType, employmentIncomeData.get("startDate"));
                borrower_coapplicant_user_checks_unchecks_category_currently(userType, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), formType);

                if ( !employmentIncomeData.isCurrentEmployment() )
                    borrower_coapplicant_user_types_category_end_date(userType, formType, employmentIncomeData.get("endDate"));
                else {
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
                                    put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlSelfEmployed txtBusinessEndDate\",\"data\":{\"enable\":false}}]}"
                                    );
                                }
                            },
                            localContext,
                            CONSUME_QUIETLY
                    );
                }

                borrower_coapplicant_user_types_category_net_monthly_income(userType, formType, employmentIncomeData.get("netMonthlyIncome"));
//                borrowerEmploymentIncomeParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:pnlAddressField1:data", "{\"countryCode\":\"CZ\",\"route\":\"\",\"streetNumber\":\"\",\"postalCode\":\"110 00\",\"region\":\"Prague\",\"houseNumber\":\"\",\"inputText\":\"Staré Město, Prague, Czech Republic\",\"county\":\"Hlavní město Praha\"}");
                break;

//            case "Civil Servant":
////                borrower_coapplicant_user_clicks_an_employment_and_income_category(userType, formType);
//                borrower_coapplicant_user_selects_category_occupation(userType, formType, employmentIncomeData.get("occupation"));
//                borrower_coapplicant_user_types_category_employer_name(userType, formType, employmentIncomeData.get("employerName"));
//                borrower_coapplicant_user_selects_category_employer_type(userType, formType, employmentIncomeData.get("employmentType"));
//                borrower_coapplicant_user_types_category_start_date(userType, formType, employmentIncomeData.get("startDate"));
//                borrower_coapplicant_user_checks_unchecks_category_currently(userType, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), formType);
//
//                if ( !employmentIncomeData.isCurrentEmployment() )
//                    borrower_coapplicant_user_types_category_end_date(userType, formType, employmentIncomeData.get("endDate"));
//                borrower_coapplicant_user_types_category_net_monthly_income(userType, formType, employmentIncomeData.get("netMonthlyIncome"));
//                break;

            case "Unemployed/Homemaker":
//                borrower_coapplicant_user_clicks_an_employment_and_income_category(userType, formType);
                borrower_coapplicant_user_types_category_start_date(userType, formType, employmentIncomeData.get("startDate"));
                borrower_coapplicant_user_checks_unchecks_category_currently(userType, (employmentIncomeData.isCurrentEmployment() ? "checks" : "unchecks"), formType);

                if ( !employmentIncomeData.isCurrentEmployment())
                    borrower_coapplicant_user_types_category_end_date(userType, formType, employmentIncomeData.get("endDate"));
                else {
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
                                    put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlUnemployed txtUnemployedEndDate\",\"data\":{\"enable\":false}}]}");
                                }
                            },
                            localContext,
                            CONSUME_QUIETLY
                    );
                }
                break;

            case "Other":
//                borrower_coapplicant_user_clicks_an_employment_and_income_category(userType, formType);
                borrower_coapplicant_user_types_category_source_additional_income(userType, formType, employmentIncomeData.get("additionalIncomeSource"));
                borrower_coapplicant_user_types_category_net_monthly_income(userType, formType, employmentIncomeData.get("netMonthlyIncome"));
                borrower_coapplicant_user_types_category_time_earning_income(userType, formType, employmentIncomeData.get("timeEarningIncome"));
                borrower_coapplicant_user_types_category_start_date(userType, formType, employmentIncomeData.get("startDate"));

                if ( !employmentIncomeData.isCurrentEmployment() )
                    borrower_coapplicant_user_types_category_end_date(userType, formType, employmentIncomeData.get("endDate"));
                else {
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
                                    put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlOtherDates txtOtherEndDate\",\"data\":{\"enable\":false}}]}");
                                }
                            },
                            localContext,
                            CONSUME_QUIETLY
                    );
                }

                break;
            default:
                log.error("Huston, we have a problem on selecting Employment&Income category");
        }
        borrower_coapplicant_user_clicks_add_this_employment(userType, formType);
    }

    @Given("^(Borrower) sees his name in the Employment & Income title$")
    public void borrower_coapplicant_user_sees_his_name_in_the_title(String userType) {
    }

    @Given("^(Borrower) clicks the employment & income category : (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other)$")
    public void borrower_coapplicant_user_clicks_an_employment_and_income_category(String userType, String category) throws IOException {

        Document empListDoc = Jsoup.parse(httpResponse.getHttpResponse());

        Document empListDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for ( int i=0; i<componentId.length; i++) {
            try {
                empListDoc2 = Jsoup.parse(empListDoc.select("component[id~="+componentId[i]+"]").select("component[encoding~=wicket]").first().text());
                log.info("is " + componentId[i]);
                break;
            }
            catch (NullPointerException npe) {
                log.info("isnot " + componentId[i]);
            }
        }

        String fixCategory = StringUtils.EMPTY;
        switch ( category ) {
            case "Paye":
                fixCategory = category;
                break;
            case "Self Employed":
                fixCategory = "SelfEmployed";
                break;
            case "Civil Servant":
                fixCategory = "CivilServant";
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

        Elements divEmploymentTypeAddElements = empListDoc2.select("div[data-path~=pnlNoEmplyments").select("div[data-path~=lnkAdd" + finalFixCategory + "]");
        Map<String, String> wicketInterfaceMap = new LinkedHashMap<>();
        String linkAdd = null;
        String currentKey = "linkAdd";
        if ( divEmploymentTypeAddElements.size() != 0 ) {
            for (Element current : divEmploymentTypeAddElements) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_").select("a[wicketpath~=lnkAdd" + finalFixCategory + "_dialog]").attr("onclick");
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
        else if ( divEmploymentTypeAddElements.size() == 0 ) {
            divEmploymentTypeAddElements = empListDoc2.select("div[data-path~=pnlEmpList btnAdd]");
            for (Element current : divEmploymentTypeAddElements) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath=main_c_form_form_root_c_w_pnlEmpList_c_w_btnAddEmp_dialog]").attr("onclick");
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

        String stepToken = empListDoc2.select("input[name=stepToken").attr("value");
        Map<String, String> linkAddParameters = new LinkedHashMap<>();
        linkAddParameters.put("stepToken", stepToken);

        String employmentLinkAddResponse = requestHttpPost(
                httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAddPaye:dialog::IBehaviorListener:0:",
//                        System.getProperty("borrower") + "/form.2?wicket:interface=" + wicketInterfaceMap.get("lnkAdd" + finalFixCategory),
                System.getProperty("borrower") + "/form.2?wicket:interface=" + finalLinkAdd,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                linkAddParameters,
                localContext,
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(employmentLinkAddResponse);


        switch ( fixCategory ) {
            case "Paye":
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
                                put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\n" +
                                        " cmbIrelandCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed\n" +
                                        " pnlCounty pnlIrelandCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail\n" +
                                        " pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"visible\":true},\"delta\n" +
                                        "\":40,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty\n" +
                                        " pnlIrelandCounty\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\n" +
                                        "\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed txtEmployerName\",\"data\"\n" +
                                        ":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed\n" +
                                        " cmbEmplType\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\n" +
                                        "\"widget\":\"pnlDetail pnlEmployed txtEmplStartDate\",\"data\":{\"visible\":true\n" +
                                        "},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\n" +
                                        " chkEmplCurrently\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}\n" +
                                        ",{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossSalary\",\"data\n" +
                                        "\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail\n" +
                                        " pnlEmployed pnlEmplPayeServant crbEmplGrossBonus\",\"data\":{\"visible\":true}\n" +
                                        ",\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\n" +
                                        " crbEmplGrossOvertime\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"\n" +
                                        "},{\"widget\":\"pnlDetail pnlEmployed\",\"data\":{\"visible\":true},\"delta\n" +
                                        "\":520,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlNetIncomeEmpl\n" +
                                        "\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}\n" +
                                        ",{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\",\"data\":{\"visible\n" +
                                        "\":false},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail\n" +
                                        " pnlEmployed pnlEmplPayeServant\",\"data\":{\"enable\":false}},{\"widget\"\n" +
                                        ":\"pnlDetail pnlSelfEmployed\",\"data\":{\"enable\":false}},{\"widget\":\n" +
                                        "\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\n" +
                                        "\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"enable\n" +
                                        "\":false}},{\"widget\":\"pnlDetail pnlOther\",\"data\":{\"enable\":false\n" +
                                        "}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{\"enable\":false}\n" +
                                        "},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"visible\":false}\n" +
                                        ",\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeOther\n" +
                                        "\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlUnemployed\"\n" +
                                        ",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed txtBusinessEndDate\n" +
                                        "\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlUnemployed txtUnemployedEndDate\n" +
                                        "\",\"data\":{\"enable\":true}}]}");
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY
                );
                break;
            case "SelfEmployed":
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
                                put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty cmbIrelandCounty\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"visible\":true},\"delta\":40,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed\",\"data\":{\"visible\":true},\"delta\":683,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlEnglishCounty cmbEnglandCounty\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlEnglishCounty\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlEnglishCounty cmbEnglandCounty\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlEnglishCounty\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit txtAccountantNamePractice\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitLastyear\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitPreviousYear\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherDates\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlUnemployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlEmployed txtEmplEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlUnemployed txtUnemployedEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlOtherDates txtOtherEndDate\",\"data\":{\"enable\":true}}]}");
//                                put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{\"enable\":false},\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitPreviousYear\",\"data\":{\"enable\":false},\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitLastyear\",\"data\":{\"enable\":false},\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit txtAccountantNamePractice\",\"data\":{\"enable\":false},\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty cmbIrelandCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"visible\":true},\"delta\":40,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed\",\"data\":{\"visible\":true},\"delta\":683,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlEnglishCounty cmbEnglandCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlEnglishCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlEnglishCounty cmbEnglandCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlEnglishCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit txtAccountantNamePractice\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitLastyear\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitPreviousYear\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherDates\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlUnemployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlEmployed txtEmplEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlUnemployed txtUnemployedEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlOtherDates txtOtherEndDate\",\"data\":{\"enable\":true}}]}"
//                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY

                );
                break;
            case "CivilServant":
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
                                put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlEmployed txtEmployerName\",\"data\"\n" +
                                        ":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed\n" +
                                        " cmbEmplType\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\n" +
                                        "\"widget\":\"pnlDetail pnlEmployed txtEmplStartDate\",\"data\":{\"visible\":true\n" +
                                        "},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\n" +
                                        " chkEmplCurrently\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}\n" +
                                        ",{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossSalary\",\"data\n" +
                                        "\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail\n" +
                                        " pnlEmployed pnlEmplPayeServant crbEmplGrossBonus\",\"data\":{\"visible\":true}\n" +
                                        ",\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\n" +
                                        " crbEmplGrossOvertime\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"\n" +
                                        "},{\"widget\":\"pnlDetail pnlEmployed\",\"data\":{\"visible\":true},\"delta\n" +
                                        "\":600,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\n" +
                                        "\",\"data\":{},\"delta\":-150,\"visibleEvent\":\"hide\"},{\"widget\"\n" +
                                        ":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossSalary\",\"data\":{}},\n" +
                                        "{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossOvertime\",\"data\n" +
                                        "\":{}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbEmplGrossBonus\n" +
                                        "\",\"data\":{}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant crbCommision\n" +
                                        "\",\"data\":{}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplPayeServant\",\n" +
                                        "\"data\":{}},{\"widget\":\"pnlDetail pnlSelfEmployed\",\"data\":{\"enable\n" +
                                        "\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{\n" +
                                        "},\"delta\":-160,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlSelfEmployed\n" +
                                        " pnlProfit txtAccountantNamePractice\",\"data\":{}},{\"widget\":\"pnlDetail\n" +
                                        " pnlSelfEmployed pnlProfit crbNetProfitLastyear\",\"data\":{}},{\"widget\":\n" +
                                        "\"pnlDetail pnlSelfEmployed pnlProfit crbNetProfitPreviousYear\",\"data\":{}},\n" +
                                        "{\"widget\":\"pnlDetail pnlSelfEmployed pnlProfit\",\"data\":{}},{\"widget\n" +
                                        "\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"visible\":false},\"delta\":-70\n" +
                                        ",\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\n" +
                                        "\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOther\",\"data\":{\n" +
                                        "\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{}\n" +
                                        ",\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlOtherIncome\n" +
                                        " crbGrossIncome\",\"data\":{}},{\"widget\":\"pnlDetail pnlOtherIncome txtOtherIncomeTime\n" +
                                        "\",\"data\":{}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{\n" +
                                        "}},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"visible\":false\n" +
                                        "},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeOther\n" +
                                        "\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlUnemployed\"\n" +
                                        ",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed txtBusinessEndDate\n" +
                                        "\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlUnemployed txtUnemployedEndDate\n" +
                                        "\",\"data\":{\"enable\":true}}]}"
                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY

                );

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
                                put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\"\n" +
                                        ":{\"visible\":false},\"delta\":-50,\"visibleEvent\":\"hide\"},{\"widget\n" +
                                        "\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":false}}]\n" +
                                        "}"
                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY
                );
                */
                break;
            case "Unemployment":
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
                                put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty cmbIrelandCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"visible\":true},\"delta\":40,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeOther\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherDates\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlUnemployed\",\"data\":{\"visible\":true},\"delta\":130,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed txtEmplEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed txtBusinessEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlOtherDates txtOtherEndDate\",\"data\":{\"enable\":true}}]}"
                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY

                );
                break;
            case "Homemaker":
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
                                put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty cmbIrelandCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"visible\":true},\"delta\":40,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlSelfEmployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlDetail pnlNetIcomeSelf\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOther\",\"data\":{\"visible\":true},\"delta\":90,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlOtherIncome\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlOtherDates\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlUnemployed\",\"data\":{\"enable\":false}},{\"widget\":\"pnlDetail pnlEmployed txtEmplEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"visible\":true},\"delta\":0,\"visibleEvent\":\"show\"},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlEmployed pnlEmplCurrently\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlSelfEmployed txtBusinessEndDate\",\"data\":{\"enable\":true}},{\"widget\":\"pnlDetail pnlUnemployed txtUnemployedEndDate\",\"data\":{\"enable\":true}}]}"
                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY

                );

                // TODO to handle if current work or not
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
                                put("data", "{\"widgets\":[{\"widget\":\"pnlDetail pnlUnemployed txtUnemployedEndDate\",\"data\n" +
                                        "\":{\"enable\":false}}]}"
                                );
                            }
                        },
                        localContext,
                        CONSUME_QUIETLY

                );
                break;
            default:
                log.info("Huston, we have problem ! Do we have a new category type ?");
        }
    }

    @Given("^(Borrower) selects the (Paye|Self Employed|Civil Servant) occupation : (.*)$")
    public void borrower_coapplicant_user_selects_category_occupation(String userType, String category, String occupation) {
        switch (userType) {
            case "Borrower":
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

    @Given("^(Borrower) types the (Paye|Civil Servant) employer's name : (.*)$")
    public void borrower_coapplicant_user_types_category_employer_name(String userType, String category, String employerName) {
        switch (userType) {
            case "Borrower":
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

    @Given("^(Borrower) selects the (Paye|Civil Servant) employment type : (Contract|Permanent|Temporary)$")
    public void borrower_coapplicant_user_selects_category_employer_type(String userType, String category, String employmentType) throws IOException {
        switch (userType) {
            case "Borrower":
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

    @Given("^(Borrower) types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) start date : (.*)$")
    public void borrower_coapplicant_user_types_category_start_date(String userType, String category, String startDate) {
        switch (userType) {
            case "Borrower":
                borrower_coapplicant_user_types_category_start_date(borrowerEmploymentIncomeParameters, category, startDate);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_start_date(coapplicantEmploymentIncomeParameters, category, startDate);
//                break;
            default:
                assertThat("We handle only borrower or coapplicant", userType, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
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
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlUnemployed:c:w:txtUnemployedStartDate:tb", startDate);
                break;
            case "Other":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlOtherDates:c:w:txtOtherStartDate:tb", startDate);
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Self Employed")), not(equalTo("Civil Servant")), not(equalTo("Unemployed/Homemaker")) ));
        }
    }

    @Given("^(Borrower) types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other) end date : (.*)$")
    public void borrower_coapplicant_user_types_category_end_date(String userType, String category, String endDate) {
        switch (userType) {
            case "Borrower":
                borrower_coapplicant_user_types_category_end_date(borrowerEmploymentIncomeParameters, category, endDate);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_end_date(coapplicantEmploymentIncomeParameters, category, endDate);
//                break;
            default:
                assertThat("We handle only borrower or coapplicant", userType, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
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
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlUnemployed:c:w:txtUnemployedEndDate:tb", endDate);
                break;
            case "Other":
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlOtherDates:c:w:txtOtherEndDate:tb", endDate);
            default:
                assertThat("We handle only borrower or coapplicant", category, anyOf( not(equalTo("Paye")), not(equalTo("Self Employed")), not(equalTo("Civil Servant")), not(equalTo("Unemployed/Homemaker")) ));
        }
    }

    @Given("^(Borrower) (checks|unchecks) the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker) currently$")
    public void borrower_coapplicant_user_checks_unchecks_category_currently(String userType, String action, String category) {
        switch (userType) {
            case "Borrower":
                borrower_coapplicant_user_checks_unchecks_category_currently(borrowerEmploymentIncomeParameters, action, category);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_checks_unchecks_category_currently(coapplicantEmploymentIncomeParameters, action, category);
//                break;
            default:
                assertThat("We handle only borrower or coapplicant", userType, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
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
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:chkBusinessCurrently:checkbox", "on");
                else if (action.equals("unchecks"))
                    employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:chkBusinessCurrently:checkbox", "off");
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

    @Given("^(Borrower) types the (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other) net monthly income : (.*)$")
    public void borrower_coapplicant_user_types_category_net_monthly_income(String userType, String category, String netMonthlyIncome) {
        switch (userType) {
            case "Borrower":
                borrower_coapplicant_user_types_net_monthly_income(borrowerEmploymentIncomeParameters, category, netMonthlyIncome);
                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_net_monthly_income(borrowerEmploymentIncomeParameters, category, netMonthlyIncome);
//                break;
            default:
                assertThat("We handle only borrower", userType, anyOf( not(equalTo("borrower")) ));
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
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlNetIcomeOther:c:w:crbNetIcomeOther:tb", netMonthlyIncome);
                break;
            default:
                assertThat("We handle only borrower", category, anyOf( not(equalTo("Paye")), not(equalTo("Civil Servant")) ));
        }
    }

//    @Given("^(Borrower) types the (Paye|Civil Servant) net monthly salary : (.*)$")
//    public void borrower_coapplicant_user_types_net_monthly_salary(String userType, String category, String grossSalary) {
//        switch (userType) {
//            case "Borrower":
//                borrower_coapplicant_user_types_net_monthly_salary(borrowerEmploymentIncomeParameters, category, grossSalary);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_net_monthly_salary(coapplicantEmploymentIncomeParameters, category, grossSalary);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", userType, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
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
//    @Given("^(Borrower) types the (Paye|Civil Servant) gross salary : (.*)$")
//    public void borrower_coapplicant_user_types_category_salary(String userType, String category, String grossSalary) {
//        switch (userType) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_salary(borrowerEmploymentIncomeParameters, category, grossSalary);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_salary(coapplicantEmploymentIncomeParameters, category, grossSalary);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", userType, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
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

//    @Given("^(Borrower) types the (Paye|Civil Servant) regular overtime : (.*)$")
//    public void borrower_coapplicant_user_types_category_regular_overtime(String userType, String category, String regularOvertime) {
//        switch (userType) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_regular_overtime(borrowerEmploymentIncomeParameters, category, regularOvertime);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_regular_overtime(coapplicantEmploymentIncomeParameters, category, regularOvertime);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", userType, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
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

//    @Given("^(Borrower) types the (Paye|Civil Servant) regular guaranteed bonus : (.*)$")
//    public void borrower_coapplicant_user_types_category_regular_guaranteed_bonus(String userType, String category, String regularGuaranteedBonus) {
//        switch (userType) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_regular_guaranteed_bonus(borrowerEmploymentIncomeParameters, category, regularGuaranteedBonus);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_regular_guaranteed_bonus(coapplicantEmploymentIncomeParameters, category, regularGuaranteedBonus);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", userType, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
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

//    @Given("^(Borrower) types the (Paye|Civil Servant) guaranteed commission : (.*)$")
//    public void borrower_coapplicant_user_types_category_guaranteed_commission(String userType, String category, String guaranteedCommission) {
//        switch (userType) {
//            case "Borrower":
//                borrower_coapplicant_user_types_category_guaranteed_commission(borrowerEmploymentIncomeParameters, category, guaranteedCommission);
//                break;
//            case "coapplicant":
//                borrower_coapplicant_user_types_category_guaranteed_commission(coapplicantEmploymentIncomeParameters, category, guaranteedCommission);
//                break;
//            default:
//                assertThat("We handle only borrower or coapplicant", userType, anyOf( not(equalTo("borrower")), not(equalTo("coapplicant")) ));
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

    @Given("^(Borrower) types the (Self Employed) business name : (.*)$")
    public void borrower_coapplicant_user_types_category_business_name(String userType, String category, String businessName) {
        switch (userType) {
            case "Borrower":
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

    @Given("^(Borrower) types the (Self Employed) address line 1 : (.*)$")
    public void borrower_coapplicant_user_types_category_address_line1(String userType, String category, String addressLine1) {
        switch (userType) {
            case "Borrower":
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
//                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:pnlAddressField1:data:", "{\"countryCode\":\"IE\",\"route\":\"Woodquay\",\"streetNumber\":\"18-19\",\"postalCode\":\"\",\"region\":\"Galway\",\"houseNumber\":\"\",\"inputText\":\"18-19 Woodquay\",\"county\":\"Galway\"}");
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:pnlAddressField1:data:", "{\"countryCode\":\"IE\",\"route\":\"Woodquay\",\"streetNumber\":\"18\",\"postalCode\":\"\",\"region\":\"Galway\",\"houseNumber\":\"\",\"inputText\":\"18-19 Woodquay\",\"county\":\"Galway\"}");
                employmentIncomesParameters.put("root:c:w:pnlAddressField:data", "{\"inputText\":\"18-19 Woodquay\"}");
                break;
        }
    }

    @Given("^(Borrower) types the (Self Employed) address line 2 : (.*)$")
    public void borrower_coapplicant_user_types_category_address_line2(String userType, String category, String addressLine2) {
        switch (userType) {
            case "Borrower":
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

    @Given("^(Borrower) types the (Self Employed) town/city : (.*)$")
    public void borrower_coapplicant_user_types_category_town_city(String userType, String category, String townCity) {
        switch (userType) {
            case "Borrower":
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

    @Given("^(Borrower) types the (Self Employed) county/state : (.*)$")
    public void borrower_coapplicant_user_types_category_county_state(String userType, String category, String countyState) {
        switch (userType) {
            case "Borrower":
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
                employmentIncomesParameters.put("root:c:w:pnlDetail:c:w:pnlSelfEmployed:c:w:pnlCounty:c:w:pnlIrelandCounty:c:w:cmbIrelandCounty:combobox", "G");
                employmentIncomesParameters.put("root:c:w:pnlCounty:c:w:pnlIrelandCounty:c:w:cmbCountyState:v", "G");
                break;
        }
    }

    @Given("^(Borrower) selects the (Self Employed) country : (.*)$")
    public void borrower_coapplicant_user_selects_category_country(String userType, String category, String country) {
        switch (userType) {
            case "Borrower":
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

    @Given("^(Borrower) types the (Self Employed) nature of business : (.*)$")
    public void borrower_coapplicant_user_types_category_nature_business(String userType, String category, String natureBusiness) {
        switch (userType) {
            case "Borrower":
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

//    @Given("^(Borrower) types the (Self Employed) net profit previous year : (.*)$")
//    public void borrower_coapplicant_user_types_category_net_profit_previous_year(String userType, String category, String netProfitPreviousYear) {
//    }

//    private void borrower_coapplicant_user_types_category_net_profit_previous_year(IEmploymentIncomesPage employmentIncomesPage, String category, String netProfitPreviousYear) {
//    }

//    @Given("^(Borrower) types the (Self Employed) accountant name / practice : (.*)$")
//    public void borrower_coapplicant_user_types_category_accountant_name_practice(String userType, String category, String accountantNamePractice) {
//    }

//    private void borrower_coapplicant_user_types_category_accountant_name_practice(IEmploymentIncomesPage employmentIncomesPage, String category, String accountantNamePractice) {
//    }

    @Given("^(Borrower) types the (Other) source of additional income : (.*)$")
    public void borrower_coapplicant_user_types_category_source_additional_income(String userType, String category, String additionalIncomeSource) {
        switch (userType) {
            case "Borrower":
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
//    @Given("^(Borrower) types the (Other) gross income : (.*)$")
//    public void borrower_coapplicant_user_types_category_gross_income(String userType, String category, String grossIncome) {
//    }
//
//    private void borrower_coapplicant_user_types_category_gross_income(IEmploymentIncomesPage employmentIncomesPage, String category, String grossIncome) {
//    }

    @Given("^(Borrower) types the (Other) time earning this income : (.*)$")
    public void borrower_coapplicant_user_types_category_time_earning_income(String userType, String category, String timeEarningIncome) {
        switch (userType) {
            case "Borrower":
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

    @When("^(Borrower) clicks \"Add This Employment\"$")
    public void borrower_coapplicant_user_clicks_add_this_employment(String userType, String category) throws IOException {

        Map<String, String> finalEmploymentIncomeParameters = new LinkedHashMap<>();

        switch ( userType ) {
            case "Borrower":
                finalEmploymentIncomeParameters.putAll(borrowerEmploymentIncomeParameters);
                break;
            default:
                log.debug("Huston we have a problem when finalizing EmploymentIncomeParameters");
        }

        Document currentFormDoc = Jsoup.parse(httpResponse.getHttpResponse());
        Document currentFormDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for ( int i=0; i<componentId.length; i++) {
            try {
                currentFormDoc2 = Jsoup.parse(currentFormDoc.select("component[id~="+componentId[i]+"]").select("component[encoding~=wicket]").first().text());
                log.info("is " + componentId[i]);
                break;
            }
            catch (NullPointerException npe) {
                log.info("isnot " + componentId[i]);
            }
        }

        String currentWorkflow = StringUtils.EMPTY;
        if ( httpResponse.getHttpResponse().contains("btnEmploymentAdd") )
            currentWorkflow = "btnEmployment";
        else
            currentWorkflow = "";

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

        // (Paye|Self Employed|Civil Servant|Unemployed/Homemaker|Other)
        String finalCategory = StringUtils.EMPTY;
        String linkClose = StringUtils.EMPTY;
        switch (category) {
            case "Paye":
                finalCategory = "Paye";
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:pnlPaye:c:w:lnkAddPaye:close::IBehaviorListener:0:";
                break;
            case "Self Employed":
                finalCategory = "SelfEmployed";
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:pnlSelfEmployed:c:w:lnkAddSelfEmployed:close::IBehaviorListener:0:";
                break;
//            case "Civil Servant":
//                finalCategory = "CivilServant";
//                break;
            case "Unemployed/Homemaker":
                finalCategory = "Unemployment";
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:pnlUnemployed:c:w:lnkAddUnemployment:close::IBehaviorListener:0:";
                break;
            case "Other":
                finalCategory = "Homemaker";
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:pnlOther:c:w:lnkAddHomemaker:close::IBehaviorListener:0:";
                break;
        }

        if ( currentWorkflow.equals("btnEmployment")) {
            String lnkAddResponse = requestHttpPost(
                    httpClient,
                    //                System.getProperty("borrower") + "/form.2?wicket:interface=" + finalWicketInterface + ":",
                    //                System.getProperty("borrower") + "/form.2?wicket:interface=" + :1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAddEmp:close::IBehaviorListener:0:-1",
//                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAdd" + finalCategory + ":close::IBehaviorListener:0:-1",
                    System.getProperty("borrower") + "/form.2?wicket:interface=" + linkClose,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                    },
                    localContext,
                    CONSUME_QUIETLY
            );

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
//            httpResponse.setHttpResponse(addEmplCompleted);
        }
        else {
            /*
            String closeReponse = requestHttpGet(
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

    @When("^(Borrower) clicks \"ADD EMPLOYMENT\"$")
    public void borrower_coapplicant_user_clicks_add_employment(String userType) throws IOException {

        Document precedentResponseDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textNodePrecedentResponse = null;
        try {
            textNodePrecedentResponse = precedentResponseDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
        } catch ( NullPointerException npe ) {
            textNodePrecedentResponse = precedentResponseDoc.select("component[id~=dialog]").select("component[encoding~=wicket]").first().textNodes().get(0);
        }
        Document precedentResponseDoc2 = Jsoup.parse(textNodePrecedentResponse.text());

        String stepTokenValue = precedentResponseDoc2.select("input[name=stepToken]").attr("value");

        switch(userType) {
            case "Borrower":
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

    @Then("^(Borrower) clicks \"Done\"$")
    public void borrower_coapplicant_user_clicks_done(String userType) throws IOException {

        Document currentFormDoc = Jsoup.parse(httpResponse.getHttpResponse());
        Document currentFormDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for ( int i=0; i<componentId.length; i++) {
            try {
                currentFormDoc2 = Jsoup.parse(currentFormDoc.select("component[id~="+componentId[i]+"]").select("component[encoding~=wicket]").first().text());
                log.info("is " + componentId[i]);
                break;
            }
            catch (NullPointerException npe) {
                log.info("isnot " + componentId[i]);
            }
        }

        String stepToken = currentFormDoc2.select("input[name=stepToken]").attr("value");

//        finalEmploymentIncomeParameters.put("root:c:w:pnlDetail:c:w:txtHiddenId:tb", "");
//        finalEmploymentIncomeParameters.put("stepToken", stepToken);
//        finalEmploymentIncomeParameters.put("root:c:w:pnlDetail:c:w:btnEmploymentAdd:submit", "1");


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
                        put("stepToken", stepToken);
                        put("root:c:w:pnlEmpList:c:w:btnImDone:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(yourAccountPageResponse);

        Assert.assertEquals("in purpose", 1);
    }
}