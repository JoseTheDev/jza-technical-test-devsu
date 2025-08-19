package com.devsu.account_service.service.transaction.impl;

import org.springframework.stereotype.Service;

import com.devsu.account_service.model.dto.transaction.TransactionCreateRequestDTO;
import com.devsu.account_service.model.dto.transaction.TransactionManageResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionSearchResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionUpdateRequestDTO;
import com.devsu.account_service.service.transaction.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public TransactionSearchResponseDTO searchTransaction(Long transactionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchTransaction'");
    }

    @Override
    public TransactionManageResponseDTO createTransaction(TransactionCreateRequestDTO transactionDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTransaction'");
    }

    @Override
    public TransactionManageResponseDTO updateTransaction(Long transactionId,
            TransactionUpdateRequestDTO transactionDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTransaction'");
    }

}
