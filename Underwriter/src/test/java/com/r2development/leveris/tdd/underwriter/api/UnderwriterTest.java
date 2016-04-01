package com.r2development.leveris.tdd.underwriter.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.r2development.leveris.utils.HttpUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;
import static org.junit.Assert.assertEquals;

public class UnderwriterTest {

    public static void main(String... arg) throws IOException {


//        @before cucumber
        HttpClient httpClient = HttpUtils.createHttpClient();
        HttpClientContext localContext = HttpUtils.initContext("st1app.loftkeys.com", "/underwriter");

        requestHttpGet(
            httpClient,
            "https://st1app.loftkeys.com/underwriter/",
            new LinkedHashMap<String, String>() {
                {
                 put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                }
            },
            localContext,
            false
        );

//        not necessary ?
        HttpPost httpPostLoginScenarios = new HttpPost("https://st1apl.loftkeys.com/sso/api/public/sso/getLoginScenarios");
        httpPostLoginScenarios.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostLoginScenarios.setHeader("Referer", "https://st1apl.loftkeys.com/sso/?host=https://st1app.loftkeys.com/underwriter/home%3FuseCase%3Dauthenticate\n&application=UNDERWRITER");
        StringEntity se = new StringEntity("{\"url\":\"\",\"applicationCode\":\"UNDERWRITER\"}");
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostLoginScenarios.setEntity(se);
        HttpResponse responseLoginScenarios = httpClient.execute(httpPostLoginScenarios, localContext);
        HttpEntity httpEntityLoginScenarios = responseLoginScenarios.getEntity();
        System.out.println("==== httpEntityLoginScenarios ====");
        System.out.println(EntityUtils.toString(httpEntityLoginScenarios));

//        SSO Step1
        HttpPost httpPostValidateAuthProcessStep = new HttpPost("https://st1apl.loftkeys.com/sso/api/public/sso/validateAuthProcessStep");
//        httpPostValidateAuthProcessStep.setHeader("Accept-Encoding", "gzip, deflate");
//        httpPostValidateAuthProcessStep.setHeader("Accept", "*.*");
        httpPostValidateAuthProcessStep.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostValidateAuthProcessStep.setHeader("Referer", "https://st1apl.loftkeys.com/sso/?host=https://st1app.loftkeys.com/underwriter/home%3FuseCase%3Dauthenticate\n&application=UNDERWRITER");
        //TODO to move to properties user login / pwd
        StringEntity se2 = new StringEntity("{\"originalRequest\":{\"url\":\"https://st1app.loftkeys.com/underwriter/home?useCase=authenticate\",\"applicationCode\":\"UNDERWRITER\"},\"scenarioCode\":\"LDAP_USR_PWD\",\"operation\":\"LOGIN\",\"authProcessStepValues\":[{\"authDetailCode\":\"LDAPUSERNAME\",\"value\":\"u1@abakus,com\"},{\"authDetailCode\":\"LDAPPWD\",\"value\":\"Password1122\"}]}");
        se2.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostValidateAuthProcessStep.setEntity(se2);
        HttpResponse responseValidateAuthProcessStep = httpClient.execute(httpPostValidateAuthProcessStep, localContext);
        HttpEntity httpEntityValidateAuthProcessStep = responseValidateAuthProcessStep.getEntity();
        System.out.println("==== httpPostValidateAuthProcessStep ====");
        System.out.println(EntityUtils.toString(httpEntityValidateAuthProcessStep));

//        SSO Step2
        HttpPost httpPostValidateAuthProcessStep2 = new HttpPost("https://st1apl.loftkeys.com/sso/api/public/sso/validateAuthProcessStep");
//        httpPostValidateAuthProcessStep.setHeader("Accept-Encoding", "gzip, deflate");
//        httpPostValidateAuthProcessStep.setHeader("Accept", "*.*");
        httpPostValidateAuthProcessStep2.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostValidateAuthProcessStep2.setHeader("Referer", "https://st1apl.loftkeys.com/sso/?host=https://st1app.loftkeys.com/underwriter/home%3FuseCase%3Dauthenticate\n&application=UNDERWRITER");
        StringEntity se3 = new StringEntity("{\"originalRequest\":{\"url\":\"https://st1app.loftkeys.com/underwriter/home?useCase=authenticate\",\"applicationCode\":\"UNDERWRITER\"},\"scenarioCode\":\"LDAP_USR_PWD\",\"operation\":\"LOGIN\",\"authProcessStepValues\":[{\"authDetailCode\":\"LDAPUSERNAME\",\"value\":\"u1@abakus.com\"},{\"authDetailCode\":\"LDAPPWD\",\"value\":\"Password1122\"}]}");
        se3.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostValidateAuthProcessStep2.setEntity(se3);
        HttpResponse responseValidateAuthProcessStep2 = httpClient.execute(httpPostValidateAuthProcessStep2, localContext);
        HttpEntity httpEntityValidateAuthProcessStep2 = responseValidateAuthProcessStep2.getEntity();
        System.out.println("==== httpPostValidateAuthProcessStep2 ====");
        String parse2json = EntityUtils.toString(httpEntityValidateAuthProcessStep2);
        System.out.println(parse2json);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(parse2json);

        String ticket = jsonObject.get("serviceTicket").getAsString();

//        if ( responseValidateAuthProcessStep2.getHeaders("Set-Cookie").length == 1)
//            ticket=responseValidateAuthProcessStep2.getHeaders("Set-Cookie")[0].getValue();
//        else {
//            for (Header currentHeader : responseValidateAuthProcessStep2.getHeaders("Set-Cookie")) {
//                if ( currentHeader.getValue().contains("CASTGC"))
//                    ticket = currentHeader.getValue();
//            }
//        }
        System.out.println("TICKET: " + ticket);

//        SSO Step 3
        // TODO to handle when having PageExpiredErrorPage int the response !!!!
        /*String underwriterHomeSearchResult = */requestHttpGet(
                httpClient,
                "https://st1app.loftkeys.com/underwriter/home?useCase=authenticate&ticket=" + ticket,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                false
        );

//        requestHttpPost(
//            httpClient,
//            "https://st1app.loftkeys.com/underwriter/form2.?wicket:interface:4:singleFlow:p:c:form::IFormChangeListener:2:-1",
//            new LinkedHashMap<String, String>() {
//                {
//                    put("Accept", "text/xml");
//                }
//            },
//            new LinkedHashMap<String, String>() {
//                {
//                    put(
//                        "data",
//                        "{\"widgets\":[{\"widget\":\"pnl-adv-search\",\"data\":{\"visible\":true},\"delta\":70,\"visibleEvent\":\"show\"}]}"
//                    );
//                }
//            },
//            localContext,
//            false
//        );

        String underwriterHomeSearchResult = requestHttpPost(
                httpClient,
                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:btnSearch:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:cmbAssignedApplication:combobox", "ALL");
                        put("root:c:w:cmbStatusFilter:combobox","AllActive");
                        put("root:c:w:txtSearch:tb","AUTOMATIONSBAPI20160201194221756");
//                        put("root:c:w:txtSearch:tb","");
//                        put("root:c:w:txtSearch:tb","automation");
//                        put("root:c:w:pnl-adv-search:c:w:txt-application-id:tb", "4148");
                        put("root:c:w:pnl-adv-search:c:w:txt-application-id:tb", "");
                        put("stepToken", "1");
                        put("root:c:w:btnSearch:submit", "1");
                    }
                },
                localContext,
                false
        );

        Document underwriterHomeSearchResultDoc = Jsoup.parse(underwriterHomeSearchResult);
        TextNode textNodeUnderwriterHomeSearchResult = underwriterHomeSearchResultDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
        Document underwriterHomeSearchResultDoc2 = Jsoup.parse(textNodeUnderwriterHomeSearchResult.text());
        Elements applicationList = underwriterHomeSearchResultDoc2.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication$]");
