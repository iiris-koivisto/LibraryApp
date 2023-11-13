package com.example.library.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.library.models.Employee;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        // Find the employee with the given ID
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        // Return null if no employee found with the given ID
        return null;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        // Assign a unique ID (you might want to use a more sophisticated ID generation strategy)
        int nextId = employeeList.size() + 1;
        employee.setId(nextId);

        // Add the new employee to the list
        employeeList.add(employee);

        // Return the newly added employee
        return employee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        // Find the employee with the given ID
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                // Update the employee details
                employee.setName(updatedEmployee.getName());
                employee.setUsername(updatedEmployee.getUsername());
                employee.setPassword(updatedEmployee.getPassword());

                // Return the updated employee
                return employee;
            }
        }
        // Return null if no employee found with the given ID
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeList.removeIf(employee -> employee.getId() == id);
    }
}
