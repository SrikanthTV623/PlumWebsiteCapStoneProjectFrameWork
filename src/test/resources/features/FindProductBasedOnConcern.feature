Feature: Validate Product Finder Option In Application

  @mobile @savita
  Scenario Outline: Verify user can find product based on concern
    Given user opens website
    Then verify user is on the Plum Goodness homepage
    When user navigates to product finder by clicking on search
    And user selects "<concern>" from I have dropdown
    And user selects "<productType>" from looking for dropdown
    And user clicks on find product
    Then verify user is on the required "<product>"

    Examples:
      | concern        | productType        | product    |
      | Aging skin     | Face Serums & Oils | Face Serum |
      | Pimples & Acne | Night Creams       | Night      |
      | Excess Oil     | Face Scrubs        | Face Scrub |
      | Blemishes      | Toners & Mists     | Toner      |
