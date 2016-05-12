
  @login @logout
  Feature: Underwriter Api Login

    Scenario: Underwriter Api Login

      When Operator Underwriter logs in via SSO Underwriter
      Then Operator Underwriter looks for these information
#      Then Operator Underwriter logs out from Underwriter
