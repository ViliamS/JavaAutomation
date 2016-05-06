package com.r2development.leveris.di;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.http.client.protocol.HttpClientContext;

@Singleton
public class AApolloHttpContext implements IAApolloHttpContext{

    private HttpClientContext localContext;

    @Inject
    public AApolloHttpContext(HttpClientContext localContext) {
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
