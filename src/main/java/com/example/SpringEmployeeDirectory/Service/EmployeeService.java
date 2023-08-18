package com.example.SpringEmployeeDirectory.Service;

import com.example.SpringEmployeeDirectory.Models.Employee;
import com.example.SpringEmployeeDirectory.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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

    public List<Employee> getReportsTo(Long id) {
        List<Employee> employees = new ArrayList<>();
        if(employeeRepository.findById(id).isPresent()){
            Employee current = employeeRepository.findById(id).get();
            while(current.getManager()!= null){
                employees.add(current);
                current=current.getManager();
            }
            employees.add(current);
            return employees;
        }
        return null;
    }

    public List<Employee> getNoManager() {
        return employeeRepository.findAllEmployeesByManager_IdIsNull();
    }

    public List<Employee> getByDepartment(Long id) {
        return employeeRepository.findAllEmployeesByDepartment(id);
    }

    public List<Employee> getAllReports(Long id) {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        List<Employee> reports = new ArrayList<>();
        for(Employee e: employees ){
            if (e.getManager() != null) {
                Employee hold = e.getManager();
                if(hold.getId() == id){
                    reports.add(e);
                    continue;
                }
                while(hold.getManager() != null){
                    if(hold.getManager().getId() == id){
                        reports.add(e);
                        break;
                    }
                    hold = hold.getManager();
                }
            }
        }
        return reports;
    }

    public void deleteEmployees(List<Employee> e) {
        employeeRepository.deleteAll(e);
    }
    public void deleteEmployee(Employee e) {
        employeeRepository.delete(e);
    }

    public void deleteByDepartment(Long id) {
        employeeRepository.deleteAll(getByDepartment(id));
    }

    public void deleteAllReports(Long id) {
        employeeRepository.deleteAll(getAllReports(id));
    }

    public void deleteDirectReports(Long id) {
        List<Employee> employees = employeeByManager(id);
        for(Employee e: employees){
            List<Employee> employees1 = employeeByManager(e.getId());
            if(!employees1.isEmpty()){
                if(e.getManager()!= null){
                    for(Employee emp: employees1){
                        emp.setManager(e.getManager());
                    }
                }else{
                    for(Employee emp: employees1){
                        emp.setManager(null);
                    }
                }
            }
        }
        employeeRepository.deleteAll(employees);
    }


    public String getAttribute(Long id, String value) {
        if(employeeRepository.findById(id).isPresent()){
            Employee e = employeeRepository.findById(id).get();
            switch(value.toLowerCase()){
                case "manager":
                    return e.getManager().getFirstName() + e.getManager().getLastName();
                case "phonenumber":
                    return e.getPhoneNumber();
                case "lastname":
                    return e.getLastName();
                case "email":
                    return e.getEmail();
                case "title":
                    return e.getTitle();
                case "hiredate":
                    return e.getHireDate().toString();
                case "firstname":
                    return e.getFirstName();
                default:
                    return null;
            }
        }
        return null;
    }

}
