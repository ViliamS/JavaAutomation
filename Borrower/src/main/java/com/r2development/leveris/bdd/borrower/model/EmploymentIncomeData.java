package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class EmploymentIncomeData extends DataModel {

    public EmploymentIncomeData(Map<String, String> employmentIncomeData) {
        super(employmentIncomeData);
    }

    public EmploymentIncomeData(List<String> employmentIncomeData) {
        super(employmentIncomeData);
    }

    public boolean isCurrentEmployment() {
        return data.get("isCurrentEmployment") != null && data.get("isCurrentEmployment").equals("yes");
    }

    public String getFormType() {
        return data.get("formType");
    }

    public String getOccupation() {
        return data.get("occupation");
    }

    public String getEmployerName() {
        return data.get("employerName");
    }

    public String getEmploymentType() {
        return data.get("employmentType");
    }

    public String getStartDate() {
        return data.get("startDate");
    }

    public String getNetMonthlyIncome() {
        return data.get("netMonthlyIncome");
    }

    public String getEndDate(){
        return data.get("endDate");
    }

    public String getBusinessName(){
        return data.get("businessName");
    }

    public String getAddressLine1(){
        return data.get("addressLine1");
    }

    public String getAddressLine2(){
        return data.get("addressLine2");
    }

    public String getTownCity(){
        return data.get("townCity");
    }

    public String getCountry(){
        return data.get("country");
    }

    public String getCountyState(){
        return data.get("countyState");
    }

    public String getBusinessNature(){
        return data.get("businessNature");
    }

    public String getAdditionalIncomeSource(){
        return data.get("additionalIncomeSource");
    }

    public String getTimeEarningIncome(){
        return data.get("timeEarningIncome");
    }
}

/**
 And Borrower fills in Employment and Income type Paye
 | formType            | Paye              |
 | occupation          | Artist            |
 | employerName        | Hot Peppers Paye  |
 | employmentType      | Permanent         |
 | startDate           | 05/11/2013        |
 | isCurrentEmployment | yes               |
 | netMonthlyIncome    | 124000            |

 And Borrower fills in Employment and Income type Self Employed
 | categoryIncome      | Self Employed      |
 | occupation          | Artist             |
 | businessName        | testBusinessName   |
 | addressLine1        | 18 Woodquay        |
 | townCity            | Galway             |
 | country             | Ireland            |
 | countyState         | Galway             |
 | businessNature      | testNatureBusiness |
 | startDate           | 05/11/2013         |
 | isCurrentEmployment | yes                |
 | netMonthlyIncome    | 124000             |

 And Borrower fills in Employment and Income type Unemployed/Homemaker
 | formType            | Unemployed/Homemaker |
 | startDate           | 05/11/2013           |
 | isCurrentEmployment | yes                  |

 And Borrower fills in Employment and Income type Other
 | formType               | Other                      |
 | additionalIncomeSource | testAdditionalIncomeSource |
 | netMonthlyIncome       | 2000                       |
 | timeEarningIncome      | 200                        |
 */