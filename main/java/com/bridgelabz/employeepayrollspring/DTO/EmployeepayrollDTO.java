package com.bridgelabz.employeepayrollspring.DTO;

public class EmployeepayrollDTO {
    public String name;
    public long salary;

    public EmployeepayrollDTO(String name, long salary){
        this.name=name;
        this.salary=salary;
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
