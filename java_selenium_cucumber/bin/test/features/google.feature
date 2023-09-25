Feature: Probar la búsqueda de Google

Scenario: Busco algo en Google
    Given que navego a Google
    When busco algo
    Then obtengo resultados