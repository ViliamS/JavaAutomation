
@HP_Payday @:-] @:-P @:-]]
Feature: Payday Loan

  Background:
    Given Open Leveris Automatic Registration Page
#    Given Open Leveris Quote Landing page

  Scenario: Payday Loan

#----- begin With automatic
    Given Borrower processes the automatic registration
      | applicantId | test.automation@finfactory.com |
#----- end with automatic

#----- begin without automatic
#    When Borrower clicks on continue to get Payday Loan
#    And Borrower fills in Payday Loan form
#      | formType           | Payday Loan |
#      | NetMonthlyIncome   | 21,000.00   |
#      | MonthlyExpenses    | 1,000.00    |
#      | NumberOfDependants | 1           |
#      | AmountToBorrow     | 1,000.00    |
#    When Payday Loan Borrower clicks on Continue button
#    Then Borrower clicks on Apply Online
#    And this registration data, user processes the registration (format2)
#      | firstName         | AutomationSB                               |
#      | email             | test.automation.payday@test.finfactory.com |
#      | phoneNumber       | +420123456789                              |
#      | password          | Password1122+                              |
#      | termsBusiness     | accepts                                    |
#      | protectionPolicy  | accepts                                    |
#----- end without automatic

#    Then user goes to gmail
#    And user goes to CRM

#    Then Borrower logs in as his account is activated
#     Then Borrower logs in as his account is activated via DB
#    When Borrower clicks "Create new user"

#------ begin With automatic
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
#------ end With automatic

    And Borrower processes "Forms"

#    PERSONAL DETAILS
#    When Borrower clicks "Borrower Personal Details"
    And Borrower fills in Personal Details
      | formType            | Personal Details  |
      | firstName           | AutomationAPI     |
      | lastName            | Tester            |
      | gender              | Male              |
      | dateOfBirth         | 01/01/1977        |
      | nationality         | French            |
      | maritalStatus       | single            |
      | address line 1      | 18 Woodquay       |
      | town/city           | Galway            |
      | country             | Ireland           |
      | county/state        | Galway            |
      | accommodation       | Property owner     |
      | isLivingSince3years | yes                |
    And Borrower saves his personal details data

#    And Borrower fills in Current residency
#      | formType | Current residency |

#    EMPLOYMENT & INCOME
    And Borrower fills in Employment and Income type Paye
      | formType            | Paye        |
      | occupation          | Artist      |
      | employerName        | Hot Peppers Paye |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2013  |
      | endDate             | 06/12/2014  |
      | isCurrentEmployment | yes         |
      | netMonthlyIncome    | 124000      |
#    And Borrower fills in Employment and Income type Paye
#      | formType            | Paye        |
#      | occupation          | Artist      |
#      | employerName        | Hot Peppers Paye |
#      | employmentType      | Permanent   |
#      | startDate           | 05/11/2013  |
#      | endDate             | 06/12/2014  |
#      | isCurrentEmployment | yes         |
#      | netMonthlyIncome    | 124000      |
#    And Borrower fills in Employment and Income type Self Employed
#      | formType            | Self Employed      |
#      | occupation          | Artist             |
#      | businessName        | testBusinessName   |
#      | addressLine1        | 18 Woodquay        |
#      | addressLine2        | Galway             |
#      | townCity            | Galway             |
#      | country             | Ireland            |
#      | countyState         | Galway             |
#      | businessNature      | testNatureBusiness |
#      | startDate           | 05/11/2013         |
#      | endDate             | 06/12/2014         |
##      | isCurrentEmployment | yes                |
#      | netMonthlyIncome    | 124000             |
#    And Borrower fills in Employment and Income type Unemployed/Homemaker
#      | formType            | Unemployed/Homemaker |
#      | startDate           | 13/11/2013           |
#      | endDate             | 13/12/2014           |
#      | isCurrentEmployment | yes                  |
#    And Borrower fills in Employment and Income type Other
#      | formType               | Other                      |
#      | additionalIncomeSource | testAdditionalIncomeSource |
#      | startDate              | 01/01/2000                 |
#      | endDate                | 02/02/2002                 |
#      | netMonthlyIncome       | 2000                       |
#      | timeEarningIncome      | 200                        |
#      | isCurrentEmployment    | yes                        |
    And Borrower clicks "Done"
