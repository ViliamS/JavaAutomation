
@login
Feature: Verification LoginPage

  Background:
    Given Open Leveris Automatic Registration Page

  Scenario: Pass registration and Login page
    Given Borrower processes the automatic registration
      | applicantId | test.automation.test@test.finfactory.com |
    When Borrower logs in via Automatic Registration
#    Then Borrower can see Dashboard
















