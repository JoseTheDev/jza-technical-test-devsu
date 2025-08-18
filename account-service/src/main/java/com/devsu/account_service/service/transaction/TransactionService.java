package com.devsu.account_service.service.transaction;

import com.devsu.account_service.model.dto.transaction.TransactionCreateRequestDTO;
import com.devsu.account_service.model.dto.transaction.TransactionManageResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionSearchResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionUpdateRequestDTO;

import jakarta.validation.ValidationException;

public interface TransactionService {

    /**
     * Searches an transaction by ID.
     *
     * @param transactionId Transaction ID
     * @return a {@code TransactionSearchResponseDTO} containing transaction related information
     * @throws TransactionNotFoundException if transaction with given ID does not exist
     */
    TransactionSearchResponseDTO searchTransaction(Long transactionId);

    /**
     * Creates a new transaction.
     *
     * @param transactionDTO Transaction DTO containing transaction information
     * @return a {@code TransactionManageResponseDTO} containing creation status and message
     * @throws ValidationException if provided transaction data is invalid
     */
    TransactionManageResponseDTO createTransaction(TransactionCreateRequestDTO transactionDTO);

    /**
     * Updates an existing transaction.
     *
     * @param transactionId Transaction ID
     * @param transactionDTO Transaction DTO containing updated information
     * @return a {@code TransactionManageResponseDTO} containing update status and message
     * @throws ValidationException if provided transaction data is invalid
     * @throws TransactionNotFoundException if transaction with given ID does not exist
     */
    TransactionManageResponseDTO updateTransaction(Long transactionId, TransactionUpdateRequestDTO transactionDTO);

}
