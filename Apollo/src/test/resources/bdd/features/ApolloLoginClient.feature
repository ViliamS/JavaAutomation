
@login @logout
Feature: Apollo Login Client

  Scenario:
    Given user processes SSO Client Auth Step
    When user processes final SSO Client Auth Step
    Then user logs out from Client
