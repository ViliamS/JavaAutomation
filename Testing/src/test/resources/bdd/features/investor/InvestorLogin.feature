
@login @logout
Feature: Investor SSO Login Client

  Scenario:
    Given user processes SSO Investor Auth Step
    When user processes final SSO Investor Auth Step
    Then user logs out from Investor
