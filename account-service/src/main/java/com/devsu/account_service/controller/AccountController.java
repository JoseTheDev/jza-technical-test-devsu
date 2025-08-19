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

import com.devsu.account_service.command.account.AccountCommand;
import com.devsu.account_service.model.dto.account.AccountCreateRequestDTO;
import com.devsu.account_service.model.dto.account.AccountManageResponseDTO;
import com.devsu.account_service.model.dto.account.AccountSearchResponseDTO;
import com.devsu.account_service.model.dto.account.AccountUpdateRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/cuentas")
@RequiredArgsConstructor
@Validated
@Slf4j
@Tag(name = "Cuentas", description = "Operaciones sobre cuentas")
public class AccountController {

    private final AccountCommand accountCommand;

    @GetMapping("/{accountNumber}")
	@Operation(summary = "Obtener una cuenta por numero")
	public ResponseEntity<AccountSearchResponseDTO> searchAccount(
			@PathVariable @NotNull(message = "NUMERO DE CUENTA REQUERIDO") Long accountNumber) {

		log.info("Fetching account with number: {}", accountNumber);

		AccountSearchResponseDTO account = accountCommand.searchAccount(accountNumber);
		return ResponseEntity.ok(account);
	}

	@PostMapping
	@Operation(summary = "Crear una cuenta")
	public ResponseEntity<AccountManageResponseDTO> createAccount(
			@RequestBody @Valid AccountCreateRequestDTO requestDTO) {

		log.info("Creating account");

		AccountManageResponseDTO account = accountCommand.createAccount(requestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(account);
	}

	@PutMapping("/{accountNumber}")
	@Operation(summary = "Actualizar una cuenta")
	public ResponseEntity<AccountManageResponseDTO> updateAccount(
		    @RequestBody @Valid AccountUpdateRequestDTO requestDTO,
			@PathVariable @NotNull(message = "NUMERO DE CUENTA REQUERIDO") Long accountNumber) {

		log.info("Updating account with number: {}", accountNumber);

		AccountManageResponseDTO account = accountCommand.updateAccount(accountNumber, requestDTO);
		return ResponseEntity.ok(account);
	}

}
