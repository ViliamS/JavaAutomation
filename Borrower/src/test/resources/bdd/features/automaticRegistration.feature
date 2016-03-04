
  Feature: Automatic Registration

    Background:
      Given user goes to Automatic Registration page

    Scenario: High Level
      Given this automatic registration data, user processes the automatic registration
#      TODO duplicate to api and gui and to change applicantID and coapplicantId belong the right testing type
        | applicantId       | test.automation.test@test.finfactory.com              |
        | quoteComplete     | on                                             |
        | inviteCoapplicant | on                                             |
        | coapplicantId     | test.automation.coapplicant_test0001@test.finfactory.com |

    Scenario: High Level
      Given this automatic registration data, user processes the automatic registration
        | applicantId       | test.automation.test@test.finfactory.com              |

    Scenario: High Level
      Given this automatic registration data, user processes the automatic registration
        | applicantId       | test.automation.test@test.finfactory.com              |
        | quoteComplete     | on                                             |

#    Scenario: High Level
#      Given this automatic registration data, user processes the automatic registration
#        | applicantId       | anthony.mottot.test001@abakus.com              |
#        | quoteComplete     | on                                             |
#        | inviteCoapplicant | on                                             |

    Scenario: Low Level
      Given User types his applicant : test.automation.test@test.finfactory.com
      And User checks "Quote Complete"
      And User checks "Invite Coapplicant"
      And User types coapplicant's email: test.automation.coapplicant_test0001@test.finfactory.com
      When User clicks "Create new user"
