Feature: Apply Price Filter In Plum Goodness Website

  @web @srikanth @price-range-filter
  Scenario: User filters products by a specific price range
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "hair"
    And user selects product type "shampoo" from the drop down
    Then verify user is on product page
    When user clicks on price range filter
    And user sets price range between "500.0" and "700.0"
    Then displayed products should have prices within the specified range
