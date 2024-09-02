Feature: Do Login and Verify User is logged In Or Not

  Background:
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on the login logo
    Then verify user is on login page

  @web
  Scenario: Verify user can login to plum account
    When user enters a valid phone number "valid.phoneNo" and OTP
    Then verify user is logged in and print the welcome message to console

  @mobile
  Scenario: Verify user can login to plum application
    When user enters a valid phone number "valid.phoneNo" and OTP
    Then verify user is logged in by clicking on profile
 