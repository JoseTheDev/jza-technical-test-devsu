package com.devsu.client_service.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerDTO extends PersonDTO {

    private Long customerId;
    
    private Boolean status;

}
