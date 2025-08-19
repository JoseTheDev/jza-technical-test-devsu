package com.devsu.account_service.service.transaction.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsu.account_service.exception.TransactionNotFoundException;
import com.devsu.account_service.mapper.TransactionMapper;
import com.devsu.account_service.model.Account;
import com.devsu.account_service.model.Transaction;
import com.devsu.account_service.repository.transaction.TransactionRepository;
import com.devsu.account_service.service.account.AccountService;
import com.devsu.account_service.service.transaction.TransactionService;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final TransactionMapper transactionMapper;

    private final AccountService accountService;

    @Override
    @Transactional(readOnly = true)
    public Transaction searchTransaction(Long transactionId) {
        return transactionRepository.findById(transactionId)
            .orElseThrow(() -> new TransactionNotFoundException(transactionId));
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        if (transaction.getAmount().compareTo(BigDecimal.valueOf(0)) == 0) {
            throw new ValidationException("EL MONTO DEBE TENER ALGUN VALOR, POSITIVO O NEGATIVO");
        }

        Optional<Transaction> lastTransaction = transactionRepository.findTopByAccountNumberOrderByDateDesc(transaction.getAccountNumber());
        Account account = new Account();

        if (lastTransaction.isEmpty()) {
            account = accountService.searchAccount(transaction.getAccountNumber());
        }

        BigDecimal previousBalance = lastTransaction.map(Transaction::getBalance).orElse(account.getInitialBalance());
        
        BigDecimal newBalance = transaction.getAmount().compareTo(BigDecimal.ZERO) > 0 ? previousBalance.add(transaction.getAmount()) 
                              : transaction.getAmount().compareTo(BigDecimal.ZERO) < 0 ? previousBalance.subtract(transaction.getAmount()) 
                              : previousBalance;
        
        transaction.setBalance(newBalance);

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Long transactionId, Transaction transaction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTransaction'");
    }

}
