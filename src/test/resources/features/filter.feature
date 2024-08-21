Feature: Validate Plum Goodness Website Functionality

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






