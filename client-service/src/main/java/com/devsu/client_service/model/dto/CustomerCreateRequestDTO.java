package com.devsu.client_service.model.dto;

import com.devsu.client_service.enums.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CustomerCreateRequestDTO {

    @NotBlank(message = "DEBE SUMINISTRAR EL NOMBRE")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "DEBE SUMINISTRAR EL GENERO")
    private Gender gender;

    @NotNull(message = "DEBE SUMINISTRAR LA EDAD")
    @Positive(message = "LA EDAD DEBE SER UN VALOR POSITIVO")
    private Integer age;

    @NotBlank(message = "DEBE SUMINISTRAR LA IDENTIFICACION PERSONAL")
    private String identification;

    @NotBlank(message = "DEBE SUMINISTRAR UNA DIRECCION")
    private String address;

    @NotBlank(message = "DEBE SUMINISTRAR UN NUMERO DE TELEFONO")
    private String phoneNumber;

    @NotBlank(message = "DEBE SUMINISTRAR UNA CONTRASEÑA")
    private String password;

}
