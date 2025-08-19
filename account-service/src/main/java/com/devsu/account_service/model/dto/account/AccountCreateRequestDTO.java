package com.devsu.account_service.model.dto.account;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountCreateRequestDTO {

    private Long accountNumber;

    private String accountType;

    private String customerName;

    private BigDecimal initialBalance;

}
