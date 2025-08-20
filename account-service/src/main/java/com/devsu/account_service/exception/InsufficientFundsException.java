package com.devsu.account_service.exception;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException() {
        super("Saldo no disponible");
    }

}
