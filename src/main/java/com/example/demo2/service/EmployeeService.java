package com.example.demo2.service;

import com.example.demo2.entity.Employee;
import com.example.demo2.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    void add(EmployeeRequest employee);
    void remove(Integer id);
    void edit(Integer id, EmployeeRequest employeeRequest);
    Employee getById(Integer id);

}
