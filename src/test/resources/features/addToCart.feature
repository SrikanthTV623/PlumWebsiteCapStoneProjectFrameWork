Feature: Validate Plum Goodness Website Functionality

  Background:
    Given user opens website
    Then verify user is on the Plum Goodness homepage

  Scenario: User searches for a product and adds it to the cart
    When the user enters "search.value" into the search bar
    Then verify user is on product results page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    Then verify item is added into cart and should displays "1"


  Scenario: User searches for products, adds multiple products to the cart, and verifies the cart value
    When the user enters "search.value1" into the search bar
    Then verify user is on product results page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    When the user enters "search.value2" into the search bar
    Then verify user is on product results page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    When clicks on the shopping cart icon
    Then verify cart contains correct products count and cart value

