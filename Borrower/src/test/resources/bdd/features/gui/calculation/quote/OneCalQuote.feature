
Feature: Cal Quote Verification

  Background:
    Given Borrower creates a quote

  Scenario Outline: Cal Quote
    And Borrower selects <BorrowerNumber> as number of borrowers
    And Borrower selects <MortgageType> as mortgage type
    And Borrower types <BorrowerAge> as age
    And Borrower types <PartnerAge> as partner's age
    And Borrower selects <BorrowerMaritalStatus> as marital status
    And Borrower types <BorrowerTotalDependants> as total of dependents
    And Borrower selects <BorrowerIncomeType> as income type
    And Borrower types <BorrowerIncomeAmount> as income amount
    And Borrower selects <PartnerIncomeType> as partner's income type
    And Borrower types <PartnerIncomeAmount> as partner's income amount
    And Borrower types <MonthlyCreditCommitments> as monthly credit commitments
    When Borrower clicks "GET MY QUOTE"
    And Borrower is<isEligible> eligible to borrow at this time
    Then Borrower could buy a home up to the value of <MaxLoanAmount> euros
    And Borrower should pay monthly <MonthlyPayment> euros
    And Borrower should get a minimum deposit value of <MinimumDeposit> euros

    Examples:
      | BorrowerNumber    | MortgageType        | BorrowerAge | PartnerAge | BorrowerMaritalStatus                | BorrowerTotalDependants | BorrowerIncomeType        | BorrowerIncomeAmount | PartnerIncomeType         | PartnerIncomeAmount | MonthlyCreditCommitments | isEligible | MaxLoanAmount                                     | MonthlyPayment | MinimumDeposit |
      | two borrowers     | first-time buyer(s) | 20          | 20         | separated                            | 1                       | an employee               | 150000               | an employee               | 150000              | 0                        |            | 1050000                                           | 4969           | 350000         |
