# Prueba Técnica Devsu Java

Este proyecto contiene los microservicios `account-service` y `client-service`. A continuación se detallan los pasos para construir, levantar y detener los servicios usando **Maven** y **Docker Compose**.

---

## Requisitos

- Java 21  
- Maven 3.8+  
- Docker & Docker Compose  

---

## Construcción de los servicios

Antes de levantar los contenedores, compilar los servicios:

```bash
# Construir account-service
mvn clean package -DskipTests -f account-service/pom.xml

# Construir client-service
mvn clean package -DskipTests -f client-service/pom.xml
```

> Se omiten las pruebas para agilizar la compilación (`-DskipTests`).

## Levantar los servicios con Docker

Para construir las imágenes y levantar los contenedores en segundo plano:

```bash
docker-compose up --build -d
```

* --build fuerza la reconstrucción de las imágenes.

* -d ejecuta los contenedores en modo “detached” (en segundo plano).

## Rutas disponibles

Las rutas de los servicios son los siguientes:

* client-service: http://localhost:8081/api/v1
* account-service: http://localhost:8082/api/v1


## Detener y limpiar contenedores

Para detener los servicios y eliminar volúmenes asociados:

```bash
docker-compose down -v
```

---

## Notas

* Los servicios estarán listos para recibir solicitudes después de levantar los contenedores.
* 
