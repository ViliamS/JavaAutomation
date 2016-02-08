package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;

@ImplementedBy(com.r2development.leveris.di.HttpResponse.class)
public interface IHttpResponse {
    void setHttpResponse(String httpResponse);
    String getHttpResponse();
}
