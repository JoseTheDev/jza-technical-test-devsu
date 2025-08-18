package com.devsu.client_service.model.dto;

import com.devsu.client_service.enums.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class PersonDTO {

    private String identification;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    private String address;

    private String phoneNumber;

}
