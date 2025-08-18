package com.devsu.account_service.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(Long accountNumber) {
        super("Account not found with number: " + accountNumber);
    }

}