#
##    YOUR ACCOUNTS
##    And Borrower fills in Savings account
##      | formType           | Savings account         |
##      | accountProvider       | deWilliamS              |
### BUG OPO-280 - if added as second account the field disappears
##      | statementDate         | 01/01/2000              |
##      | accountName           | test Current Account    |
##      | sortCode1             | 12                      |
##      | sortCode2             | 34                      |
##      | sortCode3             | 56                      |
##      | accountNumber         | 0987654321              |
##      | accountBalance        | 2001                    |
##      | overdraftLimit        | 2002                    |
##      | sourceOfSaving        | Gift                    |
##      | regularMonthlySaving  | 200                     |
##    Tony
#    And Borrower fills in Current account
#      | formType        | Current account         |
#      | statementDate   | 01/01/2000              |
#      | accountProvider | test account provider 1 |
## TODO .... set with the user inject value
#      | accountHolderName | AutomationAPI         |
#      | accountName     | test Current Account 1 |
#      | sortCode1       | 12                      |
#      | sortCode2       | 34                      |
#      | sortCode3       | 56                      |
#      | accountNumber   | 1234567                 |
#      | accountBalance  | 2001                    |
#      | overdraftLimit  | 2002                    |
#      | sourceOfSaving  | Gift                    |
#      | regularMonthlySaving | 200                |
#    And Borrower fills in Current account
#      | formType        | Current account         |
#      | statementDate   | 01/01/2001              |
#      | accountProvider | test account provider 2 |
#      | accountHolderName | AutomationAPI         |
##      | accountName     | test Current Account 2 |
#      | sortCode1       | 12                      |
#      | sortCode2       | 34                      |
#      | sortCode3       | 56                      |
#      | accountNumber   | 1234568                 |
#      | accountBalance  | 2001                    |
#      | overdraftLimit  | 2002                    |
#      | sourceOfSaving  | Gift                    |
#      | regularMonthlySaving | 200                |
##    And Borrower clicks "ADD ACCOUNT"
##    And Borrower clicks "Savings account"
#    And Borrower fills in Savings account
#      | formType        | Savings account         |
#      | statementDate   | 01/01/2000              |
#      | accountProvider | test account provider 3 |
#      | accountHolderName | AutomationAPI         |
##      | accountName     | test Current Account 3 |
#      | sortCode1       | 12                      |
#      | sortCode2       | 34                      |
#      | sortCode3       | 56                      |
#      | accountNumber   | 0987654                 |
#      | accountBalance  | 2001                    |
##      | overdraftLimit  | 2002                    |
#      | sourceOfSaving  | Gift                    |
#      | regularMonthlySaving | 200                |
#    And Borrower fills in Savings account
#      | formType        | Savings account         |
#      | statementDate   | 01/01/2000              |
#      | accountProvider | test account provider 4 |
#      | accountHolderName | AutomationAPI 4       |
##      | accountName     | test Current Account 4 |
#      | sortCode1       | 12                      |
#      | sortCode2       | 34                      |
#      | sortCode3       | 56                      |
#      | accountNumber   | 9987654                 |
#      | accountBalance  | 2001                    |
##      | overdraftLimit  | 2002                    |
#      | sourceOfSaving  | Gift                    |
#      | regularMonthlySaving | 200                |
##    And Borrower clicks "ADD ACCOUNT"
##    And Borrower clicks "Account scraping"
##    And Borrower closes "scraping" form
#
##    And Borrower clicks "ADD ACCOUNT"
##     BUG OPO-280 - As one of the impacts its not possible to add second current account as form is a lot different from the first one.... why?? hope would be answered in OPO-280
##    And Borrower fills in Current account # BUG OPO-280
##      | accountType           | Current Account         | # BUG OPO-280
##      | accountProvider       | deWilliamS              | # BUG OPO-280
##      | statementDate         | 01/01/2000              | # BUG OPO-280
##      | accountName           | test Current Account    | # BUG OPO-280
##      | sortCode1             | 12                      | # BUG OPO-280
##      | sortCode2             | 34                      | # BUG OPO-280
##      | sortCode3             | 56                      | # BUG OPO-280
##      | accountNumber         | 1234567890              | # BUG OPO-280
##      | accountBalance        | 2001                    | # BUG OPO-280
##      | overdraftLimit        | 2002                    | # BUG OPO-280
##      | sourceOfSaving        | Gift                    | # BUG OPO-280
##      | regularMonthlySaving  | 200                     | # BUG OPO-280

