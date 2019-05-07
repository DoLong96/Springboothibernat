package com.example.demo2.service.impl;

import com.example.demo2.entity.Employee;
import com.example.demo2.repository.EmployeeRepository;
import com.example.demo2.request.EmployeeRequest;
import com.example.demo2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void add(EmployeeRequest employee) {
        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        employee1.setAge(employee.getAge());
        employeeRepository.save(employee1);
    }

    @Override
    public void remove(Integer id) {

        employeeRepository.deleteById(id);
    }

    @Override
    public void edit(Integer id, EmployeeRequest employeeRequest) {

        try {
            Employee employee = employeeRepository.findById(id).get();
            employee.setName(employeeRequest.getName());
            employee.setAge(employeeRequest.getAge());
            employeeRepository.save(employee);
        }catch (Exception ex){
        }
    }
    @Override
    public Employee getById(Integer id) {
        return employeeRepository.findById(id).get();

    }
}
