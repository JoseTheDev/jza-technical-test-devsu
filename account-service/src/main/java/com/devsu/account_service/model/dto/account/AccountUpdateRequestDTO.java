package com.devsu.account_service.model.dto.account;

import lombok.Data;

@Data
public class AccountUpdateRequestDTO {

    private String accountType;

    private Boolean status;

}
