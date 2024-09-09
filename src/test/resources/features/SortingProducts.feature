Feature: Validate Alphabet & Price Sorting In Plum Goodness Website

  @web @savita
  Scenario Outline: User sorting the products from AtoZ and ZtoA
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "<category>"
    And user selects product type "<products>" from the drop down
    Then verify user is on product page
    When user clicks on sort by
    And selects "<typeOfSorting>" from the drop down
    Then verify products are sorted "<typeOfSorting>" accordingly


    Examples:
      | typeOfSorting | category | products  |
      | A-Z           | hair     | hair-mask |
      | A-Z           | makeup   | nail      |
      | Z-A           | hair     | hair-mask |
      | Z-A           | makeup   | nail      |


  @web @srikanth
  Scenario Outline: User sorting the products from low to high and high to low
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "<category>"
    And user selects product type "<products>" from the drop down
    Then verify user is on product page
    When user clicks on sort by
    And selects "<typeOfSorting>" from the drop down
    Then verify products are sorted "<sortingValue>" accordingly


    Examples:
      | typeOfSorting      | sortingValue | category | products |
      | Price: Low to High | Low to High  | hair     | shampoo  |
      | Price: High to Low | High to Low  | hair     | shampoo  |





