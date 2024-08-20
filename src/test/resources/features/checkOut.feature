Feature: Validate Plum Goodness Website Functionality

  Scenario: User searches for a product, adds it to the cart and do checkout
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.value" into the search bar
    Then verify user is on product results page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    Then verify item is added into cart and should displays "1"
    When clicks on the shopping cart icon
    And user views the cart contents
    And clicks on checkout button
    And enters phoneNo and address
    Then verify payment option is displayed

