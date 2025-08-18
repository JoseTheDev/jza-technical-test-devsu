package com.devsu.client_service.command;

import com.devsu.client_service.model.dto.CustomerCreateRequestDTO;
import com.devsu.client_service.model.dto.CustomerManageResponseDTO;
import com.devsu.client_service.model.dto.CustomerSearchResponseDTO;
import com.devsu.client_service.model.dto.CustomerUpdateRequestDTO;

public interface CustomerCommand {

    CustomerSearchResponseDTO searchCustomer(Long customerId);

    CustomerManageResponseDTO createCustomer(CustomerCreateRequestDTO customerDTO);

    CustomerManageResponseDTO updateCustomer(Long customerId, CustomerUpdateRequestDTO customerDTO);

    CustomerManageResponseDTO deleteCustomer(Long customerId);

}