#    And Borrower clicks Accounts "Done"

#    YOUR DEPENDANTS
#    And Borrower hasn't dependants
##    And Borrower has dependants
#    And Borrower fills in "Dependant form"
#      | dateOfBirth | 01/01/2000 |
#    And Borrower fills in "Dependant form"
#      | dateOfBirth | 01/01/2000 |
#    And Borrower fills in "Dependant form"
#      | dateOfBirth | 01/01/2000 |
#    And Borrower clicks Dependants "Done"

#    Financial Commitments
#    And Borrower hasn't financial commitments
##    When Borrower has financial commitments
##    And Borrower clicks financial Add
#    Then Borrower fills in Personal Loan
#      | formType              | Personal Loan |
#      | outstandingAmount     | 1500          |
#      | financialInstitution  | HellsBank     |
#      | purposeOfTheLoan      | Debt repay    |
#      | finalRepaymentDate    | 01/03/2018    |
#      | paymentFrequency      | Monthly       |
#      | repaymentAmount       | 2500          |
#    Then Borrower fills in Credit Card
#      | formType              | Credit Card |
#      | repaymentAmount       | 2500        |
#      | cardProvider          | Friend      |
#      | cardType              | VISA        |
#      | cardLimit             | 50000       |
#      | cardBalance           | 45000       |
#    Then Borrower fills in Maintenance Payment
#      | formType                  | Maintenance Payment |
#      | monthlyMaintenancePayment | 1000                |
#    Then Borrower fills in Other
#      | formType        | Other     |
#      | repaymentAmount | 2500      |
#      | value           | 5000      |
#      | description     | text1232  |
#    Then Borrower fills in Car Loan
#      | formType              | Car Loan   |
#      | outstandingAmount     | 2500       |
#      | financialInstitution  | Hell Bank  |
#      | finalRepaymentDate    | 31/03/2018 |
#      | paymentFrequency      | Weekly     |
#      | repaymentAmount       | 15000      |
#    Then Borrower fills in Student Loan
#      | formType              | Student Loan |
#      | outstandingAmount     | 5000         |
#      | financialInstitution  | Bank of Debt |
#      | finalRepaymentDate    | 01/03/2020   |
#      | paymentFrequency      | Fortnightly  |
#      | repaymentAmount       | 50000        |
#    Then Borrower fills in Rent
#      | formType          | Rent    |
#      | paymentFrequency  | Yearly  |
#      | repaymentAmount   | 15000   |
#      | note              | ABC123  |
#    Then Borrower fills in Utilities
#      | formType          | Utilities |
#      | paymentFrequency  | Weekly    |
#      | repaymentAmount   | 2500      |
#      | note              | wsad8546  |
#    Then Borrower fills in Childcare
#      | formType          | Childcare |
#      | paymentFrequency  | Weekly    |
#      | repaymentAmount   | 250       |
#      | note              | wsad8546  |
#    Then Borrower fills in Mortgage
#      | formType              | Mortgage     |
#      | outstandingAmount     | 5000         |
#      | financialInstitution  | Bank of Debt |
#      | finalRepaymentDate    | 01/03/2020   |
#      | repaymentAmount       | 50000        |
#    And Borrower clicks financial Done

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
#    And Borrower uploads all documents

#    FINAL STAGE 1
#    And borrower finalizes the Borrower Phase
#    And Borrower clicks "Review and Submit"
#    And Borrower checks "Distance Marketing"
#    And Borrower checks "Statutory"
#    And Borrower checks "Declaration"
#    And Borrower checks "Fraud Credit check"
#    And finally, Borrower clicks "Submit Application"

    When user processes SSO Underwriter Auth Step
    And user processes final SSO Underwriter Auth Step
