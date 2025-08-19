package com.devsu.client_service.exception;

public class CustomerAlreadyCreatedException extends RuntimeException {

    public CustomerAlreadyCreatedException(String message) {
        super(message);
    }

    public CustomerAlreadyCreatedException(Long customerId) {
        super("Customer already created with ID: " + customerId);
    }

}
