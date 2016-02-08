
  Feature: Automatic Registration

    Background:
      Given user goes to Automatic Registration page

    Scenario: High Level
      Given this automatic registration data, user processes the automatic registration
#      TODO duplicate to api and gui and to change applicantID and coapplicantId belong the right testing type
        | applicantId       | anthony.mottot.test001@abakus.com              |
        | quoteComplete     | on                                             |
        | inviteCoapplicant | on                                             |
        | coapplicantId     | anthony.mottot.coapplicant.test0001@abakus.com |

    Scenario: High Level
      Given this automatic registration data, user processes the automatic registration
        | applicantId       | anthony.mottot.test001@abakus.com              |

    Scenario: High Level
      Given this automatic registration data, user processes the automatic registration
        | applicantId       | anthony.mottot.test001@abakus.com              |
        | quoteComplete     | on                                             |

#    Scenario: High Level
#      Given this automatic registration data, user processes the automatic registration
#        | applicantId       | anthony.mottot.test001@abakus.com              |
#        | quoteComplete     | on                                             |
#        | inviteCoapplicant | on                                             |

    Scenario: Low Level
      Given User types his applicant : anthony.mottot.test001@abakus.com
      And User checks "Quote Complete"
      And User checks "Invite Coapplicant"
      And User types coapplicant's email: anthony.mottot.coapplicant.test0001@abakus.com
      When User clicks "Create new user"
