package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;

@ImplementedBy(HttpResponse.class)
public interface IHttpResponse {
    void setHttpResponse(String httpResponse);
    String getHttpResponse();
}
