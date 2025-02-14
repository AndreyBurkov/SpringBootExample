package com.example.eployees;

import java.time.LocalDate;

public class Employee {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private Integer age;
    private Integer salary;

    public Employee(Long id, String name, String email, LocalDate birthDate, Integer age, Integer salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.age = age;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSalary() {
        return salary;
    }
}
