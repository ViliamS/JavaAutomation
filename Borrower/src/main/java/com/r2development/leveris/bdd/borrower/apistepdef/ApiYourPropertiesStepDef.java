package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

@Singleton
public class ApiYourPropertiesStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourPropertiesStepDef.class);

    public ApiYourPropertiesStepDef() {
    }

    @When("^Borrower has(n't)? properties$")
    public void user_has_properties(String hasProperties) throws IOException {

        if (hasProperties == null) {
            // TODO to implement
        }
        else {

            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put(
                                "data",
                                "{" +
                                        "  \"widgets\": [" +
                                        "    {" +
                                        "      \"widget\": \"pnlMain pnlPropertyPast\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": true" +
                                        "      }," +
                                        "      \"delta\": 130," +
                                        "      \"visibleEvent\": \"show\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlMain pnlPropertyPast pnlWarning\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }" +
//                                        "    }," +
//                                        "    {" +
//                                        "      \"widget\": \"pnlMain btnDone\"," +
//                                        "      \"data\": {" +
//                                        "        \"visible\": true" +
//                                        "      }," +
//                                        "      \"visibleEvent\": \"show\"" +
//                                        "    }," +
//                                        "    {" +
//                                        "      \"widget\": \"pnlMain lblSeparator\"," +
//                                        "      \"data\": {" +
//                                        "        \"visible\": true" +
//                                        "      }," +
//                                        "      \"visibleEvent\": \"show\"" +
//                                        "    }" +
                                        "  ]" +
                                "}"
                            );
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );

        }
    }

    @When("^Borrower has(n't)? a property in the past$")
    public void user_has_properties_in_the_past(String hasPropertyInThePast) throws IOException {
        if (hasPropertyInThePast == null) {
            // TODO to implement
        }
        else {
            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:pnlPropertyPast:c:w:btnPropertyPastNoIDont:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "1");
//                            put("root:c:w:pnlMain:c:w:pnlPropertyPast:c:w:rgrPastProperty:rg:radNoPropery", "1");
                            put("root:c:w:pnlMain:c:w:pnlPropertyPast:c:w:btnPropertyPastNoIDont:submit", "1");
                            put("root:c:w:pnlMain:c:w:btnDone:submit", "1");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );

            requestHttpPost(
                    httpClient,
                    System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoProperties:c:w:btnNextSection:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "1");
                            put("root:c:w:pnlNoProperties:c:w:btnNextSection:submit", "1");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
        }
    }

    @And("^this property is applied to (borrower|coapplicant|both)$")
    public void this_property_is_applied_to(String toWhom) {
        switch (toWhom) {
            case "Borrower":
//                yourPropertiesPage.checkThisPropertyAppliesToBorrower(user.getFirstName());
                break;
            case "coapplicant":
//                yourPropertiesPage.checkThisPropertyAppliedToCoapplicant(user.getFirstNameCoApplicant());
                break;
            case "both":
//                yourPropertiesPage.checkThisPropertyAppliesToBorrower(user.getFirstName());
//                yourPropertiesPage.checkThisPropertyAppliedToCoapplicant(user.getFirstNameCoApplicant());
                break;
            default:
        }
    }

    @And("^other party has(n't)? an interest in this property$")
    public void other_party_has_interest_in_this_property(String hasInterest) {
//        if (hasInterest == null)
//            yourPropertiesPage.checkOtherPartyInterest();
    }

    @And("^this property is a (Principal Dwelling House|Investment|Holiday Home)$")
    public void this_property_is_a(String propertyCategory) {
//        yourPropertiesPage.selectPropertiesCategory(propertyCategory);
    }

    @And("^Borrower types (Investment|Holiday Home) property's monthly rent: (.*)$")
    public void user_types_property_monthly_rent(String propertyCategory, String monthlyRent) {
        switch (propertyCategory) {
            case "Investment":
//                yourPropertiesPage.typeINV_MonthlyRent(monthlyRent);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_MonthlyRent(monthlyRent);
                break;
            default:
        }
    }

    @And("^Borrower selects (Investment|Holiday Home) property's rent: (Seasonal|Guaranteed)$")
    public void user_types_property_is_a_(String propertyCategory, String rentType) {
        switch (propertyCategory) {
            case "Investment":
//                yourPropertiesPage.selectINV_RentType(rentType);
                break;
            case "Holiday Home":
//                yourPropertiesPage.selectHH_RentType(rentType);
                break;
            default:
        }
    }

    @And("^this Principal Dwelling House property's address is same as home address$")
    public void this_property_address_is_same_as_home_address() {
//        yourPropertiesPage.clickPDH_SameAsHomeAddress();
    }

    @And("^Borrower types the (Principal Dwelling House|Investment|Holiday Home) property's address line 1: (.*)$")
    public void user_types_the_property_address_line_1(String propertyCategory, String addressLine1) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_AddressLine1(addressLine1);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_AddressLine1(addressLine1);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_AddressLine1(addressLine1);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investment|Holiday Home) property's address line 2: (.*)$")
    public void user_types_the_property_address_line_2(String propertyCategory, String addressLine2) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_AddressLine2(addressLine2);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_AddressLine2(addressLine2);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_AddressLine2(addressLine2);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investment|Holiday Home) property's town city: (.*)$")
    public void user_types_the_property_town_city(String propertyCategory, String townCity) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_TownCity(townCity);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_TownCity(townCity);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_TownCity(townCity);
                break;
            default:
        }
    }

    @And("^Borrower selects the (Principal Dwelling House|Investment|Holiday Home) property's county: (.*)$")
    public void user_selects_the_property_county(String propertyCategory, String county) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.selectPDH_County(county);
                break;
            case "Investment":
