
Feature: Api Double Borrower

  Background:
    Given user goes to Registration page

  Scenario: Simplest Double Borrower

    Given this registration data, user processes the registration (format2)
      | firstName         | AutomationDBApi                             |
      | email             | test_automation.ttdbapi.test0001@abakus.com |
      | phoneNumber       | 1234567890                                  |
      | password          | Password1122                                |
      | termsBusiness     | accepts                                     |
      | protectionPolicy  | accepts                                     |

#    Then user goes to gmail
#    And user goes to CRM
    Then  user logs in as his account is activated

    Then user processes "Get a Quote" (format2)
      | borrowerNumber           | two borrowers       |
      | mortgageType             | first-time buyer(s) |
      | borrowerAge              | 20                  |
      | partnerAge               | 20                  |
      | borrowerMaritalStatus    | separated           |
      | borrowerTotalDependents  | 1                   |
      | borrowerIncomeType       | an employee         |
      | borrowerIncomeAmount     | 150000              |
      | partnerIncomeType        | an employee         |
      | partnerIncomeAmount      | 150000              |
      | monthlyCreditCommitments | 0                   |

    And borrower invites a co-applicant
      | firstName | AutomationCoapplicantApi                     |
      | email     | test_automation.test.srcoapi0001@abakus.com |

    And user processes "Forms"

#    PERSONAL DETAILS
#    When user clicks "Borrower Personal Details"
    And borrower fills in "Personal Details"
      | firstName           | AutomationDBApi |
      | lastName            | Tester          |
      | gender              | Male            |
      | dateOfBirth         | 01/01/1977      |
      | address line 1      | 18 Woodquay     |
      | town/city           | Galway          |
      | county/state        | Galway          |
      | accommodation       | Property owner  |
      | isLivingSince3years | yes             |
    And borrower user saves his personal details data

#    EMPLOYMENT & INCOME
#    When user clicks "Borrower Employment Income"
    And borrower fills in "Employment Income"
      | categoryIncome      | Paye        |
      | occupation          | ARTIST      |
      | employerName        | Hot Peppers |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2013  |
      | isCurrentEmployment | yes         |
      | grossSalary         | 124000      |
    And borrower user clicks "Done"

#    PERSONAL DETAILS
#    When user clicks "Borrower Personal Details"
    And coapplicant fills in "Personal Details"
      | firstName           | AutomationCoapplicantApi |
      | lastName            | Tester                   |
      | gender              | Male                     |
      | dateOfBirth         | 01/01/1977               |
      | address line 1      | 18 Woodquay              |
      | town/city           | Galway                   |
      | county/state        | Galway                   |
      | accommodation       | Property owner           |
      | isLivingSince3years | yes                      |
    And coapplicant user saves his personal details data

#    EMPLOYMENT & INCOME
#    When user clicks "Borrower Employment Income"
    And coapplicant fills in "Employment Income"
      | categoryIncome      | Paye        |
      | occupation          | ARTIST      |
      | employerName        | Hot Peppers |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2013  |
      | isCurrentEmployment | yes         |
      | grossSalary         | 124000      |
    And coapplicant user clicks "Done"

#    YOUR ACCOUNTS
#    When user clicks "Account"
    Then user clicks "ADD ACCOUNT"
#    And user clicks "ADD ACCOUNT MANUALLY"
    And user fills in "Account"
      | fundsSource     | Current Account         |
      | accountProvider | Central Bank of Ireland |
      | IBAN            | IE92BOFI90001710027952  |
      | accountBalance  | 20000                   |
    And user clicks Accounts "NEXT"

#    YOUR DEPENDENT
#    When user clicks "Dependents"
    Then user hasn't dependents

#    YOUR FINANCIAL ASSETS
#    When user clicks "Financial Assets"
    Then user hasn't financial assets

#    Properties
#    When user clicks "Properties"
    Then user hasn't properties
    And user hasn't a property in the past

#    Financial Commitments
#    When user clicks "Financial Commitments"
    Then user hasn't financial commitments

#    FUNDING
#    When user clicks "Funding"
    Then user clicks Funding "NEXT"

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
    And Upload all documents

#    FINAL STAGE 1
#    And borrower finalizes the Borrower Phase
    And user clicks "Review and Submit"
    And user clicks "Submit your application"
    And user checks "Distance Marketing"
    And user checks "Statutory"
    And user checks "Declaration"
    And finally, user clicks "Submit Application"
