Feature: Validate Cart Value In Plum Goodness Application

  @mobile
  Scenario: User searches for products, adds multiple products to the cart, and verifies the cart value
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
    #When clicks on the shopping cart icon
    Then verify cart contains correct products count and cart value

