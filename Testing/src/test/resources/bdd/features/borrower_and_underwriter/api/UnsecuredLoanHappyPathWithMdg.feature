@HP_Payday @:-] @:-P @:-]]
Feature: Unsecured Loan

  Background:
    Given Borrower goes to Registration page

        #################################
        #                               #
        #          Unsecured Loan       #
        #                               #
        #################################

  Scenario: Unsecured Loan

    Given this registration data, Borrower processes the registration (format2)
      | firstName         | AutomationSBApi                             |
      | email             | test.automation+api@finfactory.com          |
      | phoneNumber       | +420778098091                               |
      | password          | Password1122+                               |
      | termsBusiness     | accepts                                     |
      | protectionPolicy  | accepts                                     |

        #################################
        #                               #
        #       EMAIL &  SMS MDG        #
        #                               #
        #################################

    Then Borrower activates his account

    Then Borrower clicks "Quote" task
    And Borrower clicks on continue to get Unsecured Loan
    And Borrower fills in Unsecured Loan form
      | formType           | Unsecured Loan Loan |
      | loanPurpose        | Personal purposes   |
      | NetMonthlyIncome   | 21,000.00   |
      | MonthlyExpenses    | 1,000.00    |
      | NumberOfDependants | 0           |
      | AmountToBorrow     | 1,000.00    |
    When Unsecured Loan Borrower clicks on Continue button
    Then Borrower clicks on Apply Online

    And Borrower processes "Forms"

        #################################
        #        Personal Details       #
        #################################

    And Borrower fills in Personal Details
      | formType            | Personal Details  |
      | title               | Mr.               |
      | firstName           | AutomationApi     |
      | middleName          | Amazing           |
      | lastName            | Tester            |
      | suffix              | Greatest          |
      | gender              | Male              |
      | dateOfBirth         | 01/01/1977        |
      | nationality         | French            |
      | maritalStatus       | separated         |
    And Borrower saves his personal details data

        #################################
        #       Your Residencies        #
        #################################

    And Borrower fills in Current residency
      | formType          | Current residency   |
      | addressLine1      | Havirovska          |
      | addressLine2      | Hlavni mesto Praha  |
      | townCity          | Prague              |
      | postcode/zip      | 199 00              |
      | country           | Czech Republic      |
      | startDate         | 27/03/2012          |
      | residentialStatus | Tenant              |
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
    And Borrower clicks "Done"

        #################################
        #         Your Accounts         #
        #################################

    And Borrower fills in Current account
      | formType          | Current account         |
      | statementDate     | 01/01/2000              |
      | accountProvider   | test account provider 1 |
      | accountHolderName | AutomationAPI           |
      | accountName       | test Current Account 1  |
      | sortCode1         | 08                      |
      | sortCode2         | 99                      |
      | sortCode3         | 99                      |
      | accountNumber     | 66374958                |
      | accountBalance    | 50000                   |
      | overdraftLimit    | 1000                    |
    And Borrower clicks Accounts "Done"

        #################################
        #        Your Dependants        #
        #################################

    And Borrower hasn't dependants

        #################################
        #     Financial Commitments     #
        #################################

    When Borrower hasn't financial commitments

        #################################
        #        Document Upload        #
        #################################

    And Borrower uploads all documents

        ##################################
        #     Final Borrower Stage 1     #
        ##################################

    And Borrower clicks "Review and Submit"
    And finally, Borrower clicks "Submit Application"
      | distanceMarketing | on |
      | statutory         | on |
      | declaration       | on |
      | fraudCreditCheck  | on |

        ##################################
        #     Underwriter Stage 1        #
        ##################################

    When Operator Underwriter logs in via SSO Underwriter
    Then Operator Underwriter looks for these information
      | assigned | all |
      | case     | Unsecured Loan |
    And Operator Underwriter opens the application of the customer AUTOMATION
    And Operator Underwriter validates all documents
    And Operator Underwriter sets Score Card
      | FICO | 800 |
      | AML  | OK  |
      | Fraud | OK |
      | repeat customer | 10 |
    And Operator Underwriter validates KYC party
      | partyStatus | GREEN |
    And Operator Underwriter validates Workflow Stage 1
    And Operator Underwriter saves the offer
    And Operator Underwriter signs the offer
    And Operator Underwriter refreshes Workflow panel

        ##################################
        #     Underwriter Stage 2        #
        ##################################

    And Operator Underwriter validates Workflow Stage 2
    And Operator Underwriter refreshes Workflow panel

        ##################################
        #     Borrower Stage 2           #
        ##################################

    And Borrower refreshes the page
    And Borrower closes his Unsecured approved loan

    And Borrower starts "Tweak your loan details"
    And Borrower submits "Tweak your loan details"
    And Borrower starts "Payment method"
    And Borrower submits "Payment method"
      | preferredDay | 3 |
    And Borrower starts "Target account setup"
    And Borrower submits "Target account setup"
      | sortCode1 | 10 |
      | sortCode2 | 79 |
      | sortCode3 | 99 |
      | accountNumber | 8883741 |
    And Borrower starts "Digitally sign the loan offer"
    And Borrower agrees the loan agreement
    And Borrower signs the loan offer document
    And Borrower goes for money

        ##################################
        #     Underwriter Final Stage 2  #
        ##################################

#    And Operator Underwriter refreshes Workflow panel
#    And Operator Underwriter issues funds
#    And Operator Underwriter refreshes Workflow panel

        ##################################
        #     Borrower Loan Overview     #
        ##################################

#    And Borrower refreshes the page

        #######  ###    ##  ######
        ##       ####   ##  ##   ##
        ##       ## ##  ##  ##    ##
        #####    ##  ## ##  ##    ##
        ##       ##   ####  ##    ##
        ##       ##    ###  ##   ##
        #######  ##     ##  ######
