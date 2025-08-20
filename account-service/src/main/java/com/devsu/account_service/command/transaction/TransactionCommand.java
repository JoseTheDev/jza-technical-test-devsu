package com.devsu.account_service.command.transaction;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import com.devsu.account_service.model.dto.transaction.TransactionCreateRequestDTO;
import com.devsu.account_service.model.dto.transaction.TransactionManageResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionSearchResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionUpdateRequestDTO;

public interface TransactionCommand {

    TransactionSearchResponseDTO searchTransaction(Long transactionId);

    CompletableFuture<TransactionSearchResponseDTO> getAccountReport(Long customerId, LocalDateTime fromDate,
            LocalDateTime toDate);

    TransactionManageResponseDTO createTransaction(TransactionCreateRequestDTO transactionDTO);

    TransactionManageResponseDTO updateTransaction(Long transactionId, TransactionUpdateRequestDTO transactionDTO);

}
