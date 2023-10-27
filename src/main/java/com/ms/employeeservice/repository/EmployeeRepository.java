package com.ms.employeeservice.repository;

import com.ms.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        return employees.stream().filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findByDept(Long deptId) {
        return employees.stream().filter(emp -> emp.deptId().equals(deptId)).collect(Collectors.toList());
    }

    public List<Employee> findAll() {
        return employees;
    }
}
