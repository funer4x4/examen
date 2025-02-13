package com.example.employees.application;

import com.example.employees.domain.Employee;
import com.example.employees.domain.EmployeeRepositoryPort;
import com.example.employees.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepositoryPort employeeRepositoryPort;

    public List<Employee> getAllEmployees() {
        log.info("Obteniendo todos los empleados");
        return employeeRepositoryPort.findAll();
    }

    public Employee getEmployeeById(Long id) {
        log.info("Buscando empleado con ID: {}", id);
        return employeeRepositoryPort.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee createOrUpdateEmployee(Employee employee) {
        log.info("Guardando empleado: {}", employee);
        return employeeRepositoryPort.save(employee);
    }

    public void deleteEmployee(Long id) {
        log.warn("Eliminando empleado con ID: {}", id);
        if (!employeeRepositoryPort.findById(id).isPresent()) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepositoryPort.deleteById(id);
    }
}
