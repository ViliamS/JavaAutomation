Feature: Cal Quote - Two Borrowers - Mover

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
    Then user could buy a home up to the value of <MaxLoanAmount> euros, should pay monthly <MonthlyPayment> euros and should get a minimum deposit value of <MinimumDeposit> euros, for scenario <ScenarioID>

    Examples:
      |ScenarioID| BorrowerNumber    | MortgageType        | BorrowerAge | PartnerAge | BorrowerMaritalStatus                | BorrowerTotalDependents | BorrowerIncomeType        | BorrowerIncomeAmount | PartnerIncomeType         | PartnerIncomeAmount | MonthlyCreditCommitments | isEligible | MaxLoanAmount                                     | MonthlyPayment | MinimumDeposit |
      |UAT - TC 62|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|0|self employed|100000|an employee|100000|230||700000|3547|183750|
      |UAT - TC 63|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|2|not in paid work just now|0|an employee|45000|1000||103293|798|27114|
      |UAT - TC 41|two borrowers|mover(s)|20|20|separated|1|an employee|150000|an employee|150000|0||1050000|5320.11|368000|
      |UAT - TC 42|two borrowers|mover(s)|20|20|separated|2|an employee|100000|a civil servant|100000|100||700000|3547|183750|
      |UAT - TC 43|two borrowers|mover(s)|20|20|separated|0|an employee|85000|self employed|75000|200||56000|2837|147000|
      |UAT - TC 44|two borrowers|mover(s)|20|20|separated|3|an employee|65000|not in paid work just now|0|0||11292825|1153|29644|
      |UAT - TC 45|two borrowers|mover(s)|20|20|separated|0|a civil servant|2000000|an employee|250000|240||7875000|39901|2825000|
      |UAT - TC 46|two borrowers|mover(s)|20|20|separated|0|self employed|100000|an employee|100000|230||700000|3547|183750|
      |UAT - TC 47|two borrowers|mover(s)|20|20|separated|2|not in paid work just now|0|an employee|45000|1000||103293|798|27114|
      |UAT - TC 48|two borrowers|mover(s)|20|20|separated|1|not in paid work just now|0|not in paid work just now|0|0|n't||||
      |UAT - TC 49|two borrowers|mover(s)|25|25|married/civil partner(s)|1|an employee|150000|an employee|150000|0||1050000|5320|368000|
      |UAT - TC 50|two borrowers|mover(s)|25|25|married/civil partner(s)|2|an employee|100000|a civil servant|100000|100||700000|3547|183750|
      |UAT - TC 51|two borrowers|mover(s)|25|25|married/civil partner(s)|0|an employee|85000|self employed|75000|200||560000|2837|147000|
      |UAT - TC 52|two borrowers|mover(s)|25|25|married/civil partner(s)|3|an employee|65000|not in paid work just now|0|0||158414|1153|41584|
      |UAT - TC 53|two borrowers|mover(s)|25|25|married/civil partner(s)|0|a civil servant|2000000|an employee|250000|240||7875000|39901|2825000|
      |UAT - TC 54|two borrowers|mover(s)|25|25|married/civil partner(s)|0|self employed|100000|an employee|100000|230||700000|3547|183750|
      |UAT - TC 55|two borrowers|mover(s)|25|25|married/civil partner(s)|2|not in paid work just now|0|an employee|45000|1000||57808|798|15174|
      |UAT - TC 56|two borrowers|mover(s)|25|25|married/civil partner(s)|1|not in paid work just now|0|not in paid work just now|0|0|n't||||
      |UAT - TC 57|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|1|an employee|150000|an employee|150000|0||1050000|5320|368000|
      |UAT - TC 58|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|2|an employee|100000|a civil servant|100000|100||700000|3547|183750|
      |UAT - TC 59|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|0|an employee|85000|self employed|75000|200||560000|2837|147000|
      |UAT - TC 60|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|3|an employee|65000|not in paid work just now|0|0||112928|1153|29644|
      |UAT - TC 61|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|0|a civil servant|2000000|an employee|250000|240||7875000|39901|2825000|
      |UAT - TC 64|two borrowers|mover(s)|30|30|divorced/dissolved civil partnership|1|not in paid work just now|0|not in paid work just now|0|0|n't||||
      |UAT - TC 65|two borrowers|mover(s)|35|35|widowed|1|an employee|150000|an employee|150000|0||577500|2926|151594|
      |UAT - TC 66|two borrowers|mover(s)|35|35|widowed|2|an employee|100000|a civil servant|100000|100||700000|3547|183750|
      |UAT - TC 67|two borrowers|mover(s)|45|45|widowed|0|an employee|85000|self employed|75000|200||560000|3113|147000|
      |UAT - TC 68|two borrowers|mover(s)|45|55|widowed|3|an employee|65000|not in paid work just now|0|0||92941|1740|24397|
      |UAT - TC 69|two borrowers|mover(s)|55|50|widowed|0|a civil servant|2000000|an employee|250000|240||7875000|60243|2825000|
      |UAT - TC 70|two borrowers|mover(s)|46|48|widowed|0|self employed|100000|an employee|100000|230||700000|4182|183750|
      |UAT - TC 71|two borrowers|mover(s)|35|35|widowed|2|not in paid work just now|0|an employee|45000|1000|n't||||
      |UAT - TC 72|two borrowers|mover(s)|35|35|widowed|1|not in paid work just now|0|not in paid work just now|0|0|n't||||
      |UAT - TC 73|two borrowers|mover(s)|45|45|married/civil partner(s)|1|an employee|150000|an employee|150000|0||1050000|5836|368000|
      |UAT - TC 74|two borrowers|mover(s)|55|55|married/civil partner(s)|2|an employee|100000|a civil servant|100000|100||695367|5355|182534|
      |UAT - TC 75|two borrowers|mover(s)|65|45|married/civil partner(s)|0|an employee|85000|self employed|75000|200||255465|10440|67060|
      |UAT - TC 76|two borrowers|mover(s)|35|65|married/civil partner(s)|3|an employee|65000|not in paid work just now|0|0||51174|954|13433|
      |UAT - TC 77|two borrowers|mover(s)|55|20|married/civil partner(s)|0|a civil servant|2000000|an employee|250000|240||7875000|60243|2825000|
      |UAT - TC 78|two borrowers|mover(s)|55|60|married/civil partner(s)|0|self employed|100000|an employee|100000|230||578476|7255|151850|
      |UAT - TC 79|two borrowers|mover(s)|45|55|married/civil partner(s)|2|not in paid work just now|0|an employee|45000|1000|n't||||
      |UAT - TC 80|two borrowers|mover(s)|89|90|married/civil partner(s)|1|not in paid work just now|0|not in paid work just now|0|0|n't||||