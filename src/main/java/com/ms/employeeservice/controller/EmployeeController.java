package com.ms.employeeservice.controller;

import com.ms.employeeservice.model.Employee;
import com.ms.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}", employee);
        return employeeRepository.addEmployee(employee);
    }
    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Employee findAll: {}");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        LOGGER.info("Employee findById: id={}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/dept/{deptId}")
    public List<Employee> findByDept(@PathVariable("deptId") Long id){
        LOGGER.info("Employee findByDeptId: id={}", id);
        return employeeRepository.findByDept(id);
    }
}
