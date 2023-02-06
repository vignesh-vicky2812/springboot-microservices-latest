package com.microservices.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.demo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    Department findByDepartmentCode(String departmentCode);

}
