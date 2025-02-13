# Proyecto: Gestión de Empleados - Spring Boot

Este proyecto es una API REST para la gestión de empleados, desarrollada con **Spring Boot** siguiendo la **arquitectura hexagonal** y utilizando una base de datos en memoria **H2**. Incluye validaciones de entrada, documentación con Swagger y pruebas unitarias con JUnit y Mockito.

## Características

- **Spring Boot 3.x**
- **Base de datos en memoria H2**
- **Arquitectura Hexagonal**
- **Validaciones con `spring-boot-starter-validation`**
- **Swagger UI para documentación de la API**
- **Pruebas unitarias con JUnit 5 y Mockito**

---

## Detalles importantes

### 1. Ejecutar la aplicación
Puedes ejecutarlo de dos formas:

### **Desde IntelliJ IDEA**
1. Abre el proyecto en IntelliJ.
2. Ejecuta la clase principal: **`EmployeesApplication.java`**.

#### **Desde la línea de comandos**
```sh
mvn clean install
mvn spring-boot:run
```

### Consultar Swagger
Puedes entrar aqui:
[swagger](http://localhost:8081/swagger-ui/index.html#/Employee%20API/getAllEmployees)

### Entrar ala consola de H2
1. validar que JDBC URL sea igual a **`jdbc:h2:mem:testdb`**
2. Puedes entrar aqui:
[h2 console]( http://localhost:8081/h2-console)
