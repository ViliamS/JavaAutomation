package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IHttpResponse;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.util.EntityUtils;
import org.hamcrest.core.Is;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.Interval;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;
import static org.junit.Assert.assertThat;

@Singleton
public class ApiDocumentUploadStepDef extends ApiOpoqoBorrowerStepDef {

    enum DOCUMENT {
        PROOF_IDENTITY,
        PROOF_ADDRESS,
        MARRIAGE_CERTIFICATE,
        P60,
        CERTIFIED_ACCOUNT_LAST_YEAR,
        CERTIFIED_ACCOUNT_PREVIOUS_LAST_YEAR,
        CURRENT_PAYSLIP,
        PREVIOUS_PAYSLIP,
        SALARY_CERTIFICATE,
        CONFIRMATION_TAX_AFFAIRS,
        CURRENT_ACCOUNT,
        CREDIT_CARD_PROVIDER
    }

    private static final Log log = LogFactory.getLog(ApiDocumentUploadStepDef.class);

    @Inject
    IHttpResponse httpResponse;
    @Inject
    IUser user;

    @Inject
    public ApiDocumentUploadStepDef(IHttpResponse httpResponse, IUser user) {
        this.httpResponse = httpResponse;
        this.user = user;
    }


    @When("^user clicks on \"documents list\"$")
    public void user_clicks_on_documents_list() {
    }

    @When("^user clicks on \"DOWNLOAD CERT\"$")
    public void user_clicks_on_download_cert() {
    }

    @When("^(Borrower|Coapplicant|Borrower and Coapplicant) user upload(?:s) the file (.*) as (.*) document$")
    public void user_uploads_document(String userType, String filename, String documentType) {
    }

    @When("^Upload all documents$")
    public void upload_all_documents() throws IOException {
        Pattern p = Pattern.compile("main_c_form_form_root_c_w_pnlNew_c_w_rptDocs_c_rows_(\\d{1,2})_item_pnlDocs_c_w_lblUploadName_l\" data-height=\"\\d{1,3}\"><span>([0-9A-Za-z -]*)</span>");
        Matcher m = p.matcher(httpResponse.getHttpResponse());

        int items = 0;
//        Map<String, String> documentCollection = new LinkedHashMap<>();
        while (m.find()) {
            int currentInt = Integer.parseInt(m.group(1));
            if ( currentInt >= items )
                items = currentInt;

//            documentCollection.put(m.group(2), m.group(1));
        }

        for ( int i=1; i <= items; i++) {
            requestHttpPost(
                    httpClient,
//                    "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNew:c:w:rptDocs:c:rows:" + i + ":item:pnlDocs:c:w:lnkAddMore:dialog::IBehaviorListener:0:",
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNew:c:w:rptDocs:c:rows:" + i + ":item:pnlDocs:c:w:lnkAddMore:dialog::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    null,
                    localContext,
                    CONSUME_QUIETLY
            );

            Instant begin_timestamp = DateTime.now().toInstant();
//            HttpPost httpPostUploadDocItemDD = new HttpPost("https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlMain:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:");
            HttpPost httpPostUploadDocItemDD = new HttpPost(System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlMain:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:");
            httpPostUploadDocItemDD.setHeader("Accept-Encoding", "gzip, deflate");
            httpPostUploadDocItemDD.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            String boundary = RandomStringUtils.randomAlphanumeric(15);
            String fullBoundary = "----WebKitFormBoundary" + boundary;
            httpPostUploadDocItemDD.setHeader("Content-Type", "multipart/form-data; boundary=" + fullBoundary);

            File file2upload = null;
            try {
                //noinspection ConstantConditions
                file2upload = new File(ApiDocumentUploadStepDef.class.getClassLoader().getResource("file.txt").toURI());
            } catch (URISyntaxException | NullPointerException e) {
//                e.printStackTrace();
                log.error("File is not existed");
            }
            assertThat("File should exist", file2upload!=null && file2upload.exists(), Is.is(true));

            //noinspection ConstantConditions
            HttpEntity entityUploadDocItemDD = MultipartEntityBuilder
                    .create().setCharset(Charset.forName("UTF-8")).setBoundary(fullBoundary).setLaxMode()
                    .addTextBody("root:c:w:pnlMain:c:w:pnl:c:w:pnlDnd:data", "{\"fileName\":\"file.txt\",\"contentType\":\"text/plain\",\"data\":\"" + Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(file2upload)) + "\"}", ContentType.create("application/json", Charset.forName("UTF-8")))
                    .addTextBody("stepToken", "1", ContentType.create("text/plain", Charset.forName("UTF-8")))
                    .addTextBody("root:c:w:pnlMain:c:w:btnHiddenSubmit:submit", "1", ContentType.create("text/plain", Charset.forName("UTF-8")))
                    .addPart(file2upload.getName(), new FileBody(file2upload))
                    .build();

            httpPostUploadDocItemDD.setEntity(entityUploadDocItemDD);

            HttpResponse responseUploadDocItemDD = httpClient.execute(httpPostUploadDocItemDD, localContext);
            HttpEntity httpEntityUploadDocItemDD = responseUploadDocItemDD.getEntity();

            if (!CONSUME_QUIETLY ) {
                log.info(" = Document - Upload Doc Item " + i + " DD =============================================");
                log.info(EntityUtils.toString(httpEntityUploadDocItemDD));
            } else {
                EntityUtils.consumeQuietly(httpEntityUploadDocItemDD);
                Instant end_timestamp = DateTime.now().toInstant();
                log.info("done... in " + new Interval(begin_timestamp, end_timestamp).toDuration().toStandardSeconds());
            }

        }


        requestHttpPost(
                httpClient,
//                "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnSubmitDialog:submit::IBehaviorListener:0:",
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnSubmitDialog:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                        put("root:c:w:btnSubmitDialog:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );


    }

}
