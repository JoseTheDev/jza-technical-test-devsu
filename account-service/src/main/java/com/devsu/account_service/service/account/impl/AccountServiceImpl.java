package com.devsu.account_service.service.account.impl;

import org.springframework.stereotype.Service;

import com.devsu.account_service.model.dto.account.AccountCreateRequestDTO;
import com.devsu.account_service.model.dto.account.AccountManageResponseDTO;
import com.devsu.account_service.model.dto.account.AccountSearchResponseDTO;
import com.devsu.account_service.model.dto.account.AccountUpdateRequestDTO;
import com.devsu.account_service.service.account.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public AccountSearchResponseDTO searchAccount(Long accountNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAccount'");
    }

    @Override
    public AccountManageResponseDTO createAccount(AccountCreateRequestDTO accountDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }

    @Override
    public AccountManageResponseDTO updateAccount(Long accountNumber, AccountUpdateRequestDTO accountDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }

}
