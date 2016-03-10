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
public class ApiYourDependentsStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourDependentsStepDef.class);

    @When("^Borrower has(n't)? dependents$")
    public void user_has_dependencies(String hasDependents) throws IOException {
        if (hasDependents == null) {
            // TODO to implement
//            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
//                yourDependentsPage.clickCoupleYes();
//            else
//                yourDependentsPage.clickSingleYes();
        }
        else {
//            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
//                yourDependentsPage.clickCoupleNo();
//            else
//                yourDependentsPage.clickSingleNo();
//            yourDependentsPage.clickNext();

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

    @Deprecated @And("^this dependent is applied to (borrower|coapplicant|both)$")
    public void this_dependent_is_applied_to(String toWhom) {
        switch (toWhom) {
            case "Borrower":
//                yourDependentsPage.checkAccountAppliesToBorrower(user.getFirstName());
                break;
            case "coapplicant":
//                yourDependentsPage.checkAccountAppliesToCoapplicant(user.getFirstNameCoApplicant());
                break;
            case "both":
//                yourDependentsPage.checkAccountAppliesToBorrower(user.getFirstName());
//                yourDependentsPage.checkAccountAppliesToCoapplicant(user.getFirstNameCoApplicant());
                break;
            default:
        }
    }

    @And("^Borrower types the Dependent date of birth: (.*)$")
    public void user_types_Dependent_date_of_birth(String dateOfBirth) {
//        yourDependentsPage.typeDateOfBirth(dateOfBirth);
    }

    @And("^Borrower clicks \"ADD THIS DEPENDENT\"$")
    public void user_clicks_add_this_dependent() {
//        yourDependentsPage.clickAddThisDependent();
    }

    @And("^Borrower clicks \"ADD DEPENDENT\"$")
    public void user_clicks_add_dependent() {
//        yourDependentsPage.clickAddDependent();
    }

    @And("^Borrower clicks Dependents \"NEXT\"$")
    public void user_clicks_dependents_next() {
//        yourDependentsPage.clickNext();
    }
}
