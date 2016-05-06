package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;

@ImplementedBy(BorrowerHttpResponse.class)
public interface IBorrowerHttpResponse {
    void setHttpResponse(String httpResponse);
    String getHttpResponse();
}
