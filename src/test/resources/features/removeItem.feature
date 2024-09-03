Feature: Validate Remove Button In Plum Goodness Website

  @web
  Scenario: User removes an item from the cart
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.value1" into the search bar
    Then verify user is on searched product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    When clicks on the shopping cart icon
    And user views the cart contents
    When user clicks on remove button next to an item
    Then verify shopping cart is empty


  @mobile
  Scenario: User removes an item from the cart and verify count
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
    And user views the cart contents
    When user clicks on remove button next to an item
    Then the item "search.value1" should be removed from the cart
    And the cart should display the updated cart count

