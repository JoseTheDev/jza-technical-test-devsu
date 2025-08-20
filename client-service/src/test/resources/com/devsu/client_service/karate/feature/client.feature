Feature: API de Clientes

  Background:
    * url 'http://localhost:8081/api/v1/clientes'

  Scenario: Buscar cliente por nombre
    Given path 'by-name', 'Integrador Karate'
    When method get
    Then status 200
    And match response ==
    """
    {
      customer: {
        id: '#number',
        name: 'Integrador Karate',
        gender: 'M',
        age: '#number',
        identification: '#string',
        address: '#string',
        phoneNumber: '#string',
        status: true
      },
      message: '#string'
    }
    """
