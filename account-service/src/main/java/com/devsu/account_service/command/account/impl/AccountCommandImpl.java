package com.devsu.account_service.command.account.impl;

import org.springframework.stereotype.Component;

import com.devsu.account_service.command.account.AccountCommand;
import com.devsu.account_service.mapper.AccountMapper;
import com.devsu.account_service.model.Account;
import com.devsu.account_service.model.dto.account.AccountCreateRequestDTO;
import com.devsu.account_service.model.dto.account.AccountManageResponseDTO;
import com.devsu.account_service.model.dto.account.AccountSearchResponseDTO;
import com.devsu.account_service.model.dto.account.AccountUpdateRequestDTO;
import com.devsu.account_service.service.account.AccountService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountCommandImpl implements AccountCommand {

    private final AccountService accountService;

    private final AccountMapper mapper;

    @Override
    public AccountSearchResponseDTO searchAccount(Long accountNumber) {
        AccountSearchResponseDTO responseDTO = new AccountSearchResponseDTO();

        Account account = accountService.searchAccount(accountNumber);
        
        responseDTO.setAccount(mapper.toDTO(account));
        responseDTO.setMessage("CUENTA ENCONTRADA!");

        return responseDTO;
    }

    @Override
    public AccountManageResponseDTO createAccount(AccountCreateRequestDTO accountDTO) {
        AccountManageResponseDTO responseDTO = new AccountManageResponseDTO();

        Account account = accountService.createAccount(mapper.toCreateEntity(accountDTO));

        responseDTO.setAccountDTO(mapper.toDTO(account));
        responseDTO.setMessage("CUENTA CREADA!");

        return responseDTO;
    }

    @Override
    public AccountManageResponseDTO updateAccount(Long accountNumber, AccountUpdateRequestDTO accountDTO) {
        AccountManageResponseDTO responseDTO = new AccountManageResponseDTO();

        Account account = accountService.createAccount(mapper.toUpdateEntity(accountDTO));

        responseDTO.setAccountDTO(mapper.toDTO(account));
        responseDTO.setMessage("CUENTA CREADA!");

        return responseDTO;
    }

}
