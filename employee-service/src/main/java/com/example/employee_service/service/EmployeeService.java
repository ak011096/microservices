package com.example.employee_service.service;

import com.example.employee_service.dto.EmployeeResponse;
import com.example.employee_service.entity.Employee;

public interface EmployeeService {

    EmployeeResponse getEmployeeDetails(Long id);
}
