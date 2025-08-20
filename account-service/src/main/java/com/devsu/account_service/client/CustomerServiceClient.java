package com.devsu.account_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsu.account_service.model.dto.customer.CustomerSearchResponseDTO;

@FeignClient(name = "client-service", url = "http://client-service:8080/api/v1/clientes")
public interface CustomerServiceClient {
    
    @GetMapping("/by-name/{customerName}")
    CustomerSearchResponseDTO searchCustomerByName(@PathVariable String customerName);

    @GetMapping("/{customerId}")
    CustomerSearchResponseDTO searchCustomerById(@PathVariable Long customerId);

}
