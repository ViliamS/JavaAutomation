package com.r2development.leveris.di;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class BorrowerHttpResponse implements IBorrowerHttpResponse{

    private String httpResponse;

    @Inject
    public BorrowerHttpResponse(String httpResponse) {
        this.httpResponse = httpResponse;
    }

    @Override
    public void setHttpResponse(String httpResponse) {
        this.httpResponse = httpResponse;
    }

    @Override
    public String getHttpResponse() {
        return httpResponse;
    }
}
