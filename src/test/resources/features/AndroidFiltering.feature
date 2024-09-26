Feature: Apply Price & Rating Filter In Plum Goodness Application

  @mobile @srikanth
  Scenario Outline: User filters products by a specified price range in application
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on shop option and scroll "<scrollTillElement>"
    When selects product category "<category>" and product type "<typeofProduct>"
    Then verify user is on selected product screen "<validateProductName>"
    When user clicks on filters
    And selects "<typeOfFilter>" from the filters menu
    And selects "<subTypeOfFilter>"
    Then verify products are sorted "<subTypeOfFilter>" accordingly

    Examples:
      | scrollTillElement | category | typeofProduct | validateProductName | typeOfFilter | subTypeOfFilter |
      | shopOnConcern     | haircare | serums        | Serum               | Price        | 0-500           |
      | shopOnConcern     | haircare | serums        | Serum               | Price        | 500-1000        |
      | shopOnConcern     | haircare | conditioner   | Conditioner         | Price        | 0-500           |
      | shopOnConcern     | bodycare | body butters  | Body Butter         | Price        | 0-499           |
      | shopOnConcern     | bodycare | hand creams   | Hand Cream          | Price        | 0-499           |
      | shopOnConcern     | bodycare | body oils     | Body Oil            | Price        | 0-500           |
      | shopOnConcern     | bodycare | body oils     | Body Oil            | Price        | 500-1000        |
      | shopOnConcern     | bodycare | body mists    | Body Mist           | Price        | 500-999         |
      | shopOnConcern     | bodycare | body mists    | Body Mist           | Price        | 1000-1499       |


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
      | category  | products     | validateProductName | typeOfFilter | subTypeOfFilter |
      | haircare  | hair mask    | Hair Mask           | Ratings      | 3               |
      | makeup    | nails        | Nail                | Ratings      | 4               |
      | bodycare  | body butters | Body Butter         | Ratings      | 3               |
      | fragrance | perfumes     | Perfume             | Ratings      | 3               |

