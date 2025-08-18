package com.devsu.client_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devsu.client_service.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM clientes c WHERE c.id_cliente = :customerId")
    Optional<Customer> findByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT c FROM clientes c WHERE c.identificacion = :identification")
    Optional<Customer> findByIdenfication(@Param("identification") String identification);

}
