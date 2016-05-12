package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IAUnderwriterHttpContext;
import cucumber.api.java.en.And;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;

@Singleton
public class ApiRiskStepDef extends ApiOpoqoUnderwriterStepDef {

    @Inject
    IAUnderwriterHttpContext localContext;
    private boolean isRiskAlreadyExpand = false;

//    And Operator Underwriter validates KYC party
//    | party status | Green |

    @And("(Operator Underwriter) validates KYC party")
    public void operator_validates_kyc_party(String operator, Map<String, String> kycData) throws IOException {

    /* on purpose for the demo
        showOrHide("risk");

        final String formChangeListener = jsoupContainer.get("risk").select("form[id~=form]").select("form[wicketpath=multiFlow_panels_7_p_c_form_form]").attr("action").replace(":p:c:form:form::IFormSubmitListener::", ":p:c:form::IFormChangeListener:2:-1");
        requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2" + formChangeListener,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("data", "{\"widgets\":[{\"widget\":\"pnlMain pnlManualKYC tblKycTable 0 cmbStatus\",\"data\":{\"enable\":true}},{\"widget\":\"pnlMain pnlManualKYC btnManualSave\",\"data\":{\"enable\":true}}]}");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );


        String submitKYC = jsoupContainer.get("risk").select("a[id~=submit]").select("a[wicketpath=multiFlow_panels_7_p_c_form_form_root_c_w_pnlMain_c_w_pnlManualKYC_c_w_btnKycQuery_submit]").attr("onclick");
        Pattern pSubmitKYC = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mSubmitKYC = pSubmitKYC.matcher(submitKYC);

        String submitKYCWicketInterface = null;
        while ( mSubmitKYC.find() ) {
            submitKYCWicketInterface = mSubmitKYC.group(1);
        }
        final String finalSubmitKYCWicketInterface = submitKYCWicketInterface;

//        String btnHiddenRefresh = jsoupContainer.get("risk").select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_btnHiddenRefresh_submit]").attr("onclick");
//        Pattern pBtnHiddenRefresh = Pattern.compile("\\?(wicket:interface=.*)&");
//        Matcher mBtnHiddenRefresh = pBtnHiddenRefresh.matcher(btnHiddenRefresh);
//
//        String btnHiddenRefreshWicketInterface = null;
//        while ( mBtnHiddenRefresh.find() ) {
//            btnHiddenRefreshWicketInterface = mBtnHiddenRefresh.group(1);
//        }
//        final String finalBtnHiddenRefreshWicketInterface = btnHiddenRefreshWicketInterface;

        String inputStepToken = jsoupContainer.get("risk").select("input[name=stepToken]").attr("value");
        final String finalInputStepToken = inputStepToken;

        String submitKYCResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalSubmitKYCWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:tblKycTable:c:b:r:0:c:cmbStatus:combobox", kycData.get("partyStatus"));
//                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:tblKycTable:c:b:r:0:c:cmbStatus:v", kycData.get("partyStatus"));
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:chkKycManualSwitch:checkbox", "on");
                        put("stepToken", finalInputStepToken);
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:btnManualSave:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        jsoupContainer.replace("risk", Jsoup.parse(Jsoup.parse(submitKYCResponse).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("div[id~=form]"));
    */
    }

//    And Operator Underwriter sets Score Card
//    | FICO | 800 |
//    | AML  | OK  |
//    | Fraud | OK |
//    | repeat customer | 10 |

