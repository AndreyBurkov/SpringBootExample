package com.example.eployees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            var employeeList = List.of(
                    new Employee(null, "Vasya", "Vasya@gmail.com", LocalDate.of(2000, 1, 10), 10000),
                    new Employee(null, "Pasha", "Pasha@gmail.com", LocalDate.of(2000, 5, 25), 20000)
            );
            employeeRepository.saveAll(employeeList);
        };
    }

}