//        Elements potentatialApplication = underwriterHomeSearchResultDoc2.select("div[id~=rptApplication] > div[id~=pnlApplication] div[ ").div[wicketpath~=singleFlow_p_c_form_form_root_c_w_rptApplicationList_c_rows_(\\d+)_item_pnlApplication_c_w_lbl-application-id_l]");

        List<Element> automationApplication = new LinkedList<>();
        for ( Element currentElement : applicationList) {
            Elements elementApplicationFirstName = currentElement.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_lblName$]:contains(AUTOMATIONSBAPI20160201194221756)");
            if ( elementApplicationFirstName.size() == 1) {
                System.out.println(elementApplicationFirstName.text());
                automationApplication.add(currentElement);
                System.out.println("Yeeeeeeeeesssssssssss");
            }

            Elements elementApplicationId = currentElement.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication_c_w_lbl-application-id$]:contains(4148)");
            if ( elementApplicationId.size() == 1) {
                System.out.println(elementApplicationId.text());
//                automationApplication.add(currentElement);
                System.out.println("Bingo application Id Yeeeeeeeeesssssssssss");
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
                "https://st1app.loftkeys.com/underwriter/form.2?" + wicketStartLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                new LinkedHashMap<String, String>() {},
                localContext,
                false
        );

        Document applicationResult = Jsoup.parse(applicationAutomation);

        Elements containerPanels = applicationResult.select("div[wicketpath=multiFlow]");
