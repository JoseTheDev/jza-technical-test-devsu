package com.devsu.client_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.client_service.model.dto.CustomerCreateRequestDTO;
import com.devsu.client_service.model.dto.CustomerManageResponseDTO;
import com.devsu.client_service.model.dto.CustomerSearchResponseDTO;
import com.devsu.client_service.model.dto.CustomerUpdateRequestDTO;
import com.devsu.client_service.service.CustomerService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
@Validated
@Slf4j
public class CustomerController {

	private final CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<CustomerSearchResponseDTO> searchCustomer(
			@PathVariable @NotNull(message = "ID DE CLIENTE REQUERIDO") Long customerId) {

		log.info("Fetching customer with id: {}", customerId);

		CustomerSearchResponseDTO customer = customerService.searchCustomer(customerId);
		return ResponseEntity.ok(customer);
	}

	@PostMapping
	public ResponseEntity<CustomerManageResponseDTO> createCustomer(
			@RequestBody @Valid CustomerCreateRequestDTO requestDTO) {

		log.info("Creating customer");

		CustomerManageResponseDTO customer = customerService.createCustomer(requestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerManageResponseDTO> updateCustomer(
		    @RequestBody @Valid CustomerUpdateRequestDTO requestDTO,
			@PathVariable @NotNull(message = "ID DE CLIENTE REQUERIDO") Long customerId) {

		log.info("Updating customer with id: {}", customerId);

		CustomerManageResponseDTO customer = customerService.updateCustomer(requestDTO);
		return ResponseEntity.ok(customer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerManageResponseDTO> deleteCustomer(
			@PathVariable @NotNull(message = "ID DE CLIENTE REQUERIDO") Long customerId) {

		log.info("Deleting customer with id: {}", customerId);

		CustomerManageResponseDTO customer = customerService.deleteCustomer(customerId);
		return ResponseEntity.ok(customer);
	}

}
