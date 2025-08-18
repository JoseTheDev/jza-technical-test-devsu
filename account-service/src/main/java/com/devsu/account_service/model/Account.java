package com.devsu.account_service.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    private Integer accountNumber;

    private String accountType;

    private BigDecimal initialBalance;

    private Boolean status;

}
