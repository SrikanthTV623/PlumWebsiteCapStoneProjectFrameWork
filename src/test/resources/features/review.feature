Feature: Write a Review for a product in Plum Goodness Website

  Scenario: Write a review for the product
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.babyCare" into the search bar
    Then verify user is on searched product page
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

  @mobile
  Scenario: Verify user can login to plum application and write a review for the product
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user clicks on the login logo
    Then verify user is on login page
    When user enters a valid phone number "valid.phoneNo" and OTP
    Then verify user is logged in by clicking on profile
    When the user enters "search.value" into the search bar
    Then verify user is on searched "search.value" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
