package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.r2development.leveris.bdd.borrower.model.FinancialData;
import com.r2development.leveris.di.IAHttpContext;
import com.r2development.leveris.di.IHttpResponse;
import com.r2development.leveris.di.IUser;
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
public class ApiYourFinancialCommitmentsStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourFinancialCommitmentsStepDef.class.getName());

    @Inject
    IAHttpContext localContext;
    @Inject
    IHttpResponse httpResponse;
    @Inject
    IUser user;

    boolean isThereFinancialList = false;

    @Inject
    public ApiYourFinancialCommitmentsStepDef(IHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @Given("^(Borrower) fills in (Personal Loan|Credit Card|Maintenance Payment|Other|Car Loan|Student Loan|Rent|Utilities|Childcare|Mortgage)$")
    public void user_fills_in_financial(String userType, String formType, List<String> financialListData) throws IOException {
        FinancialData financialData = new FinancialData(financialListData);

        Assert.assertEquals("Form Type from table under step definition do not match the financial commitment in the step definition", formType, financialData.getFormType());

        user_clicks_financial_loan_type(userType, financialData.getFormType());

        switch (financialData.getFormType()) {
            case "Personal Loan":
                user_types_personal_oustanding_balance_amount(userType, financialData.getOutstandingAmount());
//                yourFinancialCommitmentsPage.typePersonalOutstandingBalanceAmount(financialData.getOutstandingAmount());
                user_types_personal_financial_institution(userType, financialData.getFinancialInstitution());
//                yourFinancialCommitmentsPage.typePersonalFinancialInstitution(financialData.getFinancialInstitution());
                user_types_personal_loan_purpose(userType, financialData.getPurposeOfTheLoan());
//                yourFinancialCommitmentsPage.typePersonalLoanPurpose(financialData.getPurposeOfTheLoan());
                user_types_personal_final_repayment_date(userType, financialData.getFinalRepaymentDate());
//                yourFinancialCommitmentsPage.typePersonalFinalRepaymentDate(financialData.getFinalRepaymentDate());
                user_selects_personal_payment_frequency(userType, financialData.getPaymentFrequency());
//                yourFinancialCommitmentsPage.selectPersonalPaymentFrequency(financialData.getPaymentFrequency());
                user_types_personal_repayment_amount(userType, financialData.getRepaymentAmount());
//                yourFinancialCommitmentsPage.typePersonalRepaymentAmount(financialData.getRepaymentAmount());
                break;
            case "Credit Card":
                user_types_credit_card_repayment_amount(userType, financialData.getRepaymentAmount());
//                yourFinancialCommitmentsPage.typeCreditcRepaymentAmount(financialData.getRepaymentAmount());
                user_types_credit_card_provider(userType, financialData.getCardProvider());
//                yourFinancialCommitmentsPage.typeCreditcProvider(financialData.getCardProvider());
                user_selects_credit_card_type(userType, financialData.getCardType());
//                yourFinancialCommitmentsPage.selectCreditcType(financialData.getCardType());
                user_types_credit_care_limit(userType, financialData.getCardLimit());
//                yourFinancialCommitmentsPage.typeCreditcLimit(financialData.getCardLimit());
                user_types_credit_card_balance(userType, financialData.getCardBalance());
//                yourFinancialCommitmentsPage.typeCreditcBalance(financialData.getCardBalance());
                break;
            case "Maintenance Payment":
                user_types_maintenance_payment(userType, financialData.getMonthlyMaintenancePayment());
//                yourFinancialCommitmentsPage.typeMaintenancepPayment(financialData.getMonthlyMaintenancePayment());
                break;
            case "Other":
                user_types_other_repayment_amount(userType, financialData.getRepaymentAmount());
//                yourFinancialCommitmentsPage.typeOtherRepaymentAmount(financialData.getRepaymentAmount());
                user_types_other_value(userType, financialData.getRepaymentAmount());
//                yourFinancialCommitmentsPage.typeOtherValue(financialData.getValue());
                user_types_other_description(userType, financialData.getDescription());
//                yourFinancialCommitmentsPage.typeOtherDescription(financialData.getDescription());
                break;
            case "Car Loan":
                user_types_car_outstanding_balance_amount(userType, financialData.getOutstandingAmount());
//                yourFinancialCommitmentsPage.typeCarOutstandingBalanceAmount(financialData.getOutstandingAmount());
                user_types_car_financial_institution(userType, financialData.getFinancialInstitution());
//                yourFinancialCommitmentsPage.typeCarFinancialInstitution(financialData.getFinancialInstitution());
                user_types_car_final_repayment_date(userType, financialData.getFinalRepaymentDate());
//                yourFinancialCommitmentsPage.typeCarFinalRepaymentDate(financialData.getFinalRepaymentDate());
                user_selects_car_payment_frequency(userType, financialData.getPaymentFrequency());
//                yourFinancialCommitmentsPage.selectCarPaymentFrequency(financialData.getPaymentFrequency());
                user_types_card_repayment_amount(userType, financialData.getRepaymentAmount());
//                yourFinancialCommitmentsPage.typeCarRepaymentAmount(financialData.getRepaymentAmount());
                break;
            case "Student Loan":
                user_types_student_outstanding_balance_amount(userType, financialData.getOutstandingAmount());
//                yourFinancialCommitmentsPage.typeStudentOutstandingBalanceAmount(financialData.getOutstandingAmount());
                user_types_student_financial_institution(userType, financialData.getFinancialInstitution());
//                yourFinancialCommitmentsPage.typeStudentFinancialInstitution(financialData.getFinancialInstitution());
                user_types_student_final_repayment_date(userType, financialData.getFinalRepaymentDate());
//                yourFinancialCommitmentsPage.typeStudentFinalRepaymentDate(financialData.getFinalRepaymentDate());
                user_selects_student_payment_frequency(userType, financialData.getPaymentFrequency());
//                yourFinancialCommitmentsPage.selectStudentPaymentFrequency(financialData.getPaymentFrequency());
                user_types_student_repayment_amount(userType, financialData.getRepaymentAmount());
//                yourFinancialCommitmentsPage.typeStudentRepaymentAmount(financialData.getRepaymentAmount());
                break;
            case "Rent":
                //optional
                user_selects_rent_payment_frequency(userType, financialData.getPaymentFrequency());
//                yourFinancialCommitmentsPage.selectRentPaymentFrequency(financialData.getPaymentFrequency());
                user_types_rent_repayment_amount(userType, financialData.getRepaymentAmount());
//                yourFinancialCommitmentsPage.typeRentRepaymentAmount(financialData.getRepaymentAmount());
                //optional
                user_types_rent_note(userType, financialData.getNote());
//                yourFinancialCommitmentsPage.typeRentNote(financialData.getNote());
                break;
            case "Utilities":
                //optional
                user_types_utilities_payment_frequency(userType, financialData.getPaymentFrequency());
//                yourFinancialCommitmentsPage.selectUtilitiesPaymentFrequency(financialData.getPaymentFrequency());
                user_types_utilities_repayment_amount(userType, financialData.getRepaymentAmount());
//                yourFinancialCommitmentsPage.typeUtilitiesRepaymentAmount(financialData.getRepaymentAmount());
                //optional
                user_types_utilities_note(userType, financialData.getNote());
//                yourFinancialCommitmentsPage.typeUtilitiesNote(financialData.getNote());
                break;
            case "Childcare":
                //optional
                user_types_child_care_payment_frequency(userType, financialData.getPaymentFrequency());
//                yourFinancialCommitmentsPage.selectChildCarePaymentFrequency(financialData.getPaymentFrequency());
                user_types_child_care_repayment_amount(userType, financialData.getRepaymentAmount());
//                yourFinancialCommitmentsPage.typeChildCareRepaymentAmount(financialData.getRepaymentAmount());
                //optional
                user_types_child_care_note(userType, financialData.getNote());
//                yourFinancialCommitmentsPage.typeChildCareNote(financialData.getNote());
                break;
            case "Mortgage":
                user_types_mortgage_outstanding_balance_amount(userType, financialData.getOutstandingAmount());
//                yourFinancialCommitmentsPage.typeMortgageOutstandingBalanceAmount(financialData.getOutstandingAmount());
                user_types_mortgage_financial_institution(userType, financialData.getFinancialInstitution());
//                yourFinancialCommitmentsPage.typeMortgageFinancialInstitution(financialData.getFinancialInstitution());
                //optional
                user_types_mortgage_final_repayment_date(userType, financialData.getFinalRepaymentDate());
//                yourFinancialCommitmentsPage.typeMortgageFinalRepaymentDate(financialData.getFinalRepaymentDate());
                user_types_mortgage_repayment_amount(userType, financialData.getRepaymentAmount());
//                yourFinancialCommitmentsPage.typeMortgageRepaymentAmount(financialData.getRepaymentAmount());
                break;
            default:
        }
        user_clicks_financial_save_and_close(userType, formType);
    }

    @When("^Borrower has(n't)? financial commitments$")
    public void user_has_financial_commitments(String hasCommitments) throws IOException {
        if (hasCommitments == null) {
            // TODO handle the case or refactor
        }
        else {
            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoLiability:c:w:lnkHaveNoCommitments:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "1");
                            put("root:c:w:pnlNoLiability:c:w:lnkHaveNoCommitments:submit", "1");
                        }
                    },
                    localContext.getHttpContext(),
                    CONSUME_QUIETLY
            );

            String noCommitmentsResponse = requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoCommitments:c:w:btnNextSection:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "1");
                            put("root:c:w:pnlNoCommitments:c:w:btnNextSection:submit", "1");
                        }
                    },
                    localContext.getHttpContext(),
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(noCommitmentsResponse);
        }
    }

    @Given("^(Borrower) selects (Personal Loan|Credit Card|Maintenance Payment|Other|Car Loan|Student Loan|Rent|Utilities|Childcare|Mortgage) as his financial commitment$")
    public void user_clicks_financial_loan_type(String usertType, String financialTypeLoan) throws IOException {
        Document empListDoc = Jsoup.parse(httpResponse.getHttpResponse());

        Document empListDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for (String aComponentId : componentId) {
            try {
                empListDoc2 = Jsoup.parse(empListDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);

                if ( !aComponentId.equals("main") )
                    isThereFinancialList = true;
                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

        String fixCategory = StringUtils.EMPTY;
        switch ( financialTypeLoan ) {
            case "Personal Loan":
                fixCategory = "lnkAddPersonalLoan";
                break;
            case "Credit Card":
                fixCategory = "lnkAddCreditCard";
                break;
            case "Maintenance Payment":
                fixCategory = "lnkAddMaintenancePayment";
                break;
            case "Other":
                fixCategory = "lnkAddOther";
                break;
            case "Car Loan":
                fixCategory = "lnkAddCarLoan";
                break;
            case "Student Loan":
                fixCategory = "lnkAddStudentLoan";
                break;
            case "Rent":
                fixCategory = "pnlAddExpanses lnkRent";
                break;
            case "Utilities":
                fixCategory = "pnlAddExpanses lnkUtilities";
                break;
            case "Childcare":
                fixCategory = "pnlAddExpanses lnkChildcare";
                break;
            case "Mortgage":
                fixCategory = "pnlAddExpanses lnkMortage";
                break;
            default:
                log.error("Huston, we have an issue on Fix financial Type");
        }
        final String finalFixCategory = fixCategory;

        Elements divEmploymentTypeAddElements = empListDoc2.select("div[data-path~=pnlNoLiability").select("div[data-path~=" + finalFixCategory + "]");

        switch (financialTypeLoan) {
            case "Rent":
                fixCategory = "pnlAddExpanses_c_w_lnkRent";
                break;
            case "Utilities":
                fixCategory = "pnlAddExpanses_c_w_lnkUtilities";
                break;
            case "Childcare":
                fixCategory = "pnlAddExpanses_c_w_lnkChildcare";
                break;
            case "Mortgage":
                fixCategory = "pnlAddExpanses_c_w_lnkMortage";
                break;
        }
        final String finalFixCategory2 = fixCategory;

        Elements divEmploymentTypeAddElements2;
//        Map<String, String> wicketInterfaceMap = new LinkedHashMap<>();
        String linkAdd = null;
//        String currentKey = "linkAdd";
        if ( divEmploymentTypeAddElements.size() != 0 ) {
            for (Element current : divEmploymentTypeAddElements) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoLiability_c_w_").select("a[wicketpath~=" + finalFixCategory2 + "_dialog]").attr("onclick");
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
            isThereFinancialList = true;
            divEmploymentTypeAddElements2 = empListDoc2.select("div[data-path~=pnlLiabList btnAdd]");
            for (Element current : divEmploymentTypeAddElements2) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath=main_c_form_form_root_c_w_pnlLiabList_c_w_btnAddLiab_dialog]").attr("onclick");
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


        switch ( financialTypeLoan ) {
            case "Personal Loan":

                if ( isThereFinancialList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoLiability:c:w:lnkAddPersonalLoan:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoLiability:c:w:pnlPaye:c:w:lnkAddPaye:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);

                }

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
                break;
            case "Credit Card":

                if ( isThereFinancialList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoLiability:c:w:lnkAddCreditCard:submit::IBehaviorListener:0:",
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
                break;
            case "Maintenance Payment":

                if ( isThereFinancialList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoLiability:c:w:lnkAddMaintenancePayment:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoLiability:c:w:lnkAddMaintenancePayment:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);
                }

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
                                        "{\"widget\":\"pnlAddNew pnlCreditCard\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":false},\"delta\":-80,\"visibleEvent\":\"hide\"}," +
                                        "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlRepaymentAmount\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlMaintenance\",\"data\":{\"visible\":true},\"delta\":70,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlNote txaNote\",\"data\":{\"enable\":false}}" +
                                        "{\"widget\":\"pnlAddNew pnlOtherValue crbValue\",\"data\":{\"enable\":false}}" +
                                    "]}"
                                );
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
                break;
            case "Other":

                if ( isThereFinancialList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoLiability:c:w:lnkAddOther:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoLiability:c:w:lnkAddOther:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);

                }

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
                                        "{\"widget\":\"pnlAddNew pnlCreditCard\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":false},\"delta\":-80,\"visibleEvent\":\"hide\"}," +
                                        "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlRepaymentAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlMaintenance\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlOtherValue\",\"data\":{\"visible\":true},\"delta\":220,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlNote txaNote\",\"data\":{\"enable\":false}}" +
                                    "]}"
                                );
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
                break;
            case "Car Loan":
                if ( isThereFinancialList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoLiability:c:w:lnkAddCarLoan:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoLiability:c:w:lnkAddCarLoan:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);
                }

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
                                    "{\"widgets\":[{" +
                                        "\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan\",\"data\":{\"visible\":true},\"delta\":160,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPaymentFreq\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan txtLoanPurpose\",\"data\":{\"visible\":false},\"visibleEvent\":\"hide\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan txtLoanPurpose\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
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
                                    "]}"
                                );
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );

                break;
            case "Student Loan":
                if ( isThereFinancialList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoLiability:c:w:lnkAddStudentLoan:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoLiability:c:w:lnkAddStudentLoan:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);

                }

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
                                    "{\"widgets\":[{" +
                                        "\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan\",\"data\":{\"visible\":true},\"delta\":160,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPaymentFreq\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan txtLoanPurpose\",\"data\":{\"visible\":false},\"visibleEvent\":\"hide\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan txtLoanPurpose\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
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
                                    "]}"
                                );
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );

                break;
            case "Rent":
                if ( isThereFinancialList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoLiability:c:w:pnl-737:c:w:lnkRent:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoLiability:c:w:pnl-737:c:w:lnkRent:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);

                }

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
                                    "{\"widgets\":[{" +
                                        "\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlPaymentFreq\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":false},\"delta\":-80,\"visibleEvent\":\"hide\"}," +
                                        "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlRepaymentAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlMaintenance\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlNote\",\"data\":{\"visible\":true},\"delta\":60,\"visibleEvent\":\"show\"}" +
                                        "{\"widget\":\"pnlAddNew pnlOtherValue crbValue\",\"data\":{\"enable\":false}}" +
                                    "]}"
                                );
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
                break;
            case "Utilities":
                if ( isThereFinancialList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoLiability:c:w:pnl-737:c:w:lnkUtilities:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoLiability:c:w:pnl-737:c:w:lnkUtilities:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);

                }

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
                                    "{\"widgets\": [{" +
                                        "\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlPaymentFreq\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":false},\"delta\":-80,\"visibleEvent\":\"hide\"}," +
                                        "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlRepaymentAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlMaintenance\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlNote\",\"data\":{\"visible\":true},\"delta\":60,\"visibleEvent\":\"show\"}" +
                                        "{\"widget\":\"pnlAddNew pnlOtherValue crbValue\",\"data\":{\"enable\":false}}" +
                                    "]}"
                                );
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
                break;
            case "Childcare":
                if ( isThereFinancialList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoLiability:c:w:pnl-737:c:w:lnkChildcare:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoLiability:c:w:pnl-737:c:w:lnkChildcare:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);

                }

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
                                    "{\"widgets\": [{" +
                                        "\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlPaymentFreq\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":false},\"delta\":-80,\"visibleEvent\":\"hide\"}," +
                                        "{\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard cmbCardType\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardLimit\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard crbCardBalance\",\"data\":{\"enable\":true}}," +
                                        "{\"widget\":\"pnlAddNew pnlRepaymentAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlMaintenance\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlNote\",\"data\":{\"visible\":true},\"delta\":60,\"visibleEvent\":\"show\"}" +
                                        "{\"widget\":\"pnlAddNew pnlOtherValue crbValue\",\"data\":{\"enable\":false}}" +
                                    "]}"
                                );
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
                break;
            case "Mortgage":
                if ( isThereFinancialList ) {

                    String addResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoLiability:c:w:pnl-737:c:w:lnkMortgage:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoLiability:c:w:pnl-737:c:w:lnkMortgage:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(addResponse);

                }

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
                                    "{\"widgets\":[{" +
                                        "\"widget\":\"pnlAddNew pnlOutstandingAmount\",\"data\":{\"visible\":true},\"delta\":80,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan\",\"data\":{\"visible\":true},\"delta\":160,\"visibleEvent\":\"show\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPaymentFreq cmbRepaymentFrequency\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan txtLoanPurpose\",\"data\":{\"visible\":false},\"visibleEvent\":\"hide\"}," +
                                        "{\"widget\":\"pnlAddNew pnlPersonalLoan txtLoanPurpose\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard\",\"data\":{\"enable\":false}}," +
                                        "{\"widget\":\"pnlAddNew pnlCreditCard txtCardProvider\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"}," +
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
                                    "]}"
                                );
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
                break;
            default:
                log.info("Huston, we have problem ! Do we have a new financial type ?");
        }
    }

    @When("^(Borrower) clicks Financial I have none$")
    public void user_clicks_i_have_none(String usertType) {
//        yourFinancialCommitmentsPage.clickNone();
    }

    @When("^(Borrower) clicks Financial Cancel")
    public void user_clicks_financial_cancel(String usertType) {
//        yourFinancialCommitmentsPage.clickCancel();
    }

    @When("^(Borrower) clicks Financial Save and Close")
    public void user_clicks_financial_save_and_close(String userType, String formType) throws IOException {
//        yourFinancialCommitmentsPage.clickSaveAndClose();

        Map<String, String> finalFinancialParameters = new LinkedHashMap<>();

        switch ( userType ) {
            case "Borrower":
                finalFinancialParameters.putAll(financialParameters);
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

//        finalFinancialParameters.put("root:c:w:pnlDetail:c:w:txtHiddenId:tb", "");
        finalFinancialParameters.put("stepToken", stepToken);
        finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:btnAddLiability:submit", "1");

        String linkClose = StringUtils.EMPTY;
//        String fixCategory = StringUtils.EMPTY;
        switch ( formType ) {
            case "Personal Loan":
                finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "PL");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoLiability:c:w:lnkAddPersonalLoan:close::IBehaviorListener:0:";
                break;
            case "Credit Card":
                finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "CRD");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoLiability:c:w:lnkAddCreditCard:close::IBehaviorListener:0:";
                break;
            case "Maintenance Payment":
                finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "MP");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoLiability:c:w:lnkAddMaintenancePayment:close::IBehaviorListener:0:";
                break;
            case "Other":
                finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "OTH");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoLiability:c:w:lnkAddOther:close::IBehaviorListener:0:";
                break;
            case "Car Loan":
                finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "CL");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoLiability:c:w:lnkAddCarLoan:close::IBehaviorListener:0:";
                break;
            case "Student Loan":
                finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "SL");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoLiability:c:w:lnkAddStudentLoan:close::IBehaviorListener:0:";
                break;
            case "Rent":
                finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "RENT");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoLiability:c:w:pnlAddExpanses:c:w:lnkRent:close::IBehaviorListener:0:";
                break;
            case "Utilities":
                finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "UTILITIES");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoLiability:c:w:pnlAddExpanses:c:w:lnkUtilities:close::IBehaviorListener:0:";
                break;
            case "Childcare":
                finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "CHILDCARE");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoLiability:c:w:pnlAddExpanses:c:w:lnkChildcare:close::IBehaviorListener:0:";
                break;
            case "Mortgage":
                finalFinancialParameters.put("root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox", "MORTGAGE");
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoLiability:c:w:pnlAddExpanses:c:w:lnkMortage:close::IBehaviorListener:0:";
                break;
            default:
                log.error("Huston, we have an issue on Fix Financial Type");
        }

        requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlDetail:c:w:btnEmploymentAdd:submit::IBehaviorListener:0:",
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlAddNew:c:w:btnAddLiability:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                finalFinancialParameters,
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
//        httpResponse.setHttpResponse(employmentAddResponse);

        if ( isThereFinancialList )
            linkClose = "1:main:c:form:form:root:c:w:pnlLiabList:c:w:btnAddEmp:close::IBehaviorListener:0:";

