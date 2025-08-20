package com.devsu.account_service.service.transaction.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsu.account_service.exception.InsufficientFundsException;
import com.devsu.account_service.exception.TransactionNotFoundException;
import com.devsu.account_service.mapper.TransactionMapper;
import com.devsu.account_service.model.Transaction;
import com.devsu.account_service.repository.transaction.TransactionRepository;
import com.devsu.account_service.service.account.AccountService;
import com.devsu.account_service.service.transaction.TransactionService;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
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
        if (transaction.getAmount().compareTo(BigDecimal.ZERO) == 0) {
            throw new ValidationException("EL MONTO DEBE TENER ALGUN VALOR, POSITIVO O NEGATIVO");
        }

        BigDecimal previousBalance = getPreviousBalance(transaction.getAccountNumber());

        log.warn("ULTIMO BALANCE: " + previousBalance);

        BigDecimal amount = transaction.getAmount();

        if (isWithdrawal(amount) && hasInsufficientFunds(previousBalance, amount)) {
            throw new InsufficientFundsException();
        }

        transaction.setBalance(previousBalance.add(amount));
        return transactionRepository.save(transaction);
    }

    private BigDecimal getPreviousBalance(Long accountNumber) {
        return transactionRepository
            .findTopByAccountNumberOrderByDateDesc(accountNumber)
            .map(Transaction::getBalance)
            .orElseGet(() -> accountService.searchAccount(accountNumber).getInitialBalance());
    }

    private boolean isWithdrawal(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) < 0;
    }

    private boolean hasInsufficientFunds(BigDecimal balance, BigDecimal withdrawAmount) {
        return balance.add(withdrawAmount).compareTo(BigDecimal.ZERO) < 0;
    }

    @Override
    public Transaction updateTransaction(Long transactionId, Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException(transactionId));

        transactionMapper.updateExisting(transaction, existingTransaction);

        return transactionRepository.save(existingTransaction);
    }

}
