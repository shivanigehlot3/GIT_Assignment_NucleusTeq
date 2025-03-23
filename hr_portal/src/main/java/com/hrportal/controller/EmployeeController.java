package com.hrportal.controller;

import com.hrportal.model.Employee;
import com.hrportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        logger.info("Fetching employee with ID: {}", id);
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(employee.getId());
        
        if (existingEmployee.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Employee ID already exists: " + employee.getId());
        }
        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        logger.info("Attempting to update employee with ID: {}", id);

        if (!employeeService.getEmployeeById(id).isPresent()) {
            logger.warn("Employee with ID {} not found!", id);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Employee not found with ID: " + id);
        }
        Employee savedEmployee = employeeService.updateEmployee(id, updatedEmployee);
        logger.info("Employee with ID {} updated successfully", id);
        return ResponseEntity.ok(savedEmployee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        logger.info("Deleting employee with ID: {}", id);
        employeeService.deleteEmployee(id);
        logger.info("Employee with ID {} deleted successfully", id);
        return "Employee with ID " + id + " has been deleted.";
    }
}
