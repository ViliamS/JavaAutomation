package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.UnderwriterHttpResponse;
import com.r2development.leveris.di.User;
import com.r2development.leveris.utils.JsoupContainer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;

@Singleton
public class ApiOpoqoUnderwriterStepDef {

    private static final Log log = LogFactory.getLog(ApiOpoqoUnderwriterStepDef.class.getName());

    protected HttpClient httpClient;
    protected HttpClientContext localContext;
    protected JsoupContainer jsoupContainer;
//    protected Document applicationResult;
//    protected Elements containerPanels;
//    protected Elements containerWorkflow;
//    protected Elements containerFinance;
//    protected Elements containerLoanOffer;
//    protected Elements containerForm;
//    protected Elements containerDocuments;
//    protected Elements containerDocuments2;
//    protected Elements containerNotes;
//    protected Elements containerRisk;
//    protected Elements containerUpdateHistory;

    @Inject
    User user;
    @Inject
    UnderwriterHttpResponse httpResponse;

    public ApiOpoqoUnderwriterStepDef() {
        httpClient = ApiSupportHttpClientStepDef.getInstanceHttpClient();
        localContext = ApiSupportHttpClientStepDef.getInstanceHttpClientContext();
        jsoupContainer = ApiSupportJsoupStepDef.getInstanceJsoupContainer();
    }

    @Inject
    public ApiOpoqoUnderwriterStepDef(User user, UnderwriterHttpResponse httpResponse) {
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
