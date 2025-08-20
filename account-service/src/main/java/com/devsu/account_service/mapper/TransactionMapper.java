package com.devsu.account_service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.devsu.account_service.model.Transaction;
import com.devsu.account_service.model.dto.transaction.TransactionCreateRequestDTO;
import com.devsu.account_service.model.dto.transaction.TransactionDTO;
import com.devsu.account_service.model.dto.transaction.TransactionUpdateRequestDTO;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TransactionMapper {

    TransactionDTO toDTO(Transaction account);

    List<TransactionDTO> toDTOs(List<Transaction> transactions);

    Transaction toCreateEntity(TransactionCreateRequestDTO requestDTO);

    Transaction toUpdateEntity(TransactionUpdateRequestDTO requestDTO);

    void updateExisting(Transaction updatedTransaction, @MappingTarget Transaction existingTransaction);
    
}
