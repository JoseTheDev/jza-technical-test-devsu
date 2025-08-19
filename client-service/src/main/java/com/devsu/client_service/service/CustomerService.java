package com.devsu.client_service.service;

import com.devsu.client_service.model.Customer;

import jakarta.validation.ValidationException;

public interface CustomerService {

    /**
     * Searches a customer by ID.
     *
     * @param customerId Customer ID
     * @return a {@code Customer} containing customer related information
     * @throws CustomerNotFoundException if customer with given ID does not exist
     */
    Customer searchCustomer(Long customerId);

    Customer searchCustomerByName(String name);

    /**
     * Creates a new customer.
     *
     * @param customer New customer information
     * @return a {@code Customer} with created customer
     * @throws ValidationException if provided customer data is invalid
     */
    Customer createCustomer(Customer customer);

    /**
     * Updates an existing customer.
     *
     * @param customerId Customer ID
     * @param customer Customer with updated information
     * @return a {@code Customer} with updated customer
     * @throws ValidationException if provided customer data is invalid
     * @throws CustomerNotFoundException if customer with given ID does not exist
     */
    Customer updateCustomer(Long customerId, Customer customer);

    /**
     * Deletes a customer.
     *
     * @param customerId Customer ID
     * @throws CustomerNotFoundException if customer with given ID does not exist
     */
    void deleteCustomer(Long customerId);

}
