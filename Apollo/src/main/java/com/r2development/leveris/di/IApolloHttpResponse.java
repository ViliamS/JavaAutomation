package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;

@ImplementedBy(ApolloHttpResponse.class)
public interface IApolloHttpResponse {
    void setHttpResponse(String httpResponse);
    String getHttpResponse();
}
