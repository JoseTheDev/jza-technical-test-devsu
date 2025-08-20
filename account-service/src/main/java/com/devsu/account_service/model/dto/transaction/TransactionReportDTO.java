package com.devsu.account_service.model.dto.transaction;

import java.util.List;

import com.devsu.account_service.model.dto.account.AccountDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionReportDTO {

    private List<AccountDTO> accounts;

    private List<TransactionDTO> transactions;

}
