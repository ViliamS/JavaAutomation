package com.r2development.leveris.bdd.borrower.model;

import java.util.Map;

public class LandingPageData /* extends DataModel */ {

    private Map<String, String> quotationData;

    public LandingPageData(Map<String, String> quotationData){
        this.quotationData.putAll(quotationData);
    }

    public Map<String, String> getQuotationData(){
        return quotationData;
    }

    public String getUpToAmount(){ return quotationData.get("UpToAmount"); }

    public String  getFromAmountPerMonth() { return quotationData.get("FromAmountPerMonth"); }

    public String getPayDayLoanAmount() { return quotationData.get("PayDayLoanAmount"); }

    public String getLoanPurpose() { return quotationData.get("LoanPurpose"); }

    public String getNetMonthlyIncome() { return quotationData.get("NetMothlyIncome"); }

    public String getMonthlyExpenses() { return quotationData.get("MonthlyExpenses"); }

    public String getNumberOfDependents() { return quotationData.get("NumberOfDependents"); }

    public String getAmountToBorrow() { return quotationData.get("AmountToBorrow"); }

    public String getMonthlyRepayment() { return quotationData.get("MonthlyRepayment"); }
}
