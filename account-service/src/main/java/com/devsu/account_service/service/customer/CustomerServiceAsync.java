package com.devsu.account_service.service.customer;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.devsu.account_service.client.CustomerServiceClient;
import com.devsu.account_service.model.dto.customer.CustomerSearchResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceAsync {

    private final CustomerServiceClient customerServiceClient;

    @Async
    public CompletableFuture<CustomerSearchResponseDTO> getCustomerByNameAsync(String name) {
        CustomerSearchResponseDTO customer = customerServiceClient.searchCustomerByName(name);
        return CompletableFuture.completedFuture(customer);
    }

    @Async
    public CompletableFuture<CustomerSearchResponseDTO> getCustomerByIdAsync(Long id) {
        CustomerSearchResponseDTO customer = customerServiceClient.searchCustomerById(id);
        return CompletableFuture.completedFuture(customer);
    }

}
