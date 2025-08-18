package com.devsu.account_service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transaction {

    @Id
    private Long id;

    private LocalDateTime date;

    private String transactionType;

    private BigDecimal amount;

    private BigDecimal balance;

}
