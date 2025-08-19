package com.devsu.account_service.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cuentas")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column(name = "numero_cuenta")
    private Long accountNumber;

    @Column(name = "tipo_cuenta")
    private String accountType;

    @Column(name = "saldo_inicial")
    private BigDecimal initialBalance;

    @Column(name = "id_cliente")
    private Long customerId;

    @Column(name = "nombre_cliente")
    private String customerName;

    @Column(name = "estado")
    private Boolean status = true;

}
