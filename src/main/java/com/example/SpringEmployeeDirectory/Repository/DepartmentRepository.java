package com.example.SpringEmployeeDirectory.Repository;

import com.example.SpringEmployeeDirectory.Models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
