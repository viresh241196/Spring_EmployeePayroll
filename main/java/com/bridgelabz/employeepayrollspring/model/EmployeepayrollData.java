package com.bridgelabz.employeepayrollspring.model;

import com.bridgelabz.employeepayrollspring.DTO.EmployeepayrollDTO;

public class EmployeepayrollData {

    private int empId;
    private String name;
    private long salary;

    public EmployeepayrollData() {
    }

    public EmployeepayrollData(int empId, EmployeepayrollDTO employeeDTO) {
        this.empId = empId;
        this.name = employeeDTO.name;
        this.salary = employeeDTO.salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
