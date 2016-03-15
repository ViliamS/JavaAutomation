
Feature: Payday Loan

  Background:
    Given Open Leveris Quote Landing page

  Scenario: Payday Load

    Given Borrower logs in with these credentials
      | email | test_automation.payday_ui@test.finfactory.com |
      ## TODO ... sync
      | pwd   | Password1122+                                 |

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
#    When Borrower clicks "Borrower Employment Income"
    And Borrower fills in "Employment Income"
      | categoryIncome      | Paye        |
      | occupation          | Artist      |
      | employerName        | Hot Peppers Paye |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2013  |
      | isCurrentEmployment | yes         |
      | netMonthlyIncome    | 124000      |
#    And borrower user clicks "ADD EMPLOYMENT"
#    And borrower fills in "Employment Income"
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
    And Borrower user clicks "Done"

#    YOUR ACCOUNTS
#    When user clicks "Account"
#    Then user clicks "ADD ACCOUNT"
    And Borrower clicks "Current account"
    And Borrower fills in "Current account"
      | fundsSource     | Current qccount         |
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
#    And user clicks "ADD ACCOUNT"
#    And user clicks "Savings account"
#    And user fills in "Savings Account"
#      | statementDate   | 01/01/2000              |
#      | accountProvider | Central Bank of Ireland |
#      | IBAN            | IE60BOFI90600516322733  |
#      | accountBalance  | 20000                   |
#      | sourceOfSaving  | Gift                    |
#    And user clicks "ADD ACCOUNT"
#    And user clicks "Account scraping"
#    And user closes "scraping" form
    And Borrower clicks Accounts "Done"

#    YOUR DEPENDANT
#    When Borrower clicks "Dependants"
    Then Borrower hasn't dependants

#    YOUR FINANCIAL ASSETS
#    When user clicks "Financial Assets"
#    Then user hasn't financial assets

#    Properties
#    When user clicks "Properties"
#    Then user hasn't properties
#    And user hasn't a property in the past

#    Financial Commitments
#    When user clicks "Financial Commitments"
    Then Borrower hasn't financial commitments

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
    And user clicks "Review and Submit"
    And user checks "Distance Marketing"
    And user checks "Statutory"
    And user checks "Declaration"
#    And user clicks "Submit your application"
    And finally, user clicks "Submit Application"
