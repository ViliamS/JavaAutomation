Feature: Lever.is Draft Happy path walk-through

  Background:

    Given Open Leveris Quote Landing page

  Scenario: Leveris draft Quotation test

#    When Check that Up to £35,000 is displayed
#    When Check that from £174.77 per month is displayed
#    When Check that Payday £500-£2,000 is displayed

#    And Borrower clicks on red continue button
    And Payday Loan Borrower clicks on Continue button

    Then Payday Loan Borrower selects Loan purpose PAYDAY

    And Payday Loan Borrower types into Net monthly income field a 66,000.00
    And Payday Loan Borrower types into Monthly expenses field a 10,000.00
    And Payday Loan Borrower types into Number of dependants field a 4
    And Payday Loan Borrower types into Amount to borrow field a 500,000.00

    When Payday Loan Borrower clicks on Continue button

    And Borrower types into Monthly instalment field a 15,000.00
    And Borrower types into Loan amount field a 500,000.00

    Then Borrower clicks on Apply Online