Feature: Apply Price Filter In Plum Goodness Website

  Background:
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "hair"
    And user selects product type "shampoo" from the drop down
    Then verify user is on product page

  @web
  Scenario: User sort the hair products from price from low to high
    When user clicks on sort by
    And selects "Price: Low to High" from the drop down
    Then verify products are sorted "Low to High" accordingly

  @web
  Scenario: User sort the hair products from price from high to low
    When user clicks on sort by
    And selects "Price: High to Low" from the drop down
    Then verify products are sorted "High to Low" accordingly

  @web
  Scenario: User filters products by a specific price range
    When user clicks on price range filter
    And user sets price range between "200.0" and "800.0"
    Then displayed products should have prices within the specified range


  @mobile
  Scenario Outline: User filters products by a specified price range in application
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "<category>"
    And user selects product type "<typeofProduct>" from the drop down
    Then verify user is on selected product screen "<validateProductName>"
    When user clicks on filters
    And selects "<typeOfFilter>" from the filters menu
    And selects "<subTypeOfFilter>"
    Then verify products are sorted "<subTypeOfFilter>" accordingly



    Examples:
      | category | typeofProduct | validateProductName | typeOfFilter | subTypeOfFilter |
      | hair     | serum         | Serum               | Price        | 0-500           |


