Feature:Validate Searched and Displayed Products are matching

  @web @savita
  Scenario: Validating whether searched item and displayed items are same
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user selects product category "fragrances"
    And user selects product category "collections"
    And user selects product type "orchid-you-not" from the drop down
    Then verify user is on product page
    And get product list
    Then verify searched product "validate.product.name" and displayed product names are same


  @mobile @srikanth @swipe
  Scenario Outline: Validating searched item and displayed items are same on plum application
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on shop option and scroll "shopOnConcern"
    When user selects product category "fragrance"
    And user apply swipe and select type of fragrance "<typeofFragrance>"
    Then verify user is on selected product screen "<validateProductName>"
    And get product list
    Then verify searched product "<validateProductName>" and displayed product names are same

    Examples:
      | typeofFragrance     | validateProductName |
      | vanilla vibes       | Vanilla             |
      | orchid-you-not      | Orchid              |
      | red velvet love     | Red Velvet Love     |
      | caramel popcorn     | Caramel Popcorn     |
      | lemme lemon         | Lemme Lemon         |
      | coffee wake-a-ccino | Coffee              |




