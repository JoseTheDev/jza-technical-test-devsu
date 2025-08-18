package com.devsu.client_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "personas")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @Column(name = "identificacion", length = 20)
    private String identification;

    @Column(name = "nombre", nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false, length = 1)
    private String gender;

    @Column(name = "edad")
    private Integer age;

    @Column(name = "direccion", length = 100)
    private String address;

    @Column(name = "telefono", length = 20)
    private String phoneNumber;

}
