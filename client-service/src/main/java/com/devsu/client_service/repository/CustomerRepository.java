package com.devsu.client_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.client_service.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
