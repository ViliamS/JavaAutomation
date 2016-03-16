
@HP_Payday @:-] @:-P @:-]]
Feature: Payday Loan

  Background:
    Given Open Leveris Automatic Registration Page

  Scenario: Payday Load

    Given Borrower processes the automatic registration
      | applicantId | test.automation@test.finfactory.com |
#    Vili should comment this line and Tony should also & move api code ...
    When Borrower logs in via Automatic Registration
#    When Payday Loan User clicks on Continue button
#    Then Borrower clicks on Apply Online
#    And this registration data, user processes the registration (format2)
#      | firstName         | AutomationSB                               |
#      | email             | test.automation.payday@test.finfactory.com |
#      | phoneNumber       | +420123456789                              |
#      | password          | Password1122+                              |
#      | termsBusiness     | accepts                                    |
#      | protectionPolicy  | accepts                                    |

#    Then user goes to gmail
#    And user goes to CRM

#    Then Borrower logs in as his account is activated
#    When Borrower clicks "Create new user"

    Then Borrower clicks "Quote" task

    And Borrower clicks on continue to get Payday Loan
    And Borrower fills in Payday Loan form
      | LoanType           | Payday Loan |
      | NetMonthlyIncome   | 21,000.00   |
      | MonthlyExpenses    | 1,000.00    |
      | NumberOfDependants | 1           |
      | AmountToBorrow     | 1,000.00    |

    When Payday Loan Borrower clicks on Continue button
    Then Borrower clicks on Apply Online

    And Borrower processes "Forms"

#    PERSONAL DETAILS
#    When Borrower clicks "Borrower Personal Details"
    And Borrower fills in Personal Details
      | formType            | Personal Details  |
      | firstName           | AutomationGUI     |
      | lastName            | Tester            |
      | gender              | Male              |
      | dateOfBirth         | 01/01/1977        |
      | nationality         | French            |
      | maritalStatus       | single            |
      | address line 1      | 18 Woodquay       |
      | town/city           | Galway            |
      | country             | Ireland           |
      | county/state        | Galway            |
#      | accommodation       | Property owner     |
#      | isLivingSince3years | yes                |
    And Borrower saves his personal details data

#    EMPLOYMENT & INCOME
#    When Borrower clicks "Borrower Employment Income"

    And Borrower fills in Employment and Income type Paye
      | formType            | Paye        |
      | occupation          | Artist      |
      | employerName        | Hot Peppers Paye |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2013  |
      | isCurrentEmployment | yes         |
      | netMonthlyIncome    | 124000      |
#    And Borrower clicks "ADD EMPLOYMENT"
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
#    Vili
#    And Borrower fills in Current account
#      | formType           | Current account         |
#      | accountProvider       | deWilliamS              |
#      | statementDate         | 01/01/2000              |
#      | accountName           | test Current Account    |
#      | sortCode1             | 12                      |
#      | sortCode2             | 34                      |
#      | sortCode3             | 56                      |
#      | accountNumber         | 1234567890              |
#      | accountBalance        | 2001                    |
#      | overdraftLimit        | 2002                    |
#      | sourceOfSaving        | Gift                    |
#      | regularMonthlySaving  | 200                     |
#
#    And Borrower fills in Savings account
#      | formType           | Savings account         |
#      | accountProvider       | deWilliamS              |
## BUG OPO-280 - if added as second account the field disappears
#      | statementDate         | 01/01/2000              |
#      | accountName           | test Current Account    |
#      | sortCode1             | 12                      |
#      | sortCode2             | 34                      |
#      | sortCode3             | 56                      |
#      | accountNumber         | 0987654321              |
#      | accountBalance        | 2001                    |
#      | overdraftLimit        | 2002                    |
#      | sourceOfSaving        | Gift                    |
#      | regularMonthlySaving  | 200                     |
#    Tony
    And Borrower fills in Current account
      | formType     | Current account         |
      | accountProvider | test account provider   |
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
#    And Borrower fills in Savings account
#      | statementDate   | 01/01/2000              |
#      | accountName     | test Current Account    |
#      | sortCode1       | 12                      |
#      | sortCode2       | 34                      |
#      | sortCode3       | 56                      |
#      | accountNumber   | 0987654321              |
#      | accountBalance  | 2001                    |
##      | overdraftLimit  | 2002                    |
#      | sourceOfSaving  | Gift                    |
#      | regularMonthlySaving | 200                |
#    And Borrower clicks "ADD ACCOUNT"
#    And Borrower clicks "Account scraping"
#    And Borrower closes "scraping" form

#    And Borrower clicks "ADD ACCOUNT"
#     BUG OPO-280 - As one of the impacts its not possible to add second current account as form is a lot different from the first one.... why?? hope would be answered in OPO-280
#    And Borrower fills in Current account # BUG OPO-280
#      | accountType           | Current Account         | # BUG OPO-280
#      | accountProvider       | deWilliamS              | # BUG OPO-280
#      | statementDate         | 01/01/2000              | # BUG OPO-280
#      | accountName           | test Current Account    | # BUG OPO-280
#      | sortCode1             | 12                      | # BUG OPO-280
#      | sortCode2             | 34                      | # BUG OPO-280
#      | sortCode3             | 56                      | # BUG OPO-280
#      | accountNumber         | 1234567890              | # BUG OPO-280
#      | accountBalance        | 2001                    | # BUG OPO-280
#      | overdraftLimit        | 2002                    | # BUG OPO-280
#      | sourceOfSaving        | Gift                    | # BUG OPO-280
#      | regularMonthlySaving  | 200                     | # BUG OPO-280

    And Borrower clicks Accounts "Done"

#    YOUR DEPENDANTS
    And Borrower hasn't dependants
#  - negative way not adding any
#    And Borrower has dependants
#  - positive way is now included in whole form filling step definition and it is being automatically handled if present
##
#    And Borrower fills in "Dependant form"
#      | date Of Birth | 01/01/2000 |
#
#    And Borrower fills in "Dependant form"
#      | date Of Birth | 01/01/2000 |
#
#    And Borrower clicks "ADD DEPENDANT"
#  - not mandatory to use but is available and it would work
#
#    And Borrower fills in "Dependant form"
#      | date Of Birth | 01/01/2000 |
#
#    And Borrower clicks Dependants "Done"

#    Financial Commitments
#    When Borrower clicks "Financial Commitments"
    And Borrower hasn't financial commitments

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
#    And borrower finalizes the Borrower Phase
    And Borrower clicks "Review and Submit"
    And Borrower checks "Distance Marketing"
    And Borrower checks "Statutory"
    And Borrower checks "Declaration"
    And Borrower checks "Fraud Credit check"
#    And Borrower clicks "Submit your application"
    And finally, Borrower clicks "Submit Application"
