package com.devsu.account_service.service.account.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsu.account_service.exception.AccountAlreadyCreatedException;
import com.devsu.account_service.exception.AccountNotFoundException;
import com.devsu.account_service.mapper.AccountMapper;
import com.devsu.account_service.model.Account;
import com.devsu.account_service.repository.account.AccountRepository;
import com.devsu.account_service.service.account.AccountService;
import com.devsu.account_service.service.customer.CustomerServiceAsync;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    
    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    private final CustomerServiceAsync customerServiceAsync;

    @Override
    @Transactional(readOnly = true)
    public Account searchAccount(Long accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));
    }

    @Override
    public CompletableFuture<List<Account>> searchCustomerAccounts(Long customerId) {
       return customerServiceAsync.getCustomerByIdAsync(customerId)
            .thenApply(customerDTO -> {
                if (customerDTO == null) {
                    throw new ValidationException("EL CLIENTE NO EXISTE");
                }

                return accountRepository.findAllByCustomerId(customerId);
            });
    }

    @Override
    public CompletableFuture<Account> createAccount(Account account) {        
        accountRepository.findByAccountNumber(account.getAccountNumber())
                .ifPresent(existing -> {
                    throw new AccountAlreadyCreatedException(existing.getAccountNumber());
                });

        return customerServiceAsync.getCustomerByNameAsync(account.getCustomerName())
            .thenApply(customerDTO -> {
                if (customerDTO == null) {
                    throw new ValidationException("EL CLIENTE NO EXISTE");
                }

                account.setCustomerId(customerDTO.getCustomer().getId());
                return accountRepository.save(account);
            });
    }

    @Override
    public Account updateAccount(Long accountNumber, Account account) {
        Account existingAccount = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));

        accountMapper.updateExisting(account, existingAccount);

        return accountRepository.save(existingAccount);
    }

}
