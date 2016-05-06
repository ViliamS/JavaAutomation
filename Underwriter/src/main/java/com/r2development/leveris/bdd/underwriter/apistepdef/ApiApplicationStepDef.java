package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IAUnderwriterHttpContext;
import com.r2development.leveris.di.User;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;
import static org.junit.Assert.assertEquals;

@Singleton
public class ApiApplicationStepDef extends ApiOpoqoUnderwriterStepDef {

    private static final Log log = LogFactory.getLog(ApiOpoqoUnderwriterStepDef.class.getName());

    @Inject
    User user;
    @Inject
    IAUnderwriterHttpContext localContext;

    @When("^(Operator Underwriter) looks for these information$")
    public void user_looks_for_these_information(String operator, Map<String, String> criteria) throws IOException, InterruptedException {

//        Map<String, String
//        if ( user == null ) {
//            System.out.println(user.getFirstName());
//            final String firstName = user.getFirstName().split(" ")[0];
//        }
//        else {

//        }

        // criteria
        // assign : ALL
        // status : AllActive
        // search : automation ...
        // applicationId : \d+

//        if ( criteria.get("assigned") == null )
//            criteria.replace("assigned", "ALL");
//        if ( criteria.get("status") == null )
//            criteria.replace("status", "AllActive" );
//
//        if ( criteria.get("search") == null )
//            criteria.replace("search", "automation" );

        if ( user != null ) {
//            criteria.replace("search", user.getFirstName().split(" ")[0]);
            criteria = new LinkedHashMap<String, String>() {
                {
                    put("assign", "ALL");
                    put("status", "AllActive");
                    put("search", user.getFirstName());
                }
            };
        }

        final String firstName = criteria.get("search");

//        if ( criteria.get("applicationId") != null ) {
//            criteria.put("applicationId", "");
//        }
//        else if ( Integer.parseInt(criteria.get("applicationId")) )
//            criteria.put("applicationId", "");

//        Thread.sleep(20000);

        Document doc = Jsoup.parse(httpResponse.getHttpResponse());
        String linkSearch = doc.select("a[id~=submit]").select("a[wicketpath=singleFlow_p_c_form_form_root_c_w_pnlSort_c_w_btnSearch_submit]").attr("onclick");
        Pattern pLinkSearch = Pattern.compile("(;jsessionid=.*)&");
//        Pattern pLinkSearch = Pattern.compile("\\?(wicket:inteface=.*IBehaviorListener:0:)&");
        Matcher mLinkSearch = pLinkSearch.matcher(linkSearch);

        String wicketInterfaceLinkSearch = null;
        while(mLinkSearch.find()) {
            wicketInterfaceLinkSearch = mLinkSearch.group(1);
        }
        final String finalWicketInterfaceLinkSearch = wicketInterfaceLinkSearch;

        String underwriterSearchResult = requestHttpPost(
                httpClient,
//                "http://dv2app.opoqodev.com/stable-underwriter/form.2?wicket:interface=:2:singleFlow:p:c:form:form:root:c:w:pnlSort:c:w:btnSearch:submit::IBehaviorListener:0:",
//                "http://dv2app.opoqodev.com/stable-underwriter/form.2?wicket:interface=:2:singleFlow:p:c:form:form:root:c:w:btnSearch:submit::IBehaviorListener:0:",
                System.getProperty("underwriter") + "/form.2" + finalWicketInterfaceLinkSearch,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        // put("root:c:w:cmbAssignedApplication:combobox", criteria.get("All"));
                        put("root:c:w:cmbAssignedApplication:combobox", "ALL"); // automation
                        put("root:c:w:cmbCase:combobox", "CoLoanApplication");
                        put("root:c:w:pnlStatusColoan:c:w:cmbStatusFilter:combobox", "AllActive");
                        put("root:c:w:pnl-adv-search:c:w:txtSearch:tb", firstName);
                        put("root:c:w:pnl-adv-search:c:w:txt-application-id:tb", "");
                        put("stepToken", "1");
                        put("root:c:w:btnSearch:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(underwriterSearchResult);

    }

    @When("^(Operator Underwriter) opens the application of the customer$")
    public void user_opens_the_customer_application(String operator) throws IOException {
        Document underwriterHomeSearchResultDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textNodeUnderwriterHomeSearchResult = underwriterHomeSearchResultDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        TextNode textNodeUnderwriterHomeSearchResult = underwriterHomeSearchResultDoc.select("div[id~=pnlApplication]").first().textNodes().get(0);
        Document underwriterHomeSearchResultDoc2 = Jsoup.parse(textNodeUnderwriterHomeSearchResult.text());
        Elements applicationList = underwriterHomeSearchResultDoc2.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication$]");
//        Elements applicationList = underwriterHomeSearchResultDoc.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication$]");
//        Elements applicationList = underwriterHomeSearchResultDoc.select("div[id~=^pnlApplication][data-path*=pnlApplication]");
//        Elements potentialApplication = underwriterHomeSearchResultDoc2.select("div[id~=rptApplication] > div[id~=pnlApplication] div[ ").div[wicketpath~=singleFlow_p_c_form_form_root_c_w_rptApplicationList_c_rows_(\\d+)_item_pnlApplication_c_w_lbl-application-id_l]");

        List<Element> automationApplication = new LinkedList<>();
        for ( Element currentElement : applicationList) {
//            Elements elementApplicationFirstName = currentElement.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_lblName$]:contains(AUTOMATIONDBUI20160204190248193)");
            Elements elementApplicationFirstName = null;
            if ( user != null )
                elementApplicationFirstName = currentElement.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_lblName$]:contains(" + user.getFirstName() +")");
//            else
//                elementApplicationFirstName = currentElement.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_lblName$]:contains(" + name +")");

            if ( elementApplicationFirstName.size() == 1) {
                System.out.println(elementApplicationFirstName.text());
                automationApplication.add(currentElement);
            }

            Elements elementApplicationId = currentElement.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_lbl-application-id$]:contains(4148)");
            if ( elementApplicationId.size() == 1) {
                System.out.println(elementApplicationId.text());
//                automationApplication.add(currentElement);
            }
        }
        assertEquals("We should have only one element item", 1, automationApplication.size());

