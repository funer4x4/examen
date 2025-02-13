package com.example.employees.domain;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepositoryPort {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    void deleteById(Long id);
}
