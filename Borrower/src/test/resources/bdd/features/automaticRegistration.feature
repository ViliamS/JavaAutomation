
  Feature: Automatic Registration

    Background:
      Given Borrower goes to Automatic Registration page

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
      Given Borrower types his applicant : test.automation.test@test.finfactory.com
      And Borrower checks "Quote Complete"
      And Borrower checks "Invite Coapplicant"
      And Borrower types coapplicant's email: test.automation.coapplicant_test0001@test.finfactory.com
      When Borrower clicks "Create new user"
