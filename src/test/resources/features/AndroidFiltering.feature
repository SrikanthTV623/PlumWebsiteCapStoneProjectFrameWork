Feature: Apply Price & Rating Filter In Plum Goodness Application

  @mobile @srikanth
  Scenario Outline: User filters products by a specified price range in application
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When selects product category "<category>" and product type "<typeofProduct>"
    Then verify user is on selected product screen "<validateProductName>"
    When user clicks on filters
    And selects "<typeOfFilter>" from the filters menu
    And selects "<subTypeOfFilter>"
    Then verify products are sorted "<subTypeOfFilter>" accordingly

    Examples:
      | category | typeofProduct | validateProductName | typeOfFilter | subTypeOfFilter |
      #| haircare | serums        | Serum               | Price        | 500-1000        |
      | haircare | serums        | Serum               | Price        | 0-500           |


  @mobile @savita
  Scenario Outline: User filters the products based on rating in application
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

