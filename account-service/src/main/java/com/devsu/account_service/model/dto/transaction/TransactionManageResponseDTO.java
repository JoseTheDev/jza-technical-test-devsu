package com.devsu.account_service.model.dto.transaction;

import lombok.Data;

@Data
public class TransactionManageResponseDTO {

    TransactionDTO transaction;

    String message;

}
