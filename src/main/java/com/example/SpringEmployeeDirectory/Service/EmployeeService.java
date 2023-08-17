package com.example.SpringEmployeeDirectory.Service;

import com.example.SpringEmployeeDirectory.Models.Employee;
import com.example.SpringEmployeeDirectory.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee createEmployee(Employee e){
        return employeeRepository.save(e);
    }

    public Employee addManager(Long id, Employee e) {
        if(employeeRepository.findById(id).isPresent() && e.getId() !=null){
            Employee subordinate = employeeRepository.findById(id).get();
            subordinate.setManager(e);
            return employeeRepository.save(subordinate);
        }
        return null;
    }

    public Employee updateEmployee(Long id, Employee e) {
        if(employeeRepository.findById(id).isPresent()){
            return employeeRepository.save(e);
        }
        return null;
    }

    public List<Employee> employeeByManager(Long id) {
        if(employeeRepository.findById(id).isPresent()){
            return employeeRepository.findAllEmployeesBymanager_id(id);
        }
        return null;
    }
}
