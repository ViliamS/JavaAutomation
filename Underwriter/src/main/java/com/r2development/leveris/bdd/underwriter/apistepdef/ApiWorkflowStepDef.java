package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IAUnderwriterHttpContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;

@Singleton
public class ApiWorkflowStepDef extends ApiOpoqoUnderwriterStepDef {

    private static final Log log = LogFactory.getLog(ApiWorkflowStepDef.class.getName());

    @Inject
    IAUnderwriterHttpContext localContext;
    private String refreshWicketInterface = null;

    public ApiWorkflowStepDef() throws IOException {
    }

    @When("^(Operator Underwriter) refreshes Workflow panel$")
    public void user_refreshes_workflow_panel(String operator) throws IOException {

//        Document containerWorkflowDoc = Jsoup.parse(jsoupContainer.get("workflow").html());
        String wicketRefreshLink = jsoupContainer.get("workflow").select("a[wicketpath=multiFlow_panels_0_p_c_form_form_root_c_w_btnRefresh_cancel]").attr("onclick");
        if (StringUtils.isEmpty(wicketRefreshLink) )
            wicketRefreshLink = Jsoup.parse(jsoupContainer.get("workflow").select("component[id~=form]").select("component[encoding~=wicket]").text()).select("a[wicketpath=multiFlow_panels_0_p_c_form_form_root_c_w_btnRefresh_cancel]").attr("onclick");

        Pattern pWicketRefreshLink = Pattern.compile("\\[[0-9]+,[0-9]+,\\\\'\\?wicket:interface=([:a-zA-Z0-9=]+&stepToken=[0-9]+)&");
        Matcher mWicketRefreshLink = pWicketRefreshLink.matcher(wicketRefreshLink);

        String currentWicketRefreshLink = null;
        while (mWicketRefreshLink.find()) {
            currentWicketRefreshLink = mWicketRefreshLink.group(1);
        }

        String responseRefresh = requestHttpGet(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.5?wicket:interface=:5:multiFlow:panels:0:p:c:form:form:root:c:w:btnRefresh:cancel::IBehaviorListener:0:",
                System.getProperty("underwriter.url") + "/form.2?wicket:interface=" + currentWicketRefreshLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        jsoupContainer.replace("workflow", Jsoup.parse(responseRefresh).select("component[id~=form]").select("component[encoding~=wicket]"));
    }

    @When("^(Operator Underwriter) validates Workflow Stage 1$")
    public void user_validates_workflow_stage_1(String operator) throws IOException {

//        Document containerWorkflowDoc = Jsoup.parse(jsoupContainer.get("workflow"));
//        TextNode textNodeWorkflowOfferDoc = containerWorkflowDoc.select("component[id~=p]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        Document WorkflowOfferDoc2 = Jsoup.parse(textNodeWorkflowOfferDoc.text());

        String enableSubmitWicketInterface = jsoupContainer.get("workflow").select("form[id~=form]").select("form[wicketpath~=multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_1_form]").attr("action");

        requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2" + enableSubmitWicketInterface + "-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("data", "{\"widgets\":[{\"widget\":\"pnlStage1 btnCompleteScript\",\"data\":{\"enable\":true}}]}");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );


        String wicketCompleteReviewLink = jsoupContainer.get("workflow").select("a[wicketpath~=multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_1_form_root_c_w_pnlStage1_c_w_btnComplete_submit]").attr("onclick");
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
                System.getProperty("underwriter.url") + "/form.2?wicket:interface=" + currentWicketCompleteReviewLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlStage1:c:w:chkCheck1:checkbox", "on");
                        put("root:c:w:pnlStage1:c:w:chkCheck2:checkbox", "on");
                        put("root:c:w:pnlStage1:c:w:chkCheck3:checkbox", "on");
                        put("stepToken", "1");
                        put("root:c:w:pnlStage1:c:w:btnComplete:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
//        jsoupContainer.replace("workflow", Jsoup.parse(completeStage1Response).select("component[id~=id]").select("component[encoding~=wicket]"));

    }

    @When("^(Operator Underwriter) validates Workflow Stage 2")
    public void user_validates_workflow_stage_2(String operator) throws IOException {

//        Document containerWorkflowDoc = Jsoup.parse(jsoupContainer.get("workflow").html());
//        TextNode textNodeWorkflowOfferDoc = containerWorkflowDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        Document WorkflowOfferDoc2 = Jsoup.parse(textNodeWorkflowOfferDoc.text());
        String wicketCompleteReviewLink = Jsoup.parse(jsoupContainer.get("workflow").select("component[id~=form]").select("component[encoding~=wicket]").text()).select("a[wicketpath=multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_5_form_root_c_w_pnlStage2_c_w_btnOfferCredit_submit]").attr("onclick");
        Pattern pWicketCompleteReviewLink = Pattern.compile("\\?wicket:interface=(.*)&");
        Matcher mWicketCompleteReviewLink = pWicketCompleteReviewLink.matcher(wicketCompleteReviewLink);

        String currentWicketCompleteReviewLink = null;
        while (mWicketCompleteReviewLink.find()) {
            currentWicketCompleteReviewLink = mWicketCompleteReviewLink.group(1);
        }

        String completeStage2Response = requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:0:p:c:form:embeddedFormWrapper:embeddedForm:2:form:root:c:w:pnlStage2:c:w:btnOfferCredit:submit::IBehaviorListener:0:",
                System.getProperty("underwriter.url") + "/form.2?wicket:interface=" + currentWicketCompleteReviewLink,
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
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
//        jsoupContainer.replace("workflow", Jsoup.parse(completeStage2Response).getAllElements());
    }

    @And("^(Operator Underwriter) issues funds$")
    public void user_issues_funds(String operator) throws IOException {

        String wicketIssueFundsLink = Jsoup.parse(jsoupContainer.get("workflow").select("component[id~=form]").select("component[encoding~=wicket]").text()).select("a[wicketpath=multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_12_form_root_c_w_pnlStage4_c_w_btnIssueFunds_dialog]").attr("onclick");
        Pattern pWicketIssueFundsLink = Pattern.compile("\\?wicket:interface=(.*)&");
        Matcher mWicketIssueFundsLink = pWicketIssueFundsLink.matcher(wicketIssueFundsLink);

        String currentWicketIssueFundsLink = null;
        while (mWicketIssueFundsLink.find()) {
            currentWicketIssueFundsLink = mWicketIssueFundsLink.group(1);
        }

        String issueFundsResponse = requestHttpPost(
                httpClient,
    //                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:0:p:c:form:embeddedFormWrapper:embeddedForm:2:form:root:c:w:pnlStage2:c:w:btnOfferCredit:submit::IBehaviorListener:0:",
                System.getProperty("underwriter.url") + "/form.2?wicket:interface=" + currentWicketIssueFundsLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {},
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        String wicketFinalizeIssueFundsLink = Jsoup.parse(Jsoup.parse(issueFundsResponse).select("component[id~=dialog]").select("component[encoding~=wicket]").text()).select("a[wicketpath=multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_12_dialogWrapper_dialog_form_root_c_w_pnlIssueFunds_c_w_btnConfirm_submit]").attr("onclick");
        Pattern pWicketFinalizeIssueFundsLink = Pattern.compile("\\?wicket:interface=(.*)&");
        Matcher mWicketFinalizeIssueFundsLink = pWicketFinalizeIssueFundsLink.matcher(wicketFinalizeIssueFundsLink);

        String currentWicketFinalizeIssueFundsLink = null;
        while (mWicketFinalizeIssueFundsLink.find()) {
            currentWicketFinalizeIssueFundsLink = mWicketFinalizeIssueFundsLink.group(1);
        }

        String finalizeIssueFundsResponse = requestHttpPost(
                httpClient,
                //                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:0:p:c:form:embeddedFormWrapper:embeddedForm:2:form:root:c:w:pnlStage2:c:w:btnOfferCredit:submit::IBehaviorListener:0:",
                System.getProperty("underwriter.url") + "/form.2?wicket:interface=" + currentWicketFinalizeIssueFundsLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlIssueFunds:c:w:txtAccountName:tb", "Tester AutomationA");
                        put("root:c:w:pnlIssueFunds:c:w:txtIban:tb", "10-79-99");
                        put("root:c:w:pnlIssueFunds:c:w:txtBic:tb", "88837491");
                        put("root:c:w:pnlIssueFunds:c:w:crbFinalLoanAmount:tb", "1,000.00");
                        put("stepToken", "1");
                        put("root:c:w:pnlIssueFunds:c:w:btnConfirm:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(finalizeIssueFundsResponse);
//        <a class="content control submit sc-button ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" id="submit159ee" wicketpath="multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_3_dialogWrapper_dialog_form_root_c_w_pnlIssueFunds_c_w_btnConfirm_submit" href="javascript:void(0);" aria-readonly="false" style="line-height: 36px !important;" onclick="if($('#form159ea').valid()&amp;&amp;SC._validate('dialog15892')){SC._submit.apply(this,['form159ea','dialog15892','scAjax.apply(this,[2,0,\'?wicket:interface=:7:multiFlow:panels:0:p:c:form:embeddedFormWrapper:embeddedForm:3:dialogWrapper:dialog:form:root:c:w:pnlIssueFunds:c:w:btnConfirm:submit::IBehaviorListener:0:-1&amp;${scrollPos}\',\'busyIndicator1582d\',0,0,2,\'root:c:w:pnlIssueFunds:c:w:btnConfirm:submit\',\'form159ea\']);']);};return false;" data-readonly="false" data-enabled="true" data-height="40" tabindex="3001" role="button" aria-disabled="false"><span class="ui-button-text" style="line-height: 38px; height: 38px;">Issue Funds</span></a>
//        a id submit wicketpath multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_3_dialogWrapper_dialog_form_root_c_w_pnlIssueFunds_c_w_btnConfirm_submit
//        post
//        :7:multiFlow:panels:0:p:c:form:embeddedFormWrapper:embeddedForm:3:dialogWrapper:dialog:form:root:c:w:pnlIssueFunds:c:w:btnConfirm:submit::IBehaviorListener:0:
//
//        put("root:c:w:pnlIssueFunds:c:w:txtAccountName:tb", "Tester AutomationA");
//        put("root:c:w:pnlIssueFunds:c:w:txtIban:tb", "10-79-99");
//        put("root:c:w:pnlIssueFunds:c:w:txtBic:tb", "88837491");
//        put("root:c:w:pnlIssueFunds:c:w:crbFinalLoanAmount:tb", "1,000.00");
//        put("stepToken", "1");
//        put("root:c:w:pnlIssueFunds:c:w:btnConfirm:submit", "1");

    }

}
