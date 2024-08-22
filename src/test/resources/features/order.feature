Feature: Validate Plum Goodness Website Functionality

  Background:
    Given user opens website
    Then verify user is on the Plum Goodness homepage

  Scenario: User searches for a product and places the order
    When the user enters "search.value" into the search bar
    Then verify user is on searched product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    Then verify item is added into cart and should displays "1"
    When clicks on the shopping cart icon
    And user views the cart contents
    And clicks on checkout button
    And enters phoneNo and address
    Then verify payment option is displayed
    When user clicks on cash on delivery option
    Then verify the order is placed
    And store the order id as "order.id"
    And user navigates to home page
    Then verify user is on the Plum Goodness homepage
    When user clicks on the login button
    And clicks on order history
    Then verify user is on account page
    When user clicks on order cancellation
    And Enter order cancellation details "order.id" and "valid.phoneNo"
    And select reason for order cancellation as "cancel.reason"
    And user clicks on cancel button
    And confirm cancellation
    Then verify user has successfully cancelled the order






  Scenario: Verify user can cancel the placed order



