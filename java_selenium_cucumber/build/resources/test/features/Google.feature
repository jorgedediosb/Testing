Feature: Probar la búsqueda de Google

Scenario: As a user I enter a search page
    Given (Dado) I am on the Google search page
    When (Cuando) I enter a search criteria
    And (Y) click on the search button
    Then (Entonces) the results match the criteria