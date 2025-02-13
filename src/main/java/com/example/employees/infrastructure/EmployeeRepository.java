package com.example.employees.infrastructure;

import com.example.employees.domain.Employee;
import com.example.employees.domain.EmployeeRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryPort {
}
