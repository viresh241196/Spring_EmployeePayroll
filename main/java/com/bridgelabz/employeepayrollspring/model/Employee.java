package com.bridgelabz.employeepayrollspring.model;
import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int empId;
    public String name;
    public long salary;
    public String gender;
    public String startDate;
    public String note;
    public String profilePic;

    @ElementCollection
    @CollectionTable(name="employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String > departments;

    public Employee(EmployeepayrollDTO employeepayrollDTO) {
        this.name= employeepayrollDTO.name;
        this.salary= employeepayrollDTO.salary;
        this.gender= employeepayrollDTO.gender;
        this.note=employeepayrollDTO.note;
        this.startDate=employeepayrollDTO.startDate;
        this.profilePic=employeepayrollDTO.profilePic;
        this.departments=employeepayrollDTO.departments;
    }

    public Employee(int empId,EmployeepayrollDTO employeepayrollDTO) {
        this.empId = empId;
        this.name= employeepayrollDTO.name;
        this.salary= employeepayrollDTO.salary;
        this.gender= employeepayrollDTO.gender;
        this.note=employeepayrollDTO.note;
        this.startDate=employeepayrollDTO.startDate;
        this.profilePic=employeepayrollDTO.profilePic;
        this.departments=employeepayrollDTO.departments;
    }

    public Employee() {
    }
}

