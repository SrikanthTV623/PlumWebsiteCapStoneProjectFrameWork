Feature: Validate Add To Wishlist Button In Plum Goodness Website

  @mobile @srikanth
  Scenario: User searches for a product and adds it to the wishlist using textile
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on the login logo
    Then verify user is on login page
    When user enters a valid phone number "valid.phoneNo" and OTP
    When user searches for search product names from text file
    And selects first product added to wishlist and verify products are added to wishlist


  @mobile @srikanth
  Scenario: User searches for a product and adds it to the wishlist
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on the login logo
    Then verify user is on login page
    When user enters a valid phone number "valid.phoneNo" and OTP
    When user searches for search product names from text file
    And selects first product added to wishlist and verify products are added to wishlist


