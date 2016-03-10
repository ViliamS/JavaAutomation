
Feature: Payday Loan

  Background:
    Given Open Leveris Quote Landing page

  Scenario: Payday Load

    Given Borrower clicks on continue to get Payday Loan
    And Borrower fills in Payday Loan form
#      | LoanPurpose        | PAYDAY    |
      | NetMonthlyIncome   | 21,000.00 |
      | MonthlyExpenses    | 1,000.00  |
      | NumberOfDependents | 1         |
      | AmountToBorrow     | 500       |
    When Payday Loan User clicks on Continue button
    Then Borrower clicks on Apply Online
    And this registration data, user processes the registration (format2)
      | firstName         | AutomationSB                               |
      | email             | test.automation.payday@test.finfactory.com |
      | phoneNumber       | +420123456789                              |
      | password          | Password1122+                              |
      | termsBusiness     | accepts                                    |
      | protectionPolicy  | accepts                                    |

#    Then user goes to gmail
#    And user goes to CRM
    Then Borrower logs in as his account is activated
    And Borrower processes "Forms"

#    PERSONAL DETAILS
#    When user clicks "Borrower Personal Details"
    And Borrower fills in "Personal Details"
      | firstName           | AutomationSBUI |
      | lastName            | Tester         |
      | gender              | Male           |
      | dateOfBirth         | 01/01/1977     |
      | nationality         | French         |
      | maritalStatus       | single         |
      | address line 1      | 18 Woodquay    |
      | town/city           | Galway         |
      | country             | Ireland        |
      | county/state        | Galway         |
#      | accommodation       | Property owner |
#      | isLivingSince3years | yes            |
    And Borrower saves his personal details data

#    EMPLOYMENT & INCOME
#    When user clicks "Borrower Employment Income"

    And Borrower fills in Employment and Income type Paye
      | categoryIncome      | Paye        |
      | occupation          | Artist      |
      | employerName        | Hot Peppers Paye |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2013  |
      | isCurrentEmployment | yes         |
      | netMonthlyIncome    | 124000      |
#    And Borrower user clicks "ADD EMPLOYMENT"
#    And Borrower fills in Employment and Income type Paye
#      | categoryIncome      | Paye        |
#      | occupation          | Artist      |
#      | employerName        | Hot Peppers Paye |
#      | employmentType      | Permanent   |
#      | startDate           | 05/11/2013  |
#      | isCurrentEmployment | yes         |
#      | netMonthlyIncome    | 124000      |
#    And Borrower fills in Employment and Income type Self Employed
#      | categoryIncome      | Self Employed      |
#      | occupation          | Artist             |
#      | businessName        | testBusinessName   |
#      | addressLine1        | 18 Woodquay        |
#      | townCity            | Galway             |
#      | country             | Ireland            |
#      | countyState         | Galway             |
#      | businessNature      | testNatureBusiness |
#      | startDate           | 05/11/2013         |
#      | isCurrentEmployment | yes                |
#      | netMonthlyIncome    | 124000             |
#    And borrower user clicks "ADD EMPLOYMENT"
#    And borrower fills in "Employment Income"
#      | categoryIncome      | Civil Servant |
#      | occupation          | Artist        |
#      | employerName        | Hot Peppers Civil Servant  |
#      | employmentType      | Permanent     |
#      | startDate           | 05/11/2013    |
#      | isCurrentEmployment | yes           |
#      | netMonthlyIncome    | 124000        |
#    And borrower user clicks "ADD EMPLOYMENT"
#    And borrower fills in "Employment Income"
#      | categoryIncome      | Unemployed/Homemaker |
#      | startDate           | 05/11/2013           |
#      | isCurrentEmployment | yes                  |
#    And borrower user clicks "ADD EMPLOYMENT"
#    And borrower fills in "Employment Income"
#      | categoryIncome      | Unemployed/Homemaker |
#      | startDate           | 13/11/2013           |
#      | endDate             | 13/12/2014           |
#    And borrower user clicks "ADD EMPLOYMENT"
#    And borrower fills in "Employment Income"
#      | categoryIncome         | Other                      |
#      | additionalIncomeSource | testAdditionalIncomeSource |
#      | netMonthlyIncome       | 2000                       |
#      | timeEarningIncome      | 200                        |
    And Borrower clicks "Done"

#    YOUR ACCOUNTS
    And Borrower fills in Current account
      | accountType     | Current account         |
      | accountProvider | bli bla bleu            |
      | statementDate   | 01/01/2000              |
      | accountName     | test Current Account    |
      | sortCode1       | 12                      |
      | sortCode2       | 34                      |
      | sortCode3       | 56                      |
      | accountNumber   | 1234567890              |
      | accountBalance  | 2001                    |
      | overdraftLimit  | 2002                    |
      | sourceOfSaving  | Gift                    |
      | regularMonthlySaving | 200                |
#    And Borrower clicks "ADD ACCOUNT"
#    And Borrower clicks Savings account
#    And Borrower fills in Savings account
#      | accountType     | Savings account         |
#      | statementDate   | 01/01/2000              |
#      | accountName     | test Current Account    |
#      | sortCode1       | 12                      |
#      | sortCode2       | 34                      |
#      | sortCode3       | 56                      |
#      | accountNumber   | 0987654321              |
#      | accountBalance  | 2001                    |
#      | overdraftLimit  | 2002                    |
#      | sourceOfSaving  | Gift                    |
#      | regularMonthlySaving | 200                |
#    And Borrower clicks "ADD ACCOUNT"
#    And user clicks "Account scraping"
#    And user closes "scraping" form
    And Borrower clicks Accounts "Done"

#    YOUR DEPENDENT
    And Borrower hasn't dependents
#    And user has dependents
#    And user fills in "Dependant form"
#    | date Of Birth | 01/01/2000 |
#    And user clicks "ADD DEPENDANT"
#    And user fills in "Dependant form"
#      | date Of Birth | 01/01/2000 |
#    And user clicks Dependants "Done"

#    Financial Commitments
#    When user clicks "Financial Commitments"
    And  Borrower hasn't financial commitments

#    FUNDING
#    When user clicks "Funding"
# should be changed to I'm done :)
#    Then user clicks Funding "NEXT"

#    DOCUMENT UPLOAD
#    And user uploads required document
#    And user clicks "Document Upload"
#    And Borrower user uploads the file file.txt as Proof of identity document
#    And Borrower user uploads the file file.txt as Proof of address document
#    And Borrower user uploads the file file.txt as P60 document
#    And Borrower user uploads the file file.txt as Current payslip document
#    And Borrower user uploads the file file.txt as Previous payslip document
#    And Borrower user uploads the file file.txt as Salary certificate document
#    And Borrower user uploads the file file.txt as Current account - IE92BOFI90001710027952 document
    And Borrower uploads all documents

#    FINAL STAGE 1
#    And borrower finalizes the Borrower Phase
    And Borrower clicks "Review and Submit"
    And Borrower checks "Distance Marketing"
    And Borrower checks "Statutory"
    And Borrower checks "Declaration"
#    And user clicks "Submit your application"
    And finally, Borrower clicks "Submit Application"
