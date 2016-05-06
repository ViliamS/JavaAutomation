package com.r2development.leveris.bdd.apollo.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;

import java.util.LinkedHashMap;
import java.util.Map;

@Singleton
public class ApiOpoqoApolloStepDef /*implements IBorrower*/ {

    private static final Log log = LogFactory.getLog(ApiOpoqoApolloStepDef.class);

    protected HttpClient httpClient;
    protected HttpClientContext localContext;
//    protected HttpContext localContext;

//    protected Map<String, String> registerParameters;
//    protected Map<String, String> automationRegistrationParameters;
    protected Map<String, String> loginParameters;
//    protected Map<String, String> quoteParameters;

//    protected PersonalDetailsData borrowerPersonalDetailsData;
//    protected Map<String, String> borrowerPersonalDetailsParameters;
//    protected PersonalDetailsData coapplicantPersonalDetailsData;
//    protected Map<String, String> coapplicantPersonalDetailsParameters;

//    protected EmploymentIncomeData borrowerEmploymentIncomeData;
//    protected Map<String, String> borrowerEmploymentIncomeParameters;
//    protected EmploymentIncomeData coapplicantEmploymentIncomeData;
//    protected Map<String, String> coapplicantEmploymentIncomeParameters;

//    protected Map<String, String> accountParameters;
//    protected Map<String, String> paydayParameters;

    @Inject
    IUser user;

//    TODO ApolloHttpResponse
//    @Inject
//    IHttpResponse httpResponse;

    public ApiOpoqoApolloStepDef() {
        httpClient = ApiSupportHttpClientStepDef.getInstanceHttpClient();
        localContext = ApiSupportHttpClientStepDef.getInstanceHttpClientContext();

//        registerParameters = new LinkedHashMap<>();
        loginParameters = new LinkedHashMap<>();
//        quoteParameters = new LinkedHashMap<>();

//        borrowerPersonalDetailsParameters = new LinkedHashMap<>();
//        coapplicantPersonalDetailsParameters = new LinkedHashMap<>();

//        borrowerEmploymentIncomeParameters = new LinkedHashMap<>();
//        coapplicantEmploymentIncomeParameters = new LinkedHashMap<>();

//        accountParameters = new LinkedHashMap<>();
//        paydayParameters = new LinkedHashMap<>();
    }

//    @Inject
//    public ApiOpoqoApolloStepDef(IUser user, IHttpResponse httpResponse) {
//        this.user = user;
//        this.httpResponse = httpResponse;
//    }

    @Inject
    public ApiOpoqoApolloStepDef(IUser user/*, IHttpResponse httpResponse*/) {
        this.user = user;
//        this.httpResponse = httpResponse;
    }

    public HttpContext newHttpClientContext() {
        return ( localContext = ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext() );
    }

    public HttpContext newHttpClientContext(String domain, @SuppressWarnings("SameParameterValue") String context) {
        return ( localContext = ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext(domain, context));
    }

}
