@HP_Payday @:-] @:-P @:-]]
Feature: Payday Loan

  Background:
    Given Open Leveris Automatic Registration Page

        #################################
        #                               #
        #          Payday Loan          #
        #                               #
        #################################

#  Scenario: Payday Loan
#
#    Given Borrower processes the automatic registration
#      | applicantId | test.automation@finfactory.com |
#
#    Then Borrower clicks "Quote" task
#    And Borrower clicks on continue to get Payday Loan
#    And Borrower fills in Payday Loan form
#      | formType           | Payday Loan |
#      | NetMonthlyIncome   | 21,000.00   |
#      | MonthlyExpenses    | 1,000.00    |
#      | NumberOfDependants | 1           |
#      | AmountToBorrow     | 1,000.00    |
#    When Payday Loan Borrower clicks on Continue button
#    Then Borrower clicks on Apply Online

        #################################
        #        Personal Details       #
        #################################

#    And Borrower processes "Forms"
#    And Borrower fills in Personal Details
#      | formType            | Personal Details  |
#      | title               | Mr.               |
#      | firstName           | AutomationGUI     |
#      | middleName          | Amazing           |
#      | lastName            | Tester            |
#      | suffix              | the Greatest      |
#      | gender              | Male              |
#      | dateOfBirth         | 01/01/1977        |
#      | nationality         | French            |
#      | maritalStatus       | single            |
#    And Borrower saves his personal details data

        #################################
        #       Your Residencies        #
        #################################

#    And Borrower fills in Other/previous residency
#      | formType          | Other/previous residency   |
#      | addressLine1      | Hejtmanská                 |
#      | addressLine2      | Hlavní město Praha  |
#      | townCity          | Prague              |
#      | postcode/zip      | 198 00              |
#      | country           | Czech Republic      |
#      | startDate         | 11/01/2000          |
#      | endDate           | 26/03/2012          |
#
#    And Borrower fills in Current residency
#      | formType          | Current residency   |
#      | addressLine1      | Havířovská          |
#      | addressLine2      | Hlavní město Praha  |
#      | townCity          | Prague              |
#      | postcode/zip      | 199 00              |
#      | country           | Czech Republic      |
#      | startDate         | 27/03/2012          |
#      | residentialStatus | Owner               |
#    And Borrower clicks Residency "Done"

        #################################
        #      Employment & Income      #
        #################################

#    And Borrower fills in Employment and Income type Paye
#      | formType            | Paye        |
#      | occupation          | Artist      |
#      | employerName        | Hot Peppers Paye |
#      | employmentType      | Permanent   |
#      | startDate           | 05/11/2014  |
#      | isCurrentEmployment | yes         |
#      | netMonthlyIncome    | 124000      |
#
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
#      | startDate           | 05/11/2012         |
#      | endDate             | 06/12/2013         |
#      | isCurrentEmployment | no                 |
#      | netMonthlyIncome    | 124000             |
#
#    And Borrower fills in Employment and Income type Unemployed/Homemaker
#      | formType            | Unemployed/Homemaker |
#      | startDate           | 13/11/2011           |
#      | endDate             | 13/12/2012           |
#      | isCurrentEmployment | no                   |
#
#    And Borrower fills in Employment and Income type Other
#      | formType               | Other                      |
#      | additionalIncomeSource | testAdditionalIncomeSource |
#      | startDate              | 01/01/2010                 |
#      | endDate                | 02/02/2011                 |
#      | netMonthlyIncome       | 2000                       |
#      | isCurrentEmployment    | no                         |
#    And Borrower clicks "Done"

        #################################
        #         Your Accounts         #
        #################################

#    And Borrower fills in Current account
#      | formType          | Current account         |
#      | statementDate     | 01/01/2000              |
#      | accountProvider   | test account provider 1 |
#      | accountHolderName | AutomationAPI           |
#      | accountName       | test Current Account 1  |
#      | sortCode1         | 12                      |
#      | sortCode2         | 34                      |
#      | sortCode3         | 56                      |
#      | accountNumber     | 123456                  |
#      | accountBalance    | 2001                    |
#      | overdraftLimit    | 2002                    |
#
#    And Borrower fills in Current account
#      | formType          | Current account         |
#      | statementDate     | 01/01/2001              |
#      | accountProvider   | test account provider 2 |
#      | accountHolderName | AutomationAPI           |
#      | sortCode1         | 12                      |
#      | sortCode2         | 34                      |
#      | sortCode3         | 56                      |
#      | accountNumber     | 123455                  |
#      | accountBalance    | 2001                    |
#      | overdraftLimit    | 2002                    |
#
#    And Borrower fills in Savings account
#      | formType             | Savings account         |
#      | statementDate        | 01/01/2000              |
#      | accountProvider      | test account provider 3 |
#      | accountHolderName    | AutomationAPI           |
#      | sortCode1            | 12                      |
#      | sortCode2            | 34                      |
#      | sortCode3            | 56                      |
#      | accountNumber        | 0987654                 |
#      | accountBalance       | 2001                    |
#      | sourceOfSaving       | Gift                    |
#      | regularMonthlySaving | 200                     |
#
#    And Borrower fills in Savings account
#      | formType              | Savings account         |
#      | statementDate         | 01/01/2000              |
#      | accountProvider       | test account provider 4 |
#      | accountHolderName     | AutomationAPI 4         |
#      | sortCode1             | 12                      |
#      | sortCode2             | 34                      |
#      | sortCode3             | 56                      |
#      | accountNumber         | 9987654                 |
#      | accountBalance        | 2001                    |
#      | sourceOfSaving        | Gift                    |
#      | regularMonthlySaving  | 200                     |
#    And Borrower clicks Accounts "Done"

        #################################
        #        Your Dependants        #
        #################################

