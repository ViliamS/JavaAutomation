
Feature: Api Double Borrowers

  Background:
    Given Borrower goes to Registration page

  Scenario: Simplest Double Borrowers

    Given this registration data, Borrower processes the registration (format2)
      | firstName         | AutomationDBApi                             |
      | email             | test.automation.stdbapi0001@test.finfactory.com |
      | phoneNumber       | +4201234567890                              |
      | password          | Password1122+                               |
      | termsBusiness     | accepts                                     |
      | protectionPolicy  | accepts                                     |

#    Then Borrower goes to gmail
#    And Borrower goes to CRM
    Then Borrower logs in as his account is activated

    Then Borrower processes "Get a Quote" (format2)
      | borrowerNumber           | two borrowers       |
      | mortgageType             | first-time buyer(s) |
      | borrowerAge              | 20                  |
      | partnerAge               | 20                  |
      | borrowerMaritalStatus    | separated           |
      | borrowerTotalDependants  | 1                   |
      | borrowerIncomeType       | an employee         |
      | borrowerIncomeAmount     | 150000              |
      | partnerIncomeType        | an employee         |
      | partnerIncomeAmount      | 150000              |
      | monthlyCreditCommitments | 0                   |

    And borrower invites a co-applicant
      | firstName | AutomationCoapplicantApi                    |
      | email     | test.automation.srcoapi0001@test.finfactory.com |

    And Borrower processes "Forms"

#    PERSONAL DETAILS
#    When Borrower clicks "Borrower Personal Details"
    And Borrower fills in "Personal Details"
      | firstName           | AutomationDBApi |
      | lastName            | Tester          |
      | gender              | Male            |
      | dateOfBirth         | 01/01/1977      |
      | address line 1      | 18 Woodquay     |
      | town/city           | Galway          |
      | county/state        | Galway          |
      | accommodation       | Property owner  |
      | isLivingSince3years | yes             |
    And Borrower saves his personal details data

#    EMPLOYMENT & INCOME
#    When Borrower clicks "Borrower Employment Income"
    And borrower fills in "Employment Income"
      | categoryIncome      | Paye        |
      | occupation          | ARTIST      |
      | employerName        | Hot Peppers |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2013  |
      | isCurrentEmployment | yes         |
      | grossSalary         | 124000      |
    And Borrower clicks "Done"

#    PERSONAL DETAILS
#    When Borrower clicks "Borrower Personal Details"
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
    And Coapplicant saves his personal details data

#    EMPLOYMENT & INCOME
#    When Coapplicant clicks "Borrower Employment Income"
    And coapplicant fills in "Employment Income"
      | categoryIncome      | Paye        |
      | occupation          | ARTIST      |
      | employerName        | Hot Peppers |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2013  |
      | isCurrentEmployment | yes         |
      | grossSalary         | 124000      |
    And Coapplicant clicks "Done"

#    YOUR ACCOUNTS
#    When Borrower clicks "Account"
    Then Borrower clicks "ADD ACCOUNT"
#    And Borrower clicks "ADD ACCOUNT MANUALLY"
    And Borrower fills in "Account"
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
    Then Borrower hasn't financial assets

#    Properties
#    When Borrower clicks "Properties"
    Then Borrower hasn't properties
    And Borrower hasn't a property in the past

#    Financial Commitments
#    When Borrower clicks "Financial Commitments"
    Then Borrower hasn't financial commitments

#    FUNDING
#    When Borrower clicks "Funding"
    Then Borrower clicks Funding "NEXT"

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
    And Borrower uploads all documents

#    FINAL STAGE 1
#    And borrower finalizes the Borrower Phase
    And Borrower clicks "Review and Submit"
    And Borrower clicks "Submit your application"
    And Borrower checks "Distance Marketing"
    And Borrower checks "Statutory"
    And Borrower checks "Declaration"
    And finally, Borrower clicks "Submit Application"
