package com.syborg.service.department.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String departmentCode;
    private Long id;
}