Feature: Validate Plum Goodness Website Functionality

  Scenario: Write a review for the product
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.babyCare" into the search bar
    Then verify user is on product results page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user scroll and clicks on write review button
    And user fills review data
    |valid.rating|
    |valid.reviewTitle|
    |valid.review     |
    |valid.name       |
    |valid.email      |
    And user clicks on submit review
    Then verify user "valid.name" review has been added
