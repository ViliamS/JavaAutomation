@HPPaydayLoan
Feature: Payday Loan

  Background:
#    Given Open Leveris Quote Landing page
    Given Open Leveris Automatic Registration Page

  Scenario: Payday Load

#    Given User clicks on continue to get Payday Loan
#
#    And User fills in Payday Loan form
##      | LoanPurpose        | PAYDAY    |
#      | NetMonthlyIncome   | 21,000.00 |
#      | MonthlyExpenses    | 1,000.00  |
#      | NumberOfDependents | 1         |
#      | AmountToBorrow     | 1,000.00  |
#
#    When Payday Loan User clicks on Continue button
#
#    Then User clicks on Apply Online
#
#    And this registration data, user processes the registration (format2)
#      | firstName         | AutomationSBUI                                    |
#      | email             | test.automation.payday@test.finfactory.com        |
#      | phoneNumber       | +420123456789                                     |
#      | password          | Password1122+                                     |
#      | termsBusiness     | accepts                                           |
#      | protectionPolicy  | accepts                                           |
#
##    Then user goes to gmail
##    And user goes to CRM
#    Then Borrower user logs in as his account is activated

    Given Borrower processes the automatic registration
      | ApplicantId | test.automation.test@finfactory.com |

    Then Borrower clicks "Quote" task

#    When Use Automatic registration page to create a new Borrower and login
#      | ApplicantId | test.automation.test@finfactory.com |
#
#    Then Borrower wants to get a quote now

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
    And Borrower fills in "Personal Details"
      | firstName           | AutomationGUI    |
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
      | categoryIncome      | Paye              |
      | occupation          | Artist            |
      | employerName        | Hot Peppers Paye  |
      | employmentType      | Permanent         |
      | startDate           | 05/11/2013        |
      | isCurrentEmployment | yes               |
      | netMonthlyIncome    | 124000            |

#   This step is optional if it is not declared following form fill detects on itself if it needs click on add
#    And Borrower clicks "ADD EMPLOYMENT"
#
#    And Borrower fills in Employment and Income type Paye
#      | categoryIncome      | Paye              |
#      | occupation          | Artist            |
#      | employerName        | Hot Peppers Paye  |
#      | employmentType      | Permanent         |
#      | startDate           | 05/11/2013        |
#      | isCurrentEmployment | yes               |
#      | netMonthlyIncome    | 124000            |
#
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
#    And borrower Borrower clicks "ADD EMPLOYMENT"
#    And borrower fills in "Employment Income"
#      | categoryIncome      | Civil Servant |
#      | occupation          | Artist        |
#      | employerName        | Hot Peppers Civil Servant  |
#      | employmentType      | Permanent     |
#      | startDate           | 05/11/2013    |
#      | isCurrentEmployment | yes           |
#      | netMonthlyIncome    | 124000        |
#    And borrower Borrower clicks "ADD EMPLOYMENT"
#    And borrower fills in "Employment Income"
#      | categoryIncome      | Unemployed/Homemaker |
#      | startDate           | 05/11/2013           |
#      | isCurrentEmployment | yes                  |
#    And borrower Borrower clicks "ADD EMPLOYMENT"
#    And borrower fills in "Employment Income"
#      | categoryIncome      | Unemployed/Homemaker |
#      | startDate           | 13/11/2013           |
#      | endDate             | 13/12/2014           |
#    And borrower Borrower clicks "ADD EMPLOYMENT"
#    And borrower fills in "Employment Income"
#      | categoryIncome         | Other                      |
#      | additionalIncomeSource | testAdditionalIncomeSource |
#      | netMonthlyIncome       | 2000                       |
#      | timeEarningIncome      | 200                        |

    And Borrower clicks "Done"

#    YOUR ACCOUNTS
#    And Borrower fills in Current account
#      | accountType           | Current Account         |
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

    And Borrower fills in Savings account
      | accountType           | Savings account         |
     | accountProvider       | deWilliamS              |
# BUG OPO-280 - if added as second account the field disappears
      | statementDate         | 01/01/2000              |
      | accountName           | test Current Account    |
      | sortCode1             | 12                      |
      | sortCode2             | 34                      |
      | sortCode3             | 56                      |
      | accountNumber         | 0987654321              |
      | accountBalance        | 2001                    |
      | overdraftLimit        | 2002                    |
      | sourceOfSaving        | Gift                    |
      | regularMonthlySaving  | 200                     |

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
#    And user has dependants - positive way is now included in whole form filling step definition and it is being automatically handled if present
#
#    And Borrower fills in "Dependant form"
#      | date Of Birth | 01/01/2000 |
#
#    And Borrower fills in "Dependant form"
#      | date Of Birth | 01/01/2000 |

#    And user clicks "ADD DEPENDANT" - not mandatory to use but is available and it would work
#    And user fills in "Dependant form"
#      | date Of Birth | 01/01/2000 |

#    And Borrower clicks Dependants "Done"

#    Financial Commitments
#    When user clicks "Financial Commitments"
    And Borrower hasn't financial commitments

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
