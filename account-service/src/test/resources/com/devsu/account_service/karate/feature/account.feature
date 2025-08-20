Feature: API de Cuentas

  Background:
    * url 'http://localhost:8082/api/v1/cuentas'

  Scenario: Buscar cuenta por numero
    Given path '4000'
    When method get
    Then status 200
    And match response ==
    """
    {
      account: {
        accountNumber: 4000,
        accountType: 'AHORROS',
        initialBalance: 1000,
        customerId: 1,
        customerName: 'Integrador Karate',
        status: true
      },
      message: '#string'
    }
    """