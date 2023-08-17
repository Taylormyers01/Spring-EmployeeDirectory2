package com.example.SpringEmployeeDirectory.Repository;

import com.example.SpringEmployeeDirectory.Models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
