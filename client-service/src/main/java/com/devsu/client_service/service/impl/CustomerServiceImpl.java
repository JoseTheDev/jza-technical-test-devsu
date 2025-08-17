package com.devsu.client_service.service.impl;

import com.devsu.client_service.model.dto.CustomerCreateRequestDTO;
import com.devsu.client_service.model.dto.CustomerManageResponseDTO;
import com.devsu.client_service.model.dto.CustomerSearchResponseDTO;
import com.devsu.client_service.model.dto.CustomerUpdateRequestDTO;
import com.devsu.client_service.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerSearchResponseDTO searchCustomer(Long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchCustomer'");
    }

    @Override
    public CustomerManageResponseDTO createCustomer(CustomerCreateRequestDTO customerDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCustomer'");
    }

    @Override
    public CustomerManageResponseDTO updateCustomer(CustomerUpdateRequestDTO customerDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
    }

    @Override
    public CustomerManageResponseDTO deleteCustomer(Long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
    }

}
