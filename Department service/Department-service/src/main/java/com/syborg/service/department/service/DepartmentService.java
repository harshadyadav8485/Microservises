package com.syborg.service.department.service;

import com.syborg.service.department.config.EmployeeClient;
import com.syborg.service.department.dto.EmployeeDto;
import com.syborg.service.department.exception.EmployeeNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final RestTemplate restTemplate;
    @Autowired
    private EmployeeClient employeeClient;

    public EmployeeDto callEmployeeApi() {
        EmployeeDto request = new EmployeeDto(
                "meera",
                "kumar",
                "meera.kumar2025@example.com",
                "9012345678",
                "DEPT005",
                null
        );


        return employeeClient.createAndGetEmployees(request);
    }
    public List<EmployeeDto> fetchAllEmployees() {
        // Build the URI
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8081/employee/v1") // employee-service URL
                .build()
                .toUri();

        // Create RequestEntity with headers
        RequestEntity<Void> request = RequestEntity
                .get(uri)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        // Call API
        ResponseEntity<EmployeeDto[]> response = restTemplate.exchange(request, EmployeeDto[].class);
        EmployeeDto[] employeeArray = restTemplate.getForObject(
                "http://localhost:8081/employee/v1",
                EmployeeDto[].class
        );

        List<EmployeeDto> employeeLists = Arrays.asList(employeeArray);

        System.out.println(employeeLists);
        // Convert array to list
        List<EmployeeDto> employeeList = Arrays.asList(response.getBody());

        // Print data
        employeeList.forEach(emp -> {
            System.out.println("Name: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Email: " + emp.getEmail());
            System.out.println("Phone: " + emp.getPhone());
            System.out.println("Department Code: " + emp.getDepartmentCode());
            System.out.println("---------------------------");
        });

        return employeeList;
    }

    public EmployeeDto getEmployee(Long employeeId) {
        try {
            return employeeClient.getEmployee(employeeId);
        } catch (FeignException.NotFound ex) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
        } catch (FeignException ex) {
            throw new RuntimeException("Error calling employee-service: " + ex.getMessage());
        }
    }

}
