@RegisterPage
Feature: Verification RegistrationPage
  
  Background: 
    Given user goes to Registration page
    
  Scenario: Pass registration page
    Given user types his first name Tonda in Register page
    And user types his email anthonymottot@abakus.com in Register page
    And user types his phone number 0812345678 in Register page
    And user types his password Password1122 in Register page
    And user accepts the terms of business
    And user accepts the data protection policy
    When user registers
    Then Verify Email Page is loaded
    When user wants us resent email
    And user types his email anthonymottot@bakus.com in the Verify Email Page
    And user resends
    Then Verify Email Page is loaded