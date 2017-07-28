@ApolloUserAdministration
Feature: Apollo User Administration

  Scenario: Create Underwriter if doesn't exists

    Given Go to Apollo Administration Login page

    When Set username "admin" with password "changemenow!" and click login
    And Admin clicks on the Users link
    And Admin clicks on the Top Banner Users link
    And Admin set User Search criteria: test_automation@finfactory.com and triggers Search
    Then Admin checks the search result "Found no items."
    When "Found no items." is displayed then Admin Creates new user
    And Admin clicks on the Top Banner Users link
    And Admin set User Search criteria: test_automation@finfactory.com and triggers Search
    When "Found 1 item." is displayed then Admin Logouts

        #######  ###    ##  ######
        ##       ####   ##  ##   ##
        ##       ## ##  ##  ##    ##
        #####    ##  ## ##  ##    ##
        ##       ##   ####  ##    ##
        ##       ##    ###  ##   ##
        #######  ##     ##  ######