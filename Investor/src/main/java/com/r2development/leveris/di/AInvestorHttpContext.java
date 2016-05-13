package com.r2development.leveris.di;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.http.client.protocol.HttpClientContext;

@Singleton
public class AInvestorHttpContext implements IAInvestorHttpContext{

    private HttpClientContext localContext;

    @Inject
    public AInvestorHttpContext(HttpClientContext localContext) {
        this.localContext = localContext;
    }

    @Override
    public void setHttpContext(HttpClientContext localContext) {
        this.localContext = localContext;
    }

    @Override
    public HttpClientContext getHttpContext() {
        return localContext;
    }
}
