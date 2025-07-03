package com.syborg.service.employee.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String departmentCode;
    private Long id;
}