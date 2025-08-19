package com.devsu.account_service.model.dto.customer;

import lombok.Data;

@Data
public class CustomerDTO {
    
    private Long id;

    private String identification;

    private String name;

    private String gender;

    private Integer age;

    private String address;

    private String phoneNumber;

    private Boolean status;

}
