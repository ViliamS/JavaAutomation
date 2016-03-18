package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.employmentincome;

/**
 * Created by anthonymottot on 17/03/2016.
 */
public interface IEmploymentIncomeOther {

    String EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_MONTHLY_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlNetIcomeOther_c_w_crbNetIcomeOther_tb']";
    String EMPLOYMENT_INCOME_OTHER_FORM_NET_ADDITIONAL_INCOME_SOURCE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlOther_c_w_txtSourceAdditionalIncome_tb']";
    String EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_TIME_EARNING_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlDetail_c_w_pnlNetIcomeOther_c_w_txtOtherNetIncomeTime_tb']";

    IEmploymentIncomeOther typeOther_NetIncomeMonthly(String netIncomeMonthly);
    IEmploymentIncomeOther typeOther_AdditionalIncomeSource(String additionalIncomeSource);
    IEmploymentIncomeOther typeOther_EarningTime(String earningTIme);

}
