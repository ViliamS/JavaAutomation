
Feature: Payday Loan

  Background:
    Given Open Leveris Quote Landing page

  Scenario: Payday Load

    Given Borrower clicks on continue to get Unsecured Loan
    And Borrower fills in Unsecured Loan form
      | LoanPurpose        | PERSONAL  |
      | NetMonthlyIncome   | 44,000.00 |
      | MonthlyExpenses    | 5,000.00  |
      | NumberOfDependants | 3         |
      | AmountToBorrow     | 1,000.00  |
    When Unsecured Loan Borrower clicks on Continue button
    Then Borrower clicks on Apply Online
    And this registration data, Borrower processes the registration (format2)
      | firstName         | AutomationSBUI                                    |
      | email             | test_automation.sbui@test.finfactory.com          |
      | phoneNumber       | +4201234567890                                    |
      | password          | Password1122+                                     |
      | termsBusiness     | accepts                                           |
      | protectionPolicy  | accepts                                           |

#    Then Borrower goes to gmail
#    And Borrower goes to CRM
    Then Borrower logs in as his account is activated
    And Borrower processes "Forms"

#    PERSONAL DETAILS
#    When Borrower clicks "Borrower Personal Details"
    And borrower fills in "Personal Details"
      | firstName           | AutomationSBUI |
      | lastName            | Tester         |
      | gender              | Male           |
      | dateOfBirth         | 01/01/1977     |
      | maritalStatus       | single         |
      | address line 1      | 18 Woodquay    |
      | town/city           | Galway         |
      | county/state        | Galway         |
      | accommodation       | Property owner |
      | isLivingSince3years | yes            |
    And Borrower saves his personal details data

#    EMPLOYMENT & INCOME
#    When Borrower clicks "Borrower Employment Income"
    And borrower fills in "Employment Income"
      | categoryIncome      | Paye        |
      | occupation          | Artist      |
      | employerName        | Hot Peppers |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2013  |
      | isCurrentEmployment | yes         |
      | grossSalary         | 124000      |
    And Borrower clicks "Done"

#    YOUR ACCOUNTS
#    When Borrower clicks "Account"
    Then Borrower clicks "ADD ACCOUNT"
#    And Borrower clicks "ADD ACCOUNT MANUALLY"
    And Borrower fills in Current account
      | fundsSource     | Current Account         |
      | accountProvider | Central Bank of Ireland |
      | IBAN            | IE92BOFI90001710027952  |
      | accountBalance  | 20000                   |
    And Borrower clicks Accounts "NEXT"

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
#    And Borrower Borrower uploads the file file.txt as Proof of identity document
#    And Borrower Borrower uploads the file file.txt as Proof of address document
#    And Borrower Borrower uploads the file file.txt as P60 document
#    And Borrower Borrower uploads the file file.txt as Current payslip document
#    And Borrower Borrower uploads the file file.txt as Previous payslip document
#    And Borrower Borrower uploads the file file.txt as Salary certificate document
#    And Borrower Borrower uploads the file file.txt as Current account - IE92BOFI90001710027952 document
    And Upload all documents

#    FINAL STAGE 1
#    And borrower finalizes the Borrower Phase
    And Borrower clicks "Review and Submit"
    And Borrower clicks "Submit your application"
    And Borrower checks "Distance Marketing"
    And Borrower checks "Statutory"
    And Borrower checks "Declaration"
    And finally, Borrower clicks "Submit Application"