        String startLink = automationApplication.get(0).select("a[wicketpath~=singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_btnStart_submit]").attr("onclick");
//        Pattern pStartLink = Pattern.compile(".*\\[([0-9]+),[0-9]+,\\\\'\\?(wicket:interface=[:a-zA-Z0-9]*)&.*");
        Pattern pStartLink = Pattern.compile(".*\\[([0-9]+),[0-9]+,\\\\'\\?(wicket:interface=[:a-zA-Z0-9]*)&.*");
        Matcher mStartLink = pStartLink.matcher(startLink);
        String wicketStartLink = null;
        while (mStartLink.find()) {
            wicketStartLink = mStartLink.group(2);
        }

        String applicationAutomation = requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
                System.getProperty("underwriter") + "/form.2?" + wicketStartLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                new LinkedHashMap<String, String>() {},
                localContext.getHttpContext(),
                false
        );
        Document applicationResult = Jsoup.parse(applicationAutomation);

        jsoupContainer.put("workflow", applicationResult.select("div[wicketpath=multiFlow_panels_0]"));
        jsoupContainer.put("finance", applicationResult.select("div[wicketpath=multiFlow_panels_1]"));
        jsoupContainer.put("loanOffer", applicationResult.select("div[wicketpath=multiFlow_panels_2]"));
        jsoupContainer.put("form", applicationResult.select("div[wicketpath=multiFlow_panels_3]"));
        jsoupContainer.put("documents", applicationResult.select("div[wicketpath=multiFlow_panels_4]"));
        jsoupContainer.put("documents2", applicationResult.select("div[wicketpath=multiFlow_panels_5]"));
        jsoupContainer.put("notes", applicationResult.select("div[wicketpath=multiFlow_panels_6]"));
        jsoupContainer.put("risk", applicationResult.select("div[wicketpath=multiFlow_panels_7]"));
        jsoupContainer.put("updateHistory", applicationResult.select("div[wicketpath=multiFlow_panels_8]"));
    }

    @When("^(Operator Underwriter) opens the application of the customer (AUTOMATION.*)$")
    public void user_opens_the_customer_application(String operator, String name) throws IOException {
        Document underwriterSearchResultDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textNodeUnderwriterHomeSearchResult = underwriterSearchResultDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        TextNode textNodeUnderwriterHomeSearchResult = underwriterHomeSearchResultDoc.select("div[id~=pnlApplication]").first().textNodes().get(0);
        Document underwriterHomeSearchResultDoc2 = Jsoup.parse(textNodeUnderwriterHomeSearchResult.text());
        Elements applicationList = underwriterHomeSearchResultDoc2.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication$]");
