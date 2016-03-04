
@login @logout
Feature: Apollo Login Payment

  Scenario:
    Given user processes SSO Payment Auth Step
    When user processes final SSO Payment Auth Step
    Then user logs out from Payment
