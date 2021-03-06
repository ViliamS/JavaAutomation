package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;
import org.apache.http.client.protocol.HttpClientContext;

@ImplementedBy(AInvestorHttpContext.class)
public interface IAInvestorHttpContext {
    void setHttpContext(HttpClientContext httpResponse);
    HttpClientContext getHttpContext();
}