//                yourPropertiesPage.selectINV_County(county);
                break;
            case "Holiday Home":
//                yourPropertiesPage.selectHH_County(county);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investment|Holiday Home) property's post code: (.*)$")
    public void user_types_the_property_post_code(String propertyCategory, String postcode) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_Postcode(postcode);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_Postcode(postcode);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_Postcode(postcode);
                break;
            default:
        }
    }

    @And("^Borrower selects the (Principal Dwelling House|Investment|Holiday Home) property's country: (.*)$")
    public void user_types_the_property_country(String propertyCategory, String country) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.selectPDH_Country(country);
                break;
            case "Investment":
//                yourPropertiesPage.selectINV_Country(country);
                break;
            case "Holiday Home":
//                yourPropertiesPage.selectHH_Country(country);
                break;
            default:
        }
    }

    @And("^Borrower selects the (Principal Dwelling House|Investment|Holiday Home) property's type: (Detached house|Detached house with basement|Semi detached house|Semi detached house with basement|Terraced|Terraced house with basement|Bungalow|Bungalow with basement|Apartment/Flat/Duplex|Purpose built duplex)$")
    public void user_selects_the_property_type(String propertyCategory, String propertyType) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.selectPDH_PropertyType(propertyType);
                break;
            case "Investment":
//                yourPropertiesPage.selectINV_PropertyType(propertyType);
                break;
            case "Holiday Home":
//                yourPropertiesPage.selectHH_PropertyType(propertyType);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investment|Holiday Home) property's number of bedrooms: (.*)$")
    public void user_types_the_property_type(String propertyCategory, String numberBedrooms) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_NumberBedrooms(numberBedrooms);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_NumberBedrooms(numberBedrooms);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_NumberBedrooms(numberBedrooms);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investment|Holiday Home) property's acquired year: (.*)")
    public void user_types_the_property_acquired_year(String propertyCategory, String acquiredYear) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_AcquiredYear(acquiredYear);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_AcquiredYear(acquiredYear);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_AcquiredYear(acquiredYear);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investment|Holiday Home) property's original purchase price: (.*)")
    public void user_types_the_property_original_purchase_price(String propertyCategory, String originalPurchasePrice) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_OriginalPurchasePrice(originalPurchasePrice);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_OriginalPurchasePrice(originalPurchasePrice);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_OriginalPurchasePrice(originalPurchasePrice);
                break;
            default:
        }
