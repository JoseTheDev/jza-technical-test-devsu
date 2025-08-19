package com.devsu.client_service.model.dto;

import com.devsu.client_service.enums.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO {

    private String identification;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    private String address;

    private String phoneNumber;

}
