package com.example.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.models.Employee;
import com.example.library.repositories.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        // findById returns an Optional<Employee>
        return employeeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        // Save the new employee to the database
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        // Check if the employee with the given ID exists
        return employeeRepository.findById(id)
                .map(employee -> {
                    // Set the ID of the updated employee
                    updatedEmployee.setId(id);
                    // Save the updated employee to the database
                    return employeeRepository.save(updatedEmployee);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        // Delete the employee with the given ID from the database
        employeeRepository.deleteById(id);
    }
}
