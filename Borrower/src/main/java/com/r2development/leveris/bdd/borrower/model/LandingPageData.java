package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class LandingPageData extends DataModel {

//    public Map<String, String> quotationData = new LinkedHashMap<>();

    public LandingPageData(Map<String, String> quotationData){
        this.data.putAll(quotationData);
    }

    public LandingPageData(List<String> quotationData) {
        super(quotationData);
    }

    public Map<String, String> getQuotationData(){
        return getData();
    }

    public String getFormType(){ return data.get("formType"); }

    public String getUpToAmount(){ return data.get("UpToAmount"); }

    public String  getFromAmountPerMonth() { return data.get("FromAmountPerMonth"); }

    public String getPayDayLoanAmount() { return data.get("PayDayLoanAmount"); }

    public String getLoanPurpose() { return data.get("LoanPurpose"); }

    public String getNetMonthlyIncome() { return data.get("NetMonthlyIncome"); }

    public String getMonthlyExpenses() { return data.get("MonthlyExpenses"); }

    public String getNumberOfDependants() { return data.get("NumberOfDependants"); }

    public String getLoanAmount() { return data.get("AmountToBorrow"); }

    public String getMonthlyInstallmentAmount() { return data.get("MonthlyRepayment"); }
}

/**
 * Example setting Feature file
 *
 And Borrower fills in Unsecured Loan form
 | formType           | Unsecured Loan     |
 | loanPurpose        | Personal purposes  |
 | NetMonthlyIncome   | 210,000.00         |
 | MonthlyExpenses    | 2,000.00           |
 | NumberOfDependants | 0                  |
 | AmountToBorrow     | 15,000.00          |
 *
 * or example no. 2
 *
 And Borrower fills in Payday Loan form
 | formType           | Payday Loan |
 | NetMonthlyIncome   | 21,000.00   |
 | MonthlyExpenses    | 1,000.00    |
 | NumberOfDependants | 1           |
 | AmountToBorrow     | 1,000.00    |
 *
 * or non mandatory filling of loanPurpose for Payday loan as it
 * is already pre-selected in application, but it is valid to use
 *
 And Borrower fills in Payday Loan form
 | formType           | Payday Loan |
 | loanPurpose        | Payday Loan |
 | NetMonthlyIncome   | 21,000.00   |
 | MonthlyExpenses    | 1,000.00    |
 | NumberOfDependants | 1           |
 | AmountToBorrow     | 1,000.00    |
 *
 * That's all.
 */