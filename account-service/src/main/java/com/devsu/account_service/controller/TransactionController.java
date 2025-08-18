package com.devsu.account_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.account_service.model.dto.transaction.TransactionCreateRequestDTO;
import com.devsu.account_service.model.dto.transaction.TransactionManageResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionSearchResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionUpdateRequestDTO;
import com.devsu.account_service.service.transaction.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/movimientos")
@RequiredArgsConstructor
@Validated
@Slf4j
@Tag(name = "Movimientos API", description = "Operaciones sobre movimientos")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/{transactionId}")
	@Operation(summary = "Obtener un movimiento por ID")
	public ResponseEntity<TransactionSearchResponseDTO> searchTransaction(
			@PathVariable @NotNull(message = "ID DE TRANSACCION REQUERIDO") Long transactionId) {

		log.info("Fetching transaction with ID: {}", transactionId);

		TransactionSearchResponseDTO transaction = transactionService.searchTransaction(transactionId);
		return ResponseEntity.ok(transaction);
	}

	@PostMapping
	@Operation(summary = "Crear un movimiento")
	public ResponseEntity<TransactionManageResponseDTO> createTransaction(
			@RequestBody @Valid TransactionCreateRequestDTO requestDTO) {

		log.info("Creating transaction");

		TransactionManageResponseDTO transaction = transactionService.createTransaction(requestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
	}

	@PutMapping("/{transactionId}")
	@Operation(summary = "Actualizar un movimiento")
	public ResponseEntity<TransactionManageResponseDTO> updateTransaction(
		    @RequestBody @Valid TransactionUpdateRequestDTO requestDTO,
			@PathVariable @NotNull(message = "ID DE TRANSACCION REQUERIDO") Long transactionId) {

		log.info("Updating transaction with ID: {}", transactionId);

		TransactionManageResponseDTO transaction = transactionService.updateTransaction(transactionId, requestDTO);
		return ResponseEntity.ok(transaction);
	}

}
