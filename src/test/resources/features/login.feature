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

  @mobile @savita
  Scenario: User login, search and add product to cart and do checkout in app
    When the user enters "search.value" into the search bar
    Then verify user is on searched "search.value" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    Then verify item is added into cart and should displays "1"
    And user views the cart contents
    And clicks on checkout button
    Then verify payment option is displayed
 