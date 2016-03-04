
  @login @logout
  Feature: Underwriter SSO Login

    Scenario: Underwriter SSO Login

      Given user processes SSO Underwriter Auth Step
      When user processes final SSO Underwriter Auth Step
      Then user logs out from Underwriter
