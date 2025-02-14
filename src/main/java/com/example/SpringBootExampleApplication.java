package com.example;

import com.example.eployees.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@SpringBootApplication
public class SpringBootExampleApplication {

    @GetMapping
    public List<Employee> getHelloWorld() {
        return List.of(new Employee(1L, "Vasya", "Vasya@gmail.com", LocalDate.of(2000, 1, 10), 25, 10000),
                new Employee(2L, "Pasha", "Pasha@gmail.com", LocalDate.of(2000, 5, 25), 24, 20000)
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }

}
