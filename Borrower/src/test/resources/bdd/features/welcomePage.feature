@WelcomePage
Feature: Verification WelcomePage

  Background:
    Given user is on Abakus Borrower homepage

  Scenario Outline: Check links
    When user clicks on <link_value> link on Welcome Page
    Then <loaded_page> page is loaded
    When <loaded_page> page is closed
    Then Welcome page is loaded

    Examples:
      | link_value    | loaded_page     |
#      | Register      | Register        |
#      | Quote         | Welcome Quote   |
      | Login         | Login           |
