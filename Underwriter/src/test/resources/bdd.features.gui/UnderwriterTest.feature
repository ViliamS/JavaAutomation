@Underwriter
Feature: Underwriter Stage 2

  Background:

    Given Go to Underwriter Login Page

    #################################
    #                               #
    #  Low Level Scenario Example   #
    #                               #
    #################################
  Scenario: Underwriter Approve Loan Application Low Level
    #################################
    #       Low Level Login         #
    #################################
    And Underwriter types username : "testautomation@finfactory.com"
    And Underwriter types password : "1234567Aa"
    Then Underwriter clicks on Login button
    When Underwriter has successfully logged in
    #################################
    #  Low Level Search Filtering   #
#    #################################

    And Underwriter sets filters and triggers the search
        | Assigned        | All applications |
        | Case            | Unsecured Loan   |
        | Status          | All active       |
        | Search text     | AutomationGUI    |
        | Application id  | 4138             |
#
#
#    Then Underwriter sets Assigned Filter to : "All applications"
#    And Underwriter sets Case Filter to : "Unsecured Loan"
#    And Underwriter sets Status Filter to : "All active"
#    And Underwriter clicks on Show advanced options
#    And Underwriter sets Search Text Filter to : "AUTOMATIONGUI"
#    And Underwriter sets Application ID Filter to : "2701"
#    Then Underwriter clicks on Search
#    And Underwriter clicks on Hide advanced options
    #################################
    #       Low Level Sorting       #
    #################################
#    And Underwriter wants to Sort By stage submission date
#    And Underwriter wants to sort results descendant
#    And Underwriter wants to Sort By creation date
#    And Underwriter wants to sort results ascendant
#    And Underwriter clicks on stage submission date to Sort results ascendant
#    And Underwriter clicks on creation date to Sort results descendant

    And Underwriter opens Loan Application with name : "AutomationGUI"

    And Underwriter validates all documents

    And Underwriter goes to Workflow section and Completes Validation Stage 1

    And Underwriter does Set FICO part of KYC check
        | FICO     | 888 |
        | TicketId | 123 |
        | Comment  | Underwriter Commentary Set FICO |

    And Underwriter does Set AML part of KYC check
        | AML      | OK  |
        | TicketId | 321 |
        | Comment  | Underwriter Commentary Set AML |

    And Underwriter does Set Fraud part of KYC check
        | Fraud    | OK  |
        | TicketId | 222 |
        | Comment  | Underwriter Commentary Set Fraud |

    And Underwriter does Set rep. customer part of KYC check
        | RepeatCustomer | 20 |

    And Underwriter does Set score override part of KYC check
        | Score   | 100 |
        | Note    | Underwriter Note Set score override |

    And Underwriter does Set note part of KYC check
        | Note | Underwriter Set note Commentary |

    And Underwriter Manually sets KYC Check status to Green and click Save

#    And Underwriter Sign the Loan Offer




#    Then Underwriter logouts from application
    #######  ###    ##  ######
    ##       ####   ##  ##   ##
    ##       ## ##  ##  ##    ##
    #####    ##  ## ##  ##    ##
    ##       ##   ####  ##    ##
    ##       ##    ###  ##   ##
    #######  ##     ##  ######

    #################################
    #                               #
    #  High Level Scenario Example  #
    #                               #
    #################################
#  Scenario: Underwriter Approve Loan Application High Level
    #################################
    #       High Level Login        #
    #################################
#    When Underwriter login as user : "testautomation@finfactory.com" with password : "1234567Aa"
    #################################
    #  High Level Search Filtering  #
    #################################
#    And Underwriter sets filters and triggers the search
#        | Assigned        | All applications |
#        | Case            | Unsecured Loan   |
#        | Status          | All active       |
#        | Search text     | AutomationGUI    |
#        | Application id  | 2590             |
    #################################
    #      High Level Sorting       #
    #################################
#    And Underwriter sets SORT BY and sorting order
#     | creation date         | ascendant  |
#     | Stage submission date | ascendant  |
#     | stage submission date | descendant |
#     | creation date         | descendant |

#    And Underwriter clicks on Start button of Loan Application with name : "AutomationGUI20160418134547195 Tester"
    #######  ###    ##  ######
    ##       ####   ##  ##   ##
    ##       ## ##  ##  ##    ##
    #####    ##  ## ##  ##    ##
    ##       ##   ####  ##    ##
    ##       ##    ###  ##   ##
    #######  ##     ##  ######