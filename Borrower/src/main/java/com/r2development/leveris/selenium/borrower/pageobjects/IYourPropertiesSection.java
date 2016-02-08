package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourPropertiesSection {
    String YOUR_PROPERTIES_TITLE_XPATH = "//h2[contains(., 'Your properties')]";
    String YOUR_PROPERTIES_DESCRIPTION_XPATH = "//div[contains(@wicketpath, 'PropertyStartDesc')]//span";


    //div[contains(@id, 'PropertyList')]
    //div[contains(@id, 'PropertyList')]//div[contains(@id, 'TypeAndPriceHeader')]//span
    //div[contains(@id, 'PropertyList')]//div[contains(@id, 'TypeAndPrice') and not(contains(@data-path, 'TypeAndPriceHeader'))]//span
    //a[contains(@wicketpath, 'lnkEdit')]
    //a[contains(@wicketpath, 'lnkEdit')]/span/span
    //a[contains(@wicketpath, 'Delete')]
    //div[contains(@id, 'PropertyList')]//div[contains(@data-path, 'MortgageSt') and not(contains(@data-path, 'MortgageStatus'))]//span

    /*
    <div class="content control panel" id="c2fb7" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c" aria-readonly="false" aria-labelledby="label2fb6" data-readonly="false" data-enabled="true" data-height="70">
    <div class="panel-inner">
    <div id="lblTypeAndPriceHeader2f59" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lblTypeAndPriceHeader" data-path="rptProperties 0 pnlPropertyList lblTypeAndPriceHeader" data-type="label" data-top="10" style="width:350px;height:20px;top:10px;left:20px;" class="widget widget-label blue uppercase widget-enabled widget-align-left widget-absolute dynamic-tooltip">
    <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
    <div class="content control sc-label" id="l2fb8" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lblTypeAndPriceHeader_l" data-height="20"><span class="ellipsis">Type and price</span></div>
    <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
    </div>
    <div id="lnkEdit2f5c" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lnkEdit" data-path="rptProperties 0 pnlPropertyList lnkEdit" data-type="link" data-top="10" style="width:20px;height:20px;top:10px;left:370px;" class="widget widget-submit widget-enabled widget-align-right invisible widget-absolute dynamic-tooltip">
    <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent BEGIN --><a class="content control submit sc-link" id="submit2fb9" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lnkEdit_submit" href="javascript:void(0);" aria-readonly="false" onclick="SC._submit.apply(this,['form2933','form2922','scAjax.apply(this,[1,0,\'?wicket:interface=:14:main:c:form:form:root:c:w:rptProperties:c:rows:1:item:pnlPropertyList:c:w:lnkEdit:submit::IBehaviorListener:0:-1&amp;${scrollPos}\',\'busyIndicator2934\',0,0,function(){return SC._isRowValid(\'submit2fb9\', false);},SC._serializeRow(\'submit2fb9\', false),0]);']);return false;" data-readonly="false" data-enabled="true" data-height="20" tabindex="1004"><span class="main ellipsis"><span class="link">MORTGAGE</span></span></a><!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent END -->
    </div>
    <div id="lblMortgageSt2f5e" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lblMortgageSt" data-path="rptProperties 0 pnlPropertyList lblMortgageSt" data-type="label" data-top="10" style="width:350px;height:20px;top:10px;left:390px;" class="widget widget-label blue uppercase widget-enabled widget-align-right widget-absolute dynamic-tooltip">
    <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
    <div class="content control sc-label" id="l2fba" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lblMortgageSt_l" data-height="20"><span class="ellipsis">MORTGAGE</span></div>
    <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
    </div>
    <div id="lblTypeAndPrice2f5b" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lblTypeAndPrice" data-path="rptProperties 0 pnlPropertyList lblTypeAndPrice" data-type="label" data-top="40" style="width:350px;height:20px;top:40px;left:20px;" class="widget widget-label gray widget-enabled widget-absolute dynamic-tooltip">
    <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
    <div class="content control sc-label" id="l2fbb" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lblTypeAndPrice_l" data-height="20"><span class="ellipsis">Principal Dwelling House - €20000</span></div>
    <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
    </div>
    <div id="lnkDelete2f5d" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lnkDelete" data-path="rptProperties 0 pnlPropertyList lnkDelete" data-type="link" data-top="40" style="width:20px;height:20px;top:40px;left:370px;" class="widget widget-submit row-delete-icon widget-enabled widget-absolute dynamic-tooltip">
    <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent BEGIN --><a class="content control submit sc-link" id="submit2fbc" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lnkDelete_submit" href="javascript:void(0);" aria-readonly="false" onclick="SC._submit.apply(this,['form2933','form2922','scAjax.apply(this,[1,0,\'?wicket:interface=:14:main:c:form:form:root:c:w:rptProperties:c:rows:1:item:pnlPropertyList:c:w:lnkDelete:submit::IBehaviorListener:0:-1&amp;${scrollPos}\',\'busyIndicator2934\',0,0,function(){return SC._isRowValid(\'submit2fbc\', false);},SC._serializeRow(\'submit2fbc\', false),0]);']);return false;" data-readonly="false" data-enabled="true" data-height="20" tabindex="1004"><span class="main ellipsis"><span class="link">Delete</span></span></a><!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent END -->
    </div>
    <div id="lblMortgageStatus2f5f" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lblMortgageStatus" data-path="rptProperties 0 pnlPropertyList lblMortgageStatus" data-type="label" data-top="40" style="width:350px;height:20px;top:40px;left:390px;" class="widget widget-label gray widget-enabled widget-align-right widget-absolute dynamic-tooltip">
    <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
    <div class="content control sc-label" id="l2fbd" wicketpath="main_c_form_form_root_c_w_rptProperties_c_rows_1_item_pnlPropertyList_c_w_lblMortgageStatus_l" data-height="20"><span class="ellipsis">Yes</span></div>
    <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
    </div>
    </div>
    </div>
    */

//    String YOUR_PROPERTIES_SINGLE_NO_XPATH = "//label[contains(@wicketpath, 'rgrRadio') and contains(., 'NO I DON')]/following-sibling::span/a";
    String YOUR_PROPERTIES_SINGLE_NO_XPATH = "//a[contains(., 'NO I DON') and contains(., 'T')]";
    String YOUR_PROPERTIES_COUPLE_NO_XPATH = "//a[contains(., 'NO WE DON') and contains(., 'T')]"; //"//label[contains(@wicketpath, 'rgrRadio') and contains(., 'NO WE DON')]/following-sibling::span/a";
    String YOUR_PROPERTIES_SINGLE_YES_XPATH = "//label[contains(@wicketpath, 'rgrRadio') and contains(., 'YES I DO')]/following-sibling::span/a";
    String YOUR_PROPERTIES_COUPLE_YES_XPATH = "//label[contains(@wicketpath, 'rgrRadio') and contains(., 'YES WE DO')]/following-sibling::span/a";

//    String YOUR_PROPERTIES_PAST_SINGLE_NO_XPATH = "//label[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_pnlPropertyPast_c_w_rgrPastProperty_rg_rb_radNoPropery_label' and contains(., 'NO I DON')]/following-sibling::span/a";
    String YOUR_PROPERTIES_PAST_SINGLE_NO_XPATH = "//div[contains(@data-path, 'pnlMain pnlPropertyPast btnPropertyPastNoIDont')]/a";
    String YOUR_PROPERTIES_PAST_COUPLE_NO_XPATH = "//div[contains(@data-path, 'pnlMain pnlPropertyPast btnPropertyPastNoIDont')]/a"; //label[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_pnlPropertyPast_c_w_rgrPastProperty_rg_rb_radNoPropery_label' and contains(., 'NO WE DON')]/following-sibling::span/a";
    String YOUR_PROPERTIES_PAST_SINGLE_YES_XPATH = "//label[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_pnlPropertyPast_c_w_rgrPastProperty_rg_rb_radNoPropery_label' and contains(., 'YES I DO')]/following-sibling::span/a";
    String YOUR_PROPERTIES_PAST_COUPLE_YES_XPATH = "//label[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_pnlPropertyPast_c_w_rgrPastProperty_rg_rb_radNoPropery_label' and contains(., 'YES WE DO')]/following-sibling::span/a";

    String YOUR_PROPERTIES_APPLIES_TO_BORROWER_XPATH = "//label[contains(., '${replaceBorrower}$')]/following-sibling::span/a";
    String YOUR_PROPERTIES_APPLIES_TO_COAPPLICANT_XPATH = "//label[contains(., '${replaceCoapplicant}$')]/following-sibling::span/a";

    String YOUR_PROPERTIES_OTHER_PARTY_INTEREST_XPATH = "//label[contains(., 'YES') and @wicketpath='main_c_form_form_root_c_w_pnlAddNew_c_w_pnlBorrowers_c_w_pnlOtherParty_c_w_chkBorrowerOther_label']/following-sibling::span/a";

    String YOUR_PROPERTIES_SELECTED_CATEGORY_XPATH = "//label[contains(., 'Property category')]/following-sibling::input"; // Principal Dwelling House, Investment, Holiday Home";

    // Principal Dwelling House
    String YOUR_PROPERTIES_PDH_SAME_AS_HOME_ADDRESS_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlAddNew_c_w_pnlPrincipalDwelling_c_w_lnkApplicantAddress1_script']";

    String YOUR_PROPERTIES_PDH_ADDRESS_LINE1_XPATH = "//label[contains(., 'Address line 1')]/following-sibling::input"; //input[@id='txtAddressLine1-autocompleteBox']";
    String YOUR_PROPERTIES_PDH_ADDRESS_LINE2_XPATH = "//label[contains(., 'Address line 2')]/following-sibling::input"; //input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:txtAddressLine2:tb']";
    String YOUR_PROPERTIES_PDH_TOWNCITY_XPATH = "//label[contains(., 'Town / City')]/following-sibling::input"; //or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:txtTown:tb']";
    String YOUR_PROPERTIES_PDH_COUNTY_XPATH = "//label[contains(., 'County')]/following-sibling::input"; //or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:cmbCounty:v']";       //select
    String YOUR_PROPERTIES_PDH_POSTCODE_XPATH = "//label[contains(., 'Post code')]/following-sibling::input"; //or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:txtPostCode:tb']
    String YOUR_PROPERTIES_PDH_COUNTRY_XPATH = "//label[contains(., 'Country')]/following-sibling::input"; // or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:cmbCountry:v']      //select
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    String YOUR_PROPERTIES_PDH_PROPERTY_TYPE_XPATH = "//label[contains(., 'Property type')]/following-sibling::input"; // or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:cmbPropertyType:v']";        // select
    String YOUR_PROPERTIES_PDH_NUMBER_BEDROOMS_XPATH = "//label[contains(., 'Number of bedrooms')]/following-sibling::input"; // or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:txtNumberOfBedrooms:tb']
    String YOUR_PROPERTIES_PDH_ACQUIRED_YEAR_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:txtYearOfAcquisition:tb']"; // or //label[contains(., 'Year property was acquired')]/following-sibling::input";
    String YOUR_PROPERTIES_PDH_ORIGINAL_PURCHASE_PRICE_XPATH = "//label[contains(., 'Original purchase price')]/following-sibling::input"; // or input[@name='root:c:w:pnlAddNew:c:w:pnlProperty:c:w:crbOrigPurchasePrice:tb']
    // plan to sel it before you get your home loan
    String YOUR_PROPERTIES_PDH_SELL_PLAN_YES_XPATH = "//label[@wicketpath='main_c_form_form_root_c_w_pnlAddNew_c_w_rgrSoldBeforeDrawdown_rg_rb_radSoldBeforeYes_label']/following-sibling::span/a";
    String YOUR_PROPERTIES_PDH_SELL_PLAN_NO_XPATH = "//label[@wicketpath='main_c_form_form_root_c_w_pnlAddNew_c_w_rgrSoldBeforeDrawdown_rg_rb_radSoldBeforeNo_label']/following-sibling::span/a";
    String YOUR_PROPERTIES_PDH_ESTIMATION_PRICE_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:crbEstimatedPrice:tb']"; // or
    //div[contains(@id, 'radSoldBeforeYes')]//label[contains(., 'YES')]/following-sibling::span/a
    //div[contains(@id, 'radSoldBeforeNo')]//label[contains(., 'NO')]/following-sibling::span/a
    //label[contains(., 'Estimated value/sale agreed price*')]/following-sibling::input


    // Investment
    String YOUR_PROPERTIES_INV_MONTHLY_RENT_XPATH = "//label[contains(., 'Monthly rent')]/following-sibling::input";  // or //input[@name='root:c:w:pnlAddNew:c:w:pnlInvestmentOrHoliday:c:w:crbMonthlyRent:tb']
    //// Seasonal, Guaranteed
    String YOUR_PROPERTIES_INV_RENT_TYPE_XPATH = "//label[contains(., 'Rent is')]/following-sibling::input"; // select
    String YOUR_PROPERTIES_INV_ADDRESS_LINE1_XPATH = YOUR_PROPERTIES_PDH_ADDRESS_LINE1_XPATH;
    String YOUR_PROPERTIES_INV_ADDRESS_LINE2_XPATH = YOUR_PROPERTIES_PDH_ADDRESS_LINE2_XPATH;
    String YOUR_PROPERTIES_INV_TOWNCITY_XPATH = YOUR_PROPERTIES_PDH_TOWNCITY_XPATH;
    String YOUR_PROPERTIES_INV_COUNTY_XPATH = YOUR_PROPERTIES_PDH_COUNTY_XPATH;
    String YOUR_PROPERTIES_INV_POSTCODE_XPATH = YOUR_PROPERTIES_PDH_POSTCODE_XPATH;
    String YOUR_PROPERTIES_INV_COUNTRY_XPATH = YOUR_PROPERTIES_PDH_COUNTRY_XPATH;
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    String YOUR_PROPERTIES_INV_PROPERTY_TYPE_XPATH = YOUR_PROPERTIES_PDH_PROPERTY_TYPE_XPATH;
    String YOUR_PROPERTIES_INV_NUMBER_BEDROOMS_XPATH = YOUR_PROPERTIES_PDH_NUMBER_BEDROOMS_XPATH;
    String YOUR_PROPERTIES_INV_ACQUIRED_YEAR_XPATH = YOUR_PROPERTIES_PDH_ACQUIRED_YEAR_XPATH;
    String YOUR_PROPERTIES_INV_ORIGINAL_PURCHASE_PRICE_XPATH = YOUR_PROPERTIES_PDH_ORIGINAL_PURCHASE_PRICE_XPATH;
    // plan to sel it before you get your home loan
    String YOUR_PROPERTIES_INV_SELL_PLAN_YES_XPATH = YOUR_PROPERTIES_PDH_SELL_PLAN_YES_XPATH;
    String YOUR_PROPERTIES_INV_SELL_PLAN_NO_XPATH = YOUR_PROPERTIES_PDH_SELL_PLAN_NO_XPATH;
    String YOUR_PROPERTIES_INV_ESTIMATION_PRICE_XPATH = YOUR_PROPERTIES_PDH_ESTIMATION_PRICE_XPATH;


    // Holiday Home
    String YOUR_PROPERTIES_HH_MONTHLY_RENT_XPATH = YOUR_PROPERTIES_INV_MONTHLY_RENT_XPATH;
    //// Seasonal, Guaranteed
    String YOUR_PROPERTIES_HH_RENT_TYPE_XPATH = YOUR_PROPERTIES_INV_RENT_TYPE_XPATH;
    String YOUR_PROPERTIES_HH_ADDRESS_LINE1_XPATH = YOUR_PROPERTIES_PDH_ADDRESS_LINE1_XPATH;
    String YOUR_PROPERTIES_HH_ADDRESS_LINE2_XPATH = YOUR_PROPERTIES_PDH_ADDRESS_LINE2_XPATH;
    String YOUR_PROPERTIES_HH_TOWNCITY_XPATH = YOUR_PROPERTIES_PDH_TOWNCITY_XPATH;
    String YOUR_PROPERTIES_HH_COUNTY_XPATH = YOUR_PROPERTIES_PDH_COUNTY_XPATH;
    String YOUR_PROPERTIES_HH_POSTCODE_XPATH = YOUR_PROPERTIES_PDH_POSTCODE_XPATH;
    String YOUR_PROPERTIES_HH_COUNTRY_XPATH = YOUR_PROPERTIES_PDH_COUNTRY_XPATH;
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    String YOUR_PROPERTIES_HH_PROPERTY_TYPE_XPATH = YOUR_PROPERTIES_PDH_PROPERTY_TYPE_XPATH;
    String YOUR_PROPERTIES_HH_NUMBER_BEDROOMS_XPATH = YOUR_PROPERTIES_PDH_NUMBER_BEDROOMS_XPATH;
    String YOUR_PROPERTIES_HH_ACQUIRED_YEAR_XPATH = YOUR_PROPERTIES_PDH_ACQUIRED_YEAR_XPATH;
    String YOUR_PROPERTIES_HH_ORIGINAL_PURCHASE_PRICE_XPATH = YOUR_PROPERTIES_PDH_ORIGINAL_PURCHASE_PRICE_XPATH;
    // plan to sel it before you get your home loan
    String YOUR_PROPERTIES_HH_SELL_PLAN_YES_XPATH = YOUR_PROPERTIES_PDH_SELL_PLAN_YES_XPATH;
    String YOUR_PROPERTIES_HH_SELL_PLAN_NO_XPATH = YOUR_PROPERTIES_PDH_SELL_PLAN_NO_XPATH;
    String YOUR_PROPERTIES_HH_ESTIMATION_PRICE_XPATH = YOUR_PROPERTIES_PDH_ESTIMATION_PRICE_XPATH;


    //// Yes; No, Mortgage Repaid; No, Never Had a Mortgage
    String YOUR_PROPERTIES_MORTGAGE_QUESTION_XPATH = "//label[contains(., 'Is this property mortgaged?')]/following-sibling::input"; // or //input[@name='root:c:w:pnlAddNew:c:w:cmbIsPropertyMortgaged:v'] // Select
    //// yes
    String YOUR_PROPERTIES_MORTGAGE_PROVIDER_XPATH = "//label[contains(., 'Mortgage provider')]/following-sibling::input"; // or //input[@name='root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:txtMortgageProvider:tb']
    String YOUR_PROPERTIES_MORTGAGE_ACCOUNT_NUMBER_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:rptMortgageAccount:c:rows:${replaceIndex}$:item:pnlAccount:c:w:txtMortgageAccountNumber:tb']"; // ... root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:rptMortgageAccount:c:rows:2:item:pnlAccount:c:w:txtMortgageAccountNumber:tb or "//label[contains(., 'Mortgage account number')]/following-sibling::input or
    String YOUR_PROPERTIES_MORTGAGE_ACCOUNT_BALANCE_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:rptMortgageAccount:c:rows:${replaceIndex}$:item:pnlAccount:c:w:crbCurrentBalance:tb']"; // ... root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:rptMortgageAccount:c:rows:2:item:pnlAccount:c:w:crbCurrentBalance:tb or //label[contains(., 'Current balance')]/following-sibling::input or
    String YOUR_PROPERTIES_MORTGAGE_ACCOUNT_MONTHLY_PAYMENT_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:rptMortgageAccount:c:rows:${replaceIndex}$:item:pnlAccount:c:w:crbMonthlyPayment:tb']"; // ... root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:rptMortgageAccount:c:rows:2:item:pnlAccount:c:w:crbMonthlyPayment:tb or //label[contains(., 'Monthly payment')]/following-sibling::input or
    String YOUR_PROPERTIES_MORTGAGE_ACCOUNT_INTEREST_RATE_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:rptMortgageAccount:c:rows:${replaceIndex}$:item:pnlAccount:c:w:txtInterestRate:tb']"; // ... root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:rptMortgageAccount:c:rows:2:item:pnlAccount:c:w:txtInterestRate:tb or //label[contains(., 'Current interest rate')]/following-sibling::input or
    String YOUR_PROPERTIES_MORTGAGE_ACCOUNT_ONLY_INTEREST_XPATH = "//label[@wicketpath='main_c_form_form_root_c_w_pnlAddNew_c_w_pnlMortageDetail_c_w_rptMortgageAccount_c_rows_${replaceIndex}$_item_pnlAccount_c_w_pnlInterestOnly_c_w_chkInterestOnly_label']/following-sibling::span/a"; // ... //label[@wicketpath='main_c_form_form_root_c_w_pnlAddNew_c_w_pnlMortageDetail_c_w_rptMortgageAccount_c_rows_2_item_pnlAccount_c_w_pnlInterestOnly_c_w_chkInterestOnly_label']/following-sibling::span/a or "//label[contains(@wicketpath, 'chkInterestOnly') and contains(., 'YES')]/following-sibling::span/a or
    //// Fixed, Variable
    String YOUR_PROPERTIES_MORTGAGE_ACCOUNT_RATE_TYPE = "//input[@name='root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:rptMortgageAccount:c:rows:${replaceIndex}$:item:pnlAccount:c:w:cmbRateType:v']"; // ... root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:rptMortgageAccount:c:rows:2:item:pnlAccount:c:w:cmbRateType:v or "//label[contains(., 'Rate type')]/following-sibling::input  or // select
    String YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_YES = "//label[@wicketpath='main_c_form_form_root_c_w_pnlAddNew_c_w_pnlMortageDetail_c_w_rptMortgageAccount_c_rows_${replaceIndex}$_item_pnlAccount_c_w_rgr24Months_rg_rb_rad24MonthsYes_label']/following-sibling::span/a"; // ... main_c_form_form_root_c_w_pnlAddNew_c_w_pnlMortageDetail_c_w_rptMortgageAccount_c_rows_2_item_pnlAccount_c_w_rgr24Months_rg_rb_rad24MonthsYes_label
    String YOUR_PROPERTIES_MORTGAGE_ACCOUNT_24MONTH_NO = "//label[@wicketpath='main_c_form_form_root_c_w_pnlAddNew_c_w_pnlMortageDetail_c_w_rptMortgageAccount_c_rows_${replaceIndex}$_item_pnlAccount_c_w_rgr24Months_rg_rb_rad24MonthsNo_label']/following-sibling::span/a"; // ... main_c_form_form_root_c_w_pnlAddNew_c_w_pnlMortageDetail_c_w_rptMortgageAccount_c_rows_2_item_pnlAccount_c_w_rgr24Months_rg_rb_rad24MonthsNo_label or //label[contains(@wicketpath, 'ad24MonthsNo') and contains(/, 'No')]/following-sibling::span/a or
    String YOUR_PROPERTIES_ADD_ANOTHER_MORTGAGE_ACCOUNT_XPATH = "//a[contains(., 'ADD ANOTHER MORTGAGE ACCOUNT')]";
    //// No, Mortgage Repaid
    String YOUR_PROPERTIES_MORTGAGE_REPAID_PROVIDER_XPATH = "//label[contains(., 'Mortgage provider')]/following-sibling::input"; // or input[@name='root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:txtMortgageProvider:tb']
    String YOUR_PROPERTIES_MORTGAGE_REPAID_YEAR_XPATH = "//label[contains(., 'Year repaid')]/following-sibling::input"; // or input[@name='root:c:w:pnlAddNew:c:w:pnlMortageDetail:c:w:pnlMortgageRepaid:c:w:txtYearRepaid:tb']



    String YOUR_PROPERTIES_CANCEL_XPATH = "//a[contains(., 'CANCEL')]";
    String YOUR_PROPERTIES_ADD_THIS_PROPERTY_XPATH = "//a[contains(., 'ADD THIS PROPERTY')]";
    String YOUR_PROPERTIES_ADD_PROPERTY_XPATH = "//a[contains(., 'ADD PROPERTY')]";
    String YOUR_PROPERTIES_NEXT_XPATH = "//a[contains(., 'Next')]";
    String YOUR_PROPERTIES_NEXT_SECTION_XPATH = "//a[contains(., 'Next section')]";
    String YOUR_PROPERTIES_EDIT_THIS_PROPERTY_XPATH = "//a[contains(., 'EDIT THIS PROPERTY)]";



    String getYourPropertiesTitle();
    String getYourPropertiesDescription();

    IYourPropertiesSection clickSingleNo();
    IYourPropertiesSection clickSingleYes();
    IYourPropertiesSection clickCoupleNo();
    IYourPropertiesSection clickCoupleYes();

    IYourPropertiesSection clickPastSingleNo();
    IYourPropertiesSection clickPastSingleYes();
    IYourPropertiesSection clickPastCoupleNo();
    IYourPropertiesSection clickPastCoupleYes();

    IYourPropertiesSection checkThisPropertyAppliesToBorrower(String borrower);
    IYourPropertiesSection checkThisPropertyAppliedToCoapplicant(String coapplicant);

    IYourPropertiesSection checkOtherPartyInterest();

    // Principal Dwelling House, Investment, Holiday Home"
    IYourPropertiesSection selectPropertiesCategory(String propertyCategory);

    // Principal Dwelling House
    IYourPropertiesSection clickPDH_SameAsHomeAddress();
    IYourPropertiesSection typePDH_AddressLine1(String addressLine1);
    IYourPropertiesSection typePDH_AddressLine2(String addressLine2);
    IYourPropertiesSection typePDH_TownCity(String townCity);
    IYourPropertiesSection selectPDH_County(String county);
    IYourPropertiesSection typePDH_Postcode(String postcode);
    IYourPropertiesSection selectPDH_Country(String country);
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    IYourPropertiesSection selectPDH_PropertyType(String propertyType);
    IYourPropertiesSection typePDH_NumberBedrooms(String numberBedrooms);
    IYourPropertiesSection typePDH_AcquiredYear(String acquiredYear);
    IYourPropertiesSection typePDH_OriginalPurchasePrice(String originalPurchasePrice);
    // plan to sel it before you get your home loan
    IYourPropertiesSection clickPDH_SellPlanYes(); //div[contains(@id, 'radSoldBeforeYes')]//label[contains(., 'YES')]/following-sibling::span/a
    IYourPropertiesSection clickPDH_SellPlanNo(); //div[contains(@id, 'radSoldBeforeNo')]//label[contains(., 'NO')]/following-sibling::span/a
    IYourPropertiesSection typePDH_EstimationPrice(String estimationPrice); //label[contains(., 'Estimated value/sale agreed price*')]/following-sibling::input

    // Investment
    IYourPropertiesSection typeINV_MonthlyRent(String monthlyRent);
    //// Seasonal, Guaranteed
    IYourPropertiesSection selectINV_RentType(String rentType);
    IYourPropertiesSection typeINV_AddressLine1(String addressLine1);
    IYourPropertiesSection typeINV_AddressLine2(String addressLine2);
    IYourPropertiesSection typeINV_TownCity(String townCity);
    IYourPropertiesSection selectINV_County(String county);
    IYourPropertiesSection typeINV_Postcode(String postcode);
    IYourPropertiesSection selectINV_Country(String country);
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    IYourPropertiesSection selectINV_PropertyType(String propertyType);
    IYourPropertiesSection typeINV_NumberBedrooms(String numberBedrooms);
    IYourPropertiesSection typeINV_AcquiredYear(String acquiredYear);
    IYourPropertiesSection typeINV_OriginalPurchasePrice(String originalPurchasePrice);
    // plan to sel it before you get your home loan
    IYourPropertiesSection clickINV_SellPlanYes();
    IYourPropertiesSection clickINV_SellPlanNo();
    IYourPropertiesSection typeINV_EstimationPrice(String estimationPrice);

    // Holiday Home
    IYourPropertiesSection typeHH_MonthlyRent(String monthlyRent);
    //// Seasonal, Guaranteed
    IYourPropertiesSection selectHH_RentType(String rentType);
    IYourPropertiesSection typeHH_AddressLine1(String addressLine1);
    IYourPropertiesSection typeHH_AddressLine2(String addressLine2);
    IYourPropertiesSection typeHH_TownCity(String townCity);
    IYourPropertiesSection selectHH_County(String county);
    IYourPropertiesSection typeHH_Postcode(String postcode);
    IYourPropertiesSection selectHH_Country(String country);
    // Detached house, Detached house with basement, Semi detached house, Semi detached house with basement, Terraced, Terraced house with basement. Bungalow, Bungalow with basement, Apartment/Flat/Duplex, Purpose built duplex
    IYourPropertiesSection selectHH_PropertyType(String propertyType);
    IYourPropertiesSection typeHH_NumberBedrooms(String numberBedrooms);
    IYourPropertiesSection typeHH_AcquiredYear(String acquiredYear);
    IYourPropertiesSection typeHH_OriginalPurchasePrice(String originalPurchasePrice);
    // plan to sel it before you get your home loan
    IYourPropertiesSection clickHH_SellPlanYes();
    IYourPropertiesSection clickHH_SellPlanNo();
    IYourPropertiesSection typeHH_EstimationPrice(String estimationPrice);



    //// Yes; No, Mortgage Repaid; No, Never Had a Mortgage
    IYourPropertiesSection selectPDH_MortgageQuestion(String mortgageQuestion);
    IYourPropertiesSection selectINV_MortgageQuestion(String mortgageQuestion);
    IYourPropertiesSection selectHH_MortgageQuestion(String mortgageQuestion);
    //// yes
    IYourPropertiesSection typePDH_MortgageProvider(String mortgageType);
    IYourPropertiesSection typeINV_MortgageProvider(String mortgageType);
    IYourPropertiesSection typeHH_MortgageProvider(String mortgageType);
    IYourPropertiesSection typePDH_MortgageAccountNumber(String accountNumber, String index);
    IYourPropertiesSection typeINV_MortgageAccountNumber(String accountNumber, String index);
    IYourPropertiesSection typeHH_MortgageAccountNumber(String accountNumber, String index);
    IYourPropertiesSection typePDH_MortgageAccountBalance(String accountBalance, String index);
    IYourPropertiesSection typeINV_MortgageAccountBalance(String accountBalance, String index);
    IYourPropertiesSection typeHH_MortgageAccountBalance(String accountBalance, String index);
    IYourPropertiesSection typePDH_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index);
    IYourPropertiesSection typeINV_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index);
    IYourPropertiesSection typeHH_MortgageAccountMonthlyPayment(String accountMonthlyPayment, String index);
    IYourPropertiesSection typePDH_MortgageAccountInterestRate(String accountInterestRate, String index);
    IYourPropertiesSection typeINV_MortgageAccountInterestRate(String accountInterestRate, String index);
    IYourPropertiesSection typeHH_MortgageAccountInterestRate(String accountInterestRate, String index);
    IYourPropertiesSection checkPDH_MortgageAccountOnlyInterest(String index);
    IYourPropertiesSection checkINV_MortgageAccountOnlyInterest(String index);
    IYourPropertiesSection checkHH_MortgageAccountOnlyInterest(String index);
    //// Fixed, Variable
    IYourPropertiesSection selectPDH_MortgageAccountRateType(String accountRateType, String index);
    IYourPropertiesSection selectINV_MortgageAccountRateType(String accountRateType, String index);
    IYourPropertiesSection selectHH_MortgageAccountRateType(String accountRateType, String index);
    IYourPropertiesSection checkPDH_MortgageAccount24MonthYes(String index);
    IYourPropertiesSection checkINV_MortgageAccount24MonthYes(String index);
    IYourPropertiesSection checkHH_MortgageAccount24MonthYes(String index);
    IYourPropertiesSection checkPDH_MortgageAccount24MonthNo(String index);
    IYourPropertiesSection checkINV_MortgageAccount24MonthNo(String index);
    IYourPropertiesSection checkHH_MortgageAccount24MonthNo(String index);
    IYourPropertiesSection clickAddAnotherMortgageAccount();
    //// No, Mortgage Repaid
    IYourPropertiesSection typePDH_MortgageRepaidProvider(String mortgageRepaidProvider);
    IYourPropertiesSection typeINV_MortgageRepaidProvider(String mortgageRepaidProvider);
    IYourPropertiesSection typeHH_MortgageRepaidProvider(String mortgageRepaidProvider);
    IYourPropertiesSection typePDH_MortgageRepaidYear(String mortgageRepaidYear);
    IYourPropertiesSection typeINV_MortgageRepaidYear(String mortgageRepaidYear);
    IYourPropertiesSection typeHH_MortgageRepaidYear(String mortgageRepaidYear);


    IYourPropertiesSection clickCancel();
    IYourPropertiesSection clickAddThisProperty();
    IYourPropertiesSection clickAddProperty();
    IYourPropertiesSection clickNext();
    IYourPropertiesSection clickNextSection();
    IYourPropertiesSection clickEditThisProperty();

}