//        Elements containerWorkflow = containerPanels.select("div[wicketpath=multiFlow_panels_0]");
//        Elements containerFinance = containerPanels.select("div[wicketpath=multiFlow_panels_1]");
        Elements containerLoanOffer = containerPanels.select("div[wicketpath=multiFlow_panels_2]");
//        Elements containerForm = containerPanels.select("div[wicketpath=multiFlow_panels_3]");
//        Elements containerDocuments = containerPanels.select("div[wicketpath=multiFlow_panels_4]");
//        Elements containerDocuments2 = containerPanels.select("div[wicketpath=multiFlow_panels_5]");
//        Elements containerNotes = containerPanels.select("div[wicketpath=multiFlow_panels_6]");
//        Elements containerRisk = containerPanels.select("div[wicketpath=multiFlow_panels_7]");
//        Elements containerUpdateHistory = containerPanels.select("div[wicketpath=multiFlow_panels_8]");

        Elements applicationDocument = applicationResult.select("div[wicketpath~=^multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_(\\d+)_item_pnlDocuments$]");
        Map<String, String> document2Validate = new LinkedHashMap<>();
        for ( Element currentElement : applicationDocument ) {
            String linkDetail = currentElement.select("a[wicketpath~=^multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_(\\d+)_item_pnlDocuments_c_w_lnkDetail_submit$]").attr("onclick");
            String status = currentElement.select("div[wicketpath~=^multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_(\\d+)_item_pnlDocuments_c_w_lblStatus$]").attr("class");

            if ( status.contains("check-icon"))
                continue;

//            SC._submit.apply(this,['form1713','form1694','scAjax.apply(this,[1,0,\'?wicket:interface=:5:multiFlow:panels:4:p:c:form:form:root:c:w:rptDocuments:c:rows:1:item:pnlDocuments:c:w:lnkDetail:submit::IBehaviorListener:0:&${scrollPos}\',\'busyIndicator180f\',0,0,function(){return SC._isRowValid(\'submit19fe\', false);},SC._serializeRow(\'submit19fe\', false),0]);']);return false;,
            Pattern pInit = Pattern.compile(".*\\[([0-9]+),[0-9]+,\\\\'\\?(wicket:interface=[:a-zA-Z0-9]*)&.*");
            Matcher mInit = pInit.matcher(linkDetail);

            String currentWicketLinkDetail = null;
            while (mInit.find()) {
                currentWicketLinkDetail = mInit.group(2);
            }

            String owner = currentElement.select("div[wicketpath~=^multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_(\\d+)_item_pnlDocuments_c_w_lblOwners_l$]").text();
            String documentType = currentElement.select("div[wicketpath~=^multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_(\\d+)_item_pnlDocuments_c_w_lblType_l$]").text();

            System.out.println("document row : " + currentWicketLinkDetail + ", " + owner + ", " + documentType);
            document2Validate.put(currentWicketLinkDetail, documentType);
        }

        while ( !document2Validate.isEmpty() ) {

            String currentDocumentKey = (String) document2Validate.keySet().toArray()[0];
            String currentDocumentValue = document2Validate.get(currentDocumentKey);

            System.out.println("===============================================================================");
            System.out.println("===============================================================================");
            System.out.println("currentDocument :" + currentDocumentKey + "-" + currentDocumentValue);
            System.out.println("===============================================================================");
            System.out.println("===============================================================================");

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().setCharset(Charset.forName("UTF-8")).setLaxMode();

            String typeKey = "";
            switch (currentDocumentValue) {
                case "ICB manual report": // BUG CLV // ok
                    typeKey="ICEBREPMAN";
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "ICBREPMAN");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "ICB manual report");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "16565");
//                    multipartEntityBuilder.addTextBody("stepToken", "33");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit", "1");
                    break;
                case "Bank Statement": // BUG CLV // ok
                    typeKey="BANSTM";
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "BANSTM");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Bank Statement");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:1:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:2:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:3:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:4:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:5:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:6:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:7:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:8:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:9:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:10:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:11:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:12:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:13:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:14:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:15:item:pnlExtractDataItem:c:w:pnlTextFieldNumber:c:w:txtFieldNumber:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:16:item:pnlExtractDataItem:c:w:pnlTextFieldNumber:c:w:txtFieldNumber:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:17:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:17:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:18:item:pnlExtractDataItem:c:w:pnlTextFieldNumber:c:w:txtFieldNumber:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:19:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:19:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:20:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:21:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:22:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:23:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:24:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15192");
//                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15192");
//                    multipartEntityBuilder.addTextBody("stepToken", "24");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit", "1");
                    break;
                case "Certified Accounts (Year before last year)":
                    typeKey="ACCS2";
                    break;
                case "Certified Accounts (Last year)":
                    typeKey="ACCS1";
                    break;
                case "Confirmation of Tax Affairs":
                    typeKey="TAXAFF";
                    break;
                case "Credit Card":
                    typeKey="CRDSTM";
                    break;
                case "Current Payslip": // ok
                    typeKey="PAYS1";

                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "PAYS1");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Current Payslip");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "PAYSLP");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Payslip");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");

