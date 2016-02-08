package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Singleton;
import cucumber.api.java.en.Given;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;

@Singleton
public class ApiSsoStepDef extends ApiAbakusUnderwriterStepDef {

    private static final Log log = LogFactory.getLog(ApiSsoStepDef.class.getName());

    private String ssoTicket;

    @Given("^user processes SSO Auth Step 1$")
    public void user_processes_sso_auth_step1() throws IOException {
        HttpPost httpPostValidateAuthProcessStep = new HttpPost("https://st1apl.loftkeys.com/sso/api/public/sso/validateAuthProcessStep");
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
    }

    @Given("^user processes SSO Auth Step 2$")
    public void user_processes_sso_auth_step2() throws IOException {
        HttpPost httpPostValidateAuthProcessStep2 = new HttpPost("https://st1apl.loftkeys.com/sso/api/public/sso/validateAuthProcessStep");
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

        ssoTicket = jsonObject.get("serviceTicket").getAsString();
        System.out.println("TICKET: " + ssoTicket);
    }

    @Given("^user processes final SSO Auth Step$")
    public void user_processes_final_sso_auth_step() throws IOException {
        String authenticateResponse;

        authenticateResponse = requestHttpGet(
                    httpClient,
                    "https://st1app.loftkeys.com/underwriter/home?useCase=authenticate&ticket=" + ssoTicket,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );

        if ( authenticateResponse.contains("// dynamic script begin: LoginErrorView") ) {
            do {
                user_processes_sso_auth_step1();
                user_processes_sso_auth_step2();
            } while ( authenticateResponse.contains("// dynamic script begin: LoginErrorView") );
        }
    }
}
