
Feature: Cal Quote Verification

  Background:
    Given Borrower creates a quote

#  Scenario Outline: Cal Quote
#    And Borrower selects <BorrowerNumber> as number of borrowers
#    And Borrower selects <MortgageType> as mortgage type
#    And Borrower types <BorrowerAge> as age
#    And Borrower types <PartnerAge> as partner's age
#    And Borrower selects <BorrowerMaritalStatus> as marital status
#    And Borrower types <BorrowerTotalDependants> as total of dependants
#    And Borrower selects <BorrowerIncomeType> as income type
#    And Borrower types <BorrowerIncomeAmount> as income amount
#    And Borrower selects <PartnerIncomeType> as partner's income type
#    And Borrower types <PartnerIncomeAmount> as partner's income amount
#    And Borrower types <MonthlyCreditCommitments> as monthly credit commitments
#    When Borrower clicks "GET MY QUOTE"
#    And Borrower is<isEligible> eligible to borrow at this time
##    Then Borrower could buy a home up to the value of <MaxLoanAmount> euros, should pay monthly <MonthlyPayment> euros and should get a minimum deposit value of <MinimumDeposit> euros
#    Then Borrower could buy a home up to the value of <MaxLoanAmount> euros, should pay monthly <MonthlyPayment> euros and should get a minimum deposit value of <MinimumDeposit> euros, need to pay Government stamp duty of <StampDuty> and a maximum price of <MaxHousePrice>, for scenario <ScenarioID>
##    And Borrower could buy a home up to the value of <MaxLoanAmount> euros
##    And Borrower should pay monthly <MonthlyPayment> euros
##    And Borrower should get a minimum deposit value of <MinimumDeposit> euros

#    Examples:
#      | ScenarioID | BorrowerNumber    | MortgageType        | BorrowerAge | PartnerAge | BorrowerMaritalStatus                | BorrowerTotalDependants | BorrowerIncomeType        | BorrowerIncomeAmount | PartnerIncomeType         | PartnerIncomeAmount | MonthlyCreditCommitments | isEligible | MaxLoanAmount | MonthlyPayment | MinimumDeposit | StampDuty | MaxHousePrice |
#      |UAT - TC 81|a single borrower|first-time buyer(s)|20|-|separated|1|an employee|100000|-|-|0| |350000|1656.37|64100|-|-|
#      |UAT - TC 82|a single borrower|first-time buyer(s)|35|-|separated|2|a civil servant|65000|-|-|100| |213669|1011|28313|-|-|
#      |UAT - TC 83|a single borrower|first-time buyer(s)|45|-|separated|0|self employed|89000|-|-|200| |230342|3228|32690|-|-|
#      |UAT - TC 84|a single borrower|first-time buyer(s)|30|-|separated|3|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
#      |UAT - TC 85|a single borrower|first-time buyer(s)|20|-|married/civil partner(s)|0|an employee|100000|-|-|240| |350000|1656|64100|-|-|
#      |UAT - TC 86|a single borrower|first-time buyer(s)|35|-|married/civil partner(s)|0|a civil servant|65000|-|-|230| |194220|919|23738|-|-|
#      |UAT - TC 87|a single borrower|first-time buyer(s)|45|-|married/civil partner(s)|2|self employed|89000|-|-|1000| |137437|764|16798|-|-|
#      |UAT - TC 88|a single borrower|first-time buyer(s)|30|-|married/civil partner(s)|1|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
#      |UAT - TC 89|a single borrower|first-time buyer(s)|20|-|divorced/dissolved civil partnership|1|an employee|100000|-|-|0| |350000|1656|64100|-|-|
#      |UAT - TC 90|a single borrower|first-time buyer(s)|35|-|divorced/dissolved civil partnership|2|a civil servant|65000|-|-|100| |213669|1011|28313|-|-|
#      |UAT - TC 91|a single borrower|first-time buyer(s)|45|-|divorced/dissolved civil partnership|0|self employed|89000|-|-|200| |311500|1731|53994|-|-|
#      |UAT - TC 92|a single borrower|first-time buyer(s)|30|-|divorced/dissolved civil partnership|3|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
#      |UAT - TC 93|a single borrower|first-time buyer(s)|20|-|widowed|0|an employee|100000|-|-|240| |350000|1656|64100|-|-|
#      |UAT - TC 94|a single borrower|first-time buyer(s)|35|-|widowed|0|a civil servant|65000|-|-|230| |227500|1077|31944|-|-|
#      |UAT - TC 95|a single borrower|first-time buyer(s)|45|-|widowed|2|self employed|89000|-|-|1000| |230002|1731|32600|-|-|
#      |UAT - TC 96|a single borrower|first-time buyer(s)|30|-|widowed|1|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
#      |UAT - TC 97|a single borrower|mover(s)|20|-|separated|1|an employee|100000|-|-|0| |350000|1773.37|91875|-|-|
#      |UAT - TC 98|a single borrower|mover(s)|35|-|separated|2|a civil servant|65000|-|-|100| |204232|1035|53611|-|-|
#      |UAT - TC 99|a single borrower|mover(s)|45|-|separated|0|self employed|89000|-|-|200| |311500|1731|81769|-|-|
#      |UAT - TC 100|a single borrower|mover(s)|30|-|separated|3|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
#      |UAT - TC 101|a single borrower|mover(s)|20|-|married/civil partner(s)|0|an employee|100000|-|-|240| |350000|1773|91875|-|-|
#      |UAT - TC 102|a single borrower|mover(s)|35|-|married/civil partner(s)|0|a civil servant|65000|-|-|230| |185643|941|48731|-|-|
#      |UAT - TC 103|a single borrower|mover(s)|45|-|married/civil partner(s)|2|self employed|89000|-|-|1000| |137437|764|36077|-|-|
#      |UAT - TC 104|a single borrower|mover(s)|30|-|married/civil partner(s)|1|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
#      |UAT - TC 105|a single borrower|mover(s)|20|-|divorced/dissolved civil partnership|1|an employee|190000|-|-|0| |665000|3369|174563|-|-|
#      |UAT - TC 106|a single borrower|mover(s)|35|-|divorced/dissolved civil partnership|2|a civil servant|65000|-|-|100| |204232|1035|53611|-|-|
#      |UAT - TC 107|a single borrower|mover(s)|45|-|divorced/dissolved civil partnership|0|self employed|89000|-|-|200| |311500|1731|81769|-|-|
#      |UAT - TC 108|a single borrower|mover(s)|30|-|divorced/dissolved civil partnership|3|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
#      |UAT - TC 109|a single borrower|mover(s)|20|-|widowed|0|an employee|190000|-|-|240| |665000|3369|174563|-|-|
#      |UAT - TC 110|a single borrower|mover(s)|35|-|widowed|0|a civil servant|65000|-|-|230| |227500|1153|59719|-|-|
#      |UAT - TC 111|a single borrower|mover(s)|45|-|widowed|2|self employed|89000|-|-|1000| |230002|1731|60375|-|-|
#      |UAT - TC 112|a single borrower|mover(s)|30|-|widowed|1|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|