//        Elements applicationList = underwriterHomeSearchResultDoc.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication$]");
//        Elements applicationList = underwriterHomeSearchResultDoc.select("div[id~=^pnlApplication][data-path*=pnlApplication]");
//        Elements potentialApplication = underwriterHomeSearchResultDoc2.select("div[id~=rptApplication] > div[id~=pnlApplication] div[ ").div[wicketpath~=singleFlow_p_c_form_form_root_c_w_rptApplicationList_c_rows_(\\d+)_item_pnlApplication_c_w_lbl-application-id_l]");

        List<Element> automationApplication = new LinkedList<>();
        for ( Element currentElement : applicationList) {
//            Elements elementApplicationFirstName = currentElement.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_lblName$]:contains(AUTOMATIONDBUI20160204190248193)");
            Elements elementApplicationFirstName = null;
            if ( user != null )
                elementApplicationFirstName = currentElement.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_lblName$]:contains(" + user.getFirstName() +")");
            else
                elementApplicationFirstName = currentElement.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_lblName$]:contains(" + name +")");

            if ( elementApplicationFirstName.size() == 1) {
                System.out.println(elementApplicationFirstName.text());
                automationApplication.add(currentElement);
                break;
            }

            Elements elementApplicationId = currentElement.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_lbl-application-id$]:contains(4148)");
            if ( elementApplicationId.size() == 1) {
                System.out.println(elementApplicationId.text());
//                automationApplication.add(currentElement);
            }
        }
        assertEquals("We should have only one element item", 1, automationApplication.size());

        String startLink = automationApplication.get(0).select("a[wicketpath~=singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_btnStart_submit]").attr("onclick");
//        Pattern pStartLink = Pattern.compile(".*\\[([0-9]+),[0-9]+,\\\\'\\?(wicket:interface=[:a-zA-Z0-9]*)&.*");
//        Pattern pStartLink = Pattern.compile(".*\\[([0-9]+),[0-9]+,\\\\'\\?(wicket:interface=[:a-zA-Z0-9]*)&.*");
        Pattern pStartLink = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mStartLink = pStartLink.matcher(startLink);
        String wicketStartLink = null;
        while (mStartLink.find()) {
            wicketStartLink = mStartLink.group(1);
        }

        String applicationAutomation = requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
                System.getProperty("underwriter") + "/form.2?" + wicketStartLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                new LinkedHashMap<String, String>() {},
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        Document applicationResult = Jsoup.parse(applicationAutomation);

        jsoupContainer.put("workflow", applicationResult.select("div[wicketpath=multiFlow_panels_0]"));
        jsoupContainer.put("finance", applicationResult.select("div[wicketpath=multiFlow_panels_1]"));
        jsoupContainer.put("loanOffer", applicationResult.select("div[wicketpath=multiFlow_panels_2]"));
        jsoupContainer.put("form", applicationResult.select("div[wicketpath=multiFlow_panels_3]"));
        jsoupContainer.put("documents", applicationResult.select("div[wicketpath=multiFlow_panels_4]"));
        jsoupContainer.put("documents2", applicationResult.select("div[wicketpath=multiFlow_panels_5]"));
        jsoupContainer.put("notes", applicationResult.select("div[wicketpath=multiFlow_panels_6]"));
        jsoupContainer.put("risk", applicationResult.select("div[wicketpath=multiFlow_panels_7]"));
        jsoupContainer.put("updateHistory", applicationResult.select("div[wicketpath=multiFlow_panels_8]"));
    }
}