#    When user looks for these information
#      | assign | ALL |
#      | status | AllActive |
#      | search | AUTOMATIONSBAPI20160205171043551 |
##        | applicationId | 4344                      |
#    Then user opens the application of the customer



  Scenario: Payday Loan 2

#----- begin With automatic
    Given Borrower processes the automatic registration
      | applicantId | test.automation@finfactory.com |
#----- end with automatic

#----- begin without automatic
#    When Borrower clicks on continue to get Payday Loan
#    And Borrower fills in Payday Loan form
#      | formType           | Payday Loan |
#      | NetMonthlyIncome   | 21,000.00   |
#      | MonthlyExpenses    | 1,000.00    |
#      | NumberOfDependants | 1           |
#      | AmountToBorrow     | 1,000.00    |
#    When Payday Loan Borrower clicks on Continue button
#    Then Borrower clicks on Apply Online
#    And this registration data, user processes the registration (format2)
#      | firstName         | AutomationSB                               |
#      | email             | test.automation.payday@test.finfactory.com |
#      | phoneNumber       | +420123456789                              |
#      | password          | Password1122+                              |
#      | termsBusiness     | accepts                                    |
#      | protectionPolicy  | accepts                                    |
#----- end without automatic

#    Then user goes to gmail
#    And user goes to CRM

#    Then Borrower logs in as his account is activated
#     Then Borrower logs in as his account is activated via DB
#    When Borrower clicks "Create new user"

#------ begin With automatic
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
#------ end With automatic

    And Borrower processes "Forms"

#    PERSONAL DETAILS
#    When Borrower clicks "Borrower Personal Details"
    And Borrower fills in Personal Details
      | formType            | Personal Details  |
      | firstName           | AutomationAPI     |
      | lastName            | Tester            |
      | gender              | Male              |
      | dateOfBirth         | 01/01/1977        |
      | nationality         | French            |
      | maritalStatus       | single            |
      | address line 1      | 18 Woodquay       |
      | town/city           | Galway            |
      | country             | Ireland           |
      | county/state        | Galway            |
      | accommodation       | Property owner     |
      | isLivingSince3years | yes                |
    And Borrower saves his personal details data

#    And Borrower fills in Current residency
#      | formType | Current residency |

#    EMPLOYMENT & INCOME
    And Borrower fills in Employment and Income type Paye
      | formType            | Paye        |
      | occupation          | Artist      |
      | employerName        | Hot Peppers Paye |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2013  |
      | endDate             | 06/12/2014  |
      | isCurrentEmployment | yes         |
      | netMonthlyIncome    | 124000      |
#    And Borrower fills in Employment and Income type Paye
#      | formType            | Paye        |
#      | occupation          | Artist      |
#      | employerName        | Hot Peppers Paye |
#      | employmentType      | Permanent   |
#      | startDate           | 05/11/2013  |
#      | endDate             | 06/12/2014  |
#      | isCurrentEmployment | yes         |
#      | netMonthlyIncome    | 124000      |
#    And Borrower fills in Employment and Income type Self Employed
#      | formType            | Self Employed      |
#      | occupation          | Artist             |
#      | businessName        | testBusinessName   |
#      | addressLine1        | 18 Woodquay        |
#      | addressLine2        | Galway             |
#      | townCity            | Galway             |
#      | country             | Ireland            |
#      | countyState         | Galway             |
#      | businessNature      | testNatureBusiness |
#      | startDate           | 05/11/2013         |
#      | endDate             | 06/12/2014         |
##      | isCurrentEmployment | yes                |
#      | netMonthlyIncome    | 124000             |
#    And Borrower fills in Employment and Income type Unemployed/Homemaker
#      | formType            | Unemployed/Homemaker |
#      | startDate           | 13/11/2013           |
#      | endDate             | 13/12/2014           |
#      | isCurrentEmployment | yes                  |
#    And Borrower fills in Employment and Income type Other
#      | formType               | Other                      |
#      | additionalIncomeSource | testAdditionalIncomeSource |
#      | startDate              | 01/01/2000                 |
#      | endDate                | 02/02/2002                 |
#      | netMonthlyIncome       | 2000                       |
#      | timeEarningIncome      | 200                        |
#      | isCurrentEmployment    | yes                        |
    And Borrower clicks "Done"
