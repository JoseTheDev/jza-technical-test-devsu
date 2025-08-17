package com.devsu.client_service.model.dto;

import com.devsu.client_service.enums.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class PersonDTO {

    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    private String identification;

    private String address;

    private String phoneNumber;

}
