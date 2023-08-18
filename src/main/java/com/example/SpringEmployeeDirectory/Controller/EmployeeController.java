package com.example.SpringEmployeeDirectory.Controller;

import com.example.SpringEmployeeDirectory.Models.Department;
import com.example.SpringEmployeeDirectory.Models.Employee;
import com.example.SpringEmployeeDirectory.Service.EmployeeService;
import org.apache.coyote.http2.HpackDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PutMapping(value = "/employee/{id}/addmanager")
    public ResponseEntity<Employee> addManager(@PathVariable Long id, @RequestBody Employee e){
        return new ResponseEntity<>(employeeService.addManager(id, e), HttpStatus.OK);
    }

    @GetMapping(value = "/employeebymanager/{id}")
    public ResponseEntity<List<Employee>> employeeByManager(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.employeeByManager(id), HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/employee/{id}/reportsto")
    public ResponseEntity<List<Employee>> getReportsTo(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getReportsTo(id), HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/nomanager")
    public ResponseEntity<List<Employee>> getNoManager(){
        return new ResponseEntity<>(employeeService.getNoManager(), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/employeebydepartment/{id}")
    public ResponseEntity<List<Employee>> getByDepartment(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getByDepartment(id), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/allreports/{id}")
    public ResponseEntity<List<Employee>> getAllReports(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getAllReports(id), HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "/employees")
    public ResponseEntity<Boolean> deleteEmployees(@RequestBody List<Employee> e){
        employeeService.deleteEmployees(e);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/employee")
    public ResponseEntity<Boolean> deleteEmployees(@RequestBody Employee e){
        employeeService.deleteEmployee(e);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(value = "/employeebydepartment/{id}")
    public ResponseEntity<Boolean> deleteByDepartment(@PathVariable Long id) {
        employeeService.deleteByDepartment(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/allreports/{id}")
    public ResponseEntity<Boolean> deleteAllReports(@PathVariable Long id) {
        employeeService.deleteAllReports(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/employee/{id}/reportsto")
    public ResponseEntity<Boolean> deleteDirectReports(@PathVariable Long id){
        employeeService.deleteDirectReports(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/employee/{id}/{value}")
    public ResponseEntity<String> getAtribute(@PathVariable Long id, @PathVariable String value){
        return new ResponseEntity<>(employeeService.getAttribute(id, value), HttpStatus.ACCEPTED);
    }


    }
