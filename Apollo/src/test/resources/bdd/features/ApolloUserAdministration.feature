@ApolloUserAdministration
Feature: Apollo User Administration

  Background:
    Given Go to Apollo Administration Login page

  Scenario:
    When Set username Admin with password changemenow! and click login

    And Admin clicks on the Users banner menu link

    And Admin set User Search criteria: test_automation@abakus.com and triggers Search

    Then Admin checks the search result "Found 0 items."

    When "Found 0 items." is displayed then Admin Creates new user

    When "Found 1 items." is displayed then Admin Logouts