package com.microservices.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