#
##    YOUR ACCOUNTS
##    And Borrower fills in Savings account
##      | formType           | Savings account         |
##      | accountProvider       | deWilliamS              |
### BUG OPO-280 - if added as second account the field disappears
##      | statementDate         | 01/01/2000              |
##      | accountName           | test Current Account    |
##      | sortCode1             | 12                      |
##      | sortCode2             | 34                      |
##      | sortCode3             | 56                      |
##      | accountNumber         | 0987654321              |
##      | accountBalance        | 2001                    |
##      | overdraftLimit        | 2002                    |
##      | sourceOfSaving        | Gift                    |
##      | regularMonthlySaving  | 200                     |
##    Tony
#    And Borrower fills in Current account
#      | formType        | Current account         |
#      | statementDate   | 01/01/2000              |
#      | accountProvider | test account provider 1 |
## TODO .... set with the user inject value
#      | accountHolderName | AutomationAPI         |
#      | accountName     | test Current Account 1 |
#      | sortCode1       | 12                      |
#      | sortCode2       | 34                      |
#      | sortCode3       | 56                      |
#      | accountNumber   | 1234567                 |
#      | accountBalance  | 2001                    |
#      | overdraftLimit  | 2002                    |
#      | sourceOfSaving  | Gift                    |
#      | regularMonthlySaving | 200                |
#    And Borrower fills in Current account
#      | formType        | Current account         |
#      | statementDate   | 01/01/2001              |
#      | accountProvider | test account provider 2 |
#      | accountHolderName | AutomationAPI         |
##      | accountName     | test Current Account 2 |
#      | sortCode1       | 12                      |
#      | sortCode2       | 34                      |
#      | sortCode3       | 56                      |
#      | accountNumber   | 1234568                 |
#      | accountBalance  | 2001                    |
#      | overdraftLimit  | 2002                    |
#      | sourceOfSaving  | Gift                    |
#      | regularMonthlySaving | 200                |
##    And Borrower clicks "ADD ACCOUNT"
##    And Borrower clicks "Savings account"
#    And Borrower fills in Savings account
#      | formType        | Savings account         |
#      | statementDate   | 01/01/2000              |
#      | accountProvider | test account provider 3 |
#      | accountHolderName | AutomationAPI         |
##      | accountName     | test Current Account 3 |
#      | sortCode1       | 12                      |
#      | sortCode2       | 34                      |
#      | sortCode3       | 56                      |
#      | accountNumber   | 0987654                 |
#      | accountBalance  | 2001                    |
##      | overdraftLimit  | 2002                    |
#      | sourceOfSaving  | Gift                    |
#      | regularMonthlySaving | 200                |
#    And Borrower fills in Savings account
#      | formType        | Savings account         |
#      | statementDate   | 01/01/2000              |
#      | accountProvider | test account provider 4 |
#      | accountHolderName | AutomationAPI 4       |
##      | accountName     | test Current Account 4 |
#      | sortCode1       | 12                      |
#      | sortCode2       | 34                      |
#      | sortCode3       | 56                      |
#      | accountNumber   | 9987654                 |
#      | accountBalance  | 2001                    |
##      | overdraftLimit  | 2002                    |
#      | sourceOfSaving  | Gift                    |
#      | regularMonthlySaving | 200                |
##    And Borrower clicks "ADD ACCOUNT"
##    And Borrower clicks "Account scraping"
##    And Borrower closes "scraping" form
#
##    And Borrower clicks "ADD ACCOUNT"
##     BUG OPO-280 - As one of the impacts its not possible to add second current account as form is a lot different from the first one.... why?? hope would be answered in OPO-280
##    And Borrower fills in Current account # BUG OPO-280
##      | accountType           | Current Account         | # BUG OPO-280
##      | accountProvider       | deWilliamS              | # BUG OPO-280
##      | statementDate         | 01/01/2000              | # BUG OPO-280
##      | accountName           | test Current Account    | # BUG OPO-280
##      | sortCode1             | 12                      | # BUG OPO-280
##      | sortCode2             | 34                      | # BUG OPO-280
##      | sortCode3             | 56                      | # BUG OPO-280
##      | accountNumber         | 1234567890              | # BUG OPO-280
##      | accountBalance        | 2001                    | # BUG OPO-280
##      | overdraftLimit        | 2002                    | # BUG OPO-280
##      | sourceOfSaving        | Gift                    | # BUG OPO-280
##      | regularMonthlySaving  | 200                     | # BUG OPO-280

