package com.r2development.leveris.di;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.http.client.protocol.HttpClientContext;

@Singleton
public class AHttpContext implements IAHttpContext{

    private HttpClientContext localContext;

    @Inject
    public AHttpContext(HttpClientContext localContext) {
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
