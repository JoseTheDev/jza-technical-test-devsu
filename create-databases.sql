CREATE DATABASE clientes_db;
CREATE DATABASE cuentas_db;

-- TABLA PERSONAS
CREATE TABLE IF NOT EXISTS personas (
    identificacion VARCHAR(50) NOT NULL,
    nombre VARCHAR(100),
    genero VARCHAR(1),
    edad INT,
    direccion VARCHAR(150),
    telefono VARCHAR(20),
    PRIMARY KEY (identificacion)
);

-- TABLA CLIENTES
CREATE TABLE IF NOT EXISTS clientes (
    identificacion VARCHAR(50) NOT NULL,
    id_cliente BIGINT AUTO_INCREMENT,
    contrasena VARCHAR(255),
    estado VARCHAR(5),
    PRIMARY KEY (identificacion),
    UNIQUE (id_cliente),
    CONSTRAINT fk_cliente_persona FOREIGN KEY (identificacion) REFERENCES persona (identificacion)
);