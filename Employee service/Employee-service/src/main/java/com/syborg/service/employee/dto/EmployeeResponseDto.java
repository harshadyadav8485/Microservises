package com.syborg.service.employee.dto;
import lombok.Data;

@Data
public class EmployeeResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String departmentCode;
    private String hireDate;
}