
Feature: Registration + Login + CalQuote

  Background:
    Given user goes to Registration page

  Scenario: Registration + Login + CalQuote

    Given this registration data, user processes the registration (format2)
      | firstName         | Tonda                               |
      | email             | anthony.mottot.test0001@abakus.com  |
      | phoneNumber       | 1234567890                          |
      | password          | Password1122+                       |
      | termsBusiness     | accepts                             |
      | protectionPolicy  | accepts                             |

    Then Borrower user logs in as his account is activated

    Then user processes "Get a Quote" (format2)
      | borrowerNumber           | a single borrower   |
      | mortgageType             | first-time buyer(s) |
      | borrowerAge              | 28                  |
      | borrowerMaritalStatus    | single              |
      | borrowerTotalDependents  | 0                   |
      | borrowerIncomeType       | an employee         |
      | borrowerIncomeAmount     | 125000              |
      | monthlyCreditCommitments | 1000                |
