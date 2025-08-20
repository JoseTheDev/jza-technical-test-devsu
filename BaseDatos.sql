CREATE DATABASE IF NOT EXISTS clientes_db;
CREATE DATABASE IF NOT EXISTS cuentas_db;

-- SERVICIOS DE CLIENTE
USE clientes_db;

-- TABLA PERSONAS
CREATE TABLE IF NOT EXISTS personas (
	id BIGINT NOT NULL AUTO_INCREMENT,
    identificacion VARCHAR(50) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    genero VARCHAR(1) NOT NULL,
    edad INT,
    direccion VARCHAR(150) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

-- TABLA CLIENTES
CREATE TABLE IF NOT EXISTS clientes (
    id BIGINT NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id),
    CONSTRAINT fk_cliente_persona FOREIGN KEY (id) REFERENCES personas (id)
);

-- INSERT PARA PRUEBA DE INTEGRACION
INSERT INTO personas (identificacion, nombre, genero, edad, direccion, telefono)
VALUES ('8-000-000', 'Integrador Karate', 'M', 18, 'Ciudad Karate, Panama', '6565-6767');

SET @persona_id = LAST_INSERT_ID();

INSERT INTO clientes (id, contrasena, estado)
VALUES (@persona_id, 'devsupassword', TRUE);


-- SERVICIOS DE CUENTAS
USE cuentas_db;

-- TABLA CUENTAS
CREATE TABLE IF NOT EXISTS cuentas (
    numero_cuenta BIGINT NOT NULL,
    tipo_cuenta VARCHAR(10) NOT NULL,
    saldo_inicial DECIMAL(15,2) NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
	id_cliente BIGINT NOT NULL,
	nombre_cliente VARCHAR(100) NOT NULL,
    PRIMARY KEY (numero_cuenta)
);

-- TABLA MOVIMIENTOS
CREATE TABLE IF NOT EXISTS movimientos (
    id BIGINT NOT NULL AUTO_INCREMENT,
	fecha DATETIME NOT NULL,
    tipo_movimiento VARCHAR(100) NOT NULL,
	numero_cuenta BIGINT NOT NULL,
	valor DECIMAL(15,2) NOT NULL,
	saldo DECIMAL(15,2) NOT NULL,
    PRIMARY KEY (id),
	CONSTRAINT fk_cuenta_movimiento FOREIGN KEY (numero_cuenta) REFERENCES cuentas (numero_cuenta)
);

-- INSERTS PARA PRUEBAS DE INTEGRACION

INSERT INTO cuentas(numero_cuenta, tipo_cuenta, saldo_inicial, id_cliente, nombre_cliente)
VALUES (4000, 'AHORROS', 1000, 1, 'Integrador Karate');

INSERT INTO movimientos(fecha, tipo_movimiento, numero_cuenta, saldo, valor)
VALUES ('2025-08-22T00:00:00', 'DEPOSITO 2000', 4000, 3000, 2000);