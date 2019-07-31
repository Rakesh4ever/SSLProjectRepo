package com.kumar.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.kumar.model.Employee;

@Service
public class EmployeeService
{
    Map<String, Employee> employeeMap = new HashMap<String, Employee>(); 
    
    @PostConstruct
    void initialize() {
        Employee emp1 = new Employee("John", 11);
        Employee emp2 = new Employee("James", 22);
        employeeMap.put("John", emp1);
        employeeMap.put("James", emp2);
    }
    
    public Employee getEmployee (String name) throws Exception
    {
        return employeeMap.get(name);
    }
}