// Bug CLV wicket if double pairValue, at least one cmbUnderwritingStatus & cmbUnderwritingStatus empty .... even the other one is filled accepted
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Choose One");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15189");
//                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15189");
//                    multipartEntityBuilder.addTextBody("stepToken", "13");
                    multipartEntityBuilder.addTextBody("root:c:w:btnHiddenSubExtract:submit", "1");

//                    // or
//
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "PAYS1");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Current Payslip");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "PAYSLP");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Payslip");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:1:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:2:item:pnlExtractDataItem:c:w:pnlSelect:c:w:cmbCombo:combobox", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:2:item:pnlExtractDataItem:c:w:pnlSelect:c:w:cmbCombo:v", "Choose...");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:3:item:pnlExtractDataItem:c:w:pnlTextFieldNumber:c:w:txtFieldNumber:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:4:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
////                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15189");
////                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15189");
////                    multipartEntityBuilder.addTextBody("stepToken", "14");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit", "1");

                    break;
                case "Deed of Assignment":
                    typeKey="DEOASS";
                    break;
                case "Direct debit confirmation":
                    typeKey="DOC_DDCL";
                    break;
                case "Direct debit - paper":
                    typeKey="DIRDEB";
                    break;
                case "Divorce Agreement":
                    typeKey="DIVAGR";
                    break;
                case "European Standard Information Sheet":
                    typeKey="DOC_ESIS";
                    break;
                case "Gift":
                    typeKey="GIFLET";
                    break;
                case "Home Insurance Policy":
                    typeKey="HOINPD";
                    break;
                case "Inheritence":
                    typeKey="INHLET";
                    break;
                case "Statement of suitability":
                    typeKey="DOC_LOS";
/*
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox"                    on
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox"                    DOC_LOS
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v"                    Statement of suitability
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox"
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v"                    Choose...
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb"
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb"
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb"
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox"                    ACCEPTED
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v"                    Accepted
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:uplUpload:upload"; filename=""                    Content-Type: application/octet-stream
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb"                    17198
                    Content-Disposition: form-data; name="root:c:w:txtDocumentId:tb"                    17198
                    Content-Disposition: form-data; name="stepToken"                    5
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit"                    1
*/
                    break;
                case "Life Assurance Policy":
                    typeKey="LAPOLD";
                    break;
                case "Loan offer letter":
                    typeKey="DOC_LOL";
/*
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox"                    on
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox"                    DOC_LOL
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v"                    Loan offer letter
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox"
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v"                    Choose...
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb"
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb"
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb"
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox"                    ACCEPTED
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v"                    Accepted
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:uplUpload:upload"; filename=""                    Content-Type: application/octet-stream
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb"                    17197
                    Content-Disposition: form-data; name="root:c:w:txtDocumentId:tb"                    17197
                    Content-Disposition: form-data; name="stepToken"                    2
                    Content-Disposition: form-data; name="root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit"                    1
*/
                    break;
                case "Signed loan offer letter":
                    typeKey="DOC_LOLS";
                    break;
                case "Loan Statement":
                    typeKey="LOASTM";
                    break;
                case "Marriage Certificate":
                    typeKey="MARCER";
                    break;
