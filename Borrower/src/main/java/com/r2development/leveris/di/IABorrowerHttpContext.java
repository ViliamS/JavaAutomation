package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;
import org.apache.http.client.protocol.HttpClientContext;

@ImplementedBy(ABorrowerHttpContext.class)
public interface IABorrowerHttpContext {
    void setHttpContext(HttpClientContext httpResponse);
    HttpClientContext getHttpContext();
}
