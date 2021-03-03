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

    private GrantServiceProvider grantServiceProvider;

    @Autowired
    public EmployeeService(GrantServiceProvider grantServiceProvider) {
        this.grantServiceProvider = grantServiceProvider;
    }
    public List<Employee> getEmployees() {
        List<Employee>  list = employeeRepository.findAll();
        Demo demo = grantServiceProvider.create("T1");
        System.out.println(demo.getNameById("simple "));
        Demo demo2 = grantServiceProvider.create("T2");
        System.out.println(demo2.getNameById("simple "));
        return list;
    }
}