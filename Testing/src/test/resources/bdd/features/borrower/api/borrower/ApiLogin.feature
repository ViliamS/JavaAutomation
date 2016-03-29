
@login
Feature: Borrower Wicket Login

  Background:
    Given Open Leveris Automatic Registration Page

  Scenario: Pass registration and Login page
    Given Borrower processes the automatic registration
      | applicantId | test.automation.api@finfactory.com |
    When Borrower logs in via Automatic Registration
#    Then Borrower logs out
#    Then Borrower can see Dashboard











