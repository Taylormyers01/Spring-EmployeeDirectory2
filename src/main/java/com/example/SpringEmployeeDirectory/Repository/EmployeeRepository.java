package com.example.SpringEmployeeDirectory.Repository;

import com.example.SpringEmployeeDirectory.Models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    public List<Employee>  findAllEmployeesBymanager_id(Long id);
    public List<Employee> findAllEmployeesByManager_IdIsNull();
    @Query(value = "select * from employee e where e.department_dpt_num = ?1", nativeQuery = true)
    public List<Employee> findAllEmployeesByDepartment(Long id);
}
