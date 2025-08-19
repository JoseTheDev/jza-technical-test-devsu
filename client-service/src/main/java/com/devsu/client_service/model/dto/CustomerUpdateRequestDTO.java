package com.devsu.client_service.model.dto;

import com.devsu.client_service.enums.Gender;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CustomerUpdateRequestDTO {

    private String name;

    private Gender gender;

    @Positive(message = "LA EDAD DEBE SER UN VALOR POSITIVO")
    private Integer age;

    private String identification;

    private String address;

    private String phoneNumber;

    private Boolean status;

    private String password;

}
