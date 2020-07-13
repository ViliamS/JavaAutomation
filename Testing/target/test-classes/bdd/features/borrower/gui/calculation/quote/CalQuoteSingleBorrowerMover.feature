Feature: Cal Quote - Single Borrower Mover

#  Background:
#    Given user creates a quote

#  Scenario Outline: Cal Quote
#    And user selects <BorrowerNumber> as number of borrowers
#    And user selects <MortgageType> as mortgage type
#    And user types <BorrowerAge> as age
#    And user types <PartnerAge> as partner's age
#    And user selects <BorrowerMaritalStatus> as marital status
#    And user types <BorrowerTotalDependants> as total of dependants
#    And user selects <BorrowerIncomeType> as income type
#    And user types <BorrowerIncomeAmount> as income amount
#    And user selects <PartnerIncomeType> as partner's income type
#    And user types <PartnerIncomeAmount> as partner's income amount
#    And user types <MonthlyCreditCommitments> as monthly credit commitments
#    When user clicks "GET MY QUOTE"
#    And user is<isEligible> eligible to borrow at this time
#    Then user could buy a home up to the value of <MaxLoanAmount> euros
#    And user should pay monthly <MonthlyPayment> euros
#    And user should get a minimum deposit value of <MinimumDeposit> euros

#    Examples:
#      | BorrowerNumber    | MortgageType        | BorrowerAge | PartnerAge | BorrowerMaritalStatus                | BorrowerTotalDependants | BorrowerIncomeType        | BorrowerIncomeAmount | PartnerIncomeType         | PartnerIncomeAmount | MonthlyCreditCommitments | isEligible | MaxLoanAmount                                     | MonthlyPayment | MinimumDeposit |
#      | a single borrower | mover(s)            | 20          |            | separated                            | 1                       | an employee               | 100000               |                           |                     | 0                        |            | 350000                                            | 1773           | 91875          |
#      | a single borrower | mover(s)            | 35          |            | separated                            | 2                       | a civil servant           | 65000                |                           |                     | 100                      |            | 204232                                            | 1035           | 53611          |
#      | a single borrower | mover(s)            | 45          |            | separated                            | 0                       | self employed             | 89000                |                           |                     | 200                      |            | 311500                                            | 1731           | 81769          |
#      | a single borrower | mover(s)            | 30          |            | separated                            | 3                       | not in paid work just now | 0                    |                           |                     | 0                        | n't        |                                                   |                |                |
#      | a single borrower | mover(s)            | 20          |            | married/civil partner(s)             | 0                       | an employee               | 100000               |                           |                     | 240                      |            | 350000                                            | 1773           | 91875          |
#      | a single borrower | mover(s)            | 35          |            | married/civil partner(s)             | 0                       | a civil servant           | 65000                |                           |                     | 230                      |            | 185643                                            | 941            | 48731          |
#      | a single borrower | mover(s)            | 45          |            | married/civil partner(s)             | 2                       | self employed             | 89000                |                           |                     | 1000                     |            | 137437                                            | 764            | 36077          |
#      | a single borrower | mover(s)            | 30          |            | married/civil partner(s)             | 1                       | not in paid work just now | 0                    |                           |                     | 0                        | n't        |                                                   |                |                |
#      | a single borrower | mover(s)            | 20          |            | divorced/dissolved civil partnership | 1                       | an employee               | 190000               |                           |                     | 0                        |            | 665000                                            | 3369           | 174563         |
#      | a single borrower | mover(s)            | 35          |            | divorced/dissolved civil partnership | 2                       | a civil servant           | 65000                |                           |                     | 100                      |            | 204232                                            | 1035           | 53611          |
#      | a single borrower | mover(s)            | 45          |            | divorced/dissolved civil partnership | 0                       | self employed             | 89000                |                           |                     | 200                      |            | 311500                                            | 1731           | 81769          |
#      | a single borrower | mover(s)            | 30          |            | divorced/dissolved civil partnership | 3                       | not in paid work just now | 0                    |                           |                     | 0                        | n't        |                                                   |                |                |
#      | a single borrower | mover(s)            | 20          |            | widowed                              | 0                       | an employee               | 190000               |                           |                     | 240                      |            | 665000                                            | 3369           | 174563         |
#      | a single borrower | mover(s)            | 35          |            | widowed                              | 0                       | a civil servant           | 65000                |                           |                     | 230                      |            | 227500                                            | 1153           | 59719          |
#      | a single borrower | mover(s)            | 45          |            | widowed                              | 2                       | self employed             | 89000                |                           |                     | 1000                     |            | 230002                                            | 1731           | 60375          |
#      | a single borrower | mover(s)            | 30          |            | widowed                              |                         | not in paid work just now | 0                    |                           |                     | 0                        | n't        |                                                   |                |                |