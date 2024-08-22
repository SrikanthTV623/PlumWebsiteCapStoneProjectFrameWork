Feature: Validate Plum Goodness Website Functionality


  Scenario: Search for products using keywords from text file
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user searches for search product names from text file
    Then search results should display products related to all searched value
