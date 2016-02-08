package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourDependentsSection {
//    String YOUR_DEPENDENT_TITLE_XPATH = "//h2[contains(., 'YOUR DEPENDENTS')]";
    String YOUR_DEPENDENT_TITLE_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lblNoDepTitle_l' and contains(., 'Your depend')]";
    String YOUR_DEPENDENT_DESCRIPTION_XPATH = "//div[@data-path='lblDependent']";

//    String YOUR_DEPENDENT_SINGLE_NO_XPATH = "//label[contains(., 'NO I DON')]/following-sibling::span/a";
    String YOUR_DEPENDENT_SINGLE_NO_XPATH = "//a[contains(., 'I have none')]";
    String YOUR_DEPENDENT_SINGLE_YES_XPATH = "//label[contains(., 'YES I DO')]/following-sibling::span/a";

    String YOUR_DEPENDENT_COUPLE_NO_XPATH = "//a[contains(., 'We have none')]"; //"//label[contains(., 'WE HAVE NONE')]/following-sibling::span/a";
    String YOUR_DEPENDENT_COUPLE_YES_XPATH = "//label[contains(., 'YES WE DO')]/following-sibling::span/a";

    //div[contains(@id, 'DependentList')]
        //div[contains(@id, 'lblAge')]//span
        //a[contains(@wicketpath, 'lnkAge')]
        //div[contains(@id, 'BorrowerName')]/span
        //a[contains(@wicketpath, 'lnkDependentDelete')]


    /*
    <div id="pnlDependentList10db" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList" data-path="rptDependent 2 pnlDependentList" data-row="2" data-type="panel" data-top="160" style="width:760px;height:70px;top:160px;left:0px;" data-moveup="true" class="widget widget-panel row-type1 clickable widget-enabled widget-absolute chromeXpathFinder chromeXpathFinder2" data-multi="true">
       <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.PanelWidgetComponent BEGIN -->
       <div id="label110e" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_label" class="label-widget label-left"></div>
       <div class="content control panel" id="c110f" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c" aria-readonly="false" aria-labelledby="label110e" data-readonly="false" data-enabled="true" data-height="70">
          <div class="panel-inner">
             <div id="lblAge10dc" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lblAge" data-path="rptDependent 2 pnlDependentList lblAge" data-type="label" data-top="10" style="width:350px;height:20px;top:10px;left:20px;" class="widget widget-label blue uppercase widget-enabled widget-absolute dynamic-tooltip">
                <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
                <div class="content control sc-label" id="l1110" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lblAge_l" data-height="20"><span class="ellipsis">Dependent aged 0</span></div>
                <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
             </div>
             <div id="lnkAge10de" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lnkAge" data-path="rptDependent 2 pnlDependentList lnkAge" data-type="link" data-top="10" style="width:20px;height:20px;top:10px;left:370px;" class="widget widget-submit widget-enabled invisible widget-absolute dynamic-tooltip">
                <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent BEGIN --><a class="content control submit sc-link" id="submit1111" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lnkAge_submit" href="javascript:void(0);" aria-readonly="false" onclick="SC._submit.apply(this,['formcf9','formcf0','scAjax.apply(this,[1,0,\'?wicket:interface=:7:main:c:form:form:root:c:w:rptDependent:c:rows:3:item:pnlDependentList:c:w:lnkAge:submit::IBehaviorListener:0:-1&amp;${scrollPos}\',\'busyIndicatorcfa\',0,0,function(){return SC._isRowValid(\'submit1111\', false);},SC._serializeRow(\'submit1111\', false),0]);']);return false;" data-readonly="false" data-enabled="true" data-height="20" tabindex="1005"><span class="main ellipsis"><span class="link">Age</span></span></a><!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent END -->
             </div>
             <div id="lblMonthlyCostHeader10e0" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lblMonthlyCostHeader" data-path="rptDependent 2 pnlDependentList lblMonthlyCostHeader" data-type="label" data-top="10" style="width:350px;height:20px;top:10px;left:390px;" class="widget widget-label blue uppercase widget-enabled widget-align-right invisible widget-absolute dynamic-tooltip">
                <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
                <div class="content control sc-label" id="l1112" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lblMonthlyCostHeader_l" data-height="20"><span class="ellipsis">Monthly cost</span></div>
                <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
             </div>
             <div id="lblBorrowerName10dd" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lblBorrowerName" data-path="rptDependent 2 pnlDependentList lblBorrowerName" data-type="label" data-top="40" style="width:350px;height:20px;top:40px;left:20px;" class="widget widget-label gray widget-enabled widget-absolute dynamic-tooltip">
                <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN -->
                <div class="content control sc-label" id="l1113" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lblBorrowerName_l" data-height="20"><span class="ellipsis">Tonda</span></div>
                <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
             </div>
             <div id="lnkDependentDelete10df" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lnkDependentDelete" data-path="rptDependent 2 pnlDependentList lnkDependentDelete" data-type="link" data-top="40" style="width:20px;height:20px;top:40px;left:370px;" class="widget widget-submit row-delete-icon widget-enabled widget-absolute dynamic-tooltip">
                <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent BEGIN --><a class="content control submit sc-link" id="submit1114" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lnkDependentDelete_submit" href="javascript:void(0);" aria-readonly="false" onclick="SC._submit.apply(this,['formcf9','formcf0','scAjax.apply(this,[1,0,\'?wicket:interface=:7:main:c:form:form:root:c:w:rptDependent:c:rows:3:item:pnlDependentList:c:w:lnkDependentDelete:submit::IBehaviorListener:0:-1&amp;${scrollPos}\',\'busyIndicatorcfa\',0,0,function(){return SC._isRowValid(\'submit1114\', false);},SC._serializeRow(\'submit1114\', false),0]);']);return false;" data-readonly="false" data-enabled="true" data-height="20" tabindex="1005"><span class="main ellipsis"><span class="link">Delete</span></span></a><!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.SubmitWidgetComponent END -->
             </div>
             <div id="lblMonthlyCost10e1" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lblMonthlyCost" data-path="rptDependent 2 pnlDependentList lblMonthlyCost" data-type="label" data-top="40" style="width:350px;height:20px;top:40px;left:390px;" class="widget widget-label gray widget-enabled widget-align-right invisible widget-absolute dynamic-tooltip">
                <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent BEGIN --><label id="label1115" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lblMonthlyCost_label" for="l1116" class="label-widget label-upperleft"></label>
                <div class="content control sc-label" id="l1116" wicketpath="main_c_form_form_root_c_w_rptDependent_c_rows_3_item_pnlDependentList_c_w_lblMonthlyCost_l" aria-labelledby="label1115" data-height="20"><span class="ellipsis">€</span></div>
                <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.LabelWidgetComponent END -->
             </div>
          </div>
       </div>
       <div id="ce1117" style="display:none"></div>
       <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.form.widget.PanelWidgetComponent END -->
    </div>
     */


    String YOUR_DEPENDENTS_APPLIES_TO_BORROWER_XPATH = "//label[contains(., '${replaceBorrower}$')]/following-sibling::span/a";
    String YOUR_DEPENDENTS_APPLIES_TO_COAPPLICANT_XPATH = "//label[contains(., '${replaceCoapplicant}$')]/following-sibling::span/a";
    String YOUR_DEPENDENTS_DATE_OF_BIRTH_XPATH = "//label[contains(., 'Date of birth')]/following-sibling::input";

    String YOUR_DEPENDENTS_ADD_THIS_DEPENDENT_XPATH = "//a[contains(., 'ADD THIS DEPENDENT')]";
    String YOUR_DEPENDENTS_ADD_DEPENDENT_XPATH = "//a[contains(., 'ADD DEPENDENT')]";
    String YOUR_DEPENDENTS_EDIT_THIS_DEPENDENT_XPATH = "//a[contains(., 'EDIT THIS DEPENDENT')]";
    String YOUR_DEPENDENTS_CANCEL_DEPENDENT_XPATH = "//a[contains(., 'CANCEL')]";
    String YOUR_DEPENDENTS_NEXT_DEPENDENT_XPATH = "//a[contains(., 'Next section')]";

    String getTitle();
    String getDescription();

    IYourDependentsSection clickSingleYes();
    IYourDependentsSection clickSingleNo();
    IYourDependentsSection clickCoupleYes();
    IYourDependentsSection clickCoupleNo();

    IYourDependentsSection checkAccountAppliesToBorrower(String borrower);
    IYourDependentsSection checkAccountAppliesToCoapplicant(String coapplicant);
    IYourDependentsSection typeDateOfBirth(String dateOfBirth);

    IYourDependentsSection clickAddThisDependent();
    IYourDependentsSection clickCancel();
    IYourDependentsSection clickAddDependent();
    IYourDependentsSection clickNext();
    IYourDependentsSection clickEditThisDependent(int index);

    String getDependentAge(int index);
    String getBorrowerName(int index);
    IYourDependentsSection deleteDependent(int index);
    IYourDependentsSection clickDependentPanel(int index);

}
