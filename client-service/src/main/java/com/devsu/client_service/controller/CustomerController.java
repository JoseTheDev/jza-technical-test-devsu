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

import com.devsu.client_service.command.CustomerCommand;
import com.devsu.client_service.model.dto.CustomerCreateRequestDTO;
import com.devsu.client_service.model.dto.CustomerManageResponseDTO;
import com.devsu.client_service.model.dto.CustomerSearchResponseDTO;
import com.devsu.client_service.model.dto.CustomerUpdateRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
@Validated
@Slf4j
@Tag(name = "Clientes", description = "Operaciones sobre clientes")
public class CustomerController {

	private final CustomerCommand customerCommand;

	@GetMapping("/{customerId}")
	@Operation(summary = "Obtener un cliente por ID")
	public ResponseEntity<CustomerSearchResponseDTO> searchCustomer(
			@PathVariable @NotNull(message = "ID DE CLIENTE REQUERIDO") Long customerId) {

		log.info("Fetching customer with ID: {}", customerId);

		CustomerSearchResponseDTO customer = customerCommand.searchCustomer(customerId);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping("by-name/{customerName}")
	@Operation(summary = "Obtener un cliente por nombre")
	public ResponseEntity<CustomerSearchResponseDTO> searchCustomerByName(
			@PathVariable @NotNull(message = "NOMBRE DEL CLIENTE REQUERIDO") String customerName) {

		log.info("Fetching customer with name: {}", customerName);

		CustomerSearchResponseDTO customer = customerCommand.searchCustomerByName(customerName);
		return ResponseEntity.ok(customer);
	}

	@PostMapping
	@Operation(summary = "Crear un cliente")
	public ResponseEntity<CustomerManageResponseDTO> createCustomer(
			@RequestBody @Valid CustomerCreateRequestDTO requestDTO) {

		log.info("Creating customer");

		CustomerManageResponseDTO customer = customerCommand.createCustomer(requestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}

	@PutMapping("/{customerId}")
	@Operation(summary = "Actualizar un cliente")
	public ResponseEntity<CustomerManageResponseDTO> updateCustomer(
		    @RequestBody @Valid CustomerUpdateRequestDTO requestDTO,
			@PathVariable @NotNull(message = "ID DE CLIENTE REQUERIDO") Long customerId) {

		log.info("Updating customer with ID: {}", customerId);

		CustomerManageResponseDTO customer = customerCommand.updateCustomer(customerId, requestDTO);
		return ResponseEntity.ok(customer);
	}

	@DeleteMapping("/{customerId}")
	@Operation(summary = "Eliminar un cliente")
	public ResponseEntity<CustomerManageResponseDTO> deleteCustomer(
			@PathVariable @NotNull(message = "ID DE CLIENTE REQUERIDO") Long customerId) {

		log.info("Deleting customer with ID: {}", customerId);

		CustomerManageResponseDTO customer = customerCommand.deleteCustomer(customerId);
		return ResponseEntity.ok(customer);
	}

}