#    And Borrower has dependants
#    And Borrower fills in "Dependant form"
#      | dateOfBirth | 01/01/2000 |
#
#    And Borrower fills in "Dependant form"
#      | dateOfBirth | 01/01/2000 |
#
#    And Borrower fills in "Dependant form"
#      | dateOfBirth | 01/01/2000 |
#    And Borrower clicks Dependants "Done"

        #################################
        #     Financial Commitments     #
        #################################

#    When Borrower has financial commitments
#    Then Borrower fills in Personal Loan
#      | formType              | Personal Loan |
#      | outstandingAmount     | 1500          |
#      | financialInstitution  | HellsBank     |
#      | purposeOfTheLoan      | Debt repay    |
#      | finalRepaymentDate    | 01/03/2018    |
#      | paymentFrequency      | Monthly       |
#      | repaymentAmount       | 2500          |
#
#    Then Borrower fills in Credit Card
#      | formType              | Credit Card |
#      | repaymentAmount       | 2500        |
#      | cardProvider          | Friend      |
#      | cardType              | VISA        |
#      | cardLimit             | 50000       |
#      | cardBalance           | 45000       |
#
#    Then Borrower fills in Maintenance Payment
#      | formType                  | Maintenance Payment |
#      | monthlyMaintenancePayment | 1000                |
#
#    Then Borrower fills in Other
#      | formType        | Other     |
#      | repaymentAmount | 2500      |
#      | value           | 5000      |
#      | description     | text1232  |
#
#    Then Borrower fills in Car Loan
#      | formType              | Car Loan   |
#      | outstandingAmount     | 2500       |
#      | financialInstitution  | Hell Bank  |
#      | finalRepaymentDate    | 31/03/2018 |
#      | paymentFrequency      | Weekly     |
#      | repaymentAmount       | 15000      |
#
#    Then Borrower fills in Student Loan
#      | formType              | Student Loan |
#      | outstandingAmount     | 5000         |
#      | financialInstitution  | Bank of Debt |
#      | finalRepaymentDate    | 01/03/2020   |
#      | paymentFrequency      | Fortnightly  |
#      | repaymentAmount       | 50000        |
#
#    Then Borrower fills in Rent
#      | formType          | Rent    |
#      | paymentFrequency  | Yearly  |
#      | repaymentAmount   | 15000   |
#      | note              | ABC123  |
#
#    Then Borrower fills in Utilities
#      | formType          | Utilities |
#      | paymentFrequency  | Weekly    |
#      | repaymentAmount   | 2500      |
#      | note              | wsad8546  |
#
#    Then Borrower fills in Childcare
#      | formType          | Childcare |
#      | paymentFrequency  | Weekly    |
#      | repaymentAmount   | 250       |
#      | note              | wsad8546  |
#
#    Then Borrower fills in Mortgage
#      | formType              | Mortgage     |
#      | outstandingAmount     | 5000         |
#      | financialInstitution  | Bank of Debt |
#      | finalRepaymentDate    | 01/03/2020   |
#      | repaymentAmount       | 50000        |
#    And Borrower clicks financial Done

        #################################
        #        Document Upload        #
        #################################

#    And Borrower uploads all documents

        #################################
        #         Final Stage 1         #
        #################################

