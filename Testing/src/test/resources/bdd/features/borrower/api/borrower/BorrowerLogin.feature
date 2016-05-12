
@login
Feature: Borrower Login

  Scenario: Official registration and Login page
    Given Borrower goes to Registration page
    When this registration data, Borrower processes the registration (format2)
      | firstName         | AutomationSBApi                             |
      | email             | test.automation+api@finfactory.com          |
      | phoneNumber       | +420778098091                               |
      | password          | Password1122+                               |
      | termsBusiness     | accepts                                     |
      | protectionPolicy  | accepts                                     |
    # EMAIL & SMS MDG
    Then Borrower activates his account
    And Borrower clicks "Quote" task