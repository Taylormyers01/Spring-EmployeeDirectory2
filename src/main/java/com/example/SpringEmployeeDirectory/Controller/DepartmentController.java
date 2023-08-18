package com.example.SpringEmployeeDirectory.Controller;

import com.example.SpringEmployeeDirectory.Models.Department;
import com.example.SpringEmployeeDirectory.Models.Employee;
import com.example.SpringEmployeeDirectory.Service.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentServices departmentServices;


    @GetMapping(value = "/department")
    public ResponseEntity<List<Department>> getDepartments(){
        return new ResponseEntity<>(departmentServices.getDepartments(), HttpStatus.OK);
    }
    @PostMapping(value = "/department")
    public ResponseEntity<Department> createDepartment(@RequestBody Department d){
        return new ResponseEntity<>(departmentServices.createDepartment(d), HttpStatus.CREATED);
    }

    @PutMapping(value = "/department/{id}/name")
    public ResponseEntity<Department> updateName(@PathVariable Long id, @RequestBody Department d){
        return new ResponseEntity<>(departmentServices.updateName(id, d), HttpStatus.ACCEPTED);
    }
    @PutMapping(value = "/department/{id}/manager")
    public ResponseEntity<Department> setManager(@PathVariable Long id, @RequestBody Employee e){
        return new ResponseEntity<>(departmentServices.setManager(id, e), HttpStatus.ACCEPTED);
    }
    @PutMapping(value = "/deptswap/{id}/{id2}")
    public ResponseEntity<List<Employee>> updateDepartments(@PathVariable Long id, @PathVariable Long id2){
        return new ResponseEntity<>(departmentServices.updateDepartments(id, id2), HttpStatus.OK);
    }

}
