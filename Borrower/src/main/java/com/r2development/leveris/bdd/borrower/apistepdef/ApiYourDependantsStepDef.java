package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.utils.HttpUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;

@Singleton
public class ApiYourDependantsStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourDependantsStepDef.class);

    @When("^Borrower has(n't)? dependants$")
    public void user_has_dependencies(String hasDependants) throws IOException {
        if (hasDependants == null) {
            // TODO to implement
//            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
//                yourDependantsPage.clickCoupleYes();
//            else
//                yourDependantsPage.clickSingleYes();
        }
        else {
//            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
//                yourDependantsPage.clickCoupleNo();
//            else
//                yourDependantsPage.clickSingleNo();
//            yourDependantsPage.clickNext();

            HttpUtils.requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:btnNoneDependants:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "1");
                            put("root:c:w:pnlNoEmplyments:c:w:btnNoneDependants:submit", "1");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );

            HttpUtils.requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:btnNextSection:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "2");
                            put("root:c:w:pnlNoEmplyments:c:w:btnNextSection:submit", "1");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
        }
    }

    @Deprecated @And("^this dependant is applied to (borrower|coapplicant|both)$")
    public void this_dependant_is_applied_to(String toWhom) {
        switch (toWhom) {
            case "Borrower":
//                yourDependantsPage.checkAccountAppliesToBorrower(user.getFirstName());
                break;
            case "coapplicant":
//                yourDependantsPage.checkAccountAppliesToCoapplicant(user.getFirstNameCoApplicant());
                break;
            case "both":
//                yourDependantsPage.checkAccountAppliesToBorrower(user.getFirstName());
//                yourDependantsPage.checkAccountAppliesToCoapplicant(user.getFirstNameCoApplicant());
                break;
            default:
        }
    }

    @And("^Borrower types the dependant date of birth: (.*)$")
    public void user_types_dependant_date_of_birth(String dateOfBirth) {
//        yourDependantsPage.typeDateOfBirth(dateOfBirth);
    }

    @And("^Borrower clicks \"ADD THIS DEPENDANT\"$")
    public void user_clicks_add_this_dependant() {
//        yourDependantsPage.clickAddThisDependant();
    }

    @And("^Borrower clicks \"ADD DEPENDANT\"$")
    public void user_clicks_add_dependant() {
//        yourDependantsPage.clickAddDependant();
    }

    @And("^Borrower clicks Dependants \"NEXT\"$")
    public void user_clicks_dependants_next() {
//        yourDependantsPage.clickNext();
    }
}
