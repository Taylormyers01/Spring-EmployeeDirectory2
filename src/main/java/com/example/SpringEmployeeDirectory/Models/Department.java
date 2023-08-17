package com.example.SpringEmployeeDirectory.Models;

import jakarta.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dpt_num")
    private Long id;
    private String departmentName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee Manager;


    public Department(){}

    public Department(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public Employee getManager() {
        return Manager;
    }

    public void setManager(Employee manager) {
        Manager = manager;
    }
//    @OneToOne
//    @JoinColumn(name = "employee_id" , referencedColumnName = "id")
//    private Employee manager;

}
