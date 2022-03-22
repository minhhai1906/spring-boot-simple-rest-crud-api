package com.minhhai.springboot.cruddemo.rest;

import com.minhhai.springboot.cruddemo.entity.Employee;
import com.minhhai.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> list(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee employee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null)
            throw new RuntimeException("Employee not found id - " + id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null)
            throw new RuntimeException("Employee not found id - " + id);
        employeeService.deleteById(id);
        return "Deleted employee id " + id;
    }
}
