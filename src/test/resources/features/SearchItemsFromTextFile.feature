Feature: Take Search Keys from Text File and perform the Search Operations


  @web @srikanth @mobile @savita
  Scenario: Search for products using keywords from text file
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user searches for search product names from text file
    Then search results should display products related to all searched value