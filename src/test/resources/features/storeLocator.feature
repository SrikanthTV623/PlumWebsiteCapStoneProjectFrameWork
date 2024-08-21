Feature: Validate Plum Goodness Website Functionality

  Scenario Outline: Verify user can get the store locations based on the city name
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "<category>"
    And user selects product type "<sub category>" from the drop down
    Then verify user is on "<page>"
    When user clicks on "<cityName>"
    And print all the store locations

    Examples:
      | category       | sub category  | page          | cityName   |
      | get to know us | store-locator | store locator | Trivandrum |
      | get to know us | store-locator | store locator | Bengaluru  |
      | get to know us | store-locator | store locator | Nagpur     |
      | get to know us | store-locator | store locator | Pune       |

