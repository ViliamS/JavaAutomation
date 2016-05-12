
@login @logout
Feature: Investor Api Login

  Scenario: Investor Api Login

    When Investor processes SSO Investor Auth Step
    Then Investor processes final SSO Investor Auth Step
#      Then Investor logs out from Investor
