package com.syborg.service.department.controller;

import com.syborg.service.department.dto.EmployeeDto;
import com.syborg.service.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/v1")
    public ResponseEntity<EmployeeDto> getEmployee(@RequestParam("employeeId")Long employeeId){
        EmployeeDto employeeDto=departmentService.getEmployee(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);

    }
}
