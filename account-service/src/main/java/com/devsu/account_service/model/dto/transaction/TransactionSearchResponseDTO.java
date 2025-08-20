package com.devsu.account_service.model.dto.transaction;

import java.util.List;

import com.devsu.account_service.model.dto.account.AccountReportDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionSearchResponseDTO {

    private TransactionDTO transaction;

    private List<AccountReportDTO> accountsReport;

    private String message;

}
