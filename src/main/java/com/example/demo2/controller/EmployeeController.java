package com.example.demo2.controller;

import com.example.demo2.entity.Employee;
import com.example.demo2.request.EmployeeRequest;
import com.example.demo2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public  String getList(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employee";
    }

    @GetMapping("/add")
    public  String add(){
        return "employeeadd";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute EmployeeRequest employeeRequest) {
        employeeService.add(employeeRequest);
        return "redirect:/employee/list";
    }

    @GetMapping("/remove/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        employeeService.remove(id);
        return "redirect:/employee/list";
    }

    @GetMapping("/update/{id}")
    public String update(@Valid @PathVariable(name = "id") Integer id, Model model) {
         Employee employee = employeeService.getById(id);
        model.addAttribute("employee",employee);
        return "employeeupdate";
    }

    @PostMapping ("/update/{id}")
    public String update(  @PathVariable(name = "id") Integer id,
                           @Valid  @ModelAttribute EmployeeRequest employeeRequest) {
            employeeService.edit(id,employeeRequest);
            return "redirect:/employee/list";
    }

}