//                case "Mortgage application form": // ok
                case "Application Form": // ok
                    typeKey="DOC_MAF";
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "DOC_MAF");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Mortgage application form");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15193");
//                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15193");
//                    multipartEntityBuilder.addTextBody("stepToken", "27");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit", "1");

//                        // or
//
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "DOC_MAF");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Mortgage application form");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Choose...");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15193");
////                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15193");
////                    multipartEntityBuilder.addTextBody("stepToken", "30");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit", "1");

                    break;
                case "Mortgage Statement":
                    typeKey="MTGSTM";
                    break;
                case "Mortgage Terms &amp; Conditions":
                    typeKey="AGR_MTC";
                    break;
                case "No Formal Agreement:":
                    typeKey="NOFAGR";
                    break;
                case "Notice of Interest and Fire:":
                    typeKey="NOTINF";
                    break;
                case "P60": // ok
                    typeKey="P60";

                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "P60");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "P60");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:1:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:2:item:pnlExtractDataItem:c:w:pnlTextFieldNumber:c:w:txtFieldNumber:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:3:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:4:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:5:item:pnlExtractDataItem:c:w:pnlTextFieldNumber:c:w:txtFieldNumber:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15188");
//                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15188");
//                    multipartEntityBuilder.addTextBody("stepToken", "10");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit", "1");

                    break;
                case "Photo Identification": // ok
                    typeKey="PROID";
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "PROID");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Photo Identification");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "PASS");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Passport");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15186");
//                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15186");
//                    multipartEntityBuilder.addTextBody("stepToken", "2");
                    multipartEntityBuilder.addTextBody("root:c:w:btnHiddenSubExtract:submit", "1");

                    // or
//
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "PROID");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Photo Identification");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "PASS");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Passport");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
////                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
////                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:1:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:2:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:3:item:pnlExtractDataItem:c:w:pnlSelect:c:w:cmbCombo:combobox", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:3:item:pnlExtractDataItem:c:w:pnlSelect:c:w:cmbCombo:v", "Choose...");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:4:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:5:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:6:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:7:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:8:item:pnlExtractDataItem:c:w:pnlSelect:c:w:cmbCombo:combobox", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:8:item:pnlExtractDataItem:c:w:pnlSelect:c:w:cmbCombo:v", "Choose...");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:9:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:10:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:combobox", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:10:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:v", "Choose...");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15186");
////                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15186");
////                    multipartEntityBuilder.addTextBody("stepToken", "3");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit", "1");

                    break;
                case "Previous Payslip": // ok
                    typeKey="PAYS2";

                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "PAYS2");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Previous Payslip");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "PAYSLP");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Payslip");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Choose One");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15190");
//                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15190");
//                    multipartEntityBuilder.addTextBody("stepToken", "17");
                    multipartEntityBuilder.addTextBody("root:c:w:btnHiddenSubExtract:submit", "1");

                    // or
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "PAYS2");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Previous Payslip");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "PAYSLP");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Payslip");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
////                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
////                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:1:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:2:item:pnlExtractDataItem:c:w:pnlSelect:c:w:cmbCombo:combobox", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:2:item:pnlExtractDataItem:c:w:pnlSelect:c:w:cmbCombo:v", "Choose...");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:3:item:pnlExtractDataItem:c:w:pnlTextFieldNumber:c:w:txtFieldNumber:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:4:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15190");
////                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15190");
////                    multipartEntityBuilder.addTextBody("stepToken", "18");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit", "1");

                    break;
                case "Proof of Address": // ok
                    typeKey="PROADR";

                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "PROADR");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Proof of Address");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "UTIL");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Utility Bill (Gas / Electrity / Phone / Television Provider)"); // BUG CLV ? not handling special characters
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Choose One");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15187");
//                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15187");
//                    multipartEntityBuilder.addTextBody("stepToken", "6");
                    multipartEntityBuilder.addTextBody("root:c:w:btnHiddenSubExtract:submit", "1");

                    break;
                case "Proof of Rental Income":
                    typeKey="RENTB";
                    break;
                case "Proof of Residency":
                    typeKey="PRORES";
                    break;
                case "Salary Certificate": // ok
                    typeKey="SALCERT";

                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:rgrRelatedTo:rg:rb:radApplicant1:checkbox", "on");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:combobox", "SALCERT");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocumentType:v", "Salary Certificate");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbDocSubtype:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlDescription:c:w:txtDescription:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtExpiryDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:txtTag:tb", "");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:1:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:2:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:3:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:4:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:5:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:5:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:6:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:6:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:7:item:pnlExtractDataItem:c:w:pnlTextFieldDate:c:w:txtFieldDate:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:8:item:pnlExtractDataItem:c:w:pnlTextFieldNumber:c:w:txtFieldNumber:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:9:item:pnlExtractDataItem:c:w:pnlTextFieldNumber:c:w:txtFieldNumber:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:10:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:10:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:11:item:pnlExtractDataItem:c:w:pnlTextFieldNumber:c:w:txtFieldNumber:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:12:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:12:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:13:item:pnlExtractDataItem:c:w:pnlTextFieldString:c:w:txtFieldString:tb", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:14:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:combobox", "");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:pnlExtraction:c:w:rptExtractionData:c:rows:14:item:pnlExtractDataItem:c:w:pnlCheckbox:c:w:cmbTrueFalse:v", "Choose...");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:uplUpload:upload", "{\"fileName\":\"\",\"contentType\":\"application/octet-stream\",\"data\":\"\"}", ContentType.create("application/octet-stream", Charset.forName("UTF-8")));
