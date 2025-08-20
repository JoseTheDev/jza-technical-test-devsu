package com.devsu.account_service.model.dto.account;

import java.math.BigDecimal;
import java.util.List;

import com.devsu.account_service.model.dto.transaction.TransactionDTO;

import lombok.Data;

@Data
public class AccountReportDTO {

    private AccountDTO account;

    private BigDecimal currentBalance;

    private List<TransactionDTO> transactions;

}
