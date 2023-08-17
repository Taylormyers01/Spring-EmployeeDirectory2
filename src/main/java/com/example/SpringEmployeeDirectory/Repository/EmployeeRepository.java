package com.example.SpringEmployeeDirectory.Repository;

import com.example.SpringEmployeeDirectory.Models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    public List<Employee>  findAllEmployeesBymanager_id(Long id);
}
