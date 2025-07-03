package com.syborg.service.employee.service;

import com.syborg.service.employee.dto.EmployeeDto;
import com.syborg.service.employee.model.Employee;
import com.syborg.service.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employee.setDepartmentCode(employeeDto.getDepartmentCode());

        Employee saved = employeeRepository.save(employee);

        EmployeeDto result = new EmployeeDto();
        result.setFirstName(saved.getFirstName());
        result.setLastName(saved.getLastName());
        result.setEmail(saved.getEmail());
        result.setPhone(saved.getPhone());
        result.setDepartmentCode(saved.getDepartmentCode());

        return result;
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setDepartmentCode(employee.getDepartmentCode());
        dto.setPhone(employee.getPhone());
        return dto;
    }
}
