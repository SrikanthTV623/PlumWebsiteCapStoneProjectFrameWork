Feature: Validate Plum Goodness Website Functionality

  Scenario: User sort the hair products from AtoZ
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "category.hair"
    And user selects product type "product.hairMask" from the drop down
    Then verify user is on product page
    When user clicks on sort by
    And selects "sort.A-Z" from the drop down
    Then verify products are sorted "sort.A-Z" accordingly

  Scenario: User sort the hair products from ZtoA
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "category.hair"
    And user selects product type "product.hairMask" from the drop down
    Then verify user is on product page
    When user clicks on sort by
    And selects "sort.Z-A" from the drop down
    Then verify products are sorted "sort.Z-A" accordingly

  Scenario: User sort the makeup products from ZtoA
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "category.makeup"
    And user selects product type "product.nails" from the drop down
    Then verify user is on product page
    When user clicks on sort by
    And selects "sort.Z-A" from the drop down
    Then verify products are sorted "sort.Z-A" accordingly


  Scenario Outline: User sort the makeup products from ZtoA
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "category.makeup"
    And user selects product type "product.nails" from the drop down
    Then verify user is on product page
    When user clicks on sort by
    And selects "sort.Z-A" from the drop down
    Then verify products are sorted "sort.Z-A" accordingly


    Examples: