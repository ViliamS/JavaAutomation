@LoginPage
Feature: Verification LoginPage

  Background:
    Given user goes to Registration page

  Scenario: Pass registration and Login page
    Given user creates an account
    When user logs in as his account is activated
    Then Home Borrower Page is loaded