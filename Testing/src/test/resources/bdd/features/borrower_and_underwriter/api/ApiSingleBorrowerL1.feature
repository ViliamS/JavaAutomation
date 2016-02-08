
Feature: Api Single Borrower

  Background:
    Given user goes to Registration page

  Scenario: Simplest Single Borrower

    Given this registration data, user processes the registration (format2)
      | firstName         | AutomationSBApi                           |
      | email             | test_automation.sbapi.test0001@abakus.com |
      | phoneNumber       | 1234567890                                |
      | password          | Password1122                              |
      | termsBusiness     | accepts                                   |
      | protectionPolicy  | accepts                                   |

#    Then user goes to gmail
#    And user goes to CRM
    Then  user logs in as his account is activated

    Then user processes "Get a Quote" (format2)
      | borrowerNumber           | a single borrower   |
      | mortgageType             | first-time buyer(s) |
      | borrowerAge              | 28                  |
      | borrowerMaritalStatus    | single              |
      | borrowerTotalDependents  | 0                   |
      | borrowerIncomeType       | an employee         |
      | borrowerIncomeAmount     | 125000              |
      | monthlyCreditCommitments | 1000                |

    And borrower goes solo

    And user processes "Forms"

#    PERSONAL DETAILS
#    When user clicks "Borrower Personal Details"
    And borrower fills in "Personal Details"
      | firstName           | AutomationSBApi |
      | lastName            | Tester          |
      | gender              | Male            |
      | dateOfBirth         | 01/01/1977      |
      | address line 1      | 18 Woodquay     |
      | town/city           | Galway          |
      | county/state        | Galway          |
      | country             | Ireland         |
      | accommodation       | Property owner  |
      | isLivingSince3years | yes             |
      | maritalStatus       | single          |
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

#    Underwriter
    Given user processes SSO Auth Step 1
    And user processes SSO Auth Step 2
    And user processes final SSO Auth Step

    When user looks for these information
      | assign | ALL |
      | status | AllActive |
      | search | AUTOMATIONSBAPI20160205171043551 |
#        | applicationId | 4344                      |
    Then user opens the application of the customer AUTOMATIONSBAPI20160205171043551
    And user validates all documents
    And user saves offer
    And user completes and signs the offer
    And user refreshes workflow panel
    And user completes stage 1
    And user refreshes workflow panel
    And user completes stage 2