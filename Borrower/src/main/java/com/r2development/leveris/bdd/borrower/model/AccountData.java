package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class AccountData extends DataModel {

    public AccountData(Map<String, String> accountData) {
        super(accountData);
    }

    public AccountData(List<String> accountData) {
        super(accountData);
    }

    public String getFormType() {
        return data.get("formType");
    }

    public void setAccountType(String accountType){
        data.replace("accountType", accountType);
    }

    public String getAccountHolderName() {
        return data.get("accountHolderName");
    }

    public void setAccountHolderName(String accountHolderName){
        data.replace("accountHolderName", accountHolderName);
    }

    public String getStatementDate() {
        return data.get("statementDate");
    }

    public void setStatementDate(String statementDate){
        data.replace("statementDate", statementDate);
    }

    public String getAccountProvider(){
        return data.get("accountProvider");
    }

    public String getAccountName() {
        return data.get("accountName");
    }

    public void setAccountName(String accountName){
        data.replace("accountName", accountName);
    }

    public String getSortCode1() {
        return data.get("sortCode1");
    }

    public void setSortCode1(String sortCode1){
        data.replace("sortCode1", sortCode1);
    }

    public String getSortCode2() {
        return data.get("sortCode2");
    }

    public void setSortCode2(String sortCode2){
        data.replace("sortCode2", sortCode2);
    }

    public String getSortCode3() {
        return data.get("sortCode3");
    }

    public void setSortCode3(String sortCode3){
        data.replace("sortCode3", sortCode3);
    }

    public String getAccountNumber() {
        return data.get("accountNumber");
    }

    public void setAccountNumber(String accountNumber){
        data.replace("accountNumber", accountNumber);
    }

    public String getAccountBalance() {
        return data.get("accountBalance");
    }

    public void setAccountBalance(String accountBalance){
        data.replace("accountBalance", accountBalance);
    }

    public String getOverdraftLimit() {
        return data.get("overdraftLimit");
    }

    public void setOverdraftLimit(String overdraftLimit){
        data.replace("overdraftLimit", overdraftLimit);
    }

    public String getSourceOfSaving() {
        return data.get("sourceOfSaving");
    }

    public void setSourceOfSaving(String sourceOfSaving){
        data.replace("sourceOfSaving", sourceOfSaving);
    }

    public String getRegularMonthlySaving() {
        return data.get("regularMonthlySaving");
    }

    public void setRegularMonthlySaving(String regularMonthlySaving){
        data.replace("regularMonthlySaving", regularMonthlySaving);
    }

    /**
    public String get() {
        return data.get("");
    }

    public void set(String ){
        data.replace("", );
    }
    */

    /**
     And Borrower fills in Current account
     | formType              | Current account         |
     | statementDate         | 21/03/2016              |
     | accountProvider       | CSOB                    |
     | accountHolderName     | deWilliamS              |
     | sortCode1             | 12                      |
     | sortCode2             | 34                      |
     | sortCode3             | 56                      |
     | accountNumber         | 1234567                 |
     | accountBalance        | 2001                    |
     | overdraftLimit        | 2002                    |

     And Borrower fills in Savings account
     | accountType           | Savings account         |
     | accountProvider       | deWilliamS              |
     # BUG OPO-280 - if added as second account the field disappears
     | statementDate         | 01/01/2000              |
     | accountName           | test Current Account    |
     | sortCode1             | 12                      |
     | sortCode2             | 34                      |
     | sortCode3             | 56                      |
     | accountNumber         | 09876543                |
     | accountBalance        | 2001                    |
     | sourceOfSaving        | Gift                    |
     | regularMonthlySaving  | 200                     |
     */
}
