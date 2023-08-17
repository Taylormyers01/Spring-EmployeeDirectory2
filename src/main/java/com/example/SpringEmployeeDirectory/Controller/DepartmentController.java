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

    @PutMapping(value = "/department/{id}/manager")
    public ResponseEntity<Department> setManager(@PathVariable Long id, @RequestBody Employee e){
        return new ResponseEntity<>(departmentServices.setManager(id, e), HttpStatus.ACCEPTED);
    }

}
