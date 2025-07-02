package com.syborg.service.employee.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String departmentCode;
}