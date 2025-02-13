package com.example.employees.infrastructure;

import com.example.employees.application.EmployeeService;
import com.example.employees.domain.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee API", description = "CRUD operations for employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Get all employees")
    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("Solicitud para obtener todos los empleados");
        return employeeService.getAllEmployees();
    }

    @Operation(summary = "Get an employee by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        log.info("Solicitud para obtener empleado con ID: {}", id);
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @Operation(summary = "Create a new employee")
    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        log.info("Solicitud para crear empleado: {}", employee);
        return employeeService.createOrUpdateEmployee(employee);
    }

    @Operation(summary = "Update an existing employee")
    @PutMapping
    public Employee updateEmployee(@Valid @RequestBody Employee employee) {
        log.info("Solicitud para actualizar empleado: {}", employee);
        return employeeService.createOrUpdateEmployee(employee);
    }

    @Operation(summary = "Delete an employee by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        log.warn("Solicitud para eliminar empleado con ID: {}", id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
