package com.syborg.service.employee.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data                       // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor          // No-args constructor
@AllArgsConstructor         // All-args constructor
@Builder                    // Builder pattern
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    @Column(name = "department_code", nullable = false)
    private String departmentCode;

    @Column(name = "hire_date")
    private LocalDate hireDate = LocalDate.now();
}
