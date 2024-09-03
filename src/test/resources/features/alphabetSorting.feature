Feature: Apply Filter Button Validate Alphabet Sorting In Plum Goodness Website

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

  @mobile
  Scenario Outline: User sorting the products based on rating in app
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "<category>"
    And user selects product type "<products>" from the drop down
    Then verify user is on selected product screen "<validateProductName>"
    When user clicks on filters
    And selects "<typeOfFilter>" from the filters menu
    And selects "<subTypeOfFilter>"
    Then verify products are sorted "<subTypeOfFilter>" accordingly



    Examples:
      | category | products | validateProductName | typeOfFilter | subTypeOfFilter |
     # | haircare | hair mask | Hair Mask           | Ratings      | 4               |
      | makeup   | nails    | Nail                | Ratings      | 3               |
#      | haircare | hair mask | Hair Mask           |
#      | makeup   | nail      | Nail                |







