package com.syborg.service.department.config;

import com.syborg.service.department.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "employee-service", url = "http://localhost:8081")
public interface EmployeeClient {
    @PostMapping("/employee")
    EmployeeDto createAndGetEmployees(@RequestBody EmployeeDto employeeDto);
    @GetMapping("/employee/v2")
    EmployeeDto getEmployee(@RequestParam("employeeId")Long employeeId);
}