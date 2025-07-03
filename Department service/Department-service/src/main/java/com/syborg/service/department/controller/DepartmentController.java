package com.syborg.service.department.controller;

import com.syborg.service.department.dto.EmployeeDto;
import com.syborg.service.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
   @Autowired
    private  DepartmentService departmentService;
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesFromEmployeeService() {
        List<EmployeeDto> employees = departmentService.fetchAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/create-and-fetch")
    public ResponseEntity<EmployeeDto> createAndFetchEmployees() {
        EmployeeDto employeeList = departmentService.callEmployeeApi();
        return ResponseEntity.ok(employeeList);
    }
}
