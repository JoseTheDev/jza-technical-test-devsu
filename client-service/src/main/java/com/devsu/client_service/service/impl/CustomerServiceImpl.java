package com.devsu.client_service.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsu.client_service.exception.CustomerAlreadyCreatedException;
import com.devsu.client_service.exception.CustomerNotFoundException;
import com.devsu.client_service.mapper.CustomerMapper;
import com.devsu.client_service.model.Customer;
import com.devsu.client_service.repository.CustomerRepository;
import com.devsu.client_service.service.CustomerService;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public Customer searchCustomer(Long customerId) {
        return customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }
   
    @Override
    public Customer createCustomer(Customer customer) {
        if (customer.getAge() < 18) {
            throw new ValidationException("EL CLIENTE NO ES ADULTO");
        }

        customerRepository.findByIdentification(customer.getIdentification())
                .ifPresent(existing -> {
                    throw new CustomerAlreadyCreatedException(existing.getCustomerId());
                });

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        Customer created = customerRepository.save(customer);       
        Customer fromDB = customerRepository.findByIdentification(created.getIdentification())
                .orElseThrow(() -> new CustomerNotFoundException((created.getCustomerId())));

        return fromDB;
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer existingCustomer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        customerMapper.updateExisting(customer, existingCustomer);

        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        customerRepository.delete(customer);
    }

}
