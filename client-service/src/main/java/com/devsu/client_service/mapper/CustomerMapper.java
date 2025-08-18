package com.devsu.client_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.devsu.client_service.model.Customer;
import com.devsu.client_service.model.dto.CustomerCreateRequestDTO;
import com.devsu.client_service.model.dto.CustomerDTO;
import com.devsu.client_service.model.dto.CustomerUpdateRequestDTO;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {

    CustomerDTO toDto(Customer customer);

    Customer toCreateEntity(CustomerCreateRequestDTO dto);

    Customer toUpdateEntity(CustomerUpdateRequestDTO dto);

    void updateExisting(Customer updatedCustomer, @MappingTarget Customer existingCustomer);

}
