@ApolloUserAdministration
Feature: Apollo User Administration
  Scenario: 1
    Given Go to Apollo Administration Login page
    When Set username "admin" with password "changemenow!" and click login
    And Admin clicks on the Users link
    And Admin clicks on the Top Banner Users link
    And Admin set User Search criteria: test_automation@abakus.com and triggers Search
    Then Admin checks the search result "Found 0 items."
    When "Found 0 items." is displayed then Admin Creates new user
    When "Found 1 items." is displayed then Admin Logouts

  Scenario: 2
    Given Go to Apollo Administration Login page
    When Set username "admin" with password "changemenow!" and click login
    And Admin clicks on the Users link
    And Admin clicks on the Top Banner Users link
    And Admin set User Search criteria: test_automation@abakus.com and triggers Search
    Then Admin checks the search result "Found 0 items."
    When "Found 0 items." is displayed then Admin Creates new user
    When "Found 1 items." is displayed then Admin Logouts