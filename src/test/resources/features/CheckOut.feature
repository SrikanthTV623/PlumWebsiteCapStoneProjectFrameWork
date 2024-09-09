Feature: Validate Check-Out Process In Plum Goodness Website

  Background:
    Given user opens website
    Then verify user is on the Plum Goodness homepage

  @web @savita
  Scenario: User searches for a product, adds it to the cart and do checkout
    When the user enters "search.value" into the search bar
    Then verify user is on searched "search.value" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    When clicks on the shopping cart icon
    Then verify item is added into cart and should displays "1"
    And user views the cart contents
    And clicks on checkout button
    And enters phoneNo and address
    Then verify payment option is displayed


  @mobile @srikanth
  Scenario: User searches for a product without login, adds it to the cart and do checkout in app
    When the user enters "search.value" into the search bar
    Then verify user is on searched "search.value" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    When clicks on the shopping cart icon
    Then verify item is added into cart and should displays "1"
    And user views the cart contents
    And clicks on checkout button
    And enters phoneNo and address
    #When clicks on the shopping cart icon
    And clicks on checkout button
    Then verify payment option is displayed


  @mobile @srikanth
  Scenario: User login, search and add product to cart and do checkout in app
    When user clicks on the login logo
    Then verify user is on login page
    When user enters a valid phone number "valid.phoneNo" and OTP
    When the user enters "search.value" into the search bar
    Then verify user is on searched "search.value" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    Then verify item is added into cart and should displays "1"
    And user views the cart contents
    And clicks on checkout button
    Then verify payment option is displayed


