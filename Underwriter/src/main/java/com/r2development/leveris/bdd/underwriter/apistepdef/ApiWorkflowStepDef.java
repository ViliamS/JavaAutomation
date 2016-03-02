package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.google.inject.Singleton;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

/**
 * Created by anthonymottot on 03/02/2016.
 */
@Singleton
public class ApiWorkflowStepDef extends ApiOpoqoUnderwriterStepDef {

    private static final Log log = LogFactory.getLog(ApiWorkflowStepDef.class.getName());

    @When("^user refreshes workflow panel$")
    public void user_refreshes_workflow_panel() throws IOException {

//        Document containerWorkflowDoc = Jsoup.parse(jsoupContainer.get("workflow").html());
        Elements workflowPanel = jsoupContainer.get("workflow");
        String wicketRefreshLink = workflowPanel.select("a[wicketpath=multiFlow_panels_0_p_c_form_form_root_c_w_btnRefresh_cancel").attr("onclick");

        Pattern pWicketRefreshLink = Pattern.compile("\\[[0-9]+,[0-9]+,\\\\'\\?wicket:interface=([:a-zA-Z0-9=]+&stepToken=[0-9]+)&");
        Matcher mWicketRefreshLink = pWicketRefreshLink.matcher(wicketRefreshLink);

        String currentWicketRefreshLink = null;
        while (mWicketRefreshLink.find()) {
            currentWicketRefreshLink = mWicketRefreshLink.group(1);
        }

        String responseRefresh = requestHttpGet(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.5?wicket:interface=:5:multiFlow:panels:0:p:c:form:form:root:c:w:btnRefresh:cancel::IBehaviorListener:0:",
                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=" + currentWicketRefreshLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        TextNode newRefreshResponse = Jsoup.parse(responseRefresh).select("component[id~=p]").first().textNodes().get(0);
        jsoupContainer.replace("workflow", Jsoup.parse(newRefreshResponse.text()).children());
    }

    @When("^user completes stage 1$")
    public void user_competes_stage_1() throws IOException {

//        Document containerWorkflowDoc = Jsoup.parse(jsoupContainer.get("workflow"));
//        TextNode textNodeWorkflowOfferDoc = containerWorkflowDoc.select("component[id~=p]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        Document WorkflowOfferDoc2 = Jsoup.parse(textNodeWorkflowOfferDoc.text());

        String wicketCompleteReviewLink = jsoupContainer.get("workflow").select("a[wicketpath=multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_1_form_root_c_w_pnlStage1_c_w_btnComplete_submit").attr("onclick");
        Pattern pWicketCompleteReviewLink = Pattern.compile("\\[[0-9]+,[0-9]+,\\\\'\\?wicket:interface=([:a-zA-Z0-9]+)&");
        Matcher mWicketCompleteReviewLink = pWicketCompleteReviewLink.matcher(wicketCompleteReviewLink);

        String currentWicketCompleteReviewLink = null;
        while (mWicketCompleteReviewLink.find()) {
            currentWicketCompleteReviewLink = mWicketCompleteReviewLink.group(1);
        }

        String completeStage1Response = requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:0:p:c:form:embeddedFormWrapper:embeddedForm:1:form:root:c:w:pnlStage1:c:w:btnComplete:submit::IBehaviorListener:0:",
                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=" + currentWicketCompleteReviewLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlStage1:c:w:chkCheck1:checkbox", "on");
                        put("root:c:w:pnlStage1:c:w:chkCheck2:checkbox", "on");
                        put("stepToken", "1");
                        put("root:c:w:pnlStage1:c:w:btnComplete:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

//        jsoupContainer.replace("workflow", Jsoup.parse(completeStage1Response).getAllElements());

    }

    @When("^user completes stage 2")
    public void user_completes_stage_2() throws IOException {

//        Document containerWorkflowDoc = Jsoup.parse(jsoupContainer.get("workflow").html());
//        TextNode textNodeWorkflowOfferDoc = containerWorkflowDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        Document WorkflowOfferDoc2 = Jsoup.parse(textNodeWorkflowOfferDoc.text());
        String wicketCompleteReviewLink = jsoupContainer.get("workflow").select("div[wicketpath=multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_2] a[wicketpath=multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_2_form_root_c_w_pnlStage2_c_w_btnOfferCredit_submit]").attr("onclick");
        Pattern pWicketCompleteReviewLink = Pattern.compile("\\[[0-9]+,[0-9]+,\\\\'\\?wicket:interface=([:a-zA-Z0-9]+)&");
        Matcher mWicketCompleteReviewLink = pWicketCompleteReviewLink.matcher(wicketCompleteReviewLink);

        String currentWicketCompleteReviewLink = null;
        while (mWicketCompleteReviewLink.find()) {
            currentWicketCompleteReviewLink = mWicketCompleteReviewLink.group(1);
        }

        String completeStage2Response = requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:0:p:c:form:embeddedFormWrapper:embeddedForm:2:form:root:c:w:pnlStage2:c:w:btnOfferCredit:submit::IBehaviorListener:0:",
                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=" + currentWicketCompleteReviewLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                        put("root:c:w:pnlStage2:c:w:btnOfferCredit:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        jsoupContainer.replace("workflow", Jsoup.parse(completeStage2Response).getAllElements());
    }

}
