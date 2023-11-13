package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByUsername(String username);
}

