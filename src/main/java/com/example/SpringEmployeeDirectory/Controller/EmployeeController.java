package com.example.SpringEmployeeDirectory.Controller;

import com.example.SpringEmployeeDirectory.Models.Department;
import com.example.SpringEmployeeDirectory.Models.Employee;
import com.example.SpringEmployeeDirectory.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @GetMapping(value = "/employee")
    public ResponseEntity<List<Employee>> getDepartments(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee e){
        return new ResponseEntity<>(employeeService.createEmployee(e), HttpStatus.CREATED);
    }

    @PutMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee e){
        return new ResponseEntity<>(employeeService.updateEmployee(id, e), HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/employee/{id}/manager/")
    public ResponseEntity<Employee> addManager(@PathVariable Long id, @RequestBody Employee e){
        return new ResponseEntity<>(employeeService.addManager(id, e), HttpStatus.OK);
    }

    @GetMapping(value = "/employeebymanager/{id}")
    public ResponseEntity<List<Employee>> employeeByManager(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.employeeByManager(id), HttpStatus.ACCEPTED);
    }

}
