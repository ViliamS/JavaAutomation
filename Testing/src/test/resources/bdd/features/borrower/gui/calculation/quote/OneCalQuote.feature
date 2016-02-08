
Feature: Cal Quote Verification

  Background:
    Given user creates a quote

  Scenario Outline: Cal Quote
    And user selects <BorrowerNumber> as number of borrowers
    And user selects <MortgageType> as mortgage type
    And user types <BorrowerAge> as age
    And user types <PartnerAge> as partner's age
    And user selects <BorrowerMaritalStatus> as marital status
    And user types <BorrowerTotalDependents> as total of dependents
    And user selects <BorrowerIncomeType> as income type
    And user types <BorrowerIncomeAmount> as income amount
    And user selects <PartnerIncomeType> as partner's income type
    And user types <PartnerIncomeAmount> as partner's income amount
    And user types <MonthlyCreditCommitments> as monthly credit commitments
    When user clicks "GET MY QUOTE"
    And user is<isEligible> eligible to borrow at this time
    Then user could buy a home up to the value of <MaxLoanAmount> euros
    And user should pay monthly <MonthlyPayment> euros
    And user should get a minimum deposit value of <MinimumDeposit> euros

    Examples:
      | BorrowerNumber    | MortgageType        | BorrowerAge | PartnerAge | BorrowerMaritalStatus                | BorrowerTotalDependents | BorrowerIncomeType        | BorrowerIncomeAmount | PartnerIncomeType         | PartnerIncomeAmount | MonthlyCreditCommitments | isEligible | MaxLoanAmount                                     | MonthlyPayment | MinimumDeposit |
      | two borrowers     | first-time buyer(s) | 20          | 20         | separated                            | 1                       | an employee               | 150000               | an employee               | 150000              | 0                        |            | 1050000                                           | 4969           | 350000         |
