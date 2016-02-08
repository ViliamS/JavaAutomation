package com.r2development.leveris.selenium.borrower.pageobjects;

import java.util.Map;

public interface IYourAssetsSection {
    //h2[contains(., 'YOUR ASSETS')]
    //div[@data-path='lblHeaderText']//span

    //label[contains(., 'NO I DON')]/following-sibling::span/a
    //label[contains(., 'YES I DO')]/following-sibling::span/a

    //div[contains(@id, 'AssetList')]
    //div[contains(@id, 'AssetList')]//div[contains(@id, 'lblAssetType')]//span
    //div[contains(@id, 'AssetList')]//div[contains(@id, 'lnkAssetType')]
    //div[contains(@id, 'AssetList')]//div[contains(@id, 'ValueTitle')]//span
    //div[contains(@id, 'AssetList')]//div[contains(@id, 'Borrower')]//span
    //div[contains(@id, 'AssetList')]//a[contains(@wicketpath, 'Remove')]
    //div[contains(@id, 'AssetList')]//div[contains(@data-path, 'Value') and not(contains(@data-path, 'ValueTitle'))]//span

    /*

    <div class="content control panel" id="c21f5" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c" aria-readonly="false" aria-labelledby="label21f4" data-readonly="false" data-enabled="true" data-height="70">
       <div class="panel-inner">
          <div id="lblAssetType219b" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lblAssetType" data-path="rptAssets 0 pnlAssetList lblAssetType" data-type="label" data-top="10" style="width:350px;height:20px;top:10px;left:20px;" class="widget widget-label blue uppercase widget-enabled widget-absolute dynamic-tooltip">
             <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
             <div class="content control sc-label" id="l21f6" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lblAssetType_l" data-height="20"><span class="ellipsis">Investment Product Funds / Bonds</span></div>
             <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
          </div>
          <div id="lnkAssetType219e" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lnkAssetType" data-path="rptAssets 0 pnlAssetList lnkAssetType" data-type="link" data-top="10" style="width:20px;height:20px;top:10px;left:370px;" class="widget widget-submit widget-enabled invisible widget-absolute dynamic-tooltip">
             <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent BEGIN --><a class="content control submit sc-link" id="submit21f7" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lnkAssetType_submit" href="javascript:void(0);" aria-readonly="false" onclick="SC._submit.apply(this,['form194d','form1944','scAjax.apply(this,[1,0,\'?wicket:interface=:12:main:c:form:form:root:c:w:rptAssets:c:rows:1:item:pnlAssetList:c:w:lnkAssetType:submit::IBehaviorListener:0:-1&amp;${scrollPos}\',\'busyIndicator194e\',0,0,function(){return SC._isRowValid(\'submit21f7\', false);},SC._serializeRow(\'submit21f7\', false),0]);']);return false;" data-readonly="false" data-enabled="true" data-height="20" tabindex="1003"><span class="main ellipsis"><span class="link">Other</span></span></a><!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent END -->
          </div>
          <div id="lblValueTitle21a0" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lblValueTitle" data-path="rptAssets 0 pnlAssetList lblValueTitle" data-type="label" data-top="10" style="width:350px;height:20px;top:10px;left:390px;" class="widget widget-label blue uppercase widget-enabled widget-align-right widget-absolute dynamic-tooltip">
             <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
             <div class="content control sc-label" id="l21f8" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lblValueTitle_l" data-height="20"><span class="ellipsis">VALUE</span></div>
             <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
          </div>
          <div id="lblBorrower219d" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lblBorrower" data-path="rptAssets 0 pnlAssetList lblBorrower" data-type="label" data-top="40" style="width:350px;height:20px;top:40px;left:20px;" class="widget widget-label gray widget-enabled widget-absolute dynamic-tooltip">
             <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
             <div class="content control sc-label" id="l21f9" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lblBorrower_l" data-height="20"><span class="ellipsis">Tonda</span></div>
             <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
          </div>
          <div id="lnkRemove219f" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lnkRemove" data-path="rptAssets 0 pnlAssetList lnkRemove" data-type="link" data-top="40" style="width:20px;height:20px;top:40px;left:370px;" class="widget widget-submit row-delete-icon widget-enabled widget-absolute dynamic-tooltip">
             <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent BEGIN --><a class="content control submit sc-link" id="submit21fa" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lnkRemove_submit" href="javascript:void(0);" aria-readonly="false" onclick="SC._submit.apply(this,['form194d','form1944','scAjax.apply(this,[1,0,\'?wicket:interface=:12:main:c:form:form:root:c:w:rptAssets:c:rows:1:item:pnlAssetList:c:w:lnkRemove:submit::IBehaviorListener:0:-1&amp;${scrollPos}\',\'busyIndicator194e\',0,0,function(){return SC._isRowValid(\'submit21fa\', false);},SC._serializeRow(\'submit21fa\', false),0]);']);return false;" data-readonly="false" data-enabled="true" data-height="20" tabindex="1003"><span class="main ellipsis"><span class="link">delete</span></span></a><!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent END -->
          </div>
          <div id="lblValue21a1" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lblValue" data-path="rptAssets 0 pnlAssetList lblValue" data-type="label" data-top="40" style="width:350px;height:20px;top:40px;left:390px;" class="widget widget-label gray widget-enabled widget-align-right widget-absolute dynamic-tooltip">
             <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
             <div class="content control sc-label" id="l21fb" wicketpath="main_c_form_form_root_c_w_rptAssets_c_rows_1_item_pnlAssetList_c_w_lblValue_l" data-height="20"><span class="ellipsis">€200.00</span></div>
             <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
          </div>
       </div>
    </div>

     */