//                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", "15191");
//                    multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", "15191");
//                    multipartEntityBuilder.addTextBody("stepToken", "21");
                    multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit", "1");

                    break;
                case "Solicitors undertaking":
                    typeKey="SOLUND";
                    break;
                case "Suitabillity":
                    typeKey="DOC_LOSF";
                    break;
                case "Survey Report":
                    typeKey="SURREP";
                    break;
                case "Valuation Report":
                    typeKey="VALREP";
                    break;
                case "Other":
                    typeKey="OTHER";
                    break;
                default:
                    System.out.println("new doc type ? it will failed");
            }
            final String typeKeyParameterValue = typeKey;

            String documentViewResponse = requestHttpPost(
                    httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
                    "https://st1app.loftkeys.com/underwriter/form.2?" + currentDocumentKey,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("root:c:w:rptDocuments:c:rows:1:item:pnlDocuments:c:w:mbtActivity:combobox", "");
                            put("root:c:w:rptDocuments:c:rows:1:item:pnlDocuments:c:w:txtTypeKey:tb", typeKeyParameterValue);
                            put("root:c:w:rptDocuments:c:rows:1:item:pnlDocuments:c:w:txtDescription:tb", "");
                        }
                    },
//                    null,
                    localContext,
                    false
            );

            requestHttpPost(
                    httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
                    "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:4:p:c:form::IFormChangeListener:2:-1",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("data", "{\"widgets\":[{\"widget\":\"pnlBlack pnlEdit\",\"data\":{\"visible\":true},\"delta\":600,\"visibleEvent\":\"show\"},{\"widget\":\"pnlBlack pnlInfo\",\"data\":{\"visible\":false},\"delta\":-140,\"visibleEvent\":\"hide\"},{\"widget\":\"pnlBlack pnlEdit pnlDescription\",\"data\":{\"visible\":false},\"delta\":-60,\"visibleEvent\":\"hide\"}]}");
                        }
                    },
                    localContext,
                    false
            );

            Document documentViewDoc = Jsoup.parse(documentViewResponse);
            TextNode textNodeDocumentView = documentViewDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
            Document documentViewDoc2 = Jsoup.parse(textNodeDocumentView.text());

            String stepToken = documentViewDoc2.select("input[name=stepToken").attr("value");
            multipartEntityBuilder.addTextBody("stepToken", stepToken);
            String txtDocumentId = documentViewDoc2.select("div[id~=txtDocumentId]").attr("value");
            String txtDocumentId2 = documentViewDoc2.select("input[name=root:c:w:txtDocumentId:tb]").attr("value");

            multipartEntityBuilder.addTextBody("root:c:w:txtDocumentId:tb", (!StringUtils.isEmpty(txtDocumentId) ? txtDocumentId : txtDocumentId2 ));
            multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:rptDocuments:c:rows:1:item:txtDocumentId:tb", (!StringUtils.isEmpty(txtDocumentId) ? txtDocumentId : txtDocumentId2 ));
            multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:combobox", "ACCEPTED");
            multipartEntityBuilder.addTextBody("root:c:w:pnlBlack:c:w:pnlEdit:c:w:cmbUnderwritingStatus:v", "Accepted");

