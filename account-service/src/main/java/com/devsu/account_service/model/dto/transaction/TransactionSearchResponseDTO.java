package com.devsu.account_service.model.dto.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionSearchResponseDTO {

    private TransactionDTO transaction;

    private TransactionReportDTO report;

    private String message;

}
