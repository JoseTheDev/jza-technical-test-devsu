package com.devsu.account_service.command.account;

import java.util.concurrent.CompletableFuture;

import com.devsu.account_service.model.dto.account.AccountCreateRequestDTO;
import com.devsu.account_service.model.dto.account.AccountManageResponseDTO;
import com.devsu.account_service.model.dto.account.AccountSearchResponseDTO;
import com.devsu.account_service.model.dto.account.AccountUpdateRequestDTO;

public interface AccountCommand {

    AccountSearchResponseDTO searchAccount(Long accountNumber);

    CompletableFuture<AccountManageResponseDTO> createAccount(AccountCreateRequestDTO accountDTO);

    AccountManageResponseDTO updateAccount(Long accountNumber, AccountUpdateRequestDTO accountDTO);

}
