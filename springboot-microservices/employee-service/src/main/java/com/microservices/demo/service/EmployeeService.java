package com.microservices.demo.service;

import com.microservices.demo.dto.APIResponseDto;
import com.microservices.demo.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
