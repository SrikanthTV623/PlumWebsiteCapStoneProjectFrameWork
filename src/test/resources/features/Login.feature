Feature: Do Login and Verify User is logged In Or Not

  Background:
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on the login logo
    Then verify user is on login page
    When user enters a valid phone number "valid.phoneNo" and OTP

  @web @savita
  Scenario: Verify user can login to plum account
    Then verify user is logged in and print the welcome message to console

  @mobile @savita
  Scenario: Verify user can login to plum application
    Then verify user is logged in by clicking on profile
 