//        yourPropertiesPage.typePDH_OriginalPurchasePrice(originalPurchasePrice);
    }

    @And("^Borrower chooses the (Principal Dwelling House|Investment|Holiday Home) property if planned to sell: (Yes|No)$")
    public void user_chooses_the_property_if_planned(String propertyCategory, String isPlanned) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                if ( isPlanned.equals("Yes") )
//                    yourPropertiesPage.clickPDH_SellPlanYes();
//                else
//                    yourPropertiesPage.clickPDH_SellPlanNo();
                break;
            case "Investment":
//                if ( isPlanned.equals("Yes") )
//                    yourPropertiesPage.clickINV_SellPlanYes();
//                else
//                    yourPropertiesPage.clickINV_SellPlanNo();
                break;
            case "Holiday Home":
//                if ( isPlanned.equals("Yes") )
//                    yourPropertiesPage.clickHH_SellPlanYes();
//                else
//                    yourPropertiesPage.clickHH_SellPlanNo();
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investment|Holiday Home) property's estimated value/sale agreed price: (.*)$")
    public void user_types_the_property_estimation_price(String propertyCategory, String estimationPrice) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_EstimationPrice(estimationPrice);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_EstimationPrice(estimationPrice);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_EstimationPrice(estimationPrice);
                break;
            default:
        }
    }

    @And("^Borrower selects the (Principal Dwelling House|Investment|Holiday Home) property if mortgaged: (Yes|No, Mortgage Repaid|No, Never Had a Mortgage)$")
    public void user_selects_the_property_if_mortgaged(String propertyCategory, String propertyMortgaged) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.selectPDH_MortgageQuestion(propertyMortgaged);
                break;
            case "Investment":
//                yourPropertiesPage.selectINV_MortgageQuestion(propertyMortgaged);
                break;
            case "Holiday Home":
//                yourPropertiesPage.selectHH_MortgageQuestion(propertyMortgaged);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investment|Holiday Home) property's repaid mortgage provider: (.*)$")
    public void user_selects_the_property_repaid_mortgage_provider(String propertyCategory, String mortgageRepaidProvider) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_MortgageRepaidProvider(mortgageRepaidProvider);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_MortgageRepaidProvider(mortgageRepaidProvider);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_MortgageRepaidProvider(mortgageRepaidProvider);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investment|Holiday Home) property's repaid mortgage year: (.*)$")
    public void user_selects_the_property_repaid_mortgage_year(String propertyCategory, String mortgageRepaidYear) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_MortgageRepaidYear(mortgageRepaidYear);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_MortgageRepaidYear(mortgageRepaidYear);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_MortgageRepaidYear(mortgageRepaidYear);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investiment|Holiday Home) property's mortgage provider: (.*)$")
    public void user_types_the_property_mortgage_provider(String propertyCategory, String mortgageProvider) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_MortgageProvider(mortgageProvider);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_MortgageProvider(mortgageProvider);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_MortgageProvider(mortgageProvider);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage account number: (.*)$")
    public void user_types_the_property_position_mortgage_account_number(String propertyCategory, String position, String mortgageAccountNumber) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_MortgageAccountNumber(mortgageAccountNumber, position);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_MortgageAccountNumber(mortgageAccountNumber, position);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_MortgageAccountNumber(mortgageAccountNumber, position);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage account balance: (.*)$")
    public void user_types_the_property_position_mortgage_account_balance(String propertyCategory, String position, String mortgageAccountNumber) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_MortgageAccountBalance(mortgageAccountNumber, position);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_MortgageAccountBalance(mortgageAccountNumber, position);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_MortgageAccountBalance(mortgageAccountNumber, position);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage account monthly payment: (.*)$")
    public void user_types_the_property_position_mortgage_account_payment(String propertyCategory, String position, String mortgageMonthlyPayment) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_MortgageAccountMonthlyPayment(mortgageMonthlyPayment, position);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_MortgageAccountMonthlyPayment(mortgageMonthlyPayment, position);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_MortgageAccountMonthlyPayment(mortgageMonthlyPayment, position);
                break;
            default:
        }
    }

    @And("^Borrower types the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage account interest rate: (.*)$")
    public void user_types_the_property_position_mortgage_account_interest_rate(String propertyCategory, String position, String accountInterestRate) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.typePDH_MortgageAccountInterestRate(accountInterestRate, position);
                break;
            case "Investment":
