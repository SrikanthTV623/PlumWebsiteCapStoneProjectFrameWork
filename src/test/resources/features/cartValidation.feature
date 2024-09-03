Feature: Validate Cart Value In Plum Goodness Application

  @mobile
  Scenario: User searches for products, adds multiple products to the cart, and verifies the cart value
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.value1" into the search bar
    Then verify user is on searched "search.value1" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    And navigates next to search next product
    When the user enters "search.value2" into the search bar
    Then verify user is on searched "search.value2" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    Then verify cart contains correct products count and cart value



