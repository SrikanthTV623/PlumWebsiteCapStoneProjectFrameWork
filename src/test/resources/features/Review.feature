Feature: Write a Review for a product in Plum Goodness Website

  @web @savita
  Scenario: Write a review for the product
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.babyCare" into the search bar
    Then verify user is on searched "search.babyCare" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user scroll and clicks on write review button
    And user fills review data
      | valid.rating      |
      | valid.reviewTitle |
      | valid.review      |
      | valid.name        |
      | valid.email       |
    And user clicks on submit review
    Then verify user "valid.name" review has been added

  @mobile @savita
  Scenario: Write a review for the product in application
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on the login logo
    Then verify user is on login page
    When user enters a valid phone number "valid.phoneNo" and OTP
    Then verify user is logged in by clicking on profile
    When user store the profile name as "user.name"
    And navigate back to home page
    When the user enters "search.babyCare" into the search bar
    Then verify user is on searched "search.babyCare" product page
    When user clicks on the first product from product page
    Then user should be redirected to the product details page
    When user scroll and clicks on write review button
    And user fills review data
      | valid.reviewTitle |
      | valid.review      |
    And user clicks on submit review
    Then verify user "review.success.message" review has been added
