package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.r2development.leveris.di.IABorrowerHttpContext;
import com.r2development.leveris.di.IBorrowerHttpResponse;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.And;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;

public class ApiConfigureSignLoanStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourAccountsStepDef.class.getName());

    @Inject
    IABorrowerHttpContext localContext;
    @Inject
    private IUser user;
    @Inject
    IBorrowerHttpResponse httpResponse;

    @And("(Borrower) refreshes the page")
    public void borrower_user_refreshes_the_page(String user) throws IOException {

//        System.out.println(httpResponse.getHttpResponse());
        log.info(httpResponse.getHttpResponse());

        String homeResponse = requestHttpGet(
                httpClient,
                System.getProperty("borrower.url") + "/home",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(homeResponse);

    }
}
