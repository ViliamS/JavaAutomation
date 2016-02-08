
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
#    Then user could buy a home up to the value of <MaxLoanAmount> euros, should pay monthly <MonthlyPayment> euros and should get a minimum deposit value of <MinimumDeposit> euros
    Then user could buy a home up to the value of <MaxLoanAmount> euros, should pay monthly <MonthlyPayment> euros and should get a minimum deposit value of <MinimumDeposit> euros, need to pay Government stamp duty of <StampDuty> and a maximum price of <MaxHousePrice>, for scenario <ScenarioID>
#    And user could buy a home up to the value of <MaxLoanAmount> euros
#    And user should pay monthly <MonthlyPayment> euros
#    And user should get a minimum deposit value of <MinimumDeposit> euros

    Examples:
      | ScenarioID | BorrowerNumber    | MortgageType        | BorrowerAge | PartnerAge | BorrowerMaritalStatus                | BorrowerTotalDependents | BorrowerIncomeType        | BorrowerIncomeAmount | PartnerIncomeType         | PartnerIncomeAmount | MonthlyCreditCommitments | isEligible | MaxLoanAmount | MonthlyPayment | MinimumDeposit | StampDuty | MaxHousePrice |
      |UAT - TC 1|two borrowers|first-time buyer(s)|20|20|separated|1|an employee|150000|an employee|150000|0| |1050000.00|4969.11|350000.00|-|-|
      |UAT - TC 2|two borrowers|first-time buyer(s)|20|20|separated|2|an employee|100000|a civil servant|100000|100| |700000.00|3312.74|147500.00|-|-|
      |UAT - TC 3|two borrowers|first-time buyer(s)|20|20|separated|0|an employee|85000|self employed|75000|200| |560000.00|2650.19|112500.00|-|-|
      |UAT - TC 4|two borrowers|first-time buyer(s)|20|20|separated|3|an employee|65000|not in paid work just now|0|0| |118148.64|559.14|13127.63|-|-|
      |UAT - TC 5|two borrowers|first-time buyer(s)|20|20|separated|0|a civil servant|2000000|an employee|250000|240| |7875000.00|37268.97|2625000.00|-|-|
      |UAT - TC 6|two borrowers|first-time buyer(s)|20|20|separated|0|self employed|100000|an employee|100000|230| |700000.00|3312.80|155975.00|-|-|
      |UAT - TC 7|two borrowers|first-time buyer(s)|20|20|separated|2|not in paid work just now|0|an employee|45000|100|n't|-|-|-|-|-|
      |UAT - TC 8|two borrowers|first-time buyer(s)|20|20|separated|2|not in paid work just now|0|an employee|45000|1000|n't|-|-|-|-|-|
      |UAT - TC 9|two borrowers|first-time buyer(s)|25|25|married/civil partner(s)|1|an employee|150000|an employee|150000|0| |1050000.00|4969.20|350000.00|18000.00|368000.00|
      |UAT - TC 10|two borrowers|first-time buyer(s)|25|25|married/civil partner(s)|2|an employee|100000|a civil servant|100000|100| |700000.00|3312.80|147500.00|8475.00|155975.00|
      |UAT - TC 11|two borrowers|first-time buyer(s)|25|25|married/civil partner(s)|0|an employee|85000|self employed|75000|200| |560000.00|2650.24|112500.00|6725.00|119225.00|
      |UAT - TC 12|two borrowers|first-time buyer(s)|25|25|married/civil partner(s)|3|an employee|65000|not in paid work just now|0|0| |165733.04|784.34|18414.78|1841.48|20256.26|
      |UAT - TC 13|two borrowers|first-time buyer(s)|25|25|married/civil partner(s)|0|a civil servant|2000000|an employee|250000|240| |7875000.00|37268.97|2625000.00|200000.00|2825000.00|
      |UAT - TC 14|two borrowers|first-time buyer(s)|25|25|married/civil partner(s)|0|self employed|100000|an employee|100000|230| |700000.00|3312.80|147500.00|8475.00|155975.00|
      |UAT - TC 15|two borrowers|first-time buyer(s)|25|25|married/civil partner(s)|2|not in paid work just now|0|an employee|45000|100| |88490.08|418.79|9832.23|983.22|10815.45|
      |UAT - TC 16|two borrowers|first-time buyer(s)|25|25|married/civil partner(s)|1|not in paid work just now|0|not in paid work just now|0|0|n't|-|-|-|-|-|
      |UAT - TC 17|two borrowers|first-time buyer(s)|30|30|divorced/dissolved civil partnership|1|an employee|150000|an employee|150000|0| |1050000.00|4969.20|350000.00|18000.00|368000.00|
      |UAT - TC 18|two borrowers|first-time buyer(s)|30|30|divorced/dissolved civil partnership|2|an employee|100000|a civil servant|100000|100| |700000.00|3312.80|147500.00|8475.00|155975.00|
      |UAT - TC 19|two borrowers|first-time buyer(s)|30|30|divorced/dissolved civil partnership|0|an employee|85000|self employed|75000|200| |560000.00|2650.24|112500.00|6725.00|119225.00|
      |UAT - TC 20|two borrowers|first-time buyer(s)|30|30|divorced/dissolved civil partnership|3|an employee|65000|not in paid work just now|0|0| |118145.86|559.13|13127.32|1312.73|14440.05|
      |UAT - TC 21|two borrowers|first-time buyer(s)|30|30|divorced/dissolved civil partnership|0|a civil servant|2000000|an employee|250000|240| |7875000.00|37268.97|2625000.00|200000.00|2825000.00|
      |UAT - TC 22|two borrowers|first-time buyer(s)|30|30|divorced/dissolved civil partnership|0|self employed|100000|an employee|100000|230| |700000.00|3312.80|147500.00|8475.00|155975.00|
      |UAT - TC 23|two borrowers|first-time buyer(s)|30|30|divorced/dissolved civil partnership|2|not in paid work just now|0|an employee|45000|100|n't|-|-|-|-|-|
      |UAT - TC 24|two borrowers|first-time buyer(s)|30|30|divorced/dissolved civil partnership|1|not in paid work just now|0|not in paid work just now|0|0|n't|-|-|-|-|-|
      |UAT - TC 25|two borrowers|first-time buyer(s)|35|35|widowed|1|an employee|150000|an employee|150000|0| |1050000.00|4969.20|350000.00|18000.00|368000.00|
      |UAT - TC 26|two borrowers|first-time buyer(s)|35|35|widowed|2|an employee|100000|a civil servant|100000|100| |700000.00|3312.80|147500.00|8475.00|155975.00|
      |UAT - TC 27|two borrowers|first-time buyer(s)|35|35|widowed|0|an employee|85000|self employed|75000|200| |560000.00|2650.24|112500.00|119225.00|231725.00|
      |UAT - TC 28|two borrowers|first-time buyer(s)|35|35|widowed|3|an employee|65000|not in paid work just now|0|0| |140904.95|666.84|15656.11|1565.61|17221.72|
      |UAT - TC 29|two borrowers|first-time buyer(s)|35|35|widowed|0|a civil servant|2000000|an employee|250000|240| |7875000.00|37268.97|2625000.00|200000.00|2825000.00|
      |UAT - TC 30|two borrowers|first-time buyer(s)|35|35|widowed|0|self employed|100000|an employee|100000|1000| |700000.00|3312.80|147500.00|8475.00|155975.00|
      |UAT - TC 31|two borrowers|first-time buyer(s)|35|35|widowed|2|not in paid work just now|0|an employee|45000|100| |63661.99|301.28|7073.55|707.36|7780.91|
      |UAT - TC 32|two borrowers|first-time buyer(s)|35|35|widowed|1|not in paid work just now|0|not in paid work just now|0|0|n't|-|-|-|-|-|
      |UAT - TC 33|two borrowers|first-time buyer(s)|35|35|married/civil partner(s)|1|an employee|150000|an employee|150000|1000| |1050000.00|4969.20|350000.00|18000.00|368000.00|
      |UAT - TC 34|two borrowers|first-time buyer(s)|35|45|married/civil partner(s)|2|an employee|100000|a civil servant|100000|100| |700000.00|3890.83|147500.00|8475.00|155975.00|
      |UAT - TC 35|two borrowers|first-time buyer(s)|35|55|married/civil partner(s)|0|an employee|85000|self employed|75000|1000| |481969.67|3687.04|92992.42|5749.62|98742.04|
      |UAT - TC 36|two borrowers|first-time buyer(s)|35|65|married/civil partner(s)|3|an employee|65000|not in paid work just now|0|0| |51174.27|954.04|5686.03|568.60|6254.63|
      |UAT - TC 37|two borrowers|first-time buyer(s)|35|35|married/civil partner(s)|0|a civil servant|2000000|an employee|250000|10000| |7875000.00|37268.97|2625000.00|200000.00|2825000.00|
      |UAT - TC 38|two borrowers|first-time buyer(s)|35|35|married/civil partner(s)|0|self employed|100000|an employee|100000|2000| |700000.00|3312.80|147500.00|155975.00|303475.00|
      |UAT - TC 39|two borrowers|first-time buyer(s)|35|45|married/civil partner(s)|2|not in paid work just now|0|an employee|45000|100| |79178.17|440.10|8797.57|879.76|9677.33|
      |UAT - TC 40|two borrowers|first-time buyer(s)|35|35|married/civil partner(s)|1|not in paid work just now|0|not in paid work just now|0|0|n't|-|-|-|-|-|
      |UAT - TC 41|two borrowers|mover(s)|20|20|separated|1|an employee|150000|an employee|150000|0| |1050000|5320.11|368000|-|-|
      |UAT - TC 42|two borrowers|mover(s)|20|20|separated|2|an employee|100000|a civil servant|100000|100| |700000|3547|183750|-|-|
      |UAT - TC 43|two borrowers|mover(s)|20|20|separated|0|an employee|85000|self employed|75000|200| |56000|2837|147000|-|-|
      |UAT - TC 44|two borrowers|mover(s)|20|20|separated|3|an employee|65000|not in paid work just now|0|0| |11292825|1153|29644|-|-|
      |UAT - TC 45|two borrowers|mover(s)|20|20|separated|0|a civil servant|2000000|an employee|250000|240| |7875000|39901|2825000|-|-|
      |UAT - TC 46|two borrowers|mover(s)|20|20|separated|0|self employed|100000|an employee|100000|230| |700000|3547|183750|-|-|
      |UAT - TC 47|two borrowers|mover(s)|20|20|separated|2|not in paid work just now|0|an employee|45000|1000| |103293|798|27114|-|-|
      |UAT - TC 48|two borrowers|mover(s)|20|20|separated|1|not in paid work just now|0|not in paid work just now|0|0|n't|-|-|-|-|-|
      |UAT - TC 49|two borrowers|mover(s)|25|25|married/civil partner(s)|1|an employee|150000|an employee|150000|0| |1050000|5320|368000|-|-|
      |UAT - TC 50|two borrowers|mover(s)|25|25|married/civil partner(s)|2|an employee|100000|a civil servant|100000|100| |700000|3547|183750|-|-|
      |UAT - TC 51|two borrowers|mover(s)|25|25|married/civil partner(s)|0|an employee|85000|self employed|75000|200| |560000|2837|147000|-|-|
      |UAT - TC 52|two borrowers|mover(s)|25|25|married/civil partner(s)|3|an employee|65000|not in paid work just now|0|0| |158414|1153|41584|-|-|
      |UAT - TC 53|two borrowers|mover(s)|25|25|married/civil partner(s)|0|a civil servant|2000000|an employee|250000|240| |7875000|39901|2825000|-|-|
      |UAT - TC 54|two borrowers|mover(s)|25|25|married/civil partner(s)|0|self employed|100000|an employee|100000|230| |700000|3547|183750|-|-|
      |UAT - TC 55|two borrowers|mover(s)|25|25|married/civil partner(s)|2|not in paid work just now|0|an employee|45000|1000| |57808|798|15174|-|-|
      |UAT - TC 56|two borrowers|mover(s)|25|25|married/civil partner(s)|1|not in paid work just now|0|not in paid work just now|0|0|n't|-|-|-|-|-|
      |UAT - TC 57|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|1|an employee|150000|an employee|150000|0| |1050000|5320|368000|-|-|
      |UAT - TC 58|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|2|an employee|100000|a civil servant|100000|100| |700000|3547|183750|-|-|
      |UAT - TC 59|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|0|an employee|85000|self employed|75000|200| |560000|2837|147000|-|-|
      |UAT - TC 60|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|3|an employee|65000|not in paid work just now|0|0| |112928|1153|29644|-|-|
      |UAT - TC 61|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|0|a civil servant|2000000|an employee|250000|240| |7875000|39901|2825000|-|-|
      |UAT - TC 62|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|0|self employed|100000|an employee|100000|230| |700000|3547|183750|-|-|
      |UAT - TC 63|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|2|not in paid work just now|0|an employee|45000|1000| |103293|798|27114|-|-|
      |UAT - TC 64|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|1|not in paid work just now|0|not in paid work just now|0|0|n't|-|-|-|-|-|
      |UAT - TC 65|two borrowers|mover(s)|35|35|widowed|1|an employee|150000|an employee|150000|0| |577500|2926|151594|-|-|
      |UAT - TC 66|two borrowers|mover(s)|35|35|widowed|2|an employee|100000|a civil servant|100000|100| |700000|3547|183750|-|-|
      |UAT - TC 67|two borrowers|mover(s)|45|45|widowed|0|an employee|85000|self employed|75000|200| |560000|3113|147000|-|-|
      |UAT - TC 68|two borrowers|mover(s)|45|55|widowed|3|an employee|65000|not in paid work just now|0|0| |92941|1740|24397|-|-|
      |UAT - TC 69|two borrowers|mover(s)|55|50|widowed|0|a civil servant|2000000|an employee|250000|240| |7875000|60243|2825000|-|-|
      |UAT - TC 70|two borrowers|mover(s)|46|48|widowed|0|self employed|100000|an employee|100000|230| |700000|4182|183750|-|-|
      |UAT - TC 71|two borrowers|mover(s)|35|35|widowed|2|not in paid work just now|0|an employee|45000|1000|n't|-|-|-|-|-|
      |UAT - TC 72|two borrowers|mover(s)|35|35|widowed|1|not in paid work just now|0|not in paid work just now|0|0|n't|-|-|-|-|-|
      |UAT - TC 73|two borrowers|mover(s)|45|45|married/civil partner(s)|1|an employee|150000|an employee|150000|0| |1050000|5836|368000|-|-|
      |UAT - TC 74|two borrowers|mover(s)|55|55|married/civil partner(s)|2|an employee|100000|a civil servant|100000|100| |695367|5355|182534|-|-|
      |UAT - TC 75|two borrowers|mover(s)|65|45|married/civil partner(s)|0|an employee|85000|self employed|75000|200| |255465|10440|67060|-|-|
      |UAT - TC 76|two borrowers|mover(s)|35|65|married/civil partner(s)|3|an employee|65000|not in paid work just now|0|0| |51174|954|13433|-|-|
      |UAT - TC 77|two borrowers|mover(s)|55|20|married/civil partner(s)|0|a civil servant|2000000|an employee|250000|240| |7875000|60243|2825000|-|-|
      |UAT - TC 78|two borrowers|mover(s)|55|60|married/civil partner(s)|0|self employed|100000|an employee|100000|230| |578476|7255|151850|-|-|
      |UAT - TC 79|two borrowers|mover(s)|45|55|married/civil partner(s)|2|not in paid work just now|0|an employee|45000|1000|n't|-|-|-|-|-|
      |UAT - TC 80|two borrowers|mover(s)|89|90|married/civil partner(s)|1|not in paid work just now|0|not in paid work just now|0|0|n't|-|-|-|-|-|
      |UAT - TC 81|a single borrower|first-time buyer(s)|20|-|separated|1|an employee|100000|-|-|0| |350000|1656.37|64100|-|-|
      |UAT - TC 82|a single borrower|first-time buyer(s)|35|-|separated|2|a civil servant|65000|-|-|100| |213669|1011|28313|-|-|
      |UAT - TC 83|a single borrower|first-time buyer(s)|45|-|separated|0|self employed|89000|-|-|200| |230342|3228|32690|-|-|
      |UAT - TC 84|a single borrower|first-time buyer(s)|30|-|separated|3|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
      |UAT - TC 85|a single borrower|first-time buyer(s)|20|-|married/civil partner(s)|0|an employee|100000|-|-|240| |350000|1656|64100|-|-|
      |UAT - TC 86|a single borrower|first-time buyer(s)|35|-|married/civil partner(s)|0|a civil servant|65000|-|-|230| |194220|919|23738|-|-|
      |UAT - TC 87|a single borrower|first-time buyer(s)|45|-|married/civil partner(s)|2|self employed|89000|-|-|1000| |137437|764|16798|-|-|
      |UAT - TC 88|a single borrower|first-time buyer(s)|30|-|married/civil partner(s)|1|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
      |UAT - TC 89|a single borrower|first-time buyer(s)|20|-|divorced/dissolved civil partnership|1|an employee|100000|-|-|0| |350000|1656|64100|-|-|
      |UAT - TC 90|a single borrower|first-time buyer(s)|35|-|divorced/dissolved civil partnership|2|a civil servant|65000|-|-|100| |213669|1011|28313|-|-|
      |UAT - TC 91|a single borrower|first-time buyer(s)|45|-|divorced/dissolved civil partnership|0|self employed|89000|-|-|200| |311500|1731|53994|-|-|
      |UAT - TC 92|a single borrower|first-time buyer(s)|30|-|divorced/dissolved civil partnership|3|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
      |UAT - TC 93|a single borrower|first-time buyer(s)|20|-|widowed|0|an employee|100000|-|-|240| |350000|1656|64100|-|-|
      |UAT - TC 94|a single borrower|first-time buyer(s)|35|-|widowed|0|a civil servant|65000|-|-|230| |227500|1077|31944|-|-|
      |UAT - TC 95|a single borrower|first-time buyer(s)|45|-|widowed|2|self employed|89000|-|-|1000| |230002|1731|32600|-|-|
      |UAT - TC 96|a single borrower|first-time buyer(s)|30|-|widowed|1|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
      |UAT - TC 97|a single borrower|mover(s)|20|-|separated|1|an employee|100000|-|-|0| |350000|1773.37|91875|-|-|
      |UAT - TC 98|a single borrower|mover(s)|35|-|separated|2|a civil servant|65000|-|-|100| |204232|1035|53611|-|-|
      |UAT - TC 99|a single borrower|mover(s)|45|-|separated|0|self employed|89000|-|-|200| |311500|1731|81769|-|-|
      |UAT - TC 100|a single borrower|mover(s)|30|-|separated|3|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
      |UAT - TC 101|a single borrower|mover(s)|20|-|married/civil partner(s)|0|an employee|100000|-|-|240| |350000|1773|91875|-|-|
      |UAT - TC 102|a single borrower|mover(s)|35|-|married/civil partner(s)|0|a civil servant|65000|-|-|230| |185643|941|48731|-|-|
      |UAT - TC 103|a single borrower|mover(s)|45|-|married/civil partner(s)|2|self employed|89000|-|-|1000| |137437|764|36077|-|-|
      |UAT - TC 104|a single borrower|mover(s)|30|-|married/civil partner(s)|1|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
      |UAT - TC 105|a single borrower|mover(s)|20|-|divorced/dissolved civil partnership|1|an employee|190000|-|-|0| |665000|3369|174563|-|-|
      |UAT - TC 106|a single borrower|mover(s)|35|-|divorced/dissolved civil partnership|2|a civil servant|65000|-|-|100| |204232|1035|53611|-|-|
      |UAT - TC 107|a single borrower|mover(s)|45|-|divorced/dissolved civil partnership|0|self employed|89000|-|-|200| |311500|1731|81769|-|-|
      |UAT - TC 108|a single borrower|mover(s)|30|-|divorced/dissolved civil partnership|3|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|
      |UAT - TC 109|a single borrower|mover(s)|20|-|widowed|0|an employee|190000|-|-|240| |665000|3369|174563|-|-|
      |UAT - TC 110|a single borrower|mover(s)|35|-|widowed|0|a civil servant|65000|-|-|230| |227500|1153|59719|-|-|
      |UAT - TC 111|a single borrower|mover(s)|45|-|widowed|2|self employed|89000|-|-|1000| |230002|1731|60375|-|-|
      |UAT - TC 112|a single borrower|mover(s)|30|-|widowed|1|not in paid work just now|0|-|-|0|n't|-|-|-|-|-|