//        if ( currentWorkflow.equals("btnEmployment")) {
        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=" + linkClose,
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

        if ( !isThereFinancialList ) {
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
                    localContext.getHttpContext(),
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(addEmplCompleted);
        }
        else {
            String addEmplCompleted = requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHidenRefresh:submit::IBehaviorListener:0:",
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

    @When("^(Borrower) clicks Financial Edit")
    public void user_clicks_financial_edit(String usertType) {
//        yourFinancialCommitmentsPage.clickEdit();
    }

    @When("^(Borrower) clicks financial Delete$")
    public void user_clicks_financial_delete(String usertType) {
//        yourFinancialCommitmentsPage.clickDelete();
    }

    @When("^(Borrower) clicks financial Done$")
    public void user_clicks_financial_done(String usertType) throws IOException {
//        yourFinancialCommitmentsPage.clickDone();

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

        String yourAccountPageResponse = requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlLiabList:c:w:btnImDone:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", stepToken); // TODO extract stepToken should be 3
                        put("root:c:w:pnlLiabList:c:w:btnImDone:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(yourAccountPageResponse);
    }

    @When("^(Borrower) clicks financial Add$")
    public void user_clicks_financial_add(String usertType) {
//        yourFinancialCommitmentsPage.clickAdd();
    }

    @And("^(Borrower) clicks financial \"NEXT\"$")
    public void user_clicks_financial_next(String usertType) {
//        yourFinancialCommitmentsPage.clickNext();
    }

    @When("^(Borrower) clicks financial Wait I have...$")
    public void user_clicks_financial_wait_i_have(String usertType) {
//        yourFinancialCommitmentsPage.clickWaitIHave();
    }


    /**
     root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox
     PL
     root:c:w:pnlAddNew:c:w:pnlBorrowers:c:w:chkBorrowerOne:checkbox
     on
     root:c:w:pnlAddNew:c:w:pnlOutstandingAmount:c:w:crbOutstandingLoanAmount:tb
     1
     root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb
     2
     root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtLoanPurpose:tb
     3
     root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb
     31/03/2016
     root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox
     W
     root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb
     4
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea
     stepToken
     1
     root:c:w:pnlAddNew:c:w:btnAddLiability:submit
     1
     */


    @And("^(Borrower) types Personal OustandingBalalnceAmount : (.*)$")
    public void user_types_personal_oustanding_balance_amount(String usertType, String outstandingBalanceAmount) {
//        yourFinancialCommitmentsPage.typePersonalOutstandingBalanceAmount(outstandingBalanceAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlOutstandingAmount:c:w:crbOutstandingLoanAmount:tb", outstandingBalanceAmount);

    }

    @And("^(Borrower) types Personal Financial Institution : (.*)$")
    public void user_types_personal_financial_institution(String usertType, String financialInstitution) {
//        yourFinancialCommitmentsPage.typePersonalFinancialInstitution(financialInstitution);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb", financialInstitution);
    }

    @And("^(Borrower) types Personal Loan Purpose : (.*)$")
    public void user_types_personal_loan_purpose(String usertType, String loanPurpose) {
//        yourFinancialCommitmentsPage.typePersonalLoanPurpose(loanPurpose);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtLoanPurpose:tb", loanPurpose);
    }

    @And("^(Borrower) types Personal final repayment date : (.*)$")
    public void user_types_personal_final_repayment_date(String usertType, String finalRepaymentDate) {
//        yourFinancialCommitmentsPage.typePersonalFinalRepaymentDate(finalRepaymentDate);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb", finalRepaymentDate);
    }

    @And("^(Borrower) selects Personal payment frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selects_personal_payment_frequency(String usertType, String paymentFrequency) {
//        yourFinancialCommitmentsPage.selectPersonalPaymentFrequency(paymentFrequency);
        String finalPaymentFrequency = StringUtils.EMPTY;
        switch(paymentFrequency) {
            case "Weekly":
                finalPaymentFrequency = "W";
                break;
            case "Fortnightly":
                finalPaymentFrequency = "F";
                break;
            case "Monthly":
                finalPaymentFrequency = "M";
                break;
            case "Yearly":
                finalPaymentFrequency = "Y";
                break;
        }
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox", finalPaymentFrequency);
    }

    @And("^(Borrower) types Personal repayment amount : (.*)$")
    public void user_types_personal_repayment_amount(String usertType, String repaymentAmount) {
//        yourFinancialCommitmentsPage.typePersonalRepaymentAmount(repaymentAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb", repaymentAmount);
    }


    /**
     root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox
     CRD
     root:c:w:pnlAddNew:c:w:pnlBorrowers:c:w:chkBorrowerOne:checkbox
     on
     root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb
     1
     root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:txtCardProvider:tb
     2
     root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:cmbCardType:combobox
     VIS
     root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:crbCardLimit:tb
     3
     root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:crbCardBalance:tb
     4
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea
     stepToken
     2
     root:c:w:pnlAddNew:c:w:btnAddLiability:submit
     1
     */

    @And("^(Borrower) types Credit Card repayment amount : (.*)$")
    public void user_types_credit_card_repayment_amount(String usertType, String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeCreditcRepaymentAmount(repaymentAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb",  repaymentAmount);
    }

    @And("^(Borrower) types Credit Card provider : (.*)$")
    public void user_types_credit_card_provider(String usertType, String provider) {
//        yourFinancialCommitmentsPage.typeCreditcProvider(provider);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:txtCardProvider:tb", provider);
    }

    @And("^(Borrower) selects Credit Card type : (VISA|Mastercard|American Express|Store Card|Other)$")
    public void user_selects_credit_card_type(String usertType, String type) {
//        yourFinancialCommitmentsPage.selectCreditcType(type);
        String finalCreditCardType = StringUtils.EMPTY;
        switch (type) {
            case "VISA":
                finalCreditCardType = "VIS";
                break;
            case "Mastercard":
                finalCreditCardType = "";
                break;
            case "American Express":
                finalCreditCardType = "";
                break;
            case "Store Card":
                finalCreditCardType = "";
                break;
            case "Other":
                finalCreditCardType = "";
                break;
        }
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:cmbCardType:combobox", finalCreditCardType);
    }

    @And("^(Borrower) types Credit Card limit : (.*)$")
    public void user_types_credit_care_limit(String usertType, String limit) {
//        yourFinancialCommitmentsPage.typeCreditcLimit(limit);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:crbCardLimit:tb", limit);
    }

    @And("^(Borrower) types Credit Card balance : (.*)$")
    public void user_types_credit_card_balance(String usertType, String balance) {
//        yourFinancialCommitmentsPage.typeCreditcBalance(balance);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:crbCardBalance:tb", balance);
    }


    /**
    root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox
            MP
    root:c:w:pnlAddNew:c:w:pnlBorrowers:c:w:chkBorrowerOne:checkbox
            on
    root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb
    root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea
    root:c:w:pnlAddNew:c:w:pnlMaintenance:c:w:crbMaintenancePayment:tb
    1
    stepToken
    2
    root:c:w:pnlAddNew:c:w:btnAddLiability:submit
    1*/

    @And("^(Borrower) types Maintenance payment : (.*)$")
    public void user_types_maintenance_payment(String usertType, String payment) {
//        yourFinancialCommitmentsPage.typeMaintenancepPayment(payment);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlMaintenance:c:w:crbMaintenancePayment:tb", payment);

    }


    /**
     root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox
     OTH
     root:c:w:pnlAddNew:c:w:pnlBorrowers:c:w:chkBorrowerOne:checkbox
     on
     root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb
     1
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb
     2
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea
     3
     stepToken
     2
     root:c:w:pnlAddNew:c:w:btnAddLiability:submit
     1
     */

    @And("^(Borrower) types Other repayment amount : (.*)$")
    public void user_types_other_repayment_amount(String usertType, String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeOtherRepaymentAmount(repaymentAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb", repaymentAmount);
    }

    @And("^(Borrower) types Other value : (.*)$")
    public void user_types_other_value(String usertType, String value) {
//        yourFinancialCommitmentsPage.typeOtherValue(value);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb", value);
    }

    @And("^(Borrower) types Other description : (.*)$")
    public void user_types_other_description(String usertType, String description) {
//        yourFinancialCommitmentsPage.typeOtherDescription(description);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea", description);
    }


    /**
     root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox
     CL
     root:c:w:pnlAddNew:c:w:pnlBorrowers:c:w:chkBorrowerOne:checkbox
     on
     root:c:w:pnlAddNew:c:w:pnlOutstandingAmount:c:w:crbOutstandingLoanAmount:tb
     1
     root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb
     2
     root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb
     31/03/2016
     root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox
     W
     root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb
     3
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea
     stepToken
     2
     root:c:w:pnlAddNew:c:w:btnAddLiability:submit
     1
     */

    @And("^(Borrower) types Car outstanding balance amount : (.*)$")
    public void user_types_car_outstanding_balance_amount(String usertType, String outstandingBalanceAmount) {
//        yourFinancialCommitmentsPage.typeCarOutstandingBalanceAmount(outstandingBalanceAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlOutstandingAmount:c:w:crbOutstandingLoanAmount:tb", outstandingBalanceAmount);
    }

    @And("^(Borrower) types Car financial institution : (.*)$")
    public void user_types_car_financial_institution(String usertType, String financialInstitution) {
//        yourFinancialCommitmentsPage.typeCarFinancialInstitution(financialInstitution);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb", financialInstitution);
    }

    @And("^(Borrower) types Car final Repayment Date : (.*)$")
    public void user_types_car_final_repayment_date(String usertType, String finalRepaymentDate) {
//        yourFinancialCommitmentsPage.typeCarFinalRepaymentDate(finalRepaymentDate);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb", finalRepaymentDate);
    }

    @And("^(Borrower) selects Car Payment Frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selects_car_payment_frequency(String usertType, String paymentFrequency) {
//        yourFinancialCommitmentsPage.selectCarPaymentFrequency(paymentFrequency);
        String finalPaymentFrequency = StringUtils.EMPTY;
        switch (paymentFrequency) {
            case "Weekly":
                finalPaymentFrequency = "W";
                break;
            case "Fortnightly":
                finalPaymentFrequency = "F";
                break;
            case "Monthly":
                finalPaymentFrequency = "M";
                break;
            case "Yearly":
                finalPaymentFrequency = "Y";
                break;
        }
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox", finalPaymentFrequency);
    }

    @And("^(Borrower) types Card repayment amount : (.*)$")
    public void user_types_card_repayment_amount(String usertType, String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeCarRepaymentAmount(repaymentAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb", repaymentAmount);
    }


    /**
     root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox
     SL
     root:c:w:pnlAddNew:c:w:pnlBorrowers:c:w:chkBorrowerOne:checkbox
     on
     root:c:w:pnlAddNew:c:w:pnlOutstandingAmount:c:w:crbOutstandingLoanAmount:tb
     1
     root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb
     2
     root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb
     31/03/2016
     root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox
     W
     root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb
     3
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea
     stepToken
     2
     root:c:w:pnlAddNew:c:w:btnAddLiability:submit
     1
     */

    @And("^(Borrower) types Student outstanding balance amount : (.*)$")
    public void user_types_student_outstanding_balance_amount(String usertType, String outstandingBalanceAmount) {
//        yourFinancialCommitmentsPage.typeStudentOutstandingBalanceAmount(outstandingBalanceAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlOutstandingAmount:c:w:crbOutstandingLoanAmount:tb", outstandingBalanceAmount);
    }

    @And("^(Borrower) types Student financial institution : (.*)$")
    public void user_types_student_financial_institution(String usertType, String financialInstitution) {
//        yourFinancialCommitmentsPage.typeStudentFinancialInstitution(financialInstitution);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb", financialInstitution);
    }

    @And("^(Borrower) types Student final repayment date : (.*)$")
    public void user_types_student_final_repayment_date(String usertType, String finalRepaymentDate) {
//        yourFinancialCommitmentsPage.typeStudentFinalRepaymentDate(finalRepaymentDate);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb", finalRepaymentDate);
    }

    @And("^(Borrower) selects Student payment frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selects_student_payment_frequency(String usertType, String paymentFrequency) {
//        yourFinancialCommitmentsPage.selectStudentPaymentFrequency(paymentFrequency);
        String finalPaymentFrequency = StringUtils.EMPTY;
        switch (paymentFrequency) {
            case "Weekly":
                finalPaymentFrequency = "W";
                break;
            case "Fortnightly":
                finalPaymentFrequency = "F";
                break;
            case "Monthly":
                finalPaymentFrequency = "M";
                break;
            case "Yearly":
                finalPaymentFrequency = "Y";
                break;
        }
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox", finalPaymentFrequency);
    }

    @And("^(Borrower) types Student repayment amount : (.*)$")
    public void user_types_student_repayment_amount(String usertType, String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeStudentRepaymentAmount(repaymentAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb", repaymentAmount);
    }


    /**
     root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox
     RENT
     root:c:w:pnlAddNew:c:w:pnlBorrowers:c:w:chkBorrowerOne:checkbox
     on
     root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox
     W
     root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb
     1
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea
     root:c:w:pnlAddNew:c:w:pnlNote:c:w:txaNote:textarea
     2
     stepToken
     2
     root:c:w:pnlAddNew:c:w:btnAddLiability:submit
     1     */

//    rent
    @And("^(Borrower) selects Rent Payment Frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_selects_rent_payment_frequency(String usertType, String repaymentFrequency) {
        //optional
//        yourFinancialCommitmentsPage.selectRentPaymentFrequency(repaymentFrequency);
        String finalPaymentFrequency = StringUtils.EMPTY;
        switch (repaymentFrequency) {
            case "Weekly":
                finalPaymentFrequency = "W";
                break;
            case "Fortnightly":
                finalPaymentFrequency = "F";
                break;
            case "Monthly":
                finalPaymentFrequency = "M";
                break;
            case "Yearly":
                finalPaymentFrequency = "Y";
                break;
        }
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox", finalPaymentFrequency);
    }

    @And("^(Borrower) types Rent Repayment Amount : (.*)$")
    public void user_types_rent_repayment_amount(String usertType, String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeRentRepaymentAmount(repaymentAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb", repaymentAmount);
    }

    @And("^(Borrower) types Rent note : (.*)$")
    public void user_types_rent_note(String usertType, String note) {
        //optional
//        yourFinancialCommitmentsPage.typeRentNote(note);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlNote:c:w:txaNote:textarea", note);
    }


    /**
     root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox
     UTILITIES
     root:c:w:pnlAddNew:c:w:pnlBorrowers:c:w:chkBorrowerOne:checkbox
     on
     root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox
     W
     root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb
     1
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea
     root:c:w:pnlAddNew:c:w:pnlNote:c:w:txaNote:textarea
     2
     stepToken
     2
     root:c:w:pnlAddNew:c:w:btnAddLiability:submit
     1
     */

//    utilities
    @And("^(Borrower) types Utilities payment frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_types_utilities_payment_frequency(String usertType, String paymentFrequency) {
        //optional
//        yourFinancialCommitmentsPage.selectUtilitiesPaymentFrequency(paymentFrequency);
        String finalPaymentFrequency = StringUtils.EMPTY;
        switch (paymentFrequency) {
            case "Weekly":
                finalPaymentFrequency = "W";
                break;
            case "Fortnightly":
                finalPaymentFrequency = "F";
                break;
            case "Monthly":
                finalPaymentFrequency = "M";
                break;
            case "Yearly":
                finalPaymentFrequency = "Y";
                break;
        }
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox", finalPaymentFrequency);
    }

    @And("^(Borrower) types Utilities Repayment Amount : (.*)$")
    public void user_types_utilities_repayment_amount(String usertType, String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeUtilitiesRepaymentAmount(repaymentAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb", repaymentAmount);
    }

    @And("^(Borrower) types Utilities note : (.*)$")
    public void user_types_utilities_note(String usertType, String note) {
        //optional
//        yourFinancialCommitmentsPage.typeUtilitiesNote(note);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlNote:c:w:txaNote:textarea", note);
    }


    /**
     root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox
     CHILDCARE
     root:c:w:pnlAddNew:c:w:pnlBorrowers:c:w:chkBorrowerOne:checkbox
     on
     root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox
     W
     root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb
     1
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb
     root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea
     root:c:w:pnlAddNew:c:w:pnlNote:c:w:txaNote:textarea
     2
     stepToken
     2
     root:c:w:pnlAddNew:c:w:btnAddLiability:submit
     1
     */

//    childcare
    @And("^(Borrower) selects Child Care Payment Frequency : (Weekly|Fortnightly|Monthly|Yearly)$")
    public void user_types_child_care_payment_frequency(String usertType, String paymentFrequency) {
        //optional
//        yourFinancialCommitmentsPage.selectChildCarePaymentFrequency(paymentFrequency);
        String finalPaymentFrequency = StringUtils.EMPTY;
        switch (paymentFrequency) {
            case "Weekly":
                finalPaymentFrequency = "W";
                break;
            case "Fortnightly":
                finalPaymentFrequency = "F";
                break;
            case "Monthly":
                finalPaymentFrequency = "M";
                break;
            case "Yearly":
                finalPaymentFrequency = "Y";
                break;
        }
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPaymentFreq:c:w:cmbRepaymentFrequency:combobox", finalPaymentFrequency);

    }

    @And("^(Borrower) types Child Care Repayment Amount : (.*)$")
    public void user_types_child_care_repayment_amount(String usertType, String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeChildCareRepaymentAmount(repaymentAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb", repaymentAmount);
    }

    @And("^(Borrower) types Child Care note: (.*)$")
    public void user_types_child_care_note(String usertType, String note) {
        //optional
//        yourFinancialCommitmentsPage.typeChildCareNote(note);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlNote:c:w:txaNote:textarea", note);
    }


     /**
      root:c:w:pnlAddNew:c:w:cmbLiabilityType:combobox
      MORTGAGE
      root:c:w:pnlAddNew:c:w:pnlBorrowers:c:w:chkBorrowerOne:checkbox
      on
      root:c:w:pnlAddNew:c:w:pnlOutstandingAmount:c:w:crbOutstandingLoanAmount:tb
      1
      root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb
      2
      root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb
      31/03/2016
      root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb
      3
      root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb
      root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea
      stepToken
      2
      root:c:w:pnlAddNew:c:w:btnAddLiability:submit
      1
     */

//    mortgage
    @And("^(Borrower) types Mortgage Outstanding Balance Amount : (.*)$")
    public void user_types_mortgage_outstanding_balance_amount(String usertType, String outstandingBalanceAmount) {
//        yourFinancialCommitmentsPage.typeMortgageOutstandingBalanceAmount(outstandingBalanceAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlOutstandingAmount:c:w:crbOutstandingLoanAmount:tb", outstandingBalanceAmount);
    }

    @And("^(Borrower) types Mortgage Financial Institution : (.*)$")
    public void user_types_mortgage_financial_institution(String usertType, String financialInstitution) {
//        yourFinancialCommitmentsPage.typeMortgageFinancialInstitution(financialInstitution);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb", financialInstitution);
    }

    @And("^(Borrower) types Mortgage Final Repayment Date : (.*)$")
    public void user_types_mortgage_final_repayment_date(String usertType, String finalRepaymentDate) {
        //optional
//        yourFinancialCommitmentsPage.typeMortgageFinalRepaymentDate(finalRepaymentDate);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb", finalRepaymentDate);
    }

    @And("^(Borrower) types Mortgage Repayment Amount: (.*)$")
    public void user_types_mortgage_repayment_amount(String usertType, String repaymentAmount) {
//        yourFinancialCommitmentsPage.typeMortgageRepaymentAmount(repaymentAmount);
        financialParameters.put("root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb", repaymentAmount);
    }

    @And("^Borrower clicks on Financial commitments link$")
    public void borrower_clicks_on_financial_commitments_link(){
//        formsMenu = new FormsMenu((SharedDriver)webDriver);
//        formsMenu.clickFinancialCommitments();
    }
}
