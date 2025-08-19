package com.devsu.account_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsu.account_service.model.dto.customer.CustomerSearchResponseDTO;

@FeignClient(name = "client-service", url = "http://localhost:8081/api/v1")
public interface CustomerServiceClient {
    
    @GetMapping("/clientes/{customerName}")
    CustomerSearchResponseDTO searchCustomerByName(@PathVariable String customerName);

}
