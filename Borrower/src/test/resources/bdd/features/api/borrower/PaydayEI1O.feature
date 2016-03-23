@:-] @:-P @:-]] @Payday @1O
Feature: Payday Loan

  Background:
    Given Open Leveris Automatic Registration Page

  Scenario: Payday Loan - Employment & Income Other

    Given Borrower processes the automatic registration
      | applicantId | test.automation.api@finfactory.com |

    Then Borrower clicks "Quote" task

    And Borrower clicks on continue to get Payday Loan
    And Borrower fills in Payday Loan form
      | formType           | Payday Loan |
      | NetMonthlyIncome   | 21,000.00   |
      | MonthlyExpenses    | 1,000.00    |
      | NumberOfDependants | 1           |
      | AmountToBorrow     | 1,000.00    |
    When Payday Loan Borrower clicks on Continue button
    Then Borrower clicks on Apply Online

    And Borrower processes "Forms"

#    PERSONAL DETAILS
    And Borrower fills in Personal Details
      | formType            | Personal Details  |
      | firstName           | AutomationAPI     |
      | lastName            | Tester            |
      | gender              | Male              |
      | dateOfBirth         | 01/01/1977        |
      | nationality         | French            |
      | maritalStatus       | single            |
    And Borrower saves his personal details data

#    EMPLOYMENT & INCOME
    And Borrower fills in Employment and Income type Other
      | formType               | Other                      |
      | additionalIncomeSource | testAdditionalIncomeSource |
      | startDate              | 01/01/2000                 |
      | endDate                | 02/02/2002                 |
      | netMonthlyIncome       | 2000                       |
      | timeEarningIncome      | 200                        |
      | isCurrentEmployment    | yes                        |
    And Borrower clicks "Done"

#    ACCOUNTS
    And Borrower fills in Current account
      | formType        | Current account         |
      | statementDate   | 01/01/2000              |
      | accountProvider | test account provider 1 |
      | accountHolderName | AutomationAPI         |
      | accountName     | test Current Account 1  |
      | sortCode1       | 12                      |
      | sortCode2       | 34                      |
      | sortCode3       | 56                      |
      | accountNumber   | 1234567                 |
      | accountBalance  | 2001                    |
      | overdraftLimit  | 2002                    |
      | sourceOfSaving  | Gift                    |
      | regularMonthlySaving | 200                |
    And Borrower clicks Accounts "Done"

#     DEPENDANTS
     And Borrower hasn't dependants

#    EXPENSE & FINANCIAL
     And Borrower hasn't financial commitments

#    DOCUMENT UPLOAD
    And Borrower uploads all documents

#    FINAL STAGE 1
    And Borrower clicks "Review and Submit"
    And Borrower checks "Distance Marketing"
    And Borrower checks "Statutory"
    And Borrower checks "Declaration"
    And Borrower checks "Fraud Credit check"
    And finally, Borrower clicks "Submit Application"
