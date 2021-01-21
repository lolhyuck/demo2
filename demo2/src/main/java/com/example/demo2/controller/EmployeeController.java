package com.example.demo2.controller;

import com.example.demo2.config.DatasourceProps;
import com.example.demo2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DatasourceProps datasourceProps;

    @GetMapping(value = "employee")
    public Object getEmployees() {
        return employeeService.getEmployees();
    }
}
