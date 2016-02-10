package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.selenium.borrower.pageobjects.IFormsMenu;
import com.r2development.leveris.selenium.borrower.pageobjects.YourPropertiesPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;

@Singleton
public class YourPropertiesStepDef extends BorrowerStepDef implements CLV312Workaround {

    private static final Log log = LogFactory.getLog(YourPropertiesStepDef.class);

    public YourPropertiesStepDef() {
        yourPropertiesPage = new YourPropertiesPage(WebDriverService.getWebDriverInstance());
    }

    // TODO HANDLE NUMBER mortgage by order created property and by property category

    @When("^user has(n't)? properties$")
    public void user_has_properties(String hasProperties) throws InterruptedException {
        workaroundCLV312(null);

        if (hasProperties == null) {
            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
                yourPropertiesPage.clickCoupleYes();
            else
                yourPropertiesPage.clickSingleYes();
        }
        else {
            if (StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
                yourPropertiesPage.clickCoupleNo();
            else
                yourPropertiesPage.clickSingleNo();
        }
    }

    @Override
    public void workaroundCLV312(String borrowerOrCoapplicant) {
        borrowerHomePage.clickInfoUpload();

        boolean toGoOn = false;
        while ( !toGoOn ) {
            try {
                if ( StringUtils.isEmpty(user.getFirstNameCoApplicant()))
                    borrowerPersonalDetailsPage.clickProperties();
                else
                    ((IFormsMenu)borrowerPersonalDetailsPage).clickProperties("double");
                yourPropertiesPage.getYourPropertiesTitle();
                toGoOn = true;
            } catch (TimeoutException te) {
                log.debug("Issues of getting Properties page.");
            }
        }
    }

    @When("^user has(n't)? a property in the past$")
    public void user_has_properties_in_the_past(String hasPropertyInThePast) {
        if (hasPropertyInThePast == null) {
            if (user.getFirstNameCoApplicant() != null && StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
                yourPropertiesPage.clickPastCoupleYes();
            else
                yourPropertiesPage.clickPastSingleYes();
        }
        else {
            if (user.getFirstNameCoApplicant() != null && StringUtils.isNotEmpty(user.getFirstNameCoApplicant()))
                yourPropertiesPage.clickPastCoupleNo();
            else
                yourPropertiesPage.clickPastSingleNo();
            yourPropertiesPage.clickNext();
            yourPropertiesPage.clickNextSection();
        }
    }

    @And("^this property is applied to (borrower|coapplicant|both)$")
    public void this_property_is_applied_to(String toWhom) {
        switch (toWhom) {
            case "borrower":
                yourPropertiesPage.checkThisPropertyAppliesToBorrower(user.getFirstName());
                break;
            case "coapplicant":
                yourPropertiesPage.checkThisPropertyAppliedToCoapplicant(user.getFirstNameCoApplicant());
                break;
            case "both":
                yourPropertiesPage.checkThisPropertyAppliesToBorrower(user.getFirstName());
                yourPropertiesPage.checkThisPropertyAppliedToCoapplicant(user.getFirstNameCoApplicant());
                break;
            default:
        }
    }

    @And("^other party has(n't)? an interest in this property$")
    public void other_party_has_interest_in_this_property(String hasInterest) {
        if (hasInterest == null)
            yourPropertiesPage.checkOtherPartyInterest();
    }

    @And("^this property is a (Principal Dwelling House|Investment|Holiday Home)$")
    public void this_property_is_a(String propertyCategory) {
        yourPropertiesPage.selectPropertiesCategory(propertyCategory);
    }

    @And("^user types (Investment|Holiday Home) property's monthly rent: (.*)$")
    public void user_types_property_monthly_rent(String propertyCategory, String monthlyRent) {
        switch (propertyCategory) {
            case "Investment":
                yourPropertiesPage.typeINV_MonthlyRent(monthlyRent);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_MonthlyRent(monthlyRent);
                break;
            default:
        }
    }

    @And("^user selects (Investment|Holiday Home) property's rent: (Seasonal|Guaranteed)$")
    public void user_types_property_is_a_(String propertyCategory, String rentType) {
        switch (propertyCategory) {
            case "Investment":
                yourPropertiesPage.selectINV_RentType(rentType);
                break;
            case "Holiday Home":
                yourPropertiesPage.selectHH_RentType(rentType);
                break;
            default:
        }
    }

    @And("^this Principal Dwelling House property's address is same as home address$")
    public void this_property_address_is_same_as_home_address() {
        yourPropertiesPage.clickPDH_SameAsHomeAddress();
    }

    @And("^user types the (Principal Dwelling House|Investment|Holiday Home) property's address line 1: (.*)$")
    public void user_types_the_property_address_line_1(String propertyCategory, String addressLine1) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_AddressLine1(addressLine1);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_AddressLine1(addressLine1);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_AddressLine1(addressLine1);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investment|Holiday Home) property's address line 2: (.*)$")
    public void user_types_the_property_address_line_2(String propertyCategory, String addressLine2) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_AddressLine2(addressLine2);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_AddressLine2(addressLine2);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_AddressLine2(addressLine2);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investment|Holiday Home) property's town city: (.*)$")
    public void user_types_the_property_town_city(String propertyCategory, String townCity) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_TownCity(townCity);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_TownCity(townCity);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_TownCity(townCity);
                break;
            default:
        }
    }

    @And("^user selects the (Principal Dwelling House|Investment|Holiday Home) property's county: (.*)$")
    public void user_selects_the_property_county(String propertyCategory, String county) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.selectPDH_County(county);
                break;
            case "Investment":
                yourPropertiesPage.selectINV_County(county);
                break;
            case "Holiday Home":
                yourPropertiesPage.selectHH_County(county);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investment|Holiday Home) property's post code: (.*)$")
    public void user_types_the_property_post_code(String propertyCategory, String postcode) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_Postcode(postcode);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_Postcode(postcode);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_Postcode(postcode);
                break;
            default:
        }
    }

    @And("^user selects the (Principal Dwelling House|Investment|Holiday Home) property's country: (.*)$")
    public void user_types_the_property_country(String propertyCategory, String country) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.selectPDH_Country(country);
                break;
            case "Investment":
                yourPropertiesPage.selectINV_Country(country);
                break;
            case "Holiday Home":
                yourPropertiesPage.selectHH_Country(country);
                break;
            default:
        }
    }

    @And("^user selects the (Principal Dwelling House|Investment|Holiday Home) property's type: (Detached house|Detached house with basement|Semi detached house|Semi detached house with basement|Terraced|Terraced house with basement|Bungalow|Bungalow with basement|Apartment/Flat/Duplex|Purpose built duplex)$")
    public void user_selects_the_property_type(String propertyCategory, String propertyType) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.selectPDH_PropertyType(propertyType);
                break;
            case "Investment":
                yourPropertiesPage.selectINV_PropertyType(propertyType);
                break;
            case "Holiday Home":
                yourPropertiesPage.selectHH_PropertyType(propertyType);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investment|Holiday Home) property's number of bedrooms: (.*)$")
    public void user_types_the_property_type(String propertyCategory, String numberBedrooms) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_NumberBedrooms(numberBedrooms);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_NumberBedrooms(numberBedrooms);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_NumberBedrooms(numberBedrooms);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investment|Holiday Home) property's acquired year: (.*)")
    public void user_types_the_property_acquired_year(String propertyCategory, String acquiredYear) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_AcquiredYear(acquiredYear);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_AcquiredYear(acquiredYear);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_AcquiredYear(acquiredYear);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investment|Holiday Home) property's original purchase price: (.*)")
    public void user_types_the_property_original_purchase_price(String propertyCategory, String originalPurchasePrice) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_OriginalPurchasePrice(originalPurchasePrice);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_OriginalPurchasePrice(originalPurchasePrice);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_OriginalPurchasePrice(originalPurchasePrice);
                break;
            default:
        }
        yourPropertiesPage.typePDH_OriginalPurchasePrice(originalPurchasePrice);
    }

    @And("^user chooses the (Principal Dwelling House|Investment|Holiday Home) property if planned to sell: (Yes|No)$")
    public void user_chooses_the_property_if_planned(String propertyCategory, String isPlanned) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                if ( isPlanned.equals("Yes") )
                    yourPropertiesPage.clickPDH_SellPlanYes();
                else
                    yourPropertiesPage.clickPDH_SellPlanNo();
                break;
            case "Investment":
                if ( isPlanned.equals("Yes") )
                    yourPropertiesPage.clickINV_SellPlanYes();
                else
                    yourPropertiesPage.clickINV_SellPlanNo();
                break;
            case "Holiday Home":
                if ( isPlanned.equals("Yes") )
                    yourPropertiesPage.clickHH_SellPlanYes();
                else
                    yourPropertiesPage.clickHH_SellPlanNo();
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investment|Holiday Home) property's estimated value/sale agreed price: (.*)$")
    public void user_types_the_property_estimation_price(String propertyCategory, String estimationPrice) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_EstimationPrice(estimationPrice);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_EstimationPrice(estimationPrice);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_EstimationPrice(estimationPrice);
                break;
            default:
        }
    }

    @And("^user selects the (Principal Dwelling House|Investment|Holiday Home) property if mortgaged: (Yes|No, Mortgage Repaid|No, Never Had a Mortgage)$")
    public void user_selects_the_property_if_mortgaged(String propertyCategory, String propertyMortgaged) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.selectPDH_MortgageQuestion(propertyMortgaged);
                break;
            case "Investment":
                yourPropertiesPage.selectINV_MortgageQuestion(propertyMortgaged);
                break;
            case "Holiday Home":
                yourPropertiesPage.selectHH_MortgageQuestion(propertyMortgaged);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investment|Holiday Home) property's repaid mortgage provider: (.*)$")
    public void user_selects_the_property_repaid_mortgage_provider(String propertyCategory, String mortgageRepaidProvider) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_MortgageRepaidProvider(mortgageRepaidProvider);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_MortgageRepaidProvider(mortgageRepaidProvider);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_MortgageRepaidProvider(mortgageRepaidProvider);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investment|Holiday Home) property's repaid mortgage year: (.*)$")
    public void user_selects_the_property_repaid_mortgage_year(String propertyCategory, String mortgageRepaidYear) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_MortgageRepaidYear(mortgageRepaidYear);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_MortgageRepaidYear(mortgageRepaidYear);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_MortgageRepaidYear(mortgageRepaidYear);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investiment|Holiday Home) property's mortgage provider: (.*)$")
    public void user_types_the_property_mortgage_provider(String propertyCategory, String mortgageProvider) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_MortgageProvider(mortgageProvider);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_MortgageProvider(mortgageProvider);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_MortgageProvider(mortgageProvider);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage account number: (.*)$")
    public void user_types_the_property_position_mortgage_account_number(String propertyCategory, String position, String mortgageAccountNumber) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_MortgageAccountNumber(mortgageAccountNumber, position);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_MortgageAccountNumber(mortgageAccountNumber, position);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_MortgageAccountNumber(mortgageAccountNumber, position);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage account balance: (.*)$")
    public void user_types_the_property_position_mortgage_account_balance(String propertyCategory, String position, String mortgageAccountNumber) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_MortgageAccountBalance(mortgageAccountNumber, position);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_MortgageAccountBalance(mortgageAccountNumber, position);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_MortgageAccountBalance(mortgageAccountNumber, position);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage account monthly payment: (.*)$")
    public void user_types_the_property_position_mortgage_account_payment(String propertyCategory, String position, String mortgageMonthlyPayment) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_MortgageAccountMonthlyPayment(mortgageMonthlyPayment, position);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_MortgageAccountMonthlyPayment(mortgageMonthlyPayment, position);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_MortgageAccountMonthlyPayment(mortgageMonthlyPayment, position);
                break;
            default:
        }
    }

    @And("^user types the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage account interest rate: (.*)$")
    public void user_types_the_property_position_mortgage_account_interest_rate(String propertyCategory, String position, String accountInterestRate) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.typePDH_MortgageAccountInterestRate(accountInterestRate, position);
                break;
            case "Investment":
                yourPropertiesPage.typeINV_MortgageAccountInterestRate(accountInterestRate, position);
                break;
            case "Holiday Home":
                yourPropertiesPage.typeHH_MortgageAccountInterestRate(accountInterestRate, position);
                break;
            default:
        }
    }

    @And("^user (un)?checks the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage account only interest$")
    public void user_unchecks_or_checks_the_property_position_mortgage_account_interest_rate(String isUnchecked, String propertyCategory, String position) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                if ( isUnchecked == null)
                    yourPropertiesPage.checkPDH_MortgageAccountOnlyInterest(position);
                break;
            case "Investment":
                if ( isUnchecked == null)
                    yourPropertiesPage.checkINV_MortgageAccountOnlyInterest(position);
                break;
            case "Holiday Home":
                if ( isUnchecked == null)
                    yourPropertiesPage.checkHH_MortgageAccountOnlyInterest(position);
                break;
            default:
        }
    }

    @And("^user selects the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage rate type: (Fixed|Variable)$")
    public void user_unchecks_or_checks_the_property_position_mortgage_account_rate_type(String propertyCategory, String position, String mortgageRateType) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                yourPropertiesPage.selectPDH_MortgageAccountRateType(mortgageRateType, position);
                break;
            case "Investment":
                yourPropertiesPage.selectINV_MortgageAccountRateType(mortgageRateType, position);
                break;
            case "Holiday Home":
                yourPropertiesPage.selectHH_MortgageAccountRateType(mortgageRateType, position);
                break;
            default:
        }
    }

    @And("^user chooses the (Principal Dwelling House|Investiment|Holiday Home) property's (.*). mortgage last 24 month: (YES|NO)$")
    public void user_chooses_the_property_position_mortgage_account_24_month(String propertyCategory, String position, String yesNo24Month) {
        switch (propertyCategory) {
            case "Principal Dwelling House":
                if ( yesNo24Month.equals("YES"))
                    yourPropertiesPage.checkPDH_MortgageAccount24MonthYes(position);
                else
                    yourPropertiesPage.checkPDH_MortgageAccount24MonthNo(position);
                break;
            case "Investment":
                if ( yesNo24Month.equalsIgnoreCase("YES"))
                    yourPropertiesPage.checkINV_MortgageAccount24MonthYes(position);
                else
                    yourPropertiesPage.checkINV_MortgageAccount24MonthNo(position);
                break;
            case "Holiday Home":
                if ( yesNo24Month.equalsIgnoreCase("YES"))
                    yourPropertiesPage.checkHH_MortgageAccount24MonthYes(position);
                else
                    yourPropertiesPage.checkHH_MortgageAccount24MonthNo(position);
                break;
            default:
        }
    }

    @And("^user clicks \"ADD THIS PROPERTY\"$")
    public void user_clicks_add_this_property() {
        yourPropertiesPage.clickAddThisProperty();
    }

    @And("^user clicks PROPERTY \"CANCEL\"$")
    public void user_clicks_property_cancel() {
        yourPropertiesPage.clickCancel();
    }

    @And("^user clicks \"ADD PROPERTY\"$")
    public void user_clicks_add_property() {
        yourPropertiesPage.clickAddProperty();
    }

    @And("^user clicks PROPERTY \"NEXT\"$")
    public void user_clicks_property_next() {
        yourPropertiesPage.clickNext();
    }

    @And("^user clicks \"EDIT THIS PROPERTY\"$")
    public void user_clicks_edit_this_property() {
        yourPropertiesPage.clickEditThisProperty();
    }

    @And("^user clicks \"ADD ANOTHER MORTGAGE ACCOUNT\"$")
    public void user_clicks_add_another_mortgage_account() {
        yourPropertiesPage.clickAddAnotherMortgageAccount();
    }
}