//            Instant begin_timestamp = DateTime.now().toInstant();
////            HttpPost httpPostUploadDocItemDD = new HttpPost("https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlMain:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:");
            HttpPost httpPostUploadDocItem = new HttpPost("https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:4:p:c:form:form:root:c:w:pnlBlack:c:w:pnlEdit:c:w:btnSave:submit::IBehaviorListener:0:");
            httpPostUploadDocItem.setHeader("Accept-Encoding", "gzip, deflate");
            httpPostUploadDocItem.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            String boundary = RandomStringUtils.randomAlphanumeric(15);
            String fullBoundary = "----WebKitFormBoundary" + boundary;
            httpPostUploadDocItem.setHeader("Content-Type", "multipart/form-data; boundary=" + fullBoundary);

            HttpEntity entityUploadDocItem = multipartEntityBuilder
                    .setBoundary(fullBoundary)
                    .build();
            httpPostUploadDocItem.setEntity(entityUploadDocItem);

            HttpResponse responseUploadDocItem = httpClient.execute(httpPostUploadDocItem, localContext);
            HttpEntity httpEntityUploadDocItem = responseUploadDocItem.getEntity();
//
//            if (!CONSUME_QUIETLY) {
            System.out.println(" = Document - Upload Doc Item " + currentDocumentKey + "=" + currentDocumentValue + " DD =============================================");
//                log.info(EntityUtils.toString(httpEntityUploadDocItemDD));
            String documentViewSaveResponse = EntityUtils.toString(httpEntityUploadDocItem);
            System.out.println(documentViewSaveResponse);
//            } else {
//                EntityUtils.consumeQuietly(httpEntityUploadDocItemDD);
//                Instant end_timestamp = DateTime.now().toInstant();
////                log.info("done... in " + new Interval(begin_timestamp, end_timestamp).toDuration().toStandardSeconds());
//                System.out.println("done... in " + new Interval(begin_timestamp, end_timestamp).toDuration().toStandardSeconds());
//            }

            Document documentViewSaveDoc = Jsoup.parse(documentViewSaveResponse);
            TextNode textNodeDocumentViewSaveDoc = documentViewSaveDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
            Document documentViewSaveDoc2 = Jsoup.parse(textNodeDocumentViewSaveDoc.text());

            String lnkClose =documentViewSaveDoc2.select("a[id~=cancel]").attr("onclick");
            Pattern p = Pattern.compile(".*\\[([0-9]+),[0-9]+,\\\\'\\?(wicket:interface=[:a-zA-Z0-9]*&stepToken=[0-9]+)&.*");
            Matcher m = p.matcher(lnkClose);

            String currentWicketLinkClose = null;
            while (m.find()) {
                currentWicketLinkClose = m.group(2);
            }

            String linkCloseResponse = requestHttpGet(
                    httpClient,
//                    "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:4:p:c:form:form:root:c:w:pnlBlack:c:w:lnkClose:cancel::IBehaviorListener:0:&amp;stepToken=2&amp;",
                    "https://st1app.loftkeys.com/underwriter/form.2?" + currentWicketLinkClose,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/html");
                        }
                    },
                    localContext,
                    false
            );

            Document linkCloseResponseDoc = Jsoup.parse(linkCloseResponse);
            TextNode textNodeLinkCloseResponseDoc = linkCloseResponseDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
            Document linkCloseResponseDoc2 = Jsoup.parse(textNodeLinkCloseResponseDoc.text());
            Elements newApplicationDocument = linkCloseResponseDoc2.select("div[wicketpath~=^multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_(\\d+)_item_pnlDocuments$]");

            document2Validate = new LinkedHashMap<>();
            for ( Element currentElement : newApplicationDocument ) {
                String linkDetail = currentElement.select("a[wicketpath~=^multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_(\\d+)_item_pnlDocuments_c_w_lnkDetail_submit$]").attr("onclick");
                String status = currentElement.select("div[wicketpath~=^multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_(\\d+)_item_pnlDocuments_c_w_lblStatus$]").attr("class");

                if ( status.contains("check-icon"))
                    continue;

//            SC._submit.apply(this,['form1713','form1694','scAjax.apply(this,[1,0,\'?wicket:interface=:5:multiFlow:panels:4:p:c:form:form:root:c:w:rptDocuments:c:rows:1:item:pnlDocuments:c:w:lnkDetail:submit::IBehaviorListener:0:&${scrollPos}\',\'busyIndicator180f\',0,0,function(){return SC._isRowValid(\'submit19fe\', false);},SC._serializeRow(\'submit19fe\', false),0]);']);return false;,
                Pattern pInLoop = Pattern.compile(".*\\[([0-9]+),[0-9]+,\\\\'\\?(wicket:interface=[:a-zA-Z0-9]*)&.*");
                Matcher mInLoop = pInLoop.matcher(linkDetail);

                String currentWicketLinkDetail = null;
                while (mInLoop.find()) {
                    currentWicketLinkDetail = mInLoop.group(2);
                }

                String owner = currentElement.select("div[wicketpath~=^multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_(\\d+)_item_pnlDocuments_c_w_lblOwners_l$]").text();
                String documentType = currentElement.select("div[wicketpath~=^multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_(\\d+)_item_pnlDocuments_c_w_lblType_l$]").text();

                System.out.println("document row : " + currentWicketLinkDetail + ", " + owner + ", " + documentType);
                document2Validate.put(currentWicketLinkDetail, documentType);
            }

        }

        Document containerLoanOfferDoc = Jsoup.parse(containerLoanOffer.html());
        Elements loanOfferVersionElements = containerLoanOfferDoc.select("div[wicketpath=multiFlow_panels_2_p_c_form_form_root_c_w_cmbLoanOfferVersion]");
        String loanOfferVersionAttributeValue = loanOfferVersionElements.select("option[selected]").attr("value");
