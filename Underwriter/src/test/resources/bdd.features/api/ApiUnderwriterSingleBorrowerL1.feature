
  Feature: Api Underwriter for Single Borrower

    Background:
#      Given user processes SSO Auth Step 1
#      And user processes SSO Auth Step 2
#      And user processes final SSO Auth Step

    Scenario: Simplest Single Borrower

      When user looks for these information
        | assign | ALL |
        | status | AllActive |
        | search | AUTOMATIONSBAPI20160205171043551 |
#        | applicationId | 4344                      |
      Then user opens the application of the customer AUTOMATIONSBAPI20160205171043551
      And user validates all documents
      And user saves offer
      And user completes and signs the offer
      And user refreshes workflow panel
      And user completes stage 1
      And user refreshes workflow panel
      And user completes stage 2