#    And Borrower clicks "Review and Submit"
#    And Borrower checks "Distance Marketing"
#    And Borrower checks "Statutory"
#    And Borrower checks "Declaration"
#    And Borrower checks "Fraud Credit check"
#    And finally, Borrower clicks "Submit Application"

          #######  ###    ##  ######
          ##       ####   ##  ##   ##
          ##       ## ##  ##  ##    ##
          #####    ##  ## ##  ##    ##
          ##       ##   ####  ##    ##
          ##       ##    ###  ##   ##
          #######  ##     ##  ######

        #################################
        #                               #
        #        Unsecured Loan         #
        #                               #
        #################################

  Scenario: Unsecured Loan

    Given Borrower processes the automatic registration
      | applicantId | test.automation.unsecured.loan@finfactory.com |

    Then Borrower clicks "Quote" task
    And Borrower clicks on continue to get Unsecured Loan

    And Borrower fills in Unsecured Loan form
      | formType           | Unsecured Loan     |
      | LoanPurpose        | Personal purposes  |
      | NetMonthlyIncome   | 210,000.00         |
      | MonthlyExpenses    | 2,000.00           |
      | NumberOfDependants | 0                  |
      | AmountToBorrow     | 15,000.00          |
    When Unsecured Loan Borrower clicks on Continue button
    Then Borrower clicks on Apply Online

        #################################
        #        Personal Details       #
        #################################

    And Borrower processes "Forms"
    And Borrower fills in Personal Details
      | formType            | Personal Details  |
      | title               | Mr.               |
      | firstName           | AutomationGUI     |
      | middleName          | Amazing           |
      | lastName            | Tester            |
      | suffix              | 1st               |
      | gender              | Male              |
      | dateOfBirth         | 01/01/1977        |
      | nationality         | French            |
      | maritalStatus       | single            |
    And Borrower saves his personal details data

        #################################
        #       Your Residencies        #
        #################################

    And Borrower fills in Other/previous residency
      | formType   | Other/previous residency   |
      | addressLine1 |      Hejtmanská          |
      | addressLine2      | Hlavní město Praha  |
      | townCity          | Prague              |
      | postcode/zip      | 198 00              |
      | country           | Czech Republic      |
      | startDate         | 11/01/2000          |
      | endDate           | 26/03/2012          |

    And Borrower fills in Current residency
      | formType          | Current residency   |
      | addressLine1      | Havířovská          |
      | addressLine2      | Hlavní město Praha  |
      | townCity          | Prague              |
      | postcode/zip      | 199 00              |
      | country           | Czech Republic      |
      | startDate         | 27/03/2012          |
      | residentialStatus | Owner               |
    And Borrower clicks Residency "Done"

        #################################
        #      Employment & Income      #
        #################################

    And Borrower fills in Employment and Income type Paye
      | formType            | Paye        |
      | occupation          | Artist      |
      | employerName        | Hot Peppers Paye |
      | employmentType      | Permanent   |
      | startDate           | 05/11/2014  |
      | isCurrentEmployment | yes         |
      | netMonthlyIncome    | 124000      |

    And Borrower fills in Employment and Income type Self Employed
      | formType            | Self Employed      |
      | occupation          | Artist             |
      | businessName        | testBusinessName   |
      | addressLine1        | 18 Woodquay        |
      | addressLine2        | Galway             |
      | townCity            | Galway             |
      | country             | Ireland            |
      | countyState         | Galway             |
      | businessNature      | testNatureBusiness |
      | startDate           | 05/11/2012         |
      | endDate             | 06/12/2013         |
      | isCurrentEmployment | no                 |
      | netMonthlyIncome    | 124000             |

    And Borrower fills in Employment and Income type Unemployed/Homemaker
      | formType            | Unemployed/Homemaker |
      | startDate           | 13/11/2011           |
      | endDate             | 13/12/2012           |
      | isCurrentEmployment | no                   |

    And Borrower fills in Employment and Income type Other
      | formType               | Other                      |
      | additionalIncomeSource | testAdditionalIncomeSource |
      | startDate              | 01/01/2010                 |
      | endDate                | 02/02/2011                 |
      | netMonthlyIncome       | 2000                       |
      | isCurrentEmployment    | no                         |
    And Borrower clicks "Done"

        #################################
        #         Your Accounts         #
        #################################

    And Borrower fills in Current account
      | formType          | Current account         |
      | accountName       | CurrentAccountName      |
      | statementDate     | 01/01/2000              |
      | accountProvider   | test account provider 1 |
      | accountHolderName | AutomationAPI           |
      | accountName       | test Current Account 1  |
      | sortCode1         | 12                      |
      | sortCode2         | 34                      |
      | sortCode3         | 56                      |
      | accountNumber     | 123456                  |
      | accountBalance    | 2001                    |
      | overdraftLimit    | 2002                    |

    And Borrower fills in Current account
      | formType          | Current account         |
      | accountName       | CurrentAccountName      |
      | statementDate     | 01/01/2001              |
      | accountProvider   | test account provider 2 |
      | accountHolderName | AutomationAPI           |
      | sortCode1         | 12                      |
      | sortCode2         | 34                      |
      | sortCode3         | 56                      |
      | accountNumber     | 123455                  |
      | accountBalance    | 2001                    |
      | overdraftLimit    | 2002                    |

    And Borrower fills in Savings account
      | formType             | Savings account         |
      | accountName          | Savings Account Name    |
      | statementDate        | 01/01/2000              |
      | accountProvider      | test account provider 3 |
      | accountHolderName    | AutomationAPI           |
      | sortCode1            | 12                      |
      | sortCode2            | 34                      |
      | sortCode3            | 56                      |
      | accountNumber        | 0987654                 |
      | accountBalance       | 2001                    |
      | sourceOfSaving       | Gift                    |
      | regularMonthlySaving | 200                     |

    And Borrower fills in Savings account
      | formType              | Savings account         |
      | accountName           | Savings Account Name    |
      | statementDate         | 01/01/2000              |
      | accountProvider       | test account provider 4 |
      | accountHolderName     | AutomationAPI 4         |
      | sortCode1             | 12                      |
      | sortCode2             | 34                      |
      | sortCode3             | 56                      |
      | accountNumber         | 9987654                 |
      | accountBalance        | 2001                    |
      | sourceOfSaving        | Gift                    |
      | regularMonthlySaving  | 200                     |
    And Borrower clicks Accounts "Done"

        #################################
        #        Your Dependants        #
        #################################

    And Borrower has dependants
    And Borrower fills in "Dependant form"
      | dateOfBirth | 01/01/2000 |

    And Borrower fills in "Dependant form"
      | dateOfBirth | 01/01/2000 |

    And Borrower fills in "Dependant form"
      | dateOfBirth | 01/01/2000 |
    And Borrower clicks Dependants "Done"

        #################################
        #     Financial Commitments     #
        #################################

    When Borrower has financial commitments
    Then Borrower fills in Personal Loan
      | formType              | Personal Loan |
      | outstandingAmount     | 1500          |
      | financialInstitution  | HellsBank     |
      | purposeOfTheLoan      | Debt repay    |
      | finalRepaymentDate    | 01/03/2018    |
      | paymentFrequency      | Monthly       |
      | repaymentAmount       | 2500          |

    Then Borrower fills in Credit Card
      | formType              | Credit Card |
      | repaymentAmount       | 2500        |
      | cardProvider          | Friend      |
      | cardType              | VISA        |
      | cardLimit             | 50000       |
      | cardBalance           | 45000       |

    Then Borrower fills in Maintenance Payment
      | formType                  | Maintenance Payment |
      | monthlyMaintenancePayment | 1000                |

    Then Borrower fills in Other
      | formType        | Other     |
      | repaymentAmount | 2500      |
      | value           | 5000      |
      | description     | text1232  |

    Then Borrower fills in Car Loan
      | formType              | Car Loan   |
      | outstandingAmount     | 2500       |
      | financialInstitution  | Hell Bank  |
      | finalRepaymentDate    | 31/03/2018 |
      | paymentFrequency      | Weekly     |
      | repaymentAmount       | 15000      |

    Then Borrower fills in Student Loan
      | formType              | Student Loan |
      | outstandingAmount     | 5000         |
      | financialInstitution  | Bank of Debt |
      | finalRepaymentDate    | 01/03/2020   |
      | paymentFrequency      | Fortnightly  |
      | repaymentAmount       | 50000        |

    Then Borrower fills in Rent
      | formType          | Rent    |
      | paymentFrequency  | Yearly  |
      | repaymentAmount   | 15000   |
      | note              | ABC123  |

    Then Borrower fills in Utilities
      | formType          | Utilities |
      | paymentFrequency  | Weekly    |
      | repaymentAmount   | 2500      |
      | note              | wsad8546  |

    Then Borrower fills in Childcare
      | formType          | Childcare |
      | paymentFrequency  | Weekly    |
      | repaymentAmount   | 250       |
      | note              | wsad8546  |

    Then Borrower fills in Mortgage
      | formType              | Mortgage     |
      | outstandingAmount     | 5000         |
      | financialInstitution  | Bank of Debt |
      | finalRepaymentDate    | 01/03/2020   |
      | repaymentAmount       | 50000        |
    And Borrower clicks financial Done

        #################################
        #        Document Upload        #
        #################################

    And Borrower uploads all documents

        #################################
        #         Final Stage 1         #
        #################################

    And Borrower clicks "Review and Submit"
    And Borrower checks "Distance Marketing"
    And Borrower checks "Statutory"
    And Borrower checks "Declaration"
    And Borrower checks "Fraud Credit check"
    And finally, Borrower clicks "Submit Application"

          #######  ###    ##  ######
          ##       ####   ##  ##   ##
          ##       ## ##  ##  ##    ##
          #####    ##  ## ##  ##    ##
          ##       ##   ####  ##    ##
          ##       ##    ###  ##   ##
          #######  ##     ##  ######