//        String loanOfferVersionOptionValue = loanOfferVersionElements.select("option[selected]").first().textNodes().get(0).text();

        String responseSaveOffer = requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:2:p:c:form:form:root:c:w:btnSaveOffer:submit::IBehaviorListener:0:",
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
                false
        );

        requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:5:multiFlow:panels:2:p:c:form:form:root:c:w:pnlCommentAndSign:c:w:btnCompleteReview:submit::IBehaviorListener:0:",
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
                false
        );

        /*String containerWorkflowRefresh = */requestHttpGet(
                httpClient,
                "https://st1app.loftkeys.com/underwriter/form.5?wicket:interface=:5:multiFlow:panels:0:p:c:form:form:root:c:w:btnRefresh:cancel::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html");
                    }
                },
                localContext,
                false
        );

        String completeStage1Response = requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/underwriter/form.2?wicket:interface=:4:singleFlow:p:c:form:form:root:c:w:pnlApplicationList:c:w:rptApplication:c:rows:1:item:pnlApplication:c:w:btnStart:submit::IBehaviorListener:0:",
                "https://st1app.loftkeys.com/underwriter/form.5?wicket:interface=:5:multiFlow:panels:0:p:c:form:embeddedFormWrapper:embeddedForm:1:form:root:c:w:pnlStage1:c:w:btnComplete:submit::IBehaviorListener:0:",
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
                false
        );

        String containerWorkflowRefresh = requestHttpGet(
                httpClient,
                "https://st1app.loftkeys.com/underwriter/form.5?wicket:interface=:5:multiFlow:panels:0:p:c:form:form:root:c:w:btnRefresh:cancel::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html");
                    }
                },
                localContext,
                false
        );

        // TODO to save for UI !
//        Document containerWorkflowRefreshDoc = Jsoup.parse(containerWorkflowRefresh);
//        TextNode textNodeContainerWorkflowRefresh = containerWorkflowRefreshDoc.select("component[id~=p]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        Document containerWorkflowRefreshDoc2 = Jsoup.parse(textNodeContainerWorkflowRefresh.text());
////        Elements applicationList = containerWorkflowRefreshDoc2.select("div[wicketpath~=^singleFlow_p_c_form_form_root_c_w_pnlApplicationList_c_w_rptApplication_c_rows_(\\d+)_item_pnlApplication$]");
//        Elements workflowStages = containerWorkflowRefreshDoc2.select("div[id=multiFlow_panels_0_p_c_form_embeddedFormWrapper_embeddedForm_(\\d+)]");

        requestHttpPost(
                httpClient,
                "https://st1app.loftkeys.com/underwriter/form.5?wicket:interface=:5:multiFlow:panels:0:p:c:form:embeddedFormWrapper:embeddedForm:2:form:root:c:w:pnlStage2:c:w:btnOfferCredit:submit::IBehaviorListener:0:",
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
                false
        );

        System.out.println("end...");
    }
}
