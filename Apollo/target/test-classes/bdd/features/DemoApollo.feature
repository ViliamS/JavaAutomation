Feature: Demo Apollo - Display Client Data

  Background:
    Given user is on Apollo homepage

  Scenario: Display client data via simple search
#    When user searches tomas_p_test0030@test.finfactory.com as a client on simple search
    When user searches tomas as a client on simple search
    And user chooses 1st client
#    Then user checks client's data

#  tomas_p_test0030@test.finfactory.com  +420 608 700 143

#  Scenario Outline: Display client data via simple search version 2
#    When user searches <data> as a client on simple search
#    And user chooses 1st client
#    Then user checks client's data
#
#    Examples:
#      | data                    |
#      | m                       |
##      | ma                      |
##      | mai                     |
##      | mail                    |
#      | mail@mcdowellpurcell.ie |


#  Scenario: Display client data via advanced search
#    Given client's Email is mail@mcdowellpurcell.ie
#    When user searches a client on advanced search
#    And user chooses 1st client
#    Then user checks client's data


#  Scenario: Display client data via advanced search bis
#    Given client's First Name is ""
#    And client's Middle Name is ""
#    And client's Last Name is ""
#    And client's Date Of Birth is ""
#    And client's Email is mail@mcdowellpurcell.ie
#    And client's Phone is ""
#    And client's Address Line 1 is ""
#    And client's Address Line 2 is ""
#    When user searches a client on advanced search
#    And user chooses 1st client
#    Then user checks client's data

#  Scenario Outline: Display client data via advanced search version 2
#    Given client's First Name is <First Name>
#    And client's Middle Name is <Middle Name>
#    And client's Last Name is <Last Name>
#    And client's Date Of Birth is <Date Of Birth>
#    And client's Email is <Email>
#    And client's Phone is <Phone>
#    And client's Address Line 1 is <Address Line 1>
#    And client's Address Line 2 is <Address Line 2>
#    When user searches a client on advanced search
#    And user chooses 1st client
#    Then user checks client's data
#
#    Examples:
#      | First Name | Middle Name | Last Name | Date Of Birth | Email                      | Phone     | Address Line 1    | Address Line 2 |
#      | test       | test        | test      | 01011950      | johndoe@underthebridge.com | 123456789 | Under the bridge  |                |
#      |            |             |           |               | mail@mcdowellpurcell.ie    |           |                   |                |
#
#
#  Scenario: Display client data via advanced search version 3
#    Given client's data are
#      | First Name      | test                          |
#      | Middle Name     | test                          |
#      | Last Name       | test                          |
#      | Date Of Birth   | 01011950                      |
#      | Email           | johndoe@underthebridge.com    |
#      | Phone           | 123456789                     |
#      | Address Line 1  | Under the bridge              |
#      | Address Line 2  |                               |
#    When user searches a client on advanced search
#    And user chooses 1st client
#    Then user checks client's data