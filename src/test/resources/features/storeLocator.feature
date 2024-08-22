Feature: Find out Stores available in different locations Through Plum Goodness Website

  Background:
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "get to know us"
    And user selects product type "store-locator" from the drop down
    Then verify user is on "store locator"

  Scenario Outline: Verify user can get the store locations based on the city name
    When user clicks on "<cityName>"
    And print all the store locations

    Examples:
      | cityName   |
      | Trivandrum |
      | Bengaluru  |
      | Nagpur     |
      | Pune       |

