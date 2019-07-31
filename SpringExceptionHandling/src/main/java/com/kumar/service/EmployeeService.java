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
    	Employee emp0 = new Employee("rakesh", 25);
        Employee emp1 = new Employee("vinoba bhave", 1992);
        Employee emp2 = new Employee("mahto", 103);
        employeeMap.put("rakesh", emp0);
        employeeMap.put("hazaribag", emp1);
        employeeMap.put("mahto", emp2);
    }
    
    public Employee getEmployee (String name) throws Exception
    {
        return employeeMap.get(name);
    }
}