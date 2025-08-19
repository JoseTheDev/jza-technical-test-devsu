package com.devsu.account_service.model.dto.account;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountDTO {

    private Long accountNumber;

    private String accountType;

    private BigDecimal initialBalance;

    private Boolean status;

}
