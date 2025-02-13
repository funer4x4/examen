package com.example.employees.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Empleado con ID " + id + " no encontrado");
    }
}