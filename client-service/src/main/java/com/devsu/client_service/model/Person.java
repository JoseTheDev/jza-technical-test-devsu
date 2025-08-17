package com.devsu.client_service.model;

import lombok.Data;

@Data
public class Person {

    // TODO: PK
    private Long id;

    private String name;

    private String gender;

    private Integer age;

    private String identification;

    private String address;

    private String phoneNumber;

}
