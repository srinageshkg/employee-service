package com.ms.employeeservice.model;

public record Employee(Long id, Long deptId, String name, Integer age, String position) {
}
