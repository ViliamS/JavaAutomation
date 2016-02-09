Feature: Lever.is Draft Happy path walk-through

  Background:

    Given Open Lever.is Quote Landing page

  Scenario: Lever.is draft Quotation test

    When Check that Up to VALUE is displayed
    When Check that from VALUE per month is displayed
    When Check that Payday VALUE is displayed

    When User clicks on red continue button

    Then User selects a VALUE from drop down field Loan purpose
    And User types a VALUE into Net monthly income field
    And User types a VALUE into Monthly expenses filed
    And User types a VALUE into Number of dependents field
    And User types a VALUE into Amount to borrow field

    When User clicks on Continue button

    Then User types a VALUE into Amount to borrow field
    And Check that VALUE is in Amount to borrow field
    Then User types a VALUE into Monthly repayment filed
    And Check that VALUE is in Monthly repayment field

    Then User clicks on Apply Online




