package com.example.employee_service.service;

import com.example.employee_service.dto.EmployeeResponse;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements  EmployeeService {
     @Autowired
     EmployeeRepo employeeRepo;

    @Override
    public EmployeeResponse getEmployeeDetails(Long id) {
        Employee employee = employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setSalary(employee.getSalary());
        return employeeResponse;
    }
}
