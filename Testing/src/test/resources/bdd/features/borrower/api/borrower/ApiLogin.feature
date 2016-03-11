
@login
Feature: Borrower Wicket Login

#  Background:
#    Given user goes to Registration page

  Scenario: Pass registration and Login page
    Given Borrower processes the automatic registration
      | applicantId | test.automation.test@test.finfactory.com |
    When Borrower logs in via Automatic Registration
#    Then Borrower can see Dashboard











