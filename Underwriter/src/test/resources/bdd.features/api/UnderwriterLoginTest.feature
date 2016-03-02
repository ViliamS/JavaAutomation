
  @login @logout
  Feature: Underwriter Api Login

    Scenario: Underwriter Api Login

      Given user processes SSO Underwriter Auth Step
      When user processes final SSO Underwriter Auth Step
      Then user logs out from Underwriter
