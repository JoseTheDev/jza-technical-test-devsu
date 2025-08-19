package com.devsu.account_service.service.account.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsu.account_service.exception.AccountAlreadyCreatedException;
import com.devsu.account_service.exception.AccountNotFoundException;
import com.devsu.account_service.mapper.AccountMapper;
import com.devsu.account_service.model.Account;
import com.devsu.account_service.repository.account.AccountRepository;
import com.devsu.account_service.service.account.AccountService;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    
    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Override
    @Transactional(readOnly = true)
    public Account searchAccount(Long accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));
    }

    @Override
    public Account createAccount(Account account) {        
        accountRepository.findByAccountNumber(account.getAccountNumber())
                .ifPresent(existing -> {
                    throw new AccountAlreadyCreatedException(existing.getAccountNumber());
                });

        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long accountNumber, Account account) {
        Account existingAccount = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));

        accountMapper.updateExisting(account, existingAccount);

        return accountRepository.save(existingAccount);
    }

}
