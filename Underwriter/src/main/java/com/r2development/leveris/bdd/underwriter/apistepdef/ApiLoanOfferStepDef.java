package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.google.inject.Singleton;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

@Singleton
public class ApiLoanOfferStepDef extends ApiOpoqoUnderwriterStepDef {

    private static final Log log = LogFactory.getLog(ApiLoanOfferStepDef.class.getName());

//    @Inject
//    IAHttpContext localContext;

    @When("^user saves offer$")
    public void user_saves_offer() throws IOException {
        Document containerLoanOfferDoc = Jsoup.parse(jsoupContainer.get("loanOffer").html());
        Elements loanOfferVersionElements = containerLoanOfferDoc.select("div[wicketpath=multiFlow_panels_2_p_c_form_form_root_c_w_cmbLoanOfferVersion]");
        String loanOfferVersionAttributeValue = loanOfferVersionElements.select("option[selected]").attr("value");
//        String loanOfferVersionOptionValue = loanOfferVersionElements.select("option[selected]").first().textNodes().get(0).text();

        String wicketSaveOfferLink = containerLoanOfferDoc.select("a[wicketpath=multiFlow_panels_2_p_c_form_form_root_c_w_btnSaveOffer_submit").attr("onclick");
        Pattern pWicketSaveOfferLink = Pattern.compile("\\[[0-9]+,[0-9]+,\\\\'\\?wicket:interface=([:a-zA-Z0-9=]+)&");
        Matcher mWicketSaveOfferLink = pWicketSaveOfferLink.matcher(wicketSaveOfferLink);

        String currentWicketSaveOfferLink = null;
        while (mWicketSaveOfferLink.find()) {
            currentWicketSaveOfferLink = mWicketSaveOfferLink.group(1);
        }

        String responseSaveOffer = requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:2:p:c:form:form:root:c:w:btnSaveOffer:submit::IBehaviorListener:0:",
                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=" + currentWicketSaveOfferLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:cmbLoanOfferVersion:combobox", loanOfferVersionAttributeValue);
//                        put("root:c:w:cmbLoanOfferVersion:v", loanOfferVersionOptionValue);   // CLV BUG ..... chrome network not fetching this information !
                        put("root:c:w:pnlOfferValues:c:w:tblOfferUnderwriter:c:b:r:0:c:txtMaxRep:tb", "");
                        put("root:c:w:pnlOfferValues:c:w:tblOfferUnderwriter:c:b:r:0:c:txtMaxLoan:tb", "");
                        put("root:c:w:pnlOfferValues:c:w:tblOfferUnderwriter:c:b:r:0:c:txtMaxTerm:tb", "");
                        put("root:c:w:pnlCommentAndSign:c:w:txaComments:textarea", "");
                        put("stepToken", "1");
                        put("root:c:w:btnSaveOffer:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        jsoupContainer.replace("loanOffer", Jsoup.parse(responseSaveOffer).getAllElements());
    }

    @When("^user completes and signs the offer$")
    public void user_completes_and_signs_the_offer() throws IOException {

/*        Document underwriterHomeSearchResultDoc = Jsoup.parse(underwriterHomeSearchResult);
        TextNode textNodeUnderwriterHomeSearchResult = underwriterHomeSearchResultDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        TextNode textNodeUnderwriterHomeSearchResult = underwriterHomeSearchResultDoc.select("div[id~=pnlApplication]").first().textNodes().get(0);
        Document underwriterHomeSearchResultDoc2 = Jsoup.parse(textNodeUnderwriterHomeSearchResult.text());
        Elements applicationList = underwriterHomeSearchResultDoc2.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication$]");
 */

        Document containerLoanOfferDoc = Jsoup.parse(jsoupContainer.get("loanOffer").html());
        TextNode textNodeContainerLoanOfferDoc = containerLoanOfferDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
        Document containerLoanOfferDoc2 = Jsoup.parse(textNodeContainerLoanOfferDoc.text());
        String wicketCompleteReviewLink = containerLoanOfferDoc2.select("a[wicketpath=multiFlow_panels_2_p_c_form_form_root_c_w_pnlCommentAndSign_c_w_btnCompleteReview_submit").attr("onclick");
        Pattern pWicketCompleteReviewLink = Pattern.compile("\\[[0-9]+,[0-9]+,\\\\'\\?wicket:interface=([:a-zA-Z0-9=]+)&");
        Matcher mWicketCompleteReviewLink = pWicketCompleteReviewLink.matcher(wicketCompleteReviewLink);

        String currentWicketCompleteReviewLink = null;
        while (mWicketCompleteReviewLink.find()) {
            currentWicketCompleteReviewLink = mWicketCompleteReviewLink.group(1);
        }

        Elements loanOfferVersionElements = containerLoanOfferDoc2.select("div[wicketpath=multiFlow_panels_2_p_c_form_form_root_c_w_cmbLoanOfferVersion]");
        String loanOfferVersionAttributeValue = loanOfferVersionElements.select("option[selected]").attr("value");

        requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:2:p:c:form:form:root:c:w:pnlCommentAndSign:c:w:btnCompleteReview:submit::IBehaviorListener:0:",
                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=" + currentWicketCompleteReviewLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:cmbLoanOfferVersion:combobox", loanOfferVersionAttributeValue);
//                        put("root:c:w:cmbLoanOfferVersion:v", loanOfferVersionOptionValue);   // CLV BUG ..... chrome network not fetching this information !
                        put("root:c:w:pnlOfferValues:c:w:tblOfferUnderwriter:c:b:r:0:c:txtMaxRep:tb", "");
                        put("root:c:w:pnlOfferValues:c:w:tblOfferUnderwriter:c:b:r:0:c:txtMaxLoan:tb", "");
                        put("root:c:w:pnlOfferValues:c:w:tblOfferUnderwriter:c:b:r:0:c:txtMaxTerm:tb", "");
                        put("root:c:w:pnlCommentAndSign:c:w:txaComments:textarea", "");
                        put("stepToken", "2");
                        put("root:c:w:pnlCommentAndSign:c:w:btnCompleteReview:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }


}
