package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;
import org.apache.http.client.protocol.HttpClientContext;

@ImplementedBy(AHttpContext.class)
public interface IAHttpContext {
    void setHttpContext(HttpClientContext httpResponse);
    HttpClientContext getHttpContext();
}
