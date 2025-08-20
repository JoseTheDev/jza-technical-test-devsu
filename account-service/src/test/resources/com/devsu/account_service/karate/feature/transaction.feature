Feature: API de Movimientos

  Background:
    * url 'http://localhost:8082/api/v1/movimientos'

  Scenario: Buscar movimiento por ID
    Given path '1'
    When method get
    Then status 200
    And match response ==
    """
    {
        transaction: {
            id: 1,
            date: '2025-08-22T00:00:00',
            transactionType: 'DEPOSITO 2000',
            accountNumber: 4000,
            amount: 2000,
            balance: 3000.00
        },
        message: '#string'
    }
    """