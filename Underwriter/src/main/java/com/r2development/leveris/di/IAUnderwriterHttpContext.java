package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;
import org.apache.http.client.protocol.HttpClientContext;

@ImplementedBy(AUnderwriterHttpContext.class)
public interface IAUnderwriterHttpContext {
    void setHttpContext(HttpClientContext httpResponse);
    HttpClientContext getHttpContext();
}
