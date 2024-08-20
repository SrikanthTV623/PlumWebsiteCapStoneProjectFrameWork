Feature: Validate Plum Goodness Website Functionality

  Background:
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "hair"
    And user selects product type "shampoo" from the drop down
    Then verify user is on product page

  Scenario: User sort the hair products from price from low to high
    When user clicks on sort by
    And selects "Price: Low to High" from the drop down
    Then verify products are sorted "Low to High" accordingly

  Scenario: User sort the hair products from price from high to low
    When user clicks on sort by
    And selects "Price: High to Low" from the drop down
    Then verify products are sorted "High to Low" accordingly

  Scenario: User filters products by a specific price range
    When user clicks on price range filter
    And user sets price range between "200.0" and "800.0"
    Then displayed products should have prices within the specified range


