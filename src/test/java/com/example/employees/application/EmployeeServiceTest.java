package com.example.employees.application;

import com.example.employees.domain.Employee;
import com.example.employees.domain.EmployeeRepositoryPort;
import com.example.employees.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepositoryPort employeeRepositoryPort;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee(1L, "Juan", "Carlos", "Perez", "Gonzalez", 30, "Masculino", LocalDate.of(1993, 5, 20), "Desarrollador");
    }

    @Test
    void getAllEmployees_ShouldReturnEmployeeList() {
        when(employeeRepositoryPort.findAll()).thenReturn(List.of(employee));
        List<Employee> employees = employeeService.getAllEmployees();
        assertFalse(employees.isEmpty());
        assertEquals(1, employees.size());
    }

    @Test
    void getEmployeeById_ShouldReturnEmployee() {
        when(employeeRepositoryPort.findById(1L)).thenReturn(Optional.of(employee));
        Employee foundEmployee = employeeService.getEmployeeById(1L);
        assertNotNull(foundEmployee);
        assertEquals("Juan", foundEmployee.getFirstName());
    }

    @Test
    void getEmployeeById_ShouldThrowException_WhenNotFound() {
        when(employeeRepositoryPort.findById(2L)).thenReturn(Optional.empty());
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.getEmployeeById(2L));
    }

    @Test
    void createOrUpdateEmployee_ShouldSaveEmployee() {
        when(employeeRepositoryPort.save(any(Employee.class))).thenReturn(employee);
        Employee savedEmployee = employeeService.createOrUpdateEmployee(employee);
        assertNotNull(savedEmployee);
        assertEquals("Juan", savedEmployee.getFirstName());
    }
}
