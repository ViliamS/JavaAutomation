  Feature:
    As a user, I am applying a PAYDAY loan or INSTALLMENT loan

  Background:
    Given Open Leveris Quote Landing page

#
#    Medium Level = FullFill in the form + Submit Form
#

  Scenario: WalkThrough Payday Loan Section
#      Given Open Leveris Quote Landing page
      When Borrower clicks on continue to get Payday Loan
      Then Borrower fills in Payday Loan form
      | LoanPurpose        | PAYDAY    |
      | NetMonthlyIncome   | 21,000.00 |
      | MonthlyExpenses    | 1,000.00  |
      | NumberOfDependants | 1         |
      | AmountToBorrow     | 1,000.00  |
    Then Payday Loan Borrower clicks on Continue button
    When Borrower clicks on Apply Online
    Then Borrower is forwarded to the Registration Page

  Scenario: WalkThrough Unsecured Loan Section
#      Given Open Leveris Quote Landing page
      When Borrower clicks on continue to get Unsecured Loan
      Then Borrower fills in Unsecured Loan form
        | LoanPurpose        | PERSONAL  |
        | NetMonthlyIncome   | 44,000.00 |
        | MonthlyExpenses    | 5,000.00  |
        | NumberOfDependants | 3         |
        | AmountToBorrow     | 1,000.00  |
      Then Unsecured Loan Borrower clicks on Continue button
      When Borrower clicks on Apply Online
      Then Borrower is forwarded to the Registration Page

#
#    High Level = Quotation Process
#

  Scenario: WalkThrough Whole Unsecured Loan Process at once
#      Given Open Leveris Quote Landing page
      When Borrower walk-through Unsecured Loan Quotation process
        | LoanPurpose        | HOMEIMPROVEMENT |
        | NetMonthlyIncome   | 4,000.00        |
        | MonthlyExpenses    | 500.00          |
        | NumberOfDependants | 1               |
        | AmountToBorrow     | 1,000.00        |
        | LoanAmount         | 1,000.00        |
        | MonthlyRepayment   | 296             |
      Then Borrower is forwarded to the Registration Page

  Scenario: WalkThrough Whole PayDay Process at onc
#      Given Open Leveris Quote Landing page
      When Borrower walk-through Payday Loan Quotation process
        | LoanPurpose        | PAYDAY    |
        | NetMonthlyIncome   | 2,500.00  |
        | MonthlyExpenses    | 1,500.00  |
        | NumberOfDependants | 10        |
        | AmountToBorrow     | 525       |
        | LoanAmount         | 10,000.00 |
        | MonthlyRepayment   | 296       |
      Then Borrower is forwarded to the Registration Page