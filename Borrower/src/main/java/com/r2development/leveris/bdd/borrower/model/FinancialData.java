package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class FinancialData extends DataModel {

    public FinancialData(Map<String, String> financialData) {
        super(financialData);
    }

    public FinancialData(List<String> financialData) {
        super(financialData);
    }

    public String getFormType(){
        return data.get("formType");
    }

    public String getOutstandingAmount(){
        return data.get("outstandingAmount");
    }

    public String getFinancialInstitution(){
        return data.get("financialInstitution");
    }

    public String getPurposeOfTheLoan(){
        return data.get("purposeOfTheLoan");
    }

    public String getFinalRepaymentDate(){
        return data.get("finalRepaymentDate");
    }

    public String getPaymentFrequency(){
        return data.get("paymentFrequency");
    }

    public String getRepaymentAmount(){
        return data.get("repaymentAmount");
    }

    public String getCardProvider(){
        return data.get("cardProvider");
    }

    public String getCardType(){
        return data.get("cardType");
    }

    public String getCardLimit(){
        return data.get("cardLimit");
    }

    public String getCardBalance(){
        return data.get("cardBalance");
    }

    public String getMonthlyMaintenancePayment(){
        return data.get("monthlyMaintenancePayment");
    }

    public String getValue(){
        return data.get("value");
    }

    public String getDescription(){
        return data.get("description");
    }

    public String getNote(){
        return data.get("note");
    }
}


/**
 *
 * Then Borrower selects Personal Loan as his financial commitment
 | formType              | Personal Loan |
 | outstandingAmount     | 1500          |
 | financialInstitution  | HellsBank     |
 | purposeOfTheLoan      | Debt repay    |
 | finalRepaymentDate    | 01/03/2018    |
 | paymentFrequency      | Monthly       |
 | repaymentAmount       | 2500          |

 Then Borrower selects Credit Card as his financial commitment
 | formType              | Credit Card |
 | repaymentAmount       | 2500        |
 | cardProvider          | Friend      |
 | cardType              | VISA        |
 | cardLimit             | 50000       |
 | cardBalance           | 45000       |

 Then Borrower selects Maintenance Payment as his financial commitment
 | formType                  | Maintenance Payment |
 | monthlyMaintenancePayment | 1000                |

 Then Borrower selects Other as his financial commitment
 | formType        | Other     |
 | repaymentAmount | 2500      |
 | value           | 5000      |
 | description     | text1232  |

 Then Borrower selects Car Loan as his financial commitment
 | formType              | Car Loan   |
 | outstandingAmount     | 2500       |
 | financialInstitution  | Hell Bank  |
 | finalRepaymentDate    | 31/03/2018 |
 | paymentFrequency      | Weekly     |
 | repaymentAmount       | 15000      |

 Then Borrower selects Student Loan as his financial commitment
 | formType              | Student Loan |
 | outstandingAmount     | 5000         |
 | financialInstitution  | Bank of Debt |
 | finalRepaymentDate    | 01/03/2020   |
 | paymentFrequency      | Fortnightly  |
 | repaymentAmount       | 50000        |

 Then Borrower selects Rent as his financial commitment
 | formType          | Rent    |
 | paymentFrequency  | Yearly  |
 | repaymentAmount   | 15000   |
 | note              | ABC123  |

 Then Borrower selects Utilities as his financial commitment
 | formType          | Utilities |
 | paymentFrequency  | Weekly    |
 | repaymentAmount   | 2500      |
 | note              | wsad8546  |

 Then Borrower selects Childcare as his financial commitment
 | formType          | Childcare |
 | paymentFrequency  | Weekly    |
 | repaymentAmount   | 250       |
 | note              | wsad8546  |

 Then Borrower selects Mortgage as his financial commitment
 | formType              | Mortgage     |
 | outstandingAmount     | 5000         |
 | financialInstitution  | Bank of Debt |
 | finalRepaymentDate    | 01/03/2020   |
 | repaymentAmount       | 50000        |
 *
 */
