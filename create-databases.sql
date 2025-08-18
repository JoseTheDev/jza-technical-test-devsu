CREATE DATABASE IF NOT EXISTS clientes_db;
CREATE DATABASE IF NOT EXISTS cuentas_db;

-- SERVICIOS DE CLIENTE
USE clientes_db;

-- TABLA PERSONAS
CREATE TABLE IF NOT EXISTS personas (
    identificacion VARCHAR(50) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    genero VARCHAR(1) NOT NULL,
    edad INT,
    direccion VARCHAR(150) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    PRIMARY KEY (identificacion)
);

-- PARA BUSQUEDA POR NOMBRE
CREATE INDEX idx_personas_nombre ON personas (nombre);

-- TABLA CLIENTES
CREATE TABLE IF NOT EXISTS clientes (
    identificacion VARCHAR(50) NOT NULL,
    id_cliente BIGINT NOT NULL AUTO_INCREMENT,
    contrasena VARCHAR(255) NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (identificacion),
    UNIQUE (id_cliente),
    CONSTRAINT fk_cliente_persona FOREIGN KEY (identificacion) REFERENCES personas (identificacion)
);

-- PARA BUSQUEDA POR ID DE CLIENTE
CREATE INDEX idx_clientes_id_cliente ON clientes (id_cliente);


-- SERVICIOS DE CUENTAS
USE cuentas_db;

-- TABLA CUENTAS
CREATE TABLE IF NOT EXISTS cuentas (
    numero_cuenta BIGINT NOT NULL,
    tipo_cuenta VARCHAR(10) NOT NULL,
    saldo_inicial DECIMAL(15,2) NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (numero_cuenta)
);

-- TABLA MOVIMIENTOS
CREATE TABLE IF NOT EXISTS movimientos (
    id BIGINT NOT NULL AUTO_INCREMENT,
	fecha DATETIME NOT NULL,
    tipo_movimiento VARCHAR(100) NOT NULL,
	valor DECIMAL(15,2) NOT NULL,
	saldo DECIMAL(15,2) NOT NULL,
    PRIMARY KEY (id)
);