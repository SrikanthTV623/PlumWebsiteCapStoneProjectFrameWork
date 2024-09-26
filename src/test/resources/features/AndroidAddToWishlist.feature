Feature: Validate Add To Wishlist Button In Plum Goodness Website

  @mobile @srikanth
  Scenario: User searches for a product and adds it to the wishlist in application
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on the login logo
    Then verify user is on login page
    When user enters a valid phone number "valid.phoneNo" and OTP
    When the user enters "search.value" into the search bar
    Then verify user is on searched "search.value" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks on wishlist button
    And user clicks on wishlist icon which is visible on product screen
    Then verify searched product "search.value" is added into wishlist
