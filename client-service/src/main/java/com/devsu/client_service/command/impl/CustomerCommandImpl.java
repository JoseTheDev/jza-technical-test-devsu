package com.devsu.client_service.command.impl;

import org.springframework.stereotype.Component;

import com.devsu.client_service.command.CustomerCommand;
import com.devsu.client_service.mapper.CustomerMapper;
import com.devsu.client_service.model.Customer;
import com.devsu.client_service.model.dto.CustomerCreateRequestDTO;
import com.devsu.client_service.model.dto.CustomerManageResponseDTO;
import com.devsu.client_service.model.dto.CustomerSearchResponseDTO;
import com.devsu.client_service.model.dto.CustomerUpdateRequestDTO;
import com.devsu.client_service.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerCommandImpl implements CustomerCommand {

    private final CustomerService customerService;

    private final CustomerMapper mapper;

    @Override
    public CustomerSearchResponseDTO searchCustomer(Long customerId) {
        CustomerSearchResponseDTO responseDTO = new CustomerSearchResponseDTO();

        Customer customer = customerService.searchCustomer(customerId);

        responseDTO.setCustomer(mapper.toDto(customer));
        responseDTO.setMessage("CLIENTE ENCONTRADO!");

        return responseDTO;
    }

    @Override
    public CustomerSearchResponseDTO searchCustomerByName(String name) {
        CustomerSearchResponseDTO responseDTO = new CustomerSearchResponseDTO();

        Customer customer = customerService.searchCustomerByName(name);

        responseDTO.setCustomer(mapper.toDto(customer));
        responseDTO.setMessage("CLIENTE ENCONTRADO!");

        return responseDTO;
    }

    @Override
    public CustomerManageResponseDTO createCustomer(CustomerCreateRequestDTO customerDTO) {
        CustomerManageResponseDTO responseDTO = new CustomerManageResponseDTO();

        Customer customer = customerService.createCustomer(mapper.toCreateEntity(customerDTO));

        responseDTO.setCustomer(mapper.toDto(customer));
        responseDTO.setMessage("CLIENTE CREADO!");

        return responseDTO;
    }

    @Override
    public CustomerManageResponseDTO updateCustomer(Long customerId, CustomerUpdateRequestDTO customerDTO) {
        CustomerManageResponseDTO responseDTO = new CustomerManageResponseDTO();

        Customer customer = customerService.updateCustomer(customerId, mapper.toUpdateEntity(customerDTO));

        responseDTO.setCustomer(mapper.toDto(customer));
        responseDTO.setMessage("CLIENTE ACTUALIZADO!");

        return responseDTO;
    }

    @Override
    public CustomerManageResponseDTO deleteCustomer(Long customerId) {
        CustomerManageResponseDTO responseDTO = new CustomerManageResponseDTO();

        customerService.deleteCustomer(customerId);
        responseDTO.setMessage("CLIENTE ELIMINADO!");

        return responseDTO;
    }

}
