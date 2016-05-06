package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.EmploymentIncomeData;
import com.r2development.leveris.bdd.borrower.model.PersonalDetailsData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HttpContext;

import java.util.LinkedHashMap;
import java.util.Map;

@Singleton
public class ApiOpoqoBorrowerStepDef /*implements IBorrower*/ {

    private static final Log log = LogFactory.getLog(ApiOpoqoBorrowerStepDef.class);

    protected HttpClient httpClient;
//    protected HttpClientContext localContext;
    protected HttpContext localContext;

    protected Map<String, String> registerParameters;
    protected Map<String, String> automationRegistrationParameters;
    protected Map<String, String> loginParameters;
    protected Map<String, String> quoteParameters;

    protected PersonalDetailsData borrowerPersonalDetailsData;
    protected Map<String, String> borrowerPersonalDetailsParameters;
    protected PersonalDetailsData coapplicantPersonalDetailsData;
    protected Map<String, String> coapplicantPersonalDetailsParameters;

    protected EmploymentIncomeData borrowerEmploymentIncomeData;
    protected Map<String, String> borrowerEmploymentIncomeParameters;
    protected EmploymentIncomeData coapplicantEmploymentIncomeData;
    protected Map<String, String> coapplicantEmploymentIncomeParameters;

    protected Map<String, String> accountParameters;
    protected Map<String, String> dependantParameters;
    protected Map<String, String> financialParameters;
    protected Map<String, String> residencyParameters;
    protected Map<String, String> paydayParameters;
    protected Map<String, String> unsecuredParameters;

//    @Inject
//    IUser user;
//    @Inject
//    IHttpResponse httpResponse;

//    @Inject
    public ApiOpoqoBorrowerStepDef(/*IUser user, IHttpResponse httpResponse*/) {

//        this.user = user;
//        this.httpResponse = httpResponse;

        httpClient = ApiSupportHttpClientStepDef.getInstanceHttpClient();
//        localContext = ApiSupportHttpClientStepDef.getInstanceHttpClientContext();
//        localContext = ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext();
//        localContext = ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext(System.getProperty("domain.borrower"), "/stable-borrower");

//        httpClient = HttpUtils.createHttpClient();
//        localContext = HttpUtils.initContext(System.getProperty("domain.borrower"), "/stable-borrower");

        registerParameters = new LinkedHashMap<>();
        loginParameters = new LinkedHashMap<>();
        quoteParameters = new LinkedHashMap<>();

        borrowerPersonalDetailsParameters = new LinkedHashMap<>();
        coapplicantPersonalDetailsParameters = new LinkedHashMap<>();

        borrowerEmploymentIncomeParameters = new LinkedHashMap<>();
        coapplicantEmploymentIncomeParameters = new LinkedHashMap<>();

        accountParameters = new LinkedHashMap<>();
        paydayParameters = new LinkedHashMap<>();
        unsecuredParameters = new LinkedHashMap<>();
        dependantParameters = new LinkedHashMap<>();
        financialParameters = new LinkedHashMap<>();
        residencyParameters = new LinkedHashMap<>();

        automationRegistrationParameters = new LinkedHashMap<>();
    }

//    @Inject
//    public ApiOpoqoBorrowerStepDef(IUser user, IHttpResponse httpResponse) {
//        this.user = user;
//        this.httpResponse = httpResponse;
//    }

    public HttpContext newHttpClientContext() {
        return ( localContext = ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext() );
    }

    public HttpContext newHttpClientContext(String domain, @SuppressWarnings("SameParameterValue") String context) {
        return ( localContext = ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext(domain, context));
    }

}
