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
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }
    
    @Override
    @Transactional(readOnly = true)
    public Customer searchCustomerByName(String name) {
        return customerRepository.findTopByName(name)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente no encontrado con nombre: " + name));
    }
   
    @Override
    public Customer createCustomer(Customer customer) {
        if (customer.getAge() < 18) {
            throw new ValidationException("EL CLIENTE NO ES ADULTO");
        }

        customerRepository.findByIdentification(customer.getIdentification())
                .ifPresent(existing -> {
                    throw new CustomerAlreadyCreatedException(existing.getId());
                });

        customer.setPassword(passwordEncoder.encode(customer.getPassword())); 
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        customerMapper.updateExisting(customer, existingCustomer);

        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        customerRepository.delete(customer);
    }

}
