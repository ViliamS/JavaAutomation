package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;

@ImplementedBy(UnderwriterHttpResponse.class)
public interface IUnderwriterHttpResponse {
    void setHttpResponse(String httpResponse);
    String getHttpResponse();
}
