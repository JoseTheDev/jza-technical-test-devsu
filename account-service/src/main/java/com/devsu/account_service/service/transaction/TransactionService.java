package com.devsu.account_service.service.transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.devsu.account_service.exception.TransactionNotFoundException;
import com.devsu.account_service.model.Transaction;

import jakarta.validation.ValidationException;

public interface TransactionService {

    /**
     * Searches an transaction by ID.
     *
     * @param transactionId Transaction ID
     * @return a {@code TransactionSearchResponseDTO} containing transaction related information
     * @throws TransactionNotFoundException if transaction with given ID does not exist
     */
    Transaction searchTransaction(Long transactionId);

    CompletableFuture<List<Transaction>> searchAccountsTransactions(List<Long> accountsNumber, LocalDateTime fromDate,
            LocalDateTime toDate);

    /**
     * Creates a new transaction.
     *
     * @param transactionDTO Transaction DTO containing transaction information
     * @return a {@code TransactionManageResponseDTO} containing creation status and message
     * @throws ValidationException if provided transaction data is invalid
     */
    Transaction createTransaction(Transaction transaction);

    /**
     * Updates an existing transaction.
     *
     * @param transactionId Transaction ID
     * @param transactionDTO Transaction DTO containing updated information
     * @return a {@code TransactionManageResponseDTO} containing update status and message
     * @throws ValidationException if provided transaction data is invalid
     * @throws TransactionNotFoundException if transaction with given ID does not exist
     */
    Transaction updateTransaction(Long transactionId, Transaction transaction);

}
