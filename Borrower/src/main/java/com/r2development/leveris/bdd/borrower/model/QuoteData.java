package com.r2development.leveris.bdd.borrower.model;

import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;

public class QuoteData extends DataModel {

    public QuoteData() {
        super();
    }

    public QuoteData(Map<String, String> quoteDataMap) {
        super(quoteDataMap);
    }

    public QuoteData(List<String> quoteDataMap) {
        super(quoteDataMap);
    }

    public String getBorrowerNumber() {
        return data.get("borrowerNumber");
    }

    public void setBorrowerNumber(String borrowerNumber) {
        data.replace("borrowerNumber", borrowerNumber);
    }

    public String getMortgageType() {
        return data.get("mortgageType");
    }

    public void setMortgageType(String mortgageType) {
        data.replace("mortgageType", mortgageType);
    }

    public String getBorrowerAge() {
        return data.get("borrowerAge");
    }

    public void setBorrowerAge(String borrowerAge) {
        data.replace("borrowerAge", borrowerAge);
    }

    public String getPartnerAge() {
        return data.get("partnerAge");
    }

    public void setPartnerAge(String partnerAge) {
        data.replace("partnerAge", partnerAge);
    }

    public String getBorrowerMaritalStatus() {
        return data.get("borrowerMaritalStatus");
    }

    public void setBorrowerMaritalStatus(String borrowerMaritalStatus) {
        data.replace("borrowerMaritalStatus", borrowerMaritalStatus);
    }

    public String getBorrowerTotalDependants() {
        return data.get("borrowerTotalDependants");
    }

    public void setBorrowerTotalDependants(String borrowerTotalDependants) {
        data.replace("borrowerTotalDependants", borrowerTotalDependants);
    }

    public String getBorrowerIncomeType() {
        return data.get("borrowerIncomeType");
    }


    public void setBorrowerIncomeType(String borrowerIncomeType) {
        data.replace("borrowerIncomeType", borrowerIncomeType);
    }

    public String getBorrowerIncomeAmount() {
        return data.get("borrowerIncomeAmount");
    }

    public void setBorrowerIncomeAmount(String borrowerIncomeAmount) {
        data.replace("borrowerIncomeAmount", borrowerIncomeAmount);
    }

    public String getPartnerIncomeType() {
        return data.get("partnerIncomeType");
    }

    public void setPartnerIncomeType(String partnerIncomeType) {
        data.replace("partnerIncomeType", partnerIncomeType);
    }

    public String getPartnerIncomeAmount() {
        return data.get("partnerIncomeAmount");
    }

    public void setPartnerIncomeAmount(String partnerIncomeAmount) {
        data.replace("partnerIncomeAmount", partnerIncomeAmount);
    }

    public String getMonthlyCreditCommitments() {
        return data.get("monthlyCreditCommitments");
    }

    public void setMonthlyCreditCommitments(String monthlyCreditCommitments) {
        data.replace("monthlyCreditCommitments", monthlyCreditCommitments);
    }

    public boolean isEligible() {
        return StringUtils.isNotEmpty(data.get("isEligible"));
    }

    public void setIsEligible(String isEligible) {
        data.replace("isEligible", isEligible);
    }

    public String getMaxLoanAmount() {
        return data.get("maxLoanAmount");
    }

    public void setMaxLoanAmount(String maxLoanAmount) {
        data.replace("maxLoanAmount", maxLoanAmount);
    }

    public String getMonthlyPayment() {
        return data.get("monthlyPayment");
    }

    public void setMonthlyPayment(String monthlyPayment) {
        data.replace("monthlyPayment", monthlyPayment);
    }

    public String getMinimumDeposit() {
        return data.get("minimumDeposit");
    }

    public void setMinimumDeposit(String minimumDeposit) {
        data.replace("minimumDeposit", minimumDeposit);
    }
}
