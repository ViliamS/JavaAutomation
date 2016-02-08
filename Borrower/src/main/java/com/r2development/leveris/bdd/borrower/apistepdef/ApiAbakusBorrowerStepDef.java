package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.EmploymentIncomeData;
import com.r2development.leveris.bdd.borrower.model.PersonalDetailsData;
import com.r2development.leveris.di.HttpResponse;
import com.r2development.leveris.di.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;

import java.util.LinkedHashMap;
import java.util.Map;

@Singleton
public class ApiAbakusBorrowerStepDef /*implements IBorrower*/ {

    private static final Log log = LogFactory.getLog(ApiAbakusBorrowerStepDef.class);

    protected HttpClient httpClient;
    protected HttpClientContext localContext;

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

    @Inject
    User user;

    @Inject
    HttpResponse httpResponse;

    public ApiAbakusBorrowerStepDef() {
        httpClient = ApiSupportHttpClientStepDef.getInstanceHttpClient();
        localContext = ApiSupportHttpClientStepDef.getInstanceHttpClientContext();

        registerParameters = new LinkedHashMap<>();
        loginParameters = new LinkedHashMap<>();
        quoteParameters = new LinkedHashMap<>();

        borrowerPersonalDetailsParameters = new LinkedHashMap<>();
        coapplicantPersonalDetailsParameters = new LinkedHashMap<>();

        borrowerEmploymentIncomeParameters = new LinkedHashMap<>();
        coapplicantEmploymentIncomeParameters = new LinkedHashMap<>();

        accountParameters = new LinkedHashMap<>();
    }

    @Inject
    public ApiAbakusBorrowerStepDef(User user, HttpResponse httpResponse) {
        this.user = user;
        this.httpResponse = httpResponse;
    }

    public HttpClientContext newHttpClientContext() {
        return ( localContext = ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext() );
    }

    public HttpClientContext newHttpClientContext(String domain, @SuppressWarnings("SameParameterValue") String context) {
        return ( localContext = ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext(domain, context));
    }

}
