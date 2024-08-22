Feature: Validate Plum Goodness Website and Data Driven Functionality


  Scenario Outline: Verify user can select different category and sub-category products
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "<category>"
    And user selects product sub-category "<sub-category>"
    And user selects specified product type "<specific-product>"
    Then verify specific-product type "<specific-product>" of products are displayed
    And print product name and description

    Examples:
      | category | sub-category  | specific-product    |
      | skin     | by concern    | aging skin          |
      | skin     | by concern    | blemishes           |
      | skin     | by ingredient | aloe                |
      | skin     | by regime     | facewashes          |
      | skin     | by regime     | facial moisturizers |
      | skin     | by benefits   | hydrate & nourish   |

