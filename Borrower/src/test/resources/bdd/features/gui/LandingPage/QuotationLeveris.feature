Business Need: To provide fill of whole page Section by one Sentence and using

  Background:

    Given Open Leveris Quote Landing page

  Scenario: Go through Quotation landing page to the Quick Loan and providing Borrower Basic Parameters then moving Quotation Configuration page for checking the result

      When User walk-through the Quotation process filling all mandatory data
        | LoanPurpose        | PERSONAL   |
        | NetMonthlyIncome   | 66,000.00  |
        | MonthlyExpenses    | 10,000.00  |
        | NumberOfDependents | 4          |
        | AmountToBorrow     | 500,000.00 |
        | MonthlyRepayment   |            |




