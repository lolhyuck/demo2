package com.example.demo2.service;

import com.example.demo2.entity.Employee;
import com.example.demo2.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        List<Employee>  list = employeeRepository.findAll();
        return list;
    }
}