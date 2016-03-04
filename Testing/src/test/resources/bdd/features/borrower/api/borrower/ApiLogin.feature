
@login
Feature: Borrower Wicket Login

  Background:
    Given user goes to Registration page

  Scenario: Borrower Wicket Login
    Given user creates an account
    When Borrower user logs in as his account is activated
#    TODO create/call a stepdef belong dashboard











