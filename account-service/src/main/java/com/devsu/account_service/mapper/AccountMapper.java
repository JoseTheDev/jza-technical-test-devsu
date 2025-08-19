package com.devsu.account_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.devsu.account_service.model.Account;
import com.devsu.account_service.model.dto.account.AccountCreateRequestDTO;
import com.devsu.account_service.model.dto.account.AccountDTO;
import com.devsu.account_service.model.dto.account.AccountUpdateRequestDTO;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountMapper {
    
    AccountDTO toDTO(Account account);

    Account toCreateEntity(AccountCreateRequestDTO requestDTO);

    Account toUpdateEntity(AccountUpdateRequestDTO requestDTO);

    void updateExisting(Account updatedAccount, @MappingTarget Account existingAccount);

}
