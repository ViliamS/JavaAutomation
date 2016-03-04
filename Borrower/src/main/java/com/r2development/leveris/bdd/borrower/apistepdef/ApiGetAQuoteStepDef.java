package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.QuoteData;
import com.r2development.leveris.di.IHttpResponse;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.protocol.HttpContext;
import org.hamcrest.core.Is;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;
import static org.junit.Assert.*;

@Singleton
public class ApiGetAQuoteStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiGetAQuoteStepDef.class.getName());

    protected boolean toSkip = false;
    protected QuoteData quoteData = new QuoteData();

    @Inject
    IHttpResponse httpResponse;
    @Inject
    IUser user;

    @Inject
    public ApiGetAQuoteStepDef(IHttpResponse httpResponse, IUser user) {
        this.httpResponse = httpResponse;
        this.user = user;
    }

    @Given("^user goes to Borrower homepage$")
    public void user_goes_to_borrower_home_page() throws IOException {

        assertNotEquals("Should be different HttpClientContext object", localContext, initContext());
        HttpContext newLocalContext = newHttpClientContext();
        assertEquals("not same HttpClientContext object", newLocalContext, localContext);

        String response = requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/home",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(response);
    }

    @Given("^user clicks the Quote link$")
    public void user_clicks_quote_link() throws IOException {

        String response = requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:lnkQuote:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                        put("root:c:w:pnlMain:c:w:lnkQuote:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(response);

    }

    @Given("^user creates a quote$")
    public void user_creates_a_quote() throws IOException {
        user_goes_to_borrower_home_page();
//        user_clicks_quote_link();
//        user_clicks_the_get_quote_now_button();
    }

    @Given("^user processes \"Get a Quote\" \\(format1\\)$")
    public void user_processes_get_quote(List<QuoteData> quoteDataList, String... test) throws IOException {
        assertEquals("System is expecting only one QuoteData occurrence", quoteDataList.size(), 1);
        user_wants_to_get_a_quote_now();
        fill_in_quote_step1(quoteDataList.get(0));
        user_processes_2step3_to_get_a_quote();
        user_processes_3step3_to_get_a_quote();
    }

    @Given("^user processes \"Get a Quote\" \\(format2\\)$")
//    public void user_processes_get_quote(Map<String, String> quoteDataMap) throws IOException {
    public void user_processes_get_quote(List<String> quoteDataMap) throws IOException {
        user_wants_to_get_a_quote_now();
        quoteData = new QuoteData(quoteDataMap);
        fill_in_quote_step1(quoteData);
        user_processes_2step3_to_get_a_quote();
        user_processes_3step3_to_get_a_quote();
    }

    @And("^user wants to get a quote now$")
    public void user_wants_to_get_a_quote_now() throws IOException {

        String getStartedResponse = requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btn-GetStarted:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        Document getStartedDoc = Jsoup.parse(getStartedResponse);
//        TextNode textNodeGetStartedDoc = getStartedDoc.select("component[id~=main]").select("component[encoding~=wicket]").first().textNodes().get(0);
        Elements evaluateElements =  getStartedDoc.select("evaluate[encoding~=wicket]");
        String textContainingWorkItemId = "";
        for ( Element currentElement : evaluateElements) {
            if ( currentElement.outerHtml().contains("QuoteCollapsed")) {
                textContainingWorkItemId = currentElement.text();
                break;
            }
        }

        Pattern pWorkItemId = Pattern.compile("\"workItemId\":\"([a-z0-9]+)\"");
        Matcher mWorkItemId = pWorkItemId.matcher(textContainingWorkItemId);
        String workItemId = null;
        while (mWorkItemId.find()) {
            workItemId = mWorkItemId.group(1);
        }
        final String finalWorkItemId = workItemId;

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:txtWorkItemViewTaskId:tb", finalWorkItemId);
                        put("stepToken", "1");
                        put("root:c:w:btnTasksHidden:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

//        String currentResponse = requestHttpPost(
//                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlBackground:c:w:btnGetQuoteNow:submit::IBehaviorListener:0:",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                    }
//                },
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("stepToken", "1");
//                        put("root:c:w:pnlBackground:c:w:btnGetQuoteNow:submit", "1");
//                    }
//                },
//                localContext,
//                CONSUME_QUIETLY
//        );
//        httpResponse.setHttpResponse(currentResponse);

    }

    private void fill_in_quote_step1(QuoteData quoteData) throws IOException {
        user_selects_number_of_borrowers(quoteData.getBorrowerNumber());
        user_selects_mortgage_type(quoteData.getMortgageType());
        user_types_his_age(quoteData.getBorrowerAge());
        if ( quoteData.getPartnerAge() != null )
            user_types_partner_age(quoteData.getPartnerAge());
        user_selects_his_marital_status(quoteData.getBorrowerMaritalStatus());
        user_types_his_total_of_dependents(quoteData.getBorrowerTotalDependents());
        user_selects_his_income_type(quoteData.getBorrowerIncomeType());
        user_types_his_income_amount(quoteData.getBorrowerIncomeAmount());
        if ( quoteData.getPartnerIncomeType() != null ) {
            user_selects_partner_income_type(quoteData.getPartnerIncomeType());
        }
        if ( quoteData.getPartnerIncomeAmount() != null )
            user_types_partner_income_amount(quoteData.getPartnerIncomeAmount());
        user_types_monthly_credit_commitments(quoteData.getMonthlyCreditCommitments());
        user_clicks_get_my_quote();
    }

    @And("^user processes 2nd step of 3 to get a quote$")
    public void user_processes_2step3_to_get_a_quote() throws IOException {
        user_clicks_configure_loan();
    }

    @And("^user clicks \"CONFIGURE LOAN\"$")
    public void user_clicks_configure_loan() throws IOException {
        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlAffordability:c:w:btnconfigureYourLoan:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlAffordability:c:w:crbYourFunds:tb", "110,037.50"); //87,068.75
                        put("stepToken", "2");
                        put("root:c:w:pnlAffordability:c:w:btnconfigureYourLoan:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    @And("^user processes 3rd step of 3 to get a quote$")
    public void user_processes_3step3_to_get_a_quote() throws IOException {
        user_clicks_apply_now();
    }

    @And("^user clicks \"APPLY NOW\"$")
    public void user_clicks_apply_now() throws IOException {
        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnApplyNow:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
// BUG CLV
//                    new LinkedHashMap<String, String>() {
//                        {
//                            put("root:c:w:pnlMortgageCalc:data", "{\"loanValue\":525000,\"depositValue\":103750,\"repaymentValue\":2485,\"termValue\":35,\"changedParam\":\"\"}");
//                            put("stepToken", "3");
//                            put("root:c:w:btnApplyNow:submit", "1");
//                        }
//                    },
                null,
                localContext,
                CONSUME_QUIETLY
        );
    }

    @Given("^user clicks the Get Quote Now button$")
    public void user_clicks_the_get_quote_now_button() throws IOException {

//        String currentResponse = requestHttpPost(
//                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlBackground:c:w:btnGetQuoteNow:submit::IBehaviorListener:0:",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                        put("Content-Type", "application/x-www-form-urlencoded");
//                    }
//                },
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("stepToken", "2");
//                        put("root:c:w:pnlBackground:c:w:btnGetQuoteNow:submit","1");
//                    }
//                },
//                localContext,
//                CONSUME_QUIETLY
//        );
//
//        httpResponse.setHttpResponse(currentResponse);
    }

    @And("^user selects (a single borrower|two borrowers) as number of borrowers")
    public void user_selects_number_of_borrowers(String nbBorrowers) throws IOException {

        String numberOfBorrowers = ( nbBorrowers.equals("a single borrower") ? "1" : "2" );
        String rgrNumberOfBorrowers = ( nbBorrowers.equals("a single borrower") ? "radNumberOfBorrowersSingle" : "radNumberOfBorrowersJoint" );
        quoteData.setBorrowerNumber(numberOfBorrowers);
//        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlNumberOfBorrowers:c:w:cmbNumberOfBorrowers:combobox", numberOfBorrowers);
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlNumberOfBorrowers:c:w:rgrNumberOfBorrowers:rg", rgrNumberOfBorrowers);

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
//                        put(
//                            "data",
//                            "{" +
//                                "\"widgets\": [" +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlMortgageType\"," +
//                                        "\"data\": {" +
//                                            "\"visible\": true" +
//                                        "}," +
//                                        "\"delta\": 60," +
//                                        "\"visibleEvent\": \"show\"" +
//                                    "}," +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlMortgageType\"," +
//                                        "\"data\": {" +
//                                            "\"enable\": true" +
//                                        "}" +
//                                    "}," +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlMortgageType cmbMortgageType\"," +
//                                        "\"data\": {" +
//                                            "\"enable\": true" +
//                                        "}" +
//                                    "}" +
//                                "]" +
//                            "}"
//                        );
                        
                        put(
                            "data",
                            "{\"widgets\":[{\"widget\":\"pnlBuildYourQuotation pnlMortgageType\",\"data\":{\"visible\":true},\"delta\":100,\"visibleEvent\":\"show\"},{\"widget\":\"pnlBuildYourQuotation pnlMortgageType rgrMortgageType radMortgageTypeFirstTime\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlMortgageType rgrMortgageType radMortgageTypeMovers\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlMortgageType rgrMortgageType\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlMortgageType\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlAge pnlAge2\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlBuildYourQuotation pnlAge pnlAge2 txtAge2\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlAge pnlAge2\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncome2\",\"data\":{\"visible\":true},\"delta\":130,\"visibleEvent\":\"show\"},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncome2 txtIncomeType2origValue\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncome2 rgrIncomeTypeB2 radIncomeTypePaye\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncome2 rgrIncomeTypeB2 radIncomeTypeSelfEmployed\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncome2 rgrIncomeTypeB2 radIncomeTypeCivilServant\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncome2 rgrIncomeTypeB2\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncome2\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2\",\"data\":{\"visible\":true},\"delta\":70,\"visibleEvent\":\"show\"},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2 crbIncomeAmount\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2\",\"data\":{\"enable\":true}}]}"
//                            "{" +
//                                "\"widgets\": [" +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlMortgageType\"," +
//                                        "\"data\": {" +
//                                            "\"visible\": true" +
//                                        "}," +
//                                        "\"delta\": 100," +
//                                        "\"visibleEvent\": \"show\"" +
//                                    "}," +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlMortgageType rgrMortgageType radMortgageTypeFirstTime\"," +
//                                        "\"data\": {" +
//                                            "\"enable\": true" +
//                                        "}" +
//                                    "}," +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlMortgageType rgrMortgageType radMortgageTypeMovers\"," +
//                                        "\"data\": {" +
//                                            "\"enable\":true" +
//                                        "}" +
//                                    "}," +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlMortgageType rgrMortgageType\"," +
//                                        "\"data\": {" +
//                                            "\"enable\":true" +
//                                        "}" +
//                                    "}," +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlMortgageType\"," +
//                                        "\"data\": {" +
//                                            "\"enable\": true" +
//                                        "}" +
//                                    "}" +
//                                "]" +
//                            "}"
                        );
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

    }

    @And("^user selects (first-time buyer\\(s\\)|mover\\(s\\)) as mortgage type$")
    public void user_selects_mortgage_type(String mortgageType) throws IOException {

        String mortgageTypeValue = ( mortgageType.equals("first-time buyer(s)") ? "FTB" : "MOV" );
        String rgrMortgageType = ( mortgageType.equals("first-time buyer(s)") ? "radMortgageTypeFirstTime" : "radMortgageTypeMovers" );
        quoteData.setMortgageType(mortgageType);
//        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlMortgageType:c:w:cmbMortgageType:combobox", mortgageTypeValue);
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlMortgageType:c:w:rgrMortgageType:rg", rgrMortgageType);


        Map<String, String> parametersPost = new LinkedHashMap<>();
        if ( quoteData.getBorrowerNumber().equals("2")) {
//            parametersPost.put(
//                    "data",
//                    "{" +
//                        "\"widgets\": [" +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge\"," +
//                                "\"data\": {" +
//                                    "\"visible\": true" +
//                                "}," +
//                                "\"delta\": 80," +
//                                "\"visibleEvent\": \"show\"" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge\"," +
//                                "\"data\": {" +
//                                 "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge txtAge\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge pnlAge2\"," +
//                                "\"data\": {" +
//                                    "\"visible\": true" +
//                                "}," +
//                                "\"visibleEvent\": \"show\"" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge pnlAge2\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge pnlAge2 txtAge2\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}" +
//                        "]" +
//                    "}"
//            );

            // not really CLV Bug but redundant info
//            {"widgets":[{"widget":"pnlBuildYourQuotation pnlAge","data":{"visible":true},"delta":90,"visibleEvent":"show"},{"widget":"pnlBuildYourQuotation pnlAge pnlAge2 txtAge2","data":{"enable":true}},{"widget":"pnlBuildYourQuotation pnlAge pnlAge2","data":{"enable":true}},{"widget":"pnlBuildYourQuotation pnlAge txtAge","data":{"enable":true}},{"widget":"pnlBuildYourQuotation pnlAge","data":{"enable":true}},{"widget":"pnlBuildYourQuotation pnlAge pnlAge2","data":{"enable":true}}]}
            parametersPost.put(
                    "data",
                    "{\"widgets\":[{\"widget\":\"pnlBuildYourQuotation pnlAge\",\"data\":{\"visible\":true},\"delta\":90,\"visibleEvent\":\"show\"},{\"widget\":\"pnlBuildYourQuotation pnlAge pnlAge2 txtAge2\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlAge pnlAge2\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlAge txtAge\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlAge\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlAge pnlAge2\",\"data\":{\"enable\":true}}]}"
//                    "{" +
//                        "\"widgets\": [" +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge\"," +
//                                "\"data\": {" +
//                                    "\"visible\": true" +
//                                "}," +
//                                "\"delta\": 90," +
//                                "\"visibleEvent\": \"show\"" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge txtAge\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge pnlAge2\"," +
//                                "\"data\": {" +
//                                    "\"visible\": true" +
//                                "}," +
//                                "\"visibleEvent\": \"show\"" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge pnlAge2\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlAge pnlAge2 txtAge2\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}" +
//                        "]" +
//                    "}"
            );
        } else {
            parametersPost.put(
                "data",
//                "{" +
//                    "\"widgets\": [" +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlAge\"," +
//                            "\"data\": {" +
//                                "\"visible\": true" +
//                            "}," +
//                            "\"delta\": 80," +
//                            "\"visibleEvent\": \"show\"" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlAge\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlAge txtAge\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}" +
//                    "]" +
//                "}"
                    "{\"widgets\":[{\"widget\":\"pnlBuildYourQuotation pnlAge\",\"data\":{\"visible\":true},\"delta\":90,\"visibleEvent\":\"show\"},{\"widget\":\"pnlBuildYourQuotation pnlAge pnlAge2 txtAge2\",\"data\":{\"enable\":false}},{\"widget\":\"pnlBuildYourQuotation pnlAge pnlAge2\",\"data\":{\"enable\":false}},{\"widget\":\"pnlBuildYourQuotation pnlAge txtAge\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlAge\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlAge pnlAge2\",\"data\":{\"enable\":false}}]}"
            );
        }

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                parametersPost,
                localContext,
                CONSUME_QUIETLY
        );

    }

    @And("^user types (.*) as age$")
    public void user_types_his_age(String age) throws IOException {

        quoteData.setBorrowerAge(age);
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlAge:c:w:txtAge:tb", age);

        if ( quoteData.getBorrowerNumber().equals("1") ) {
            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
//                            put (
//                                "data",
//                                "{" +
//                                    "\"widgets\": [" +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus\"," +
//                                            "\"data\": {" +
//                                                "\"visible\":true" +
//                                            "}," +
//                                            "\"delta\": 60," +
//                                            "\"visibleEvent\": \"show\"" +
//                                        "}," +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus\"," +
//                                            "\"data\": {" +
//                                                "\"enable\": true" +
//                                            "}" +
//                                        "}," +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus cmbMaritalStatus\"," +
//                                            "\"data\": {" +
//                                                "\"enable\": true" +
//                                            "}" +
//                                        "}," +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus txtTotalDependents\"," +
//                                            "\"data\": {" +
//                                                "\"enable\":true" +
//                                            "}" +
//                                        "}" +
//                                    "]" +
//                                "}"
//                            );

                            put(
                                "data",
                                "{" +
                                    "\"widgets\": [" +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus\"," +
                                            "\"data\": {" +
                                                "\"visible\": true" +
                                            "}," +
                                            "\"delta\": 200," +
                                            "\"visibleEvent\": \"show\"" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus radMaritalStatusSingle\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus radMaritalStatusSeparated\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus radMaritalStatusMarried\"," +
                                            "\"data\": {" +
                                                "\"enable\":true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus radMaritalStatusDivorced\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\":\"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus radMaritalStatusWidowed\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
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
        }
    }

    @And("^user types (.*) as partner\'s age")
    public void user_types_partner_age(String age) throws IOException {

        if ( quoteData.getBorrowerNumber().equals("2")) {
            quoteData.setPartnerAge(age);
            quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlAge:c:w:pnlAge2:c:w:txtAge2:tb", age);

            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
//                            put(
//                                "data",
//                                "{" +
//                                    "\"widgets\": [" +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus\"," +
//                                            "\"data\": {" +
//                                                "\"visible\": true" +
//                                            "}," +
//                                            "\"delta\": 60," +
//                                            "\"visibleEvent\": \"show\"" +
//                                        "}," +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus\"," +
//                                            "\"data\": {" +
//                                                "\"enable\": true" +
//                                            "}" +
//                                        "}," +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus cmbMaritalStatus\"," +
//                                            "\"data\": {" +
//                                                "\"enable\": true" +
//                                            "}" +
//                                        "}," +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus txtTotalDependents\"," +
//                                            "\"data\": {" +
//                                                "\"enable\": true" +
//                                            "}" +
//                                        "}" +
//                                    "]" +
//                                "}"
//                            );

                            put(
                                "data",
                                "{" +
                                    "\"widgets\": [" +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus\"," +
                                            "\"data\": {" +
                                                "\"visible\": true" +
                                            "}," +
                                            "\"delta\": 200," +
                                            "\"visibleEvent\": \"show\"" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus radMaritalStatusSingle\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus radMaritalStatusSeparated\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus radMaritalStatusMarried\"," +
                                            "\"data\": {" +
                                                "\"enable\":true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus radMaritalStatusDivorced\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\":\"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus radMaritalStatusWidowed\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus rgrMaritalStatus\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMaritalStatus\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
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
        }
    }

    @And("^user selects (single|separated|married/civil partner\\(s\\)|divorced/dissolved civil partnership|widowed) as marital status$")
    public void user_selects_his_marital_status(String maritalStatus) throws IOException {

        String maritalStatusValue = "";
        switch (maritalStatus) {
            case "single":
//                maritalStatusValue = "SIN";
                maritalStatusValue = "radMaritalStatusSingle";
                break;
            case "separated":
//                maritalStatusValue = "SEP";
                maritalStatusValue = "radMaritalStatusSeparated";
                break;
            case "married / civil partner":
//                maritalStatusValue = "MAR";
                maritalStatusValue = "radMaritalStatusMarried";
                break;
            case "divorced / dissolved civil partnership":
//                maritalStatusValue = "DIV";
                maritalStatusValue = "radMaritalStatusDivorced";
                break;
            case "widowed":
                maritalStatusValue = "WID";
                maritalStatusValue = "radMaritalStatusWidowed";
                break;
        }
        quoteData.setBorrowerMaritalStatus(maritalStatusValue);
//        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlMaritalStatus:c:w:cmbMaritalStatus:combobox",maritalStatusValue);
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlMaritalStatus:c:w:rgrMaritalStatus:rg", maritalStatusValue);

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
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
                                        "\"widget\": \"pnlBuildYourQuotation pnlTotalDependents\"," +
                                        "\"data\": {" +
                                            "\"visible\": true" +
                                        "}," +
                                        "\"delta\": 90," +
                                        "\"visibleEvent\": \"show\"" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlTotalDependents txtTotalDependents\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlTotalDependents\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlTotalDependents lblTotalDependents\"," +
                                        "\"delta\": 2" +
                                    "}" +
                                "]" +
                            "}"
                        );
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    @And("^user types (.*) as total of dependents$")
    public void user_types_his_total_of_dependents(String totalDependents) throws IOException {

        if ( StringUtils.isEmpty(totalDependents) )
            totalDependents = "0";

        quoteData.setBorrowerTotalDependents(totalDependents);
//        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlMaritalStatus:c:w:txtTotalDependents:tb",totalDependents);
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlTotalDependents:c:w:txtTotalDependents:tb", totalDependents);

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
//                        put(
//                            "data",
//                            "{" +
//                                "\"widgets\": [" +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlIncome1\"," +
//                                        "\"data\": {" +
//                                            "\"visible\": true" +
//                                        "}," +
//                                        "\"delta\": 70," +
//                                        "\"visibleEvent\": \"show\"" +
//                                    "}," +
//                                    "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlIncome1\"," +
//                                        "\"data\": {" +
//                                        "\"enable\":true" +
//                                        "}" +
//                                    "}," +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlIncome1 cmbIncomeType\"," +
//                                        "\"data\": {" +
//                                            "\"enable\": true" +
//                                        "}" +
//                                    "}," +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlIncome1 txtIncomeType1origValue\"," +
//                                        "\"data\": {" +
//                                            "\"enable\": true" +
//                                        "}" +
//                                    "}," +
//                                    // necessary ??
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount\"," +
//                                        "\"data\": {" +
//                                            "\"enable\": true" +
//                                        "}" +
//                                    "}," +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount crbIncomeAmount\"," +
//                                        "\"data\": {" +
//                                            "\"enable\": true" +
//                                        "}" +
//                                    "}" +
//                                "]" +
//                            "}"
//                        );

                        put(
                            "data",
                            "{" +
                                "\"widgets\": [" +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1\"," +
                                        "\"data\": {" +
                                            "\"visible\": true" +
                                        "}," +
                                        "\"delta\": 1," +
                                        "\"visibleEvent\": \"show\"" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncome1 txtIncomeType1origValue\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncome1 rgrIncomeTypeB1 radIncomeTypePaye\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncome1 rgrIncomeTypeB1 radIncomeTypeSelfEmployed\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncome1 rgrIncomeTypeB1 radIncomeTypeCivilServant\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncome1 rgrIncomeTypeB1\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncome1\"," +
                                        "\"data\": {" +
                                            "\"enable\":true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncomeAmountB1 crbIncomeAmount\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncomeAmountB1\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
                                        "}" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncome1\"," +
                                        "\"data\": {" +
                                            "\"visible\": true" +
                                        "}," +
                                        "\"delta\": 130," +
                                        "\"visibleEvent\": \"show\"" +
                                    "}," +
                                    "{" +
                                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncome1\"," +
                                        "\"data\": {" +
                                            "\"enable\": true" +
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
    }

    @And("^user selects (an employee|self employed|a civil servant) as income type$")
    public void user_selects_his_income_type(String incomeType) throws IOException {

        String incomeTypeValue = "";
        switch (incomeType) {
            case "an employee":
//                incomeTypeValue = "PAY";
                incomeTypeValue = "radIncomeTypePaye";
                break;
            case "a civil servant":
//                incomeTypeValue = "CIV";
                incomeTypeValue = "radIncomeTypeCivilServant";
                break;
            case "self employed":
//                incomeTypeValue = "SEL";
                incomeTypeValue = "radIncomeTypeSelfEmployed";
                break;
//            case "not in paid work just now":
//                incomeTypeValue = "UNE";
//                break;
        }
        quoteData.setBorrowerIncomeType(incomeType);
//        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlIncome1:c:w:txtIncomeType1origValue:tb", incomeTypeValue);
//        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlIncome1:c:w:cmbIncomeType:combobox", incomeTypeValue);
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlEmploymentAndIncome1:c:w:pnlIncome1:c:w:txtIncomeType1origValue:tb" , "");
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlEmploymentAndIncome1:c:w:pnlIncome1:c:w:rgrIncomeTypeB1:rg", incomeTypeValue);

        Map<String, String> parameterPost = new LinkedHashMap<>();
//        if ( quoteData.getBorrowerNumber().equals("1") && incomeTypeValue.equals("UNE") ) {
//
//            parameterPost.put(
//                "data",
//                "{" +
//                    "\"widgets\": [" +
//                        // if lines 521 - 532 are commented, lines 590-602 may not be necessary
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"visible\": false" +
//                            "}," +
//                            "\"visibleEvent\": \"hide\"" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"enable\": false" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount crbIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"enable\": false" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
//                            "\"data\": {" +
//                                "\"visible\": true" +
//                            "}," +
//                            "\"delta\": 80," +
//                            "\"visibleEvent\": \"show\"" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments crbMonthlyCreditCommitments\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments txtMonthlyComOrigValue\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}" +
//                    "]" +
//                "}"
//            );
//        } else if ( quoteData.getBorrowerNumber().equals("2") && incomeTypeValue.equals("UNE") ) {
//
//            parameterPost.put(
//                "data",
//                "{" +
//                    "\"widgets\": [" +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"visible\": true" +
//                            "}," +
//                            "\"visibleEvent\": \"hide\"" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"enable\": false" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount crbIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"enable\": false" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome2\"," +
//                            "\"data\": {" +
//                                "\"visible\": true" +
//                            "}," +
//                            "\"delta\": 80," +
//                            "\"visibleEvent\": \"show\"" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome2\"," +
//                            "\"data\": {" +
//                            "\"enable\": true" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome2 cmbIncomeType\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome2 txtIncomeType2origValue\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}," +
//                        // maybe not necessary
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome2 pnlIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome2 pnlIncomeAmount crbIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}" +
//                    "]" +
//                "}"
//            );
//
//        } else if ( quoteData.getBorrowerNumber().equals("1") && !incomeTypeValue.equals("UNE") ) {
//
//            parameterPost.put(
//                "data",
//                "{" +
//                    "\"widgets\": [" +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"visible\": true" +
//                            "}," +
//                            "\"visibleEvent\": \"show\"" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}," +
//                        "{" +
//                            "\"widget\": \"pnlBuildYourQuotation pnlIncome1 pnlIncomeAmount crbIncomeAmount\"," +
//                            "\"data\": {" +
//                                "\"enable\": true" +
//                            "}" +
//                        "}" +
//                    "]" +
//                "}"
//            );
//
//        } else {
//            log.error("Houston, we have a problem when handling Borrower income type !");
//        }

        parameterPost.put(
            "data",
            "{" +
                "\"widgets\": [" +
                    "{" +
                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncomeAmountB1\"," +
                        "\"data\": {" +
                            "\"visible\":true" +
                        "}," +
                        "\"delta\": 90," +
                        "\"visibleEvent\": \"show\"" +
                    "}," +
                    "{" +
                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncomeAmountB1\"," +
                        "\"data\": {" +
                            "\"enable\": true" +
                        "}" +
                    "}," +
                    "{" +
                        "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome1 pnlIncomeAmountB1 lblIncomeAmount1B1\"," +
                        "\"delta\": 2" +
                    "}" +
                "]" +
            "}"
        );

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                parameterPost,
                localContext,
                CONSUME_QUIETLY
        );
    }

    @And("^user types (.*) as income amount$")
    public void user_types_his_income_amount(String incomeAmount) throws IOException {

        quoteData.setBorrowerIncomeAmount(incomeAmount);
//        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlIncome1:c:w:pnlIncomeAmount:c:w:crbIncomeAmount:tb", incomeAmount);
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlEmploymentAndIncome1:c:w:pnlIncomeAmountB1:c:w:crbIncomeAmount:tb", incomeAmount);

        Map<String, String> parameterPost = new LinkedHashMap<>();
//        switch (quoteData.getBorrowerNumber()) {
//            case "2":
//
//                parameterPost.put(
//                    "data",
//                    "{" +
//                        "\"widgets\": [" +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2\"," +
//                                "\"data\": {" +
//                                    "\"visible\": true" +
//                                "}," +
//                                "\"delta\":80," +
//                                "\"visibleEvent\":\"show\"" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2 cmbIncomeType\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2 txtIncomeType2origValue\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2 pnlIncomeAmount crbIncomeAmount\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2 pnlIncomeAmount\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}" +
//                        "]" +
//                    "}"
//                );
//                break;
//            case "1":
//
//                parameterPost.put(
//                    "data",
//                    "{" +
//                        "\"widgets\": [" +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
//                                "\"data\": {" +
//                                    "\"visible\": true" +
//                                "}," +
//                                "\"delta\": 80," +
//                                "\"visibleEvent\": \"show\"" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments crbMonthlyCreditCommitments\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments txtMonthlyComOrigValue\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}" +
//                        "]" +
//                    "}"
//                );
//                break;
//            default:
//                log.error("Houston, we have a problem while handling Borrower Income Amount !");
//                break;
//        }

        if ( quoteData.getBorrowerNumber().equals("2")) {
            parameterPost.put(
                "data",
                "{\"widgets\":[{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2\",\"data\":{\"visible\":true},\"delta\":240,\"visibleEvent\":\"show\"},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2\",\"data\":{\"visible\":false},\"delta\":-70,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2\",\"data\":{\"enable\":false}}]}"
            );
        } else {
            parameterPost.put(
                    "data",
                    "{" +
                        "\"widgets\": [" +
                            "{" +
                                "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2 crbIncomeAmount\"," +
                                "\"data\": {" +
                                    "\"enable\": false" +
                                "}" +
                            "}," +
                            "{" +
                                "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2\"," +
                                "\"data\": {" +
                                    "\"enable\": false" +
                                "}" +
                            "}" +
                            "," +
                            "{" +
                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
                            "\"data\": {" +
                            "\"visible\": true" +
                            "}," +
                            "\"delta\": 70," +
                            "\"visibleEvent\": \"show\"" +
                            "}," +
                            "{" +
                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments txtMonthlyComOrigValue\"," +
                            "\"data\": {" +
                            "\"enable\": true" +
                            "}" +
                            "}," +
                            "{" +
                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments crbMonthlyCreditCommitments\"," +
                            "\"data\": {" +
                            "\"enable\": true" +
                            "}" +
                            "}," +
                            "{" +
                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
                            "\"data\": {" +
                            "\"enable\": true" +
                            "}" +
                            "}," +
                            "{" +
                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments lblMonthlyCreditCommitments2\"," +
                            "\"delta\": 2" +
                            "}" +


                        "]" +
                    "}"
            );
        }

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                parameterPost,
                localContext,
                CONSUME_QUIETLY
        );
    }

    @And("^user selects (an employee|a civil servant|self employed) as partner\'s income type$")
    public void user_selects_partner_income_type(String incomeType) throws IOException {

        if ( quoteData.getBorrowerNumber().equals("2") ) {

            String incomeTypeValue = "";
            switch (incomeType) {
                case "an employee":
//                incomeTypeValue = "PAY";
                    incomeTypeValue = "radIncomeTypePaye";
                    break;
                case "a civil servant":
//                incomeTypeValue = "CIV";
                    incomeTypeValue = "radIncomeTypeCivilServant";
                    break;
                case "self employed":
//                incomeTypeValue = "SEL";
                    incomeTypeValue = "radIncomeTypeSelfEmployed";
                    break;
//            case "not in paid work just now":
//                incomeTypeValue = "UNE";
//                break;
            }
//            quoteData.setPartnerIncomeType(incomeType);
//            if (!incomeTypeValue.equals("UNE")) {
//                quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlIncome2:c:w:txtIncomeType2origValue:tb", incomeTypeValue);
//            }
//            else {
//                quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlIncome2:c:w:txtIncomeType2origValue:tb", null);
//            }
//            quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlIncome2:c:w:cmbIncomeType:combobox", incomeTypeValue);

//            quoteData.put("root:c:w:pnlBuildYourQuotation:c:w:pnlEmploymentAndIncome2:c:w:pnlIncome2:c:w:txtIncomeType2origValue:tb", incomeTypeValue);
//            quoteData.put("root:c:w:pnlBuildYourQuotation:c:w:pnlEmploymentAndIncome2:c:w:pnlIncome2:c:w:rgrIncomeTypeB2:rg", incomeTypeValue);
            quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlEmploymentAndIncome2:c:w:pnlIncome2:c:w:txtIncomeType2origValue:tb", "");
            quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlEmploymentAndIncome2:c:w:pnlIncome2:c:w:rgrIncomeTypeB2:rg", incomeTypeValue);

            Map<String, String> parameterPost = new LinkedHashMap<>();
//            if (incomeTypeValue.equals("UNE")) {
//                parameterPost.put(
//                    "data",
//                    "{" +
//                        "\"widgets\": [" +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2 pnlIncomeAmount\"," +
//                                "\"data\": {" +
//                                    "\"visible\": false" +
//                                "}," +
//                                "\"visibleEvent\": \"hide\"" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2 pnlIncomeAmount\"," +
//                                "\"data\": {" +
//                                    "\"enable\": false" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
//                                "\"data\": {" +
//                                    "\"visible\": true" +
//                                "}," +
//                                "\"delta\": 80," +
//                                "\"visibleEvent\": \"show\"" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments crbMonthlyCreditCommitments\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments txtMonthlyComOrigValue\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}" +
//                        "]" +
//                    "}"
//                );
//            } else if (!incomeTypeValue.equals("UNE")) {
//                parameterPost.put(
//                    "data",
//                    "{" +
//                        "\"widgets\": [" +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2 pnlIncomeAmount\"," +
//                                "\"data\": {" +
//                                    "\"visible\": true" +
//                                "}," +
//                                "\"visibleEvent\": \"show\"" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2 pnlIncomeAmount\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}," +
//                            "{" +
//                                "\"widget\": \"pnlBuildYourQuotation pnlIncome2 pnlIncomeAmount crbIncomeAmount\"," +
//                                "\"data\": {" +
//                                    "\"enable\": true" +
//                                "}" +
//                            "}" +
//                        "]" +
//                    "}"
//                );
//            } else {
//                log.error("Houston, we have a problem while handling Coapplicant Income Type !");
//            }

            parameterPost.put(
                "data",
                "{" +
                    "\"widgets\": [" +
                        "{" +
                            "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2\"," +
                            "\"data\": {" +
                                "\"visible\": true" +
                            "}," +
                            "\"delta\": 70," +
                            "\"visibleEvent\": \"show\"" +
                        "}," +
                            "{" +
                                "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2 crbIncomeAmount\"," +
                                "\"data\": {" +
                                    "\"enable\": true" +
                                "}" +
                            "}," +
                        "{" +
                            "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2\"," +
                            "\"data\": {" +
                                "\"enable\": true" +
                            "}" +
                        "}," +
                        "{" +
                            "\"widget\": \"pnlBuildYourQuotation pnlEmploymentAndIncome2 pnlIncomeAmountB2 lblIncomeAmount2B2\"," +
                            "\"delta\": 2" +
                        "}" +
                    "]" +
                "}"
            );

            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    parameterPost,
                    localContext,
                    CONSUME_QUIETLY
            );
        }
    }

    @And("^user types (.*) as partner\'s income amount$")
    public void user_types_partner_income_amount(String incomeAmount) throws IOException {

//        if ( quoteData.getBorrowerNumber().equals("2") && quoteData.getPartnerIncomeType().equals("not in paid work just now")) {
        if ( quoteData.getBorrowerNumber().equals("2")) {
            quoteData.setPartnerIncomeAmount(incomeAmount);
//            quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlIncome2:c:w:pnlIncomeAmount:c:w:crbIncomeAmount:tb", incomeAmount);
//            quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlIncome2:c:w:txtIncomeType2origValue:tb", null);
            quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlEmploymentAndIncome2:c:w:pnlIncomeAmountB2:c:w:crbIncomeAmount:tb", incomeAmount);

            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
//                            put(
//                                "data",
//                                "{" +
//                                    "\"widgets\": [" +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
//                                            "\"data\": {" +
//                                                "\"visible\": true" +
//                                            "}," +
//                                            "\"delta\": 80," +
//                                            "\"visibleEvent\": \"show\"" +
//                                        "}," +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
//                                            "\"data\": {" +
//                                                "\"enable\": true" +
//                                            "}" +
//                                        "}," +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments crbMonthlyCreditCommitments\"," +
//                                            "\"data\": {" +
//                                                "\"enable\": true" +
//                                            "}" +
//                                        "}," +
//                                        "{" +
//                                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments txtMonthlyComOrigValue\"," +
//                                            "\"data\": {" +
//                                                "\"enable\": true" +
//                                            "}" +
//                                        "}" +
//                                    "]" +
//                                "}"
//                            );

                            put(
                                "data",
                                "{" +
                                    "\"widgets\": [" +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
                                            "\"data\": {" +
                                                "\"visible\": true" +
                                            "}," +
                                            "\"delta\": 70," +
                                            "\"visibleEvent\": \"show\"" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments txtMonthlyComOrigValue\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments crbMonthlyCreditCommitments\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments\"," +
                                            "\"data\": {" +
                                                "\"enable\": true" +
                                            "}" +
                                        "}," +
                                        "{" +
                                            "\"widget\": \"pnlBuildYourQuotation pnlMonthlyCreditCommitments lblMonthlyCreditCommitments2\"," +
                                            "\"delta\": 2" +
                                        "}" +
                                    "]" +
                                "}"
                            );
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
        } else {
//            quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlIncome2:c:w:pnlIncomeAmount:c:w:crbIncomeAmount:tb", incomeAmount);
            quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlEmploymentAndIncome2:c:w:pnlIncomeAmountB2:c:w:crbIncomeAmount:tb", incomeAmount);
        }
    }

    @And("^user types (.*) as monthly credit commitments$")
    public void user_types_monthly_credit_commitments(String monthlyCreditCommitments) throws IOException {

        quoteData.setMonthlyCreditCommitments(monthlyCreditCommitments);
//        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlMonthlyCreditCommitments:c:w:crbMonthlyCreditCommitments:tb", monthlyCreditCommitments);
//        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlMonthlyCreditCommitments:c:w:txtMonthlyComOrigValue:tb", monthlyCreditCommitments);
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlMonthlyCreditCommitments:c:w:txtMonthlyComOrigValue:tb", "");
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlMonthlyCreditCommitments:c:w:crbMonthlyCreditCommitments:tb", monthlyCreditCommitments);

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
//                        put(
//                            "data",
//                            "{" +
//                                "\"widgets\": [" +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation btnGetYourQuotation\"," +
//                                        "\"data\": {" +
//                                            "\"visible\": true" +
//                                        "}," +
//                                        "\"visibleEvent\": \"show\"" +
//                                    "}," +
//                                    "{" +
//                                        "\"widget\": \"pnlBuildYourQuotation btnGetYourQuotation\"," +
//                                        "\"data\": {" +
//                                            "\"enable\": true" +
//                                        "}" +
//                                    "}" +
//                                "]" +
//                            "}"
//                        );

                        put(
                            "data",
                            "{\"widgets\":[{\"widget\":\"pnlBuildYourQuotation pnlShowSeparatorAndButton\",\"data\":{\"visible\":true},\"delta\":120,\"visibleEvent\":\"show\"},{\"widget\":\"pnlBuildYourQuotation pnlShowSeparatorAndButton btnGetYourQuotation\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlShowSeparatorAndButton\",\"data\":{\"enable\":true}},{\"widget\":\"pnlBuildYourQuotation pnlShowSeparatorAndButton lblSeparator\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlBuildYourQuotation pnlShowSeparatorAndButton btnGetYourQuotation\",\"data\":{\"visible\":true},\"visibleEvent\":\"show\"},{\"widget\":\"pnlBuildYourQuotation pnlShowSeparatorAndButton btnGetYourQuotation\",\"data\":{\"enable\":true}}]}"
                        );
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    @When("^user clicks \"GET MY QUOTE\"$")
    public void user_clicks_get_my_quote() throws IOException {

        quoteParameters.put("stepToken", "1");
        quoteParameters.put("root:c:w:pnlBuildYourQuotation:c:w:pnlShowSeparatorAndButton:c:w:btnGetYourQuotation:submit", "1");

        String currentResponse = requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlBuildYourQuotation:c:w:pnlShowSeparatorAndButton:c:w:btnGetYourQuotation:submit::IBehaviorListener:0:-1",

                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                quoteParameters,
                localContext,
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(currentResponse);
    }

    @And("^user is(\\s*|n't) eligible to borrow at this time$")
    public void user_is_eligible_to_borrow_at_this_time(String isEligible) throws IOException {

        Document isEligibleDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textIsEligible = isEligibleDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
        Document isEligibleDoc2 = Jsoup.parse(textIsEligible.text());
        String isEligibleText = isEligibleDoc2.select("div[wicketpath=main_c_form_form_root_c_w_pnl-904_c_w_lblNotEligible_l]").text();

        toSkip = (!StringUtils.isEmpty(isEligibleText) && isEligibleText.equals("Sorry, you're not eligible to borrow at this time"));
    }

    @Then("^user could buy a home up to the value of (.*) euros, should pay monthly (.*) euros and should get a minimum deposit value of (.*) euros, for scenario (.*)$")
    public void user_gets(String maxLoanAmount, String monthlyPayment, String minimumDeposit, String testcase) throws IOException {
        user_gets(maxLoanAmount, monthlyPayment, minimumDeposit, "", "", testcase);
    }

    @Then("^user could buy a home up to the value of (.*) euros, should pay monthly (.*) euros and should get a minimum deposit value of (.*) euros, need to pay Government stamp duty of (.*) and a maximum price of (.*), for scenario (.*)$")
    public void user_gets(String maxLoanAmount, String monthlyPayment, String minimumDeposit, String stampDuty, String maxHousePrice, String testcase) throws IOException {

        if ( toSkip )
            return;

        Document affordabilityDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textNodeSubmitQuote = affordabilityDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);

        Document affordabilityDoc2 = Jsoup.parse(textNodeSubmitQuote.text());
        Element maxLoanAndMinimumDepositAndStampDuty = affordabilityDoc2.select("div[wicketpath=main_c_form_form_root_c_w_pnlAffordability_c_w_lblBasedOn_l] > span").first();
        // maxLoan => child 1 -> child 0 remove Euro
        String potentialMaxLoan = maxLoanAndMinimumDepositAndStampDuty.getAllElements().get(1).text().replace("€", "").replace(",", "");
        // minimumDeposit => child 3 -> child 0 + remove ()Euro
        String potentialMinimumDeposit = maxLoanAndMinimumDepositAndStampDuty.getAllElements().get(2).text().replace("€", "").replace(",", "").replace("(", "").replace(")", "");
        // stampDuty => child 5 -> child 0 + remove ()Euro
//        String potentialStampDuty = maxLoanAndMinimumDepositAndStampDuty.getAllElements().get(3).text().replace("€", "").replace("(", "").replace(")", "").replace(",", "");
        // monthPayment => child 0 + remove Euro
        String potentialMonthlyPayment = affordabilityDoc2.select("div[wicketpath=main_c_form_form_root_c_w_pnlAffordability_c_w_pnlValues_c_w_lblMonthlyValue_l]").text().replace("€", "").replace(",", "");
//        String potentialMaxHousePrice = doc2.select("input[name=root:c:w:pnlAffordability:c:w:crbYourFunds:tb]").attr("value").replace(",", "");

        Collection<String> potentialValue = new LinkedList<>();
        assertEquals("potentialMaxLoan can't null or empty", true, !StringUtils.isEmpty(potentialMaxLoan));
        potentialValue.add(new DecimalFormat("###,##0,000.00").format(new Double(potentialMaxLoan)));
        assertEquals("potentialMonthlyPayment can't null or empty", true, !StringUtils.isEmpty(potentialMonthlyPayment));
        potentialValue.add(new DecimalFormat("###,##0,000.00").format(new Double(potentialMonthlyPayment)));
        assertEquals("potentialMinimumDeposit can't null or empty", true, !StringUtils.isEmpty(potentialMinimumDeposit));
        potentialValue.add(new DecimalFormat("###,##0,000.00").format(new Double(potentialMinimumDeposit)));
//        potentialValue.add(potentialStampDuty);
//        potentialValue.add(potentialMaxHousePrice);

        Collection<String> expectedValue = new LinkedList<>();
        assertEquals("maxLoanAmount can't null or empty", true, !StringUtils.isEmpty(maxLoanAmount));
        expectedValue.add(new DecimalFormat("###,##0,000.00").format(new Double(maxLoanAmount)));
        assertEquals("monthlyPayment can't null or empty", true, !StringUtils.isEmpty(monthlyPayment));
        expectedValue.add(new DecimalFormat("###,##0,000.00").format(new Double(monthlyPayment)));
        assertEquals("minimumDeposit can't null or empty", true, !StringUtils.isEmpty(minimumDeposit));
        expectedValue.add(new DecimalFormat("###,##0,000.00").format(new Double(minimumDeposit)));
//        expectedValue.add(new DecimalFormat("0.00").format(new Double("0")));
//        expectedValue.add(new DecimalFormat("0.00").format(new Double("0")));

//        try {
//            try {
//                ApiAllCalQuoteTest test = ApiGetAQuoteStepDef.class.getClassLoader().loadClass("ApiAllCalQuoteTest").getDeclaredField("data2store");
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        log.info("End: expected ..." + expectedValue.toString() + "... potentialValue ..." + potentialValue.toString() + "...");
        if (!toSkip)
            assertEquals("End: expected ..." + expectedValue.toString() + "... potentialValue ..." + potentialValue.toString() + "...", true, CollectionUtils.isEqualCollection(expectedValue, potentialValue));

    }


    @Then("^user could buy a home up to the value of (.*) euros$")
    public void user_could_build_a_home_up_to_value(String maxLoanAmount) {
        if ( !toSkip ) {
            assertThat("Expected max loan amount is incorrect",
                    String.valueOf(0),
                    Is.is(maxLoanAmount)
            );
        }
    }

    @Then("^user should pay monthly (.*) euros$")
    public void user_should_pay_monthly(String monthlyPayment) {
        if ( !toSkip ) {
            assertThat("Expected monthly payment is incorrect",
                    String.valueOf(0),
                    Is.is(monthlyPayment)
            );
        }
    }

    @Then("^user should get a minimum deposit value of (.*) euros$")
    public void user_should_get_minimum_deposit_of(String minimumDeposit) {
        if ( !toSkip ) {
            assertThat("Expected minimum  deposit is incorrect",
                    String.valueOf(0),
                    Is.is(minimumDeposit)
            );
        }
    }

    @And("^borrower invites a co-applicant$")
    public void borrower_invites_coapplicant(Map<String, String> coapplicantDataMap) throws IOException {

        // StartTask
        borrower_clicks_start_task();

        // Invite Coapplicant
        requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnCoapplicantAdd:cancel::IBehaviorListener:0:&amp;stepToken=2",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml;charset=UTF-8");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnInvite:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml;charset=UTF-8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:txtFirstName:tb", "Anthony-Coapplicant");
                        put("root:c:w:txtEmail:tb", "anthony.mottot.test" + System.getProperty("timestamp") + "@abakus.com");
                        put("stepToken", "1");
                        put("root:c:w:btnInvite:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMainSingleApp:c:w:btnBackToDashboard2:cancel::IBehaviorListener:0:&amp;stepToken=2",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml;charset=UTF-8");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    private void borrower_clicks_start_task() throws IOException {
        // StartTask
        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:embeddedFormWrapper:embeddedForm:2:form:root:c:w:pnlCoapplicant:c:w:btnAction:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                        put("root:c:w:pnlCoapplicant:c:w:btnAction:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    @And("^borrower goes solo$")
    public void borrower_goes_solo() throws IOException {

        // StartTask
        borrower_clicks_start_task();

        // Go Solo
        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:embeddedFormWrapper:embeddedForm:2:form:root:c:w:pnlCoapplicant:c:w:btnStayAlone:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "2");
                        put("root:c:w:pnlCoapplicant:c:w:btnStayAlone:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    @And("^user clicks \"Review and Submit\"$")
    public void user_clicks_review_and_submit() throws IOException {

        // TODO to check application status
        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnl-YouAreReadyToSubmit:c:w:btn-ReviewAndSubmit:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:txtWorkItemViewTaskId:tb", null);
                        put("stepToken", "1");
                        put("root:c:w:pnl-YouAreReadyToSubmit:c:w:btn-ReviewAndSubmit:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
        // TODO to check application status
    }

    @And("^user clicks \"Submit your application\"$")
    public void user_clicks_submit_your_application() throws IOException {


        // TODO to check
        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlContent:c:w:btnSubmitApplication:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlContent:c:w:txaAddComment:textarea", null);
                        put("stepToken", "1");
                        put("root:c:w:pnlContent:c:w:btnSubmitApplication:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        // TODO to parse the response to validate the final page
    }

    @And("^user checks \"Distance Marketing\"$")
    public void user_checks_DistanceMarketing() throws IOException {
        requestHttpPost(
                httpClient,
                // TODO to check even we failed here ... we are still able to complete Phase 1
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlContent:c:w:btnSubmitApplication:submit::IBehaviorListener:0:",
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnSubmitApplication:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlContent:c:w:txaAddComment:textarea", null);
                        put("stepToken", "1");
                        put("root:c:w:pnlContent:c:w:btnSubmitApplication:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    @And("^user checks \"Statutory\"$")
    public void user_checks_Statutory() {
//        borrowerHomePage.checkStatutory();
    }

    @And("^user checks \"Declaration\"$")
    public void user_checks_Declaration() {
//        borrowerHomePage.checkDeclaration();
    }

    @And("^finally, user clicks \"Submit Application\"$")
    public void user_clicks_submit_application_final() throws IOException {

        // TODO to check
        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
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
                                "\"widgets\":" +
                                "[" +
                                    "{" +
                                        "\"widget\": \"btnSubmitApplication\"," +
                                        "\"data\":" +
                                        "{" +
                                            "\"enable\":true" +
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

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnSubmitApplication:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:txtLoanAmount:tb", null);
                        put("root:c:w:pnlBeforeSubmit:c:w:chkDistanceMarketing:checkbox", "on");
                        put("root:c:w:pnlBeforeSubmit:c:w:chkStatutory:checkbox", "on");
                        put("root:c:w:pnlBeforeSubmit:c:w:chkDeclarations:checkbox", "on");
                        put("stepToken", "2");
                        put("root:c:w:btnSubmitApplication:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }
}
