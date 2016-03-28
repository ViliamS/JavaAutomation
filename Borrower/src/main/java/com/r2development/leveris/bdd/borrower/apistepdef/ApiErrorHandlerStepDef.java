package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.r2development.leveris.di.IErrorHandler;
import cucumber.api.java.en.Then;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;

import java.util.Map;

/**
 * Created by anthonymottot on 22/03/2016.
 */
public class ApiErrorHandlerStepDef {

//    Borrower should see these validation errors
//
    @Inject
    IErrorHandler errorHandler;

    @Inject
    ApiErrorHandlerStepDef(IErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Then("^(Borrower) sees these errors messages$")
    public void borrower_sees_these_error_messages(String userType, Map<String, String> values) {
        Assert.assertEquals(
                true,
                CollectionUtils.isEqualCollection(
                        errorHandler.getKeySet(),
                        values.keySet()
                )
                &&
                CollectionUtils.isEqualCollection(
                        errorHandler.getValues(),
                        values.values()
                )
        );
    }

    @Then("^(Borrower) don't see these errors message$")
    public void borrower_do_not_sees_these_error_messages(String userType, Map<String, String> values) {
        Assert.assertEquals(
                true,
                CollectionUtils.isSubCollection(values.keySet(), errorHandler.getKeySet())
                ||
                CollectionUtils.isSubCollection(values.values(), errorHandler.getValues())
        );
    }

}
