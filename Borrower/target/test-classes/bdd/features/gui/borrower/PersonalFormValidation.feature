
@PersonalFormValidation
Feature: Personal Form Validation

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
    When Borrower fills in Personal Details
      | formType            | Personal Details  |
    And Borrower saves his personal details data
    Then Borrower sees these errors messages
      | Last name     | Field is required. |
      | Gender        | Field is required. |
      | Date of birth | Field is required. |