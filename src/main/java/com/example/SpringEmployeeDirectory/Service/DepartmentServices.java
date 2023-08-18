package com.example.SpringEmployeeDirectory.Service;

import com.example.SpringEmployeeDirectory.Models.Department;
import com.example.SpringEmployeeDirectory.Models.Employee;
import com.example.SpringEmployeeDirectory.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServices {

    @Autowired
    DepartmentRepository departmentRepository;


    public List<Department> getDepartments(){
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    public Department createDepartment(Department d) {
        return departmentRepository.save(d);
    }


    public Department setManager(Long id, Employee e) {
        if(departmentRepository.findById(id).isPresent()){
            Department d = departmentRepository.findById(id).get();
            d.setManager(e);
            return departmentRepository.save(d);
        }
        return null;
    }


    public Department updateName(Long id, Department d) {
        if(departmentRepository.findById(id).isPresent()){
            Department holdDpt = departmentRepository.findById(id).get();
            holdDpt.setDepartmentName(d.getDepartmentName());
            return departmentRepository.save(holdDpt);
        }
        return null;
    }

    public List<Employee> updateDepartments(Long id, Long id2) {
        
        return null;
    }
}
