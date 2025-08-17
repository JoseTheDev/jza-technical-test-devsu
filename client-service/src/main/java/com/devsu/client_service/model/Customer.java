package com.devsu.client_service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends Person {

    // TODO: PK
    private Long customerId;

    private String password;

    private Boolean status;

}