#    And Borrower clicks Accounts "Done"

#    YOUR DEPENDANTS
#    And Borrower hasn't dependants
##    And Borrower has dependants
#    And Borrower fills in "Dependant form"
#      | dateOfBirth | 01/01/2000 |
#    And Borrower fills in "Dependant form"
#      | dateOfBirth | 01/01/2000 |
#    And Borrower fills in "Dependant form"
#      | dateOfBirth | 01/01/2000 |
#    And Borrower clicks Dependants "Done"

#    Financial Commitments
#    And Borrower hasn't financial commitments
##    When Borrower has financial commitments
##    And Borrower clicks financial Add
#    Then Borrower fills in Personal Loan
#      | formType              | Personal Loan |
#      | outstandingAmount     | 1500          |
#      | financialInstitution  | HellsBank     |
#      | purposeOfTheLoan      | Debt repay    |
#      | finalRepaymentDate    | 01/03/2018    |
#      | paymentFrequency      | Monthly       |
#      | repaymentAmount       | 2500          |
#    Then Borrower fills in Credit Card
#      | formType              | Credit Card |
#      | repaymentAmount       | 2500        |
#      | cardProvider          | Friend      |
#      | cardType              | VISA        |
#      | cardLimit             | 50000       |
#      | cardBalance           | 45000       |
#    Then Borrower fills in Maintenance Payment
#      | formType                  | Maintenance Payment |
#      | monthlyMaintenancePayment | 1000                |
#    Then Borrower fills in Other
#      | formType        | Other     |
#      | repaymentAmount | 2500      |
#      | value           | 5000      |
#      | description     | text1232  |
#    Then Borrower fills in Car Loan
#      | formType              | Car Loan   |
#      | outstandingAmount     | 2500       |
#      | financialInstitution  | Hell Bank  |
#      | finalRepaymentDate    | 31/03/2018 |
#      | paymentFrequency      | Weekly     |
#      | repaymentAmount       | 15000      |
#    Then Borrower fills in Student Loan
#      | formType              | Student Loan |
#      | outstandingAmount     | 5000         |
#      | financialInstitution  | Bank of Debt |
#      | finalRepaymentDate    | 01/03/2020   |
#      | paymentFrequency      | Fortnightly  |
#      | repaymentAmount       | 50000        |
#    Then Borrower fills in Rent
#      | formType          | Rent    |
#      | paymentFrequency  | Yearly  |
#      | repaymentAmount   | 15000   |
#      | note              | ABC123  |
#    Then Borrower fills in Utilities
#      | formType          | Utilities |
#      | paymentFrequency  | Weekly    |
#      | repaymentAmount   | 2500      |
#      | note              | wsad8546  |
#    Then Borrower fills in Childcare
#      | formType          | Childcare |
#      | paymentFrequency  | Weekly    |
#      | repaymentAmount   | 250       |
#      | note              | wsad8546  |
#    Then Borrower fills in Mortgage
#      | formType              | Mortgage     |
#      | outstandingAmount     | 5000         |
#      | financialInstitution  | Bank of Debt |
#      | finalRepaymentDate    | 01/03/2020   |
#      | repaymentAmount       | 50000        |
#    And Borrower clicks financial Done

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
#    And Borrower uploads all documents

#    FINAL STAGE 1
#    And borrower finalizes the Borrower Phase
#    And Borrower clicks "Review and Submit"
#    And Borrower checks "Distance Marketing"
#    And Borrower checks "Statutory"
#    And Borrower checks "Declaration"
#    And Borrower checks "Fraud Credit check"
#    And finally, Borrower clicks "Submit Application"

    When user processes SSO Underwriter Auth Step
    And user processes final SSO Underwriter Auth Step
#    When user looks for these information
#      | assign | ALL |
#      | status | AllActive |
#      | search | AUTOMATIONSBAPI20160205171043551 |
##        | applicationId | 4344                      |
#    Then user opens the application of the customer