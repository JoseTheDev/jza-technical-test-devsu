package com.devsu.account_service.model.dto.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionCreateRequestDTO {

    private LocalDateTime date;

    private String transactionType;

    private BigDecimal amount;

    private BigDecimal balance;

}
