
Feature: Payday Loan

  Background:
    Given Open Leveris Quote Landing page

  Scenario: Payday Load

    Given Borrower logs in with these credentials
      | email | test_automation.payday_ui@test.finfactory.com |
      | pwd   | Password1122+                                                   |

#    PERSONAL DETAILS
#    When Borrower clicks "Borrower Personal Details"
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
#    And Borrower clicks "ADD EMPLOYMENT"
#    And Borrower fills in "Employment Income"
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
#    And Borrower clicks "ADD EMPLOYMENT"
#    And Borrower fills in "Employment Income"
#      | categoryIncome      | Civil Servant |
#      | occupation          | Artist        |
#      | employerName        | Hot Peppers Civil Servant  |
#      | employmentType      | Permanent     |
#      | startDate           | 05/11/2013    |
#      | isCurrentEmployment | yes           |
#      | netMonthlyIncome    | 124000        |
#    And Borrower clicks "ADD EMPLOYMENT"
#    And Borrower fills in "Employment Income"
#      | categoryIncome      | Unemployed/Homemaker |
#      | startDate           | 05/11/2013           |
#      | isCurrentEmployment | yes                  |
#    And Borrower clicks "ADD EMPLOYMENT"
#    And Borrower fills in "Employment Income"
#      | categoryIncome      | Unemployed/Homemaker |
#      | startDate           | 13/11/2013           |
#      | endDate             | 13/12/2014           |
#    And Borrower clicks "ADD EMPLOYMENT"
#    And Borrower fills in "Employment Income"
#      | categoryIncome         | Other                      |
#      | additionalIncomeSource | testAdditionalIncomeSource |
#      | netMonthlyIncome       | 2000                       |
#      | timeEarningIncome      | 200                        |
    And Borrower clicks "Done"

#    YOUR ACCOUNTS
#    When Borrower clicks "Account"
#    Then Borrower clicks "ADD ACCOUNT"
    And Borrower clicks "Current account"
    And Borrower fills in Current account
      | fundsSource     | Current Account         |
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
#    And Borrower clicks "Savings account"
#    And Borrower fills in "Savings Account"
#      | statementDate   | 01/01/2000              |
#      | accountProvider | Central Bank of Ireland |
#      | IBAN            | IE60BOFI90600516322733  |
#      | accountBalance  | 20000                   |
#      | sourceOfSaving  | Gift                    |
#    And Borrower clicks "ADD ACCOUNT"
#    And Borrower clicks "Account scraping"
#    And Borrower closes "scraping" form
    And Borrower clicks Accounts "Done"

#    YOUR DEPENDANT
#    When Borrower clicks "Dependants"
    Then Borrower hasn't dependants

#    YOUR FINANCIAL ASSETS
#    When Borrower clicks "Financial Assets"
#    Then Borrower hasn't financial assets

#    Properties
#    When Borrower clicks "Properties"
#    Then Borrower hasn't properties
#    And Borrower hasn't a property in the past

#    Financial Commitments
#    When Borrower clicks "Financial Commitments"
    Then Borrower hasn't financial commitments

#    FUNDING
#    When Borrower clicks "Funding"
# should be changed to I'm done :)
#    Then Borrower clicks Funding "NEXT"

#    DOCUMENT UPLOAD
#    And Borrower uploads required document
#    And Borrower clicks "Document Upload"
#    And Borrower uploads the file file.txt as Proof of identity document
#    And Borrower uploads the file file.txt as Proof of address document
#    And Borrower uploads the file file.txt as P60 document
#    And Borrower uploads the file file.txt as Current payslip document
#    And Borrower uploads the file file.txt as Previous payslip document
#    And Borrower uploads the file file.txt as Salary certificate document
#    And Borrower uploads the file file.txt as Current account - IE92BOFI90001710027952 document
    And Borrower uploads all documents

#    FINAL STAGE 1
#    And Borrower finalizes the Borrower Phase
#    And Borrower clicks "Review and Submit"
#    And Borrower checks "Distance Marketing"
#    And Borrower checks "Statutory"
#    And Borrower checks "Declaration"
#    And Borrower clicks "Submit your application"
#    And finally, Borrower clicks "Submit Application"
