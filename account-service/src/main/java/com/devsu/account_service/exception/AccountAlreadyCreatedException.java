package com.devsu.account_service.exception;

public class AccountAlreadyCreatedException extends RuntimeException {

    public AccountAlreadyCreatedException(String message) {
        super(message);
    }

    public AccountAlreadyCreatedException(Long accountNumber) {
        super("Account already created with number: " + accountNumber);
    }
    
}
