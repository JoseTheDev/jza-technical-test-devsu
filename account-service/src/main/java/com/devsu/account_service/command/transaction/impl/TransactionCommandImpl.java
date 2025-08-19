package com.devsu.account_service.command.transaction.impl;

import org.springframework.stereotype.Component;

import com.devsu.account_service.command.transaction.TransactionCommand;
import com.devsu.account_service.mapper.TransactionMapper;
import com.devsu.account_service.model.Transaction;
import com.devsu.account_service.model.dto.transaction.TransactionCreateRequestDTO;
import com.devsu.account_service.model.dto.transaction.TransactionManageResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionSearchResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionUpdateRequestDTO;
import com.devsu.account_service.service.transaction.TransactionService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TransactionCommandImpl implements TransactionCommand {

    private final TransactionService transactionService;

    private final TransactionMapper mapper;

    @Override
    public TransactionSearchResponseDTO searchTransaction(Long transactionId) {
        TransactionSearchResponseDTO responseDTO = new TransactionSearchResponseDTO();

        Transaction transaction = transactionService.searchTransaction(transactionId);

        responseDTO.setTransaction(mapper.toDTO(transaction));
        responseDTO.setMessage("TRANSACCION ENCONTRADA!");

        return responseDTO;
    }

    @Override
    public TransactionManageResponseDTO createTransaction(TransactionCreateRequestDTO transactionDTO) {
        TransactionManageResponseDTO responseDTO = new TransactionManageResponseDTO();

        Transaction transaction = transactionService.createTransaction(mapper.toCreateEntity(transactionDTO));

        responseDTO.setTransaction(mapper.toDTO(transaction));
        responseDTO.setMessage("TRANSACCION CREADA!");

        return responseDTO;
    }

    @Override
    public TransactionManageResponseDTO updateTransaction(Long transactionId,
            TransactionUpdateRequestDTO transactionDTO) {
        TransactionManageResponseDTO responseDTO = new TransactionManageResponseDTO();

        Transaction transaction = transactionService.createTransaction(mapper.toUpdateEntity(transactionDTO));

        responseDTO.setTransaction(mapper.toDTO(transaction));
        responseDTO.setMessage("TRANSACCION ACTUALIZADA!");

        return responseDTO;
    }

}
