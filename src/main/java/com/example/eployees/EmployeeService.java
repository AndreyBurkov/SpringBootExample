package com.example.eployees;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
//        return List.of(new Employee(1L, "Vasya", "Vasya@gmail.com", LocalDate.of(2000, 1, 10), 25, 10000),
//                new Employee(2L, "Pasha", "Pasha@gmail.com", LocalDate.of(2000, 5, 25), 24, 20000)  );
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        if (employee.getId() != null) {
            throw new IllegalArgumentException("ID must be empty");
        }

        // unique email
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already taken");
        }

        // salary > 5000
        if (employee.getSalary() <= 5000) {
            throw new IllegalArgumentException("Salary must be more than 5000");
        }

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Employee not found by ID=%s".formatted(id));
        }
        employeeRepository.deleteById(id);
    }

    @Transactional
    public Employee updateEmployee(Long id, String email, Integer salary) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Employee not found by ID=%s".formatted(id)));

        // unique email
        if (email != null && !email.isEmpty() && !email.equals(employee.getEmail())) {
            Optional<Employee> employeeOpt = employeeRepository.findByEmail(email);
            if (employeeOpt.isPresent()) {
                throw new IllegalArgumentException("Email already taken");
            }
            employee.setEmail(email);
        }

        // salary > 5000
        if (salary != null) {
            if (salary <= 5000) {
                throw new IllegalArgumentException("Salary must be more than 5000");
            }
            employee.setSalary(salary);
        }

        return employee;
    }
}
