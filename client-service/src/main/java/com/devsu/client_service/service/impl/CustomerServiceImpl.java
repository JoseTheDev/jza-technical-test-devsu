package com.devsu.client_service.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsu.client_service.exception.CustomerNotFoundException;
import com.devsu.client_service.mapper.CustomerMapper;
import com.devsu.client_service.model.Customer;
import com.devsu.client_service.repository.CustomerRepository;
import com.devsu.client_service.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    @Transactional(readOnly = true)
    public Customer searchCustomer(Long customerId) {
        return customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }
   
    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        return customerRepository.findByIdentification(customer.getIdentification())
                .orElseGet(() -> customerRepository.save(customer));
    }

    @Override
    @Transactional
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer existingCustomer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        customerMapper.updateExisting(customer, existingCustomer);

        return customerRepository.save(existingCustomer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        customerRepository.delete(customer);
    }

}