    //div[contains(@id, 'SubtotalValue')]

    // Investment Product Funds / Bonds, Shares, Share Options, Land/Site, Life Policy, Other
    //label[contains(., 'What is type of asset?')]/following-sibling::input

    // Investment Product Funds / Bonds
    //label[contains(., 'Current value of investments funds / bonds')]/following-sibling::input
    //label[contains(., 'Funds / bonds institution')]/following-sibling::input
    //label[contains(., 'Maturity date')]/following-sibling::input

    // Shares
    //label[contains(., 'Company in which shares held')]/following-sibling::input
    //label[contains(., 'Current value of shares')]/following-sibling::input

    // Share Options
    //label[contains(., 'Company in which share options held')]/following-sibling::input
    //label[contains(., 'Share options exercise date')]/following-sibling::input
    //label[contains(., 'Current value of share options')]/following-sibling::input

    // Land/Site
    //label[contains(., 'Nature of the land / site')]/following-sibling::input
    //label[contains(., 'Land / site location')]/following-sibling::input
    //label[contains(., 'Land / site size')]/following-sibling::input
    // Sq. Kilometers, Acres, Hectares
    //label[contains(., 'Units')]/following-sibling::input
    //label[contains(., 'Estimated land / site value')]/following-sibling::input

    // Life Policy
    //label[contains(., 'Life policy company')]/following-sibling::input
    //label[contains(., 'Current encashment value')]/following-sibling::input

    // Other
    //label[contains(., 'Nature of other financial asset')]/following-sibling::input
    //label[contains(., 'Current value')]/following-sibling::input

    //a[contains(., 'ADD ASSET')]
    //a[contains(., 'ADD THIS ASSET')]
    //a[contains(., 'CANCEL')]
    //a[contains(., 'NEXT')]
    //a[contains(., 'EDIT THIS ASSET');


    String getTitle();
    String getDescription();

    IYourAssetsSection clickYes();
    IYourAssetsSection clickNo();

    Map<Integer, YourAsset> getYourAssets();
    YourAsset getAsset(int index);
    String getAssetType(int index);
    String getAssetOwner(int index);
    String getAssetValue(int index);
    IYourAssetsSection deleteAsset(int index);
    IYourAccountsSection editAsset(int index);

    IYourAssetsSection selectAssetType(String assetType);
    IYourAssetsSection typeCurrentValueInvestmentsFundBond(String CurrentValueInvestmentsFundBond);
    IYourAssetsSection typeFundBondInstitution(String fundBondInstitution);
    IYourAssetsSection typeMaturityDate(String maturityDate);

    IYourAssetsSection typeCompanySharesHeld(String companyShareHeld);
    IYourAssetsSection typeCurrentValueShares(String currentValueShare);

    IYourAssetsSection typeShareOptionsExerciseDate(String shareOptionsExerciseDate);
    IYourAssetsSection typeCurrentValueShareOptions(String currentValueShareOptions);

    IYourAssetsSection typeNatureLandSite(String natureLandSite);
    IYourAssetsSection typeLandSiteLocation(String landSiteLocation);
    IYourAssetsSection typeLandSiteSize(String landSiteSize);
    IYourAssetsSection selectUnits(String unit);
    IYourAssetsSection typeEstimatedLandSiteValue(String estimatedLandSiteValue);

    IYourAssetsSection typeLifePolicyCompany(String lifePolicyCompany);
    IYourAssetsSection typeCurrentEncashmentValue(String currentEncashmentValue);

    IYourAssetsSection typeNatureOtherFinancialAsset(String natureOtherFinancialAsset);
    IYourAssetsSection typeCurrentValue(String currentValue);

    IYourAssetsSection clickAddAsset();
    IYourAssetsSection clickAddThisAsset();
    IYourAssetsSection clickCancel();
    IYourAssetsSection clickNext();
    IYourAssetsSection clickEditThisAsset();
}
