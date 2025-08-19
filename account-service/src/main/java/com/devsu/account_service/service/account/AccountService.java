package com.devsu.account_service.service.account;

import com.devsu.account_service.model.Account;

import jakarta.validation.ValidationException;

public interface AccountService {

    /**
     * Searches an account by number.
     *
     * @param accountNumber Account number
     * @return a {@code AccountSearchResponseDTO} containing account related information
     * @throws AccountNotFoundException if account with given number does not exist
     */
    Account searchAccount(Long accountNumber);

    /**
     * Creates a new account.
     *
     * @param accountDTO Account DTO containing account information
     * @return a {@code AccountManageResponseDTO} containing creation status and message
     * @throws ValidationException if provided account data is invalid
     */
    Account createAccount(Account account);

    /**
     * Updates an existing account.
     *
     * @param accountNumber Account number
     * @param accountDTO Account DTO containing updated information
     * @return a {@code AccountManageResponseDTO} containing update status and message
     * @throws ValidationException if provided account data is invalid
     * @throws AccountNotFoundException if account with given number does not exist
     */
    Account updateAccount(Long accountNumber, Account account);

}