//                yourPropertiesPage.typeINV_MortgageAccountInterestRate(accountInterestRate, position);
                break;
            case "Holiday Home":
//                yourPropertiesPage.typeHH_MortgageAccountInterestRate(accountInterestRate, position);
                break;
            default:
        }
    }

    @And("^Borrower (un)?checks the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage account only interest$")
    public void user_unchecks_or_checks_the_property_position_mortgage_account_interest_rate(String isUncheck, String propertyCategory, String position) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                if ( isUncheck == null)
//                    yourPropertiesPage.checkPDH_MortgageAccountOnlyInterest(position);
                break;
            case "Investment":
                if ( isUncheck == null)
//                    yourPropertiesPage.checkINV_MortgageAccountOnlyInterest(position);
                break;
            case "Holiday Home":
                if ( isUncheck == null)
//                    yourPropertiesPage.checkHH_MortgageAccountOnlyInterest(position);
                break;
            default:
        }
    }

    @And("^Borrower selects the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage rate type: (Fixed|Variable)$")
    public void user_unchecks_or_checks_the_property_position_mortgage_account_rate_type(String propertyCategory, String position, String mortgageRateType) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                yourPropertiesPage.selectPDH_MortgageAccountRateType(mortgageRateType, position);
                break;
            case "Investment":
//                yourPropertiesPage.selectINV_MortgageAccountRateType(mortgageRateType, position);
                break;
            case "Holiday Home":
//                yourPropertiesPage.selectHH_MortgageAccountRateType(mortgageRateType, position);
                break;
            default:
        }
    }

    @And("^Borrower chooses the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage last 24 month: (YES|NO)$")
    public void user_chooses_the_property_position_mortgage_account_24_month(String propertyCategory, String position, String yesNo24Month) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
//                if ( yesNo24Month.equals("YES"))
//                    yourPropertiesPage.checkPDH_MortgageAccount24MonthYes(position);
//                else
//                    yourPropertiesPage.checkPDH_MortgageAccount24MonthNo(position);
                break;
            case "Investment":
//                if ( yesNo24Month.equals("YES"))
//                    yourPropertiesPage.checkINV_MortgageAccount24MonthYes(position);
//                else
//                    yourPropertiesPage.checkINV_MortgageAccount24MonthNo(position);
                break;
            case "Holiday Home":
//                if ( yesNo24Month.equals("YES"))
//                    yourPropertiesPage.checkHH_MortgageAccount24MonthYes(position);
//                else
//                    yourPropertiesPage.checkHH_MortgageAccount24MonthNo(position);
                break;
            default:
        }
    }

    @And("^Borrower clicks \"ADD THIS PROPERTY\"$")
    public void user_clicks_add_this_property() {
//        yourPropertiesPage.clickAddThisProperty();
    }

    @And("^Borrower clicks PROPERTY \"CANCEL\"$")
    public void user_clicks_property_cancel() {
//        yourPropertiesPage.clickCancel();
    }

    @And("^Borrower clicks \"ADD PROPERTY\"$")
    public void user_clicks_add_property() {
//        yourPropertiesPage.clickAddProperty();
    }

    @And("^Borrower clicks PROPERTY \"NEXT\"$")
    public void user_clicks_property_next() {
//        yourPropertiesPage.clickNext();
    }

    @And("^Borrower clicks \"EDIT THIS PROPERTY\"$")
    public void user_clicks_edit_this_property() {
//        yourPropertiesPage.clickEditThisProperty();
    }

    @And("^Borrower clicks \"ADD ANOTHER MORTGAGE ACCOUNT\"$")
    public void user_clicks_add_another_mortgage_account() {
//        yourPropertiesPage.clickAddAnotherMortgageAccount();
    }
}
