package com.devsu.account_service.command.transaction;

import com.devsu.account_service.model.dto.transaction.TransactionCreateRequestDTO;
import com.devsu.account_service.model.dto.transaction.TransactionManageResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionSearchResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionUpdateRequestDTO;

public interface TransactionCommand {

    TransactionSearchResponseDTO searchTransaction(Long transactionId);

    TransactionManageResponseDTO createTransaction(TransactionCreateRequestDTO transactionDTO);

    TransactionManageResponseDTO updateTransaction(Long transactionId, TransactionUpdateRequestDTO transactionDTO);

}
