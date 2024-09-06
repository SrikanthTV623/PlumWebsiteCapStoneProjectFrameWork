Feature: Search for Out-of-Stock Products In Plum Goodness Website


  @web @srikanth
  Scenario: Search for out-of-stock items and verify the out-of-stock message
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.value.out" into the search bar
    Then verify user is on searched product page
    Then verify product is out of stock
    And print names of all out of stock products


  @mobile @srikanth
  Scenario: Search for out-of-stock items and verify the out-of-stock message
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on shop option and scroll
    When selects product category "<category>" and product type "<typeofProduct>"


