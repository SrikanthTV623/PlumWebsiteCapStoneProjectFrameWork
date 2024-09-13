Feature: Validate Add To Cart Button In Plum Goodness Website

  Background:
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.value" into the search bar
    Then verify user is on searched "search.value" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button

  @web @srikanth
  Scenario: User searches for a product and adds it to the cart
    Then verify item is added into cart and should displays "1"

  @mobile @srikanth
  Scenario: User searches for a product and adds it to the cart in application
    When clicks on the shopping cart icon
    Then verify item is added into cart and should displays "1"
