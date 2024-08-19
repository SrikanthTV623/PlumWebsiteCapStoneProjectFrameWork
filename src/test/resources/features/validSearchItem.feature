Feature:Validate Plum Goodness Website Functionality

  Scenario: Validating whether searched item and displayed items are same
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "category.fragrances"
    And user selects product category "category.collections"
    And user selects product type "product.orchid" from the drop down
    Then verify user is on product page
    And get product list
    Then verify searched product "validate.product.name" and displayed product names are same
