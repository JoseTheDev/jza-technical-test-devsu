package com.devsu.client_service.service;

import com.devsu.client_service.model.dto.CustomerCreateRequestDTO;
import com.devsu.client_service.model.dto.CustomerManageResponseDTO;
import com.devsu.client_service.model.dto.CustomerSearchResponseDTO;
import com.devsu.client_service.model.dto.CustomerUpdateRequestDTO;

import jakarta.validation.ValidationException;

public interface CustomerService {

    /**
     * Searches a customer by ID.
     *
     * @param customerId Customer ID
     * @return a {@code CustomerSearchResponseDTO} containing customer related information
     * @throws CustomerNotFoundException if customer with given ID does not exist
     */
    CustomerSearchResponseDTO searchCustomer(Long customerId);

    /**
     * Creates a new customer.
     *
     * @param customerDTO Customer DTO containing customer information
     * @return a {@code CustomerManageResponseDTO} containing creation status and message
     * @throws ValidationException if provided customer data is invalid
     */
    CustomerManageResponseDTO createCustomer(CustomerCreateRequestDTO customerDTO);

    /**
     * Updates an existing customer.
     *
     * @param customerDTO Customer DTO containing updated information
     * @return a {@code CustomerManageResponseDTO} containing update status and message
     * @throws ValidationException if provided customer data is invalid
     * @throws CustomerNotFoundException if customer with given ID does not exist
     */
    CustomerManageResponseDTO updateCustomer(CustomerUpdateRequestDTO customerDTO);

    /**
     * Deletes a customer.
     *
     * @param customerId Customer ID
     * @return a {@code CustomerManageResponseDTO} containing deletion status and message
     * @throws CustomerNotFoundException if customer with given ID does not exist
     */
    CustomerManageResponseDTO deleteCustomer(Long customerId);

}
