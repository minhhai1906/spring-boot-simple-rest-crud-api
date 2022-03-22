package com.minhhai.springboot.cruddemo.service;

import com.minhhai.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void deleteById(int id);
}