    @And("(Operator Underwriter) sets Score Card")
    public void operator_sets_score_card(String operator, Map<String, String> scoreCardData) throws IOException {

        showOrHide("risk");

        String btnSetFico = jsoupContainer.get("risk").select("a[id~=dialog]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_pnlMain_c_w_pnlScoreCard_c_w_btnSetFico_dialog]").attr("onclick");
        Pattern pBtnSetFico = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnSetFico = pBtnSetFico.matcher(btnSetFico);

        String btnSetFicoWicketInterface = null;
        while ( mBtnSetFico.find() ) {
            btnSetFicoWicketInterface = mBtnSetFico.group(1);
        }
        final String finalBtnSetFicoWicketInterface = btnSetFicoWicketInterface;

        String btnSetFicoResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnSetFicoWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {},
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        String btnFicoSave = Jsoup.parse(Jsoup.parse(btnSetFicoResponse).select("component[id~=dialog]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_dialogWrapper_dialog_form_root_c_w_pnlSetFico_c_w_btnSave_submit]").attr("onclick");
        Pattern pBtnFicoSave = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnFicoSave = pBtnFicoSave.matcher(btnFicoSave);

        String btnFicoSaveWicketInterface = null;
        while ( mBtnFicoSave.find() ) {
            btnFicoSaveWicketInterface = mBtnFicoSave.group(1);
        }
        final String finalBtnFicoSaveWicketInterface = btnFicoSaveWicketInterface;

        String btnFicoSaveResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnFicoSaveWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlSetFico:c:w:txtFico:tb","800");
                        put("root:c:w:pnlSetFico:c:w:txtExternalId:tb", "");
                        put("root:c:w:pnlSetFico:c:w:txaDescription:textarea", "");
                        put("stepToken", "1");
                        put("root:c:w:pnlSetFico:c:w:btnSave:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        String btnFicoClose = Jsoup.parse(Jsoup.parse(btnSetFicoResponse).select("component[id~=close]").select("component[encoding~=wicket]").text()).select("a[id~=close]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_pnlMain_c_w_pnlScoreCard_c_w_btnSetFico_close]").attr("onclick");
        Pattern pBtnFicoClose = Pattern.compile("\\?(wicket:interface=.*IBehaviorListener:0:).,");
        Matcher mBtnFicoClose = pBtnFicoClose.matcher(btnFicoClose);

        String btnFicoCloseWicketInterface = null;
        while ( mBtnFicoClose.find() ) {
            btnFicoCloseWicketInterface = mBtnFicoClose.group(1);
        }
        final String finalBtnFicoCloseWicketInterface = btnFicoCloseWicketInterface;

        String btnFicoCloseResponse = requestHttpGet(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnFicoCloseWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );



        String btnHiddenRefresh = jsoupContainer.get("risk").select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_btnHiddenRefresh_submit]").attr("onclick");
        Pattern pBtnHiddenRefresh = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnHiddenRefresh = pBtnHiddenRefresh.matcher(btnHiddenRefresh);

        String btnHiddenRefreshWicketInterface = null;
        while ( mBtnHiddenRefresh.find() ) {
            btnHiddenRefreshWicketInterface = mBtnHiddenRefresh.group(1);
        }
        final String finalBtnHiddenRefreshWicketInterface = btnHiddenRefreshWicketInterface;

        String inputStepToken = jsoupContainer.get("risk").select("input[name=stepToken]").attr("value");
        final String finalInputStepToken = inputStepToken;

        String btnHiddenRefreshResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnHiddenRefreshWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:tblKycTable:c:b:r:0:c:cmbStatus:combobox", "");
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:chkKycManualSwitch:checkbox", "off");
                        put("stepToken", finalInputStepToken);
                        put("root:c:w:btnHiddenRefresh:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        jsoupContainer.replace("risk", Jsoup.parse(Jsoup.parse(btnHiddenRefreshResponse).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("div[id~=form]"));



        String btnSetAML = jsoupContainer.get("risk").select("a[id~=dialog]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_pnlMain_c_w_pnlScoreCard_c_w_btnSetAML_dialog]").attr("onclick");
        Pattern pBtnSetAML = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnSetAML = pBtnSetAML.matcher(btnSetAML);

        String btnSetAMLWicketInterface = null;
        while ( mBtnSetAML.find() ) {
            btnSetAMLWicketInterface = mBtnSetAML.group(1);
        }
        final String finalBtnSetAMLWicketInterface = btnSetAMLWicketInterface;

        String btnSetAMLResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnSetAMLWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {},
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        String btnAMLSave = Jsoup.parse(Jsoup.parse(btnSetAMLResponse).select("component[id~=dialog]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_dialogWrapper_dialog_form_root_c_w_pnlAml_c_w_btnSave_submit]").attr("onclick");
        Pattern pBtnAMLSave = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnAMLSave = pBtnAMLSave.matcher(btnAMLSave);

        String btnAMLSaveWicketInterface = null;
        while ( mBtnAMLSave.find() ) {
            btnAMLSaveWicketInterface = mBtnAMLSave.group(1);
        }
        final String finalBtnAMLSaveWicketInterface = btnAMLSaveWicketInterface;

        String btnAMLSaveResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnAMLSaveWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlAml:c:w:cmbValue:combobox","OK");
                        put("root:c:w:pnlAml:c:w:txtTicketId:tb", "");
                        put("root:c:w:pnlAml:c:w:txaDescription:textarea", "");
                        put("stepToken", "1");
                        put("root:c:w:pnlAml:c:w:btnSave:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        String btnAMLClose = Jsoup.parse(Jsoup.parse(btnSetAMLResponse).select("component[id~=close]").select("component[encoding~=wicket]").text()).select("a[id~=close]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_pnlMain_c_w_pnlScoreCard_c_w_btnSetAML_close]").attr("onclick");
        Pattern pBtnAMLClose = Pattern.compile("\\?(wicket:interface=.*IBehaviorListener:0:).,");
        Matcher mBtnAMLClose = pBtnAMLClose.matcher(btnAMLClose);

        String btnAMLCloseWicketInterface = null;
        while ( mBtnAMLClose.find() ) {
            btnAMLCloseWicketInterface = mBtnAMLClose.group(1);
        }
        final String finalBtnAMLCloseWicketInterface = btnAMLCloseWicketInterface;

        String btnAMLCloseResponse = requestHttpGet(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnAMLCloseWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );



        btnHiddenRefresh = jsoupContainer.get("risk").select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_btnHiddenRefresh_submit]").attr("onclick");
        pBtnHiddenRefresh = Pattern.compile("\\?(wicket:interface=.*)&");
        mBtnHiddenRefresh = pBtnHiddenRefresh.matcher(btnHiddenRefresh);

        btnHiddenRefreshWicketInterface = null;
        while ( mBtnHiddenRefresh.find() ) {
            btnHiddenRefreshWicketInterface = mBtnHiddenRefresh.group(1);
        }
        final String finalBtnHiddenRefreshWicketInterface2 = btnHiddenRefreshWicketInterface;

        inputStepToken = jsoupContainer.get("risk").select("input[name=stepToken]").attr("value");
        final String finalInputStepToken2 = inputStepToken;

        btnHiddenRefreshResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnHiddenRefreshWicketInterface2,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:tblKycTable:c:b:r:0:c:cmbStatus:combobox", "");
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:chkKycManualSwitch:checkbox", "off");
                        put("stepToken", finalInputStepToken2);
                        put("root:c:w:btnHiddenRefresh:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        jsoupContainer.replace("risk", Jsoup.parse(Jsoup.parse(btnHiddenRefreshResponse).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("div[id~=form]"));



        String btnSetFraud = jsoupContainer.get("risk").select("a[id~=dialog]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_pnlMain_c_w_pnlScoreCard_c_w_btnSetFraud_dialog]").attr("onclick");
        Pattern pBtnSetFraud = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnSetFraud = pBtnSetFraud.matcher(btnSetFraud);

        String btnSetFraudWicketInterface = null;
        while ( mBtnSetFraud.find() ) {
            btnSetFraudWicketInterface = mBtnSetFraud.group(1);
        }
        final String finalBtnSetFraudWicketInterface = btnSetFraudWicketInterface;

        String btnSetFraudResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnSetFraudWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {},
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        String btnFraudSave = Jsoup.parse(Jsoup.parse(btnSetFraudResponse).select("component[id~=dialog]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_dialogWrapper_dialog_form_root_c_w_pnlFraud_c_w_btnSave_submit]").attr("onclick");
        Pattern pBtnFraudSave = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnFraudSave = pBtnFraudSave.matcher(btnFraudSave);

        String btnFraudSaveWicketInterface = null;
        while ( mBtnFraudSave.find() ) {
            btnFraudSaveWicketInterface = mBtnFraudSave.group(1);
        }
        final String finalBtnFraudSaveWicketInterface = btnFraudSaveWicketInterface;

        String btnFraudSaveResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnFraudSaveWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlFraud:c:w:cmbFraud:combobox","OK");
                        put("root:c:w:pnlFraud:c:w:txtTiketId:tb", "");
                        put("root:c:w:pnlFraud:c:w:txaDescription:textarea", "");
                        put("stepToken","1");
                        put("root:c:w:pnlFraud:c:w:btnSave:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        String btnFraudClose = Jsoup.parse(Jsoup.parse(btnSetFraudResponse).select("component[id~=close]").select("component[encoding~=wicket]").text()).select("a[id~=close]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_pnlMain_c_w_pnlScoreCard_c_w_btnSetFraud_close]").attr("onclick");
        Pattern pBtnFraudClose = Pattern.compile("\\?(wicket:interface=.*IBehaviorListener:0:).,");
        Matcher mBtnFraudClose = pBtnFraudClose.matcher(btnFraudClose);

        String btnFraudCloseWicketInterface = null;
        while ( mBtnFraudClose.find() ) {
            btnFraudCloseWicketInterface = mBtnFraudClose.group(1);
        }
        final String finalBtnFraudCloseWicketInterface = btnFraudCloseWicketInterface;

        String btnFraudCloseResponse = requestHttpGet(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnFraudCloseWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );



        btnHiddenRefresh = jsoupContainer.get("risk").select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_btnHiddenRefresh_submit]").attr("onclick");
        pBtnHiddenRefresh = Pattern.compile("\\?(wicket:interface=.*)&");
        mBtnHiddenRefresh = pBtnHiddenRefresh.matcher(btnHiddenRefresh);

        btnHiddenRefreshWicketInterface = null;
        while ( mBtnHiddenRefresh.find() ) {
            btnHiddenRefreshWicketInterface = mBtnHiddenRefresh.group(1);
        }
        final String finalBtnHiddenRefreshWicketInterface3 = btnHiddenRefreshWicketInterface;

        inputStepToken = jsoupContainer.get("risk").select("input[name=stepToken]").attr("value");
        final String finalInputStepToken3 = inputStepToken;

        btnHiddenRefreshResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnHiddenRefreshWicketInterface3,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:tblKycTable:c:b:r:0:c:cmbStatus:combobox", "");
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:chkKycManualSwitch:checkbox", "off");
                        put("stepToken", finalInputStepToken3);
                        put("root:c:w:btnHiddenRefresh:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        jsoupContainer.replace("risk", Jsoup.parse(Jsoup.parse(btnHiddenRefreshResponse).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("div[id~=form]"));



        String btnSetRepCustomer = jsoupContainer.get("risk").select("a[id~=dialog]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_pnlMain_c_w_pnlScoreCard_c_w_btnSetRepCustomer_dialog]").attr("onclick");
        Pattern pBtnSetRepCustomer = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnSetRepCustomer = pBtnSetRepCustomer.matcher(btnSetRepCustomer);

        String btnSetRepCustomerWicketInterface = null;
        while ( mBtnSetRepCustomer.find() ) {
            btnSetRepCustomerWicketInterface = mBtnSetRepCustomer.group(1);
        }
        final String finalBtnSetRepCustomerWicketInterface = btnSetRepCustomerWicketInterface;

        String btnSetRepCustomerResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnSetRepCustomerWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {},
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        String btnRepCustomerSave = Jsoup.parse(Jsoup.parse(btnSetRepCustomerResponse).select("component[id~=dialog]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_dialogWrapper_dialog_form_root_c_w_pnlRepeatCustomer_c_w_btnSave_submit]").attr("onclick");
        Pattern pBtnRepCustomerSave = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnRepCustomerSave = pBtnRepCustomerSave.matcher(btnRepCustomerSave);

        String btnRepCustomerSaveWicketInterface = null;
        while ( mBtnRepCustomerSave.find() ) {
            btnRepCustomerSaveWicketInterface = mBtnRepCustomerSave.group(1);
        }
        final String finalBtnRepCustomerSaveWicketInterface = btnRepCustomerSaveWicketInterface;

        String btnRepCustomerSaveResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnRepCustomerSaveWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlRepeatCustomer:c:w:txtRepeatCustomer:tb","10");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        String btnRepCustomerClose = Jsoup.parse(Jsoup.parse(btnSetRepCustomerResponse).select("component[id~=close]").select("component[encoding~=wicket]").text()).select("a[id~=close]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_pnlMain_c_w_pnlScoreCard_c_w_btnSetRepCustomer_close]").attr("onclick");
        Pattern pBtnRepCustomerClose = Pattern.compile("\\?(wicket:interface=.*IBehaviorListener:0:).,");
        Matcher mBtnRepCustomerClose = pBtnRepCustomerClose.matcher(btnRepCustomerClose);

        String btnRepCustomerCloseWicketInterface = null;
        while ( mBtnRepCustomerClose.find() ) {
            btnRepCustomerCloseWicketInterface = mBtnRepCustomerClose.group(1);
        }
        final String finalBtnRepCustomerCloseWicketInterface = btnRepCustomerCloseWicketInterface;

        String btnRepCustomerCloseResponse = requestHttpGet(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnRepCustomerCloseWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );



        btnHiddenRefresh = jsoupContainer.get("risk").select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_7_p_c_form_form_root_c_w_btnHiddenRefresh_submit]").attr("onclick");
        pBtnHiddenRefresh = Pattern.compile("\\?(wicket:interface=.*)&");
        mBtnHiddenRefresh = pBtnHiddenRefresh.matcher(btnHiddenRefresh);

        btnHiddenRefreshWicketInterface = null;
        while ( mBtnHiddenRefresh.find() ) {
            btnHiddenRefreshWicketInterface = mBtnHiddenRefresh.group(1);
        }
        final String finalBtnHiddenRefreshWicketInterface4 = btnHiddenRefreshWicketInterface;

        inputStepToken = jsoupContainer.get("risk").select("input[name=stepToken]").attr("value");
        final String finalInputStepToken4 = inputStepToken;

        btnHiddenRefreshResponse = requestHttpPost(
                httpClient,
                System.getProperty("underwriter.url") + "/form.2?" + finalBtnHiddenRefreshWicketInterface4,
                new LinkedHashMap<String, String>() {
                    {
                        put("Content+Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:tblKycTable:c:b:r:0:c:cmbStatus:combobox", "");
                        put("root:c:w:pnlMain:c:w:pnlManualKYC:c:w:chkKycManualSwitch:checkbox", "off");
                        put("stepToken", finalInputStepToken4);
                        put("root:c:w:btnHiddenRefresh:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        jsoupContainer.replace("risk", Jsoup.parse(Jsoup.parse(btnHiddenRefreshResponse).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("div[id~=form]"));
    }


    private void showOrHide(String toActiveTools) throws IOException {
        switch (toActiveTools) {
            case "workflow":
                break;
            case "finance":
                break;
            case "loan offer":
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
                while(mDocumentPanelLink.find()) {
                    documentPanelWicketInterface = mDocumentPanelLink.group(1);
                    documentPanelSubmit = mDocumentPanelLink.group(2);
                }
                final String finalDocumentPanelWicketInterfce = documentPanelWicketInterface;
                final String finalDocumentPanelSubmit = documentPanelSubmit;

                String documentPanelResponse = requestHttpPost(
                        httpClient,
                        System.getProperty("underwriter.url") + "/form.2" + finalDocumentPanelWicketInterfce,
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
                if (isRiskAlreadyExpand)
                    break;

                Elements riskPanel = jsoupContainer.get("risk");
                String riskPanelLink = riskPanel.select("a[id~=submit]").select("a[wicketpath~=multiFlow_panels_7]").attr("onclick");

                Pattern pRiskPanelLink = Pattern.compile("(\\?wicket:interface=.*)&.*(root.*submit).*false");
                Matcher mRiskPanelLink = pRiskPanelLink.matcher(riskPanelLink);
                String riskPanelWicketInterface = null;
                String riskPanelSubmit = null;
                while(mRiskPanelLink.find()) {
                    riskPanelWicketInterface = mRiskPanelLink.group(1);
                    riskPanelSubmit = mRiskPanelLink.group(2);
                }
                final String finalRiskPanelWicketInterfce = riskPanelWicketInterface;
                final String finalRiskPanelSubmit = riskPanelSubmit;

                String riskPanelResponse = requestHttpPost(
                        httpClient,
                        System.getProperty("underwriter.url") + "/form.2" + finalRiskPanelWicketInterfce,
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("stepToken", "1");
                                put(finalRiskPanelSubmit, "1");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
                jsoupContainer.replace("risk", Jsoup.parse(Jsoup.parse(riskPanelResponse).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("div[id~=form]"));
                isRiskAlreadyExpand = true;
                break;
            case "update history":
                break;
            default:
//                log.info("Oups, non valid active tool");
        }
    }
}
