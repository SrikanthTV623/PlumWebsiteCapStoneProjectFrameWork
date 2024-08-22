Feature: Validate Plum Goodness Functionality

  Scenario: Verify user can login to plum account
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on the login logo
    Then verify user is on login page
    When user enters a valid phone number "valid.phoneNo" and OTP
    Then verify user is logged in and print the welcome message to console
    When user clicks on the login button
    And clicks on order history

 