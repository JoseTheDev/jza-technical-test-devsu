package com.devsu.account_service.exception;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(String message) {
        super(message);
    }

    public TransactionNotFoundException(Long transactionId) {
        super("Transaction not found with ID: " + transactionId);
    }

}
