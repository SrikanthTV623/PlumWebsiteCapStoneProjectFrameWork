Feature: Validate Pin Code for Delivery of the Order

  Scenario Outline: Validating the PinCode
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.value" into the search bar
    When user clicks on a product from the search results
    When user clicks the Add to Cart button
    When clicks on the shopping cart icon
    And user enters pin code "<pinCode>"
    Then then validate whether pin code is valid or not

    Examples:
      | pinCode |
      | 515201  |
      | 52200   |
      | 220015  |
      | 98761   |
      | 695583  |
      | 69558   |
