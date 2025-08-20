package com.devsu.account_service.command.transaction.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.devsu.account_service.command.transaction.TransactionCommand;
import com.devsu.account_service.mapper.AccountMapper;
import com.devsu.account_service.mapper.TransactionMapper;
import com.devsu.account_service.model.Account;
import com.devsu.account_service.model.Transaction;
import com.devsu.account_service.model.dto.account.AccountReportDTO;
import com.devsu.account_service.model.dto.transaction.TransactionCreateRequestDTO;
import com.devsu.account_service.model.dto.transaction.TransactionManageResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionSearchResponseDTO;
import com.devsu.account_service.model.dto.transaction.TransactionUpdateRequestDTO;
import com.devsu.account_service.service.account.AccountService;
import com.devsu.account_service.service.transaction.TransactionService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TransactionCommandImpl implements TransactionCommand {

    private final TransactionService transactionService;

    private final AccountService accountService;

    private final TransactionMapper mapper;

    private final AccountMapper accountMapper;

    @Override
    public TransactionSearchResponseDTO searchTransaction(Long transactionId) {
        TransactionSearchResponseDTO responseDTO = new TransactionSearchResponseDTO();

        Transaction transaction = transactionService.searchTransaction(transactionId);

        responseDTO.setTransaction(mapper.toDTO(transaction));
        responseDTO.setMessage("TRANSACCION ENCONTRADA!");

        return responseDTO;
    }
    
    @Override
    public CompletableFuture<TransactionSearchResponseDTO> getAccountReport(Long customerId, LocalDateTime fromDate,
            LocalDateTime toDate) {
        CompletableFuture<List<Account>> accountsFuture = accountService.searchCustomerAccounts(customerId);

        CompletableFuture<List<Transaction>> transactionsFuture = accountsFuture
                .thenCompose(accounts -> transactionService.searchAccountsTransactions(
                        accounts.stream().map(ac -> ac.getAccountNumber()).toList(), fromDate, toDate));

        return accountsFuture.thenCombine(transactionsFuture,
                (accounts, transactions) -> {
                    TransactionSearchResponseDTO responseDTO = new TransactionSearchResponseDTO();
                    List<AccountReportDTO> accountReports = new ArrayList<>();

                    Map<Long, List<Transaction>> transactionsByAccount = transactions.stream()
                            .collect(Collectors.groupingBy(Transaction::getAccountNumber));

                    for (Account account : accounts) {
                        AccountReportDTO report = new AccountReportDTO();
                        List<Transaction> accountTransactions = transactionsByAccount.getOrDefault(account.getAccountNumber(), List.of());

                        BigDecimal totalTransactions = accountTransactions.stream()
                                                        .map(Transaction::getAmount)
                                                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                        report.setCurrentBalance(account.getInitialBalance().add(totalTransactions));
                        report.setAccount(accountMapper.toDTO(account));
                        report.setTransactions(mapper.toDTOs(accountTransactions));

                        accountReports.add(report);
                    }
                    
                    responseDTO.setAccountsReport(accountReports);
                    responseDTO.setMessage("REPORTE CREADO!");
                    
                    return responseDTO;
                });
    }

    @Override
    public TransactionManageResponseDTO createTransaction(TransactionCreateRequestDTO transactionDTO) {
        TransactionManageResponseDTO responseDTO = new TransactionManageResponseDTO();

        Transaction transaction = transactionService.createTransaction(mapper.toCreateEntity(transactionDTO));

        responseDTO.setTransaction(mapper.toDTO(transaction));
        responseDTO.setMessage("TRANSACCION CREADA!");

        return responseDTO;
    }

    @Override
    public TransactionManageResponseDTO updateTransaction(Long transactionId,
            TransactionUpdateRequestDTO transactionDTO) {
        TransactionManageResponseDTO responseDTO = new TransactionManageResponseDTO();

        Transaction transaction = transactionService.updateTransaction(transactionId, mapper.toUpdateEntity(transactionDTO));

        responseDTO.setTransaction(mapper.toDTO(transaction));
        responseDTO.setMessage("TRANSACCION ACTUALIZADA!");

        return responseDTO;
    }

}
