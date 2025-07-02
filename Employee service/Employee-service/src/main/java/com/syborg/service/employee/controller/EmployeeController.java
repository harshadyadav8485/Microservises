package com.syborg.service.employee.controller;

import com.syborg.service.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
}
