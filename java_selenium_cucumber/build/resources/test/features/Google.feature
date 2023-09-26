Feature: Try Google Search

Scenario: As a user I enter a search page
    Given I am on the Google search page
    When I enter a search criteria
    And click on the search button
    Then the results match the criteria