package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IAUnderwriterHttpContext;
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

    @Inject
    IAUnderwriterHttpContext localContext;
    private boolean isLoanOfferAlreadyExpand = false;

    @When("^(Operator Underwriter) saves the offer$")
    public void user_saves_offer(String operator) throws IOException {

        showOrHide("loanOffer");

        Elements loanOfferVersionElements = jsoupContainer.get("loanOffer").select("div[wicketpath=multiFlow_panels_2_p_c_form_form_root_c_w_cmbLoanOfferVersion]");
        String loanOfferVersionAttributeValue = loanOfferVersionElements.select("option[selected]").attr("value");
//        String loanOfferVersionOptionValue = loanOfferVersionElements.select("option[selected]").first().textNodes().get(0).text();

        String wicketSaveOfferLink = jsoupContainer.get("loanOffer").select("a[wicketpath=multiFlow_panels_2_p_c_form_form_root_c_w_btnSaveOffer_submit]").attr("onclick");
        Pattern pWicketSaveOfferLink = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mWicketSaveOfferLink = pWicketSaveOfferLink.matcher(wicketSaveOfferLink);

        String currentWicketSaveOfferLink = null;
        while (mWicketSaveOfferLink.find()) {
            currentWicketSaveOfferLink = mWicketSaveOfferLink.group(1);
        }

        String responseSaveOffer = requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:2:p:c:form:form:root:c:w:btnSaveOffer:submit::IBehaviorListener:0:",
//        :7:multiFlow:panels:2:p:c:form:form:root:c:w:btnSaveOffer:submit::IBehaviorListener:0:-1
                System.getProperty("underwriter") + "/form.2?" + currentWicketSaveOfferLink,
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
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:crbMaxLoan:tb", "");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:txtInterestRate:tb", "");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:txtMinTerm:tb", "");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:txtMaxTerm:tb", "");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:crbMinRepayment:tb", "0.00");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:crbMaxRepayment:tb", "0.00");
                        put("root:c:w:pnlCommentAndSign:c:w:txaComments:textarea", "");
                        put("stepToken", "2");
                        put("root:c:w:btnSaveOffer:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        jsoupContainer.replace("loanOffer", Jsoup.parse(responseSaveOffer).getAllElements());
    }

    @When("^(Operator Underwriter) signs the offer$")
    public void user_completes_and_signs_the_offer(String opertator) throws IOException {

/*        Document underwriterHomeSearchResultDoc = Jsoup.parse(underwriterHomeSearchResult);
        TextNode textNodeUnderwriterHomeSearchResult = underwriterHomeSearchResultDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        TextNode textNodeUnderwriterHomeSearchResult = underwriterHomeSearchResultDoc.select("div[id~=pnlApplication]").first().textNodes().get(0);
        Document underwriterHomeSearchResultDoc2 = Jsoup.parse(textNodeUnderwriterHomeSearchResult.text());
        Elements applicationList = underwriterHomeSearchResultDoc2.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication$]");
 */

        TextNode textNodeContainerLoanOfferDoc = jsoupContainer.get("loanOffer").select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
        Document containerLoanOfferDoc2 = Jsoup.parse(textNodeContainerLoanOfferDoc.text());
        String wicketCompleteReviewLink = containerLoanOfferDoc2.select("a[wicketpath=multiFlow_panels_2_p_c_form_form_root_c_w_pnlCommentAndSign_c_w_btnCompleteReview_submit]").attr("onclick");
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
//        :7:multiFlow:panels:2:p:c:form:form:root:c:w:pnlCommentAndSign:c:w:btnCompleteReview:submit::IBehaviorListener:0:
                System.getProperty("underwriter") + "/form.2?wicket:interface=" + currentWicketCompleteReviewLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:cmbLoanOfferVersion:combobox", loanOfferVersionAttributeValue);
                        put("root:c:w:pnlOfferValues:c:w:tblOfferUnderwriter:c:b:r:0:c:txtMaxRep:tb", "");
                        put("root:c:w:pnlOfferValues:c:w:tblOfferUnderwriter:c:b:r:0:c:txtMaxLoan:tb", "");
                        put("root:c:w:pnlOfferValues:c:w:tblOfferUnderwriter:c:b:r:0:c:txtMaxTerm:tb", "");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:crbMaxLoan:tb", "");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:txtInterestRate:tb", "");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:txtMinTerm:tb", "");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:txtMaxTerm:tb", "");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:crbMinRepayment:tb", "0.00");
                        put("root:c:w:pnlOfferValuesUWOffer:c:w:crbMaxRepayment:tb", "0.00");
                        put("root:c:w:pnlCommentAndSign:c:w:txaComments:textarea", "");
                        put("stepToken", "3");
                        put("root:c:w:pnlCommentAndSign:c:w:btnCompleteReview:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        /*
        ??? why ?
        post  :7:multiFlow:panels:7:p:c:form:form:root:c:w:btnHiddenRefreshNotif:submit::IBehaviorListener:0:
        root:c:w:pnlMain:c:w:pnlManualKYC:c:w:tblKycTable:c:b:r:0:c:cmbStatus:combobox:GREEN
        stepToken:2
        root:c:w:btnHiddenRefreshNotif:submit:1
        */
    }

    private void showOrHide(String toActiveTools) throws IOException {
        switch (toActiveTools) {
            case "workflow":
                break;
            case "finance":
                break;
            case "loanOffer":
                if (isLoanOfferAlreadyExpand)
                    break;

                Elements loanOfferPanel = jsoupContainer.get("loanOffer");
                String loanOfferPanelLink = loanOfferPanel.select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_2]").attr("onclick");

                Pattern pLoanOfferPanelLink = Pattern.compile("(\\?wicket:interface=.*)&.*(root.*submit).*false");
                Matcher mLoanOfferPanelLink = pLoanOfferPanelLink.matcher(loanOfferPanelLink);
                String loanOfferPanelWicketInterface = null;
                String loanOfferPanelSubmit = null;
                while (mLoanOfferPanelLink.find()) {
                    loanOfferPanelWicketInterface = mLoanOfferPanelLink.group(1);
                    loanOfferPanelSubmit = mLoanOfferPanelLink.group(2);
                }
                final String finalLoanOfferPanelWicketInterface = loanOfferPanelWicketInterface;
                final String finalLoanOfferPanelSubmit = loanOfferPanelSubmit;

                String loanOfferPanelResponse = requestHttpPost(
                        httpClient,
                        System.getProperty("underwriter") + "/form.2" + finalLoanOfferPanelWicketInterface,
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("stepToken", "1");
                                put(finalLoanOfferPanelSubmit, "1");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
                jsoupContainer.replace("loanOffer", Jsoup.parse(Jsoup.parse(loanOfferPanelResponse).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("div[id~=form]"));
                isLoanOfferAlreadyExpand = true;
                break;
            case "form":
                break;
            case "documents":
                Elements documentPanel = jsoupContainer.get("documents");
                String documentPanelLink = documentPanel.select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_4]").attr("onclick");

                Pattern pDocumentPanelLink = Pattern.compile("(\\?wicket:interface=.*)&.*(root.*submit).*false");
                Matcher mDocumentPanelLink = pDocumentPanelLink.matcher(documentPanelLink);
                String documentPanelWicketInterface = null;
                String documentPanelSubmit = null;
                while (mDocumentPanelLink.find()) {
                    documentPanelWicketInterface = mDocumentPanelLink.group(1);
                    documentPanelSubmit = mDocumentPanelLink.group(2);
                }
                final String finalDocumentPanelWicketInterfce = documentPanelWicketInterface;
                final String finalDocumentPanelSubmit = documentPanelSubmit;

                String documentPanelResponse = requestHttpPost(
                        httpClient,
                        System.getProperty("underwriter") + "/form.2" + finalDocumentPanelWicketInterfce,
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("stepToken", "1");
                                put(finalDocumentPanelSubmit, "1");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
                jsoupContainer.replace("documents", Jsoup.parse(Jsoup.parse(documentPanelResponse).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("div[id~=form]"));
                break;
            case "document2":
                break;
            case "notes":
                break;
            case "risk":
            case "update history":
                break;
            default:
//                log.info("Oups, non valid active tool");
        }
    }
}
