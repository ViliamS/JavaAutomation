Feature: Lever.is Draft Happy path walk-through

  Background:

    Given Open Lever.is Quote Landing page

  Scenario: Lever.is draft Quotation test

#    When Check that Up to £35,000 is displayed
#    When Check that from £174.77 per month is displayed
#    When Check that Payday £500-£2,000 is displayed

    And User clicks on red continue button

    Then User selects Loan purpose PERSONAL
    Then User selects Loan purpose PAYDAY

    And User types into Net monthly income field a 66,000.00
    And User types into Monthly expenses field a 10,000.00
    And User types into Number of dependents field a 4
    And User types into Amount to borrow field a 500,000.00

    When User clicks on Continue button

    And User types into Monthly instalment field a 15,000.00
    And User types into Loan amount field a 500,000.00

    Then User clicks on Apply Online




